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
        if(super.isFirstSettingsOK()){
            openScreen("Principal");
        }
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
                mainScreen.setLabelUser(super.getDbUser());
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

    public class openLOV_XML_Converter implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            lovControl = new LOV_XML_Controller();
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
