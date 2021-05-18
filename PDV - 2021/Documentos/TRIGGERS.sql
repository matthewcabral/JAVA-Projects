-- TRIGGER TABELA DE LISTA DE VALORES
CREATE OR REPLACE TRIGGER PDV.TRIGGER_T_LOV
AFTER INSERT
ON PDV.T_LST_OF_VAL
FOR EACH ROW

DECLARE
	V_PREFIX NUMBER(10, 0);
	V_SUFFIX NUMBER(10, 0);
	V_MODIFICATION_NUM NUMBER(10, 0);
	V_NEXT_ID VARCHAR2(15 CHAR);    
BEGIN
    SELECT
        P_PREFIX,
        P_SUFFIX,
        MODIFICATION_NUM,
        P_NEXT_ID
        INTO V_PREFIX, V_SUFFIX, V_MODIFICATION_NUM, V_NEXT_ID
    FROM PDV.T_SSA_ID;
    
    IF LENGTH(V_SUFFIX) = 1 THEN
        IF V_SUFFIX = 0 THEN
            V_SUFFIX := V_SUFFIX + 1;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-0000' || (TO_CHAR(V_SUFFIX));
        ELSIF V_SUFFIX < 9 THEN
            V_SUFFIX := V_SUFFIX + 1;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-0000' || (TO_CHAR(V_SUFFIX));
        ELSE
            V_SUFFIX := V_SUFFIX + 1;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-000' || (TO_CHAR(V_SUFFIX));
        END IF;
    ELSIF LENGTH(V_SUFFIX) = 2 THEN
        IF V_SUFFIX < 99 THEN
            V_SUFFIX := V_SUFFIX + 1;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-000' || (TO_CHAR(V_SUFFIX));
        ELSE
		V_SUFFIX := V_SUFFIX + 1;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-00' || (TO_CHAR(V_SUFFIX));
        END IF;
    ELSIF LENGTH(V_SUFFIX) = 3 THEN
        IF V_SUFFIX < 999 THEN
            V_SUFFIX := V_SUFFIX + 1;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-00' || (TO_CHAR(V_SUFFIX));
        ELSE
            V_SUFFIX := V_SUFFIX + 1;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-0' || (TO_CHAR(V_SUFFIX));
        END IF;
    ELSIF LENGTH(V_SUFFIX) = 4 THEN
        IF V_SUFFIX < 9999 THEN
            V_SUFFIX := V_SUFFIX + 1;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-0' || (TO_CHAR(V_SUFFIX));
        ELSE
            V_SUFFIX := V_SUFFIX + 1;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-' || (TO_CHAR(V_SUFFIX));
        END IF;
    ELSE
        IF V_SUFFIX < 99999 THEN
            V_SUFFIX := V_SUFFIX + 1;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-' || (TO_CHAR(V_SUFFIX));
        ELSE
            V_PREFIX := V_PREFIX + 1;
            V_SUFFIX := 0;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-0000' || (TO_CHAR(V_SUFFIX));
        END IF;
    END IF;
            
    UPDATE PDV.T_SSA_ID ID
    SET P_PREFIX = V_PREFIX,
        P_SUFFIX = V_SUFFIX,
        MODIFICATION_NUM = V_MODIFICATION_NUM + 1,
        P_NEXT_ID = V_NEXT_ID,
        LAST_UPD = SYSDATE;
END;

-- TRIGGER TABELA DE USUÁRIO
CREATE OR REPLACE TRIGGER PDV.TRIGGER_T_USER
AFTER INSERT
ON PDV.T_USER
FOR EACH ROW

DECLARE
	V_PREFIX NUMBER(10, 0);
	V_SUFFIX NUMBER(10, 0);
	V_MODIFICATION_NUM NUMBER(10, 0);
	V_NEXT_ID VARCHAR2(15 CHAR);    
