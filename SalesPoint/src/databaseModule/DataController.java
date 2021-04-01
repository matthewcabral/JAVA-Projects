/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseModule;

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import settingsModule.DbSettingsController;
import userModule.userController;

/**
 *
 * @author Matheus Cabral Rosa
 */
public abstract class DataController extends Controller{
    EncryptDecryptWordClass encryptDecrypt;
    DbSettingsController genSettings;
    
    // Empty Constructor
    public DataController() throws InterruptedException {
        encryptDecrypt = new EncryptDecryptWordClass();
        this.readParameters();
    }
    
    @Override
    public String openConnection(String message){
        try {
            Class.forName(super.getDbDriver());
            System.out.println("Oracle JDBC Driver Registered! " + message + "...");
        } catch (ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, super.exc.getDbODBCEx() + "\n" + super.exc.getMsgReturn() + e, "Erro", JOptionPane.ERROR_MESSAGE);
        }
        try {
            super.conn = DriverManager.getConnection(super.getDbURL(), super.getDbUser(), super.getDbPassword());
            System.out.println("Connected Successfuly! " + message + "...");
            return "true";
        } catch(SQLException e) {
            if(!"Realizando Login".equals(message)){
                if("java.sql.SQLRecoverableException: IO Error: The Network Adapter could not establish the connection\n".equals(e)){
                    JOptionPane.showMessageDialog(null, "Erro ao tentar realizar conexão com o Banco de dados. Verifique se o listener está ativo.","Erro",JOptionPane.ERROR_MESSAGE);
                } else if("ORA-12505: TNS: listener does not currently know of SID given in connect descriptor tips\n".equals(e)){
                    JOptionPane.showMessageDialog(null, "O Listener não identificou o SID utilizado no descritor de conexão.","Erro",JOptionPane.ERROR_MESSAGE);
                } else if("java.sql.SQLRecoverableException: Erro de ES: The Network Adapter could not establish the connection\n".equals(e)){
                    JOptionPane.showMessageDialog(null, "Erro ao tentar realizar conexão com o Banco de dados. Verifique se o listener está ativo.","Erro",JOptionPane.ERROR_MESSAGE);
                } else if("ORA-12505, TNS:listener does not currently know of SID given in connect descriptor\n".equals(e)){
                    JOptionPane.showMessageDialog(null, "O Listener não identificou o SID utilizado no descritor de conexão.","Erro",JOptionPane.ERROR_MESSAGE);
                } else if("java.sql.SQLException: ORA-01017: invalid username/password; logon denied\n".equals(e)){
                    JOptionPane.showMessageDialog(null, "Nome de usuário/senha incorreto. Tente novamente.","Erro",JOptionPane.ERROR_MESSAGE);
                } else if("java.sql.SQLRecoverableException: Erro de ES: Unknown host specified ".equals(e)){
                    JOptionPane.showMessageDialog(null, "Erro ao tentar realizar conexão com o Banco de dados. Verifique o Host.","Erro",JOptionPane.ERROR_MESSAGE);                
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco de dados!\n" + e,"Erro",JOptionPane.ERROR_MESSAGE);
                }
            }            
            return e.toString();
        }
    }
    
    @Override
    public String closeConnection(String message){
        try {
            Class.forName(super.getDbDriver());
            System.out.println("Oracle JDBC Driver Registered! " + message + "...");
        } catch (ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, super.exc.getDbODBCEx()+ "\n" + super.exc.getMsgReturn() + e,"Erro",JOptionPane.ERROR_MESSAGE);
        }
        try {
            conn.close();
            System.out.println(message + "... Disconnected Successfuly!");
            return "true";
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, super.exc.getDbDisconnectEx() + "\n" + super.exc.getMsgReturn() + e,"Erro",JOptionPane.ERROR_MESSAGE);
            return "false";
        }
    }    

    public boolean readParameters() {
        System.out.println("Carregando Parametros do Banco de Dados");
        File file = new File(super.getConfFile());
        if(file.exists()) {
            try {
                int i = 0;
                BufferedReader br = new BufferedReader(new FileReader(super.getConfFile()));
                String line;
                
                while((line = br.readLine()) != null){
                    if(i > 0){
                        StringTokenizer st = new StringTokenizer(line, super.getSplitBy());
                        setDbDriverName(st.nextToken());
                        setDbDriver(st.nextToken());
                        setDbURL(st.nextToken());
                        setDbLocal(st.nextToken());
                        setDbPort(st.nextToken());
                        setDbName(st.nextToken());
                        setDbOwner(st.nextToken());
                    }
                    i++;
                }

                System.out.println("Parametros OK");
                return true;
                
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "O arquivo não foi encontrado, verifique se o mesmo existe ou está correto.", "Erro", JOptionPane.ERROR_MESSAGE);
                System.out.println("O arquivo não foi encontrado, verifique se o mesmo existe ou está correto.");
                
                wishConfDbLScreen();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Erro ao Carregar parâmetros do Banco de Dados", "Erro", JOptionPane.ERROR_MESSAGE);
                System.out.println("Erro ao Carregar parâmetros do Banco de Dados");
                
                wishConfDbLScreen();
            }
        } else {
            //JOptionPane.showMessageDialog(null, "Erro ao Carregar parâmetros do Banco de Dados", "Erro", JOptionPane.ERROR_MESSAGE);
            System.out.println("Erro ao Carregar parâmetros do Banco de Dados");
            
            wishConfDbLScreen();
        }
        return false;
    }
    
    public void wishConfDbLScreen() {
        String[] options = {"Sim", "Não"};
        int x = JOptionPane.showOptionDialog(null, "Os arquivo de configuração do banco de dados não está correto, deseja realizar a configuração?", "Erro", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]);
        if(x == 0){
            try {
                genSettings = new DbSettingsController(true);
            } catch (InterruptedException ex) {
                Logger.getLogger(userController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @Override
    public String insertRecord(String table, String columns, String values) {
        String sqlHeader = "INSERT INTO " + super.getDbOwner() + "." + table;
        String sqlColumn = " (" + columns + ") ";
        String sqlValue = "VALUES (" + values + ")";
        
        try{
            if("true".equals(openConnection("Inserindo registros..."))){
                statement = conn.createStatement();
                statement.execute(sqlHeader + sqlColumn + sqlValue);
                
                closeConnection("Dados inseridos com sucesso...");
                JOptionPane.showMessageDialog(null, "Registro inserido com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao inserir registro no banco de dados!");
            }
            return "true";
        } catch (HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao inserir registros no banco de dados!\nErro: " + e);
            return "false";
        } finally{
            sqlHeader = null;
            sqlColumn = null;
            sqlValue = null;
        }
    }
    
    @Override
    public String updateRecord(String table, String columnsValues, String condition){
        String sqlHeader = "UPDATE " + super.getDbOwner() + "." + table + "\n";
        String sqlColumnsValues = "SET " + columnsValues + "\n";
        String sqlCondition = "WHERE " + condition;
        int count = 0;
        
        try{
            if("true".equals(openConnection("Inserindo registros..."))){
                statement = conn.createStatement();
                count = statement.executeUpdate(sqlHeader + sqlColumnsValues + sqlCondition);
                
                closeConnection("Dados atualizados com sucesso...");
                JOptionPane.showMessageDialog(null, "Registros atualizados com sucesso!\nTotal de registros alterados: " + count);
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar registro no banco de dados!");
            }
            return "true";
        } catch (HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao atualizar registros no banco de dados!\nErro: " + e);
            return "false";
        } finally{
            sqlHeader = null;
            sqlColumnsValues = null;
            sqlCondition = null;
            count = 0;
        }
    }

    @Override
    public String deleteRecord(String table, String condition) {
        String sqlHeader = "DELETE FROM " + super.getDbOwner() + "." + table + "\n";
        String sqlCondition = "WHERE " + condition;
        int count = 0;
        
        try{
            if("true".equals(openConnection("Inserindo registros..."))){
                statement = conn.createStatement();
                count = statement.executeUpdate(sqlHeader + sqlCondition);
                
                closeConnection("Dados removidos com sucesso...");
                JOptionPane.showMessageDialog(null, "Registros removidos com sucesso!\nTotal de registros removidos: " + count);
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao remover registros no banco de dados!");
            }
            return "true";
        } catch (HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao remover registros no banco de dados!\nErro: " + e);
            return "false";
        } finally{
            sqlHeader = null;
            sqlCondition = null;
            count = 0;
        }
    }

    @Override
    public ArrayList<UserClass> queryUserRecord(String query){
        ArrayList<UserClass> result = new ArrayList<>();
        
        try{
            if("true".equals(openConnection("Buscando Registros de usuários..."))){
                super.statement = super.conn.createStatement();
                ResultSet rs = super.statement.executeQuery(query);
                
                while(rs.next()){
                    UserClass list = new UserClass();
                    
                    list.setRow_id(rs.getString("ROW_ID"));
                    if(!"".equals(rs.getString("CREATED")) && rs.getString("CREATED") != null) {
                        list.setCreated(rs.getString("CREATED").substring(8, 10) + "/" + rs.getString("CREATED").substring(5, 7) + "/" + rs.getString("CREATED").substring(0, 4));
                    }
                    list.setCreated_by(rs.getString("CREATED_BY"));
                    if(!"".equals(rs.getString("LAST_UPD")) && rs.getString("LAST_UPD") != null) {
                        list.setUpdated(rs.getString("LAST_UPD").substring(8, 10) + "/" + rs.getString("LAST_UPD").substring(5, 7) + "/" + rs.getString("LAST_UPD").substring(0, 4));
                    }
                    list.setUpdated_by(rs.getString("LAST_UPD_BY"));
                    list.setModification_num(rs.getString("MODIFICATION_NUM"));
                    list.setPar_row_id(rs.getString("PAR_ROW_ID"));
                    if(!"".equals(rs.getString("DB_LAST_UPD")) && rs.getString("DB_LAST_UPD") != null) {
                        list.setDb_last_upd(rs.getString("DB_LAST_UPD").substring(8, 10) + "/" + rs.getString("DB_LAST_UPD").substring(5, 7) + "/" + rs.getString("DB_LAST_UPD").substring(0, 4));
                    }
                    list.setLOGIN(rs.getString("LOGIN"));
                    list.setPASSWORD(encryptDecrypt.decryptWord(rs.getString("PASSWORD")));
                    list.setUSER_FLG(rs.getString("USER_FLG"));
                    if(!"".equals(rs.getString("LAST_LOGIN_TS")) && rs.getString("LAST_LOGIN_TS") != null) {
                        list.setLAST_LOGIN_TS(rs.getString("LAST_LOGIN_TS").substring(8, 10) + "/" + rs.getString("LAST_LOGIN_TS").substring(5, 7) + "/" + rs.getString("LAST_LOGIN_TS").substring(0, 4));
                    }
                    list.setDOC_TYPE(rs.getString("DOC_TYPE"));
                    list.setDOC_NUM(rs.getString("DOC_NUM"));
                    list.setFST_NAME(rs.getString("FST_NAME"));
                    list.setLAST_NAME(rs.getString("LAST_NAME"));
                    list.setFULL_NAME(rs.getString("FULL_NAME"));
                    list.setNICK_NAME(rs.getString("NICK_NAME"));
                    list.setAGE(rs.getString("AGE"));
                    if(!"".equals(rs.getString("BIRTH_DT")) && rs.getString("BIRTH_DT") != null) {
                        list.setBIRTH_DT(rs.getString("BIRTH_DT").substring(8, 10) + "/" + rs.getString("BIRTH_DT").substring(5, 7) + "/" + rs.getString("BIRTH_DT").substring(0, 4));
                    }
                    list.setPLACE_OF_BIRTH(rs.getString("PLACE_OF_BIRTH"));
                    list.setSEX_MF(rs.getString("SEX_MF"));
                    list.setMARITAL_STAT_CD(rs.getString("MARITAL_STAT_CD"));
                    list.setNAME_CONJUGE(rs.getString("NAME_CONJUGE"));
                    list.setMOTHER_FULL_NAME(rs.getString("MOTHER_FULL_NAME"));
                    list.setFATHER_FULL_NAME(rs.getString("FATHER_FULL_NAME"));
                    list.setIDENTITY_DOC_TYPE(rs.getString("IDENTITY_DOC_TYPE"));
                    list.setREGISTER_NUM(rs.getString("REGISTER_NUM"));
                    list.setREGISTER_SERIE(rs.getString("REGISTER_SERIE"));
                    list.setORGAO_EMISSOR(rs.getString("ORGAO_EMISSOR"));
                    list.setUF_EMISSAO(rs.getString("UF_EMISSAO"));
                    if(!"".equals(rs.getString("EMISSION_DT")) && rs.getString("EMISSION_DT") != null) {
                        list.setEMISSION_DT(rs.getString("EMISSION_DT").substring(8, 10) + "/" + rs.getString("EMISSION_DT").substring(5, 7) + "/" + rs.getString("EMISSION_DT").substring(0, 4));
                    }
                    if(!"".equals(rs.getString("VALIDATION_DT")) && rs.getString("VALIDATION_DT") != null) {
                        list.setVALIDATION_DT(rs.getString("VALIDATION_DT").substring(8, 10) + "/" + rs.getString("VALIDATION_DT").substring(5, 7) + "/" + rs.getString("VALIDATION_DT").substring(0, 4));
                    }
                    list.setNATURALNESS(rs.getString("NATURALNESS"));
                    list.setNATIONALITY(rs.getString("NATIONALITY"));
                    list.setCHALLENGE_QUESTION_1(encryptDecrypt.decryptWord(rs.getString("CHALLENGE_QUESTION_1")));
                    list.setCHALLENGE_ANSWER_1(encryptDecrypt.decryptWord(rs.getString("CHALLENGE_ANSWER_1")));
                    list.setCHALLENGE_QUESTION_2(encryptDecrypt.decryptWord(rs.getString("CHALLENGE_QUESTION_2")));
                    list.setCHALLENGE_ANSWER_2(encryptDecrypt.decryptWord(rs.getString("CHALLENGE_ANSWER_2")));
                    list.setCHALLENGE_QUESTION_3(encryptDecrypt.decryptWord(rs.getString("CHALLENGE_QUESTION_3")));
                    list.setCHALLENGE_ANSWER_3(encryptDecrypt.decryptWord(rs.getString("CHALLENGE_ANSWER_3")));
                    list.setPR_ADDR_ID(rs.getString("PR_ADDR_ID"));
                    list.setPR_CON_ID(rs.getString("PR_CON_ID"));
                    list.setPR_PHONE_ID(rs.getString("PR_PHONE_ID"));
                    list.setSTATUS_CD(rs.getString("STATUS_CD"));
                    
                    result.add(list);
                }
                
                rs.close();
                closeConnection("Dados de Usuários retornados com sucesso...");
            }
        } catch (HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao buscar registros de usuários no banco de dados!\nErro: " + e);
        }
        
        return result;
    }
    
    @Override
    public ArrayList<PositionClass> queryPositionRecord(String query){
        ArrayList<PositionClass> result = new ArrayList<>();
        
        try{
            if("true".equals(openConnection("Buscando Registros de usuários..."))){
                super.statement = super.conn.createStatement();
                ResultSet rs = super.statement.executeQuery(query);
                
                while(rs.next()){
                    PositionClass list = new PositionClass();
                    
                    list.setRow_id(rs.getString("ROW_ID"));
                    if(!"".equals(rs.getString("CREATED")) && rs.getString("CREATED") != null) {
                        list.setCreated(rs.getString("CREATED").substring(8, 10) + "/" + rs.getString("CREATED").substring(5, 7) + "/" + rs.getString("CREATED").substring(0, 4));
                    }
                    list.setCreated_by(rs.getString("CREATED_BY"));
                    if(!"".equals(rs.getString("LAST_UPD")) && rs.getString("LAST_UPD") != null) {
                        list.setUpdated(rs.getString("LAST_UPD").substring(8, 10) + "/" + rs.getString("LAST_UPD").substring(5, 7) + "/" + rs.getString("LAST_UPD").substring(0, 4));
                    }
                    list.setUpdated_by(rs.getString("LAST_UPD_BY"));
                    list.setModification_num(rs.getString("MODIFICATION_NUM"));
                    list.setPar_row_id(rs.getString("PAR_ROW_ID"));
                    if(!"".equals(rs.getString("DB_LAST_UPD")) && rs.getString("DB_LAST_UPD") != null) {
                        list.setDb_last_upd(rs.getString("DB_LAST_UPD").substring(8, 10) + "/" + rs.getString("DB_LAST_UPD").substring(5, 7) + "/" + rs.getString("DB_LAST_UPD").substring(0, 4));
                    }
                    list.setNAME(rs.getString("NAME"));
                    list.setPOSTN_TYPE_CD(rs.getString("POSTN_TYPE_CD"));
                    list.setDESC_TEXT(rs.getString("DESC_TEXT"));
                    list.setPAR_POSTN_ID(rs.getString("PAR_POSTN_ID"));
                    
                    result.add(list);
                }
                
                rs.close();
                closeConnection("Dados de Usuários retornados com sucesso...");
            }
        } catch (HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao buscar registros de usuários no banco de dados!\nErro: " + e);
        }
        
        return result;
    }
    
    @Override
    public ArrayList<UserPermitionClass> queryUserPermitionRecord(String query){
        ArrayList<UserPermitionClass> result = new ArrayList<>();
        
        try{
            if("true".equals(openConnection("Buscando Registros de usuários..."))){
                super.statement = super.conn.createStatement();
                ResultSet rs = super.statement.executeQuery(query);
                
                while(rs.next()){
                    UserPermitionClass list = new UserPermitionClass();
                    
                    list.setRow_id(rs.getString("ROW_ID"));
                    if(!"".equals(rs.getString("CREATED")) && rs.getString("CREATED") != null) {
                        list.setCreated(rs.getString("CREATED").substring(8, 10) + "/" + rs.getString("CREATED").substring(5, 7) + "/" + rs.getString("CREATED").substring(0, 4));
                    }
                    list.setCreated_by(rs.getString("CREATED_BY"));
                    if(!"".equals(rs.getString("LAST_UPD")) && rs.getString("LAST_UPD") != null) {
                        list.setUpdated(rs.getString("LAST_UPD").substring(8, 10) + "/" + rs.getString("LAST_UPD").substring(5, 7) + "/" + rs.getString("LAST_UPD").substring(0, 4));
                    }
                    list.setUpdated_by(rs.getString("LAST_UPD_BY"));
                    list.setModification_num(rs.getString("MODIFICATION_NUM"));
                    list.setPar_row_id(rs.getString("PAR_ROW_ID"));
                    if(!"".equals(rs.getString("DB_LAST_UPD")) && rs.getString("DB_LAST_UPD") != null) {
                        list.setDb_last_upd(rs.getString("DB_LAST_UPD").substring(8, 10) + "/" + rs.getString("DB_LAST_UPD").substring(5, 7) + "/" + rs.getString("DB_LAST_UPD").substring(0, 4));
                    }
                    list.setX_PAY_BOX_MANAGER(rs.getString("X_PAY_BOX_MANAGER"));
                    list.setX_NEW_SALE(rs.getString("X_NEW_SALE"));
                    list.setX_DELIVERY(rs.getString("X_DELIVERY"));
                    list.setX_VIEW_CLIENT(rs.getString("X_VIEW_CLIENT"));
                    list.setX_ADD_CLIENT(rs.getString("X_ADD_CLIENT"));
                    list.setX_UPD_CLIENT(rs.getString("X_UPD_CLIENT"));
                    list.setX_DEL_CLIENT(rs.getString("X_DEL_CLIENT"));
                    list.setX_CASH_REPORT(rs.getString("X_CASH_REPORT"));
                    list.setX_SALES_REPORT(rs.getString("X_SALES_REPORT"));
                    list.setX_VIEW_PROD(rs.getString("X_VIEW_PROD"));
                    list.setX_ADD_PROD(rs.getString("X_ADD_PROD"));
                    list.setX_UPD_PROD(rs.getString("X_UPD_PROD"));
                    list.setX_DEL_PROD(rs.getString("X_DEL_PROD"));
                    list.setX_VIEW_COMP(rs.getString("X_VIEW_COMP"));
                    list.setX_ADD_COMP(rs.getString("X_ADD_COMP"));
                    list.setX_UPD_COMP(rs.getString("X_UPD_COMP"));
                    list.setX_DEL_COMP(rs.getString("X_DEL_COMP"));
                    list.setX_VIEW_CAT(rs.getString("X_VIEW_CAT"));
                    list.setX_ADD_CAT(rs.getString("X_ADD_CAT"));
                    list.setX_UPD_CAT(rs.getString("X_UPD_CAT"));
                    list.setX_DEL_CAT(rs.getString("X_DEL_CAT"));
                    list.setX_VIEW_SIZE(rs.getString("X_VIEW_SIZE"));
                    list.setX_ADD_SIZE(rs.getString("X_ADD_SIZE"));
                    list.setX_UPD_SIZE(rs.getString("X_UPD_SIZE"));
                    list.setX_DEL_SIZE(rs.getString("X_DEL_SIZE"));
                    list.setX_VIEW_USER(rs.getString("X_VIEW_USER"));
                    list.setX_ADD_USER(rs.getString("X_ADD_USER"));
                    list.setX_UPD_USER(rs.getString("X_UPD_USER"));
                    list.setX_DEL_USER(rs.getString("X_DEL_USER"));
                    list.setX_COMMENTS(rs.getString("X_COMMENTS"));                    
                    
                    result.add(list);
                }
                
                rs.close();
                closeConnection("Dados de Usuários retornados com sucesso...");
            }
        } catch (HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao buscar registros de usuários no banco de dados!\nErro: " + e);
        }
        
        return result;
    }
    
    @Override
    public ArrayList<AddressClass> queryAddressRecord(String query){
        ArrayList<AddressClass> result = new ArrayList<>();
        
        try{
            if("true".equals(openConnection("Buscando Registros de usuários..."))){
                super.statement = super.conn.createStatement();
                ResultSet rs = super.statement.executeQuery(query);
                
                while(rs.next()){
                    AddressClass list = new AddressClass();
                    
                    list.setRow_id(rs.getString("ROW_ID"));
                    if(!"".equals(rs.getString("CREATED")) && rs.getString("CREATED") != null) {
                        list.setCreated(rs.getString("CREATED").substring(8, 10) + "/" + rs.getString("CREATED").substring(5, 7) + "/" + rs.getString("CREATED").substring(0, 4));
                    }
                    list.setCreated_by(rs.getString("CREATED_BY"));
                    if(!"".equals(rs.getString("LAST_UPD")) && rs.getString("LAST_UPD") != null) {
                        list.setUpdated(rs.getString("LAST_UPD").substring(8, 10) + "/" + rs.getString("LAST_UPD").substring(5, 7) + "/" + rs.getString("LAST_UPD").substring(0, 4));
                    }
                    list.setUpdated_by(rs.getString("LAST_UPD_BY"));
                    list.setModification_num(rs.getString("MODIFICATION_NUM"));
                    list.setPar_row_id(rs.getString("PAR_ROW_ID"));
                    if(!"".equals(rs.getString("DB_LAST_UPD")) && rs.getString("DB_LAST_UPD") != null) {
                        list.setDb_last_upd(rs.getString("DB_LAST_UPD").substring(8, 10) + "/" + rs.getString("DB_LAST_UPD").substring(5, 7) + "/" + rs.getString("DB_LAST_UPD").substring(0, 4));
                    }
                    list.setPAR_CON_ID(rs.getString("PAR_CON_ID"));
                    list.setPAR_ADDR_ID(rs.getString("PAR_ADDR_ID"));
                    list.setACTIVE_FLG(rs.getString("ACTIVE_FLG"));
                    list.setPR_ADDR_FLG(rs.getString("PR_ADDR_FLG"));
                    list.setZIPCODE(rs.getString("ZIPCODE"));
                    list.setADDR_TYPE_CD(rs.getString("ADDR_TYPE_CD"));
                    list.setADDR(rs.getString("ADDR"));
                    list.setADDR_NUM(rs.getString("ADDR_NUM"));
                    list.setNEIGHBORHOOD(rs.getString("NEIGHBORHOOD"));
                    list.setX_ZONA(rs.getString("X_ZONA"));
                    list.setCITY(rs.getString("CITY"));
                    list.setSTATE(rs.getString("STATE"));
                    list.setNATIONALITY(rs.getString("NATIONALITY"));
                    list.setCOUNTRY(rs.getString("COUNTRY"));
                    list.setCOUNTRY_CODE(rs.getString("COUNTRY_CODE"));
                    list.setCOUNTRY_INITIAL(rs.getString("COUNTRY_INITIAL"));
                    list.setPROPERTY_TYPE_CD(rs.getString("PROPERTY_TYPE_CD"));
                    list.setADDR_LINE_2(rs.getString("ADDR_LINE_2"));
                    list.setX_ANDAR(rs.getString("X_ANDAR"));
                    list.setX_NUM_AP(rs.getString("X_NUM_AP"));
                    list.setX_COD_BLOCO(rs.getString("X_COD_BLOCO"));
                    list.setADDR_NAME(rs.getString("ADDR_NAME"));
                    list.setCOMMENTS(rs.getString("COMMENTS"));
                    
                    result.add(list);
                }
                
                rs.close();
                closeConnection("Dados de Usuários retornados com sucesso...");
            }
        } catch (HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao buscar registros de usuários no banco de dados!\nErro: " + e);
        }
        
        return result;
    }
    
    @Override
    public ArrayList<ContactClass> queryContactRecord(String query){
        ArrayList<ContactClass> result = new ArrayList<>();
        
        try{
            if("true".equals(openConnection("Buscando Registros de usuários..."))){
                super.statement = super.conn.createStatement();
                ResultSet rs = super.statement.executeQuery(query);
                
                while(rs.next()){
                    ContactClass list = new ContactClass();
                    
                    list.setRow_id(rs.getString("ROW_ID"));
                    if(!"".equals(rs.getString("CREATED")) && rs.getString("CREATED") != null) {
                        list.setCreated(rs.getString("CREATED").substring(8, 10) + "/" + rs.getString("CREATED").substring(5, 7) + "/" + rs.getString("CREATED").substring(0, 4));
                    }
                    list.setCreated_by(rs.getString("CREATED_BY"));
                    if(!"".equals(rs.getString("LAST_UPD")) && rs.getString("LAST_UPD") != null) {
                        list.setUpdated(rs.getString("LAST_UPD").substring(8, 10) + "/" + rs.getString("LAST_UPD").substring(5, 7) + "/" + rs.getString("LAST_UPD").substring(0, 4));
                    }
                    list.setUpdated_by(rs.getString("LAST_UPD_BY"));
                    list.setModification_num(rs.getString("MODIFICATION_NUM"));
                    list.setPar_row_id(rs.getString("PAR_ROW_ID"));
                    if(!"".equals(rs.getString("DB_LAST_UPD")) && rs.getString("DB_LAST_UPD") != null) {
                        list.setDb_last_upd(rs.getString("DB_LAST_UPD").substring(8, 10) + "/" + rs.getString("DB_LAST_UPD").substring(5, 7) + "/" + rs.getString("DB_LAST_UPD").substring(0, 4));
                    }
                    list.setACTIVE_FLG(rs.getString("ACTIVE_FLG"));                    
                    list.setPAR_USR_ID(rs.getString("PAR_USR_ID"));
                    list.setPR_CON_FLG(rs.getString("PR_CON_FLG"));
                    list.setEMP_FLG(rs.getString("EMP_FLG"));                    
                    list.setDOC_TYPE(rs.getString("DOC_TYPE"));
                    list.setDOC_NUM(rs.getString("DOC_NUM"));
                    list.setALIAS_NAME(rs.getString("ALIAS_NAME"));
                    list.setNOME_FANTASIA(rs.getString("NOME_FANTASIA"));
                    list.setFST_NAME(rs.getString("FST_NAME"));
                    list.setLAST_NAME(rs.getString("LAST_NAME"));
                    list.setFULL_NAME(rs.getString("FULL_NAME"));
                    list.setNICK_NAME(rs.getString("NICK_NAME"));
                    list.setAGE(rs.getString("AGE"));
                    list.setBIRTH_DT(rs.getString("BIRTH_DT"));
                    list.setPLACE_OF_BIRTH(rs.getString("PLACE_OF_BIRTH"));
                    list.setSEX_MF(rs.getString("SEX_MF"));
                    list.setMARITAL_STAT_CD(rs.getString("MARITAL_STAT_CD"));
                    list.setNAME_CONJUGE(rs.getString("NAME_CONJUGE"));
                    list.setMOTHER_FULL_NAME(rs.getString("MOTHER_FULL_NAME"));
                    list.setFATHER_FULL_NAME(rs.getString("FATHER_FULL_NAME"));
                    list.setPOTENTIAL_FLG(rs.getString("POTENTIAL_FLG"));
                    list.setSUPPRESS_EMAIL_FLG(rs.getString("SUPPRESS_EMAIL_FLG"));
                    list.setENTERPRISE_FLAG(rs.getString("ENTERPRISE_FLAG"));
                    list.setRELATIONSHIP_TYPE(rs.getString("RELATIONSHIP_TYPE"));
                    list.setMEMBER_FLG(rs.getString("MEMBER_FLG"));
                    list.setSEND_NEWS_FLG(rs.getString("SEND_NEWS_FLG"));
                    list.setSEND_PROMOTES_FLG(rs.getString("SEND_PROMOTES_FLG"));
                    list.setSUPPRESS_CALL_FLG(rs.getString("SUPPRESS_CALL_FLG"));
                    list.setCONSUMER_FLG(rs.getString("CONSUMER_FLG"));
                    list.setMAIN_PH_NUM(rs.getString("MAIN_PH_NUM"));
                    list.setALT_PH_NUM(rs.getString("ALT_PH_NUM"));
                    list.setWORK_PH_NUM(rs.getString("WORK_PH_NUM"));
                    list.setASST_PH_NUM(rs.getString("ASST_PH_NUM"));
                    list.setFAX_PH_NUM(rs.getString("FAX_PH_NUM"));
                    list.setCALL_FREQUENCY(rs.getString("CALL_FREQUENCY"));
                    list.setCREATOR_LOGIN(rs.getString("CREATOR_LOGIN"));
                    list.setEMAIL_TYPE(rs.getString("EMAIL_TYPE"));
                    list.setEMAIL_ADDR(rs.getString("EMAIL_ADDR"));
                    list.setSITE_ADDR(rs.getString("SITE_ADDR"));
                    list.setWHATSAPP_FLG(rs.getString("WHATSAPP_FLG"));
                    list.setLOGIN(rs.getString("LOGIN"));
                    list.setOCCUPATION(rs.getString("OCCUPATION"));
                    list.setPASSWORD(rs.getString("PASSWORD"));
                    list.setPR_CON_ADDR_ID(rs.getString("PR_CON_ADDR_ID"));
                    list.setPR_EMAIL_ADDR_ID(rs.getString("PR_EMAIL_ADDR_ID"));
                    list.setPR_ADDR_ID(rs.getString("PR_ADDR_ID"));
                    list.setSTATUS_CD(rs.getString("STATUS_CD"));
                    
                    result.add(list);
                }
                
                rs.close();
                closeConnection("Dados de Usuários retornados com sucesso...");
            }
        } catch (HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao buscar registros de usuários no banco de dados!\nErro: " + e);
        }
        
        return result;
    }
    
    @Override
    public ArrayList<ContactXClass> queryContactXRecord(String query){
        ArrayList<ContactXClass> result = new ArrayList<>();
        
        try{
            if("true".equals(openConnection("Buscando Registros de usuários..."))){
                super.statement = super.conn.createStatement();
                ResultSet rs = super.statement.executeQuery(query);
                
                while(rs.next()){
                    ContactXClass list = new ContactXClass();
                    
                    list.setRow_id(rs.getString("ROW_ID"));
                    if(!"".equals(rs.getString("CREATED")) && rs.getString("CREATED") != null) {
                        list.setCreated(rs.getString("CREATED").substring(8, 10) + "/" + rs.getString("CREATED").substring(5, 7) + "/" + rs.getString("CREATED").substring(0, 4));
                    }
                    list.setCreated_by(rs.getString("CREATED_BY"));
                    if(!"".equals(rs.getString("LAST_UPD")) && rs.getString("LAST_UPD") != null) {
                        list.setUpdated(rs.getString("LAST_UPD").substring(8, 10) + "/" + rs.getString("LAST_UPD").substring(5, 7) + "/" + rs.getString("LAST_UPD").substring(0, 4));
                    }
                    list.setUpdated_by(rs.getString("LAST_UPD_BY"));
                    list.setModification_num(rs.getString("MODIFICATION_NUM"));
                    list.setPar_row_id(rs.getString("PAR_ROW_ID"));
                    if(!"".equals(rs.getString("DB_LAST_UPD")) && rs.getString("DB_LAST_UPD") != null) {
                        list.setDb_last_upd(rs.getString("DB_LAST_UPD").substring(8, 10) + "/" + rs.getString("DB_LAST_UPD").substring(5, 7) + "/" + rs.getString("DB_LAST_UPD").substring(0, 4));
                    }
                    list.setACTIVE_FLG(rs.getString("ACTIVE_FLG"));                    
                    list.setPAR_USR_ID(rs.getString("PAR_USR_ID"));
                    list.setPAR_ACCNT_ID(rs.getString("PAR_ACCNT_ID"));
                    list.setSOCIAL_M_NAME(rs.getString("SOCIAL_M_NAME"));                    
                    list.setSOCIAL_M_VALUE(rs.getString("SOCIAL_M_VALUE"));
                    list.setSTATUS_CD(rs.getString("STATUS_CD"));
                    
                    result.add(list);
                }
                
                rs.close();
                closeConnection("Dados de Usuários retornados com sucesso...");
            }
        } catch (HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao buscar registros de usuários no banco de dados!\nErro: " + e);
        }
        
        return result;
    }
    
    @Override
    public String getNextRowId(){
        String row_id = null;
        
        try{
            if("true".equals(openConnection("Buscando proximo ROW_ID"))){
                statement = conn.createStatement();
                
                ResultSet rs = statement.executeQuery("SELECT P_NEXT_ID FROM " + super.getDbOwner() + "." + super.getTblSSAId() + " WHERE ROW_ID = '0-1'");
                
                while(rs.next()){
                    row_id = rs.getString("P_NEXT_ID");
                }
                
                rs.close();
                closeConnection("ROW_ID: " + row_id + " encontrado com sucesso");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao buscar ROW_ID!");
            }
        } catch (HeadlessException | SQLException e){
            System.out.println(e);
        }
        
        return row_id;
    }
    
    @Override
    public String LookupValueSubtype(String type, String name, String subtype){
        String value = null;
        try{
            if("true".equals(openConnection("Buscando LookupValue usando Subtype"))){
                statement = conn.createStatement();
                
                ResultSet rs = statement.executeQuery(
                    "SELECT\n" +
                    "	LOV.VAL\n" +
                    "FROM " + super.getDbOwner() + "." + super.getTblLstOfVal() + " LOV\n" +
                    "WHERE " + super.getDbOwner() + ".TYPE = '" + type + "'\n" +
                    "AND " + super.getDbOwner() + ".NAME = '" + name + "'\n" +
                    "AND " + super.getDbOwner() + ".SUBTYPE = '" + subtype + "'"
                );
                
                while(rs.next()){
                    value = rs.getString("VAL");
                }
                
                rs.close();
                closeConnection("LookupValue usando Subtype encontrado com sucesso");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao buscar LOV Value!");
            }
        } catch (HeadlessException | SQLException e){
            System.out.println(e);
        }
        
        return value;
    }
    
    @Override
    public String LookupValue(String type, String name){
        String value = null;
        try{
            if("true".equals(openConnection("Buscando LookupValue"))){
                statement = conn.createStatement();
                
                ResultSet rs = statement.executeQuery(
                    "SELECT\n" +
                    "	LOV.VAL\n" +
                    "FROM " + super.getDbOwner() + "." + super.getTblLstOfVal() + " LOV\n" +
                    "WHERE LOV.TYPE = '" + type + "'\n" +
                    "AND LOV.NAME = '" + name + "'\n" +
                    "ORDER BY LOV.ORDER_BY ASC"
                );
                
                while(rs.next()){
                    value = rs.getString("VAL");
                }
                
                rs.close();
                closeConnection("LookupValue encontrado com sucesso");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao buscar LookupValue");
            }
        } catch (HeadlessException | SQLException e){
            System.out.println(e);
        }
        
        return value;
    }
    
    @Override
    public String LookupNameSubtype(String type, String value, String subtype){
        String name = null;
        try{
            if("true".equals(openConnection("Buscando LookupName usando Subtype"))){
                statement = conn.createStatement();
                
                ResultSet rs = statement.executeQuery(
                    "SELECT\n" +
                    "	LOV.NAME\n" +
                    "FROM " + super.getDbOwner() + "." + super.getTblLstOfVal() + " LOV\n" +
                    "WHERE " + super.getDbOwner() + ".TYPE = '" + type + "'\n" +
                    "AND " + super.getDbOwner() + ".VAL = '" + value + "'\n" +
                    "AND " + super.getDbOwner() + ".SUBTYPE = '" + subtype + "'"
                );
                
                while(rs.next()){
                    name = rs.getString("NAME");
                }
                
                rs.close();
                closeConnection("LookupName usando Subtype encontrado com sucesso");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao buscar LOV Value!");
            }
        } catch (HeadlessException | SQLException e){
            System.out.println(e);
        }
        
        return name;
    }
    
    @Override
    public ArrayList<ListOfValuesClass> LookupName(String type, String value){
        ArrayList<ListOfValuesClass> array = new ArrayList<>();
        
        try{
            if("true".equals(openConnection("Buscando LookupName"))){
                statement = conn.createStatement();
                
                ResultSet rs = statement.executeQuery(
                    "SELECT\n" +
                    "	LOV.NAME\n" +
                    "FROM " + super.getDbOwner() + "." + super.getTblLstOfVal() + " LOV\n" +
                    "WHERE " + super.getDbOwner() + ".TYPE = '" + type + "'\n" +
                    "AND " + super.getDbOwner() + ".VAL = '" + value + "'"
                );
                
                while(rs.next()){
                    ListOfValuesClass lookup = new ListOfValuesClass();
                    
                    lookup.setName(rs.getString("NAME"));
                    
                    array.add(lookup);
                }
                
                rs.close();
                closeConnection("LookupName encontrado com sucesso");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao buscar LOV Value!");
            }
        } catch (HeadlessException | SQLException e){
            System.out.println(e);
        }
        
        return array;
    }
    
    @Override
    public ArrayList<ListOfValuesClass> LookupList(String type){
        ArrayList<ListOfValuesClass> array = new ArrayList<>();
        
        try{
            if("true".equals(openConnection("Buscando LookupName"))){
                statement = conn.createStatement();
                
                ResultSet rs = statement.executeQuery(
                    "SELECT *\n" +
                    "FROM " + super.getDbOwner() + "." + super.getTblLstOfVal() + " LOV\n" +
                    "WHERE LOV.TYPE = '" + type + "'\n" +
                    "ORDER BY LOV.ORDER_BY ASC"
                );
                
                while(rs.next()){
                    ListOfValuesClass lookup = new ListOfValuesClass();
                    
                    lookup.setType(rs.getString("TYPE"));
                    lookup.setName(rs.getString("NAME"));
                    lookup.setValue(rs.getString("VAL"));
                    lookup.setSubtype(rs.getString("SUB_TYPE"));
                    lookup.setLang_id(rs.getString("LANG_ID"));
                    lookup.setActive_flg(rs.getString("ACTIVE_FLG"));                    
                    lookup.setOrder_by(rs.getString("ORDER_BY"));
                    lookup.setCode(rs.getString("CODE"));
                    
                    array.add(lookup);
                }
                
                rs.close();
                closeConnection("LookupName encontrado com sucesso");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao buscar LOV Value!");
            }
        } catch (HeadlessException | SQLException e){
            System.out.println(e);
        }
        
        return array;
    }
    
    public class ListOfValuesClass {
        private String row_id;
        private String created;
        private String created_by;
        private String updated;
        private String updated_by;
        private String modification_num;
        private String par_row_id;
        private String db_last_upd;
        private String rplctn_lvl_cd;
        private String type;
        private String name;
        private String value;
        private String subtype;
        private String lang_id;
        private String active_flg;
        private String order_by;
        private String code;
        private String desc_text;
        
        public ListOfValuesClass(){
            this.row_id = null;
            this.created = null;
            this.created_by = null;
            this.updated = null;
            this.updated_by = null;
            this.modification_num = null;
            this.par_row_id = null;
            this.db_last_upd = null;
            this.rplctn_lvl_cd = null;
            this.type = null;
            this.name = null;
            this.value = null;
            this.subtype = null;
            this.lang_id = null;
            this.active_flg = null;
            this.order_by = null;
            this.code = null;
            this.desc_text = null;
        }

        public String getRow_id() { return row_id; }
        public void setRow_id(String row_id) { this.row_id = row_id; }

        public String getCreated() { return created; }
        public void setCreated(String created) { this.created = created; }

        public String getCreated_by() { return created_by; }
        public void setCreated_by(String created_by) { this.created_by = created_by; }

        public String getUpdated() { return updated; }
        public void setUpdated(String updated) { this.updated = updated; }

        public String getUpdated_by() { return updated_by; }
        public void setUpdated_by(String updated_by) { this.updated_by = updated_by; }

        public String getModification_num() { return modification_num; }
        public void setModification_num(String modification_num) { this.modification_num = modification_num; }

        public String getPar_row_id() { return par_row_id; }
        public void setPar_row_id(String par_row_id) { this.par_row_id = par_row_id; }

        public String getDb_last_upd() { return db_last_upd; }
        public void setDb_last_upd(String db_last_upd) { this.db_last_upd = db_last_upd; }

        public String getRplctn_lvl_cd() { return rplctn_lvl_cd; }
        public void setRplctn_lvl_cd(String rplctn_lvl_cd) { this.rplctn_lvl_cd = rplctn_lvl_cd; }

        public String getDesc_text() { return desc_text; }
        public void setDesc_text(String desc_text) { this.desc_text = desc_text; }
        
        public String getType() { return type; }
        public void setType(String type) { this.type = type; }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public String getValue() { return value; }
        public void setValue(String value) { this.value = value; }

        public String getSubtype() { return subtype; }
        public void setSubtype(String subtype) { this.subtype = subtype; }

        public String getLang_id() { return lang_id; }
        public void setLang_id(String lang_id) { this.lang_id = lang_id; }

        public String getActive_flg() { return active_flg; }
        public void setActive_flg(String active_flg) { this.active_flg = active_flg; }

        public String getOrder_by() { return order_by; }
        public void setOrder_by(String order_by) { this.order_by = order_by; }

        public String getCode() { return code; }
        public void setCode(String code) { this.code = code; }
    }
    
    public class UserClass {
        private String row_id;
        private String created;
        private String created_by;
        private String updated;
        private String updated_by;
        private String modification_num;
        private String par_row_id;
        private String db_last_upd;
        private String LOGIN;
        private String PASSWORD;
        private String USER_FLG;
        private String LAST_LOGIN_TS;
        private String DOC_TYPE;
        private String DOC_NUM;
        private String FST_NAME;
        private String LAST_NAME;
        private String FULL_NAME;
        private String NICK_NAME;
        private String AGE;
        private String BIRTH_DT;
        private String PLACE_OF_BIRTH;
        private String SEX_MF;
        private String MARITAL_STAT_CD;
        private String NAME_CONJUGE;
        private String MOTHER_FULL_NAME;
        private String FATHER_FULL_NAME;
        private String IDENTITY_DOC_TYPE;
        private String REGISTER_NUM;
        private String REGISTER_SERIE;
        private String ORGAO_EMISSOR;
        private String UF_EMISSAO;
        private String EMISSION_DT;
        private String VALIDATION_DT;
        private String NATURALNESS;
        private String NATIONALITY;
        private String CHALLENGE_QUESTION_1;
        private String CHALLENGE_ANSWER_1;
        private String CHALLENGE_QUESTION_2;
        private String CHALLENGE_ANSWER_2;
        private String CHALLENGE_QUESTION_3;
        private String CHALLENGE_ANSWER_3;
        private String PR_ADDR_ID;
        private String PR_CON_ID;
        private String PR_PHONE_ID;
        private String STATUS_CD;
                
        public UserClass(){
            this.row_id = null;
            this.created = null;
            this.created_by = null;
            this.updated = null;
            this.updated_by = null;
            this.modification_num = null;
            this.par_row_id = null;
            this.db_last_upd = null;
            this.LOGIN = null;
            this.PASSWORD = null;
            this.USER_FLG = null;
            this.LAST_LOGIN_TS = null;
            this.DOC_TYPE = null;
            this.DOC_NUM = null;
            this.FST_NAME = null;
            this.LAST_NAME = null;
            this.FULL_NAME = null;
            this.NICK_NAME = null;
            this.AGE = null;
            this.BIRTH_DT = null;
            this.PLACE_OF_BIRTH = null;
            this.SEX_MF = null;
            this.MARITAL_STAT_CD = null;
            this.NAME_CONJUGE = null;
            this.MOTHER_FULL_NAME = null;
            this.FATHER_FULL_NAME = null;
            this.IDENTITY_DOC_TYPE = null;
            this.REGISTER_NUM = null;
            this.REGISTER_SERIE = null;
            this.ORGAO_EMISSOR = null;
            this.UF_EMISSAO = null;
            this.EMISSION_DT = null;
            this.VALIDATION_DT = null;
            this.NATURALNESS = null;
            this.NATIONALITY = null;
            this.CHALLENGE_QUESTION_1 = null;
            this.CHALLENGE_ANSWER_1 = null;
            this.CHALLENGE_QUESTION_2 = null;
            this.CHALLENGE_ANSWER_2 = null;
            this.CHALLENGE_QUESTION_3 = null;
            this.CHALLENGE_ANSWER_3 = null;
            this.PR_ADDR_ID = null;
            this.PR_CON_ID = null;
            this.PR_PHONE_ID = null;
            this.STATUS_CD = null;
        }
        
        public String getRow_id() { return row_id; }
        public void setRow_id(String row_id) { this.row_id = row_id; }

        public String getCreated() { return created; }
        public void setCreated(String created) { this.created = created; }

        public String getCreated_by() { return created_by; }
        public void setCreated_by(String created_by) { this.created_by = created_by; }

        public String getUpdated() { return updated; }
        public void setUpdated(String updated) { this.updated = updated; }

        public String getUpdated_by() { return updated_by; }
        public void setUpdated_by(String updated_by) { this.updated_by = updated_by; }

        public String getModification_num() { return modification_num; }
        public void setModification_num(String modification_num) { this.modification_num = modification_num; }

        public String getPar_row_id() { return par_row_id; }
        public void setPar_row_id(String par_row_id) { this.par_row_id = par_row_id; }

        public String getDb_last_upd() { return db_last_upd; }
        public void setDb_last_upd(String db_last_upd) { this.db_last_upd = db_last_upd; }
        
        public String getLOGIN() { return LOGIN; }
        public void setLOGIN(String LOGIN) { this.LOGIN = LOGIN; }

        public String getPASSWORD() { return PASSWORD; }
        public void setPASSWORD(String PASSWORD) { this.PASSWORD = PASSWORD; }

        public String getUSER_FLG() { return USER_FLG; }
        public void setUSER_FLG(String USER_FLG) { this.USER_FLG = USER_FLG; }

        public String getLAST_LOGIN_TS() { return LAST_LOGIN_TS; }
        public void setLAST_LOGIN_TS(String LAST_LOGIN_TS) { this.LAST_LOGIN_TS = LAST_LOGIN_TS; }

        public String getDOC_TYPE() { return DOC_TYPE; }
        public void setDOC_TYPE(String DOC_TYPE) { this.DOC_TYPE = DOC_TYPE; }

        public String getDOC_NUM() { return DOC_NUM; }
        public void setDOC_NUM(String DOC_NUM) { this.DOC_NUM = DOC_NUM; }

        public String getFST_NAME() { return FST_NAME; }
        public void setFST_NAME(String FST_NAME) { this.FST_NAME = FST_NAME; }

        public String getLAST_NAME() { return LAST_NAME; }
        public void setLAST_NAME(String LAST_NAME) { this.LAST_NAME = LAST_NAME; }

        public String getFULL_NAME() { return FULL_NAME; }
        public void setFULL_NAME(String FULL_NAME) { this.FULL_NAME = FULL_NAME; }

        public String getNICK_NAME() { return NICK_NAME; }
        public void setNICK_NAME(String NICK_NAME) { this.NICK_NAME = NICK_NAME; }

        public String getAGE() { return AGE; }
        public void setAGE(String AGE) { this.AGE = AGE; }

        public String getBIRTH_DT() { return BIRTH_DT; }
        public void setBIRTH_DT(String BIRTH_DT) { this.BIRTH_DT = BIRTH_DT; }

        public String getPLACE_OF_BIRTH() { return PLACE_OF_BIRTH; }
        public void setPLACE_OF_BIRTH(String PLACE_OF_BIRTH) { this.PLACE_OF_BIRTH = PLACE_OF_BIRTH; }

        public String getSEX_MF() { return SEX_MF; }
        public void setSEX_MF(String SEX_MF) { this.SEX_MF = SEX_MF; }

        public String getMARITAL_STAT_CD() { return MARITAL_STAT_CD; }
        public void setMARITAL_STAT_CD(String MARITAL_STAT_CD) { this.MARITAL_STAT_CD = MARITAL_STAT_CD; }

        public String getNAME_CONJUGE() { return NAME_CONJUGE; }
        public void setNAME_CONJUGE(String NAME_CONJUGE) { this.NAME_CONJUGE = NAME_CONJUGE; }

        public String getMOTHER_FULL_NAME() { return MOTHER_FULL_NAME; }
        public void setMOTHER_FULL_NAME(String MOTHER_FULL_NAME) { this.MOTHER_FULL_NAME = MOTHER_FULL_NAME; }

        public String getFATHER_FULL_NAME() { return FATHER_FULL_NAME; }
        public void setFATHER_FULL_NAME(String FATHER_FULL_NAME) { this.FATHER_FULL_NAME = FATHER_FULL_NAME; }

        public String getIDENTITY_DOC_TYPE() { return IDENTITY_DOC_TYPE; }
        public void setIDENTITY_DOC_TYPE(String IDENTITY_DOC_TYPE) { this.IDENTITY_DOC_TYPE = IDENTITY_DOC_TYPE; }

        public String getREGISTER_NUM() { return REGISTER_NUM; }
        public void setREGISTER_NUM(String REGISTER_NUM) { this.REGISTER_NUM = REGISTER_NUM; }

        public String getREGISTER_SERIE() { return REGISTER_SERIE; }
        public void setREGISTER_SERIE(String REGISTER_SERIE) { this.REGISTER_SERIE = REGISTER_SERIE; }

        public String getORGAO_EMISSOR() { return ORGAO_EMISSOR; }
        public void setORGAO_EMISSOR(String ORGAO_EMISSOR) { this.ORGAO_EMISSOR = ORGAO_EMISSOR; }

        public String getUF_EMISSAO() { return UF_EMISSAO; }
        public void setUF_EMISSAO(String UF_EMISSAO) { this.UF_EMISSAO = UF_EMISSAO; }

        public String getEMISSION_DT() { return EMISSION_DT; }
        public void setEMISSION_DT(String EMISSION_DT) { this.EMISSION_DT = EMISSION_DT; }

        public String getVALIDATION_DT() { return VALIDATION_DT; }
        public void setVALIDATION_DT(String VALIDATION_DT) { this.VALIDATION_DT = VALIDATION_DT; }

        public String getNATURALNESS() { return NATURALNESS; }
        public void setNATURALNESS(String NATURALNESS) { this.NATURALNESS = NATURALNESS; }

        public String getNATIONALITY() { return NATIONALITY; }
        public void setNATIONALITY(String NATIONALITY) { this.NATIONALITY = NATIONALITY; }

        public String getCHALLENGE_QUESTION_1() { return CHALLENGE_QUESTION_1; }
        public void setCHALLENGE_QUESTION_1(String CHALLENGE_QUESTION_1) { this.CHALLENGE_QUESTION_1 = CHALLENGE_QUESTION_1; }

        public String getCHALLENGE_ANSWER_1() { return CHALLENGE_ANSWER_1; }
        public void setCHALLENGE_ANSWER_1(String CHALLENGE_ANSWER_1) { this.CHALLENGE_ANSWER_1 = CHALLENGE_ANSWER_1; }

        public String getCHALLENGE_QUESTION_2() { return CHALLENGE_QUESTION_2; }
        public void setCHALLENGE_QUESTION_2(String CHALLENGE_QUESTION_2) { this.CHALLENGE_QUESTION_2 = CHALLENGE_QUESTION_2; }

        public String getCHALLENGE_ANSWER_2() { return CHALLENGE_ANSWER_2; }
        public void setCHALLENGE_ANSWER_2(String CHALLENGE_ANSWER_2) { this.CHALLENGE_ANSWER_2 = CHALLENGE_ANSWER_2; }

        public String getCHALLENGE_QUESTION_3() { return CHALLENGE_QUESTION_3; }
        public void setCHALLENGE_QUESTION_3(String CHALLENGE_QUESTION_3) { this.CHALLENGE_QUESTION_3 = CHALLENGE_QUESTION_3; }

        public String getCHALLENGE_ANSWER_3() { return CHALLENGE_ANSWER_3; }
        public void setCHALLENGE_ANSWER_3(String CHALLENGE_ANSWER_3) { this.CHALLENGE_ANSWER_3 = CHALLENGE_ANSWER_3; }

        public String getPR_ADDR_ID() { return PR_ADDR_ID; }
        public void setPR_ADDR_ID(String PR_ADDR_ID) { this.PR_ADDR_ID = PR_ADDR_ID; }

        public String getPR_CON_ID() { return PR_CON_ID; }
        public void setPR_CON_ID(String PR_CON_ID) { this.PR_CON_ID = PR_CON_ID; }

        public String getPR_PHONE_ID() { return PR_PHONE_ID; }
        public void setPR_PHONE_ID(String PR_PHONE_ID) { this.PR_PHONE_ID = PR_PHONE_ID; }

        public String getSTATUS_CD() { return STATUS_CD; }
        public void setSTATUS_CD(String STATUS_CD) { this.STATUS_CD = STATUS_CD; }
        
        
    }
    
    public class PositionClass {
        private String row_id;
        private String created;
        private String created_by;
        private String updated;
        private String updated_by;
        private String modification_num;
        private String par_row_id;
        private String db_last_upd;
        private String NAME;
        private String POSTN_TYPE_CD;
        private String DESC_TEXT;
        private String PAR_POSTN_ID;
                
        public PositionClass(){
            this.row_id = null;
            this.created = null;
            this.created_by = null;
            this.updated = null;
            this.updated_by = null;
            this.modification_num = null;
            this.par_row_id = null;
            this.db_last_upd = null;
            this.NAME = null;
            this.POSTN_TYPE_CD = null;
            this.DESC_TEXT = null;
            this.PAR_POSTN_ID = null;
        }
        
        public String getRow_id() { return row_id; }
        public void setRow_id(String row_id) { this.row_id = row_id; }

        public String getCreated() { return created; }
        public void setCreated(String created) { this.created = created; }

        public String getCreated_by() { return created_by; }
        public void setCreated_by(String created_by) { this.created_by = created_by; }

        public String getUpdated() { return updated; }
        public void setUpdated(String updated) { this.updated = updated; }

        public String getUpdated_by() { return updated_by; }
        public void setUpdated_by(String updated_by) { this.updated_by = updated_by; }

        public String getModification_num() { return modification_num; }
        public void setModification_num(String modification_num) { this.modification_num = modification_num; }

        public String getPar_row_id() { return par_row_id; }
        public void setPar_row_id(String par_row_id) { this.par_row_id = par_row_id; }

        public String getDb_last_upd() { return db_last_upd; }
        public void setDb_last_upd(String db_last_upd) { this.db_last_upd = db_last_upd; }

        public String getNAME() { return NAME; }
        public void setNAME(String NAME) { this.NAME = NAME; }

        public String getPOSTN_TYPE_CD() { return POSTN_TYPE_CD; }
        public void setPOSTN_TYPE_CD(String POSTN_TYPE_CD) { this.POSTN_TYPE_CD = POSTN_TYPE_CD; }

        public String getDESC_TEXT() { return DESC_TEXT; }
        public void setDESC_TEXT(String DESC_TEXT) { this.DESC_TEXT = DESC_TEXT; }

        public String getPAR_POSTN_ID() { return PAR_POSTN_ID; }
        public void setPAR_POSTN_ID(String PAR_POSTN_ID) { this.PAR_POSTN_ID = PAR_POSTN_ID; }
    }
    
    public class UserPermitionClass {
        private String row_id;
        private String created;
        private String created_by;
        private String updated;
        private String updated_by;
        private String modification_num;
        private String par_row_id;
        private String db_last_upd;
        private String X_PAY_BOX_MANAGER;
        private String X_NEW_SALE;
        private String X_DELIVERY;
        private String X_VIEW_CLIENT;
        private String X_ADD_CLIENT;
        private String X_UPD_CLIENT;
        private String X_DEL_CLIENT;
        private String X_CASH_REPORT;
        private String X_SALES_REPORT;
        private String X_VIEW_PROD;
        private String X_ADD_PROD;
        private String X_UPD_PROD;
        private String X_DEL_PROD;
        private String X_VIEW_COMP;
        private String X_ADD_COMP;
        private String X_UPD_COMP;
        private String X_DEL_COMP;
        private String X_VIEW_CAT;
        private String X_ADD_CAT;
        private String X_UPD_CAT;
        private String X_DEL_CAT;
        private String X_VIEW_SIZE;
        private String X_ADD_SIZE;
        private String X_UPD_SIZE;
        private String X_DEL_SIZE;
        private String X_VIEW_USER;
        private String X_ADD_USER;
        private String X_UPD_USER;
        private String X_DEL_USER;
        private String X_COMMENTS;
                
        public UserPermitionClass(){
            this.row_id = null;
            this.created = null;
            this.created_by = null;
            this.updated = null;
            this.updated_by = null;
            this.modification_num = null;
            this.par_row_id = null;
            this.db_last_upd = null;
            this.X_PAY_BOX_MANAGER = null;
            this.X_NEW_SALE = null;
            this.X_DELIVERY = null;
            this.X_VIEW_CLIENT = null;
            this.X_ADD_CLIENT = null;
            this.X_UPD_CLIENT = null;
            this.X_DEL_CLIENT = null;
            this.X_CASH_REPORT = null;
            this.X_SALES_REPORT = null;
            this.X_VIEW_PROD = null;
            this.X_ADD_PROD = null;
            this.X_UPD_PROD = null;
            this.X_DEL_PROD = null;
            this.X_VIEW_COMP = null;
            this.X_ADD_COMP = null;
            this.X_UPD_COMP = null;
            this.X_DEL_COMP = null;
            this.X_VIEW_CAT = null;
            this.X_ADD_CAT = null;
            this.X_UPD_CAT = null;
            this.X_DEL_CAT = null;
            this.X_VIEW_SIZE = null;
            this.X_ADD_SIZE = null;
            this.X_UPD_SIZE = null;
            this.X_DEL_SIZE = null;
            this.X_VIEW_USER = null;
            this.X_ADD_USER = null;
            this.X_UPD_USER = null;
            this.X_DEL_USER = null;
            this.X_COMMENTS = null;
        }
        
        public String getRow_id() { return row_id; }
        public void setRow_id(String row_id) { this.row_id = row_id; }

        public String getCreated() { return created; }
        public void setCreated(String created) { this.created = created; }

        public String getCreated_by() { return created_by; }
        public void setCreated_by(String created_by) { this.created_by = created_by; }

        public String getUpdated() { return updated; }
        public void setUpdated(String updated) { this.updated = updated; }

        public String getUpdated_by() { return updated_by; }
        public void setUpdated_by(String updated_by) { this.updated_by = updated_by; }

        public String getModification_num() { return modification_num; }
        public void setModification_num(String modification_num) { this.modification_num = modification_num; }

        public String getPar_row_id() { return par_row_id; }
        public void setPar_row_id(String par_row_id) { this.par_row_id = par_row_id; }

        public String getDb_last_upd() { return db_last_upd; }
        public void setDb_last_upd(String db_last_upd) { this.db_last_upd = db_last_upd; }

        public String getX_PAY_BOX_MANAGER() { return X_PAY_BOX_MANAGER; }
        public void setX_PAY_BOX_MANAGER(String X_PAY_BOX_MANAGER) { this.X_PAY_BOX_MANAGER = X_PAY_BOX_MANAGER; }

        public String getX_NEW_SALE() { return X_NEW_SALE; }
        public void setX_NEW_SALE(String X_NEW_SALE) { this.X_NEW_SALE = X_NEW_SALE; }

        public String getX_DELIVERY() { return X_DELIVERY; }
        public void setX_DELIVERY(String X_DELIVERY) { this.X_DELIVERY = X_DELIVERY; }

        public String getX_VIEW_CLIENT() { return X_VIEW_CLIENT; }
        public void setX_VIEW_CLIENT(String X_VIEW_CLIENT) { this.X_VIEW_CLIENT = X_VIEW_CLIENT; }

        public String getX_ADD_CLIENT() { return X_ADD_CLIENT; }
        public void setX_ADD_CLIENT(String X_ADD_CLIENT) { this.X_ADD_CLIENT = X_ADD_CLIENT; }

        public String getX_UPD_CLIENT() { return X_UPD_CLIENT; }
        public void setX_UPD_CLIENT(String X_UPD_CLIENT) { this.X_UPD_CLIENT = X_UPD_CLIENT; }

        public String getX_DEL_CLIENT() { return X_DEL_CLIENT; }
        public void setX_DEL_CLIENT(String X_DEL_CLIENT) { this.X_DEL_CLIENT = X_DEL_CLIENT; }

        public String getX_CASH_REPORT() { return X_CASH_REPORT; }
        public void setX_CASH_REPORT(String X_CASH_REPORT) { this.X_CASH_REPORT = X_CASH_REPORT; }

        public String getX_SALES_REPORT() { return X_SALES_REPORT; }
        public void setX_SALES_REPORT(String X_SALES_REPORT) { this.X_SALES_REPORT = X_SALES_REPORT; }

        public String getX_VIEW_PROD() { return X_VIEW_PROD; }
        public void setX_VIEW_PROD(String X_VIEW_PROD) { this.X_VIEW_PROD = X_VIEW_PROD; }

        public String getX_ADD_PROD() { return X_ADD_PROD; }
        public void setX_ADD_PROD(String X_ADD_PROD) { this.X_ADD_PROD = X_ADD_PROD; }

        public String getX_UPD_PROD() { return X_UPD_PROD; }
        public void setX_UPD_PROD(String X_UPD_PROD) { this.X_UPD_PROD = X_UPD_PROD; }

        public String getX_DEL_PROD() { return X_DEL_PROD; }
        public void setX_DEL_PROD(String X_DEL_PROD) { this.X_DEL_PROD = X_DEL_PROD; }

        public String getX_VIEW_COMP() { return X_VIEW_COMP; }
        public void setX_VIEW_COMP(String X_VIEW_COMP) { this.X_VIEW_COMP = X_VIEW_COMP; }

        public String getX_ADD_COMP() { return X_ADD_COMP; }
        public void setX_ADD_COMP(String X_ADD_COMP) { this.X_ADD_COMP = X_ADD_COMP; }

        public String getX_UPD_COMP() { return X_UPD_COMP; }
        public void setX_UPD_COMP(String X_UPD_COMP) { this.X_UPD_COMP = X_UPD_COMP; }

        public String getX_DEL_COMP() { return X_DEL_COMP; }
        public void setX_DEL_COMP(String X_DEL_COMP) { this.X_DEL_COMP = X_DEL_COMP; }

        public String getX_VIEW_CAT() { return X_VIEW_CAT; }
        public void setX_VIEW_CAT(String X_VIEW_CAT) { this.X_VIEW_CAT = X_VIEW_CAT; }

        public String getX_ADD_CAT() { return X_ADD_CAT; }
        public void setX_ADD_CAT(String X_ADD_CAT) { this.X_ADD_CAT = X_ADD_CAT; }

        public String getX_UPD_CAT() { return X_UPD_CAT; }
        public void setX_UPD_CAT(String X_UPD_CAT) { this.X_UPD_CAT = X_UPD_CAT; }

        public String getX_DEL_CAT() { return X_DEL_CAT; }
        public void setX_DEL_CAT(String X_DEL_CAT) { this.X_DEL_CAT = X_DEL_CAT; }

        public String getX_VIEW_SIZE() { return X_VIEW_SIZE; }
        public void setX_VIEW_SIZE(String X_VIEW_SIZE) { this.X_VIEW_SIZE = X_VIEW_SIZE; }

        public String getX_ADD_SIZE() { return X_ADD_SIZE; }
        public void setX_ADD_SIZE(String X_ADD_SIZE) { this.X_ADD_SIZE = X_ADD_SIZE; }

        public String getX_UPD_SIZE() { return X_UPD_SIZE; }
        public void setX_UPD_SIZE(String X_UPD_SIZE) { this.X_UPD_SIZE = X_UPD_SIZE; }

        public String getX_DEL_SIZE() { return X_DEL_SIZE; }
        public void setX_DEL_SIZE(String X_DEL_SIZE) { this.X_DEL_SIZE = X_DEL_SIZE; }

        public String getX_VIEW_USER() { return X_VIEW_USER; }
        public void setX_VIEW_USER(String X_VIEW_USER) { this.X_VIEW_USER = X_VIEW_USER; }

        public String getX_ADD_USER() { return X_ADD_USER; }
        public void setX_ADD_USER(String X_ADD_USER) { this.X_ADD_USER = X_ADD_USER; }

        public String getX_UPD_USER() { return X_UPD_USER; }
        public void setX_UPD_USER(String X_UPD_USER) { this.X_UPD_USER = X_UPD_USER; }

        public String getX_DEL_USER() { return X_DEL_USER; }
        public void setX_DEL_USER(String X_DEL_USER) { this.X_DEL_USER = X_DEL_USER; }
	
        public String getX_COMMENTS() { return X_COMMENTS; }
        public void setX_COMMENTS(String X_COMMENTS) { this.X_COMMENTS = X_COMMENTS; }
	
    }
    
    public class AccountClass {
        private String row_id;
        private String created;
        private String created_by;
        private String updated;
        private String updated_by;
        private String modification_num;
        private String par_row_id;
        private String db_last_upd;
        private String ACTIVE_FLG;
        private String ACCNT_NUMBER;
        private String ACCNT_FLG;
        private String DOC_TYPE;
        private String DOC_NUM;
        private String ALIAS_NAME;
        private String NOME_FANTASIA;
        private String FST_NAME;
        private String LAST_NAME;
        private String FULL_NAME;
        private String NICK_NAME;
        private String AGE;
        private String BIRTH_DT;
        private String PLACE_OF_BIRTH;
        private String SEX_MF;
        private String MARITAL_STAT_CD;
        private String NAME_CONJUGE;
        private String MOTHER_FULL_NAME;
        private String FATHER_FULL_NAME;
        private String POTENTIAL_FLG;
        private String ENTERPRISE_FLAG;
        private String PARTNER_FLG;
        private String ACCNT_TYPE_CD;
        private String CREATOR_LOGIN;
        private String DESC_TEXT;
        private String PR_ADDR_ID;
        private String PR_CON_ID;
        private String PR_PHONE_ID;
        private String STATUS_CD;
        private String ATIV_COMERCIAL;
        private String INSCR_MUNICIPAL;
        private String INSCR_ESTADUAL;
        private String DOCUMENT_TYPE;
        private String REGISTER_NUM;
        private String REGISTER_SERIE;
        private String ORGAO_EMISSOR;
        private String UF_EMISSAO;
        private String NATURALNESS;
        private String NATIONALITY;
        private String EMISSION_DT;
        private String VALIDATION_DT;
        private String PODER_PUBLICO_FLG;
                
        public AccountClass(){
            this.row_id = null;
            this.created = null;
            this.created_by = null;
            this.updated = null;
            this.updated_by = null;
            this.modification_num = null;
            this.par_row_id = null;
            this.db_last_upd = null;
            this.ACTIVE_FLG = null;
            this.ACCNT_NUMBER = null;
            this.ACCNT_FLG = null;
            this.DOC_TYPE = null;
            this.DOC_NUM = null;
            this.ALIAS_NAME = null;
            this.NOME_FANTASIA = null;
            this.FST_NAME = null;
            this.LAST_NAME = null;
            this.FULL_NAME = null;
            this.NICK_NAME = null;
            this.AGE = null;
            this.BIRTH_DT = null;
            this.PLACE_OF_BIRTH = null;
            this.SEX_MF = null;
            this.MARITAL_STAT_CD = null;
            this.NAME_CONJUGE = null;
            this.MOTHER_FULL_NAME = null;
            this.FATHER_FULL_NAME = null;
            this.POTENTIAL_FLG = null;
            this.ENTERPRISE_FLAG = null;
            this.PARTNER_FLG = null;
            this.ACCNT_TYPE_CD = null;
            this.CREATOR_LOGIN = null;
            this.DESC_TEXT = null;
            this.PR_ADDR_ID = null;
            this.PR_CON_ID = null;
            this.PR_PHONE_ID = null;
            this.STATUS_CD = null;
            this.ATIV_COMERCIAL = null;
            this.INSCR_MUNICIPAL = null;
            this.INSCR_ESTADUAL = null;
            this.DOCUMENT_TYPE = null;
            this.REGISTER_NUM = null;
            this.REGISTER_SERIE = null;
            this.ORGAO_EMISSOR = null;
            this.UF_EMISSAO = null;
            this.NATURALNESS = null;
            this.NATIONALITY = null;
            this.EMISSION_DT = null;
            this.VALIDATION_DT = null;
            this.PODER_PUBLICO_FLG = null;
        }
        
        public String getRow_id() { return row_id; }
        public void setRow_id(String row_id) { this.row_id = row_id; }

        public String getCreated() { return created; }
        public void setCreated(String created) { this.created = created; }

        public String getCreated_by() { return created_by; }
        public void setCreated_by(String created_by) { this.created_by = created_by; }

        public String getUpdated() { return updated; }
        public void setUpdated(String updated) { this.updated = updated; }

        public String getUpdated_by() { return updated_by; }
        public void setUpdated_by(String updated_by) { this.updated_by = updated_by; }

        public String getModification_num() { return modification_num; }
        public void setModification_num(String modification_num) { this.modification_num = modification_num; }

        public String getPar_row_id() { return par_row_id; }
        public void setPar_row_id(String par_row_id) { this.par_row_id = par_row_id; }

        public String getDb_last_upd() { return db_last_upd; }
        public void setDb_last_upd(String db_last_upd) { this.db_last_upd = db_last_upd; }

        public String getACTIVE_FLG() { return ACTIVE_FLG; }
        public void setACTIVE_FLG(String ACTIVE_FLG) { this.ACTIVE_FLG = ACTIVE_FLG; }

        public String getACCNT_NUMBER() { return ACCNT_NUMBER; }
        public void setACCNT_NUMBER(String ACCNT_NUMBER) { this.ACCNT_NUMBER = ACCNT_NUMBER; }

        public String getACCNT_FLG() { return ACCNT_FLG; }
        public void setACCNT_FLG(String ACCNT_FLG) { this.ACCNT_FLG = ACCNT_FLG; }

        public String getDOC_TYPE() { return DOC_TYPE; }
        public void setDOC_TYPE(String DOC_TYPE) { this.DOC_TYPE = DOC_TYPE; }

        public String getDOC_NUM() { return DOC_NUM; }
        public void setDOC_NUM(String DOC_NUM) { this.DOC_NUM = DOC_NUM; }

        public String getALIAS_NAME() { return ALIAS_NAME; }
        public void setALIAS_NAME(String ALIAS_NAME) { this.ALIAS_NAME = ALIAS_NAME; }

        public String getNOME_FANTASIA() { return NOME_FANTASIA; }
        public void setNOME_FANTASIA(String NOME_FANTASIA) { this.NOME_FANTASIA = NOME_FANTASIA; }

        public String getFST_NAME() { return FST_NAME; }
        public void setFST_NAME(String FST_NAME) { this.FST_NAME = FST_NAME; }

        public String getLAST_NAME() { return LAST_NAME; }
        public void setLAST_NAME(String LAST_NAME) { this.LAST_NAME = LAST_NAME; }

        public String getFULL_NAME() { return FULL_NAME; }
        public void setFULL_NAME(String FULL_NAME) { this.FULL_NAME = FULL_NAME; }

        public String getNICK_NAME() { return NICK_NAME; }
        public void setNICK_NAME(String NICK_NAME) { this.NICK_NAME = NICK_NAME; }

        public String getAGE() { return AGE; }
        public void setAGE(String AGE) { this.AGE = AGE; }

        public String getBIRTH_DT() { return BIRTH_DT; }
        public void setBIRTH_DT(String BIRTH_DT) { this.BIRTH_DT = BIRTH_DT; }

        public String getPLACE_OF_BIRTH() { return PLACE_OF_BIRTH; }
        public void setPLACE_OF_BIRTH(String PLACE_OF_BIRTH) { this.PLACE_OF_BIRTH = PLACE_OF_BIRTH; }

        public String getSEX_MF() { return SEX_MF; }
        public void setSEX_MF(String SEX_MF) { this.SEX_MF = SEX_MF; }

        public String getMARITAL_STAT_CD() { return MARITAL_STAT_CD; }
        public void setMARITAL_STAT_CD(String MARITAL_STAT_CD) { this.MARITAL_STAT_CD = MARITAL_STAT_CD; }

        public String getNAME_CONJUGE() { return NAME_CONJUGE; }
        public void setNAME_CONJUGE(String NAME_CONJUGE) { this.NAME_CONJUGE = NAME_CONJUGE; }

        public String getMOTHER_FULL_NAME() { return MOTHER_FULL_NAME; }
        public void setMOTHER_FULL_NAME(String MOTHER_FULL_NAME) { this.MOTHER_FULL_NAME = MOTHER_FULL_NAME; }

        public String getFATHER_FULL_NAME() { return FATHER_FULL_NAME; }
        public void setFATHER_FULL_NAME(String FATHER_FULL_NAME) { this.FATHER_FULL_NAME = FATHER_FULL_NAME; }

        public String getPOTENTIAL_FLG() { return POTENTIAL_FLG; }
        public void setPOTENTIAL_FLG(String POTENTIAL_FLG) { this.POTENTIAL_FLG = POTENTIAL_FLG; }

        public String getENTERPRISE_FLAG() { return ENTERPRISE_FLAG; }
        public void setENTERPRISE_FLAG(String ENTERPRISE_FLAG) { this.ENTERPRISE_FLAG = ENTERPRISE_FLAG; }

        public String getPARTNER_FLG() { return PARTNER_FLG; }
        public void setPARTNER_FLG(String PARTNER_FLG) { this.PARTNER_FLG = PARTNER_FLG; }

        public String getACCNT_TYPE_CD() { return ACCNT_TYPE_CD; }
        public void setACCNT_TYPE_CD(String ACCNT_TYPE_CD) { this.ACCNT_TYPE_CD = ACCNT_TYPE_CD; }

        public String getCREATOR_LOGIN() { return CREATOR_LOGIN; }
        public void setCREATOR_LOGIN(String CREATOR_LOGIN) { this.CREATOR_LOGIN = CREATOR_LOGIN; }

        public String getDESC_TEXT() { return DESC_TEXT; }
        public void setDESC_TEXT(String DESC_TEXT) { this.DESC_TEXT = DESC_TEXT; }

        public String getPR_ADDR_ID() { return PR_ADDR_ID; }
        public void setPR_ADDR_ID(String PR_ADDR_ID) { this.PR_ADDR_ID = PR_ADDR_ID; }

        public String getPR_CON_ID() { return PR_CON_ID; }
        public void setPR_CON_ID(String PR_CON_ID) { this.PR_CON_ID = PR_CON_ID; }

        public String getPR_PHONE_ID() { return PR_PHONE_ID; }
        public void setPR_PHONE_ID(String PR_PHONE_ID) { this.PR_PHONE_ID = PR_PHONE_ID; }

        public String getSTATUS_CD() { return STATUS_CD; }
        public void setSTATUS_CD(String STATUS_CD) { this.STATUS_CD = STATUS_CD; }

        public String getATIV_COMERCIAL() { return ATIV_COMERCIAL; }
        public void setATIV_COMERCIAL(String ATIV_COMERCIAL) { this.ATIV_COMERCIAL = ATIV_COMERCIAL; }

        public String getINSCR_MUNICIPAL() { return INSCR_MUNICIPAL; }
        public void setINSCR_MUNICIPAL(String INSCR_MUNICIPAL) { this.INSCR_MUNICIPAL = INSCR_MUNICIPAL; }

        public String getINSCR_ESTADUAL() { return INSCR_ESTADUAL; }
        public void setINSCR_ESTADUAL(String INSCR_ESTADUAL) { this.INSCR_ESTADUAL = INSCR_ESTADUAL; }

        public String getDOCUMENT_TYPE() { return DOCUMENT_TYPE; }
        public void setDOCUMENT_TYPE(String DOCUMENT_TYPE) { this.DOCUMENT_TYPE = DOCUMENT_TYPE; }

        public String getREGISTER_NUM() { return REGISTER_NUM; }
        public void setREGISTER_NUM(String REGISTER_NUM) { this.REGISTER_NUM = REGISTER_NUM; }

        public String getREGISTER_SERIE() { return REGISTER_SERIE; }
        public void setREGISTER_SERIE(String REGISTER_SERIE) { this.REGISTER_SERIE = REGISTER_SERIE; }

        public String getORGAO_EMISSOR() { return ORGAO_EMISSOR; }
        public void setORGAO_EMISSOR(String ORGAO_EMISSOR) { this.ORGAO_EMISSOR = ORGAO_EMISSOR; }

        public String getUF_EMISSAO() { return UF_EMISSAO; }
        public void setUF_EMISSAO(String UF_EMISSAO) { this.UF_EMISSAO = UF_EMISSAO; }

        public String getNATURALNESS() { return NATURALNESS; }
        public void setNATURALNESS(String NATURALNESS) { this.NATURALNESS = NATURALNESS; }

        public String getNATIONALITY() { return NATIONALITY; }
        public void setNATIONALITY(String NATIONALITY) { this.NATIONALITY = NATIONALITY; }

        public String getEMISSION_DT() { return EMISSION_DT; }
        public void setEMISSION_DT(String EMISSION_DT) { this.EMISSION_DT = EMISSION_DT; }

        public String getVALIDATION_DT() { return VALIDATION_DT; }
        public void setVALIDATION_DT(String VALIDATION_DT) { this.VALIDATION_DT = VALIDATION_DT; }

        public String getPODER_PUBLICO_FLG() { return PODER_PUBLICO_FLG; }
        public void setPODER_PUBLICO_FLG(String PODER_PUBLICO_FLG) { this.PODER_PUBLICO_FLG = PODER_PUBLICO_FLG; }
	
    }
    
    public class ContactClass {
        private String row_id;
        private String created;
        private String created_by;
        private String updated;
        private String updated_by;
        private String modification_num;
        private String par_row_id;
        private String db_last_upd;
        private String ACTIVE_FLG;
        private String PAR_USR_ID;
        private String PR_CON_FLG;
        private String EMP_FLG;
        private String DOC_TYPE;
        private String DOC_NUM;
        private String ALIAS_NAME;
        private String NOME_FANTASIA;
        private String FST_NAME;
        private String LAST_NAME;
        private String FULL_NAME;
        private String NICK_NAME;
        private String AGE;
        private String BIRTH_DT;
        private String PLACE_OF_BIRTH;
        private String SEX_MF;
        private String MARITAL_STAT_CD;
        private String NAME_CONJUGE;
        private String MOTHER_FULL_NAME;
        private String FATHER_FULL_NAME;
        private String POTENTIAL_FLG;
        private String SUPPRESS_EMAIL_FLG;
        private String ENTERPRISE_FLAG;
        private String RELATIONSHIP_TYPE;
        private String MEMBER_FLG;
        private String SEND_NEWS_FLG;
        private String SEND_PROMOTES_FLG;
        private String SUPPRESS_CALL_FLG;
        private String CONSUMER_FLG;
        private String MAIN_PH_NUM;
        private String ALT_PH_NUM;
        private String WORK_PH_NUM;
        private String ASST_PH_NUM;
        private String FAX_PH_NUM;
        private String CALL_FREQUENCY;
        private String CREATOR_LOGIN;
        private String EMAIL_TYPE;
        private String EMAIL_ADDR;
        private String SITE_ADDR;
        private String WHATSAPP_FLG;
        private String LOGIN;
        private String OCCUPATION;
        private String PASSWORD;
        private String PR_CON_ADDR_ID;
        private String PR_EMAIL_ADDR_ID;
        private String PR_ADDR_ID;
        private String STATUS_CD;
        
        public ContactClass(){
            this.row_id = null;
            this.created = null;
            this.created_by = null;
            this.updated = null;
            this.updated_by = null;
            this.modification_num = null;
            this.par_row_id = null;
            this.db_last_upd = null;
            this.ACTIVE_FLG = null;
            this.PAR_USR_ID = null;
            this.PR_CON_FLG = null;
            this.EMP_FLG = null;
            this.DOC_TYPE = null;
            this.DOC_NUM = null;
            this.ALIAS_NAME = null;
            this.NOME_FANTASIA = null;
            this.FST_NAME = null;
            this.LAST_NAME = null;
            this.FULL_NAME = null;
            this.NICK_NAME = null;
            this.AGE = null;
            this.BIRTH_DT = null;
            this.PLACE_OF_BIRTH = null;
            this.SEX_MF = null;
            this.MARITAL_STAT_CD = null;
            this.NAME_CONJUGE = null;
            this.MOTHER_FULL_NAME = null;
            this.FATHER_FULL_NAME = null;
            this.POTENTIAL_FLG = null;
            this.SUPPRESS_EMAIL_FLG = null;
            this.ENTERPRISE_FLAG = null;
            this.RELATIONSHIP_TYPE = null;
            this.MEMBER_FLG = null;
            this.SEND_NEWS_FLG = null;
            this.SEND_PROMOTES_FLG = null;
            this.SUPPRESS_CALL_FLG = null;
            this.CONSUMER_FLG = null;
            this.MAIN_PH_NUM = null;
            this.ALT_PH_NUM = null;
            this.WORK_PH_NUM = null;
            this.ASST_PH_NUM = null;
            this.FAX_PH_NUM = null;
            this.CALL_FREQUENCY = null;
            this.CREATOR_LOGIN = null;
            this.EMAIL_TYPE = null;
            this.EMAIL_ADDR = null;
            this.SITE_ADDR = null;
            this.WHATSAPP_FLG = null;
            this.LOGIN = null;
            this.OCCUPATION = null;
            this.PASSWORD = null;
            this.PR_CON_ADDR_ID = null;
            this.PR_EMAIL_ADDR_ID = null;
            this.PR_ADDR_ID = null;
            this.STATUS_CD = null;
        }
        
        public String getRow_id() { return row_id; }
        public void setRow_id(String row_id) { this.row_id = row_id; }

        public String getCreated() { return created; }
        public void setCreated(String created) { this.created = created; }

        public String getCreated_by() { return created_by; }
        public void setCreated_by(String created_by) { this.created_by = created_by; }

        public String getUpdated() { return updated; }
        public void setUpdated(String updated) { this.updated = updated; }

        public String getUpdated_by() { return updated_by; }
        public void setUpdated_by(String updated_by) { this.updated_by = updated_by; }

        public String getModification_num() { return modification_num; }
        public void setModification_num(String modification_num) { this.modification_num = modification_num; }

        public String getPar_row_id() { return par_row_id; }
        public void setPar_row_id(String par_row_id) { this.par_row_id = par_row_id; }

        public String getDb_last_upd() { return db_last_upd; }
        public void setDb_last_upd(String db_last_upd) { this.db_last_upd = db_last_upd; }

        public String getACTIVE_FLG() { return ACTIVE_FLG; }
        public void setACTIVE_FLG(String ACTIVE_FLG) { this.ACTIVE_FLG = ACTIVE_FLG; }
    
        public String getPAR_USR_ID() { return PAR_USR_ID; }
        public void setPAR_USR_ID(String PAR_USR_ID) { this.PAR_USR_ID = PAR_USR_ID; }

        public String getPR_CON_FLG() { return PR_CON_FLG; }
        public void setPR_CON_FLG(String PR_CON_FLG) { this.PR_CON_FLG = PR_CON_FLG; }

        public String getEMP_FLG() { return EMP_FLG; }
        public void setEMP_FLG(String EMP_FLG) { this.EMP_FLG = EMP_FLG; }

        public String getDOC_TYPE() { return DOC_TYPE; }
        public void setDOC_TYPE(String DOC_TYPE) { this.DOC_TYPE = DOC_TYPE; }

        public String getDOC_NUM() { return DOC_NUM; }
        public void setDOC_NUM(String DOC_NUM) { this.DOC_NUM = DOC_NUM; }

        public String getALIAS_NAME() { return ALIAS_NAME; }
        public void setALIAS_NAME(String ALIAS_NAME) { this.ALIAS_NAME = ALIAS_NAME; }

        public String getNOME_FANTASIA() { return NOME_FANTASIA; }
        public void setNOME_FANTASIA(String NOME_FANTASIA) { this.NOME_FANTASIA = NOME_FANTASIA; }

        public String getFST_NAME() { return FST_NAME; }
        public void setFST_NAME(String FST_NAME) { this.FST_NAME = FST_NAME; }

        public String getLAST_NAME() { return LAST_NAME; }
        public void setLAST_NAME(String LAST_NAME) { this.LAST_NAME = LAST_NAME; }

        public String getFULL_NAME() { return FULL_NAME; }
        public void setFULL_NAME(String FULL_NAME) { this.FULL_NAME = FULL_NAME; }

        public String getNICK_NAME() { return NICK_NAME; }
        public void setNICK_NAME(String NICK_NAME) { this.NICK_NAME = NICK_NAME; }

        public String getAGE() { return AGE; }
        public void setAGE(String AGE) { this.AGE = AGE; }

        public String getBIRTH_DT() { return BIRTH_DT; }
        public void setBIRTH_DT(String BIRTH_DT) { this.BIRTH_DT = BIRTH_DT; }

        public String getPLACE_OF_BIRTH() { return PLACE_OF_BIRTH; }
        public void setPLACE_OF_BIRTH(String PLACE_OF_BIRTH) { this.PLACE_OF_BIRTH = PLACE_OF_BIRTH; }

        public String getSEX_MF() { return SEX_MF; }
        public void setSEX_MF(String SEX_MF) { this.SEX_MF = SEX_MF; }

        public String getMARITAL_STAT_CD() { return MARITAL_STAT_CD; }
        public void setMARITAL_STAT_CD(String MARITAL_STAT_CD) { this.MARITAL_STAT_CD = MARITAL_STAT_CD; }

        public String getNAME_CONJUGE() { return NAME_CONJUGE; }
        public void setNAME_CONJUGE(String NAME_CONJUGE) { this.NAME_CONJUGE = NAME_CONJUGE; }

        public String getMOTHER_FULL_NAME() { return MOTHER_FULL_NAME; }
        public void setMOTHER_FULL_NAME(String MOTHER_FULL_NAME) { this.MOTHER_FULL_NAME = MOTHER_FULL_NAME; }

        public String getFATHER_FULL_NAME() { return FATHER_FULL_NAME; }
        public void setFATHER_FULL_NAME(String FATHER_FULL_NAME) { this.FATHER_FULL_NAME = FATHER_FULL_NAME; }

        public String getPOTENTIAL_FLG() { return POTENTIAL_FLG; }
        public void setPOTENTIAL_FLG(String POTENTIAL_FLG) { this.POTENTIAL_FLG = POTENTIAL_FLG; }

        public String getSUPPRESS_EMAIL_FLG() { return SUPPRESS_EMAIL_FLG; }
        public void setSUPPRESS_EMAIL_FLG(String SUPPRESS_EMAIL_FLG) { this.SUPPRESS_EMAIL_FLG = SUPPRESS_EMAIL_FLG; }

        public String getENTERPRISE_FLAG() { return ENTERPRISE_FLAG; }
        public void setENTERPRISE_FLAG(String ENTERPRISE_FLAG) { this.ENTERPRISE_FLAG = ENTERPRISE_FLAG; }

        public String getRELATIONSHIP_TYPE() { return RELATIONSHIP_TYPE; }
        public void setRELATIONSHIP_TYPE(String RELATIONSHIP_TYPE) { this.RELATIONSHIP_TYPE = RELATIONSHIP_TYPE; }

        public String getMEMBER_FLG() { return MEMBER_FLG; }
        public void setMEMBER_FLG(String MEMBER_FLG) { this.MEMBER_FLG = MEMBER_FLG; }

        public String getSEND_NEWS_FLG() { return SEND_NEWS_FLG; }
        public void setSEND_NEWS_FLG(String SEND_NEWS_FLG) { this.SEND_NEWS_FLG = SEND_NEWS_FLG; }

        public String getSEND_PROMOTES_FLG() { return SEND_PROMOTES_FLG; }
        public void setSEND_PROMOTES_FLG(String SEND_PROMOTES_FLG) { this.SEND_PROMOTES_FLG = SEND_PROMOTES_FLG; }

        public String getSUPPRESS_CALL_FLG() { return SUPPRESS_CALL_FLG; }
        public void setSUPPRESS_CALL_FLG(String SUPPRESS_CALL_FLG) { this.SUPPRESS_CALL_FLG = SUPPRESS_CALL_FLG; }

        public String getCONSUMER_FLG() { return CONSUMER_FLG; }
        public void setCONSUMER_FLG(String CONSUMER_FLG) { this.CONSUMER_FLG = CONSUMER_FLG; }

        public String getMAIN_PH_NUM() { return MAIN_PH_NUM; }
        public void setMAIN_PH_NUM(String MAIN_PH_NUM) { this.MAIN_PH_NUM = MAIN_PH_NUM; }

        public String getALT_PH_NUM() { return ALT_PH_NUM; }
        public void setALT_PH_NUM(String ALT_PH_NUM) { this.ALT_PH_NUM = ALT_PH_NUM; }

        public String getWORK_PH_NUM() { return WORK_PH_NUM; }
        public void setWORK_PH_NUM(String WORK_PH_NUM) { this.WORK_PH_NUM = WORK_PH_NUM; }

        public String getASST_PH_NUM() { return ASST_PH_NUM; }
        public void setASST_PH_NUM(String ASST_PH_NUM) { this.ASST_PH_NUM = ASST_PH_NUM; }

        public String getFAX_PH_NUM() { return FAX_PH_NUM; }
        public void setFAX_PH_NUM(String FAX_PH_NUM) { this.FAX_PH_NUM = FAX_PH_NUM; }

        public String getCALL_FREQUENCY() { return CALL_FREQUENCY; }
        public void setCALL_FREQUENCY(String CALL_FREQUENCY) { this.CALL_FREQUENCY = CALL_FREQUENCY; }

        public String getCREATOR_LOGIN() { return CREATOR_LOGIN; }
        public void setCREATOR_LOGIN(String CREATOR_LOGIN) { this.CREATOR_LOGIN = CREATOR_LOGIN; }

        public String getEMAIL_TYPE() { return EMAIL_TYPE; }
        public void setEMAIL_TYPE(String EMAIL_TYPE) { this.EMAIL_TYPE = EMAIL_TYPE; }

        public String getEMAIL_ADDR() { return EMAIL_ADDR; }
        public void setEMAIL_ADDR(String EMAIL_ADDR) { this.EMAIL_ADDR = EMAIL_ADDR; }

        public String getSITE_ADDR() { return SITE_ADDR; }
        public void setSITE_ADDR(String SITE_ADDR) { this.SITE_ADDR = SITE_ADDR; }

        public String getWHATSAPP_FLG() { return WHATSAPP_FLG; }
        public void setWHATSAPP_FLG(String WHATSAPP_FLG) { this.WHATSAPP_FLG = WHATSAPP_FLG; }

        public String getLOGIN() { return LOGIN; }
        public void setLOGIN(String LOGIN) { this.LOGIN = LOGIN; }

        public String getOCCUPATION() { return OCCUPATION; }
        public void setOCCUPATION(String OCCUPATION) { this.OCCUPATION = OCCUPATION; }

        public String getPASSWORD() { return PASSWORD; }
        public void setPASSWORD(String PASSWORD) { this.PASSWORD = PASSWORD; }

        public String getPR_CON_ADDR_ID() { return PR_CON_ADDR_ID; }
        public void setPR_CON_ADDR_ID(String PR_CON_ADDR_ID) { this.PR_CON_ADDR_ID = PR_CON_ADDR_ID; }

        public String getPR_EMAIL_ADDR_ID() { return PR_EMAIL_ADDR_ID; }
        public void setPR_EMAIL_ADDR_ID(String PR_EMAIL_ADDR_ID) { this.PR_EMAIL_ADDR_ID = PR_EMAIL_ADDR_ID; }

        public String getPR_ADDR_ID() { return PR_ADDR_ID; }
        public void setPR_ADDR_ID(String PR_ADDR_ID) { this.PR_ADDR_ID = PR_ADDR_ID; }

        public String getSTATUS_CD() { return STATUS_CD; }
        public void setSTATUS_CD(String STATUS_CD) { this.STATUS_CD = STATUS_CD; }
	
    }
    
    public class ContactXClass {
        private String row_id;
        private String created;
        private String created_by;
        private String updated;
        private String updated_by;
        private String modification_num;
        private String par_row_id;
        private String db_last_upd;
        private String PAR_ACCNT_ID;
        private String PAR_USR_ID;
        private String ACTIVE_FLG;
        private String DB_LAST_UPD;
        private String SOCIAL_M_NAME;
        private String SOCIAL_M_VALUE;
        private String STATUS_CD;

        public ContactXClass(){
            this.row_id = null;
            this.created = null;
            this.created_by = null;
            this.updated = null;
            this.updated_by = null;
            this.modification_num = null;
            this.par_row_id = null;
            this.db_last_upd = null;
            this.PAR_ACCNT_ID = null;
            this.PAR_USR_ID = null;
            this.ACTIVE_FLG = null;
            this.DB_LAST_UPD = null;
            this.SOCIAL_M_NAME = null;
            this.SOCIAL_M_VALUE = null;
            this.STATUS_CD = null;
        }
        
        public String getRow_id() { return row_id; }
        public void setRow_id(String row_id) { this.row_id = row_id; }

        public String getCreated() { return created; }
        public void setCreated(String created) { this.created = created; }

        public String getCreated_by() { return created_by; }
        public void setCreated_by(String created_by) { this.created_by = created_by; }

        public String getUpdated() { return updated; }
        public void setUpdated(String updated) { this.updated = updated; }

        public String getUpdated_by() { return updated_by; }
        public void setUpdated_by(String updated_by) { this.updated_by = updated_by; }

        public String getModification_num() { return modification_num; }
        public void setModification_num(String modification_num) { this.modification_num = modification_num; }

        public String getPar_row_id() { return par_row_id; }
        public void setPar_row_id(String par_row_id) { this.par_row_id = par_row_id; }

        public String getDb_last_upd() { return db_last_upd; }
        public void setDb_last_upd(String db_last_upd) { this.db_last_upd = db_last_upd; }

        public String getPAR_ACCNT_ID() { return PAR_ACCNT_ID; }
        public void setPAR_ACCNT_ID(String PAR_ACCNT_ID) { this.PAR_ACCNT_ID = PAR_ACCNT_ID; }

        public String getPAR_USR_ID() { return PAR_USR_ID; }
        public void setPAR_USR_ID(String PAR_USR_ID) { this.PAR_USR_ID = PAR_USR_ID; }

        public String getACTIVE_FLG() { return ACTIVE_FLG; }
        public void setACTIVE_FLG(String ACTIVE_FLG) { this.ACTIVE_FLG = ACTIVE_FLG; }

        public String getDB_LAST_UPD() { return DB_LAST_UPD; }
        public void setDB_LAST_UPD(String DB_LAST_UPD) { this.DB_LAST_UPD = DB_LAST_UPD; }

        public String getSOCIAL_M_NAME() { return SOCIAL_M_NAME; }
        public void setSOCIAL_M_NAME(String SOCIAL_M_NAME) { this.SOCIAL_M_NAME = SOCIAL_M_NAME; }

        public String getSOCIAL_M_VALUE() { return SOCIAL_M_VALUE; }
        public void setSOCIAL_M_VALUE(String SOCIAL_M_VALUE) { this.SOCIAL_M_VALUE = SOCIAL_M_VALUE; }

        public String getSTATUS_CD() { return STATUS_CD; }
        public void setSTATUS_CD(String STATUS_CD) { this.STATUS_CD = STATUS_CD; }

    }
    
    public class AddressClass {
        private String row_id;
        private String created;
        private String created_by;
        private String updated;
        private String updated_by;
        private String modification_num;
        private String par_row_id;
        private String db_last_upd;
        private String PAR_CON_ID;
        private String PAR_ADDR_ID;
        private String ACTIVE_FLG;
        private String PR_ADDR_FLG;
        private String ZIPCODE;
        private String ADDR_TYPE_CD;
        private String ADDR;
        private String ADDR_NUM;
        private String NEIGHBORHOOD;
        private String X_ZONA;
        private String CITY;
        private String STATE;
        private String NATIONALITY;
        private String COUNTRY;
        private String COUNTRY_CODE;
        private String COUNTRY_INITIAL;
        private String PROPERTY_TYPE_CD;
        private String ADDR_LINE_2;
        private String X_ANDAR;
        private String X_NUM_AP;
        private String X_COD_BLOCO;
        private String ADDR_NAME;
        private String COMMENTS;
                
        public AddressClass(){
            this.row_id = null;
            this.created = null;
            this.created_by = null;
            this.updated = null;
            this.updated_by = null;
            this.modification_num = null;
            this.par_row_id = null;
            this.db_last_upd = null;
            this.PAR_CON_ID = null;
            this.PAR_ADDR_ID = null;
            this.ACTIVE_FLG = null;
            this.PR_ADDR_FLG = null;
            this.ZIPCODE = null;
            this.ADDR_TYPE_CD = null;
            this.ADDR = null;
            this.ADDR_NUM = null;
            this.NEIGHBORHOOD = null;
            this.X_ZONA = null;
            this.CITY = null;
            this.STATE = null;
            this.NATIONALITY = null;
            this.COUNTRY = null;
            this.COUNTRY_CODE = null;
            this.COUNTRY_INITIAL = null;
            this.PROPERTY_TYPE_CD = null;
            this.ADDR_LINE_2 = null;
            this.X_ANDAR = null;
            this.X_NUM_AP = null;
            this.X_COD_BLOCO = null;
            this.ADDR_NAME = null;
            this.COMMENTS = null;
        }
        
        public String getRow_id() { return row_id; }
        public void setRow_id(String row_id) { this.row_id = row_id; }

        public String getCreated() { return created; }
        public void setCreated(String created) { this.created = created; }

        public String getCreated_by() { return created_by; }
        public void setCreated_by(String created_by) { this.created_by = created_by; }

        public String getUpdated() { return updated; }
        public void setUpdated(String updated) { this.updated = updated; }

        public String getUpdated_by() { return updated_by; }
        public void setUpdated_by(String updated_by) { this.updated_by = updated_by; }

        public String getModification_num() { return modification_num; }
        public void setModification_num(String modification_num) { this.modification_num = modification_num; }

        public String getPar_row_id() { return par_row_id; }
        public void setPar_row_id(String par_row_id) { this.par_row_id = par_row_id; }

        public String getDb_last_upd() { return db_last_upd; }
        public void setDb_last_upd(String db_last_upd) { this.db_last_upd = db_last_upd; }

        public String getPAR_CON_ID() { return PAR_CON_ID; }
        public void setPAR_CON_ID(String PAR_CON_ID) { this.PAR_CON_ID = PAR_CON_ID; }

        public String getPAR_ADDR_ID() { return PAR_ADDR_ID; }
        public void setPAR_ADDR_ID(String PAR_ADDR_ID) { this.PAR_ADDR_ID = PAR_ADDR_ID; }

        public String getACTIVE_FLG() { return ACTIVE_FLG; }
        public void setACTIVE_FLG(String ACTIVE_FLG) { this.ACTIVE_FLG = ACTIVE_FLG; }

        public String getPR_ADDR_FLG() { return PR_ADDR_FLG; }
        public void setPR_ADDR_FLG(String PR_ADDR_FLG) { this.PR_ADDR_FLG = PR_ADDR_FLG; }

        public String getZIPCODE() { return ZIPCODE; }
        public void setZIPCODE(String ZIPCODE) { this.ZIPCODE = ZIPCODE; }

        public String getADDR_TYPE_CD() { return ADDR_TYPE_CD; }
        public void setADDR_TYPE_CD(String ADDR_TYPE_CD) { this.ADDR_TYPE_CD = ADDR_TYPE_CD; }

        public String getADDR() { return ADDR; }
        public void setADDR(String ADDR) { this.ADDR = ADDR; }

        public String getADDR_NUM() { return ADDR_NUM; }
        public void setADDR_NUM(String ADDR_NUM) { this.ADDR_NUM = ADDR_NUM; }

        public String getNEIGHBORHOOD() { return NEIGHBORHOOD; }
        public void setNEIGHBORHOOD(String NEIGHBORHOOD) { this.NEIGHBORHOOD = NEIGHBORHOOD; }

        public String getX_ZONA() { return X_ZONA; }
        public void setX_ZONA(String X_ZONA) { this.X_ZONA = X_ZONA; }

        public String getCITY() { return CITY; }
        public void setCITY(String CITY) { this.CITY = CITY; }

        public String getSTATE() { return STATE; }
        public void setSTATE(String STATE) { this.STATE = STATE; }

        public String getNATIONALITY() { return NATIONALITY; }
        public void setNATIONALITY(String NATIONALITY) { this.NATIONALITY = NATIONALITY; }

        public String getCOUNTRY() { return COUNTRY; }
        public void setCOUNTRY(String COUNTRY) { this.COUNTRY = COUNTRY; }

        public String getCOUNTRY_CODE() { return COUNTRY_CODE; }
        public void setCOUNTRY_CODE(String COUNTRY_CODE) { this.COUNTRY_CODE = COUNTRY_CODE; }

        public String getCOUNTRY_INITIAL() { return COUNTRY_INITIAL; }
        public void setCOUNTRY_INITIAL(String COUNTRY_INITIAL) { this.COUNTRY_INITIAL = COUNTRY_INITIAL; }

        public String getPROPERTY_TYPE_CD() { return PROPERTY_TYPE_CD; }
        public void setPROPERTY_TYPE_CD(String PROPERTY_TYPE_CD) { this.PROPERTY_TYPE_CD = PROPERTY_TYPE_CD; }

        public String getADDR_LINE_2() { return ADDR_LINE_2; }
        public void setADDR_LINE_2(String ADDR_LINE_2) { this.ADDR_LINE_2 = ADDR_LINE_2; }

        public String getX_ANDAR() { return X_ANDAR; }
        public void setX_ANDAR(String X_ANDAR) { this.X_ANDAR = X_ANDAR; }

        public String getX_NUM_AP() { return X_NUM_AP; }
        public void setX_NUM_AP(String X_NUM_AP) { this.X_NUM_AP = X_NUM_AP; }

        public String getX_COD_BLOCO() { return X_COD_BLOCO; }
        public void setX_COD_BLOCO(String X_COD_BLOCO) { this.X_COD_BLOCO = X_COD_BLOCO; }

        public String getADDR_NAME() { return ADDR_NAME; }
        public void setADDR_NAME(String ADDR_NAME) { this.ADDR_NAME = ADDR_NAME; }

        public String getCOMMENTS() { return COMMENTS; }
        public void setCOMMENTS(String COMMENTS) { this.COMMENTS = COMMENTS; }

    }
    
    public class ValidationMessageClass {
        private String row_id;
        private String created;
        private String created_by;
        private String updated;
        private String updated_by;
        private String modification_num;
        private String par_row_id;
        private String db_last_upd;
        private String MSG_LVL_CD;
        private String MSG_SRC_TYPE_CD;
        private String MSG_TYPE_CD;
        private String MSG_TEXT;
        private String DESC_TEXT;

        public ValidationMessageClass(){
            this.row_id = null;
            this.created = null;
            this.created_by = null;
            this.updated = null;
            this.updated_by = null;
            this.modification_num = null;
            this.par_row_id = null;
            this.db_last_upd = null;
            this.MSG_LVL_CD = null;
            this.MSG_SRC_TYPE_CD = null;
            this.MSG_TYPE_CD = null;
            this.MSG_TEXT = null;
            this.DESC_TEXT = null;
        }
        
        public String getRow_id() { return row_id; }
        public void setRow_id(String row_id) { this.row_id = row_id; }

        public String getCreated() { return created; }
        public void setCreated(String created) { this.created = created; }

        public String getCreated_by() { return created_by; }
        public void setCreated_by(String created_by) { this.created_by = created_by; }

        public String getUpdated() { return updated; }
        public void setUpdated(String updated) { this.updated = updated; }

        public String getUpdated_by() { return updated_by; }
        public void setUpdated_by(String updated_by) { this.updated_by = updated_by; }

        public String getModification_num() { return modification_num; }
        public void setModification_num(String modification_num) { this.modification_num = modification_num; }

        public String getPar_row_id() { return par_row_id; }
        public void setPar_row_id(String par_row_id) { this.par_row_id = par_row_id; }

        public String getDb_last_upd() { return db_last_upd; }
        public void setDb_last_upd(String db_last_upd) { this.db_last_upd = db_last_upd; }

        public String getMSG_LVL_CD() { return MSG_LVL_CD; }
        public void setMSG_LVL_CD(String MSG_LVL_CD) { this.MSG_LVL_CD = MSG_LVL_CD; }

        public String getMSG_SRC_TYPE_CD() { return MSG_SRC_TYPE_CD; }
        public void setMSG_SRC_TYPE_CD(String MSG_SRC_TYPE_CD) { this.MSG_SRC_TYPE_CD = MSG_SRC_TYPE_CD; }

        public String getMSG_TYPE_CD() { return MSG_TYPE_CD; }
        public void setMSG_TYPE_CD(String MSG_TYPE_CD) { this.MSG_TYPE_CD = MSG_TYPE_CD; }

        public String getMSG_TEXT() { return MSG_TEXT; }
        public void setMSG_TEXT(String MSG_TEXT) { this.MSG_TEXT = MSG_TEXT; }

        public String getDESC_TEXT() { return DESC_TEXT; }
        public void setDESC_TEXT(String DESC_TEXT) { this.DESC_TEXT = DESC_TEXT; }

    }
    
}