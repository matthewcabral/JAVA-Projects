/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SystemSettingsModule;

import databaseModule.DataController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Matheus Cabral Rosa
 */
public class DatabaseSettingsController extends DataController {
    
    // Classes Instances
    DatabaseSettingsScreen dbSettingScr;

    public DatabaseSettingsController(String dbUser, String dbPassword) {
        super.setDbUser(dbUser);
        super.setDbPassword(dbPassword);
        dbSettingScr = new DatabaseSettingsScreen();
        this.screenOnLoadEnviromentSettings(true, "Selecione...");
        this.screenOnLoadDBLinkSettings();
        dbSettingScr.setListenerBtnDbLinkSave(new insertDbLinkSave());
        dbSettingScr.setListenerBtnDbLinkSaveAdd(new insertDbLinkSaveAndAdd());
        dbSettingScr.setListenerBtnDbLinkDelete(new deleteDbLink());
        dbSettingScr.setListenerEnvCbbProjectFilter(new projectSelectedItemListener());
        dbSettingScr.setListenerBtnEnvDelete(new deleteEnviromentObj());
        dbSettingScr.setListenerBtnEnvSave(new insertEnviromentSave());
        dbSettingScr.setListenerBtnEnvSaveAdd(new insertEnviromentSaveAndAdd());
    }
    
    // Functions
    
