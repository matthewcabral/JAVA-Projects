DECLARE
    PASS VARCHAR(35):='Mc26011997@';
    password_encrypted VARCHAR(175);
	password_decrypted VARCHAR(35);
BEGIN
    FOR I IN 1..LENGTH(PASS) LOOP
        DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1));
    END LOOP;
    
    FOR I IN 1..LENGTH(PASS) LOOP
        IF SUBSTR(PASS, I, 1) = 'A' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || '01aWf');
            password_encrypted := password_encrypted || '01aWf';
        ELSIF SUBSTR(PASS, I, 1) = 'B' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || '2uasD');
            password_encrypted := password_encrypted || '2uasD';
        ELSIF SUBSTR(PASS, I, 1) = 'C' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || 'r4sfA');
            password_encrypted := password_encrypted || 'r4sfA';
        ELSIF SUBSTR(PASS, I, 1) = 'D' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || ':ASDs');
            password_encrypted := password_encrypted || ':ASDs';
        ELSIF SUBSTR(PASS, I, 1) = 'E' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || '>asYA');
            password_encrypted := password_encrypted || '>asYA';
        ELSIF SUBSTR(PASS, I, 1) = 'F' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || '(9usH');
            password_encrypted := password_encrypted || '(9usH';
        ELSIF SUBSTR(PASS, I, 1) = 'G' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || 'Â748x');
            password_encrypted := password_encrypted || 'Â748x';
        ELSIF SUBSTR(PASS, I, 1) = 'H' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || ';23cx');
            password_encrypted := password_encrypted || ';23cx';
        ELSIF SUBSTR(PASS, I, 1) = 'I' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || '%#sqf');
            password_encrypted := password_encrypted || '%#sqf';
        ELSIF SUBSTR(PASS, I, 1) = 'J' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || '@13ac');
            password_encrypted := password_encrypted || '@13ac';
        ELSIF SUBSTR(PASS, I, 1) = 'K' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || '!*vbf');
            password_encrypted := password_encrypted || '!*vbf';
        ELSIF SUBSTR(PASS, I, 1) = 'L' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || '\|sda');
            password_encrypted := password_encrypted || '\|sda';
        ELSIF SUBSTR(PASS, I, 1) = 'M' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || ',s.ad');
            password_encrypted := password_encrypted || ',s.ad';
        ELSIF SUBSTR(PASS, I, 1) = 'N' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || '*+-as');
            password_encrypted := password_encrypted || '*+-as';
        ELSIF SUBSTR(PASS, I, 1) = 'O' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || '6¬7bk');
            password_encrypted := password_encrypted || '6¬7bk';
        ELSIF SUBSTR(PASS, I, 1) = 'P' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || '~sd4s');
            password_encrypted := password_encrypted || '~sd4s';
        ELSIF SUBSTR(PASS, I, 1) = 'Q' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || 'AAAAA');
            password_encrypted := password_encrypted || 'AAAAA';
        ELSIF SUBSTR(PASS, I, 1) = 'R' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || 'DSCsd');
            password_encrypted := password_encrypted || 'DSCsd';
        ELSIF SUBSTR(PASS, I, 1) = 'S' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || '§ssVR');
            password_encrypted := password_encrypted || '§ssVR';
        ELSIF SUBSTR(PASS, I, 1) = 'T' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || '*b406');
            password_encrypted := password_encrypted || '*b406';
        ELSIF SUBSTR(PASS, I, 1) = 'U' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || '6Gash');
            password_encrypted := password_encrypted || '6Gash';
        ELSIF SUBSTR(PASS, I, 1) = 'V' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || 'sS:Kg');
            password_encrypted := password_encrypted || 'sS:Kg';
        ELSIF SUBSTR(PASS, I, 1) = 'X' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || 'jJvbx');
            password_encrypted := password_encrypted || 'jJvbx';
        ELSIF SUBSTR(PASS, I, 1) = 'W' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || '12658');
            password_encrypted := password_encrypted || '12658';
        ELSIF SUBSTR(PASS, I, 1) = 'Y' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || '32894');
            password_encrypted := password_encrypted || '32894';
        ELSIF SUBSTR(PASS, I, 1) = 'Z' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || '78521');
            password_encrypted := password_encrypted || '78521';
        ELSIF SUBSTR(PASS, I, 1) = 'a' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || '00213');
            password_encrypted := password_encrypted || '00213';
        ELSIF SUBSTR(PASS, I, 1) = 'b' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || 'q12as');
            password_encrypted := password_encrypted || 'q12as';
        ELSIF SUBSTR(PASS, I, 1) = 'c' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || '54fH1');
            password_encrypted := password_encrypted || '54fH1';
        ELSIF SUBSTR(PASS, I, 1) = 'd' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || 'A5-15');
            password_encrypted := password_encrypted || 'A5-15';
        ELSIF SUBSTR(PASS, I, 1) = 'e' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || 'RsKKy');
            password_encrypted := password_encrypted || 'RsKKy';
        ELSIF SUBSTR(PASS, I, 1) = 'f' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || 'terRW');
            password_encrypted := password_encrypted || 'terRW';
        ELSIF SUBSTR(PASS, I, 1) = 'g' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || 'CaGue');
            password_encrypted := password_encrypted || 'CaGue';
        ELSIF SUBSTR(PASS, I, 1) = 'h' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || 'iDjsb');
            password_encrypted := password_encrypted || 'iDjsb';
        ELSIF SUBSTR(PASS, I, 1) = 'i' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || 'ZuAdo');
            password_encrypted := password_encrypted || 'ZuAdo';
        ELSIF SUBSTR(PASS, I, 1) = 'j' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || 'WWWWW');
            password_encrypted := password_encrypted || 'WWWWW';
        ELSIF SUBSTR(PASS, I, 1) = 'k' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || 'gO0gL');
            password_encrypted := password_encrypted || 'gO0gL';
        ELSIF SUBSTR(PASS, I, 1) = 'l' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || '@PPle');
            password_encrypted := password_encrypted || '@PPle';
        ELSIF SUBSTR(PASS, I, 1) = 'm' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || 'MiCro');
            password_encrypted := password_encrypted || 'MiCro';
        ELSIF SUBSTR(PASS, I, 1) = 'n' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || 'SoftW');
            password_encrypted := password_encrypted || 'SoftW';
        ELSIF SUBSTR(PASS, I, 1) = 'o' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || 'wINdo');
            password_encrypted := password_encrypted || 'wINdo';
        ELSIF SUBSTR(PASS, I, 1) = 'p' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || 'wS10@');
            password_encrypted := password_encrypted || 'wS10@';
        ELSIF SUBSTR(PASS, I, 1) = 'q' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || 'M@c0S');
            password_encrypted := password_encrypted || 'M@c0S';
        ELSIF SUBSTR(PASS, I, 1) = 'r' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || 'hIGHS');
            password_encrypted := password_encrypted || 'hIGHS';
        ELSIF SUBSTR(PASS, I, 1) = 's' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || 'iErra');
            password_encrypted := password_encrypted || 'iErra';
        ELSIF SUBSTR(PASS, I, 1) = 't' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || 'Le0PA');
            password_encrypted := password_encrypted || 'Le0PA';
        ELSIF SUBSTR(PASS, I, 1) = 'u' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || 'Rrddd');
            password_encrypted := password_encrypted || 'Rrddd';
        ELSIF SUBSTR(PASS, I, 1) = 'v' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || 'bIgSR');
            password_encrypted := password_encrypted || 'bIgSR';
        ELSIF SUBSTR(PASS, I, 1) = 'x' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || 'SieBE');
            password_encrypted := password_encrypted || 'SieBE';
        ELSIF SUBSTR(PASS, I, 1) = 'w' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || 't001S');
            password_encrypted := password_encrypted || 't001S';
        ELSIF SUBSTR(PASS, I, 1) = 'y' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || '*/!@$');
            password_encrypted := password_encrypted || '*/!@$';
        ELSIF SUBSTR(PASS, I, 1) = 'z' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || '\\we|');
            password_encrypted := password_encrypted || '\\we|';        
        ELSIF SUBSTR(PASS, I, 1) = '0' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || ':;/*3');
            password_encrypted := password_encrypted || ':;/*3';
        ELSIF SUBSTR(PASS, I, 1) = '1' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || '.,;:2');
            password_encrypted := password_encrypted || '.,;:2';
        ELSIF SUBSTR(PASS, I, 1) = '2' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || '0.83,');
            password_encrypted := password_encrypted || '0.83,';
        ELSIF SUBSTR(PASS, I, 1) = '3' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || '<r>4w');
            password_encrypted := password_encrypted || '<r>4w';
        ELSIF SUBSTR(PASS, I, 1) = '4' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || '↑hs→a');
            password_encrypted := password_encrypted || '↑hs→a';
        ELSIF SUBSTR(PASS, I, 1) = '5' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || '←hi↨4');
            password_encrypted := password_encrypted || '←hi↨4';
        ELSIF SUBSTR(PASS, I, 1) = '6' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || 'gfa54');
            password_encrypted := password_encrypted || 'gfa54';
        ELSIF SUBSTR(PASS, I, 1) = '7' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || '¨¨*.,');
            password_encrypted := password_encrypted || '¨¨*.,';
        ELSIF SUBSTR(PASS, I, 1) = '8' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || '935hj');
            password_encrypted := password_encrypted || '935hj';
        ELSIF SUBSTR(PASS, I, 1) = '9' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || 'j0rN@');
            password_encrypted := password_encrypted || 'j0rN@';        
        ELSIF SUBSTR(PASS, I, 1) = '!' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || 'H0jE3');
            password_encrypted := password_encrypted || 'H0jE3';
        ELSIF SUBSTR(PASS, I, 1) = '@' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || 'rJtV1');
            password_encrypted := password_encrypted || 'rJtV1';
        ELSIF SUBSTR(PASS, I, 1) = '#' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || 'RjtV2');
            password_encrypted := password_encrypted || 'RjtV2';
        ELSIF SUBSTR(PASS, I, 1) = '$' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || 'B0mD1');
            password_encrypted := password_encrypted || 'B0mD1';
        ELSIF SUBSTR(PASS, I, 1) = '%' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || 'aR10m');
            password_encrypted := password_encrypted || 'aR10m';
        ELSIF SUBSTR(PASS, I, 1) = '¨' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || 'gtHJs');
            password_encrypted := password_encrypted || 'gtHJs';
        ELSIF SUBSTR(PASS, I, 1) = '*' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || '/-?as');
            password_encrypted := password_encrypted || '/-?as';
        ELSIF SUBSTR(PASS, I, 1) = '(' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || '?ad?z');
            password_encrypted := password_encrypted || '?ad?z';
        ELSIF SUBSTR(PASS, I, 1) = ')' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || 'e?sc°');
            password_encrypted := password_encrypted || 'e?sc°';
        ELSIF SUBSTR(PASS, I, 1) = '_' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || 'ª}[as');
            password_encrypted := password_encrypted || 'ª}[as';
        ELSIF SUBSTR(PASS, I, 1) = '-' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || '{QW?]');
            password_encrypted := password_encrypted || '{QW?]';
        ELSIF SUBSTR(PASS, I, 1) = '=' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || '{{aaa');
            password_encrypted := password_encrypted || '{{aaa';
        ELSIF SUBSTR(PASS, I, 1) = '+' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || '^qwda');
            password_encrypted := password_encrypted || '^qwda';
        ELSIF SUBSTR(PASS, I, 1) = '{' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || 'qwert');
            password_encrypted := password_encrypted || 'qwert';
        ELSIF SUBSTR(PASS, I, 1) = '}' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || 'asdfg');
            password_encrypted := password_encrypted || 'asdfg';
        ELSIF SUBSTR(PASS, I, 1) = '[' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || 'zxcvb');
            password_encrypted := password_encrypted || 'zxcvb';
        ELSIF SUBSTR(PASS, I, 1) = ']' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || 'yuiop');
            password_encrypted := password_encrypted || 'yuiop';
        ELSIF SUBSTR(PASS, I, 1) = 'ª' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || 'ghjkl');
            password_encrypted := password_encrypted || 'ghjkl';
        ELSIF SUBSTR(PASS, I, 1) = 'º' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || 'ççrdv');
            password_encrypted := password_encrypted || 'ççrdv';
        ELSIF SUBSTR(PASS, I, 1) = '<' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || 'bnmça');
            password_encrypted := password_encrypted || 'bnmça';
        ELSIF SUBSTR(PASS, I, 1) = '>' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || 'JÇKan');
            password_encrypted := password_encrypted || 'JÇKan';
        ELSIF SUBSTR(PASS, I, 1) = ';' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || 'ASKDa');
            password_encrypted := password_encrypted || 'ASKDa';
        ELSIF SUBSTR(PASS, I, 1) = ':' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || 'ÇLASK');
            password_encrypted := password_encrypted || 'ÇLASK';
        ELSIF SUBSTR(PASS, I, 1) = '§' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || 'YYYYY');
            password_encrypted := password_encrypted || 'YYYYY';
        ELSIF SUBSTR(PASS, I, 1) = '£' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || 'BBBBB');
            password_encrypted := password_encrypted || 'BBBBB';
        ELSIF SUBSTR(PASS, I, 1) = '¢' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || 'NNNNN');
            password_encrypted := password_encrypted || 'NNNNN';
        ELSIF SUBSTR(PASS, I, 1) = '¬' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || 'RRRRR');
            password_encrypted := password_encrypted || 'RRRRR';
        ELSIF SUBSTR(PASS, I, 1) = '/' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || 'ddddd');
            password_encrypted := password_encrypted || 'ddddd';
        ELSIF SUBSTR(PASS, I, 1) = '\' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || 'xxxxx');
            password_encrypted := password_encrypted || 'xxxxx';
        ELSIF SUBSTR(PASS, I, 1) = '|' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || 'ZZZZZ');
			password_encrypted := password_encrypted || 'ZZZZZ';
		ELSIF SUBSTR(PASS, I, 1) = '^' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || 'lllll');
            password_encrypted := password_encrypted || 'lllll';
		ELSIF SUBSTR(PASS, I, 1) = '~' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || 'xbxbx');
            password_encrypted := password_encrypted || 'xbxbx';
		ELSIF SUBSTR(PASS, I, 1) = '.' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || 'vbncv');
            password_encrypted := password_encrypted || 'vbncv';
		ELSIF SUBSTR(PASS, I, 1) = ',' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || 'we.,a');
            password_encrypted := password_encrypted || 'we.,a';
		ELSIF SUBSTR(PASS, I, 1) = '?' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(PASS, I, 1) || ' Virou: ' || 'jsjss');
            password_encrypted := password_encrypted || 'jsjss';
        END IF;
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('Senha Criptografada: ' || password_encrypted);
	
	FOR I IN 1..LENGTH(password_encrypted) LOOP
        DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5));
    END LOOP;
    
    FOR I IN 1..LENGTH(password_encrypted) LOOP
        IF SUBSTR(password_encrypted, I, 5) = '01aWf' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || 'A');
            password_decrypted := password_decrypted || 'A';
        ELSIF SUBSTR(password_encrypted, I, 5) = '2uasD' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || 'B');
            password_decrypted := password_decrypted || 'B';
        ELSIF SUBSTR(password_encrypted, I, 5) = 'r4sfA' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || 'C');
            password_decrypted := password_decrypted || 'C';
        ELSIF SUBSTR(password_encrypted, I, 5) = ':ASDs' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || 'D');
            password_decrypted := password_decrypted || 'D';
        ELSIF SUBSTR(password_encrypted, I, 5) = '>asYA' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || 'E');
            password_decrypted := password_decrypted || 'E';
        ELSIF SUBSTR(password_encrypted, I, 5) = '(9usH' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || 'F');
            password_decrypted := password_decrypted || 'F';
        ELSIF SUBSTR(password_encrypted, I, 5) = 'Â748x' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || 'G');
            password_decrypted := password_decrypted || 'G';
        ELSIF SUBSTR(password_encrypted, I, 5) = ';23cx' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || 'H');
            password_decrypted := password_decrypted || 'H';
        ELSIF SUBSTR(password_encrypted, I, 5) = '%#sqf' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || 'I');
            password_decrypted := password_decrypted || 'I';
        ELSIF SUBSTR(password_encrypted, I, 5) = '@13ac' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || 'J');
            password_decrypted := password_decrypted || 'J';
        ELSIF SUBSTR(password_encrypted, I, 5) = '!*vbf' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || 'K');
            password_decrypted := password_decrypted || 'K';
        ELSIF SUBSTR(password_encrypted, I, 5) = '\|sda' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || 'L');
            password_decrypted := password_decrypted || 'L';
        ELSIF SUBSTR(password_encrypted, I, 5) = ',s.ad' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || 'M');
            password_decrypted := password_decrypted || 'M';
        ELSIF SUBSTR(password_encrypted, I, 5) = '*+-as' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || 'N');
            password_decrypted := password_decrypted || '';
        ELSIF SUBSTR(password_encrypted, I, 5) = '6¬7bk' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || 'O');
            password_decrypted := password_decrypted || '';
        ELSIF SUBSTR(password_encrypted, I, 5) = '~sd4s' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || 'P');
            password_decrypted := password_decrypted || 'P';
        ELSIF SUBSTR(password_encrypted, I, 5) = 'AAAAA' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || 'Q');
            password_decrypted := password_decrypted || 'Q';
        ELSIF SUBSTR(password_encrypted, I, 5) = 'DSCsd' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || 'R');
            password_decrypted := password_decrypted || 'R';
        ELSIF SUBSTR(password_encrypted, I, 5) = '§ssVR' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || 'S');
            password_decrypted := password_decrypted || 'S';
        ELSIF SUBSTR(password_encrypted, I, 5) = '*b406' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || 'T');
            password_decrypted := password_decrypted || 'T';
        ELSIF SUBSTR(password_encrypted, I, 5) = '6Gash' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || 'U');
            password_decrypted := password_decrypted || 'U';
        ELSIF SUBSTR(password_encrypted, I, 5) = 'sS:Kg' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || 'V');
            password_decrypted := password_decrypted || 'V';
        ELSIF SUBSTR(password_encrypted, I, 5) = 'jJvbx' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || 'X');
            password_decrypted := password_decrypted || 'X';
        ELSIF SUBSTR(password_encrypted, I, 5) = '12658' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || 'W');
            password_decrypted := password_decrypted || 'W';
        ELSIF SUBSTR(password_encrypted, I, 5) = '32894' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || 'Y');
            password_decrypted := password_decrypted || 'Y';
        ELSIF SUBSTR(password_encrypted, I, 5) = '78521' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || 'Z');
            password_decrypted := password_decrypted || 'Z';
        ELSIF SUBSTR(password_encrypted, I, 5) = '00213' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || 'a');
            password_decrypted := password_decrypted || 'a';
        ELSIF SUBSTR(password_encrypted, I, 5) = 'q12as' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || 'b');
            password_decrypted := password_decrypted || 'b';
        ELSIF SUBSTR(password_encrypted, I, 5) = '54fH1' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || 'c');
            password_decrypted := password_decrypted || 'c';
        ELSIF SUBSTR(password_encrypted, I, 5) = 'A5-15' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || 'd');
            password_decrypted := password_decrypted || 'd';
        ELSIF SUBSTR(password_encrypted, I, 5) = 'RsKKy' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || 'e');
            password_decrypted := password_decrypted || 'e';
        ELSIF SUBSTR(password_encrypted, I, 5) = 'terRW' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || 'f');
            password_decrypted := password_decrypted || 'f';
        ELSIF SUBSTR(password_encrypted, I, 5) = 'CaGue' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || 'g');
            password_decrypted := password_decrypted || 'g';
        ELSIF SUBSTR(password_encrypted, I, 5) = 'iDjsb' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || 'h');
            password_decrypted := password_decrypted || 'h';
        ELSIF SUBSTR(password_encrypted, I, 5) = 'ZuAdo' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || 'i');
            password_decrypted := password_decrypted || 'i';
        ELSIF SUBSTR(password_encrypted, I, 5) = 'WWWWW' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || 'j');
            password_decrypted := password_decrypted || 'j';
        ELSIF SUBSTR(password_encrypted, I, 5) = 'gO0gL' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || 'k');
            password_decrypted := password_decrypted || 'k';
        ELSIF SUBSTR(password_encrypted, I, 5) = '@PPle' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || 'l');
            password_decrypted := password_decrypted || 'l';
        ELSIF SUBSTR(password_encrypted, I, 5) = 'MiCro' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || 'm');
            password_decrypted := password_decrypted || 'm';
        ELSIF SUBSTR(password_encrypted, I, 5) = 'SoftW' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || 'n');
            password_decrypted := password_decrypted || 'n';
        ELSIF SUBSTR(password_encrypted, I, 5) = 'wINdo' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || 'o');
            password_decrypted := password_decrypted || 'o';
        ELSIF SUBSTR(password_encrypted, I, 5) = 'wS10@' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || 'p');
            password_decrypted := password_decrypted || 'p';
        ELSIF SUBSTR(password_encrypted, I, 5) = 'M@c0S' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || 'q');
            password_decrypted := password_decrypted || 'q';
        ELSIF SUBSTR(password_encrypted, I, 5) = 'hIGHS' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || 'r');
            password_decrypted := password_decrypted || 'r';
        ELSIF SUBSTR(password_encrypted, I, 5) = 'iErra' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || 's');
            password_decrypted := password_decrypted || 's';
        ELSIF SUBSTR(password_encrypted, I, 5) = 'Le0PA' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || 't');
            password_decrypted := password_decrypted || 't';
        ELSIF SUBSTR(password_encrypted, I, 5) = 'Rrddd' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || 'u');
            password_decrypted := password_decrypted || 'u';
        ELSIF SUBSTR(password_encrypted, I, 5) = 'bIgSR' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || 'v');
            password_decrypted := password_decrypted || 'v';
        ELSIF SUBSTR(password_encrypted, I, 5) = 'SieBE' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || 'x');
            password_decrypted := password_decrypted || 'x';
        ELSIF SUBSTR(password_encrypted, I, 5) = 't001S' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || 'w');
            password_decrypted := password_decrypted || 'w';
        ELSIF SUBSTR(password_encrypted, I, 5) = '*/!@$' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || 'y');
            password_decrypted := password_decrypted || 'y';
        ELSIF SUBSTR(password_encrypted, I, 5) = '\\we|' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || 'z');
            password_decrypted := password_decrypted || 'z';        
        ELSIF SUBSTR(password_encrypted, I, 5) = ':;/*3' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || '0');
            password_decrypted := password_decrypted || '0';
        ELSIF SUBSTR(password_encrypted, I, 5) = '.,;:2' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || '1');
            password_decrypted := password_decrypted || '1';
        ELSIF SUBSTR(password_encrypted, I, 5) = '0.83,' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || '2');
            password_decrypted := password_decrypted || '2';
        ELSIF SUBSTR(password_encrypted, I, 5) = '<r>4w' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || '3');
            password_decrypted := password_decrypted || '3';
        ELSIF SUBSTR(password_encrypted, I, 5) = '↑hs→a' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || '4');
            password_decrypted := password_decrypted || '4';
        ELSIF SUBSTR(password_encrypted, I, 5) = '←hi↨4' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || '5');
            password_decrypted := password_decrypted || '5';
        ELSIF SUBSTR(password_encrypted, I, 5) = 'gfa54' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || '6');
            password_decrypted := password_decrypted || '6';
        ELSIF SUBSTR(password_encrypted, I, 5) = '¨¨*.,' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || '7');
            password_decrypted := password_decrypted || '7';
        ELSIF SUBSTR(password_encrypted, I, 5) = '935hj' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || '8');
            password_decrypted := password_decrypted || '8';
        ELSIF SUBSTR(password_encrypted, I, 5) = 'j0rN@' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || '9');
            password_decrypted := password_decrypted || '9';        
        ELSIF SUBSTR(password_encrypted, I, 5) = 'H0jE3' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || '!');
            password_decrypted := password_decrypted || '!';
        ELSIF SUBSTR(password_encrypted, I, 5) = 'rJtV1' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || '@');
            password_decrypted := password_decrypted || '@';
        ELSIF SUBSTR(password_encrypted, I, 5) = 'RjtV2' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || '#');
            password_decrypted := password_decrypted || '#';
        ELSIF SUBSTR(password_encrypted, I, 5) = 'B0mD1' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || '$');
            password_decrypted := password_decrypted || '$';
        ELSIF SUBSTR(password_encrypted, I, 5) = 'aR10m' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || '%');
            password_decrypted := password_decrypted || '%';
        ELSIF SUBSTR(password_encrypted, I, 5) = 'gtHJs' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || '¨');
            password_decrypted := password_decrypted || '¨';
        ELSIF SUBSTR(password_encrypted, I, 5) = '/-?as' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || '*');
            password_decrypted := password_decrypted || '*';
        ELSIF SUBSTR(password_encrypted, I, 5) = '?ad?z' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || '(');
            password_decrypted := password_decrypted || '(';
        ELSIF SUBSTR(password_encrypted, I, 5) = 'e?sc°' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || ')');
            password_decrypted := password_decrypted || ')';
        ELSIF SUBSTR(password_encrypted, I, 5) = 'ª}[as' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || '_');
            password_decrypted := password_decrypted || '_';
        ELSIF SUBSTR(password_encrypted, I, 5) = '{QW?]' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || '-');
            password_decrypted := password_decrypted || '-';
        ELSIF SUBSTR(password_encrypted, I, 5) = '{{aaa' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || '=');
            password_decrypted := password_decrypted || '=';
        ELSIF SUBSTR(password_encrypted, I, 5) = '^qwda' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || '+');
            password_decrypted := password_decrypted || '+';
        ELSIF SUBSTR(password_encrypted, I, 5) = 'qwert' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || '{');
            password_decrypted := password_decrypted || '{';
        ELSIF SUBSTR(password_encrypted, I, 5) = 'asdfg' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || '}');
            password_decrypted := password_decrypted || '}';
        ELSIF SUBSTR(password_encrypted, I, 5) = 'zxcvb' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || '[');
            password_decrypted := password_decrypted || '[';
        ELSIF SUBSTR(password_encrypted, I, 5) = 'yuiop' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || ']');
            password_decrypted := password_decrypted || ']';
        ELSIF SUBSTR(password_encrypted, I, 5) = 'ghjkl' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || 'ª');
            password_decrypted := password_decrypted || 'ª';
        ELSIF SUBSTR(password_encrypted, I, 5) = 'ççrdv' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || 'º');
            password_decrypted := password_decrypted || 'º';
        ELSIF SUBSTR(password_encrypted, I, 5) = 'bnmça' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || '<');
            password_decrypted := password_decrypted || '<';
        ELSIF SUBSTR(password_encrypted, I, 5) = 'JÇKan' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || '>');
            password_decrypted := password_decrypted || '>';
        ELSIF SUBSTR(password_encrypted, I, 5) = 'ASKDa' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || ';');
            password_decrypted := password_decrypted || ';';
        ELSIF SUBSTR(password_encrypted, I, 5) = 'ÇLASK' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || ':');
            password_decrypted := password_decrypted || ':';
        ELSIF SUBSTR(password_encrypted, I, 5) = 'YYYYY' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || '§');
            password_decrypted := password_decrypted || '§';
        ELSIF SUBSTR(password_encrypted, I, 5) = 'BBBBB' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || '£');
            password_decrypted := password_decrypted || '£';
        ELSIF SUBSTR(password_encrypted, I, 5) = 'NNNNN' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || '¢');
            password_decrypted := password_decrypted || '¢';
        ELSIF SUBSTR(password_encrypted, I, 5) = 'RRRRR' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || '¬');
            password_decrypted := password_decrypted || '¬';
        ELSIF SUBSTR(password_encrypted, I, 5) = 'ddddd' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || '/');
            password_decrypted := password_decrypted || '/';
        ELSIF SUBSTR(password_encrypted, I, 5) = 'xxxxx' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || '\');
            password_decrypted := password_decrypted || '\';
        ELSIF SUBSTR(password_encrypted, I, 5) = 'ZZZZZ' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 5) || ' Virou: ' || '|');
            password_decrypted := password_decrypted || '|';
		ELSIF SUBSTR(password_encrypted, I, 5) = 'lllll' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 1) || ' Virou: ' || '^');
            password_decrypted := password_decrypted || '^';
		ELSIF SUBSTR(password_encrypted, I, 5) = 'xbxbx' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 1) || ' Virou: ' || '~');
            password_decrypted := password_decrypted || '~';
		ELSIF SUBSTR(password_encrypted, I, 5) = 'vbncv' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 1) || ' Virou: ' || '.');
            password_decrypted := password_decrypted || '.';
		ELSIF SUBSTR(password_encrypted, I, 5) = 'we.,a' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 1) || ' Virou: ' || ',');
            password_decrypted := password_decrypted || ',';
		ELSIF SUBSTR(password_encrypted, I, 5) = 'jsjss' THEN
            DBMS_OUTPUT.PUT_LINE('Letra: ' || SUBSTR(password_encrypted, I, 1) || ' Virou: ' || '?');
            password_decrypted := password_decrypted || '?';
        END IF;
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('Senha Descriptografada: ' || password_decrypted);
END;