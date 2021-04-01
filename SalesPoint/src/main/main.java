/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Matheus
 */
import contactModule.ContactManagementScreen;
import databaseModule.EncryptDecryptWordClass;
import javax.xml.parsers.DocumentBuilderFactory;  
import javax.xml.parsers.DocumentBuilder;  
import org.w3c.dom.Document;  
import org.w3c.dom.NodeList;  
import org.w3c.dom.Node;  
import org.w3c.dom.Element;  
import java.io.File;  
import java.util.logging.Level;
import java.util.logging.Logger;

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        mainController mainCtrl = new mainController();
        /*EncryptDecryptWordClass encDec = new EncryptDecryptWordClass();
        
        String teste = encDec.encryptWord("Mc260197");
        String teste2 = encDec.decryptWord(teste);*/
        //!@#$%¨*()_+{}`<>-=[];~´^,.ªº/\\|£¢¬§
        
        //ContactManagementScreen screen = new ContactManagementScreen();
    }
}