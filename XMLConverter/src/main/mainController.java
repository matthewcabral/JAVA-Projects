/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import LOVConverterModule.LOV_XML_Controller;
import SystemSettingsModule.AboutSystemScreen;
import databaseModule.DbSettingsController;
import databaseModule.DataController;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Matheus Cabral Rosa
 */
public class mainController extends DataController{
    // Classes Instances
    mainScreen mainScreen;
    LOV_XML_Controller lovControl;
    AboutSystemScreen about;
    DbSettingsController genSettings;
    
    
    private boolean mainScreenVisible = false;
    private boolean settingScreenVisible = false;
    
    // Constructor
    public mainController() throws InterruptedException {
        mainScreen = new mainScreen();
        if(super.isFirstSettingsOK()){
            mainScreen.setLabelUser(super.getDbUser());
        } else {
            mainScreen.setLabelUser(System.getProperty("user.name"));
        }
        mainScreen.setExtendedState(MAXIMIZED_BOTH);
        mainScreen.setListenerAboutSystem(new AboutSystem());
        mainScreen.setListenerOpenLOV_XML_ConverterScreen(new openLOV_XML_Converter());
        mainScreen.setListenerOpenDBSettings(new openDBSettings());
        setScrVisible("Principal", true);
        //dbParamTest = new DBParametersTest();
        //this.openScreen("Principal");
    }

    // Functions to control the screens visibility
    public boolean isMainScreenVisible() { return mainScreenVisible; }
    public boolean isSettingsScreenVisible() { return settingScreenVisible; }
    
    public void setMainScreenVisible(boolean mainScreenVisible) { this.mainScreenVisible = mainScreenVisible; }
    public void setSettingsScreenVisible(boolean settingScreenVisible) { this.settingScreenVisible = settingScreenVisible; }
    
    public void setScrVisible(String screen, boolean choice){
        switch(screen){
            case "Principal":
                setMainScreenVisible(choice);
                break;
            default:
                break;
        }
    }

    public class openLOV_XML_Converter implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                lovControl = new LOV_XML_Controller();
            } catch (InterruptedException ex) {
                Logger.getLogger(mainController.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public class openDBSettings implements ActionListener {
        DbSettingsController genSettings;
        @Override
        public void actionPerformed(ActionEvent ae) {
            genSettings = new DbSettingsController(true);
        }
        
    }
    
    
}
