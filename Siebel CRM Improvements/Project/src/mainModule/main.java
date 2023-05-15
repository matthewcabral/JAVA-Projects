/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainModule;

import SystemSettingsModule.GeneralSettingsController;
import databaseModule.ParametersTest;
import javax.swing.JOptionPane;

/**
 *
 * @author Matheus Cabral Rosa
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        Controller control;
        ParametersTest test;
        GeneralSettingsController genSettings;
        
        test = new ParametersTest();
        
        if(test.testParameters()){
            control = new Controller();
            control.openScreen("Login");
        } else {
            String[] options = {"Sim", "Não"};
            
            int x = JOptionPane.showOptionDialog(null, "Deseja Realizar a configuração do Banco de Dados?", "Escolha", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            
            if(x == 0){
                genSettings = new GeneralSettingsController(true);
            } else {
                System.exit(0);
            }
        }
        
        //mainScreen main = new mainScreen();
    }
    
    
}
