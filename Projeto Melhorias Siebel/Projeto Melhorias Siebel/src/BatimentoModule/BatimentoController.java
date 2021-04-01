/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BatimentoModule;

import SystemSettingsModule.AboutSystemScreen;
import databaseModule.DataController;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jxl.Workbook;
import jxl.write.*;

/**
 *
 * @author Matheus Cabral Rosa
 */
public class BatimentoController extends DataController {    
    // Class instances
    BatimentoThread thread;
    BatimentoScreen screen;
    Date date;
    SimpleDateFormat dateFormat;
    AboutSystemScreen about;
    
    // Variables
    private String confName;
    private String firstAmb;
    private String secAmb;
    private String firstRep;
    private String secRep;
    private String dateSeachSpec;
    private int numThreads;
    
    // Empty Constructor
    public BatimentoController() { }    
    
    public BatimentoController(String user, String password) {
        super.setDbUser(user);
        super.setDbPassword(password);
        //relBatControl = new RelatorioBatimentoBS(user, password);
        screen = new BatimentoScreen();
        date = new Date();
        dateFormat = new SimpleDateFormat("dd/MM/YYYY");
        this.LoadQuery();
        screen.setListenerExecBat(new execBatimento());
        screen.setListenerSave(new saveResult());
        screen.setListenerCbbProj(new projectSelected());
        screen.setListenerAmbOri(new AmbOriSelected());
        screen.setListenerAmbDest(new AmbDestSelected());
        screen.setListenerAboutSystem(new AboutSystem());
        screen.setExtendedState(MAXIMIZED_BOTH);        
    }

    public BatimentoController(String firstAmb, String secAmb, String firstRep, String secRep, String dateSeachSpec, int numThreads) {
        this.firstAmb = firstAmb;
        this.secAmb = secAmb;
        this.firstRep = firstRep;
        this.secRep = secRep;
        this.dateSeachSpec = dateSeachSpec;
        this.numThreads = numThreads;
    }

    // Getters and Setters
    public String getConfName() { return confName; }
    public void setConfName(String confName) { this.confName = confName; }
    
    public String getFirstAmb() { return firstAmb; }
    public void setFirstAmb(String firstAmb) { this.firstAmb = firstAmb; }

    public String getSecAmb() { return secAmb; }
    public void setSecAmb(String secAmb) { this.secAmb = secAmb; }

    public String getFirstRep() { return firstRep; }
    public void setFirstRep(String firstRep) { this.firstRep = firstRep; }

    public String getSecRep() { return secRep; }
    public void setSecRep(String secRep) { this.secRep = secRep; }

    public String getDateSeachSpec() { return dateSeachSpec; }
    public void setDateSeachSpec(String dateSeachSpec) { this.dateSeachSpec = dateSeachSpec; }

    public int getNumThreads() { return numThreads; }
    public void setNumThreads(int numThreads) { this.numThreads = numThreads; }
    
    public void setBatScreenVisible(boolean visibility) { screen.setVisible(visibility); }
    
    // Function used to load projects on BatimentoScreen startup
    private void LoadQuery(){
        screen.setCbbProjEnabled(false);
        screen.clearCbbProj();
        
        // Call the Select Function on DataController to get the Projects list
        selectProject("SELECT DISTINCT CONFIGURATION_NAME FROM SADMIN.TAB_CTRL_BATIMENTO_REP");
        screen.insertCbbProj("Selecione...");
        for(int i = 0; i < resultQuery.size(); i++){
            screen.insertCbbProj(resultQuery.get(i));
        }
        
        screen.insertTxtDateSearchSpec(dateFormat.format(date));
        screen.setCbbProjEnabled(true);
    }
    
    // Function used to create Threads
    public boolean createThreads(){
        try{
            for(int i=1; i <= getNumThreads(); i++){
                System.out.println("A " + i + "ª Thread foi iniciada...");
                //log.addList("A " + i + "ª Thread foi iniciada...");
                thread = new BatimentoThread("Thread"+i, getFirstRep(), getSecRep(), getFirstAmb(), getSecAmb(), getDateSeachSpec(), String.valueOf(i), getConfName(), super.getDbUser(), super.getDbPassword());
            }
            thread.waitThreadsEnd();
            return true;
        } catch (Exception e){
            return false;
        }        
    }
    