BEGIN
    SELECT
        P_PREFIX,
        P_SUFFIX,
        MODIFICATION_NUM,
        P_NEXT_ID
        INTO V_PREFIX, V_SUFFIX, V_MODIFICATION_NUM, V_NEXT_ID
    FROM PDV.T_SSA_ID;
    
    IF LENGTH(V_SUFFIX) = 1 THEN
        IF V_SUFFIX = 0 THEN
            V_SUFFIX := V_SUFFIX + 1;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-0000' || (TO_CHAR(V_SUFFIX));
        ELSIF V_SUFFIX < 9 THEN
            V_SUFFIX := V_SUFFIX + 1;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-0000' || (TO_CHAR(V_SUFFIX));
        ELSE
            V_SUFFIX := V_SUFFIX + 1;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-000' || (TO_CHAR(V_SUFFIX));
        END IF;
    ELSIF LENGTH(V_SUFFIX) = 2 THEN
        IF V_SUFFIX < 99 THEN
            V_SUFFIX := V_SUFFIX + 1;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-000' || (TO_CHAR(V_SUFFIX));
        ELSE
            V_SUFFIX := V_SUFFIX + 1;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-00' || (TO_CHAR(V_SUFFIX));
        END IF;
    ELSIF LENGTH(V_SUFFIX) = 3 THEN
        IF V_SUFFIX < 999 THEN
            V_SUFFIX := V_SUFFIX + 1;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-00' || (TO_CHAR(V_SUFFIX));
        ELSE
            V_SUFFIX := V_SUFFIX + 1;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-0' || (TO_CHAR(V_SUFFIX));
        END IF;
    ELSIF LENGTH(V_SUFFIX) = 4 THEN
        IF V_SUFFIX < 9999 THEN
            V_SUFFIX := V_SUFFIX + 1;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-0' || (TO_CHAR(V_SUFFIX));
        ELSE
            V_SUFFIX := V_SUFFIX + 1;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-' || (TO_CHAR(V_SUFFIX));
        END IF;
    ELSE
        IF V_SUFFIX < 99999 THEN
            V_SUFFIX := V_SUFFIX + 1;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-' || (TO_CHAR(V_SUFFIX));
        ELSE
            V_PREFIX := V_PREFIX + 1;
            V_SUFFIX := 0;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-0000' || (TO_CHAR(V_SUFFIX));
        END IF;
    END IF;
            
    UPDATE PDV.T_SSA_ID ID
    SET P_PREFIX = V_PREFIX,
        P_SUFFIX = V_SUFFIX,
        MODIFICATION_NUM = V_MODIFICATION_NUM + 1,
        P_NEXT_ID = V_NEXT_ID,
        LAST_UPD = SYSDATE;
END;

-- TRIGGER TABELA DE POSICAO
CREATE OR REPLACE TRIGGER PDV.TRIGGER_T_POSITION
AFTER INSERT
ON PDV.T_POSITION
FOR EACH ROW

DECLARE
	V_PREFIX NUMBER(10, 0);
	V_SUFFIX NUMBER(10, 0);
	V_MODIFICATION_NUM NUMBER(10, 0);
	V_NEXT_ID VARCHAR2(15 CHAR);    
BEGIN
    SELECT
        P_PREFIX,
        P_SUFFIX,
        MODIFICATION_NUM,
        P_NEXT_ID
        INTO V_PREFIX, V_SUFFIX, V_MODIFICATION_NUM, V_NEXT_ID
    FROM PDV.T_SSA_ID;
    
    IF LENGTH(V_SUFFIX) = 1 THEN
        IF V_SUFFIX = 0 THEN
            V_SUFFIX := V_SUFFIX + 1;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-0000' || (TO_CHAR(V_SUFFIX));
        ELSIF V_SUFFIX < 9 THEN
            V_SUFFIX := V_SUFFIX + 1;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-0000' || (TO_CHAR(V_SUFFIX));
        ELSE
            V_SUFFIX := V_SUFFIX + 1;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-000' || (TO_CHAR(V_SUFFIX));
        END IF;
    ELSIF LENGTH(V_SUFFIX) = 2 THEN
        IF V_SUFFIX < 99 THEN
            V_SUFFIX := V_SUFFIX + 1;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-000' || (TO_CHAR(V_SUFFIX));
        ELSE
            V_SUFFIX := V_SUFFIX + 1;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-00' || (TO_CHAR(V_SUFFIX));
        END IF;
    ELSIF LENGTH(V_SUFFIX) = 3 THEN
        IF V_SUFFIX < 999 THEN
            V_SUFFIX := V_SUFFIX + 1;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-00' || (TO_CHAR(V_SUFFIX));
        ELSE
            V_SUFFIX := V_SUFFIX + 1;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-0' || (TO_CHAR(V_SUFFIX));
        END IF;
    ELSIF LENGTH(V_SUFFIX) = 4 THEN
        IF V_SUFFIX < 9999 THEN
            V_SUFFIX := V_SUFFIX + 1;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-0' || (TO_CHAR(V_SUFFIX));
        ELSE
            V_SUFFIX := V_SUFFIX + 1;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-' || (TO_CHAR(V_SUFFIX));
        END IF;
    ELSE
        IF V_SUFFIX < 99999 THEN
            V_SUFFIX := V_SUFFIX + 1;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-' || (TO_CHAR(V_SUFFIX));
        ELSE
            V_PREFIX := V_PREFIX + 1;
            V_SUFFIX := 0;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-0000' || (TO_CHAR(V_SUFFIX));
        END IF;
    END IF;
            
    UPDATE PDV.T_SSA_ID ID
    SET P_PREFIX = V_PREFIX,
        P_SUFFIX = V_SUFFIX,
        MODIFICATION_NUM = V_MODIFICATION_NUM + 1,
        P_NEXT_ID = V_NEXT_ID,
        LAST_UPD = SYSDATE;
