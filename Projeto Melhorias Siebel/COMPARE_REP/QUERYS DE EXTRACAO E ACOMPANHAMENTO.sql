select M.* from CTRL_LOG_COMP_REP_MASTER M where M.CREATED > sysdate -0.5;

select R.* from CTRL_LOG_COMP_REP R where R.DATE_START > sysdate -0.5;

select L.* from CTRL_LOG_COMP_REP_LOG L where L.TABLE_NAME='S_STDPROD_PMTRX';

SELECT  
A.* 
FROM BATIMENTO_REPOSITORIO A WHERE
CTRL_LOG_COMP_REP_ID IN
(
SELECT ID FROM
CTRL_LOG_COMP_REP WHERE MASTER_LOG_COMPARE_ID =
(SELECT MAX(ID) FROM CTRL_LOG_COMP_REP_MASTER))
AND  NOT EXISTS 
                        (   SELECT  1 FROM BATIMENTO_REPOSITORIO B 
                            WHERE A.CTRL_LOG_COMP_REP_ID IN
                                                        (
                                                        SELECT ID FROM
                                                        CTRL_LOG_COMP_REP WHERE MASTER_LOG_COMPARE_ID =
                                                        (SELECT MAX(ID) FROM CTRL_LOG_COMP_REP_MASTER))
                            AND (
                                B.OBJECT_NAME = A.PAR_N0
                                OR 
                                B.OBJECT_NAME = A.PAR_N1
                                OR
                                B.OBJECT_NAME = A.PAR_N2
                                OR
                                B.OBJECT_NAME = A.PAR_N3
                                )
                                AND B.STATUS = 'NOT EXISTS'
                                AND B.GROUP_OBJECT = A.GROUP_OBJECT
                                AND B.ORDER_COL <= A.ORDER_COL
                        )
                        ORDER BY PAR_N0, ORDER_COL, DESCRIPTION

						
						
						
						
						
						
						
select 
DATE_START,
br.status, 
br.description OBJECT_TYPE            , 
decode(par_n0, null, '', '['|| par_n0 || '] -> ') || 
decode(par_n1, null, '', '['|| par_n1 || '] -> ') ||
decode(par_n2, null, '', '['|| par_n2 || '] -> ') ||
decode(object_name, null, '', '['|| object_name || ']') objeto, 
column_name, 
object_name, 
val_orig, 
val_dest 
from SIEBEL.CTRL_LOG_COMPARE_REPOSITORY log, SIEBEL.TAB_CTRL_BATIMENTO_REP tab_ctlr , BATIMENTO_REPOSITORIO BR
where tab_ctlr.fila = log.fila
AND BR.CTRL_LOG_COMP_REP_ID = log.ID
and log.DATE_START > TO_DATE('25/07/2017 20:40:06', 'DD/MM/YYYY HH24:MI:SS')
and br.status = 'NOT EXISTS'

SELECT 
(select 
count(1) from SIEBEL.CTRL_LOG_COMPARE_REPOSITORY log, SIEBEL.TAB_CTRL_BATIMENTO_REP tab_ctlr
where tab_ctlr.fila = log.fila
and log.DATE_START > TO_DATE('25/07/2017 20:40:06', 'DD/MM/YYYY HH24:MI:SS')) TOTAL,
(select 
count(1) from SIEBEL.CTRL_LOG_COMPARE_REPOSITORY log, SIEBEL.TAB_CTRL_BATIMENTO_REP tab_ctlr
where tab_ctlr.fila = log.fila
and log.DATE_START > TO_DATE('25/07/2017 20:40:06', 'DD/MM/YYYY HH24:MI:SS')
and log.DATE_END IS NOT NULL) FINALIZADOS,
(select 
count(1) from SIEBEL.CTRL_LOG_COMPARE_REPOSITORY log, SIEBEL.TAB_CTRL_BATIMENTO_REP tab_ctlr
where tab_ctlr.fila = log.fila
and log.DATE_START > TO_DATE('25/07/2017 20:40:06', 'DD/MM/YYYY HH24:MI:SS'))
-
(select 
count(1) from SIEBEL.CTRL_LOG_COMPARE_REPOSITORY log, SIEBEL.TAB_CTRL_BATIMENTO_REP tab_ctlr
where tab_ctlr.fila = log.fila
and log.DATE_START > TO_DATE('25/07/2017 20:40:06', 'DD/MM/YYYY HH24:MI:SS')
and log.DATE_END IS NOT NULL) FALTAM
FROM DUAL


