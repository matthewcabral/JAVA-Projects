/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseModule;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author MatheusCabral
 */
public class EncryptDecryptWord {

    String pattern = "dd-MM-yyyy hh:mm:ss";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    String date;
    
    public EncryptDecryptWord() {}

    public String encryptWord(String word) {
        String wordEncrypted = "";
        int count = 0;

        for (int i = 0; i < word.length(); i++) {
            if ("A".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "01aWf");
                wordEncrypted += "01aWf";
            } else if ("B".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "2uasD");
                wordEncrypted += "2uasD";
            } else if ("C".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "r4sfA");
                wordEncrypted += "r4sfA";
            } else if ("D".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + ":ASDs");
                wordEncrypted += ":ASDs";
            } else if ("E".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + ">asYA");
                wordEncrypted += ">asYA";
            } else if ("F".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "(9usH");
                wordEncrypted += "(9usH";
            } else if ("G".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "Â748x");
                wordEncrypted += "Â748x";
            } else if ("H".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + ";23cx");
                wordEncrypted += ";23cx";
            } else if ("I".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "%#sqf");
                wordEncrypted += "%#sqf";
            } else if ("J".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "@13ac");
                wordEncrypted += "@13ac";
            } else if ("K".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "!*vbf");
                wordEncrypted += "!*vbf";
            } else if ("L".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "ç|sda");
                wordEncrypted += "ç|sda";
            } else if ("M".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + ",s.ad");
                wordEncrypted += ",s.ad";
            } else if ("N".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "*+-as");
                wordEncrypted += "*+-as";
            } else if ("O".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "6¬7bk");
                wordEncrypted += "6¬7bk";
            } else if ("P".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "~sd4s");
                wordEncrypted += "~sd4s";
            } else if ("Q".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "AAAAA");
                wordEncrypted += "AAAAA";
            } else if ("R".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "DSCsd");
                wordEncrypted += "DSCsd";
            } else if ("S".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "§ssVR");
                wordEncrypted += "§ssVR";
            } else if ("T".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "*b406");
                wordEncrypted += "*b406";
            } else if ("U".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "6Gash");
                wordEncrypted += "6Gash";
            } else if ("V".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "sS:Kg");
                wordEncrypted += "sS:Kg";
            } else if ("X".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "jJvbx");
                wordEncrypted += "jJvbx";
            } else if ("W".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "12658");
                wordEncrypted += "12658";
            } else if ("Y".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "32894");
                wordEncrypted += "32894";
            } else if ("Z".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "78521");
                wordEncrypted += "78521";
            } else if ("Ç".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "5SFgf");
                wordEncrypted += "5SFgf";
            } else if ("a".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "00213");
                wordEncrypted += "00213";
            } else if ("b".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "q12as");
                wordEncrypted += "q12as";
            } else if ("c".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "54fH1");
                wordEncrypted += "54fH1";
            } else if ("d".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "A5-15");
                wordEncrypted += "A5-15";
            } else if ("e".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "RsKKy");
                wordEncrypted += "RsKKy";
            } else if ("f".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "terRW");
                wordEncrypted += "terRW";
            } else if ("g".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "CaGue");
                wordEncrypted += "CaGue";
            } else if ("h".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "iDjsb");
                wordEncrypted += "iDjsb";
            } else if ("i".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "ZuAdo");
                wordEncrypted += "ZuAdo";
            } else if ("j".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "WWWWW");
                wordEncrypted += "WWWWW";
            } else if ("k".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "gO0gL");
                wordEncrypted += "gO0gL";
            } else if ("l".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "@PPle");
                wordEncrypted += "@PPle";
            } else if ("m".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "MiCro");
                wordEncrypted += "MiCro";
            } else if ("n".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "SoftW");
                wordEncrypted += "SoftW";
            } else if ("o".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "wINdo");
                wordEncrypted += "wINdo";
            } else if ("p".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "wS10@");
                wordEncrypted += "wS10@";
            } else if ("q".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "M@c0S");
                wordEncrypted += "M@c0S";
            } else if ("r".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "hIGHS");
                wordEncrypted += "hIGHS";
            } else if ("s".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "iErra");
                wordEncrypted += "iErra";
            } else if ("t".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "Le0PA");
                wordEncrypted += "Le0PA";
            } else if ("u".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "Rrddd");
                wordEncrypted += "Rrddd";
            } else if ("v".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "bIgSR");
                wordEncrypted += "bIgSR";
            } else if ("x".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "SieBE");
                wordEncrypted += "SieBE";
            } else if ("w".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "t001S");
                wordEncrypted += "t001S";
            } else if ("y".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "*/!@$");
                wordEncrypted += "*/!@$";
            } else if ("z".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "ççwe|");
                wordEncrypted += "ççwe|";
            } else if ("ç".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "98000");
                wordEncrypted += "98000";
            } else if ("0".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + ":;/*3");
                wordEncrypted += ":;/*3";
            } else if ("1".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + ".,;:2");
                wordEncrypted += ".,;:2";
            } else if ("2".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "0.83,");
                wordEncrypted += "0.83,";
            } else if ("3".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "<r>4w");
                wordEncrypted += "<r>4w";
            } else if ("4".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "↑hs→a");
                wordEncrypted += "↑hs→a";
            } else if ("5".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "←hi↨4");
                wordEncrypted += "←hi↨4";
            } else if ("6".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "gfa54");
                wordEncrypted += "gfa54";
            } else if ("7".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "¨¨*.,");
                wordEncrypted += "¨¨*.,";
            } else if ("8".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "935hj");
                wordEncrypted += "935hj";
            } else if ("9".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "j0rN@");
                wordEncrypted += "j0rN@";
            } else if ("!".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "H0jE3");
                wordEncrypted += "H0jE3";
            } else if ("@".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "rJtV1");
                wordEncrypted += "rJtV1";
            } else if ("#".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "RjtV2");
                wordEncrypted += "RjtV2";
            } else if ("$".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "B0mD1");
                wordEncrypted += "B0mD1";
            } else if ("%".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "aR10m");
                wordEncrypted += "aR10m";
            } else if ("¨".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "gtHJs");
                wordEncrypted += "gtHJs";
            } else if ("*".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "/-?as");
                wordEncrypted += "/-?as";
            } else if ("(".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "?ad?z");
                wordEncrypted += "?ad?z";
            } else if (")".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "e?sc°");
                wordEncrypted += "e?sc°";
            } else if ("_".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "ª}[as");
                wordEncrypted += "ª}[as";
            } else if ("-".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "{QW?]");
                wordEncrypted += "{QW?]";
            } else if ("=".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "{{aaa");
                wordEncrypted += "{{aaa";
            } else if ("+".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "^qwda");
                wordEncrypted += "^qwda";
            } else if ("{".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "qwert");
                wordEncrypted += "qwert";
            } else if ("}".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "asdfg");
                wordEncrypted += "asdfg";
            } else if ("[".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "zxcvb");
                wordEncrypted += "zxcvb";
            } else if ("]".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "yuiop");
                wordEncrypted += "yuiop";
            } else if ("ª".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "ghjkl");
                wordEncrypted += "ghjkl";
            } else if ("º".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "ççrdv");
                wordEncrypted += "ççrdv";
            } else if ("<".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "bnmça");
                wordEncrypted += "bnmça";
            } else if (">".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "JÇKan");
                wordEncrypted += "JÇKan";
            } else if (";".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "ASKDa");
                wordEncrypted += "ASKDa";
            } else if (":".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "ÇLASK");
                wordEncrypted += "ÇLASK";
            } else if ("§".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "YYYYY");
                wordEncrypted += "YYYYY";
            } else if ("£".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "BBBBB");
                wordEncrypted += "BBBBB";
            } else if ("¢".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "NNNNN");
                wordEncrypted += "NNNNN";
            } else if ("¬".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "RRRRR");
                wordEncrypted += "RRRRR";
            } else if ("/".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "ddddd");
                wordEncrypted += "ddddd";
            } else if ("\\".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "xxxxx");
                wordEncrypted += "xxxxx";
            } else if ("|".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "ZZZZZ");
                wordEncrypted += "ZZZZZ";
            } else if ("^".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "lllll");
                wordEncrypted += "lllll";
            } else if ("~".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "xbxbx");
                wordEncrypted += "xbxbx";
            } else if (".".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "vbncv");
                wordEncrypted += "vbncv";
            } else if (",".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "we.,a");
                wordEncrypted += "we.,a";
            } else if ("?".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "jsjss");
                wordEncrypted += "jsjss";
            } else if ("`".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "jhdas");
                wordEncrypted += "jhdas";
            } else if ("´".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "88888");
                wordEncrypted += "88888";
            } else if (" ".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + ";spc;");
                wordEncrypted += ";spc;";
            } else if ("à".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "597*7");
                wordEncrypted += "597*7";
            } else if ("è".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "jJHSs");
                wordEncrypted += "jJHSs";
            } else if ("ì".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "lvmau");
                wordEncrypted += "lvmau";
            } else if ("ò".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "èassa");
                wordEncrypted += "èassa";
            } else if ("ù".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "ásssa");
                wordEncrypted += "ásssa";
            } else if ("À".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "bvcxz");
                wordEncrypted += "bvcxz";
            } else if ("È".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "trewq");
                wordEncrypted += "trewq";
            } else if ("Ì".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "çlkjh");
                wordEncrypted += "çlkjh";
            } else if ("Ò".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "98qwd");
                wordEncrypted += "98qwd";
            } else if ("Ù".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "WSADs");
                wordEncrypted += "WSADs";
            } else if ("á".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "askhd");
                wordEncrypted += "askhd";
            } else if ("é".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "aisjd");
                wordEncrypted += "aisjd";
            } else if ("í".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "ÂSSDg");
                wordEncrypted += "ÂSSDg";
            } else if ("ó".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "as154");
                wordEncrypted += "as154";
            } else if ("ú".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "asd41");
                wordEncrypted += "asd41";
            } else if ("Á".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "as5d4");
                wordEncrypted += "as5d4";
            } else if ("É".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "8sdf7");
                wordEncrypted += "8sdf7";
            } else if ("Í".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "a53sd");
                wordEncrypted += "a53sd";
            } else if ("Ó".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "y5uku");
                wordEncrypted += "y5uku";
            } else if ("Ú".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "vbn56");
                wordEncrypted += "vbn56";
            } else if ("ý".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "nr5d4");
                wordEncrypted += "nr5d4";
            } else if ("Ý".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "jsadh");
                wordEncrypted += "jsadh";
            } else if ("â".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "´=FDF");
                wordEncrypted += "´=FDF";
            } else if ("ê".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "A]S~D");
                wordEncrypted += "A]S~D";
            } else if ("î".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "aSKJD");
                wordEncrypted += "aSKJD";
            } else if ("ô".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "A/SD.");
                wordEncrypted += "A/SD.";
            } else if ("û".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "TBG65");
                wordEncrypted += "TBG65";
            } else if ("Â".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "ayçlo");
                wordEncrypted += "ayçlo";
            } else if ("Ê".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "@3ajh");
                wordEncrypted += "@3ajh";
            } else if ("Î".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "$wdsa");
                wordEncrypted += "$wdsa";
            } else if ("Ô".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "#43@1");
                wordEncrypted += "#43@1";
            } else if ("Û".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "***¨%");
                wordEncrypted += "***¨%";
            } else if ("ã".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "Ããosj");
                wordEncrypted += "Ããosj";
            } else if ("ñ".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "osdáõ");
                wordEncrypted += "osdáõ";
            } else if ("õ".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "][][s");
                wordEncrypted += "][][s";
            } else if ("Ã".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "ççasç");
                wordEncrypted += "ççasç";
            } else if ("Ñ".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "hckrt");
                wordEncrypted += "hckrt";
            } else if ("Õ".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "igilo");
                wordEncrypted += "igilo";
            } else if ("ä".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + ".,mjh");
                wordEncrypted += ".,mjh";
            } else if ("ë".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "/ã[ad");
                wordEncrypted += "/ã[ad";
            } else if ("ï".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "´p~58");
                wordEncrypted += "´p~58";
            } else if ("ö".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "we5r4");
                wordEncrypted += "we5r4";
            } else if ("ü".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "dsfsd");
                wordEncrypted += "dsfsd";
            } else if ("ÿ".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "r65gf");
                wordEncrypted += "r65gf";
            } else if ("Ä".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "a6s5d");
                wordEncrypted += "a6s5d";
            } else if ("Ë".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "0asd8");
                wordEncrypted += "0asd8";
            } else if ("Ï".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "htg85");
                wordEncrypted += "htg85";
            } else if ("Ö".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "tyu41");
                wordEncrypted += "tyu41";
            } else if ("Ü".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "¨76Yf");
                wordEncrypted += "¨76Yf";
            } else if ("Ÿ".equals(word.substring(i, i + 1))) {
                //System.out.println("Letra: " + word.substring(i, i + 1) + " virou: " + "ãs{K5");
                wordEncrypted += "ãs{K5";
            }
            count++;

        }

        //System.out.println("Count: " + count);
        //date = simpleDateFormat.format(new Date());
        //System.out.println(date + "\tDatabaseModule.EncryptDecryptWord\t\tResultado Final: " + wordEncrypted);

        return wordEncrypted;
    }

    public String decryptWord(String word) {
        String wordDecrypted = "";
        int count = 0;

        for (int i = 0; i < word.length(); i += 5) {
            if ("01aWf".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "A");
                wordDecrypted += "A";
            } else if ("2uasD".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "B");
                wordDecrypted += "B";
            } else if ("r4sfA".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "C");
                wordDecrypted += "C";
            } else if (":ASDs".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "D");
                wordDecrypted += "D";
            } else if (">asYA".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "E");
                wordDecrypted += "E";
            } else if ("(9usH".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "F");
                wordDecrypted += "F";
            } else if ("Â748x".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "G");
                wordDecrypted += "G";
            } else if (";23cx".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "H");
                wordDecrypted += "H";
            } else if ("%#sqf".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "I");
                wordDecrypted += "I";
            } else if ("@13ac".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "J");
                wordDecrypted += "J";
            } else if ("!*vbf".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "K");
                wordDecrypted += "K";
            } else if ("ç|sda".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "L");
                wordDecrypted += "L";
            } else if (",s.ad".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "M");
                wordDecrypted += "M";
            } else if ("*+-as".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "N");
                wordDecrypted += "N";
            } else if ("6¬7bk".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "O");
                wordDecrypted += "O";
            } else if ("~sd4s".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "P");
                wordDecrypted += "P";
            } else if ("AAAAA".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "Q");
                wordDecrypted += "Q";
            } else if ("DSCsd".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "R");
                wordDecrypted += "R";
            } else if ("§ssVR".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "S");
                wordDecrypted += "S";
            } else if ("*b406".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "T");
                wordDecrypted += "T";
            } else if ("6Gash".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "U");
                wordDecrypted += "U";
            } else if ("sS:Kg".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "V");
                wordDecrypted += "V";
            } else if ("jJvbx".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "X");
                wordDecrypted += "X";
            } else if ("12658".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "W");
                wordDecrypted += "W";
            } else if ("32894".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "Y");
                wordDecrypted += "Y";
            } else if ("78521".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "Z");
                wordDecrypted += "Z";
            } else if ("5SFgf".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "Ç");
                wordDecrypted += "Ç";
            } else if ("00213".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "a");
                wordDecrypted += "a";
            } else if ("q12as".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "b");
                wordDecrypted += "b";
            } else if ("54fH1".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "c");
                wordDecrypted += "c";
            } else if ("A5-15".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "d");
                wordDecrypted += "d";
            } else if ("RsKKy".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "e");
                wordDecrypted += "e";
            } else if ("terRW".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "f");
                wordDecrypted += "f";
            } else if ("CaGue".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "g");
                wordDecrypted += "g";
            } else if ("iDjsb".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "h");
                wordDecrypted += "h";
            } else if ("ZuAdo".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "i");
                wordDecrypted += "i";
            } else if ("WWWWW".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "j");
                wordDecrypted += "j";
            } else if ("gO0gL".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "k");
                wordDecrypted += "k";
            } else if ("@PPle".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "l");
                wordDecrypted += "l";
            } else if ("MiCro".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "m");
                wordDecrypted += "m";
            } else if ("SoftW".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "n");
                wordDecrypted += "n";
            } else if ("wINdo".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "o");
                wordDecrypted += "o";
            } else if ("wS10@".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "p");
                wordDecrypted += "p";
            } else if ("M@c0S".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "q");
                wordDecrypted += "q";
            } else if ("hIGHS".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "r");
                wordDecrypted += "r";
            } else if ("iErra".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "s");
                wordDecrypted += "s";
            } else if ("Le0PA".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "t");
                wordDecrypted += "t";
            } else if ("Rrddd".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "u");
                wordDecrypted += "u";
            } else if ("bIgSR".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "v");
                wordDecrypted += "v";
            } else if ("SieBE".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "x");
                wordDecrypted += "x";
            } else if ("t001S".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "w");
                wordDecrypted += "w";
            } else if ("*/!@$".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "y");
                wordDecrypted += "y";
            } else if ("ççwe|".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "z");
                wordDecrypted += "z";
            } else if ("98000".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "ç");
                wordDecrypted += "ç";
            } else if (":;/*3".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "0");
                wordDecrypted += "0";
            } else if (".,;:2".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "1");
                wordDecrypted += "1";
            } else if ("0.83,".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "2");
                wordDecrypted += "2";
            } else if ("<r>4w".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "3");
                wordDecrypted += "3";
            } else if ("↑hs→a".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "4");
                wordDecrypted += "4";
            } else if ("←hi↨4".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "5");
                wordDecrypted += "5";
            } else if ("gfa54".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "6");
                wordDecrypted += "6";
            } else if ("¨¨*.,".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "7");
                wordDecrypted += "7";
            } else if ("935hj".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "8");
                wordDecrypted += "8";
            } else if ("j0rN@".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "9");
                wordDecrypted += "9";
            } else if ("H0jE3".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "!");
                wordDecrypted += "!";
            } else if ("rJtV1".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "@");
                wordDecrypted += "@";
            } else if ("RjtV2".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "#");
                wordDecrypted += "#";
            } else if ("B0mD1".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "$");
                wordDecrypted += "$";
            } else if ("aR10m".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "%");
                wordDecrypted += "%";
            } else if ("gtHJs".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "¨");
                wordDecrypted += "¨";
            } else if ("/-?as".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "*");
                wordDecrypted += "*";
            } else if ("?ad?z".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "(");
                wordDecrypted += "(";
            } else if ("e?sc°".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + ")");
                wordDecrypted += ")";
            } else if ("ª}[as".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "_");
                wordDecrypted += "_";
            } else if ("{QW?]".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "-");
                wordDecrypted += "-";
            } else if ("{{aaa".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "=");
                wordDecrypted += "=";
            } else if ("^qwda".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "+");
                wordDecrypted += "+";
            } else if ("qwert".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "{");
                wordDecrypted += "{";
            } else if ("asdfg".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "}");
                wordDecrypted += "}";
            } else if ("zxcvb".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "[");
                wordDecrypted += "[";
            } else if ("yuiop".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "]");
                wordDecrypted += "]";
            } else if ("ghjkl".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "ª");
                wordDecrypted += "ª";
            } else if ("ççrdv".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "º");
                wordDecrypted += "º";
            } else if ("bnmça".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "<");
                wordDecrypted += "<";
            } else if ("JÇKan".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + ">");
                wordDecrypted += ">";
            } else if ("ASKDa".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + ";");
                wordDecrypted += ";";
            } else if ("ÇLASK".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + ":");
                wordDecrypted += ":";
            } else if ("YYYYY".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "§");
                wordDecrypted += "§";
            } else if ("BBBBB".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "£");
                wordDecrypted += "£";
            } else if ("NNNNN".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "¢");
                wordDecrypted += "¢";
            } else if ("RRRRR".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "¬");
                wordDecrypted += "¬";
            } else if ("ddddd".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "/");
                wordDecrypted += "/";
            } else if ("xxxxx".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "\\");
                wordDecrypted += "\\";
            } else if ("ZZZZZ".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "|");
                wordDecrypted += "|";
            } else if ("lllll".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "^");
                wordDecrypted += "^";
            } else if ("xbxbx".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "~");
                wordDecrypted += "~";
            } else if ("vbncv".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + ".");
                wordDecrypted += ".";
            } else if ("we.,a".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + ",");
                wordDecrypted += ",";
            } else if ("jsjss".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "?");
                wordDecrypted += "?";
            }  else if ("jhdas".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " virou: " + "`");
                wordDecrypted += "`";
            } else if ("88888".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " virou: " + "´");
                wordDecrypted += "´";
            } else if (";spc;".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " virou: " + " ");
                wordDecrypted += " ";
            }  else if ("597*7".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "à");
                wordDecrypted += "à";
            } else if ("jJHSs".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "è");
                wordDecrypted += "è";
            } else if ("lvmau".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "ì");
                wordDecrypted += "ì";
            } else if ("èassa".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "ò");
                wordDecrypted += "ò";
            } else if ("ásssa".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "ù");
                wordDecrypted += "ù";
            } else if ("bvcxz".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "À");
                wordDecrypted += "À";
            } else if ("trewq".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "È");
                wordDecrypted += "È";
            } else if ("çlkjh".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "Ì");
                wordDecrypted += "Ì";
            } else if ("98qwd".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "Ò");
                wordDecrypted += "Ò";
            } else if ("WSADs".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "Ù");
                wordDecrypted += "Ù";
            } else if ("askhd".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "á");
                wordDecrypted += "á";
            } else if ("aisjd".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "é");
                wordDecrypted += "é";
            } else if ("ÂSSDg".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "í");
                wordDecrypted += "í";
            } else if ("as154".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "ó");
                wordDecrypted += "ó";
            } else if ("asd41".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "ú");
                wordDecrypted += "ú";
            } else if ("as5d4".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "Á");
                wordDecrypted += "Á";
            } else if ("8sdf7".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "É");
                wordDecrypted += "É";
            } else if ("a53sd".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "Í");
                wordDecrypted += "Í";
            } else if ("y5uku".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "Ó");
                wordDecrypted += "Ó";
            } else if ("vbn56".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "Ú");
                wordDecrypted += "Ú";
            } else if ("nr5d4".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "ý");
                wordDecrypted += "ý";
            } else if ("jsadh".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "Ý");
                wordDecrypted += "Ý";
            } else if ("´=FDF".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "â");
                wordDecrypted += "â";
            } else if ("A]S~D".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "ê");
                wordDecrypted += "ê";
            } else if ("aSKJD".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "î");
                wordDecrypted += "î";
            } else if ("A/SD.".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "ô");
                wordDecrypted += "ô";
            } else if ("TBG65".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "û");
                wordDecrypted += "û";
            } else if ("ayçlo".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "Â");
                wordDecrypted += "Â";
            } else if ("@3ajh".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "Ê");
                wordDecrypted += "Ê";
            } else if ("$wdsa".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "Î");
                wordDecrypted += "Î";
            } else if ("#43@1".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "Ô");
                wordDecrypted += "Ô";
            } else if ("***¨%".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "Û");
                wordDecrypted += "Û";
            } else if ("Ããosj".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "ã");
                wordDecrypted += "ã";
            } else if ("osdáõ".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "ñ");
                wordDecrypted += "ñ";
            } else if ("][][s".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "õ");
                wordDecrypted += "õ";
            } else if ("ççasç".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "Ã");
                wordDecrypted += "Ã";
            } else if ("hckrt".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "Ñ");
                wordDecrypted += "Ñ";
            } else if ("igilo".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "Õ");
                wordDecrypted += "Õ";
            } else if (".,mjh".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "ä");
                wordDecrypted += "ä";
            } else if ("/ã[ad".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "ë");
                wordDecrypted += "ë";
            } else if ("´p~58".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "ï");
                wordDecrypted += "ï";
            } else if ("we5r4".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "ö");
                wordDecrypted += "ö";
            } else if ("dsfsd".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "ü");
                wordDecrypted += "ü";
            } else if ("r65gf".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "ÿ");
                wordDecrypted += "ÿ";
            } else if ("a6s5d".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "Ä");
                wordDecrypted += "Ä";
            } else if ("0asd8".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "Ë");
                wordDecrypted += "Ë";
            } else if ("htg85".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "Ï");
                wordDecrypted += "Ï";
            } else if ("tyu41".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "Ö");
                wordDecrypted += "Ö";
            } else if ("¨76Yf".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "Ü");
                wordDecrypted += "Ü";
            } else if ("ãs{K5".equals(word.substring(i, i + 5))) {
                //System.out.println("Letra: " + word.substring(i, i + 5) + " Virou: " + "Ÿ");
                wordDecrypted += "Ÿ";
            }

            count++;
        }

        //System.out.println("Count: " + count);
        //date = simpleDateFormat.format(new Date());
        //System.out.println(date + "\tDatabaseModule.EncryptDecryptWord\t\tResultado Final: " + wordDecrypted);

        return wordDecrypted;
    }

}
