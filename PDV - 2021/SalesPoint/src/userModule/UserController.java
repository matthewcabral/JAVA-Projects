/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userModule;

import addressModule.addressController;
import contactModule.ContactController;
import databaseModule.DataController;
import databaseModule.EncryptDecryptWord;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MatheusCabral
 */
public class UserController extends DataController {
    UserLoginScreen loginScreen;
    UserScreen userScreen;
    UserPermitionScreen permScreen;
    ContactController cont;
    addressController addr;
    EncryptDecryptWord encryptDecrypt;
    userRowIdClass userRowId;
    
    private ArrayList<userRowIdClass> userRowIdArray = new ArrayList<>();
    //public ArrayList<addressRowIdClass> addrRowIdArray = new ArrayList<>();
    
    private String user;
    private String password;
    private String lastUserAdd;
    private String lastUserUpd;
    private boolean firstSettingsOK = false;
    private boolean loginOK = false;
    private int count;
    
    public UserController() throws InterruptedException {
        encryptDecrypt = new EncryptDecryptWord();
    }

    public String getUser() { return user; }
    public void setUser(String user) { this.user = user; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getLastUserAdd() { return lastUserAdd; }
    public void setLastUserAdd(String lastUserAdd) { this.lastUserAdd = lastUserAdd; }

    public String getLastUserUpd() { return lastUserUpd; }
    public void setLastUserUpd(String lastUserUpd) { this.lastUserUpd = lastUserUpd; }
    
    public int getCount() { return count; }
    public void setCount(int count) { this.count += count; }
    public void clearCount() { this.count = 0; }
    
    public boolean isFirstSettingsOK() { return firstSettingsOK; }
    public void setFirstSettingsOK(boolean firstSettingsOK) { this.firstSettingsOK = firstSettingsOK; }
    
    public boolean getLoginOK() { return loginOK; }
    public void setLoginOK(boolean loginOK) { this.loginOK = loginOK; }
    
    public void setListenerUserLoginScreen(WindowListener listener) { loginScreen.addWindowListener(listener); }
    
    public void openLoginScreen(){
        loginScreen = new UserLoginScreen();
        //loginScreen.addWindowListener(new loginScreenWindowListener());
        loginScreen.setListenerLogin(new clickLoginButton());
    }
    
    public void openUserScreen(String screen, String query){
        switch(screen) {
            case "MAIN":
                userScreen = new UserScreen();
                userScreen.setListenerBtnEditUser(new buttonEdit());
                userScreen.setListenerBtnNewUser(new buttonNew());
                userScreen.setListenerBtnSaveUser(new buttonSave());
                userScreen.setListenerBtnCancelUser(new buttonCancel());
                userScreen.setListenerBtnDelete(new buttonDelete());
                userScreen.setListenerBtnAddAddress(new manageAddress());
                userScreen.setListenerBtnPermitions(new viewUserPermitions());
                userScreen.setListenerBtnAddContact(new manageContact());
                userScreen.setListenerTblUserListSelection(new userListSelected());
                userScreen.setListenercbbListFilterValue(new CbbListFilterItemState());
                userScreen.setListenertxtListFilterValue(new TxtListFilterValue());
                query = "SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblUser() + " USR\nORDER BY USR.FST_NAME ASC";
                break;
            case "USER":
                break;
            default:
                break;
        }
        
        userScreen.clearFields();
        userScreen.clearComboBoxes();
        userScreen.enableFields("LOAD_SCREEN");
        userScreen.insertSelectComboBox();
        this.fillComboBoxes("USER_FILTER");
        this.fillComboBoxes("POSITION_TYPE");
        this.fillComboBoxes("DOC_TYPE");
        this.fillComboBoxes("SEX_MF");
        this.fillComboBoxes("MONTH_DAY");
        this.fillComboBoxes("MONTH");
        this.fillComboBoxes("CIVIL_STATE");
        this.fillComboBoxes("DOCUMENT_TYPE");
        this.fillComboBoxes("STATE");
        
        this.fillList(query);
        
        userScreen.setFocus("FILTRO_VALOR");
    }
    
    private boolean tryLogin(){
        try{
            
            System.out.println(super.getDateTime() + "\tUserModule.userController\t\tTestando conexão..."); // Teste de conexão
            String result = super.openConnection("Realizando Login");
            if("true".equals(result)){
                super.closeConnection("Login realizado com sucesso!");
                this.setFirstSettingsOK(true);
                return true;
            } else {
                if(result.contains("java.sql.SQLRecoverableException: IO Error: The Network Adapter could not establish the connection")){
                    loginScreen.setErrorArea("Erro ao tentar realizar conexão com o Banco de dados. Verifique se o listener está ativo.");
                    System.out.println(super.getDateTime() + "\tUserModule.userController\t\tErro ao tentar realizar conexão com o Banco de dados. Verifique se o listener está ativo.");
                } else if(result.contains("ORA-12505: TNS: listener does not currently know of SID given in connect descriptor tips")) {
                    loginScreen.setErrorArea("O Listener não identificou o SID utilizado no descritor de conexão.");
                    System.out.println(super.getDateTime() + "\tUserModule.userController\t\tO Listener não identificou o SID utilizado no descritor de conexão.");
                } else if(result.contains("java.sql.SQLRecoverableException: Erro de ES: The Network Adapter could not establish the connection")){
                    loginScreen.setErrorArea("Erro ao tentar realizar conexão com o Banco de dados. Verifique se o listener está ativo.");
                    System.out.println(super.getDateTime() + "\tUserModule.userController\t\tErro ao tentar realizar conexão com o Banco de dados. Verifique se o listener está ativo.");
                } else if(result.contains("ORA-12505, TNS:listener does not currently know of SID given in connect descriptor")) {
                    loginScreen.setErrorArea("O Listener não identificou o SID utilizado no descritor de conexão.");
                    System.out.println(super.getDateTime() + "\tUserModule.userController\t\tO Listener não identificou o SID utilizado no descritor de conexão.");
                } else if(result.contains("java.sql.SQLException: ORA-01017")  || result.contains("Access denied for user")){
                    loginScreen.setErrorArea("Nome de usuário/senha incorreto. Tente novamente.");
                    System.out.println(super.getDateTime() + "\tUserModule.userController\t\tNome de usuário/senha incorreto. Tente novamente.");
                } else if(result.contains("java.sql.SQLRecoverableException: Erro de ES: Unknown host specified")){
                    loginScreen.setErrorArea("Erro ao tentar realizar conexão com o Banco de dados. Verifique o Host."); 
                    System.out.println(super.getDateTime() + "\tUserModule.userController\t\ttErro ao tentar realizar conexão com o Banco de dados. Verifique o Host.");
                } else {
                    loginScreen.setErrorArea("Erro ao conectar com o banco de dados!\n" + result);
                    System.out.println(getDateTime() + "\t" + "DatabaseModule" + "." + "DataController" + "\t\t" + "OpenConnection" + "\t\t" + "ObjMgrSqlLog" + "\t" + "Error" + "\t" + "Erro ao conectar com o banco de dados! Erro: " + result);
                }
                return false;
            }
        } catch(Exception e){
            super.wishConfDbLScreen();
            return false;
        }
    }
    
    private void fillList(String query){
        int countRecord = 0;
        try{
            ArrayList<UserClass> userList = super.queryUserRecord(query);
            ArrayList<PositionClass> positionList;
                    
            DefaultTableModel table = (DefaultTableModel) userScreen.getTableModel();
            table.setRowCount(0);
            
            if(userList.size() > 0){
                table.setNumRows(userList.size());
                
                for(int i = 0; i < userList.size(); i++){
                    table.setValueAt(userList.get(i).getRow_id(), i, 0);
                    table.setValueAt(userList.get(i).getLOGIN(), i, 1);
                    table.setValueAt(userList.get(i).getDOC_NUM(), i, 2);
                    table.setValueAt(userList.get(i).getFST_NAME(), i, 3);
                    table.setValueAt(userList.get(i).getLAST_NAME(), i, 4);
                    table.setValueAt(userList.get(i).getNICK_NAME(), i, 5);
                    
                    positionList = queryPositionRecord(
                        "SELECT *\n" + 
                        "FROM " + super.getDbOwner() + "." + super.getTblPosition() + "\n" +
                        "WHERE ROW_ID = '" + userList.get(i).getPAR_POSTN_ID() + "'"
                    );
                    if(positionList.size() > 0){
                        table.setValueAt(positionList.get(0).getNAME(), i, 6);
                        table.setValueAt(userList.get(i).getSTATUS_CD(), i, 7);
                    }
                    
                    countRecord++;
                }
            }
            
            userScreen.setlblRecCount(String.valueOf(countRecord));
            
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher tabela...\nErro: " + e);
        }
    }
    
    private void fillFields(String query){
        try{
            ArrayList<UserClass> userList = queryUserRecord(query);
            ArrayList<PositionClass> positionList;
            ArrayList<ContactClass> ContactList;
            ArrayList<SocialMediaClass> ContactXList;
            ArrayList<AddressClass> AddressList;
            
            if(userList.size() > 0){
                for(int i = 0; i < userList.size(); i++){
                    userScreen.setlblUserNameHeader(userList.get(i).getFULL_NAME());
                    userScreen.settxtRowId(userList.get(i).getRow_id());
                    userScreen.setckbActiveUserFlg(("Ativo".equals(userList.get(i).getSTATUS_CD())) ? "Y" : "N");
                    userScreen.settxtUser(userList.get(i).getLOGIN());
                    userScreen.settxtPass(userList.get(i).getPASSWORD());
                    userScreen.settxtPassVerification(userList.get(i).getPASSWORD());
                    
                    // Position Information
                    positionList = super.queryPositionRecord("SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblPosition() + "\nWHERE ROW_ID = '" + userList.get(i).getPAR_POSTN_ID() + "'");
                    if(positionList.size() > 0) {
                        for(int p = 0; p < positionList.size(); p++) {
                            userScreen.setcbbPositionItemIndex(userScreen.getcbbPositionItemIndex(super.LookupValue("POSITION_TYPE", positionList.get(p).getPOSTN_TYPE_CD())));
                        }
                    }
                    
                    userScreen.settxtSecQuestion1(userList.get(i).getCHALLENGE_QUESTION_1());
                    userScreen.settxtSecAnswer1(userList.get(i).getCHALLENGE_ANSWER_1());
                    userScreen.settxtSecQuestion2(userList.get(i).getCHALLENGE_QUESTION_2());
                    userScreen.settxtSecAnswer2(userList.get(i).getCHALLENGE_ANSWER_2());
                    userScreen.settxtSecQuestion3(userList.get(i).getCHALLENGE_QUESTION_3());
                    userScreen.settxtSecAnswer3(userList.get(i).getCHALLENGE_ANSWER_3());
                    userScreen.setcbbDocTypeItemIndex(userScreen.getcbbDocTypeItemIndex(super.LookupValue("DOC_TYPE", userList.get(i).getDOC_TYPE())));
                    userScreen.settxtDocNum(userList.get(i).getDOC_NUM());
                    userScreen.settxtName(userList.get(i).getFST_NAME());
                    userScreen.settxtSurname(userList.get(i).getLAST_NAME());
                    userScreen.settxtNickName(userList.get(i).getNICK_NAME());
                    userScreen.setcbbSexItemIndex(userScreen.getcbbSexItemIndex(super.LookupValue("SEX_MF", userList.get(i).getSEX_MF())));
                    if (!"".equals(userList.get(i).getBIRTH_DT()) && userList.get(i).getBIRTH_DT() != null) {
                        userScreen.setcbbDayItemIndex(userScreen.getcbbDayItemIndex(super.LookupValue("MONTH_DAY", userList.get(i).getBIRTH_DT().substring(0, 2))));
                        userScreen.setcbbMonthItemIndex(userScreen.getcbbMonthItemIndex(super.LookupValue("MONTH", userList.get(i).getBIRTH_DT().substring(3, 5))));
                        userScreen.settxtYear(userList.get(i).getBIRTH_DT().substring(6, 10));
                    }
                    userScreen.settxtBornLocation(userList.get(i).getPLACE_OF_BIRTH());
                    userScreen.setcbbCivilStateItemIndex(userScreen.getcbbCivilStateItemIndex(super.LookupValue("CIVIL_STATE", userList.get(i).getMARITAL_STAT_CD())));
                    userScreen.settxtSpouseName(userList.get(i).getNAME_CONJUGE());
                    userScreen.settxtMotherName(userList.get(i).getMOTHER_FULL_NAME());
                    userScreen.settxtFatherName(userList.get(i).getFATHER_FULL_NAME());
                    userScreen.setcbbIdentityTypeItemIndex(userScreen.getcbbIdentityTypeItemIndex(super.LookupValue("DOCUMENT_TYPE", userList.get(i).getIDENTITY_DOC_TYPE())));
                    userScreen.settxtRecNum(userList.get(i).getREGISTER_NUM());
                    userScreen.settxtSerieNum(userList.get(i).getREGISTER_SERIE());
                    userScreen.settxtEmissor(userList.get(i).getORGAO_EMISSOR());
                    userScreen.setcbbEmissionUFItemIndex(userScreen.getcbbEmissionUFItemIndex(super.LookupValue("STATE", userList.get(i).getUF_EMISSAO())));
                    if (!"".equals(userList.get(i).getEMISSION_DT()) && userList.get(i).getEMISSION_DT() != null) {
                        userScreen.settxtEmissionDate(userList.get(i).getEMISSION_DT());
                    }
                    if (!"".equals(userList.get(i).getVALIDATION_DT()) && userList.get(i).getVALIDATION_DT() != null) {
                        userScreen.settxtValidThru(userList.get(i).getVALIDATION_DT());
                    }
                    userScreen.settxtNationality(userList.get(i).getNATIONALITY());
                    userScreen.settxtNaturalness(userList.get(i).getNATURALNESS());

                    // Contact Information
                    ContactList = super.queryContactRecord("SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblContact() + "\nWHERE (PAR_ROW_ID = '" + userList.get(i).getRow_id() + "'\nOR PAR_USR_ID = '" + userList.get(i).getRow_id() + "')\nAND PR_CON_FLG = 'Y'");
                    if(ContactList.size() > 0){
                        for(int c = 0; c < ContactList.size(); c++) {
                            userScreen.settxtContactMPhone(ContactList.get(c).getMAIN_PH_NUM());
                            userScreen.settxtContactEmail(ContactList.get(c).getEMAIL_ADDR());
                            userScreen.settxtContactPhone(ContactList.get(c).getALT_PH_NUM());
                            userScreen.settxtContactEnterprise(ContactList.get(c).getWORK_PH_NUM());
                        }
                        // Social Media Information
                        ContactXList = super.querySocialMediaRecord("SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblSocialMedia()+ "\nWHERE PAR_ROW_ID = '" + ContactList.get(i).getRow_id() + "'\nAND PAR_USR_ID = '" + userList.get(i).getRow_id() + "'");
                        for(int cx = 0; cx < ContactXList.size(); cx++) {
                            if(null != ContactXList.get(cx).getSOCIAL_M_NAME()) {
                                switch (ContactXList.get(cx).getSOCIAL_M_NAME()) {
                                    case "Facebook":
                                        userScreen.settxtFacebook(ContactXList.get(cx).getSOCIAL_M_VALUE());
                                        break;
                                    case "Twitter":
                                        userScreen.settxtTwitter(ContactXList.get(cx).getSOCIAL_M_VALUE());
                                        break;
                                    case "Instagram":
                                        userScreen.settxtInstagram(ContactXList.get(cx).getSOCIAL_M_VALUE());
                                        break;
                                    default:
                                        break;
                                }
                            }
                        }
                    }                    
                    
                    // Address Information
                    AddressList = super.queryAddressRecord("SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblAddress() + "\nWHERE PAR_ROW_ID = '" + userList.get(i).getRow_id() +  "'\nAND PR_ADDR_FLG = 'Y'");
                    if(AddressList.size() > 0) {
                        for(int a = 0; a < AddressList.size(); a++) {
                            userScreen.settxtFullAddress(AddressList.get(a).getADDR_NAME());
                        }
                    }
                }
            }

        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher Campos...\nErro: " + e);
        }
    }
    
    private void fillComboBoxes(String LovType){
        try{
            ArrayList<ListOfValuesClass> lov = super.LookupList(LovType);
            
            if(lov.size() > 0){
                for(int i = 0; i < lov.size(); i++){
                    if(null == LovType){
                        JOptionPane.showMessageDialog(null, "O LOV_TYPE 'null' não existe!");
                    } else switch (LovType) {
                        case "USER_FILTER":
                            userScreen.setcbbListFilter(lov.get(i).getValue());
                            break;
                        case "POSITION_TYPE":
                            userScreen.setcbbPosition(lov.get(i).getValue());
                            break;
                        case "DOC_TYPE":
                            userScreen.setcbbDocType(lov.get(i).getValue());
                            break;
                        case "SEX_MF":
                            userScreen.setcbbSex(lov.get(i).getValue());
                            break;
                        case "MONTH_DAY":
                            userScreen.setcbbDay(lov.get(i).getValue());
                            break;
                        case "MONTH":
                            userScreen.setcbbMonth(lov.get(i).getValue());
                            break;
                        case "CIVIL_STATE":
                            userScreen.setcbbCivilState(lov.get(i).getValue());
                            break;
                        case "DOCUMENT_TYPE":
                            userScreen.setcbbIdentityType(lov.get(i).getValue());
                            break;
                        case "STATE":
                            userScreen.setcbbEmissionUF(lov.get(i).getValue());
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "O LOV_TYPE '" + LovType +  "' não é utilizado por nenhum ComboBox!");
                            break;
                    }
                }
            }
        } catch(HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher ComboBoxes...\nErro: " + e);
        }
    }
    
    private void fillFieldsNewRecord(){
        userScreen.settxtRowId(getNextRowId());
        userScreen.setckbActiveUserFlg("Y");
    }
    
    private boolean viewUserPermitions(String position){
        String positionId = "";
        String permitionName = "";
        String permitionValue = "";
        
        if(userScreen.getcbbPosition() != null){
            permScreen = new UserPermitionScreen();
            permScreen.setListenerUserPermitionScreen(new userPermitionScreenListener());
            
            try{
                positionId = getPositionIdByName(super.LookupName("POSITION_TYPE", position));
                permScreen.setlblPosition(userScreen.getcbbPosition());

                if(!"".equals(positionId) && positionId != null){
                    ArrayList<PositionPerClass> permList = super.queryPositionPerRecord("SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblPositionPermition() + "\nWHERE PAR_ROW_ID = '" + positionId + "'");

                    DefaultTableModel table = (DefaultTableModel) permScreen.getTableModel();
                    table.setRowCount(0);

                    if(permList.size() > 0){
                        table.setNumRows(permList.size());

                        ArrayList<ListOfValuesClass> lovList;

                        for(int i = 0; i < permList.size(); i++){
                            table.setValueAt(permList.get(i).getPERMITION_DESC(), i, 0);
                            permScreen.setTableColumnWidth(0, permScreen.getTableFontMetrics(permList.get(i).getPERMITION_DESC()) + 50);
                            
                            if("Y".equals(permList.get(i).getPERMITION_FLG())){ table.setValueAt(true, i, 1); } else { table.setValueAt(false, i, 1); }
                            permScreen.setTableColumnWidth(1, 60);
                            
                            permitionName = permList.get(i).getPERMITION_NAME().substring(permList.get(i).getPERMITION_NAME().lastIndexOf("_") + 1, permList.get(i).getPERMITION_NAME().length());
                            permitionValue = permList.get(i).getPERMITION_VALUE();
                            permitionValue = permitionValue.substring(permitionValue.lastIndexOf(" ") + 1, permitionValue.length());
                            lovList = super.queryListOfValues("SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblLstOfVal() + " LOV\nWHERE LOV.TYPE = 'POSTN_DESC'\nAND LOV.NAME = 'POSTN_" + permitionName + "'");

                            if(lovList.size() > 0) {
                                for(int j = 0; j < lovList.size(); j++){
                                    table.setValueAt(lovList.get(j).getDesc_text() + permitionValue, i, 2);
                                    permScreen.setTableColumnWidth(2, permScreen.getTableFontMetrics(lovList.get(j).getDesc_text() + permitionValue) + 50);
                                }
                            }
                        }
                    }
                }
                return true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao preencher tabela...\nErro: " + e);
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "O campo 'Posição' é obrigatório. Favor preencher o mesmo!");
            return false;
        }
    }
    
    public boolean validateFields(){
        String mensagem = "";
        int i = 0;
        
        if(userScreen.gettxtUser() == null) { mensagem += "\n- " + "Usuário" + ";"; i = (i < 1) ? 1 : i; }
        if(userScreen.gettxtPass() == null) { mensagem += "\n- " + "Senha" + ";"; i = (i < 2 && i != 0) ? i : 2; }
        if(userScreen.gettxtPassVerification() == null) { mensagem += "\n- " + "Confirmação de Senha" + ";"; i = (i < 3 && i != 0) ? i : 4; }
        if(userScreen.getcbbPosition() == null) { mensagem += "\n- " + "Posição" + ";"; i = (i < 4 && i != 0) ? i : 4; }
        if(userScreen.gettxtSecQuestion1() == null) { mensagem += "\n- " + "Pergunta de Segurança - 1" + ";"; i = (i < 5 && i != 0) ? i : 5; }
        if(userScreen.gettxtSecAnswer1() == null) { mensagem += "\n- " + "Resposta de Segurança - 1" + ";"; i = (i < 6 && i != 0) ? i : 6; }
        if(userScreen.gettxtSecQuestion2() == null) { mensagem += "\n- " + "Resposta de Segurança - 2" + ";"; i = (i < 7 && i != 0) ? i : 7; }
        if(userScreen.gettxtSecAnswer2() == null) { mensagem += "\n- " + "Resposta de Segurança - 2" + ";"; i = (i < 8 && i != 0) ? i : 8; }
        if(userScreen.gettxtSecQuestion3() == null) { mensagem += "\n- " + "Resposta de Segurança - 3" + ";"; i = (i < 9 && i != 0) ? i : 9; }
        if(userScreen.gettxtSecAnswer3() == null) { mensagem += "\n- " + "Resposta de Segurança - 3" + ";"; i = (i < 10 && i != 0) ? i : 10; }
        if(userScreen.getcbbDocType() == null) { mensagem += "\n- " + "Tipo de Documento" + ";"; i = (i < 11 && i != 0) ? i : 11; }
        if(userScreen.gettxtDocNum() == null) { mensagem += "\n- " + "Documento" + ";"; i = (i < 12 && i != 0) ? i : 12; }
        if(userScreen.gettxtName() == null) { mensagem += "\n- " + "Nome" + ";"; i = (i < 13 && i != 0) ? i : 13; }
        if(userScreen.gettxtSurname() == null) { mensagem += "\n- " + "Sobrenome" + ";"; i = (i < 14 && i != 0) ? i : 14; }
        if(userScreen.getcbbSex() == null) { mensagem += "\n- " + "Sexo" + ";"; i = (i < 15 && i != 0) ? i : 15; }
        if(userScreen.getcbbDay() == null) { mensagem += "\n- " + "Data de Nascimento - Dia" + ";"; i = (i < 16 && i != 0) ? i : 16; }
        if(userScreen.getcbbMonth() == null) { mensagem += "\n- " + "Data de Nascimento - Mês" + ";"; i = (i < 17 && i != 0) ? i : 17; }
        if(userScreen.gettxtYear() == null) { mensagem += "\n- " + "Data de Nascimento - Ano" + ";"; i = (i < 18 && i != 0) ? i : 18; }
        if(userScreen.gettxtYear() != null && Integer.valueOf(userScreen.gettxtYear()) >= Integer.valueOf(super.getDateTime().substring(6, 10))) {
            mensagem += "\n- " + "Data de Nascimento - Ano deve ser menor que ano atual" + ";"; i = (i < 19 && i != 0) ? i : 19;
        }

        switch(i){
            case 1:
                userScreen.setFocus("USUARIO");
                break;
            case 2:
                userScreen.setFocus("SENHA");
                break;
            case 3:
                userScreen.setFocus("SENHA_CONFIRMACAO");
                break;
            case 4:
                userScreen.setFocus("POSICAO");
                break;
            case 5:
                userScreen.setFocus("PERGUNTA_SEG_1");
                break;
            case 6:
                userScreen.setFocus("RESPOSTA_SEG_1");
                break;
            case 7:
                userScreen.setFocus("PERGUNTA_SEG_2");
                break;
            case 8:
                userScreen.setFocus("RESPOSTA_SEG_2");
                break;
            case 9:
                userScreen.setFocus("PERGUNTA_SEG_3");
                break;
            case 10:
                userScreen.setFocus("RESPOSTA_SEG_3");
                break;
            case 11:
                userScreen.setFocus("DOCUMENTO_TIPO");
                break;
            case 12:
                userScreen.setFocus("NUM_DOCUMENTO");
                break;
            case 13:
                userScreen.setFocus("NOME");
                break;
            case 14:
                userScreen.setFocus("SOBRENOME");
                break;
            case 15:
                userScreen.setFocus("SEXO");
                break;
            case 16:
                userScreen.setFocus("NASCIMENTO_DIA");
                break;
            case 17:
                userScreen.setFocus("NASCIMENTO_MES");
                break;
            case 18:
                userScreen.setFocus("NASCIMENTO_ANO");
                break;
            case 19:
                userScreen.setFocus("NASCIMENTO_ANO");
            default:
                break;
        }
        
        if(!"".equals(mensagem) && mensagem != null){
            JOptionPane.showMessageDialog(null, "Os campos abaixo são obrigatórios. Favor preencher os mesmos:" + mensagem);
            return false;
        } else {
            return true;
        }
    }
    
    public boolean validateUser(){
        if(userScreen.gettxtUser() != null) {
            int count = super.queryTableCount(super.getTblUser(), "LOGIN = '" + userScreen.gettxtUser() + "'");
            if(count > 0){
                JOptionPane.showMessageDialog(null, "Já existe um usuário com este nome. Favor escolher outro nome de usuário.");
                userScreen.setFocus("USUARIO");
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
    
    public boolean validatePassword(){
        // Validações de Senha:
        // Mínimo 8 caracteres
        // Mínimo uma Letra minúscula
        // Mínimo uma letra maiúscula
        // Mínimo um numero
        // Não deve conter mais de 2 caracteres idênticos consecutivos
        // Não ser a mesma que o nome da conta
        // Não ter data de nascimento
        // Não pode ter sido utilizada no ultimo ano

        String mensagem = "";
        String[] maiuscula = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "X", "W", "Y", "Z", "Ç"};
        String[] minuscula = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "x", "w", "y", "z", "ç"};
        String[] numero = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

        String diaNascimento = super.LookupName("MONTH_DAY", userScreen.getcbbDay());
        String mesNascimento = super.LookupName("MONTH", userScreen.getcbbMonth());
        String anoNascimento = userScreen.gettxtYear();
        
        int passLength = 0;
        int totalMaiuscula = 0;
        int totalMinuscula = 0;
        int totalNumero = 0;
        int totalDataNasc = 0;
        int totalCharRepetido = 0;
        int totalNomeUser = 0;
        int totalNome = 0;
        //int totalPassLastYear = 0;

        if(userScreen.gettxtPass() != null){
            passLength = userScreen.gettxtPass().length();
            
            System.out.println(super.getDateTime() + "\t" + "UserModule" + "." + "UserController" + "\t\t" + "ValidatePassword" + "\t" + "GenericLog" + "\t" + "GenericInfo" + "\t" + "Validação de Quantidade de caracteres" + "\t" + "Verificando quantidade de caracteres");
            if(passLength > 7) { System.out.println(super.getDateTime() + "\t" + "UserModule" + "." + "UserController" + "\t\t" + "ValidatePassword" + "\t" + "GenericLog" + "\t" + "GenericInfo" + "\t" + "Validação de Quantidade de caracteres" + "\t" + "Verificação OK: Maior ou igual a 8 caracteres"); } else { System.out.println(super.getDateTime() + "\t" + "UserModule" + "." + "UserController" + "\t\t" + "ValidatePassword" + "\t" + "GenericLog" + "\t" + "GenericInfo" + "\t" + "Validação de Quantidade de caracteres" + "\t" + "Verificação NÃO OK: Menor que 8 caracteres"); }
            
            
            System.out.println(super.getDateTime() + "\t" + "UserModule" + "." + "UserController" + "\t\t" + "ValidatePassword" + "\t" + "GenericLog" + "\t" + "GenericInfo" + "\t" + "Validação de letra Maiúscula" + "\t" + "Buscando por: Caracter MAIÚSCULO");
            // Validação de Letra maiúscula
            for(int i = 0; i < maiuscula.length; i++) {
                for(int j = 0; j < passLength; j++) {
                    //System.out.println(super.getDateTime() + "\t" + "UserModule" + "." + "UserController" + "\t\t" + "ValidatePassword" + "\t" + "GenericLog" + "\t" + "GenericInfo" + "\t" + "Validação de letra Maiúscula" + "\t" + "Encontrado: " + userScreen.gettxtPass().substring(j, j + 1));
                    if(maiuscula[i].equals(userScreen.gettxtPass().substring(j, j + 1))) {

                        totalMaiuscula++;
                    }
                }
            }
            if(totalMaiuscula > 0) { System.out.println(super.getDateTime() + "\t" + "UserModule" + "." + "UserController" + "\t\t" + "ValidatePassword" + "\t" + "GenericLog" + "\t" + "GenericInfo" + "\t" + "Validação de letra Maiúscula" + "\t" + "Caracter Encontrado"); } else { System.out.println(super.getDateTime() + "\t" + "UserModule" + "." + "UserController" + "\t\t" + "ValidatePassword" + "\t" + "GenericLog" + "\t" + "GenericInfo" + "\t" + "Validação de letra Maiúscula" + "\t" + "Caracter NÃO Encontrado"); }

            System.out.println(super.getDateTime() + "\t" + "UserModule" + "." + "UserController" + "\t\t" + "ValidatePassword" + "\t" + "GenericLog" + "\t" + "GenericInfo" + "\t" + "Validação de letra Minúscula" + "\t" + "Buscando por: Caracter minúsculo");
            // Validação de Letra minúscula
            for(int i = 0; i < minuscula.length; i++) {
                for(int j = 0; j < passLength; j++) {
                    //System.out.println(super.getDateTime() + "\t" + "UserModule" + "." + "UserController" + "\t\t" + "ValidatePassword" + "\t" + "GenericLog" + "\t" + "GenericInfo" + "\t" + "Validação de letra Minúscula" + "\t" + "Encontrado: " + userScreen.gettxtPass().substring(j, j + 1));
                    if(minuscula[i].equals(userScreen.gettxtPass().substring(j, j + 1))) {
                        totalMinuscula++;
                    }
                }
            }
            if(totalMinuscula > 0) { System.out.println(super.getDateTime() + "\t" + "UserModule" + "." + "UserController" + "\t\t" + "ValidatePassword" + "\t" + "GenericLog" + "\t" + "GenericInfo" + "\t" + "Validação de letra minúscula" + "\t" + "Caracter Encontrado"); } else { System.out.println(super.getDateTime() + "\t" + "UserModule" + "." + "UserController" + "\t\t" + "ValidatePassword" + "\t" + "GenericLog" + "\t" + "GenericInfo" + "\t" + "Validação de letra minúscula" + "\t" + "Caracter NÃO Encontrado"); }

            System.out.println(super.getDateTime() + "\t" + "UserModule" + "." + "UserController" + "\t\t" + "ValidatePassword" + "\t" + "GenericLog" + "\t" + "GenericInfo" + "\t" + "Validação de caracteres repetidos" + "\t" + "Buscando por: Caracter repetido");
            // Validação de caracteres repetidos Maiúsculo
            for(int i = 0; i < maiuscula.length; i++) {
                for(int j = 0; j < passLength; j++) {
                    try{
                        //System.out.println(super.getDateTime() + "\t" + "UserModule" + "." + "UserController" + "\t\t" + "ValidatePassword" + "\t" + "GenericLog" + "\t" + "GenericInfo" + "\t" + "Validação de caracteres repetidos Maiúsculo." + "\t" + "Encontrado: " + userScreen.gettxtPass().substring(j, j + 3));
                        if((maiuscula[i] + maiuscula[i] + maiuscula[i]).equals(userScreen.gettxtPass().substring(j, j + 3))) {
                            totalCharRepetido++;
                        }
                    } catch (Exception e) {}
                }
            }

            for(int i = 0; i < minuscula.length; i++) {
                //System.out.println(super.getDateTime() + "\t" + "UserModule" + "." + "UserController" + "\t\t" + "ValidatePassword" + "\t" + "GenericLog" + "\t" + "GenericInfo" + "\t" + "Validação de caracteres repetidos Minúsculo." + "\t" + "Buscando por: " + minuscula[i] + minuscula[i] + minuscula[i]);
                for(int j = 0; j < passLength; j++) {
                    try{
                        //System.out.println(super.getDateTime() + "\t" + "UserModule" + "." + "UserController" + "\t\t" + "ValidatePassword" + "\t" + "GenericLog" + "\t" + "GenericInfo" + "\t" + "Validação de caracteres repetidos Minúsculo." + "\t" + "Encontrado: " + userScreen.gettxtPass().substring(j, j + 3));
                        if((minuscula[i] + minuscula[i] + minuscula[i]).equals(userScreen.gettxtPass().substring(j, j + 3))) {
                            //System.out.println(super.getDateTime() + "\t" + "UserModule" + "." + "UserController" + "\t\t" + "ValidatePassword" + "\t" + "GenericLog" + "\t" + "GenericInfo" + "\t" + "Validação de caracteres repetidos Maiúsculo." + "\t" + "Caracter Encontrado");
                            totalCharRepetido++;
                        }
                    } catch (Exception e) {}
                }
            }
            if(totalCharRepetido > 0) { System.out.println(super.getDateTime() + "\t" + "UserModule" + "." + "UserController" + "\t\t" + "ValidatePassword" + "\t" + "GenericLog" + "\t" + "GenericInfo" + "\t" + "Validação de caracteres repetidos" + "\t" + "Caracter Encontrado"); } else { System.out.println(super.getDateTime() + "\t" + "UserModule" + "." + "UserController" + "\t\t" + "ValidatePassword" + "\t" + "GenericLog" + "\t" + "GenericInfo" + "\t" + "Validação de caracteres repetidos" + "\t" + "Caracter NÃO Encontrado"); }

            System.out.println(super.getDateTime() + "\t" + "UserModule" + "." + "UserController" + "\t\t" + "ValidatePassword" + "\t" + "GenericLog" + "\t" + "GenericInfo" + "\t" + "Validação de mínimo 1 número" + "\t" + "Buscando por: Número");
            // Validação de numero
            for(int i = 0; i < numero.length; i++) {
                //System.out.println(super.getDateTime() + "\t" + "UserModule" + "." + "UserController" + "\t\t" + "ValidatePassword" + "\t" + "GenericLog" + "\t" + "GenericInfo" + "\t" + "Validação de mínimo 1 número" + "\t" + "Buscando por: " + numero[i]);
                for(int j = 0; j < passLength; j++) {
                    //System.out.println(super.getDateTime() + "\t" + "UserModule" + "." + "UserController" + "\t\t" + "ValidatePassword" + "\t" + "GenericLog" + "\t" + "GenericInfo" + "\t" + "Validação de mínimo 1 número" + "\t" + "Encontrado: " + userScreen.gettxtPass().substring(j, j + 1));
                    if(numero[i].equals(userScreen.gettxtPass().substring(j, j + 1))) {
                        //System.out.println(super.getDateTime() + "\t" + "UserModule" + "." + "UserController" + "\t\t" + "ValidatePassword" + "\t" + "GenericLog" + "\t" + "GenericInfo" + "\t" + "Validação de mínimo 1 número" + "\t" + "Número Encontrado");
                        totalNumero++;
                    }
                }
            }
            if(totalNumero > 0) { System.out.println(super.getDateTime() + "\t" + "UserModule" + "." + "UserController" + "\t\t" + "ValidatePassword" + "\t" + "GenericLog" + "\t" + "GenericInfo" + "\t" + "Validação de mínimo 1 número" + "\t" + "Número Encontrado"); } else { System.out.println(super.getDateTime() + "\t" + "UserModule" + "." + "UserController" + "\t\t" + "ValidatePassword" + "\t" + "GenericLog" + "\t" + "GenericInfo" + "\t" + "Validação de mínimo 1 número" + "\t" + "Número NÃO Encontrado"); }

            System.out.println(super.getDateTime() + "\t" + "UserModule" + "." + "UserController" + "\t\t" + "ValidatePassword" + "\t" + "GenericLog" + "\t" + "GenericInfo" + "\t" + "Validação de data de nascimento" + "\t\t" + "Buscando por: " + diaNascimento + mesNascimento + anoNascimento);
            System.out.println(super.getDateTime() + "\t" + "UserModule" + "." + "UserController" + "\t\t" + "ValidatePassword" + "\t" + "GenericLog" + "\t" + "GenericInfo" + "\t" + "Validação de data de nascimento" + "\t\t" + "Buscando por: " + diaNascimento + anoNascimento + mesNascimento);
            System.out.println(super.getDateTime() + "\t" + "UserModule" + "." + "UserController" + "\t\t" + "ValidatePassword" + "\t" + "GenericLog" + "\t" + "GenericInfo" + "\t" + "Validação de data de nascimento" + "\t\t" + "Buscando por: " + mesNascimento + diaNascimento + anoNascimento);
            System.out.println(super.getDateTime() + "\t" + "UserModule" + "." + "UserController" + "\t\t" + "ValidatePassword" + "\t" + "GenericLog" + "\t" + "GenericInfo" + "\t" + "Validação de data de nascimento" + "\t\t" + "Buscando por: " + mesNascimento + anoNascimento + diaNascimento);
            System.out.println(super.getDateTime() + "\t" + "UserModule" + "." + "UserController" + "\t\t" + "ValidatePassword" + "\t" + "GenericLog" + "\t" + "GenericInfo" + "\t" + "Validação de data de nascimento" + "\t\t" + "Buscando por: " + anoNascimento + diaNascimento + mesNascimento);
            System.out.println(super.getDateTime() + "\t" + "UserModule" + "." + "UserController" + "\t\t" + "ValidatePassword" + "\t" + "GenericLog" + "\t" + "GenericInfo" + "\t" + "Validação de data de nascimento" + "\t\t" + "Buscando por: " + anoNascimento + mesNascimento + diaNascimento);
            System.out.println(super.getDateTime() + "\t" + "UserModule" + "." + "UserController" + "\t\t" + "ValidatePassword" + "\t" + "GenericLog" + "\t" + "GenericInfo" + "\t" + "Validação de data de nascimento" + "\t\t" + "Buscando por: " + diaNascimento + mesNascimento + anoNascimento.substring(2, 4));
            System.out.println(super.getDateTime() + "\t" + "UserModule" + "." + "UserController" + "\t\t" + "ValidatePassword" + "\t" + "GenericLog" + "\t" + "GenericInfo" + "\t" + "Validação de data de nascimento" + "\t\t" + "Buscando por: " + diaNascimento + anoNascimento.substring(2, 4) + mesNascimento);
            System.out.println(super.getDateTime() + "\t" + "UserModule" + "." + "UserController" + "\t\t" + "ValidatePassword" + "\t" + "GenericLog" + "\t" + "GenericInfo" + "\t" + "Validação de data de nascimento" + "\t\t" + "Buscando por: " + mesNascimento + diaNascimento + anoNascimento.substring(2, 4));
            System.out.println(super.getDateTime() + "\t" + "UserModule" + "." + "UserController" + "\t\t" + "ValidatePassword" + "\t" + "GenericLog" + "\t" + "GenericInfo" + "\t" + "Validação de data de nascimento" + "\t\t" + "Buscando por: " + mesNascimento + anoNascimento.substring(2, 4) + diaNascimento);
            System.out.println(super.getDateTime() + "\t" + "UserModule" + "." + "UserController" + "\t\t" + "ValidatePassword" + "\t" + "GenericLog" + "\t" + "GenericInfo" + "\t" + "Validação de data de nascimento" + "\t\t" + "Buscando por: " + anoNascimento.substring(2, 4) + diaNascimento + mesNascimento);
            System.out.println(super.getDateTime() + "\t" + "UserModule" + "." + "UserController" + "\t\t" + "ValidatePassword" + "\t" + "GenericLog" + "\t" + "GenericInfo" + "\t" + "Validação de data de nascimento" + "\t\t" + "Buscando por: " + anoNascimento.substring(2, 4) + mesNascimento + diaNascimento);

            // Validação de data de nascimento
            for(int i = 0; i < passLength; i++) {            
                try{                
                    if((i + 8) <= passLength){
                        if((diaNascimento + mesNascimento + anoNascimento).equals(userScreen.gettxtPass().substring(i, i + 8))) { totalDataNasc++; }
                        if((diaNascimento + anoNascimento + mesNascimento).equals(userScreen.gettxtPass().substring(i, i + 8))) { totalDataNasc++; }
                        if((mesNascimento + diaNascimento + anoNascimento).equals(userScreen.gettxtPass().substring(i, i + 8))) { totalDataNasc++; }
                        if((mesNascimento + anoNascimento + diaNascimento).equals(userScreen.gettxtPass().substring(i, i + 8))) { totalDataNasc++; }
                        if((anoNascimento + diaNascimento + mesNascimento).equals(userScreen.gettxtPass().substring(i, i + 8))) { totalDataNasc++; }
                        if((anoNascimento + mesNascimento + diaNascimento).equals(userScreen.gettxtPass().substring(i, i + 8))) { totalDataNasc++; }
                        //System.out.println(super.getDateTime() + "\t" + "UserModule" + "." + "UserController" + "\t\t" + "ValidatePassword" + "\t" + "GenericLog" + "\t" + "GenericInfo" + "\t" + "Validação de data de nascimento" + "\t" + "Encontrado: " + userScreen.gettxtPass().substring(i, i + 8));
                        //System.out.println(super.getDateTime() + "\t" + "UserModule" + "." + "UserController" + "\t\t" + "ValidatePassword" + "\t" + "GenericLog" + "\t" + "GenericInfo" + "\t" + "Validação de data de nascimento" + "\t\t" + "Data de Nascimento Encontrada");
                    } else {
                        if((diaNascimento + mesNascimento + anoNascimento).equals(userScreen.gettxtPass().substring(i, passLength - 1))) { totalDataNasc++; }
                        if((diaNascimento + anoNascimento + mesNascimento).equals(userScreen.gettxtPass().substring(i, passLength - 1))) { totalDataNasc++; }
                        if((mesNascimento + diaNascimento + anoNascimento).equals(userScreen.gettxtPass().substring(i, passLength - 1))) { totalDataNasc++; }
                        if((mesNascimento + anoNascimento + diaNascimento).equals(userScreen.gettxtPass().substring(i, passLength - 1))) { totalDataNasc++; }
                        if((anoNascimento + diaNascimento + mesNascimento).equals(userScreen.gettxtPass().substring(i, passLength - 1))) { totalDataNasc++; }
                        if((anoNascimento + mesNascimento + diaNascimento).equals(userScreen.gettxtPass().substring(i, passLength - 1))) { totalDataNasc++; }
                    }

                    if((i + 6) <= passLength){
                        if((diaNascimento + mesNascimento + anoNascimento.substring(2, 4)).equals(userScreen.gettxtPass().substring(i, i + 6))) { totalDataNasc++; }
                        if((diaNascimento + anoNascimento.substring(2, 4) + mesNascimento).equals(userScreen.gettxtPass().substring(i, i + 6))) { totalDataNasc++; }
                        if((mesNascimento + diaNascimento + anoNascimento.substring(2, 4)).equals(userScreen.gettxtPass().substring(i, i + 6))) { totalDataNasc++; }
                        if((mesNascimento + anoNascimento.substring(2, 4) + diaNascimento).equals(userScreen.gettxtPass().substring(i, i + 6))) { totalDataNasc++; }
                        if((anoNascimento.substring(2, 4) + diaNascimento + mesNascimento).equals(userScreen.gettxtPass().substring(i, i + 6))) { totalDataNasc++; }
                        if((anoNascimento.substring(2, 4) + mesNascimento + diaNascimento).equals(userScreen.gettxtPass().substring(i, i + 6))) { totalDataNasc++; }
                        //System.out.println(super.getDateTime() + "\t" + "UserModule" + "." + "UserController" + "\t\t" + "ValidatePassword" + "\t" + "GenericLog" + "\t" + "GenericInfo" + "\t" + "Validação de data de nascimento" + "\t" + "Encontrado: " + userScreen.gettxtPass().substring(i, i + 6));
                        //System.out.println(super.getDateTime() + "\t" + "UserModule" + "." + "UserController" + "\t\t" + "ValidatePassword" + "\t" + "GenericLog" + "\t" + "GenericInfo" + "\t" + "Validação de data de nascimento" + "\t\t" + "Data de Nascimento Encontrada");
                    } else {
                        if((diaNascimento + mesNascimento + anoNascimento.substring(2, 4)).equals(userScreen.gettxtPass().substring(i, passLength - 1))) { totalDataNasc++; }
                        if((diaNascimento + anoNascimento.substring(2, 4) + mesNascimento).equals(userScreen.gettxtPass().substring(i, passLength - 1))) { totalDataNasc++; }
                        if((mesNascimento + diaNascimento + anoNascimento.substring(2, 4)).equals(userScreen.gettxtPass().substring(i, passLength - 1))) { totalDataNasc++; }
                        if((mesNascimento + anoNascimento.substring(2, 4) + diaNascimento).equals(userScreen.gettxtPass().substring(i, passLength - 1))) { totalDataNasc++; }
                        if((anoNascimento.substring(2, 4) + diaNascimento + mesNascimento).equals(userScreen.gettxtPass().substring(i, passLength - 1))) { totalDataNasc++; }
                        if((anoNascimento.substring(2, 4) + mesNascimento + diaNascimento).equals(userScreen.gettxtPass().substring(i, passLength - 1))) { totalDataNasc++; }
                    }

                    /*if(((i + 6) > passLength) || ((i + 8) > passLength)){
                        //System.out.println(super.getDateTime() + "\t" + "UserModule" + "." + "UserController" + "\t\t" + "ValidatePassword" + "\t" + "GenericLog" + "\t" + "GenericInfo" + "\t" + "Validação de data de nascimento" + "\t" + "Encontrado: " + userScreen.gettxtPass().substring(i, userScreen.gettxtPass().length() - i));
                        //System.out.println(super.getDateTime() + "\t" + "UserModule" + "." + "UserController" + "\t\t" + "ValidatePassword" + "\t" + "GenericLog" + "\t" + "GenericInfo" + "\t" + "Validação de data de nascimento" + "\t\t" + "Data de Nascimento NÃO Encontrada");
                        i = passLength;
                    }*/

                } catch (Exception e) {}

            }
            if(totalDataNasc > 0) { System.out.println(super.getDateTime() + "\t" + "UserModule" + "." + "UserController" + "\t\t" + "ValidatePassword" + "\t" + "GenericLog" + "\t" + "GenericInfo" + "\t" + "Validação de data de nascimento" + "\t\t" + "Data de Nascimento Encontrada"); } else { System.out.println(super.getDateTime() + "\t" + "UserModule" + "." + "UserController" + "\t\t" + "ValidatePassword" + "\t" + "GenericLog" + "\t" + "GenericInfo" + "\t" + "Validação de data de nascimento" + "\t\t" + "Data de Nascimento NÃO Encontrada"); }

            System.out.println(super.getDateTime() + "\t" + "UserModule" + "." + "UserController" + "\t\t" + "ValidatePassword" + "\t" + "GenericLog" + "\t" + "GenericInfo" + "\t" + "Validação de nome de usuário" + "\t" + "Buscando por: Nome de usuário");
            // Validação de nome de usuário
            for(int i = 0; i < passLength; i++) {
                try{
                    if((userScreen.gettxtUser()).equals(userScreen.gettxtPass().substring(i, i + userScreen.gettxtUser().length()))) {
                        totalNomeUser++;
                        i = userScreen.gettxtPass().length();
                    }
                } catch (Exception e) {}
            }
            if(totalNomeUser > 0) { System.out.println(super.getDateTime() + "\t" + "UserModule" + "." + "UserController" + "\t\t" + "ValidatePassword" + "\t" + "GenericLog" + "\t" + "GenericInfo" + "\t" + "Validação de nome de usuário" + "\t\t" + "Nome de usuário encontrado"); } else { System.out.println(super.getDateTime() + "\t" + "UserModule" + "." + "UserController" + "\t\t" + "ValidatePassword" + "\t" + "GenericLog" + "\t" + "GenericInfo" + "\t" + "Validação de nome de usuário" + "\t\t" + "Nome de usuário NÃO encontrado"); }

            System.out.println(super.getDateTime() + "\t" + "UserModule" + "." + "UserController" + "\t\t" + "ValidatePassword" + "\t" + "GenericLog" + "\t" + "GenericInfo" + "\t" + "Validação de Nome" + "\t" + "Buscando por: Nome");
            // Validação de nome
            for(int i = 0; i < passLength; i++) {
                try{
                    if((userScreen.gettxtName()).equals(userScreen.gettxtPass().substring(i, i + userScreen.gettxtName().length()))) {
                        totalNome++;
                        i = userScreen.gettxtPass().length();
                    }
                } catch (Exception e) {}
            }
            if(totalNome > 0) { System.out.println(super.getDateTime() + "\t" + "UserModule" + "." + "UserController" + "\t\t" + "ValidatePassword" + "\t" + "GenericLog" + "\t" + "GenericInfo" + "\t" + "Validação de Nome" + "\t\t" + "Nome encontrado"); } else { System.out.println(super.getDateTime() + "\t" + "UserModule" + "." + "UserController" + "\t\t" + "ValidatePassword" + "\t" + "GenericLog" + "\t" + "GenericInfo" + "\t" + "Validação de Nome" + "\t\t" + "Nome NÃO encontrado"); }

            //SELECT * FROM PDV.T_USER_HISTORY WHERE PAR_ROW_ID = 'USER_ID'
            /*
            for(int i = 0; i < userHistory.size(); i++) {
                if(userScreen.gettxtPass().equals(userHistory.get(i).getPASWORD())) {
                    totalPassLastYear++;
                }
            }
            */
        }

        if(passLength < 8) { mensagem += "\n- " + "Deve conter pelo menos 8 caracteres" + ";"; }
        if(totalMaiuscula < 1) { mensagem += "\n- " + "Deve conter pelo menos 1 letra Maiúscula" + ";"; }
        if(totalMinuscula < 1) { mensagem += "\n- " + "Deve conter pelo menos 1 letra Minúscula" + ";"; }
        if(totalNumero < 1) { mensagem += "\n- " + "Deve conter pelo menos 1 número" + ";"; }
        
        if(totalCharRepetido > 0) { mensagem += "\n- " + "Não deve conter mais de 2 caracteres idênticos consecutivos" + ";"; }
        if(totalDataNasc > 0) { mensagem += "\n- " + "Não deve conter data de nascimento" + ";"; }
        //if(totalPassLastYear < 1) { mensagem += "\n- " + "Não pode ter sido utilizada no último ano" + ";"; }
        if(totalNomeUser > 0) { mensagem += "\n- " + "Não deve ser a mesma que o nome do usuário" + ";"; }
        if(totalNome > 0) { mensagem += "\n- " + "Não deve ser a mesma que o seu nome" + ";"; }        

        if(!"".equals(mensagem) && mensagem != null){
            JOptionPane.showMessageDialog(null, "O campo 'Senha' não preencheu o(s) seguinte(s) requisito(s):" + mensagem);
            return false;
        } else {
            if(!userScreen.gettxtPass().equals(userScreen.gettxtPassVerification())){
                JOptionPane.showMessageDialog(null, "Os campos 'Senha' e 'Verificação de Senha' não coincidem! Favor corrigir os mesmos.");
                return false;
            } else {
                return true;
            }
        }
    }
    
    public boolean insert(){
        ArrayList<PositionClass> positionList;
        
        String userId = super.getNextRowId();
        super.clearColumns();
        super.clearValues();
        super.setColumns("ROW_ID"); super.setValues("'" + userId + "'");
        super.setColumns(",\n\t" + "CREATED");
        super.setColumns(",\n\t" + "LAST_UPD");
        super.setColumns(",\n\t" + "DB_LAST_UPD");
        if(super.getDbDriver().toUpperCase().contains("ORACLE")) {
            super.setValues(",\n\t" + "SYSDATE");
            super.setValues(",\n\t" + "SYSDATE");
            super.setValues(",\n\t" + "SYSDATE");
        } else if (super.getDbDriver().toUpperCase().contains("MYSQL")) {
            super.setValues(",\n\t" + "SYSDATE()");
            super.setValues(",\n\t" + "SYSDATE()");
            super.setValues(",\n\t" + "SYSDATE()");
        } else {
            super.setValues(",\n\t" + "SYSDATE");
            super.setValues(",\n\t" + "SYSDATE");
            super.setValues(",\n\t" + "SYSDATE");
        }
        super.setColumns(",\n\t" + "CREATED_BY"); super.setValues(",\n\t" + "'" + super.getConnectedUserId() + "'");
        super.setColumns(",\n\t" + "LAST_UPD_BY"); super.setValues(",\n\t" + "'" + super.getConnectedUserId() + "'");
        super.setColumns(",\n\t" + "STATUS_CD"); super.setValues(",\n\t" + "'" + super.LookupName("USER_STATUS", ("Y".equals(userScreen.getckbActiveUserFlg()) ? "Ativo" : "Inativo")) + "'");
        super.setColumns(",\n\t" + "PAR_ROW_ID"); super.setValues(",\n\t" + "NULL");
        super.setColumns(",\n\t" + "PAR_POSTN_ID");
        if(userScreen.getcbbPosition() != null){
            positionList = queryPositionRecord("SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblPosition() + " POS\nWHERE POS.NAME = '" + userScreen.getcbbPosition() + "'\nAND POS.POSTN_TYPE_CD = '" + super.LookupName("POSITION_TYPE", userScreen.getcbbPosition()) + "'");
            super.setValues(",\n\t" + ((positionList.size() > 0) ? "'" + positionList.get(0).getRow_id() + "'" : "NULL"));
        } else {
            super.setValues(",\n\t" + "NULL");
        }
        
        super.setColumns(",\n\t" + "LOGIN"); super.setValues(",\n\t" + "'" + userScreen.gettxtUser() + "'");
        super.setColumns(",\n\t" + "PASSWORD"); super.setValues(",\n\t" + "'" + encryptDecrypt.encryptWord(userScreen.gettxtPass())  + "'");
        super.setColumns(",\n\t" + "USER_FLG"); super.setValues(",\n\t" + "'Y'");
        super.setColumns(",\n\t" + "LAST_LOGIN_TS"); super.setValues(",\n\t" + "NULL");
        super.setColumns(",\n\t" + "DOC_TYPE"); super.setValues(",\n\t" + "'" + super.LookupName("DOC_TYPE", userScreen.getcbbDocType()) + "'");
        super.setColumns(",\n\t" + "DOC_NUM"); super.setValues(",\n\t" + "'" + userScreen.gettxtDocNum() + "'");
        super.setColumns(",\n\t" + "FST_NAME"); super.setValues(",\n\t" + "'" + userScreen.gettxtName() + "'");
        super.setColumns(",\n\t" + "LAST_NAME"); super.setValues(",\n\t" + "'" + userScreen.gettxtSurname() + "'");
        super.setColumns(",\n\t" + "FULL_NAME"); super.setValues(",\n\t" + "'" + userScreen.gettxtName() + " " + userScreen.gettxtSurname() + "'");
        super.setColumns(",\n\t" + "NICK_NAME"); super.setValues(",\n\t" + ((userScreen.gettxtNickName() != null) ? "'" + userScreen.gettxtNickName() + "'" : "NULL"));
        
        String month = super.LookupValue("MONTH_TRANSLATION", userScreen.getcbbMonth()).toUpperCase();
        LocalDate today = LocalDate.now();
        LocalDate birthDate = LocalDate.of(Integer.valueOf(userScreen.gettxtYear()), Month.valueOf(month), Integer.valueOf(userScreen.getcbbDay()));
        long age = ChronoUnit.YEARS.between(birthDate, today);
        
        System.out.println(super.getDateTime() + "\t" + "UserModule" + "." + "UserController" + "\t\t" + "insertUser" + "\t" + "GenericLog" + "\t" + "GenericInfo" + "\t" + "Calculando idade do usuário" + "\t\t" + "Convertendo o mês de nascimento para Inglês e MAIÚSCULO");
        System.out.println(super.getDateTime() + "\t" + "UserModule" + "." + "UserController" + "\t\t" + "insertUser" + "\t" + "GenericLog" + "\t" + "GenericInfo" + "\t" + "Calculando idade do usuário" + "\t\t" + "Mês convertido para inglês. Resultado: " + month);
        System.out.println(super.getDateTime() + "\t" + "UserModule" + "." + "UserController" + "\t\t" + "insertUser" + "\t" + "GenericLog" + "\t" + "GenericInfo" + "\t" + "Calculando idade do usuário" + "\t\t" + "Instanciando o objeto LocalDate com a data de hoje");
        System.out.println(super.getDateTime() + "\t" + "UserModule" + "." + "UserController" + "\t\t" + "insertUser" + "\t" + "GenericLog" + "\t" + "GenericInfo" + "\t" + "Calculando idade do usuário" + "\t\t" + "Objeto LocalDate instanciado com sucesso. Resultado: " + today);
        System.out.println(super.getDateTime() + "\t" + "UserModule" + "." + "UserController" + "\t\t" + "insertUser" + "\t" + "GenericLog" + "\t" + "GenericInfo" + "\t" + "Calculando idade do usuário" + "\t\t" + "Instanciando o objeto LocalDate com a data de nascimento");
        System.out.println(super.getDateTime() + "\t" + "UserModule" + "." + "UserController" + "\t\t" + "insertUser" + "\t" + "GenericLog" + "\t" + "GenericInfo" + "\t" + "Calculando idade do usuário" + "\t\t" + "Objeto LocalDate instanciado com sucesso. Resultado: " + birthDate);
        System.out.println(super.getDateTime() + "\t" + "UserModule" + "." + "UserController" + "\t\t" + "insertUser" + "\t" + "GenericLog" + "\t" + "GenericInfo" + "\t" + "Calculando idade do usuário" + "\t\t" + "Calculando a diferença (em ANOS) entre as datas: " + today + " - " + birthDate + " = " + age);
        
        super.setColumns(",\n\t" + "AGE"); super.setValues(",\n\t" + "'" + age + "'");
        super.setColumns(",\n\t" + "BIRTH_DT"); super.setValues(",\n\t" + "'" + super.LookupName("MONTH_DAY", userScreen.getcbbDay()) + "/" + super.LookupName("MONTH", userScreen.getcbbMonth()) + "/" + userScreen.gettxtYear() + "'");
        super.setColumns(",\n\t" + "PLACE_OF_BIRTH"); super.setValues(",\n\t" + ((userScreen.gettxtBornLocation() != null) ? "'" + userScreen.gettxtBornLocation() + "'" : "NULL"));
        super.setColumns(",\n\t" + "SEX_MF"); super.setValues(",\n\t" + "'" + super.LookupName("SEX_MF", userScreen.getcbbSex())  + "'");
        super.setColumns(",\n\t" + "MARITAL_STAT_CD"); super.setValues(",\n\t" + ((userScreen.getcbbCivilState() != null) ? "'" + super.LookupName("CIVIL_STATE", userScreen.getcbbCivilState()) + "'" : "NULL"));
        super.setColumns(",\n\t" + "NAME_CONJUGE"); super.setValues(",\n\t" + ((userScreen.gettxtSpouseName() != null) ? "'" + userScreen.gettxtSpouseName() + "'" : "NULL"));
        super.setColumns(",\n\t" + "MOTHER_FULL_NAME"); super.setValues(",\n\t" + ((userScreen.gettxtMotherName() != null) ? "'" + userScreen.gettxtMotherName() + "'" : "NULL"));
        super.setColumns(",\n\t" + "FATHER_FULL_NAME"); super.setValues(",\n\t" + ((userScreen.gettxtFatherName() != null) ? "'" + userScreen.gettxtFatherName() + "'" : "NULL"));
        super.setColumns(",\n\t" + "IDENTITY_DOC_TYPE"); super.setValues(",\n\t" +((userScreen.getcbbIdentityType() != null) ? "'" + super.LookupName("DOCUMENT_TYPE", userScreen.getcbbIdentityType()) + "'" : "NULL")); 
        super.setColumns(",\n\t" + "REGISTER_NUM"); super.setValues(",\n\t" + ((userScreen.gettxtRecNum() != null) ? "'" + userScreen.gettxtRecNum() + "'" : "NULL"));
        super.setColumns(",\n\t" + "REGISTER_SERIE"); super.setValues(",\n\t" + ((userScreen.gettxtSerieNum() != null) ? "'" + userScreen.gettxtSerieNum() + "'" : "NULL"));
        super.setColumns(",\n\t" + "ORGAO_EMISSOR"); super.setValues(",\n\t" + ((userScreen.gettxtEmissor() != null) ? "'" + userScreen.gettxtEmissor() + "'" : "NULL"));
        super.setColumns(",\n\t" + "UF_EMISSAO"); super.setValues(",\n\t" + ((userScreen.getcbbEmissionUF() != null) ? "'" + super.LookupName("STATE", userScreen.getcbbEmissionUF()) + "'" : "NULL"));
        super.setColumns(",\n\t" + "EMISSION_DT"); super.setValues(",\n\t" + ((userScreen.gettxtEmissionDate() != null) ? "'" + userScreen.gettxtEmissionDate() + "'" : "NULL"));
        super.setColumns(",\n\t" + "VALIDATION_DT"); super.setValues(",\n\t" + ((userScreen.gettxtValidThru() != null) ? "'" + userScreen.gettxtValidThru() + "'" : "NULL"));
        super.setColumns(",\n\t" + "NATURALNESS"); super.setValues(",\n\t" + ((userScreen.gettxtNaturalness() != null) ? "'" + userScreen.gettxtNaturalness() + "'" : "NULL"));
        super.setColumns(",\n\t" + "NATIONALITY"); super.setValues(",\n\t" + ((userScreen.gettxtNationality() != null) ? "'" + userScreen.gettxtNationality() + "'" : "NULL"));
        super.setColumns(",\n\t" + "CHALLENGE_QUESTION_1"); super.setValues(",\n\t" + ((userScreen.gettxtSecQuestion1()!= null) ? "'" + encryptDecrypt.encryptWord(userScreen.gettxtSecQuestion1()) + "'" : "NULL"));
        super.setColumns(",\n\t" + "CHALLENGE_ANSWER_1"); super.setValues(",\n\t" + ((userScreen.gettxtSecAnswer1() != null) ? "'" + encryptDecrypt.encryptWord(userScreen.gettxtSecAnswer1()) + "'" : "NULL"));
        super.setColumns(",\n\t" + "CHALLENGE_QUESTION_2"); super.setValues(",\n\t" + ((userScreen.gettxtSecQuestion2() != null) ? "'" + encryptDecrypt.encryptWord(userScreen.gettxtSecQuestion2()) + "'" : "NULL"));
        super.setColumns(",\n\t" + "CHALLENGE_ANSWER_2"); super.setValues(",\n\t" + ((userScreen.gettxtSecAnswer2() != null) ? "'" + encryptDecrypt.encryptWord(userScreen.gettxtSecAnswer2()) + "'" : "NULL"));
        super.setColumns(",\n\t" + "CHALLENGE_QUESTION_3"); super.setValues(",\n\t" + ((userScreen.gettxtSecQuestion3() != null) ? "'" + encryptDecrypt.encryptWord(userScreen.gettxtSecQuestion3()) + "'" : "NULL"));
        super.setColumns(",\n\t" + "CHALLENGE_ANSWER_3"); super.setValues(",\n\t" + ((userScreen.gettxtSecAnswer3() != null) ? "'" + encryptDecrypt.encryptWord(userScreen.gettxtSecAnswer3()) + "'" : "NULL"));
        super.setColumns(",\n\t" + "PR_ADDR_ID"); super.setValues(",\n\t" + "NULL");
        super.setColumns(",\n\t" + "PR_CON_ID"); super.setValues(",\n\t" + "NULL");
        super.setColumns(",\n\t" + "PR_PHONE_ID"); super.setValues(",\n\t" + "NULL");
        super.setColumns(",\n\t" + "COMMENTS"); super.setValues(",\n\t" + "NULL");
        
        try{
            if("true".equals(super.insertRecord(super.getTblUser(), super.getColumns(), super.getValues()))){
                userRowId = new userRowIdClass();
                userRowId.setRow_Id(userId);
                setLastUserAdd(userId);
                userRowIdArray.add(userRowId);
                this.clearColumns();
                this.clearValues();

                try{
                    if(cont.getContRowIdArray().size() > 0){
                        for(int i = 0; i < cont.getContRowIdArray().size(); i ++){
                            super.clearColumnsValues();
                            super.clearCondition();
                            super.setColumnsValues(",\n\t" + "PAR_ROW_ID = '" + userId + "'");
                            super.setColumnsValues(",\n\t" + "PAR_USR_ID = '" + userId + "'");
                            super.setColumnsValues(",\n\t" + "EMP_FLG = 'Y'");

                            try{
                                cont.updateContact("USER", super.getColumnsValues(), super.getCondition(), cont.getContRowIdArray().get(i).getRow_id());
                            } catch(Exception e) {
                                System.out.println(super.getDateTime() + "\tContactModule.ContactController\t\tinsertContact\nUpdateSocialMedia\tError Exception\tError: " + e);
                            }
                        }
                    }
                } catch(Exception e) { }
                
                try{
                    if(cont.getSocialMediaRowIdArray().size() > 0){
                        for(int i = 0; i < cont.getSocialMediaRowIdArray().size(); i ++){
                            super.clearColumnsValues();
                            super.clearCondition();
                            super.setColumnsValues(",\n\t" + "PAR_USR_ID = '" + userId + "'");

                            try{
                                cont.updateSocialMedia("USER", super.getColumnsValues(), super.getCondition(), cont.getSocialMediaRowIdArray().get(i).getRow_id());
                            } catch(Exception e) {
                                System.out.println(super.getDateTime() + "\tContactModule.ContactController\t\tinsertContact\nUpdateSocialMedia\tError Exception\tError: " + e);
                            }
                        }
                    }
                } catch(Exception e) { }
                
                try{
                    if(addr.getAddressRowIdArray().size() > 0){
                        for(int i = 0; i < addr.getAddressRowIdArray().size(); i ++){
                            super.clearColumnsValues();
                            super.clearCondition();
                            super.setColumnsValues(",\n\t" + "PAR_ROW_ID = '" + userId + "'");

                            try{
                                addr.updateAddress("USER", super.getColumnsValues(), super.getCondition(), addr.getAddressRowIdArray().get(i).getRow_id());
                            } catch(Exception e) {
                                System.out.println(super.getDateTime() + "\tContactModule.ContactController\t\tinsertContact\nUpdateSocialMedia\tError Exception\tError: " + e);
                            }
                        }
                    }
                } catch(Exception e) { }
                
                this.updateUserPrimaryContactAddress(userId);
                return true;
            } else {
                userId = null;
                this.clearColumns();
                this.clearValues();
                return false;
            }
        } catch (Exception e) {
            userId = null;
            this.clearColumns();
            this.clearValues();
            return false;
        }
    }
    
    public boolean update(String screen, String columnsValues, String condition, String userId){
        ArrayList<PositionClass> postnList;
        
        boolean retorno = false;
        super.clearColumnsValues();
        super.clearCondition();
        switch(screen) {
            case "USER":
                this.setLastUserUpd(userId);
                
                if(super.getDbDriver().toUpperCase().contains("ORACLE")) {
                    super.setColumnsValues("LAST_UPD = SYSDATE");
                    super.setColumnsValues(",\n\t" + "DB_LAST_UPD = SYSDATE");
                } else if (super.getDbDriver().toUpperCase().contains("MYSQL")) {
                    super.setColumnsValues("LAST_UPD = SYSDATE()");
                    super.setColumnsValues(",\n\t" + "DB_LAST_UPD = SYSDATE()");
                } else {
                    super.setColumnsValues("LAST_UPD = SYSDATE");
                    super.setColumnsValues(",\n\t" + "DB_LAST_UPD = SYSDATE");
                }
                super.setColumnsValues(",\n\t" + "LAST_UPD_BY = '" + super.getConnectedUserId() + "'");                
                super.setColumnsValues(",\n\t" + "STATUS_CD = '" + super.LookupName("USER_STATUS", ("Y".equals(userScreen.getckbActiveUserFlg()) ? "Ativo" : "Inativo")) + "'");
                super.setColumnsValues(",\n\t" + "PAR_ROW_ID = NULL");
                
                if(userScreen.getcbbPosition() != null){
                    postnList = queryPositionRecord("SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblPosition() + " POS\nWHERE POS.NAME = '" + userScreen.getcbbPosition() + "'\nAND POS.POSTN_TYPE_CD = '" + super.LookupName("POSITION_TYPE", userScreen.getcbbPosition()) + "'");
                    super.setColumnsValues(",\n\t" + ((postnList.size() > 0) ? "PAR_POSTN_ID = '" + postnList.get(0).getRow_id() + "'" : "PAR_POSTN_ID = NULL"));
                } else {
                    super.setColumnsValues(",\n\t" + "PAR_POSTN_ID = NULL");
                }
                
                super.setColumnsValues(",\n\t" + "LOGIN = '" + userScreen.gettxtUser() + "'");
                super.setColumnsValues(",\n\t" + "PASSWORD = '" + encryptDecrypt.encryptWord(userScreen.gettxtPass())  + "'");
                super.setColumnsValues(",\n\t" + "USER_FLG = 'Y'");
                super.setColumnsValues(",\n\t" + "DOC_TYPE = '" + super.LookupName("DOC_TYPE", userScreen.getcbbDocType()) + "'");
                super.setColumnsValues(",\n\t" + "DOC_NUM = '" + userScreen.gettxtDocNum() + "'");
                super.setColumnsValues(",\n\t" + "FST_NAME = '" + userScreen.gettxtName() + "'");
                super.setColumnsValues(",\n\t" + "LAST_NAME = '" + userScreen.gettxtSurname() + "'");
                super.setColumnsValues(",\n\t" + "FULL_NAME = '" + userScreen.gettxtName() + " " + userScreen.gettxtSurname() + "'");
                super.setColumnsValues(",\n\t" + "NICK_NAME = " + ((userScreen.gettxtNickName() != null) ? "'" + userScreen.gettxtNickName() + "'" : "NULL"));

                String month = super.LookupValue("MONTH_TRANSLATION", userScreen.getcbbMonth()).toUpperCase();
                LocalDate today = LocalDate.now();
                LocalDate birthDate = LocalDate.of(Integer.valueOf(userScreen.gettxtYear()), Month.valueOf(month), Integer.valueOf(userScreen.getcbbDay()));
                long age = ChronoUnit.YEARS.between(birthDate, today);

                System.out.println(super.getDateTime() + "\t" + "UserModule" + "." + "UserController" + "\t\t" + "UpdateUser" + "\t" + "GenericLog" + "\t" + "GenericInfo" + "\t" + "Calculando idade do usuário" + "\t\t" + "Convertendo o mês de nascimento para Inglês e MAIÚSCULO");
                System.out.println(super.getDateTime() + "\t" + "UserModule" + "." + "UserController" + "\t\t" + "UpdateUser" + "\t" + "GenericLog" + "\t" + "GenericInfo" + "\t" + "Calculando idade do usuário" + "\t\t" + "Mês convertido para inglês. Resultado: " + month);
                System.out.println(super.getDateTime() + "\t" + "UserModule" + "." + "UserController" + "\t\t" + "UpdateUser" + "\t" + "GenericLog" + "\t" + "GenericInfo" + "\t" + "Calculando idade do usuário" + "\t\t" + "Instanciando o objeto LocalDate com a data de hoje");
                System.out.println(super.getDateTime() + "\t" + "UserModule" + "." + "UserController" + "\t\t" + "UpdateUser" + "\t" + "GenericLog" + "\t" + "GenericInfo" + "\t" + "Calculando idade do usuário" + "\t\t" + "Objeto LocalDate instanciado com sucesso. Resultado: " + today);
                System.out.println(super.getDateTime() + "\t" + "UserModule" + "." + "UserController" + "\t\t" + "UpdateUser" + "\t" + "GenericLog" + "\t" + "GenericInfo" + "\t" + "Calculando idade do usuário" + "\t\t" + "Instanciando o objeto LocalDate com a data de nascimento");
                System.out.println(super.getDateTime() + "\t" + "UserModule" + "." + "UserController" + "\t\t" + "UpdateUser" + "\t" + "GenericLog" + "\t" + "GenericInfo" + "\t" + "Calculando idade do usuário" + "\t\t" + "Objeto LocalDate instanciado com sucesso. Resultado: " + birthDate);
                System.out.println(super.getDateTime() + "\t" + "UserModule" + "." + "UserController" + "\t\t" + "UpdateUser" + "\t" + "GenericLog" + "\t" + "GenericInfo" + "\t" + "Calculando idade do usuário" + "\t\t" + "Calculando a diferença (em ANOS) entre as datas: " + today + " - " + birthDate + " = " + age);

                super.setColumnsValues(",\n\t" + "AGE = '" + age + "'");
                super.setColumnsValues(",\n\t" + "BIRTH_DT = '" + super.LookupName("MONTH_DAY", userScreen.getcbbDay()) + "/" + super.LookupName("MONTH", userScreen.getcbbMonth()) + "/" + userScreen.gettxtYear() + "'");
                super.setColumnsValues(",\n\t" + "PLACE_OF_BIRTH = " + ((userScreen.gettxtBornLocation() != null) ? "'" + userScreen.gettxtBornLocation() + "'" : "NULL"));
                super.setColumnsValues(",\n\t" + "SEX_MF = '" + super.LookupName("SEX_MF", userScreen.getcbbSex()) + "'");
                super.setColumnsValues(",\n\t" + "MARITAL_STAT_CD = " + ((userScreen.getcbbCivilState() != null) ? "'" + super.LookupName("CIVIL_STATE", userScreen.getcbbCivilState()) + "'" : "NULL"));
                super.setColumnsValues(",\n\t" + "NAME_CONJUGE = " + ((userScreen.gettxtSpouseName() != null) ? "'" + userScreen.gettxtSpouseName() + "'" : "NULL"));
                super.setColumnsValues(",\n\t" + "MOTHER_FULL_NAME = " + ((userScreen.gettxtMotherName() != null) ? "'" + userScreen.gettxtMotherName() + "'" : "NULL"));
                super.setColumnsValues(",\n\t" + "FATHER_FULL_NAME = " + ((userScreen.gettxtFatherName() != null) ? "'" + userScreen.gettxtFatherName() + "'" : "NULL"));
                super.setColumnsValues(",\n\t" + "IDENTITY_DOC_TYPE = " +((userScreen.getcbbIdentityType() != null) ? "'" + super.LookupName("DOCUMENT_TYPE", userScreen.getcbbIdentityType()) + "'" : "NULL"));
                super.setColumnsValues(",\n\t" + "REGISTER_NUM = " + ((userScreen.gettxtRecNum() != null) ? "'" + userScreen.gettxtRecNum() + "'" : "NULL"));
                super.setColumnsValues(",\n\t" + "REGISTER_SERIE = " + ((userScreen.gettxtSerieNum() != null) ? "'" + userScreen.gettxtSerieNum() + "'" : "NULL"));
                super.setColumnsValues(",\n\t" + "ORGAO_EMISSOR = " + ((userScreen.gettxtEmissor() != null) ? "'" + userScreen.gettxtEmissor() + "'" : "NULL"));
                super.setColumnsValues(",\n\t" + "UF_EMISSAO = " + ((userScreen.getcbbEmissionUF() != null) ? "'" + super.LookupName("STATE", userScreen.getcbbEmissionUF()) + "'" : "NULL"));
                super.setColumnsValues(",\n\t" + "EMISSION_DT = " + ((userScreen.gettxtEmissionDate() != null) ? "'" + userScreen.gettxtEmissionDate() + "'" : "NULL"));
                super.setColumnsValues(",\n\t" + "VALIDATION_DT = " + ((userScreen.gettxtValidThru() != null) ? "'" + userScreen.gettxtValidThru() + "'" : "NULL"));
                super.setColumnsValues(",\n\t" + "NATURALNESS = " + ((userScreen.gettxtNaturalness() != null) ? "'" + userScreen.gettxtNaturalness() + "'" : "NULL"));
                super.setColumnsValues(",\n\t" + "NATIONALITY = " + ((userScreen.gettxtNationality() != null) ? "'" + userScreen.gettxtNationality() + "'" : "NULL"));
                super.setColumnsValues(",\n\t" + "CHALLENGE_QUESTION_1 = " + ((userScreen.gettxtSecQuestion1()!= null) ? "'" + encryptDecrypt.encryptWord(userScreen.gettxtSecQuestion1()) + "'" : "NULL"));
                super.setColumnsValues(",\n\t" + "CHALLENGE_ANSWER_1 = " + ((userScreen.gettxtSecAnswer1() != null) ? "'" + encryptDecrypt.encryptWord(userScreen.gettxtSecAnswer1()) + "'" : "NULL"));
                super.setColumnsValues(",\n\t" + "CHALLENGE_QUESTION_2 = " + ((userScreen.gettxtSecQuestion2() != null) ? "'" + encryptDecrypt.encryptWord(userScreen.gettxtSecQuestion2()) + "'" : "NULL"));
                super.setColumnsValues(",\n\t" + "CHALLENGE_ANSWER_2 = " + ((userScreen.gettxtSecAnswer2() != null) ? "'" + encryptDecrypt.encryptWord(userScreen.gettxtSecAnswer2()) + "'" : "NULL"));
                super.setColumnsValues(",\n\t" + "CHALLENGE_QUESTION_3 = " + ((userScreen.gettxtSecQuestion3() != null) ? "'" + encryptDecrypt.encryptWord(userScreen.gettxtSecQuestion3()) + "'" : "NULL"));
                super.setColumnsValues(",\n\t" + "CHALLENGE_ANSWER_3 = " + ((userScreen.gettxtSecAnswer3() != null) ? "'" + encryptDecrypt.encryptWord(userScreen.gettxtSecAnswer3()) + "'" : "NULL"));
                super.setColumnsValues(",\n\t" + "PR_PHONE_ID = NULL");
                super.setColumnsValues(",\n\t" + "COMMENTS = NULL");
                
                if(!"".equals(columnsValues) && columnsValues != null){
                    super.setColumnsValues(columnsValues);
                }
                super.setCondition("ROW_ID = '" + userId + "'");
                if(!"".equals(condition) && condition != null){
                    super.setCondition(condition);
                }
                
                try{
                    this.clearCount();
                    this.setCount(super.updateRecord(super.getTblUser(), super.getColumnsValues(), super.getCondition()));
                    if(this.getCount() > 0){
                        JOptionPane.showMessageDialog(null, "Registros atualizados com sucesso!\nTotal de registros alterados: " + this.getCount());

                        try{
                            if(cont.getContRowIdArray().size() > 0){
                                for(int i = 0; i < cont.getContRowIdArray().size(); i ++){
                                    super.clearColumnsValues();
                                    super.clearCondition();
                                    super.setColumnsValues(",\n\t" + "PAR_ROW_ID = '" + userId + "'");
                                    super.setColumnsValues(",\n\t" + "PAR_USR_ID = '" + userId + "'");
                                    super.setColumnsValues(",\n\t" + "EMP_FLG = 'Y'");
                                    //super.setCondition("ROW_ID = '" + cont.getContRowIdArray().get(i).getRow_id() + "'");

                                    try{
                                        cont.updateContact("USER", super.getColumnsValues(), super.getCondition(), cont.getContRowIdArray().get(i).getRow_id());
                                    } catch(Exception e) {
                                        System.out.println(super.getDateTime() + "\tContactModule.ContactController\t\tinsertContact\nUpdateSocialMedia\tError Exception\tError: " + e);
                                    }
                                }
                            }
                        } catch (Exception e) { }
                        
                        try{
                            if(addr.getAddressRowIdArray().size() > 0){
                                for(int i = 0; i < addr.getAddressRowIdArray().size(); i ++){
                                    super.clearColumnsValues();
                                    super.clearCondition();
                                    super.setColumnsValues(",\n\t" + "PAR_ROW_ID = '" + userId + "'");
                                    //super.setCondition("ROW_ID = '" + addr.getAddressRowIdArray().get(i).getRow_id() + "'");

                                    try{
                                        addr.updateAddress("USER", super.getColumnsValues(), super.getCondition(), addr.getAddressRowIdArray().get(i).getRow_id());
                                    } catch(Exception e) {
                                        System.out.println(super.getDateTime() + "\tContactModule.ContactController\t\tinsertContact\nUpdateSocialMedia\tError Exception\tError: " + e);
                                    }
                                }
                            }
                        } catch (Exception e) { }
                        
                        this.updateUserPrimaryContactAddress(userId);
                        retorno = true;
                    } else {
                        super.clearColumnsValues();
                        super.clearCondition();
                        retorno = false;
                    }
                } catch (Exception e) {
                    super.clearColumnsValues();
                    super.clearCondition();
                    retorno = false;
                }
                break;
            default:
                break;
        }
        return retorno;
    }
    
    public void updateUserPrimaryContactAddress(String userId){
        ArrayList<AddressClass> addrList;
        ArrayList<ContactClass> contList;
        
        super.clearColumnsValues();
        super.clearCondition();
        
        addrList = queryAddressRecord("SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblAddress() + " ADDR\nWHERE ADDR.PAR_ROW_ID = '" + userId + "'\nAND ADDR.PR_ADDR_FLG = 'Y'");
        super.setColumnsValues("PR_ADDR_ID = " + ((addrList.size() > 0) ? "'" + addrList.get(0).getRow_id() + "'": "NULL"));

        contList = queryContactRecord("SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblContact()+ " CON\nWHERE CON.PAR_ROW_ID = '" + userId + "'\nAND CON.PAR_USR_ID = '" + userId + "'\nAND CON.PR_CON_FLG = 'Y'");
        super.setColumnsValues(",\n\t" + "PR_CON_ID = " + ((contList.size() > 0) ? "'" + contList.get(0).getRow_id() + "'": "NULL"));
        
        super.setCondition("ROW_ID = '" + userId + "'");
        
        try{
            this.clearCount();
            this.setCount(super.updateRecord(super.getTblUser(), super.getColumnsValues(), super.getCondition()));
            if(this.getCount() > 0){
                System.out.println(super.getDateTime() + "\t" + "UserModule" + "." + "UserController" + "\t\t" + "UpdateUserPrimaryContactAddress" + "\t" + "GenericLog" + "\t" + "GenericInfo" + "\t" + "Atualizando o Contato e Endereço Principal" + "\t\t" + "Contato e Endereço Principal do usuário atualizados com sucesso");
                super.clearColumnsValues();
                super.clearCondition();
            } else {
                super.clearColumnsValues();
                super.clearCondition();
            }
        } catch (Exception e) {
            super.clearColumnsValues();
            super.clearCondition();
        }
        
        this.setLastUserUpd(userId);
    }
    
    public boolean delete(){
        int countUser = 0;
        int countContact = 0;
        int countSocialMedia = 0;
        
        if(super.wishDeleteRecord()){
            ArrayList<ContactClass> contact = null;
            ArrayList<SocialMediaClass> socialMedia = null;
            super.clearCondition();
            
            contact = super.queryContactRecord("SELECT *\nFROM " + super.getDbOwner() + "." + getTblContact() + "\nWHERE PAR_USR_ID = '" + userScreen.gettxtRowId() + "'\nAND PAR_ROW_ID = '" + userScreen.gettxtRowId() + "'");
            
            if(contact.size() > 0){
                super.setCondition("PAR_ROW_ID IN (");
                for(int i = 0; i < contact.size(); i++){
                    if(i == 0){
                        super.setCondition("\n\t'" + contact.get(i).getRow_id() + "'");
                    } else {
                        super.setCondition(",\n\t'" + contact.get(i).getRow_id() + "'");
                    }
                }
                super.setCondition("\n)\nAND PAR_USR_ID = '" + userScreen.gettxtRowId() + "'");
                
                socialMedia = super.querySocialMediaRecord("SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblSocialMedia() + "\nWHERE " + super.getCondition());
                
                if(socialMedia.size() > 0) {
                    countSocialMedia = super.deleteRecord(super.getTblSocialMedia(), super.getCondition());
                    if(countSocialMedia > 0){
                        try{
                            cont.updateArrayAfterDelete("CONTACT");
                        } catch (Exception e) {
                            try {
                                cont = new ContactController();    
                                cont.updateArrayAfterDelete("CONTACT");
                            } catch (InterruptedException ex) {
                                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
                
                super.clearCondition();
                
                super.setCondition("PAR_ROW_ID = '" + userScreen.gettxtRowId() + "'");
                super.setCondition("\nAND PAR_USR_ID = '" + userScreen.gettxtRowId() + "'");
                
                countContact = super.deleteRecord(super.getTblContact(), super.getCondition());
                
                if(countContact > 0){
                    try{
                        cont.updateArrayAfterDelete("CONTACT");
                    } catch (Exception e) {
                        try {
                            cont = new ContactController();    
                            cont.updateArrayAfterDelete("CONTACT");
                        } catch (InterruptedException ex) {
                            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                super.clearCondition();
            }
            
            super.setCondition("ROW_ID = '" + userScreen.gettxtRowId() + "'");
            try{
                countUser = super.deleteRecord(super.getTblUser(), super.getCondition());
                if(countUser > 0){
                    JOptionPane.showMessageDialog(null, "Registro(s) removido(s) com sucesso! Total de registros removidos:\nUsuário: " + countUser + " registro(s)\nContato: " + countContact + " registro(s)\nRedes Sociais: " + countSocialMedia + " registro(s)");
                    super.clearCondition();
                    return true;
                } else {
                    super.clearCondition();
                    return false;
                }
            } catch (HeadlessException e) {
                super.clearCondition();
                return false;
            }
        } else {
            return false;
        }
    }
    
    public void save(){
        if(validateFields() && validatePassword()){
            try{
                ArrayList<UserClass> userList = queryUserRecord("SELECT *\nFROM " + getDbOwner() + "." + getTblUser() + "\nWHERE ROW_ID = '" + userScreen.gettxtRowId() + "'");
                if(userList.size() > 0) {
                    if(update("USER", null, null, userScreen.gettxtRowId())) {
                        userScreen.enableFields("SALVAR");
                        openUserScreen("USER", "SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblUser() + " USR\nORDER BY USR.FST_NAME ASC");

                        boolean foundRow = true;
                        int i = 0;
                        int o = userScreen.getNumOfListRows();
                        do {
                            if(i < o){
                                try{
                                    userScreen.setSelectedRowColumnList(i, 0);
                                    if(getLastUserUpd().equals(userScreen.getSelectedUserListId())){
                                        fillFields(
                                            "SELECT *\n" +
                                            "FROM " + getDbOwner() + "." + getTblUser() + "\n" +
                                            "WHERE ROW_ID = '" + getLastUserUpd() + "'"
                                        );
                                        foundRow = false;
                                    }
                                } catch(Exception e){
                                    foundRow = false;
                                }
                            } else {
                                foundRow = false;
                            }
                            i++;
                        } while(foundRow);
                        userScreen.setFocus("FILTRO_VALOR");
                    }
                } else {
                    if(validateUser()) {
                        if(insert()){
                            userScreen.enableFields("SALVAR");
                            openUserScreen("USER", "SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblUser() + " USR\nORDER BY USR.FST_NAME ASC");

                            boolean foundRow = true;
                            int i = 0;
                            int o = userScreen.getNumOfListRows();
                            do {
                                if(i < o){
                                    try{
                                        userScreen.setSelectedRowColumnList(i, 0);
                                        if(getLastUserAdd().equals(userScreen.getSelectedUserListId())){
                                            fillFields(
                                                "SELECT *\n" +
                                                "FROM " + getDbOwner() + "." + getTblUser() + "\n" +
                                                "WHERE ROW_ID = '" + getLastUserAdd() + "'"
                                            );
                                            foundRow = false;
                                        }
                                    } catch(Exception e){
                                        foundRow = false;
                                    }
                                } else {
                                    foundRow = false;
                                }
                                i++;
                            } while(foundRow);
                            userScreen.setFocus("FILTRO_VALOR");
                        }
                    }
                }
                try{
                    cont.getContRowIdArray().clear();
                } catch (Exception e) {}
                try{
                    addr.getAddressRowIdArray().clear();
                } catch (Exception e) {}                
            } catch (Exception e) {
                System.out.println(getDateTime() + "\tContactModule.ContactController\t\tSaveContact\tInsertUpdateContact\tError Exception\tError: " + e);
            }
        }
    }
    
    private class buttonEdit implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            userScreen.enableFields("EDITAR");
            userScreen.setFocus("USUARIO");
        }
    }
    
    private class buttonNew implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            userScreen.enableFields("NOVO");
            userScreen.clearFields();
            fillFieldsNewRecord();
            userScreen.setFocus("USUARIO");
        }
    }
    
    private class buttonSave implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            save();
        }
    }
    
    private class buttonCancel implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            userScreen.enableFields("CANCELAR");
            if(!"".equals(userScreen.getSelectedUserListId()) && userScreen.getSelectedUserListId() != null){
                fillFields(
                    "SELECT *\n" +
                    "FROM " + getDbOwner() + "." + getTblUser()+ " USR\n" +
                    "WHERE USR.ROW_ID = '" + userScreen.getSelectedUserListId() + "'"
                );
            } else {
                userScreen.clearFields();
            }
            userScreen.setFocus("FILTRO_VALOR");
        }
    }
    
    private class buttonDelete implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if(delete()){
                userScreen.enableFields("DELETAR");
                openUserScreen("USER", "SELECT *\nFROM " + getDbOwner() + "." + getTblUser() + " USR\nORDER BY USR.FST_NAME ASC");
                userScreen.setFocus("FILTRO_VALOR");
            } else {
                userScreen.enableFields("CANCELAR");
                if(!"".equals(userScreen.getSelectedUserListId()) && userScreen.getSelectedUserListId() != null){
                    fillFields("SELECT *\nFROM " + getDbOwner() + "." + getTblUser()+ " USR\nWHERE USR.ROW_ID = '" + userScreen.getSelectedUserListId() + "'");
                } else {
                    userScreen.clearFields();
                }
                userScreen.setFocus("FILTRO_VALOR");
            }
        }
    }
    
    private class manageContact implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            String condition = "";
            try{
                // This Array is cleaned everytime when user is saved
                if(cont.getContRowIdArray().size() > 0) {
                    for(int i = 0; i < cont.getContRowIdArray().size(); i++) {
                        if(i != cont.getContRowIdArray().size() - 1){
                            condition += "'" + cont.getContRowIdArray().get(i).getRow_id() + "',\n\t";
                        } else {
                            condition += "'" + cont.getContRowIdArray().get(i).getRow_id() + "'\n";
                        }
                    }
                } else {
                    try {
                        cont = new ContactController();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } catch (Exception e) {
                try {
                    cont = new ContactController();                    
                } catch (InterruptedException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            cont.setDbUser(getUser());
            cont.setDbPassword(getPassword());
            cont.clearVariables();
            cont.setOpenFromScreen("USER");
            cont.setUserId(userScreen.gettxtRowId());
            cont.openContactScreen("SELECT *\nFROM " + getDbOwner() + "." + getTblContact() + " CON\nWHERE CON.PAR_ROW_ID = '" + userScreen.gettxtRowId() + "'" + ((!"".equals(condition)) ? "\nOR ROW_ID IN (\n\t" + condition + ")\n" : "\n") + "ORDER BY CON.FST_NAME ASC","NEW_USER_CONTACT");
            cont.setListenerConMgrScreen(new contactScreenListener());
            //cont.setContactScrenOpen(true);
            userScreen.setEnabled(false);
            
        }
    }
    
    private class manageAddress implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            String condition = "";
            try{
                // This Array is cleaned everytime when user is saved
                if(addr.getAddressRowIdArray().size() > 0){
                    for(int i = 0; i < addr.getAddressRowIdArray().size(); i++) {
                        if(i != addr.getAddressRowIdArray().size() - 1){
                            condition += "'" + addr.getAddressRowIdArray().get(i).getRow_id() + "',\n\t";
                        } else {
                            condition += "'" + addr.getAddressRowIdArray().get(i).getRow_id() + "'\n";
                        }
                    }
                } else {
                    try {
                        addr = new addressController();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } catch (Exception e) {
                try {
                    addr = new addressController();
                } catch (InterruptedException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            addr.setDbUser(getUser());
            addr.setDbPassword(getPassword());
            addr.setOpenFromScreen("USER");
            addr.setUserId(userScreen.gettxtRowId());        
            addr.openAddressScreen("SELECT *\nFROM " + getDbOwner() + "." + getTblAddress() + " ADDR\nWHERE ADDR.PAR_ROW_ID = '" + userScreen.gettxtRowId() + "'" + ((!"".equals(condition)) ? "\nOR ROW_ID IN (\n\t" + condition + ")\n" : "\n") + "ORDER BY ADDR.ROW_ID ASC", "NEW_USER_ADDRESS");
            addr.setListenerAddressScreen(new addressScreenListener());
            userScreen.setEnabled(false);
        }
    }
    
    private class viewUserPermitions implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if(viewUserPermitions(userScreen.getcbbPosition())){
                userScreen.setEnabled(false);
            } else {
                userScreen.setEnabled(true);
                userScreen.setVisible(true);
            }
        }
    }
    
    private class clickLoginButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if(!"".equals(loginScreen.getUser()) && loginScreen.getUser() != null){
                if(!"".equals(loginScreen.getPassword()) && loginScreen.getPassword() != null){
                    setDbUser(loginScreen.getUser());
                    setDbPassword(loginScreen.getPassword());
                    setUser(loginScreen.getUser());
                    setPassword(loginScreen.getPassword());
                    if(readParameters()){
                        if(tryLogin()){
                            loginScreen.dispose();
                        }
                    }
                }
            }
        }
    }
    
    private class CbbListFilterItemState implements java.awt.event.ItemListener {

        @Override
        public void itemStateChanged(ItemEvent ie) {
            if(ie.getStateChange() == ItemEvent.SELECTED){
                if(userScreen.getcbbListFilter() == null) {
                    userScreen.cleartxtListFilterValue();
                }
                userScreen.setFocus("FILTRO_VALOR");
            }
        }
        
    }
    
    private class TxtListFilterValue implements java.awt.event.KeyListener {

        @Override
        public void keyTyped(KeyEvent ke) { }

        @Override
        public void keyPressed(KeyEvent ke) {
            if(ke.getKeyCode() == KeyEvent.VK_ENTER){
                userScreen.unselectRowList();
                if(userScreen.getcbbListFilter() != null && userScreen.gettxtListFilterValue() != null) {
                    fillList(
                        "SELECT *\n" +
                        "FROM " + getDbOwner() + "." + getTblUser() + " USR\n" +
                        "WHERE " + processFilterCondition(userScreen.getcbbListFilter(), userScreen.gettxtListFilterValue(), "USER_FILTER", "USR") +
                        "ORDER BY USR.FST_NAME ASC"
                    );
                } else {
                    fillList("SELECT *\nFROM " + getDbOwner() + "." + getTblUser() + " USR\nORDER BY USR.FST_NAME ASC");
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent ke) { }
        
    }
    
    private class userListSelected implements ListSelectionListener {
        
        private int count;

        private userListSelected() {
            this.count = 0;
        }
        
        @Override
        public void valueChanged(ListSelectionEvent lse) {
            if(count < 1){
                userScreen.clearFields();
                fillFields("SELECT * FROM " + getDbOwner() + "." + getTblUser() + " WHERE ROW_ID = '" + userScreen.getSelectedUserListId() + "'");
                userScreen.setbtnEditUserEnabled(true);
                userScreen.setbtnDeleteEnabled(true);
                count++;
            } else {
                count = 0;
            }
        }
        
    }
    
    private class contactScreenListener implements WindowListener {

        @Override
        public void windowOpened(WindowEvent we) { }

        @Override
        public void windowClosing(WindowEvent we) { }

        @Override
        public void windowClosed(WindowEvent we) {
            userScreen.setEnabled(true);
            userScreen.setVisible(true);
        }

        @Override
        public void windowIconified(WindowEvent we) { }

        @Override
        public void windowDeiconified(WindowEvent we) { }

        @Override
        public void windowActivated(WindowEvent we) { }

        @Override
        public void windowDeactivated(WindowEvent we) { }
        
    }

    private class addressScreenListener implements WindowListener {

        @Override
        public void windowOpened(WindowEvent we) { }

        @Override
        public void windowClosing(WindowEvent we) { }

        @Override
        public void windowClosed(WindowEvent we) {
            userScreen.setEnabled(true);
            userScreen.setVisible(true);
        }

        @Override
        public void windowIconified(WindowEvent we) { }

        @Override
        public void windowDeiconified(WindowEvent we) { }

        @Override
        public void windowActivated(WindowEvent we) { }

        @Override
        public void windowDeactivated(WindowEvent we) { }
        
    }
    
    private class userPermitionScreenListener implements WindowListener {

        @Override
        public void windowOpened(WindowEvent we) { }

        @Override
        public void windowClosing(WindowEvent we) { }

        @Override
        public void windowClosed(WindowEvent we) {
            userScreen.setEnabled(true);
            userScreen.setVisible(true);
        }

        @Override
        public void windowIconified(WindowEvent we) { }

        @Override
        public void windowDeiconified(WindowEvent we) { }

        @Override
        public void windowActivated(WindowEvent we) { }

        @Override
        public void windowDeactivated(WindowEvent we) { }
        
    }
    
    private class userRowIdClass {
        private String row_id;
        
        public userRowIdClass() { this.row_id = null; }

        public String getRow_Id() {
            return row_id;
        }

        public void setRow_Id(String row_id) {
            this.row_id = row_id;
        }
        
        
    }
}