select * 
from SIEBEL.CTRL_LOG_COMPARE_REPOSITORY log, SIEBEL.TAB_CTRL_BATIMENTO_REP tab_ctlr 
where tab_ctlr.fila = log.fila
and log.DATE_END is not null

select rowid, a.* from SIEBEL.TAB_CTRL_BATIMENTO_REP a 

select * 
from SIEBEL.CTRL_LOG_COMPARE_REPOSITORY

select 
 (select count(1) from siebel.S_INTFLD_UPROP t , siebel.s_Repository rep where rep.row_id = t.Repository_id and rep.name = 'Siebel Repository' and substr( T.name , 1, 1) = 'A')+
 (select count(1) from siebel.S_INTFLD_UPROP t , siebel.s_Repository rep where rep.row_id = t.Repository_id and rep.name = 'Siebel Repository' and substr( T.name , 1, 1) = 'C')+
 (select count(1) from siebel.S_INTFLD_UPROP t , siebel.s_Repository rep where rep.row_id = t.Repository_id and rep.name = 'Siebel Repository' and substr( T.name , 1, 1) IN ( 'B', 'D'))+
 (select count(1) from siebel.S_INTFLD_UPROP t , siebel.s_Repository rep where rep.row_id = t.Repository_id and rep.name = 'Siebel Repository' and substr( T.name , 1, 1) IN ('E', 'F'))+
 (select count(1) from siebel.S_INTFLD_UPROP t , siebel.s_Repository rep where rep.row_id = t.Repository_id and rep.name = 'Siebel Repository' and substr( T.name , 1, 1) IN ('G', 'H', 'I'))+
 (select count(1) from siebel.S_INTFLD_UPROP t , siebel.s_Repository rep where rep.row_id = t.Repository_id and rep.name = 'Siebel Repository' and substr( T.name , 1, 1)  IN ('L', 'M'))+
 (select count(1) from siebel.S_INTFLD_UPROP t , siebel.s_Repository rep where rep.row_id = t.Repository_id and rep.name = 'Siebel Repository' and substr( T.name , 1, 1) IN ('N', 'O', 'Q'))+
 (select count(1) from siebel.S_INTFLD_UPROP t , siebel.s_Repository rep where rep.row_id = t.Repository_id and rep.name = 'Siebel Repository' and substr( T.name , 1, 1) = 'P')+
 (select count(1) from siebel.S_INTFLD_UPROP t , siebel.s_Repository rep where rep.row_id = t.Repository_id and rep.name = 'Siebel Repository' and substr( T.name , 1, 1)  IN ('R', 'U'))+
 (select count(1) from siebel.S_INTFLD_UPROP t , siebel.s_Repository rep where rep.row_id = t.Repository_id and rep.name = 'Siebel Repository' and substr( T.name , 1, 1) = 'S')+
 (select count(1) from siebel.S_INTFLD_UPROP t , siebel.s_Repository rep where rep.row_id = t.Repository_id and rep.name = 'Siebel Repository' and substr(t.name, 1, 6) = 'VIVO C')+
 (select count(1) from siebel.S_INTFLD_UPROP t , siebel.s_Repository rep where rep.row_id = t.Repository_id and rep.name = 'Siebel Repository' and substr(t.name, 1, 6) IN ('VIVO E', 'VIVO D', 'VIVO A', 'VIVO B'))+
 (select count(1) from siebel.S_INTFLD_UPROP t , siebel.s_Repository rep where rep.row_id = t.Repository_id and rep.name = 'Siebel Repository' and substr(t.name, 1, 6) IN ('VIVO F','VIVO G', 'VIVO H', 'VIVO I', 'VIVO J', 'VIVO L', 'VIVO M', 'VIVO N'))+
 (select count(1) from siebel.S_INTFLD_UPROP t , siebel.s_Repository rep where rep.row_id = t.Repository_id and rep.name = 'Siebel Repository' and substr(t.name, 1, 6) IN ('VIVO O','VIVO P', 'VIVO Q'))+
 (select count(1) from siebel.S_INTFLD_UPROP t , siebel.s_Repository rep where rep.row_id = t.Repository_id and rep.name = 'Siebel Repository' and substr(t.name, 1, 6) IN ( 'VIVO R', 'VIVO S', 'VIVO T' ) )+
 (select count(1) from siebel.S_INTFLD_UPROP t , siebel.s_Repository rep where rep.row_id = t.Repository_id and rep.name = 'Siebel Repository' and substr(t.name, 1, 6) IN ( 'VIVO U', 'VIVO V',  'VIVO X', 'VIVO Z'))+
 --(select count(1) from siebel.S_INTFLD_UPROP t , siebel.s_Repository rep where rep.row_id = t.Repository_id and rep.name = 'Siebel Repository' and substr(t.name, 1, 1) IN ( 'V'))+
 (select count(1) from siebel.S_INTFLD_UPROP t , siebel.s_Repository rep where rep.row_id = t.Repository_id and rep.name = 'Siebel Repository' and substr(t.name, 1, 1) IN ( 'V') and substr(t.name, 1, 6) NOT IN ( 'VIVO A','VIVO B', 'VIVO C', 'VIVO D', 'VIVO E', 'VIVO F', 'VIVO G', 'VIVO H', 'VIVO I','VIVO J', 'VIVO L', 'VIVO M', 'VIVO N', 'VIVO O', 'VIVO P', 'VIVO Q', 'VIVO R', 'VIVO S','VIVO T', 'VIVO U', 'VIVO V', 'VIVO X', 'VIVO Z'))+
 (select count(1) from siebel.S_INTFLD_UPROP t , siebel.s_Repository rep where rep.row_id = t.Repository_id and rep.name = 'Siebel Repository' and substr( T.name , 1, 1) NOT IN ('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',  'U', 'V' ))
 soma,
 (select count(1) from siebel.S_INTFLD_UPROP t , siebel.s_Repository rep where rep.row_id = t.Repository_id and rep.name = 'Siebel Repository') total
 from dual
 
 
 
 select 
 (select count(1) from siebel.S_INTFLD_UPROP t , siebel.s_Repository rep where rep.row_id = t.Repository_id and rep.name = 'Siebel Repository' and substr( T.name , 1, 1) NOT IN ( 'X')) +
 (select count(1) from siebel.S_INTFLD_UPROP t , siebel.s_Repository rep where rep.row_id = t.Repository_id and rep.name = 'Siebel Repository' and  T.name IN ( 'XMLTagNamespace', 'XMLTagNamespace`'))+
 (select count(1) from siebel.S_INTFLD_UPROP t , siebel.s_Repository rep where rep.row_id = t.Repository_id and rep.name = 'Siebel Repository' and  T.name IN ( 'XSDTypeNamespace')) +
 (select count(1) from siebel.S_INTFLD_UPROP t , siebel.s_Repository rep where rep.row_id = t.Repository_id and rep.name = 'Siebel Repository' and  T.name IN ( 'XSDTypeName')) SOMA, 
 (select count(1) from siebel.S_INTFLD_UPROP t , siebel.s_Repository rep where rep.row_id = t.Repository_id and rep.name = 'Siebel Repository') total
from dual

 substr( T.name , 1, 1) NOT IN ( 'X')
 substr( T.name , 1, 1) IN ( 'X') AND T.name NOT IN ( 'XMLTagNamespace', 'XMLTagNamespace`', 'XSDTypeNamespace', 'XSDTypeName') 
 T.name IN ( 'XSDTypeNamespace') 
 T.name IN ( 'XSDTypeName')