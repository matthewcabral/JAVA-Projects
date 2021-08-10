/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseModule;

import java.awt.HeadlessException;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
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
import javax.swing.JOptionPane;
import settingsModule.DbSettingsController;

/**
 *
 * @author Matheus Cabral Rosa
 */
public abstract class DataController extends Controller{
    EncryptDecryptWord encryptDecrypt;
    DbSettingsController dbSetCtrl;
        
    // Empty Constructor
    public DataController() throws InterruptedException {
        dbSetCtrl = new DbSettingsController();
        encryptDecrypt = new EncryptDecryptWord();
        this.readParameters();
    }
    
    @Override
    public String openConnection(String message){
        try {
            Class.forName(super.getDbDriver());
        } catch (ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, super.exc.getDbODBCEx() + "\n" + super.exc.getMsgReturn() + e, "Erro", JOptionPane.ERROR_MESSAGE);
        }
        try {
            super.conn = DriverManager.getConnection(super.getDbURL(), super.getDbUser(), super.getDbPassword());
            System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "OpenConnection" + "\t\t" + "ObjMgrSqlLog" + "\t" + "Oracle JDBC Driver Registered. Connected Successfuly" + "\t\t" + message);
            return "true";
        } catch(SQLException e) {
            if(!"Realizando Login".equals(message)){
                if(e.toString().contains("java.sql.SQLRecoverableException: IO Error: The Network Adapter could not establish the connection\n")){
                    JOptionPane.showMessageDialog(null, "Erro ao tentar realizar conexão com o Banco de dados. Verifique se o listener está ativo.","Erro",JOptionPane.ERROR_MESSAGE);
                    System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "OpenConnection" + "\t\t" + "ObjMgrSqlLog" + "\t" + "Error" + "\t" + "Erro ao tentar realizar conexão com o Banco de dados. Verifique se o listener está ativo.");
                } else if(e.toString().contains("ORA-12505: TNS: listener does not currently know of SID given in connect descriptor tips\n")){
                    JOptionPane.showMessageDialog(null, "O Listener não identificou o SID utilizado no descritor de conexão.","Erro",JOptionPane.ERROR_MESSAGE);
                    System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "OpenConnection" + "\t\t" + "ObjMgrSqlLog" + "\t" + "Error" + "\t" + "O Listener não identificou o SID utilizado no descritor de conexão.");
                } else if(e.toString().contains("CommunicationsException")){
                    JOptionPane.showMessageDialog(null, "Erro ao tentar realizar conexão com o Banco de dados. Não foi possível conectar-se ao servidor.","Erro",JOptionPane.ERROR_MESSAGE);
                    System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "OpenConnection" + "\t\t" + "ObjMgrSqlLog" + "\t" + "Error" + "\t" + "Erro ao tentar realizar conexão com o Banco de dados. Não foi possível conectar-se ao servidor.");
                } else if(e.toString().contains("ORA-12505, TNS:listener does not currently know of SID given in connect descriptor\n")){
                    JOptionPane.showMessageDialog(null, "O Listener não identificou o SID utilizado no descritor de conexão.","Erro",JOptionPane.ERROR_MESSAGE);
                    System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "OpenConnection" + "\t\t" + "ObjMgrSqlLog" + "\t" + "Error" + "\t" + "O Listener não identificou o SID utilizado no descritor de conexão.");
                } else if(e.toString().contains("java.sql.SQLException: ORA-01017: invalid username/password; logon denied\n") || e.toString().contains("Access denied for user")){
                    JOptionPane.showMessageDialog(null, "Nome de usuário/senha incorreto. Tente novamente.","Erro",JOptionPane.ERROR_MESSAGE);
                    System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "OpenConnection" + "\t\t" + "ObjMgrSqlLog" + "\t" + "Error" + "\t" + "Nome de usuário/senha incorreto. Tente novamente.");
                } else if(e.toString().contains("java.sql.SQLRecoverableException: Erro de ES: Unknown host specified ")){
                    JOptionPane.showMessageDialog(null, "Erro ao tentar realizar conexão com o Banco de dados. Verifique o Host.","Erro",JOptionPane.ERROR_MESSAGE);
                    System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "OpenConnection" + "\t\t" + "ObjMgrSqlLog" + "\t" + "Error" + "\t" + "Erro ao tentar realizar conexão com o Banco de dados. Verifique o Host.");
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco de dados!\n" + e,"Erro",JOptionPane.ERROR_MESSAGE);
                    System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "OpenConnection" + "\t\t" + "ObjMgrSqlLog" + "\t" + "Error" + "\t" + "Erro ao conectar com o banco de dados! Erro: " + e);
                }
            }            
            return e.toString();
        }
    }
    
    @Override
    public String closeConnection(String message){
        try {
            Class.forName(super.getDbDriver());
        } catch (ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, super.exc.getDbODBCEx()+ "\n" + super.exc.getMsgReturn() + e,"Erro",JOptionPane.ERROR_MESSAGE);
        }
        try {
            conn.close();
            System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "CloseConnection" + "\t\t" + "ObjMgrSqlLog" + "\t" + "Oracle JDBC Driver Registered. Disconnected Successfuly" + "\t\t" + message + "\n");
            return "true";
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, super.exc.getDbDisconnectEx() + "\n" + super.exc.getMsgReturn() + e,"Erro",JOptionPane.ERROR_MESSAGE);
            return "false";
        }
    }    

    public boolean readParameters() {
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "ReadParameters" + "\t\t" + "ObjMgrBufReaderLog" + "\t\t" + "BEGIN: Carregando Parametros do Banco de Dados");
        File file = new File(super.getConfFile());
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "ReadParameters" + "\t\t" + "ObjMgrBufReaderLog" + "\t\t" + "Verificando a existência do arquivo: '" + super.getConfFile() + "'");
        if(file.exists()) {
            System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "ReadParameters" + "\t\t" + "ObjMgrBufReaderLog" + "\t\t" + "Arquivo encontrado");
            try {
                int i = 0;
                BufferedReader br = new BufferedReader(new FileReader(super.getConfFile()));
                String line;
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "ReadParameters" + "\t\t" + "ObjMgrBufReaderLog" + "\t\t" + "Carregando os parametros do arquivo em memória");
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
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "ReadParameters" + "\t\t" + "ObjMgrBufReaderLog" + "\t\t" + "Parametros:");
                System.out.println("DriverName: " + getDbDriverName());
                System.out.println("Driver: " + getDbDriver());
                System.out.println("URL: " + getDbURL());
                System.out.println("Local: " + getDbLocal());
                System.out.println("Porta: " + getDbPort());
                System.out.println("Nome do Banco: " + getDbName());
                System.out.println("Owner: " + getDbOwner());
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "ReadParameters" + "\t\t" + "ObjMgrBufReaderLog" + "\t\t" + "END: Parametros carregados com sucesso");
                br.close();
                return true;
                
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "O arquivo não foi encontrado, verifique se o mesmo existe ou está correto.", "Erro", JOptionPane.ERROR_MESSAGE);
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "ReadParameters" + "\t\t" + "ObjMgrBufReaderLog" + "\t\t" + "END: O arquivo não foi encontrado, verifique se o mesmo existe ou está correto");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Erro ao Carregar parâmetros do Banco de Dados", "Erro", JOptionPane.ERROR_MESSAGE);
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "ReadParameters" + "\t\t" + "ObjMgrBufReaderLog" + "\t\t" + "END: Erro ao Carregar parâmetros do Banco de Dados. Erro: " + e);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao Carregar parâmetros do Banco de Dados", "Erro", JOptionPane.ERROR_MESSAGE);
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "ReadParameters" + "\t\t" + "ObjMgrBufReaderLog" + "\t\t" + "END: Erro ao Carregar parâmetros do Banco de Dados. Erro: " + e);
            }
        } else {
            //JOptionPane.showMessageDialog(null, "Erro ao Carregar parâmetros do Banco de Dados", "Erro", JOptionPane.ERROR_MESSAGE);
            System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "ReadParameters" + "\t\t" + "ObjMgrBufReaderLog" + "\t\t" + "END: Erro ao Carregar parâmetros do Banco de Dados");
        }
        if(wishConfDbLScreen()){
            dbSetCtrl.openDbSettingsScreen();
            dbSetCtrl.setListenerDBSettingsScreen(new dbSettingsScreenListener());
        }
        return false;
    }
    
    public boolean wishConfDbLScreen() {
        String[] options = {"Sim", "Não"};
        int x = JOptionPane.showOptionDialog(null, "Os arquivo de configuração do banco de dados não está correto, deseja realizar a configuração?", "Erro", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]);
        if(x == 0){
            return true;
        } else {
            return false;
        }
    }
    
    public boolean wishDeleteRecord() {
        if(JOptionPane.showConfirmDialog(null, "Tem certeza que deseja Excluir o registro?","Atenção",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION){
            return true;
        } else {
            return false;
        }
    }
    
    public boolean wishSaveRecord(){
        if(JOptionPane.showConfirmDialog(null, "Existem registros não salvos. Deseja salvá-los agora?","Atenção",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION){
            return true;
        } else {
            return false;
        }
    }
    
    public String convertSpecialCharacter(String string){
        String stringProcessed = "";
        
        for (int i = 0; i < string.length(); i++) {
            switch(string.substring(i, i + 1)) {
                case "*":
                    stringProcessed += "%";
                    break;
                case "?":
                    stringProcessed += "_";
                    break;
                default:
                    stringProcessed += string.substring(i, i + 1);
                    break;
            }
        }
        
        return stringProcessed;        
    }
    
    public String convertReservedWords(String string) {
        String stringProcessed = "";
        String stringToUpperCase = string.toUpperCase();
        
        for (int i = 0; i < string.length(); i++) {
            if(string.length() >= (i + 7)) {
                switch(stringToUpperCase.substring(i, i + 7)) {
                    case "TODAY()":
                        if(super.getDbDriver().toUpperCase().contains("ORACLE")) {
                            stringProcessed += "SYSDATE";
                        } else if (super.getDbDriver().toUpperCase().contains("MYSQL")) {
                            stringProcessed += "SYSDATE()";
                        } else {
                            stringProcessed += "SYSDATE";
                        }                        
                        i += 6;
                        break;
                    default:
                        stringProcessed += string.substring(i, i + 1);
                        break;
                }
            } else {
                stringProcessed += string.substring(i, i + 1);
            }
        }
        
        return stringProcessed;
        
    }
    
    public String processFilterCondition(String filterColumn, String filterValue, String lovType, String tblAlias){
        String condition = "";
        int posChrOR = 0;           // OR
        int posChrAND = 0;          // AND
        int posChrGreaterThen = 0;  // >=
        int posChrLessThen = 0;     // <=
        boolean loop = true;
        String filterValueUpper = filterValue.toUpperCase();

        filterValue = this.convertSpecialCharacter(filterValue);
        filterValue = this.convertReservedWords(filterValue);
        filterValueUpper = filterValue.toUpperCase();

        while(loop) {
            posChrOR = filterValueUpper.indexOf(" OR ");
            posChrAND = filterValueUpper.indexOf(" AND ");
            posChrGreaterThen = filterValueUpper.indexOf(">=");
            posChrLessThen = filterValueUpper.indexOf("<=");

            if (((posChrOR != 0 && posChrOR != -1) && (posChrOR < posChrAND)) || ((posChrOR != 0 && posChrOR != -1) && (posChrAND < 1))) {
                if ("IS NULL".equals(filterValueUpper.substring(0, posChrOR)) || "IS NOT NULL".equals(filterValueUpper.substring(0, posChrOR))) {
                    if ("IS NULL".equals(filterValueUpper.substring(0, posChrOR))) {
                        condition += tblAlias + "." + this.LookupName(lovType, filterColumn) + " IS NULL\nOR ";
                    } else {
                        condition += tblAlias + "." + this.LookupName(lovType, filterColumn) + " IS NOT NULL\nOR ";
                    }
                } else if (filterValueUpper.substring(0, posChrOR).contains(">=") || filterValueUpper.substring(0, posChrOR).contains("<=") || filterValueUpper.substring(0, posChrOR).contains("<>")) {
                    if (filterValueUpper.substring(0, posChrOR).contains(">=")) {
                        try {
                            Integer.valueOf(filterValueUpper.substring(posChrGreaterThen + 3, posChrOR));
                            condition += tblAlias + "." + this.LookupName(lovType, filterColumn) + " >= " + filterValue.substring(posChrGreaterThen + 3, posChrOR) + "\nOR ";
                        } catch (NumberFormatException e) {
                            if(filterValueUpper.substring(posChrGreaterThen + 3, posChrOR).contains("SYSDATE")){
                                condition += tblAlias + "." + this.LookupName(lovType, filterColumn) + " >= " + filterValue.substring(posChrGreaterThen + 3, posChrOR) + "\nOR ";
                            } else {
                                condition += tblAlias + "." + this.LookupName(lovType, filterColumn) + " >= '" + filterValue.substring(posChrGreaterThen + 3, posChrOR) + "'\nOR ";
                            }
                        }
                    } else if (filterValueUpper.substring(0, posChrOR).contains("<=")) {
                        try {
                            Integer.valueOf(filterValueUpper.substring(posChrLessThen + 3, posChrOR));
                            condition += tblAlias + "." + this.LookupName(lovType, filterColumn) + " <= " + filterValue.substring(posChrLessThen + 3, posChrOR) + "\nOR ";
                        } catch (NumberFormatException e) {
                            if(filterValueUpper.substring(posChrLessThen + 3, posChrOR).contains("SYSDATE")){
                                condition += tblAlias + "." + this.LookupName(lovType, filterColumn) + " <= " + filterValue.substring(posChrLessThen + 3, posChrOR) + "\nOR ";
                            } else {
                                condition += tblAlias + "." + this.LookupName(lovType, filterColumn) + " <= '" + filterValue.substring(posChrLessThen + 3, posChrOR) + "'\nOR ";
                            }
                        }
                    } else {
                        try {
                            Integer.valueOf(filterValueUpper.substring(posChrLessThen + 3, posChrOR));
                            condition += tblAlias + "." + this.LookupName(lovType, filterColumn) + " <> " + filterValue.substring(posChrLessThen + 3, posChrOR) + "\nOR ";
                        } catch (NumberFormatException e) {
                            if(filterValueUpper.substring(posChrLessThen + 3, posChrOR).contains("SYSDATE")){
                                condition += tblAlias + "." + this.LookupName(lovType, filterColumn) + " <> " + filterValue.substring(posChrLessThen + 3, posChrOR) + "\nOR ";
                            } else {
                                condition += tblAlias + "." + this.LookupName(lovType, filterColumn) + " <> '" + filterValue.substring(posChrLessThen + 3, posChrOR) + "'\nOR ";
                            }
                        }
                    }
                } else {
                    if (filterValueUpper.substring(0, posChrOR).contains("%") || filterValueUpper.substring(0, posChrOR).contains("_")) {
                        if("CRIADO POR".equals(filterColumn.toUpperCase()) || "ATUALIZADO POR".equals(filterColumn.toUpperCase())) {
                            condition += tblAlias + "." + this.LookupName(lovType, filterColumn) + " LIKE '" + this.getUserIdByLogin(filterValue.substring(0, posChrOR)) + "'\nOR ";
                        } else {
                            condition += tblAlias + "." + this.LookupName(lovType, filterColumn) + " LIKE '" + filterValue.substring(0, posChrOR) + "'\nOR ";
                        }
                    } else {
                        try {
                            Integer.valueOf(filterValue.substring(0, posChrOR));
                            condition += tblAlias + "." + this.LookupName(lovType, filterColumn) + " = " + filterValue.substring(0, posChrOR) + "\nOR ";
                        } catch (NumberFormatException e) {
                            if("CRIADO POR".equals(filterColumn.toUpperCase()) || "ATUALIZADO POR".equals(filterColumn.toUpperCase())) {
                                condition += tblAlias + "." + this.LookupName(lovType, filterColumn) + " = '" + this.getUserIdByLogin(filterValue.substring(0, posChrOR)) + "'\nOR ";
                            } else {
                                if(filterValueUpper.substring(0, posChrOR).contains("SYSDATE")){
                                    condition += tblAlias + "." + this.LookupName(lovType, filterColumn) + " = " + filterValue.substring(0, posChrOR) + "\nOR ";
                                } else {
                                    condition += tblAlias + "." + this.LookupName(lovType, filterColumn) + " = '" + filterValue.substring(0, posChrOR) + "'\nOR ";
                                }
                            }
                        }
                    }
                }
                filterValue = filterValue.substring(posChrOR + 4, filterValue.length());
                filterValueUpper = filterValueUpper.substring(posChrOR + 4, filterValueUpper.length());

                loop = true;
            } else if (posChrAND != 0 && posChrAND != -1) {
                if ("IS NULL".equals(filterValueUpper.substring(0, posChrAND)) || "IS NOT NULL".equals(filterValueUpper.substring(0, posChrAND))) {
                    if ("IS NULL".equals(filterValueUpper.substring(0, posChrAND))) {
                        condition += tblAlias + "." + this.LookupName(lovType, filterColumn) + " IS NULL\nAND ";
                    } else {
                        condition += tblAlias + "." + this.LookupName(lovType, filterColumn) + " IS NOT NULL\nAND ";
                    }
                } else if (filterValueUpper.substring(0, posChrAND).contains(">=") || filterValueUpper.substring(0, posChrAND).contains("<=") || filterValueUpper.substring(0, posChrAND).contains("<>")) {
                    if (filterValueUpper.substring(0, posChrAND).contains(">=")) {
                        try {
                            Integer.valueOf(filterValueUpper.substring(posChrGreaterThen + 3, posChrAND));
                            condition += tblAlias + "." + this.LookupName(lovType, filterColumn) + " >= " + filterValue.substring(posChrGreaterThen + 3, posChrAND) + "\nAND ";
                        } catch (NumberFormatException e) {
                            if(filterValueUpper.substring(posChrGreaterThen + 3, posChrAND).contains("SYSDATE")){
                                condition += tblAlias + "." + this.LookupName(lovType, filterColumn) + " >= " + filterValue.substring(posChrGreaterThen + 3, posChrAND) + "\nAND ";
                            } else {
                                condition += tblAlias + "." + this.LookupName(lovType, filterColumn) + " >= '" + filterValue.substring(posChrGreaterThen + 3, posChrAND) + "'\nAND ";
                            }
                        }
                    } else if (filterValueUpper.substring(0, posChrAND).contains("<=")) {
                        try {
                            Integer.valueOf(filterValueUpper.substring(posChrLessThen + 3, posChrAND));
                            condition += tblAlias + "." + this.LookupName(lovType, filterColumn) + " <= " + filterValue.substring(posChrLessThen + 3, posChrAND) + "\nAND ";
                        } catch (NumberFormatException e) {
                            if(filterValueUpper.substring(posChrLessThen + 3, posChrAND).contains("SYSDATE")){
                                condition += tblAlias + "." + this.LookupName(lovType, filterColumn) + " <= " + filterValue.substring(posChrLessThen + 3, posChrAND) + "\nAND ";
                            } else {
                                condition += tblAlias + "." + this.LookupName(lovType, filterColumn) + " <= '" + filterValue.substring(posChrLessThen + 3, posChrAND) + "'\nAND ";
                            }
                        }
                    } else {
                        try {
                            Integer.valueOf(filterValueUpper.substring(posChrLessThen + 3, posChrAND));
                            condition += tblAlias + "." + this.LookupName(lovType, filterColumn) + " <> " + filterValue.substring(posChrLessThen + 3, posChrAND) + "\nAND ";
                        } catch (NumberFormatException e) {
                            if(filterValueUpper.substring(posChrLessThen + 3, posChrAND).contains("SYSDATE")){
                                condition += tblAlias + "." + this.LookupName(lovType, filterColumn) + " <> " + filterValue.substring(posChrLessThen + 3, posChrAND) + "\nAND ";
                            } else {
                                condition += tblAlias + "." + this.LookupName(lovType, filterColumn) + " <> '" + filterValue.substring(posChrLessThen + 3, posChrAND) + "'\nAND ";
                            }
                        }
                    }
                } else {
                    if (filterValueUpper.substring(0, posChrAND).contains("%") || filterValueUpper.substring(0, posChrAND).contains("_")) {
                        if("CRIADO POR".equals(filterColumn.toUpperCase()) || "ATUALIZADO POR".equals(filterColumn.toUpperCase())) {
                            condition += tblAlias + "." + this.LookupName(lovType, filterColumn) + " LIKE '" + this.getUserIdByLogin(filterValue.substring(0, posChrAND)) + "'\nAND ";
                        } else {
                            condition += tblAlias + "." + this.LookupName(lovType, filterColumn) + " LIKE '" + filterValue.substring(0, posChrAND) + "'\nAND ";
                        }
                    } else {
                        try {
                            Integer.valueOf(filterValue.substring(0, posChrAND));
                            condition += tblAlias + "." + this.LookupName(lovType, filterColumn) + " = " + filterValue.substring(0, posChrAND) + "\nAND ";
                        } catch (NumberFormatException e) {
                            if("CRIADO POR".equals(filterColumn.toUpperCase()) || "ATUALIZADO POR".equals(filterColumn.toUpperCase())) {
                                condition += tblAlias + "." + this.LookupName(lovType, filterColumn) + " = '" + this.getUserIdByLogin(filterValue.substring(0, posChrAND)) + "'\nAND ";
                            } else {
                                if(filterValueUpper.substring(0, posChrAND).contains("SYSDATE")){
                                    condition += tblAlias + "." + this.LookupName(lovType, filterColumn) + " = " + filterValue.substring(0, posChrAND) + "\nAND ";
                                } else {
                                    condition += tblAlias + "." + this.LookupName(lovType, filterColumn) + " = '" + filterValue.substring(0, posChrAND) + "'\nAND ";
                                }                                    
                            }
                        }
                    }
                }
                filterValue = filterValue.substring(posChrAND + 5, filterValue.length());
                filterValueUpper = filterValueUpper.substring(posChrAND + 5, filterValueUpper.length());

                loop = true;
            } else {
                if ("IS NULL".equals(filterValueUpper) || "IS NOT NULL".equals(filterValueUpper)) {
                    if ("IS NULL".equals(filterValueUpper)) {
                        condition += tblAlias + "." + this.LookupName(lovType, filterColumn) + " IS NULL\n";
                    } else {
                        condition += tblAlias + "." + this.LookupName(lovType, filterColumn) + " IS NOT NULL\n";
                    }
                } else if (filterValueUpper.contains(">=") || filterValueUpper.contains("<=") || filterValueUpper.contains("<>")) {
                    if (filterValueUpper.contains(">=")) {
                        try {
                            Integer.valueOf(filterValueUpper.substring(posChrGreaterThen + 3, filterValueUpper.length()));
                            condition += tblAlias + "." + this.LookupName(lovType, filterColumn) + " >= " + filterValue.substring(posChrGreaterThen + 3, filterValueUpper.length()) + "\n";
                        } catch (NumberFormatException e) {
                            if(filterValueUpper.substring(posChrGreaterThen + 3, filterValueUpper.length()).contains("SYSDATE")){
                                condition += tblAlias + "." + this.LookupName(lovType, filterColumn) + " >= " + filterValue.substring(posChrGreaterThen + 3, filterValueUpper.length()) + "\n";
                            } else {
                                condition += tblAlias + "." + this.LookupName(lovType, filterColumn) + " >= '" + filterValue.substring(posChrGreaterThen + 3, filterValueUpper.length()) + "'\n";
                            }
                        }
                    } else if (filterValueUpper.contains("<=")) {
                        try {
                            Integer.valueOf(filterValueUpper.substring(posChrLessThen + 3, filterValueUpper.length()));
                            condition += tblAlias + "." + this.LookupName(lovType, filterColumn) + " <= " + filterValue.substring(posChrLessThen + 3, filterValueUpper.length()) + "\n";
                        } catch (NumberFormatException e) {
                            if(filterValueUpper.substring(posChrLessThen + 3, filterValueUpper.length()).contains("SYSDATE")){
                                condition += tblAlias + "." + this.LookupName(lovType, filterColumn) + " <= " + filterValue.substring(posChrLessThen + 3, filterValueUpper.length()) + "\n";
                            } else {
                                condition += tblAlias + "." + this.LookupName(lovType, filterColumn) + " <= '" + filterValue.substring(posChrLessThen + 3, filterValueUpper.length()) + "'\n";
                            }
                        }
                    } else {
                        try {
                            Integer.valueOf(filterValueUpper.substring(posChrLessThen + 3, filterValueUpper.length()));
                            condition += tblAlias + "." + this.LookupName(lovType, filterColumn) + " <> " + filterValue.substring(posChrLessThen + 3, filterValueUpper.length()) + "\n";
                        } catch (NumberFormatException e) {
                            if(filterValueUpper.substring(posChrLessThen + 3, filterValueUpper.length()).contains("SYSDATE")){
                                condition += tblAlias + "." + this.LookupName(lovType, filterColumn) + " <> " + filterValue.substring(posChrLessThen + 3, filterValueUpper.length()) + "\n";
                            } else {
                                condition += tblAlias + "." + this.LookupName(lovType, filterColumn) + " <> '" + filterValue.substring(posChrLessThen + 3, filterValueUpper.length()) + "'\n";
                            }
                        }
                    }
                } else {
                    if (filterValueUpper.contains("%") || filterValueUpper.contains("_")) {
                        if("CRIADO POR".equals(filterColumn.toUpperCase()) || "ATUALIZADO POR".equals(filterColumn.toUpperCase())) {
                            condition += tblAlias + "." + this.LookupName(lovType, filterColumn) + " LIKE '" + this.getUserIdByLogin(filterValue.substring(0, filterValueUpper.length())) + "'\n";
                        } else {
                            condition += tblAlias + "." + this.LookupName(lovType, filterColumn) + " LIKE '" + filterValue.substring(0, filterValueUpper.length()) + "'\n";
                        }
                    } else {
                        try {
                            Integer.valueOf(filterValue.substring(0, filterValueUpper.length()));
                            condition += tblAlias + "." + this.LookupName(lovType, filterColumn) + " = '" + filterValue.substring(0, filterValueUpper.length()) + "'\n";
                        } catch (NumberFormatException e) {
                            if("CRIADO POR".equals(filterColumn.toUpperCase()) || "ATUALIZADO POR".equals(filterColumn.toUpperCase())) {
                                condition += tblAlias + "." + this.LookupName(lovType, filterColumn) + " = '" + this.getUserIdByLogin(filterValue.substring(0, filterValueUpper.length())) + "'\n";
                            } else {
                                if(filterValueUpper.substring(0, filterValueUpper.length()).contains("SYSDATE")){
                                    condition += tblAlias + "." + this.LookupName(lovType, filterColumn) + " = " + filterValue.substring(0, filterValueUpper.length()) + "\n";
                                } else {
                                    condition += tblAlias + "." + this.LookupName(lovType, filterColumn) + " = '" + filterValue.substring(0, filterValueUpper.length()) + "'\n";
                                }
                            }
                        }
                    }
                }
                loop = false;
            }
            posChrOR = 0;
            posChrAND = 0;
            posChrGreaterThen = 0;
            posChrLessThen = 0;
        }

        return condition;
        
    }
        
    @Override
    public String createUser(String sqlCommand, String user) {
        long tempoInicial = 0;
        long tempoFinal = 0;
        long tempoExec = 0;
        
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "InsertRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "Execute" + "\t" + "BEGIN: Preparando a instrução INSERT para inserir dados na tabela");
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "InsertRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "Execute" + "\t" + "Owner: " + super.getDbOwner());
        try{
            if("true".equals(openConnection("Inserindo registro(s)"))){
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "InsertRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "Execute" + "\t" + "Criando Statement INSERT");
                
                statement = conn.createStatement();
                tempoInicial = System.currentTimeMillis();
                statement.execute(sqlCommand);
                tempoFinal = System.currentTimeMillis();
                tempoExec = tempoFinal - tempoInicial;
                
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "InsertRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instruções:\n" + sqlCommand);
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "InsertRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "Execute" + "\n" + "***** Início da execução da instrução: " + (tempoInicial / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "InsertRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "Execute" + "\n" + "***** Fim da execução da instrução: " + (tempoFinal / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "InsertRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "Execute" + "\n" + "***** Tempo total da execução da instrução: " + (tempoExec / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "InsertRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "Execute" + "\t" + "END: Instrução INSERT para inserir dados na tabela finalizada");
                
                closeConnection("Registro inserido com sucesso...");
                //JOptionPane.showMessageDialog(null, "Registro inserido com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao executar comandos no banco de dados!");
            }
            return "true";
        } catch (HeadlessException | SQLException e){
            System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "InsertRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instruções:\n" + sqlCommand);
            System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "InsertRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "Error Exception" + "\t" + "Error: " + e);
            JOptionPane.showMessageDialog(null, "Erro ao inserir registros no banco de dados!\nErro: " + e);
            return "false";
        }
    }
    
    @Override
    public void generateRowIdTrigger() {
        int V_PREFIX = 0;
        int V_SUFFIX = 0;
        int V_MODIFICATION_NUM = 0;
        String V_NEXT_ID = "";
        int count = 0;
        long tempoInicial = 0;
        long tempoFinal = 0;
        long tempoExec = 0;
        
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryTableCount" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "BEGIN: Preparando a instrução SELECT para buscar dados na tabela");
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryTableCount" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Owner: " + super.getDbOwner());
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryTableCount" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Tabela: " + super.getTblSSAId() );
        
        try{
            if("true".equals(openConnection("Trigger proximo RowId"))){
                super.statement = super.conn.createStatement();
                tempoInicial = System.currentTimeMillis();
                ResultSet rs = super.statement.executeQuery("SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblSSAId());
                
                while(rs.next()){
                    V_PREFIX = rs.getInt("P_PREFIX");
                    V_SUFFIX = rs.getInt("P_SUFFIX");
                    V_MODIFICATION_NUM = rs.getInt("MODIFICATION_NUM");
                    V_NEXT_ID = rs.getString("P_NEXT_ID");
                    count++;
                }
                
                tempoFinal = System.currentTimeMillis();
                tempoExec = tempoFinal - tempoInicial;
                
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryTableCount" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instrução SELECT:" + "\n" + "SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblSSAId());
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryTableCount" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Início da execução da instrução: " + (tempoInicial / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryTableCount" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Fim da execução da instrução: " + (tempoFinal / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryTableCount" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Tempo total da execução da instrução: " + (tempoExec / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryTableCount" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Total de registros encontrados: " + count);
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryTableCount" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "END: Instrução SELECT para selecionar dados na tabela finalizada");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryTableCount" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Prefix Atual: " + V_PREFIX);
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryTableCount" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Suffix Atual: " + V_SUFFIX);
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryTableCount" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Id Atual: " + V_NEXT_ID);
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryTableCount" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Calculando o próximo Id");
                
                rs.close();
                closeConnection("Dados de Usuários retornados com sucesso...");
                
                switch(String.valueOf(V_SUFFIX).length()){
                    case 1:
                        if(V_SUFFIX == 0) {
                            V_SUFFIX++;
                            V_NEXT_ID = String.valueOf(V_PREFIX) + "-0000" + String.valueOf(V_SUFFIX);
                        } else if(V_SUFFIX < 9) {
                            V_SUFFIX++;
                            V_NEXT_ID = String.valueOf(V_PREFIX) + "-0000" + String.valueOf(V_SUFFIX);
                        } else {
                            V_SUFFIX += 1;
                            V_NEXT_ID = String.valueOf(V_PREFIX) + "-000" + String.valueOf(V_SUFFIX);
                        }
                        break;
                    case 2:
                        if(V_SUFFIX < 99) {
                            V_SUFFIX++;
                            V_NEXT_ID = String.valueOf(V_PREFIX) + "-000" + String.valueOf(V_SUFFIX);
                        } else {
                            V_SUFFIX++;
                            V_NEXT_ID = String.valueOf(V_PREFIX) + "-00" + String.valueOf(V_SUFFIX);
                        }
                        break;
                    case 3:
                        if(V_SUFFIX < 999) {
                            V_SUFFIX++;
                            V_NEXT_ID = String.valueOf(V_PREFIX) + "-00" + String.valueOf(V_SUFFIX);
                        } else {
                            V_SUFFIX++;
                            V_NEXT_ID = String.valueOf(V_PREFIX) + "-0" + String.valueOf(V_SUFFIX);
                        }
                        break;
                    case 4:
                        if(V_SUFFIX < 9999) {
                            V_SUFFIX++;
                            V_NEXT_ID = String.valueOf(V_PREFIX) + "-0" + String.valueOf(V_SUFFIX);
                        } else {
                            V_SUFFIX++;
                            V_NEXT_ID = String.valueOf(V_PREFIX) + "-" + String.valueOf(V_SUFFIX);
                        }
                        break;
                    default:
                        if(V_SUFFIX < 99999) {
                            V_SUFFIX++;
                            V_NEXT_ID = String.valueOf(V_PREFIX) + "-" + String.valueOf(V_SUFFIX);
                        } else {
                            V_PREFIX++;
                            V_SUFFIX = 0;
                            V_NEXT_ID = String.valueOf(V_PREFIX) + "-0000" + String.valueOf(V_SUFFIX);
                        }
                        break;
                }
                
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryTableCount" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Novo Prefix: " + V_PREFIX);
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryTableCount" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Novo Suffix: " + V_SUFFIX);
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryTableCount" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Novo Id: " + V_NEXT_ID);

                super.clearColumnsValues();
                super.clearCondition();

                super.setColumnsValues(",\n\t" + "P_PREFIX = " + V_PREFIX);
                super.setColumnsValues(",\n\t" + "P_SUFFIX = " + V_SUFFIX);
                super.setColumnsValues(",\n\t" + "P_NEXT_ID = '" + V_NEXT_ID + "'");
                super.setColumnsValues(",\n\t" + "MODIFICATION_NUM = " + (V_MODIFICATION_NUM + 1));
                super.setCondition("1=1");
                
                this.updateRecord(super.getTblSSAId(), super.getColumnsValues(), super.getCondition());
                
                super.clearColumnsValues();
                super.clearCondition();
            }
        } catch (HeadlessException | SQLException e){
            System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryTableCount" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instrução SELECT:" + "\n" + "SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblSSAId());
            System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryTableCount" + "\t" + "ObjMgrSqlLog" + "\t" + "Error Exception" + "\t" + "Error: " + e);
            JOptionPane.showMessageDialog(null, "Erro ao buscar registros de usuários no banco de dados!\nErro: " + e);
        }
        
    }
    
    @Override
    public String insertRecord(String table, String columns, String values) {
        String sqlHeader = "INSERT INTO " + super.getDbOwner() + "." + table;
        String sqlColumn = " (";
        sqlColumn += "\n\t" + "ROW_ID";
        sqlColumn += ",\n\t" + "CREATED";
        sqlColumn += ",\n\t" + "LAST_UPD";
        sqlColumn += ",\n\t" + "DB_LAST_UPD";
        sqlColumn += ",\n\t" + "CREATED_BY";
        sqlColumn += ",\n\t" + "LAST_UPD_BY";
        sqlColumn += columns;
        sqlColumn += "\n) ";
        
        String sqlValue = "VALUES (";
        sqlValue += "\n\t" + "'" + this.getNextRowId() + "'";
        if(super.getDbDriver().toUpperCase().contains("ORACLE")) {
            sqlValue += ",\n\t" + "SYSDATE";
            sqlValue += ",\n\t" + "SYSDATE";
            sqlValue += ",\n\t" + "SYSDATE";
        } else if (super.getDbDriver().toUpperCase().contains("MYSQL")) {
            sqlValue += ",\n\t" + "SYSDATE()";
            sqlValue += ",\n\t" + "SYSDATE()";
            sqlValue += ",\n\t" + "SYSDATE()";
        } else {
            sqlValue += ",\n\t" + "SYSDATE";
            sqlValue += ",\n\t" + "SYSDATE";
            sqlValue += ",\n\t" + "SYSDATE";
        }
        sqlValue += ",\n\t" + "'" + this.getConnectedUserId() + "'";
        sqlValue += ",\n\t" + "'" + this.getConnectedUserId() + "'";
        sqlValue += values;
        sqlValue += "\n)";
        
        long tempoInicial = 0;
        long tempoFinal = 0;
        long tempoExec = 0;
        
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "InsertRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "Execute" + "\t" + "BEGIN: Preparando a instrução INSERT para inserir dados na tabela");
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "InsertRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "Execute" + "\t" + "Owner: " + super.getDbOwner());
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "InsertRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "Execute" + "\t" + "Tabela: " + table);
        
        try{
            if("true".equals(openConnection("Inserindo registro(s)"))){
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "InsertRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "Execute" + "\t" + "Criando Statement INSERT");
                
                statement = conn.createStatement();
                tempoInicial = System.currentTimeMillis();
                statement.execute(sqlHeader + sqlColumn + sqlValue);
                tempoFinal = System.currentTimeMillis();
                tempoExec = tempoFinal - tempoInicial;
                
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "InsertRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instrução INSERT:\n" + sqlHeader + sqlColumn + sqlValue);
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "InsertRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "Execute" + "\n" + "***** Início da execução da instrução: " + (tempoInicial / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "InsertRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "Execute" + "\n" + "***** Fim da execução da instrução: " + (tempoFinal / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "InsertRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "Execute" + "\n" + "***** Tempo total da execução da instrução: " + (tempoExec / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "InsertRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "Execute" + "\t" + "END: Instrução INSERT para inserir dados na tabela finalizada");
                
                closeConnection("Registro inserido com sucesso...");
                JOptionPane.showMessageDialog(null, "Registro inserido com sucesso!");
                this.generateRowIdTrigger();
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao inserir registro no banco de dados!");
            }
            return "true";
        } catch (HeadlessException | SQLException e){
            System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "InsertRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instrução INSERT:\n" + sqlHeader + sqlColumn + sqlValue);
            System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "InsertRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "Error Exception" + "\t" + "Error: " + e);
            JOptionPane.showMessageDialog(null, "Erro ao inserir registros no banco de dados!\nErro: " + e);
            return "false";
        }
    }
    
    @Override
    public int updateRecord(String table, String columnsValues, String condition){
        String sqlHeader = "UPDATE " + super.getDbOwner() + "." + table + "\n";
        String sqlColumnsValues = "SET ";        
        // Default Columns
        if(super.getDbDriver().toUpperCase().contains("ORACLE")) {
            sqlColumnsValues += "LAST_UPD = SYSDATE";
            sqlColumnsValues += ",\n\t" + "DB_LAST_UPD = SYSDATE";
        } else if (super.getDbDriver().toUpperCase().contains("MYSQL")) {
            sqlColumnsValues += "LAST_UPD = SYSDATE()";
            sqlColumnsValues += ",\n\t" + "DB_LAST_UPD = SYSDATE()";
        } else {
            sqlColumnsValues += "LAST_UPD = SYSDATE";
            sqlColumnsValues += ",\n\t" + "DB_LAST_UPD = SYSDATE";
        }        
        sqlColumnsValues += ",\n\t" + "LAST_UPD_BY = '" + this.getConnectedUserId() + "'";
        // Other Columns
        sqlColumnsValues += columnsValues + "\n";
        
        String sqlCondition = "WHERE " + condition;
        long tempoInicial = 0;
        long tempoFinal = 0;
        long tempoExec = 0;
        int count = 0;
        
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "UpdateRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteUpdate" + "\t" + "BEGIN: Preparando a instrução UPDATE para atualizar dados na tabela");
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "UpdateRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteUpdate" + "\t" + "Owner: " + super.getDbOwner());
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "UpdateRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteUpdate" + "\t" + "Tabela: " + table);     
        
        try{
            if("true".equals(openConnection("Atualizando registro(s)"))){
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "UpdateRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteUpdate" + "\t" + "Criando Statement UPDATE");
                
                statement = conn.createStatement();
                tempoInicial = System.currentTimeMillis();
                count = statement.executeUpdate(sqlHeader + sqlColumnsValues + sqlCondition);
                tempoFinal = System.currentTimeMillis();
                tempoExec = tempoFinal - tempoInicial;
                
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "UpdateRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instrução UPDATE:" + "\n" + sqlHeader + sqlColumnsValues + sqlCondition);
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "UpdateRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteUpdate" + "\n" + "***** Início da execução da instrução: " + (tempoInicial / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "UpdateRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteUpdate" + "\n" + "***** Fim da execução da instrução: " + (tempoFinal / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "UpdateRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteUpdate" + "\n" + "***** Tempo total da execução da instrução: " + (tempoExec / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "UpdateRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteUpdate" + "\t" + "Total de registros alterados: " + count);
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "UpdateRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteUpdate" + "\t" + "END: Instrução UPDATE para atualizar dados na tabela finalizada");
                
                closeConnection("Registro(s) atualizado(s) com sucesso");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar registro no banco de dados!");
            }
            return count;
        } catch (HeadlessException | SQLException e){
            System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "UpdateRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instrução UPDATE:" + "\n" + sqlHeader + sqlColumnsValues + sqlCondition);
            System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "UpdateRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "Error Exception" + "\t" + "Error: " + e);
            JOptionPane.showMessageDialog(null, "Erro ao atualizar registros no banco de dados!\nErro: " + e);
            return -1;
        } finally{
            sqlHeader = null;
            sqlColumnsValues = null;
            sqlCondition = null;
            count = 0;
        }
    }

    @Override
    public int deleteRecord(String table, String condition) {
        String sqlHeader = "DELETE FROM " + super.getDbOwner() + "." + table + "\n";
        String sqlCondition = "WHERE " + condition;
        int count = 0;
        long tempoInicial = 0;
        long tempoFinal = 0;
        long tempoExec = 0;
        
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "DeleteRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteUpdate" + "\t" + "BEGIN: Preparando a instrução DELETE para deletar dados da tabela.");
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "DeleteRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteUpdate" + "\t" + "Owner: " + super.getDbOwner());
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "DeleteRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteUpdate" + "\t" + "Tabela: " + table );
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "DeleteRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteUpdate" + "\t" + "Condição: " + condition );
        
        try{
            if("true".equals(openConnection("Deletando registro(s)"))){
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "DeleteRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteUpdate" + "\t" + "Criando Statement DELETE");
                
                statement = conn.createStatement();
                tempoInicial = System.currentTimeMillis();
                count = statement.executeUpdate(sqlHeader + sqlCondition);
                tempoFinal = System.currentTimeMillis();
                tempoExec = tempoFinal - tempoInicial;
                
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "DeleteRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instrução DELETE:" + "\n" + sqlHeader + sqlCondition);
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "DeleteRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteUpdate" + "\n" + "***** Início da execução da instrução: " + (tempoInicial / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "DeleteRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteUpdate" + "\n" + "***** Fim da execução da instrução: " + (tempoFinal / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "DeleteRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteUpdate" + "\n" + "***** Tempo total da execução da instrução: " + (tempoExec / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "DeleteRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteUpdate" + "\t" + "Total de registros deletados: " + count);
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "DeleteRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteUpdate" + "\t" + "END: Instrução DELETE para deletar dados na tabela finalizada");
                
                closeConnection("Registro(s) deletado(s) com sucesso");
                //JOptionPane.showMessageDialog(null, "Registros removidos com sucesso!\nTotal de registros removidos: " + count);
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao remover registros no banco de dados!");
            }
            return count;
        } catch (HeadlessException | SQLException e){
            System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "DeleteRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instrução DELETE:" + "\n" + sqlHeader + sqlCondition);
            System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "DeleteRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "Error Exception" + "\t" + "Error: " + e);
            JOptionPane.showMessageDialog(null, "Erro ao remover registros no banco de dados!\nErro: " + e);
            return -1;
        } finally{
            sqlHeader = null;
            sqlCondition = null;
            count = 0;
        }
    }

    @Override
    public int queryTableCount(String table, String condition){
        int count = 0;
        long tempoInicial = 0;
        long tempoFinal = 0;
        long tempoExec = 0;
        
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryTableCount" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "BEGIN: Preparando a instrução SELECT para buscar dados na tabela");
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryTableCount" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Owner: " + super.getDbOwner());
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryTableCount" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Tabela: " + table );
        
        try{
            if("true".equals(openConnection("Buscando Registros de usuários..."))){
                super.statement = super.conn.createStatement();
                tempoInicial = System.currentTimeMillis();
                ResultSet rs = super.statement.executeQuery("SELECT\n\tCOUNT(*) AS COUNT\nFROM " + super.getDbOwner() + "." + table + "\nWHERE " + condition);
                
                while(rs.next()){
                    count = rs.getInt("COUNT");
                }
                
                tempoFinal = System.currentTimeMillis();
                tempoExec = tempoFinal - tempoInicial;
                
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryTableCount" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instrução SELECT:" + "\n" + "SELECT COUNT(*) AS COUNT\nFROM " + super.getDbOwner() + "." + table + "\nWHERE " + condition);
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryTableCount" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Início da execução da instrução: " + (tempoInicial / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryTableCount" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Fim da execução da instrução: " + (tempoFinal / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryTableCount" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Tempo total da execução da instrução: " + (tempoExec / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryTableCount" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Total de registros encontrados: " + count);
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryTableCount" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "END: Instrução SELECT para selecionar dados na tabela finalizada");
                
                rs.close();
                closeConnection("Dados de Usuários retornados com sucesso...");
            }
        } catch (HeadlessException | SQLException e){
            System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryTableCount" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instrução SELECT:" + "\n" + "SELECT COUNT(*)\nFROM '" + super.getDbOwner() + "'.'" + table + "'\nWHERE " + condition);
            System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryTableCount" + "\t" + "ObjMgrSqlLog" + "\t" + "Error Exception" + "\t" + "Error: " + e);
            JOptionPane.showMessageDialog(null, "Erro ao buscar registros de usuários no banco de dados!\nErro: " + e);
        }
        
        return count;
    }
    
    @Override
    public ArrayList<UserClass> queryUserRecord(String query){
        ArrayList<UserClass> result = new ArrayList<>();
        int count = 0;
        long tempoInicial = 0;
        long tempoFinal = 0;
        long tempoExec = 0;
        
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryUserRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "BEGIN: Preparando a instrução SELECT para buscar dados na tabela");
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryUserRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Owner: " + super.getDbOwner());
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryUserRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Tabela: " + super.getTblUser() );
        
        try{
            if("true".equals(openConnection("Buscando Registros de usuários..."))){
                super.statement = super.conn.createStatement();
                tempoInicial = System.currentTimeMillis();
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
                    list.setPAR_POSTN_ID(rs.getString("PAR_POSTN_ID"));
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
                    list.setSTATUS_CD(this.LookupValue("USER_STATUS", rs.getString("STATUS_CD")));
                    
                    result.add(list);
                    count++;
                }
                tempoFinal = System.currentTimeMillis();
                tempoExec = tempoFinal - tempoInicial;
                
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryUserRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instrução SELECT:" + "\n" + query);
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryUserRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Início da execução da instrução: " + (tempoInicial / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryUserRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Fim da execução da instrução: " + (tempoFinal / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryUserRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Tempo total da execução da instrução: " + (tempoExec / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryUserRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Total de registros encontrados: " + count);
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryUserRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "END: Instrução SELECT para selecionar dados na tabela finalizada");
                
                rs.close();
                closeConnection("Dados de Usuários retornados com sucesso...");
            }
        } catch (HeadlessException | SQLException e){
            System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryUserRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instrução SELECT:" + "\n" + query);
            System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryUserRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "Error Exception" + "\t" + "Error: " + e);
            JOptionPane.showMessageDialog(null, "Erro ao buscar registros de usuários no banco de dados!\nErro: " + e);
        }
        
        return result;
    }
    
    @Override
    public ArrayList<PositionClass> queryPositionRecord(String query){
        ArrayList<PositionClass> result = new ArrayList<>();
        int count = 0;
        long tempoInicial = 0;
        long tempoFinal = 0;
        long tempoExec = 0;
        
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryPositionRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "BEGIN: Preparando a instrução SELECT para buscar dados na tabela");
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryPositionRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Owner: " + super.getDbOwner());
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryPositionRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Tabela: " + super.getTblPosition());
        
        try{
            if("true".equals(openConnection("Buscando Registros de usuários..."))){
                super.statement = super.conn.createStatement();
                tempoInicial = System.currentTimeMillis();
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
                    count++;
                }
                tempoFinal = System.currentTimeMillis();
                tempoExec = tempoFinal - tempoInicial;
                
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryPositionRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instrução SELECT:" + "\n" + query);
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryPositionRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Início da execução da instrução: " + (tempoInicial / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryPositionRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Fim da execução da instrução: " + (tempoFinal / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryPositionRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Tempo total da execução da instrução: " + (tempoExec / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryPositionRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Total de registros encontrados: " + count);
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryPositionRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "END: Instrução SELECT para selecionar dados na tabela finalizada");
                
                rs.close();
                closeConnection("Dados de Usuários retornados com sucesso...");
            }
        } catch (HeadlessException | SQLException e){
            System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryPositionRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instrução SELECT:" + "\n" + query);
            System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryPositionRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "Error Exception" + "\t" + "Error: " + e);
            JOptionPane.showMessageDialog(null, "Erro ao buscar registros de usuários no banco de dados!\nErro: " + e);
        }
        
        return result;
    }
    
    @Override
    public ArrayList<PositionPerClass> queryPositionPerRecord(String query){
        ArrayList<PositionPerClass> result = new ArrayList<>();
        int count = 0;
        long tempoInicial = 0;
        long tempoFinal = 0;
        long tempoExec = 0;
        
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryUserPermitionRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "BEGIN: Preparando a instrução SELECT para buscar dados na tabela");
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryUserPermitionRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Owner: " + super.getDbOwner());
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryUserPermitionRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Tabela: " + super.getTblPositionPermition());
        
        try{
            if("true".equals(openConnection("Buscando Registros de usuários..."))){
                super.statement = super.conn.createStatement();
                tempoInicial = System.currentTimeMillis();
                ResultSet rs = super.statement.executeQuery(query);
                
                while(rs.next()){
                    PositionPerClass list = new PositionPerClass();
                    
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
                    list.setPERMITION_NAME(rs.getString("PERMITION_NAME"));
                    list.setPERMITION_VALUE(rs.getString("PERMITION_VALUE"));
                    list.setPERMITION_FLG(rs.getString("PERMITION_FLG"));
                    list.setPERMITION_DESC(rs.getString("PERMITION_DESC"));
                    list.setORDER_BY(rs.getString("ORDER_BY"));
                    list.setCOMMENTS(rs.getString("COMMENTS"));                  
                    
                    result.add(list);
                    count++;
                }
                tempoFinal = System.currentTimeMillis();
                tempoExec = tempoFinal - tempoInicial;
                
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryUserPermitionRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instrução SELECT:" + "\n" + query);
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryUserPermitionRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Início da execução da instrução: " + (tempoInicial / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryUserPermitionRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Fim da execução da instrução: " + (tempoFinal / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryUserPermitionRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Tempo total da execução da instrução: " + (tempoExec / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryUserPermitionRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Total de registros encontrados: " + count);
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryUserPermitionRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "END: Instrução SELECT para selecionar dados na tabela finalizada");
                
                rs.close();
                closeConnection("Dados de Usuários retornados com sucesso...");
            }
        } catch (HeadlessException | SQLException e){
            System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryUserPermitionRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instrução SELECT:" + "\n" + query);
            System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryUserPermitionRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "Error Exception" + "\t" + "Error: " + e);
            JOptionPane.showMessageDialog(null, "Erro ao buscar registros de usuários no banco de dados!\nErro: " + e);
        }
        
        return result;
    }
    
    @Override
    public ArrayList<AddressClass> queryAddressRecord(String query){
        ArrayList<AddressClass> result = new ArrayList<>();
        int count = 0;
        long tempoInicial = 0;
        long tempoFinal = 0;
        long tempoExec = 0;
        
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryAddressRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "BEGIN: Preparando a instrução SELECT para buscar dados na tabela");
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryAddressRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Owner: " + super.getDbOwner());
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryAddressRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Tabela: " + super.getTblAddress());
        
        try{
            if("true".equals(openConnection("Buscando Registros de usuários..."))){
                super.statement = super.conn.createStatement();
                tempoInicial = System.currentTimeMillis();
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
                    count++;
                }
                tempoFinal = System.currentTimeMillis();
                tempoExec = tempoFinal - tempoInicial;
                
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryAddressRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instrução SELECT:" + "\n" + query);
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryAddressRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Início da execução da instrução: " + (tempoInicial / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryAddressRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Fim da execução da instrução: " + (tempoFinal / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryAddressRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Tempo total da execução da instrução: " + (tempoExec / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryAddressRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Total de registros encontrados: " + count);
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryAddressRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "END: Instrução SELECT para selecionar dados na tabela finalizada");
                
                rs.close();
                closeConnection("Dados de Usuários retornados com sucesso...");
            }
        } catch (HeadlessException | SQLException e){
            System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryAddressRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instrução SELECT:" + "\n" + query);
            System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryAddressRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "Error Exception" + "\t" + "Error: " + e);
            JOptionPane.showMessageDialog(null, "Erro ao buscar registros de usuários no banco de dados!\nErro: " + e);
        }
        
        return result;
    }
    
    @Override
    public ArrayList<ContactClass> queryContactRecord(String query){
        ArrayList<ContactClass> result = new ArrayList<>();
        int count = 0;
        long tempoInicial = 0;
        long tempoFinal = 0;
        long tempoExec = 0;
        
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryContactRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "BEGIN: Preparando a instrução SELECT para buscar dados na tabela");
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryContactRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Owner: " + super.getDbOwner());
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryContactRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Tabela: " + super.getTblContact());
        
        try{
            if("true".equals(openConnection("Buscando Registros de usuários..."))){
                super.statement = super.conn.createStatement();
                tempoInicial = System.currentTimeMillis();
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
                    if(!"".equals(rs.getString("BIRTH_DT")) && rs.getString("BIRTH_DT") != null) {
                        list.setBIRTH_DT(rs.getString("BIRTH_DT").substring(8, 10) + "/" + rs.getString("BIRTH_DT").substring(5, 7) + "/" + rs.getString("BIRTH_DT").substring(0, 4));
                    }
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
                    count++;
                }
                tempoFinal = System.currentTimeMillis();
                tempoExec = tempoFinal - tempoInicial;
                
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryContactRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instrução SELECT:" + "\n" + query);
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryContactRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Início da execução da instrução: " + (tempoInicial / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryContactRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Fim da execução da instrução: " + (tempoFinal / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryContactRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Tempo total da execução da instrução: " + (tempoExec / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryContactRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Total de registros encontrados: " + count);
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryContactRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "END: Instrução SELECT para selecionar dados na tabela finalizada");
                
                rs.close();
                closeConnection("Dados de Usuários retornados com sucesso...");
            }
        } catch (HeadlessException | SQLException e){
            System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryContactRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instrução SELECT:" + "\n" + query);
            System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryContactRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "Error Exception" + "\t" + "Error: " + e);
            JOptionPane.showMessageDialog(null, "Erro ao buscar registros de usuários no banco de dados!\nErro: " + e);
        }
        
        return result;
    }
    
    @Override
    public ArrayList<SocialMediaClass> querySocialMediaRecord(String query){        
        ArrayList<SocialMediaClass> result = new ArrayList<>();
        int count = 0;
        long tempoInicial = 0;
        long tempoFinal = 0;
        long tempoExec = 0;
        
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QuerySocialMediaRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "BEGIN: Preparando a instrução SELECT para buscar dados na tabela");
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QuerySocialMediaRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Owner: " + super.getDbOwner());
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QuerySocialMediaRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Tabela: " + super.getTblSocialMedia());
        
        try{
            if("true".equals(openConnection("Buscando Registros de Redes Sociais"))){
                super.statement = super.conn.createStatement();
                tempoInicial = System.currentTimeMillis();
                ResultSet rs = super.statement.executeQuery(query);
                
                while(rs.next()){
                    SocialMediaClass list = new SocialMediaClass();
                    
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
                    count++;
                }
                tempoFinal = System.currentTimeMillis();
                tempoExec = tempoFinal - tempoInicial;
                
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QuerySocialMediaRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instrução SELECT:" + "\n" + query);
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QuerySocialMediaRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Início da execução da instrução: " + (tempoInicial / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QuerySocialMediaRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Fim da execução da instrução: " + (tempoFinal / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QuerySocialMediaRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Tempo total da execução da instrução: " + (tempoExec / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QuerySocialMediaRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Total de registros encontrados: " + count);
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QuerySocialMediaRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "END: Instrução SELECT para selecionar dados na tabela finalizada");
                
                rs.close();
                closeConnection("Dados de Usuários retornados com sucesso...");
            }
        } catch (HeadlessException | SQLException e){
            System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QuerySocialMediaRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instrução SELECT:" + "\n" + query);
            System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QuerySocialMediaRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "Error Exception" + "\t" + "Error: " + e);
            JOptionPane.showMessageDialog(null, "Erro ao buscar registros de usuários no banco de dados!\nErro: " + e);
        }
        
        return result;
    }
    
    @Override
    public String getNextRowId(){
        String row_id = null;
        int count = 0;
        long tempoInicial = 0;
        long tempoFinal = 0;
        long tempoExec = 0;
        
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "GetNextRowId" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "BEGIN: Preparando a instrução SELECT para buscar dados na tabela");
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "GetNextRowId" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Owner: " + super.getDbOwner());
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "GetNextRowId" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Tabela: " + super.getTblSSAId());
        
        try{
            if("true".equals(openConnection("Buscando proximo ROW_ID"))){
                statement = conn.createStatement();
                
                tempoInicial = System.currentTimeMillis();
                ResultSet rs = statement.executeQuery("SELECT\n\tP_NEXT_ID\nFROM " + super.getDbOwner() + "." + super.getTblSSAId() + "\nWHERE ROW_ID = '0-1'");
                
                while(rs.next()){
                    row_id = rs.getString("P_NEXT_ID");
                    count++;
                }
                tempoFinal = System.currentTimeMillis();
                tempoExec = tempoFinal - tempoInicial;
                
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "GetNextRowId" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instrução SELECT:" + "\n" + "SELECT\n\tP_NEXT_ID\nFROM " + super.getDbOwner() + "." + super.getTblSSAId() + "\nWHERE ROW_ID = '0-1'");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "GetNextRowId" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Início da execução da instrução: " + (tempoInicial / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "GetNextRowId" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Fim da execução da instrução: " + (tempoFinal / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "GetNextRowId" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Tempo total da execução da instrução: " + (tempoExec / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "GetNextRowId" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Total de registros encontrados: " + count);
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "GetNextRowId" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "END: Instrução SELECT para selecionar dados na tabela finalizada");
                
                rs.close();
                closeConnection("ROW_ID: '" + row_id + "' encontrado com sucesso");
            } else {
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "GetNextRowId" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instrução SELECT:" + "\n" + "SELECT\n\tP_NEXT_ID\nFROM " + super.getDbOwner() + "." + super.getTblSSAId() + "\nWHERE ROW_ID = '0-1'");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "GetNextRowId" + "\t" + "ObjMgrSqlLog" + "\t" + "Error Exception" + "\t" + "Error: " + "Erro ao buscar ROW_ID");
                JOptionPane.showMessageDialog(null, "Erro ao buscar ROW_ID!");
            }
        } catch (HeadlessException | SQLException e){
            System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "GetNextRowId" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instrução SELECT:" + "\n" + "SELECT\n\tP_NEXT_ID\nFROM " + super.getDbOwner() + "." + super.getTblSSAId() + "\nWHERE ROW_ID = '0-1'");
            System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "GetNextRowId" + "\t" + "ObjMgrSqlLog" + "\t" + "Error Exception" + "\t" + "Error: " + e);
            System.out.println(e);
        }
        
        return row_id;
    }
    
    @Override
    public String getConnectedUserId(){
        String row_id = null;
        int count = 0;
        long tempoInicial = 0;
        long tempoFinal = 0;
        long tempoExec = 0;
        
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "getConnectedUserId" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "BEGIN: Preparando a instrução SELECT para buscar dados na tabela");
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "getConnectedUserId" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Owner: " + super.getDbOwner());
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "getConnectedUserId" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Tabela: " + super.getTblUser());
        
        try{
            if("true".equals(openConnection("Buscando Id do usuário..."))){
                statement = conn.createStatement();
                
                tempoInicial = System.currentTimeMillis();
                ResultSet rs = statement.executeQuery("SELECT\n\tROW_ID\nFROM " + super.getDbOwner() + "." + super.getTblUser() + "\nWHERE LOGIN = '" + super.getDbUser() + "'");
                
                while(rs.next()){
                    row_id = rs.getString("ROW_ID");
                    count++;
                }
                tempoFinal = System.currentTimeMillis();
                tempoExec = tempoFinal - tempoInicial;
                
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "getConnectedUserId" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instrução SELECT:" + "\n" + "SELECT\n\tROW_ID\nFROM " + super.getDbOwner() + "." + super.getTblUser() + "\nWHERE LOGIN = '" + super.getDbUser() + "'");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "getConnectedUserId" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Início da execução da instrução: " + (tempoInicial / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "getConnectedUserId" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Fim da execução da instrução: " + (tempoFinal / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "getConnectedUserId" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Tempo total da execução da instrução: " + (tempoExec / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "getConnectedUserId" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Total de registros encontrados: " + count);
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "getConnectedUserId" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "END: Instrução SELECT para selecionar dados na tabela finalizada");
                
                rs.close();
                closeConnection("Id do usuário: '" + row_id + "' encontrado com sucesso");
            } else {
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "getConnectedUserId" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instrução SELECT:" + "\n" + "SELECT\n\tROW_ID\nFROM " + super.getDbOwner() + "." + super.getTblUser() + "\nWHERE LOGIN = '" + super.getDbUser() + "'");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "getConnectedUserId" + "\t" + "ObjMgrSqlLog" + "\t" + "Error Exception" + "\t" + "Error: " + "Erro ao buscar ROW_ID");
                JOptionPane.showMessageDialog(null, "Erro ao buscar ROW_ID!");
            }
        } catch (HeadlessException | SQLException e){
            System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "getConnectedUserId" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instrução SELECT:" + "\n" + "SELECT\n\tROW_ID\nFROM " + super.getDbOwner() + "." + super.getTblUser() + "\nWHERE LOGIN = '" + super.getDbUser() + "'");
            System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "getConnectedUserId" + "\t" + "ObjMgrSqlLog" + "\t" + "Error Exception" + "\t" + "Error: " + e);
            System.out.println(e);
        }
        
        return row_id;
    }
    
    @Override
    public String getUserIdByLogin(String login) {
        String row_id = null;
        int count = 0;
        long tempoInicial = 0;
        long tempoFinal = 0;
        long tempoExec = 0;
        
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "GetUserIdByLogin" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "BEGIN: Preparando a instrução SELECT para buscar dados na tabela");
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "GetUserIdByLogin" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Owner: " + super.getDbOwner());
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "GetUserIdByLogin" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Tabela: " + super.getTblUser());
        
        try{
            if("true".equals(openConnection("Buscando Id do usuário..."))){
                statement = conn.createStatement();
                
                tempoInicial = System.currentTimeMillis();
                ResultSet rs = statement.executeQuery("SELECT\n\tROW_ID\nFROM " + super.getDbOwner() + "." + super.getTblUser() + "\nWHERE LOGIN LIKE '" + login.toUpperCase() + "'");
                
                while(rs.next()){
                    row_id = rs.getString("ROW_ID");
                    count++;
                }
                tempoFinal = System.currentTimeMillis();
                tempoExec = tempoFinal - tempoInicial;
                
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "GetUserIdByLogin" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instrução SELECT:" + "\n" + "SELECT\n\tROW_ID\nFROM " + super.getDbOwner() + "." + super.getTblUser() + "\nWHERE LOGIN LIKE '" + login.toUpperCase() + "'");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "GetUserIdByLogin" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Início da execução da instrução: " + (tempoInicial / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "GetUserIdByLogin" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Fim da execução da instrução: " + (tempoFinal / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "GetUserIdByLogin" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Tempo total da execução da instrução: " + (tempoExec / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "GetUserIdByLogin" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Total de registros encontrados: " + count);
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "GetUserIdByLogin" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "END: Instrução SELECT para selecionar dados na tabela finalizada");
                
                rs.close();
                closeConnection("Id do usuário: '" + row_id + "' encontrado com sucesso");
            } else {
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "GetUserIdByLogin" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instrução SELECT:" + "\n" + "SELECT\n\tROW_ID\nFROM " + super.getDbOwner() + "." + super.getTblUser() + "\nWHERE LOGIN = '" + super.getDbUser() + "'");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "GetUserIdByLogin" + "\t" + "ObjMgrSqlLog" + "\t" + "Error Exception" + "\t" + "Error: " + "Erro ao buscar ROW_ID");
                JOptionPane.showMessageDialog(null, "Erro ao buscar ROW_ID!");
            }
        } catch (HeadlessException | SQLException e){
            System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "GetUserIdByLogin" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instrução SELECT:" + "\n" + "SELECT\n\tROW_ID\nFROM " + super.getDbOwner() + "." + super.getTblUser() + "\nWHERE LOGIN = '" + super.getDbUser() + "'");
            System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "GetUserIdByLogin" + "\t" + "ObjMgrSqlLog" + "\t" + "Error Exception" + "\t" + "Error: " + e);
            System.out.println(e);
        }
        
        return row_id;
    }
    
    @Override
    public String getPositionIdByName(String positionType) {
        String row_id = null;
        int count = 0;
        long tempoInicial = 0;
        long tempoFinal = 0;
        long tempoExec = 0;
        
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "GetPositionIdByName" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "BEGIN: Preparando a instrução SELECT para buscar dados na tabela");
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "GetPositionIdByName" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Owner: " + super.getDbOwner());
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "GetPositionIdByName" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Tabela: " + super.getTblPosition());
        
        try{
            if("true".equals(openConnection("Buscando Id do usuário..."))){
                statement = conn.createStatement();
                
                tempoInicial = System.currentTimeMillis();
                ResultSet rs = statement.executeQuery("SELECT\n\tROW_ID\nFROM " + super.getDbOwner() + "." + super.getTblPosition() + "\nWHERE POSTN_TYPE_CD = '" + positionType + "'");
                
                while(rs.next()){
                    row_id = rs.getString("ROW_ID");
                    count++;
                }
                tempoFinal = System.currentTimeMillis();
                tempoExec = tempoFinal - tempoInicial;
                
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "GetPositionIdByName" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instrução SELECT:" + "\n" + "SELECT\n\tROW_ID\nFROM " + super.getDbOwner() + "." + super.getTblPosition() + "\nWHERE POSTN_TYPE_CD = '" + positionType + "'");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "GetPositionIdByName" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Início da execução da instrução: " + (tempoInicial / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "GetPositionIdByName" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Fim da execução da instrução: " + (tempoFinal / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "GetPositionIdByName" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Tempo total da execução da instrução: " + (tempoExec / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "GetPositionIdByName" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Total de registros encontrados: " + count);
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "GetPositionIdByName" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "END: Instrução SELECT para selecionar dados na tabela finalizada");
                
                rs.close();
                closeConnection("Position Id: '" + row_id + "' encontrado com sucesso");
            } else {
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "GetPositionIdByName" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instrução SELECT:" + "\n" + "SELECT\n\tROW_ID\nFROM " + super.getDbOwner() + "." + super.getTblPosition() + "\nWHERE POSTN_TYPE_CD = '" + positionType + "'");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "GetPositionIdByName" + "\t" + "ObjMgrSqlLog" + "\t" + "Error Exception" + "\t" + "Error: " + "Erro ao buscar ROW_ID");
                JOptionPane.showMessageDialog(null, "Erro ao buscar ROW_ID!");
            }
        } catch (HeadlessException | SQLException e){
            System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "GetPositionIdByName" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instrução SELECT:" + "\n" + "SELECT\n\tROW_ID\nFROM " + super.getDbOwner() + "." + super.getTblPosition() + "\nWHERE POSTN_TYPE_CD = '" + positionType + "'");
            System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "GetPositionIdByName" + "\t" + "ObjMgrSqlLog" + "\t" + "Error Exception" + "\t" + "Error: " + e);
            System.out.println(e);
        }
        
        return row_id;
    }
    
    @Override
    public String LookupValueSubtype(String type, String name, String subtype){
        String value = null;
        int count = 0;
        long tempoInicial = 0;
        long tempoFinal = 0;
        long tempoExec = 0;
        
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupValueSubtype" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "BEGIN: Preparando a instrução SELECT para buscar dados na tabela");
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupValueSubtype" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Owner: " + super.getDbOwner());
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupValueSubtype" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Tabela: " + super.getTblLstOfVal());
        
        try{
            if("true".equals(openConnection("Buscando LookupValue usando Subtype"))){
                statement = conn.createStatement();
                tempoInicial = System.currentTimeMillis();
                ResultSet rs = statement.executeQuery(
                    "SELECT\n" +
                    "\tLOV.VAL\n" +
                    "FROM " + super.getDbOwner() + "." + super.getTblLstOfVal() + " LOV\n" +
                    "WHERE " + super.getDbOwner() + ".TYPE = '" + type + "'\n" +
                    "AND " + super.getDbOwner() + ".NAME = '" + name + "'\n" +
                    "AND " + super.getDbOwner() + ".SUBTYPE = '" + subtype + "'"
                );
                
                while(rs.next()){
                    value = rs.getString("VAL");
                    count++;
                }
                tempoFinal = System.currentTimeMillis();
                tempoExec = tempoFinal - tempoInicial;
                
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupValueSubtype" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instrução SELECT:" + "\n" + "SELECT\n\tLOV.VAL\nFROM " + super.getDbOwner() + "." + super.getTblLstOfVal() + " LOV\nWHERE " + super.getDbOwner() + ".TYPE = '" + type + "'\nAND " + super.getDbOwner() + ".NAME = '" + name + "'\nAND " + super.getDbOwner() + ".SUBTYPE = '" + subtype + "'");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupValueSubtype" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Início da execução da instrução: " + (tempoInicial / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupValueSubtype" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Fim da execução da instrução: " + (tempoFinal / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupValueSubtype" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Tempo total da execução da instrução: " + (tempoExec / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupValueSubtype" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Total de registros encontrados: " + count);
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupValueSubtype" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "END: Instrução SELECT para selecionar dados na tabela finalizada");
                
                rs.close();
                closeConnection("LookupValueSubtype - Type: '" + type + "', name: '" + name + "', subtype: '" + subtype + "', retornou o value: '" + value + "' com sucesso");
            } else {
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupValueSubtype" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instrução SELECT:" + "\n" + "SELECT\n\tLOV.VAL\nFROM " + super.getDbOwner() + "." + super.getTblLstOfVal() + " LOV\nWHERE " + super.getDbOwner() + ".TYPE = '" + type + "'\nAND " + super.getDbOwner() + ".NAME = '" + name + "'\nAND " + super.getDbOwner() + ".SUBTYPE = '" + subtype + "'");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupValueSubtype" + "\t" + "ObjMgrSqlLog" + "\t" + "Error Exception" + "\t" + "Error: " + "Erro ao buscar LOV Value");
                JOptionPane.showMessageDialog(null, "Erro ao buscar LOV Value!");
            }
        } catch (HeadlessException | SQLException e){
            System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupValueSubtype" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instrução SELECT:" + "\n" + "SELECT\n\tLOV.VAL\nFROM " + super.getDbOwner() + "." + super.getTblLstOfVal() + " LOV\nWHERE " + super.getDbOwner() + ".TYPE = '" + type + "'\nAND " + super.getDbOwner() + ".NAME = '" + name + "'\nAND " + super.getDbOwner() + ".SUBTYPE = '" + subtype + "'");
            System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupValueSubtype" + "\t" + "ObjMgrSqlLog" + "\t" + "Error Exception" + "\t" + "Error: " + e);
            System.out.println(e);
        }
        
        return value;
    }
    
    @Override
    public String LookupValue(String type, String name){
        String value = null;
        int count = 0;
        long tempoInicial = 0;
        long tempoFinal = 0;
        long tempoExec = 0;
        
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupValue" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "BEGIN: Preparando a instrução SELECT para buscar dados na tabela");
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupValue" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Owner: " + super.getDbOwner());
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupValue" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Tabela: " + super.getTblLstOfVal());
        
        try{
            if("true".equals(openConnection("Buscando LookupValue '" + type + "'"))){
                statement = conn.createStatement();
                tempoInicial = System.currentTimeMillis();
                ResultSet rs = statement.executeQuery(
                    "SELECT\n" +
                    "\tLOV.VAL\n" +
                    "FROM " + super.getDbOwner() + "." + super.getTblLstOfVal() + " LOV\n" +
                    "WHERE LOV.TYPE = '" + type + "'\n" +
                    "AND LOV.NAME = '" + name + "'\n" +
                    "ORDER BY LOV.ORDER_BY ASC"
                );
                
                while(rs.next()){
                    value = rs.getString("VAL");
                    count++;
                }
                tempoFinal = System.currentTimeMillis();
                tempoExec = tempoFinal - tempoInicial;
                
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupValue" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instrução SELECT:" + "\n" + "SELECT\n\tLOV.VAL\nFROM " + super.getDbOwner() + "." + super.getTblLstOfVal() + " LOV\nWHERE LOV.TYPE = '" + type + "'\nAND LOV.NAME = '" + name + "'\nORDER BY LOV.ORDER_BY ASC");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupValue" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Início da execução da instrução: " + (tempoInicial / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupValue" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Fim da execução da instrução: " + (tempoFinal / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupValue" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Tempo total da execução da instrução: " + (tempoExec / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupValue" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Total de registros encontrados: " + count);
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupValue" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "END: Instrução SELECT para selecionar dados na tabela finalizada");
                
                rs.close();
                closeConnection("LookupValue - Type: '" + type + "', name: '" + name + "', retornou o value: '" + value + "' com sucesso");
            } else {
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupValue" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instrução SELECT:" + "\n" + "SELECT\n\tLOV.VAL\nFROM " + super.getDbOwner() + "." + super.getTblLstOfVal() + " LOV\nWHERE LOV.TYPE = '" + type + "'\nAND LOV.NAME = '" + name + "'\nORDER BY LOV.ORDER_BY ASC");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupValue" + "\t" + "ObjMgrSqlLog" + "\t" + "Error Exception" + "\t" + "Error: " + "Erro ao buscar LookupValue");
                JOptionPane.showMessageDialog(null, "Erro ao buscar LookupValue");
            }
        } catch (HeadlessException | SQLException e){
            System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupValue" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instrução SELECT:" + "\n" + "SELECT\n\tLOV.VAL\nFROM " + super.getDbOwner() + "." + super.getTblLstOfVal() + " LOV\nWHERE LOV.TYPE = '" + type + "'\nAND LOV.NAME = '" + name + "'\nORDER BY LOV.ORDER_BY ASC");
            System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupValue" + "\t" + "ObjMgrSqlLog" + "\t" + "Error Exception" + "\t" + "Error: " + e);
            System.out.println(e);
        }
        
        return value;
    }
    
    @Override
    public String LookupNameSubtype(String type, String value, String subtype){
        String name = null;
        int count = 0;
        long tempoInicial = 0;
        long tempoFinal = 0;
        long tempoExec = 0;
        
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupNameSubtype" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "BEGIN: Preparando a instrução SELECT para buscar dados na tabela");
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupNameSubtype" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Owner: " + super.getDbOwner());
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupNameSubtype" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Tabela: " + super.getTblLstOfVal());
        
        try{
            if("true".equals(openConnection("Buscando LookupName usando Subtype"))){
                statement = conn.createStatement();
                tempoInicial = System.currentTimeMillis();
                ResultSet rs = statement.executeQuery(
                    "SELECT\n" +
                    "\tLOV.NAME\n" +
                    "FROM " + super.getDbOwner() + "." + super.getTblLstOfVal() + " LOV\n" +
                    "WHERE " + super.getDbOwner() + ".TYPE = '" + type + "'\n" +
                    "AND " + super.getDbOwner() + ".VAL = '" + value + "'\n" +
                    "AND " + super.getDbOwner() + ".SUBTYPE = '" + subtype + "'"
                );
                
                while(rs.next()){
                    name = rs.getString("NAME");
                    count++;
                }
                tempoFinal = System.currentTimeMillis();
                tempoExec = tempoFinal - tempoInicial;
                
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupNameSubtype" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instrução SELECT:" + "\n" + "SELECT\n\tLOV.NAME\nFROM " + super.getDbOwner() + "." + super.getTblLstOfVal() + " LOV\nWHERE " + super.getDbOwner() + ".TYPE = '" + type + "'\nAND " + super.getDbOwner() + ".VAL = '" + value + "'\nAND " + super.getDbOwner() + ".SUBTYPE = '" + subtype + "'");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupNameSubtype" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Início da execução da instrução: " + (tempoInicial / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupNameSubtype" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Fim da execução da instrução: " + (tempoFinal / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupNameSubtype" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Tempo total da execução da instrução: " + (tempoExec / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupNameSubtype" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Total de registros encontrados: " + count);
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupNameSubtype" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "END: Instrução SELECT para selecionar dados na tabela finalizada");
                
                rs.close();
                closeConnection("LookupNameSubtype - Type: '" + type + "', value: '" + value + "', subtype: '" + subtype + "', retornou o name: '" + name + "' com sucesso");
            } else {
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupNameSubtype" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instrução SELECT:" + "\n" + "SELECT\n\tLOV.NAME\nFROM " + super.getDbOwner() + "." + super.getTblLstOfVal() + " LOV\nWHERE " + super.getDbOwner() + ".TYPE = '" + type + "'\nAND " + super.getDbOwner() + ".VAL = '" + value + "'\nAND " + super.getDbOwner() + ".SUBTYPE = '" + subtype + "'");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupNameSubtype" + "\t" + "ObjMgrSqlLog" + "\t" + "Error Exception" + "\t" + "Error: " + "Erro ao buscar LOV Name");
                JOptionPane.showMessageDialog(null, "Erro ao buscar LOV Name!");
            }
        } catch (HeadlessException | SQLException e){
            System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupNameSubtype" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instrução SELECT:" + "\n" + "SELECT\n\tLOV.NAME\nFROM " + super.getDbOwner() + "." + super.getTblLstOfVal() + " LOV\nWHERE " + super.getDbOwner() + ".TYPE = '" + type + "'\nAND " + super.getDbOwner() + ".VAL = '" + value + "'\nAND " + super.getDbOwner() + ".SUBTYPE = '" + subtype + "'");
            System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupNameSubtype" + "\t" + "ObjMgrSqlLog" + "\t" + "Error Exception" + "\t" + "Error: " + e);
            System.out.println(e);
        }
        
        return name;
    }
    
    @Override
    public String LookupName(String type, String value){
        String name = null;
        int count = 0;
        long tempoInicial = 0;
        long tempoFinal = 0;
        long tempoExec = 0;
        
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupNameSubtype" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "BEGIN: Preparando a instrução SELECT para buscar dados na tabela");
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupNameSubtype" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Owner: " + super.getDbOwner());
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupNameSubtype" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Tabela: " + super.getTblLstOfVal());
        
        try{
            if("true".equals(openConnection("Buscando LookupName"))){
                statement = conn.createStatement();
                tempoInicial = System.currentTimeMillis();
                ResultSet rs = statement.executeQuery(
                    "SELECT\n" +
                    "\tLOV.NAME\n" +
                    "FROM " + super.getDbOwner() + "." + super.getTblLstOfVal() + " LOV\n" +
                    "WHERE LOV.TYPE = '" + type + "'\n" +
                    "AND LOV.VAL = '" + value + "'"
                );
                
                while(rs.next()){
                    name = rs.getString("NAME");
                    System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupNameSubtype" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "LookupName - Type: '" + type + "', value: '" + value + "', retornou name: '" + rs.getString("NAME") + "' com sucesso");
                    count++;
                }
                tempoFinal = System.currentTimeMillis();
                tempoExec = tempoFinal - tempoInicial;
                
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupNameSubtype" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instrução SELECT:" + "\n" + "SELECT\n\tLOV.NAME\nFROM " + super.getDbOwner() + "." + super.getTblLstOfVal() + " LOV\nWHERE LOV.TYPE = '" + type + "'\nAND LOV.VAL = '" + value + "'");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupNameSubtype" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Início da execução da instrução: " + (tempoInicial / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupNameSubtype" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Fim da execução da instrução: " + (tempoFinal / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupNameSubtype" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Tempo total da execução da instrução: " + (tempoExec / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupNameSubtype" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Total de registros encontrados: " + count);
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupNameSubtype" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "END: Instrução SELECT para selecionar dados na tabela finalizada");
                
                rs.close();
                closeConnection("LookupName encontrado com sucesso!");
            } else {
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupNameSubtype" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instrução SELECT:" + "\n" + "SELECT\n\tLOV.NAME\nFROM " + super.getDbOwner() + "." + super.getTblLstOfVal() + " LOV\nWHERE LOV.TYPE = '" + type + "'\nAND LOV.VAL = '" + value + "'");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupNameSubtype" + "\t" + "ObjMgrSqlLog" + "\t" + "Error Exception" + "\t" + "Error: " + "Erro ao buscar LookupName");
                JOptionPane.showMessageDialog(null, "Erro ao buscar LookupName!");
            }
        } catch (HeadlessException | SQLException e){
            System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupNameSubtype" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instrução SELECT:" + "\n" + "SELECT\n\tLOV.NAME\nFROM " + super.getDbOwner() + "." + super.getTblLstOfVal() + " LOV\nWHERE LOV.TYPE = '" + type + "'\nAND LOV.VAL = '" + value + "'");
            System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupNameSubtype" + "\t" + "ObjMgrSqlLog" + "\t" + "Error Exception" + "\t" + "Error: " + e);
            System.out.println(e);
        }
        
        return name;
    }
    
    @Override
    public ArrayList<ListOfValuesClass> LookupList(String type){
        ArrayList<ListOfValuesClass> array = new ArrayList<>();
        int count = 0;
        long tempoInicial = 0;
        long tempoFinal = 0;
        long tempoExec = 0;
        
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupNameSubtype" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "BEGIN: Preparando a instrução SELECT para buscar dados na tabela");
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupNameSubtype" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Owner: " + super.getDbOwner());
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupNameSubtype" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Tabela: " + super.getTblLstOfVal());
        
        try{
            if("true".equals(openConnection("Buscando LookupList '" + type + "'"))){
                statement = conn.createStatement();
                tempoInicial = System.currentTimeMillis();
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
                    count++;
                }
                tempoFinal = System.currentTimeMillis();
                tempoExec = tempoFinal - tempoInicial;
                
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupNameSubtype" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instrução SELECT:" + "\n" + "SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblLstOfVal() + " LOV\nWHERE LOV.TYPE = '" + type + "'\nORDER BY LOV.ORDER_BY ASC");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupNameSubtype" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Início da execução da instrução: " + (tempoInicial / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupNameSubtype" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Fim da execução da instrução: " + (tempoFinal / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupNameSubtype" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Tempo total da execução da instrução: " + (tempoExec / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupNameSubtype" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Total de registros encontrados: " + count);
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupNameSubtype" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "END: Instrução SELECT para selecionar dados na tabela finalizada");
                
                rs.close();
                closeConnection("LookupList '" + type + "' encontrado com sucesso");
            } else {
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupNameSubtype" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instrução SELECT:" + "\n" + "SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblLstOfVal() + " LOV\nWHERE LOV.TYPE = '" + type + "'\nORDER BY LOV.ORDER_BY ASC");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupNameSubtype" + "\t" + "ObjMgrSqlLog" + "\t" + "Error Exception" + "\t" + "Error: " + "Erro ao buscar LookupList");
                JOptionPane.showMessageDialog(null, "Erro ao buscar LookupList!");
            }
        } catch (HeadlessException | SQLException e){
            System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupNameSubtype" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instrução SELECT:" + "\n" + "SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblLstOfVal() + " LOV\nWHERE LOV.TYPE = '" + type + "'\nORDER BY LOV.ORDER_BY ASC");
            System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupNameSubtype" + "\t" + "ObjMgrSqlLog" + "\t" + "Error Exception" + "\t" + "Error: " + e);
            System.out.println(e);
        }
        
        return array;
    }
    
    @Override
    public ArrayList<ListOfValuesClass> queryListOfValues(String query) {
        ArrayList<ListOfValuesClass> result = new ArrayList<>();
        int count = 0;
        long tempoInicial = 0;
        long tempoFinal = 0;
        long tempoExec = 0;
        
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryListOfValues" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "BEGIN: Preparando a instrução SELECT para buscar dados na tabela");
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryListOfValues" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Owner: " + super.getDbOwner());
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryListOfValues" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Tabela: " + super.getTblLstOfVal());
        
        try{
            if("true".equals(openConnection("Buscando Lista de Valores"))){
                statement = conn.createStatement();
                tempoInicial = System.currentTimeMillis();
                ResultSet rs = statement.executeQuery(query);
                
                while(rs.next()){
                    ListOfValuesClass lookup = new ListOfValuesClass();
                    
                    lookup.setRow_id(rs.getString("ROW_ID"));
                    lookup.setCreated(rs.getString("CREATED"));
                    lookup.setCreated_by(rs.getString("CREATED_BY"));
                    lookup.setUpdated(rs.getString("LAST_UPD"));
                    lookup.setUpdated_by(rs.getString("LAST_UPD_BY"));
                    lookup.setModification_num(rs.getString("MODIFICATION_NUM"));
                    lookup.setPar_row_id(rs.getString("PAR_ROW_ID"));
                    lookup.setDb_last_upd(rs.getString("DB_LAST_UPD"));
                    lookup.setLang_id(rs.getString("LANG_ID"));
                    lookup.setRplctn_lvl_cd(rs.getString("RPLCTN_LVL_CD"));
                    lookup.setType(rs.getString("TYPE"));
                    lookup.setName(rs.getString("NAME"));
                    lookup.setValue(rs.getString("VAL"));
                    lookup.setSubtype(rs.getString("SUB_TYPE"));
                    lookup.setLang_id(rs.getString("LANG_ID"));
                    lookup.setActive_flg(rs.getString("ACTIVE_FLG"));                    
                    lookup.setOrder_by(rs.getString("ORDER_BY"));
                    lookup.setCode(rs.getString("CODE"));
                    lookup.setDesc_text(rs.getString("DESC_TEXT"));
                    
                    result.add(lookup);
                    count++;
                }
                tempoFinal = System.currentTimeMillis();
                tempoExec = tempoFinal - tempoInicial;
                
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryListOfValues" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instrução SELECT:" + "\n" + query);
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryListOfValues" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Início da execução da instrução: " + (tempoInicial / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryListOfValues" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Fim da execução da instrução: " + (tempoFinal / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryListOfValues" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Tempo total da execução da instrução: " + (tempoExec / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryListOfValues" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Total de registros encontrados: " + count);
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryListOfValues" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "END: Instrução SELECT para selecionar dados na tabela finalizada");
                
                rs.close();
                closeConnection("Lista de Valores encontrada com sucesso");
            }
        } catch (HeadlessException | SQLException e){
            System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryListOfValues" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instrução SELECT:" + "\n" + query);
            System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryListOfValues" + "\t" + "ObjMgrSqlLog" + "\t" + "Error Exception" + "\t" + "Error: " + e);
            JOptionPane.showMessageDialog(null, "Erro ao buscar registros de usuários no banco de dados!\nErro: " + e);
        }
        
        return result;
    }
    
    @Override
    public ArrayList<LanguageClass> queryLanguageRecord(String query) {
        ArrayList<LanguageClass> result = new ArrayList<>();
        int count = 0;
        long tempoInicial = 0;
        long tempoFinal = 0;
        long tempoExec = 0;
        
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryLanguageRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "BEGIN: Preparando a instrução SELECT para buscar dados na tabela");
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryLanguageRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Owner: " + super.getDbOwner());
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryLanguageRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Tabela: " + super.getTblLang());
        
        try{
            if("true".equals(openConnection("Buscando na Lista de Idiomas"))){
                statement = conn.createStatement();
                tempoInicial = System.currentTimeMillis();
                ResultSet rs = statement.executeQuery(query);
                
                while(rs.next()){
                    LanguageClass lang = new LanguageClass();
                    
                    lang.setRow_id(rs.getString("ROW_ID"));
                    lang.setCreated(rs.getString("CREATED"));
                    lang.setCreated_by(rs.getString("CREATED_BY"));
                    lang.setUpdated(rs.getString("LAST_UPD"));
                    lang.setUpdated_by(rs.getString("LAST_UPD_BY"));
                    lang.setModification_num(rs.getString("MODIFICATION_NUM"));
                    lang.setDb_last_upd(rs.getString("DB_LAST_UPD"));
                    lang.setLANG_CD(rs.getString("LANG_CD"));
                    lang.setNAME(rs.getString("NAME"));
                    lang.setVALUE(rs.getString("VALUE"));
                    lang.setORDER_BY(rs.getString("ORDER_BY"));
                    
                    result.add(lang);
                    count++;
                }
                tempoFinal = System.currentTimeMillis();
                tempoExec = tempoFinal - tempoInicial;
                
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryLanguageRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instrução SELECT:" + "\n" + query);
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryLanguageRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Início da execução da instrução: " + (tempoInicial / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryLanguageRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Fim da execução da instrução: " + (tempoFinal / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryLanguageRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Tempo total da execução da instrução: " + (tempoExec / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryLanguageRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Total de registros encontrados: " + count);
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryLanguageRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "END: Instrução SELECT para selecionar dados na tabela finalizada");
                
                rs.close();
                closeConnection("Lista de Idiomas encontrada com sucesso");
            }
        } catch (HeadlessException | SQLException e){
            System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryLanguageRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instrução SELECT:" + "\n" + query);
            System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "QueryLanguageRecord" + "\t" + "ObjMgrSqlLog" + "\t" + "Error Exception" + "\t" + "Error: " + e);
            JOptionPane.showMessageDialog(null, "Erro ao buscar registros de usuários no banco de dados!\nErro: " + e);
        }
        
        return result;
    }
    
    @Override
    public ArrayList<LanguageClass> LookupLangList() {
        ArrayList<LanguageClass> array = new ArrayList<>();
        int count = 0;
        long tempoInicial = 0;
        long tempoFinal = 0;
        long tempoExec = 0;
        
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupNameSubtype" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "BEGIN: Preparando a instrução SELECT para buscar dados na tabela");
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupNameSubtype" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Owner: " + super.getDbOwner());
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupNameSubtype" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Tabela: " + super.getTblLang());
        
        try{
            if("true".equals(openConnection("Buscando Language List"))){
                statement = conn.createStatement();
                tempoInicial = System.currentTimeMillis();
                ResultSet rs = statement.executeQuery(
                    "SELECT *\n" +
                    "FROM " + super.getDbOwner() + "." + super.getTblLang()+ " LAN\n" +
                    "ORDER BY LAN.ORDER_BY ASC"
                );
                
                while(rs.next()){
                    LanguageClass lang = new LanguageClass();
                    
                    lang.setRow_id(rs.getString("ROW_ID"));
                    lang.setCreated(rs.getString("CREATED"));
                    lang.setCreated_by(rs.getString("CREATED_BY"));
                    lang.setUpdated(rs.getString("LAST_UPD"));
                    lang.setUpdated_by(rs.getString("LAST_UPD_BY"));
                    lang.setModification_num(rs.getString("MODIFICATION_NUM"));
                    lang.setDb_last_upd(rs.getString("DB_LAST_UPD"));
                    lang.setLANG_CD(rs.getString("LANG_CD"));
                    lang.setNAME(rs.getString("NAME"));
                    lang.setVALUE(rs.getString("VALUE"));
                    lang.setORDER_BY(rs.getString("ORDER_BY"));
                    
                    array.add(lang);
                    count++;
                }
                tempoFinal = System.currentTimeMillis();
                tempoExec = tempoFinal - tempoInicial;
                
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupNameSubtype" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instrução SELECT:" + "\n" + "SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblLang() + " LAN\nORDER BY LAN.ORDER_BY ASC");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupNameSubtype" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Início da execução da instrução: " + (tempoInicial / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupNameSubtype" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Fim da execução da instrução: " + (tempoFinal / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupNameSubtype" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Tempo total da execução da instrução: " + (tempoExec / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupNameSubtype" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Total de registros encontrados: " + count);
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupNameSubtype" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "END: Instrução SELECT para selecionar dados na tabela finalizada");
                
                rs.close();
                closeConnection("Language List encontrado com sucesso");
            } else {
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupNameSubtype" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instrução SELECT:" + "\n" + "SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblLang() + " LAN\nORDER BY LAN.ORDER_BY ASC");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupNameSubtype" + "\t" + "ObjMgrSqlLog" + "\t" + "Error Exception" + "\t" + "Error: " + "Erro ao buscar LookupList");
                JOptionPane.showMessageDialog(null, "Erro ao buscar LookupList!");
            }
        } catch (HeadlessException | SQLException e){
            System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupNameSubtype" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instrução SELECT:" + "\n" + "SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblLang() + " LOV\nORDER BY LAN.ORDER_BY ASC");
            System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupNameSubtype" + "\t" + "ObjMgrSqlLog" + "\t" + "Error Exception" + "\t" + "Error: " + e);
            System.out.println(e);
        }
        
        return array;
    }
    
    @Override
    public String LookupLangValue(String name){
        String value = null;
        int count = 0;
        long tempoInicial = 0;
        long tempoFinal = 0;
        long tempoExec = 0;
        
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangValue" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "BEGIN: Preparando a instrução SELECT para buscar dados na tabela");
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangValue" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Owner: " + super.getDbOwner());
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangValue" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Tabela: " + super.getTblLang());
        
        try{
            if("true".equals(openConnection("Buscando Language Value com Name: '" + name + "'"))){
                statement = conn.createStatement();
                tempoInicial = System.currentTimeMillis();
                ResultSet rs = statement.executeQuery(
                    "SELECT\n\t" +
                    "LAN.VALUE\n" +
                    "FROM " + super.getDbOwner() + "." + super.getTblLang()+ " LAN\n" +
                    "WHERE LAN.NAME = '" + name + "'\n" +
                    "ORDER BY LAN.ORDER_BY ASC"
                );
                
                while(rs.next()){
                    value = rs.getString("VALUE");
                    count++;
                }
                tempoFinal = System.currentTimeMillis();
                tempoExec = tempoFinal - tempoInicial;
                
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangValue" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instrução SELECT:" + "\n" + "SELECT\n\tLAN.VALUE\nFROM " + super.getDbOwner() + "." + super.getTblLang() + " LAN\nWHERE LAN.NAME = '" + name + "'\nORDER BY LAN.ORDER_BY ASC");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangValue" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Início da execução da instrução: " + (tempoInicial / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangValue" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Fim da execução da instrução: " + (tempoFinal / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangValue" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Tempo total da execução da instrução: " + (tempoExec / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangValue" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Total de registros encontrados: " + count);
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangValue" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "END: Instrução SELECT para selecionar dados na tabela finalizada");
                
                rs.close();
                closeConnection("Language Name: '" + name + "', retornou o Value: '" + value + "' com sucesso");
            } else {
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangValue" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instrução SELECT:" + "\n" + "SELECT\n\tLAN.VALUE\nFROM " + super.getDbOwner() + "." + super.getTblLang() + " LAN\nWHERE LAN.NAME = '" + name + "'\nORDER BY LAN.ORDER_BY ASC");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangValue" + "\t" + "ObjMgrSqlLog" + "\t" + "Error Exception" + "\t" + "Error: " + "Erro ao buscar LookupValue");
                JOptionPane.showMessageDialog(null, "Erro ao buscar LookupValue");
            }
        } catch (HeadlessException | SQLException e){
            System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangValue" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instrução SELECT:" + "\n" + "SELECT\n\tLAN.VALUE\nFROM " + super.getDbOwner() + "." + super.getTblLang() + " LAN\nWHERE LAN.NAME = '" + name + "'\nORDER BY LAN.ORDER_BY ASC");
            System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangValue" + "\t" + "ObjMgrSqlLog" + "\t" + "Error Exception" + "\t" + "Error: " + e);
            System.out.println(e);
        }
        
        return value;
    }
    
    @Override
    public String LookupLangValueByCode(String code){
        String value = null;
        int count = 0;
        long tempoInicial = 0;
        long tempoFinal = 0;
        long tempoExec = 0;
        
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangValueByCode" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "BEGIN: Preparando a instrução SELECT para buscar dados na tabela");
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangValueByCode" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Owner: " + super.getDbOwner());
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangValueByCode" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Tabela: " + super.getTblLang());
        
        try{
            if("true".equals(openConnection("Buscando Language Value com Code: '" + code + "'"))){
                statement = conn.createStatement();
                tempoInicial = System.currentTimeMillis();
                ResultSet rs = statement.executeQuery(
                    "SELECT\n\t" +
                    "LAN.VALUE\n" +
                    "FROM " + super.getDbOwner() + "." + super.getTblLang()+ " LAN\n" +
                    "WHERE LAN.LANG_CD = '" + code + "'\n" +
                    "ORDER BY LAN.ORDER_BY ASC"
                );
                
                while(rs.next()){
                    value = rs.getString("VALUE");
                    count++;
                }
                tempoFinal = System.currentTimeMillis();
                tempoExec = tempoFinal - tempoInicial;
                
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangValueByCode" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instrução SELECT:" + "\n" + "SELECT\n\tLAN.VALUE\nFROM " + super.getDbOwner() + "." + super.getTblLang() + " LAN\nWHERE LAN.LANG_CD = '" + code + "'\nORDER BY LAN.ORDER_BY ASC");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangValueByCode" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Início da execução da instrução: " + (tempoInicial / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangValueByCode" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Fim da execução da instrução: " + (tempoFinal / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangValueByCode" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Tempo total da execução da instrução: " + (tempoExec / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangValueByCode" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Total de registros encontrados: " + count);
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangValue" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "END: Instrução SELECT para selecionar dados na tabela finalizada");
                
                rs.close();
                closeConnection("Language Code: '" + code + "', retornou o Value: '" + value + "' com sucesso");
            } else {
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangValueByCode" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instrução SELECT:" + "\n" + "SELECT\n\tLAN.VALUE\nFROM " + super.getDbOwner() + "." + super.getTblLang() + " LAN\nWHERE LAN.LANG_CD = '" + code + "'\nORDER BY LAN.ORDER_BY ASC");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangValueByCode" + "\t" + "ObjMgrSqlLog" + "\t" + "Error Exception" + "\t" + "Error: " + "Erro ao buscar LookupValue");
                JOptionPane.showMessageDialog(null, "Erro ao buscar LookupValue");
            }
        } catch (HeadlessException | SQLException e){
            System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangValueByCode" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instrução SELECT:" + "\n" + "SELECT\n\tLAN.VALUE\nFROM " + super.getDbOwner() + "." + super.getTblLang() + " LAN\nWHERE LAN.LANG_CD = '" + code + "'\nORDER BY LAN.ORDER_BY ASC");
            System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangValueByCode" + "\t" + "ObjMgrSqlLog" + "\t" + "Error Exception" + "\t" + "Error: " + e);
            System.out.println(e);
        }
        
        return value;
    }
    
    @Override
    public String LookupLangNameByCode(String code) {
        String value = null;
        int count = 0;
        long tempoInicial = 0;
        long tempoFinal = 0;
        long tempoExec = 0;
        
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangValueByCode" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "BEGIN: Preparando a instrução SELECT para buscar dados na tabela");
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangValueByCode" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Owner: " + super.getDbOwner());
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangValueByCode" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Tabela: " + super.getTblLang());
        
        try{
            if("true".equals(openConnection("Buscando Language Name com Code: '" + code + "'"))){
                statement = conn.createStatement();
                tempoInicial = System.currentTimeMillis();
                ResultSet rs = statement.executeQuery(
                    "SELECT\n\t" +
                    "LAN.NAME\n" +
                    "FROM " + super.getDbOwner() + "." + super.getTblLang()+ " LAN\n" +
                    "WHERE LAN.LANG_CD = '" + code + "'\n" +
                    "ORDER BY LAN.ORDER_BY ASC"
                );
                
                while(rs.next()){
                    value = rs.getString("NAME");
                    count++;
                }
                tempoFinal = System.currentTimeMillis();
                tempoExec = tempoFinal - tempoInicial;
                
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangValueByCode" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instrução SELECT:" + "\n" + "SELECT\n\tLAN.NAME\nFROM " + super.getDbOwner() + "." + super.getTblLang() + " LAN\nWHERE LAN.LANG_CD = '" + code + "'\nORDER BY LAN.ORDER_BY ASC");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangValueByCode" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Início da execução da instrução: " + (tempoInicial / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangValueByCode" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Fim da execução da instrução: " + (tempoFinal / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangValueByCode" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Tempo total da execução da instrução: " + (tempoExec / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangValueByCode" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Total de registros encontrados: " + count);
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangValue" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "END: Instrução SELECT para selecionar dados na tabela finalizada");
                
                rs.close();
                closeConnection("Language Code: '" + code + "', retornou o Name: '" + value + "' com sucesso");
            } else {
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangValueByCode" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instrução SELECT:" + "\n" + "SELECT\n\tLAN.NAME\nFROM " + super.getDbOwner() + "." + super.getTblLang() + " LAN\nWHERE LAN.LANG_CD = '" + code + "'\nORDER BY LAN.ORDER_BY ASC");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangValueByCode" + "\t" + "ObjMgrSqlLog" + "\t" + "Error Exception" + "\t" + "Error: " + "Erro ao buscar LookupValue");
                JOptionPane.showMessageDialog(null, "Erro ao buscar LookupValue");
            }
        } catch (HeadlessException | SQLException e){
            System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangValueByCode" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instrução SELECT:" + "\n" + "SELECT\n\tLAN.NAME\nFROM " + super.getDbOwner() + "." + super.getTblLang() + " LAN\nWHERE LAN.LANG_CD = '" + code + "'\nORDER BY LAN.ORDER_BY ASC");
            System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangValueByCode" + "\t" + "ObjMgrSqlLog" + "\t" + "Error Exception" + "\t" + "Error: " + e);
            System.out.println(e);
        }
        
        return value;
    }
    
    @Override
    public String LookupLangName(String value){
        String result = null;
        int count = 0;
        long tempoInicial = 0;
        long tempoFinal = 0;
        long tempoExec = 0;
        
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangName" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "BEGIN: Preparando a instrução SELECT para buscar dados na tabela");
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangName" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Owner: " + super.getDbOwner());
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangName" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Tabela: " + super.getTblLang());
        
        try{
            if("true".equals(openConnection("Buscando Language Name com Value: '" + value + "'"))){
                statement = conn.createStatement();
                tempoInicial = System.currentTimeMillis();
                ResultSet rs = statement.executeQuery(
                    "SELECT\n\t" +
                    "LAN.NAME\n" +
                    "FROM " + super.getDbOwner() + "." + super.getTblLang()+ " LAN\n" +
                    "WHERE LAN.VALUE = '" + value + "'\n" +
                    "ORDER BY LAN.ORDER_BY ASC"
                );
                
                while(rs.next()){
                    result = rs.getString("NAME");
                    count++;
                }
                tempoFinal = System.currentTimeMillis();
                tempoExec = tempoFinal - tempoInicial;
                
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangName" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instrução SELECT:" + "\n" + "SELECT\n\tLAN.NAME\nFROM " + super.getDbOwner() + "." + super.getTblLang() + " LAN\nWHERE LAN.VALUE = '" + value + "'\nORDER BY LAN.ORDER_BY ASC");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangName" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Início da execução da instrução: " + (tempoInicial / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangName" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Fim da execução da instrução: " + (tempoFinal / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangName" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Tempo total da execução da instrução: " + (tempoExec / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangName" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Total de registros encontrados: " + count);
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangName" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "END: Instrução SELECT para selecionar dados na tabela finalizada");
                
                rs.close();
                closeConnection("Language Value: '" + value + "', retornou o Name: '" + result + "' com sucesso");
            } else {
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangName" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instrução SELECT:" + "\n" + "SELECT\n\tLAN.NAME\nFROM " + super.getDbOwner() + "." + super.getTblLang() + " LAN\nWHERE LAN.VALUE = '" + value + "'\nORDER BY LAN.ORDER_BY ASC");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangName" + "\t" + "ObjMgrSqlLog" + "\t" + "Error Exception" + "\t" + "Error: " + "Erro ao buscar LookupValue");
                JOptionPane.showMessageDialog(null, "Erro ao buscar LookupValue");
            }
        } catch (HeadlessException | SQLException e){
            System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangName" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instrução SELECT:" + "\n" + "SELECT\n\tLAN.NAME\nFROM " + super.getDbOwner() + "." + super.getTblLang() + " LAN\nWHERE LAN.VALUE = '" + value + "'\nORDER BY LAN.ORDER_BY ASC");
            System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangName" + "\t" + "ObjMgrSqlLog" + "\t" + "Error Exception" + "\t" + "Error: " + e);
            System.out.println(e);
        }
        
        return result;
    }
        
    @Override
    public String LookupLangCodeByName(String name) {
        String value = null;
        int count = 0;
        long tempoInicial = 0;
        long tempoFinal = 0;
        long tempoExec = 0;
        
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangCodeByName" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "BEGIN: Preparando a instrução SELECT para buscar dados na tabela");
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangCodeByName" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Owner: " + super.getDbOwner());
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangCodeByName" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Tabela: " + super.getTblLang());
        
        try{
            if("true".equals(openConnection("Buscando Language Code com Name: '" + name + "'"))){
                statement = conn.createStatement();
                tempoInicial = System.currentTimeMillis();
                ResultSet rs = statement.executeQuery(
                    "SELECT\n\t" +
                    "LAN.LANG_CD\n" +
                    "FROM " + super.getDbOwner() + "." + super.getTblLang()+ " LAN\n" +
                    "WHERE LAN.NAME = '" + name + "'\n" +
                    "ORDER BY LAN.ORDER_BY ASC"
                );
                
                while(rs.next()){
                    value = rs.getString("LANG_CD");
                    count++;
                }
                tempoFinal = System.currentTimeMillis();
                tempoExec = tempoFinal - tempoInicial;
                
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangCodeByName" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instrução SELECT:" + "\n" + "SELECT\n\tLAN.LANG_CD\nFROM " + super.getDbOwner() + "." + super.getTblLang() + " LAN\nWHERE LAN.NAME = '" + name + "'\nORDER BY LAN.ORDER_BY ASC");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangCodeByName" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Início da execução da instrução: " + (tempoInicial / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangCodeByName" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Fim da execução da instrução: " + (tempoFinal / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangCodeByName" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Tempo total da execução da instrução: " + (tempoExec / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangCodeByName" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Total de registros encontrados: " + count);
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangCodeByName" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "END: Instrução SELECT para selecionar dados na tabela finalizada");
                
                rs.close();
                closeConnection("Language Name: '" + name + "', retornou o Code: '" + value + "' com sucesso");
            } else {
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangCodeByName" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instrução SELECT:" + "\n" + "SELECT\n\tLAN.LANG_CD\nFROM " + super.getDbOwner() + "." + super.getTblLang() + " LAN\nWHERE LAN.NAME = '" + name + "'\nORDER BY LAN.ORDER_BY ASC");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangCodeByName" + "\t" + "ObjMgrSqlLog" + "\t" + "Error Exception" + "\t" + "Error: " + "Erro ao buscar LookupValue");
                JOptionPane.showMessageDialog(null, "Erro ao buscar LookupValue");
            }
        } catch (HeadlessException | SQLException e){
            System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangCodeByName" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instrução SELECT:" + "\n" + "SELECT\n\tLAN.LANG_CD\nFROM " + super.getDbOwner() + "." + super.getTblLang() + " LAN\nWHERE LAN.NAME = '" + name + "'\nORDER BY LAN.ORDER_BY ASC");
            System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangCodeByName" + "\t" + "ObjMgrSqlLog" + "\t" + "Error Exception" + "\t" + "Error: " + e);
            System.out.println(e);
        }
        
        return value;
    }
    
    @Override
    public String LookupLangCodeByValue(String value){
        String retorno = null;
        int count = 0;
        long tempoInicial = 0;
        long tempoFinal = 0;
        long tempoExec = 0;
        
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangCodeByName" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "BEGIN: Preparando a instrução SELECT para buscar dados na tabela");
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangCodeByName" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Owner: " + super.getDbOwner());
        System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangCodeByName" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Tabela: " + super.getTblLang());
        
        try{
            if("true".equals(openConnection("Buscando Language Code com Value: '" + value + "'"))){
                statement = conn.createStatement();
                tempoInicial = System.currentTimeMillis();
                ResultSet rs = statement.executeQuery(
                    "SELECT\n\t" +
                    "LAN.LANG_CD\n" +
                    "FROM " + super.getDbOwner() + "." + super.getTblLang()+ " LAN\n" +
                    "WHERE LAN.VALUE = '" + value + "'\n" +
                    "ORDER BY LAN.ORDER_BY ASC"
                );
                
                while(rs.next()){
                    retorno = rs.getString("LANG_CD");
                    count++;
                }
                tempoFinal = System.currentTimeMillis();
                tempoExec = tempoFinal - tempoInicial;
                
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangCodeByName" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instrução SELECT:" + "\n" + "SELECT\n\tLAN.LANG_CD\nFROM " + super.getDbOwner() + "." + super.getTblLang() + " LAN\nWHERE LAN.VALUE = '" + value + "'\nORDER BY LAN.ORDER_BY ASC");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangCodeByName" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Início da execução da instrução: " + (tempoInicial / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangCodeByName" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Fim da execução da instrução: " + (tempoFinal / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangCodeByName" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\n" + "***** Tempo total da execução da instrução: " + (tempoExec / 1000.0) + " segundos *****\n");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangCodeByName" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "Total de registros encontrados: " + count);
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangCodeByName" + "\t" + "ObjMgrSqlLog" + "\t" + "ExecuteQuery" + "\t" + "END: Instrução SELECT para selecionar dados na tabela finalizada");
                
                rs.close();
                closeConnection("Language Value: '" + value + "', retornou o Code: '" + retorno + "' com sucesso");
            } else {
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangCodeByName" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instrução SELECT:" + "\n" + "SELECT\n\tLAN.LANG_CD\nFROM " + super.getDbOwner() + "." + super.getTblLang() + " LAN\nWHERE LAN.VALUE = '" + value + "'\nORDER BY LAN.ORDER_BY ASC");
                System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangCodeByName" + "\t" + "ObjMgrSqlLog" + "\t" + "Error Exception" + "\t" + "Error: " + "Erro ao buscar LookupValue");
                JOptionPane.showMessageDialog(null, "Erro ao buscar LookupValue");
            }
        } catch (HeadlessException | SQLException e){
            System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangCodeByName" + "\t" + "ObjMgrSqlLog" + "\t" + "Detail" + "\t" + "Instrução SELECT:" + "\n" + "SELECT\n\tLAN.LANG_CD\nFROM " + super.getDbOwner() + "." + super.getTblLang() + " LAN\nWHERE LAN.VALUE = '" + value + "'\nORDER BY LAN.ORDER_BY ASC");
            System.out.println("\n" + super.getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "LookupLangCodeByName" + "\t" + "ObjMgrSqlLog" + "\t" + "Error Exception" + "\t" + "Error: " + e);
            System.out.println(e);
        }
        
        return retorno;
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
        private String PAR_POSTN_ID;
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
            this.PAR_POSTN_ID = null;
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

        public String getPAR_POSTN_ID() { return PAR_POSTN_ID; }
        public void setPAR_POSTN_ID(String PAR_POSTN_ID) { this.PAR_POSTN_ID = PAR_POSTN_ID; }
        
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
    
    public class PositionPerClass {
        private String row_id;
        private String created;
        private String created_by;
        private String updated;
        private String updated_by;
        private String modification_num;
        private String par_row_id;
        private String db_last_upd;
        private String PERMITION_NAME;
        private String PERMITION_VALUE;
        private String PERMITION_FLG;
        private String PERMITION_DESC;
        private String ORDER_BY;
        private String COMMENTS;
                
        public PositionPerClass(){
            this.row_id = null;
            this.created = null;
            this.created_by = null;
            this.updated = null;
            this.updated_by = null;
            this.modification_num = null;
            this.par_row_id = null;
            this.db_last_upd = null;
            this.PERMITION_NAME = null;
            this.PERMITION_VALUE = null;
            this.PERMITION_FLG = null;
            this.ORDER_BY = null;
            this.PERMITION_DESC = null;
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

        public String getPERMITION_NAME() { return PERMITION_NAME; }
        public void setPERMITION_NAME(String PERMITION_NAME) { this.PERMITION_NAME = PERMITION_NAME; }

        public String getPERMITION_VALUE() { return PERMITION_VALUE; }
        public void setPERMITION_VALUE(String PERMITION_VALUE) { this.PERMITION_VALUE = PERMITION_VALUE; }

        public String getPERMITION_FLG() { return PERMITION_FLG; }
        public void setPERMITION_FLG(String PERMITION_FLG) { this.PERMITION_FLG = PERMITION_FLG; }

        public String getPERMITION_DESC() { return PERMITION_DESC; }
        public void setPERMITION_DESC(String PERMITION_DESC) { this.PERMITION_DESC = PERMITION_DESC; }

        public String getORDER_BY() { return ORDER_BY; }
        public void setORDER_BY(String ORDER_BY) { this.ORDER_BY = ORDER_BY; }
        
        public String getCOMMENTS() { return COMMENTS; }
        public void setCOMMENTS(String COMMENTS) { this.COMMENTS = COMMENTS; }
        
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
    
    public class SocialMediaClass {
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

        public SocialMediaClass(){
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
    
    public class LanguageClass {
        private String row_id;
        private String created;
        private String created_by;
        private String updated;
        private String updated_by;
        private String modification_num;
        private String db_last_upd;
        private String LANG_CD;
        private String NAME;        
        private String VALUE;
        private String ORDER_BY;
        
        public LanguageClass() {
            this.row_id = null;
            this.created = null;
            this.created_by = null;
            this.updated = null;
            this.updated_by = null;
            this.modification_num = null;
            this.db_last_upd = null;
            this.LANG_CD = null;
            this.NAME = null;
            this.VALUE = null;
            this.ORDER_BY = null;
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

        public String getDb_last_upd() { return db_last_upd; }
        public void setDb_last_upd(String db_last_upd) { this.db_last_upd = db_last_upd; }

        public String getLANG_CD() { return LANG_CD; }
        public void setLANG_CD(String LANG_CD) { this.LANG_CD = LANG_CD; }

        public String getNAME() { return NAME; }
        public void setNAME(String NAME) { this.NAME = NAME; }

        public String getVALUE() { return VALUE; }
        public void setVALUE(String VALUE) { this.VALUE = VALUE; }

        public String getORDER_BY() { return ORDER_BY; }
        public void setORDER_BY(String ORDER_BY) { this.ORDER_BY = ORDER_BY; }
        
    }
    
    public class dbSettingsScreenListener implements WindowListener {

        @Override
        public void windowOpened(WindowEvent we) { }

        @Override
        public void windowClosing(WindowEvent we) { }

        @Override
        public void windowClosed(WindowEvent we) {
            if(dbSetCtrl.verifyFileExists()){
                readParameters();
            } else {
                if(wishConfDbLScreen()){
                    dbSetCtrl.openDbSettingsScreen();
                    dbSetCtrl.setListenerDBSettingsScreen(new dbSettingsScreenListener());
                } else {
                    System.exit(0);
                }
            }
        }

        @Override
        public void windowIconified(WindowEvent we) { }

        @Override
        public void windowDeiconified(WindowEvent we) { }

        @Override
        public void windowActivated(WindowEvent we) { }

        @Override
        public void windowDeactivated(WindowEvent we) { }
        
    }
    
    
}