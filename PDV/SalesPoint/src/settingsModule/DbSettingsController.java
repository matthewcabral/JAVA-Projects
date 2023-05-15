/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package settingsModule;

import databaseModule.ExceptionsController;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
//import main.Controller;

/**
 *
 * @author mcabralr
 */
public class DbSettingsController {
    File file;
    DbSettingsScreen dbSetScreen;
    ExceptionsController exc;
    
    // Database Variables
    private final String confFile = System.getProperty("user.home") + (System.getProperty("os.name").contains("Windows") ? "\\SalesPoint\\Settings\\db_conf.conf" : "//SalesPoint//Settings//db_conf.conf");
    private final String SplitBy = ";";
    private final String pattern = "dd-MM-yyyy HH:mm:ss";
    public Connection conn = null;
    public Statement statement;
    private String dbDriverName;
    private String dbDriver;// = "oracle.jdbc.OracleDriver"; // Driver used to connect on oracle database
    private String dbURL;// = "jdbc:oracle:thin:@"; // Connection line used to connect to the database
    private String dbLocal;// = "RJA-CGJP0L2";
    private String dbPort;// = "1521";
    private String dbName;// = "SIEBELDEV"; // Database Name
    private String dbOwner;// = "SADMIN";// Default Database table Owners
    private String dbUser; // Database user connected
    private String dbPassword; // Database user password connected
    private String driverType;
    SimpleDateFormat simpleDateFormat;
    //String date;
    
    //private boolean firstSettings;
    private boolean firstSettingsOK;

    public DbSettingsController() {
        this.dbDriverName = null;
        this.dbDriver = null;
        this.dbURL = null;
        this.dbLocal = null;
        this.dbPort = null;
        this.dbName = null;
        this.dbOwner = null;
        this.dbUser = null;
        this.dbPassword = null;
        this.driverType = null;
        this.firstSettingsOK = false;
        simpleDateFormat = new SimpleDateFormat(pattern);
    }
    
    // Database Setters and Getters
    public String getDbDriverName() { return dbDriverName; }
    public void setDbDriverName(String dbDriverName) { this.dbDriverName = dbDriverName; }

    public String getDbDriver() { return dbDriver; }
    public void setDbDriver(String dbDriver) { this.dbDriver = dbDriver; }
    
    public String getDbURL() { 
        String url = "";
        if("SID".equals(getDbDriverName())){
            url = this.dbURL + this.dbLocal + ":" + this.dbPort + ":" + this.dbName;
        } else if("Service Name".equals(getDbDriverName())){
            url = this.dbURL + "//" + this.dbLocal + ":" + this.dbPort + "/" + this.dbName;
        } else {
            url = this.dbURL + this.dbName;
        }        
        return url;
    }
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
    
    public String getDateTime() { return simpleDateFormat.format(new Date()); }    
    
    public boolean isFirstSettingsOK() { return firstSettingsOK; }
    
    public void setListenerDBSettingsScreen(WindowListener listener) { dbSetScreen.addWindowListener(listener); }
    
    public void openDbSettingsScreen(){
        dbSetScreen = new DbSettingsScreen();
        
        dbSetScreen.clearFields();
        dbSetScreen.clearComboBoxes();
        dbSetScreen.insertSelectComboBox();
        this.fillComboBoxes("DRIVER_NAME");
        this.fillComboBoxes("DRIVER");
        
        dbSetScreen.setListenerBtnTestDB(new testDbConnection());
        dbSetScreen.setListenerBtnSaveDBParam(new saveDbParameters());
        dbSetScreen.setListenerCbbDriver(new chooseDriverType());
        
    }
    
    private void fillComboBoxes(String type){
        switch(type){
            case "DRIVER_NAME":
                dbSetScreen.setcbbDriverName("SID");
                dbSetScreen.setcbbDriverName("Service Name");
                dbSetScreen.setcbbDriverName("TNS");
                break;
            case "DRIVER":
                dbSetScreen.setcbbDriver("ORACLE SQL");
                dbSetScreen.setcbbDriver("MySQL");
                break;
            default:
                break;
        }
    }
    