    // Function used to get the maximum of threads used
    private int getMaxThreads(){
        selectFunction("select MAX(FILA) as FILA from SADMIN.TAB_CTRL_BATIMENTO_REP where CONFIGURATION_NAME = '" + screen.getCbbProj() + "'", "Threads");
        return Integer.parseInt(super.resultQuery.get(0));
    }
    
    public void selectFunction(String Query, String function){
        resultQuery = new ArrayList<>();
        try{
            super.openConnection("Buscando: " + function);
            super.statement = super.conn.createStatement();
            ResultSet readline = super.statement.executeQuery(Query);
            while(readline.next()){
                switch(function){
                    case "DB_LINKS": // Used on AboutViewScreen
                        resultQuery.add(readline.getString("HOST"));
                        break;
                    case "Threads": // Used to get the maximum of threads used
                        resultQuery.add(readline.getString("FILA"));
                        break;
                    default:
                        break;
                }
            }
            readline.close();
            super.closeConnection("Fim da busca do contexto atual: " + function);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de leitura no Banco de Dados!\nMensagem: " + e,"Erro",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Function used to return Repository's
    public void selectRepository(String Query){
        resultQuery = new ArrayList<>();
        try{
            super.openConnection("");
            super.statement = super.conn.createStatement();
            ResultSet readline = super.statement.executeQuery(Query);
            while(readline.next()){
                resultQuery.add(readline.getString("NAME"));
            }
            readline.close();
        } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro de leitura no Banco de Dados!\nMensagem: " + e,"Erro",JOptionPane.ERROR_MESSAGE);
        } finally {
            super.closeConnection("");
        }
    }
    
    // Function used to return Projects
    public void selectProject(String Query){
        resultQuery = new ArrayList<>();
        try{
            super.openConnection("Buscando Projetos Existentes");
            super.statement = super.conn.createStatement();
            ResultSet readline = super.statement.executeQuery(Query);
            while(readline.next()){
                resultQuery.add(readline.getString("CONFIGURATION_NAME"));
            }
            readline.close();
        } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro de leitura no Banco de Dados!\nMensagem: " + e,"Erro",JOptionPane.ERROR_MESSAGE);
        } finally {
            super.closeConnection("Fim da busca dos projetos");
        }
    }
    
    public void runPLCompareAmb(String RepOrigemName, String RepDestinoName, String DbLinkOrigem, String DbLinkDestino, String Data, String FilaThreads, String ConfName){
        try{
            super.openConnection("Thread " + String.valueOf(FilaThreads));
            statement = super.conn.createStatement();
            statement.execute(instructions.queryCompareRep(RepOrigemName, RepDestinoName, DbLinkOrigem, DbLinkDestino, Data, FilaThreads, ConfName, super.getDbOwner()));
            super.closeConnection("Thread " + String.valueOf(FilaThreads));
        } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao executar o processo no Banco de Dados!\nMensagem: " + e,"Erro",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public String runPLCompareAmbMaster(String RepOrigemName, String RepDestinoName, String DbLinkOrigem, String DbLinkDestino, String ConfName){
        try{
            super.openConnection("Tabela Master");
            statement = super.conn.createStatement();
            statement.execute(instructions.queryCompareRepMaster(RepOrigemName, RepDestinoName, DbLinkOrigem, DbLinkDestino, ConfName, super.getDbOwner()));
            super.closeConnection("Tabela Master");
            return "sucesso";
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao executar o processo no Banco de Dados!\nMensagem: " + e,"Erro",JOptionPane.ERROR_MESSAGE);
            return "erro";
        }
    }
    
