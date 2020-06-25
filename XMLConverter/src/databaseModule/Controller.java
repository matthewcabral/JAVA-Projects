/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseModule;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Statement;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Matheus Cabral Rosa
 */
public abstract class Controller {
    DbSettingsController genSettings;
    
    // Database Variables
    public Connection conn = null;
    public Statement statement;
    private final String confFile = System.getProperty("user.home") +"\\XMLConverter\\Settings\\db_conf.conf";
    private final String SplitBy = ";";
    private String dbDriver;// = "oracle.jdbc.OracleDriver"; // Driver used to connect on oracle database
    private String dbURL;// = "jdbc:oracle:thin:@"; // Connection line used to connect to the database
    private String dbLocal;// = "RJA-CGJP0L2";
    private String dbPort;// = "1521";
    private String dbName;// = "SIEBELDEV"; // Database Name
    private String dbOwner;// = "SADMIN";// Default Database table Owners
    private String dbUser; // Database user connected
    private String dbPassword; // Database user password connected
    public ArrayList<String> resultQuery;
    private boolean firstSettingsOK = false;
    
    // Database exceptions list
    exceptionsController exc;
    
    // Empty Constructor
    public Controller() {
        try {
            readParameters();
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        exc = new exceptionsController();
    }

    
    // Database Setters and Getters
    public String getDbDriver() { return dbDriver; }
    public void setDbDriver(String dbDriver) { this.dbDriver = dbDriver; }
    
    public String getDbURL() { return this.dbURL + this.dbLocal + ":" + this.dbPort + ":" + this.dbName; }
    public void setDbURL(String dbURL) { this.dbURL = dbURL; }
    
    public String getDbLocal(){ return this.dbLocal; }
    public void setDbLocal(String dbLocal) { this.dbLocal = dbLocal; }
    
    public String getDbName(){ return this.dbName; }
    public void setDbName(String dbName) { this.dbName = dbName; }
    
    public String getDbPort(){ return this.dbPort; }
    public void setDbPort(String dbPort) { this.dbPort = dbPort; }
    
    public String getDbOwner() { return dbOwner; }
    public void setDbOwner(String dbOwner) { this.dbOwner = dbOwner; }

    public String getDbUser() { return dbUser; }
    public void setDbUser(String dbUser) { this.dbUser = dbUser; }

    public String getDbPassword() { return dbPassword; }
    public void setDbPassword(String dbPassword) { this.dbPassword = dbPassword; }

    public boolean isFirstSettingsOK() {
        return firstSettingsOK;
    }

    public void setFirstSettingsOK(boolean firstSettingsOK) {
        this.firstSettingsOK = firstSettingsOK;
    }
    
    

    public ArrayList<String> getResultQuery() { return resultQuery; }
    public void setResultQuery(ArrayList<String> resultQuery) { this.resultQuery = resultQuery; }
        
    // Open Database Connection
    public abstract String openConnection(String message);
    
    // Close Database Connection
    public abstract String closeConnection(String message);
    
    private void readParameters() throws IOException{
        
        System.out.println("Carregando Parametros do Banco de Dados");
        File file = new File(confFile);
        if(file.exists()) {
            try {
                int i = 0;
                BufferedReader br = new BufferedReader(new FileReader(confFile));
                String line;
                while((line = br.readLine()) != null){
                    if(i > 0){
                        StringTokenizer st = new StringTokenizer(line, SplitBy);
                        setDbDriver(st.nextToken());
                        setDbURL(st.nextToken());
                        setDbLocal(st.nextToken());
                        setDbPort(st.nextToken());
                        setDbName(st.nextToken());
                        setDbOwner(st.nextToken());
                        setDbUser(st.nextToken());
                        setDbPassword(st.nextToken());
                    }
                    i++;
                }

                System.out.println("Parametros OK");
                this.setFirstSettingsOK(true);
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "O arquivo não foi encontrado, verifique se o mesmo existe ou está com o nome correto.", "Erro", JOptionPane.ERROR_MESSAGE);
                System.out.println("O arquivo não foi encontrado, verifique se o mesmo existe ou está com o nome correto.");
                
                String[] options = {"Sim", "Não"};
                int x = JOptionPane.showOptionDialog(null, "Deseja Realizar a configuração do Banco de Dados?", "Escolha", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                if(x == 0){
                    genSettings = new DbSettingsController(true);
                    this.setFirstSettingsOK(genSettings.isFirstSettingsOK());
                } else {
                    System.exit(0);
                }
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Erro ao Carregar parâmetros do Banco de Dados", "Erro", JOptionPane.ERROR_MESSAGE);
                System.out.println("Erro ao Carregar parâmetros do Banco de Dados");
                
                String[] options = {"Sim", "Não"};
                int x = JOptionPane.showOptionDialog(null, "Deseja Realizar a configuração do Banco de Dados?", "Escolha", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                if(x == 0){
                    genSettings = new DbSettingsController(true);
                    this.setFirstSettingsOK(genSettings.isFirstSettingsOK());
                } else {
                    System.exit(0);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao Carregar parâmetros do Banco de Dados", "Erro", JOptionPane.ERROR_MESSAGE);
            System.out.println("Erro ao Carregar parâmetros do Banco de Dados");
            
            String[] options = {"Sim", "Não"};
            int x = JOptionPane.showOptionDialog(null, "Deseja Realizar a configuração do Banco de Dados?", "Escolha", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            if(x == 0){
                genSettings = new DbSettingsController(true);
                this.setFirstSettingsOK(genSettings.isFirstSettingsOK());
            } else {
                System.exit(0);
            }
        }
        
        
    }
}