    public void screenOnLoad() throws IOException{
        if(verifyFileExists()) {
            try {
                int i = 0;
                BufferedReader br = new BufferedReader(new FileReader(confFile));
                String line;
                while((line = br.readLine()) != null){
                    if(i > 0){
                        StringTokenizer st = new StringTokenizer(line, SplitBy);
                        //driverType = st.nextToken();
                        
                        dbSetScreen.setCbbDriverNameItemIndex(dbSetScreen.getCbbDriverNameItemIndex(st.nextToken()));
                        /*if("SID".equals(driverType)){
                            
                        } else if("Service Name".equals(driverType)){
                            dbSetScreen.setCbbDriverNameItemIndex(1);
                        } else {
                            dbSetScreen.setCbbDriverNameItemIndex(2);
                        }*/
                        
                        String driver = st.nextToken();
                        switch(driver){
                            case "oracle.jdbc.OracleDriver":
                                dbSetScreen.setCbbDriverItemIndex(dbSetScreen.getCbbDriverItemIndex("ORACLE SQL"));
                                break;
                            case "com.mysql.jdbc.Driver":
                                dbSetScreen.setCbbDriverItemIndex(dbSetScreen.getCbbDriverItemIndex("MySQL"));
                                break;
                            default:
                                dbSetScreen.setCbbDriverItemIndex(dbSetScreen.getCbbDriverItemIndex("ORACLE SQL"));
                                break;
                        }
                        
                        //dbSetScreen.setcbbDriver(st.nextToken());                        
                        dbSetScreen.settxtURL(st.nextToken());
                        dbSetScreen.settxtLocal(st.nextToken());
                        dbSetScreen.settxtPort(st.nextToken());
                        dbSetScreen.settxtDBName(st.nextToken());
                        dbSetScreen.settxtOwner(st.nextToken());
                    }
                    i++;
                }

                br.close();
                System.out.println("Parametros OK");
                
            } catch (Exception ex) {
                System.out.println("Erro ao ler arquivo: " + ex);
            }
        }
    }
    
    public boolean verifyFileExists(){
        file = new File(confFile);
        return (file.exists());
        //verificar por que está dando problema aqui
    }
    
    public boolean isParametersOk() {
        try {
            int i = 0;
            BufferedReader br = new BufferedReader(new FileReader(confFile));
            String line;
            while((line = br.readLine()) != null){
                if(i > 0){
                    StringTokenizer st = new StringTokenizer(line, SplitBy);
                    driverType = st.nextToken();
                    if("SID".equals(driverType)){
                        this.setDbDriverName("SID");
                    } else if("Service Name".equals(driverType)){
                        this.setDbDriverName("Service Name");
                    } else {
                        this.setDbDriverName("TNS");
                    }

                    this.setDbDriver(st.nextToken());
                    this.setDbURL(st.nextToken());
                    this.setDbLocal(st.nextToken());
                    this.setDbPort(st.nextToken());
                    this.setDbName(st.nextToken());
                    this.setDbOwner(st.nextToken());
                }
                i++;
            }

            br.close();
            System.out.println("Parametros OK");
            return true;
        } catch (Exception ex) {
            System.out.println("Erro ao ler arquivo: " + ex);
        }
        return false;
    }
    
