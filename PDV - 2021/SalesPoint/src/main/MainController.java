/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import settingsModule.AboutSystemScreen;
import settingsModule.DbSettingsController;
import java.awt.event.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import settingsModule.LanguageController;
import settingsModule.ListOfValuesController;
import userModule.UserController;


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
    ListOfValuesController lovCtrl;
    LanguageController langCtrl;
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
                dbSetCtrl.setListenerDBSettingsScreen(new dbSettingsScreenListener());
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
    
    public void openLoginScreen(){
        this.user = null;
        this.password = null;

        try {
            usrCtrl = new UserController();
            usrCtrl.openLoginScreen();
            usrCtrl.setListenerUserLoginScreen(new userLoginScreenListener());
        } catch (InterruptedException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void openMainScreen(){
        mainScreen = new mainScreen();
        if(usrCtrl.isFirstSettingsOK()){
            mainScreen.setLabelUser(usrCtrl.getDbUser());
            this.setUser(usrCtrl.getUser());
            this.setPassword(usrCtrl.getPassword());
        } else {
            mainScreen.setLabelUser(System.getProperty("user.name"));
        }
        mainScreen.setListenerAboutSystem(new AboutSystem());
        //mainScreen.setListenerOpenLOV_XML_ConverterScreen(new openLOV_XML_Converter());
        mainScreen.setListenerOpenDBSettings(new BtnOpenDBSettings());
        mainScreen.setListenerbtnOpenUserManagement(new BtnOpenUserModule());
        mainScreen.setListenerbtnOpenListOfValues(new BtnOpenListOfValuesScreen());
        mainScreen.setListenerbtnOpenLanguage(new BtnOpenLanguageScreen());
        mainScreen.setListenerbtnOpenCalculator(new BtnOpenCalculator());
        mainScreen.setListenerbtnLockSystem(new BtnLockSystem());
        
        setScrVisible("Principal", true);
        //dbParamTest = new DBParametersTest();
        //this.openScreen("Principal");
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
    
    public void setScrVisible(String screen, boolean choice){
        switch(screen){
            case "Principal":
                setMainScreenVisible(choice);
                break;
            default:
                break;
        }
    }
    
    public class AboutSystem implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            about = new AboutSystemScreen();
            about.openScreen(usrCtrl.getDbUser(), usrCtrl.getDbName());
        }
    }
    
    public class BtnOpenDBSettings implements ActionListener {
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
    
    public class BtnOpenListOfValuesScreen implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                lovCtrl = new ListOfValuesController();
            } catch (InterruptedException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
            lovCtrl.setUser(getUser());
            lovCtrl.setDbUser(getUser());
            lovCtrl.setPassword(getPassword());
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
            langCtrl.setUser(getUser());
            langCtrl.setDbUser(getUser());
            langCtrl.setPassword(getPassword());
            langCtrl.setDbPassword(getPassword());
            langCtrl.openScreen();
        }
        
    }
    
    public class BtnOpenUserModule implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            usrCtrl.openUserScreen("MAIN", "");
            usrCtrl.setUser(getUser());
            usrCtrl.setPassword(getPassword());
        }
        
    }
    
    public class BtnOpenCalculator implements ActionListener {

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
    
    public class dbSettingsScreenListener implements WindowListener {

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
    
    public class userLoginScreenListener implements WindowListener {

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
    
    
    
}
