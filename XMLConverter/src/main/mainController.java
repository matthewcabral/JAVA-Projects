/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import LOVConverterModule.LOV_XML_Controller;
import SystemSettingsModule.AboutSystemScreen;
import databaseModule.DbConSettingsController;
import databaseModule.DBParametersTest;
import databaseModule.DataController;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author Matheus Cabral Rosa
 */
public class mainController extends DataController{
    // Classes Instances
    mainScreen mainScreen;
    LOV_XML_Controller lovControl;
    DBParametersTest dbParamTest;
    AboutSystemScreen about;
    DbConSettingsController genSettings;
    
    
    private boolean mainScreenVisible = false;
    private boolean settingScreenVisible = false;
    
    // Constructor
    public mainController(){
        //dbParamTest = new DBParametersTest();
        //this.openScreen("Principal");
    }

    // Functions to control the screens visibility
    public boolean isMainScreenVisible() { return mainScreenVisible; }
    public boolean isSettingsScreenVisible() { return settingScreenVisible; }
    
    public void setMainScreenVisible(boolean mainScreenVisible) { this.mainScreenVisible = mainScreenVisible; }
    public void setSettingsScreenVisible(boolean settingScreenVisible) { this.settingScreenVisible = settingScreenVisible; }

    // Function used to open Screens
    public void openScreen(String function){
        switch(function){
            case "Principal":
                mainScreen = new mainScreen();
                mainScreen.setExtendedState(MAXIMIZED_BOTH);
                mainScreen.setListenerAboutSystem(new AboutSystem());
                setScrVisible("Principal", true);
                mainScreen.setListenerOpenLOV_XML_ConverterScreen(new openLOV_XML_Converter());
                break;
            default:
                break;
        }
    }
    
    public void setScrVisible(String screen, boolean choice){
        switch(screen){
            case "Principal":
                setMainScreenVisible(choice);
                break;
            default:
                break;
        }
    }
        
    public boolean connectToSiebelDatabase(){
        boolean connected = false;
        
        try{
            if(dbParamTest.testParameters()){
                mainScreen.setLabelUser(dbParamTest.getDbUser());
                connected = true;
            } else {
                System.out.println("Passou aqui");
                connected = false;
            }
            
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            connected = false;
        }
        
        return connected;        
    }

    public class openLOV_XML_Converter implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            lovControl = new LOV_XML_Controller();
        }
        
    }
    
    public class UserLogin implements ActionListener {
        private String result;
        @Override
        public void actionPerformed(ActionEvent e) {
            if(isMainScreenVisible()){
                setDbUser(login.getUser());
                setDbPassword(login.getPassword());

                result = openConnection("Realizando Login");
                if("true".equals(result)){
                    login.setErrorArea("");
                    login.setVisible(false);
                    mainScreen.setVisible(true);
                    mainScreen.setLabelUser(getDbUser());
                    closeConnection("Login Realizado com sucesso!");
                } else {
                    if("java.sql.SQLRecoverableException: Erro de ES: The Network Adapter could not establish the connection".equals(result)){
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(mainController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        login.setErrorArea("Erro ao tentar realizar conexão com o Banco de dados. Verifique se o listener está ativo.");
                    } else if(result.contains("ORA-12505, TNS:listener does not currently know of SID given in connect descriptor")) {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(mainController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        login.setErrorArea("Erro ao tentar realizar conexão com o Banco de dados. Verifique se o listener está correto.");
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(mainController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        String[] options = {"Sim", "Não"};
                        int x = JOptionPane.showOptionDialog(null, "Deseja Realizar a configuração do Banco de Dados?", "Escolha", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                        if(x == 0){
                            login.dispose();
                            genSettings = new DbConSettingsController(true);
                        } else {
                            System.exit(0);
                        }
                    } else {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(mainController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        login.setErrorArea("Nome de usuário/senha incorreto. Tente novamente.");
                    }
                    
                }                
            } else {
                setDbUser(login.getUser());
                setDbPassword(login.getPassword());
                
                result = openConnection("Realizando Login");
                   
                if("true".equals(result)){
                    login.setErrorArea("");
                    login.setVisible(false);
                    openScreen("Principal");
                    mainScreen.setLabelUser(getDbUser());
                    closeConnection("Login Realizado com sucesso!");
                } else {
                    if("java.sql.SQLRecoverableException: Erro de ES: The Network Adapter could not establish the connection".equals(result)){
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(mainController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        login.setErrorArea("Erro ao tentar realizar conexão com o Banco de dados. Verifique se o listener está ativo.");
                    } else if(result.contains("ORA-12505, TNS:listener does not currently know of SID given in connect descriptor")) {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(mainController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        login.setErrorArea("Erro ao tentar realizar conexão com o Banco de dados. Verifique se o listener está correto.");
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(mainController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        String[] options = {"Sim", "Não"};
                        int x = JOptionPane.showOptionDialog(null, "Deseja Realizar a configuração do Banco de Dados?", "Escolha", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                        if(x == 0){
                            login.dispose();
                            genSettings = new DbConSettingsController(true);
                        } else {
                            System.exit(0);
                        }
                    } else {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(mainController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        login.setErrorArea("Nome de usuário/senha incorreto. Tente novamente.");
                    }
                    
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
    
    
}
