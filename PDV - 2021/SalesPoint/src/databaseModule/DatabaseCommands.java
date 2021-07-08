/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseModule;

/**
 *
 * @author mathe
 */
public class DatabaseCommands {
        
    public String getCreateUser(String user, String password) {
        String command = "CREATE USER \"" + user + "\" IDENTIFIED BY \"" + password + "\"\n";
        command += "DEFAULT TABLESPACE \"USERS\"\n";
        command += "TEMPORARY TABLESPACE \"TEMP\"\n";
        
        return command;
    }
    
    public String getUserGrants(String user, String position, boolean admin){
        String command = "";
        // -- DATABASE
        command += "GRANT IMPORT FULL DATABASE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT EXPORT FULL DATABASE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT ALTER DATABASE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");

        // -- USER
        command += "GRANT CREATE USER TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT ALTER USER TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT DROP USER TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT BECOME USER TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");

        // -- TABLE BASICS
        command += "GRANT SELECT ANY TABLE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT INSERT ANY TABLE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT UPDATE ANY TABLE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT DELETE ANY TABLE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        
        // -- TABLE ADVANCED ADMINSTRATION
        command += "GRANT CREATE TABLE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT CREATE ANY TABLE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT ALTER ANY TABLE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT DROP ANY TABLE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT UNDER ANY TABLE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT FLASHBACK ANY TABLE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT BACKUP ANY TABLE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT LOCK ANY TABLE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT COMMENT ANY TABLE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");

        // -- VIEW
        command += "GRANT MERGE ANY VIEW TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT CREATE VIEW TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT DROP ANY VIEW TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT UNDER ANY VIEW TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT CREATE ANY VIEW TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");

        // -- MATERIALIZED VIEW
        command += "GRANT CREATE MATERIALIZED VIEW TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT ALTER ANY MATERIALIZED VIEW TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT DROP ANY MATERIALIZED VIEW TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT CREATE ANY MATERIALIZED VIEW TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");

        // -- JOB
        command += "GRANT CREATE JOB TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT CREATE EXTERNAL JOB TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT CREATE ANY JOB TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");

        // -- TRIGGER
        command += "GRANT DROP ANY TRIGGER TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT CREATE TRIGGER TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT ADMINISTER DATABASE TRIGGER TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT ALTER ANY TRIGGER TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT CREATE ANY TRIGGER TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");

        // -- SEQUENCE
        command += "GRANT CREATE SEQUENCE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT CREATE ANY SEQUENCE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT DROP ANY SEQUENCE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT ALTER ANY SEQUENCE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT SELECT ANY SEQUENCE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");

        // -- LINK
        command += "GRANT CREATE PUBLIC DATABASE LINK TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT ALTER PUBLIC DATABASE LINK TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT CREATE DATABASE LINK TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT ALTER DATABASE LINK TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT DROP PUBLIC DATABASE LINK TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");

        // -- INDEX
        command += "GRANT CREATE ANY INDEX TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT ALTER ANY INDEX TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT DROP ANY INDEX TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");

        // -- PROCEDURE
        command += "GRANT CREATE PROCEDURE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT CREATE ANY PROCEDURE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT ALTER ANY PROCEDURE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT EXECUTE ANY PROCEDURE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT DROP ANY PROCEDURE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT DEBUG ANY PROCEDURE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");

        // -- ROLE
        command += "GRANT CREATE ROLE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT ALTER ANY ROLE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT DROP ANY ROLE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT GRANT ANY ROLE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");

        // -- RULE
        command += "GRANT CREATE RULE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT DROP ANY RULE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT CREATE ANY RULE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT EXECUTE ANY RULE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT ALTER ANY RULE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");

        // -- CONTEXT
        command += "GRANT DROP ANY CONTEXT TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT CREATE ANY CONTEXT TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");

        // -- EVALUATION CONTEXT
        command += "GRANT CREATE EVALUATION CONTEXT TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT CREATE ANY EVALUATION CONTEXT TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT ALTER ANY EVALUATION CONTEXT TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT DROP ANY EVALUATION CONTEXT TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT EXECUTE ANY EVALUATION CONTEXT TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");

        // -- FILE GROUP
        command += "GRANT MANAGE ANY FILE GROUP TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT MANAGE FILE GROUP TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT READ ANY FILE GROUP TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");

        // -- PROFILE
        command += "GRANT CREATE ANY SQL PROFILE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT ALTER ANY SQL PROFILE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT DROP ANY SQL PROFILE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT CREATE PROFILE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT ALTER PROFILE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT DROP PROFILE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");

        // -- LIBRARY
        command += "GRANT CREATE LIBRARY TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT DROP ANY LIBRARY TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT EXECUTE ANY LIBRARY TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT ALTER ANY LIBRARY TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT CREATE ANY LIBRARY TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");

        // -- SEGMENT
        command += "GRANT DROP ROLLBACK SEGMENT TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT CREATE ROLLBACK SEGMENT TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT ALTER ROLLBACK SEGMENT TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");

        // -- CUBE
        command += "GRANT CREATE CUBE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT CREATE ANY CUBE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT ALTER ANY CUBE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT DROP ANY CUBE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT SELECT ANY CUBE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT UPDATE ANY CUBE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");

        // -- ASSEMBLY
        command += "GRANT CREATE ASSEMBLY TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT ALTER ANY ASSEMBLY TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT EXECUTE ASSEMBLY TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT EXECUTE ANY ASSEMBLY TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT DROP ANY ASSEMBLY TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT CREATE ANY ASSEMBLY TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");

        // -- EDITION
        command += "GRANT ALTER ANY EDITION TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT CREATE ANY EDITION TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT DROP ANY EDITION TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");

        // -- MEASURE FOLDER
        command += "GRANT DROP ANY MEASURE FOLDER TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT CREATE ANY MEASURE FOLDER TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT CREATE MEASURE FOLDER TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT INSERT ANY MEASURE FOLDER TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT DELETE ANY MEASURE FOLDER TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");

        // -- OUTLINE
        command += "GRANT ALTER ANY OUTLINE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT DROP ANY OUTLINE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT CREATE ANY OUTLINE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");

        // -- INDEXTYPE
        command += "GRANT EXECUTE ANY INDEXTYPE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT CREATE INDEXTYPE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT CREATE ANY INDEXTYPE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT ALTER ANY INDEXTYPE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT DROP ANY INDEXTYPE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");

        // -- DIRECTORY
        command += "GRANT CREATE ANY DIRECTORY TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT DROP ANY DIRECTORY TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");

        // -- RULE SET
        command += "GRANT ALTER ANY RULE SET TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT EXECUTE ANY RULE SET TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT DROP ANY RULE SET TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT CREATE ANY RULE SET TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT CREATE RULE SET TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");

        // -- MINING MODEL
        command += "GRANT ALTER ANY MINING MODEL TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT CREATE ANY MINING MODEL TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT SELECT ANY MINING MODEL TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT DROP ANY MINING MODEL TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT COMMENT ANY MINING MODEL TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT CREATE MINING MODEL TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");

        // -- SESSION
        command += "GRANT DEBUG CONNECT SESSION TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT ALTER SESSION TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT CREATE SESSION TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT RESTRICTED SESSION TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");

        // -- DIMENSION
        command += "GRANT CREATE DIMENSION TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT DELETE ANY CUBE DIMENSION TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT SELECT ANY CUBE DIMENSION TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT CREATE ANY DIMENSION TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT DROP ANY DIMENSION TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT INSERT ANY CUBE DIMENSION TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT ALTER ANY CUBE DIMENSION TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT CREATE ANY CUBE DIMENSION TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT UPDATE ANY CUBE DIMENSION TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT ALTER ANY DIMENSION TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT DROP ANY CUBE DIMENSION TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT CREATE CUBE DIMENSION TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");

        // -- TABLESPACE
        command += "GRANT MANAGE TABLESPACE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT CREATE TABLESPACE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT ALTER TABLESPACE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT UNLIMITED TABLESPACE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT DROP TABLESPACE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");

        // -- BUILD PROCESS
        command += "GRANT CREATE CUBE BUILD PROCESS TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT CREATE ANY CUBE BUILD PROCESS TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT UPDATE ANY CUBE BUILD PROCESS TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT DROP ANY CUBE BUILD PROCESS TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");

        // -- OPERATOR
        command += "GRANT CREATE OPERATOR TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT DROP ANY OPERATOR TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT CREATE ANY OPERATOR TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT EXECUTE ANY OPERATOR TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT ALTER ANY OPERATOR TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");

        // -- SYSTEM
        command += "GRANT AUDIT SYSTEM TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT ALTER SYSTEM TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");

        // -- QUEUE
        command += "GRANT MANAGE ANY QUEUE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT DEQUEUE ANY QUEUE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT ENQUEUE ANY QUEUE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");

        // -- PRIVILEGE
        command += "GRANT GRANT ANY OBJECT PRIVILEGE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT GRANT ANY PRIVILEGE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");

        // -- TRANSACTION
        command += "GRANT FORCE ANY TRANSACTION TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT SELECT ANY TRANSACTION TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT FORCE TRANSACTION TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");

        // -- CLUSTER
        command += "GRANT ALTER ANY CLUSTER TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT CREATE CLUSTER TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT DROP ANY CLUSTER TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT CREATE ANY CLUSTER TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");

        // -- CLASS
        command += "GRANT EXECUTE ANY CLASS TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");

        // -- ANY
        command += "GRANT AUDIT ANY TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT ANALYZE ANY TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");

        // -- TYPE
        command += "GRANT CREATE TYPE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT CREATE ANY TYPE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT DROP ANY TYPE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT EXECUTE ANY TYPE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT ALTER ANY TYPE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT UNDER ANY TYPE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");

        // -- DICTIONARY
        command += "GRANT SELECT ANY DICTIONARY TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT ANALYZE ANY DICTIONARY TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");

        // -- SYNONYM
        command += "GRANT CREATE PUBLIC SYNONYM TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT CREATE ANY SYNONYM TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT DROP ANY SYNONYM TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT CREATE SYNONYM TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT DROP PUBLIC SYNONYM TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");

        // -- POLICY
        command += "GRANT EXEMPT IDENTITY POLICY TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT EXEMPT ACCESS POLICY TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");

        // -- QUERY REWRITE
        command += "GRANT GLOBAL QUERY REWRITE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT QUERY REWRITE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");

        // -- SQL TUNING
        command += "GRANT ADMINISTER SQL TUNING SET TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT ADMINISTER ANY SQL TUNING SET TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");

        // -- OTHERS
        command += "GRANT ADVISOR TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT EXECUTE ANY PROGRAM TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT ON COMMIT REFRESH TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT FLASHBACK ARCHIVE ADMINISTER TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT CHANGE NOTIFICATION TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT MANAGE SCHEDULER TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT ADMINISTER SQL MANAGEMENT OBJECT TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT RESUMABLE TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        command += "GRANT ALTER RESOURCE COST TO \"" + user + "\"" + ((admin) ? " WITH ADMIN OPTION\n" : "\n");
        
        
        return command;
    }
    
    public String getDropUser(String user) {
        return "DROP USER \"" + user + "\"\n";
    }
    
    public String getRevokeUserGrants(String user){
        String commands = "";
        
        // -- DATABASE
        commands += "REVOKE IMPORT FULL DATABASE FROM \"" + user + "\"\n";
        commands += "REVOKE EXPORT FULL DATABASE FROM \"" + user + "\"\n";
        commands += "REVOKE ALTER DATABASE FROM \"" + user + "\"\n";

        // -- USER
        commands += "REVOKE CREATE USER FROM \"" + user + "\"\n";
        commands += "REVOKE ALTER USER FROM \"" + user + "\"\n";
        commands += "REVOKE DROP USER FROM \"" + user + "\"\n";
        commands += "REVOKE BECOME USER FROM \"" + user + "\"\n";

        // -- TABLE BASICS
        commands += "REVOKE SELECT ANY TABLE FROM \"" + user + "\"\n";
        commands += "REVOKE INSERT ANY TABLE FROM \"" + user + "\"\n";
        commands += "REVOKE UPDATE ANY TABLE FROM \"" + user + "\"\n";
        commands += "REVOKE DELETE ANY TABLE FROM \"" + user + "\"\n";

        // -- TABLE ADVANCED ADMINSTRATION
        commands += "REVOKE CREATE TABLE FROM \"" + user + "\"\n";
        commands += "REVOKE CREATE ANY TABLE FROM \"" + user + "\"\n";
        commands += "REVOKE ALTER ANY TABLE FROM \"" + user + "\"\n";
        commands += "REVOKE DROP ANY TABLE FROM \"" + user + "\"\n";
        commands += "REVOKE UNDER ANY TABLE FROM \"" + user + "\"\n";
        commands += "REVOKE FLASHBACK ANY TABLE FROM \"" + user + "\"\n";
        commands += "REVOKE BACKUP ANY TABLE FROM \"" + user + "\"\n";
        commands += "REVOKE LOCK ANY TABLE FROM \"" + user + "\"\n";
        commands += "REVOKE COMMENT ANY TABLE FROM \"" + user + "\"\n";

        // -- VIEW
        commands += "REVOKE MERGE ANY VIEW FROM \"" + user + "\"\n";
        commands += "REVOKE CREATE VIEW FROM \"" + user + "\"\n";
        commands += "REVOKE DROP ANY VIEW FROM \"" + user + "\"\n";
        commands += "REVOKE UNDER ANY VIEW FROM \"" + user + "\"\n";
        commands += "REVOKE CREATE ANY VIEW FROM \"" + user + "\"\n";

        // -- MATERIALIZED VIEW
        commands += "REVOKE CREATE MATERIALIZED VIEW FROM \"" + user + "\"\n";
        commands += "REVOKE ALTER ANY MATERIALIZED VIEW FROM \"" + user + "\"\n";
        commands += "REVOKE DROP ANY MATERIALIZED VIEW FROM \"" + user + "\"\n";
        commands += "REVOKE CREATE ANY MATERIALIZED VIEW FROM \"" + user + "\"\n";

        // -- JOB
        commands += "REVOKE CREATE JOB FROM \"" + user + "\"\n";
        commands += "REVOKE CREATE EXTERNAL JOB FROM \"" + user + "\"\n";
        commands += "REVOKE CREATE ANY JOB FROM \"" + user + "\"\n";

        // -- TRIGGER
        commands += "REVOKE DROP ANY TRIGGER FROM \"" + user + "\"\n";
        commands += "REVOKE CREATE TRIGGER FROM \"" + user + "\"\n";
        commands += "REVOKE ADMINISTER DATABASE TRIGGER FROM \"" + user + "\"\n";
        commands += "REVOKE ALTER ANY TRIGGER FROM \"" + user + "\"\n";
        commands += "REVOKE CREATE ANY TRIGGER FROM \"" + user + "\"\n";

        // -- SEQUENCE
        commands += "REVOKE CREATE SEQUENCE FROM \"" + user + "\"\n";
        commands += "REVOKE CREATE ANY SEQUENCE FROM \"" + user + "\"\n";
        commands += "REVOKE DROP ANY SEQUENCE FROM \"" + user + "\"\n";
        commands += "REVOKE ALTER ANY SEQUENCE FROM \"" + user + "\"\n";
        commands += "REVOKE SELECT ANY SEQUENCE FROM \"" + user + "\"\n";

        // -- LINK
        commands += "REVOKE CREATE PUBLIC DATABASE LINK FROM \"" + user + "\"\n";
        commands += "REVOKE ALTER PUBLIC DATABASE LINK FROM \"" + user + "\"\n";
        commands += "REVOKE CREATE DATABASE LINK FROM \"" + user + "\"\n";
        commands += "REVOKE ALTER DATABASE LINK FROM \"" + user + "\"\n";
        commands += "REVOKE DROP PUBLIC DATABASE LINK FROM \"" + user + "\"\n";

        // -- INDEX
        commands += "REVOKE CREATE ANY INDEX FROM \"" + user + "\"\n";
        commands += "REVOKE ALTER ANY INDEX FROM \"" + user + "\"\n";
        commands += "REVOKE DROP ANY INDEX FROM \"" + user + "\"\n";

        // -- PROCEDURE
        commands += "REVOKE CREATE PROCEDURE FROM \"" + user + "\"\n";
        commands += "REVOKE CREATE ANY PROCEDURE FROM \"" + user + "\"\n";
        commands += "REVOKE ALTER ANY PROCEDURE FROM \"" + user + "\"\n";
        commands += "REVOKE EXECUTE ANY PROCEDURE FROM \"" + user + "\"\n";
        commands += "REVOKE DROP ANY PROCEDURE FROM \"" + user + "\"\n";
        commands += "REVOKE DEBUG ANY PROCEDURE FROM \"" + user + "\"\n";

        // -- ROLE
        commands += "REVOKE CREATE ROLE FROM \"" + user + "\"\n";
        commands += "REVOKE ALTER ANY ROLE FROM \"" + user + "\"\n";
        commands += "REVOKE DROP ANY ROLE FROM \"" + user + "\"\n";
        commands += "REVOKE GRANT ANY ROLE FROM \"" + user + "\"\n";

        // -- RULE
        commands += "REVOKE CREATE RULE FROM \"" + user + "\"\n";
        commands += "REVOKE DROP ANY RULE FROM \"" + user + "\"\n";
        commands += "REVOKE CREATE ANY RULE FROM \"" + user + "\"\n";
        commands += "REVOKE EXECUTE ANY RULE FROM \"" + user + "\"\n";
        commands += "REVOKE ALTER ANY RULE FROM \"" + user + "\"\n";

        // -- CONTEXT
        commands += "REVOKE DROP ANY CONTEXT FROM \"" + user + "\"\n";
        commands += "REVOKE CREATE ANY CONTEXT FROM \"" + user + "\"\n";

        // -- EVALUATION CONTEXT
        commands += "REVOKE CREATE EVALUATION CONTEXT FROM \"" + user + "\"\n";
        commands += "REVOKE CREATE ANY EVALUATION CONTEXT FROM \"" + user + "\"\n";
        commands += "REVOKE ALTER ANY EVALUATION CONTEXT FROM \"" + user + "\"\n";
        commands += "REVOKE DROP ANY EVALUATION CONTEXT FROM \"" + user + "\"\n";
        commands += "REVOKE EXECUTE ANY EVALUATION CONTEXT FROM \"" + user + "\"\n";

        // -- FILE GROUP
        commands += "REVOKE MANAGE ANY FILE GROUP FROM \"" + user + "\"\n";
        commands += "REVOKE MANAGE FILE GROUP FROM \"" + user + "\"\n";
        commands += "REVOKE READ ANY FILE GROUP FROM \"" + user + "\"\n";

        // -- PROFILE
        commands += "REVOKE CREATE ANY SQL PROFILE FROM \"" + user + "\"\n";
        commands += "REVOKE ALTER ANY SQL PROFILE FROM \"" + user + "\"\n";
        commands += "REVOKE DROP ANY SQL PROFILE FROM \"" + user + "\"\n";
        commands += "REVOKE CREATE PROFILE FROM \"" + user + "\"\n";
        commands += "REVOKE ALTER PROFILE FROM \"" + user + "\"\n";
        commands += "REVOKE DROP PROFILE FROM \"" + user + "\"\n";

        // -- LIBRARY
        commands += "REVOKE CREATE LIBRARY FROM \"" + user + "\"\n";
        commands += "REVOKE DROP ANY LIBRARY FROM \"" + user + "\"\n";
        commands += "REVOKE EXECUTE ANY LIBRARY FROM \"" + user + "\"\n";
        commands += "REVOKE ALTER ANY LIBRARY FROM \"" + user + "\"\n";
        commands += "REVOKE CREATE ANY LIBRARY FROM \"" + user + "\"\n";

        // -- SEGMENT
        commands += "REVOKE DROP ROLLBACK SEGMENT FROM \"" + user + "\"\n";
        commands += "REVOKE CREATE ROLLBACK SEGMENT FROM \"" + user + "\"\n";
        commands += "REVOKE ALTER ROLLBACK SEGMENT FROM \"" + user + "\"\n";

        // -- CUBE
        commands += "REVOKE CREATE CUBE FROM \"" + user + "\"\n";
        commands += "REVOKE CREATE ANY CUBE FROM \"" + user + "\"\n";
        commands += "REVOKE ALTER ANY CUBE FROM \"" + user + "\"\n";
        commands += "REVOKE DROP ANY CUBE FROM \"" + user + "\"\n";
        commands += "REVOKE SELECT ANY CUBE FROM \"" + user + "\"\n";
        commands += "REVOKE UPDATE ANY CUBE FROM \"" + user + "\"\n";

        // -- ASSEMBLY
        commands += "REVOKE CREATE ASSEMBLY FROM \"" + user + "\"\n";
        commands += "REVOKE ALTER ANY ASSEMBLY FROM \"" + user + "\"\n";
        commands += "REVOKE EXECUTE ASSEMBLY FROM \"" + user + "\"\n";
        commands += "REVOKE EXECUTE ANY ASSEMBLY FROM \"" + user + "\"\n";
        commands += "REVOKE DROP ANY ASSEMBLY FROM \"" + user + "\"\n";
        commands += "REVOKE CREATE ANY ASSEMBLY FROM \"" + user + "\"\n";

        // -- EDITION
        commands += "REVOKE ALTER ANY EDITION FROM \"" + user + "\"\n";
        commands += "REVOKE CREATE ANY EDITION FROM \"" + user + "\"\n";
        commands += "REVOKE DROP ANY EDITION FROM \"" + user + "\"\n";

        // -- MEASURE FOLDER
        commands += "REVOKE DROP ANY MEASURE FOLDER FROM \"" + user + "\"\n";
        commands += "REVOKE CREATE ANY MEASURE FOLDER FROM \"" + user + "\"\n";
        commands += "REVOKE CREATE MEASURE FOLDER FROM \"" + user + "\"\n";
        commands += "REVOKE INSERT ANY MEASURE FOLDER FROM \"" + user + "\"\n";
        commands += "REVOKE DELETE ANY MEASURE FOLDER FROM \"" + user + "\"\n";

        // -- OUTLINE
        commands += "REVOKE ALTER ANY OUTLINE FROM \"" + user + "\"\n";
        commands += "REVOKE DROP ANY OUTLINE FROM \"" + user + "\"\n";
        commands += "REVOKE CREATE ANY OUTLINE FROM \"" + user + "\"\n";

        // -- INDEXTYPE
        commands += "REVOKE EXECUTE ANY INDEXTYPE FROM \"" + user + "\"\n";
        commands += "REVOKE CREATE INDEXTYPE FROM \"" + user + "\"\n";
        commands += "REVOKE CREATE ANY INDEXTYPE FROM \"" + user + "\"\n";
        commands += "REVOKE ALTER ANY INDEXTYPE FROM \"" + user + "\"\n";
        commands += "REVOKE DROP ANY INDEXTYPE FROM \"" + user + "\"\n";

        // -- DIRECTORY
        commands += "REVOKE CREATE ANY DIRECTORY FROM \"" + user + "\"\n";
        commands += "REVOKE DROP ANY DIRECTORY FROM \"" + user + "\"\n";

        // -- RULE SET
        commands += "REVOKE ALTER ANY RULE SET FROM \"" + user + "\"\n";
        commands += "REVOKE EXECUTE ANY RULE SET FROM \"" + user + "\"\n";
        commands += "REVOKE DROP ANY RULE SET FROM \"" + user + "\"\n";
        commands += "REVOKE CREATE ANY RULE SET FROM \"" + user + "\"\n";
        commands += "REVOKE CREATE RULE SET FROM \"" + user + "\"\n";

        // -- MINING MODEL
        commands += "REVOKE ALTER ANY MINING MODEL FROM \"" + user + "\"\n";
        commands += "REVOKE CREATE ANY MINING MODEL FROM \"" + user + "\"\n";
        commands += "REVOKE SELECT ANY MINING MODEL FROM \"" + user + "\"\n";
        commands += "REVOKE DROP ANY MINING MODEL FROM \"" + user + "\"\n";
        commands += "REVOKE COMMENT ANY MINING MODEL FROM \"" + user + "\"\n";
        commands += "REVOKE CREATE MINING MODEL FROM \"" + user + "\"\n";

        // -- SESSION
        commands += "REVOKE DEBUG CONNECT SESSION FROM \"" + user + "\"\n";
        commands += "REVOKE ALTER SESSION FROM \"" + user + "\"\n";
        commands += "REVOKE CREATE SESSION FROM \"" + user + "\"\n";
        commands += "REVOKE RESTRICTED SESSION FROM \"" + user + "\"\n";

        // -- DIMENSION
        commands += "REVOKE CREATE DIMENSION FROM \"" + user + "\"\n";
        commands += "REVOKE DELETE ANY CUBE DIMENSION FROM \"" + user + "\"\n";
        commands += "REVOKE SELECT ANY CUBE DIMENSION FROM \"" + user + "\"\n";
        commands += "REVOKE CREATE ANY DIMENSION FROM \"" + user + "\"\n";
        commands += "REVOKE DROP ANY DIMENSION FROM \"" + user + "\"\n";
        commands += "REVOKE INSERT ANY CUBE DIMENSION FROM \"" + user + "\"\n";
        commands += "REVOKE ALTER ANY CUBE DIMENSION FROM \"" + user + "\"\n";
        commands += "REVOKE CREATE ANY CUBE DIMENSION FROM \"" + user + "\"\n";
        commands += "REVOKE UPDATE ANY CUBE DIMENSION FROM \"" + user + "\"\n";
        commands += "REVOKE ALTER ANY DIMENSION FROM \"" + user + "\"\n";
        commands += "REVOKE DROP ANY CUBE DIMENSION FROM \"" + user + "\"\n";
        commands += "REVOKE CREATE CUBE DIMENSION FROM \"" + user + "\"\n";

        // -- TABLESPACE
        commands += "REVOKE MANAGE TABLESPACE FROM \"" + user + "\"\n";
        commands += "REVOKE CREATE TABLESPACE FROM \"" + user + "\"\n";
        commands += "REVOKE ALTER TABLESPACE FROM \"" + user + "\"\n";
        commands += "REVOKE UNLIMITED TABLESPACE FROM \"" + user + "\"\n";
        commands += "REVOKE DROP TABLESPACE FROM \"" + user + "\"\n";

        // -- BUILD PROCESS
        commands += "REVOKE CREATE CUBE BUILD PROCESS FROM \"" + user + "\"\n";
        commands += "REVOKE CREATE ANY CUBE BUILD PROCESS FROM \"" + user + "\"\n";
        commands += "REVOKE UPDATE ANY CUBE BUILD PROCESS FROM \"" + user + "\"\n";
        commands += "REVOKE DROP ANY CUBE BUILD PROCESS FROM \"" + user + "\"\n";

        // -- OPERATOR
        commands += "REVOKE CREATE OPERATOR FROM \"" + user + "\"\n";
        commands += "REVOKE DROP ANY OPERATOR FROM \"" + user + "\"\n";
        commands += "REVOKE CREATE ANY OPERATOR FROM \"" + user + "\"\n";
        commands += "REVOKE EXECUTE ANY OPERATOR FROM \"" + user + "\"\n";
        commands += "REVOKE ALTER ANY OPERATOR FROM \"" + user + "\"\n";

        // -- SYSTEM
        commands += "REVOKE AUDIT SYSTEM FROM \"" + user + "\"\n";
        commands += "REVOKE ALTER SYSTEM FROM \"" + user + "\"\n";

        // -- QUEUE
        commands += "REVOKE MANAGE ANY QUEUE FROM \"" + user + "\"\n";
        commands += "REVOKE DEQUEUE ANY QUEUE FROM \"" + user + "\"\n";
        commands += "REVOKE ENQUEUE ANY QUEUE FROM \"" + user + "\"\n";

        // -- PRIVILEGE
        commands += "REVOKE GRANT ANY OBJECT PRIVILEGE FROM \"" + user + "\"\n";
        commands += "REVOKE GRANT ANY PRIVILEGE FROM \"" + user + "\"\n";

        // -- TRANSACTION
        commands += "REVOKE FORCE ANY TRANSACTION FROM \"" + user + "\"\n";
        commands += "REVOKE SELECT ANY TRANSACTION FROM \"" + user + "\"\n";
        commands += "REVOKE FORCE TRANSACTION FROM \"" + user + "\"\n";

        // -- CLUSTER
        commands += "REVOKE ALTER ANY CLUSTER FROM \"" + user + "\"\n";
        commands += "REVOKE CREATE CLUSTER FROM \"" + user + "\"\n";
        commands += "REVOKE DROP ANY CLUSTER FROM \"" + user + "\"\n";
        commands += "REVOKE CREATE ANY CLUSTER FROM \"" + user + "\"\n";

        // -- CLASS
        commands += "REVOKE EXECUTE ANY CLASS FROM \"" + user + "\"\n";

        // -- ANY
        commands += "REVOKE AUDIT ANY FROM \"" + user + "\"\n";
        commands += "REVOKE ANALYZE ANY FROM \"" + user + "\"\n";

        // -- TYPE
        commands += "REVOKE CREATE TYPE FROM \"" + user + "\"\n";
        commands += "REVOKE CREATE ANY TYPE FROM \"" + user + "\"\n";
        commands += "REVOKE DROP ANY TYPE FROM \"" + user + "\"\n";
        commands += "REVOKE EXECUTE ANY TYPE FROM \"" + user + "\"\n";
        commands += "REVOKE ALTER ANY TYPE FROM \"" + user + "\"\n";
        commands += "REVOKE UNDER ANY TYPE FROM \"" + user + "\"\n";

        // -- DICTIONARY
        commands += "REVOKE SELECT ANY DICTIONARY FROM \"" + user + "\"\n";
        commands += "REVOKE ANALYZE ANY DICTIONARY FROM \"" + user + "\"\n";

        // -- SYNONYM
        commands += "REVOKE CREATE PUBLIC SYNONYM FROM \"" + user + "\"\n";
        commands += "REVOKE CREATE ANY SYNONYM FROM \"" + user + "\"\n";
        commands += "REVOKE DROP ANY SYNONYM FROM \"" + user + "\"\n";
        commands += "REVOKE CREATE SYNONYM FROM \"" + user + "\"\n";
        commands += "REVOKE DROP PUBLIC SYNONYM FROM \"" + user + "\"\n";

        // -- POLICY
        commands += "REVOKE EXEMPT IDENTITY POLICY FROM \"" + user + "\"\n";
        commands += "REVOKE EXEMPT ACCESS POLICY FROM \"" + user + "\"\n";

        // -- QUERY REWRITE
        commands += "REVOKE GLOBAL QUERY REWRITE FROM \"" + user + "\"\n";
        commands += "REVOKE QUERY REWRITE FROM \"" + user + "\"\n";

        // -- SQL TUNING
        commands += "REVOKE ADMINISTER SQL TUNING SET FROM \"" + user + "\"\n";
        commands += "REVOKE ADMINISTER ANY SQL TUNING SET FROM \"" + user + "\"\n";

        // -- OTHERS
        commands += "REVOKE ADVISOR FROM \"" + user + "\"\n";
        commands += "REVOKE EXECUTE ANY PROGRAM FROM \"" + user + "\"\n";
        commands += "REVOKE ON COMMIT REFRESH FROM \"" + user + "\"\n";
        commands += "REVOKE FLASHBACK ARCHIVE ADMINISTER FROM \"" + user + "\"\n";
        commands += "REVOKE CHANGE NOTIFICATION FROM \"" + user + "\"\n";
        commands += "REVOKE MANAGE SCHEDULER FROM \"" + user + "\"\n";
        commands += "REVOKE ADMINISTER SQL MANAGEMENT OBJECT FROM \"" + user + "\"\n";
        commands += "REVOKE RESUMABLE FROM \"" + user + "\"\n";
        commands += "REVOKE ALTER RESOURCE COST FROM \"" + user + "\"\n";        
        
        return commands;
    }
    
}
