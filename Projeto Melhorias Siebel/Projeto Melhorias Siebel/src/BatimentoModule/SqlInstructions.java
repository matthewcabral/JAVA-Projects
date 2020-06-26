/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BatimentoModule;

/**
 *
 * @author Matheus Cabral Rosa
 */
public class SqlInstructions {
    
    // Description: This class is used to store the PL/SQL used by Batimento Module
    public String queryCompareRep(String RepOrigemName, String RepDestinoName, String DbLinkOrigem, String DbLinkDestino, String Data, String FilaThreads, String ConfName, String dbOwner){
        return 
            "DECLARE\n" +
                "TYPE tabsplit IS TABLE OF VARCHAR2 (50) INDEX BY BINARY_INTEGER;\n" +
                "\n" +
                "FUNCTION fn_split (mp_string IN VARCHAR2, mp_delimiter IN VARCHAR2)\n" +
                "RETURN tabsplit\n" +
                "IS\n" +
                "ml_point     NUMBER (5, 0) := 1;\n" +
                "ml_sub_str   VARCHAR2 (50);\n" +
                "i            NUMBER (5, 0) := 1;\n" +
                "taboutput    tabsplit;\n" +
                "ml_count     NUMBER (5, 0) := 0;    \n" +
                "BEGIN\n" +
                "WHILE i <= LENGTH (mp_string)\n" +
                "LOOP\n" +
                "FOR j IN i .. LENGTH (mp_string)\n" +
                "LOOP\n" +
                "IF SUBSTR (mp_string, j, 1) = mp_delimiter\n" +
                "THEN\n" +
                "ml_sub_str := SUBSTR (mp_string, ml_point, j - ml_point);\n" +
                "ml_point := j + 1;\n" +
                "i := ml_point;\n" +
                "i := i - 1;\n" +
                "taboutput (ml_count) := ml_sub_str;\n" +
                "ml_count := ml_count + 1;\n" +
                "EXIT;\n" +
                "END IF;\n" +
                "END LOOP;\n" +
                "\n" +
                "i := i + 1;\n" +
                "END LOOP;\n" +
                "\n" +
                "ml_sub_str := SUBSTR (mp_string, ml_point, LENGTH (mp_string));\n" +
                "taboutput (ml_count) := ml_sub_str;\n" +
                "\n" +
                "RETURN taboutput;\n" +
                "END fn_split;\n" +
                "\n" +
                "PROCEDURE EXEC_COMPARE(\n" +
                "V_ORI_REPOSITORY_NAME IN VARCHAR2, \n" +
                "V_DES_REPOSITORY_NAME IN VARCHAR2,\n" +
                "V_DBLINK_ORIG IN VARCHAR2,\n" +
                "V_DBLINK_DEST IN VARCHAR2,\n" +
                "V_DATA IN VARCHAR2,\n" +
                "V_FILA IN NUMBER,\n" +
                "V_CONFIGURATION_NAME IN VARCHAR2\n" +
                ") IS\n" +
                "\n" +
                "\n" +
                "TABOUTPUT   TABSPLIT;\n" +
                "V_QUERY_ORI VARCHAR2(4000);\n" +
                "V_QUERY_DES VARCHAR2(4000);\n" +
                "V_PL CLOB;\n" +
                "--V_PL VARCHAR2(4000 CHAR);\n" +
                "V_SUB_SELECT  VARCHAR2(4000);\n" +
                "V_EXISTS_PARENT  VARCHAR2(4000);\n" +
                "V_PAR_N0 VARCHAR2(1000);\n" +
                "V_PAR_N1 VARCHAR2(1000); \n" +
                "V_PAR_N2 VARCHAR2(1000); \n" +
                "V_PAR_N3 VARCHAR2(1000);\n" +
                "V_SUB_SELECT_PAR_N0 VARCHAR2(4000);\n" +
                "VEXIT CHAR(1);\n" +
                "CONT NUMBER(22):= 0;\n" +
                "VTOTAL_PROCESS NUMBER(10):= 0;\n" +
                "VDATE_START DATE;\n" +
                "VDATE_END DATE;\n" +
                "VID NUMBER(22):=0;\n" +
                "V_VALIDA_LOG NUMBER(22):=0;\n" +
                "V_VALIDA_FIM NUMBER(22):=0;\n" +
                "V_STATUS_MASTER VARCHAR2(100 CHAR);\n" +
                "VMASTER_ID NUMBER(22):=0;\n" +
                "VERROR VARCHAR2(4000 CHAR);\n" +
                "V_OTHER_PARENT_KEY0  VARCHAR2(4000);\n" +
                "V_OTHER_PARENT_KEY1  VARCHAR2(4000);\n" +
                "V_OTHER_PARENT_KEY2  VARCHAR2(4000);\n" +
                "V_OTHER_PARENT_KEY3  VARCHAR2(4000);\n" +
                "V_COL_PAR0  VARCHAR2(4000);\n" +
                "V_COL_PAR1  VARCHAR2(4000);\n" +
                "V_COL_PAR2  VARCHAR2(4000);\n" +
                "V_COL_PAR3  VARCHAR2(4000);\n" +
                "REPLACE_VALOR_DES  VARCHAR2(1000);\n" +
                "REPLACE_VALOR_ORI  VARCHAR2(1000);\n" +
                "VSTATUS VARCHAR2(1000);\n" +
                "\n" +
                "CURSOR C_TABLE IS\n" +
                "SELECT \n" +
                "TBC.TABLE_NAME NAME, \n" +
                "(SELECT T.ROW_ID \n" +
                "FROM SIEBEL.S_TABLE@" + DbLinkOrigem + " T, SIEBEL.S_REPOSITORY@" + DbLinkOrigem + " REP \n" +
                "WHERE T.NAME = TBC.TABLE_NAME \n" +
                "AND REP.NAME = '" + RepOrigemName + "'\n" +
                "AND REP.ROW_ID = T.REPOSITORY_ID \n" +
                "AND ROWNUM < 2) ROW_ID,\n" +
                "(SELECT BC.NAME \n" +
                "FROM SIEBEL.S_BUSCOMP@" + DbLinkOrigem + " BC, SIEBEL.S_REPOSITORY@" + DbLinkOrigem + " REP \n" +
                "WHERE \n" +
                "BC.TABLE_NAME = TBC.TABLE_NAME\n" +
                "AND REP.NAME = '" + RepOrigemName + "'\n" +
                "AND REP.ROW_ID = BC.REPOSITORY_ID \n" +
                "AND ROWNUM < 2) BCNAME,\n" +
                "TBC.JOIN3,\n" +
                "TBC.TAB_P3,\n" +
                "TBC.JOIN2,\n" +
                "TBC.TAB_P2,\n" +
                "TBC.JOIN1,\n" +
                "TBC.TAB_P1,\n" +
                "TBC.JOIN0,\n" +
                "TBC.TAB_P0,\n" +
                "TBC.TYPE,\n" +
                "TBC.DESCRIPTION,\n" +
                "TBC.OTHER_KEY_FIELD,\n" +
                "TBC.ADDITIONAL_SEARCH,\n" +
                "TBC.ID,\n" +
                "TBC.GROUP_OBJECT,\n" +
                "TBC.ORDER_COL,\n" +
                "TBC.CONFIGURATION_NAME\n" +
                "FROM \n" +
                "" + dbOwner + ".TAB_CTRL_BATIMENTO_REP TBC\n" +
                "WHERE \n" +
                "TBC.INACTIVE_FLG = 'N'\n" +
                "AND TBC.FILA = V_FILA\n" +
                "AND TBC.CONFIGURATION_NAME = V_CONFIGURATION_NAME\n" +
                "ORDER BY  TBC.GROUP_OBJECT, TBC.ORDER_COL, TBC.DESCRIPTION ASC;\n" +
                "\n" +
                "CURSOR C_COLUMN (V_TBL_ID VARCHAR2) IS\n" +
                "SELECT  T.NAME TABLE_NAME, \n" +
                "C.NAME COL_NAME, \n" +
                "C.ROW_ID, \n" +
                "(   SELECT F.NAME \n" +
                "FROM SIEBEL.S_FIELD@" + DbLinkOrigem + " F, SIEBEL.S_BUSCOMP@" + DbLinkOrigem + " B \n" +
                "WHERE \n" +
                "F.BUSCOMP_ID = B.ROW_ID \n" +
                "AND B.TABLE_NAME = T.NAME \n" +
                "AND F.COL_NAME = C.NAME \n" +
                "AND ROWNUM < 2\n" +
                ") FIELD_NAME,\n" +
                "(SELECT DATA_TYPE FROM ALL_TAB_COLUMNS@" + DbLinkOrigem + " WHERE COLUMN_NAME = C.NAME AND TABLE_NAME = T.NAME AND ROWNUM < 2) DATA_TYPE\n" +
                "FROM \n" +
                "SIEBEL.S_COLUMN@" + DbLinkOrigem + " C,\n" +
                "SIEBEL.S_TABLE@" + DbLinkOrigem + " T,  \n" +
                "SIEBEL.S_REPOSITORY@" + DbLinkOrigem + " R  \n" +
                "WHERE C.REPOSITORY_ID = R.ROW_ID\n" +
                "AND C.TYPE <> 'System'\n" +
                "AND C.NAME NOT IN ('COMMENTS', 'NAME', 'REPOSITORY_ID', 'OBJ_LOCKED_BY','OBJ_LOCKED_DATE', 'OBJ_LOCKED_FLG', 'OBJ_LOCKED_LANG','REV_NUM', 'PROJECT_ID', 'TO_STEP_ID', 'FROM_STEP_ID', 'LAYOUT', 'AUTO_MAPPED_FLG')\n" +
                "AND T.NAME || '.' || C.NAME NOT IN (SELECT TABELA || '.' || COLUNA FROM " + dbOwner + ".TAB_CTRL_COLUMN_EXCEPTION)\n" +
                "AND C.NAME NOT LIKE '%_ID'\n" +
                "AND R.NAME = '" + RepOrigemName + "'\n" +
                "AND T.ROW_ID = C.TBL_ID\n" +
                "AND C.TBL_ID = V_TBL_ID\n" +
                "AND EXISTS (SELECT 1 FROM ALL_TAB_COLUMNS@" + DbLinkOrigem + " WHERE COLUMN_NAME = C.NAME AND TABLE_NAME = T.NAME AND ROWNUM < 2);\n" +
                "\n" +
                "BEGIN\n" +
                "DBMS_OUTPUT.PUT_LINE('teste9');\n" +
                "SELECT NVL(MAX(ID),0) INTO VID FROM " + dbOwner + ".CTRL_LOG_COMP_REP TUPD \n" +
                "WHERE\n" +
                "FILA = V_FILA\n" +
                "AND TABLE_NAME = 'Pending'\n" +
                "AND ACTUAL_TYPE = 'Pending'\n" +
                "AND ACTUAL_DESCRIPTION = 'Pending'\n" +
                "AND CONFIGURATION_NAME = V_CONFIGURATION_NAME;\n" +
                "\n" +
                "DBMS_OUTPUT.PUT_LINE('teste10 - ' || to_char(VID)|| ' - FILA: '|| TO_CHAR(V_FILA));\n" +
                "IF VID > 0 THEN  \n" +
                "\n" +
                "SELECT TOTAL_PROCESS_TO_EXEC INTO VTOTAL_PROCESS FROM " + dbOwner + ".CTRL_LOG_COMP_REP TUPD \n" +
                "WHERE\n" +
                "TUPD.ID = VID;\n" +
                "DBMS_OUTPUT.PUT_LINE('teste11');\n" +
                "FOR R IN C_TABLE LOOP\n" +
                "\n" +
                "UPDATE " + dbOwner + ".CTRL_LOG_COMP_REP TUPD\n" +
                "SET \n" +
                "TUPD.TOTAL_PROCESS_EXECUTED = VTOTAL_PROCESS,   \n" +
                "TUPD.TABLE_NAME =  TO_CHAR(R.NAME) ,\n" +
                "STATUS = 'QUEUE PROCESSING',\n" +
                "TUPD.ACTUAL_DESCRIPTION =  TO_CHAR(R.DESCRIPTION), \n" +
                "TUPD.ACTUAL_TYPE =  R.TYPE\n" +
                "WHERE TUPD.ID = VID;\n" +
                "COMMIT;\n" +
                "DBMS_OUTPUT.PUT_LINE('teste12');\n" +
                "SELECT MASTER_LOG_COMPARE_ID INTO VMASTER_ID FROM " + dbOwner + ".CTRL_LOG_COMP_REP WHERE ID = VID;\n" +
                "DBMS_OUTPUT.PUT_LINE('teste13');\n" +
                "INSERT INTO " + dbOwner + ".CTRL_LOG_COMP_REP_LOG\n" +
                "(\n" +
                "TABLE_NAME                  ,\n" +
                "CTRL_LOG_COMP_REP_MASTER_ID ,\n" +
                "CTRL_LOG_COMP_REP_ID        ,\n" +
                "TAB_CTRL_BATIMENTO_REP_ID   ,\n" +
                "FILA                        ,\n" +
                "STATUS                      ,\n" +
                "STATUS_DESC                 \n" +
                ") VALUES\n" +
                "(\n" +
                "R.NAME,\n" +
                "VMASTER_ID,\n" +
                "VID,\n" +
                "R.ID,\n" +
                "V_FILA,\n" +
                "'PROCESSING',\n" +
                "''                            \n" +
                ");\n" +
                "COMMIT;\n" +
                "DBMS_OUTPUT.PUT_LINE('teste14');\n" +
                "VTOTAL_PROCESS:= VTOTAL_PROCESS - 1;\n" +
                "\n" +
                "V_SUB_SELECT := '';\n" +
                "V_EXISTS_PARENT := '';\n" +
                "V_PAR_N0 := '''''';\n" +
                "V_PAR_N1 := '''''';\n" +
                "V_PAR_N2 := '''''';\n" +
                "V_PAR_N3 := '''''';\n" +
                "DBMS_OUTPUT.PUT_LINE('teste15');\n" +
                "\n" +
                "IF (R.TAB_P3 IS NOT NULL) THEN\n" +
                "BEGIN\n" +
                "SELECT OTHER_KEY_FIELD INTO V_OTHER_PARENT_KEY0\n" +
                "FROM " + dbOwner + ".TAB_CTRL_BATIMENTO_REP WHERE\n" +
                "GROUP_OBJECT = R.GROUP_OBJECT\n" +
                "AND CONFIGURATION_NAME = R.CONFIGURATION_NAME\n" +
                "AND TABLE_NAME = R.TAB_P0\n" +
                "AND ORDER_COL = R.ORDER_COL - 4;\n" +
                "EXCEPTION WHEN OTHERS THEN    \n" +
                "V_OTHER_PARENT_KEY0 := NULL;\n" +
                "END;\n" +
                "DBMS_OUTPUT.PUT_LINE('teste16');\n" +
                "BEGIN                                \n" +
                "SELECT OTHER_KEY_FIELD INTO V_OTHER_PARENT_KEY1\n" +
                "FROM " + dbOwner + ".TAB_CTRL_BATIMENTO_REP WHERE\n" +
                "GROUP_OBJECT = R.GROUP_OBJECT\n" +
                "AND CONFIGURATION_NAME = R.CONFIGURATION_NAME\n" +
                "AND TABLE_NAME = R.TAB_P1\n" +
                "AND ORDER_COL = R.ORDER_COL - 3;                            \n" +
                "EXCEPTION WHEN OTHERS THEN    \n" +
                "V_OTHER_PARENT_KEY1 := NULL;\n" +
                "END;\n" +
                "DBMS_OUTPUT.PUT_LINE('teste17');\n" +
                "BEGIN\n" +
                "SELECT OTHER_KEY_FIELD INTO V_OTHER_PARENT_KEY2\n" +
                "FROM " + dbOwner + ".TAB_CTRL_BATIMENTO_REP WHERE\n" +
                "GROUP_OBJECT = R.GROUP_OBJECT\n" +
                "AND CONFIGURATION_NAME = R.CONFIGURATION_NAME\n" +
                "AND TABLE_NAME = R.TAB_P2\n" +
                "AND ORDER_COL = R.ORDER_COL - 2;\n" +
                "EXCEPTION WHEN OTHERS THEN    \n" +
                "V_OTHER_PARENT_KEY2 := NULL;\n" +
                "END;\n" +
                "DBMS_OUTPUT.PUT_LINE('teste18');\n" +
                "BEGIN\n" +
                "SELECT OTHER_KEY_FIELD INTO V_OTHER_PARENT_KEY3\n" +
                "FROM " + dbOwner + ".TAB_CTRL_BATIMENTO_REP WHERE\n" +
                "GROUP_OBJECT = R.GROUP_OBJECT\n" +
                "AND CONFIGURATION_NAME = R.CONFIGURATION_NAME\n" +
                "AND TABLE_NAME = R.TAB_P3\n" +
                "AND ORDER_COL = R.ORDER_COL - 1;                            \n" +
                "EXCEPTION WHEN OTHERS THEN    \n" +
                "V_OTHER_PARENT_KEY3 := NULL;\n" +
                "END;\n" +
                "DBMS_OUTPUT.PUT_LINE('teste19');\n" +
                "IF V_OTHER_PARENT_KEY0 IS NOT NULL THEN\n" +
                "IF UPPER(SUBSTR(TRIM(REPLACE(V_OTHER_PARENT_KEY0, '(', '')), 1, 6)) = 'SELECT' THEN\n" +
                "V_COL_PAR0 := '(' || REPLACE(V_OTHER_PARENT_KEY0, '''', '''''') || ')';\n" +
                "ELSE\n" +
                "V_COL_PAR0 := '''[''|| TAB.' || REPLACE(REPLACE(V_OTHER_PARENT_KEY0, ' ', ''), ',', '|| ''].['' ||TAB.') || '|| '']''';\n" +
                "END IF;\n" +
                "ELSE\n" +
                "V_COL_PAR0 := ' TAB.NAME'; \n" +
                "END IF;                            \n" +
                "DBMS_OUTPUT.PUT_LINE('teste20');\n" +
                "IF V_OTHER_PARENT_KEY1 IS NOT NULL THEN\n" +
                "IF UPPER(SUBSTR(TRIM(REPLACE(V_OTHER_PARENT_KEY1, '(', '')), 1, 6)) = 'SELECT' THEN\n" +
                "V_COL_PAR0 := '(' || REPLACE(V_OTHER_PARENT_KEY1, '''', '''''') || ')';\n" +
                "ELSE\n" +
                "V_COL_PAR1 := '''[''|| TAB1.' || REPLACE(REPLACE(V_OTHER_PARENT_KEY1, ' ', ''), ',', '|| ''].['' ||TAB1.') || '|| '']''';\n" +
                "END IF;\n" +
                "ELSE\n" +
                "V_COL_PAR1 := ' TAB1.NAME'; \n" +
                "END IF;    \n" +
                "DBMS_OUTPUT.PUT_LINE('teste21');\n" +
                "IF V_OTHER_PARENT_KEY2 IS NOT NULL THEN\n" +
                "IF UPPER(SUBSTR(TRIM(REPLACE(V_OTHER_PARENT_KEY2, '(', '')), 1, 6)) = 'SELECT' THEN\n" +
                "V_COL_PAR0 := '(' || REPLACE(V_OTHER_PARENT_KEY2, '''', '''''') || ')';\n" +
                "ELSE    \n" +
                "V_COL_PAR2 := '''[''|| TAB2.' || REPLACE(REPLACE(V_OTHER_PARENT_KEY2, ' ', ''), ',', '|| ''].['' ||TAB2.') || '|| '']''';\n" +
                "END IF;\n" +
                "ELSE\n" +
                "V_COL_PAR2 := ' TAB2.NAME'; \n" +
                "END IF;    \n" +
                "DBMS_OUTPUT.PUT_LINE('teste22');\n" +
                "IF V_OTHER_PARENT_KEY3 IS NOT NULL THEN\n" +
                "IF UPPER(SUBSTR(TRIM(REPLACE(V_OTHER_PARENT_KEY3, '(', '')), 1, 6)) = 'SELECT' THEN\n" +
                "V_COL_PAR0 := '(' || REPLACE(V_OTHER_PARENT_KEY3, '''', '''''') || ')';\n" +
                "ELSE    \n" +
                "V_COL_PAR3 := '''[''|| TAB3.' || REPLACE(REPLACE(V_OTHER_PARENT_KEY3, ' ', ''), ',', '|| ''].['' ||TAB3.') || '|| '']''';\n" +
                "END IF;\n" +
                "ELSE\n" +
                "V_COL_PAR3 := ' TAB3.NAME'; \n" +
                "END IF;                            \n" +
                "DBMS_OUTPUT.PUT_LINE('teste23');\n" +
                "V_SUB_SELECT  := ', (SELECT '|| V_COL_PAR0 ||' FROM ' || \n" +
                "' SIEBEL.' || R.TAB_P0 || V_DBLINK_ORIG ||' TAB, ' || \n" +
                "' SIEBEL.' || R.TAB_P1 || V_DBLINK_ORIG || ' TAB1, ' ||\n" +
                "' SIEBEL.' || R.TAB_P2 || V_DBLINK_ORIG || ' TAB2, ' ||\n" +
                "' SIEBEL.' || R.TAB_P3 || V_DBLINK_ORIG || ' TAB3 ' ||\n" +
                "' WHERE ' ||\n" +
                "' T.' || R.JOIN3 || ' = TAB3.ROW_ID ' ||\n" +
                "' AND ' ||\n" +
                "' TAB3.' || R.JOIN2 || ' = TAB2.ROW_ID ' ||\n" +
                "' AND ' ||\n" +
                "' TAB2.' || R.JOIN1 || ' = TAB1.ROW_ID ' ||\n" +
                "' AND ' ||                                   \n" +
                "' TAB1.' || R.JOIN0 || ' = TAB.ROW_ID ) PAR_N0';\n" +
                "V_SUB_SELECT  := V_SUB_SELECT || ', ' ||  \n" +
                "' (SELECT '|| V_COL_PAR1 ||' FROM ' ||\n" +
                "' SIEBEL.' || R.TAB_P0 || V_DBLINK_ORIG ||' TAB, ' || \n" +
                "' SIEBEL.' || R.TAB_P1 || V_DBLINK_ORIG || ' TAB1, ' ||\n" +
                "' SIEBEL.' || R.TAB_P2 || V_DBLINK_ORIG || ' TAB2, ' ||\n" +
                "' SIEBEL.' || R.TAB_P3 || V_DBLINK_ORIG || ' TAB3 ' ||\n" +
                "' WHERE ' ||\n" +
                "' T.' || R.JOIN3 || ' = TAB3.ROW_ID ' ||\n" +
                "' AND ' ||\n" +
                "' TAB3.' || R.JOIN2 || ' = TAB2.ROW_ID ' ||\n" +
                "' AND ' ||\n" +
                "' TAB2.' || R.JOIN1 || ' = TAB1.ROW_ID ' ||\n" +
                "' AND ' ||                                   \n" +
                "' TAB1.' || R.JOIN0 || ' = TAB.ROW_ID ) PAR_N1';                                               \n" +
                "V_SUB_SELECT  := V_SUB_SELECT || ', ' || \n" +
                "' (SELECT '|| V_COL_PAR2 ||' FROM ' ||\n" +
                "' SIEBEL.' || R.TAB_P0 || V_DBLINK_ORIG ||' TAB, ' || \n" +
                "' SIEBEL.' || R.TAB_P1 || V_DBLINK_ORIG || ' TAB1, ' ||\n" +
                "' SIEBEL.' || R.TAB_P2 || V_DBLINK_ORIG || ' TAB2, ' ||\n" +
                "' SIEBEL.' || R.TAB_P3 || V_DBLINK_ORIG || ' TAB3 ' ||\n" +
                "' WHERE ' ||\n" +
                "' T.' || R.JOIN3 || ' = TAB3.ROW_ID ' ||\n" +
                "' AND ' ||\n" +
                "' TAB3.' || R.JOIN2 || ' = TAB2.ROW_ID ' ||\n" +
                "' AND ' ||\n" +
                "' TAB2.' || R.JOIN1 || ' = TAB1.ROW_ID ' ||\n" +
                "' AND ' ||                                   \n" +
                "' TAB1.' || R.JOIN0 || ' = TAB.ROW_ID ) PAR_N2';\n" +
                "V_SUB_SELECT  := V_SUB_SELECT || ', ' || \n" +
                "'(SELECT '|| V_COL_PAR3 ||' FROM ' ||\n" +
                "' SIEBEL.' || R.TAB_P0 || V_DBLINK_ORIG ||' TAB, ' || \n" +
                "' SIEBEL.' || R.TAB_P1 || V_DBLINK_ORIG || ' TAB1, ' ||\n" +
                "' SIEBEL.' || R.TAB_P2 || V_DBLINK_ORIG || ' TAB2, ' ||\n" +
                "' SIEBEL.' || R.TAB_P3 || V_DBLINK_ORIG || ' TAB3 ' ||\n" +
                "' WHERE ' ||\n" +
                "' T.' || R.JOIN3 || ' = TAB3.ROW_ID ' ||\n" +
                "' AND ' ||\n" +
                "' TAB3.' || R.JOIN2 || ' = TAB2.ROW_ID ' ||\n" +
                "' AND ' ||\n" +
                "' TAB2.' || R.JOIN1 || ' = TAB1.ROW_ID ' ||\n" +
                "' AND ' ||                                   \n" +
                "' TAB1.' || R.JOIN0 || ' = TAB.ROW_ID ) PAR_N3';\n" +
                "V_EXISTS_PARENT :=                      \n" +
                "' AND EXISTS ( ' || \n" +
                "' SELECT 1 FROM ' || \n" +
                "' SIEBEL.' || R.TAB_P0 || V_DBLINK_DEST || ' TAB, ' || \n" +
                "' SIEBEL.' || R.TAB_P1 || V_DBLINK_DEST || ' TAB1,' ||\n" +
                "' SIEBEL.' || R.TAB_P2 || V_DBLINK_DEST || ' TAB2,' ||\n" +
                "' SIEBEL.' || R.TAB_P3 || V_DBLINK_DEST || ' TAB3';\n" +
                "IF R.TYPE = 'Repository'    THEN                                        \n" +
                "V_EXISTS_PARENT := V_EXISTS_PARENT || \n" +
                "' ,SIEBEL.S_REPOSITORY' || V_DBLINK_DEST || ' REP  ';\n" +
                "END IF;\n" +
                "V_EXISTS_PARENT := V_EXISTS_PARENT || \n" +
                "' WHERE ' ||\n" +
                "' T.' || R.JOIN3 || ' = TAB3.ROW_ID ' ||\n" +
                "' AND ' ||\n" +
                "' TAB3.' || R.JOIN2 || ' = TAB2.ROW_ID ' ||\n" +
                "' AND ' ||\n" +
                "' TAB2.' || R.JOIN1 || ' = TAB1.ROW_ID ' ||\n" +
                "' AND ' ||\n" +
                "' TAB1.' || R.JOIN0 || ' = TAB.ROW_ID ' ||        \n" +
                "' AND ' ||                                   \n" +
                "' '|| V_COL_PAR0 ||' = REG.PAR_N0 ' ||\n" +
                "' AND ' ||\n" +
                "' '|| V_COL_PAR1 ||' = REG.PAR_N1 ' ||\n" +
                "' AND ' ||                                             \n" +
                "' '|| V_COL_PAR2 ||' = REG.PAR_N2 ' ||\n" +
                "' AND ' ||                                             \n" +
                "' '|| V_COL_PAR3 ||' = REG.PAR_N3 ';\n" +
                "IF R.TYPE = 'Repository'    THEN                                             \n" +
                "V_EXISTS_PARENT := V_EXISTS_PARENT ||      \n" +
                "' AND ' ||  \n" +
                "' TAB.REPOSITORY_ID = REP.ROW_ID ' ||\n" +
                "' AND ' ||  \n" +
                "' TAB1.REPOSITORY_ID = REP.ROW_ID ' ||\n" +
                "' AND ' ||  \n" +
                "' TAB2.REPOSITORY_ID = REP.ROW_ID ' ||\n" +
                "' AND ' ||  \n" +
                "' TAB3.REPOSITORY_ID = REP.ROW_ID ' ||\n" +
                "' AND ' || \n" +
                "' REP.NAME = ''' || V_DES_REPOSITORY_NAME || '''' ;\n" +
                "END IF;                                             \n" +
                "V_EXISTS_PARENT := V_EXISTS_PARENT ||   ' )';\n" +
                "\n" +
                "V_PAR_N0 := 'REG.PAR_N0';\n" +
                "V_PAR_N1 := 'REG.PAR_N1';\n" +
                "V_PAR_N2 := 'REG.PAR_N2';\n" +
                "V_PAR_N3 := 'REG.PAR_N3';      \n" +
                "DBMS_OUTPUT.PUT_LINE('teste24');                      \n" +
                "ELSIF (R.TAB_P2 IS NOT NULL) THEN\n" +
                "BEGIN\n" +
                "SELECT OTHER_KEY_FIELD INTO V_OTHER_PARENT_KEY0\n" +
                "FROM " + dbOwner + ".TAB_CTRL_BATIMENTO_REP WHERE\n" +
                "GROUP_OBJECT = R.GROUP_OBJECT\n" +
                "AND CONFIGURATION_NAME = R.CONFIGURATION_NAME\n" +
                "AND TABLE_NAME = R.TAB_P0\n" +
                "AND ORDER_COL = R.ORDER_COL - 3;\n" +
                "EXCEPTION WHEN OTHERS THEN    \n" +
                "V_OTHER_PARENT_KEY0 := NULL;\n" +
                "END;\n" +
                "DBMS_OUTPUT.PUT_LINE('teste25');\n" +
                "BEGIN\n" +
                "SELECT OTHER_KEY_FIELD INTO V_OTHER_PARENT_KEY1\n" +
                "FROM " + dbOwner + ".TAB_CTRL_BATIMENTO_REP WHERE\n" +
                "GROUP_OBJECT = R.GROUP_OBJECT\n" +
                "AND CONFIGURATION_NAME = R.CONFIGURATION_NAME\n" +
                "AND TABLE_NAME = R.TAB_P1\n" +
                "AND ORDER_COL = R.ORDER_COL - 2;                            \n" +
                "EXCEPTION WHEN OTHERS THEN    \n" +
                "V_OTHER_PARENT_KEY1 := NULL;\n" +
                "END;\n" +
                "DBMS_OUTPUT.PUT_LINE('teste26');\n" +
                "BEGIN\n" +
                "SELECT OTHER_KEY_FIELD INTO V_OTHER_PARENT_KEY2\n" +
                "FROM " + dbOwner + ".TAB_CTRL_BATIMENTO_REP WHERE\n" +
                "GROUP_OBJECT = R.GROUP_OBJECT\n" +
                "AND CONFIGURATION_NAME = R.CONFIGURATION_NAME\n" +
                "AND TABLE_NAME = R.TAB_P2\n" +
                "AND ORDER_COL = R.ORDER_COL - 1;    \n" +
                "EXCEPTION WHEN OTHERS THEN    \n" +
                "V_OTHER_PARENT_KEY2 := NULL;\n" +
                "END;\n" +
                "DBMS_OUTPUT.PUT_LINE('teste27');\n" +
                "IF V_OTHER_PARENT_KEY0 IS NOT NULL THEN\n" +
                "IF UPPER(SUBSTR(TRIM(REPLACE(V_OTHER_PARENT_KEY0, '(', '')), 1, 6)) = 'SELECT' THEN\n" +
                "V_COL_PAR0 := '(' || REPLACE(V_OTHER_PARENT_KEY0, '''', '''''') || ')';\n" +
                "ELSE\n" +
                "V_COL_PAR0 := '''[''|| TAB.' || REPLACE(REPLACE(V_OTHER_PARENT_KEY0, ' ', ''), ',', '|| ''].['' ||TAB.') || '|| '']''';\n" +
                "END IF;\n" +
                "ELSE\n" +
                "V_COL_PAR0 := ' TAB.NAME'; \n" +
                "END IF;                            \n" +
                "DBMS_OUTPUT.PUT_LINE('teste28');\n" +
                "IF V_OTHER_PARENT_KEY1 IS NOT NULL THEN\n" +
                "IF UPPER(SUBSTR(TRIM(REPLACE(V_OTHER_PARENT_KEY1, '(', '')), 1, 6)) = 'SELECT' THEN\n" +
                "V_COL_PAR0 := '(' || REPLACE(V_OTHER_PARENT_KEY1, '''', '''''') || ')';\n" +
                "ELSE                                \n" +
                "V_COL_PAR1 := '''[''|| TAB1.' || REPLACE(REPLACE(V_OTHER_PARENT_KEY1, ' ', ''), ',', '|| ''].['' ||TAB1.') || '|| '']''';\n" +
                "END IF;\n" +
                "ELSE\n" +
                "V_COL_PAR1 := ' TAB1.NAME'; \n" +
                "END IF;    \n" +
                "DBMS_OUTPUT.PUT_LINE('teste29');\n" +
                "IF V_OTHER_PARENT_KEY2 IS NOT NULL THEN\n" +
                "IF UPPER(SUBSTR(TRIM(REPLACE(V_OTHER_PARENT_KEY2, '(', '')), 1, 6)) = 'SELECT' THEN\n" +
                "V_COL_PAR0 := '(' || REPLACE(V_OTHER_PARENT_KEY2, '''', '''''') || ')';\n" +
                "ELSE                                \n" +
                "V_COL_PAR2 := '''[''|| TAB3.' || REPLACE(REPLACE(V_OTHER_PARENT_KEY2, ' ', ''), ',', '|| ''].['' ||TAB3.') || '|| '']''';\n" +
                "END IF;\n" +
                "ELSE\n" +
                "V_COL_PAR2 := ' TAB2.NAME'; \n" +
                "END IF;    \n" +
                "DBMS_OUTPUT.PUT_LINE('teste30');\n" +
                "V_SUB_SELECT  := ', (SELECT '|| V_COL_PAR0 ||' FROM ' ||\n" +
                "' SIEBEL.' || R.TAB_P0 || V_DBLINK_ORIG ||' TAB, ' || \n" +
                "' SIEBEL.' || R.TAB_P1 || V_DBLINK_ORIG || ' TAB1, ' ||\n" +
                "' SIEBEL.' || R.TAB_P2 || V_DBLINK_ORIG || ' TAB2 ' ||\n" +
                "' WHERE ' ||\n" +
                "' T.' || R.JOIN2 || ' = TAB2.ROW_ID ' ||\n" +
                "' AND ' ||\n" +
                "' TAB2.' || R.JOIN1 || ' = TAB1.ROW_ID ' ||\n" +
                "' AND ' ||                                   \n" +
                "' TAB1.' || R.JOIN0 || ' = TAB.ROW_ID ) PAR_N0';\n" +
                "V_SUB_SELECT  := V_SUB_SELECT || ', ' || \n" +
                "'(SELECT '|| V_COL_PAR1 ||' FROM ' ||\n" +
                "' SIEBEL.' || R.TAB_P0 || V_DBLINK_ORIG || ' TAB, ' || \n" +
                "' SIEBEL.' || R.TAB_P1 || V_DBLINK_ORIG || ' TAB1, ' ||\n" +
                "' SIEBEL.' || R.TAB_P2 || V_DBLINK_ORIG || ' TAB2 ' ||\n" +
                "' WHERE ' ||\n" +
                "' T.' || R.JOIN2 || ' = TAB2.ROW_ID ' ||\n" +
                "' AND ' ||\n" +
                "' TAB2.' || R.JOIN1 || ' = TAB1.ROW_ID ' ||\n" +
                "' AND ' ||\n" +
                "' TAB1.' || R.JOIN0 || ' = TAB.ROW_ID ) PAR_N1';\n" +
                "V_SUB_SELECT  := V_SUB_SELECT || ', ' || \n" +
                "'(SELECT '|| V_COL_PAR2 ||' FROM ' || \n" +
                "' SIEBEL.' || R.TAB_P0 || V_DBLINK_ORIG || ' TAB, ' || \n" +
                "' SIEBEL.' || R.TAB_P1 || V_DBLINK_ORIG || ' TAB1, ' ||\n" +
                "' SIEBEL.' || R.TAB_P2 || V_DBLINK_ORIG || ' TAB2 ' ||\n" +
                "' WHERE ' ||\n" +
                "' T.' || R.JOIN2 || ' = TAB2.ROW_ID ' ||\n" +
                "' AND ' ||\n" +
                "' TAB2.' || R.JOIN1 || ' = TAB1.ROW_ID ' ||\n" +
                "' AND ' ||\n" +
                "' TAB1.' || R.JOIN0 || ' = TAB.ROW_ID ) PAR_N2';\n" +
                "V_EXISTS_PARENT :=                      \n" +
                "' AND EXISTS ( ' || \n" +
                "' SELECT 1 FROM ' || \n" +
                "' SIEBEL.' || R.TAB_P0 || V_DBLINK_DEST || ' TAB, ' || \n" +
                "' SIEBEL.' || R.TAB_P1 || V_DBLINK_DEST || ' TAB1,' ||\n" +
                "' SIEBEL.' || R.TAB_P2 || V_DBLINK_DEST || ' TAB2';\n" +
                "IF R.TYPE = 'Repository'    THEN                                        \n" +
                "V_EXISTS_PARENT := V_EXISTS_PARENT || \n" +
                "' ,SIEBEL.S_REPOSITORY' || V_DBLINK_DEST || ' REP  ';\n" +
                "END IF;\n" +
                "V_EXISTS_PARENT := V_EXISTS_PARENT || \n" +
                "' WHERE ' ||\n" +
                "' T.' || R.JOIN2 || ' = TAB2.ROW_ID ' ||\n" +
                "' AND ' ||\n" +
                "' TAB2.' || R.JOIN1 || ' = TAB1.ROW_ID ' ||\n" +
                "' AND ' ||\n" +
                "' TAB1.' || R.JOIN0 || ' = TAB.ROW_ID ' ||        \n" +
                "' AND ' ||                                   \n" +
                "' '|| V_COL_PAR0 ||' = REG.PAR_N0 ' ||\n" +
                "' AND ' ||\n" +
                "' '|| V_COL_PAR1 ||' = REG.PAR_N1 ' ||\n" +
                "' AND ' ||                                             \n" +
                "' '|| V_COL_PAR2 ||' = REG.PAR_N2 ';\n" +
                "IF R.TYPE = 'Repository'    THEN                                             \n" +
                "V_EXISTS_PARENT := V_EXISTS_PARENT ||      \n" +
                "' AND ' ||  \n" +
                "' TAB.REPOSITORY_ID = REP.ROW_ID ' ||\n" +
                "' AND ' ||  \n" +
                "' TAB1.REPOSITORY_ID = REP.ROW_ID ' ||\n" +
                "' AND ' ||  \n" +
                "' TAB2.REPOSITORY_ID = REP.ROW_ID ' ||\n" +
                "' AND ' || \n" +
                "' REP.NAME = ''' || V_DES_REPOSITORY_NAME || '''' ;\n" +
                "END IF;                                             \n" +
                "V_EXISTS_PARENT := V_EXISTS_PARENT ||   ' )';\n" +
                "\n" +
                "V_PAR_N0 := 'REG.PAR_N0';\n" +
                "V_PAR_N1 := 'REG.PAR_N1';\n" +
                "V_PAR_N2 := 'REG.PAR_N2';\n" +
                "DBMS_OUTPUT.PUT_LINE('teste31');\n" +
                "ELSIF (R.TAB_P1 IS NOT NULL) THEN\n" +
                "BEGIN\n" +
                "SELECT OTHER_KEY_FIELD INTO V_OTHER_PARENT_KEY0\n" +
                "FROM " + dbOwner + ".TAB_CTRL_BATIMENTO_REP WHERE\n" +
                "GROUP_OBJECT = R.GROUP_OBJECT\n" +
                "AND CONFIGURATION_NAME = R.CONFIGURATION_NAME\n" +
                "AND TABLE_NAME = R.TAB_P0\n" +
                "AND ORDER_COL = R.ORDER_COL - 2;\n" +
                "EXCEPTION WHEN OTHERS THEN    \n" +
                "V_OTHER_PARENT_KEY0 := NULL;\n" +
                "END;\n" +
                "DBMS_OUTPUT.PUT_LINE('teste6');\n" +
                "BEGIN\n" +
                "SELECT OTHER_KEY_FIELD INTO V_OTHER_PARENT_KEY1\n" +
                "FROM " + dbOwner + ".TAB_CTRL_BATIMENTO_REP WHERE\n" +
                "GROUP_OBJECT = R.GROUP_OBJECT\n" +
                "AND CONFIGURATION_NAME = R.CONFIGURATION_NAME\n" +
                "AND TABLE_NAME = R.TAB_P1\n" +
                "AND ORDER_COL = R.ORDER_COL - 1;\n" +
                "EXCEPTION WHEN OTHERS THEN    \n" +
                "V_OTHER_PARENT_KEY1 := NULL;\n" +
                "END;\n" +
                "\n" +
                "IF V_OTHER_PARENT_KEY0 IS NOT NULL THEN\n" +
                "IF UPPER(SUBSTR(TRIM(REPLACE(V_OTHER_PARENT_KEY0, '(', '')), 1, 6)) = 'SELECT' THEN\n" +
                "V_COL_PAR0 := '(' || REPLACE(V_OTHER_PARENT_KEY0, '''', '''''') || ')';\n" +
                "ELSE\n" +
                "V_COL_PAR0 := '''[''|| TAB.' || REPLACE(REPLACE(V_OTHER_PARENT_KEY0, ' ', ''), ',', '|| ''].['' ||TAB.') || '|| '']''';\n" +
                "END IF;\n" +
                "ELSE\n" +
                "V_COL_PAR0 := ' TAB.NAME'; \n" +
                "END IF;                            \n" +
                "\n" +
                "IF V_OTHER_PARENT_KEY1 IS NOT NULL THEN\n" +
                "IF UPPER(SUBSTR(TRIM(REPLACE(V_OTHER_PARENT_KEY1, '(', '')), 1, 6)) = 'SELECT' THEN\n" +
                "V_COL_PAR0 := '(' || REPLACE(V_OTHER_PARENT_KEY1, '''', '''''') || ')';\n" +
                "ELSE\n" +
                "V_COL_PAR1 := '''[''|| TAB1.' || REPLACE(REPLACE(V_OTHER_PARENT_KEY1, ' ', ''), ',', '|| ''].['' ||TAB1.') || '|| '']''';\n" +
                "END IF;\n" +
                "ELSE\n" +
                "V_COL_PAR1 := ' TAB1.NAME'; \n" +
                "END IF;    \n" +
                "\n" +
                "V_SUB_SELECT  := ', (SELECT '|| V_COL_PAR0 ||' FROM ' ||\n" +
                "' SIEBEL.' || R.TAB_P0 ||  V_DBLINK_ORIG ||' TAB, ' || \n" +
                "' SIEBEL.' || R.TAB_P1 ||  V_DBLINK_ORIG ||' TAB1 ' ||\n" +
                "' WHERE ' ||\n" +
                "' T.' || R.JOIN1 || ' = TAB1.ROW_ID ' ||\n" +
                "' AND ' ||\n" +
                "' TAB1.' || R.JOIN0 || ' = TAB.ROW_ID ) PAR_N0';\n" +
                "V_SUB_SELECT  := V_SUB_SELECT || ', ' || \n" +
                "'(SELECT '|| V_COL_PAR1 ||' FROM ' ||\n" +
                "' SIEBEL.' || R.TAB_P0 ||  V_DBLINK_ORIG ||' TAB, ' || \n" +
                "' SIEBEL.' || R.TAB_P1 ||  V_DBLINK_ORIG ||' TAB1 ' ||\n" +
                "' WHERE ' ||\n" +
                "' T.' || R.JOIN1 || ' = TAB1.ROW_ID ' ||\n" +
                "' AND ' ||\n" +
                "' TAB1.' || R.JOIN0 || ' = TAB.ROW_ID ) PAR_N1';    \n" +
                "\n" +
                "V_EXISTS_PARENT :=     ' AND EXISTS ( ' || \n" +
                "' SELECT 1 FROM ' || \n" +
                "' SIEBEL.' || R.TAB_P0 || V_DBLINK_DEST ||' TAB, ' || \n" +
                "' SIEBEL.' || R.TAB_P1 || V_DBLINK_DEST ||' TAB1 ';\n" +
                "IF R.TYPE = 'Repository'    THEN\n" +
                "V_EXISTS_PARENT := V_EXISTS_PARENT || \n" +
                "' ,SIEBEL.S_REPOSITORY' || V_DBLINK_DEST || ' REP ';\n" +
                "END IF;    \n" +
                "V_EXISTS_PARENT := V_EXISTS_PARENT ||\n" +
                "' WHERE ' ||\n" +
                "' T.' || R.JOIN1 || ' = TAB1.ROW_ID ' ||\n" +
                "' AND ' ||\n" +
                "' TAB1.' || R.JOIN0 || ' = TAB.ROW_ID ' ||            \n" +
                "' AND ' ||                                                 \n" +
                "' '|| V_COL_PAR0 ||' = REG.PAR_N0 ' ||\n" +
                "' AND ' ||\n" +
                "' '|| V_COL_PAR1 ||' = REG.PAR_N1 ';\n" +
                "IF R.TYPE = 'Repository'    THEN\n" +
                "V_EXISTS_PARENT := V_EXISTS_PARENT ||\n" +
                "' AND ' ||  \n" +
                "' TAB.REPOSITORY_ID = REP.ROW_ID ' ||\n" +
                "' AND ' ||  \n" +
                "' TAB1.REPOSITORY_ID = REP.ROW_ID ' ||\n" +
                "' AND ' || \n" +
                "' REP.NAME = ''' || V_DES_REPOSITORY_NAME || '''';                                             \n" +
                "END IF;    \n" +
                "V_EXISTS_PARENT := V_EXISTS_PARENT ||\n" +
                "' )';  \n" +
                "\n" +
                "V_PAR_N0 := 'REG.PAR_N0';\n" +
                "V_PAR_N1 := 'REG.PAR_N1';                              \n" +
                "ELSIF (R.TAB_P0 IS NOT NULL) THEN\n" +
                "DBMS_OUTPUT.PUT_LINE('teste5');\n" +
                "BEGIN\n" +
                "SELECT OTHER_KEY_FIELD INTO V_OTHER_PARENT_KEY0\n" +
                "FROM " + dbOwner + ".TAB_CTRL_BATIMENTO_REP WHERE\n" +
                "GROUP_OBJECT = R.GROUP_OBJECT\n" +
                "AND CONFIGURATION_NAME = R.CONFIGURATION_NAME\n" +
                "AND TABLE_NAME = R.TAB_P0\n" +
                "AND ORDER_COL = R.ORDER_COL - 1;                        \n" +
                "EXCEPTION WHEN OTHERS THEN    \n" +
                "V_OTHER_PARENT_KEY0 := NULL;\n" +
                "END;\n" +
                "\n" +
                "IF V_OTHER_PARENT_KEY0 IS NOT NULL THEN\n" +
                "IF UPPER(SUBSTR(TRIM(REPLACE(V_OTHER_PARENT_KEY0, '(', '')), 1, 6)) = 'SELECT' THEN\n" +
                "V_COL_PAR0 := '(' || REPLACE(V_OTHER_PARENT_KEY0, '''', '''''') || ')';\n" +
                "ELSE                            \n" +
                "V_COL_PAR0 := '''[''|| TAB.' || REPLACE(REPLACE(V_OTHER_PARENT_KEY0, ' ', ''), ',', '|| ''].['' ||TAB.') || '|| '']''';\n" +
                "END IF;\n" +
                "ELSE\n" +
                "V_COL_PAR0 := ' TAB.NAME'; \n" +
                "END IF;    \n" +
                "DBMS_OUTPUT.PUT_LINE('teste4');\n" +
                "V_SUB_SELECT  := ', (SELECT '|| V_COL_PAR0 ||' FROM ' ||\n" +
                "' SIEBEL.' || R.TAB_P0 || V_DBLINK_ORIG || ' TAB ' || \n" +
                "' WHERE ' ||\n" +
                "' T.' || R.JOIN0 || ' = TAB.ROW_ID ) PAR_N0';\n" +
                "\n" +
                "V_EXISTS_PARENT :=  ' AND EXISTS ( ' || \n" +
                "' SELECT 1 FROM ' || \n" +
                "' SIEBEL.' || R.TAB_P0 || V_DBLINK_DEST || ' TAB ';\n" +
                "IF R.TYPE = 'Repository'    THEN\n" +
                "V_EXISTS_PARENT := V_EXISTS_PARENT || \n" +
                "' ,SIEBEL.S_REPOSITORY' || V_DBLINK_DEST || ' REP ';  \n" +
                "END IF;             \n" +
                "V_EXISTS_PARENT := V_EXISTS_PARENT ||\n" +
                "' WHERE ' ||\n" +
                "' T.' || R.JOIN0 || ' = TAB.ROW_ID ' ||                                             \n" +
                "' AND ' ||                                                 \n" +
                "' '|| V_COL_PAR0 ||' = REG.PAR_N0 ';\n" +
                "IF R.TYPE = 'Repository'    THEN\n" +
                "V_EXISTS_PARENT := V_EXISTS_PARENT ||\n" +
                "' AND ' ||  \n" +
                "' TAB.REPOSITORY_ID = REP.ROW_ID ' ||    \n" +
                "' AND ' || \n" +
                "' REP.NAME = ''' || V_DES_REPOSITORY_NAME || '''';                                             \n" +
                "END IF;    \n" +
                "V_EXISTS_PARENT := V_EXISTS_PARENT ||\n" +
                "' )';  \n" +
                "\n" +
                "V_PAR_N0 := 'REG.PAR_N0';                              \n" +
                "ELSE\n" +
                "V_SUB_SELECT  := '';\n" +
                "V_EXISTS_PARENT  := '';\n" +
                "END IF;        \n" +
                "DBMS_OUTPUT.PUT_LINE('teste3');\n" +
                "FOR RC IN C_COLUMN (R.ROW_ID) LOOP    \n" +
                "\n" +
                "VEXIT := 'N'; \n" +
                "CONT := 0;\n" +
                "\n" +
                "DBMS_OUTPUT.PUT_LINE('teste2 - ' || R.OTHER_KEY_FIELD);    \n" +
                "IF R.OTHER_KEY_FIELD IS NOT NULL THEN\n" +
                "IF UPPER(R.OTHER_KEY_FIELD) LIKE '%SELECT%FROM%' OR UPPER(R.OTHER_KEY_FIELD) LIKE '%].[%' THEN\n" +
                "VEXIT := 'N';\n" +
                "ELSE\n" +
                "TABOUTPUT:= fn_split (R.OTHER_KEY_FIELD, ',');\n" +
                "FOR i IN 0 .. TABOUTPUT.COUNT - 1 LOOP\n" +
                "IF RC.COL_NAME = TABOUTPUT (i) THEN\n" +
                "VEXIT := 'Y';\n" +
                "END IF;\n" +
                "END LOOP;\n" +
                "END IF;\n" +
                "ELSE\n" +
                "VEXIT := 'N'; \n" +
                "END IF;\n" +
                "DBMS_OUTPUT.PUT_LINE('teste1');\n" +
                "IF VEXIT = 'N' THEN\n" +
                "DBMS_OUTPUT.PUT_LINE('teste400');\n" +
                "V_QUERY_ORI :=  ' SELECT T.' || RC.COL_NAME || ',' ;\n" +
                "IF R.OTHER_KEY_FIELD IS NOT NULL THEN\n" +
                "IF UPPER(R.OTHER_KEY_FIELD) LIKE '%SELECT%FROM%'  OR UPPER(R.OTHER_KEY_FIELD) LIKE '%].[%' THEN\n" +
                "V_QUERY_ORI := V_QUERY_ORI ||\n" +
                "UPPER(REPLACE(R.OTHER_KEY_FIELD, '@', V_DBLINK_ORIG)) || ' OTHER_KEY_SUB_SELECT, ';\n" +
                "ELSE\n" +
                "TABOUTPUT:= fn_split (R.OTHER_KEY_FIELD, ',');\n" +
                "FOR i IN 0 .. TABOUTPUT.COUNT - 1 LOOP\n" +
                "V_QUERY_ORI := V_QUERY_ORI ||\n" +
                "'T.' || TABOUTPUT (i) || ', ';\n" +
                "END LOOP;\n" +
                "END IF;\n" +
                "ELSE\n" +
                "V_QUERY_ORI := V_QUERY_ORI ||\n" +
                "' T.NAME,'; \n" +
                "END IF;\n" +
                "V_QUERY_ORI := V_QUERY_ORI ||\n" +
                "' T.LAST_UPD, ' ||\n" +
                "' (SELECT LOGIN FROM SIEBEL.S_USER' || V_DBLINK_ORIG || ' WHERE ROW_ID = T.LAST_UPD_BY AND ROWNUM < 2) LAST_UPD_BY' ||  \n" +
                "V_SUB_SELECT ||\n" +
                "' FROM SIEBEL.' || R.NAME || V_DBLINK_ORIG || ' T'; \n" +
                "IF R.TYPE = 'Repository'    THEN\n" +
                "V_QUERY_ORI := V_QUERY_ORI ||\n" +
                "' ,SIEBEL.S_REPOSITORY' || V_DBLINK_ORIG || ' R0 '; \n" +
                "END IF;    \n" +
                "V_QUERY_ORI := V_QUERY_ORI ||\n" +
                "' WHERE ';\n" +
                "IF R.TYPE = 'Repository'    THEN\n" +
                "V_QUERY_ORI := V_QUERY_ORI ||\n" +
                "' R0.ROW_ID = T.REPOSITORY_ID AND' ||\n" +
                "' R0.NAME = ''' || V_ORI_REPOSITORY_NAME || ''' AND ' ;\n" +
                "END IF;    \n" +
                "V_QUERY_ORI := V_QUERY_ORI ||\n" +
                "' T.LAST_UPD > TO_DATE(''' || V_DATA || ''', ''DD/MM/YYYY'') ' ;\n" +
                "IF R.ADDITIONAL_SEARCH IS NOT NULL THEN\n" +
                "V_QUERY_ORI := V_QUERY_ORI ||\n" +
                "' AND ' || REPLACE(REPLACE(R.ADDITIONAL_SEARCH, '@', V_DBLINK_ORIG), 'Siebel Repository', V_ORI_REPOSITORY_NAME) || ' ';\n" +
                "END IF;\n" +
                "\n" +
                "\n" +
                "DBMS_OUTPUT.PUT_LINE('teste401');            \n" +
                "V_QUERY_DES :=  ' SELECT T.' || RC.COL_NAME || ', T.LAST_UPD, ' ||\n" +
                "' (SELECT LOGIN FROM SIEBEL.S_USER' || V_DBLINK_DEST || ' WHERE ROW_ID = T.LAST_UPD_BY AND ROWNUM < 2) ' ||\n" +
                "' INTO V_VALOR_DES, V_LAST_UPD_DEST, V_LAST_UPD_BY_DEST ' ||  \n" +
                "' FROM SIEBEL.' || R.NAME || V_DBLINK_DEST || ' T' ; \n" +
                "IF R.TYPE = 'Repository'    THEN\n" +
                "V_QUERY_DES := V_QUERY_DES ||\n" +
                "' ,SIEBEL.S_REPOSITORY' || V_DBLINK_DEST || ' R0 ';\n" +
                "END IF;    \n" +
                "V_QUERY_DES := V_QUERY_DES ||\n" +
                "' WHERE ';\n" +
                "IF R.TYPE = 'Repository'    THEN\n" +
                "V_QUERY_DES := V_QUERY_DES ||\n" +
                "' R0.ROW_ID = T.REPOSITORY_ID AND ' ||\n" +
                "' R0.NAME = ''' || V_DES_REPOSITORY_NAME || ''' AND ' ;                                    \n" +
                "END IF;    \n" +
                "IF R.OTHER_KEY_FIELD IS NOT NULL THEN\n" +
                "IF UPPER(R.OTHER_KEY_FIELD) LIKE '%SELECT%FROM%'   OR UPPER(R.OTHER_KEY_FIELD) LIKE '%].[%' THEN\n" +
                "V_QUERY_DES := V_QUERY_DES ||\n" +
                "UPPER(REPLACE(R.OTHER_KEY_FIELD, '@', V_DBLINK_DEST)) || ' = REG.OTHER_KEY_SUB_SELECT AND ';\n" +
                "ELSE\n" +
                "TABOUTPUT:= fn_split (R.OTHER_KEY_FIELD, ',');\n" +
                "FOR i IN 0 .. TABOUTPUT.COUNT - 1 LOOP\n" +
                "V_QUERY_DES := V_QUERY_DES ||\n" +
                "'NVL(T.' || TABOUTPUT (i) || ',''X'') = NVL(REG.' || TABOUTPUT (i) || ',''X'') AND ';\n" +
                "END LOOP;\n" +
                "END IF;    \n" +
                "ELSE\n" +
                "V_QUERY_DES := V_QUERY_DES ||\n" +
                "' T.NAME = REG.NAME AND ' ; \n" +
                "END IF;\n" +
                "V_QUERY_DES := V_QUERY_DES || \n" +
                "' ROWNUM < 2 ' ;\n" +
                "IF R.ADDITIONAL_SEARCH IS NOT NULL THEN\n" +
                "V_QUERY_DES := V_QUERY_DES ||\n" +
                "' AND ' || REPLACE(REPLACE(R.ADDITIONAL_SEARCH, '@', V_DBLINK_DEST), 'Siebel Repository', V_DES_REPOSITORY_NAME) || ' ';\n" +
                "END IF;\n" +
                "V_QUERY_DES := V_QUERY_DES || V_EXISTS_PARENT || ';' ;\n" +
                "\n" +
                "DBMS_OUTPUT.PUT_LINE('teste402');\n" +
                "V_PL :=   'DECLARE ' ||\n" +
                "'   V_VALOR_DES SIEBEL.' ||  R.NAME || '.' || RC.COL_NAME || V_DBLINK_ORIG || '%TYPE;' ||\n" +
                "'   V_LAST_UPD_DEST SIEBEL.' ||  R.NAME || '.LAST_UPD'  || V_DBLINK_ORIG || '%TYPE;' ||\n" +
                "'   V_LAST_UPD_BY_DEST VARCHAR2(100 Char);' ||\n" +
                "'   ICONTADOR NUMBER;' ||\n" +
                "'BEGIN ' ||\n" +
                "'  FOR REG IN (' || V_QUERY_ORI  || ') LOOP' ||\n" +
                "'    BEGIN ' ||\n" +
                "'           V_VALOR_DES:= NULL; ' ||\n" +
                "'           V_LAST_UPD_DEST:= NULL; ' || \n" +
                "'           V_LAST_UPD_BY_DEST:= NULL; ' ||\n" +
                "'           ' || V_QUERY_DES  ||\n" +
                "'           IF (TRIM(REG.' || RC.COL_NAME || ') <> TRIM(V_VALOR_DES)) THEN ' ||  \n" +
                "' INSERT INTO " + dbOwner + ".BATIMENTO_REPOSITORIO ' ||    \n" +
                "' (' ||\n" +
                "' TYPE,' || \n" +
                "' PAR_N0,' ||\n" +
                "' PAR_N1,' ||\n" +
                "' PAR_N2,' ||\n" +
                "' PAR_N3,' ||\n" +
                "' OBJECT_NAME,' ||\n" +
                "' COLUMN_NAME,' ||                            \n" +
                "' LAST_UPD_ORIG,' ||\n" +
                "' LAST_UPD_DEST,' ||\n" +
                "' LAST_UPD_BY_ORIG,' ||\n" +
                "' LAST_UPD_BY_DEST,' ||                                                        \n" +
                "' VAL_ORIG,' ||    \n" +
                "' VAL_DEST,' ||                \n" +
                "' STATUS,' ||\n" +
                "' DESCRIPTION,' ||    \n" +
                "' GROUP_OBJECT,' ||\n" +
                "' ORDER_COL,' ||\n" +
                "' CTRL_LOG_COMP_REP_ID' ||\n" +
                "' ) VALUES ' || \n" +
                "'  (' ;\n" +
                "V_PL :=  V_PL ||         '  ''' ||  R.TYPE || ''',' || \n" +
                "'  ' ||  V_PAR_N0 || ',' || \n" +
                "'  ' ||  V_PAR_N1 || ',' ||              \n" +
                "'  ' ||  V_PAR_N2 || ',' || \n" +
                "'  ' ||  V_PAR_N3 || ',';\n" +
                "IF R.OTHER_KEY_FIELD IS NOT NULL THEN\n" +
                "IF UPPER(R.OTHER_KEY_FIELD) LIKE '%SELECT%FROM%'   OR UPPER(R.OTHER_KEY_FIELD) LIKE '%].[%' THEN\n" +
                "V_PL := V_PL ||\n" +
                "'NVL(REG.OTHER_KEY_SUB_SELECT, ''NULL''), ';\n" +
                "ELSE    \n" +
                "CONT := 0;\n" +
                "TABOUTPUT:= fn_split (R.OTHER_KEY_FIELD, ',');\n" +
                "V_PL := V_PL || ' ''['' || ';\n" +
                "FOR i IN 0 .. TABOUTPUT.COUNT - 1 LOOP\n" +
                "IF CONT  > 0 THEN\n" +
                "V_PL := V_PL || '|| ''].['' || ';\n" +
                "END IF;\n" +
                "V_PL := V_PL ||\n" +
                "'NVL(REG.' || TRIM(TABOUTPUT (i)) || ', ''NULL'')' ;\n" +
                "CONT := CONT + 1;\n" +
                "END LOOP;\n" +
                "V_PL := V_PL || '|| '']'',';\n" +
                "END IF;\n" +
                "ELSE\n" +
                "V_PL := V_PL ||\n" +
                "'  REG.NAME,' ; \n" +
                "END IF;\n" +
                "IF RC.DATA_TYPE = 'LONG' THEN\n" +
                "REPLACE_VALOR_DES := '''Campo muito longo ... favor validar direto na base de dados.''';\n" +
                "REPLACE_VALOR_ORI := '''Campo muito longo ... favor validar direto na base de dados.''';\n" +
                "ELSE    \n" +
                "REPLACE_VALOR_DES := 'V_VALOR_DES';\n" +
                "REPLACE_VALOR_ORI := 'REG.' || RC.COL_NAME;\n" +
                "END IF;\n" +
                "V_PL := V_PL ||                                            \n" +
                "'  ''' ||  RC.COL_NAME || ''',' ||                                 \n" +
                "'  REG.LAST_UPD,' ||\n" +
                "'  V_LAST_UPD_DEST,' ||\n" +
                "'  REG.LAST_UPD_BY,' ||\n" +
                "'  V_LAST_UPD_BY_DEST,' ||\n" +
                "'  SUBSTR(TO_CHAR(' || REPLACE_VALOR_ORI || '), 1, 250),' ||     \n" +
                "'  SUBSTR(TO_CHAR(' || REPLACE_VALOR_DES || '), 1, 250),' ||                 \n" +
                "'  ''DIVERGENTE'',' ||\n" +
                "'  ''' ||  R.DESCRIPTION || ''',' ||\n" +
                "'  ''' ||  R.GROUP_OBJECT || ''',' ||\n" +
                "'  ''' ||  R.ORDER_COL || ''',' ||\n" +
                "TO_CHAR(VID) ||            \n" +
                "'  ); ' ||                                                 \n" +
                "'  COMMIT; ' || \n" +
                "'END IF; ' ||  \n" +
                "'EXCEPTION WHEN NO_DATA_FOUND THEN ' ||\n" +
                "'SELECT COUNT(1) INTO ICONTADOR FROM " + dbOwner + ".BATIMENTO_REPOSITORIO ' ||\n" +
                "'WHERE ' || \n" +
                "'(    OBJECT_NAME = ' ||  NVL(V_PAR_N0, '''X''') || '  ' ||  \n" +
                "'OR ' || \n" +
                "'     OBJECT_NAME = ' ||  NVL(V_PAR_N1, '''X''') || '  ' ||  \n" +
                "'OR ' ||\n" +
                "'     OBJECT_NAME = ' ||  NVL(V_PAR_N2, '''X''') || '  ' ||  \n" +
                "'OR ' ||\n" +
                "'     OBJECT_NAME = ' ||  NVL(V_PAR_N3, '''X''') || '  ' ||  \n" +
                "'OR ' ||\n" +
                "'OBJECT_NAME = ' ;\n" +
                "IF R.OTHER_KEY_FIELD IS NOT NULL THEN\n" +
                "IF UPPER(R.OTHER_KEY_FIELD) LIKE '%SELECT%FROM%'   OR UPPER(R.OTHER_KEY_FIELD) LIKE '%].[%' THEN\n" +
                "V_PL := V_PL ||\n" +
                "'NVL(REG.OTHER_KEY_SUB_SELECT, ''NULL'') ';\n" +
                "ELSE\n" +
                "CONT := 0;\n" +
                "TABOUTPUT:= fn_split (R.OTHER_KEY_FIELD, ',');\n" +
                "V_PL := V_PL || ' ''['' || ';\n" +
                "FOR i IN 0 .. TABOUTPUT.COUNT - 1 LOOP\n" +
                "IF CONT  > 0 THEN\n" +
                "V_PL := V_PL || '|| ''].['' || ';\n" +
                "END IF;\n" +
                "V_PL := V_PL ||\n" +
                "'NVL(REG.' || TRIM(TABOUTPUT (i)) || ', ''NULL'')' ;\n" +
                "CONT := CONT + 1;\n" +
                "END LOOP;\n" +
                "V_PL := V_PL || '|| '']''';    \n" +
                "END IF;\n" +
                "ELSE\n" +
                "V_PL := V_PL ||\n" +
                "'  REG.NAME ' ; \n" +
                "END IF;                \n" +
                "V_PL := V_PL ||     \n" +
                "')' ||\n" +
                "'AND STATUS = ''NOT EXISTS'' ' ||\n" +
                "'AND GROUP_OBJECT =  ''' ||  R.GROUP_OBJECT || ''' ' ||\n" +
                "'AND ORDER_COL <=  ' ||  R.ORDER_COL || ' ' ||\n" +
                "'AND CTRL_LOG_COMP_REP_ID = ' || TO_CHAR(VID) || ' ;' ||  \n" +
                "'IF ICONTADOR = 0 THEN ' ||                                                  \n" +
                "'  INSERT INTO " + dbOwner + ".BATIMENTO_REPOSITORIO ' ||    \n" +
                "'  (' ||\n" +
                "'  TYPE,' || \n" +
                "'  PAR_N0,' ||\n" +
                "'  PAR_N1,' ||\n" +
                "'  PAR_N2,' ||\n" +
                "'  PAR_N3,' ||\n" +
                "'  OBJECT_NAME,' ||\n" +
                "'  COLUMN_NAME,' ||                                        \n" +
                "'  LAST_UPD_ORIG,' ||\n" +
                "'  LAST_UPD_DEST,' ||\n" +
                "'  LAST_UPD_BY_ORIG,' ||\n" +
                "'  LAST_UPD_BY_DEST,' ||                                                    \n" +
                "'  VAL_ORIG,' ||    \n" +
                "'  VAL_DEST,' ||                \n" +
                "'  STATUS,' ||\n" +
                "'  DESCRIPTION,' ||\n" +
                "' GROUP_OBJECT,' ||\n" +
                "' ORDER_COL,' ||\n" +
                "'  CTRL_LOG_COMP_REP_ID' ||\n" +
                "'  ) VALUES ' || \n" +
                "'  (' ||\n" +
                "'  ''' ||  R.TYPE || ''',' || \n" +
                "'    ' ||  V_PAR_N0 || ',' || \n" +
                "'    ' ||  V_PAR_N1 || ',' ||\n" +
                "'    ' ||  V_PAR_N2 || ',' ||                                                   \n" +
                "'    ' ||  V_PAR_N3 || ',' ;\n" +
                "IF R.OTHER_KEY_FIELD IS NOT NULL THEN\n" +
                "IF UPPER(R.OTHER_KEY_FIELD) LIKE '%SELECT%FROM%'   OR UPPER(R.OTHER_KEY_FIELD) LIKE '%].[%' THEN\n" +
                "V_PL := V_PL ||\n" +
                "'NVL(REG.OTHER_KEY_SUB_SELECT, ''NULL''), ';\n" +
                "ELSE\n" +
                "CONT := 0;\n" +
                "TABOUTPUT:= fn_split (R.OTHER_KEY_FIELD, ',');\n" +
                "V_PL := V_PL || ' ''['' || ';\n" +
                "FOR i IN 0 .. TABOUTPUT.COUNT - 1 LOOP\n" +
                "IF CONT  > 0 THEN\n" +
                "V_PL := V_PL || '|| ''].['' || ';\n" +
                "END IF;\n" +
                "V_PL := V_PL ||\n" +
                "'NVL(REG.' || TRIM(TABOUTPUT (i)) || ', ''NULL'')' ;\n" +
                "CONT := CONT + 1;\n" +
                "END LOOP;\n" +
                "V_PL := V_PL || '|| '']'',';\n" +
                "END IF;\n" +
                "ELSE\n" +
                "V_PL := V_PL ||\n" +
                "'  REG.NAME,' ; \n" +
                "END IF;                \n" +
                "V_PL := V_PL ||    \n" +
                "'              '''',' ||                                 \n" +
                "'          REG.LAST_UPD,' ||\n" +
                "'          V_LAST_UPD_DEST,' ||\n" +
                "'          REG.LAST_UPD_BY,' ||\n" +
                "'          V_LAST_UPD_BY_DEST,' ||\n" +
                "'          SUBSTR(TO_CHAR(REG.' || RC.COL_NAME || '), 1, 250),' ||    \n" +
                "'              '''',' ||                \n" +
                "'        ''NOT EXISTS'',' || \n" +
                "'  ''' ||  R.DESCRIPTION || ''',' ||    \n" +
                "'  ''' ||  R.GROUP_OBJECT || ''',' ||\n" +
                "'  ''' ||  R.ORDER_COL || ''',' ||\n" +
                "TO_CHAR(VID) ||\n" +
                "'  ); ' ||                                                 \n" +
                "'  COMMIT; ' ||\n" +
                "'END IF; ' ||\n" +
                "'END; ' ||                                                \n" +
                "'END LOOP; ' ||\n" +
                "'END; '  ;  \n" +
                "\n" +
                "BEGIN\n" +
                "DBMS_OUTPUT.PUT_LINE(V_PL);\n" +
                "EXECUTE IMMEDIATE V_PL;  \n" +
                "--DBMS_OUTPUT.PUT_LINE(V_PL);\n" +
                "\n" +
                "\n" +
                "EXCEPTION WHEN OTHERS THEN\n" +
                "VERROR:=SUBSTR(SQLERRM, 1, 3000);\n" +
                "UPDATE " + dbOwner + ".CTRL_LOG_COMP_REP \n" +
                "SET \n" +
                "STATUS_DESC = STATUS_DESC || DECODE(STATUS, NULL, '', '' || chr(13) || chr(10) || '') || 'ERRO: ' || VERROR,\n" +
                "STATUS = 'QUEUE PARTIAL ERROR'\n" +
                "WHERE ID = VID;\n" +
                "COMMIT; \n" +
                "\n" +
                "UPDATE " + dbOwner + ".CTRL_LOG_COMP_REP_LOG\n" +
                "SET STATUS = 'PROCESSING WITH ERRORS',\n" +
                "SCRIPT_ERROR = V_PL,\n" +
                "STATUS_DESC = STATUS_DESC || DECODE(STATUS, NULL, '', '' || chr(13) || chr(10) || '') || 'ERRO: [' || RC.COL_NAME ||'] ' || VERROR\n" +
                "WHERE CTRL_LOG_COMP_REP_MASTER_ID = VMASTER_ID\n" +
                "AND CTRL_LOG_COMP_REP_ID = VID\n" +
                "AND TAB_CTRL_BATIMENTO_REP_ID = R.ID\n" +
                "AND FILA = V_FILA;\n" +
                "\n" +
                "COMMIT;                                    \n" +
                "END;\n" +
                "END IF;\n" +
                "END LOOP;        \n" +
                "UPDATE " + dbOwner + ".CTRL_LOG_COMP_REP_LOG\n" +
                "SET STATUS = DECODE(STATUS, 'PROCESSING', 'SUCCESS', 'PARTIAL SUCCESS')\n" +
                "--,SCRIPT_ERROR = V_PL\n" +
                "WHERE \n" +
                "CTRL_LOG_COMP_REP_MASTER_ID = VMASTER_ID\n" +
                "AND CTRL_LOG_COMP_REP_ID = VID\n" +
                "AND TAB_CTRL_BATIMENTO_REP_ID = R.ID\n" +
                "AND FILA = V_FILA;\n" +
                "\n" +
                "COMMIT;\n" +
                "END LOOP;\n" +
                "END IF;\n" +
                "--SELECT STATUS INTO VSTATUS FROM " + dbOwner + ".CTRL_LOG_COMP_REP WHERE ID = VID;\n" +
                "--dbms_output.put_line('VSTATUS = ' || VSTATUS);\n" +
                "\n" +
                "UPDATE " + dbOwner + ".CTRL_LOG_COMP_REP \n" +
                "SET TOTAL_PROCESS_EXECUTED = VTOTAL_PROCESS,\n" +
                "DATE_END = SYSDATE,\n" +
                "STATUS = DECODE(STATUS, 'QUEUE PROCESSING', 'QUEUE SUCCESS', 'QUEUE PARTIAL SUCCESS')\n" +
                "WHERE ID = VID;\n" +
                "COMMIT;\n" +
                "\n" +
                "SELECT COUNT(1) INTO V_VALIDA_FIM FROM " + dbOwner + ".CTRL_LOG_COMP_REP \n" +
                "WHERE MASTER_LOG_COMPARE_ID = VMASTER_ID\n" +
                "AND STATUS = 'QUEUE PROCESSING';\n" +
                "\n" +
                "IF V_VALIDA_FIM = 0 THEN\n" +
                "SELECT COUNT(1) INTO V_VALIDA_FIM FROM " + dbOwner + ".CTRL_LOG_COMP_REP \n" +
                "WHERE MASTER_LOG_COMPARE_ID = VMASTER_ID\n" +
                "AND (STATUS = 'QUEUE PARTIAL SUCCESS' OR STATUS = 'QUEUE FATAL ERROR') ;\n" +
                "\n" +
                "IF V_VALIDA_FIM = 0 THEN\n" +
                "SELECT COUNT(1) INTO V_VALIDA_FIM FROM " + dbOwner + ".CTRL_LOG_COMP_REP \n" +
                "WHERE MASTER_LOG_COMPARE_ID = VMASTER_ID\n" +
                "AND (STATUS = 'QUEUE PARTIAL SUCCESS' OR STATUS = 'QUEUE SUCCESS') ;\n" +
                "\n" +
                "IF V_VALIDA_FIM = 0 THEN\n" +
                "V_STATUS_MASTER := 'FATAL ERROR';\n" +
                "ELSE\n" +
                "V_STATUS_MASTER := 'PARTIAL SUCCESS';\n" +
                "END IF;    \n" +
                "ELSE\n" +
                "V_STATUS_MASTER := 'SUCCESS';\n" +
                "END IF;        \n" +
                "\n" +
                "UPDATE " + dbOwner + ".CTRL_LOG_COMP_REP_MASTER \n" +
                "SET \n" +
                "LAST_UPD = SYSDATE,\n" +
                "STATUS = V_STATUS_MASTER\n" +
                "WHERE ID = VMASTER_ID;\n" +
                "COMMIT;\n" +
                "\n" +
                "END IF;\n" +
                "\n" +
                "EXCEPTION WHEN OTHERS THEN    \n" +
                "VERROR:=SUBSTR(SQLERRM, 1, 3000);\n" +
                "\n" +
                "SELECT COUNT(1) INTO V_VALIDA_LOG FROM " + dbOwner + ".CTRL_LOG_COMP_REP_LOG \n" +
                "WHERE \n" +
                "CTRL_LOG_COMP_REP_MASTER_ID = VMASTER_ID\n" +
                "AND CTRL_LOG_COMP_REP_ID = VID\n" +
                "AND FILA = V_FILA;\n" +
                "\n" +
                "IF     V_VALIDA_LOG > 0 THEN\n" +
                "UPDATE " + dbOwner + ".CTRL_LOG_COMP_REP_LOG SET\n" +
                "STATUS = 'FATAL ERROR',\n" +
                "SCRIPT_ERROR = V_PL\n" +
                "WHERE \n" +
                "CTRL_LOG_COMP_REP_MASTER_ID = VMASTER_ID\n" +
                "AND CTRL_LOG_COMP_REP_ID = VID\n" +
                "AND FILA = V_FILA;\n" +
                "\n" +
                "COMMIT;                    \n" +
                "END IF;\n" +
                "\n" +
                "UPDATE " + dbOwner + ".CTRL_LOG_COMP_REP \n" +
                "SET \n" +
                "STATUS_DESC = STATUS_DESC || DECODE(STATUS, NULL, '', '' || chr(13) || chr(10) || '') || 'ERRO: ' || VERROR,\n" +
                "STATUS = 'QUEUE FATAL ERROR'\n" +
                "WHERE ID = VID;\n" +
                "\n" +
                "COMMIT;  \n" +
                "\n" +
                "SELECT COUNT(1) INTO V_VALIDA_FIM FROM " + dbOwner + ".CTRL_LOG_COMP_REP \n" +
                "WHERE MASTER_LOG_COMPARE_ID = VMASTER_ID\n" +
                "AND STATUS = 'QUEUE PROCESSING';\n" +
                "\n" +
                "IF V_VALIDA_FIM = 0 THEN\n" +
                "SELECT COUNT(1) INTO V_VALIDA_FIM FROM " + dbOwner + ".CTRL_LOG_COMP_REP \n" +
                "WHERE MASTER_LOG_COMPARE_ID = VMASTER_ID\n" +
                "AND (STATUS = 'QUEUE PARTIAL SUCCESS' OR STATUS = 'QUEUE FATAL ERROR') ;\n" +
                "\n" +
                "IF V_VALIDA_FIM = 0 THEN\n" +
                "SELECT COUNT(1) INTO V_VALIDA_FIM FROM " + dbOwner + ".CTRL_LOG_COMP_REP \n" +
                "WHERE MASTER_LOG_COMPARE_ID = VMASTER_ID\n" +
                "AND (STATUS = 'QUEUE PARTIAL SUCCESS' OR STATUS = 'QUEUE SUCCESS') ;\n" +
                "\n" +
                "IF V_VALIDA_FIM = 0 THEN\n" +
                "V_STATUS_MASTER := 'FATAL ERROR';\n" +
                "ELSE\n" +
                "V_STATUS_MASTER := 'PARTIAL SUCCESS';\n" +
                "END IF;    \n" +
                "ELSE\n" +
                "V_STATUS_MASTER := 'SUCCESS';\n" +
                "END IF;        \n" +
                "\n" +
                "UPDATE " + dbOwner + ".CTRL_LOG_COMP_REP_MASTER \n" +
                "SET \n" +
                "LAST_UPD = SYSDATE,\n" +
                "STATUS = V_STATUS_MASTER\n" +
                "WHERE ID = VMASTER_ID;\n" +
                "COMMIT;\n" +
                "\n" +
                "END IF;\n" +
                "\n" +
                "END;" +
            "BEGIN\n" +
            "	EXEC_COMPARE(\n" +
            "   '" + RepOrigemName + "',\n" +
            "   '" + RepDestinoName + "',\n" +
            "   '@" + DbLinkOrigem + "',\n" +
            "   '@" + DbLinkDestino + "',\n" +
            "   '" + Data + "',\n" +
            "   " + FilaThreads + ",\n" +
            "   '" + ConfName + "'\n" +
            ") ;\n" +
            "END;";
    }
    
