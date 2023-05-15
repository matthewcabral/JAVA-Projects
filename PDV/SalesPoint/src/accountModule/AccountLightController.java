/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accountModule;

import addressModule.AddressController;
import contactModule.ContactController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.awt.HeadlessException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mathe
 */
public class AccountLightController extends Account {
    
    public AccountLightController() throws InterruptedException { }
    
    @Override
    public void openAccountScreen(String screen, String query){
        try {
            contCtrl = new ContactController();
            contCtrl.setDbUser(super.getDbUser());
            contCtrl.setDbPassword(super.getDbPassword());
        } catch (InterruptedException ex) {
            Logger.getLogger(AccountLightController.class.getName()).log(Level.SEVERE, null, ex);
        }
        accntLightScreen = new AccountLightScreen();
        accntLightScreen.setListenerBtnEdit(new buttonEdit());
        accntLightScreen.setListenerBtnNew(new buttonNew());
        accntLightScreen.setListenerBtnSave(new buttonSave());
        accntLightScreen.setListenerBtnCancel(new buttonCancel());
        accntLightScreen.setListenerBtnDelete(new buttonDelete());
        accntLightScreen.setListenerBtnAddAddress(new manageAddress());
        accntLightScreen.setListenerTblAccountListSelection(new ListSelected());
        accntLightScreen.setListenercbbListFilterValue(new CbbListFilterItemState());
        accntLightScreen.setListenertxtListFilterValue(new TxtListFilterValue());
        switch(screen) {
            case "MAIN":
                query = 
                    "SELECT\n" +
                    "\t" + "ACC.ROW_ID" + ",\n" +
                    "\t" + "ACC.CREATED" + ",\n" +
                    "\t" + "ACC.CREATED_BY" + ",\n" +
                    "\t" + "ACC.LAST_UPD" + ",\n" +
                    "\t" + "ACC.LAST_UPD_BY" + ",\n" +
                    "\t" + "ACC.MODIFICATION_NUM" + ",\n" +
                    "\t" + "ACC.PAR_ROW_ID" + ",\n" +
                    "\t" + "ACC.DB_LAST_UPD" + ",\n" +
                    "\t" + "ACC.ACTIVE_FLG" + ",\n" +
                    "\t" + "ACC.ACCNT_NUMBER" + ",\n" +
                    "\t" + "ACC.ACCNT_FLG" + ",\n" +
                    "\t" + "ACC.DOC_TYPE" + ",\n" +
                    "\t" + "ACC.DOC_NUM" + ",\n" +
                    "\t" + "ACC.ALIAS_NAME" + ",\n" +
                    "\t" + "ACC.NOME_FANTASIA" + ",\n" +
                    "\t" + "ACC.FST_NAME" + ",\n" +
                    "\t" + "ACC.LAST_NAME" + ",\n" +
                    "\t" + "ACC.FULL_NAME" + ",\n" +
                    "\t" + "ACC.SEX_MF" + ",\n" +
                    "\t" + "CON.MAIN_PH_NUM" + ",\n" +
                    "\t" + "CON.EMAIL_ADDR" + ",\n" +
                    "\t" + "FACE.SOCIAL_M_VALUE     AS \"FACEBOOK\"" + ",\n" +
                    "\t" + "TWIT.SOCIAL_M_VALUE     AS \"TWITTER\"" + ",\n" +
                    "\t" + "INST.SOCIAL_M_VALUE     AS \"INSTAGRAM\"" + ",\n" +
                    "\t" + "ADDR.ADDR_NAME" + "\n" +
                    "FROM PDV.T_ACCOUNT ACC" + "\n" +
                    "LEFT JOIN PDV.T_CONTACT CON ON CON.PAR_ROW_ID = ACC.ROW_ID" + "\n" +
                    "LEFT JOIN PDV.T_CONTACT_X FACE ON FACE.PAR_ROW_ID = CON.ROW_ID AND FACE.SOCIAL_M_NAME = 'Facebook'" + "\n" +
                    "LEFT JOIN PDV.T_CONTACT_X TWIT ON TWIT.PAR_ROW_ID = CON.ROW_ID AND TWIT.SOCIAL_M_NAME = 'Twitter'" + "\n" +
                    "LEFT JOIN PDV.T_CONTACT_X INST ON INST.PAR_ROW_ID = CON.ROW_ID AND INST.SOCIAL_M_NAME = 'Instagram'" + "\n" +
                    "LEFT JOIN PDV.T_ADDRESS ADDR ON ADDR.PAR_ROW_ID = ACC.ROW_ID AND ADDR.PR_ADDR_FLG = 'Y'" + "\n" +
                    "WHERE 1=1" + "\n" +
                    "ORDER BY ACC.ACCNT_NUMBER ASC";
                break;
            default:
                break;
        }
        
        accntLightScreen.clearFields();
        accntLightScreen.clearComboBoxes();
        accntLightScreen.enableFields("LOAD_SCREEN");
        accntLightScreen.insertSelectComboBox();
        this.fillComboBoxes("ACCOUNT_FILTER");
        this.fillComboBoxes("SEX_MF");
        
        this.fillList(query, "");
        accntLightScreen.setSelectedRowColumnList(0, 0);
        
        accntLightScreen.setFocus("FILTRO_VALOR");
    }
    
    @Override
    public void fillComboBoxes(String LovType){
        try{
            ArrayList<ListOfValuesClass> lov = super.LookupList(LovType);
            
            if(lov.size() > 0){
                for(int i = 0; i < lov.size(); i++){
                    if(null == LovType){
                        JOptionPane.showMessageDialog(null, "O LOV_TYPE 'null' não existe!");
                    } else switch (LovType) {
                        case "ACCOUNT_FILTER": accntLightScreen.setcbbListFilter(lov.get(i).getValue()); break;
                        case "SEX_MF": accntLightScreen.setcbbSex(lov.get(i).getValue()); break;
                        default: JOptionPane.showMessageDialog(null, "O LOV_TYPE '" + LovType +  "' não é utilizado por nenhum ComboBox!"); break;
                    }
                }
            }
        } catch(HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher ComboBoxes...\nErro: " + e);
        }
    }
    