    // Function to show the comparizon result on screen
    public void showCompareResult(){
        screen.setLog("Exibindo os Dados na lista...");
        //Prenche table
        ArrayList<RelatorioBatimentoController> rel = getRelatorioBatimento();
        DefaultTableModel dt = (DefaultTableModel) screen.dtRelatorioBatimento.getModel();
        dt.setNumRows(rel.size());

        for (int i = 0; i < rel.size(); i++) {
            screen.setLog("Carregando a Linha:" + i);
            dt.setValueAt(rel.get(i).getStatus(), i, 0);
            dt.setValueAt(rel.get(i).getType(), i, 1);
            dt.setValueAt(rel.get(i).getGroupObject(), i, 2);
            dt.setValueAt(rel.get(i).getParN0(), i, 3);
            dt.setValueAt(rel.get(i).getParN1(), i, 4);
            dt.setValueAt(rel.get(i).getParN2(), i, 5);
            dt.setValueAt(rel.get(i).getParN3(), i, 6);
            dt.setValueAt(rel.get(i).getOrderCol(), i, 7);
            dt.setValueAt(rel.get(i).getDescription(), i, 8);
            dt.setValueAt(rel.get(i).getObjectName(), i, 9);
            dt.setValueAt(rel.get(i).getColumnName(), i, 10);
            dt.setValueAt(rel.get(i).getValOrig(), i, 11);
            dt.setValueAt(rel.get(i).getValDest(), i, 12);
            dt.setValueAt(rel.get(i).getLastUpdOrig(), i, 13);
            dt.setValueAt(rel.get(i).getLastUpdDest(), i, 14);
            dt.setValueAt(rel.get(i).getLastUpdByOrig(), i, 15);
            dt.setValueAt(rel.get(i).getLastUpdByDest(), i, 16);
            dt.setValueAt(rel.get(i).getCtrlLogComRepId(), i, 17);
            dt.setValueAt(rel.get(i).getId(), i, 18);
        }
        screen.setLog("Dados exibidos com sucesso!");
    }
    
