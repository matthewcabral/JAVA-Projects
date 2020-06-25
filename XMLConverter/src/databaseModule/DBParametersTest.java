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
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author mcabralr
 */
public class DBParametersTest {
    // Database Variables
    public Connection conn = null;
    public Statement statement;
    private final String confFile = "C:\\Projeto\\db_conf.conf";
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
    
    // Database exceptions list
    exceptionsController exc;
        
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
    
    public boolean testParameters() {
        
        System.out.println("Carregando Parametros do Banco de Dados");
        File file = new File(confFile);
        if(file.isFile()){
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
                    }
                    i++;
                }

                System.out.println("Parametros OK");
                return true;
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "ATENÇÃO: Arquivo de inicialização não encontrado, verifique se o mesmo existe ou está com o nome correto.", "Erro", JOptionPane.ERROR_MESSAGE);
                System.out.println("O arquivo não foi encontrado, verifique se o mesmo existe ou está com o nome correto.");
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Erro ao Carregar parâmetros do Banco de Dados", "Erro", JOptionPane.ERROR_MESSAGE);
                System.out.println("Erro ao Carregar parâmetros do Banco de Dados");
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "ATENÇÃO: Arquivo de inicialização não encontrado, verifique se o mesmo existe ou está com o nome correto.", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        
    }
}
