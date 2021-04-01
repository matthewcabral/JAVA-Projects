/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseModule;

import java.sql.Statement;
import java.sql.Connection;
import java.util.ArrayList;
/**
 *
 * @author Matheus Cabral Rosa
 */
public abstract class Controller {
    // Database Variables
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
    public ArrayList<String> resultQuery;
    
    private final String confFile = System.getProperty("user.home") + "\\SalesPoint\\Settings\\db_conf.conf";
    private final String SplitBy = ";";
    
    // Definições das tabelas
    private final String tblUser = "T_USER";
    private final String tblPosition = "T_POSITION";
    private final String tblUserPermition = "T_USER_PER";
    private final String tblAccount = "T_ACCOUNT";
    private final String tblContact = "T_CONTACT";
    private final String tblContactX = "T_CONTACT_X";
    private final String tblAddress = "T_ADDRESS";
    private final String tblLstOfVal = "T_LST_OF_VAL";
    private final String tblOrder = "T_ORDER";
    private final String tblOrderItem = "T_ORDER_ITEM";
    private final String tblSSAId = "T_SSA_ID";
    private final String tblValMsg = "T_VALDN_MSG";
    
    // Database exceptions list
    exceptionsController exc;
    
    // Empty Constructor
    public Controller() throws InterruptedException {
        exc = new exceptionsController();
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

    public String getTblUser() { return tblUser; }
    public String getTblPosition() { return tblPosition; }
    public String getTblUserPermition() { return tblUserPermition; }
    public String getTblAccount() { return tblAccount; }
    public String getTblContact() { return tblContact; }
    public String getTblContactX() { return tblContactX; }
    public String getTblAddress() { return tblAddress; }
    public String getTblLstOfVal() { return tblLstOfVal; }
    public String getTblOrder() { return tblOrder; }
    public String getTblOrderItem() { return tblOrderItem; }
    public String getTblSSAId() { return tblSSAId; }
    public String getTblValMsg() { return tblValMsg; }

    public String getConfFile() { return confFile; }
    public String getSplitBy() { return SplitBy; }
    
    
    
    public ArrayList<String> getResultQuery() { return resultQuery; }
    public void setResultQuery(ArrayList<String> resultQuery) { this.resultQuery = resultQuery; }
        
    // Open Database Connection
    public abstract String openConnection(String message);
    
    // Close Database Connection
    public abstract String closeConnection(String message);
    
    public abstract String insertRecord(String table, String columns, String values);
    public abstract String updateRecord(String table, String columnsValues, String condition);
    public abstract String deleteRecord(String table, String condition);
    public abstract ArrayList<DataController.UserClass> queryUserRecord(String query);
    public abstract ArrayList<DataController.PositionClass> queryPositionRecord(String query);
    public abstract ArrayList<DataController.UserPermitionClass> queryUserPermitionRecord(String query);
    public abstract ArrayList<DataController.AddressClass> queryAddressRecord(String query);
    public abstract ArrayList<DataController.ContactClass> queryContactRecord(String query);
    public abstract ArrayList<DataController.ContactXClass> queryContactXRecord(String query);
    public abstract String getNextRowId();
    public abstract String LookupValueSubtype(String type, String name, String subtype);
    public abstract String LookupValue(String type, String name);
    public abstract String LookupNameSubtype(String type, String value, String subtype);
    public abstract ArrayList<DataController.ListOfValuesClass> LookupName(String type, String value);
    public abstract ArrayList<DataController.ListOfValuesClass> LookupList(String type);
}