    private boolean testDbConnection(){
        if(validateFields()){
            switch(dbSetScreen.getcbbDriver()){
                case "ORACLE SQL":
                    setDbDriver("oracle.jdbc.OracleDriver");
                    break;
                case "MySQL":
                    setDbDriver("com.mysql.cj.jdbc.Driver");
                    break;
                default:
                    setDbDriver("oracle.jdbc.OracleDriver");
                    break;
            }
            switch(dbSetScreen.getCbbDriverName()) {
                case "SID":
                    setDbURL(dbSetScreen.gettxtURL());
                    break;
                case "Service Name":
                    setDbURL(dbSetScreen.gettxtURL());
                    break;
                default:
                    setDbURL(dbSetScreen.gettxtURL() + dbSetScreen.gettxtDBName());
                    break;
            }
            setDbDriverName(dbSetScreen.getCbbDriverName());            
            setDbName(dbSetScreen.gettxtDBName());
            setDbOwner(dbSetScreen.gettxtOwner());
            setDbLocal(dbSetScreen.gettxtLocal());
            setDbPort(dbSetScreen.gettxtPort());
            setDbUser(dbSetScreen.gettxtUser());
            setDbPassword(dbSetScreen.gettxtPassword());

            try{
                String result = openConnection("Realizando Login");
                if("true".equals(result)){
                    closeConnection("");
                    return true;
                }
            } catch(Exception e){
                JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco de dados!\n" + e,"Erro",JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Todos os campos são de preenchimento obrigatório. Favor preencher os campos vazios!","Erro",JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    private boolean validateFields(){
        return
        (!"".equals(dbSetScreen.getcbbDriver()) && dbSetScreen.getcbbDriver() != null) &&
        (!"".equals(dbSetScreen.gettxtURL()) && dbSetScreen.gettxtURL() != null) &&
        (!"".equals(dbSetScreen.gettxtLocal()) && dbSetScreen.gettxtLocal() != null) &&
        (!"".equals(dbSetScreen.gettxtPort()) && dbSetScreen.gettxtPort() != null) &&
        (!"".equals(dbSetScreen.gettxtDBName()) && dbSetScreen.gettxtDBName() != null) &&
        (!"".equals(dbSetScreen.gettxtUser()) && dbSetScreen.gettxtUser() != null) &&
        (!"".equals(dbSetScreen.gettxtPassword()) && dbSetScreen.gettxtPassword() != null) &&
        (!"".equals(dbSetScreen.gettxtOwner()) && dbSetScreen.gettxtOwner() != null) &&
        (
            (
                "SID".equals(dbSetScreen.getCbbDriverName()) || 
                "Service Name".equals(dbSetScreen.getCbbDriverName()) || 
                "TNS".equals(dbSetScreen.getCbbDriverName())
            )
        );
    }
    
    private boolean saveDbParameters(){
        try{
            //Abre caixa de dialogo para selecionar caminho do arquivo que será gerado.
            JFileChooser fc = new JFileChooser();
            fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

            file = new File(System.getProperty("user.home") + (System.getProperty("os.name").contains("Windows") ? "\\SalesPoint\\Settings" : "//SalesPoint//Settings"));
            if(!file.exists()){
                file.mkdirs();
            }
            
            String path = System.getProperty("user.home") + (System.getProperty("os.name").contains("Windows") ? "\\SalesPoint\\Settings\\db_conf.conf" : "//SalesPoint//Settings//db_conf.conf");
            String header = "TIPO_DRIVER;DRIVER;URL;LOCAL;PORTA;NOME_BANCO;OWNER_BANCO\n";
            if (!path.isEmpty()) {            
                BufferedWriter buff = new BufferedWriter(new FileWriter(path));
                buff.append(header);
                buff.append(dbSetScreen.getCbbDriverName() + ";");
                switch(dbSetScreen.getcbbDriver()){
                    case "ORACLE SQL":
                        buff.append("oracle.jdbc.OracleDriver" + ";");
                        break;
                    case "MySQL":
                        buff.append("com.mysql.jdbc.Driver" + ";");
                        break;
                    default:
                        buff.append("oracle.jdbc.OracleDriver" + ";");
                        break;
                }                
                buff.append(dbSetScreen.gettxtURL() + ";");
                buff.append(dbSetScreen.gettxtLocal() + ";");
                buff.append(dbSetScreen.gettxtPort() + ";");
                buff.append(dbSetScreen.gettxtDBName() + ";");
                buff.append(dbSetScreen.gettxtOwner() + "\n");
                buff.close();
                JOptionPane.showMessageDialog(null, "Parâmetros salvos com Sucesso!");
            }
            return true;
        } catch (HeadlessException | IOException e){
            JOptionPane.showMessageDialog(null, "Erro ao tentar salvar os Parâmetros!\nErro: " + e);
            return false;
        }
    }
    
    public String openConnection(String message){
        try {
            Class.forName(getDbDriver());
        } catch (ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, exc.getDbODBCEx() + "\n" + exc.getMsgReturn() + e, "Erro", JOptionPane.ERROR_MESSAGE);
        }
        try {
            conn = DriverManager.getConnection(getDbURL(), getDbUser(), getDbPassword());
            System.out.println(getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "OpenConnection" + "\t\t" + "ObjMgrSqlLog" + "\t" + "Oracle JDBC Driver Registered. Connected Successfuly" + "\t\t" + message);
            return "true";
        } catch(SQLException e) {
            if("Realizando Login".equals(message)){
                if(e.toString().contains("java.sql.SQLRecoverableException: IO Error: The Network Adapter could not establish the connection")){
                    JOptionPane.showMessageDialog(null, "Erro ao tentar realizar conexão com o Banco de dados. Verifique se o listener está ativo.","Erro",JOptionPane.ERROR_MESSAGE);
                    System.out.println(getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "OpenConnection" + "\t\t" + "ObjMgrSqlLog" + "\t" + "Error" + "\t" + "Erro ao tentar realizar conexão com o Banco de dados. Verifique se o listener está ativo.");
                } else if(e.toString().contains("ORA-12505: TNS: listener does not currently know of SID given in connect descriptor tips")){
                    JOptionPane.showMessageDialog(null, "O Listener não identificou o SID utilizado no descritor de conexão.","Erro",JOptionPane.ERROR_MESSAGE);
                    System.out.println(getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "OpenConnection" + "\t\t" + "ObjMgrSqlLog" + "\t" + "Error" + "\t" + "O Listener não identificou o SID utilizado no descritor de conexão.");
                } else if(e.toString().contains("CommunicationsException")){
                    JOptionPane.showMessageDialog(null, "Erro ao tentar realizar conexão com o Banco de dados. Não foi possível conectar-se ao servidor.","Erro",JOptionPane.ERROR_MESSAGE);
                    System.out.println(getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "OpenConnection" + "\t\t" + "ObjMgrSqlLog" + "\t" + "Error" + "\t" + "Erro ao tentar realizar conexão com o Banco de dados. Não foi possível conectar-se ao servidor.");
                } else if(e.toString().contains("ORA-12505, TNS:listener does not currently know of SID given in connect descriptor")){
                    JOptionPane.showMessageDialog(null, "O Listener não identificou o SID utilizado no descritor de conexão.","Erro",JOptionPane.ERROR_MESSAGE);
                    System.out.println(getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "OpenConnection" + "\t\t" + "ObjMgrSqlLog" + "\t" + "Error" + "\t" + "O Listener não identificou o SID utilizado no descritor de conexão.");
                } else if(e.toString().contains("java.sql.SQLException: ORA-01017: invalid username/password; logon denied") || e.toString().contains("Access denied for user")){
                    JOptionPane.showMessageDialog(null, "Nome de usuário/senha incorreto. Tente novamente.","Erro",JOptionPane.ERROR_MESSAGE);
                    System.out.println(getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "OpenConnection" + "\t\t" + "ObjMgrSqlLog" + "\t" + "Error" + "\t" + "Nome de usuário/senha incorreto. Tente novamente.");
                } else if(e.toString().contains("java.sql.SQLRecoverableException: Erro de ES: Unknown host specified")){
                    JOptionPane.showMessageDialog(null, "Erro ao tentar realizar conexão com o Banco de dados. Verifique o Host.","Erro",JOptionPane.ERROR_MESSAGE);
                    System.out.println(getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "OpenConnection" + "\t\t" + "ObjMgrSqlLog" + "\t" + "Error" + "\t" + "Erro ao tentar realizar conexão com o Banco de dados. Verifique o Host.");
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco de dados!\n" + e,"Erro",JOptionPane.ERROR_MESSAGE);
                    System.out.println(getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "OpenConnection" + "\t\t" + "ObjMgrSqlLog" + "\t" + "Error" + "\t" + "Erro ao conectar com o banco de dados! Erro: " + e);
                }
            }            
            return e.toString();
        }
    }
    
    public String closeConnection(String message){
        try {
            Class.forName(getDbDriver());
        } catch (ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, exc.getDbODBCEx()+ "\n" + exc.getMsgReturn() + e,"Erro",JOptionPane.ERROR_MESSAGE);
        }
        try {
            conn.close();
            System.out.println(getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "CloseConnection" + "\t\t" + "ObjMgrSqlLog" + "\t" + "Oracle JDBC Driver Registered. Disconnected Successfuly" + "\t\t" + message + "\n");
            return "true";
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, exc.getDbDisconnectEx() + "\n" + exc.getMsgReturn() + e,"Erro",JOptionPane.ERROR_MESSAGE);
            return "false";
        }
    }    
    
