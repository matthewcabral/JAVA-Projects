/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BatimentoModule;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matheus Cabral Rosa
 */
public class BatimentoThread extends BatimentoController implements Runnable  {
    private String nome;
    private String repOrigemName;
    private String repDestinoName;
    private String dbLinkOrigem;
    private String dbLinkDestino;
    private String dataBat;
    private String filaThreads;
    private String confName;

    Thread thread;
    
    public BatimentoThread(String nome, String RepOrigemName, String RepDestinoName, String DbLinkOrigem, String DbLinkDestino, String Data, String FilaThreads, String ConfName, String dbUser, String dbPassword) {
        super.setDbUser(dbUser);
        super.setDbPassword(dbPassword);
        this.nome = nome;
        this.repOrigemName = RepOrigemName;
        this.repDestinoName = RepDestinoName;
        this.dbLinkOrigem = DbLinkOrigem;
        this.dbLinkDestino = DbLinkDestino;
        this.dataBat = Data;
        this.filaThreads = FilaThreads;
        this.confName = ConfName;
        
        //dataControl = new DataController(){};
        
        thread = new Thread(this);
        thread.start();
    }
    
    public void waitThreadsEnd(){
        try {
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(BatimentoThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Getters
    public String getNome() { return nome; }
    public String getRepOrigemName() { return repOrigemName; }
    public String getRepDestinoName() { return repDestinoName; }
    public String getDbLinkOrigem() {  return dbLinkOrigem; }
    public String getDbLinkDestino() { return dbLinkDestino; }
    public String getDataBat() { return dataBat; }
    public String getFilaThreads() { return filaThreads; }
    @Override
    public String getConfName() { return confName; }
        
    @Override
    public void run(){
        System.out.println(nome + " em execução");
        //dataControl.
        runPLCompareAmb(getRepOrigemName(), getRepDestinoName(), getDbLinkOrigem(), getDbLinkDestino(), getDataBat(), getFilaThreads(), getConfName());
        System.out.println(nome + " finalizada");
    }
}
