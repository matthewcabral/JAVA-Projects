/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userModule;

import addressModule.addressController;
import contactModule.contactController;
import databaseModule.DataController;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
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
public class userController extends DataController {
    UserLoginScreen loginScreen;
    UserScreen userScreen;
    UserPermitionScreen permScreen;
    contactController cont;
    addressController addr;
    
    private String user;
    private String password;
    private boolean firstSettingsOK = false;
    private boolean loginOK = false;
        
    public userController() throws InterruptedException {}

    public String getUser() { return user; }
    public void setUser(String user) { this.user = user; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    
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
    
    public void openUserScreen(String screen){
        if("MAIN".equals(screen)) {
            userScreen = new UserScreen();
            userScreen.setListenerBtnEditUser(new editUser());
            userScreen.setListenerBtnNewUser(new newUser());
            userScreen.setListenerBtnSaveUser(new saveUser());
            userScreen.setListenerBtnCancelUser(new cancelUser());
            userScreen.setListenerBtnDelete(new deleteUser());
            userScreen.setListenerBtnAddAddress(new manageAddress());
            userScreen.setListenerBtnPermitions(new viewUserPermitions());
            userScreen.setListenerBtnAddContact(new manageContact());
            userScreen.setListenerTblUserListSelection(new userListSelected());
        }
        
        userScreen.clearFields();
        userScreen.clearComboBoxes();
        userScreen.enableFields("LOAD_SCREEN");
        userScreen.insertSelectComboBox();
        this.fillComboBoxesUMScreen("POSITION_TYPE");
        this.fillComboBoxesUMScreen("DOC_TYPE");
        this.fillComboBoxesUMScreen("SEX_MF");
        this.fillComboBoxesUMScreen("MONTH_DAY");
        this.fillComboBoxesUMScreen("MONTH");
        this.fillComboBoxesUMScreen("CIVIL_STATE");
        this.fillComboBoxesUMScreen("DOCUMENT_TYPE");
        this.fillComboBoxesUMScreen("STATE");
        this.fillListUserScreen(
            "SELECT *\n" +
            "FROM " + super.getDbOwner() + "." + super.getTblUser() + " USR\n" +
            "ORDER BY USR.FST_NAME ASC"
        );
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
                } else if(result.contains("java.sql.SQLException: ORA-01017")){
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
    
    private void fillListUserScreen(String query){
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
    
    private void fillFieldsUserScreen(String query){
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
                    userScreen.settxtUser(userList.get(i).getLOGIN());
                    userScreen.settxtPass(userList.get(i).getPASSWORD());
                    userScreen.settxtPassVerification(userList.get(i).getPASSWORD());
                    
                    // Position Information
                    positionList = super.queryPositionRecord("SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblPosition() + "\nWHERE ROW_ID = '" + userList.get(i).getPAR_POSTN_ID() + "'");
                    if(positionList.size() > 0) {
                        for(int p = 0; p < positionList.size(); p++) {
                            userScreen.setcbbPositionItemIndex(userScreen.getcbbPositionItemIndex(positionList.get(p).getNAME()));
                        }
                    }
                    
                    userScreen.settxtSecQuestion1(userList.get(i).getCHALLENGE_QUESTION_1());
                    userScreen.settxtSecAnswer1(userList.get(i).getCHALLENGE_ANSWER_1());
                    userScreen.settxtSecQuestion2(userList.get(i).getCHALLENGE_QUESTION_2());
                    userScreen.settxtSecAnswer2(userList.get(i).getCHALLENGE_ANSWER_2());
                    userScreen.settxtSecQuestion3(userList.get(i).getCHALLENGE_QUESTION_3());
                    userScreen.settxtSecAnswer3(userList.get(i).getCHALLENGE_ANSWER_3());
                    userScreen.setcbbDocTypeItemIndex(userScreen.getcbbDocTypeItemIndex(userList.get(i).getDOC_TYPE()));
                    userScreen.settxtDocNum(userList.get(i).getDOC_NUM());
                    userScreen.settxtName(userList.get(i).getFST_NAME());
                    userScreen.settxtSurname(userList.get(i).getLAST_NAME());
                    userScreen.settxtNickName(userList.get(i).getNICK_NAME());
                    userScreen.setcbbSexItemIndex(userScreen.getcbbSexItemIndex(userList.get(i).getSEX_MF()));
                    if (!"".equals(userList.get(i).getBIRTH_DT()) && userList.get(i).getBIRTH_DT() != null) {
                        userScreen.setcbbDayItemIndex(userScreen.getcbbDayItemIndex(super.LookupValue("MONTH_DAY", userList.get(i).getBIRTH_DT().substring(0, 2))));
                        userScreen.setcbbMonthItemIndex(userScreen.getcbbMonthItemIndex(super.LookupValue("MONTH", userList.get(i).getBIRTH_DT().substring(3, 5))));
                        userScreen.settxtYear(userList.get(i).getBIRTH_DT().substring(6, 10));
                    }
                    userScreen.settxtBornLocation(userList.get(i).getPLACE_OF_BIRTH());
                    userScreen.setcbbCivilStateItemIndex(userScreen.getcbbCivilStateItemIndex(userList.get(i).getMARITAL_STAT_CD()));
                    userScreen.settxtSpouseName(userList.get(i).getNAME_CONJUGE());
                    userScreen.settxtMotherName(userList.get(i).getMOTHER_FULL_NAME());
                    userScreen.settxtFatherName(userList.get(i).getFATHER_FULL_NAME());
                    userScreen.setcbbIdentityTypeItemIndex(userScreen.getcbbIdentityTypeItemIndex(userList.get(i).getIDENTITY_DOC_TYPE()));
                    userScreen.settxtRecNum(userList.get(i).getREGISTER_NUM());
                    userScreen.settxtSerieNum(userList.get(i).getREGISTER_SERIE());
                    userScreen.settxtEmissor(userList.get(i).getORGAO_EMISSOR());
                    userScreen.setcbbEmissionUFItemIndex(userScreen.getcbbEmissionUFItemIndex(userList.get(i).getUF_EMISSAO()));
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
    
    private void fillComboBoxesUMScreen(String LovType){
        try{
            ArrayList<ListOfValuesClass> lov = super.LookupList(LovType);
            
            if(lov.size() > 0){
                for(int i = 0; i < lov.size(); i++){
                    if(null == LovType){
                        JOptionPane.showMessageDialog(null, "O LOV_TYPE 'null' não existe!");
                    } else switch (LovType) {
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
    
    public boolean insertUser(){
        return true;
    }
    
    public boolean updateUser(){
        return true;
    }
    
    public boolean deleteUser(){
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
                        cont.updateArrayAfterDelete("CONTACT");
                    }
                }
                
                super.clearCondition();
                
                super.setCondition("PAR_ROW_ID = '" + userScreen.gettxtRowId() + "'");
                super.setCondition("\nAND PAR_USR_ID = '" + userScreen.gettxtRowId() + "'");
                
                countContact = super.deleteRecord(super.getTblContact(), super.getCondition());
                
                if(countContact > 0){
                    cont.updateArrayAfterDelete("CONTACT");
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
    
    private class editUser implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            userScreen.enableFields("EDITAR");
            userScreen.setFocus("USUARIO");
        }
    }
    
    private class newUser implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            userScreen.enableFields("NOVO");
            userScreen.clearFields();
            userScreen.setFocus("USUARIO");
        }
    }
    
    private class saveUser implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if(validateFields() && validatePassword() && validateUser()){
                userScreen.enableFields("SALVAR");
                if(!"".equals(userScreen.getSelectedUserListId()) && userScreen.getSelectedUserListId() != null){
                    fillFieldsUserScreen("SELECT *\n" +
                        "FROM " + getDbOwner() + "." + getTblUser()+ " USR\n" +
                        "WHERE USR.ROW_ID = '" + userScreen.getSelectedUserListId() + "'"
                    );
                } else {
                    userScreen.clearFields();
                }
                userScreen.setFocus("FILTRO_VALOR");
            }
        }
    }
    
    private class cancelUser implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            userScreen.enableFields("CANCELAR");
            if(!"".equals(userScreen.getSelectedUserListId()) && userScreen.getSelectedUserListId() != null){
                fillFieldsUserScreen("SELECT *\n" +
                    "FROM " + getDbOwner() + "." + getTblUser()+ " USR\n" +
                    "WHERE USR.ROW_ID = '" + userScreen.getSelectedUserListId() + "'"
                );
            } else {
                userScreen.clearFields();
            }
            userScreen.setFocus("FILTRO_VALOR");
        }
    }
    
    private class deleteUser implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if(deleteUser()){
                userScreen.enableFields("DELETAR");
                openUserScreen("USER");
            } else {
                userScreen.enableFields("CANCELAR");
                if(!"".equals(userScreen.getSelectedUserListId()) && userScreen.getSelectedUserListId() != null){
                    fillFieldsUserScreen("SELECT *\n" +
                        "FROM " + getDbOwner() + "." + getTblUser()+ " USR\n" +
                        "WHERE USR.ROW_ID = '" + userScreen.getSelectedUserListId() + "'"
                    );
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
            try {
                cont = new contactController();
                
                cont.setDbUser(getUser());
                cont.setDbPassword(getPassword());
                cont.clearVariables();
                cont.setOpenFromScreen("USER");
                cont.setUserId(userScreen.gettxtRowId());
                
                cont.openContactScreen(
                    "SELECT *\n" +
                    "FROM " + getDbOwner() + "." + getTblContact() + " CON\n" +
                    "WHERE CON.PAR_ROW_ID = '" + userScreen.gettxtRowId() + "'\n" +
                    "ORDER BY CON.FST_NAME ASC",
                    "NEW_USER_CONTACT"
                );
                
                cont.setListenerConMgrScreen(new contactScreenListener());
                userScreen.setEnabled(false);
            } catch (InterruptedException ex) {
                Logger.getLogger(userController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
    private class manageAddress implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                addr = new addressController();

                addr.setDbUser(getUser());
                addr.setDbPassword(getPassword());
                addr.setOpenFromScreen("USER");
                addr.setUserId(userScreen.gettxtRowId());

                addr.openAddressScreen(
                    "SELECT *\n" +
                    "FROM " + getDbOwner() + "." + getTblAddress() + " ADDR\n" +
                    "WHERE ADDR.PAR_ROW_ID = '" + userScreen.gettxtRowId() + "'\n" +
                    "ORDER BY ADDR.ROW_ID ASC",
                    "NEW_USER_ADDRESS"
                );
                
                addr.setListenerAddressScreen(new addressScreenListener());
                userScreen.setEnabled(false);
            } catch (InterruptedException ex) {
                Logger.getLogger(userController.class.getName()).log(Level.SEVERE, null, ex);
            }
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
    
    private class userListSelected implements ListSelectionListener {
        
        private int count;

        private userListSelected() {
            this.count = 0;
        }
        
        @Override
        public void valueChanged(ListSelectionEvent lse) {
            if(count < 1){
                userScreen.clearFields();
                fillFieldsUserScreen("SELECT * FROM " + getDbOwner() + "." + getTblUser() + " WHERE ROW_ID = '" + userScreen.getSelectedUserListId() + "'");
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
    
}
