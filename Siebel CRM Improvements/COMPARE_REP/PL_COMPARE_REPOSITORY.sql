DECLARE
	TYPE tabsplit IS TABLE OF VARCHAR2 (50) INDEX BY BINARY_INTEGER;

	FUNCTION fn_split (mp_string IN VARCHAR2, mp_delimiter IN VARCHAR2)
		RETURN tabsplit
		IS
		ml_point     NUMBER (5, 0) := 1;
		ml_sub_str   VARCHAR2 (50);
		i            NUMBER (5, 0) := 1;
		taboutput    tabsplit;
		ml_count     NUMBER (5, 0) := 0;    
	BEGIN
		WHILE i <= LENGTH (mp_string)
		LOOP
			FOR j IN i .. LENGTH (mp_string)
			LOOP
				IF SUBSTR (mp_string, j, 1) = mp_delimiter
				THEN
					ml_sub_str := SUBSTR (mp_string, ml_point, j - ml_point);
					ml_point := j + 1;
					i := ml_point;
					i := i - 1;
					taboutput (ml_count) := ml_sub_str;
					ml_count := ml_count + 1;
					EXIT;
				END IF;
			END LOOP;

			i := i + 1;
		END LOOP;

		ml_sub_str := SUBSTR (mp_string, ml_point, LENGTH (mp_string));
		taboutput (ml_count) := ml_sub_str;

		RETURN taboutput;
	END fn_split;

	PROCEDURE EXEC_COMPARE(V_ORI_REPOSITORY_NAME IN VARCHAR2, V_DES_REPOSITORY_NAME IN VARCHAR2, V_DBLINK_ORIG IN VARCHAR2, V_DBLINK_DEST IN VARCHAR2, V_DATA IN VARCHAR2, V_FILA IN NUMBER, V_CONFIGURATION_NAME IN VARCHAR2) IS
		-- Declaração de Variáveis
		TABOUTPUT   TABSPLIT;
		V_QUERY_ORI VARCHAR2(4000);
		V_QUERY_DES VARCHAR2(4000);
		V_PL CLOB;
		--V_PL VARCHAR2(4000 CHAR);
		V_SUB_SELECT  VARCHAR2(4000);
		V_EXISTS_PARENT  VARCHAR2(4000);
		V_PAR_N0 VARCHAR2(1000);
		V_PAR_N1 VARCHAR2(1000); 
		V_PAR_N2 VARCHAR2(1000); 
		V_PAR_N3 VARCHAR2(1000);
		V_SUB_SELECT_PAR_N0 VARCHAR2(4000);
		VEXIT CHAR(1);
		CONT NUMBER(22):= 0;
		VTOTAL_PROCESS NUMBER(10):= 0;
		VDATE_START DATE;
		VDATE_END DATE;
		VID NUMBER(22):=0;
		V_VALIDA_LOG NUMBER(22):=0;
		V_VALIDA_FIM NUMBER(22):=0;
		V_STATUS_MASTER VARCHAR2(100 CHAR);
		VMASTER_ID NUMBER(22):=0;
		VERROR VARCHAR2(4000 CHAR);
		V_OTHER_PARENT_KEY0  VARCHAR2(4000);
		V_OTHER_PARENT_KEY1  VARCHAR2(4000);
		V_OTHER_PARENT_KEY2  VARCHAR2(4000);
		V_OTHER_PARENT_KEY3  VARCHAR2(4000);
		V_COL_PAR0  VARCHAR2(4000);
		V_COL_PAR1  VARCHAR2(4000);
		V_COL_PAR2  VARCHAR2(4000);
		V_COL_PAR3  VARCHAR2(4000);
		REPLACE_VALOR_DES  VARCHAR2(1000);
		REPLACE_VALOR_ORI  VARCHAR2(1000);
		VSTATUS VARCHAR2(1000);
		
		-- Cursores
		CURSOR C_TABLE IS
			SELECT 
				TBC.TABLE_NAME NAME, 
				(
					SELECT
						T.ROW_ID 
					FROM
						SIEBEL.S_TABLE@DEV2SBL8 T,
						SIEBEL.S_REPOSITORY@DEV2SBL8 REP 
					WHERE T.NAME = TBC.TABLE_NAME 
					AND REP.NAME = 'Siebel Repository'
					AND REP.ROW_ID = T.REPOSITORY_ID 
					AND ROWNUM < 2
				) ROW_ID,
				(
					SELECT
						BC.NAME 
					FROM 
						SIEBEL.S_BUSCOMP@DEV2SBL8 BC,
						SIEBEL.S_REPOSITORY@DEV2SBL8 REP 
					WHERE BC.TABLE_NAME = TBC.TABLE_NAME
					AND REP.NAME = 'Siebel Repository'
					AND REP.ROW_ID = BC.REPOSITORY_ID 
					AND ROWNUM < 2) BCNAME,
				TBC.JOIN3,
				TBC.TAB_P3,
				TBC.JOIN2,
				TBC.TAB_P2,
				TBC.JOIN1,
				TBC.TAB_P1,
				TBC.JOIN0,
				TBC.TAB_P0,
				TBC.TYPE,
				TBC.DESCRIPTION,
				TBC.OTHER_KEY_FIELD,
				TBC.ADDITIONAL_SEARCH,
				TBC.ID,
				TBC.GROUP_OBJECT,
				TBC.ORDER_COL,
				TBC.CONFIGURATION_NAME
			FROM SADMIN.TAB_CTRL_BATIMENTO_REP TBC
			WHERE TBC.INACTIVE_FLG = 'N'
			AND TBC.FILA = V_FILA
			AND TBC.CONFIGURATION_NAME = V_CONFIGURATION_NAME
			ORDER BY TBC.GROUP_OBJECT, TBC.ORDER_COL, TBC.DESCRIPTION ASC;

		CURSOR C_COLUMN (V_TBL_ID VARCHAR2) IS
			SELECT
				T.NAME TABLE_NAME, 
				C.NAME COL_NAME, 
				C.ROW_ID, 
				(
					SELECT
						F.NAME 
					FROM
						SIEBEL.S_FIELD@DEV2SBL8 F,
						SIEBEL.S_BUSCOMP@DEV2SBL8 B 
					WHERE F.BUSCOMP_ID = B.ROW_ID 
					AND B.TABLE_NAME = T.NAME 
					AND F.COL_NAME = C.NAME 
					AND ROWNUM < 2
				) FIELD_NAME,
				(
					SELECT
						DATA_TYPE
					FROM ALL_TAB_COLUMNS@DEV2SBL8
					WHERE COLUMN_NAME = C.NAME
					AND TABLE_NAME = T.NAME
					AND ROWNUM < 2
				) DATA_TYPE
			FROM 
				SIEBEL.S_COLUMN@DEV2SBL8 C,
				SIEBEL.S_TABLE@DEV2SBL8 T,  
				SIEBEL.S_REPOSITORY@DEV2SBL8 R  
			WHERE C.REPOSITORY_ID = R.ROW_ID
			AND C.TYPE <> 'System'
			AND C.NAME NOT IN ('COMMENTS', 'NAME', 'REPOSITORY_ID', 'OBJ_LOCKED_BY','OBJ_LOCKED_DATE', 'OBJ_LOCKED_FLG', 'OBJ_LOCKED_LANG','REV_NUM', 'PROJECT_ID', 'TO_STEP_ID', 'FROM_STEP_ID', 'LAYOUT', 'AUTO_MAPPED_FLG')
			AND T.NAME || '.' || C.NAME NOT IN (SELECT TABELA || '.' || COLUNA FROM SADMIN.TAB_CTRL_COLUMN_EXCEPTION)
			AND C.NAME NOT LIKE '%_ID'
			AND R.NAME = 'Siebel Repository'
			AND T.ROW_ID = C.TBL_ID
			AND C.TBL_ID = V_TBL_ID
			AND EXISTS (SELECT 1 FROM ALL_TAB_COLUMNS@DEV2SBL8 WHERE COLUMN_NAME = C.NAME AND TABLE_NAME = T.NAME AND ROWNUM < 2);

		-- Início da execução
		BEGIN
			DBMS_OUTPUT.PUT_LINE('teste9');
			SELECT 
				NVL(MAX(ID),0)
			INTO VID
			FROM SADMIN.CTRL_LOG_COMP_REP TUPD 
			WHERE FILA = V_FILA
			AND TABLE_NAME = 'Pending'
			AND ACTUAL_TYPE = 'Pending'
			AND ACTUAL_DESCRIPTION = 'Pending'
			AND CONFIGURATION_NAME = V_CONFIGURATION_NAME;
			
			DBMS_OUTPUT.PUT_LINE('teste10 - ' || to_char(VID)|| ' - FILA: '|| TO_CHAR(V_FILA));
			IF VID > 0 THEN  
			
				SELECT
					TOTAL_PROCESS_TO_EXEC
				INTO VTOTAL_PROCESS
				FROM SADMIN.CTRL_LOG_COMP_REP TUPD 
				WHERE TUPD.ID = VID;
				DBMS_OUTPUT.PUT_LINE('teste11');
				FOR R IN C_TABLE LOOP
			
					UPDATE SADMIN.CTRL_LOG_COMP_REP TUPD
					SET 
						TUPD.TOTAL_PROCESS_EXECUTED = VTOTAL_PROCESS,   
						TUPD.TABLE_NAME =  TO_CHAR(R.NAME) ,
						STATUS = 'QUEUE PROCESSING',
						TUPD.ACTUAL_DESCRIPTION =  TO_CHAR(R.DESCRIPTION), 
						TUPD.ACTUAL_TYPE =  R.TYPE
						WHERE TUPD.ID = VID;
					COMMIT;
					DBMS_OUTPUT.PUT_LINE('teste12');
					SELECT MASTER_LOG_COMPARE_ID INTO VMASTER_ID FROM SADMIN.CTRL_LOG_COMP_REP WHERE ID = VID;
					DBMS_OUTPUT.PUT_LINE('teste13');
					INSERT INTO SADMIN.CTRL_LOG_COMP_REP_LOG
						(
						  TABLE_NAME                  ,
						  CTRL_LOG_COMP_REP_MASTER_ID ,
						  CTRL_LOG_COMP_REP_ID        ,
						  TAB_CTRL_BATIMENTO_REP_ID   ,
						  FILA                        ,
						  STATUS                      ,
						  STATUS_DESC                 
						) VALUES
						(
						R.NAME,
						VMASTER_ID,
						VID,
						R.ID,
						V_FILA,
						'PROCESSING',
						''                            
						);
					COMMIT;
					DBMS_OUTPUT.PUT_LINE('teste14');
					VTOTAL_PROCESS:= VTOTAL_PROCESS - 1;
					
					V_SUB_SELECT := '';
					V_EXISTS_PARENT := '';
					V_PAR_N0 := '''''';
					V_PAR_N1 := '''''';
					V_PAR_N2 := '''''';
					V_PAR_N3 := '''''';
					DBMS_OUTPUT.PUT_LINE('teste15');
				
					IF (R.TAB_P3 IS NOT NULL) THEN
						BEGIN
							SELECT OTHER_KEY_FIELD INTO V_OTHER_PARENT_KEY0
							FROM SADMIN.TAB_CTRL_BATIMENTO_REP WHERE
							GROUP_OBJECT = R.GROUP_OBJECT
							AND CONFIGURATION_NAME = R.CONFIGURATION_NAME
							AND TABLE_NAME = R.TAB_P0
							AND ORDER_COL = R.ORDER_COL - 4;
						EXCEPTION WHEN OTHERS THEN    
							V_OTHER_PARENT_KEY0 := NULL;
						END;
						DBMS_OUTPUT.PUT_LINE('teste16');
						BEGIN                                
							SELECT OTHER_KEY_FIELD INTO V_OTHER_PARENT_KEY1
							FROM SADMIN.TAB_CTRL_BATIMENTO_REP WHERE
							GROUP_OBJECT = R.GROUP_OBJECT
							AND CONFIGURATION_NAME = R.CONFIGURATION_NAME
							AND TABLE_NAME = R.TAB_P1
							AND ORDER_COL = R.ORDER_COL - 3;                            
						EXCEPTION WHEN OTHERS THEN    
							V_OTHER_PARENT_KEY1 := NULL;
						END;
						DBMS_OUTPUT.PUT_LINE('teste17');
						BEGIN
							SELECT OTHER_KEY_FIELD INTO V_OTHER_PARENT_KEY2
							FROM SADMIN.TAB_CTRL_BATIMENTO_REP WHERE
							GROUP_OBJECT = R.GROUP_OBJECT
							AND CONFIGURATION_NAME = R.CONFIGURATION_NAME
							AND TABLE_NAME = R.TAB_P2
							AND ORDER_COL = R.ORDER_COL - 2;
						EXCEPTION WHEN OTHERS THEN    
							V_OTHER_PARENT_KEY2 := NULL;
						END;
						DBMS_OUTPUT.PUT_LINE('teste18');
						BEGIN
							SELECT OTHER_KEY_FIELD INTO V_OTHER_PARENT_KEY3
							FROM SADMIN.TAB_CTRL_BATIMENTO_REP WHERE
							GROUP_OBJECT = R.GROUP_OBJECT
							AND CONFIGURATION_NAME = R.CONFIGURATION_NAME
							AND TABLE_NAME = R.TAB_P3
							AND ORDER_COL = R.ORDER_COL - 1;                            
						EXCEPTION WHEN OTHERS THEN    
							V_OTHER_PARENT_KEY3 := NULL;
						END;
						DBMS_OUTPUT.PUT_LINE('teste19');
						IF V_OTHER_PARENT_KEY0 IS NOT NULL THEN
							IF UPPER(SUBSTR(TRIM(REPLACE(V_OTHER_PARENT_KEY0, '(', '')), 1, 6)) = 'SELECT' THEN
								V_COL_PAR0 := '(' || REPLACE(V_OTHER_PARENT_KEY0, '''', '''''') || ')';
							ELSE
								V_COL_PAR0 := '''[''|| TAB.' || REPLACE(REPLACE(V_OTHER_PARENT_KEY0, ' ', ''), ',', '|| ''].['' ||TAB.') || '|| '']''';
							END IF;
						ELSE
							V_COL_PAR0 := ' TAB.NAME'; 
						END IF;                            
						DBMS_OUTPUT.PUT_LINE('teste20');
						IF V_OTHER_PARENT_KEY1 IS NOT NULL THEN
							IF UPPER(SUBSTR(TRIM(REPLACE(V_OTHER_PARENT_KEY1, '(', '')), 1, 6)) = 'SELECT' THEN
								V_COL_PAR0 := '(' || REPLACE(V_OTHER_PARENT_KEY1, '''', '''''') || ')';
							ELSE
								V_COL_PAR1 := '''[''|| TAB1.' || REPLACE(REPLACE(V_OTHER_PARENT_KEY1, ' ', ''), ',', '|| ''].['' ||TAB1.') || '|| '']''';
							END IF;
						ELSE
							V_COL_PAR1 := ' TAB1.NAME'; 
						END IF;    
						DBMS_OUTPUT.PUT_LINE('teste21');
						IF V_OTHER_PARENT_KEY2 IS NOT NULL THEN
							IF UPPER(SUBSTR(TRIM(REPLACE(V_OTHER_PARENT_KEY2, '(', '')), 1, 6)) = 'SELECT' THEN
								V_COL_PAR0 := '(' || REPLACE(V_OTHER_PARENT_KEY2, '''', '''''') || ')';
							ELSE    
								V_COL_PAR2 := '''[''|| TAB2.' || REPLACE(REPLACE(V_OTHER_PARENT_KEY2, ' ', ''), ',', '|| ''].['' ||TAB2.') || '|| '']''';
							END IF;
						ELSE
							V_COL_PAR2 := ' TAB2.NAME'; 
						END IF;    
						DBMS_OUTPUT.PUT_LINE('teste22');
						IF V_OTHER_PARENT_KEY3 IS NOT NULL THEN
							IF UPPER(SUBSTR(TRIM(REPLACE(V_OTHER_PARENT_KEY3, '(', '')), 1, 6)) = 'SELECT' THEN
								V_COL_PAR0 := '(' || REPLACE(V_OTHER_PARENT_KEY3, '''', '''''') || ')';
							ELSE    
								V_COL_PAR3 := '''[''|| TAB3.' || REPLACE(REPLACE(V_OTHER_PARENT_KEY3, ' ', ''), ',', '|| ''].['' ||TAB3.') || '|| '']''';
							END IF;
						ELSE
							V_COL_PAR3 := ' TAB3.NAME'; 
						END IF;                            
						DBMS_OUTPUT.PUT_LINE('teste23');
						V_SUB_SELECT  := ', (SELECT '|| V_COL_PAR0 ||' FROM ' || 
											   ' SIEBEL.' || R.TAB_P0 || V_DBLINK_ORIG ||' TAB, ' || 
											   ' SIEBEL.' || R.TAB_P1 || V_DBLINK_ORIG || ' TAB1, ' ||
											   ' SIEBEL.' || R.TAB_P2 || V_DBLINK_ORIG || ' TAB2, ' ||
											   ' SIEBEL.' || R.TAB_P3 || V_DBLINK_ORIG || ' TAB3 ' ||
											   ' WHERE ' ||
											   ' T.' || R.JOIN3 || ' = TAB3.ROW_ID ' ||
											   ' AND ' ||
											   ' TAB3.' || R.JOIN2 || ' = TAB2.ROW_ID ' ||
											   ' AND ' ||
											   ' TAB2.' || R.JOIN1 || ' = TAB1.ROW_ID ' ||
											   ' AND ' ||                                   
											   ' TAB1.' || R.JOIN0 || ' = TAB.ROW_ID ) PAR_N0';
						V_SUB_SELECT  := V_SUB_SELECT || ', ' ||  
											   ' (SELECT '|| V_COL_PAR1 ||' FROM ' ||
											   ' SIEBEL.' || R.TAB_P0 || V_DBLINK_ORIG ||' TAB, ' || 
											   ' SIEBEL.' || R.TAB_P1 || V_DBLINK_ORIG || ' TAB1, ' ||
											   ' SIEBEL.' || R.TAB_P2 || V_DBLINK_ORIG || ' TAB2, ' ||
											   ' SIEBEL.' || R.TAB_P3 || V_DBLINK_ORIG || ' TAB3 ' ||
											   ' WHERE ' ||
											   ' T.' || R.JOIN3 || ' = TAB3.ROW_ID ' ||
											   ' AND ' ||
											   ' TAB3.' || R.JOIN2 || ' = TAB2.ROW_ID ' ||
											   ' AND ' ||
											   ' TAB2.' || R.JOIN1 || ' = TAB1.ROW_ID ' ||
											   ' AND ' ||                                   
											   ' TAB1.' || R.JOIN0 || ' = TAB.ROW_ID ) PAR_N1';                                               
						V_SUB_SELECT  := V_SUB_SELECT || ', ' || 
											   ' (SELECT '|| V_COL_PAR2 ||' FROM ' ||
											   ' SIEBEL.' || R.TAB_P0 || V_DBLINK_ORIG ||' TAB, ' || 
											   ' SIEBEL.' || R.TAB_P1 || V_DBLINK_ORIG || ' TAB1, ' ||
											   ' SIEBEL.' || R.TAB_P2 || V_DBLINK_ORIG || ' TAB2, ' ||
											   ' SIEBEL.' || R.TAB_P3 || V_DBLINK_ORIG || ' TAB3 ' ||
											   ' WHERE ' ||
											   ' T.' || R.JOIN3 || ' = TAB3.ROW_ID ' ||
											   ' AND ' ||
											   ' TAB3.' || R.JOIN2 || ' = TAB2.ROW_ID ' ||
											   ' AND ' ||
											   ' TAB2.' || R.JOIN1 || ' = TAB1.ROW_ID ' ||
											   ' AND ' ||                                   
											   ' TAB1.' || R.JOIN0 || ' = TAB.ROW_ID ) PAR_N2';
						V_SUB_SELECT  := V_SUB_SELECT || ', ' || 
											   '(SELECT '|| V_COL_PAR3 ||' FROM ' ||
											   ' SIEBEL.' || R.TAB_P0 || V_DBLINK_ORIG ||' TAB, ' || 
											   ' SIEBEL.' || R.TAB_P1 || V_DBLINK_ORIG || ' TAB1, ' ||
											   ' SIEBEL.' || R.TAB_P2 || V_DBLINK_ORIG || ' TAB2, ' ||
											   ' SIEBEL.' || R.TAB_P3 || V_DBLINK_ORIG || ' TAB3 ' ||
											   ' WHERE ' ||
											   ' T.' || R.JOIN3 || ' = TAB3.ROW_ID ' ||
											   ' AND ' ||
											   ' TAB3.' || R.JOIN2 || ' = TAB2.ROW_ID ' ||
											   ' AND ' ||
											   ' TAB2.' || R.JOIN1 || ' = TAB1.ROW_ID ' ||
											   ' AND ' ||                                   
											   ' TAB1.' || R.JOIN0 || ' = TAB.ROW_ID ) PAR_N3';
						V_EXISTS_PARENT :=                      
									' AND EXISTS ( ' || 
									' SELECT 1 FROM ' || 
									' SIEBEL.' || R.TAB_P0 || V_DBLINK_DEST || ' TAB, ' || 
									' SIEBEL.' || R.TAB_P1 || V_DBLINK_DEST || ' TAB1,' ||
									' SIEBEL.' || R.TAB_P2 || V_DBLINK_DEST || ' TAB2,' ||
									' SIEBEL.' || R.TAB_P3 || V_DBLINK_DEST || ' TAB3';
									IF R.TYPE = 'Repository'    THEN                                        
										V_EXISTS_PARENT := V_EXISTS_PARENT || 
										' ,SIEBEL.S_REPOSITORY' || V_DBLINK_DEST || ' REP  ';
									END IF;
									V_EXISTS_PARENT := V_EXISTS_PARENT || 
									' WHERE ' ||
									' T.' || R.JOIN3 || ' = TAB3.ROW_ID ' ||
									' AND ' ||
									' TAB3.' || R.JOIN2 || ' = TAB2.ROW_ID ' ||
									' AND ' ||
									' TAB2.' || R.JOIN1 || ' = TAB1.ROW_ID ' ||
									' AND ' ||
									' TAB1.' || R.JOIN0 || ' = TAB.ROW_ID ' ||        
									' AND ' ||                                   
									' '|| V_COL_PAR0 ||' = REG.PAR_N0 ' ||
									' AND ' ||
									' '|| V_COL_PAR1 ||' = REG.PAR_N1 ' ||
									' AND ' ||                                             
									' '|| V_COL_PAR2 ||' = REG.PAR_N2 ' ||
									' AND ' ||                                             
									' '|| V_COL_PAR3 ||' = REG.PAR_N3 ';
									IF R.TYPE = 'Repository'    THEN                                             
										V_EXISTS_PARENT := V_EXISTS_PARENT ||      
										' AND ' ||  
										' TAB.REPOSITORY_ID = REP.ROW_ID ' ||
										' AND ' ||  
										' TAB1.REPOSITORY_ID = REP.ROW_ID ' ||
										' AND ' ||  
										' TAB2.REPOSITORY_ID = REP.ROW_ID ' ||
										' AND ' ||  
										' TAB3.REPOSITORY_ID = REP.ROW_ID ' ||
										' AND ' || 
										' REP.NAME = ''' || V_DES_REPOSITORY_NAME || '''' ;
									END IF;                                             
									V_EXISTS_PARENT := V_EXISTS_PARENT ||   ' )';
					  
						V_PAR_N0 := 'REG.PAR_N0';
						V_PAR_N1 := 'REG.PAR_N1';
						V_PAR_N2 := 'REG.PAR_N2';
						V_PAR_N3 := 'REG.PAR_N3';      
						DBMS_OUTPUT.PUT_LINE('teste24');                      
					ELSIF (R.TAB_P2 IS NOT NULL) THEN
						BEGIN
							SELECT OTHER_KEY_FIELD INTO V_OTHER_PARENT_KEY0
							FROM SADMIN.TAB_CTRL_BATIMENTO_REP WHERE
							GROUP_OBJECT = R.GROUP_OBJECT
							AND CONFIGURATION_NAME = R.CONFIGURATION_NAME
							AND TABLE_NAME = R.TAB_P0
							AND ORDER_COL = R.ORDER_COL - 3;
						EXCEPTION WHEN OTHERS THEN    
							V_OTHER_PARENT_KEY0 := NULL;
						END;
						DBMS_OUTPUT.PUT_LINE('teste25');
						BEGIN
							SELECT OTHER_KEY_FIELD INTO V_OTHER_PARENT_KEY1
							FROM SADMIN.TAB_CTRL_BATIMENTO_REP WHERE
							GROUP_OBJECT = R.GROUP_OBJECT
							AND CONFIGURATION_NAME = R.CONFIGURATION_NAME
							AND TABLE_NAME = R.TAB_P1
							AND ORDER_COL = R.ORDER_COL - 2;                            
						EXCEPTION WHEN OTHERS THEN    
							V_OTHER_PARENT_KEY1 := NULL;
						END;
						DBMS_OUTPUT.PUT_LINE('teste26');
						BEGIN
							SELECT OTHER_KEY_FIELD INTO V_OTHER_PARENT_KEY2
							FROM SADMIN.TAB_CTRL_BATIMENTO_REP WHERE
							GROUP_OBJECT = R.GROUP_OBJECT
							AND CONFIGURATION_NAME = R.CONFIGURATION_NAME
							AND TABLE_NAME = R.TAB_P2
							AND ORDER_COL = R.ORDER_COL - 1;    
						EXCEPTION WHEN OTHERS THEN    
							V_OTHER_PARENT_KEY2 := NULL;
						END;
						DBMS_OUTPUT.PUT_LINE('teste27');
						IF V_OTHER_PARENT_KEY0 IS NOT NULL THEN
							IF UPPER(SUBSTR(TRIM(REPLACE(V_OTHER_PARENT_KEY0, '(', '')), 1, 6)) = 'SELECT' THEN
									V_COL_PAR0 := '(' || REPLACE(V_OTHER_PARENT_KEY0, '''', '''''') || ')';
							ELSE
								V_COL_PAR0 := '''[''|| TAB.' || REPLACE(REPLACE(V_OTHER_PARENT_KEY0, ' ', ''), ',', '|| ''].['' ||TAB.') || '|| '']''';
							END IF;
						ELSE
							V_COL_PAR0 := ' TAB.NAME'; 
						END IF;                            
						DBMS_OUTPUT.PUT_LINE('teste28');
						IF V_OTHER_PARENT_KEY1 IS NOT NULL THEN
							IF UPPER(SUBSTR(TRIM(REPLACE(V_OTHER_PARENT_KEY1, '(', '')), 1, 6)) = 'SELECT' THEN
								V_COL_PAR0 := '(' || REPLACE(V_OTHER_PARENT_KEY1, '''', '''''') || ')';
							ELSE                                
								V_COL_PAR1 := '''[''|| TAB1.' || REPLACE(REPLACE(V_OTHER_PARENT_KEY1, ' ', ''), ',', '|| ''].['' ||TAB1.') || '|| '']''';
							END IF;
						ELSE
							V_COL_PAR1 := ' TAB1.NAME'; 
						END IF;    
						DBMS_OUTPUT.PUT_LINE('teste29');
						IF V_OTHER_PARENT_KEY2 IS NOT NULL THEN
							IF UPPER(SUBSTR(TRIM(REPLACE(V_OTHER_PARENT_KEY2, '(', '')), 1, 6)) = 'SELECT' THEN
								V_COL_PAR0 := '(' || REPLACE(V_OTHER_PARENT_KEY2, '''', '''''') || ')';
							ELSE                                
								V_COL_PAR2 := '''[''|| TAB3.' || REPLACE(REPLACE(V_OTHER_PARENT_KEY2, ' ', ''), ',', '|| ''].['' ||TAB3.') || '|| '']''';
							END IF;
						ELSE
							V_COL_PAR2 := ' TAB2.NAME'; 
						END IF;    
						DBMS_OUTPUT.PUT_LINE('teste30');
						V_SUB_SELECT  := ', (SELECT '|| V_COL_PAR0 ||' FROM ' ||
											   ' SIEBEL.' || R.TAB_P0 || V_DBLINK_ORIG ||' TAB, ' || 
											   ' SIEBEL.' || R.TAB_P1 || V_DBLINK_ORIG || ' TAB1, ' ||
											   ' SIEBEL.' || R.TAB_P2 || V_DBLINK_ORIG || ' TAB2 ' ||
											   ' WHERE ' ||
											   ' T.' || R.JOIN2 || ' = TAB2.ROW_ID ' ||
											   ' AND ' ||
											   ' TAB2.' || R.JOIN1 || ' = TAB1.ROW_ID ' ||
											   ' AND ' ||                                   
											   ' TAB1.' || R.JOIN0 || ' = TAB.ROW_ID ) PAR_N0';
						V_SUB_SELECT  := V_SUB_SELECT || ', ' || 
											   '(SELECT '|| V_COL_PAR1 ||' FROM ' ||
											   ' SIEBEL.' || R.TAB_P0 || V_DBLINK_ORIG || ' TAB, ' || 
											   ' SIEBEL.' || R.TAB_P1 || V_DBLINK_ORIG || ' TAB1, ' ||
											   ' SIEBEL.' || R.TAB_P2 || V_DBLINK_ORIG || ' TAB2 ' ||
											   ' WHERE ' ||
											   ' T.' || R.JOIN2 || ' = TAB2.ROW_ID ' ||
											   ' AND ' ||
											   ' TAB2.' || R.JOIN1 || ' = TAB1.ROW_ID ' ||
											   ' AND ' ||
											   ' TAB1.' || R.JOIN0 || ' = TAB.ROW_ID ) PAR_N1';
						V_SUB_SELECT  := V_SUB_SELECT || ', ' || 
											   '(SELECT '|| V_COL_PAR2 ||' FROM ' || 
											   ' SIEBEL.' || R.TAB_P0 || V_DBLINK_ORIG || ' TAB, ' || 
											   ' SIEBEL.' || R.TAB_P1 || V_DBLINK_ORIG || ' TAB1, ' ||
											   ' SIEBEL.' || R.TAB_P2 || V_DBLINK_ORIG || ' TAB2 ' ||
											   ' WHERE ' ||
											   ' T.' || R.JOIN2 || ' = TAB2.ROW_ID ' ||
											   ' AND ' ||
											   ' TAB2.' || R.JOIN1 || ' = TAB1.ROW_ID ' ||
											   ' AND ' ||
											   ' TAB1.' || R.JOIN0 || ' = TAB.ROW_ID ) PAR_N2';
						V_EXISTS_PARENT :=                      
									' AND EXISTS ( ' || 
									' SELECT 1 FROM ' || 
									' SIEBEL.' || R.TAB_P0 || V_DBLINK_DEST || ' TAB, ' || 
									' SIEBEL.' || R.TAB_P1 || V_DBLINK_DEST || ' TAB1,' ||
									' SIEBEL.' || R.TAB_P2 || V_DBLINK_DEST || ' TAB2';
									IF R.TYPE = 'Repository'    THEN                                        
										V_EXISTS_PARENT := V_EXISTS_PARENT || 
										' ,SIEBEL.S_REPOSITORY' || V_DBLINK_DEST || ' REP  ';
									END IF;
									V_EXISTS_PARENT := V_EXISTS_PARENT || 
									' WHERE ' ||
									' T.' || R.JOIN2 || ' = TAB2.ROW_ID ' ||
									' AND ' ||
									' TAB2.' || R.JOIN1 || ' = TAB1.ROW_ID ' ||
									' AND ' ||
									' TAB1.' || R.JOIN0 || ' = TAB.ROW_ID ' ||        
									' AND ' ||                                   
									' '|| V_COL_PAR0 ||' = REG.PAR_N0 ' ||
									' AND ' ||
									' '|| V_COL_PAR1 ||' = REG.PAR_N1 ' ||
									' AND ' ||                                             
									' '|| V_COL_PAR2 ||' = REG.PAR_N2 ';
									IF R.TYPE = 'Repository'    THEN                                             
										V_EXISTS_PARENT := V_EXISTS_PARENT ||      
										' AND ' ||  
										' TAB.REPOSITORY_ID = REP.ROW_ID ' ||
										' AND ' ||  
										' TAB1.REPOSITORY_ID = REP.ROW_ID ' ||
										' AND ' ||  
										' TAB2.REPOSITORY_ID = REP.ROW_ID ' ||
										' AND ' || 
										' REP.NAME = ''' || V_DES_REPOSITORY_NAME || '''' ;
									END IF;                                             
									V_EXISTS_PARENT := V_EXISTS_PARENT ||   ' )';
					  
						V_PAR_N0 := 'REG.PAR_N0';
						V_PAR_N1 := 'REG.PAR_N1';
						V_PAR_N2 := 'REG.PAR_N2';
						DBMS_OUTPUT.PUT_LINE('teste31');
					ELSIF (R.TAB_P1 IS NOT NULL) THEN
						BEGIN
							SELECT OTHER_KEY_FIELD INTO V_OTHER_PARENT_KEY0
							FROM SADMIN.TAB_CTRL_BATIMENTO_REP WHERE
							GROUP_OBJECT = R.GROUP_OBJECT
							AND CONFIGURATION_NAME = R.CONFIGURATION_NAME
							AND TABLE_NAME = R.TAB_P0
							AND ORDER_COL = R.ORDER_COL - 2;
						EXCEPTION WHEN OTHERS THEN    
							V_OTHER_PARENT_KEY0 := NULL;
						END;
						DBMS_OUTPUT.PUT_LINE('teste6');
						BEGIN
							SELECT OTHER_KEY_FIELD INTO V_OTHER_PARENT_KEY1
							FROM SADMIN.TAB_CTRL_BATIMENTO_REP WHERE
							GROUP_OBJECT = R.GROUP_OBJECT
							AND CONFIGURATION_NAME = R.CONFIGURATION_NAME
							AND TABLE_NAME = R.TAB_P1
							AND ORDER_COL = R.ORDER_COL - 1;
						EXCEPTION WHEN OTHERS THEN    
							V_OTHER_PARENT_KEY1 := NULL;
						END;

						IF V_OTHER_PARENT_KEY0 IS NOT NULL THEN
							IF UPPER(SUBSTR(TRIM(REPLACE(V_OTHER_PARENT_KEY0, '(', '')), 1, 6)) = 'SELECT' THEN
								V_COL_PAR0 := '(' || REPLACE(V_OTHER_PARENT_KEY0, '''', '''''') || ')';
							ELSE
								V_COL_PAR0 := '''[''|| TAB.' || REPLACE(REPLACE(V_OTHER_PARENT_KEY0, ' ', ''), ',', '|| ''].['' ||TAB.') || '|| '']''';
							END IF;
						ELSE
							V_COL_PAR0 := ' TAB.NAME'; 
						END IF;                            

						IF V_OTHER_PARENT_KEY1 IS NOT NULL THEN
							IF UPPER(SUBSTR(TRIM(REPLACE(V_OTHER_PARENT_KEY1, '(', '')), 1, 6)) = 'SELECT' THEN
								V_COL_PAR0 := '(' || REPLACE(V_OTHER_PARENT_KEY1, '''', '''''') || ')';
							ELSE
								V_COL_PAR1 := '''[''|| TAB1.' || REPLACE(REPLACE(V_OTHER_PARENT_KEY1, ' ', ''), ',', '|| ''].['' ||TAB1.') || '|| '']''';
							END IF;
						ELSE
							V_COL_PAR1 := ' TAB1.NAME'; 
						END IF;    
						
						V_SUB_SELECT  := ', (SELECT '|| V_COL_PAR0 ||' FROM ' ||
											   ' SIEBEL.' || R.TAB_P0 ||  V_DBLINK_ORIG ||' TAB, ' || 
											   ' SIEBEL.' || R.TAB_P1 ||  V_DBLINK_ORIG ||' TAB1 ' ||
											   ' WHERE ' ||
											   ' T.' || R.JOIN1 || ' = TAB1.ROW_ID ' ||
											   ' AND ' ||
											   ' TAB1.' || R.JOIN0 || ' = TAB.ROW_ID ) PAR_N0';
						V_SUB_SELECT  := V_SUB_SELECT || ', ' || 
											   '(SELECT '|| V_COL_PAR1 ||' FROM ' ||
											   ' SIEBEL.' || R.TAB_P0 ||  V_DBLINK_ORIG ||' TAB, ' || 
											   ' SIEBEL.' || R.TAB_P1 ||  V_DBLINK_ORIG ||' TAB1 ' ||
											   ' WHERE ' ||
											   ' T.' || R.JOIN1 || ' = TAB1.ROW_ID ' ||
											   ' AND ' ||
											   ' TAB1.' || R.JOIN0 || ' = TAB.ROW_ID ) PAR_N1';    
											   
						V_EXISTS_PARENT :=     ' AND EXISTS ( ' || 
											' SELECT 1 FROM ' || 
											' SIEBEL.' || R.TAB_P0 || V_DBLINK_DEST ||' TAB, ' || 
											' SIEBEL.' || R.TAB_P1 || V_DBLINK_DEST ||' TAB1 ';
											IF R.TYPE = 'Repository'    THEN
												V_EXISTS_PARENT := V_EXISTS_PARENT || 
												' ,SIEBEL.S_REPOSITORY' || V_DBLINK_DEST || ' REP ';
											END IF;    
											V_EXISTS_PARENT := V_EXISTS_PARENT ||
											' WHERE ' ||
											' T.' || R.JOIN1 || ' = TAB1.ROW_ID ' ||
											' AND ' ||
											' TAB1.' || R.JOIN0 || ' = TAB.ROW_ID ' ||            
											' AND ' ||                                                 
											' '|| V_COL_PAR0 ||' = REG.PAR_N0 ' ||
											' AND ' ||
											' '|| V_COL_PAR1 ||' = REG.PAR_N1 ';
											IF R.TYPE = 'Repository'    THEN
												V_EXISTS_PARENT := V_EXISTS_PARENT ||
												' AND ' ||  
												' TAB.REPOSITORY_ID = REP.ROW_ID ' ||
												' AND ' ||  
												' TAB1.REPOSITORY_ID = REP.ROW_ID ' ||
												' AND ' || 
												' REP.NAME = ''' || V_DES_REPOSITORY_NAME || '''';                                             
											END IF;    
											V_EXISTS_PARENT := V_EXISTS_PARENT ||
											' )';  
							
						V_PAR_N0 := 'REG.PAR_N0';
						V_PAR_N1 := 'REG.PAR_N1';                              
					ELSIF (R.TAB_P0 IS NOT NULL) THEN
					DBMS_OUTPUT.PUT_LINE('teste5');
						BEGIN
							SELECT OTHER_KEY_FIELD INTO V_OTHER_PARENT_KEY0
							FROM SADMIN.TAB_CTRL_BATIMENTO_REP WHERE
							GROUP_OBJECT = R.GROUP_OBJECT
							AND CONFIGURATION_NAME = R.CONFIGURATION_NAME
							AND TABLE_NAME = R.TAB_P0
							AND ORDER_COL = R.ORDER_COL - 1;                        
						EXCEPTION WHEN OTHERS THEN    
							V_OTHER_PARENT_KEY0 := NULL;
						END;

						IF V_OTHER_PARENT_KEY0 IS NOT NULL THEN
							IF UPPER(SUBSTR(TRIM(REPLACE(V_OTHER_PARENT_KEY0, '(', '')), 1, 6)) = 'SELECT' THEN
								V_COL_PAR0 := '(' || REPLACE(V_OTHER_PARENT_KEY0, '''', '''''') || ')';
							ELSE                            
								V_COL_PAR0 := '''[''|| TAB.' || REPLACE(REPLACE(V_OTHER_PARENT_KEY0, ' ', ''), ',', '|| ''].['' ||TAB.') || '|| '']''';
							END IF;
						ELSE
							V_COL_PAR0 := ' TAB.NAME'; 
						END IF;    
						DBMS_OUTPUT.PUT_LINE('teste4');
					V_SUB_SELECT  := ', (SELECT '|| V_COL_PAR0 ||' FROM ' ||
											   ' SIEBEL.' || R.TAB_P0 || V_DBLINK_ORIG || ' TAB ' || 
											   ' WHERE ' ||
											   ' T.' || R.JOIN0 || ' = TAB.ROW_ID ) PAR_N0';
											   
						V_EXISTS_PARENT :=  ' AND EXISTS ( ' || 
											' SELECT 1 FROM ' || 
											' SIEBEL.' || R.TAB_P0 || V_DBLINK_DEST || ' TAB ';
											IF R.TYPE = 'Repository'    THEN
												V_EXISTS_PARENT := V_EXISTS_PARENT || 
												' ,SIEBEL.S_REPOSITORY' || V_DBLINK_DEST || ' REP ';  
											END IF;             
											V_EXISTS_PARENT := V_EXISTS_PARENT ||
											' WHERE ' ||
											' T.' || R.JOIN0 || ' = TAB.ROW_ID ' ||                                             
											' AND ' ||                                                 
											' '|| V_COL_PAR0 ||' = REG.PAR_N0 ';
											IF R.TYPE = 'Repository'    THEN
												V_EXISTS_PARENT := V_EXISTS_PARENT ||
												' AND ' ||  
												' TAB.REPOSITORY_ID = REP.ROW_ID ' ||    
												' AND ' || 
												' REP.NAME = ''' || V_DES_REPOSITORY_NAME || '''';                                             
											END IF;    
											V_EXISTS_PARENT := V_EXISTS_PARENT ||
											' )';  
					
						V_PAR_N0 := 'REG.PAR_N0';                              
					ELSE
						V_SUB_SELECT  := '';
						V_EXISTS_PARENT  := '';
					END IF;        
					DBMS_OUTPUT.PUT_LINE('teste3');
					FOR RC IN C_COLUMN (R.ROW_ID) LOOP    
					
						VEXIT := 'N'; 
						CONT := 0;
						
						DBMS_OUTPUT.PUT_LINE('teste2 - ' || R.OTHER_KEY_FIELD);    
						IF R.OTHER_KEY_FIELD IS NOT NULL THEN
							IF UPPER(R.OTHER_KEY_FIELD) LIKE '%SELECT%FROM%' OR UPPER(R.OTHER_KEY_FIELD) LIKE '%].[%' THEN
								VEXIT := 'N';
							ELSE
								TABOUTPUT:= fn_split (R.OTHER_KEY_FIELD, ',');
								FOR i IN 0 .. TABOUTPUT.COUNT - 1 LOOP
									IF RC.COL_NAME = TABOUTPUT (i) THEN
										VEXIT := 'Y';
									END IF;
								END LOOP;
							END IF;
						ELSE
							VEXIT := 'N'; 
						END IF;
						DBMS_OUTPUT.PUT_LINE('teste1');
						IF VEXIT = 'N' THEN
						DBMS_OUTPUT.PUT_LINE('teste400');
							V_QUERY_ORI :=  ' SELECT T.' || RC.COL_NAME || ',' ;
										IF R.OTHER_KEY_FIELD IS NOT NULL THEN
											IF UPPER(R.OTHER_KEY_FIELD) LIKE '%SELECT%FROM%'  OR UPPER(R.OTHER_KEY_FIELD) LIKE '%].[%' THEN
												V_QUERY_ORI := V_QUERY_ORI ||
												UPPER(REPLACE(R.OTHER_KEY_FIELD, '@', V_DBLINK_ORIG)) || ' OTHER_KEY_SUB_SELECT, ';
											ELSE
												TABOUTPUT:= fn_split (R.OTHER_KEY_FIELD, ',');
												FOR i IN 0 .. TABOUTPUT.COUNT - 1 LOOP
													V_QUERY_ORI := V_QUERY_ORI ||
													'T.' || TABOUTPUT (i) || ', ';
												END LOOP;
											END IF;
										ELSE
											V_QUERY_ORI := V_QUERY_ORI ||
											' T.NAME,'; 
										END IF;
										V_QUERY_ORI := V_QUERY_ORI ||
										' T.LAST_UPD, ' ||
										' (SELECT LOGIN FROM SIEBEL.S_USER' || V_DBLINK_ORIG || ' WHERE ROW_ID = T.LAST_UPD_BY AND ROWNUM < 2) LAST_UPD_BY' ||  
										V_SUB_SELECT ||
										' FROM SIEBEL.' || R.NAME || V_DBLINK_ORIG || ' T'; 
										IF R.TYPE = 'Repository'    THEN
											V_QUERY_ORI := V_QUERY_ORI ||
											' ,SIEBEL.S_REPOSITORY' || V_DBLINK_ORIG || ' R0 '; 
										END IF;    
										V_QUERY_ORI := V_QUERY_ORI ||
										' WHERE ';
										IF R.TYPE = 'Repository'    THEN
											V_QUERY_ORI := V_QUERY_ORI ||
											' R0.ROW_ID = T.REPOSITORY_ID AND' ||
											' R0.NAME = ''' || V_ORI_REPOSITORY_NAME || ''' AND ' ;
										END IF;    
										V_QUERY_ORI := V_QUERY_ORI ||
										' T.LAST_UPD > TO_DATE(''' || V_DATA || ''', ''DD/MM/YYYY'') ' ;
										IF R.ADDITIONAL_SEARCH IS NOT NULL THEN
											V_QUERY_ORI := V_QUERY_ORI ||
											' AND ' || REPLACE(REPLACE(R.ADDITIONAL_SEARCH, '@', V_DBLINK_ORIG), 'Siebel Repository', V_ORI_REPOSITORY_NAME) || ' ';
										END IF;
										
										
							DBMS_OUTPUT.PUT_LINE('teste401');            
							V_QUERY_DES :=  ' SELECT T.' || RC.COL_NAME || ', T.LAST_UPD, ' ||
											' (SELECT LOGIN FROM SIEBEL.S_USER' || V_DBLINK_DEST || ' WHERE ROW_ID = T.LAST_UPD_BY AND ROWNUM < 2) ' ||
											' INTO V_VALOR_DES, V_LAST_UPD_DEST, V_LAST_UPD_BY_DEST ' ||  
										' FROM SIEBEL.' || R.NAME || V_DBLINK_DEST || ' T' ; 
										IF R.TYPE = 'Repository'    THEN
											V_QUERY_DES := V_QUERY_DES ||
											' ,SIEBEL.S_REPOSITORY' || V_DBLINK_DEST || ' R0 ';
										END IF;    
										V_QUERY_DES := V_QUERY_DES ||
										' WHERE ';
										IF R.TYPE = 'Repository'    THEN
											V_QUERY_DES := V_QUERY_DES ||
											' R0.ROW_ID = T.REPOSITORY_ID AND ' ||
											' R0.NAME = ''' || V_DES_REPOSITORY_NAME || ''' AND ' ;                                    
										END IF;    
										IF R.OTHER_KEY_FIELD IS NOT NULL THEN
											IF UPPER(R.OTHER_KEY_FIELD) LIKE '%SELECT%FROM%'   OR UPPER(R.OTHER_KEY_FIELD) LIKE '%].[%' THEN
												V_QUERY_DES := V_QUERY_DES ||
												UPPER(REPLACE(R.OTHER_KEY_FIELD, '@', V_DBLINK_DEST)) || ' = REG.OTHER_KEY_SUB_SELECT AND ';
											ELSE
												TABOUTPUT:= fn_split (R.OTHER_KEY_FIELD, ',');
												FOR i IN 0 .. TABOUTPUT.COUNT - 1 LOOP
													V_QUERY_DES := V_QUERY_DES ||
													'NVL(T.' || TABOUTPUT (i) || ',''X'') = NVL(REG.' || TABOUTPUT (i) || ',''X'') AND ';
												END LOOP;
											END IF;    
										ELSE
											V_QUERY_DES := V_QUERY_DES ||
											' T.NAME = REG.NAME AND ' ; 
										END IF;
										V_QUERY_DES := V_QUERY_DES || 
										' ROWNUM < 2 ' ;
										IF R.ADDITIONAL_SEARCH IS NOT NULL THEN
											V_QUERY_DES := V_QUERY_DES ||
											' AND ' || REPLACE(REPLACE(R.ADDITIONAL_SEARCH, '@', V_DBLINK_DEST), 'Siebel Repository', V_DES_REPOSITORY_NAME) || ' ';
										END IF;
										V_QUERY_DES := V_QUERY_DES || V_EXISTS_PARENT || ';' ;
										
							DBMS_OUTPUT.PUT_LINE('teste402');
							V_PL :=   'DECLARE ' ||
									'   V_VALOR_DES SIEBEL.' ||  R.NAME || '.' || RC.COL_NAME || V_DBLINK_ORIG || '%TYPE;' ||
									'   V_LAST_UPD_DEST SIEBEL.' ||  R.NAME || '.LAST_UPD'  || V_DBLINK_ORIG || '%TYPE;' ||
									'   V_LAST_UPD_BY_DEST VARCHAR2(100 Char);' ||
									'   ICONTADOR NUMBER;' ||
									'BEGIN ' ||
									'  FOR REG IN (' || V_QUERY_ORI  || ') LOOP' ||
									'    BEGIN ' ||
									'           V_VALOR_DES:= NULL; ' ||
									'           V_LAST_UPD_DEST:= NULL; ' || 
									'           V_LAST_UPD_BY_DEST:= NULL; ' ||
									'           ' || V_QUERY_DES  ||
									'           IF (TRIM(REG.' || RC.COL_NAME || ') <> TRIM(V_VALOR_DES)) THEN ' ||  
												' INSERT INTO SADMIN.BATIMENTO_REPOSITORIO ' ||    
												' (' ||
													' TYPE,' || 
													' PAR_N0,' ||
													' PAR_N1,' ||
													' PAR_N2,' ||
													' PAR_N3,' ||
													' OBJECT_NAME,' ||
													' COLUMN_NAME,' ||                            
													' LAST_UPD_ORIG,' ||
													' LAST_UPD_DEST,' ||
													' LAST_UPD_BY_ORIG,' ||
													' LAST_UPD_BY_DEST,' ||                                                        
													' VAL_ORIG,' ||    
													' VAL_DEST,' ||                
													' STATUS,' ||
													' DESCRIPTION,' ||    
													' GROUP_OBJECT,' ||
													' ORDER_COL,' ||
													' CTRL_LOG_COMP_REP_ID' ||
												' ) VALUES ' || 
												'  (' ;
						   V_PL :=  V_PL ||         '  ''' ||  R.TYPE || ''',' || 
													'  ' ||  V_PAR_N0 || ',' || 
													'  ' ||  V_PAR_N1 || ',' ||              
													'  ' ||  V_PAR_N2 || ',' || 
													'  ' ||  V_PAR_N3 || ',';
													IF R.OTHER_KEY_FIELD IS NOT NULL THEN
														IF UPPER(R.OTHER_KEY_FIELD) LIKE '%SELECT%FROM%'   OR UPPER(R.OTHER_KEY_FIELD) LIKE '%].[%' THEN
															V_PL := V_PL ||
															'NVL(REG.OTHER_KEY_SUB_SELECT, ''NULL''), ';
														ELSE    
															CONT := 0;
															TABOUTPUT:= fn_split (R.OTHER_KEY_FIELD, ',');
															V_PL := V_PL || ' ''['' || ';
															FOR i IN 0 .. TABOUTPUT.COUNT - 1 LOOP
																IF CONT  > 0 THEN
																	V_PL := V_PL || '|| ''].['' || ';
																END IF;
																V_PL := V_PL ||
																'NVL(REG.' || TRIM(TABOUTPUT (i)) || ', ''NULL'')' ;
																CONT := CONT + 1;
															END LOOP;
															V_PL := V_PL || '|| '']'',';
														END IF;
													ELSE
														V_PL := V_PL ||
														'  REG.NAME,' ; 
													END IF;
													IF RC.DATA_TYPE = 'LONG' THEN
														REPLACE_VALOR_DES := '''Campo muito longo ... favor validar direto na base de dados.''';
														REPLACE_VALOR_ORI := '''Campo muito longo ... favor validar direto na base de dados.''';
													ELSE    
														REPLACE_VALOR_DES := 'V_VALOR_DES';
														REPLACE_VALOR_ORI := 'REG.' || RC.COL_NAME;
													END IF;
													V_PL := V_PL ||                                            
													'  ''' ||  RC.COL_NAME || ''',' ||                                 
													'  REG.LAST_UPD,' ||
													'  V_LAST_UPD_DEST,' ||
													'  REG.LAST_UPD_BY,' ||
													'  V_LAST_UPD_BY_DEST,' ||
													'  SUBSTR(TO_CHAR(' || REPLACE_VALOR_ORI || '), 1, 250),' ||     
													'  SUBSTR(TO_CHAR(' || REPLACE_VALOR_DES || '), 1, 250),' ||                 
													'  ''DIVERGENTE'',' ||
													'  ''' ||  R.DESCRIPTION || ''',' ||
													'  ''' ||  R.GROUP_OBJECT || ''',' ||
													'  ''' ||  R.ORDER_COL || ''',' ||
													TO_CHAR(VID) ||            
												'  ); ' ||                                                 
												'  COMMIT; ' || 
												'END IF; ' ||  
										'EXCEPTION WHEN NO_DATA_FOUND THEN ' ||
												'SELECT COUNT(1) INTO ICONTADOR FROM SADMIN.BATIMENTO_REPOSITORIO ' ||
												'WHERE ' || 
												'(    OBJECT_NAME = ' ||  NVL(V_PAR_N0, '''X''') || '  ' ||  
												'OR ' || 
												'     OBJECT_NAME = ' ||  NVL(V_PAR_N1, '''X''') || '  ' ||  
												'OR ' ||
												'     OBJECT_NAME = ' ||  NVL(V_PAR_N2, '''X''') || '  ' ||  
												'OR ' ||
												'     OBJECT_NAME = ' ||  NVL(V_PAR_N3, '''X''') || '  ' ||  
												'OR ' ||
												'OBJECT_NAME = ' ;
													IF R.OTHER_KEY_FIELD IS NOT NULL THEN
														IF UPPER(R.OTHER_KEY_FIELD) LIKE '%SELECT%FROM%'   OR UPPER(R.OTHER_KEY_FIELD) LIKE '%].[%' THEN
															V_PL := V_PL ||
															'NVL(REG.OTHER_KEY_SUB_SELECT, ''NULL'') ';
														ELSE
															CONT := 0;
															TABOUTPUT:= fn_split (R.OTHER_KEY_FIELD, ',');
															V_PL := V_PL || ' ''['' || ';
															FOR i IN 0 .. TABOUTPUT.COUNT - 1 LOOP
																IF CONT  > 0 THEN
																	V_PL := V_PL || '|| ''].['' || ';
																END IF;
																V_PL := V_PL ||
																'NVL(REG.' || TRIM(TABOUTPUT (i)) || ', ''NULL'')' ;
																CONT := CONT + 1;
															END LOOP;
															V_PL := V_PL || '|| '']''';    
														END IF;
													ELSE
														V_PL := V_PL ||
														'  REG.NAME ' ; 
													END IF;                
													V_PL := V_PL ||     
												')' ||
												'AND STATUS = ''NOT EXISTS'' ' ||
												'AND GROUP_OBJECT =  ''' ||  R.GROUP_OBJECT || ''' ' ||
												'AND ORDER_COL <=  ' ||  R.ORDER_COL || ' ' ||
												'AND CTRL_LOG_COMP_REP_ID = ' || TO_CHAR(VID) || ' ;' ||  
											'IF ICONTADOR = 0 THEN ' ||                                                  
											'  INSERT INTO SADMIN.BATIMENTO_REPOSITORIO ' ||    
											'  (' ||
											'  TYPE,' || 
											'  PAR_N0,' ||
											'  PAR_N1,' ||
											'  PAR_N2,' ||
											'  PAR_N3,' ||
											'  OBJECT_NAME,' ||
											'  COLUMN_NAME,' ||                                        
											'  LAST_UPD_ORIG,' ||
											'  LAST_UPD_DEST,' ||
											'  LAST_UPD_BY_ORIG,' ||
											'  LAST_UPD_BY_DEST,' ||                                                    
											'  VAL_ORIG,' ||    
											'  VAL_DEST,' ||                
											'  STATUS,' ||
											'  DESCRIPTION,' ||
											' GROUP_OBJECT,' ||
											' ORDER_COL,' ||
											'  CTRL_LOG_COMP_REP_ID' ||
											'  ) VALUES ' || 
											'  (' ||
											'  ''' ||  R.TYPE || ''',' || 
											'    ' ||  V_PAR_N0 || ',' || 
											'    ' ||  V_PAR_N1 || ',' ||
											'    ' ||  V_PAR_N2 || ',' ||                                                   
											'    ' ||  V_PAR_N3 || ',' ;
											IF R.OTHER_KEY_FIELD IS NOT NULL THEN
												IF UPPER(R.OTHER_KEY_FIELD) LIKE '%SELECT%FROM%'   OR UPPER(R.OTHER_KEY_FIELD) LIKE '%].[%' THEN
													V_PL := V_PL ||
													'NVL(REG.OTHER_KEY_SUB_SELECT, ''NULL''), ';
												ELSE
													CONT := 0;
													TABOUTPUT:= fn_split (R.OTHER_KEY_FIELD, ',');
													V_PL := V_PL || ' ''['' || ';
													FOR i IN 0 .. TABOUTPUT.COUNT - 1 LOOP
														IF CONT  > 0 THEN
															V_PL := V_PL || '|| ''].['' || ';
														END IF;
														V_PL := V_PL ||
														'NVL(REG.' || TRIM(TABOUTPUT (i)) || ', ''NULL'')' ;
														CONT := CONT + 1;
													END LOOP;
													V_PL := V_PL || '|| '']'',';
												END IF;
											ELSE
												V_PL := V_PL ||
												'  REG.NAME,' ; 
											END IF;                
											V_PL := V_PL ||    
											'              '''',' ||                                 
											'          REG.LAST_UPD,' ||
											'          V_LAST_UPD_DEST,' ||
											'          REG.LAST_UPD_BY,' ||
											'          V_LAST_UPD_BY_DEST,' ||
											'          SUBSTR(TO_CHAR(REG.' || RC.COL_NAME || '), 1, 250),' ||    
											'              '''',' ||                
											'        ''NOT EXISTS'',' || 
											'  ''' ||  R.DESCRIPTION || ''',' ||    
											'  ''' ||  R.GROUP_OBJECT || ''',' ||
											'  ''' ||  R.ORDER_COL || ''',' ||
											TO_CHAR(VID) ||
											'  ); ' ||                                                 
											'  COMMIT; ' ||
											'END IF; ' ||
										 'END; ' ||                                                
									   'END LOOP; ' ||
									 'END; '  ;  
									
							BEGIN
								DBMS_OUTPUT.PUT_LINE(V_PL);
								EXECUTE IMMEDIATE V_PL;  
								--DBMS_OUTPUT.PUT_LINE(V_PL);
								
								
							EXCEPTION WHEN OTHERS THEN
								VERROR:=SUBSTR(SQLERRM, 1, 3000);
								UPDATE SADMIN.CTRL_LOG_COMP_REP 
									SET 
										STATUS_DESC = STATUS_DESC || DECODE(STATUS, NULL, '', '' || chr(13) || chr(10) || '') || 'ERRO: ' || VERROR,
										STATUS = 'QUEUE PARTIAL ERROR'
										WHERE ID = VID;
								COMMIT; 
								
								UPDATE SADMIN.CTRL_LOG_COMP_REP_LOG
								SET STATUS = 'PROCESSING WITH ERRORS',
								SCRIPT_ERROR = V_PL,
								STATUS_DESC = STATUS_DESC || DECODE(STATUS, NULL, '', '' || chr(13) || chr(10) || '') || 'ERRO: [' || RC.COL_NAME ||'] ' || VERROR
								WHERE CTRL_LOG_COMP_REP_MASTER_ID = VMASTER_ID
								AND CTRL_LOG_COMP_REP_ID = VID
								AND TAB_CTRL_BATIMENTO_REP_ID = R.ID
								AND FILA = V_FILA;
									
								COMMIT;                                    
							END;
						END IF;
					END LOOP;        
					UPDATE SADMIN.CTRL_LOG_COMP_REP_LOG
					SET STATUS = DECODE(STATUS, 'PROCESSING', 'SUCCESS', 'PARTIAL SUCCESS')
					--,SCRIPT_ERROR = V_PL
					WHERE 
					CTRL_LOG_COMP_REP_MASTER_ID = VMASTER_ID
					AND CTRL_LOG_COMP_REP_ID = VID
					AND TAB_CTRL_BATIMENTO_REP_ID = R.ID
					AND FILA = V_FILA;
						
					COMMIT;
				END LOOP;
			END IF;
			--SELECT STATUS INTO VSTATUS FROM SADMIN.CTRL_LOG_COMP_REP WHERE ID = VID;
			--dbms_output.put_line('VSTATUS = ' || VSTATUS);
			
			UPDATE SADMIN.CTRL_LOG_COMP_REP 
				SET TOTAL_PROCESS_EXECUTED = VTOTAL_PROCESS,
					DATE_END = SYSDATE,
					STATUS = DECODE(STATUS, 'QUEUE PROCESSING', 'QUEUE SUCCESS', 'QUEUE PARTIAL SUCCESS')
					WHERE ID = VID;
			COMMIT;

			SELECT COUNT(1) INTO V_VALIDA_FIM FROM SADMIN.CTRL_LOG_COMP_REP 
			WHERE MASTER_LOG_COMPARE_ID = VMASTER_ID
			AND STATUS = 'QUEUE PROCESSING';
			
			IF V_VALIDA_FIM = 0 THEN
				SELECT COUNT(1) INTO V_VALIDA_FIM FROM SADMIN.CTRL_LOG_COMP_REP 
				WHERE MASTER_LOG_COMPARE_ID = VMASTER_ID
				AND (STATUS = 'QUEUE PARTIAL SUCCESS' OR STATUS = 'QUEUE FATAL ERROR') ;
				
				IF V_VALIDA_FIM = 0 THEN
					SELECT COUNT(1) INTO V_VALIDA_FIM FROM SADMIN.CTRL_LOG_COMP_REP 
					WHERE MASTER_LOG_COMPARE_ID = VMASTER_ID
					AND (STATUS = 'QUEUE PARTIAL SUCCESS' OR STATUS = 'QUEUE SUCCESS') ;
					
					IF V_VALIDA_FIM = 0 THEN
						V_STATUS_MASTER := 'FATAL ERROR';
					ELSE
						V_STATUS_MASTER := 'PARTIAL SUCCESS';
					END IF;    
				ELSE
					V_STATUS_MASTER := 'SUCCESS';
				END IF;        
				
				UPDATE SADMIN.CTRL_LOG_COMP_REP_MASTER 
				SET 
				LAST_UPD = SYSDATE,
				STATUS = V_STATUS_MASTER
				WHERE ID = VMASTER_ID;
				COMMIT;
				
			END IF;

		EXCEPTION WHEN OTHERS THEN    
			VERROR:=SUBSTR(SQLERRM, 1, 3000);
			
			SELECT COUNT(1) INTO V_VALIDA_LOG FROM SADMIN.CTRL_LOG_COMP_REP_LOG 
			WHERE 
			CTRL_LOG_COMP_REP_MASTER_ID = VMASTER_ID
			AND CTRL_LOG_COMP_REP_ID = VID
			AND FILA = V_FILA;
				
			IF     V_VALIDA_LOG > 0 THEN
				UPDATE SADMIN.CTRL_LOG_COMP_REP_LOG SET
					STATUS = 'FATAL ERROR',
					SCRIPT_ERROR = V_PL
					WHERE 
					CTRL_LOG_COMP_REP_MASTER_ID = VMASTER_ID
					AND CTRL_LOG_COMP_REP_ID = VID
					AND FILA = V_FILA;
					
				COMMIT;                    
			END IF;
			
			UPDATE SADMIN.CTRL_LOG_COMP_REP 
			SET 
			STATUS_DESC = STATUS_DESC || DECODE(STATUS, NULL, '', '' || chr(13) || chr(10) || '') || 'ERRO: ' || VERROR,
			STATUS = 'QUEUE FATAL ERROR'
			WHERE ID = VID;

			COMMIT;  

			SELECT COUNT(1) INTO V_VALIDA_FIM FROM SADMIN.CTRL_LOG_COMP_REP 
			WHERE MASTER_LOG_COMPARE_ID = VMASTER_ID
			AND STATUS = 'QUEUE PROCESSING';
			
			IF V_VALIDA_FIM = 0 THEN
				SELECT COUNT(1) INTO V_VALIDA_FIM FROM SADMIN.CTRL_LOG_COMP_REP 
				WHERE MASTER_LOG_COMPARE_ID = VMASTER_ID
				AND (STATUS = 'QUEUE PARTIAL SUCCESS' OR STATUS = 'QUEUE FATAL ERROR') ;
				
				IF V_VALIDA_FIM = 0 THEN
					SELECT COUNT(1) INTO V_VALIDA_FIM FROM SADMIN.CTRL_LOG_COMP_REP 
					WHERE MASTER_LOG_COMPARE_ID = VMASTER_ID
					AND (STATUS = 'QUEUE PARTIAL SUCCESS' OR STATUS = 'QUEUE SUCCESS') ;
					
					IF V_VALIDA_FIM = 0 THEN
						V_STATUS_MASTER := 'FATAL ERROR';
					ELSE
						V_STATUS_MASTER := 'PARTIAL SUCCESS';
					END IF;    
				ELSE
					V_STATUS_MASTER := 'SUCCESS';
				END IF;        
				
				UPDATE SADMIN.CTRL_LOG_COMP_REP_MASTER 
				SET 
				LAST_UPD = SYSDATE,
				STATUS = V_STATUS_MASTER
				WHERE ID = VMASTER_ID;
				COMMIT;
				
			END IF;
			
		END;
BEGIN
	EXEC_COMPARE(
		'&1', 
		'&2',
		'&3',
		'&4',
		'&5',
		&6,
		'&7'
	);

END ; 
/

