/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package settingsModule;

import databaseModule.DataController;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
//import main.Controller;

/**
 *
 * @author mcabralr
 */
public class DbSettingsController extends DataController {
    File file;
    DbSettingsScreen dbSetScreen;
    
    // Database Variables
    private final String confFile = System.getProperty("user.home") +"\\SalesPoint\\Settings\\db_conf.conf";
    private final String SplitBy = ";";
    
    private boolean firstSettings = false;
    private boolean firstSettingsOK = false;

    public DbSettingsController(boolean firstSettings) throws InterruptedException {
        this.firstSettings = firstSettings;
        if(firstSettings){
            dbSetScreen = new DbSettingsScreen();
            dbSetScreen.setListenerBtnTestDB(new testDbConnection());
            dbSetScreen.setListenerBtnSaveDBParam(new saveDbParameters());
        }
    }
    
    public boolean isFirstSettingsOK() { return firstSettingsOK; }
    
    public void screenOnLoad() throws IOException{
        String driverType = "";
        System.out.println("Carregando Parametros do Banco de Dados");
        File file = new File(confFile);
        if(file.exists()) {
            try {
                int i = 0;
                BufferedReader br = new BufferedReader(new FileReader(confFile));
                String line;
                while((line = br.readLine()) != null){
                    if(i > 0){
                        StringTokenizer st = new StringTokenizer(line, SplitBy);
                        driverType = st.nextToken();
                        if("SID".equals(driverType)){
                            dbSetScreen.setCbbDriverName(0);
                        } else if("Service Name".equals(driverType)){
                            dbSetScreen.setCbbDriverName(1);
                        } else {
                            dbSetScreen.setCbbDriverName(2);
                        }
                        
                        dbSetScreen.settxtDriver(st.nextToken());
                        dbSetScreen.settxtURL(st.nextToken());
                        dbSetScreen.settxtLocal(st.nextToken());
                        dbSetScreen.settxtPort(st.nextToken());
                        dbSetScreen.settxtDBName(st.nextToken());
                        dbSetScreen.settxtOwner(st.nextToken());
                    }
                    i++;
                }

                System.out.println("Parametros OK");
                
            } catch (Exception ex) {
                System.out.println("Erro ao ler arquivo: " + ex);
            }
        }
    }
    
