/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BatimentoModule.SOM;

import BatimentoModule.SOM.BatimentoSOMScreen;
import databaseModule.DataController;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Matheus Cabral Rosa
 */
public class SOMController extends DataController {
    BatimentoSOMScreen screen;
    Date date;
    SimpleDateFormat dateFormat;
    
    public SOMController(String dbUser, String dbPassword) {
        super.setDbUser(dbUser);
        super.setDbPassword(dbPassword);
        date = new Date();
        dateFormat = new SimpleDateFormat("dd/MM/YYYY");
        screen = new BatimentoSOMScreen();
        screen.setExtendedState(MAXIMIZED_BOTH);
        screen.insertTxtDateSearchSpec(dateFormat.format(date));
        this.selectDBLink();
        screen.setCbbEnviromentOriEnabled(true);
        screen.setListenerExecSOMExtract(new btnExecListener());
        screen.setListenerSave(new btnSaveListener());
        //screen.setListenerCbbEnviromentOri(new CbbAmbOriListener());
        //screen.setListenerCbbEnviromentDest(new CbbAmbDestListener());
    }
    
    
    public void selectDBLink(){
        try{
            super.openConnection("Buscando: DBLINK's");
            super.statement = super.conn.createStatement();
            ResultSet readline = super.statement.executeQuery("SELECT SUBSTR(HOST, 0, 3) AS HOST FROM ALL_DB_LINKS WHERE HOST NOT LIKE 'DEV%' AND HOST NOT LIKE 'QADBA' ORDER BY HOST ASC");
            while(readline.next()){
                if("QA3SBL8".equals(readline.getString("HOST")) || "DEVT_QA3".equals(readline.getString("HOST"))){
                    if("QA3SBL8".equals(readline.getString("HOST"))){
                        screen.insertCbbEnviromentOri("QA3SBL8" + " - " + "DEVT_QA3");
                        screen.insertCbbEnviromentDest("QA3SBL8" + " - " + "DEVT_QA3");
                    }                    
                } else {
                    screen.insertCbbEnviromentOri(readline.getString("HOST"));
                    screen.insertCbbEnviromentDest(readline.getString("HOST"));
                }
                
            }
            readline.close();
            super.closeConnection("Fim da busca do contexto atual: DBLINK's");
        } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro de leitura no Banco de Dados!\nMensagem: " + e,"Erro",JOptionPane.ERROR_MESSAGE);
        } finally {
            screen.setCbbEnviromentOriEnabled(true);
            screen.setBtnExecCompareEnabled(true);
        }
    }
            
    // Function to show the comparizon result on screen
    public void showResult(){
        screen.setLog("Exibindo os Dados na lista...");
        //Prenche table
        ArrayList<SomExportReport> som = selectSOMResult();
        DefaultTableModel dt = (DefaultTableModel) screen.lstResultExport.getModel();
        dt.setNumRows(som.size());

        for (int i = 0; i < som.size(); i++) {
            screen.setLog("Carregando a Linha:" + i);
            dt.setValueAt(i + 1, i, 0);
            dt.setValueAt(som.get(i).getAMBIENTE(), i, 1);
            dt.setValueAt(som.get(i).getMGR_BUG(), i, 2);
            dt.setValueAt(som.get(i).getRDM_CRQ(), i, 3);
            dt.setValueAt(som.get(i).getTIPO_OBJETO(), i, 4);
            dt.setValueAt(som.get(i).getNOME_OBJETO(), i, 5);
            dt.setValueAt(som.get(i).getOBJ_SVN_FILE(), i, 6);
            dt.setValueAt(som.get(i).getREVISION(), i, 7);
            dt.setValueAt(som.get(i).getDATA_MIGRACAO(), i, 8);
            dt.setValueAt(som.get(i).getCRIADO_POR(), i, 9);
            dt.setValueAt(som.get(i).getMIGRADO(), i, 10);
            dt.setValueAt(som.get(i).getDATA_MODIFICACAO(), i, 11);
            dt.setValueAt(som.get(i).getIS_REBUILD(), i, 12);
        }
        screen.setLog("Dados exibidos com sucesso!");
    }
    
    
    public ArrayList<SomExportReport> selectSOMResult(){
        ArrayList<SomExportReport> resultQuery = new ArrayList<>();
        
        try{
            super.openConnection("Gerando Relatório...");
            super.statement = super.conn.createStatement();
            ResultSet rs = super.statement.executeQuery(
                "SELECT\n" +
                "   SOM.*\n" +
                "FROM SADMIN.BATIMENTO_SOM SOM\n" +
                "WHERE SOM.PAR_ROW_ID = (\n" +
                "    SELECT\n" +
                "        MAX(ROW_ID)\n" +
                "    FROM SADMIN.BATIMENTO_SOM_MASTER\n" +
                "    WHERE CONFIGURATION_NAME = 'NV'\n" +
                "    AND STATUS_CD = 'Success'\n" +
                ")\n" +
                "ORDER BY ROW_ID ASC");
            
            while(rs.next()){
                SomExportReport som = new SomExportReport();
                
                som.setAMBIENTE(rs.getString("AMBIENTE"));
                som.setMGR_BUG(rs.getString("MGR_BUG"));
                som.setRDM_CRQ(rs.getString("RDM_CRQ"));
                som.setTIPO_OBJETO(rs.getString("TIPO_OBJETO"));
                som.setNOME_OBJETO(rs.getString("NOME_OBJETO"));
                som.setOBJ_SVN_FILE(rs.getString("OBJ_SVN_FILE"));
                som.setREVISION(rs.getString("REVISION"));
                som.setDATA_MIGRACAO(rs.getString("DATA_MIGRACAO"));
                som.setCRIADO_POR(rs.getString("CRIADO_POR"));
                som.setMIGRADO(rs.getString("MIGRADO"));
                som.setDATA_MODIFICACAO(rs.getString("DATA_MODIFICACAO"));
                som.setIS_REBUILD(rs.getString("IS_REBUILD"));
                                
                resultQuery.add(som);
            }
            rs.close();
        } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro de leitura no Banco de Dados!\nMensagem: " + e,"Erro",JOptionPane.ERROR_MESSAGE);
        } finally{
            closeConnection("Relatório gerado com sucesso!");
        }
        return resultQuery;
    }
    
    public boolean geraRelBatimentoSOMCSV(String path) {
        ArrayList<SomExportReport> result = selectSOMResult();
        String header = "AMBIENTE;MGR_BUG;RDM_CRQ;TIPO_OBJETO;NOME_OBJETO;OBJ_SVN_FILE;REVISION;DATA_MIGRACAO;CRIADO_POR;MIGRADO;DATA_MODIFICACAO;IS_REBUILD\n";
        boolean criado = false;

        if (!path.isEmpty()) {
            try {
                BufferedWriter buff = new BufferedWriter(new FileWriter(path));
                buff.append(header);

                for (int i = 0; i < result.size(); i++) {
                    buff.append(result.get(i).getAMBIENTE() + ";");
                    buff.append(result.get(i).getMGR_BUG() + ";");
                    buff.append(result.get(i).getRDM_CRQ() + ";");
                    buff.append(result.get(i).getTIPO_OBJETO() + ";");
                    buff.append(result.get(i).getNOME_OBJETO() + ";");
                    buff.append(result.get(i).getOBJ_SVN_FILE() + ";");
                    buff.append(result.get(i).getREVISION() + ";");
                    buff.append(result.get(i).getDATA_MIGRACAO() + ";");
                    buff.append(result.get(i).getCRIADO_POR() + ";");
                    buff.append(result.get(i).getMIGRADO() + ";");
                    buff.append(result.get(i).getDATA_MODIFICACAO() + ";");
                    buff.append(result.get(i).getIS_REBUILD() + "\n");
                }

                buff.close();
                criado = true;

            } catch (Exception e) {
                criado = false;
            }

        } else {
            criado = false;
        }
        return criado;
    }
    
    public void insertOnMasterTable(){
        try{
            super.openConnection("Inserindo dados na tabela master");
            super.statement = super.conn.createStatement();
            statement.executeUpdate("INSERT INTO SADMIN.BATIMENTO_SOM_MASTER (ROW_ID, CREATED, LAST_UPD, STATUS_CD, CONFIGURATION_NAME) VALUES (SADMIN.SEQ_SOM_MASTER.nextval, SYSDATE, SYSDATE, 'Executing', 'NV')");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de leitura no Banco de Dados!\nMensagem: " + e,"Erro",JOptionPane.ERROR_MESSAGE);
        } finally {
            super.closeConnection("Dados inseridos com sucesso!");
        }
    }
    
    public void executeSOMComparizon(){
        try{
            super.openConnection("Executando a comparação da SOM...");
            super.statement = super.conn.createStatement();
            statement.execute(PLExecSomComparison(screen.getCbbEnviromentOri(), screen.getTxtDateSearchSpec(), "QADBA"));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de leitura no Banco de Dados!\nMensagem: " + e,"Erro",JOptionPane.ERROR_MESSAGE);
        } finally {
            super.closeConnection("Fim da Comparação da SOM");
        }
    }
    
    public String PLExecSomComparison(String enviromentOri, String date, String dblink){
        return 
            "DECLARE\n" +
            "---------ENTRADAS-----------\n" +
            "    AMBIENTE                 VARCHAR2(300) := '" + enviromentOri + "'; --INFORMAR AMBIENTE\n" +
            "    DATADUMP                 DATE := TO_DATE('" + date + "','DD/MM/YYYY'); --INFORMAR DATA DE DUMP DO AMBIENTE\n" +
            "------------------------------------\n" +
            "    MIGRADO                  VARCHAR2(1);\n" +
            "    COUNT_REBUILD            NUMBER;\n" +
            "    REBUILD                  VARCHAR2(1);\n" +
            "    NOME_OBJETO_SEM_VERSAO   VARCHAR2(300);\n" +
            "	\n" +
            "    CURSOR OBJECTO (PARAMETRO_AMBIENTE VARCHAR2, PARAMETRO_DATADUMP DATE) IS \n" +
            "		SELECT\n" +
            "			E.ENV_ENVIROMENT, 	-- AMBIENTE\n" +
            "			M.MGR_BUG,			-- MIGRACAO/BUG\n" +
            "			M.MGR_PM   CRQ,		-- RDM/CRQ\n" +
            "			O.OBJ_TYPE_UID,		--\n" +
            "			OT.OBTP_NAME,		-- TIPO OBJETO\n" +
            "			O.OBJ_NAME,			-- NOME OBJETO\n" +
            "			O.OBJ_SVN_FILE,	-- CAMINHO SVN\n" +
            "			O.OBJ_SVN_REVISION,	-- REVISION\n" +
            "			M.MGR_START_DATE,	-- DATA MIGRACAO\n" +
            "			O.OBJ_CREATED_BY,	-- CRIADO POR\n" +
            "			O.OBJ_MIGRATED,		-- MIGRADO\n" +
            "			O.OBJ_CHANGED_DATE 	-- DATA MIGRACAO\n" +
            "		FROM SOM.TB_OBJECT@"+ dblink +" O,\n" +
            "			SOM.TB_OBJECT_TYPE@"+ dblink +" OT,\n" +
            "			SOM.TB_MIGRATION@"+ dblink +" M,\n" +
            "			SOM.TB_ENVIROMENT@"+ dblink +" E\n" +
            "		WHERE O.OBJ_TYPE_UID = OT.OBTP_UID\n" +
            "		AND O.OBJ_MIGRATION_UID = M.MGR_UID\n" +
            "		AND M.MGR_TARGET_ENVIROMENT_UID = E.ENV_UID\n" +
            "		AND M.MGR_START_DATE IS NOT NULL\n" +
            "		AND O.OBJ_SVN_FILE IS NOT NULL\n" +
            "		AND	M.MGR_START_DATE > PARAMETRO_DATADUMP\n" +
            "		AND E.ENV_ENVIROMENT = PARAMETRO_AMBIENTE;	\n" +
            "\n" +
            "BEGIN\n" +
            "	\n" +
            "    FOR O IN OBJECTO(AMBIENTE,DATADUMP) LOOP\n" +
            "        IF (O.OBJ_MIGRATED = 1) THEN\n" +
            "            MIGRADO := 'Y';\n" +
            "        ELSE\n" +
            "            MIGRADO := 'N';\n" +
            "        END IF;\n" +
            "\n" +
            "        CASE O.OBTP_NAME\n" +
            "            WHEN 'Workflow Process' THEN NOME_OBJETO_SEM_VERSAO := SUBSTR(O.OBJ_NAME,1,INSTR(O.OBJ_NAME,':') - 1);\n" +
            "                SELECT\n" +
            "                    COUNT(*)\n" +
            "                INTO COUNT_REBUILD\n" +
            "                FROM\n" +
            "                    SOM.TB_OBJECT@"+ dblink +" RO,\n" +
            "                    SOM.TB_MIGRATION@"+ dblink +" RM,\n" +
            "                    SOM.TB_ENVIROMENT@"+ dblink +" RE\n" +
            "                WHERE\n" +
            "                    RO.OBJ_MIGRATION_UID = RM.MGR_UID\n" +
            "                    AND RM.MGR_TARGET_ENVIROMENT_UID = RE.ENV_UID\n" +
            "                    AND RE.ENV_ENVIROMENT IN ('QA3', 'DEVT_QA3')\n" +
            "                    AND RM.MGR_START_DATE > DATADUMP\n" +
            "                    AND RO.OBJ_TYPE_UID = O.OBJ_TYPE_UID\n" +
            "                    AND -- CURSOR\n" +
            "                     RO.OBJ_NAME LIKE (NOME_OBJETO_SEM_VERSAO || '%' ); -- Cursor\n" +
            "\n" +
            "            WHEN 'Workspace Prjs' THEN NOME_OBJETO_SEM_VERSAO := SUBSTR(O.OBJ_NAME,1,INSTR(O.OBJ_NAME,'_',9) - 1);\n" +
            "\n" +
            "                NOME_OBJETO_SEM_VERSAO := O.OBJ_NAME;\n" +
            "                SELECT\n" +
            "                    COUNT(*)\n" +
            "                INTO COUNT_REBUILD\n" +
            "                FROM\n" +
            "                    SOM.TB_OBJECT@"+ dblink +" RO,\n" +
            "                    SOM.TB_MIGRATION@"+ dblink +" RM,\n" +
            "                    SOM.TB_ENVIROMENT@"+ dblink +" RE\n" +
            "                WHERE\n" +
            "                    RO.OBJ_MIGRATION_UID = RM.MGR_UID\n" +
            "                    AND RM.MGR_TARGET_ENVIROMENT_UID = RE.ENV_UID\n" +
            "                    AND RE.ENV_ENVIROMENT IN ('QA3', 'DEVT_QA3')\n" +
            "                    AND RM.MGR_START_DATE > DATADUMP\n" +
            "                    AND RO.OBJ_TYPE_UID = O.OBJ_TYPE_UID\n" +
            "                    AND -- CURSOR\n" +
            "                     RO.OBJ_NAME LIKE (NOME_OBJETO_SEM_VERSAO || '%' ); -- CURSOR\n" +
            "\n" +
            "            ELSE\n" +
            "                NOME_OBJETO_SEM_VERSAO := O.OBJ_NAME;\n" +
            "                SELECT\n" +
            "                    COUNT(*)\n" +
            "                INTO COUNT_REBUILD\n" +
            "                FROM\n" +
            "                    SOM.TB_OBJECT@"+ dblink +" RO,\n" +
            "                    SOM.TB_MIGRATION@"+ dblink +" RM,\n" +
            "                    SOM.TB_ENVIROMENT@"+ dblink +" RE\n" +
            "                WHERE\n" +
            "                    RO.OBJ_MIGRATION_UID = RM.MGR_UID\n" +
            "                    AND RM.MGR_TARGET_ENVIROMENT_UID = RE.ENV_UID\n" +
            "                    AND RE.ENV_ENVIROMENT IN ('QA3', 'DEVT_QA3')\n" +
            "                    AND RM.MGR_START_DATE > DATADUMP\n" +
            "                    AND RO.OBJ_TYPE_UID = O.OBJ_TYPE_UID\n" +
            "                    AND -- CURSOR\n" +
            "                     RO.OBJ_NAME = NOME_OBJETO_SEM_VERSAO; -- CURSOR\n" +
            "\n" +
            "        END CASE;\n" +
            "\n" +
            "        IF COUNT_REBUILD > 0 THEN\n" +
            "            REBUILD := 'Y';\n" +
            "        ELSE\n" +
            "            REBUILD := 'N';\n" +
            "        END IF;\n" +
            "		\n" +
            "		INSERT INTO SADMIN.BATIMENTO_SOM (ROW_ID, PAR_ROW_ID, AMBIENTE, MGR_BUG, RDM_CRQ, TIPO_OBJETO, NOME_OBJETO, OBJ_SVN_FILE, REVISION, DATA_MIGRACAO, CRIADO_POR, MIGRADO, DATA_MODIFICACAO, IS_REBUILD)\n" +
            "		VALUES(SADMIN.SEQ_SOM.NEXTVAL, (SELECT MAX(ROW_ID) FROM SADMIN.BATIMENTO_SOM_MASTER), O.ENV_ENVIROMENT, O.MGR_BUG, O.CRQ, O.OBTP_NAME, NOME_OBJETO_SEM_VERSAO, O.OBJ_SVN_FILE, O.OBJ_SVN_REVISION, O.MGR_START_DATE, O.OBJ_CREATED_BY, MIGRADO, O.OBJ_CHANGED_DATE, REBUILD);\n" +
            "		\n" +
            "    END LOOP;\n" +
            "	\n" +
            "	UPDATE SADMIN.BATIMENTO_SOM_MASTER SMAS\n" +
            "	SET SMAS.LAST_UPD = SYSDATE,\n" +
            "		SMAS.STATUS_CD = 'Success'\n" +
            "	WHERE SMAS.ROW_ID = (\n" +
            "        SELECT\n" +
            "            MAX(ROW_ID)\n" +
            "        FROM SADMIN.BATIMENTO_SOM_MASTER SMAS\n" +
            "    );\n" +
            "END;";
    }
    
    private class btnExecListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            insertOnMasterTable();                
            executeSOMComparizon();
            showResult();
            screen.clickSave();
            screen.setBtnSaveEnabled(true);
        }
        
    }
    
    private class btnSaveListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            screen.setLog("Gerando Relatório...");
            try{
                //Abre caixa de dialogo para selecionar caminho do arquivo que será gerado.
                JFileChooser fc = new JFileChooser();
                fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                fc.setDialogTitle("Selecione o caminho desejado");
                //fc.setCurrentDirectory("");
                fc.showOpenDialog(screen);

                //gera arquivo relatório em .csv
                try{
                String path = fc.getSelectedFile().toString() + "\\RelatorioBatimento(" + screen.getCbbEnviromentOri() + " - QA3_DEVT_QA3).csv";
                    if(geraRelBatimentoSOMCSV(path)){
                        screen.setLog("Relatório gerado com sucesso no caminho: " + path);
                        JOptionPane.showMessageDialog(null, "Relatório gerado com sucesso no caminho:\n" + path);
                    } else {
                        screen.setLog("Erro ao tentar gerar relatório!");
                        JOptionPane.showMessageDialog(null, "Erro ao tentar gerar relatório!");
                    }                    
                } catch(Exception ex) {
                    System.out.println("Exceção Gerada: " + ex);
                }
            } catch (Exception ex){
                JOptionPane.showMessageDialog(null, "ERRO: " + ex);
            }
        }
        
    }
    
    /*private class CbbAmbOriListener implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent ie) {
            //screen.setCbbEnviromentDestEnabled(true);
            screen.setBtnExecCompareEnabled(true);
        }
        
    }*/
    
    /*private class CbbAmbDestListener implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent ie) {
            screen.setBtnExecCompareEnabled(true);
        }
        
    }*/
    
    private class SomExportReport {
        private String AMBIENTE;
        private String MGR_BUG;
        private String RDM_CRQ;
        private String TIPO_OBJETO;
        private String NOME_OBJETO;
        private String OBJ_SVN_FILE;
        private String REVISION;
        private String DATA_MIGRACAO;
        private String CRIADO_POR;
        private String MIGRADO;
        private String DATA_MODIFICACAO;
        private String IS_REBUILD;

        public SomExportReport(String AMBIENTE, String MGR_BUG, String RDM_CRQ, String TIPO_OBJETO, String NOME_OBJETO, String OBJ_SVN_FILE, String REVISION, String DATA_MIGRACAO, String CRIADO_POR, String MIGRADO, String DATA_MODIFICACAO, String IS_REBUILD) {
            this.AMBIENTE = AMBIENTE;
            this.MGR_BUG = MGR_BUG;
            this.RDM_CRQ = RDM_CRQ;
            this.TIPO_OBJETO = TIPO_OBJETO;
            this.NOME_OBJETO = NOME_OBJETO;
            this.OBJ_SVN_FILE = OBJ_SVN_FILE;
            this.REVISION = REVISION;
            this.DATA_MIGRACAO = DATA_MIGRACAO;
            this.CRIADO_POR = CRIADO_POR;
            this.MIGRADO = MIGRADO;
            this.DATA_MODIFICACAO = DATA_MODIFICACAO;
            this.IS_REBUILD = IS_REBUILD;
        }

        private SomExportReport() { }

        public String getAMBIENTE() { return AMBIENTE; }
        public void setAMBIENTE(String AMBIENTE) { this.AMBIENTE = AMBIENTE; }

        public String getMGR_BUG() { return MGR_BUG; }
        public void setMGR_BUG(String MGR_BUG) { this.MGR_BUG = MGR_BUG; }

        public String getRDM_CRQ() { return RDM_CRQ; }
        public void setRDM_CRQ(String RDM_CRQ) { this.RDM_CRQ = RDM_CRQ; }

        public String getTIPO_OBJETO() { return TIPO_OBJETO; }
        public void setTIPO_OBJETO(String TIPO_OBJETO) { this.TIPO_OBJETO = TIPO_OBJETO; }

        public String getNOME_OBJETO() { return NOME_OBJETO; }
        public void setNOME_OBJETO(String NOME_OBJETO) { this.NOME_OBJETO = NOME_OBJETO; }

        public String getOBJ_SVN_FILE() { return OBJ_SVN_FILE; }
        public void setOBJ_SVN_FILE(String OBJ_SVN_FILE) { this.OBJ_SVN_FILE = OBJ_SVN_FILE; }

        public String getREVISION() { return REVISION; }
        public void setREVISION(String REVISION) { this.REVISION = REVISION; }

        public String getDATA_MIGRACAO() { return DATA_MIGRACAO; }
        public void setDATA_MIGRACAO(String DATA_MIGRACAO) { this.DATA_MIGRACAO = DATA_MIGRACAO; }

        public String getCRIADO_POR() { return CRIADO_POR; }
        public void setCRIADO_POR(String CRIADO_POR) { this.CRIADO_POR = CRIADO_POR; }

        public String getMIGRADO() { return MIGRADO; }
        public void setMIGRADO(String MIGRADO) { this.MIGRADO = MIGRADO; }

        public String getDATA_MODIFICACAO() { return DATA_MODIFICACAO; }
        public void setDATA_MODIFICACAO(String DATA_MODIFICACAO) { this.DATA_MODIFICACAO = DATA_MODIFICACAO; }

        public String getIS_REBUILD() { return IS_REBUILD; }
        public void setIS_REBUILD(String IS_REBUILD) { this.IS_REBUILD = IS_REBUILD; }
        
        
    }
    
}
