/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accountModule;

import addressModule.AddressController;
import contactModule.ContactController;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author mathe
 */
public class AccountInsertController extends Account {

    public AccountInsertController() throws InterruptedException { }
    
    @Override
    public void openAccountScreen(String screen, String query) {
        try {
            contCtrl = new ContactController();
            contCtrl.setDbUser(super.getDbUser());
            contCtrl.setDbPassword(super.getDbPassword());
        } catch (InterruptedException ex) {
            Logger.getLogger(AccountLightController.class.getName()).log(Level.SEVERE, null, ex);
        }
        accntInsScreen = new AccountInsertScreen();
        accntInsScreen.setListenerBtnNew(new buttonNew());
        accntInsScreen.setListenerBtnSave(new buttonSave());
        accntInsScreen.setListenerBtnCancel(new buttonCancel());
        accntInsScreen.setListenerBtnAddAddress(new manageAddress());
        accntInsScreen.clearFields();
        accntInsScreen.clearComboBoxes();
        accntInsScreen.enableFields("LOAD_SCREEN");
        accntInsScreen.insertSelectComboBox();
        this.fillComboBoxes("SEX_MF");
        accntInsScreen.clickNew();
        accntInsScreen.setFocus("NOME");
    }

    @Override
    public void fillComboBoxes(String LovType) {
        try{
            ArrayList<ListOfValuesClass> lov = super.LookupList(LovType);
            
            if(lov.size() > 0){
                for(int i = 0; i < lov.size(); i++){
                    if(null == LovType){
                        JOptionPane.showMessageDialog(null, "O LOV_TYPE 'null' não existe!");
                    } else switch (LovType) {
                        case "SEX_MF": accntInsScreen.setcbbSex(lov.get(i).getValue()); break;
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
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void fillFields(String query) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void fillFieldsNewRecord() {
        accntInsScreen.settxtRowId(super.getNextRowId());
        accntInsScreen.settxtAccountNumber(super.getNextAccountNumber());
    }

    @Override
    public boolean validateMandatoryFields() {
        String mensagem = "";
        int i = 0;
        
        if(accntInsScreen.gettxtName() == null) { mensagem += "\n- " + "Nome" + ";"; i = (i < 1) ? 1 : i; }
        if(accntInsScreen.gettxtSurname() == null) { mensagem += "\n- " + "Sobrenome" + ";"; i = (i < 2 && i != 0) ? i : 2; }
        if(accntInsScreen.getcbbSex() == null) { mensagem += "\n- " + "Sexo" + ";"; i = (i < 3 && i != 0) ? i : 3; }
        if(accntInsScreen.gettxtContactMPhone() == null) { mensagem += "\n- " + "Celular/WhatsApp" + ";"; i = (i < 4 && i != 0) ? i : 4; }
        
        switch(i){
            case 1: accntInsScreen.setFocus("NOME"); break;
            case 2: accntInsScreen.setFocus("SOBRENOME"); break;
            case 3: accntInsScreen.setFocus("SEXO"); break;
            case 4: accntInsScreen.setFocus("CONTATO_CELULAR"); break;
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
    public boolean validateFieldValues() {
        // Validate Field Sizes
        if((accntInsScreen.gettxtAccountNumber() != null) && (accntInsScreen.gettxtAccountNumber().length() > getAccntNumberColumnSize())) { JOptionPane.showMessageDialog(null, "O tamanho do campo 'Número do Cliente' deve ter no máximo: " + getAccntNumberColumnSize() + " caractere(s)"); return false; }
        if((accntInsScreen.gettxtName() != null) && (accntInsScreen.gettxtName().length() > getFirstNameColumnSize())) { JOptionPane.showMessageDialog(null, "O tamanho do campo 'Nome' deve ter no máximo: " + getFirstNameColumnSize() + " caractere(s)"); return false; }
        if((accntInsScreen.gettxtSurname() != null) && (accntInsScreen.gettxtSurname().length() > getLastNameColumnSize())) { JOptionPane.showMessageDialog(null, "O tamanho do campo 'Sobrenome' deve ter no máximo: " + getLastNameColumnSize() + " caractere(s)"); return false; }
        if((accntInsScreen.gettxtContactMPhone() != null) && (accntInsScreen.gettxtContactMPhone().length() > getContMainPhNumColumnSize())) { JOptionPane.showMessageDialog(null, "O tamanho do campo 'Celular/WhatsApp' deve ter no máximo: " + getContMainPhNumColumnSize() + " caractere(s)"); return false; }
        if((accntInsScreen.gettxtContactPhone() != null) && (accntInsScreen.gettxtContactPhone().length() > getContPhNumColumnSize())) { JOptionPane.showMessageDialog(null, "O tamanho do campo 'Telefone Fixo' deve ter no máximo: " + getContPhNumColumnSize() + " caractere(s)"); return false; }
        if((accntInsScreen.gettxtContactEnterprise() != null) && (accntInsScreen.gettxtContactEnterprise().length() > getContWorkPhNumColumnSize())) { JOptionPane.showMessageDialog(null, "O tamanho do campo 'Telefone Comercial' deve ter no máximo: " + getContWorkPhNumColumnSize() + " caractere(s)"); return false; }
        if((accntInsScreen.gettxtContactEmail() != null) && (accntInsScreen.gettxtContactEmail().length() > getContEmailAddrColumnSize())) { JOptionPane.showMessageDialog(null, "O tamanho do campo 'Email' deve ter no máximo: " + getContEmailAddrColumnSize() + " caractere(s)"); return false; }
        if((accntInsScreen.gettxtFacebook() != null) && (accntInsScreen.gettxtFacebook().length() > getSocMedValueColumnSize())) { JOptionPane.showMessageDialog(null, "O tamanho do campo 'Facebook' deve ter no máximo: " + getSocMedValueColumnSize() + " caractere(s)"); return false; }
        if((accntInsScreen.gettxtTwitter() != null) && (accntInsScreen.gettxtTwitter().length() > getSocMedValueColumnSize())) { JOptionPane.showMessageDialog(null, "O tamanho do campo 'Twitter' deve ter no máximo: " + getSocMedValueColumnSize() + " caractere(s)"); return false; }
        if((accntInsScreen.gettxtInstagram() != null) && (accntInsScreen.gettxtInstagram().length() > getSocMedValueColumnSize())) { JOptionPane.showMessageDialog(null, "O tamanho do campo 'Instagram' deve ter no máximo: " + getSocMedValueColumnSize() + " caractere(s)"); return false; }
        
        return true;
    }

    @Override
    public boolean insert() {
        String accntId = super.getNextRowId();
        String accntNumber = super.getNextAccountNumber();
        super.clearColumns();
        super.clearValues();
        
        super.setColumns(",\n\t" + "ACCNT_NUMBER"); super.setValues(",\n\t" + "'" + accntNumber + "'");
        super.setColumns(",\n\t" + "FST_NAME"); super.setValues(",\n\t" + ((accntInsScreen.gettxtName() != null) ? "'" + accntInsScreen.gettxtName() + "'" : "NULL"));
        super.setColumns(",\n\t" + "LAST_NAME"); super.setValues(",\n\t" + ((accntInsScreen.gettxtSurname() != null) ? "'" + accntInsScreen.gettxtSurname() + "'" : "NULL"));
        super.setColumns(",\n\t" + "FULL_NAME"); super.setValues(",\n\t" + ((accntInsScreen.gettxtName() != null && accntInsScreen.gettxtSurname() != null) ? "'" + accntInsScreen.gettxtName() + " " + accntInsScreen.gettxtSurname() + "'" : "NULL"));
        super.setColumns(",\n\t" + "SEX_MF"); super.setValues(",\n\t" + ((accntInsScreen.getcbbSex() != null) ? "'" + super.LookupName("SEX_MF", accntInsScreen.getcbbSex()) + "'" : "NULL"));
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
                super.setColumns(",\n\t" + "MAIN_PH_NUM"); super.setValues(",\n\t" + ((accntInsScreen.gettxtContactMPhone() != null) ? "'" + accntInsScreen.gettxtContactMPhone().replaceAll("[( )-]", "") + "'" : "NULL"));
                super.setColumns(",\n\t" + "ALT_PH_NUM"); super.setValues(",\n\t" + ((accntInsScreen.gettxtContactPhone() != null) ? "'" + accntInsScreen.gettxtContactPhone().replaceAll("[( )-]", "") + "'" : "NULL"));
                super.setColumns(",\n\t" + "WORK_PH_NUM"); super.setValues(",\n\t" + ((accntInsScreen.gettxtContactEnterprise() != null) ? "'" + accntInsScreen.gettxtContactEnterprise().replaceAll("[( )-]", "") + "'" : "NULL"));
                if(accntInsScreen.gettxtContactEmail() != null) {
                    super.setColumns(",\n\t" + "EMAIL_ADDR"); super.setValues(",\n\t" + "'" + accntInsScreen.gettxtContactEmail() + "'");
                    String mail = accntInsScreen.gettxtContactEmail();
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
                        if(accntInsScreen.gettxtFacebook() != null){ socialName.add("Facebook"); }
                        if(accntInsScreen.gettxtInstagram() != null){ socialName.add("Instagram"); }
                        if(accntInsScreen.gettxtTwitter() != null){ socialName.add("Twitter"); }
                        
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
                                        smClass.setSOCIAL_M_VALUE(accntInsScreen.gettxtFacebook());
                                        break;
                                    case "Instagram":
                                        smClass.setSOCIAL_M_VALUE(accntInsScreen.gettxtInstagram());
                                        break;
                                    case "Twitter":
                                        smClass.setSOCIAL_M_VALUE(accntInsScreen.gettxtTwitter());
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
    public boolean update() {
        return false;
    }

    @Override
    public boolean delete() {
        return false;
    }

    @Override
    public void save() {
        if(insert()){
            accntInsScreen.clearFields();
            accntInsScreen.enableFields("CANCELAR");
            accntInsScreen.setFocus("BOTAO_NOVO");
        }
    }

    @Override
    public void updateAccountPrimaryContactAddress(String accountId) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    protected class buttonNew implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            accntInsScreen.enableFields("NOVO");
            accntInsScreen.clearFields();
            fillFieldsNewRecord();
            accntInsScreen.setFocus("NOME");
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
            accntInsScreen.enableFields("CANCELAR");
            accntInsScreen.clearFields();
            accntInsScreen.setFocus("FILTRO_VALOR");
        }
        
    }
    
    private class manageAddress implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            try{ addrCtrl = new AddressController(); } catch (InterruptedException ex) { }
            addrCtrl.setDbUser(getDbUser());
            addrCtrl.setDbPassword(getDbPassword());
            addrCtrl.setOpenFromScreen("ACCOUNT");
            addrCtrl.setAccountId(accntInsScreen.gettxtRowId());        
            addrCtrl.openAddressScreen("SELECT *\nFROM " + getDbOwner() + "." + getTblAddress() + " ADDR\nWHERE ADDR.PAR_ROW_ID = '" + accntInsScreen.gettxtRowId() + "'\nORDER BY ADDR.ROW_ID ASC", "NEW_ACCOUNT_ADDRESS");
            addrCtrl.setListenerAddressScreen(new addressScreenListener());
            accntInsScreen.setEnabled(false);
        }
    }
    
    private class addressScreenListener implements WindowListener {

        @Override
        public void windowOpened(WindowEvent we) { }

        @Override
        public void windowClosing(WindowEvent we) { }

        @Override
        public void windowClosed(WindowEvent we) {
            accntInsScreen.setEnabled(true);
            accntInsScreen.setVisible(true);
            accntInsScreen.settxtRowId(getNextRowId());
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