    @Override
    public void fillList(String query, String method) {
        DefaultTableModel table = (DefaultTableModel) accntLightScreen.getTableModel();
        switch(method){
            case "INSERT_RECORD":
                int newRow = table.getRowCount() + 1;
                try{
                    table.addRow(
                        new Object[] {
                            accntLightScreen.gettxtAccountNumber(),
                            accntLightScreen.gettxtName(),
                            accntLightScreen.gettxtSurname(),
                            accntLightScreen.gettxtContactMPhone(),
                            accntLightScreen.gettxtContactEmail(),
                            accntLightScreen.gettxtFacebook(),
                            accntLightScreen.gettxtInstagram(),
                            accntLightScreen.gettxtTwitter(),
                            accntLightScreen.gettxtFullAddress()
                        }
                    );
                } catch(Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro ao preencher tabela...\nErro: " + e);
                }
                break;
            case "UPDATE_RECORD":
                try{
                    table.setValueAt(accntLightScreen.gettxtAccountNumber(), accntLightScreen.getSelectedRowList(), 0);
                    table.setValueAt(accntLightScreen.gettxtName(), accntLightScreen.getSelectedRowList(), 1);
                    table.setValueAt(accntLightScreen.gettxtSurname(), accntLightScreen.getSelectedRowList(), 2);
                    table.setValueAt(accntLightScreen.gettxtContactMPhone(), accntLightScreen.getSelectedRowList(), 3);
                    table.setValueAt(accntLightScreen.gettxtContactEmail(), accntLightScreen.getSelectedRowList(), 4);
                    table.setValueAt(accntLightScreen.gettxtFacebook(), accntLightScreen.getSelectedRowList(), 5);
                    table.setValueAt(accntLightScreen.gettxtInstagram(), accntLightScreen.getSelectedRowList(), 6);
                    table.setValueAt(accntLightScreen.gettxtTwitter(), accntLightScreen.getSelectedRowList(), 7);
                    table.setValueAt(accntLightScreen.gettxtFullAddress(), accntLightScreen.getSelectedRowList(), 8);
                } catch(Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro ao preencher tabela...\nErro: " + e);
                }
                break;
            case "FILTER_RECORD":
                try{
                    ArrayList<AccountClass> accntList = super.queryAccountRecord(query);
                    ArrayList<ContactClass> contList;
                    ArrayList<SocialMediaClass> socMedList;
                    ArrayList<AddressClass> addrList;
                    
                    try{ AccntIdArray.clear(); } catch (Exception e) {}

                    if(accntList.size() > 0){
                        int count = accntList.size();
                        try{ table.setRowCount(count); } catch (Exception e) {}
                        try{ table.setNumRows(count); } catch (Exception e) {}
                        
                        for(int i = 0; i < count; i++){
                            AccntId = new accountIdClass();
                            AccntId.setRowId(accntList.get(i).getRowId());
                            AccntIdArray.add(AccntId);
                            table.setValueAt(accntList.get(i).getACCNT_NUMBER(), i, 0);
                            table.setValueAt(accntList.get(i).getFST_NAME(), i, 1);
                            table.setValueAt(accntList.get(i).getLAST_NAME(), i, 2);
                            
                            contList = queryContactRecord("SELECT *\nFROM " + getDbOwner() + "." + getTblContact() + " CON\nWHERE CON.PAR_ROW_ID = '" + accntList.get(i).getRowId() + "'\nAND CON.PR_CON_FLG = 'Y'");
                            if(contList.size() > 0){
                                table.setValueAt(((contList.get(0).getMAIN_PH_NUM() != null) ? contList.get(0).getMAIN_PH_NUM() : ""), i, 3);
                                table.setValueAt(((contList.get(0).getEMAIL_ADDR() != null) ? contList.get(0).getEMAIL_ADDR() : ""), i, 4);
                                // Social Media Information
                                socMedList = querySocialMediaRecord("SELECT *\nFROM " + getDbOwner() + "." + getTblSocialMedia()+ " SOC\nWHERE SOC.PAR_ROW_ID = '" + contList.get(0).getRow_id() + "'");
                                if(socMedList.size() > 0) {
                                    for(int sm = 0; sm < socMedList.size(); sm++) {
                                        if(null != socMedList.get(sm).getSOCIAL_M_NAME()) {
                                            switch (socMedList.get(sm).getSOCIAL_M_NAME()) {
                                                case "Facebook":
                                                    table.setValueAt(socMedList.get(sm).getSOCIAL_M_VALUE(), i, 5);
                                                    break;
                                                case "Instagram":
                                                    table.setValueAt(socMedList.get(sm).getSOCIAL_M_VALUE(), i, 6);
                                                    break;
                                                case "Twitter":
                                                    table.setValueAt(socMedList.get(sm).getSOCIAL_M_VALUE(), i, 7);
                                                    break;
                                                default:
                                                    break;
                                            }
                                        }
                                    }
                                } else {
                                    table.setValueAt("", i, 5);
                                    table.setValueAt("", i, 6);
                                    table.setValueAt("", i, 7); 
                                }
                            } else {
                                table.setValueAt("", i, 3);
                                table.setValueAt("", i, 4);
                                table.setValueAt("", i, 5);
                                table.setValueAt("", i, 6);
                                table.setValueAt("", i, 7);
                            }

                            // Address Information
                            addrList = queryAddressRecord("SELECT *\nFROM " + getDbOwner() + "." + getTblAddress() + " ADDR\nWHERE ADDR.PAR_ROW_ID = '" + accntList.get(i).getRowId() +  "'\nAND ADDR.PR_ADDR_FLG = 'Y'");
                            if(addrList.size() > 0) {
                                for(int a = 0; a < addrList.size(); a++) {
                                    table.setValueAt(((addrList.get(a).getADDR_NAME() != null) ? addrList.get(a).getADDR_NAME() : ""), i, 8);
                                }
                            } else {
                                table.setValueAt("", i, 8);
                            }
                        }
                        
                    } else {
                        table.setRowCount(0);
                    }

                } catch(Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro ao preencher tabela...\nErro: " + e);
                }
                break;
            default:
                try{
                    ArrayList<AccountLightClass> accntList = super.queryAccountLightRecord(query);
                    
                    try{ AccntIdArray.clear(); } catch (Exception e) {}

                    if(accntList.size() > 0){
                        int count = accntList.size();
                        try{ table.setRowCount(count); } catch (Exception e) {}
                        try{ table.setNumRows(count); } catch (Exception e) {}
                        
                        for(int i = 0; i < count; i++){
                            AccntId = new accountIdClass();
                            AccntId.setRowId(accntList.get(i).getRowId());
                            AccntIdArray.add(AccntId);
                            table.setValueAt(accntList.get(i).getACCNT_NUMBER(), i, 0);
                            table.setValueAt(accntList.get(i).getFST_NAME(), i, 1);
                            table.setValueAt(accntList.get(i).getLAST_NAME(), i, 2);
                            
                            table.setValueAt(accntList.get(i).getMAIN_PH_NUM(), i, 3);
                            table.setValueAt(accntList.get(i).getEMAIL_ADDR(), i, 4);
                            table.setValueAt(accntList.get(i).getSOCIAL_M_FACEBOOK(), i, 5);
                            table.setValueAt(accntList.get(i).getSOCIAL_M_TWITTER(), i, 6);
                            table.setValueAt(accntList.get(i).getSOCIAL_M_INSTAGRAM(), i, 7);
                            table.setValueAt(accntList.get(i).getADDR_NAME(), i, 8);
                            
                        }
                        
                    } else {
                        table.setRowCount(0);
                    }

                } catch(Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro ao preencher tabela...\nErro: " + e);
                }
                break;
        }
        accntLightScreen.setlblRecCount("0 - " + String.valueOf(AccntIdArray.size()));
    }
    