END;

-- TRIGGER TABELA DE PERMISSAO DE USUARIO
create or replace TRIGGER PDV.TRIGGER_T_POSTN_PER
AFTER INSERT
ON PDV.T_POSTN_PER
FOR EACH ROW

DECLARE
	V_PREFIX NUMBER(10, 0);
	V_SUFFIX NUMBER(10, 0);
	V_MODIFICATION_NUM NUMBER(10, 0);
	V_NEXT_ID VARCHAR2(15 CHAR);    
BEGIN
    SELECT
        P_PREFIX,
        P_SUFFIX,
        MODIFICATION_NUM,
        P_NEXT_ID
        INTO V_PREFIX, V_SUFFIX, V_MODIFICATION_NUM, V_NEXT_ID
    FROM PDV.T_SSA_ID;

    IF LENGTH(V_SUFFIX) = 1 THEN
        IF V_SUFFIX = 0 THEN
            V_SUFFIX := V_SUFFIX + 1;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-0000' || (TO_CHAR(V_SUFFIX));
        ELSIF V_SUFFIX < 9 THEN
            V_SUFFIX := V_SUFFIX + 1;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-0000' || (TO_CHAR(V_SUFFIX));
        ELSE
            V_SUFFIX := V_SUFFIX + 1;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-000' || (TO_CHAR(V_SUFFIX));
        END IF;
    ELSIF LENGTH(V_SUFFIX) = 2 THEN
        IF V_SUFFIX < 99 THEN
            V_SUFFIX := V_SUFFIX + 1;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-000' || (TO_CHAR(V_SUFFIX));
        ELSE
            V_SUFFIX := V_SUFFIX + 1;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-00' || (TO_CHAR(V_SUFFIX));
        END IF;
    ELSIF LENGTH(V_SUFFIX) = 3 THEN
        IF V_SUFFIX < 999 THEN
            V_SUFFIX := V_SUFFIX + 1;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-00' || (TO_CHAR(V_SUFFIX));
        ELSE
            V_SUFFIX := V_SUFFIX + 1;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-0' || (TO_CHAR(V_SUFFIX));
        END IF;
    ELSIF LENGTH(V_SUFFIX) = 4 THEN
        IF V_SUFFIX < 9999 THEN
            V_SUFFIX := V_SUFFIX + 1;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-0' || (TO_CHAR(V_SUFFIX));
        ELSE
            V_SUFFIX := V_SUFFIX + 1;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-' || (TO_CHAR(V_SUFFIX));
        END IF;
    ELSE
        IF V_SUFFIX < 99999 THEN
            V_SUFFIX := V_SUFFIX + 1;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-' || (TO_CHAR(V_SUFFIX));
        ELSE
            V_PREFIX := V_PREFIX + 1;
            V_SUFFIX := 0;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-0000' || (TO_CHAR(V_SUFFIX));
        END IF;
    END IF;

    UPDATE PDV.T_SSA_ID ID
    SET P_PREFIX = V_PREFIX,
        P_SUFFIX = V_SUFFIX,
        MODIFICATION_NUM = V_MODIFICATION_NUM + 1,
        P_NEXT_ID = V_NEXT_ID,
        LAST_UPD = SYSDATE;
END;

-- TRIGGER TABELA DE CONTATO
CREATE OR REPLACE TRIGGER PDV.TRIGGER_T_CONTACT
AFTER INSERT
ON PDV.T_CONTACT
FOR EACH ROW

DECLARE
	V_PREFIX NUMBER(10, 0);
	V_SUFFIX NUMBER(10, 0);
	V_MODIFICATION_NUM NUMBER(10, 0);
	V_NEXT_ID VARCHAR2(15 CHAR);    
