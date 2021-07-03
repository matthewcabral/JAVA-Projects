/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import addressModule.addressController;
import java.lang.annotation.Annotation;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import userModule.UserPermitionScreen;

/**
 *
 * @author Matheus
 */

public class main{

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
        /*for(int i = 0; i < 200; i++) {
            System.out.println(i);
        }*/
        
        
        /*addressController address;
        try {
            address = new addressController();
            address.getAddressByZipcode("23036030");
        } catch (InterruptedException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
        
        /*String permitionValue = "Visualizar Usuario";
        /*System.out.println(permitionValue.lastIndexOf(" "));
        permitionValue = permitionValue.substring(permitionValue.lastIndexOf(" ") + 1, permitionValue.length());
        System.out.println(permitionValue);
        //UserPermitionScreen scr = new UserPermitionScreen();
        String texto = "CASH_BOX_VIEW";
        int index = texto.lastIndexOf("_") + 1;
        System.out.println("Indice: " + index);
        String textoSub = texto.substring(index, texto.length());
        System.out.println("Texto substring: " + textoSub);*/
        /*EncryptDecryptWordClass encDec = new EncryptDecryptWordClass();
        
        String teste = encDec.encryptWord("Mc260197");
        String teste2 = encDec.decryptWord(teste);*/
        //!@#$%¨*()_+{}`<>-=[];~´^,.ªº/\\|£¢¬§
        
        //ContactManagementScreen screen = new ContactManagementScreen();
    }
}