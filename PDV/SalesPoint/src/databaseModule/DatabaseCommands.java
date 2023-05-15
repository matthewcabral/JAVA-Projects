/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseModule;

import java.util.ArrayList;

/**
 *
 * @author mathe
 */
public class DatabaseCommands extends DataController {

    public DatabaseCommands() throws InterruptedException { }
    
    public ArrayList<GenericCommandClass> getCreateUser(String user, String password) {
        GenericCommandClass generic;
        ArrayList<GenericCommandClass> insertArray = new ArrayList<>();
        
        generic = new GenericCommandClass();
        generic.setSqlCommand("CREATE USER \"" + user + "\" IDENTIFIED BY \"" + password + "\"\nDEFAULT TABLESPACE \"USERS\"\nTEMPORARY TABLESPACE \"TEMP\"\n");
        insertArray.add(generic);
        
        return insertArray;
    }
    
    public ArrayList<GenericCommandClass> getUserGrants(String user, String position, boolean admin) {
        GenericCommandClass generic;
        ArrayList<GenericCommandClass> insertArray = new ArrayList<>();
        String permissionName = "";
        String permissionFlag = "";
        
        ArrayList<PositionPerClass> permList = queryPostnPermissionRecord("SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblPositionPermition() + " PER\nWHERE PER.PAR_ROW_ID = '" + super.getPositionIdByName(position) + "'\nAND PER.PERMITION_NAME LIKE 'USER%'\nORDER BY PER.PERMITION_NAME ASC");
        
        if(permList.size() > 0) {
            for(int i = 0; i < permList.size(); i++) {
                permissionName = permList.get(i).getPERMITION_NAME();
                permissionFlag = permList.get(i).getPERMITION_FLG();
                
                if(permissionName.contains("USER")){
                    if(permissionName.contains("INSERT")){
                        if("Y".equals(permissionFlag)) {
                            if(super.getDbDriver().toUpperCase().contains("ORACLE")){
                                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT CREATE USER TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT BECOME USER TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                            }
                        }
                    }
                    if(permissionName.contains("UPDATE")){
                        if("Y".equals(permissionFlag)) {
                            if(super.getDbDriver().toUpperCase().contains("ORACLE")){
                                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT ALTER USER TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                            }
                        }
                    }
                    if(permissionName.contains("DELETE")){
                        if("Y".equals(permissionFlag)) {
                            if(super.getDbDriver().toUpperCase().contains("ORACLE")){
                                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT DROP USER TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                            }
                        }
                    }
                }
            }
        }
        
        if(super.getDbDriver().toUpperCase().contains("ORACLE")){
            // -- TABLE BASICS
            generic = new GenericCommandClass(); generic.setSqlCommand("GRANT SELECT ANY TABLE TO \"" + user + "\"" + "\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("GRANT INSERT ANY TABLE TO \"" + user + "\"" + "\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("GRANT UPDATE ANY TABLE TO \"" + user + "\"" + "\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("GRANT DELETE ANY TABLE TO \"" + user + "\"" + "\n"); insertArray.add(generic);
            
            // -- SESSION
            generic = new GenericCommandClass(); generic.setSqlCommand("GRANT CREATE SESSION TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("GRANT RESTRICTED SESSION TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
        }
        
        if("Administrador".equals(position)){                
            if(super.getDbDriver().toUpperCase().contains("ORACLE")){
                // -- DATABASE
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT IMPORT FULL DATABASE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT EXPORT FULL DATABASE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT ALTER DATABASE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);

                // -- TABLE ADVANCED ADMINSTRATION
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT CREATE TABLE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT CREATE ANY TABLE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT ALTER ANY TABLE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT DROP ANY TABLE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT UNDER ANY TABLE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT FLASHBACK ANY TABLE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT BACKUP ANY TABLE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT LOCK ANY TABLE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT COMMENT ANY TABLE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);

                // -- VIEW
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT MERGE ANY VIEW TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT CREATE VIEW TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT DROP ANY VIEW TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT UNDER ANY VIEW TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT CREATE ANY VIEW TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);

                // -- MATERIALIZED VIEW
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT CREATE MATERIALIZED VIEW TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT ALTER ANY MATERIALIZED VIEW TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT DROP ANY MATERIALIZED VIEW TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT CREATE ANY MATERIALIZED VIEW TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);

                // -- JOB
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT CREATE JOB TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT CREATE EXTERNAL JOB TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT CREATE ANY JOB TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);

