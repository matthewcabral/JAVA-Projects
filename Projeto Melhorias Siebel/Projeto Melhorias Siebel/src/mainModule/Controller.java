/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainModule;

import SystemSettingsModule.SystemSettingsController;
import BatimentoModule.*;
import BatimentoModule.Relatorio.RelBatimentoController;
import BatimentoModule.SOM.SOMController;
import SystemSettingsModule.AboutSystemScreen;
import SystemSettingsModule.GeneralSettingsController;
import databaseModule.DataController;
import userModule.*;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author Matheus Cabral Rosa
 */
public class Controller extends DataController{
    // Classes Instances
    UserLoginScreen login;
    mainScreen main;
    //BatimentoScreen batimentoSc;
    BatimentoController batControl;
    RelBatimentoController relBatControl;
    SOMController som;
    SystemSettingsController settingsCon;
    AboutSystemScreen about;
    GeneralSettingsController genSettings;
    
    
    private boolean mainScreenVisible = false;
    private boolean batScrennVisible = false;
    private boolean loginScreenVisible = false;
    private boolean batSOMScrennVisible = false;
    private boolean relBatControlVisible = false;
    private boolean settingScreenVisible = false;
    
    // Constructor
    public Controller(){ }

    // Functions to control the screens visibility
    public boolean isMainScreenVisible() { return mainScreenVisible; }
    public boolean isBatScreenVisible() { return batScrennVisible; }
    public boolean isBatSOMScreenVisible() { return batSOMScrennVisible; }
    public boolean isLoginScreenVisible() { return loginScreenVisible; }
    public boolean isrelBatControlVisible() { return relBatControlVisible; }
    public boolean isSettingsScreenVisible() { return settingScreenVisible; }
    
    public void setMainScreenVisible(boolean mainScreenVisible) { this.mainScreenVisible = mainScreenVisible; }
    public void setBatScrennVisible(boolean batScrennVisible) { this.batScrennVisible = batScrennVisible; }
    public void setBatSOMScrennVisible(boolean batSOMScrennVisible) { this.batSOMScrennVisible = batSOMScrennVisible; }
    public void setLoginScreenVisible(boolean loginScreenVisible) { this.loginScreenVisible = loginScreenVisible; }
    public void setEnvReportVisible(boolean relBatControlVisible) { this.relBatControlVisible = relBatControlVisible; }
    public void setSettingsScreenVisible(boolean settingScreenVisible) { this.settingScreenVisible = settingScreenVisible; }

    // Function used to open Screens
    public void openScreen(String function){
        switch(function){
            case "Login":
                login = new UserLoginScreen();
                login.setListenerLogin(new UserLogin());
                setScrVisible("Login", true);
                break;
            case "Principal":
                main = new mainScreen();
                main.setExtendedState(MAXIMIZED_BOTH);
                main.setListenerBatimento(new openBatimentoScreen());
                //main.setListenerBatimentoSOM(new openBatimentoSOMScreen());
                main.setListenerLockSystem(new LockSystem());
                main.setListenerAboutSystem(new AboutSystem());
                main.setListenerEnvReport(new openEnvReportScreen());
                main.setListenerBtnSettings(new openSettingsScreen());
                setScrVisible("Principal", true);
                break;
            case "Batimento":
                batControl = new BatimentoController(super.getDbUser(), super.getDbPassword());
                setScrVisible("Batimento", true);
                break;
            case "BatimentoSOM":
                som = new SOMController(super.getDbUser(), super.getDbPassword());
                setScrVisible("BatimentoSOM", true);
                break;
            case "RelatorioBatimento":
                relBatControl = new RelBatimentoController(super.getDbUser(), super.getDbPassword());
                setScrVisible("RelatorioBatimento", true);
                break;
            case "Settings":
                settingsCon = new SystemSettingsController(super.getDbUser(), super.getDbPassword());
                setScrVisible("Settings", true);
                break;
            default:
                break;
        }
    }
    
