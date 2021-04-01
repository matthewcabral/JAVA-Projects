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
import userModule.userController;


/**
 *
 * @author Matheus Cabral Rosa
 */
public class mainController {
    // Classes Instances
    mainScreen mainScreen;
    //LOV_XML_Controller lovControl;
    AboutSystemScreen about;
    DbSettingsController genSettings;
    userController userControl;
    
    
    private boolean mainScreenVisible = false;
    private boolean settingScreenVisible = false;
    
    private String user;
    private String password;
    
    // Constructor
    public mainController() {
        this.user = null;
        this.password = null;
        
        try {
            userControl = new userController();
            userControl.openLoginScreen();
            while(userControl.getLoginOK() != true){
                Thread.sleep(1000);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(mainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        mainScreen = new mainScreen();
        
        if(userControl.isFirstSettingsOK()){
            mainScreen.setLabelUser(userControl.getDbUser());
            this.setUser(userControl.getUser());
            this.setPassword(userControl.getPassword());
        } else {
            mainScreen.setLabelUser(System.getProperty("user.name"));
        }
        mainScreen.setListenerAboutSystem(new AboutSystem());
        //mainScreen.setListenerOpenLOV_XML_ConverterScreen(new openLOV_XML_Converter());
        mainScreen.setListenerOpenDBSettings(new openDBSettings());
        mainScreen.setListenerbtnOpenUserManagement(new openUserManagement());
        setScrVisible("Principal", true);
        //dbParamTest = new DBParametersTest();
        //this.openScreen("Principal");
        
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

    /*public class openLOV_XML_Converter implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                lovControl = new LOV_XML_Controller();
            } catch (InterruptedException ex) {
                Logger.getLogger(mainController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }*/
    
    public class AboutSystem implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            about = new AboutSystemScreen();
            about.openScreen(userControl.getDbUser(), userControl.getDbName());
        }
    }
    
    public class openDBSettings implements ActionListener {
        DbSettingsController genSettings;
        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                genSettings = new DbSettingsController(true);
                genSettings.screenOnLoad();
            } catch (IOException | InterruptedException ex) {
                Logger.getLogger(mainController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    public class openUserManagement implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            userControl.openUMScreen();
            userControl.setUser(getUser());
            userControl.setPassword(getPassword());
        }
        
    }
    
    
}
