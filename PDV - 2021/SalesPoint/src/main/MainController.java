/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import databaseModule.DataController;
import databaseModule.DatabaseCommands;
import settingsModule.AboutSystemScreen;
import settingsModule.DbSettingsController;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import settingsModule.LanguageController;
import settingsModule.ListOfValuesController;
import userModule.UserChangePasswordClass;
import userModule.UserController;
import userModule.UserPositionController;


/**
 *
 * @author Matheus Cabral Rosa
 */
public class MainController {
    // Classes Instances
    mainScreen mainScreen;
    //LOV_XML_Controller lovControl;
    AboutSystemScreen about;
    DbSettingsController dbSetCtrl;
    UserController usrCtrl;
    UserPositionController posCtrl;
    ListOfValuesController lovCtrl;
    LanguageController langCtrl;
    UserChangePasswordClass changePass;
    DatabaseCommands dbCmd;
    Runtime run;
    
    private boolean mainScreenVisible = false;
    private boolean settingScreenVisible = false;
    
    private String user;
    private String password;
    
    // Constructor
    public MainController() {
        dbSetCtrl = new DbSettingsController();
        if(dbSetCtrl.verifyFileExists() && dbSetCtrl.isParametersOk()){
            this.openLoginScreen();
        } else {
            if(wishConfDbLScreen()){
                dbSetCtrl.openDbSettingsScreen();
                dbSetCtrl.setListenerDBSettingsScreen(new ScreenListenerDbSettings());
            } else {
                System.exit(0);
            }
        }
    }

    // Functions to control the screens visibility
    public boolean isMainScreenVisible() { return mainScreenVisible; }
    public boolean isSettingsScreenVisible() { return settingScreenVisible; }
    
    public void setMainScreenVisible(boolean mainScreenVisible) { this.mainScreenVisible = mainScreenVisible; }
    public void setSettingsScreenVisible(boolean settingScreenVisible) { this.settingScreenVisible = settingScreenVisible; }

    public String getUser() { return user; }
    public void setUser(String user) { this.user = user; }
    
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    
    public void setScrVisible(String screen, boolean choice){
        switch(screen){
            case "Principal":
                setMainScreenVisible(choice);
                break;
            default:
                break;
        }
    }
    
    public void openMainScreen(){
        mainScreen = new mainScreen();
        if(usrCtrl.isFirstSettingsOK()){
            mainScreen.setLabelUser(usrCtrl.getDbUser());
            this.setUser(usrCtrl.getDbUser());
            this.setPassword(usrCtrl.getDbPassword());
        } else {
            mainScreen.setLabelUser(System.getProperty("user.name"));
        }
        mainScreen.setListenerAboutSystem(new AboutSystem());
        //mainScreen.setListenerOpenLOV_XML_ConverterScreen(new openLOV_XML_Converter());
        mainScreen.setListenerOpenDBSettings(new BtnOpenDBSettingsScreen());
        mainScreen.setListenerbtnOpenUserManagement(new BtnOpenUserScreen());
        mainScreen.setListenerbtnOpenListOfValues(new BtnOpenListOfValuesScreen());
        mainScreen.setListenerbtnOpenLanguage(new BtnOpenLanguageScreen());
        mainScreen.setListenerbtnOpenCalculator(new BtnOpenWindowsCalculator());
        mainScreen.setListenerbtnLockSystem(new BtnLockSystem());
        mainScreen.setListenerbtnOpenUserPermition(new BtnOpenUserPermitionScreen());
        mainScreen.setListenerbtnOpenChangePassword(new BtnOpenChangePasswordScreen());
        setScrVisible("Principal", true);
        //dbParamTest = new DBParametersTest();
        //this.openScreen("Principal");
    }
    
    public void openLoginScreen(){
        this.user = null;
        this.password = null;

        try {
            usrCtrl = new UserController();
            usrCtrl.openLoginScreen();
            usrCtrl.setListenerUserLoginScreen(new ScreenListenerUserLogin());
        } catch (InterruptedException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean wishConfDbLScreen() {
        String[] options = {"Sim", "Não"};
        int x = JOptionPane.showOptionDialog(null, "Os arquivo de configuração do banco de dados não está correto, deseja realizar a configuração?", "Erro", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]);
        if(x == 0){
            return true;
        } else{
            return false;
        }
    }
    
    public class AboutSystem implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            about = new AboutSystemScreen();
            about.openScreen(usrCtrl.getDbUser(), usrCtrl.getDbName());
        }
    }
    
    // MAIN Panel
    public class BtnOpenWindowsCalculator implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            run = Runtime.getRuntime();
            try {
                run.exec("calc");
            } catch (IOException ex) {
                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    public class BtnLockSystem implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            mainScreen.dispose();
            openLoginScreen();
        }
        
    }
    
    
    // Account Panel
    // Product Panel
    // Finance Panel
    
    // Settings Panel
    public class BtnOpenListOfValuesScreen implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                lovCtrl = new ListOfValuesController();
            } catch (InterruptedException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
            lovCtrl.setDbUser(getUser());
            lovCtrl.setDbPassword(getPassword());
            lovCtrl.openScreen();
        }
        
    }
    
    public class BtnOpenLanguageScreen implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                langCtrl = new LanguageController();
            } catch (InterruptedException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
            langCtrl.setDbUser(getUser());
            langCtrl.setDbPassword(getPassword());
            langCtrl.openScreen();
        }
        
    }
    
    public class BtnOpenUserScreen implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            usrCtrl.setDbUser(getUser());
            usrCtrl.setDbPassword(getPassword());
            usrCtrl.openUserScreen("MAIN", "");
        }
        
    }
    
    public class BtnOpenUserPermitionScreen implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                posCtrl = new UserPositionController();
            } catch (InterruptedException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
            posCtrl.setDbUser(getUser());
            posCtrl.setDbPassword(getPassword());
            posCtrl.openUserPositionScreen();
        }
        
    }
    
    public class BtnOpenChangePasswordScreen implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                changePass = new UserChangePasswordClass();
            } catch (InterruptedException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
            changePass.setDbUser(getUser());
            changePass.setDbPassword(getPassword());
            changePass.openChangePassword();
            changePass.setWindowListenerChangeScreen(new ScreenListenerUserChangePassword());
            
        }
        
    }
    
    public class BtnOpenDBSettingsScreen implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                dbSetCtrl = new DbSettingsController();
                dbSetCtrl.openDbSettingsScreen();
                dbSetCtrl.screenOnLoad();
            } catch (IOException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    public class ScreenListenerDbSettings implements WindowListener {

        @Override
        public void windowOpened(WindowEvent we) { }

        @Override
        public void windowClosing(WindowEvent we) { }

        @Override
        public void windowClosed(WindowEvent we) {
            if(dbSetCtrl.verifyFileExists() && dbSetCtrl.isParametersOk()){
                openLoginScreen();
            } else {
                if(wishConfDbLScreen()){
                    dbSetCtrl.openDbSettingsScreen();
                    dbSetCtrl.setListenerDBSettingsScreen(new ScreenListenerDbSettings());
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
    
    public class ScreenListenerUserLogin implements WindowListener {

        @Override
        public void windowOpened(WindowEvent we) { }

        @Override
        public void windowClosing(WindowEvent we) { }

        @Override
        public void windowClosed(WindowEvent we) {
            openMainScreen();
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
    
    public class ScreenListenerUserChangePassword implements WindowListener {

        @Override
        public void windowOpened(WindowEvent we) { }

        @Override
        public void windowClosing(WindowEvent we) { }

        @Override
        public void windowClosed(WindowEvent we) {
            setPassword(changePass.getDbPassword());
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
