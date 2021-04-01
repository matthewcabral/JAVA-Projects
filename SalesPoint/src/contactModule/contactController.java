/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactModule;

import databaseModule.DataController;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MatheusCabral
 */
public class contactController extends DataController {
    ContactManagementScreen conMgr;
    ContactSocialMediaManagementScreen socMedMgr;
    private ArrayList<contactRowId> contRowId;
    private ArrayList<contactXRowId> contXRowId;
    private String userId;
    private String accountId;
    private String openFromScreen;

    public contactController() throws InterruptedException {
        this.userId = null;
        this.accountId = null;
        this.openFromScreen = null;
    }

    public void setListenerConMgrScreen(WindowListener listener) { conMgr.addWindowListener(listener); }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getAccountId() { return accountId; }
    public void setAccountId(String accountId) { this.accountId = accountId; }

    public String getOpenFromScreen() { return openFromScreen; }
    public void setOpenFromScreen(String openFromScreen) { this.openFromScreen = openFromScreen; }
    
    public void clearVariables(){
        this.accountId = "";
        this.userId = "";
    }
    
    public ArrayList<contactRowId> getContRowId() { return contRowId; }
    public void setContRowId(ArrayList<contactRowId> contRowId) { this.contRowId = contRowId; }

    public ArrayList<contactXRowId> getContXRowId() { return contXRowId; }
    public void setContXRowId(ArrayList<contactXRowId> contXRowId) { this.contXRowId = contXRowId; }
    
    public void openContactScreen(String query){
        conMgr = new ContactManagementScreen();        
        conMgr.setListenerBtnAddSocialMedia(new openContactSocialMedia());
        conMgr.setListenerBtnCancelContact(new cancelContact());
        conMgr.setListenerBtnEditContact(new editContact());
        conMgr.setListenerBtnNewContact(new newContact());
        conMgr.setListenerBtnSaveContact(new saveContact());
        conMgr.setListenerTblContactListSelection(new contactListSelectedUMScreen());
        //conMgr.setListenerContactManagementScreen(new contactScreenListener());
        
        conMgr.clearFields();
        conMgr.clearComboBoxes();
        conMgr.enableFields("LOAD_SCREEN");
        conMgr.insertSelectComboBox();
        
        this.fillComboBoxesContactScreen("DOC_TYPE");
        this.fillComboBoxesContactScreen("SEX_MF");
        this.fillComboBoxesContactScreen("MONTH");
        this.fillComboBoxesContactScreen("MONTH_DAY");
        this.fillComboBoxesContactScreen("CIVIL_STATE");
        this.fillComboBoxesContactScreen("EMAIL_ADDR_TYPE");
        
        this.fillContactListScreen(query);
        conMgr.setFocus("FILTRO_VALOR");
    }

    private void fillContactListScreen(String query){
        int countRecord = 0;
        String subQueryContactX = "";
        String subQueryAddress = "";
        
        try{
            ArrayList<ContactClass> contList = super.queryContactRecord(query);
            ArrayList<ContactXClass> ContactXList;
            ArrayList<AddressClass> AddressList;
            
            DefaultTableModel table = (DefaultTableModel) conMgr.getTableModel();
            table.setRowCount(0);
            
            if(contList.size() > 0){
                table.setNumRows(contList.size());
                
                for(int i = 0; i < contList.size(); i++){
                    table.setValueAt(contList.get(i).getRow_id(), i, 0);
                    table.setValueAt(contList.get(i).getDOC_TYPE(), i, 1);
                    table.setValueAt(contList.get(i).getDOC_NUM(), i, 2);
                    table.setValueAt(contList.get(i).getFULL_NAME(), i, 3);
                    if("Y".equals(contList.get(i).getPR_CON_FLG())){
                        table.setValueAt(true, i, 4);
                    }
                    table.setValueAt(contList.get(i).getEMAIL_ADDR(), i, 5);
                    table.setValueAt(contList.get(i).getALT_PH_NUM(), i, 6);
                    if("Y".equals(contList.get(i).getWHATSAPP_FLG())){
                        table.setValueAt(true, i, 7);
                    }                    
                    table.setValueAt(contList.get(i).getMAIN_PH_NUM(), i, 8);
                    table.setValueAt(contList.get(i).getWORK_PH_NUM(), i, 9);
                    
                    if(this.getOpenFromScreen() != null && !"".equals(this.getOpenFromScreen())){
                        switch(this.getOpenFromScreen()){
                            case "USER":
                                subQueryContactX = "SELECT * FROM " + super.getDbOwner() + "." + super.getTblContactX()+ " WHERE PAR_ROW_ID = '" + contList.get(i).getRow_id() + "' AND PAR_USR_ID = '" + this.getUserId() + "'";
                                subQueryAddress = "SELECT * FROM " + super.getDbOwner() + "." + super.getTblAddress() + " WHERE PAR_ROW_ID = '" + getUserId() +  "' AND PR_ADDR_FLG = 'Y'";
                                break;
                            default:
                                break;
                        }
                    }
                    
                    // Social Media Information
                    ContactXList = super.queryContactXRecord(subQueryContactX);
                    for(int cx = 0; cx < ContactXList.size(); cx++) {
                        if(null != ContactXList.get(cx).getSOCIAL_M_NAME()) {
                            switch (ContactXList.get(cx).getSOCIAL_M_NAME()) {
                                case "Facebook":
                                    table.setValueAt(ContactXList.get(cx).getSOCIAL_M_VALUE(), i, 10);
                                    break;
                                case "Twitter":
                                    table.setValueAt(ContactXList.get(cx).getSOCIAL_M_VALUE(), i, 11);
                                    break;
                                case "Instagram":
                                    table.setValueAt(ContactXList.get(cx).getSOCIAL_M_VALUE(), i, 12);
                                    break;
                                default:
                                    break;
                            }
                        }
                    }
                    table.setValueAt(contList.get(i).getFAX_PH_NUM(), i, 13);
                    // Address Information
                    AddressList = super.queryAddressRecord(subQueryAddress);
                    for(int a = 0; a < AddressList.size(); a++) {
                        table.setValueAt(AddressList.get(a).getADDR_TYPE_CD() + " " + AddressList.get(a).getADDR(), i, 14);
                        table.setValueAt(AddressList.get(a).getADDR_NUM(), i, 15);
                        table.setValueAt(AddressList.get(a).getNEIGHBORHOOD(), i, 16);
                        table.setValueAt(AddressList.get(a).getCITY(), i, 17);
                        table.setValueAt(AddressList.get(a).getSTATE(), i, 18);
                    }
                    
                    countRecord++;
                }
            }
            
            conMgr.setlblRecCount(String.valueOf(countRecord));
            
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher tabela...\nErro: " + e);
        }
    }
    