    @Override
    public void fillFields(String query){
        try{
            ArrayList<AccountClass> accntList = queryAccountRecord(query);
            ArrayList<ContactClass> contList;
            ArrayList<SocialMediaClass> socMedList;
            ArrayList<AddressClass> addrList;
            
            if(accntList.size() > 0){
                for(int i = 0; i < accntList.size(); i++){
                    accntLightScreen.setlblAccountNameHeader(accntList.get(i).getFULL_NAME());
                    accntLightScreen.settxtRowId(accntList.get(i).getRowId());
                    accntLightScreen.settxtAccountNumber(accntList.get(i).getACCNT_NUMBER());
                    accntLightScreen.settxtName(accntList.get(i).getFST_NAME());
                    accntLightScreen.settxtSurname(accntList.get(i).getLAST_NAME());
                    accntLightScreen.setcbbSexItemIndex(accntLightScreen.getcbbSexItemIndex(super.LookupValue("SEX_MF", accntList.get(i).getSEX_MF())));
                    
                    // Contact Information
                    contList = super.queryContactRecord("SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblContact() + " CON\nWHERE CON.PAR_ROW_ID = '" + accntList.get(i).getRowId() + "'\nAND CON.PR_CON_FLG = 'Y'");
                    if(contList.size() > 0){
                        for(int c = 0; c < contList.size(); c++) {
                            accntLightScreen.settxtContactMPhone(contList.get(c).getMAIN_PH_NUM());
                            accntLightScreen.settxtContactEmail(contList.get(c).getEMAIL_ADDR());
                            accntLightScreen.settxtContactPhone(contList.get(c).getALT_PH_NUM());
                            accntLightScreen.settxtContactEnterprise(contList.get(c).getWORK_PH_NUM());
                        }
                        
                        // Social Media Information
                        socMedList = super.querySocialMediaRecord("SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblSocialMedia()+ " SOC\nWHERE SOC.PAR_ROW_ID = '" + contList.get(i).getRow_id() + "'");
                        for(int cx = 0; cx < socMedList.size(); cx++) {
                            if(null != socMedList.get(cx).getSOCIAL_M_NAME()) {
                                switch (socMedList.get(cx).getSOCIAL_M_NAME()) {
                                    case "Facebook":
                                        accntLightScreen.settxtFacebook(socMedList.get(cx).getSOCIAL_M_VALUE());
                                        break;
                                    case "Twitter":
                                        accntLightScreen.settxtTwitter(socMedList.get(cx).getSOCIAL_M_VALUE());
                                        break;
                                    case "Instagram":
                                        accntLightScreen.settxtInstagram(socMedList.get(cx).getSOCIAL_M_VALUE());
                                        break;
                                    default:
                                        break;
                                }
                            }
                        }
                    }
                    
                    // Address Information
                    addrList = super.queryAddressRecord("SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblAddress() + " ADDR\nWHERE ADDR.PAR_ROW_ID = '" + accntList.get(i).getRowId() +  "'\nAND ADDR.PR_ADDR_FLG = 'Y'");
                    if(addrList.size() > 0) {
                        for(int a = 0; a < addrList.size(); a++) {
                            accntLightScreen.settxtFullAddress(addrList.get(a).getADDR_NAME());
                        }
                    }
                }
            }

        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher Campos...\nErro: " + e);
        }
    }
    
    @Override
    public void fillFieldsNewRecord(){
        accntLightScreen.settxtRowId(super.getNextRowId());
        accntLightScreen.settxtAccountNumber(super.getNextAccountNumber());
    }
    
    @Override
    public boolean validateMandatoryFields(){
        String mensagem = "";
        int i = 0;
        
        if(accntLightScreen.gettxtName() == null) { mensagem += "\n- " + "Nome" + ";"; i = (i < 1) ? 1 : i; }
        if(accntLightScreen.gettxtSurname() == null) { mensagem += "\n- " + "Sobrenome" + ";"; i = (i < 2 && i != 0) ? i : 2; }
        if(accntLightScreen.getcbbSex() == null) { mensagem += "\n- " + "Sexo" + ";"; i = (i < 3 && i != 0) ? i : 3; }
        if(accntLightScreen.gettxtContactMPhone() == null) { mensagem += "\n- " + "Celular/WhatsApp" + ";"; i = (i < 4 && i != 0) ? i : 4; }
        
        switch(i){
            case 1: accntLightScreen.setFocus("NOME"); break;
            case 2: accntLightScreen.setFocus("SOBRENOME"); break;
            case 3: accntLightScreen.setFocus("SEXO"); break;
            case 4: accntLightScreen.setFocus("CONTATO_CELULAR"); break;
            default: break;
        }
        
        if(!"".equals(mensagem)){
            JOptionPane.showMessageDialog(null, "Os campos abaixo são obrigatórios. Favor preencher os mesmos:" + mensagem);
            return false;
        } else {
            return true;
        }
    }
    
    @Override
    public boolean validateFieldValues(){
        // Validate Field Sizes
        String AccntNum = accntLightScreen.gettxtAccountNumber();
        String name = accntLightScreen.gettxtName();
        String surname = accntLightScreen.gettxtSurname();
        String mobilePhone = accntLightScreen.gettxtContactMPhone();
        String phone = accntLightScreen.gettxtContactPhone();
        String workPhone = accntLightScreen.gettxtContactEnterprise();
        String email = accntLightScreen.gettxtContactEmail();
        String facebook = accntLightScreen.gettxtFacebook();
        String twitter = accntLightScreen.gettxtTwitter();
        String instagram = accntLightScreen.gettxtInstagram();
        
        
        if((AccntNum != null) && (AccntNum.length() > getAccntNumberColumnSize())) { JOptionPane.showMessageDialog(null, "O tamanho do campo 'Número do Cliente' deve ter no máximo: " + getAccntNumberColumnSize() + " caractere(s)"); return false; }
        if((name != null) && (name.length() > getFirstNameColumnSize())) { JOptionPane.showMessageDialog(null, "O tamanho do campo 'Nome' deve ter no máximo: " + getFirstNameColumnSize() + " caractere(s)"); return false; }
        if((surname != null) && (surname.length() > getLastNameColumnSize())) { JOptionPane.showMessageDialog(null, "O tamanho do campo 'Sobrenome' deve ter no máximo: " + getLastNameColumnSize() + " caractere(s)"); return false; }
        if((mobilePhone != null) && (mobilePhone.length() > getContMainPhNumColumnSize())) { JOptionPane.showMessageDialog(null, "O tamanho do campo 'Celular/WhatsApp' deve ter no máximo: " + getContMainPhNumColumnSize() + " caractere(s)"); return false; }
        if((phone != null) && (phone.length() > getContPhNumColumnSize())) { JOptionPane.showMessageDialog(null, "O tamanho do campo 'Telefone Fixo' deve ter no máximo: " + getContPhNumColumnSize() + " caractere(s)"); return false; }
        if((workPhone != null) && (workPhone.length() > getContWorkPhNumColumnSize())) { JOptionPane.showMessageDialog(null, "O tamanho do campo 'Telefone Comercial' deve ter no máximo: " + getContWorkPhNumColumnSize() + " caractere(s)"); return false; }
        if((email != null) && (email.length() > getContEmailAddrColumnSize())) { JOptionPane.showMessageDialog(null, "O tamanho do campo 'Email' deve ter no máximo: " + getContEmailAddrColumnSize() + " caractere(s)"); return false; }
        if((facebook != null) && (facebook.length() > getSocMedValueColumnSize())) { JOptionPane.showMessageDialog(null, "O tamanho do campo 'Facebook' deve ter no máximo: " + getSocMedValueColumnSize() + " caractere(s)"); return false; }
        if((twitter != null) && (twitter.length() > getSocMedValueColumnSize())) { JOptionPane.showMessageDialog(null, "O tamanho do campo 'Twitter' deve ter no máximo: " + getSocMedValueColumnSize() + " caractere(s)"); return false; }
        if((instagram != null) && (instagram.length() > getSocMedValueColumnSize())) { JOptionPane.showMessageDialog(null, "O tamanho do campo 'Instagram' deve ter no máximo: " + getSocMedValueColumnSize() + " caractere(s)"); return false; }
        
        return true;
    }
    
    @Override
    public boolean insert(){
        String accntId = super.getNextRowId();
        String accntNumber = super.getNextAccountNumber();
        super.clearColumns();
        super.clearValues();
        
        super.setColumns(",\n\t" + "ACCNT_NUMBER"); super.setValues(",\n\t" + "'" + accntNumber + "'");
        super.setColumns(",\n\t" + "FST_NAME"); super.setValues(",\n\t" + ((accntLightScreen.gettxtName() != null) ? "'" + accntLightScreen.gettxtName() + "'" : "NULL"));
        super.setColumns(",\n\t" + "LAST_NAME"); super.setValues(",\n\t" + ((accntLightScreen.gettxtSurname() != null) ? "'" + accntLightScreen.gettxtSurname() + "'" : "NULL"));
        super.setColumns(",\n\t" + "FULL_NAME"); super.setValues(",\n\t" + ((accntLightScreen.gettxtName() != null && accntLightScreen.gettxtSurname() != null) ? "'" + accntLightScreen.gettxtName() + " " + accntLightScreen.gettxtSurname() + "'" : "NULL"));
        super.setColumns(",\n\t" + "SEX_MF"); super.setValues(",\n\t" + ((accntLightScreen.getcbbSex() != null) ? "'" + super.LookupName("SEX_MF", accntLightScreen.getcbbSex()) + "'" : "NULL"));
        super.setColumns(",\n\t" + "CREATOR_LOGIN"); super.setValues(",\n\t" + "'" + super.getDbUser() + "'");
        super.setColumns(",\n\t" + "STATUS_CD"); super.setValues(",\n\t" + "'Potential'");
        super.setColumns(",\n\t" + "ACTIVE_FLG"); super.setValues(",\n\t" + "'Y'");
        super.setColumns(",\n\t" + "ACCNT_FLG"); super.setValues(",\n\t" + "'Y'");
        super.setColumns(",\n\t" + "POTENTIAL_FLG"); super.setValues(",\n\t" + "'Y'");
        super.setColumns(",\n\t" + "ENTERPRISE_FLAG"); super.setValues(",\n\t" + "'N'");
        super.setColumns(",\n\t" + "PODER_PUBLICO_FLG"); super.setValues(",\n\t" + "'N'");
        super.setColumns(",\n\t" + "PARTNER_FLG"); super.setValues(",\n\t" + "'N'");
        
        try {
            if("true".equals(super.insertRecord(super.getTblAccount(), super.getColumns(), super.getValues()))){
                super.generateAccountNumberTrigger();
                AccntId = new accountIdClass();
                AccntId.setRowId(accntId);
                AccntIdArray.add(AccntId);
                this.setLastAccntAdd(accntId);
                this.clearColumns();
                this.clearValues();
                super.setSilentInsertMode(true);
                
                String contactId = super.getNextRowId();
                super.setColumns(",\n\t" + "ACTIVE_FLG"); super.setValues(",\n\t" + "'Y'");
                super.setColumns(",\n\t" + "STATUS_CD"); super.setValues(",\n\t" + "'Potential'");
                super.setColumns(",\n\t" + "PAR_ROW_ID"); super.setValues(",\n\t" + "'" + accntId + "'");
                super.setColumns(",\n\t" + "EMP_FLG"); super.setValues(",\n\t" + "'N'");
                super.setColumns(",\n\t" + "PR_CON_FLG"); super.setValues(",\n\t" + "'Y'");
                super.setColumns(",\n\t" + "POTENTIAL_FLG"); super.setValues(",\n\t" + "'Y'");
                super.setColumns(",\n\t" + "ENTERPRISE_FLAG"); super.setValues(",\n\t" + "'N'");
                super.setColumns(",\n\t" + "SUPPRESS_EMAIL_FLG"); super.setValues(",\n\t" + "'Y'");
                super.setColumns(",\n\t" + "SEND_NEWS_FLG"); super.setValues(",\n\t" + "'Y'");
                super.setColumns(",\n\t" + "SEND_PROMOTES_FLG"); super.setValues(",\n\t" + "'Y'");
                super.setColumns(",\n\t" + "SUPPRESS_CALL_FLG"); super.setValues(",\n\t" + "'Y'");
                super.setColumns(",\n\t" + "WHATSAPP_FLG"); super.setValues(",\n\t" + "'Y'");
                super.setColumns(",\n\t" + "CONSUMER_FLG"); super.setValues(",\n\t" + "'N'");
                super.setColumns(",\n\t" + "MAIN_PH_NUM"); super.setValues(",\n\t" + ((accntLightScreen.gettxtContactMPhone() != null) ? "'" + accntLightScreen.gettxtContactMPhone().replaceAll("[( )-]", "") + "'" : "NULL"));
                super.setColumns(",\n\t" + "ALT_PH_NUM"); super.setValues(",\n\t" + ((accntLightScreen.gettxtContactPhone() != null) ? "'" + accntLightScreen.gettxtContactPhone().replaceAll("[( )-]", "") + "'" : "NULL"));
                super.setColumns(",\n\t" + "WORK_PH_NUM"); super.setValues(",\n\t" + ((accntLightScreen.gettxtContactEnterprise() != null) ? "'" + accntLightScreen.gettxtContactEnterprise().replaceAll("[( )-]", "") + "'" : "NULL"));
                if(accntLightScreen.gettxtContactEmail() != null) {
                    super.setColumns(",\n\t" + "EMAIL_ADDR"); super.setValues(",\n\t" + "'" + accntLightScreen.gettxtContactEmail() + "'");
                    String mail = accntLightScreen.gettxtContactEmail();
                    String mailTypeTemp = mail.substring(mail.indexOf("@") + 1, mail.length());
                    String mailTypeName = super.LookupName("EMAIL_ADDR_TYPE", mailTypeTemp);
                    super.setColumns(",\n\t" + "EMAIL_TYPE"); super.setValues(",\n\t" + ((!"".equals(mailTypeName) && mailTypeName != null) ? "'" + mailTypeName + "'" : "NULL"));
                } else {
                    super.setColumns(",\n\t" + "EMAIL_ADDR"); super.setValues(",\n\t" + "NULL");
                    super.setColumns(",\n\t" + "EMAIL_TYPE"); super.setValues(",\n\t" + "NULL");
                }
                try{
                    if("true".equals(super.insertRecord(super.getTblContact(), super.getColumns(), super.getValues()))){
                        this.clearColumns();
                        this.clearValues();
                        
                        super.clearSocialNameArray();
                        if(accntLightScreen.gettxtFacebook() != null){ socialName.add("Facebook"); }
                        if(accntLightScreen.gettxtInstagram() != null){ socialName.add("Instagram"); }
                        if(accntLightScreen.gettxtTwitter() != null){ socialName.add("Twitter"); }
                        
                        if(socialName.size() > 0) {
                            ArrayList<SocialMediaClass> socialMedia = new ArrayList<>();
                            SocialMediaClass smClass;
                            for(int i = 0; i < socialName.size(); i++) {
                                smClass = new SocialMediaClass();
                                smClass.setParRowId(contactId);
                                smClass.setPAR_USR_ID(null);
                                smClass.setPAR_ACCNT_ID(accntId);
                                smClass.setACTIVE_FLG("Y");
                                smClass.setSTATUS_CD("Active");
                                smClass.setSOCIAL_M_NAME(socialName.get(i));
                                switch(socialName.get(i)){
                                    case "Facebook":
                                        smClass.setSOCIAL_M_VALUE(accntLightScreen.gettxtFacebook());
                                        break;
                                    case "Instagram":
                                        smClass.setSOCIAL_M_VALUE(accntLightScreen.gettxtInstagram());
                                        break;
                                    case "Twitter":
                                        smClass.setSOCIAL_M_VALUE(accntLightScreen.gettxtTwitter());
                                        break;
                                    default:
                                        smClass.setSOCIAL_M_VALUE(null);
                                        break;
                                }
                                socialMedia.add(smClass);
                            }
                            contCtrl.insertMultipleSocialMedia(socialMedia);
                        }
                    } else {
                        this.clearColumns();
                        this.clearValues();
                    }
                } catch (Exception e) {
                    this.clearColumns();
                    this.clearValues();
                }
                
                try{
                    if(addrCtrl.getAddressRowIdArray().size() > 0){
                        for(int i = 0; i < addrCtrl.getAddressRowIdArray().size(); i ++){
                            super.clearColumnsValues();
                            super.clearCondition();
                            super.setColumnsValues(",\n\t" + "PAR_ROW_ID = '" + accntId + "'");

                            try{
                                addrCtrl.update("ACCOUNT", super.getColumnsValues(), super.getCondition(), addrCtrl.getAddressRowIdArray().get(i).getRow_id());
                            } catch(Exception e) {
                                System.out.println(super.getDateTime() + "\tContactModule.ContactController\t\tinsertContact\nUpdateSocialMedia\tError Exception\tError: " + e);
                            }
                        }
                        addrCtrl.clearAddressRowIdArray();
                    }
                } catch(Exception e) { }
                
                this.updateAccountPrimaryContactAddress(accntId);
                
                super.setSilentInsertMode(false);
                this.fillList(null, "INSERT_RECORD");
                return true;
            } else {
                accntId = null;
                this.clearColumns();
                this.clearValues();
                return false;
            }
        } catch (Exception e) {
            accntId = null;
            this.clearColumns();
            this.clearValues();
            return false;
        }
    }
    
    @Override
    public boolean update(){
        boolean retorno = false;
        
        super.clearColumnsValues();
        super.clearCondition();
        
        // Custom Columns
        super.setColumnsValues(",\n\t" + "MODIFICATION_NUM = (SELECT MODIFICATION_NUM + 1 FROM " + super.getDbOwner() + "." + super.getTblAccount() + " WHERE ROW_ID = '" + AccntIdArray.get(accntLightScreen.getSelectedRowList()).getRowId() + "')");
        super.setColumnsValues(",\n\t" + "FST_NAME = " + ((accntLightScreen.gettxtName() != null) ? "'" + accntLightScreen.gettxtName() + "'" : "NULL"));
        super.setColumnsValues(",\n\t" + "LAST_NAME = " + ((accntLightScreen.gettxtSurname() != null) ? "'" + accntLightScreen.gettxtSurname() + "'" : "NULL"));
        super.setColumnsValues(",\n\t" + "FULL_NAME = " + ((accntLightScreen.gettxtName() != null && accntLightScreen.gettxtSurname() != null) ? "'" + accntLightScreen.gettxtName() + " " + accntLightScreen.gettxtSurname() + "'" : "NULL"));
        super.setColumnsValues(",\n\t" + "SEX_MF = " + ((accntLightScreen.getcbbSex() != null) ? "'" + super.LookupName("SEX_MF", accntLightScreen.getcbbSex()) + "'" : "NULL"));
        super.setCondition("ROW_ID = '" + AccntIdArray.get(accntLightScreen.getSelectedRowList()).getRowId() + "'");
        
        try{
            this.clearCount();
            this.setCount(super.updateRecord(super.getTblAccount(), super.getColumnsValues(), super.getCondition()));
            if(this.getCount() > 0){
                this.setLastAccntUpd(AccntIdArray.get(accntLightScreen.getSelectedRowList()).getRowId());   
                super.clearColumnsValues();
                super.clearCondition();
                super.setSilentInsertMode(true);
                
                ArrayList<ContactClass> contList = queryContactRecord("SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblContact() + " CON\nWHERE CON.PAR_ROW_ID = '" + AccntIdArray.get(accntLightScreen.getSelectedRowList()).getRowId() + "'\nAND CON.PR_CON_FLG = 'Y'");
                
                if(contList.size() > 0){
                    super.setColumnsValues(",\n\t" + "MODIFICATION_NUM = (SELECT MODIFICATION_NUM + 1 FROM " + super.getDbOwner() + "." + super.getTblContact() + " WHERE ROW_ID = '" + contList.get(0).getRow_id() + "')");
                    super.setColumnsValues(",\n\t" + "MAIN_PH_NUM = " + ((accntLightScreen.gettxtContactMPhone() != null) ? "'" + accntLightScreen.gettxtContactMPhone().replaceAll("[( )-]", "") + "'" : "NULL"));
                    super.setColumnsValues(",\n\t" + "ALT_PH_NUM = " + ((accntLightScreen.gettxtContactPhone() != null) ? "'" + accntLightScreen.gettxtContactPhone().replaceAll("[( )-]", "") + "'" : "NULL"));
                    super.setColumnsValues(",\n\t" + "WORK_PH_NUM = " + ((accntLightScreen.gettxtContactEnterprise() != null) ? "'" + accntLightScreen.gettxtContactEnterprise().replaceAll("[( )-]", "") + "'" : "NULL"));
                    if(accntLightScreen.gettxtContactEmail() != null) {
                        String mail = accntLightScreen.gettxtContactEmail();
                        String mailTypeTemp = mail.substring(mail.indexOf("@") + 1, mail.length());
                        String mailTypeName = super.LookupName("EMAIL_ADDR_TYPE", mailTypeTemp);
                        super.setColumnsValues(",\n\t" + "EMAIL_ADDR = " + "'" + accntLightScreen.gettxtContactEmail() + "'");
                        super.setColumnsValues(",\n\t" + "EMAIL_TYPE = " + ((!"".equals(mailTypeName) && mailTypeName != null) ? "'" + mailTypeName + "'" : "NULL"));
                    } else {
                        super.setColumnsValues(",\n\t" + "EMAIL_ADDR = " + "NULL");
                        super.setColumnsValues(",\n\t" + "EMAIL_TYPE = " + "NULL");
                    }

                    super.setCondition("ROW_ID = '" + contList.get(0).getRow_id() + "'");
                    try{
                        this.clearCount();
                        this.setCount(super.updateRecord(super.getTblContact(), super.getColumnsValues(), super.getCondition()));
                        if(this.getCount() > 0){
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
                    
                    super.clearSocialNameArray();
                    if(accntLightScreen.gettxtFacebook() != null){ socialName.add("Facebook"); }
                    if(accntLightScreen.gettxtInstagram() != null){ socialName.add("Instagram"); }
                    if(accntLightScreen.gettxtTwitter() != null){ socialName.add("Twitter"); }
                    
                    ArrayList<SocialMediaClass> socMedList = querySocialMediaRecord("SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblSocialMedia()+ " SOC\nWHERE SOC.PAR_ROW_ID = '" + contList.get(0).getRow_id() + "'\nAND SOC.SOCIAL_M_NAME IN (\n\t'Facebook',\n\t'Instagram',\n\t'Twitter'\n)");
                    
                    if(socMedList.size() > 0) {
                        if(socialName.size() > 0) {
                            for(int i = 0; i < socMedList.size(); i++) {
                                String socialMedia = socMedList.get(i).getSOCIAL_M_NAME();
                                switch(socialMedia){
                                    case "Facebook":
                                        if(accntLightScreen.gettxtFacebook() != null) {
                                            super.setColumnsValues(",\n\t" + "SOCIAL_M_NAME = " + "'" + socialMedia + "'");
                                            super.setColumnsValues(",\n\t" + "SOCIAL_M_VALUE = " + "'" + accntLightScreen.gettxtFacebook() + "'");
                                            contCtrl.updateSocialMedia("ACCOUNT", super.getColumnsValues(), null, socMedList.get(i).getRowId());
                                        } else {
                                            contCtrl.deleteSocialMedia("", "ROW_ID = '" + socMedList.get(i).getRowId() + "'");
                                        }
                                        break;
                                    case "Instagram":
                                        if(accntLightScreen.gettxtInstagram() != null) {
                                            super.setColumnsValues(",\n\t" + "SOCIAL_M_NAME = " + "'" + socialMedia + "'");
                                            super.setColumnsValues(",\n\t" + "SOCIAL_M_VALUE = " + "'" + accntLightScreen.gettxtInstagram() + "'");
                                            contCtrl.updateSocialMedia("ACCOUNT", super.getColumnsValues(), null, socMedList.get(i).getRowId());
                                        } else {
                                            contCtrl.deleteSocialMedia("", "ROW_ID = '" + socMedList.get(i).getRowId() + "'");
                                        }
                                        break;
                                    case "Twitter":
                                        if(accntLightScreen.gettxtTwitter() != null) {
                                            super.setColumnsValues(",\n\t" + "SOCIAL_M_NAME = " + "'" + socialMedia + "'");
                                            super.setColumnsValues(",\n\t" + "SOCIAL_M_VALUE = " + "'" + accntLightScreen.gettxtTwitter() + "'");
                                            contCtrl.updateSocialMedia("ACCOUNT", super.getColumnsValues(), null, socMedList.get(i).getRowId());
                                        } else {
                                            contCtrl.deleteSocialMedia("", "ROW_ID = '" + socMedList.get(i).getRowId() + "'");
                                        }
                                        break;
                                    default:
                                        break;
                                }
                                super.clearColumnsValues();
                                super.clearCondition();
                            }
                            if(socMedList.size() < socialName.size()) {
                                for(int i = 0; i < socMedList.size(); i++) {
                                    for(int j = 0; j < socialName.size(); j++) {
                                        if(socMedList.get(i).getSOCIAL_M_NAME().equals(socialName.get(j))) {
                                            socialName.remove(j);
                                        }
                                    }
                                }
                                if(socialName.size() > 0) {
                                    ArrayList<SocialMediaClass> socialMedia = new ArrayList<>();
                                    SocialMediaClass smClass;
                                    for(int i = 0; i < socialName.size(); i++) {
                                        smClass = new SocialMediaClass();
                                        smClass.setParRowId(contList.get(0).getRow_id());
                                        smClass.setPAR_USR_ID(null);
                                        smClass.setPAR_ACCNT_ID(AccntIdArray.get(accntLightScreen.getSelectedRowList()).getRowId());
                                        smClass.setACTIVE_FLG("Y");
                                        smClass.setSTATUS_CD("Active");
                                        smClass.setSOCIAL_M_NAME(socialName.get(i));
                                        switch(socialName.get(i)){
                                            case "Facebook":
                                                smClass.setSOCIAL_M_VALUE(accntLightScreen.gettxtFacebook());
                                                break;
                                            case "Instagram":
                                                smClass.setSOCIAL_M_VALUE(accntLightScreen.gettxtInstagram());
                                                break;
                                            case "Twitter":
                                                smClass.setSOCIAL_M_VALUE(accntLightScreen.gettxtTwitter());
                                                break;
                                            default:
                                                smClass.setSOCIAL_M_VALUE(null);
                                                break;
                                        }
                                        socialMedia.add(smClass);
                                    }
                                    contCtrl.insertMultipleSocialMedia(socialMedia);
                                }
                            }
                        } else {
                            super.clearColumnsValues();
                            super.clearCondition();
                            super.setCondition("ROW_ID IN (");
                            for(int i = 0; i < socMedList.size(); i++) {
                                if(i == 0) {
                                    super.setCondition("\n\t" + "'" + socMedList.get(i).getRowId() + "'");
                                } else {
                                    super.setCondition(",\n\t" + "'" + socMedList.get(i).getRowId() + "'");
                                }
                                
                            }
                            super.setCondition("\n)");
                            if(contCtrl.deleteSocialMedia("", super.getCondition())) {
                                // Colocar no log que foi removido
                            } else {
                                // Colocar no log que deu erro ao remover
                            }
                            super.clearCondition();
                        }
                    } else {
                        if(socialName.size() > 0) {
                            ArrayList<SocialMediaClass> socialMedia = new ArrayList<>();
                            SocialMediaClass smClass;
                            for(int i = 0; i < socialName.size(); i++) {
                                smClass = new SocialMediaClass();
                                smClass.setParRowId(contList.get(0).getRow_id());
                                smClass.setPAR_USR_ID(null);
                                smClass.setPAR_ACCNT_ID(AccntIdArray.get(accntLightScreen.getSelectedRowList()).getRowId());
                                smClass.setACTIVE_FLG("Y");
                                smClass.setSTATUS_CD("Active");
                                smClass.setSOCIAL_M_NAME(socialName.get(i));
                                switch(socialName.get(i)){
                                    case "Facebook":
                                        smClass.setSOCIAL_M_VALUE(accntLightScreen.gettxtFacebook());
                                        break;
                                    case "Instagram":
                                        smClass.setSOCIAL_M_VALUE(accntLightScreen.gettxtInstagram());
                                        break;
                                    case "Twitter":
                                        smClass.setSOCIAL_M_VALUE(accntLightScreen.gettxtTwitter());
                                        break;
                                    default:
                                        smClass.setSOCIAL_M_VALUE(null);
                                        break;
                                }
                                socialMedia.add(smClass);
                            }
                            contCtrl.insertMultipleSocialMedia(socialMedia);
                        }
                    }
                }
                
                try{
                    if(addrCtrl.getAddressRowIdArray().size() > 0){
                        for(int i = 0; i < addrCtrl.getAddressRowIdArray().size(); i ++){
                            super.clearColumnsValues();
                            super.clearCondition();
                            super.setColumnsValues(",\n\t" + "PAR_ROW_ID = '" + AccntIdArray.get(accntLightScreen.getSelectedRowList()).getRowId() + "'");

                            try{
                                addrCtrl.update("ACCOUNT", super.getColumnsValues(), super.getCondition(), addrCtrl.getAddressRowIdArray().get(i).getRow_id());
                            } catch(Exception e) {
                                System.out.println(super.getDateTime() + "\tContactModule.ContactController\t\tinsertContact\nUpdateSocialMedia\tError Exception\tError: " + e);
                            }
                        }
                        addrCtrl.clearAddressRowIdArray();
                    }
                } catch(Exception e) { }
                
                this.updateAccountPrimaryContactAddress(AccntIdArray.get(accntLightScreen.getSelectedRowList()).getRowId());
                
                super.setSilentInsertMode(false);
                this.fillList(null, "UPDATE_RECORD");
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
        
        return retorno;
    }
    
    @Override
    public void save() {
        if(validateMandatoryFields() && validateFieldValues()){
            DefaultTableModel table = (DefaultTableModel) accntLightScreen.getTableModel();
            table.getRowCount();
            try{
                ArrayList<AccountClass> accntList = queryAccountRecord("SELECT *\nFROM " + getDbOwner() + "." + getTblAccount()+ " ACC\nWHERE ACC.ROW_ID = '" + accntLightScreen.gettxtRowId() + "'");

                if(accntList.size() > 0) {
                    if(update()){
                        accntLightScreen.enableFields("SALVAR");
                    }
                } else {
                    if(insert()){
                        accntLightScreen.enableFields("SALVAR");

                        boolean foundRow = true;
                        int i = 0;
                        int o = accntLightScreen.getNumOfListRows();
                        do {
                            if(i < o){
                                try{                                    
                                    if(getLastAccntAdd().equals(AccntIdArray.get(i).getRowId())){
                                        accntLightScreen.setSelectedRowColumnList(i, 0);
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
                accntLightScreen.setlblRecCount((accntLightScreen.getSelectedRowList() + 1) + " - " + String.valueOf(AccntIdArray.size()));
            } catch(Exception e) {
                System.out.println(getDateTime() + "\tContactModule.ContactController\t\tSaveSocialMedia\tInsertUpdateSocialMedia\tError Exception\tError: " + e);
            }
        }
    }
    
    @Override
    public boolean delete(){
        int countAccount = 0;
        int countContact = 0;
        int countSocialMedia = 0;
        
        if(super.wishDeleteRecord()){
            try{
                super.clearCondition();

                ArrayList<ContactClass> contact = null;
                ArrayList<SocialMediaClass> socialMedia = null;

                // Query Account Contacts
                contact = super.queryContactRecord("SELECT *\nFROM " + super.getDbOwner() + "." + getTblContact() + " CON\nWHERE CON.PAR_ROW_ID = '" + AccntIdArray.get(accntLightScreen.getSelectedRowList()).getRowId() + "'");

                // If Contact records were found, query Social Media Recods
                if(contact.size() > 0) {
                    // Prepare condition to query Social Media Records
                    super.setCondition("PAR_ROW_ID IN (");
                    for(int i = 0; i < contact.size(); i++){
                        if(i == 0){
                            super.setCondition("\n\t'" + contact.get(i).getRow_id() + "'");
                        } else {
                            super.setCondition(",\n\t'" + contact.get(i).getRow_id() + "'");
                        }
                    }
                    super.setCondition("\n)");

                    // Query Social Media Recods
                    socialMedia = super.querySocialMediaRecord("SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblSocialMedia() + " SOC\nWHERE " + super.getCondition());

                    // If Social Media were found, we delete then
                    if(socialMedia.size() > 0){
                        countSocialMedia = super.deleteRecord(super.getTblSocialMedia(), super.getCondition());
                    }

                    super.clearCondition();

                    // Prepare condition to DELETE Contact Records
                    super.setCondition("ROW_ID IN (");
                    for(int i = 0; i < contact.size(); i++){
                        if(i == 0){
                            super.setCondition("\n\t'" + contact.get(i).getRow_id() + "'");
                        } else {
                            super.setCondition(",\n\t'" + contact.get(i).getRow_id() + "'");
                        }
                    }
                    super.setCondition("\n)");

                    // Deleting Contats
                    countContact = super.deleteRecord(super.getTblContact(), super.getCondition());
                    super.clearCondition();
                }
            } catch (HeadlessException e) { }
            
            super.clearCondition();
            super.setCondition("ROW_ID = '" + AccntIdArray.get(accntLightScreen.getSelectedRowList()).getRowId() + "'");
            try{
                countAccount = super.deleteRecord(super.getTblAccount(), super.getCondition());
                if(countAccount > 0){
                    AccntIdArray.remove(accntLightScreen.getSelectedRowList());
                    accntLightScreen.removeRowFromList(accntLightScreen.getSelectedRowList());
                    JOptionPane.showMessageDialog(null, "Registro(s) removido(s) com sucesso! Total de registros removidos:\nClientes: " + countAccount + " registro(s)\nContato: " + countContact + " registro(s)\nRedes Sociais: " + countSocialMedia + " registro(s)");
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
    
    @Override
    public void updateAccountPrimaryContactAddress(String accountId){
        ArrayList<AddressClass> addrList;
        ArrayList<ContactClass> contList;
        
        super.clearColumnsValues();
        super.clearCondition();
        
        addrList = queryAddressRecord("SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblAddress() + " ADDR\nWHERE ADDR.PAR_ROW_ID = '" + accountId + "'\nAND ADDR.PR_ADDR_FLG = 'Y'");
        super.setColumnsValues(",\n\t" + "PR_ADDR_ID = " + ((addrList.size() > 0) ? "'" + addrList.get(0).getRow_id() + "'": "NULL"));
        accntLightScreen.settxtFullAddress(((addrList.size() > 0) ? addrList.get(0).getADDR_NAME() : ""));
        
        contList = queryContactRecord("SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblContact()+ " CON\nWHERE CON.PAR_ROW_ID = '" + accountId + "'\nAND CON.PR_CON_FLG = 'Y'");
        super.setColumnsValues(",\n\t" + "PR_CON_ID = " + ((contList.size() > 0) ? "'" + contList.get(0).getRow_id() + "'": "NULL"));
        
        super.setCondition("ROW_ID = '" + accountId + "'");
        
        try{
            this.clearCount();
            this.setCount(super.updateRecord(super.getTblAccount(), super.getColumnsValues(), super.getCondition()));
            if(this.getCount() > 0){
                System.out.println(super.getDateTime() + "\t" + "AccountModule" + "." + "AccountLightController" + "\t\t" + "UpdateAccountPrimaryContactAddress" + "\t" + "GenericLog" + "\t" + "GenericInfo" + "\t" + "Atualizando o Contato e Endereço Principal" + "\t\t" + "Contato e Endereço Principal do Cliente atualizados com sucesso");
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
        
        this.setLastAccntUpd(accountId);
    }
    
    protected class buttonEdit implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            accntLightScreen.enableFields("EDITAR");
            accntLightScreen.setFocus("NOME");
        }
    }
    
    protected class buttonNew implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            accntLightScreen.enableFields("NOVO");
            accntLightScreen.clearFields();
            fillFieldsNewRecord();
            accntLightScreen.setFocus("NOME");
        }
    }
    
    protected class buttonSave implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            save();
        }
    }
    
    protected class buttonCancel implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            accntLightScreen.enableFields("CANCELAR");
            if(accntLightScreen.getSelectedRowList() >= 0){
                fillFields("SELECT *\nFROM " + getDbOwner() + "." + getTblAccount() + " ACC\nWHERE ACC.ROW_ID = '" + AccntIdArray.get(accntLightScreen.getSelectedRowList()).getRowId() + "'");
            } else {
                accntLightScreen.clearFields();
            }
            accntLightScreen.setFocus("FILTRO_VALOR");
        }
    }
    
    protected class buttonDelete implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if(delete()){
                accntLightScreen.enableFields("DELETAR");
                accntLightScreen.clearFields();
                accntLightScreen.setFocus("FILTRO_VALOR");
            } else {
                accntLightScreen.enableFields("CANCELAR");
                accntLightScreen.setFocus("FILTRO_VALOR");
            }
        }
    }
    
    protected class manageAddress implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            String condition = "";
            try{
                // This Array is cleaned everytime when accntLightScreen is saved
                if(addrCtrl.getAddressRowIdArray().size() > 0){
                    for(int i = 0; i < addrCtrl.getAddressRowIdArray().size(); i++) {
                        if(i != addrCtrl.getAddressRowIdArray().size() - 1){
                            condition += "'" + addrCtrl.getAddressRowIdArray().get(i).getRow_id() + "',\n\t";
                        } else {
                            condition += "'" + addrCtrl.getAddressRowIdArray().get(i).getRow_id() + "'\n";
                        }
                    }
                } else {
                    try {
                        addrCtrl = new AddressController();
                    } catch (InterruptedException ex) { }
                }
            } catch (Exception e) {
                try {
                    addrCtrl = new AddressController();
                } catch (InterruptedException ex) { }
            }
            
            addrCtrl.setDbUser(getDbUser());
            addrCtrl.setDbPassword(getDbPassword());
            addrCtrl.setOpenFromScreen("ACCOUNT");
            addrCtrl.setAccountId(accntLightScreen.gettxtRowId());        
            addrCtrl.openAddressScreen("SELECT *\nFROM " + getDbOwner() + "." + getTblAddress() + " ADDR\nWHERE ADDR.PAR_ROW_ID = '" + accntLightScreen.gettxtRowId() + "'" + ((!"".equals(condition)) ? "\nOR ROW_ID IN (\n\t" + condition + ")\n" : "\n") + "ORDER BY ADDR.ROW_ID ASC", "NEW_ACCOUNT_ADDRESS");
            addrCtrl.setListenerAddressScreen(new addressScreenListener());
            accntLightScreen.setEnabled(false);
        }
    }
    
    private class CbbListFilterItemState implements java.awt.event.ItemListener {

        @Override
        public void itemStateChanged(ItemEvent ie) {
            if(ie.getStateChange() == ItemEvent.SELECTED){
                if(accntLightScreen.getcbbListFilter() == null) {
                    accntLightScreen.cleartxtListFilterValue();
                }
                accntLightScreen.setFocus("FILTRO_VALOR");
            }
        }
        
    }
    
    private class TxtListFilterValue implements java.awt.event.KeyListener {

        @Override
        public void keyTyped(KeyEvent ke) { }

        @Override
        public void keyPressed(KeyEvent ke) {
            String filterValue = "";
            if(ke.getKeyCode() == KeyEvent.VK_ENTER){
                accntLightScreen.unselectRowList();
                if(accntLightScreen.getcbbListFilter() != null && accntLightScreen.gettxtListFilterValue() != null) {
                    switch(accntLightScreen.getcbbListFilter()) {
                        case "Sexo":
                            filterValue = LookupName("SEX_MF", accntLightScreen.gettxtListFilterValue());
                            break;
                        default:
                            filterValue = accntLightScreen.gettxtListFilterValue();
                            break;
                    }
                    fillList(
                        "SELECT *\n" +
                        "FROM " + getDbOwner() + "." + getTblAccount() + " ACC\n" +
                        "WHERE " + processFilterCondition(accntLightScreen.getcbbListFilter(), filterValue, "ACCOUNT_FILTER", "ACC") +
                        "ORDER BY ACC.ACCNT_NUMBER ASC",
                        "FILTER_RECORD"
                    );
                } else {
                    fillList("SELECT *\nFROM " + getDbOwner() + "." + getTblAccount() + " ACC\nORDER BY ACC.ACCNT_NUMBER ASC", "FILTER_RECORD");
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent ke) { }
        
    }
    
    protected class ListSelected implements ListSelectionListener {

        private int count = 0;
        
        @Override
        public void valueChanged(ListSelectionEvent lse) {
            if(count < 1){
                accntLightScreen.clearFields();
                fillFields("SELECT *\nFROM " + getDbOwner() + "." + getTblAccount() + " ACC\nWHERE ACC.ROW_ID = '" + AccntIdArray.get(accntLightScreen.getSelectedRowList()).getRowId() + "'");
                accntLightScreen.setlblRecCount((accntLightScreen.getSelectedRowList() + 1) + " - " + String.valueOf(AccntIdArray.size()));
                accntLightScreen.setbtnEditEnabled(true);
                accntLightScreen.setbtnDeleteEnabled(true);
                count++;
            } else {
                count = 0;
            }
        }
        
    }
            
    private class addressScreenListener implements WindowListener {

        @Override
        public void windowOpened(WindowEvent we) { }

        @Override
        public void windowClosing(WindowEvent we) { }

        @Override
        public void windowClosed(WindowEvent we) {
            accntLightScreen.setEnabled(true);
            accntLightScreen.setVisible(true);
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
