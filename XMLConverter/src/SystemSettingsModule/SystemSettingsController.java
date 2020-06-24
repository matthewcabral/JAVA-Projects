/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SystemSettingsModule;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author mcabralr
 */
public class SystemSettingsController {
    
    // Variables
    private String dbUser;
    private String dbPassword;
    
    // Classes Instances
    SystemSettingsScreen settingsScr;
    GeneralSettingsController genSettings ;
    DatabaseSettingsController dbSettingsCon;
    AboutSystemScreen aboutSystem;

    public SystemSettingsController(String dbUser, String dbPassword) {
        this.dbUser = dbUser;
        this.dbPassword = dbPassword;
        settingsScr = new SystemSettingsScreen();
        settingsScr.setListenerBtnGenSet(new OpenGeneralSettings());
        settingsScr.setListenerBtnDBSettings(new OpenDBSettings());
        settingsScr.setListenerBtnAboutSystem(new OpenAboutSystemScreen());
    }
    
    
    public class OpenGeneralSettings implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            genSettings = new GeneralSettingsController(false);
        }
        
    }
    
    public class OpenDBSettings implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            dbSettingsCon = new DatabaseSettingsController(dbUser, dbPassword);
        }
        
    }
    
    public class OpenAboutSystemScreen implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            aboutSystem = new AboutSystemScreen();
            aboutSystem.openScreen(dbUser, dbPassword);
        }
        
    }
    
}