    public String queryCompareRepMaster(String RepOrigemName, String RepDestinoName, String DbLinkOrigem, String DbLinkDestino, String ConfName, String dbOwner){
        return
        "DECLARE \n" +
        "    V_ORI_REPOSITORY_NAME VARCHAR2(200):= '" + RepOrigemName + "';\n" +
        "    V_DES_REPOSITORY_NAME VARCHAR2(200):= '" + RepDestinoName + "';\n" +
        "    V_DBLINK_ORIG VARCHAR2(200):= '@" + DbLinkOrigem + "';\n" +
        "    V_DBLINK_DEST VARCHAR2(200):= '@" + DbLinkDestino + "';\n" +
        "    V_CONFIGURATION_NAME VARCHAR2(100 Char):= '" + ConfName + "';\n" +
        "    VDATE_START DATE;\n" +
        "    VMASTER_LOG_COMPARE_ID NUMBER(22);\n" +
        "    VTOTAL_PROCESS NUMBER(10);\n" +
        "BEGIN\n" +
        "    INSERT INTO " + dbOwner + ".CTRL_LOG_COMP_REP_MASTER (ID,CREATED,LAST_UPD,CONFIGURATION_NAME)\n" +
        "    VALUES(" + dbOwner + ".COMPARE_REP_MASTER.NEXTVAL,SYSDATE,SYSDATE, V_CONFIGURATION_NAME);\n" +
        "    COMMIT;\n" +
        "\n" +
        "    VMASTER_LOG_COMPARE_ID := " + dbOwner + ".COMPARE_REP_MASTER.CURRVAL;\n" +
        "    \n" +
        "    FOR R IN (SELECT DISTINCT FILA FROM " + dbOwner + ".TAB_CTRL_BATIMENTO_REP TBC WHERE TBC.INACTIVE_FLG = 'N' AND CONFIGURATION_NAME = V_CONFIGURATION_NAME ORDER BY FILA) LOOP\n" +
        "        SELECT\n" +
        "            COUNT(1) INTO VTOTAL_PROCESS\n" +
        "        FROM " + dbOwner + ".TAB_CTRL_BATIMENTO_REP TBC\n" +
        "        WHERE TBC.INACTIVE_FLG = 'N'\n" +
        "        AND TBC.FILA = R.FILA\n" +
        "        AND CONFIGURATION_NAME = V_CONFIGURATION_NAME;\n" +
        "        --SELECT MAX(ID) + 1 INTO VID FROM CTRL_LOG_COMP_REP;\n" +
        "        -- IF VID = 0 OR VID IS NULL THEN\n" +
        "        -- VID: = 1;\n" +
        "        -- END IF;\n" +
        "        \n" +
        "        VDATE_START := SYSDATE;\n" +
        "        \n" +
        "        INSERT INTO " + dbOwner + ".CTRL_LOG_COMP_REP (ID,TOTAL_PROCESS_TO_EXEC,TOTAL_PROCESS_EXECUTED,TABLE_NAME,ACTUAL_TYPE,ACTUAL_DESCRIPTION,ORI_REPOSITORY_NAME,DES_REPOSITORY_NAME,DBLINK_ORIG,DBLINK_DEST,DATE_START,DATE_END,FILA,MASTER_LOG_COMPARE_ID,CONFIGURATION_NAME)\n" +
        "        VALUES (" + dbOwner + ".COMPARE_REP_MASTER.NEXTVAL,VTOTAL_PROCESS,0,'Pending','Pending','Pending',V_ORI_REPOSITORY_NAME,V_DES_REPOSITORY_NAME,V_DBLINK_ORIG,V_DBLINK_DEST,VDATE_START,NULL,R.FILA,VMASTER_LOG_COMPARE_ID,V_CONFIGURATION_NAME);\n" +
        "        COMMIT;\n" +
        "    END LOOP;\n" +
        "END;";
    }
    