    private class testDbConnection implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if(testDbConnection()){
                JOptionPane.showMessageDialog(null, "Conexão testada com Sucesso!\n", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
                dbSetScreen.setbtnSaveDBParamEnabled(true);
            } else {
                dbSetScreen.setbtnSaveDBParamEnabled(false);
            }
        }
        
    }
    
    private class saveDbParameters implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if(saveDbParameters()){
                dbSetScreen.setbtnSaveDBParamEnabled(false);
                dbSetScreen.dispose();
                //if(firstSettings){
                    firstSettingsOK = true;
                //}
            } else {
                dbSetScreen.setbtnSaveDBParamEnabled(true);
            }
        }        
    }
    
    private class chooseDriverType implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent ie) {
            if(dbSetScreen.getcbbDriver() != null) {
                switch(dbSetScreen.getcbbDriver()){
                    case "ORACLE SQL":
                        dbSetScreen.setCbbDriverNameItemIndex(dbSetScreen.getCbbDriverNameItemIndex("SID"));
                        dbSetScreen.settxtURL("jdbc:oracle:thin:@");
                        dbSetScreen.settxtLocal("localhost");
                        dbSetScreen.settxtPort("1521");
                        dbSetScreen.settxtDBName("PDV");
                        dbSetScreen.settxtOwner("PDV");
                        break;
                    case "MySQL":
                        dbSetScreen.setCbbDriverNameItemIndex(dbSetScreen.getCbbDriverNameItemIndex("Service Name"));
                        dbSetScreen.settxtURL("jdbc:mysql:");
                        dbSetScreen.settxtLocal("localhost");
                        dbSetScreen.settxtPort("3306");
                        dbSetScreen.settxtDBName("PDV");
                        dbSetScreen.settxtOwner("PDV");
                        break;
                    default:
                        dbSetScreen.setCbbDriverNameItemIndex(dbSetScreen.getCbbDriverNameItemIndex("SID"));
                        dbSetScreen.settxtURL("jdbc:oracle:thin:@");
                        dbSetScreen.settxtLocal("localhost");
                        dbSetScreen.settxtPort("1521");
                        dbSetScreen.settxtDBName("PDV");
                        dbSetScreen.settxtOwner("PDV");
                        break;
                }
            }
        }
        
    }

}