    // Function to execute the Enviroment Comparizon
    private class execBatimento implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(!"Selecione...".equals(screen.getCbbProj()) && !"".equals(screen.getCbbProj()) && screen.getCbbProj() != null){
                if(!"".equals(screen.getTxtDateSearchSpec()) && screen.getTxtDateSearchSpec() != null){
                    if(!"Selecione...".equals(screen.getCbbAmbOri()) && !"".equals(screen.getCbbAmbOri()) && screen.getCbbAmbOri() != null){
                        if(!"Selecione...".equals(screen.getCbbRepOri()) && !"".equals(screen.getCbbRepOri()) && screen.getCbbRepOri() != null){
                            if(!"Selecione...".equals(screen.getCbbAmbDest()) && !"".equals(screen.getCbbAmbDest()) && screen.getCbbAmbDest() != null){
                                if(!"Selecione...".equals(screen.getCbbRepDest()) && !"".equals(screen.getCbbRepDest()) && screen.getCbbRepDest() != null){
                                    JOptionPane.showMessageDialog(null, "Iniciando a execução do Batimento...");
                                    screen.setLog("Iniciando a execução do Batimento...");
                                    try {
                                        Thread.sleep(300);
                                    } catch (InterruptedException ex) {
                                        Logger.getLogger(BatimentoScreen.class.getName()).log(Level.SEVERE, null, ex);
                                    }

                                    // Set Variables in batControl
                                    setConfName(screen.getCbbProj());
                                    setFirstAmb(screen.getCbbAmbOri());
                                    setFirstRep(screen.getCbbRepOri());
                                    setSecAmb(screen.getCbbAmbDest());
                                    setSecRep(screen.getCbbRepDest());
                                    setDateSeachSpec(screen.getTxtDateSearchSpec());
                                    setNumThreads(getMaxThreads());

                                    // Execute the comparison between siebel repository's
                                    try{
                                        // Update the Master Table
                                        screen.setLog("Atualizando a Tabela Master...");
                                        if("sucesso".equals(runPLCompareAmbMaster(getFirstRep(), getSecRep(), getFirstAmb(), getSecAmb(), getConfName()))){
                                            screen.setLog("Tabela master atualizada com sucesso...");
                                            // Call function createThreads
                                            try{
                                                screen.setLog("Executando a comparação dos ambientes... Por favor, aguarde!");
                                                if(createThreads()){
                                                    screen.setLog("Batimento Finalizado com sucesso!...");
                                                } else {
                                                    screen.setLog("Erro ao comparar ambientes...");
                                                    JOptionPane.showMessageDialog(null, "Erro ao comparar ambientes...");
                                                }                    
                                            } catch(Exception ex){
                                                JOptionPane.showMessageDialog(null, "ERRO: Não foi possível comparar os ambientes!");
                                            }
                                        } else {
                                            screen.setLog("Erro ao atualizar a tabela master...");
                                            JOptionPane.showMessageDialog(null, "Erro ao atualizar a tabela master...");
                                        }
                                        JOptionPane.showMessageDialog(null, "Batimento Finalizado com sucesso!...");
                                    } catch(Exception ex){
                                        JOptionPane.showMessageDialog(null, "ERRO: " + ex);
                                    }                                    

                                    // Save comparison result on a csv file
                                    // The Save Button invokes the Listener Class "saveResult"
                                    screen.clickSave();

                                    // Show the compare result on a table in the screen
                                    showCompareResult();

                                    // Enable the Button Save
                                    screen.setBtnSaveEnabled(true);

                                } else {
                                    JOptionPane.showMessageDialog(null, "ATENÇÃO! Favor preencher o campo \"Repositório\" em \"Ambiente de Destino\" corretamente!","Erro",JOptionPane.WARNING_MESSAGE);
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "ATENÇÃO! Favor preencher o campo \"Ambiente\" em \"Ambiente de Destino\" corretamente!","Erro",JOptionPane.WARNING_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "ATENÇÃO! Favor preencher o campo \"Repositório\" em \"Ambiente de Origem\" corretamente!","Erro",JOptionPane.WARNING_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "ATENÇÃO! Favor preencher o campo \"Ambiente\" em \"Ambiente de Origem\" corretamente!","Erro",JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "ATENÇÃO! Favor preencher o campo \"Data a partir\" corretamente!","Erro",JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "ATENÇÃO! Favor preencher o campo \"Projeto\" corretamente!","Erro",JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    
    // Function to Save the Comparizon Result
    private class saveResult implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            screen.setLog("Gerando Relatório...");
            
            String[] options = {"Excel", "CSV"};
            
            int x = JOptionPane.showOptionDialog(null, "Escolha o formato de planilha que você deseja salvar o resultado:", "Formas de Planilhas", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            
            if(x == 0){
                saveOnXLS();
            } else {
                saveOnCSV();
            }
        }
    }
    
    // This Class save the "Batimento" result on Excel File
    private void saveOnXLS(){
        ArrayList<RelatorioBatimentoController> result = getRelatorioBatimento();
        try{
            //Abre caixa de dialogo para selecionar caminho do arquivo que será gerado.
            JFileChooser fc = new JFileChooser();
            fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            fc.setDialogTitle("Selecione o caminho desejado");
            //fc.setCurrentDirectory("");
            fc.showOpenDialog(screen);

            String path = fc.getSelectedFile().toString() + "\\RelatorioBatimento(" + getFirstAmb() + "-" + getSecAmb() + ").xls";

            WritableWorkbook workbook = Workbook.createWorkbook(new File(path));


            WritableSheet sheet = workbook.createSheet("Resultado", 0);

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

            for (int i = 0; i < result.size(); i++){
                sheet.addCell(new Label(0, i + 1, result.get(i).getStatus()));
                sheet.addCell(new Label(1, i + 1, result.get(i).getType()));
                sheet.addCell(new Label(2, i + 1, result.get(i).getGroupObject()));
                sheet.addCell(new Label(3, i + 1, result.get(i).getDescription()));
                sheet.addCell(new Label(4, i + 1, result.get(i).getParN0()));
                sheet.addCell(new Label(5, i + 1, result.get(i).getParN1()));
                sheet.addCell(new Label(6, i + 1, result.get(i).getParN2()));
                sheet.addCell(new Label(7, i + 1, result.get(i).getParN3()));
                sheet.addCell(new Label(8, i + 1, result.get(i).getObjectName()));
                sheet.addCell(new Label(9, i + 1, result.get(i).getColumnName()));
                sheet.addCell(new Label(10, i + 1, result.get(i).getValOrig()));
                sheet.addCell(new Label(11, i + 1, result.get(i).getValDest()));
                sheet.addCell(new Label(12, i + 1, result.get(i).getLastUpdOrig()));
                sheet.addCell(new Label(13, i + 1, result.get(i).getLastUpdDest()));
                sheet.addCell(new Label(14, i + 1, result.get(i).getLastUpdByOrig()));
                sheet.addCell(new Label(15, i + 1, result.get(i).getLastUpdByDest()));
            }
            
            workbook.write();
            workbook.close();
            JOptionPane.showMessageDialog(null, "Relatório gerado com sucesso!\nCaminho: " + path);
        } catch (HeadlessException | IOException | WriteException e){
            JOptionPane.showMessageDialog(null, "Erro ao tentar gerar relatório!\nErro: " + e);
        }

    }
    
    // This Class save the "Batimento" result on CSV File
    private void saveOnCSV(){
        ArrayList<RelatorioBatimentoController> result = getRelatorioBatimento();
        try{
            //Abre caixa de dialogo para selecionar caminho do arquivo que será gerado.
            JFileChooser fc = new JFileChooser();
            fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            fc.setDialogTitle("Selecione o caminho desejado");
            //fc.setCurrentDirectory("");
            fc.showOpenDialog(screen);

            String path = fc.getSelectedFile().toString() + "\\RelatorioBatimento(" + getFirstAmb() + "-" + getSecAmb() + ").csv";
            String header = "STATUS;TIPO;GRUPO_OBJETO;NOME;PAR_N1;PAR_N2;PAR_N3;ORDEM;DESCRICAO;NOME_OBJETO_CAMPO;COLUNA_TABELA;VALOR_ORIGEM;VALOR_DESTINO;ULT_ATUAL_ORIGEM;ULT_ATUAL_DEST;ATUAL_POR_ORIGEM;ATUAL_POR_DETINO;ID_TAB_PAI;ID\n";
            if (!path.isEmpty()) {            
                BufferedWriter buff = new BufferedWriter(new FileWriter(path));
                buff.append(header);

                for (int i = 0; i < result.size(); i++) {
                    buff.append(result.get(i).getStatus() + ";");
                    buff.append(result.get(i).getType() + ";");
                    buff.append(result.get(i).getGroupObject() + ";");
                    buff.append(result.get(i).getParN0() + ";");
                    buff.append(result.get(i).getParN1() + ";");
                    buff.append(result.get(i).getParN2() + ";");
                    buff.append(result.get(i).getParN3() + ";");
                    buff.append(result.get(i).getOrderCol() + ";");
                    buff.append(result.get(i).getDescription() + ";");
                    buff.append(result.get(i).getObjectName() + ";");
                    buff.append(result.get(i).getColumnName() + ";");
                    buff.append(result.get(i).getValOrig() + ";");
                    buff.append(result.get(i).getValDest() + ";");
                    buff.append(result.get(i).getLastUpdOrig() + ";");
                    buff.append(result.get(i).getLastUpdDest() + ";");
                    buff.append(result.get(i).getLastUpdByOrig() + ";");
                    buff.append(result.get(i).getLastUpdByDest() + ";");
                    buff.append(result.get(i).getCtrlLogComRepId() + ";");
                    buff.append(result.get(i).getId() + "\n");
                }
                buff.close();
                JOptionPane.showMessageDialog(null, "Relatório gerado com sucess!\nCaminho: " + path);
            }            
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao tentar gerar relatório!\nErro: " + e);
        }
    }
    
    // Function to select the Projects
    private class projectSelected implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            if(screen.isCbbProjEnabled()){
                screen.clearCbbAmbOri();
                screen.clearCbbAmbDest();

                screen.insertCbbAmbOri("Selecione...");
                screen.insertCbbAmbDest("Selecione...");
                
                // Call the Select Function on DataController to get the list of the Databases used
                selectFunction("SELECT HOST FROM ALL_DB_LINKS WHERE HOST LIKE '%SBL%' ORDER BY HOST ASC", "DB_LINKS");
                for(int i = 0; i < resultQuery.size(); i++){
                    screen.insertCbbAmbOri(resultQuery.get(i));
                    screen.insertCbbAmbDest(resultQuery.get(i));
                }
                screen.setCbbAmbOriEnabled(true);
            }
        }
        
    }
        
    private class AmbOriSelected implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            if(screen.isCbbAmbOriEnabled()){
                if(screen.getCbbAmbOriSize() > 0){
                        if(screen.getCbbAmbOri() != null){
                            if(!"".equals(screen.getCbbAmbOri())){
                                if(!"Selecione...".equals(screen.getCbbAmbOri())){
                                    screen.clearCbbRepOri();
                                    screen.insertCbbRepOri("Selecione...");
                                    selectRepository("SELECT NAME FROM SIEBEL.S_REPOSITORY@" +  screen.getCbbAmbOri());
                                    for(int i = 0; i < resultQuery.size(); i++){
                                        screen.insertCbbRepOri(resultQuery.get(i));
                                    }
                                    screen.setCbbRepOriEnabled(true);
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "ATENÇÃO! O Campo \"Ambiente de Origem\" consta como VAZIO!\nFavor selecionar um ambiente válido.","Erro",JOptionPane.WARNING_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "ATENÇÃO! O Campo \"Ambiente de Origem\" consta como NULO!\nFavor selecionar um ambiente válido.","Erro",JOptionPane.WARNING_MESSAGE);
                        }
                } else {
                    System.out.println("Quantidade de itens: " + screen.getCbbAmbOriSize());
                }
            }
        }
        
    }
    
    private class AmbDestSelected implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            if(screen.isCbbAmbDestEnabled()){
                if(screen.getCbbAmbDestSize() > 0){
                        if(screen.getCbbAmbDest() != null){
                            if(!"".equals(screen.getCbbAmbDest())){
                                if(!"Selecione...".equals(screen.getCbbAmbDest())){
                                    screen.clearCbbRepDest();
                                    screen.insertCbbRepDest("Selecione...");
                                    selectRepository("SELECT NAME FROM SIEBEL.S_REPOSITORY@" +  screen.getCbbAmbDest());
                                    for(int i = 0; i < resultQuery.size(); i++){
                                        screen.insertCbbRepDest(resultQuery.get(i));
                                    }
                                    screen.setCbbRepDestEnabled(true);
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "ATENÇÃO! O Campo \"Ambiente de Origem\" consta como VAZIO!\nFavor selecionar um ambiente válido.","Erro",JOptionPane.WARNING_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "ATENÇÃO! O Campo \"Ambiente de Origem\" consta como NULO!\nFavor selecionar um ambiente válido.","Erro",JOptionPane.WARNING_MESSAGE);
                        }
                } else {
                    System.out.println("Quantidade de itens: " + screen.getCbbAmbDestSize());
                }
            }
        }
        
    }
    