    private void fillFieldsContactScreen(String query){
        String subQueryContactX = "";
        try{
            ArrayList<ContactClass> contList = super.queryContactRecord(query);
            //ArrayList<UserClass> userList = queryUserRecord(query);
            ArrayList<ContactXClass> ContactXList;
            
            if(contList.size() > 0){
                for(int i = 0; i < contList.size(); i++){
                    conMgr.setlblContactNameHeader(contList.get(i).getFULL_NAME());
                    conMgr.settxtRowId(contList.get(i).getRow_id());
                    conMgr.settxtContactMPhone(contList.get(i).getMAIN_PH_NUM());
                    conMgr.settxtContactPhone(contList.get(i).getALT_PH_NUM());
                    conMgr.settxtContactEnterprise(contList.get(i).getWORK_PH_NUM());
                    
                    /*conMgr.settxtSecQuestion1(contList.get(i).getCHALLENGE_QUESTION_1());
                    conMgr.settxtSecAnswer1(contList.get(i).getCHALLENGE_ANSWER_1());
                    conMgr.settxtSecQuestion2(contList.get(i).getCHALLENGE_QUESTION_2());
                    conMgr.settxtSecAnswer2(contList.get(i).getCHALLENGE_ANSWER_2());
                    conMgr.settxtSecQuestion3(contList.get(i).getCHALLENGE_QUESTION_3());
                    conMgr.settxtSecAnswer3(contList.get(i).getCHALLENGE_ANSWER_3());
                    conMgr.setcbbDocTypeItemIndex(contList.getcbbDocTypeItemIndex(userList.get(i).getDOC_TYPE()));
                    conMgr.settxtDocNum(contList.get(i).getDOC_NUM());
                    conMgr.settxtName(contList.get(i).getFST_NAME());
                    conMgr.settxtSurname(contList.get(i).getLAST_NAME());
                    conMgr.settxtNickName(contList.get(i).getNICK_NAME());
                    conMgr.setcbbSexItemIndex(contList.getcbbSexItemIndex(userList.get(i).getSEX_MF()));
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

                    */
                    // Social Media Information
                    
                    if(this.getOpenFromScreen() != null && !"".equals(this.getOpenFromScreen())){
                        switch(this.getOpenFromScreen()){
                            case "USER":
                                subQueryContactX = "SELECT * FROM " + super.getDbOwner() + "." + super.getTblContactX()+ " WHERE PAR_ROW_ID = '" + contList.get(i).getRow_id() + "' AND PAR_USR_ID = '" + this.getUserId() + "'";
                                break;
                            default:
                                break;
                        }
                    }
                    
                    ContactXList = super.queryContactXRecord(subQueryContactX);
                    for(int cx = 0; cx < ContactXList.size(); cx++) {
                        if(null != ContactXList.get(cx).getSOCIAL_M_NAME()) {
                            switch (ContactXList.get(cx).getSOCIAL_M_NAME()) {
                                case "Facebook":
                                    conMgr.settxtFacebook(ContactXList.get(cx).getSOCIAL_M_VALUE());
                                    break;
                                case "Twitter":
                                    conMgr.settxtTwitter(ContactXList.get(cx).getSOCIAL_M_VALUE());
                                    break;
                                case "Instagram":
                                    conMgr.settxtInstagram(ContactXList.get(cx).getSOCIAL_M_VALUE());
                                    break;
                                default:
                                    break;
                            }
                        }
                    }
                }
            }

        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher Campos...\nErro: " + e);
        }
    }
    