    private boolean testDbConnection(){
        if(!"".equals(dbSetScreen.gettxtDriver()) && dbSetScreen.gettxtDriver() != null){
            if(!"".equals(dbSetScreen.gettxtURL()) && dbSetScreen.gettxtURL() != null){
                if(!"".equals(dbSetScreen.gettxtLocal()) && dbSetScreen.gettxtLocal() != null){
                    if(!"".equals(dbSetScreen.gettxtPort()) && dbSetScreen.gettxtPort() != null){
                        if(!"".equals(dbSetScreen.gettxtDBName()) && dbSetScreen.gettxtDBName() != null){
                            if(!"".equals(dbSetScreen.gettxtUser()) && dbSetScreen.gettxtUser() != null){
                                if(!"".equals(dbSetScreen.gettxtPassword()) && dbSetScreen.gettxtPassword() != null){
                                    if(!"".equals(dbSetScreen.gettxtOwner()) && dbSetScreen.gettxtOwner() != null){
                                        if("SID".equals(dbSetScreen.getCbbDriverName())){
                                            super.setDbURL(dbSetScreen.gettxtURL());
                                        } else if("Service Name".equals(dbSetScreen.getCbbDriverName())){
                                            super.setDbURL(dbSetScreen.gettxtURL());
                                        } else {
                                            super.setDbURL(dbSetScreen.gettxtURL() + dbSetScreen.gettxtDBName());
                                        }
                                        super.setDbDriverName(dbSetScreen.getCbbDriverName());
                                        super.setDbDriver(dbSetScreen.gettxtDriver());
                                        super.setDbName(dbSetScreen.gettxtDBName());
                                        super.setDbOwner(dbSetScreen.gettxtOwner());
                                        super.setDbLocal(dbSetScreen.gettxtLocal());
                                        super.setDbPort(dbSetScreen.gettxtPort());
                                        super.setDbUser(dbSetScreen.gettxtUser());
                                        super.setDbPassword(dbSetScreen.gettxtPassword());
                                        
                                        try{
                                            String result = super.openConnection("Realizando Login");
                                            if("true".equals(result)){
                                                super.closeConnection("");
                                                return true;
                                            }
                                        } catch(Exception e){
                                            JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco de dados!\n" + e,"Erro",JOptionPane.ERROR_MESSAGE);
                                        }
                                        
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Todos os campos são de preenchimento obrigatório. Favor preencher os campos vazios!","Erro",JOptionPane.ERROR_MESSAGE);
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "Todos os campos são de preenchimento obrigatório. Favor preencher os campos vazios!","Erro",JOptionPane.ERROR_MESSAGE);
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Todos os campos são de preenchimento obrigatório. Favor preencher os campos vazios!","Erro",JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Todos os campos são de preenchimento obrigatório. Favor preencher os campos vazios!","Erro",JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Todos os campos são de preenchimento obrigatório. Favor preencher os campos vazios!","Erro",JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Todos os campos são de preenchimento obrigatório. Favor preencher os campos vazios!","Erro",JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Todos os campos são de preenchimento obrigatório. Favor preencher os campos vazios!","Erro",JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Todos os campos são de preenchimento obrigatório. Favor preencher os campos vazios!","Erro",JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    private boolean saveDbParameters(){
        try{
            //Abre caixa de dialogo para selecionar caminho do arquivo que será gerado.
            JFileChooser fc = new JFileChooser();
            fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

            file = new File(System.getProperty("user.home") +"\\SalesPoint\\Settings");
            if(!file.exists()){
                file.mkdirs();
            }
            
            String path = System.getProperty("user.home") +"\\SalesPoint\\Settings\\db_conf.conf";
            String header = "TIPO_DRIVER;DRIVER;URL;LOCAL;PORTA;NOME_BANCO;OWNER_BANCO\n";
            if (!path.isEmpty()) {            
                BufferedWriter buff = new BufferedWriter(new FileWriter(path));
                buff.append(header);
                buff.append(dbSetScreen.getCbbDriverName() + ";");
                buff.append(dbSetScreen.gettxtDriver() + ";");
                buff.append(dbSetScreen.gettxtURL() + ";");
                buff.append(dbSetScreen.gettxtLocal() + ";");
                buff.append(dbSetScreen.gettxtPort() + ";");
                buff.append(dbSetScreen.gettxtDBName() + ";");
                buff.append(dbSetScreen.gettxtOwner() + "\n");
                buff.close();
                JOptionPane.showMessageDialog(null, "Parâmetros salvos com Sucesso!");
            }
            return true;
        } catch (HeadlessException | IOException e){
            JOptionPane.showMessageDialog(null, "Erro ao tentar salvar os Parâmetros!\nErro: " + e);
            return false;
        }
    }
    
    private class testDbConnection implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if(testDbConnection()){
                JOptionPane.showMessageDialog(null, "Conexão testada com Sucesso!\n", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
                dbSetScreen.setbtnSaveDBParamEnabled(true);
            } else {
                dbSetScreen.setbtnSaveDBParamEnabled(false);
            }
        }
        
    }
    
    private class saveDbParameters implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if(saveDbParameters()){
                dbSetScreen.setbtnSaveDBParamEnabled(false);
                dbSetScreen.dispose();
                if(firstSettings){
                    firstSettingsOK = true;
                    //control = new Controller();
                    //control.openScreen("Login");
                }
            } else {
                dbSetScreen.setbtnSaveDBParamEnabled(true);
            }
        }        
    }
    
    private class chooseConnectionType implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent ie) {
            if("SID".equals(dbSetScreen.getCbbDriverName())){
                dbSetScreen.settxtDriver("oracle.jdbc.OracleDriver");
                dbSetScreen.settxtURL("jdbc:oracle:thin:@");
                dbSetScreen.settxtLocal("localhost");
                dbSetScreen.settxtPort("1521");
                dbSetScreen.settxtDBName("SIEBEL");
                dbSetScreen.settxtOwner("SIEBEL");
            } else if("Service Name".equals(dbSetScreen.getCbbDriverName())){
                dbSetScreen.settxtDriver("oracle.jdbc.OracleDriver");
                dbSetScreen.settxtURL("jdbc:oracle:thin:@");
                dbSetScreen.settxtLocal("localhost");
                dbSetScreen.settxtPort("1521");
                dbSetScreen.settxtDBName("SIEBEL");
                dbSetScreen.settxtOwner("SIEBEL");
            } else {
                dbSetScreen.settxtDriver("oracle.jdbc.OracleDriver");
                dbSetScreen.settxtURL("jdbc:oracle:thin:@");
                dbSetScreen.settxtLocal("localhost");
                dbSetScreen.settxtPort("1521");
                dbSetScreen.settxtDBName("SIEBEL");
                dbSetScreen.settxtOwner("SIEBEL");
            }
        }
        
    }
}
