/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseModule;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
//import main.Controller;

/**
 *
 * @author mcabralr
 */
public class DbSettingsController {
    File file;
    DbSettingsScreen dbSetScreen;
    
    // Database Variables
    private Connection conn = null;
    private Statement statement;
    private String dbURL;
    private String dbUser; // Database user connected
    private String dbPassword; // Database user password connected
    private String dbDriver;
    
    private boolean firstSettings = false;
    private boolean firstSettingsOK = false;

    public DbSettingsController(boolean firstSettings) {
        this.firstSettings = firstSettings;
        if(firstSettings){
            dbSetScreen = new DbSettingsScreen();
            dbSetScreen.setListenerBtnTestDB(new testDbConnection());
            dbSetScreen.setListenerBtnSaveDBParam(new saveDbParameters());
        }
        
    }
    
    // Database Setters and Getters
    public String getDbUser() { return dbUser; }
    public void setDbUser(String dbUser) { this.dbUser = dbUser; }

    public String getDbPassword() { return dbPassword; }
    public void setDbPassword(String dbPassword) { this.dbPassword = dbPassword; }

    public String getDbURL() { return dbURL; }
    public void setDbURL(String dbURL) { this.dbURL = dbURL; }

    public String getDbDriver() { return dbDriver; }
    public void setDbDriver(String dbDriver) { this.dbDriver = dbDriver; }
    
    public boolean isFirstSettingsOK() { return firstSettingsOK; }
    
    public boolean openConnection(){
        try {
            if(this.firstSettings){
                Class.forName(dbSetScreen.gettxtDriver());
            } else {
                Class.forName(this.getDbDriver());
            }
            System.out.println("Oracle JDBC Driver Registered!");
        } catch (ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, "Erro: O Driver do ODBC está incorreto ou mal formulado. Favor Tente novamente!\nMensagem: " + e, "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            conn = DriverManager.getConnection(getDbURL(), getDbUser(), getDbPassword());
            System.out.println("Connected Successfuly!");
        } catch(SQLException e) {
            if("java.sql.SQLRecoverableException: IO Error: The Network Adapter could not establish the connection".equals(String.valueOf(e))){
                JOptionPane.showMessageDialog(null, "Erro ao tentar realizar conexão com o Banco de dados. Verifique se o listener está ativo.","Erro",JOptionPane.ERROR_MESSAGE);
            } else if("ORA-12505: TNS: listener does not currently know of SID given in connect descriptor tips".equals(String.valueOf(e))) {
                JOptionPane.showMessageDialog(null, "O Listener não identificou o SID utilizado no descritor de conexão.","Erro",JOptionPane.ERROR_MESSAGE);
            } else if("java.sql.SQLRecoverableException: Erro de ES: The Network Adapter could not establish the connection".equals(String.valueOf(e))){
                JOptionPane.showMessageDialog(null, "Erro ao tentar realizar conexão com o Banco de dados. Verifique se o listener está ativo.","Erro",JOptionPane.ERROR_MESSAGE);
            } else if("ORA-12505, TNS:listener does not currently know of SID given in connect descriptor".equals(String.valueOf(e))) {
                JOptionPane.showMessageDialog(null, "O Listener não identificou o SID utilizado no descritor de conexão.","Erro",JOptionPane.ERROR_MESSAGE);
            } else if("java.sql.SQLException: ORA-01017: invalid username/password; logon denied".equals(String.valueOf(e))){
                JOptionPane.showMessageDialog(null, "Nome de usuário/senha incorreto. Tente novamente.","Erro",JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco de dados!\n" + e,"Erro",JOptionPane.ERROR_MESSAGE);
            }
            return false;
        }
        return true;
    }
    
    public boolean closeConnection(){
        try {
            if(this.firstSettings){
                Class.forName(dbSetScreen.gettxtDriver());
            } else {
                Class.forName(this.getDbDriver());
            }
            System.out.println("Oracle JDBC Driver Registered!");
        } catch (ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, "Erro: O Driver do ODBC está incorreto ou mal formulado. Favor Tente novamente!\nMensagem: " + e,"Erro",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            conn.close();
            System.out.println("Disconnected Successfuly!");
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro: Não foi possível desconectar do Banco de Dados. Favor Verificar se todos os parâmentros estão corretos!\nMensagem: " + e,"Erro",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
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
                                            setDbURL(dbSetScreen.gettxtURL() + dbSetScreen.gettxtLocal() + ":" + dbSetScreen.gettxtPort() + ":" + dbSetScreen.gettxtDBName());
                                        } else if("Service Name".equals(dbSetScreen.getCbbDriverName())){
                                            setDbURL(dbSetScreen.gettxtURL() + "//" + dbSetScreen.gettxtLocal() + ":" + dbSetScreen.gettxtPort() + "/" + dbSetScreen.gettxtDBName());
                                        } else {
                                            setDbURL(dbSetScreen.gettxtURL() + dbSetScreen.gettxtDBName());
                                        }
                                        setDbUser(dbSetScreen.gettxtUser());
                                        setDbPassword(dbSetScreen.gettxtPassword());
                                        if(openConnection()){
                                            if(closeConnection()){
                                                return true;
                                            } else {
                                                return true;
                                            }
                                        } else {
                                            return false;
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Todos os campos são de preenchimento obrigatório. Favor preencher os campos vazios!","Erro",JOptionPane.ERROR_MESSAGE);
                                        return false;
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "Todos os campos são de preenchimento obrigatório. Favor preencher os campos vazios!","Erro",JOptionPane.ERROR_MESSAGE);
                                    return false;
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Todos os campos são de preenchimento obrigatório. Favor preencher os campos vazios!","Erro",JOptionPane.ERROR_MESSAGE);
                                return false;
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Todos os campos são de preenchimento obrigatório. Favor preencher os campos vazios!","Erro",JOptionPane.ERROR_MESSAGE);
                            return false;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Todos os campos são de preenchimento obrigatório. Favor preencher os campos vazios!","Erro",JOptionPane.ERROR_MESSAGE);
                        return false;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Todos os campos são de preenchimento obrigatório. Favor preencher os campos vazios!","Erro",JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Todos os campos são de preenchimento obrigatório. Favor preencher os campos vazios!","Erro",JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Todos os campos são de preenchimento obrigatório. Favor preencher os campos vazios!","Erro",JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    private boolean saveDbParameters(){
        try{
            //Abre caixa de dialogo para selecionar caminho do arquivo que será gerado.
            JFileChooser fc = new JFileChooser();
            fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

            file = new File(System.getProperty("user.home") +"\\XMLConverter\\Settings");
            if(!file.exists()){
                file.mkdirs();
            }
            
            String path = System.getProperty("user.home") +"\\XMLConverter\\Settings\\db_conf.conf";
            String header = "TIPO_DRIVER;DRIVER;URL;LOCAL;PORTA;NOME_BANCO;OWNER_BANCO;USUARIO;SENHA\n";
            if (!path.isEmpty()) {            
                BufferedWriter buff = new BufferedWriter(new FileWriter(path));
                buff.append(header);
                buff.append(dbSetScreen.getCbbDriverName() + ";");
                buff.append(dbSetScreen.gettxtDriver() + ";");
                buff.append(dbSetScreen.gettxtURL() + ";");
                buff.append(dbSetScreen.gettxtLocal() + ";");
                buff.append(dbSetScreen.gettxtPort() + ";");
                buff.append(dbSetScreen.gettxtDBName() + ";");
                buff.append(dbSetScreen.gettxtOwner() + ";");
                buff.append(this.getDbUser() + ";");
                buff.append(this.getDbPassword()+ "\n");
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