    private void fillComboBoxesContactScreen(String LovType){
        try{
            ArrayList<ListOfValuesClass> lov = super.LookupList(LovType);
            
            if(lov.size() > 0){
                for(int i = 0; i < lov.size(); i++){
                    if(null == LovType){
                        JOptionPane.showMessageDialog(null, "O LOV_TYPE 'null' não existe!");
                    } else switch (LovType) {
                        case "DOC_TYPE":
                            conMgr.setcbbDocType(lov.get(i).getValue());
                            break;
                        case "SEX_MF":
                            conMgr.setcbbSex(lov.get(i).getValue());
                            break;
                        case "MONTH_DAY":
                            conMgr.setcbbDay(lov.get(i).getValue());
                            break;
                        case "MONTH":
                            conMgr.setcbbMonth(lov.get(i).getValue());
                            break;
                        case "CIVIL_STATE":
                            conMgr.setcbbCivilState(lov.get(i).getValue());
                            break;
                        case "EMAIL_ADDR_TYPE":
                            conMgr.setcbbCivilState(lov.get(i).getValue());
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
    
    private class openContactSocialMedia implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            socMedMgr = new ContactSocialMediaManagementScreen();
            socMedMgr.setListenerBtnCancelContact(new cancelSocialMedia());
            socMedMgr.setListenerBtnEditContact(new editSocialMedia());
            socMedMgr.setListenerBtnNewContact(new newSocialMedia());
            socMedMgr.setListenerBtnSaveContact(new saveSocialMedia());
            socMedMgr.setListenerContactSocialMediaScreen(new contactSocialMediaScreenListener());
            conMgr.setEnabled(false);
        }        
    }
    
    private class editContact implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            conMgr.enableFields("EDITAR");
            conMgr.setFocus("WHATSAPP_FLG");
        }
    }
    
    private class newContact implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            conMgr.enableFields("NOVO");
            conMgr.clearFields();
            conMgr.setFocus("WHATSAPP_FLG");
        }
    }
    
    private class saveContact implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            conMgr.enableFields("SALVAR");
            conMgr.clearFields();
            conMgr.setFocus("FILTRO_VALOR");
        }
    }
    
    private class cancelContact implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            conMgr.enableFields("CANCELAR");
            conMgr.setFocus("FILTRO_VALOR");
        }
    }
    
    private class editSocialMedia implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            socMedMgr.enableFields("EDITAR");
            socMedMgr.setFocus("WHATSAPP_FLG");
        }
    }
    
    private class newSocialMedia implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            socMedMgr.enableFields("NOVO");
            socMedMgr.clearFields();
            socMedMgr.setFocus("WHATSAPP_FLG");
        }
    }
    
    private class saveSocialMedia implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            socMedMgr.enableFields("SALVAR");
            socMedMgr.clearFields();
            socMedMgr.setFocus("FILTRO_VALOR");
        }
    }
    
    private class cancelSocialMedia implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            socMedMgr.enableFields("CANCELAR");
            socMedMgr.setFocus("FILTRO_VALOR");
        }
    }
    
    private class contactSocialMediaScreenListener implements WindowListener{

        @Override
        public void windowOpened(WindowEvent we) { }

        @Override
        public void windowClosing(WindowEvent we) { }

        @Override
        public void windowClosed(WindowEvent we) {
            conMgr.setEnabled(true);
            conMgr.setVisible(true);
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
    
    private class contactRowId {
        private String row_id;

        public contactRowId() {
            this.row_id = null;
        }

        public String getRow_id() { return row_id; }
        public void setRow_id(String row_id) { this.row_id = row_id; }
        
    }
    
    private class contactXRowId {
        private String row_id;

        public contactXRowId() {
            this.row_id = null;
        }

        public String getRow_id() { return row_id; }
        public void setRow_id(String row_id) { this.row_id = row_id; }
        
    }
    
    private class contactListSelectedUMScreen implements ListSelectionListener {
        
        private int count;

        private contactListSelectedUMScreen() {
            this.count = 0;
        }
        
        @Override
        public void valueChanged(ListSelectionEvent lse) {
            if(count < 1){
                conMgr.clearFields();
                fillFieldsContactScreen("SELECT * FROM " + getDbOwner() + "." + getTblContact() + " WHERE ROW_ID = '" + conMgr.getSelectedContactListId() + "'");
                conMgr.setbtnEditContactEnabled(true);
                count++;
            } else {
                count = 0;
            }
        }
        
    }
    
    /*private class contactScreenListener implements WindowListener {

        @Override
        public void windowOpened(WindowEvent we) { }

        @Override
        public void windowClosing(WindowEvent we) { }

        @Override
        public void windowClosed(WindowEvent we) { }

        @Override
        public void windowIconified(WindowEvent we) { }

        @Override
        public void windowDeiconified(WindowEvent we) { }

        @Override
        public void windowActivated(WindowEvent we) { }

        @Override
        public void windowDeactivated(WindowEvent we) { }
        
    }*/
    
}
