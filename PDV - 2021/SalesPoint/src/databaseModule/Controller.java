/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseModule;

import java.sql.Statement;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    private String columns;
    private String values;
    private String columnsValues;
    private String condition;
    private String orderBy;
    public ArrayList<String> resultQuery;
    
    String pattern = "dd-MM-yyyy HH:mm:ss";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    //String date;
    
    private final String confFile = System.getProperty("user.home") + "\\SalesPoint\\Settings\\db_conf.conf";
    private final String SplitBy = ";";
    
    // Definições das tabelas
    private final String tblUser = "T_USER";
    private final String tblPosition = "T_POSITION";
    private final String tblPositionPermition = "T_POSTN_PER";
    private final String tblAccount = "T_ACCOUNT";
    private final String tblContact = "T_CONTACT";
    private final String tblSocialMedia = "T_CONTACT_X";
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
        this.columns = "";
        this.values = "";
        this.columnsValues = "";
        this.condition = "";
        this.orderBy = "";        
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

    public String getColumns() { return columns; }
    public void setColumns(String columns) { this.columns += columns; }
    public void clearColumns() { this.columns = ""; }

    public String getValues() { return values; }
    public void setValues(String values) { this.values += values; }
    public void clearValues() { this.values = ""; }
    
    public String getColumnsValues() { return columnsValues; }
    public void setColumnsValues(String columnsValues) { this.columnsValues += columnsValues; }
    public void clearColumnsValues() { this.columnsValues = ""; }
    
    public String getCondition() { return condition; }
    public void setCondition(String condition) { this.condition += condition; }
    public void clearCondition() { this.condition = ""; }
    
    public String getOrderBy() { return orderBy; }
    public void setOrderBy(String orderBy) { this.orderBy += orderBy; }
    public void clearOrderBy() { this.orderBy = ""; }
    
    public String getTblUser() { return tblUser; }
    public String getTblPosition() { return tblPosition; }
    public String getTblPositionPermition() { return tblPositionPermition; }
    public String getTblAccount() { return tblAccount; }
    public String getTblContact() { return tblContact; }
    public String getTblSocialMedia() { return tblSocialMedia; }
    public String getTblAddress() { return tblAddress; }
    public String getTblLstOfVal() { return tblLstOfVal; }
    public String getTblOrder() { return tblOrder; }
    public String getTblOrderItem() { return tblOrderItem; }
    public String getTblSSAId() { return tblSSAId; }
    public String getTblValMsg() { return tblValMsg; }

    public String getConfFile() { return confFile; }
    public String getSplitBy() { return SplitBy; }
    
    public String getDateTime() { return simpleDateFormat.format(new Date()); }    
    
    public ArrayList<String> getResultQuery() { return resultQuery; }
    public void setResultQuery(ArrayList<String> resultQuery) { this.resultQuery = resultQuery; }
        
    // Open Database Connection
    public abstract String openConnection(String message);
    
    // Close Database Connection
    public abstract String closeConnection(String message);
    
    public abstract String createUser(String sqlCommand, String user);
    public abstract String insertRecord(String table, String columns, String values);
    public abstract int updateRecord(String table, String columnsValues, String condition);
    public abstract int deleteRecord(String table, String condition);
    public abstract int queryTableCount(String table, String condition);
    public abstract ArrayList<DataController.UserClass> queryUserRecord(String query);
    public abstract ArrayList<DataController.PositionClass> queryPositionRecord(String query);
    public abstract ArrayList<DataController.PositionPerClass> queryPositionPerRecord(String query);
    public abstract ArrayList<DataController.AddressClass> queryAddressRecord(String query);
    public abstract ArrayList<DataController.ContactClass> queryContactRecord(String query);
    public abstract ArrayList<DataController.SocialMediaClass> querySocialMediaRecord(String query);
    public abstract String getNextRowId();
    public abstract String getUserIdByLogin();
    public abstract String getPositionIdByName(String positionType);
    public abstract String LookupValueSubtype(String type, String name, String subtype);
    public abstract String LookupValue(String type, String name);
    public abstract String LookupNameSubtype(String type, String value, String subtype);
    public abstract String LookupName(String type, String value);
    public abstract ArrayList<DataController.ListOfValuesClass> LookupList(String type);
    public abstract ArrayList<DataController.ListOfValuesClass> queryListOfValues(String query);
}
