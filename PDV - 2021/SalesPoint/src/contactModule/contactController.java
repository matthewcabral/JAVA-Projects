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
    ContactScreen conMgr;
    SocialMediaScreen socMedMgr;
    SocialMediaRowIdClass socMedia;
    contactRowIdClass contRowId;
    
    private ArrayList<contactRowIdClass> contRowIdArray = new ArrayList<>();
    private ArrayList<SocialMediaRowIdClass> socialMediaRowIdArray = new ArrayList<>();
    private String userId;
    private String accountId;
    private String openFromScreen;
    private String lastContAdd;
    private String lastContUpd;
    private String lastSocialMediaAdd;
    private String lastSocialMediaUpd;
    private int count;
    
    public contactController() throws InterruptedException {
        this.userId = null;
        this.accountId = null;
        this.openFromScreen = null;
        this.lastSocialMediaAdd = "";
        this.lastSocialMediaUpd = "";
    }

    public void setListenerConMgrScreen(WindowListener listener) { conMgr.addWindowListener(listener); }

    public ArrayList<contactRowIdClass> getContRowIdArray() { return contRowIdArray; }
    public ArrayList<SocialMediaRowIdClass> getSocialMediaRowIdArray() { return socialMediaRowIdArray; }
    
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getAccountId() { return accountId; }
    public void setAccountId(String accountId) { this.accountId = accountId; }

    public String getOpenFromScreen() { return openFromScreen; }
    public void setOpenFromScreen(String openFromScreen) { this.openFromScreen = openFromScreen; }

    public String getLastContAdd() { return lastContAdd; }
    public void setLastContAdd(String lastContAdd) { this.lastContAdd = lastContAdd; }

    public String getLastContUpd() { return lastContUpd; }
    public void setLastContUpd(String lastContUpd) { this.lastContUpd = lastContUpd; }
    
    public String getLastContXAdd() { return lastSocialMediaAdd; }
    public void setLastContXAdd(String lastContXAdd) { this.lastSocialMediaAdd = lastContXAdd; }

    public String getLastContXUpd() { return lastSocialMediaUpd; }
    public void setLastContXUpd(String lastContXUpd) { this.lastSocialMediaUpd = lastContXUpd; }

    public int getCount() { return count; }
    public void setCount(int count) { this.count += count; }
    public void clearCount() { this.count = 0; }
    
    public void clearVariables(){
        this.accountId = "";
        this.userId = "";
    }
        
    public void openContactScreen(String query, String function){
        if(!"".equals(function) && function != null){
            switch(function){
                case "NEW_USER_CONTACT":
                    conMgr = new ContactScreen();
                    conMgr.setListenerBtnAddSocialMedia(new openContactSocialMedia());
                    conMgr.setListenerBtnCancel(new cancelContact());
                    conMgr.setListenerBtnEdit(new editContact());
                    conMgr.setListenerBtnNew(new newContact());
                    conMgr.setListenerBtnSave(new saveContact());
                    conMgr.setListenerBtnDelete(new deleteContact());
                    conMgr.setListenerTblContactListSelection(new contactListSelected());
                    conMgr.setListenerContactManagementScreen(new contactScreenListener());
                    break;
                case "NEW_CONTACT":
                    conMgr = new ContactScreen();
                    conMgr.setListenerBtnAddSocialMedia(new openContactSocialMedia());
                    conMgr.setListenerBtnCancel(new cancelContact());
                    conMgr.setListenerBtnEdit(new editContact());
                    conMgr.setListenerBtnNew(new newContact());
                    conMgr.setListenerBtnSave(new saveContact());
                    conMgr.setListenerBtnDelete(new deleteContact());
                    conMgr.setListenerTblContactListSelection(new contactListSelected());
                    conMgr.setListenerContactManagementScreen(new contactScreenListener());
                    break;
                default:
                    break;
            }
        }
        
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
        
        this.fillListContactScreen(query);
        conMgr.setFocus("FILTRO_VALOR");
    }
    
    public void fillListContactScreen(String query){
        int countRecord = 0;
        String subQueryContactX = "";
        String subQueryAddress = "";
        
        try{
            ArrayList<ContactClass> contList = super.queryContactRecord(query);
            ArrayList<SocialMediaClass> ContactXList;
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
                    } else {
                        table.setValueAt(false, i, 4);
                    }
                    table.setValueAt(contList.get(i).getEMAIL_ADDR(), i, 5);
                    table.setValueAt(contList.get(i).getALT_PH_NUM(), i, 6);
                    if("Y".equals(contList.get(i).getWHATSAPP_FLG())){
                        table.setValueAt(true, i, 7);
                    } else {
                        table.setValueAt(false, i, 7);
                    }
                    table.setValueAt(contList.get(i).getMAIN_PH_NUM(), i, 8);
                    table.setValueAt(contList.get(i).getWORK_PH_NUM(), i, 9);
                    
                    if(this.getOpenFromScreen() != null && !"".equals(this.getOpenFromScreen())){
                        switch(this.getOpenFromScreen()){
                            case "USER":
                                subQueryContactX = "SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblSocialMedia()+ "\nWHERE PAR_ROW_ID = '" + contList.get(i).getRow_id() + "'\nAND PAR_USR_ID = '" + this.getUserId() + "'";
                                subQueryAddress = "SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblAddress() + "\nWHERE PAR_ROW_ID = '" + getUserId() +  "'\nAND PR_ADDR_FLG = 'Y'";
                                break;
                            default:
                                break;
                        }
                    }
                    
                    // Social Media Information
                    ContactXList = super.querySocialMediaRecord(subQueryContactX);
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
    
    public void fillFieldsContactScreen(String query){
        String subQueryContactX = "";
        try{
            ArrayList<ContactClass> contList = super.queryContactRecord(query);
            ArrayList<SocialMediaClass> ContactXList;
            
            if(contList.size() > 0){
                for(int i = 0; i < contList.size(); i++){
                    conMgr.setlblContactNameHeader(contList.get(i).getFULL_NAME());
                    conMgr.settxtRowId(contList.get(i).getRow_id());
                    conMgr.settxtContactMPhone(contList.get(i).getMAIN_PH_NUM());
                    conMgr.settxtContactPhone(contList.get(i).getALT_PH_NUM());
                    conMgr.settxtContactEnterprise(contList.get(i).getWORK_PH_NUM());   
                    if(!"".equals(contList.get(i).getEMAIL_ADDR()) && contList.get(i).getEMAIL_ADDR() != null){
                        conMgr.settxtContactEmail(contList.get(i).getEMAIL_ADDR().substring(0, contList.get(i).getEMAIL_ADDR().indexOf("@")));
                        conMgr.setcbbContactEmailTypeItemIndex(conMgr.getcbbContactEmailTypeItemIndex(contList.get(i).getEMAIL_ADDR().substring(contList.get(i).getEMAIL_ADDR().indexOf("@") + 1, contList.get(i).getEMAIL_ADDR().length())));
                    }
                    conMgr.setckbAllowEmailFlg(contList.get(i).getSUPPRESS_EMAIL_FLG());
                    conMgr.setckbMainConFlg(contList.get(i).getPR_CON_FLG());
                    conMgr.setckbWhatsAppFlg(contList.get(i).getWHATSAPP_FLG());
                    conMgr.setckbAllowCallFlg(contList.get(i).getSUPPRESS_CALL_FLG());
                    conMgr.setckbSendPromFlg(contList.get(i).getSEND_PROMOTES_FLG());
                    conMgr.setckbSendNewsFlg(contList.get(i).getSEND_NEWS_FLG());

                    conMgr.setcbbDocTypeItemIndex(conMgr.getcbbDocTypeItemIndex(contList.get(i).getDOC_TYPE()));
                    conMgr.settxtDocNum(contList.get(i).getDOC_NUM());
                    conMgr.settxtName(contList.get(i).getFST_NAME());
                    conMgr.settxtSurname(contList.get(i).getLAST_NAME());
                    conMgr.settxtNickName(contList.get(i).getNICK_NAME());
                    conMgr.setcbbSexItemIndex(conMgr.getcbbSexItemIndex(contList.get(i).getSEX_MF()));
                    if (!"".equals(contList.get(i).getBIRTH_DT()) && contList.get(i).getBIRTH_DT() != null) {
                        conMgr.setcbbDayItemIndex(conMgr.getcbbDayItemIndex(super.LookupValue("MONTH_DAY", contList.get(i).getBIRTH_DT().substring(0, 2))));
                        conMgr.setcbbMonthItemIndex(conMgr.getcbbMonthItemIndex(super.LookupValue("MONTH", contList.get(i).getBIRTH_DT().substring(3, 5))));
                        conMgr.settxtYear(contList.get(i).getBIRTH_DT().substring(6, 10));
                    }
                    conMgr.settxtBornLocation(contList.get(i).getPLACE_OF_BIRTH());
                    conMgr.setcbbCivilStateItemIndex(conMgr.getcbbCivilStateItemIndex(contList.get(i).getMARITAL_STAT_CD()));
                    conMgr.settxtSpouseName(contList.get(i).getNAME_CONJUGE());
                    conMgr.settxtMotherName(contList.get(i).getMOTHER_FULL_NAME());
                    conMgr.settxtFatherName(contList.get(i).getFATHER_FULL_NAME());
                    
                    // Social Media Information
                    if(this.getOpenFromScreen() != null && !"".equals(this.getOpenFromScreen())){
                        switch(this.getOpenFromScreen()){
                            case "USER":
                                subQueryContactX = "SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblSocialMedia() + "\nWHERE PAR_ROW_ID = '" + contList.get(i).getRow_id() + "'\nAND PAR_USR_ID = '" + this.getUserId() + "'";
                                break;
                            default:
                                break;
                        }
                    }
                    ContactXList = super.querySocialMediaRecord(subQueryContactX);
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
    
    public void fillNewContactFields(){
        conMgr.settxtRowId(getNextRowId());
        if(this.getOpenFromScreen() != null && !"".equals(this.getOpenFromScreen())){
            switch(this.getOpenFromScreen()){
                case "USER":
                    ArrayList<ContactClass> contList = super.queryContactRecord("SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblContact() + "\nWHERE PAR_USR_ID = '" + this.getUserId() + "' AND PR_CON_FLG = 'Y'");
                    if(contList.size() > 0){
                        conMgr.setckbMainConFlg("N");
                    } else {
                        conMgr.setckbMainConFlg("Y");
                    }
                    break;
                case "MAIN":
                    conMgr.setckbMainConFlg("Y");
                    break;
                default:
                    break;
            }
        }
        conMgr.setckbWhatsAppFlg("Y");
        conMgr.setckbAllowCallFlg("Y");
        conMgr.setckbSendPromFlg("Y");
        conMgr.setckbAllowEmailFlg("Y");
        conMgr.setckbSendNewsFlg("Y");
    }
    
    public void openSocialMediaScreen(String function){
        socMedMgr.clearFields();
        socMedMgr.clearComboBoxes();
        socMedMgr.insertSelectComboBox();        
        this.fillComboBoxesSocialMediaScreen("SOCIAL_MEDIA");
        if(this.getOpenFromScreen() != null && !"".equals(this.getOpenFromScreen())){
            switch(this.getOpenFromScreen()){
                case "USER":
                    switch(function){
                        case "LOAD_RECORD":
                            
                            ArrayList<UserClass> userList = super.queryUserRecord("SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblUser() + "\nWHERE ROW_ID = '" + getUserId() + "'");
                            if(userList.size() > 0){
                                ArrayList<ContactClass> contList = super.queryContactRecord("SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblContact()+ "\nWHERE ROW_ID = '" + conMgr.gettxtRowId() + "'");
                                if(contList.size() > 0){
                                    if(socialMediaRowIdArray.size() > 0){
                                        super.clearCondition();

                                        for(int i = 0; i < socialMediaRowIdArray.size(); i++){
                                            if(i == 0){
                                                super.setCondition("\n\t\t'" + socialMediaRowIdArray.get(i).getRow_id() + "'");
                                            } else {
                                                super.setCondition(",\n\t\t'" + socialMediaRowIdArray.get(i).getRow_id() + "'");
                                            }                            
                                        }
                                        this.fillListSocialMediaScreen("SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblSocialMedia()+ "\nWHERE (\n\tPAR_ROW_ID = '" + conMgr.gettxtRowId() + "'\n\tAND PAR_USR_ID = '" + this.getUserId() + "'\n\tAND ACTIVE_FLG = 'Y'\n)\nOR (\n\tROW_ID IN (" + super.getCondition() + "\n\t)\n\tAND ACTIVE_FLG = 'Y'\n\tAND PAR_ROW_ID IS NULL\n\tAND CREATED >= SYSDATE - 1\n\tAND CREATED_BY = '" + this.getUserId() + "'\n)");
                                    } else {
                                        this.fillListSocialMediaScreen("SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblSocialMedia()+ "\nWHERE PAR_ROW_ID = '" + conMgr.gettxtRowId() + "'\nAND PAR_USR_ID = '" + this.getUserId() + "'\nAND ACTIVE_FLG = 'Y'");
                                    }
                                   
                                } else {
                                    this.fillListSocialMediaScreen("SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblSocialMedia()+ "\nWHERE PAR_ROW_ID IS NULL\nAND PAR_ACCNT_ID IS NULL\nAND PAR_USR_ID IS NULL\nAND ACTIVE_FLG = 'Y'\nAND STATUS_CD = 'Ativo'\nAND CREATED >= SYSDATE - 0.1\nAND CREATED_BY = '" + super.getUserIdByLogin() + "'");
                                }
                            } else {
                                this.fillListSocialMediaScreen("SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblSocialMedia()+ "\nWHERE PAR_ROW_ID = '" + conMgr.gettxtRowId() + "'\nAND PAR_USR_ID = '" + this.getUserId() + "'\nAND ACTIVE_FLG = 'Y'");
                            }
                            break;
                        case "NEW_RECORD":
                            if(socialMediaRowIdArray.size() > 0){
                                super.clearCondition();

                                for(int i = 0; i < socialMediaRowIdArray.size(); i++){
                                    if(i == 0){
                                        super.setCondition("\n\t'" + socialMediaRowIdArray.get(i).getRow_id() + "'");
                                    } else {
                                        super.setCondition(",\n\t'" + socialMediaRowIdArray.get(i).getRow_id() + "'");
                                    }                            
                                }
                                this.fillListSocialMediaScreen("SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblSocialMedia()+ "\nWHERE (\nROW_ID IN (" + super.getCondition() + "\n)\nAND ACTIVE_FLG = 'Y' AND\nPAR_ROW_ID IS NULL\n)\nOR PAR_ROW_ID = '" + conMgr.gettxtRowId() + "'");
                            }
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    break;
            }
        }
        
        socMedMgr.enableFields("LOAD_SCREEN");
        
    }
    
    public void fillListSocialMediaScreen(String query){
        int countRecord = 0;
        
        try{
            ArrayList<SocialMediaClass> ContactXList = super.querySocialMediaRecord(query);
            
            DefaultTableModel table = (DefaultTableModel) socMedMgr.getTableModel();
            table.setRowCount(0);
            
            if(ContactXList.size() > 0){
                table.setNumRows(ContactXList.size());
                
                for(int i = 0; i < ContactXList.size(); i++){
                    
                    table.setValueAt(ContactXList.get(i).getRow_id(), i, 0);
                    table.setValueAt(ContactXList.get(i).getSOCIAL_M_NAME(), i, 1);
                    table.setValueAt(ContactXList.get(i).getSOCIAL_M_VALUE(), i, 2);
                    
                    countRecord++;
                }                    
            }
            
            socMedMgr.setlblRecCount(String.valueOf(countRecord));
            
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher tabela...\nErro: " + e);
        }
    }
        
    public void fillFieldsSocialMediaScreen(String query){
        try{
            ArrayList<SocialMediaClass> ContactXList = super.querySocialMediaRecord(query);
            
            if(ContactXList.size() > 0){
                for(int i = 0; i < ContactXList.size(); i++){
                    socMedMgr.setlblSocialMediaHeader(ContactXList.get(i).getSOCIAL_M_NAME());
                    socMedMgr.settxtRowId(ContactXList.get(i).getRow_id());
                    socMedMgr.setcbbSocialMediaTypeItemIndex(socMedMgr.getcbbSocialMediaTypeItemIndex(ContactXList.get(i).getSOCIAL_M_NAME()));
                    socMedMgr.settxtSocialMediaValue(ContactXList.get(i).getSOCIAL_M_VALUE());
                }
            }

        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher Campos...\nErro: " + e);
        }
    }
    
    public void fillComboBoxesContactScreen(String LovType){
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
                            conMgr.setcbbContactEmailType(lov.get(i).getValue());
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
    
    public void fillComboBoxesSocialMediaScreen(String LovType){
        try{
            ArrayList<ListOfValuesClass> lov = super.LookupList(LovType);
            
            if(lov.size() > 0){
                for(int i = 0; i < lov.size(); i++){
                    if(null == LovType){
                        JOptionPane.showMessageDialog(null, "O LOV_TYPE 'null' não existe!");
                    } else switch (LovType) {
                        case "SOCIAL_MEDIA":
                            socMedMgr.setcbbSocialMediaType(lov.get(i).getValue());
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
    
    public void updateArrayAfterDelete(String screen){
        boolean status = true;
        int size;
        int i = 0;
        switch(screen) {
            case "SOCIAL_MEDIA":
                size = socialMediaRowIdArray.size();
                do {
                    if(size > 0 && i != size){
                        if(super.queryTableCount(super.getTblSocialMedia(), "ROW_ID = '" + socialMediaRowIdArray.get(i).getRow_id() + "'") < 1){
                            socialMediaRowIdArray.remove(i);
                            size = socialMediaRowIdArray.size();
                            i = 0;
                        } else {
                            i++;
                        }
                    } else {
                        status = false;
                    }
                } while (status);                
                break;
            case "CONTACT":
                size = contRowIdArray.size();
                do {
                    if(size > 0 && i != size){
                        if(super.queryTableCount(super.getTblSocialMedia(), "ROW_ID = '" + contRowIdArray.get(i).getRow_id() + "'") < 1){
                            contRowIdArray.remove(i);
                            size = contRowIdArray.size();
                            i = 0;
                        } else {
                            i++;
                        }
                    } else {
                        status = false;
                    }
                } while (status);
                
                status = true;
                size = socialMediaRowIdArray.size();
                i = 0;
                do {
                    if(size > 0 && i != size){
                        if(super.queryTableCount(super.getTblSocialMedia(), "ROW_ID = '" + socialMediaRowIdArray.get(i).getRow_id() + "'") < 1){
                            socialMediaRowIdArray.remove(i);
                            size = socialMediaRowIdArray.size();
                            i = 0;
                        } else {
                            i++;
                        }
                    } else {
                        status = false;
                    }
                } while (status);     
                break;
            default:
                break;
        }
        
    }
    
    public boolean validateContactFields(){
        if(!"".equals(conMgr.gettxtContactMPhone()) && conMgr.gettxtContactMPhone() != null){
            if(!"".equals(conMgr.gettxtContactEmail()) && conMgr.gettxtContactEmail() != null){
                if(conMgr.getcbbContactEmailType() != null){
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "O campo 'Tipo de Email' é obrigatório quando o campo 'Email' é preenchido! Favor preencher o campo.");
                    conMgr.setFocus("CONTATO_EMAIL");
                    return false;
                }
            } else {
                if(conMgr.getcbbContactEmailType() != null){
                    JOptionPane.showMessageDialog(null, "O campo 'Email' é obrigatório quando o campo 'Tipo de Email' é preenchido! Favor preencher o campo.");
                    conMgr.setFocus("CONTATO_EMAIL_TIPO");
                    return false;
                } else {
                    return true;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "O campo 'Celular/WhatsApp' é obrigatório! Favor preencher o campo.");
            conMgr.setFocus("CONTATO_CELULAR");
            return false;
        }
    }
    
    public boolean validateSocialMediaFields(){
        if(!"".equals(socMedMgr.getcbbSocialMediaType()) && !"Selecione...".equals(socMedMgr.getcbbSocialMediaType()) && socMedMgr.getcbbSocialMediaType() != null){
            if(!"".equals(socMedMgr.gettxtSocialMediaValue()) && socMedMgr.gettxtSocialMediaValue() != null){
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "O campo 'Usuário Rede Social' é obrigatório! Favor preencher o campo.");
                socMedMgr.setFocus("USUARIO");
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "O campo 'Nome Rede Social' é obrigatório! Favor selecionar uma opção da lista.");
            socMedMgr.setFocus("TIPO_REDE_SOCIAL");
            return false;
        }
    }
    
    public boolean insertContact(){
        String contactId = "";
        if(validateContactFields()){
            contactId = super.getNextRowId();
            super.clearColumns();
            super.clearValues();
            super.setColumns("ROW_ID"); super.setValues("'" + contactId + "'");
            super.setColumns(",\n\t" + "CREATED"); super.setValues(",\n\t" + "SYSDATE");
            super.setColumns(",\n\t" + "CREATED_BY"); super.setValues(",\n\t" + "'" + super.getUserIdByLogin() + "'");
            super.setColumns(",\n\t" + "LAST_UPD"); super.setValues(",\n\t" + "SYSDATE");
            super.setColumns(",\n\t" + "LAST_UPD_BY"); super.setValues(",\n\t" + "'" + super.getUserIdByLogin() + "'");
            super.setColumns(",\n\t" + "ACTIVE_FLG"); super.setValues(",\n\t" + "'Y'");
            super.setColumns(",\n\t" + "DB_LAST_UPD"); super.setValues(",\n\t" + "SYSDATE");
            super.setColumns(",\n\t" + "STATUS_CD"); super.setValues(",\n\t" + "'" + super.LookupValue("ACCOUNT_STATUS", "Active") + "'");
                        
            if(this.getOpenFromScreen() != null && !"".equals(this.getOpenFromScreen())){
                switch(this.getOpenFromScreen()){
                    case "USER":                        
                        super.setColumns(",\n\t" + "PAR_USR_ID"); if(!"".equals(this.getUserId()) && this.getUserId() != null) { super.setValues(",\n\t" + "'" + this.getUserId() + "'"); } else { super.setValues(",\n\t" + "NULL"); }
                        super.setColumns(",\n\t" + "PAR_ROW_ID"); if(!"".equals(this.getUserId()) && this.getUserId() != null) { super.setValues(",\n\t" + "'" + this.getUserId() + "'"); } else { super.setValues(",\n\t" + "NULL"); }
                        super.setColumns(",\n\t" + "EMP_FLG"); super.setValues(",\n\t" + "'Y'");
                        
                        ArrayList<ContactClass> contList = super.queryContactRecord("SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblContact() + "\nWHERE PAR_USR_ID = '" + this.getUserId() + "' AND PR_CON_FLG = 'Y'");
                        if("Y".equals(conMgr.getckbMainConFlg())){
                            if(contList.size() > 0){
                                for(int i = 0; i < contList.size(); i++){
                                    if("Y".equals(contList.get(i).getPR_CON_FLG())){
                                        super.clearColumnsValues();
                                        super.clearCondition();
                                        super.setColumnsValues("PR_CON_FLG = 'N'");
                                        super.setCondition("ROW_ID = '" + contList.get(i).getRow_id() + "'");
                                        try{
                                            this.clearCount();                                            
                                            this.setCount(super.updateRecord(super.getTblContact(), super.getColumnsValues(), super.getCondition()));
                                            if(this.getCount() > 0){
                                                super.clearColumnsValues();
                                                super.clearCondition();
                                                super.setColumns(",\n\t" + "PR_CON_FLG"); super.setValues(",\n\t" + "'Y'");
                                            } else {
                                                super.clearColumnsValues();
                                                super.clearCondition();
                                                super.setColumns(",\n\t" + "PR_CON_FLG"); super.setValues(",\n\t" + "'N'");
                                            }
                                        } catch (Exception e) {
                                            super.clearColumnsValues();
                                            super.clearCondition();
                                            super.setColumns(",\n\t" + "PR_CON_FLG"); super.setValues(",\n\t" + "'N'");
                                        }
                                    }
                                }
                            } else {
                                super.setColumns(",\n\t" + "PR_CON_FLG"); super.setValues(",\n\t" + "'Y'");
                            }
                        } else {
                            super.setColumns(",\n\t" + "PR_CON_FLG"); super.setValues(",\n\t" + "'N'");
                        }
                        break;
                    default:
                        super.setColumns(",\n\t" + "PAR_ROW_ID"); super.setValues(",\n\t" + "NULL");
                        super.setColumns(",\n\t" + "PAR_USR_ID"); super.setValues(",\n\t" + "NULL");
                        super.setColumns(",\n\t" + "EMP_FLG"); super.setValues(",\n\t" + "'N'");
                        break;
                }
            }
            
            super.setColumns(",\n\t" + "DOC_TYPE"); super.setValues(",\n\t" + "NULL");
            super.setColumns(",\n\t" + "DOC_NUM"); super.setValues(",\n\t" + "NULL");
            super.setColumns(",\n\t" + "ALIAS_NAME"); super.setValues(",\n\t" + "NULL");
            super.setColumns(",\n\t" + "NOME_FANTASIA"); super.setValues(",\n\t" + "NULL");
            super.setColumns(",\n\t" + "FST_NAME"); super.setValues(",\n\t" + "NULL");
            super.setColumns(",\n\t" + "LAST_NAME"); super.setValues(",\n\t" + "NULL");
            super.setColumns(",\n\t" + "FULL_NAME"); super.setValues(",\n\t" + "NULL");
            super.setColumns(",\n\t" + "NICK_NAME"); super.setValues(",\n\t" + "NULL");
            super.setColumns(",\n\t" + "AGE"); super.setValues(",\n\t" + "NULL");
            super.setColumns(",\n\t" + "BIRTH_DT"); super.setValues(",\n\t" + "NULL");
            super.setColumns(",\n\t" + "PLACE_OF_BIRTH"); super.setValues(",\n\t" + "NULL");
            super.setColumns(",\n\t" + "SEX_MF"); super.setValues(",\n\t" + "NULL");
            super.setColumns(",\n\t" + "MARITAL_STAT_CD"); super.setValues(",\n\t" + "NULL");
            super.setColumns(",\n\t" + "NAME_CONJUGE"); super.setValues(",\n\t" + "NULL");
            super.setColumns(",\n\t" + "MOTHER_FULL_NAME"); super.setValues(",\n\t" + "NULL");
            super.setColumns(",\n\t" + "FATHER_FULL_NAME"); super.setValues(",\n\t" + "NULL");
            super.setColumns(",\n\t" + "POTENTIAL_FLG"); super.setValues(",\n\t" + "'Y'");
            super.setColumns(",\n\t" + "SUPPRESS_EMAIL_FLG"); super.setValues(",\n\t" + "'" + conMgr.getckbAllowEmailFlg() + "'");
            super.setColumns(",\n\t" + "ENTERPRISE_FLAG"); super.setValues(",\n\t" + "'N'");
            super.setColumns(",\n\t" + "RELATIONSHIP_TYPE"); super.setValues(",\n\t" + "NULL");
            super.setColumns(",\n\t" + "MEMBER_FLG"); super.setValues(",\n\t" + "'N'");
            super.setColumns(",\n\t" + "SEND_NEWS_FLG"); super.setValues(",\n\t" + "'" + conMgr.getckbSendNewsFlg() + "'");
            super.setColumns(",\n\t" + "SEND_PROMOTES_FLG"); super.setValues(",\n\t" + "'" + conMgr.getckbSendPromFlg() + "'");
            super.setColumns(",\n\t" + "SUPPRESS_CALL_FLG"); super.setValues(",\n\t" + "'" + conMgr.getckbAllowCallFlg() + "'");
            super.setColumns(",\n\t" + "WHATSAPP_FLG"); super.setValues(",\n\t" + "'" + conMgr.getckbWhatsAppFlg() + "'");
            super.setColumns(",\n\t" + "CONSUMER_FLG"); super.setValues(",\n\t" + "'N'");
            super.setColumns(",\n\t" + "MAIN_PH_NUM"); super.setValues(",\n\t" + "'" + conMgr.gettxtContactMPhone() + "'");
            super.setColumns(",\n\t" + "ALT_PH_NUM"); if(conMgr.gettxtContactPhone() != null){ super.setValues(",\n\t" + "'" + conMgr.gettxtContactPhone() + "'"); } else { super.setValues(",\n\t" + "NULL"); }
            super.setColumns(",\n\t" + "WORK_PH_NUM"); if(conMgr.gettxtContactEnterprise() != null){ super.setValues(",\n\t" + "'" + conMgr.gettxtContactEnterprise() + "'"); } else { super.setValues(",\n\t" + "NULL"); }
            super.setColumns(",\n\t" + "ASST_PH_NUM"); super.setValues(",\n\t" + "NULL");
            super.setColumns(",\n\t" + "FAX_PH_NUM"); super.setValues(",\n\t" + "NULL");
            super.setColumns(",\n\t" + "CALL_FREQUENCY"); super.setValues(",\n\t" + "NULL");
            super.setColumns(",\n\t" + "CREATOR_LOGIN"); super.setValues(",\n\t" + "'" + super.getUserIdByLogin() + "'");
            
            if(conMgr.gettxtContactEmail() != null) {
                if(conMgr.getcbbContactEmailType() != null) {
                    super.setColumns(",\n\t" + "EMAIL_ADDR"); super.setValues(",\n\t" + "'" + conMgr.gettxtContactEmail() + "@" + conMgr.getcbbContactEmailType() + "'");
                    super.setColumns(",\n\t" + "EMAIL_TYPE"); super.setValues(",\n\t" + "'" + super.LookupName("EMAIL_ADDR_TYPE", conMgr.getcbbContactEmailType()) + "'");
                } else {
                    super.setColumns(",\n\t" + "EMAIL_ADDR"); super.setValues(",\n\t" + "NULL");
                    super.setColumns(",\n\t" + "EMAIL_TYPE"); super.setValues(",\n\t" + "NULL");
                }
                
            } else {
                super.setColumns(",\n\t" + "EMAIL_ADDR"); super.setValues(",\n\t" + "NULL");
                super.setColumns(",\n\t" + "EMAIL_TYPE"); super.setValues(",\n\t" + "NULL");
            }
            
            super.setColumns(",\n\t" + "SITE_ADDR"); super.setValues(",\n\t" + "NULL");            
            super.setColumns(",\n\t" + "LOGIN"); super.setValues(",\n\t" + "NULL");
            super.setColumns(",\n\t" + "OCCUPATION"); super.setValues(",\n\t" + "NULL");
            super.setColumns(",\n\t" + "PASSWORD"); super.setValues(",\n\t" + "NULL");
            super.setColumns(",\n\t" + "PR_CON_ADDR_ID"); super.setValues(",\n\t" + "NULL");
            super.setColumns(",\n\t" + "PR_EMAIL_ADDR_ID"); super.setValues(",\n\t" + "NULL");
            super.setColumns(",\n\t" + "PR_ADDR_ID"); super.setValues(",\n\t" + "NULL");

            try{
                if("true".equals(super.insertRecord(super.getTblContact(), super.getColumns(), super.getValues()))){
                    contRowId = new contactRowIdClass();
                    contRowId.setRow_id(contactId);
                    setLastContAdd(contactId);
                    contRowIdArray.add(contRowId);
                    this.clearColumns();
                    this.clearValues();
                    
                    if(socialMediaRowIdArray.size() > 0){
                        for(int i = 0; i < socialMediaRowIdArray.size(); i ++){
                            super.clearColumnsValues();
                            super.clearCondition();
                            super.setColumnsValues(",\n\t" + "PAR_ROW_ID = '" + contactId + "'");
                            if(this.getOpenFromScreen() != null && !"".equals(this.getOpenFromScreen())){
                                switch(this.getOpenFromScreen()){
                                    case "USER":
                                        super.setColumnsValues((!"".equals(this.getUserId()) && this.getUserId() != null) ? ",\n\t" + "PAR_USR_ID = '" + this.getUserId() + "'" : ",\n\t" + "PAR_USR_ID = NULL");
                                        //if(!"".equals(this.getUserId()) && this.getUserId() != null) { super.setColumnsValues(",\n\t" + "PAR_USR_ID = '" + this.getUserId() + "'"); } else { super.setColumnsValues(",\n\t" + "PAR_USR_ID = NULL"); }
                                        break;
                                    default:
                                        break;
                                }
                            }                            
                            super.setCondition("\nAND " + "PAR_ROW_ID IS NULL");
                            try{
                                updateSocialMedia("CONTACT", super.getColumnsValues(), super.getCondition(), socialMediaRowIdArray.get(i).getRow_id());
                            } catch(Exception e) {
                                System.out.println(super.getDateTime() + "\tContactModule.ContactController\t\tinsertContact\nUpdateSocialMedia\tError Exception\tError: " + e);
                            }
                        }
                    }
                    return true;
                } else {
                    contactId = null;
                    this.clearColumns();
                    this.clearValues();
                    return false;
                }
            } catch (Exception e) {
                contactId = null;
                this.clearColumns();
                this.clearValues();
                return false;
            }
        } else {
            contactId = null;
            return false;
        }
    }
    
    public boolean updateContact(String screen, String columnsValues, String condition, String rowId){
        super.clearColumnsValues();
        super.clearCondition();
        if("CONTACT".equals(screen)){
            if(validateContactFields()){
                this.setLastContUpd(rowId);
                
                if("Y".equals(conMgr.getckbMainConFlg())){
                    ArrayList<ContactClass> contList = super.queryContactRecord("SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblContact() + "\nWHERE PAR_USR_ID = '" + this.getUserId() + "'\nAND ROW_ID <> '" + rowId + "'\nAND PR_CON_FLG = 'Y'");
                    if(contList.size() > 0){
                        for(int i = 0; i < contList.size(); i++){
                            if("Y".equals(contList.get(i).getPR_CON_FLG())){
                                super.clearColumnsValues();
                                super.clearCondition();
                                super.setColumnsValues("PR_CON_FLG = 'N'");
                                super.setCondition("ROW_ID = '" + contList.get(i).getRow_id() + "'");
                                try{
                                    this.clearCount();                                            
                                    this.setCount(super.updateRecord(super.getTblContact(), super.getColumnsValues(), super.getCondition()));
                                    if(this.getCount() > 0){
                                        super.clearColumnsValues();
                                        super.clearCondition();
                                        super.setColumnsValues("PR_CON_FLG = 'Y'");
                                    } else {
                                        super.clearColumnsValues();
                                        super.clearCondition();
                                        super.setColumnsValues("PR_CON_FLG = 'N'");
                                    }
                                } catch (Exception e) {
                                    super.clearColumnsValues();
                                    super.clearCondition();
                                    super.setColumnsValues("PR_CON_FLG = 'N'");
                                }
                            }
                        }
                    } else {
                        super.setColumnsValues("PR_CON_FLG = 'Y'");
                    }
                } else {
                    super.setColumnsValues("PR_CON_FLG = 'N'");
                }
                super.setColumnsValues(",\n\t" + "LAST_UPD = SYSDATE");
                super.setColumnsValues(",\n\t" + "LAST_UPD_BY = '" + super.getUserIdByLogin() + "'");
                super.setColumnsValues(",\n\t" + "ACTIVE_FLG = 'Y'");
                super.setColumnsValues(",\n\t" + "DB_LAST_UPD = SYSDATE");
                super.setColumnsValues(",\n\t" + "MODIFICATION_NUM = (SELECT MODIFICATION_NUM + 1 FROM " + super.getDbOwner() + "." + super.getTblContact() + " WHERE ROW_ID = '" + rowId + "')");
                super.setColumnsValues(",\n\t" + "STATUS_CD = '" + super.LookupValue("ACCOUNT_STATUS", "Active") + "'");                
                super.setColumnsValues(",\n\t" + "SUPPRESS_EMAIL_FLG = '" + conMgr.getckbAllowEmailFlg() + "'");
                super.setColumnsValues(",\n\t" + "SEND_NEWS_FLG = '" + conMgr.getckbSendNewsFlg() + "'");
                super.setColumnsValues(",\n\t" + "SEND_PROMOTES_FLG = '" + conMgr.getckbSendPromFlg() + "'");
                super.setColumnsValues(",\n\t" + "SUPPRESS_CALL_FLG = '" + conMgr.getckbAllowCallFlg() + "'");
                super.setColumnsValues(",\n\t" + "WHATSAPP_FLG = '" + conMgr.getckbWhatsAppFlg() + "'");
                if(conMgr.gettxtContactMPhone() != null){ super.setColumnsValues(",\n\t" + "MAIN_PH_NUM = '" + conMgr.gettxtContactMPhone() + "'"); } else { super.setColumnsValues(",\n\t" + "MAIN_PH_NUM = NULL"); }
                if(conMgr.gettxtContactPhone() != null){ super.setColumnsValues(",\n\t" + "ALT_PH_NUM = '" + conMgr.gettxtContactPhone() + "'"); } else { super.setColumnsValues(",\n\t" + "ALT_PH_NUM = NULL"); }
                if(conMgr.gettxtContactEnterprise() != null){ super.setColumnsValues(",\n\t" + "WORK_PH_NUM = '" + conMgr.gettxtContactEnterprise() + "'"); } else { super.setColumnsValues(",\n\t" + "WORK_PH_NUM = NULL"); }
                if(conMgr.gettxtContactEmail() != null) {
                    if(conMgr.getcbbContactEmailType() != null) {
                        super.setColumnsValues(",\n\t" + "EMAIL_ADDR = '" + conMgr.gettxtContactEmail() + "@" + conMgr.getcbbContactEmailType() + "'");
                        super.setColumnsValues(",\n\t" + "EMAIL_TYPE = '" + super.LookupName("EMAIL_ADDR_TYPE", conMgr.getcbbContactEmailType()) + "'");
                    } else { 
                        super.setColumnsValues(",\n\t" + "EMAIL_ADDR = NULL");
                        super.setColumnsValues(",\n\t" + "EMAIL_TYPE = NULL"); 
                    }                    
                } else { 
                    super.setColumnsValues(",\n\t" + "EMAIL_ADDR = NULL");
                    super.setColumnsValues(",\n\t" + "EMAIL_TYPE = NULL"); 
                }

                if(!"".equals(columnsValues) && columnsValues != null){
                    super.setColumnsValues(columnsValues);
                }
                super.setCondition("ROW_ID = '" + rowId + "'");
                if(!"".equals(condition) && condition != null){
                    super.setCondition(condition);
                }
                
                try{
                    this.clearCount();
                    this.setCount(super.updateRecord(super.getTblContact(), super.getColumnsValues(), super.getCondition()));
                    if(this.getCount() > 0){
                        JOptionPane.showMessageDialog(null, "Registros atualizados com sucesso!\nTotal de registros alterados: " + this.getCount());
                        super.clearColumnsValues();
                        super.clearCondition();
                        
                        if(socialMediaRowIdArray.size() > 0){
                            for(int i = 0; i < socialMediaRowIdArray.size(); i ++){
                                super.clearColumnsValues();
                                super.clearCondition();
                                super.setColumnsValues(",\n\t" + "PAR_ROW_ID = '" + rowId + "'");
                                if(this.getOpenFromScreen() != null && !"".equals(this.getOpenFromScreen())){
                                    switch(this.getOpenFromScreen()){
                                        case "USER":
                                            if(!"".equals(this.getUserId()) && this.getUserId() != null) { super.setColumnsValues(",\n\t" + "PAR_USR_ID = '" + this.getUserId() + "'"); } else { super.setColumnsValues(",\n\t" + "PAR_USR_ID = NULL"); }
                                            break;
                                        default:
                                            break;
                                    }
                                }                            
                                super.setCondition("\nAND " + "PAR_ROW_ID IS NULL");
                                try{
                                    updateSocialMedia("CONTACT", super.getColumnsValues(), super.getCondition(), socialMediaRowIdArray.get(i).getRow_id());
                                } catch(Exception e) {
                                    System.out.println(super.getDateTime() + "\tContactModule.ContactController\t\tUpdateContact\nUpdateSocialMedia\tError Exception\tError: " + e);
                                }
                            }
                        }
                        
                        return true;
                    } else {
                        super.clearColumnsValues();
                        super.clearCondition();
                        return false;
                    }
                } catch (Exception e) {
                    super.clearColumnsValues();
                    super.clearCondition();
                    return false;
                }
            } else {
                return false;
            }
        } else{
            return false;
        }
    }
    
    public boolean deleteContact(){
        int countContact = 0;
        int countSocialMedia = 0;
        if(super.wishDeleteRecord()){
            ArrayList<SocialMediaClass> socialMedia = null;            
            super.clearCondition();
            
            // Social Media Information
            if(this.getOpenFromScreen() != null && !"".equals(this.getOpenFromScreen())){
                switch(this.getOpenFromScreen()){
                    case "USER":
                        socialMedia = super.querySocialMediaRecord("SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblSocialMedia() + "\nWHERE PAR_ROW_ID = '" + conMgr.gettxtRowId() + "'\nAND PAR_USR_ID = '" + this.getUserId() + "'");
                        break;
                    case "MAIN":
                        socialMedia = null;
                        break;
                    case "ACCOUNT":
                        socialMedia = null;
                        break;
                    default:
                        socialMedia = null;
                        break;
                }
            }
            if(socialMedia.size() > 0) {                
                if(this.getOpenFromScreen() != null && !"".equals(this.getOpenFromScreen())){
                    switch(this.getOpenFromScreen()){
                        case "USER":
                            super.setCondition("PAR_ROW_ID = '" + conMgr.gettxtRowId() + "'");
                            super.setCondition("\n" + "AND " + "PAR_USR_ID = '" + this.getUserId() + "'");
                            break;
                        case "MAIN":
                            //super.setCondition("PAR_ROW_ID = '" + conMgr.gettxtRowId() + "'");
                            break;
                        case "ACCOUNT":
                            //super.setCondition("PAR_ROW_ID = '" + conMgr.gettxtRowId() + "'");
                            break;
                        default:
                            //super.setCondition("PAR_ROW_ID = '" + conMgr.gettxtRowId() + "'");
                            break;
                    }
                }
                try{
                    countSocialMedia = super.deleteRecord(super.getTblSocialMedia(), super.getCondition());
                    if(countSocialMedia > 0){
                        super.clearCondition();
                        updateArrayAfterDelete("CONTACT");
                    } else {
                        super.clearCondition();
                    }
                } catch (Exception e) {
                    super.clearCondition();
                }
            }
            
            super.setCondition("ROW_ID = '" + conMgr.gettxtRowId() + "'");
            try{
                countContact = super.deleteRecord(super.getTblContact(), super.getCondition());
                if(countContact > 0){
                    JOptionPane.showMessageDialog(null, "Registro(s) removido(s) com sucesso! Total de registros removidos:\nContato: " + countContact + " registro(s)\nRedes Sociais: " + countSocialMedia + " registro(s)");
                    updateArrayAfterDelete("CONTACT");
                    super.clearCondition();
                    return true;
                } else {
                    super.clearCondition();
                    return false;
                }
            } catch (Exception e) {
                super.clearCondition();
                return false;
            }
        } else {
            return false;
        }
        
    }
    
    public void saveContact(){
        try{
            ArrayList<ContactClass> contList = queryContactRecord("SELECT *\nFROM " + getDbOwner() + "." + getTblContact() + "\nWHERE ROW_ID = '" + conMgr.gettxtRowId() + "'");
            if(contList.size() > 0) {
                if(updateContact("CONTACT", null, null, conMgr.gettxtRowId())) {
                    conMgr.enableFields("SALVAR");
                    openContactScreen(
                        "SELECT *\n" +
                        "FROM " + getDbOwner() + "." + getTblContact() + " CON\n" +
                        "WHERE CON.PAR_ROW_ID = '" + getUserId() + "'\n" +
                        "ORDER BY CON.FST_NAME ASC",
                        null
                    );

                    boolean foundRow = true;
                    int i = 0;
                    int o = conMgr.getNumOfListRows();
                    do {
                        if(i < o){
                            try{
                                conMgr.setSelectedRowColumnList(i, 0);
                                if(getLastContUpd().equals(conMgr.getSelectedRowIdContactList())){
                                    fillFieldsContactScreen(
                                        "SELECT *\n" +
                                        "FROM " + getDbOwner() + "." + getTblContact() + "\n" +
                                        "WHERE ROW_ID = '" + getLastContUpd() + "'"
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
                    conMgr.setFocus("FILTRO_VALOR");
                }
            } else {
                if(insertContact()){
                    conMgr.enableFields("SALVAR");
                    openContactScreen(
                        "SELECT *\n" +
                        "FROM " + getDbOwner() + "." + getTblContact() + " CON\n" +
                        "WHERE CON.PAR_ROW_ID = '" + getUserId() + "'\n" +
                        "ORDER BY CON.FST_NAME ASC",
                        null
                    );

                    boolean foundRow = true;
                    int i = 0;
                    int o = conMgr.getNumOfListRows();
                    do {
                        if(i < o){
                            try{
                                conMgr.setSelectedRowColumnList(i, 0);
                                if(getLastContAdd().equals(conMgr.getSelectedRowIdContactList())){
                                    fillFieldsContactScreen(
                                        "SELECT *\n" +
                                        "FROM " + getDbOwner() + "." + getTblContact() + "\n" +
                                        "WHERE ROW_ID = '" + getLastContAdd() + "'"
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
                    conMgr.setFocus("FILTRO_VALOR");
                }
            }
        } catch (Exception e) {
            System.out.println(getDateTime() + "\tContactModule.ContactController\t\tSaveContact\tInsertUpdateContact\tError Exception\tError: " + e);
        }
    }
    
    public boolean insertSocialMedia(){
        String contxId = "";
        if(validateSocialMediaFields()){
            contxId = super.getNextRowId();
            super.clearColumns();
            super.clearValues();
            super.setColumns("ROW_ID"); super.setValues("'" + super.getNextRowId() + "'");
            super.setColumns(",\n\t" + "CREATED"); super.setValues(",\n\t" + "SYSDATE");
            super.setColumns(",\n\t" + "CREATED_BY"); super.setValues(",\n\t" + "'" + super.getUserIdByLogin() + "'");
            super.setColumns(",\n\t" + "LAST_UPD"); super.setValues(",\n\t" + "SYSDATE");
            super.setColumns(",\n\t" + "LAST_UPD_BY"); super.setValues(",\n\t" + "'" + super.getUserIdByLogin() + "'");
            if(this.getOpenFromScreen() != null && !"".equals(this.getOpenFromScreen())){
                switch(this.getOpenFromScreen()){
                    case "USER":
                        super.setColumns(",\n\t" + "PAR_ROW_ID"); super.setValues(",\n\t" + "NULL");
                        super.setColumns(",\n\t" + "PAR_USR_ID"); super.setValues(",\n\t" + "NULL");
                        super.setColumns(",\n\t" + "PAR_ACCNT_ID"); super.setValues(",\n\t" + "NULL");
                        break;
                    default:
                        super.setColumns(",\n\t" + "PAR_ROW_ID"); super.setValues(",\n\t" + "NULL");
                        super.setColumns(",\n\t" + "PAR_USR_ID"); super.setValues(",\n\t" + "NULL");
                        super.setColumns(",\n\t" + "PAR_ACCNT_ID"); super.setValues(",\n\t" + "NULL");
                        break;
                }
            }
            super.setColumns(",\n\t" + "ACTIVE_FLG"); super.setValues(",\n\t" + "'Y'");
            super.setColumns(",\n\t" + "DB_LAST_UPD"); super.setValues(",\n\t" + "SYSDATE");
            super.setColumns(",\n\t" + "SOCIAL_M_NAME"); super.setValues(",\n\t" + "'" + socMedMgr.getcbbSocialMediaType() + "'");
            super.setColumns(",\n\t" + "SOCIAL_M_VALUE"); super.setValues(",\n\t" + "'" + socMedMgr.gettxtSocialMediaValue() + "'");
            super.setColumns(",\n\t" + "STATUS_CD"); super.setValues(",\n\t" + "'" + super.LookupValue("ACCOUNT_STATUS", "Active") + "'");

            try{
                if("true".equals(super.insertRecord(super.getTblSocialMedia(), this.getColumns(), this.getValues()))){
                    socMedia = new SocialMediaRowIdClass();
                    socMedia.setRow_id(contxId);
                    setLastContXAdd(contxId);
                    socialMediaRowIdArray.add(socMedia);
                    this.clearColumns();
                    this.clearValues();
                    return true;
                } else {
                    contxId = "";
                    this.clearColumns();
                    this.clearValues();
                    return false;
                }
            } catch (Exception e) {
                contxId = "";
                this.clearColumns();
                this.clearValues();
                return false;
            }
        } else {
            contxId = "";
            return false;
        }
    }
    
    public boolean updateSocialMedia(String screen, String columnsValues, String condition, String rowId){
        if("SOCIAL_MEDIA".equals(screen)){
            if(validateSocialMediaFields()){        
                this.setLastContXUpd(socMedMgr.gettxtRowId());
                super.clearColumnsValues();
                super.clearCondition();
                super.setColumnsValues("LAST_UPD = SYSDATE");
                super.setColumnsValues(",\n\t" + "LAST_UPD_BY = '" + super.getUserIdByLogin() + "'");
                super.setColumnsValues(",\n\t" + "ACTIVE_FLG = 'Y'");
                super.setColumnsValues(",\n\t" + "DB_LAST_UPD = SYSDATE");
                super.setColumnsValues(",\n\t" + "MODIFICATION_NUM = (SELECT MODIFICATION_NUM + 1 FROM " + super.getDbOwner() + "." + super.getTblSocialMedia() + " WHERE ROW_ID = '" + socMedMgr.gettxtRowId() + "')");
                super.setColumnsValues(",\n\t" + "SOCIAL_M_NAME = '" + socMedMgr.getcbbSocialMediaType() + "'");
                super.setColumnsValues(",\n\t" + "SOCIAL_M_VALUE = '" + socMedMgr.gettxtSocialMediaValue() + "'");
                super.setColumnsValues(",\n\t" + "STATUS_CD = '" + super.LookupValue("ACCOUNT_STATUS", "Active") + "'");
                super.setCondition("ROW_ID = '" + socMedMgr.gettxtRowId() + "'");

                try{
                    this.clearCount();
                    this.setCount(super.updateRecord(super.getTblSocialMedia(), super.getColumnsValues(), super.getCondition()));
                    if(this.getCount() > 0){
                        JOptionPane.showMessageDialog(null, "Registros atualizados com sucesso!\nTotal de registros alterados: " + this.getCount());
                        super.clearColumnsValues();
                        super.clearCondition();
                        return true;
                    } else {
                        super.clearColumnsValues();
                        super.clearCondition();
                        return false;
                    }
                } catch (Exception e) {
                    super.clearColumnsValues();
                    super.clearCondition();
                    return false;
                }
            } else {
                return false;
            }
        } else if("CONTACT".equals(screen)){
            this.setLastContXUpd(socMedMgr.gettxtRowId());
            super.clearColumnsValues();
            super.clearCondition();
            super.setColumnsValues("LAST_UPD = SYSDATE");
            super.setColumnsValues(",\n\t" + "LAST_UPD_BY = '" + super.getUserIdByLogin() + "'");
            super.setColumnsValues(",\n\t" + "ACTIVE_FLG = 'Y'");
            super.setColumnsValues(",\n\t" + "DB_LAST_UPD = SYSDATE");
            super.setColumnsValues(",\n\t" + "MODIFICATION_NUM = (SELECT MODIFICATION_NUM + 1 FROM " + super.getDbOwner() + "." + super.getTblSocialMedia() + " WHERE ROW_ID = '" + rowId + "')");
            if(!"".equals(columnsValues) && columnsValues != null){
                super.setColumnsValues(columnsValues);
            }
            super.setCondition("ROW_ID = '" + rowId + "'");
            if(!"".equals(condition) && condition != null){
                super.setCondition(condition);
            }
            
            try{
                this.clearCount();
                this.setCount(super.updateRecord(super.getTblSocialMedia(), super.getColumnsValues(), super.getCondition()));
                if(this.getCount() > 0){
                    super.clearColumnsValues();
                    super.clearCondition();
                    return true;
                } else {
                    super.clearColumnsValues();
                    super.clearCondition();
                    return false;
                }
            } catch (Exception e) {
                super.clearColumnsValues();
                super.clearCondition();
                return false;
            }            
        } else {
            return false;
        }
        
    }
    
    public boolean deleteSocialMedia(String function, String condition) {
        if("DELETE_BUTTON".equals(function)){
            if(!super.wishDeleteRecord()){
                return false;
            }
        }
        
        super.clearCondition();
        super.setCondition(condition);
        
        try{
            int count = super.deleteRecord(super.getTblSocialMedia(), super.getCondition());
            if(count > 0){
                if("DELETE_BUTTON".equals(function)){ JOptionPane.showMessageDialog(null, "Registro(s) removido(s) com sucesso!\nTotal de registros removidos: " + count + " registro(s)"); }
                super.clearColumnsValues();
                super.clearCondition();
                updateArrayAfterDelete("SOCIAL_MEDIA");
                return true;
            } else {
                super.clearColumnsValues();
                super.clearCondition();
                return false;
            }
        } catch (Exception e) {
            super.clearColumnsValues();
            super.clearCondition();
            return false;
        }
        
    }
    
    public class newContact implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            conMgr.enableFields("NOVO");
            conMgr.clearFields();
            fillNewContactFields();
            conMgr.setFocus("CONTATO_CELULAR");
        }
    }
    
    public class editContact implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            conMgr.enableFields("EDITAR");
            conMgr.setFocus("CONTATO_CELULAR");
        }
    }
    
    public class deleteContact implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if(deleteContact()){
                conMgr.enableFields("DELETAR");
                openContactScreen(
                    "SELECT *\n" +
                    "FROM " + getDbOwner() + "." + getTblContact() + " CON\n" +
                    "WHERE CON.PAR_ROW_ID = '" + getUserId() + "'\n" +
                    "ORDER BY CON.FST_NAME ASC",
                    null
                );
                
            } else {
                conMgr.enableFields("SALVAR");
                if(!"".equals(conMgr.getSelectedRowIdContactList()) && conMgr.getSelectedRowIdContactList() != null){
                    fillFieldsContactScreen(
                        "SELECT *\n" +
                        "FROM " + getDbOwner() + "." + getTblContact() + "\n" +
                        "WHERE ROW_ID = '" + conMgr.getSelectedRowIdContactList() + "'"
                    );
                } else {
                    conMgr.clearFields();
                }
                conMgr.setFocus("FILTRO_VALOR");
            }
        }
        
    }
        
    public class saveContact implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            saveContact();
        }
    }
    
    public class cancelContact implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            try{
                ArrayList<ContactClass> contList = queryContactRecord("SELECT *\nFROM " + getDbOwner() + "." + getTblContact() + "\nWHERE ROW_ID = '" + conMgr.gettxtRowId() + "'");
                if(contList.size() > 0) {
                    if(socialMediaRowIdArray.size() > 0){
                        if(wishSaveRecord()){
                            for(int i = 0; i < socialMediaRowIdArray.size(); i ++){
                                clearColumnsValues();
                                clearCondition();
                                setColumnsValues(",\n\t" + "PAR_ROW_ID = '" + conMgr.gettxtRowId() + "'");
                                if(getOpenFromScreen() != null && !"".equals(getOpenFromScreen())){
                                    switch(getOpenFromScreen()){
                                        case "USER":
                                            if(!"".equals(getUserId()) && getUserId() != null) { setColumnsValues(",\n\t" + "PAR_USR_ID = '" + getUserId() + "'"); } else { setColumnsValues(",\n\t" + "PAR_USR_ID = NULL"); }
                                            break;
                                        default:
                                            break;
                                    }
                                }                            
                                setCondition("\nAND " + "PAR_ROW_ID IS NULL");
                                updateSocialMedia("CONTACT", getColumnsValues(), getCondition(), socialMediaRowIdArray.get(i).getRow_id());
                                clearColumnsValues();
                                clearCondition();
                            }
                        } else {
                            clearCondition();
                            for(int i = 0; i < socialMediaRowIdArray.size(); i++){
                                if(i == 0){
                                    setCondition("\n\t" + "'" + socialMediaRowIdArray.get(i).getRow_id() + "'");
                                } else {
                                    setCondition(",\n\t" + "'" + socialMediaRowIdArray.get(i).getRow_id() + "'");
                                }                            
                            }
                            deleteSocialMedia("CLOSE_CONTACT","ROW_ID IN (" + getCondition() + "\n)\nAND CREATED_BY = '" + getUserIdByLogin() + "'\nAND CREATED >= SYSDATE - 1");
                            
                            clearCondition();
                        }
                    }
                } else {
                    if(socialMediaRowIdArray.size() > 0){
                        clearCondition();
                        for(int i = 0; i < socialMediaRowIdArray.size(); i++){
                            if(i == 0){
                                setCondition("\n\t" + "'" + socialMediaRowIdArray.get(i).getRow_id() + "'");
                            } else {
                                setCondition(",\n\t" + "'" + socialMediaRowIdArray.get(i).getRow_id() + "'");
                            }                            
                        }
                        deleteSocialMedia("CLOSE_CONTACT","ROW_ID IN (" + getCondition() + "\n)\nAND CREATED_BY = '" + getUserIdByLogin() + "'\nAND CREATED >= SYSDATE - 1");
                        clearCondition();
                    }
                }
            } catch (Exception e){
                System.out.println(getDateTime() + "\tContactModule.ContactController\t\tCancelContact\tDeleteUpdateSocialMedia\tError Exception\tError: " + e);
            }
            conMgr.enableFields("CANCELAR");
            if(!"".equals(conMgr.getSelectedRowIdContactList()) && conMgr.getSelectedRowIdContactList() != null){
                fillFieldsContactScreen(
                    "SELECT *\n" +
                    "FROM " + getDbOwner() + "." + getTblContact() + " CON\n" +
                    "WHERE CON.ROW_ID = '" + conMgr.getSelectedRowIdContactList() + "'"
                );
            } else {
                conMgr.clearFields();
            }  
            conMgr.setFocus("FILTRO_VALOR");
        }
    }
    
    public class newSocialMedia implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            socMedMgr.enableFields("NOVO");
            socMedMgr.clearFields();
            socMedMgr.settxtRowId(getNextRowId());
            socMedMgr.setFocus("TIPO_REDE_SOCIAL");
        }
    }
    
    public class editSocialMedia implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            socMedMgr.enableFields("EDITAR");
            socMedMgr.setFocus("TIPO_REDE_SOCIAL");
        }
    }
    
    public class deleteSocialMedia implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if(deleteSocialMedia("DELETE_BUTTON", "ROW_ID = '" + socMedMgr.gettxtRowId() + "'")){
                socMedMgr.enableFields("DELETAR");
                openSocialMediaScreen("LOAD_RECORD");
                
            } else {
                socMedMgr.enableFields("SALVAR");
                if(!"".equals(socMedMgr.getSelectedRowIdContactSocialMediaList()) && socMedMgr.getSelectedRowIdContactSocialMediaList() != null){
                    fillFieldsSocialMediaScreen(
                        "SELECT *\n" +
                        "FROM " + getDbOwner() + "." + getTblSocialMedia() + "\n" +
                        "WHERE ROW_ID = '" + socMedMgr.getSelectedRowIdContactSocialMediaList() + "'"
                    );
                } else {
                    socMedMgr.clearFields();
                }
            }
        }
        
    }
    
    public class saveSocialMedia implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            try{
                ArrayList<SocialMediaClass> ContactXList = querySocialMediaRecord("SELECT *\nFROM " + getDbOwner() + "." + getTblSocialMedia() + "\nWHERE ROW_ID = '" + socMedMgr.gettxtRowId() + "'");

                if(ContactXList.size() > 0){
                    if(updateSocialMedia("SOCIAL_MEDIA", null, null, null)){
                        socMedMgr.enableFields("SALVAR");
                        openSocialMediaScreen("LOAD_RECORD");
                        
                        boolean foundRow = true;
                        int i = 0;
                        int o = socMedMgr.getNumOfListRows();
                        do {
                            if(i < o){
                                try{
                                    socMedMgr.setSelectedRowColumnList(i, 0);
                                    if(getLastContXUpd().equals(socMedMgr.getSelectedRowIdContactSocialMediaList())){
                                        fillFieldsSocialMediaScreen(
                                            "SELECT *\n" +
                                            "FROM " + getDbOwner() + "." + getTblSocialMedia() + "\n" +
                                            "WHERE ROW_ID = '" + getLastContXUpd() + "'"
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
                    }
                } else {
                    if(insertSocialMedia()){
                        socMedMgr.enableFields("SALVAR");
                        openSocialMediaScreen("NEW_RECORD");

                        boolean foundRow = true;
                        int i = 0;
                        int o = socMedMgr.getNumOfListRows();
                        do {
                            if(i < o){
                                try{
                                    socMedMgr.setSelectedRowColumnList(i, 0);
                                    if(getLastContXAdd().equals(socMedMgr.getSelectedRowIdContactSocialMediaList())){
                                        fillFieldsSocialMediaScreen(
                                            "SELECT *\n" +
                                            "FROM " + getDbOwner() + "." + getTblSocialMedia() + "\n" +
                                            "WHERE ROW_ID = '" + getLastContXAdd() + "'"
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
                    }
                }
            } catch(Exception e) {
                System.out.println(getDateTime() + "\tContactModule.ContactController\t\tSaveSocialMedia\tInsertUpdateSocialMedia\tError Exception\tError: " + e);
            }
        }
    }
    
    public class cancelSocialMedia implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            socMedMgr.enableFields("CANCELAR");
            if(!"".equals(socMedMgr.getSelectedRowIdContactSocialMediaList()) && socMedMgr.getSelectedRowIdContactSocialMediaList() != null){
                fillFieldsSocialMediaScreen(
                    "SELECT *\n" +
                    "FROM " + getDbOwner() + "." + getTblSocialMedia() + "\n" +
                    "WHERE ROW_ID = '" + socMedMgr.getSelectedRowIdContactSocialMediaList() + "'"
                );
            } else {
                socMedMgr.clearFields();
            }
            socMedMgr.setFocus("FILTRO_VALOR");
        }
    }
    
    public class openContactSocialMedia implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            socMedMgr = new SocialMediaScreen();
            socMedMgr.setListenerBtnCancel(new cancelSocialMedia());
            socMedMgr.setListenerBtnEdit(new editSocialMedia());
            socMedMgr.setListenerBtnNew(new newSocialMedia());
            socMedMgr.setListenerBtnSave(new saveSocialMedia());
            socMedMgr.setListenerBtnDelete(new deleteSocialMedia());
            socMedMgr.setListenerContactSocialMediaScreen(new contactSocialMediaScreenListener());
            socMedMgr.setListenerTblContactSocialMediaListSelection(new contactSocialMediaListSelected());
            conMgr.setEnabled(false);
                        
            openSocialMediaScreen("LOAD_RECORD");
        }        
    }
    
    public class contactListSelected implements ListSelectionListener {
        
        private int count;

        private contactListSelected() {
            this.count = 0;
        }
        
        @Override
        public void valueChanged(ListSelectionEvent lse) {
            if(count < 1){
                conMgr.clearFields();
                fillFieldsContactScreen("SELECT *\nFROM " + getDbOwner() + "." + getTblContact() + "\nWHERE ROW_ID = '" + conMgr.getSelectedRowIdContactList() + "'");
                conMgr.setbtnEditEnabled(true);
                conMgr.setbtnDeleteEnabled(true);
                count++;
            } else {
                count = 0;
            }
        }
    }
    
    public class contactSocialMediaListSelected implements ListSelectionListener {
        
        private int count;

        private contactSocialMediaListSelected() {
            this.count = 0;
        }
        
        @Override
        public void valueChanged(ListSelectionEvent lse) {
            if(count < 1){
                socMedMgr.clearFields();
                fillFieldsSocialMediaScreen("SELECT *\nFROM " + getDbOwner() + "." + getTblSocialMedia() + "\nWHERE ROW_ID = '" + socMedMgr.getSelectedRowIdContactSocialMediaList() + "'");
                socMedMgr.setbtnEditEnabled(true);
                socMedMgr.setbtnDeleteEnabled(true);
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
        public void windowClosing(WindowEvent we) {
            if(conMgr.isbtnSaveEnabled() || conMgr.isbtnCancelEnabled()){
                if(wishSaveRecord()){
                    try{
                        ArrayList<ContactClass> contList = queryContactRecord("SELECT *\nFROM " + getDbOwner() + "." + getTblContact() + "\nWHERE ROW_ID = '" + conMgr.gettxtRowId() + "'");
                        if(contList.size() > 0) {
                            if(!updateContact("CONTACT", null, null, conMgr.gettxtRowId())) {
                                if(socialMediaRowIdArray.size() > 0){
                                    clearCondition();
                                    for(int i = 0; i < socialMediaRowIdArray.size(); i++){
                                        if(i == 0){
                                            setCondition("\n\t" + "'" + socialMediaRowIdArray.get(i).getRow_id() + "'");
                                        } else {
                                            setCondition(",\n\t" + "'" + socialMediaRowIdArray.get(i).getRow_id() + "'");
                                        }                            
                                    }
                                    deleteSocialMedia("CLOSE_CONTACT","ROW_ID IN (" + getCondition() + "\n)\nAND CREATED_BY = '" + getUserIdByLogin() + "'\nAND CREATED >= SYSDATE - 1");
                                    clearCondition();
                                }
                                
                            }
                            conMgr.dispose();
                        } else {
                            if(socialMediaRowIdArray.size() > 0){
                                clearCondition();
                                for(int i = 0; i < socialMediaRowIdArray.size(); i++){
                                    if(i == 0){
                                        setCondition("\n\t" + "'" + socialMediaRowIdArray.get(i).getRow_id() + "'");
                                    } else {
                                        setCondition(",\n\t" + "'" + socialMediaRowIdArray.get(i).getRow_id() + "'");
                                    }                            
                                }
                                deleteSocialMedia("CLOSE_CONTACT","ROW_ID IN (" + getCondition() + "\n)\nAND CREATED_BY = '" + getUserIdByLogin() + "'\nAND CREATED >= SYSDATE - 1");
                                clearCondition();
                            }
                            conMgr.dispose();
                        }
                    } catch (Exception e){
                        System.out.println(getDateTime() + "\tContactModule.ContactController\t\tCancelContact\tDeleteUpdateSocialMedia\tError Exception\tError: " + e);
                    }
                } else {
                    if(socialMediaRowIdArray.size() > 0){
                        clearCondition();
                        for(int i = 0; i < socialMediaRowIdArray.size(); i++){
                            if(i == 0){
                                setCondition("\n\t" + "'" + socialMediaRowIdArray.get(i).getRow_id() + "'");
                            } else {
                                setCondition(",\n\t" + "'" + socialMediaRowIdArray.get(i).getRow_id() + "'");
                            }                            
                        }
                        deleteSocialMedia("CLOSE_CONTACT","ROW_ID IN (" + getCondition() + "\n)\nAND CREATED_BY = '" + getUserIdByLogin() + "'\nAND CREATED >= SYSDATE - 1");
                        clearCondition();
                    }
                    conMgr.dispose();
                }
            } else {
                conMgr.dispose();
            }
        }

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
        
    }
    
    public class contactSocialMediaScreenListener implements WindowListener{

        @Override
        public void windowOpened(WindowEvent we) { }

        @Override
        public void windowClosing(WindowEvent we) {
            if(socMedMgr.isbtnSaveEnabled() || socMedMgr.isbtnCancelEnabled()){
                if(wishSaveRecord()){
                    try{
                        ArrayList<SocialMediaClass> ContactXList = querySocialMediaRecord("SELECT *\nFROM " + getDbOwner() + "." + getTblSocialMedia() + "\nWHERE ROW_ID = '" + socMedMgr.gettxtRowId() + "'");

                        if(ContactXList.size() > 0){
                            if(updateSocialMedia("SOCIAL_MEDIA", null, null, null)){
                                socMedMgr.enableFields("SALVAR");
                                socMedMgr.dispose();
                            }
                        } else {
                            if(insertSocialMedia()){
                                socMedMgr.enableFields("SALVAR");
                                socMedMgr.dispose();
                            }
                        }
                    } catch(Exception e) {
                        System.out.println(getDateTime() + "\tContactModule.ContactController\t\tSaveSocialMedia\tInsertUpdateSocialMedia\tError Exception\tError: " + e);
                    }
                } else {
                    socMedMgr.dispose();
                }
            } else {
                socMedMgr.dispose();
            }
        }

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
    
    public class contactRowIdClass {
        private String row_id;

        public contactRowIdClass() {
            this.row_id = null;
        }

        public String getRow_id() { return row_id; }
        public void setRow_id(String row_id) { this.row_id = row_id; }
        
    }
    
    public class SocialMediaRowIdClass {
        private String row_id;

        public SocialMediaRowIdClass() {
            this.row_id = null;
        }

        public String getRow_id() { return row_id; }
        public void setRow_id(String row_id) { this.row_id = row_id; }
        
    }
    
}