    public String getQueryRelatorioBatimento(String dbOwner){
        return 
            "SELECT\n" +
            "	A.* \n" +
            "FROM " + dbOwner + ".BATIMENTO_REPOSITORIO A\n" +
            "WHERE CTRL_LOG_COMP_REP_ID IN(\n" +
            "	SELECT\n" +
            "       ID\n" +
            "	FROM " + dbOwner + ".CTRL_LOG_COMP_REP\n" +
            "	WHERE MASTER_LOG_COMPARE_ID = (\n" +
            "       SELECT\n" +
            "           MAX(ID)\n" +
            "       FROM " + dbOwner + ".CTRL_LOG_COMP_REP_MASTER\n" +
            "	)\n" +
            ")\n" +
            "AND NOT EXISTS (\n" +
            "	SELECT\n" +
            "		1\n" +
            "	FROM " + dbOwner + ".BATIMENTO_REPOSITORIO B\n" +
            "	WHERE A.CTRL_LOG_COMP_REP_ID IN (\n" +
            "       SELECT\n" +
            "           ID\n" +
            "       FROM " + dbOwner + ".CTRL_LOG_COMP_REP\n" +
            "       WHERE MASTER_LOG_COMPARE_ID = (\n" +
            "           SELECT\n" +
            "               MAX(ID)\n" +
            "           FROM " + dbOwner + ".CTRL_LOG_COMP_REP_MASTER\n" +
            "       )\n" +
            "	)\n" +
            "	AND (\n" +
            "       B.OBJECT_NAME = A.PAR_N0\n" +
            "       OR B.OBJECT_NAME = A.PAR_N1\n" +
            "       OR B.OBJECT_NAME = A.PAR_N2\n" +
            "       OR B.OBJECT_NAME = A.PAR_N3\n" +
            "	)\n" +
            "	AND B.STATUS = 'NOT EXISTS'\n" +
            "	AND B.GROUP_OBJECT = A.GROUP_OBJECT\n" +
            "	AND B.ORDER_COL <= A.ORDER_COL\n" +
            ")\n" +
            "ORDER BY PAR_N0, ORDER_COL, DESCRIPTION";
    }
    
}