/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userModule;

import contactModule.contactController;
import databaseModule.DataController;
import java.awt.HeadlessException;
import settingsModule.DbSettingsController;
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
    UserManagementScreen umScreen;
    contactController cont;
    
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
    
    public void openLoginScreen(){
        loginScreen = new UserLoginScreen();
        loginScreen.addWindowListener(new windowListenerLScreen());
        loginScreen.setListenerLogin(new loginLScreen());
    }
    
    public void openUMScreen(){
        umScreen = new UserManagementScreen();
        umScreen.setListenerBtnEditUser(new editUserUMScreen());
        umScreen.setListenerBtnNewUser(new newUserUMScreen());
        umScreen.setListenerBtnSaveUser(new saveUserUMScreen());
        umScreen.setListenerBtnCancelUser(new cancelUserUMScreen());
        umScreen.setListenerBtnAddAddress(new addUserAddressUMScreen());
        umScreen.setListenerBtnPermitions(new viewUserPermitionsUMScreen());
        umScreen.setListenerBtnAddContact(new addUserContactUMScreen());
        umScreen.setListenerTblUserListSelection(new userListSelectedUMScreen());
        
        umScreen.clearFields();
        umScreen.clearComboBoxes();
        umScreen.enableFields("LOAD_SCREEN");
        umScreen.insertSelectComboBox();
        this.fillComboBoxesUMScreen("POSITION_TYPE");
        this.fillComboBoxesUMScreen("DOC_TYPE");
        this.fillComboBoxesUMScreen("SEX_MF");
        this.fillComboBoxesUMScreen("MONTH_DAY");
        this.fillComboBoxesUMScreen("MONTH");
        this.fillComboBoxesUMScreen("CIVIL_STATE");
        this.fillComboBoxesUMScreen("DOCUMENT_TYPE");
        this.fillComboBoxesUMScreen("STATE");
        this.fillUserListUMScreen(
            "SELECT *\n" +
            "FROM " + super.getDbOwner() + "." + super.getTblUser() + " USR\n" +
            "ORDER BY USR.FST_NAME ASC"
        );
        umScreen.setFocus("FILTRO_VALOR");
    }
    
    private boolean tryLoginLScreen(){
        try{
            System.out.println("Testando conexão..."); // Teste de conexão
            String result = super.openConnection("Realizando Login");
            if("true".equals(result)){
                super.closeConnection("Conexão testada com sucesso!");
                this.setFirstSettingsOK(true);
                return true;
            } else {
                if("java.sql.SQLRecoverableException: IO Error: The Network Adapter could not establish the connection\n".equals(result)){
                    loginScreen.setErrorArea("Erro ao tentar realizar conexão com o Banco de dados. Verifique se o listener está ativo.");
                } else if("ORA-12505: TNS: listener does not currently know of SID given in connect descriptor tips\n".equals(result)) {
                    loginScreen.setErrorArea("O Listener não identificou o SID utilizado no descritor de conexão.");
                } else if("java.sql.SQLRecoverableException: Erro de ES: The Network Adapter could not establish the connection\n".equals(result)){
                    loginScreen.setErrorArea("Erro ao tentar realizar conexão com o Banco de dados. Verifique se o listener está ativo.");
                } else if("ORA-12505, TNS:listener does not currently know of SID given in connect descriptor\n".equals(result)) {
                    loginScreen.setErrorArea("O Listener não identificou o SID utilizado no descritor de conexão.");
                } else if("java.sql.SQLException: ORA-01017: senha/nome do usuário inválido; log-on negado\n".contains(result)){
                    loginScreen.setErrorArea("Nome de usuário/senha incorreto. Tente novamente.");
                } else if("java.sql.SQLRecoverableException: Erro de ES: Unknown host specified ".equals(result)){
                    loginScreen.setErrorArea("Erro ao tentar realizar conexão com o Banco de dados. Verifique o Host.");                
                } else {
                    super.wishConfDbLScreen();
                }
                return false;
            }
        } catch(Exception e){
            super.wishConfDbLScreen();
            return false;
        }
    }
    
    private void fillUserListUMScreen(String query){
        int countRecord = 0;
        try{
            ArrayList<UserClass> userList = super.queryUserRecord(query);
            ArrayList<PositionClass> positionList;
                    
            DefaultTableModel table = (DefaultTableModel) umScreen.getTableModel();
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
                        "WHERE PAR_ROW_ID = '" + userList.get(i).getRow_id() + "'"
                    );
                    table.setValueAt(positionList.get(0).getNAME(), i, 6);
                    table.setValueAt(userList.get(i).getSTATUS_CD(), i, 7);
                    
                    countRecord++;
                }
            }
            
            umScreen.setlblRecCount(String.valueOf(countRecord));
            
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher tabela...\nErro: " + e);
        }
    }
    
    private void fillFieldsUMScreen(String query){
        try{
            ArrayList<UserClass> userList = queryUserRecord(query);
            ArrayList<PositionClass> positionList;
            ArrayList<ContactClass> ContactList;
            ArrayList<ContactXClass> ContactXList;
            ArrayList<AddressClass> AddressList;
            
            if(userList.size() > 0){
                for(int i = 0; i < userList.size(); i++){
                    umScreen.setlblUserNameHeader(userList.get(i).getFULL_NAME());
                    umScreen.settxtRowId(userList.get(i).getRow_id());
                    umScreen.settxtUser(userList.get(i).getLOGIN());
                    umScreen.settxtPass(userList.get(i).getPASSWORD());
                    umScreen.settxtPassVerification(userList.get(i).getPASSWORD());
                    
                    // Position Information
                    positionList = super.queryPositionRecord("SELECT * FROM " + super.getDbOwner() + "." + super.getTblPosition() + " WHERE PAR_ROW_ID = '" + userList.get(i).getRow_id() + "'");
                    for(int p = 0; p < positionList.size(); p++) {
                        umScreen.setcbbPositionItemIndex(umScreen.getcbbPositionItemIndex(positionList.get(p).getNAME()));
                    }
                    
                    umScreen.settxtSecQuestion1(userList.get(i).getCHALLENGE_QUESTION_1());
                    umScreen.settxtSecAnswer1(userList.get(i).getCHALLENGE_ANSWER_1());
                    umScreen.settxtSecQuestion2(userList.get(i).getCHALLENGE_QUESTION_2());
                    umScreen.settxtSecAnswer2(userList.get(i).getCHALLENGE_ANSWER_2());
                    umScreen.settxtSecQuestion3(userList.get(i).getCHALLENGE_QUESTION_3());
                    umScreen.settxtSecAnswer3(userList.get(i).getCHALLENGE_ANSWER_3());
                    umScreen.setcbbDocTypeItemIndex(umScreen.getcbbDocTypeItemIndex(userList.get(i).getDOC_TYPE()));
                    umScreen.settxtDocNum(userList.get(i).getDOC_NUM());
                    umScreen.settxtName(userList.get(i).getFST_NAME());
                    umScreen.settxtSurname(userList.get(i).getLAST_NAME());
                    umScreen.settxtNickName(userList.get(i).getNICK_NAME());
                    umScreen.setcbbSexItemIndex(umScreen.getcbbSexItemIndex(userList.get(i).getSEX_MF()));
                    if (!"".equals(userList.get(i).getBIRTH_DT()) && userList.get(i).getBIRTH_DT() != null) {
                        umScreen.setcbbDayItemIndex(umScreen.getcbbDayItemIndex(super.LookupValue("MONTH_DAY", userList.get(i).getBIRTH_DT().substring(0, 2))));
                        umScreen.setcbbMonthItemIndex(umScreen.getcbbMonthItemIndex(super.LookupValue("MONTH", userList.get(i).getBIRTH_DT().substring(3, 5))));
                        umScreen.settxtYear(userList.get(i).getBIRTH_DT().substring(6, 10));
                    }
                    umScreen.settxtBornLocation(userList.get(i).getPLACE_OF_BIRTH());
                    umScreen.setcbbCivilStateItemIndex(umScreen.getcbbCivilStateItemIndex(userList.get(i).getMARITAL_STAT_CD()));
                    umScreen.settxtSpouseName(userList.get(i).getNAME_CONJUGE());
                    umScreen.settxtMotherName(userList.get(i).getMOTHER_FULL_NAME());
                    umScreen.settxtFatherName(userList.get(i).getFATHER_FULL_NAME());
                    umScreen.setcbbIdentityTypeItemIndex(umScreen.getcbbIdentityTypeItemIndex(userList.get(i).getIDENTITY_DOC_TYPE()));
                    umScreen.settxtRecNum(userList.get(i).getREGISTER_NUM());
                    umScreen.settxtSerieNum(userList.get(i).getREGISTER_SERIE());
                    umScreen.settxtEmissor(userList.get(i).getORGAO_EMISSOR());
                    umScreen.setcbbEmissionUFItemIndex(umScreen.getcbbEmissionUFItemIndex(userList.get(i).getUF_EMISSAO()));
                    if (!"".equals(userList.get(i).getEMISSION_DT()) && userList.get(i).getEMISSION_DT() != null) {
                        umScreen.settxtEmissionDate(userList.get(i).getEMISSION_DT());
                    }
                    if (!"".equals(userList.get(i).getVALIDATION_DT()) && userList.get(i).getVALIDATION_DT() != null) {
                        umScreen.settxtValidThru(userList.get(i).getVALIDATION_DT());
                    }
                    umScreen.settxtNationality(userList.get(i).getNATIONALITY());
                    umScreen.settxtNaturalness(userList.get(i).getNATURALNESS());

                    // Contact Information
                    ContactList = super.queryContactRecord("SELECT * FROM " + super.getDbOwner() + "." + super.getTblContact() + " WHERE (PAR_ROW_ID = '" + userList.get(i).getRow_id() + "' OR PAR_USR_ID = '" + userList.get(i).getRow_id() + "') AND PR_CON_FLG = 'Y'");
                    for(int c = 0; c < ContactList.size(); c++) {
                        umScreen.settxtContactMPhone(ContactList.get(c).getMAIN_PH_NUM());
                        umScreen.settxtContactEmail(ContactList.get(c).getEMAIL_ADDR());
                        umScreen.settxtContactPhone(ContactList.get(c).getALT_PH_NUM());
                        umScreen.settxtContactEnterprise(ContactList.get(c).getWORK_PH_NUM());
                    }
                    // Social Media Information
                    ContactXList = super.queryContactXRecord("SELECT * FROM " + super.getDbOwner() + "." + super.getTblContactX()+ " WHERE PAR_ROW_ID = '" + ContactList.get(i).getRow_id() + "' AND PAR_USR_ID = '" + userList.get(i).getRow_id() + "'");
                    for(int cx = 0; cx < ContactXList.size(); cx++) {
                        if(null != ContactXList.get(cx).getSOCIAL_M_NAME()) {
                            switch (ContactXList.get(cx).getSOCIAL_M_NAME()) {
                                case "Facebook":
                                    umScreen.settxtFacebook(ContactXList.get(cx).getSOCIAL_M_VALUE());
                                    break;
                                case "Twitter":
                                    umScreen.settxtTwitter(ContactXList.get(cx).getSOCIAL_M_VALUE());
                                    break;
                                case "Instagram":
                                    umScreen.settxtInstagram(ContactXList.get(cx).getSOCIAL_M_VALUE());
                                    break;
                                default:
                                    break;
                            }
                        }
                    }
                    
                    // Address Information
                    AddressList = super.queryAddressRecord("SELECT * FROM " + super.getDbOwner() + "." + super.getTblAddress() + " WHERE PAR_ROW_ID = '" + userList.get(i).getRow_id() +  "' AND PR_ADDR_FLG = 'Y'");
                    for(int a = 0; a < AddressList.size(); a++) {
                        umScreen.settxtFullAddress(AddressList.get(a).getADDR_NAME());
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
                            umScreen.setcbbPosition(lov.get(i).getValue());
                            break;
                        case "DOC_TYPE":
                            umScreen.setcbbDocType(lov.get(i).getValue());
                            break;
                        case "SEX_MF":
                            umScreen.setcbbSex(lov.get(i).getValue());
                            break;
                        case "MONTH_DAY":
                            umScreen.setcbbDay(lov.get(i).getValue());
                            break;
                        case "MONTH":
                            umScreen.setcbbMonth(lov.get(i).getValue());
                            break;
                        case "CIVIL_STATE":
                            umScreen.setcbbCivilState(lov.get(i).getValue());
                            break;
                        case "DOCUMENT_TYPE":
                            umScreen.setcbbIdentityType(lov.get(i).getValue());
                            break;
                        case "STATE":
                            umScreen.setcbbEmissionUF(lov.get(i).getValue());
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
    
    private class editUserUMScreen implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            umScreen.enableFields("EDITAR");
            umScreen.setFocus("USUARIO");
        }
    }
    
    private class newUserUMScreen implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            umScreen.enableFields("NOVO");
            umScreen.clearFields();
            umScreen.setFocus("USUARIO");
        }
    }
    
    private class saveUserUMScreen implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            umScreen.enableFields("SALVAR");
            umScreen.clearFields();
            umScreen.setFocus("FILTRO_VALOR");
        }
    }
    
    private class cancelUserUMScreen implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            umScreen.enableFields("CANCELAR");
            umScreen.setFocus("FILTRO_VALOR");
        }
    }
    
    private class addUserContactUMScreen implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                cont = new contactController();
                
                cont.setDbUser(getUser());
                cont.setDbPassword(getPassword());
                cont.clearVariables();
                cont.setOpenFromScreen("USER");
                cont.setUserId(umScreen.gettxtRowId());
                
                cont.openContactScreen(
                    "SELECT *\n" +
                    "FROM " + getDbOwner() + "." + getTblContact() + " CON\n" +
                    "WHERE CON.PAR_ROW_ID = '" + umScreen.gettxtRowId() + "'\n" +
                    "ORDER BY CON.FST_NAME ASC"
                );
                cont.setListenerConMgrScreen(new contactScreenListener());
                umScreen.setEnabled(false);
            } catch (InterruptedException ex) {
                Logger.getLogger(userController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
    private class addUserAddressUMScreen implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
    private class viewUserPermitionsUMScreen implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
    private class windowListenerLScreen implements WindowListener {

        @Override
        public void windowOpened(WindowEvent we) {
            setLoginOK(false);
        }

        @Override
        public void windowClosing(WindowEvent we) { }

        @Override
        public void windowClosed(WindowEvent we) {
            setLoginOK(true);
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
    
    private class loginLScreen implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if(!"".equals(loginScreen.getUser()) && loginScreen.getUser() != null){
                if(!"".equals(loginScreen.getPassword()) && loginScreen.getPassword() != null){
                    setDbUser(loginScreen.getUser());
                    setDbPassword(loginScreen.getPassword());
                    setUser(loginScreen.getUser());
                    setPassword(loginScreen.getPassword());
                    if(readParameters()){
                        if(tryLoginLScreen()){
                            loginScreen.dispose();
                        }
                    }
                }
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
            umScreen.setEnabled(true);
            umScreen.setVisible(true);
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
    
    private class userListSelectedUMScreen implements ListSelectionListener {
        
        private int count;

        private userListSelectedUMScreen() {
            this.count = 0;
        }
        
        @Override
        public void valueChanged(ListSelectionEvent lse) {
            if(count < 1){
                umScreen.clearFields();
                fillFieldsUMScreen("SELECT * FROM " + getDbOwner() + "." + getTblUser() + " WHERE ROW_ID = '" + umScreen.getSelectedUserListId() + "'");
                umScreen.setbtnEditUserEnabled(true);
                count++;
            } else {
                count = 0;
            }
        }
        
    }
}