    public class AboutSystem implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            about = new AboutSystemScreen();
            about.openScreen(getDbUser(), getDbName());
        }
    }
    
    public class winListenner implements ComponentListener {

        @Override
        public void componentResized(ComponentEvent e) { }

        @Override
        public void componentMoved(ComponentEvent e) { }

        @Override
        public void componentShown(ComponentEvent e) { }

        @Override
        public void componentHidden(ComponentEvent e) {
            setBatScreenVisible(false);
        }
        
    }
    
    // This Function gets the database result and return them into a ArrayList
    public ArrayList<RelatorioBatimentoController> getRelatorioBatimento(){
        ArrayList<RelatorioBatimentoController> resultQuery = new ArrayList<>();

        try{
            openConnection("Gerando Relatório...");
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(instructions.getQueryRelatorioBatimento(getDbOwner()));

            while(rs.next()){
                RelatorioBatimentoController rel = new RelatorioBatimentoController();

                rel.setStatus(rs.getString("STATUS"));
                rel.setType(rs.getString("TYPE"));
                rel.setGroupObject(rs.getString("GROUP_OBJECT"));
                rel.setOrderCol(rs.getString("ORDER_COL"));
                rel.setDescription(rs.getString("DESCRIPTION"));
                rel.setParN0(rs.getString("PAR_N0"));
                rel.setParN1(rs.getString("PAR_N1"));
                rel.setParN2(rs.getString("PAR_N2"));
                rel.setParN3(rs.getString("PAR_N3"));
                rel.setObjectName(rs.getString("OBJECT_NAME"));
                rel.setColumnName(rs.getString("COLUMN_NAME"));
                rel.setValOrig(rs.getString("VAL_ORIG"));
                rel.setValDest(rs.getString("VAL_DEST"));
                rel.setLastUpdOrig(rs.getString("LAST_UPD_ORIG"));                
                rel.setLastUpdDest(rs.getString("LAST_UPD_DEST"));
                rel.setCtrlLogComRepId(rs.getString("CTRL_LOG_COMP_REP_ID"));
                rel.setLastUpdByOrig(rs.getString("LAST_UPD_BY_ORIG"));
                rel.setLastUpdByDest(rs.getString("LAST_UPD_BY_DEST"));
                rel.setId(rs.getString("ID"));

                resultQuery.add(rel);        
            }
            rs.close();
        } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro de leitura no Banco de Dados!\nMensagem: " + e,"Erro",JOptionPane.ERROR_MESSAGE);
        } finally{
            closeConnection("Relatório gerado com sucesso!");
        }
        return resultQuery;
    }
    
    // SubClass
    public class RelatorioBatimentoController {
        //Variables
        private String _status;
        private String _type;
        private String _groupObject;    
        private String _orderCol;
        private String _description;
        private String _parN0;
        private String _parN1;
        private String _parN2;
        private String _parN3;
        private String _objectName;
        private String _columnName;
        private String _valOrig;
        private String _valDest;
        private String _lastUpdOrig;
        private String _lastUpdDest;
        private String _lastUpdByOrig;
        private String _ctrlLogComRepId;
        private String _lastUpdByDest;
        private String _id;    

        //Constructor
        public RelatorioBatimentoController(){
            this._status = null;
            this._type = null;
            this._groupObject = null;    
            this._orderCol = null;
            this._description = null;
            this._parN0 = null;
            this._parN1 = null;
            this._parN2 = null;
            this._parN3 = null;
            this._objectName = null;
            this._columnName = null;
            this._valOrig = null;
            this._valDest = null;
            this._lastUpdOrig = null;
            this._lastUpdDest = null;
            this._lastUpdByOrig = null;
            this._ctrlLogComRepId = null;
            this._lastUpdByDest = null;
            this._id = null; 
        }

        // Getters and Setters
        public String getStatus() { return _status; }
        public void setStatus(String _status) { this._status = _status; }

        public String getType() { return _type; }
        public void setType(String _type) { this._type = _type; }

        public String getGroupObject() { return _groupObject; }
        public void setGroupObject(String _groupObject) { this._groupObject = _groupObject; }

        public String getOrderCol() { return _orderCol; }
        public void setOrderCol(String _orderCol) { this._orderCol = _orderCol; }

        public String getDescription() { return _description; }
        public void setDescription(String _description) { this._description = _description; }

        public String getParN0() { return _parN0; }
        public void setParN0(String _parN0) { this._parN0 = _parN0; }

        public String getParN1() { return _parN1; }
        public void setParN1(String _parN1) { this._parN1 = _parN1; }

        public String getParN2() { return _parN2; }
        public void setParN2(String _parN2) { this._parN2 = _parN2; }

        public String getParN3() { return _parN3; }
        public void setParN3(String _parN3) { this._parN3 = _parN3; }

        public String getObjectName() { return _objectName; }
        public void setObjectName(String _objectName) { this._objectName = _objectName; } 

        public String getColumnName() { return _columnName; }
        public void setColumnName(String _columnName) { this._columnName = _columnName; }

        public String getValOrig() { return _valOrig; }
        public void setValOrig(String _valOrig) { this._valOrig = _valOrig; }

        public String getValDest() { return _valDest; }
        public void setValDest(String _valDest) { this._valDest = _valDest; }

        public String getLastUpdOrig() { return _lastUpdOrig; }
        public void setLastUpdOrig(String _lastUpdOrig) { this._lastUpdOrig = _lastUpdOrig; }

        public String getLastUpdDest() { return _lastUpdDest; }
        public void setLastUpdDest(String _lastUpdDest) { this._lastUpdDest = _lastUpdDest; }

        public String getCtrlLogComRepId() { return _ctrlLogComRepId; }
        public void setCtrlLogComRepId(String _ctrlLogComRepId) { this._ctrlLogComRepId = _ctrlLogComRepId; }

        public String getLastUpdByOrig() { return _lastUpdByOrig; }
        public void setLastUpdByOrig(String _lastUpdByOrig) { this._lastUpdByOrig = _lastUpdByOrig; }

        public String getLastUpdByDest() { return _lastUpdByDest; }
        public void setLastUpdByDest(String _lastUpdByDest) { this._lastUpdByDest = _lastUpdByDest; }

        public String getId() { return _id; }
        public void setId(String _id) { this._id = _id; }

    }
}