                // -- TRIGGER
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT DROP ANY TRIGGER TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT CREATE TRIGGER TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT ADMINISTER DATABASE TRIGGER TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT ALTER ANY TRIGGER TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT CREATE ANY TRIGGER TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);

                // -- SEQUENCE
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT CREATE SEQUENCE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT CREATE ANY SEQUENCE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT DROP ANY SEQUENCE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT ALTER ANY SEQUENCE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT SELECT ANY SEQUENCE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);

                // -- LINK
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT CREATE PUBLIC DATABASE LINK TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT ALTER PUBLIC DATABASE LINK TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT CREATE DATABASE LINK TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT ALTER DATABASE LINK TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT DROP PUBLIC DATABASE LINK TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);

                // -- INDEX
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT CREATE ANY INDEX TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT ALTER ANY INDEX TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT DROP ANY INDEX TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);

                // -- PROCEDURE
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT CREATE PROCEDURE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT CREATE ANY PROCEDURE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT ALTER ANY PROCEDURE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT EXECUTE ANY PROCEDURE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT DROP ANY PROCEDURE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT DEBUG ANY PROCEDURE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);

                // -- ROLE
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT CREATE ROLE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT ALTER ANY ROLE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT DROP ANY ROLE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT GRANT ANY ROLE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);

                // -- RULE
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT CREATE RULE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT DROP ANY RULE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT CREATE ANY RULE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT EXECUTE ANY RULE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT ALTER ANY RULE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);

                // -- CONTEXT
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT DROP ANY CONTEXT TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT CREATE ANY CONTEXT TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);

                // -- EVALUATION CONTEXT
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT CREATE EVALUATION CONTEXT TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT CREATE ANY EVALUATION CONTEXT TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT ALTER ANY EVALUATION CONTEXT TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT DROP ANY EVALUATION CONTEXT TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT EXECUTE ANY EVALUATION CONTEXT TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);

                // -- FILE GROUP
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT MANAGE ANY FILE GROUP TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT MANAGE FILE GROUP TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT READ ANY FILE GROUP TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);

                // -- PROFILE
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT CREATE ANY SQL PROFILE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT ALTER ANY SQL PROFILE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT DROP ANY SQL PROFILE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT CREATE PROFILE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT ALTER PROFILE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT DROP PROFILE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);

                // -- LIBRARY
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT CREATE LIBRARY TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT DROP ANY LIBRARY TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT EXECUTE ANY LIBRARY TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT ALTER ANY LIBRARY TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT CREATE ANY LIBRARY TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);

                // -- SEGMENT
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT DROP ROLLBACK SEGMENT TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT CREATE ROLLBACK SEGMENT TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT ALTER ROLLBACK SEGMENT TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);

                // -- CUBE
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT CREATE CUBE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT CREATE ANY CUBE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT ALTER ANY CUBE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT DROP ANY CUBE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT SELECT ANY CUBE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT UPDATE ANY CUBE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);

                // -- ASSEMBLY
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT CREATE ASSEMBLY TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT ALTER ANY ASSEMBLY TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT EXECUTE ASSEMBLY TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT EXECUTE ANY ASSEMBLY TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT DROP ANY ASSEMBLY TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT CREATE ANY ASSEMBLY TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);

                // -- EDITION
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT ALTER ANY EDITION TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT CREATE ANY EDITION TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT DROP ANY EDITION TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);

                // -- MEASURE FOLDER
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT DROP ANY MEASURE FOLDER TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT CREATE ANY MEASURE FOLDER TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT CREATE MEASURE FOLDER TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT INSERT ANY MEASURE FOLDER TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT DELETE ANY MEASURE FOLDER TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);

                // -- OUTLINE
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT ALTER ANY OUTLINE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT DROP ANY OUTLINE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT CREATE ANY OUTLINE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);

                // -- INDEXTYPE
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT EXECUTE ANY INDEXTYPE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT CREATE INDEXTYPE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT CREATE ANY INDEXTYPE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT ALTER ANY INDEXTYPE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT DROP ANY INDEXTYPE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);

                // -- DIRECTORY
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT CREATE ANY DIRECTORY TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT DROP ANY DIRECTORY TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);

                // -- RULE SET
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT ALTER ANY RULE SET TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT EXECUTE ANY RULE SET TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT DROP ANY RULE SET TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT CREATE ANY RULE SET TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT CREATE RULE SET TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);

                // -- MINING MODEL
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT ALTER ANY MINING MODEL TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT CREATE ANY MINING MODEL TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT SELECT ANY MINING MODEL TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT DROP ANY MINING MODEL TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT COMMENT ANY MINING MODEL TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT CREATE MINING MODEL TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);

                // -- SESSION
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT DEBUG CONNECT SESSION TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT ALTER SESSION TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);

                // -- DIMENSION
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT CREATE DIMENSION TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT DELETE ANY CUBE DIMENSION TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT SELECT ANY CUBE DIMENSION TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT CREATE ANY DIMENSION TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT DROP ANY DIMENSION TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT INSERT ANY CUBE DIMENSION TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT ALTER ANY CUBE DIMENSION TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT CREATE ANY CUBE DIMENSION TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT UPDATE ANY CUBE DIMENSION TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT ALTER ANY DIMENSION TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT DROP ANY CUBE DIMENSION TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT CREATE CUBE DIMENSION TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);

                // -- TABLESPACE
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT MANAGE TABLESPACE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT CREATE TABLESPACE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT ALTER TABLESPACE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT UNLIMITED TABLESPACE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT DROP TABLESPACE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);

                // -- BUILD PROCESS
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT CREATE CUBE BUILD PROCESS TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT CREATE ANY CUBE BUILD PROCESS TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT UPDATE ANY CUBE BUILD PROCESS TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT DROP ANY CUBE BUILD PROCESS TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);

                // -- OPERATOR
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT CREATE OPERATOR TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT DROP ANY OPERATOR TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT CREATE ANY OPERATOR TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT EXECUTE ANY OPERATOR TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT ALTER ANY OPERATOR TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);

                // -- SYSTEM
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT AUDIT SYSTEM TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT ALTER SYSTEM TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);

                // -- QUEUE
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT MANAGE ANY QUEUE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT DEQUEUE ANY QUEUE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT ENQUEUE ANY QUEUE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);

                // -- PRIVILEGE
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT GRANT ANY OBJECT PRIVILEGE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT GRANT ANY PRIVILEGE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);

                // -- TRANSACTION
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT FORCE ANY TRANSACTION TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT SELECT ANY TRANSACTION TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT FORCE TRANSACTION TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);

                // -- CLUSTER
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT ALTER ANY CLUSTER TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT CREATE CLUSTER TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT DROP ANY CLUSTER TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT CREATE ANY CLUSTER TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);

                // -- CLASS
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT EXECUTE ANY CLASS TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);

                // -- ANY
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT AUDIT ANY TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT ANALYZE ANY TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);

                // -- TYPE
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT CREATE TYPE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT CREATE ANY TYPE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT DROP ANY TYPE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT EXECUTE ANY TYPE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT ALTER ANY TYPE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT UNDER ANY TYPE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);

                // -- DICTIONARY
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT SELECT ANY DICTIONARY TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT ANALYZE ANY DICTIONARY TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);

                // -- SYNONYM
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT CREATE PUBLIC SYNONYM TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT CREATE ANY SYNONYM TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT DROP ANY SYNONYM TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT CREATE SYNONYM TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT DROP PUBLIC SYNONYM TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);

                // -- POLICY
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT EXEMPT IDENTITY POLICY TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT EXEMPT ACCESS POLICY TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);

                // -- QUERY REWRITE
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT GLOBAL QUERY REWRITE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT QUERY REWRITE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);

                // -- SQL TUNING
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT ADMINISTER SQL TUNING SET TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT ADMINISTER ANY SQL TUNING SET TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);

                // -- OTHERS
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT ADVISOR TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT EXECUTE ANY PROGRAM TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT ON COMMIT REFRESH TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT FLASHBACK ARCHIVE ADMINISTER TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT CHANGE NOTIFICATION TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT MANAGE SCHEDULER TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT ADMINISTER SQL MANAGEMENT OBJECT TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT RESUMABLE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
                generic = new GenericCommandClass(); generic.setSqlCommand("GRANT ALTER RESOURCE COST TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n")); insertArray.add(generic);
            }
        }
        return insertArray;
    }
    
    public ArrayList<GenericCommandClass> getDropUser(String user) {
        GenericCommandClass generic;
        ArrayList<GenericCommandClass> insertArray = new ArrayList<>();
        
        generic = new GenericCommandClass();
        generic.setSqlCommand("DROP USER \"" + user + "\"\n");
        insertArray.add(generic);
        
        return insertArray;
    }
    
    public ArrayList<GenericCommandClass> getRevokeUserGrants(String user, String position, boolean active) {
        GenericCommandClass generic;
        ArrayList<GenericCommandClass> insertArray = new ArrayList<>();
        String permissionName = "";
        String permissionFlag = "";
        
        ArrayList<PositionPerClass> permList = queryPostnPermissionRecord("SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblPositionPermition() + " PER\nWHERE PER.PAR_ROW_ID = '" + super.getPositionIdByName(position) + "'\nAND PER.PERMITION_NAME LIKE 'USER%'\nORDER BY PER.PERMITION_NAME ASC");
        
        if(permList.size() > 0) {
            for(int i = 0; i < permList.size(); i++) {
                permissionName = permList.get(i).getPERMITION_NAME();
                permissionFlag = permList.get(i).getPERMITION_FLG();
                
                if(permissionName.contains("USER")){
                    if(permissionName.contains("INSERT")){
                        if(!"Y".equals(permissionFlag)) {
                            if(super.getDbDriver().toUpperCase().contains("ORACLE")){
                                generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE CREATE USER FROM \"" + user + "\"\n"); insertArray.add(generic);
                                generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE BECOME USER FROM \"" + user + "\"\n"); insertArray.add(generic);
                            }
                        }
                    }
                    if(permissionName.contains("UPDATE")){
                        if(!"Y".equals(permissionFlag)) {
                            if(super.getDbDriver().toUpperCase().contains("ORACLE")){
                                generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE ALTER USER FROM \"" + user + "\"\n"); insertArray.add(generic);
                            }
                        }
                    }
                    if(permissionName.contains("DELETE")){
                        if(!"Y".equals(permissionFlag)) {
                            if(super.getDbDriver().toUpperCase().contains("ORACLE")){
                                generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE DROP USER FROM \"" + user + "\"\n"); insertArray.add(generic);
                            }
                        }
                    }
                }
            }
        }
        
        if(!active){
            // -- TABLE BASICS
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE SELECT ANY TABLE FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE INSERT ANY TABLE FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE UPDATE ANY TABLE FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE DELETE ANY TABLE FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE CREATE SESSION FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE RESTRICTED SESSION FROM \"" + user + "\"\n"); insertArray.add(generic);
        }
        
        if(!"Administrador".equals(position)){
            // -- DATABASE
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE IMPORT FULL DATABASE FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE EXPORT FULL DATABASE FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE ALTER DATABASE FROM \"" + user + "\"\n"); insertArray.add(generic);

            // -- TABLE ADVANCED ADMINSTRATION
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE CREATE TABLE FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE CREATE ANY TABLE FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE ALTER ANY TABLE FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE DROP ANY TABLE FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE UNDER ANY TABLE FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE FLASHBACK ANY TABLE FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE BACKUP ANY TABLE FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE LOCK ANY TABLE FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE COMMENT ANY TABLE FROM \"" + user + "\"\n"); insertArray.add(generic);

            // -- VIEW
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE MERGE ANY VIEW FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE CREATE VIEW FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE DROP ANY VIEW FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE UNDER ANY VIEW FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE CREATE ANY VIEW FROM \"" + user + "\"\n"); insertArray.add(generic);

            // -- MATERIALIZED VIEW
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE CREATE MATERIALIZED VIEW FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE ALTER ANY MATERIALIZED VIEW FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE DROP ANY MATERIALIZED VIEW FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE CREATE ANY MATERIALIZED VIEW FROM \"" + user + "\"\n"); insertArray.add(generic);

            // -- JOB
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE CREATE JOB FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE CREATE EXTERNAL JOB FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE CREATE ANY JOB FROM \"" + user + "\"\n"); insertArray.add(generic);

            // -- TRIGGER
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE DROP ANY TRIGGER FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE CREATE TRIGGER FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE ADMINISTER DATABASE TRIGGER FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE ALTER ANY TRIGGER FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE CREATE ANY TRIGGER FROM \"" + user + "\"\n"); insertArray.add(generic);

            // -- SEQUENCE
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE CREATE SEQUENCE FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE CREATE ANY SEQUENCE FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE DROP ANY SEQUENCE FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE ALTER ANY SEQUENCE FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE SELECT ANY SEQUENCE FROM \"" + user + "\"\n"); insertArray.add(generic);

            // -- LINK
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE CREATE PUBLIC DATABASE LINK FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE ALTER PUBLIC DATABASE LINK FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE CREATE DATABASE LINK FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE ALTER DATABASE LINK FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE DROP PUBLIC DATABASE LINK FROM \"" + user + "\"\n"); insertArray.add(generic);

            // -- INDEX
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE CREATE ANY INDEX FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE ALTER ANY INDEX FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE DROP ANY INDEX FROM \"" + user + "\"\n"); insertArray.add(generic);

            // -- PROCEDURE
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE CREATE PROCEDURE FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE CREATE ANY PROCEDURE FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE ALTER ANY PROCEDURE FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE EXECUTE ANY PROCEDURE FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE DROP ANY PROCEDURE FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE DEBUG ANY PROCEDURE FROM \"" + user + "\"\n"); insertArray.add(generic);

            // -- ROLE
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE CREATE ROLE FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE ALTER ANY ROLE FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE DROP ANY ROLE FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE GRANT ANY ROLE FROM \"" + user + "\"\n"); insertArray.add(generic);

            // -- RULE
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE CREATE RULE FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE DROP ANY RULE FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE CREATE ANY RULE FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE EXECUTE ANY RULE FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE ALTER ANY RULE FROM \"" + user + "\"\n"); insertArray.add(generic);

            // -- CONTEXT
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE DROP ANY CONTEXT FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE CREATE ANY CONTEXT FROM \"" + user + "\"\n"); insertArray.add(generic);

            // -- EVALUATION CONTEXT
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE CREATE EVALUATION CONTEXT FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE CREATE ANY EVALUATION CONTEXT FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE ALTER ANY EVALUATION CONTEXT FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE DROP ANY EVALUATION CONTEXT FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE EXECUTE ANY EVALUATION CONTEXT FROM \"" + user + "\"\n"); insertArray.add(generic);

            // -- FILE GROUP
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE MANAGE ANY FILE GROUP FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE MANAGE FILE GROUP FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE READ ANY FILE GROUP FROM \"" + user + "\"\n"); insertArray.add(generic);

            // -- PROFILE
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE CREATE ANY SQL PROFILE FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE ALTER ANY SQL PROFILE FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE DROP ANY SQL PROFILE FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE CREATE PROFILE FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE ALTER PROFILE FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE DROP PROFILE FROM \"" + user + "\"\n"); insertArray.add(generic);

            // -- LIBRARY
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE CREATE LIBRARY FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE DROP ANY LIBRARY FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE EXECUTE ANY LIBRARY FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE ALTER ANY LIBRARY FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE CREATE ANY LIBRARY FROM \"" + user + "\"\n"); insertArray.add(generic);

            // -- SEGMENT
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE DROP ROLLBACK SEGMENT FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE CREATE ROLLBACK SEGMENT FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE ALTER ROLLBACK SEGMENT FROM \"" + user + "\"\n"); insertArray.add(generic);

            // -- CUBE
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE CREATE CUBE FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE CREATE ANY CUBE FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE ALTER ANY CUBE FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE DROP ANY CUBE FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE SELECT ANY CUBE FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE UPDATE ANY CUBE FROM \"" + user + "\"\n"); insertArray.add(generic);

            // -- ASSEMBLY
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE CREATE ASSEMBLY FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE ALTER ANY ASSEMBLY FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE EXECUTE ASSEMBLY FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE EXECUTE ANY ASSEMBLY FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE DROP ANY ASSEMBLY FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE CREATE ANY ASSEMBLY FROM \"" + user + "\"\n"); insertArray.add(generic);

            // -- EDITION
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE ALTER ANY EDITION FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE CREATE ANY EDITION FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE DROP ANY EDITION FROM \"" + user + "\"\n"); insertArray.add(generic);

            // -- MEASURE FOLDER
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE DROP ANY MEASURE FOLDER FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE CREATE ANY MEASURE FOLDER FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE CREATE MEASURE FOLDER FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE INSERT ANY MEASURE FOLDER FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE DELETE ANY MEASURE FOLDER FROM \"" + user + "\"\n"); insertArray.add(generic);

            // -- OUTLINE
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE ALTER ANY OUTLINE FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE DROP ANY OUTLINE FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE CREATE ANY OUTLINE FROM \"" + user + "\"\n"); insertArray.add(generic);

            // -- INDEXTYPE
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE EXECUTE ANY INDEXTYPE FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE CREATE INDEXTYPE FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE CREATE ANY INDEXTYPE FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE ALTER ANY INDEXTYPE FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE DROP ANY INDEXTYPE FROM \"" + user + "\"\n"); insertArray.add(generic);

            // -- DIRECTORY
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE CREATE ANY DIRECTORY FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE DROP ANY DIRECTORY FROM \"" + user + "\"\n"); insertArray.add(generic);

            // -- RULE SET
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE ALTER ANY RULE SET FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE EXECUTE ANY RULE SET FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE DROP ANY RULE SET FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE CREATE ANY RULE SET FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE CREATE RULE SET FROM \"" + user + "\"\n"); insertArray.add(generic);

            // -- MINING MODEL
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE ALTER ANY MINING MODEL FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE CREATE ANY MINING MODEL FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE SELECT ANY MINING MODEL FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE DROP ANY MINING MODEL FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE COMMENT ANY MINING MODEL FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE CREATE MINING MODEL FROM \"" + user + "\"\n"); insertArray.add(generic);

            // -- SESSION
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE DEBUG CONNECT SESSION FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE ALTER SESSION FROM \"" + user + "\"\n"); insertArray.add(generic);

            // -- DIMENSION
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE CREATE DIMENSION FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE DELETE ANY CUBE DIMENSION FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE SELECT ANY CUBE DIMENSION FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE CREATE ANY DIMENSION FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE DROP ANY DIMENSION FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE INSERT ANY CUBE DIMENSION FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE ALTER ANY CUBE DIMENSION FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE CREATE ANY CUBE DIMENSION FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE UPDATE ANY CUBE DIMENSION FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE ALTER ANY DIMENSION FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE DROP ANY CUBE DIMENSION FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE CREATE CUBE DIMENSION FROM \"" + user + "\"\n"); insertArray.add(generic);

            // -- TABLESPACE
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE MANAGE TABLESPACE FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE CREATE TABLESPACE FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE ALTER TABLESPACE FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE UNLIMITED TABLESPACE FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE DROP TABLESPACE FROM \"" + user + "\"\n"); insertArray.add(generic);

            // -- BUILD PROCESS
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE CREATE CUBE BUILD PROCESS FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE CREATE ANY CUBE BUILD PROCESS FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE UPDATE ANY CUBE BUILD PROCESS FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE DROP ANY CUBE BUILD PROCESS FROM \"" + user + "\"\n"); insertArray.add(generic);

            // -- OPERATOR
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE CREATE OPERATOR FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE DROP ANY OPERATOR FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE CREATE ANY OPERATOR FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE EXECUTE ANY OPERATOR FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE ALTER ANY OPERATOR FROM \"" + user + "\"\n"); insertArray.add(generic);

            // -- SYSTEM
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE AUDIT SYSTEM FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE ALTER SYSTEM FROM \"" + user + "\"\n"); insertArray.add(generic);

            // -- QUEUE
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE MANAGE ANY QUEUE FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE DEQUEUE ANY QUEUE FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE ENQUEUE ANY QUEUE FROM \"" + user + "\"\n"); insertArray.add(generic);

            // -- PRIVILEGE
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE GRANT ANY OBJECT PRIVILEGE FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE GRANT ANY PRIVILEGE FROM \"" + user + "\"\n"); insertArray.add(generic);

            // -- TRANSACTION
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE FORCE ANY TRANSACTION FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE SELECT ANY TRANSACTION FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE FORCE TRANSACTION FROM \"" + user + "\"\n"); insertArray.add(generic);

            // -- CLUSTER
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE ALTER ANY CLUSTER FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE CREATE CLUSTER FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE DROP ANY CLUSTER FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE CREATE ANY CLUSTER FROM \"" + user + "\"\n"); insertArray.add(generic);

            // -- CLASS
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE EXECUTE ANY CLASS FROM \"" + user + "\"\n"); insertArray.add(generic);

            // -- ANY
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE AUDIT ANY FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE ANALYZE ANY FROM \"" + user + "\"\n"); insertArray.add(generic);

            // -- TYPE
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE CREATE TYPE FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE CREATE ANY TYPE FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE DROP ANY TYPE FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE EXECUTE ANY TYPE FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE ALTER ANY TYPE FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE UNDER ANY TYPE FROM \"" + user + "\"\n"); insertArray.add(generic);

            // -- DICTIONARY
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE SELECT ANY DICTIONARY FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE ANALYZE ANY DICTIONARY FROM \"" + user + "\"\n"); insertArray.add(generic);

            // -- SYNONYM
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE CREATE PUBLIC SYNONYM FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE CREATE ANY SYNONYM FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE DROP ANY SYNONYM FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE CREATE SYNONYM FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE DROP PUBLIC SYNONYM FROM \"" + user + "\"\n"); insertArray.add(generic);

            // -- POLICY
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE EXEMPT IDENTITY POLICY FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE EXEMPT ACCESS POLICY FROM \"" + user + "\"\n"); insertArray.add(generic);

            // -- QUERY REWRITE
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE GLOBAL QUERY REWRITE FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE QUERY REWRITE FROM \"" + user + "\"\n"); insertArray.add(generic);

            // -- SQL TUNING
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE ADMINISTER SQL TUNING SET FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE ADMINISTER ANY SQL TUNING SET FROM \"" + user + "\"\n"); insertArray.add(generic);

            // -- OTHERS
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE ADVISOR FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE EXECUTE ANY PROGRAM FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE ON COMMIT REFRESH FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE FLASHBACK ARCHIVE ADMINISTER FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE CHANGE NOTIFICATION FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE MANAGE SCHEDULER FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE ADMINISTER SQL MANAGEMENT OBJECT FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE RESUMABLE FROM \"" + user + "\"\n"); insertArray.add(generic);
            generic = new GenericCommandClass(); generic.setSqlCommand("REVOKE ALTER RESOURCE COST FROM \"" + user + "\"\n"); insertArray.add(generic);
        }
        
        return insertArray;
    }
    
}