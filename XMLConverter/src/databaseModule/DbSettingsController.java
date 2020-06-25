/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseModule;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    DbSettingsScreen genScreen;
    //Controller control;
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
            genScreen = new DbSettingsScreen();
            genScreen.setListenerBtnTestDB(new testDbConnection());
            genScreen.setListenerBtnSaveDBParam(new saveDbParameters());
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
                Class.forName(genScreen.gettxtDriver());
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
            if("java.sql.SQLRecoverableException: Erro de ES: The Network Adapter could not establish the connection".equals(e)){
                JOptionPane.showMessageDialog(null, "Erro: Não foi possível conectar com o Banco de Dados. Favor Verificar se todos os parâmentros estão corretos!\nMensagem: " + e,"Erro",JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "ERRO: Nome de usuário/senha incorreto. Tente novamente.","Erro",JOptionPane.ERROR_MESSAGE);
            }            
            return false;
        }
        return true;
    }
    
    public boolean closeConnection(){
        try {
            if(this.firstSettings){
                Class.forName(genScreen.gettxtDriver());
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
        if(!"".equals(genScreen.gettxtDriver()) && genScreen.gettxtDriver() != null){
            if(!"".equals(genScreen.gettxtURL()) && genScreen.gettxtURL() != null){
                if(!"".equals(genScreen.gettxtLocal()) && genScreen.gettxtLocal() != null){
                    if(!"".equals(genScreen.gettxtPort()) && genScreen.gettxtPort() != null){
                        if(!"".equals(genScreen.gettxtDBName()) && genScreen.gettxtDBName() != null){
                            if(!"".equals(genScreen.gettxtOwner()) && genScreen.gettxtOwner() != null){
                                setDbURL(genScreen.gettxtURL() + genScreen.gettxtLocal() + ":" + genScreen.gettxtPort() + ":" + genScreen.gettxtDBName());
                                setDbUser(JOptionPane.showInputDialog("Digite o Usuário do Banco de Dados:"));
                                setDbPassword(JOptionPane.showInputDialog("Digite a Senha do Banco de Dados:"));
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
            String header = "DRIVER;URL;LOCAL;PORTA;NOME_BANCO;OWNER_BANCO;USUARIO;SENHA\n";
            if (!path.isEmpty()) {            
                BufferedWriter buff = new BufferedWriter(new FileWriter(path));
                buff.append(header);
                buff.append(genScreen.gettxtDriver() + ";");
                buff.append(genScreen.gettxtURL() + ";");
                buff.append(genScreen.gettxtLocal() + ";");
                buff.append(genScreen.gettxtPort() + ";");
                buff.append(genScreen.gettxtDBName() + ";");
                buff.append(genScreen.gettxtOwner() + ";");
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
                genScreen.setbtnSaveDBParamEnabled(true);
            } else {
                genScreen.setbtnSaveDBParamEnabled(false);
            }
        }
        
    }
    
    private class saveDbParameters implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if(saveDbParameters()){
                genScreen.setbtnSaveDBParamEnabled(false);
                genScreen.dispose();
                if(firstSettings){
                    firstSettingsOK = true;
                    //control = new Controller();
                    //control.openScreen("Login");
                }
            } else {
                genScreen.setbtnSaveDBParamEnabled(true);
            }
        }
        
    }
}