BEGIN
    SELECT
        P_PREFIX,
        P_SUFFIX,
        MODIFICATION_NUM,
        P_NEXT_ID
        INTO V_PREFIX, V_SUFFIX, V_MODIFICATION_NUM, V_NEXT_ID
    FROM PDV.T_SSA_ID;
    
    IF LENGTH(V_SUFFIX) = 1 THEN
        IF V_SUFFIX = 0 THEN
            V_SUFFIX := V_SUFFIX + 1;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-0000' || (TO_CHAR(V_SUFFIX));
        ELSIF V_SUFFIX < 9 THEN
            V_SUFFIX := V_SUFFIX + 1;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-0000' || (TO_CHAR(V_SUFFIX));
        ELSE
            V_SUFFIX := V_SUFFIX + 1;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-000' || (TO_CHAR(V_SUFFIX));
        END IF;
    ELSIF LENGTH(V_SUFFIX) = 2 THEN
        IF V_SUFFIX < 99 THEN
            V_SUFFIX := V_SUFFIX + 1;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-000' || (TO_CHAR(V_SUFFIX));
        ELSE
            V_SUFFIX := V_SUFFIX + 1;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-00' || (TO_CHAR(V_SUFFIX));
        END IF;
    ELSIF LENGTH(V_SUFFIX) = 3 THEN
        IF V_SUFFIX < 999 THEN
            V_SUFFIX := V_SUFFIX + 1;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-00' || (TO_CHAR(V_SUFFIX));
        ELSE
            V_SUFFIX := V_SUFFIX + 1;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-0' || (TO_CHAR(V_SUFFIX));
        END IF;
    ELSIF LENGTH(V_SUFFIX) = 4 THEN
        IF V_SUFFIX < 9999 THEN
            V_SUFFIX := V_SUFFIX + 1;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-0' || (TO_CHAR(V_SUFFIX));
        ELSE
            V_SUFFIX := V_SUFFIX + 1;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-' || (TO_CHAR(V_SUFFIX));
        END IF;
    ELSE
        IF V_SUFFIX < 99999 THEN
            V_SUFFIX := V_SUFFIX + 1;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-' || (TO_CHAR(V_SUFFIX));
        ELSE
            V_PREFIX := V_PREFIX + 1;
            V_SUFFIX := 0;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-0000' || (TO_CHAR(V_SUFFIX));
        END IF;
    END IF;
            
    UPDATE PDV.T_SSA_ID ID
    SET P_PREFIX = V_PREFIX,
        P_SUFFIX = V_SUFFIX,
        MODIFICATION_NUM = V_MODIFICATION_NUM + 1,
        P_NEXT_ID = V_NEXT_ID,
        LAST_UPD = SYSDATE;
END;

-- TRIGGER TABELA DE REDES SOCIAIS
CREATE OR REPLACE TRIGGER PDV.TRIGGER_T_CONTACT_X
AFTER INSERT
ON PDV.T_CONTACT_X
FOR EACH ROW

DECLARE
	V_PREFIX NUMBER(10, 0);
	V_SUFFIX NUMBER(10, 0);
	V_MODIFICATION_NUM NUMBER(10, 0);
	V_NEXT_ID VARCHAR2(15 CHAR);    
BEGIN
    SELECT
        P_PREFIX,
        P_SUFFIX,
        MODIFICATION_NUM,
        P_NEXT_ID
        INTO V_PREFIX, V_SUFFIX, V_MODIFICATION_NUM, V_NEXT_ID
    FROM PDV.T_SSA_ID;
    
    IF LENGTH(V_SUFFIX) = 1 THEN
        IF V_SUFFIX = 0 THEN
            V_SUFFIX := V_SUFFIX + 1;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-0000' || (TO_CHAR(V_SUFFIX));
        ELSIF V_SUFFIX < 9 THEN
            V_SUFFIX := V_SUFFIX + 1;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-0000' || (TO_CHAR(V_SUFFIX));
        ELSE
            V_SUFFIX := V_SUFFIX + 1;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-000' || (TO_CHAR(V_SUFFIX));
        END IF;
    ELSIF LENGTH(V_SUFFIX) = 2 THEN
        IF V_SUFFIX < 99 THEN
            V_SUFFIX := V_SUFFIX + 1;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-000' || (TO_CHAR(V_SUFFIX));
        ELSE
            V_SUFFIX := V_SUFFIX + 1;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-00' || (TO_CHAR(V_SUFFIX));
        END IF;
    ELSIF LENGTH(V_SUFFIX) = 3 THEN
        IF V_SUFFIX < 999 THEN
            V_SUFFIX := V_SUFFIX + 1;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-00' || (TO_CHAR(V_SUFFIX));
        ELSE
            V_SUFFIX := V_SUFFIX + 1;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-0' || (TO_CHAR(V_SUFFIX));
        END IF;
    ELSIF LENGTH(V_SUFFIX) = 4 THEN
        IF V_SUFFIX < 9999 THEN
            V_SUFFIX := V_SUFFIX + 1;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-0' || (TO_CHAR(V_SUFFIX));
        ELSE
            V_SUFFIX := V_SUFFIX + 1;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-' || (TO_CHAR(V_SUFFIX));
        END IF;
    ELSE
        IF V_SUFFIX < 99999 THEN
            V_SUFFIX := V_SUFFIX + 1;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-' || (TO_CHAR(V_SUFFIX));
        ELSE
            V_PREFIX := V_PREFIX + 1;
            V_SUFFIX := 0;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-0000' || (TO_CHAR(V_SUFFIX));
        END IF;
    END IF;
            
    UPDATE PDV.T_SSA_ID ID
    SET P_PREFIX = V_PREFIX,
        P_SUFFIX = V_SUFFIX,
        MODIFICATION_NUM = V_MODIFICATION_NUM + 1,
        P_NEXT_ID = V_NEXT_ID,
        LAST_UPD = SYSDATE;