    public void setScrVisible(String screen, boolean choice){
        switch(screen){
            case "Login":
                login.setVisible(choice);
                setLoginScreenVisible(choice);
                break;
            case "Principal":
                setMainScreenVisible(choice);
                break;
            case "Batimento":
                //batimentoSc.setVisible(choice);
                setBatScrennVisible(choice);
                break;
            case "BatimentoSOM":
                //batimentoSc.setVisible(choice);
                setBatSOMScrennVisible(choice);
                break;
            case "RelatorioBatimento":
                //batimentoSc.setVisible(choice);
                setEnvReportVisible(choice);
                break;
            case "Settings":
                //batimentoSc.setVisible(choice);
                setEnvReportVisible(choice);
                break;
            default:
                break;
        }
    }

    public class UserLogin implements ActionListener {
        private String result;
        @Override
        public void actionPerformed(ActionEvent e) {
            login.setErrorArea("");
            if(isMainScreenVisible()){
                setDbUser(login.getUser());
                setDbPassword(login.getPassword());

                result = openConnection("Realizando Login");
                if("true".equals(result)){
                    login.setErrorArea("");
                    login.setVisible(false);
                    main.setVisible(true);
                    main.setLabelUser(getDbUser());
                    closeConnection("Login Realizado com sucesso!");
                } else {
                    if("java.sql.SQLRecoverableException: Erro de ES: The Network Adapter could not establish the connection".equals(result)){
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        login.setErrorArea("Erro ao tentar realizar conexão com o Banco de dados. Verifique se o listener está ativo.");
                    } else if(result.contains("ORA-12505, TNS:listener does not currently know of SID given in connect descriptor")) {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        login.setErrorArea("Erro ao tentar realizar conexão com o Banco de dados. Verifique se o listener está correto.");
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        String[] options = {"Sim", "Não"};
                        int x = JOptionPane.showOptionDialog(null, "Deseja Realizar a configuração do Banco de Dados?", "Escolha", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                        if(x == 0){
                            login.dispose();
                            genSettings = new GeneralSettingsController(true);
                        } else {
                            System.exit(0);
                        }
                    } else {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
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
                    main.setLabelUser(getDbUser());
                    closeConnection("Login Realizado com sucesso!");
                } else {
                    if("java.sql.SQLRecoverableException: Erro de ES: The Network Adapter could not establish the connection".equals(result)){
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        login.setErrorArea("Erro ao tentar realizar conexão com o Banco de dados. Verifique se o listener está ativo.");
                    } else if(result.contains("ORA-12505, TNS:listener does not currently know of SID given in connect descriptor")) {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        login.setErrorArea("Erro ao tentar realizar conexão com o Banco de dados. Verifique se o listener está correto.");
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        String[] options = {"Sim", "Não"};
                        int x = JOptionPane.showOptionDialog(null, "Deseja Realizar a configuração do Banco de Dados?", "Escolha", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                        if(x == 0){
                            login.dispose();
                            genSettings = new GeneralSettingsController(true);
                        } else {
                            System.exit(0);
                        }
                    } else {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        login.setErrorArea("Nome de usuário/senha incorreto. Tente novamente.");
                    }
                    
                }
            }
            
        }
    }
    
    public class LockSystem implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            login.setTxtUser("");
            login.setTxtPassword("");
            login.txtUserFocus();
            main.setVisible(false);
            if(isBatScreenVisible()){
                batControl.setBatScreenVisible(false);
                //setScrVisible("Batimento", false);
            }            
            login.setVisible(true);
            setScrVisible("Login", true);
        }
    }
    
    public class openBatimentoScreen implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            openScreen("Batimento");
        }
    }
    
    public class openBatimentoSOMScreen implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            openScreen("BatimentoSOM");
        }
    }
    
    public class openEnvReportScreen implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            openScreen("RelatorioBatimento");
        }
    }
    
    public class openSettingsScreen implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            openScreen("Settings");
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
