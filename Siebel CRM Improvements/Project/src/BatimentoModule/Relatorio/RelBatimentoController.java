/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BatimentoModule.Relatorio;

import databaseModule.DataController;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jxl.*;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 *
 * @author Matheus Cabral Rosa
 */
public class RelBatimentoController extends DataController {
    // Classes and Views references
    RelBatimentoScreen screen;
    
    // Variables
    private ArrayList<String> masterId = new ArrayList<>();
    private ArrayList<String> dateBatimento = new ArrayList<>();

    // Constructor
    public RelBatimentoController(String dbUser, String dbPassword) {
        super.setDbUser(dbUser);
        super.setDbPassword(dbPassword);
        screen = new RelBatimentoScreen();
        screen.setExtendedState(MAXIMIZED_BOTH);
        this.screenOnLoad();
        screen.setListenerCbbProj(new CbbProjListener());
        screen.setListenerCbbDate(new CbbDateListener());
        screen.setListenerBtnSearch(new BtnSearchListener());
        screen.setListenerBtnSaveAll(new BtnSaveAllListener());
    }
    
    // Function used to load projects on RelBatimentoScreen startup
    private void screenOnLoad(){
        screen.setCbbProjEnabled(false);
        screen.setCbbDateEnabled(false);
        screen.clearCbbProj();
        screen.clearCbbDate();
        screen.clearLblFirstEnv();
        screen.clearLblSecEnv();
        
        screen.insertCbbProj("Selecione...");
        try{
            super.openConnection("Buscando: Projetos");
            super.statement = super.conn.createStatement();
            ResultSet readline = super.statement.executeQuery("SELECT DISTINCT CONFIGURATION_NAME FROM SADMIN.TAB_CTRL_BATIMENTO_REP");
            while(readline.next()){
                screen.insertCbbProj(readline.getString("CONFIGURATION_NAME"));                
            }
            readline.close();
            super.closeConnection("Fim da busca do contexto atual: Projetos");
        } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro de leitura no Banco de Dados!\nMensagem: " + e,"Erro",JOptionPane.ERROR_MESSAGE);
        } finally {
            screen.setCbbProjEnabled(true);
        }
    }
    
    // Class invoked when the ComboBox "Projeto" value changes
    // This class is used to search the dates of last "Batimentos"
    private class CbbProjListener implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent ie) {
            if(!"Selecione...".equals(screen.getCbbProj())){
                masterId.clear();
                dateBatimento.clear();
                screen.clearCbbDate();
                screen.insertCbbDate("Selecione...");
                try{
                    openConnection("Buscando: Data dos Batimentos e DBLINK's");
                    statement = conn.createStatement();
                    ResultSet readline = statement.executeQuery(
                        "SELECT\n" +
                        "    MASTER.ID AS \"MASTER_ID\",\n" +
                        "    MASTER.CREATED AS \"CREATED\"\n" +
                        "FROM SADMIN.CTRL_LOG_COMP_REP_MASTER MASTER\n" +
                        "WHERE MASTER.CONFIGURATION_NAME = '" + screen.getCbbProj() + "'\n" +
                        "ORDER BY MASTER.CREATED DESC"
                    );
                    while(readline.next()){
                        masterId.add(readline.getString("MASTER_ID"));
                        dateBatimento.add(readline.getString("CREATED"));
                        screen.insertCbbDate(readline.getString("CREATED"));                
                    }
                    readline.close();
                    closeConnection("Fim da busca do contexto atual: Data dos Batimentos e DBLINK's");
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Erro de leitura no Banco de Dados!\nMensagem: " + e,"Erro",JOptionPane.ERROR_MESSAGE);
                } finally {
                    screen.setCbbDateEnabled(true);
                }
            } else {
                screen.setCbbDateEnabled(false);
                screen.setBtnSearchEnabled(false);
                screen.setBtnSaveAllEnabled(false);
                screen.clearCbbDate();
                screen.clearCbbDate();
                screen.clearLblFirstEnv();
                screen.clearLblSecEnv();
            }
        }
        
    }
    
    // Class invoked when the ComboBox "Data Batimento" value changes
    // This class is used to search and show the enviroments involved on the "Batimento" dates
    private class CbbDateListener implements ItemListener {
        private int i = 0;
        @Override
        public void itemStateChanged(ItemEvent ie) {
            if(!"Selecione...".equals(screen.getCbbProj())){
                if(screen.iscbbDateEnabled()){
                    if(i==1){
                        if(!"Selecione...".equals(screen.getCbbDate())){
                            screen.setBtnSearchEnabled(true);
                            screen.clearLblFirstEnv();
                            screen.clearLblSecEnv();

                            try {
                                openConnection("Buscando: Data dos Batimentos e DBLINK's");
                                statement = conn.createStatement();
                                ResultSet readline = statement.executeQuery(
                                    "SELECT DISTINCT\n" +
                                    "    TREP.DBLINK_ORIG,\n" +
                                    "    TREP.DBLINK_DEST\n" +
                                    "FROM SADMIN.CTRL_LOG_COMP_REP TREP\n" +
                                    "WHERE TREP.CONFIGURATION_NAME = '" + screen.getCbbProj() + "' -- Nome do Projeto\n" +
                                    "AND TREP.MASTER_LOG_COMPARE_ID = '" + masterId.get(screen.getCbbDateSelectedIndex()) + "'"
                                );
                                while(readline.next()){
                                    screen.insertLblFirstEnv(readline.getString("DBLINK_ORIG"));
                                    screen.insertLblSecEnv(readline.getString("DBLINK_DEST"));
                                }
                                readline.close();
                                closeConnection("Fim da busca do contexto atual: Data dos Batimentos e DBLINK's");
                                i=0;
                            } catch (SQLException e) {
                                JOptionPane.showMessageDialog(null, "Erro de leitura no Banco de Dados!\nMensagem: " + e,"Erro",JOptionPane.ERROR_MESSAGE);
                                i=0;
                            }

                        } else {
                            screen.setBtnSearchEnabled(false);
                            screen.setBtnSaveAllEnabled(false);
                            screen.clearLblFirstEnv();
                            screen.clearLblSecEnv();
                            i=0;
                        }
                    } else {
                        i++;
                    }
                }                
            }                        
        }
    
    }
    
    // Class invoked when the Button "Buscar" is clicked
    // This class is used to search and show the Batimento Result and the logs on screen
    private class BtnSearchListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if(!"Selecione...".equals(screen.getCbbProj())){
                if(!"Selecione...".equals(screen.getCbbDate())){
                    showResult();
                    screen.setBtnSaveAllEnabled(true);
                } else {
                    JOptionPane.showMessageDialog(null, "ATENÇÃO: O Campo \"Data do Batimento\" deve ser selecionado!","Atenção",JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "ATENÇÃO: O Campo \"Projeto\" deve ser selecionado!","Atenção",JOptionPane.WARNING_MESSAGE);
            }
        }
        
    }
    
    // Class invoked when the Button "Salvar Tudo" is clicked
    // This class is used to invoke the function "SaveResult()"
    private class BtnSaveAllListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            saveResult();
        }
        
    }
    
    // Function to show the comparizon result on screen
    public void showResult(){        
        // This ArrayList is based on the "resultByThread" class and receive the result of the function getThreadResult().
        // This Function do a Select Query on the CTRL_LOG_COMP_REP table
        ArrayList<resultByThread> arrayThread = getThreadResult();
        ArrayList<resultLog> arrayResultLog = getResultLog();
        ArrayList<resultBat> arrayResultBat = getResultBat();
        
        
        // Fills in the table "Resultado por Thread"
        DefaultTableModel model = (DefaultTableModel) screen.tblRelThread.getModel();
        model.setNumRows(arrayThread.size());

        for (int i = 0; i < arrayThread.size(); i++) {
            model.setValueAt(arrayThread.get(i).getID(), i, 0);
            model.setValueAt(arrayThread.get(i).getMASTER_LOG_COMPARE_ID(), i, 1);
            model.setValueAt(arrayThread.get(i).getCONFIGURATION_NAME(), i, 2);
            model.setValueAt(arrayThread.get(i).getFILA(), i, 3);
            model.setValueAt(arrayThread.get(i).getSTATUS(), i, 4);
            model.setValueAt(arrayThread.get(i).getTOTAL_PROCESS_TO_EXEC(), i, 5);
            model.setValueAt(arrayThread.get(i).getTOTAL_PROCESS_EXECUTED(), i, 6);
            model.setValueAt(arrayThread.get(i).getACTUAL_TYPE(), i, 7);
            model.setValueAt(arrayThread.get(i).getACTUAL_DESCRIPTION(), i, 8);
            model.setValueAt(arrayThread.get(i).getTABLE_NAME(), i, 9);
            model.setValueAt(arrayThread.get(i).getORI_REPOSITORY_NAME(), i, 10);
            model.setValueAt(arrayThread.get(i).getDES_REPOSITORY_NAME(), i, 11);
            model.setValueAt(arrayThread.get(i).getDBLINK_ORIG(), i, 12);
            model.setValueAt(arrayThread.get(i).getDBLINK_DEST(), i, 13);
            model.setValueAt(arrayThread.get(i).getDATE_START(), i, 14);
            model.setValueAt(arrayThread.get(i).getDATE_END(), i, 15);
            model.setValueAt(arrayThread.get(i).getSTATUS_DESC(), i, 16);
        }
        
        // Fills in the table "Log do Resultado"
        DefaultTableModel modelLog = (DefaultTableModel) screen.tblRelLog.getModel();
        modelLog.setNumRows(arrayResultLog.size());

        for (int i = 0; i < arrayResultLog.size(); i++) {
            modelLog.setValueAt(arrayResultLog.get(i).getFILA(), i, 0);
            modelLog.setValueAt(arrayResultLog.get(i).getCTRL_LOG_COMP_REP_ID(), i, 1);
            modelLog.setValueAt(arrayResultLog.get(i).getTAB_CTRL_BATIMENTO_REP_ID(), i, 2);
            modelLog.setValueAt(arrayResultLog.get(i).getTABLE_NAME(), i, 3);
            modelLog.setValueAt(arrayResultLog.get(i).getSTATUS(), i, 4);
            modelLog.setValueAt(arrayResultLog.get(i).getSTATUS_DESC(), i, 5);
            modelLog.setValueAt(arrayResultLog.get(i).getSCRIPT_ERROR(), i, 6);
        }
        
        // Fills in the table "Log do Resultado"
        DefaultTableModel modelBat = (DefaultTableModel) screen.tblRelResult.getModel();
        modelBat.setNumRows(arrayResultBat.size());

        for (int i = 0; i < arrayResultBat.size(); i++) {
            modelBat.setValueAt(arrayResultBat.get(i).getSTATUS(), i, 0);
            modelBat.setValueAt(arrayResultBat.get(i).getTYPE(), i, 1);
            modelBat.setValueAt(arrayResultBat.get(i).getGROUP_OBJECT(), i, 2);
            modelBat.setValueAt(arrayResultBat.get(i).getDESCRIPTION(), i, 3);
            modelBat.setValueAt(arrayResultBat.get(i).getPAR_N0(), i, 4);
            modelBat.setValueAt(arrayResultBat.get(i).getPAR_N1(), i, 5);
            modelBat.setValueAt(arrayResultBat.get(i).getPAR_N2(), i, 6);
            modelBat.setValueAt(arrayResultBat.get(i).getPAR_N3(), i, 7);
            modelBat.setValueAt(arrayResultBat.get(i).getOBJECT_NAME(), i, 8);
            modelBat.setValueAt(arrayResultBat.get(i).getCOLUMN_NAME(), i, 9);
            modelBat.setValueAt(arrayResultBat.get(i).getVAL_ORIG(), i, 10);
            modelBat.setValueAt(arrayResultBat.get(i).getVAL_DEST(), i, 11);
            modelBat.setValueAt(arrayResultBat.get(i).getLAST_UPD_ORIG(), i, 12);
            modelBat.setValueAt(arrayResultBat.get(i).getLAST_UPD_DEST(), i, 13);
            modelBat.setValueAt(arrayResultBat.get(i).getLAST_UPD_BY_ORIG(), i, 14);
            modelBat.setValueAt(arrayResultBat.get(i).getLAST_UPD_BY_DEST(), i, 15);
        }
                
    }
    
    // Function used to save the result on Excel File
    public void saveResult(){
        try{
            // This ArrayList is based on the "resultByThread" class and receive the result of the function getThreadResult().
            // This Function do a Select Query on the CTRL_LOG_COMP_REP table
            ArrayList<resultByThread> arrayThread = getThreadResult();
            ArrayList<resultLog> arrayResultLog = getResultLog();
            ArrayList<resultBat> arrayResultBat = getResultBat();
            
            //Abre caixa de dialogo para selecionar caminho do arquivo que será gerado.
            JFileChooser fc = new JFileChooser();
            fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            fc.setDialogTitle("Selecione o caminho desejado:");
            fc.showOpenDialog(screen);
            String path = fc.getSelectedFile().toString() + "\\RelatorioBatimento.xls";
            
            WritableWorkbook workbook = Workbook.createWorkbook(new File(path));
            
            
            WritableSheet sheet = workbook.createSheet("Resultado", 0);
            WritableSheet sheet2 = workbook.createSheet("LOG do Resultado", 1);
            WritableSheet sheet3 = workbook.createSheet("Resultado por Thread", 2);
            
            sheet.addCell(new Label(0,0, "STATUS"));
            sheet.addCell(new Label(1,0, "TIPO"));
            sheet.addCell(new Label(2,0, "OBJETO"));
            sheet.addCell(new Label(3,0, "DESCRICAO"));
            sheet.addCell(new Label(4,0, "PAR_N0"));
            sheet.addCell(new Label(5,0, "PAR_N1"));
            sheet.addCell(new Label(6,0, "PAR_N2"));
            sheet.addCell(new Label(7,0, "PAR_N3"));
            sheet.addCell(new Label(8,0, "NOME"));
            sheet.addCell(new Label(9,0, "COLUNA"));
            sheet.addCell(new Label(10,0, "VALOR AMB ORIGEM"));
            sheet.addCell(new Label(11,0, "VALOR AMB DESTINO"));
            sheet.addCell(new Label(12,0, "LAST UPD ORIGEM"));
            sheet.addCell(new Label(13,0, "LAST UPD DESTINO"));
            sheet.addCell(new Label(14,0, "ATUALIZADO POR ORIGEM"));
            sheet.addCell(new Label(15,0, "ATUALIZADO POR DESTINO"));
            
            for (int i = 0; i < arrayResultBat.size(); i++){
                sheet.addCell(new Label(0, i + 1, arrayResultBat.get(i).getSTATUS()));
                sheet.addCell(new Label(1, i + 1, arrayResultBat.get(i).getTYPE()));
                sheet.addCell(new Label(2, i + 1, arrayResultBat.get(i).getGROUP_OBJECT()));
                sheet.addCell(new Label(3, i + 1, arrayResultBat.get(i).getDESCRIPTION()));
                sheet.addCell(new Label(4, i + 1, arrayResultBat.get(i).getPAR_N0()));
                sheet.addCell(new Label(5, i + 1, arrayResultBat.get(i).getPAR_N1()));
                sheet.addCell(new Label(6, i + 1, arrayResultBat.get(i).getPAR_N2()));
                sheet.addCell(new Label(7, i + 1, arrayResultBat.get(i).getPAR_N3()));
                sheet.addCell(new Label(8, i + 1, arrayResultBat.get(i).getOBJECT_NAME()));
                sheet.addCell(new Label(9, i + 1, arrayResultBat.get(i).getCOLUMN_NAME()));
                sheet.addCell(new Label(10, i + 1, arrayResultBat.get(i).getVAL_ORIG()));
                sheet.addCell(new Label(11, i + 1, arrayResultBat.get(i).getVAL_DEST()));
                sheet.addCell(new Label(12, i + 1, arrayResultBat.get(i).getLAST_UPD_ORIG()));
                sheet.addCell(new Label(13, i + 1, arrayResultBat.get(i).getLAST_UPD_DEST()));
                sheet.addCell(new Label(14, i + 1, arrayResultBat.get(i).getLAST_UPD_BY_ORIG()));
                sheet.addCell(new Label(15, i + 1, arrayResultBat.get(i).getLAST_UPD_BY_DEST()));
            }
            
            sheet2.addCell(new Label(0,0, "THREAD"));
            sheet2.addCell(new Label(1,0, "ID THREAD"));
            sheet2.addCell(new Label(2,0, "ID RESULTADO"));
            sheet2.addCell(new Label(3,0, "NOME TABELA"));
            sheet2.addCell(new Label(4,0, "STATUS DA EXECUÇÃO"));
            sheet2.addCell(new Label(5,0, "DESCRIÇÃO"));
            sheet2.addCell(new Label(6,0, "SCRIPT ERROR"));
            
            for (int i = 0; i < arrayResultLog.size(); i++) {
                sheet2.addCell(new Label(0, i + 1, arrayResultLog.get(i).getFILA()));
                sheet2.addCell(new Label(1, i + 1, arrayResultLog.get(i).getCTRL_LOG_COMP_REP_ID()));
                sheet2.addCell(new Label(2, i + 1, arrayResultLog.get(i).getTAB_CTRL_BATIMENTO_REP_ID()));
                sheet2.addCell(new Label(3, i + 1, arrayResultLog.get(i).getTABLE_NAME()));
                sheet2.addCell(new Label(4, i + 1, arrayResultLog.get(i).getSTATUS()));
                sheet2.addCell(new Label(5, i + 1, arrayResultLog.get(i).getSTATUS_DESC()));
                sheet2.addCell(new Label(6, i + 1, arrayResultLog.get(i).getSCRIPT_ERROR()));
            }
            
            sheet3.addCell(new Label(0, 0, "ID"));
            sheet3.addCell(new Label(1, 0, "ID MASTER"));
            sheet3.addCell(new Label(2, 0, "PROJETO"));
            sheet3.addCell(new Label(3, 0, "THREAD"));
            sheet3.addCell(new Label(4, 0, "STATUS"));
            sheet3.addCell(new Label(5, 0, "TOTAL DE PROC À EXEC"));
            sheet3.addCell(new Label(6, 0, "TOTAL DE PROC EXEC"));
            sheet3.addCell(new Label(7, 0, "TIPO"));
            sheet3.addCell(new Label(8, 0, "NOME"));
            sheet3.addCell(new Label(9, 0, "NOME TABELA"));
            sheet3.addCell(new Label(10, 0, "REP ORIGEM"));
            sheet3.addCell(new Label(11, 0, "REP DESTINO"));
            sheet3.addCell(new Label(12, 0, "DBLINK ORIGEM"));
            sheet3.addCell(new Label(13, 0, "DBLINK DESTINO"));
            sheet3.addCell(new Label(14, 0, "DATA INÍCIO"));
            sheet3.addCell(new Label(15, 0, "DATA FIM"));
            sheet3.addCell(new Label(16, 0, "DESCRIÇÃO"));
            
            for (int i = 0; i < arrayThread.size(); i++) {
                sheet3.addCell(new Label(0, i + 1, arrayThread.get(i).getID()));
                sheet3.addCell(new Label(1, i + 1, arrayThread.get(i).getMASTER_LOG_COMPARE_ID()));
                sheet3.addCell(new Label(2, i + 1, arrayThread.get(i).getCONFIGURATION_NAME()));
                sheet3.addCell(new Label(3, i + 1, arrayThread.get(i).getFILA()));
                sheet3.addCell(new Label(4, i + 1, arrayThread.get(i).getSTATUS()));
                sheet3.addCell(new Label(5, i + 1, arrayThread.get(i).getTOTAL_PROCESS_TO_EXEC()));
                sheet3.addCell(new Label(6, i + 1, arrayThread.get(i).getTOTAL_PROCESS_EXECUTED()));
                sheet3.addCell(new Label(7, i + 1, arrayThread.get(i).getACTUAL_TYPE()));
                sheet3.addCell(new Label(8, i + 1, arrayThread.get(i).getACTUAL_DESCRIPTION()));
                sheet3.addCell(new Label(9, i + 1, arrayThread.get(i).getTABLE_NAME()));
                sheet3.addCell(new Label(10, i + 1, arrayThread.get(i).getORI_REPOSITORY_NAME()));
                sheet3.addCell(new Label(11, i + 1, arrayThread.get(i).getDES_REPOSITORY_NAME()));
                sheet3.addCell(new Label(12, i + 1, arrayThread.get(i).getDBLINK_ORIG()));
                sheet3.addCell(new Label(13, i + 1, arrayThread.get(i).getDBLINK_DEST()));
                sheet3.addCell(new Label(14, i + 1, arrayThread.get(i).getDATE_START()));
                sheet3.addCell(new Label(15, i + 1, arrayThread.get(i).getDATE_END()));
                sheet3.addCell(new Label(16, i + 1, arrayThread.get(i).getSTATUS_DESC()));
            }
            
            workbook.write();
            workbook.close();
            
            JOptionPane.showMessageDialog(null, "Relatório gerado com sucess!\nCaminho: " + path);
        } catch (IOException | WriteException ex){
            JOptionPane.showMessageDialog(null, "Erro ao tentar gerar relatório!\nErro: " + ex);
        }
    }
    
    // Function used to return the data of the select instruction into a Arraylist
    private ArrayList<resultByThread> getThreadResult(){        
        // ArrayList used to return the select query result
        ArrayList<resultByThread> result = new ArrayList<>();
        
        try{
            openConnection("Gerando Relatório...");
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(
                "SELECT\n" +
                "    THREAD.ID,\n" +
                "    THREAD.MASTER_LOG_COMPARE_ID,\n" +
                "    THREAD.CONFIGURATION_NAME,	\n" +
                "    THREAD.FILA,\n" +
                "    THREAD.STATUS,\n" +
                "    THREAD.TOTAL_PROCESS_TO_EXEC,\n" +
                "    THREAD.TOTAL_PROCESS_EXECUTED,\n" +
                "    THREAD.ACTUAL_TYPE,\n" +
                "    THREAD.ACTUAL_DESCRIPTION,	\n" +
                "    THREAD.TABLE_NAME,\n" +
                "    THREAD.ORI_REPOSITORY_NAME,\n" +
                "    THREAD.DES_REPOSITORY_NAME,\n" +
                "    THREAD.DBLINK_ORIG,\n" +
                "    THREAD.DBLINK_DEST,\n" +
                "    THREAD.DATE_START,\n" +
                "    THREAD.DATE_END,\n" +
                "    THREAD.STATUS_DESC    \n" +
                "FROM SADMIN.CTRL_LOG_COMP_REP_MASTER MASTER\n" +
                "INNER JOIN SADMIN.CTRL_LOG_COMP_REP THREAD ON THREAD.MASTER_LOG_COMPARE_ID = MASTER.ID\n" +
                "WHERE MASTER.ID = '" + masterId.get(screen.getCbbDateSelectedIndex()) + "'" +
                "ORDER BY THREAD.FILA ASC"
            );

            while(rs.next()){
                resultByThread thread = new resultByThread();
                
                thread.setID(rs.getString("ID"));
                thread.setMASTER_LOG_COMPARE_ID(rs.getString("MASTER_LOG_COMPARE_ID"));
                thread.setCONFIGURATION_NAME(rs.getString("CONFIGURATION_NAME"));
                thread.setFILA(rs.getString("FILA"));
                thread.setSTATUS(rs.getString("STATUS"));
                thread.setTOTAL_PROCESS_TO_EXEC(rs.getString("TOTAL_PROCESS_TO_EXEC"));
                thread.setTOTAL_PROCESS_EXECUTED(rs.getString("TOTAL_PROCESS_EXECUTED"));
                thread.setACTUAL_TYPE(rs.getString("ACTUAL_TYPE"));
                thread.setACTUAL_DESCRIPTION(rs.getString("ACTUAL_DESCRIPTION"));
                thread.setTABLE_NAME(rs.getString("TABLE_NAME"));
                thread.setORI_REPOSITORY_NAME(rs.getString("ORI_REPOSITORY_NAME"));
                thread.setDES_REPOSITORY_NAME(rs.getString("DES_REPOSITORY_NAME"));
                thread.setDBLINK_ORIG(rs.getString("DBLINK_ORIG"));
                thread.setDBLINK_DEST(rs.getString("DBLINK_DEST"));
                thread.setDATE_START(rs.getString("DATE_START"));                
                thread.setDATE_END(rs.getString("DATE_END"));
                thread.setSTATUS_DESC(rs.getString("STATUS_DESC"));

                result.add(thread);        
            }
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de leitura no Banco de Dados!\nMensagem: " + e,"Erro",JOptionPane.ERROR_MESSAGE);
        } finally{
            closeConnection("Relatório gerado com sucesso!");
            return result;
        }
    }
    
    // Function used to return the data of the select instruction into a Arraylist
    private ArrayList<resultLog> getResultLog(){        
        // ArrayList used to return the select query result
        ArrayList<resultLog> result = new ArrayList<>();
        
        try{
            openConnection("Gerando Relatório...");
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(
                "SELECT\n" +
                "    LOG.FILA,\n" +
                "    LOG.CTRL_LOG_COMP_REP_ID,    \n" +
                "    LOG.TAB_CTRL_BATIMENTO_REP_ID,\n" +
                "	LOG.TABLE_NAME,\n" +
                "	LOG.STATUS,\n" +
                "	LOG.STATUS_DESC,\n" +
                "	LOG.SCRIPT_ERROR\n" +
                "FROM SADMIN.CTRL_LOG_COMP_REP_LOG LOG\n" +
                "WHERE LOG.CTRL_LOG_COMP_REP_MASTER_ID = '" + masterId.get(screen.getCbbDateSelectedIndex()) + "' -- ID MASTER\n" +
                "ORDER BY LOG.FILA, LOG.CTRL_LOG_COMP_REP_ID ASC"
            );

            while(rs.next()){
                resultLog log = new resultLog();
                
                log.setFILA(rs.getString("FILA"));
                log.setCTRL_LOG_COMP_REP_ID(rs.getString("CTRL_LOG_COMP_REP_ID"));
                log.setTAB_CTRL_BATIMENTO_REP_ID(rs.getString("TAB_CTRL_BATIMENTO_REP_ID"));
                log.setTABLE_NAME(rs.getString("TABLE_NAME"));
                log.setSTATUS(rs.getString("STATUS"));
                log.setSTATUS_DESC(rs.getString("STATUS_DESC"));
                log.setSCRIPT_ERROR(rs.getString("SCRIPT_ERROR"));

                result.add(log);        
            }
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de leitura no Banco de Dados!\nMensagem: " + e,"Erro",JOptionPane.ERROR_MESSAGE);
        } finally{
            closeConnection("Relatório gerado com sucesso!");
            return result;
        }
    }
    
    // Function used to return the data of the select instruction into a Arraylist
    private ArrayList<resultBat> getResultBat(){        
        // ArrayList used to return the select query result
        ArrayList<resultBat> result = new ArrayList<>();
        
        try{
            openConnection("Gerando Relatório...");
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(
                "SELECT  \n" +
                "	RESULT.*\n" +
                "FROM SADMIN.BATIMENTO_REPOSITORIO RESULT \n" +
                "WHERE CTRL_LOG_COMP_REP_ID IN (\n" +
                "	SELECT\n" +
                "		ID\n" +
                "	FROM SADMIN.CTRL_LOG_COMP_REP\n" +
                "	WHERE MASTER_LOG_COMPARE_ID = '" + masterId.get(screen.getCbbDateSelectedIndex()) + "' -- ID MASTER\n" +
                ")\n" +
                "AND NOT EXISTS (\n" +
                "	SELECT\n" +
                "		1\n" +
                "	FROM SADMIN.BATIMENTO_REPOSITORIO RESULT2\n" +
                "	WHERE RESULT.CTRL_LOG_COMP_REP_ID IN (\n" +
                "		SELECT\n" +
                "			ID\n" +
                "		FROM SADMIN.CTRL_LOG_COMP_REP\n" +
                "		WHERE MASTER_LOG_COMPARE_ID = '" + masterId.get(screen.getCbbDateSelectedIndex()) + "' -- ID MASTER\n" +
                "	)\n" +
                "	AND (\n" +
                "		RESULT2.OBJECT_NAME = RESULT.PAR_N0\n" +
                "		OR RESULT2.OBJECT_NAME = RESULT.PAR_N1\n" +
                "		OR RESULT2.OBJECT_NAME = RESULT.PAR_N2\n" +
                "		OR RESULT2.OBJECT_NAME = RESULT.PAR_N3\n" +
                "	)\n" +
                "	AND RESULT2.STATUS = 'NOT EXISTS'\n" +
                "	AND RESULT2.GROUP_OBJECT = RESULT.GROUP_OBJECT\n" +
                "	AND RESULT2.ORDER_COL <= RESULT.ORDER_COL\n" +
                ")\n" +
                "ORDER BY RESULT.PAR_N0, RESULT.ORDER_COL, RESULT.DESCRIPTION" 
            );

            while(rs.next()){
                resultBat bat = new resultBat();
                
                bat.setSTATUS(rs.getString("STATUS"));
                bat.setTYPE(rs.getString("TYPE"));
                bat.setGROUP_OBJECT(rs.getString("GROUP_OBJECT"));
                bat.setDESCRIPTION(rs.getString("DESCRIPTION"));
                bat.setPAR_N0(rs.getString("PAR_N0"));
                bat.setPAR_N1(rs.getString("PAR_N1"));
                bat.setPAR_N2(rs.getString("PAR_N2"));
                bat.setPAR_N3(rs.getString("PAR_N3"));
                bat.setOBJECT_NAME(rs.getString("OBJECT_NAME"));
                bat.setCOLUMN_NAME(rs.getString("COLUMN_NAME"));
                bat.setVAL_ORIG(rs.getString("VAL_ORIG"));
                bat.setVAL_DEST(rs.getString("VAL_DEST"));
                bat.setLAST_UPD_ORIG(rs.getString("LAST_UPD_ORIG"));
                bat.setLAST_UPD_DEST(rs.getString("LAST_UPD_DEST"));
                bat.setLAST_UPD_BY_ORIG(rs.getString("LAST_UPD_BY_ORIG"));
                bat.setLAST_UPD_BY_DEST(rs.getString("LAST_UPD_BY_DEST"));

                result.add(bat);
            }
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de leitura no Banco de Dados!\nMensagem: " + e,"Erro",JOptionPane.ERROR_MESSAGE);
        } finally{
            closeConnection("Relatório gerado com sucesso!");
            return result;
        }
    }
    
    // Subclass used to populate the Array "resultByThread"
    private class resultByThread {
        private String ID;
        private String MASTER_LOG_COMPARE_ID;
        private String CONFIGURATION_NAME;
        private String FILA;
        private String STATUS;
        private String TOTAL_PROCESS_TO_EXEC;
        private String TOTAL_PROCESS_EXECUTED;
        private String ACTUAL_TYPE;
        private String ACTUAL_DESCRIPTION;
        private String TABLE_NAME;
        private String ORI_REPOSITORY_NAME;
        private String DES_REPOSITORY_NAME;
        private String DBLINK_ORIG;
        private String DBLINK_DEST;
        private String DATE_START;
        private String DATE_END;
        private String STATUS_DESC;

        public resultByThread() {
            this.ID = null;
            this.MASTER_LOG_COMPARE_ID = null;
            this.CONFIGURATION_NAME = null;
            this.FILA = null;
            this.STATUS = null;
            this.TOTAL_PROCESS_TO_EXEC = null;
            this.TOTAL_PROCESS_EXECUTED = null;
            this.ACTUAL_TYPE = null;
            this.ACTUAL_DESCRIPTION = null;
            this.TABLE_NAME = null;
            this.ORI_REPOSITORY_NAME = null;
            this.DES_REPOSITORY_NAME = null;
            this.DBLINK_ORIG = null;
            this.DBLINK_DEST = null;
            this.DATE_START = null;
            this.DATE_END = null;
            this.STATUS_DESC = null;
        }

        public String getID() { return ID; }
        public void setID(String ID) { this.ID = ID; }

        public String getMASTER_LOG_COMPARE_ID() { return MASTER_LOG_COMPARE_ID; }
        public void setMASTER_LOG_COMPARE_ID(String MASTER_LOG_COMPARE_ID) { this.MASTER_LOG_COMPARE_ID = MASTER_LOG_COMPARE_ID; }

        public String getCONFIGURATION_NAME() { return CONFIGURATION_NAME; }
        public void setCONFIGURATION_NAME(String CONFIGURATION_NAME) { this.CONFIGURATION_NAME = CONFIGURATION_NAME; }

        public String getFILA() { return FILA; }
        public void setFILA(String FILA) { this.FILA = FILA; }

        public String getSTATUS() { return STATUS; }
        public void setSTATUS(String STATUS) { this.STATUS = STATUS; }

        public String getTOTAL_PROCESS_TO_EXEC() { return TOTAL_PROCESS_TO_EXEC; }
        public void setTOTAL_PROCESS_TO_EXEC(String TOTAL_PROCESS_TO_EXEC) { this.TOTAL_PROCESS_TO_EXEC = TOTAL_PROCESS_TO_EXEC; }

        public String getTOTAL_PROCESS_EXECUTED() { return TOTAL_PROCESS_EXECUTED; }
        public void setTOTAL_PROCESS_EXECUTED(String TOTAL_PROCESS_EXECUTED) { this.TOTAL_PROCESS_EXECUTED = TOTAL_PROCESS_EXECUTED; }

        public String getACTUAL_TYPE() { return ACTUAL_TYPE; }
        public void setACTUAL_TYPE(String ACTUAL_TYPE) { this.ACTUAL_TYPE = ACTUAL_TYPE; }

        public String getACTUAL_DESCRIPTION() { return ACTUAL_DESCRIPTION; }
        public void setACTUAL_DESCRIPTION(String ACTUAL_DESCRIPTION) { this.ACTUAL_DESCRIPTION = ACTUAL_DESCRIPTION; }

        public String getTABLE_NAME() { return TABLE_NAME; }
        public void setTABLE_NAME(String TABLE_NAME) { this.TABLE_NAME = TABLE_NAME; }
        
        public String getORI_REPOSITORY_NAME() { return ORI_REPOSITORY_NAME; }
        public void setORI_REPOSITORY_NAME(String ORI_REPOSITORY_NAME) { this.ORI_REPOSITORY_NAME = ORI_REPOSITORY_NAME; }

        public String getDES_REPOSITORY_NAME() { return DES_REPOSITORY_NAME; }
        public void setDES_REPOSITORY_NAME(String DES_REPOSITORY_NAME) { this.DES_REPOSITORY_NAME = DES_REPOSITORY_NAME; }

        public String getDBLINK_ORIG() { return DBLINK_ORIG; }
        public void setDBLINK_ORIG(String DBLINK_ORIG) { this.DBLINK_ORIG = DBLINK_ORIG; }

        public String getDBLINK_DEST() { return DBLINK_DEST; }
        public void setDBLINK_DEST(String DBLINK_DEST) { this.DBLINK_DEST = DBLINK_DEST; }

        public String getDATE_START() { return DATE_START; }
        public void setDATE_START(String DATE_START) { this.DATE_START = DATE_START; }

        public String getDATE_END() { return DATE_END; }
        public void setDATE_END(String DATE_END) { this.DATE_END = DATE_END; }

        public String getSTATUS_DESC() { return STATUS_DESC; }
        public void setSTATUS_DESC(String STATUS_DESC) { this.STATUS_DESC = STATUS_DESC; }
        
        
        
    }
    
    // Subclass used to populate the Array "resultLog"
    private class resultLog {
        private String FILA;
        private String CTRL_LOG_COMP_REP_ID;
        private String TAB_CTRL_BATIMENTO_REP_ID;
        private String TABLE_NAME;
        private String STATUS;
        private String STATUS_DESC;
        private String SCRIPT_ERROR;

        public resultLog() {
            this.FILA = null;
            this.CTRL_LOG_COMP_REP_ID = null;
            this.TAB_CTRL_BATIMENTO_REP_ID = null;
            this.TABLE_NAME = null;
            this.STATUS = null;
            this.STATUS_DESC = null;
            this.SCRIPT_ERROR = null;
        }

        public String getFILA() { return FILA; }
        public void setFILA(String FILA) { this.FILA = FILA; }

        public String getCTRL_LOG_COMP_REP_ID() { return CTRL_LOG_COMP_REP_ID; }
        public void setCTRL_LOG_COMP_REP_ID(String CTRL_LOG_COMP_REP_ID) { this.CTRL_LOG_COMP_REP_ID = CTRL_LOG_COMP_REP_ID; }

        public String getTAB_CTRL_BATIMENTO_REP_ID() { return TAB_CTRL_BATIMENTO_REP_ID; }
        public void setTAB_CTRL_BATIMENTO_REP_ID(String TAB_CTRL_BATIMENTO_REP_ID) { this.TAB_CTRL_BATIMENTO_REP_ID = TAB_CTRL_BATIMENTO_REP_ID; }

        public String getTABLE_NAME() { return TABLE_NAME; }
        public void setTABLE_NAME(String TABLE_NAME) { this.TABLE_NAME = TABLE_NAME; }

        public String getSTATUS() { return STATUS; }
        public void setSTATUS(String STATUS) { this.STATUS = STATUS; }

        public String getSTATUS_DESC() { return STATUS_DESC; }
        public void setSTATUS_DESC(String STATUS_DESC) { this.STATUS_DESC = STATUS_DESC; }

        public String getSCRIPT_ERROR() { return SCRIPT_ERROR; }
        public void setSCRIPT_ERROR(String SCRIPT_ERROR) { this.SCRIPT_ERROR = SCRIPT_ERROR; }
        
    }
    
    // Subclass used to populate the Array "resultBat"
    private class resultBat {
        private String STATUS;
        private String TYPE;
        private String GROUP_OBJECT;
        private String DESCRIPTION;
        private String PAR_N0;
        private String PAR_N1;
        private String PAR_N2;
        private String PAR_N3;
        private String OBJECT_NAME;
        private String COLUMN_NAME;
        private String VAL_ORIG;
        private String VAL_DEST;
        private String LAST_UPD_ORIG;
        private String LAST_UPD_DEST;
        private String LAST_UPD_BY_ORIG;
        private String LAST_UPD_BY_DEST;

        public resultBat() {
            this.STATUS = null;
            this.TYPE = null;
            this.GROUP_OBJECT = null;
            this.DESCRIPTION = null;
            this.PAR_N0 = null;
            this.PAR_N1 = null;
            this.PAR_N2 = null;
            this.PAR_N3 = null;
            this.OBJECT_NAME = null;
            this.COLUMN_NAME = null;
            this.VAL_ORIG = null;
            this.VAL_DEST = null;
            this.LAST_UPD_ORIG = null;
            this.LAST_UPD_DEST = null;
            this.LAST_UPD_BY_ORIG = null;
            this.LAST_UPD_BY_DEST = null;
        }

        public String getSTATUS() {
            return STATUS;
        }

        public void setSTATUS(String STATUS) {
            this.STATUS = STATUS;
        }

        public String getTYPE() {
            return TYPE;
        }

        public void setTYPE(String TYPE) {
            this.TYPE = TYPE;
        }

        public String getGROUP_OBJECT() {
            return GROUP_OBJECT;
        }

        public void setGROUP_OBJECT(String GROUP_OBJECT) {
            this.GROUP_OBJECT = GROUP_OBJECT;
        }

        public String getDESCRIPTION() {
            return DESCRIPTION;
        }

        public void setDESCRIPTION(String DESCRIPTION) {
            this.DESCRIPTION = DESCRIPTION;
        }

        public String getPAR_N0() {
            return PAR_N0;
        }

        public void setPAR_N0(String PAR_N0) {
            this.PAR_N0 = PAR_N0;
        }

        public String getPAR_N1() {
            return PAR_N1;
        }

        public void setPAR_N1(String PAR_N1) {
            this.PAR_N1 = PAR_N1;
        }

        public String getPAR_N2() {
            return PAR_N2;
        }

        public void setPAR_N2(String PAR_N2) {
            this.PAR_N2 = PAR_N2;
        }

        public String getPAR_N3() {
            return PAR_N3;
        }

        public void setPAR_N3(String PAR_N3) {
            this.PAR_N3 = PAR_N3;
        }

        public String getOBJECT_NAME() {
            return OBJECT_NAME;
        }

        public void setOBJECT_NAME(String OBJECT_NAME) {
            this.OBJECT_NAME = OBJECT_NAME;
        }

        public String getCOLUMN_NAME() {
            return COLUMN_NAME;
        }

        public void setCOLUMN_NAME(String COLUMN_NAME) {
            this.COLUMN_NAME = COLUMN_NAME;
        }

        public String getVAL_ORIG() {
            return VAL_ORIG;
        }

        public void setVAL_ORIG(String VAL_ORIG) {
            this.VAL_ORIG = VAL_ORIG;
        }

        public String getVAL_DEST() {
            return VAL_DEST;
        }

        public void setVAL_DEST(String VAL_DEST) {
            this.VAL_DEST = VAL_DEST;
        }

        public String getLAST_UPD_ORIG() {
            return LAST_UPD_ORIG;
        }

        public void setLAST_UPD_ORIG(String LAST_UPD_ORIG) {
            this.LAST_UPD_ORIG = LAST_UPD_ORIG;
        }

        public String getLAST_UPD_DEST() {
            return LAST_UPD_DEST;
        }

        public void setLAST_UPD_DEST(String LAST_UPD_DEST) {
            this.LAST_UPD_DEST = LAST_UPD_DEST;
        }

        public String getLAST_UPD_BY_ORIG() {
            return LAST_UPD_BY_ORIG;
        }

        public void setLAST_UPD_BY_ORIG(String LAST_UPD_BY_ORIG) {
            this.LAST_UPD_BY_ORIG = LAST_UPD_BY_ORIG;
        }

        public String getLAST_UPD_BY_DEST() {
            return LAST_UPD_BY_DEST;
        }

        public void setLAST_UPD_BY_DEST(String LAST_UPD_BY_DEST) {
            this.LAST_UPD_BY_DEST = LAST_UPD_BY_DEST;
        }

        
        
    }
}