END;

-- TRIGGER TABELA DE ENDEREÇOS
CREATE OR REPLACE TRIGGER PDV.TRIGGER_T_ADDRESS
AFTER INSERT
ON PDV.T_ADDRESS
FOR EACH ROW

DECLARE
	V_PREFIX NUMBER(10, 0);
	V_SUFFIX NUMBER(10, 0);
	V_MODIFICATION_NUM NUMBER(10, 0);
	V_NEXT_ID VARCHAR2(15 CHAR);    
BEGIN
    SELECT
        P_PREFIX,
        P_SUFFIX,
        MODIFICATION_NUM,
        P_NEXT_ID
        INTO V_PREFIX, V_SUFFIX, V_MODIFICATION_NUM, V_NEXT_ID
    FROM PDV.T_SSA_ID;
    
    IF LENGTH(V_SUFFIX) = 1 THEN
        IF V_SUFFIX = 0 THEN
            V_SUFFIX := V_SUFFIX + 1;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-0000' || (TO_CHAR(V_SUFFIX));
        ELSIF V_SUFFIX < 9 THEN
            V_SUFFIX := V_SUFFIX + 1;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-0000' || (TO_CHAR(V_SUFFIX));
        ELSE
            V_SUFFIX := V_SUFFIX + 1;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-000' || (TO_CHAR(V_SUFFIX));
        END IF;
    ELSIF LENGTH(V_SUFFIX) = 2 THEN
        IF V_SUFFIX < 99 THEN
            V_SUFFIX := V_SUFFIX + 1;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-000' || (TO_CHAR(V_SUFFIX));
        ELSE
            V_SUFFIX := V_SUFFIX + 1;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-00' || (TO_CHAR(V_SUFFIX));
        END IF;
    ELSIF LENGTH(V_SUFFIX) = 3 THEN
        IF V_SUFFIX < 999 THEN
            V_SUFFIX := V_SUFFIX + 1;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-00' || (TO_CHAR(V_SUFFIX));
        ELSE
            V_SUFFIX := V_SUFFIX + 1;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-0' || (TO_CHAR(V_SUFFIX));
        END IF;
    ELSIF LENGTH(V_SUFFIX) = 4 THEN
        IF V_SUFFIX < 9999 THEN
            V_SUFFIX := V_SUFFIX + 1;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-0' || (TO_CHAR(V_SUFFIX));
        ELSE
            V_SUFFIX := V_SUFFIX + 1;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-' || (TO_CHAR(V_SUFFIX));
        END IF;
    ELSE
        IF V_SUFFIX < 99999 THEN
            V_SUFFIX := V_SUFFIX + 1;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-' || (TO_CHAR(V_SUFFIX));
        ELSE
            V_PREFIX := V_PREFIX + 1;
            V_SUFFIX := 0;
            V_NEXT_ID := TO_CHAR(V_PREFIX) || '-0000' || (TO_CHAR(V_SUFFIX));
        END IF;
    END IF;
            
    UPDATE PDV.T_SSA_ID ID
    SET P_PREFIX = V_PREFIX,
        P_SUFFIX = V_SUFFIX,
        MODIFICATION_NUM = V_MODIFICATION_NUM + 1,
        P_NEXT_ID = V_NEXT_ID,
        LAST_UPD = SYSDATE;
END;