    // Enviroments
    // Function to show the result on screen
    public void screenOnLoadEnviromentSettings(boolean clearObjects, String Project){
        dbSettingScr.clearcbbProjectFilter();
        dbSettingScr.insertcbbProjectFilter("Selecione...");
        if(clearObjects) {
            dbSettingScr.cleartxtProj();
            dbSettingScr.clearcbbType();
            dbSettingScr.cleartxtObjType();
            dbSettingScr.cleartxtOrder();
            dbSettingScr.cleartxtDescription();
            dbSettingScr.cleartxtTableN0();
            dbSettingScr.cleartxtTableN1();
            dbSettingScr.cleartxtTableN2();
            dbSettingScr.cleartxtTableN3();
            dbSettingScr.cleartxtTable();
            dbSettingScr.cleartxtJoinN0();
            dbSettingScr.cleartxtJoinN1();
            dbSettingScr.cleartxtJoinN2();
            dbSettingScr.cleartxtJoinN3();
            dbSettingScr.cleartxtSearchSpec();
            dbSettingScr.cleartxtKeyField();
            dbSettingScr.cleartxtLine();
            dbSettingScr.clearrdbActive();
            dbSettingScr.insertrdbActive("Y");
            dbSettingScr.insertcbbType("Selecione...");
        }
        
        try{
            super.openConnection("Buscando: Projetos...");
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT DISTINCT CONFIGURATION_NAME FROM SADMIN.TAB_CTRL_BATIMENTO_REP ORDER BY CONFIGURATION_NAME ASC");

            while(rs.next()){
                dbSettingScr.insertcbbProjectFilter(rs.getString("CONFIGURATION_NAME"));
            }
            rs.close();
            
            if(clearObjects) {
                rs = statement.executeQuery("SELECT DISTINCT TYPE FROM SADMIN.TAB_CTRL_BATIMENTO_REP ORDER BY TYPE ASC");

                while(rs.next()){
                    dbSettingScr.insertcbbType(rs.getString("TYPE"));
                }
                rs.close();
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de leitura no Banco de Dados!\nMensagem: " + e,"Erro",JOptionPane.ERROR_MESSAGE);
        } finally{
            closeConnection("Projetos exibidos com sucesso!");
        }
        if(clearObjects) {
            showOnTable(true, "Selecione...");
        } else {
            showOnTable(false, Project);
        }
        dbSettingScr.setFocus("ENV_PROJECT_FILTER");
    }
    
    // Function to populate data on Screen Table
    public void showOnTable(boolean onLoad, String Project) {
        try{
            // This ArrayList is based on the "resultByThread" class and receive the result of the function getThreadResult().
            // This Function do a Select Query on the CTRL_LOG_COMP_REP table
            ArrayList<enviromentSettings> arrayEnv;
            if(onLoad){
                arrayEnv = queryEnviroments();
            } else {
               arrayEnv = queryEnviromentsFilter(Project);
            }
               

            // Fills in the table "Resultado por Thread"
            DefaultTableModel model = (DefaultTableModel) dbSettingScr.tblEnvList.getModel();
            model.setNumRows(arrayEnv.size());

            for (int i = 0; i < arrayEnv.size(); i++) {
                model.setValueAt(arrayEnv.get(i).getID(), i, 0);
                model.setValueAt(arrayEnv.get(i).getFILA(), i, 1);
                model.setValueAt(arrayEnv.get(i).getCONFIGURATION_NAME(), i, 2);
                model.setValueAt(arrayEnv.get(i).getTYPE(), i, 3);
                model.setValueAt(arrayEnv.get(i).getGROUP_OBJECT(), i, 4);
                model.setValueAt(arrayEnv.get(i).getORDER_COL(), i, 5);
                model.setValueAt(arrayEnv.get(i).getDESCRIPTION(), i, 6);
                model.setValueAt(arrayEnv.get(i).getTAB_P0(), i, 7);
                model.setValueAt(arrayEnv.get(i).getTAB_P1(), i, 8);
                model.setValueAt(arrayEnv.get(i).getTAB_P2(), i, 9);
                model.setValueAt(arrayEnv.get(i).getTAB_P3(), i, 10);
                model.setValueAt(arrayEnv.get(i).getTABLE_NAME(), i, 11);
                model.setValueAt(arrayEnv.get(i).getJOIN0(), i, 12);
                model.setValueAt(arrayEnv.get(i).getJOIN1(), i, 13);
                model.setValueAt(arrayEnv.get(i).getJOIN2(), i, 14);
                model.setValueAt(arrayEnv.get(i).getJOIN3(), i, 15);
                model.setValueAt(arrayEnv.get(i).getINACTIVE_FLG(), i, 16);
                model.setValueAt(arrayEnv.get(i).getOTHER_KEY_FIELD(), i, 17);
                model.setValueAt(arrayEnv.get(i).getADDITIONAL_SEARCH(), i, 18);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher a tabela.\nMensagem: " + e,"Erro",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Function used to return the data of the select instruction into a Arraylist
    private ArrayList<enviromentSettings> queryEnviroments(){        
        // ArrayList used to return the select query result
        ArrayList<enviromentSettings> result = new ArrayList<>();
        
        try{
            super.openConnection("Buscando: DBLINK's existentes...");
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM SADMIN.TAB_CTRL_BATIMENTO_REP ORDER BY FILA ASC");

            while(rs.next()){
                enviromentSettings env = new enviromentSettings();
                
                env.setID(rs.getString("ID"));
                env.setFILA(rs.getString("FILA"));
                env.setCONFIGURATION_NAME(rs.getString("CONFIGURATION_NAME"));
                env.setTYPE(rs.getString("TYPE"));
                env.setGROUP_OBJECT(rs.getString("GROUP_OBJECT"));
                env.setORDER_COL(rs.getString("ORDER_COL"));
                env.setDESCRIPTION(rs.getString("DESCRIPTION"));
                env.setTAB_P0(rs.getString("TAB_P0"));
                env.setTAB_P1(rs.getString("TAB_P1"));
                env.setTAB_P2(rs.getString("TAB_P2"));
                env.setTAB_P3(rs.getString("TAB_P3"));
                env.setTABLE_NAME(rs.getString("TABLE_NAME"));
                env.setJOIN0(rs.getString("JOIN0"));
                env.setJOIN1(rs.getString("JOIN1"));
                env.setJOIN2(rs.getString("JOIN2"));
                env.setJOIN3(rs.getString("JOIN3"));
                env.setINACTIVE_FLG(rs.getString("INACTIVE_FLG"));
                env.setOTHER_KEY_FIELD(rs.getString("OTHER_KEY_FIELD"));
                env.setADDITIONAL_SEARCH(rs.getString("ADDITIONAL_SEARCH"));
                
                result.add(env);
            }
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de leitura no Banco de Dados!\nMensagem: " + e,"Erro",JOptionPane.ERROR_MESSAGE);
        } finally{
            closeConnection("Relatório gerado com sucesso!");
        }
        return result;
    }
    
    private ArrayList<enviromentSettings> queryEnviromentsFilter(String PROJECT){        
        // ArrayList used to return the select query result
        ArrayList<enviromentSettings> result = new ArrayList<>();
        
        try{
            super.openConnection("Buscando: DBLINK's existentes...");
            statement = conn.createStatement();
            ResultSet rs;
            if("Selecione...".equals(PROJECT)){
                rs = statement.executeQuery("SELECT * FROM SADMIN.TAB_CTRL_BATIMENTO_REP ORDER BY FILA ASC");
            } else {
                rs = statement.executeQuery("SELECT * FROM SADMIN.TAB_CTRL_BATIMENTO_REP WHERE CONFIGURATION_NAME = '" + PROJECT + "' ORDER BY FILA ASC");
            }
            while(rs.next()){
                enviromentSettings env = new enviromentSettings();
                
                env.setID(rs.getString("ID"));
                env.setFILA(rs.getString("FILA"));
                env.setCONFIGURATION_NAME(rs.getString("CONFIGURATION_NAME"));
                env.setTYPE(rs.getString("TYPE"));
                env.setGROUP_OBJECT(rs.getString("GROUP_OBJECT"));
                env.setORDER_COL(rs.getString("ORDER_COL"));
                env.setDESCRIPTION(rs.getString("DESCRIPTION"));
                env.setTAB_P0(rs.getString("TAB_P0"));
                env.setTAB_P1(rs.getString("TAB_P1"));
                env.setTAB_P2(rs.getString("TAB_P2"));
                env.setTAB_P3(rs.getString("TAB_P3"));
                env.setTABLE_NAME(rs.getString("TABLE_NAME"));
                env.setJOIN0(rs.getString("JOIN0"));
                env.setJOIN1(rs.getString("JOIN1"));
                env.setJOIN2(rs.getString("JOIN2"));
                env.setJOIN3(rs.getString("JOIN3"));
                env.setINACTIVE_FLG(rs.getString("INACTIVE_FLG"));
                env.setOTHER_KEY_FIELD(rs.getString("OTHER_KEY_FIELD"));
                env.setADDITIONAL_SEARCH(rs.getString("ADDITIONAL_SEARCH"));
                
                result.add(env);
            }
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de leitura no Banco de Dados!\nMensagem: " + e,"Erro",JOptionPane.ERROR_MESSAGE);
        } finally{
            closeConnection("Relatório gerado com sucesso!");
        }
        return result;
    }
    
    private class enviromentSettings {
        // Enviroment Variables
        private String ID;
        private String FILA;
        private String CONFIGURATION_NAME;
        private String TYPE;
        private String GROUP_OBJECT;
        private String ORDER_COL;
        private String DESCRIPTION;
        private String TAB_P0;
        private String TAB_P1;
        private String TAB_P2;
        private String TAB_P3;
        private String TABLE_NAME;
        private String JOIN0;
        private String JOIN1;
        private String JOIN2;
        private String JOIN3;
        private String INACTIVE_FLG;
        private String OTHER_KEY_FIELD;
        private String ADDITIONAL_SEARCH;

        public enviromentSettings() {
            this.ID = null;
            this.FILA = null;
            this.CONFIGURATION_NAME = null;
            this.TYPE = null;
            this.GROUP_OBJECT = null;
            this.ORDER_COL = null;
            this.DESCRIPTION = null;
            this.TAB_P0 = null;
            this.TAB_P1 = null;
            this.TAB_P2 = null;
            this.TAB_P3 = null;
            this.TABLE_NAME = null;
            this.JOIN0 = null;
            this.JOIN1 = null;
            this.JOIN2 = null;
            this.JOIN3 = null;
            this.INACTIVE_FLG = null;
            this.OTHER_KEY_FIELD = null;
            this.ADDITIONAL_SEARCH = null;
        }
        
        // Getters and Setters
        public String getID() { return ID; } 
        public void setID(String ID) { this.ID = ID; }
        
        public String getFILA() { return FILA; } 
        public void setFILA(String FILA) { this.FILA = FILA; }

        public String getCONFIGURATION_NAME() { return CONFIGURATION_NAME; } 
        public void setCONFIGURATION_NAME(String CONFIGURATION_NAME) { this.CONFIGURATION_NAME = CONFIGURATION_NAME; }

        public String getTYPE() { return TYPE; } 
        public void setTYPE(String TYPE) { this.TYPE = TYPE; }

        public String getGROUP_OBJECT() { return GROUP_OBJECT; }
        public void setGROUP_OBJECT(String GROUP_OBJECT) { this.GROUP_OBJECT = GROUP_OBJECT; }

        public String getORDER_COL() { return ORDER_COL; }
        public void setORDER_COL(String ORDER_COL) { this.ORDER_COL = ORDER_COL; }

        public String getDESCRIPTION() { return DESCRIPTION; }
        public void setDESCRIPTION(String DESCRIPTION) { this.DESCRIPTION = DESCRIPTION; }

        public String getTABLE_NAME() { return TABLE_NAME; }
        public void setTABLE_NAME(String TABLE_NAME) { this.TABLE_NAME = TABLE_NAME; }

        public String getJOIN3() { return JOIN3; }
        public void setJOIN3(String JOIN3) { this.JOIN3 = JOIN3; }

        public String getTAB_P3() { return TAB_P3; }
        public void setTAB_P3(String TAB_P3) { this.TAB_P3 = TAB_P3; }

        public String getJOIN2() { return JOIN2; }
        public void setJOIN2(String JOIN2) { this.JOIN2 = JOIN2; }

        public String getTAB_P2() { return TAB_P2; }
        public void setTAB_P2(String TAB_P2) { this.TAB_P2 = TAB_P2; }

        public String getJOIN1() { return JOIN1; }
        public void setJOIN1(String JOIN1) { this.JOIN1 = JOIN1; }

        public String getTAB_P1() { return TAB_P1; }
        public void setTAB_P1(String TAB_P1) { this.TAB_P1 = TAB_P1; }

        public String getJOIN0() { return JOIN0; }
        public void setJOIN0(String JOIN0) { this.JOIN0 = JOIN0; }

        public String getTAB_P0() { return TAB_P0; }
        public void setTAB_P0(String TAB_P0) { this.TAB_P0 = TAB_P0; }

        public String getINACTIVE_FLG() { return INACTIVE_FLG; }
        public void setINACTIVE_FLG(String INACTIVE_FLG) { this.INACTIVE_FLG = INACTIVE_FLG; }

        public String getOTHER_KEY_FIELD() { return OTHER_KEY_FIELD; }
        public void setOTHER_KEY_FIELD(String OTHER_KEY_FIELD) { this.OTHER_KEY_FIELD = OTHER_KEY_FIELD; }

        public String getADDITIONAL_SEARCH() { return ADDITIONAL_SEARCH; }
        public void setADDITIONAL_SEARCH(String ADDITIONAL_SEARCH) { this.ADDITIONAL_SEARCH = ADDITIONAL_SEARCH; }

    }
        
    public class projectSelectedItemListener implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent ie) {
            if(dbSettingScr.getcbbProjectFilterSize() > 0){
                if(!"Selecione...".equals(dbSettingScr.getcbbProjectFilter())){
                    showOnTable(false, dbSettingScr.getcbbProjectFilter());
                } else {
                    showOnTable(false, "Selecione...");
                }
            }
            
        }
        
    }
    
    private boolean insertEnviroment(String FILA, String CONFIGURATION_NAME, String TYPE, String GROUP_OBJECT, String ORDER_COL, String DESCRIPTION, String TAB_P0, String TAB_P1, String TAB_P2, String TAB_P3, String TABLE_NAME, String JOIN0, String JOIN1, String JOIN2, String JOIN3, String INACTIVE_FLG, String OTHER_KEY_FIELD, String ADDITIONAL_SEARCH){
        try{
            super.openConnection("Criando novo objeto...");
            statement = conn.createStatement();
            statement.execute(
                "INSERT INTO TAB_CTRL_BATIMENTO_REP ("
                    + "ID, "
                    + "FILA, "
                    + "CONFIGURATION_NAME, "
                    + "TYPE, "
                    + "GROUP_OBJECT, "
                    + "ORDER_COL, "
                    + "DESCRIPTION, "
                    + "TAB_P0, "
                    + "TAB_P1, "
                    + "TAB_P2, "
                    + "TAB_P3, "
                    + "TABLE_NAME, "
                    + "JOIN0, "
                    + "JOIN1, "
                    + "JOIN2, "
                    + "JOIN3, "
                    + "INACTIVE_FLG, "
                    + "OTHER_KEY_FIELD, "
                    + "ADDITIONAL_SEARCH"
                + ")\n" +
                "VALUES (\n" +
                "   CTRL_BATIMENTO_REP_SEQ.NEXTVAL,\n" +
                "   " + FILA + ", \n" +
                "   '" + CONFIGURATION_NAME + "', \n" +
                "   '" + TYPE + "', \n" +
                "   '" + GROUP_OBJECT + "', \n" +
                "   " + ORDER_COL + ", \n" +
                "   '" + DESCRIPTION + "', \n" +
                "   '" + TAB_P0 + "', \n" +
                "   '" + TAB_P1 + "', \n" +
                "   '" + TAB_P2 + "', \n" +
                "   '" + TAB_P3 + "', \n" +
                "   '" + TABLE_NAME + "', \n" +
                "   '" + JOIN0 + "', \n" +
                "   '" + JOIN1 + "', \n" +
                "   '" + JOIN2 + "', \n" +
                "   '" + JOIN3 + "', \n" +
                "   '" + INACTIVE_FLG + "', \n" +
                "   '" + OTHER_KEY_FIELD + "', \n" +
                "   '" + ADDITIONAL_SEARCH + "'\n" +
                ")"
            );
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar criar novo Objeto.\nMensagem: " + e,"Erro",JOptionPane.ERROR_MESSAGE);
            closeConnection("Erro ao criar Objeto...");
            return false;
        } finally{
            closeConnection("Objeto criado com sucesso!");
        }
        return true;
    }
    
    private class insertEnviromentSave implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            
            if(dbSettingScr.gettxtProj() != null && !"".equals(dbSettingScr.gettxtProj())){
                if(dbSettingScr.getcbbType() != null && !"".equals(dbSettingScr.getcbbType()) && !"Selecione...".equals(dbSettingScr.getcbbType())){
                    if(dbSettingScr.gettxtObjType() != null && !"".equals(dbSettingScr.gettxtObjType())){
                        if(dbSettingScr.gettxtOrder()!= null && !"".equals(dbSettingScr.gettxtOrder())){
                            if(dbSettingScr.gettxtDescription()!= null && !"".equals(dbSettingScr.gettxtDescription())){
                                if(dbSettingScr.gettxtTable()!= null && !"".equals(dbSettingScr.gettxtTable())){
                                    if(dbSettingScr.getrdbActive()!= null && !"".equals(dbSettingScr.getrdbActive())){
                                        if(dbSettingScr.gettxtLine()!= null && !"".equals(dbSettingScr.gettxtLine())){
                                            try{
                                                Integer.parseInt(dbSettingScr.gettxtOrder());
                                                try{
                                                    Integer.parseInt(dbSettingScr.gettxtLine());
                                                    if(insertEnviroment(
                                                        dbSettingScr.gettxtLine(),
                                                        dbSettingScr.gettxtProj(),
                                                        dbSettingScr.getcbbType(),
                                                        dbSettingScr.gettxtObjType(),
                                                        dbSettingScr.gettxtOrder(),
                                                        dbSettingScr.gettxtDescription(),
                                                        dbSettingScr.gettxtTableN0(),
                                                        dbSettingScr.gettxtTableN1(),
                                                        dbSettingScr.gettxtTableN2(),
                                                        dbSettingScr.gettxtTableN3(),
                                                        dbSettingScr.gettxtTable(),
                                                        dbSettingScr.gettxtJoinN0(),
                                                        dbSettingScr.gettxtJoinN1(),
                                                        dbSettingScr.gettxtJoinN2(),
                                                        dbSettingScr.gettxtJoinN3(),
                                                        dbSettingScr.getrdbActive(),
                                                        dbSettingScr.gettxtKeyField(),
                                                        dbSettingScr.gettxtSearchSpec()
                                                    )){
                                                        JOptionPane.showMessageDialog(null, "Objeto criado com Sucesso!","SUCESSO",JOptionPane.INFORMATION_MESSAGE);
                                                        screenOnLoadEnviromentSettings(true, "Selecione...");
                                                        dbSettingScr.setFocus("DBLINK_NAME");
                                                    }
                                                } catch(Exception b) {
                                                    JOptionPane.showMessageDialog(null, "Campo Obrigatório preenchido Incorretamente: Fila/Thread","ERRO",JOptionPane.ERROR_MESSAGE);
                                                    dbSettingScr.setFocus("ENV_LINE");
                                                }
                                            } catch(Exception a) {
                                                JOptionPane.showMessageDialog(null, "Campo Obrigatório preenchido Incorretamente: Ordem","ERRO",JOptionPane.ERROR_MESSAGE);
                                                dbSettingScr.setFocus("ENV_ORDER");
                                            }
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Campo Obrigatório não preenchido: Fila/Thread","ERRO",JOptionPane.ERROR_MESSAGE);
                                            dbSettingScr.setFocus("ENV_LINE");
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Campo Obrigatório não preenchido: Ativo","ERRO",JOptionPane.ERROR_MESSAGE);
                                        dbSettingScr.setFocus("ENV_ACTIVE_YES");
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "Campo Obrigatório não preenchido: Tabela Query","ERRO",JOptionPane.ERROR_MESSAGE);
                                    dbSettingScr.setFocus("ENV_TABLE");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Campo Obrigatório não preenchido: Descrição","ERRO",JOptionPane.ERROR_MESSAGE);
                                dbSettingScr.setFocus("ENV_DESCRIPTION");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Campo Obrigatório não preenchido: Ordem","ERRO",JOptionPane.ERROR_MESSAGE);
                            dbSettingScr.setFocus("ENV_ORDER");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Campo Obrigatório não preenchido: Tipo de Objeto","ERRO",JOptionPane.ERROR_MESSAGE);
                        dbSettingScr.setFocus("ENV_OBJTYPE");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Campo Obrigatório não preenchido ou preenchido incorretamente: Tipo","ERRO",JOptionPane.ERROR_MESSAGE);
                    dbSettingScr.setFocus("ENV_TYPE");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Campo Obrigatório não preenchido: Projeto","ERRO",JOptionPane.ERROR_MESSAGE);
                dbSettingScr.setFocus("ENV_PROJ");
            }
            
        }
        
    }
    
    private class insertEnviromentSaveAndAdd implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            
            if(dbSettingScr.gettxtProj() != null && !"".equals(dbSettingScr.gettxtProj())){
                if(dbSettingScr.getcbbType() != null && !"".equals(dbSettingScr.getcbbType()) && !"Selecione...".equals(dbSettingScr.getcbbType())){
                    if(dbSettingScr.gettxtObjType() != null && !"".equals(dbSettingScr.gettxtObjType())){
                        if(dbSettingScr.gettxtOrder()!= null && !"".equals(dbSettingScr.gettxtOrder())){
                            if(dbSettingScr.gettxtDescription()!= null && !"".equals(dbSettingScr.gettxtDescription())){
                                if(dbSettingScr.gettxtTable()!= null && !"".equals(dbSettingScr.gettxtTable())){
                                    if(dbSettingScr.getrdbActive()!= null && !"".equals(dbSettingScr.getrdbActive())){
                                        if(dbSettingScr.gettxtLine()!= null && !"".equals(dbSettingScr.gettxtLine())){
                                            try{
                                                Integer.parseInt(dbSettingScr.gettxtOrder());
                                                try{
                                                    Integer.parseInt(dbSettingScr.gettxtLine());
                                                    if(insertEnviroment(
                                                        dbSettingScr.gettxtLine(),
                                                        dbSettingScr.gettxtProj(),
                                                        dbSettingScr.getcbbType(),
                                                        dbSettingScr.gettxtObjType(),
                                                        dbSettingScr.gettxtOrder(),
                                                        dbSettingScr.gettxtDescription(),
                                                        dbSettingScr.gettxtTableN0(),
                                                        dbSettingScr.gettxtTableN1(),
                                                        dbSettingScr.gettxtTableN2(),
                                                        dbSettingScr.gettxtTableN3(),
                                                        dbSettingScr.gettxtTable(),
                                                        dbSettingScr.gettxtJoinN0(),
                                                        dbSettingScr.gettxtJoinN1(),
                                                        dbSettingScr.gettxtJoinN2(),
                                                        dbSettingScr.gettxtJoinN3(),
                                                        dbSettingScr.getrdbActive(),
                                                        dbSettingScr.gettxtKeyField(),
                                                        dbSettingScr.gettxtSearchSpec()
                                                    )){
                                                        JOptionPane.showMessageDialog(null, "Objeto criado com Sucesso!","SUCESSO",JOptionPane.INFORMATION_MESSAGE);
                                                        screenOnLoadEnviromentSettings(false, dbSettingScr.getcbbProjectFilter());
                                                        dbSettingScr.setFocus("DBLINK_NAME");
                                                    }
                                                } catch(Exception b) {
                                                    JOptionPane.showMessageDialog(null, "Campo Obrigatório preenchido Incorretamente: Fila/Thread","ERRO",JOptionPane.ERROR_MESSAGE);
                                                    dbSettingScr.setFocus("ENV_LINE");
                                                }
                                            } catch(Exception a) {
                                                JOptionPane.showMessageDialog(null, "Campo Obrigatório preenchido Incorretamente: Ordem","ERRO",JOptionPane.ERROR_MESSAGE);
                                                dbSettingScr.setFocus("ENV_ORDER");
                                            }
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Campo Obrigatório não preenchido: Fila/Thread","ERRO",JOptionPane.ERROR_MESSAGE);
                                            dbSettingScr.setFocus("ENV_LINE");
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Campo Obrigatório não preenchido: Ativo","ERRO",JOptionPane.ERROR_MESSAGE);
                                        dbSettingScr.setFocus("ENV_ACTIVE_YES");
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "Campo Obrigatório não preenchido: Tabela Query","ERRO",JOptionPane.ERROR_MESSAGE);
                                    dbSettingScr.setFocus("ENV_TABLE");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Campo Obrigatório não preenchido: Descrição","ERRO",JOptionPane.ERROR_MESSAGE);
                                dbSettingScr.setFocus("ENV_DESCRIPTION");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Campo Obrigatório não preenchido: Ordem","ERRO",JOptionPane.ERROR_MESSAGE);
                            dbSettingScr.setFocus("ENV_ORDER");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Campo Obrigatório não preenchido: Tipo de Objeto","ERRO",JOptionPane.ERROR_MESSAGE);
                        dbSettingScr.setFocus("ENV_OBJTYPE");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Campo Obrigatório não preenchido ou preenchido incorretamente: Tipo","ERRO",JOptionPane.ERROR_MESSAGE);
                    dbSettingScr.setFocus("ENV_TYPE");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Campo Obrigatório não preenchido: Projeto","ERRO",JOptionPane.ERROR_MESSAGE);
                dbSettingScr.setFocus("ENV_PROJ");
            }
            
        }
        
    }
    
    private boolean deleteEnviromentObj(String ID){
        try{
            super.openConnection("Excluindo Objeto de Ambiente...");
            statement = conn.createStatement();
            statement.execute("DELETE FROM SADMIN.TAB_CTRL_BATIMENTO_REP WHERE ID = '" + ID + "'");         
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir Database Link.\nMensagem: " + e,"Erro",JOptionPane.ERROR_MESSAGE);
            closeConnection("Erro ao excluir DBLINK...");
            return false;
        } finally{
            closeConnection("Objeto de Ambiente excluído com sucesso!");
        }
        return true;
    }
    
    private class deleteEnviromentObj implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent ae) {
            if(dbSettingScr.tblEnvList.getSelectedRow() >= 0){
                if(deleteEnviromentObj(dbSettingScr.tblEnvList.getModel().getValueAt(dbSettingScr.tblEnvList.getSelectedRow(), 0).toString())){
                    JOptionPane.showMessageDialog(null, "Objeto de Ambiente excluído com Sucesso!","SUCESSO",JOptionPane.INFORMATION_MESSAGE);
                    if("Selecione...".equals(dbSettingScr.getcbbProjectFilter())){
                        showOnTable(true,"Selecione...");
                    } else {
                        showOnTable(false, dbSettingScr.getcbbProjectFilter());
                        if(dbSettingScr.tblEnvList.getRowCount() > 0){
                            showOnTable(false, dbSettingScr.getcbbProjectFilter());
                        } else {
                            screenOnLoadEnviromentSettings(true, "Selecione...");
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Nenhuma linha da tabela foi selecionada!","ERRO",JOptionPane.ERROR_MESSAGE);
            }
            
        }
        
    }
    
    // DBLINK
    // Function to show the result on screen
    public void screenOnLoadDBLinkSettings(){
        dbSettingScr.cleartxtDbLinkName();
        dbSettingScr.cleartxtDbLinkUser();
        dbSettingScr.cleartxtDbLinkPassword();
        dbSettingScr.cleartxtDbLinkPasswordConf();
        dbSettingScr.cleartxtDbLinkServName();
        dbSettingScr.clearrdbDbLinkPub();
        dbSettingScr.insertrdbDbLinkPub("Y");
        
        try{
            // This ArrayList is based on the "resultByThread" class and receive the result of the function getThreadResult().
            // This Function do a Select Query on the CTRL_LOG_COMP_REP table
            ArrayList<dbLinkSettings> arrayDBLink = queryDBLinks();        

            // Fills in the table "Resultado por Thread"
            DefaultTableModel model = (DefaultTableModel) dbSettingScr.tblDbLinkList.getModel();
            model.setNumRows(arrayDBLink.size());

            for (int i = 0; i < arrayDBLink.size(); i++) {
                model.setValueAt(arrayDBLink.get(i).getDBLINK_owner(), i, 0);
                model.setValueAt(arrayDBLink.get(i).getDBLINK_name(), i, 1);
                model.setValueAt(arrayDBLink.get(i).getDBLINK_user(), i, 2);
                model.setValueAt(arrayDBLink.get(i).getDBLINK_service_name(), i, 3);
                model.setValueAt(arrayDBLink.get(i).getDBLINK_created(), i, 4);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher a tabela.\nMensagem: " + e,"Erro",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Function used to return the data of the select instruction into a Arraylist
    private ArrayList<dbLinkSettings> queryDBLinks(){        
        // ArrayList used to return the select query result
        ArrayList<dbLinkSettings> result = new ArrayList<>();
        
        try{
            super.openConnection("Buscando: DBLINK's existentes...");
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM ALL_DB_LINKS ORDER BY HOST ASC");

            while(rs.next()){
                dbLinkSettings dblink = new dbLinkSettings();
                
                dblink.setDBLINK_owner(rs.getString("OWNER"));
                dblink.setDBLINK_name(rs.getString("DB_LINK"));
                dblink.setDBLINK_user(rs.getString("USERNAME"));
                dblink.setDBLINK_service_name(rs.getString("HOST"));
                dblink.setDBLINK_created(rs.getString("CREATED"));
                
                result.add(dblink);
            }
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de leitura no Banco de Dados!\nMensagem: " + e,"Erro",JOptionPane.ERROR_MESSAGE);
        } finally{
            closeConnection("Relatório gerado com sucesso!");
        }
        return result;
    }
    
    private void insertDbLink(String OWNER, String NOME_DBLINK, String USUARIO, String SENHA, String NOME_TNS_BANCO){
        try{
            super.openConnection("Criando novo DBLINK...");
            statement = conn.createStatement();
            if("Y".equals(OWNER)){
                statement.execute("CREATE PUBLIC DATABASE LINK " + NOME_DBLINK + " CONNECT TO " + USUARIO + " IDENTIFIED BY " + SENHA + " USING '" + NOME_TNS_BANCO + "'");
            } else {
                statement.execute("CREATE DATABASE LINK " + NOME_DBLINK + " CONNECT TO " + USUARIO + " IDENTIFIED BY " + SENHA + " USING '" + NOME_TNS_BANCO + "'");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar criar novo Database Link.\nMensagem: " + e,"Erro",JOptionPane.ERROR_MESSAGE);
            closeConnection("Erro ao criar DBLINK...");
        } finally{
            closeConnection("DBLINK criado com sucesso!");
        }
    }
    
    private class insertDbLinkSave implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if(dbSettingScr.gettxtDbLinkName() != null && !"".equals(dbSettingScr.gettxtDbLinkName())){
                if(dbSettingScr.gettxtDbLinkUser() != null && !"".equals(dbSettingScr.gettxtDbLinkUser())){
                    if(dbSettingScr.gettxtDbLinkPassword() != null && !"".equals(dbSettingScr.gettxtDbLinkPassword())){
                        if(dbSettingScr.gettxtDbLinkPasswordConf() != null && !"".equals(dbSettingScr.gettxtDbLinkPasswordConf())){
                            if(dbSettingScr.gettxtDbLinkServName() != null && !"".equals(dbSettingScr.gettxtDbLinkServName())){
                                if(dbSettingScr.gettxtDbLinkPassword().equals(dbSettingScr.gettxtDbLinkPasswordConf())) {
                                    insertDbLink(dbSettingScr.getrdbDbLinkPub(), dbSettingScr.gettxtDbLinkName(), dbSettingScr.gettxtDbLinkUser(), dbSettingScr.gettxtDbLinkPassword(), dbSettingScr.gettxtDbLinkServName());
                                    JOptionPane.showMessageDialog(null, "Link de Banco de Dados Criado com Sucesso!","SUCESSO",JOptionPane.INFORMATION_MESSAGE);
                                    screenOnLoadDBLinkSettings();
                                    dbSettingScr.setFocus("DBLINK_NAME");
                                } else {
                                    JOptionPane.showMessageDialog(null, "As senhas não coicidem!","Erro",JOptionPane.ERROR_MESSAGE);
                                    dbSettingScr.setFocus("DBLINK_PASSWORD");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Campo Nome Serviço não preenchido!","Erro",JOptionPane.ERROR_MESSAGE);
                                dbSettingScr.setFocus("DBLINK_SERV_NAME");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Campo Confirmar Senha não preenchido!","Erro",JOptionPane.ERROR_MESSAGE);
                            dbSettingScr.setFocus("DBLINK_PASSWORD_CONF");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Campo Senha não preenchido!","Erro",JOptionPane.ERROR_MESSAGE);
                        dbSettingScr.setFocus("DBLINK_PASSWORD");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Campo nome de usuário não preenchido!","Erro",JOptionPane.ERROR_MESSAGE);
                    dbSettingScr.setFocus("DBLINK_USER_NAME");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Campo nome não preenchido!","Erro",JOptionPane.ERROR_MESSAGE);
                dbSettingScr.setFocus("DBLINK_NAME");
            }
            
        }
        
    }
    
    private class insertDbLinkSaveAndAdd implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if(dbSettingScr.gettxtDbLinkName() != null && !"".equals(dbSettingScr.gettxtDbLinkName())){
                if(dbSettingScr.gettxtDbLinkUser() != null && !"".equals(dbSettingScr.gettxtDbLinkUser())){
                    if(dbSettingScr.gettxtDbLinkPassword() != null && !"".equals(dbSettingScr.gettxtDbLinkPassword())){
                        if(dbSettingScr.gettxtDbLinkPasswordConf() != null && !"".equals(dbSettingScr.gettxtDbLinkPasswordConf())){
                            if(dbSettingScr.gettxtDbLinkServName() != null && !"".equals(dbSettingScr.gettxtDbLinkServName())){
                                if(dbSettingScr.gettxtDbLinkPassword().equals(dbSettingScr.gettxtDbLinkPasswordConf())) {
                                    insertDbLink(dbSettingScr.getrdbDbLinkPub(), dbSettingScr.gettxtDbLinkName(), dbSettingScr.gettxtDbLinkUser(), dbSettingScr.gettxtDbLinkPassword(), dbSettingScr.gettxtDbLinkServName());
                                    JOptionPane.showMessageDialog(null, "Link de Banco de Dados Criado com Sucesso!","SUCESSO",JOptionPane.INFORMATION_MESSAGE);
                                    try{
                                        // This ArrayList is based on the "resultByThread" class and receive the result of the function getThreadResult().
                                        // This Function do a Select Query on the CTRL_LOG_COMP_REP table
                                        ArrayList<dbLinkSettings> arrayThread = queryDBLinks();        

                                        // Fills in the table "Resultado por Thread"
                                        DefaultTableModel model = (DefaultTableModel) dbSettingScr.tblDbLinkList.getModel();
                                        model.setNumRows(arrayThread.size());

                                        for (int i = 0; i < arrayThread.size(); i++) {
                                            model.setValueAt(arrayThread.get(i).getDBLINK_owner(), i, 0);
                                            model.setValueAt(arrayThread.get(i).getDBLINK_name(), i, 1);
                                            model.setValueAt(arrayThread.get(i).getDBLINK_user(), i, 2);
                                            model.setValueAt(arrayThread.get(i).getDBLINK_service_name(), i, 3);
                                            model.setValueAt(arrayThread.get(i).getDBLINK_created(), i, 4);
                                        }
                                    } catch (Exception e) {
                                        JOptionPane.showMessageDialog(null, "Erro ao preencher a tabela.\nMensagem: " + e,"Erro",JOptionPane.ERROR_MESSAGE);
                                    }

                                    dbSettingScr.setFocus("DBLINK_NAME");
                                } else {
                                    JOptionPane.showMessageDialog(null, "As senhas não coicidem!","Erro",JOptionPane.ERROR_MESSAGE);
                                    dbSettingScr.setFocus("DBLINK_PASSWORD");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Campo Nome Serviço não preenchido!","Erro",JOptionPane.ERROR_MESSAGE);
                                dbSettingScr.setFocus("DBLINK_SERV_NAME");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Campo Confirmar Senha não preenchido!","Erro",JOptionPane.ERROR_MESSAGE);
                            dbSettingScr.setFocus("DBLINK_PASSWORD_CONF");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Campo Senha não preenchido!","Erro",JOptionPane.ERROR_MESSAGE);
                        dbSettingScr.setFocus("DBLINK_PASSWORD");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Campo nome de usuário não preenchido!","Erro",JOptionPane.ERROR_MESSAGE);
                    dbSettingScr.setFocus("DBLINK_USER_NAME");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Campo nome não preenchido!","Erro",JOptionPane.ERROR_MESSAGE);
                dbSettingScr.setFocus("DBLINK_NAME");
            }
            
            
        }
        
    }
    
    private boolean deleteDbLink(String OWNER, String NOME_DBLINK){
        try{
            super.openConnection("Excluindo DBLINK...");
            statement = conn.createStatement();
            if("PUBLIC".equals(OWNER)){
                statement.execute("drop public database link \"" + NOME_DBLINK + "\"");
            } else {
                statement.execute("drop database link \"" + NOME_DBLINK + "\"");
            }            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir Database Link.\nMensagem: " + e,"Erro",JOptionPane.ERROR_MESSAGE);
            closeConnection("Erro ao excluir DBLINK...");
            return false;
        } finally{
            closeConnection("DBLINK excluído com sucesso!");
        }
        return true;
    }
    
    private class deleteDbLink implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent ae) {
            if(dbSettingScr.tblDbLinkList.getSelectedRow() >= 0){
                if(deleteDbLink(dbSettingScr.tblDbLinkList.getModel().getValueAt(dbSettingScr.tblDbLinkList.getSelectedRow(), 0).toString(), dbSettingScr.tblDbLinkList.getModel().getValueAt(dbSettingScr.tblDbLinkList.getSelectedRow(), 1).toString())){
                    JOptionPane.showMessageDialog(null, "Link de Banco de Dados EXCLUÍDO com Sucesso!","SUCESSO",JOptionPane.INFORMATION_MESSAGE);
                    screenOnLoadDBLinkSettings();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Nenhuma linha da tabela foi selecionada!","ERRO",JOptionPane.ERROR_MESSAGE);
            }
            
        }
        
    }
    
    private class dbLinkSettings {
        
        // DBLINKS Variables
        private String DBLINK_name;
        private String DBLINK_user;
        private String DBLINK_password;
        private String DBLINK_password_conf;
        private String DBLINK_service_name;
        private String DBLINK_owner;
        private String DBLINK_created;

        // Constructor
        public dbLinkSettings() { 
            this.DBLINK_name = null;
            this.DBLINK_user = null;
            this.DBLINK_password = null;
            this.DBLINK_password_conf = null;
            this.DBLINK_service_name = null;
            this.DBLINK_owner = null;
            this.DBLINK_created = null;
        }

        public String getDBLINK_name() { return DBLINK_name; } 
        public void setDBLINK_name(String DBLINK_name) { this.DBLINK_name = DBLINK_name; }

        public String getDBLINK_user() { return DBLINK_user; } 
        public void setDBLINK_user(String DBLINK_user) { this.DBLINK_user = DBLINK_user; }

        public String getDBLINK_password() { return DBLINK_password; } 
        public void setDBLINK_password(String DBLINK_password) { this.DBLINK_password = DBLINK_password; }

        public String getDBLINK_password_conf() { return DBLINK_password_conf; } 
        public void setDBLINK_password_conf(String DBLINK_password_conf) { this.DBLINK_password_conf = DBLINK_password_conf; }

        public String getDBLINK_service_name() { return DBLINK_service_name; } 
        public void setDBLINK_service_name(String DBLINK_service_name) { this.DBLINK_service_name = DBLINK_service_name; }

        public String getDBLINK_owner() { return DBLINK_owner; } 
        public void setDBLINK_owner(String DBLINK_owner) { this.DBLINK_owner = DBLINK_owner; }
        
        public String getDBLINK_created() { return DBLINK_created; } 
        public void setDBLINK_created(String DBLINK_created) { this.DBLINK_created = DBLINK_created; }
    }
    
}
