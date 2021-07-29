/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import addressModule.addressController;
import databaseModule.DataController;
import databaseModule.EncryptDecryptWord;
import java.lang.annotation.Annotation;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
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
        //EncryptDecryptWord encDec;
        MainController mainCtrl = new MainController();
        /*DataController dc;
        
        try {
            dc = new DataController() {};
            dc.setDbUser("MCABRAL");
            dc.setDbPassword("Mc260197");
            for (int i = 0; i < 75; i++){
                dc.generateRowIdTrigger();
            }
        } catch (InterruptedException e){
            
        }*/
        
        /*for(int i = 0; i < 200; i++) {
            System.out.println(i);
        }*/
        
        
        
        // Cria um Objeto LocalDate com a data atual.
       /* LocalDate hoje = LocalDate.now();
        
        // Cria um Objeto LocalDate com a data 26/09/2020.
        LocalDate outraData = LocalDate.of(1997, Month.valueOf("JANUARY"), 26);
        // Calcula a diferença de dias entre as duas datas
        long diferencaEmDias = ChronoUnit.DAYS.between(hoje, outraData);
        // Calcula a diferença de meses entre as duas datas
        long diferencaEmMes = ChronoUnit.MONTHS.between(hoje, outraData);
        // Calcula a diferença de anos entre as duas datas
        long diferencaEmAnos = ChronoUnit.YEARS.between(outraData, hoje);
        
        // Exibe a diferença em dias entre as datas
        System.out.println("Diferença em dias entre " + hoje + " e " + outraData + " = " + diferencaEmDias);
        // Exibe a diferença em meses entre as datas
        System.out.println("Diferença em meses entre " + hoje + " e " + outraData + " = " + diferencaEmMes);
        // Exibe a diferença em anos entre as datas
        System.out.println("Diferença em anos entre " + hoje + " e " + outraData + " = " + diferencaEmAnos);*/
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
        /*encDec = new EncryptDecryptWord();
        
        String teste = encDec.encryptWord("Palavra");
        String teste2 = encDec.decryptWord(teste);
        
        System.out.println(teste);
        System.out.println(teste2);*/
        //!@#$%¨*()_+{}`<>-=[];~´^,.ªº/\\|£¢¬§
        
        //ContactManagementScreen screen = new ContactManagementScreen();

        /*for(int i = 0; i < 200; i++) {
        System.out.println(i);
        }*/



        // Cria um Objeto LocalDate com a data atual.
        /* LocalDate hoje = LocalDate.now();

        // Cria um Objeto LocalDate com a data 26/09/2020.
        LocalDate outraData = LocalDate.of(1997, Month.valueOf("JANUARY"), 26);
        // Calcula a diferença de dias entre as duas datas
        long diferencaEmDias = ChronoUnit.DAYS.between(hoje, outraData);
        // Calcula a diferença de meses entre as duas datas
        long diferencaEmMes = ChronoUnit.MONTHS.between(hoje, outraData);
        // Calcula a diferença de anos entre as duas datas
        long diferencaEmAnos = ChronoUnit.YEARS.between(outraData, hoje);

        // Exibe a diferença em dias entre as datas
        System.out.println("Diferença em dias entre " + hoje + " e " + outraData + " = " + diferencaEmDias);
        // Exibe a diferença em meses entre as datas
        System.out.println("Diferença em meses entre " + hoje + " e " + outraData + " = " + diferencaEmMes);
        // Exibe a diferença em anos entre as datas
        System.out.println("Diferença em anos entre " + hoje + " e " + outraData + " = " + diferencaEmAnos);*/
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
        /*encDec = new EncryptDecryptWord();

        String teste = encDec.encryptWord("Palavra");
        String teste2 = encDec.decryptWord(teste);

        System.out.println(teste);
        System.out.println(teste2);*/
        //!@#$%¨*()_+{}`<>-=[];~´^,.ªº/\\|£¢¬§

        //ContactManagementScreen screen = new ContactManagementScreen();
    }
}