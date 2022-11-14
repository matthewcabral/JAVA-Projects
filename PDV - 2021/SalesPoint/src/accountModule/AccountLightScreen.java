/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accountModule;

import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Collections;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mathe
 */
public class AccountLightScreen extends javax.swing.JFrame {

    /**
     * Creates new form AccountLightScreen
     */
    public AccountLightScreen() {
        initComponents();
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();
        if(width <= 1366 && height <= 768){
            this.setExtendedState(MAXIMIZED_BOTH);
        }
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.FocusTraversalKeys();
    }

    // Listeners
    public void setListenerBtnEdit(ActionListener listener) { this.btnEdit.addActionListener(listener); }
    public void setListenerBtnNew(ActionListener listener) { this.btnNew.addActionListener(listener); }
    public void setListenerBtnSave(ActionListener listener) { this.btnSave.addActionListener(listener); }
    public void setListenerBtnCancel(ActionListener listener) { this.btnCancel.addActionListener(listener); }
    public void setListenerBtnDelete(ActionListener listener) { this.btnDelete.addActionListener(listener); }
    public void setListenerBtnAddAddress(ActionListener listener) { this.btnAddAddress.addActionListener(listener); }
    
    public void setListenercbbListFilterValue(ItemListener listener) { this.cbbListFilter.addItemListener(listener); }
    public void setListenertxtListFilterValue(KeyListener listener) { this.txtListFilterValue.addKeyListener(listener); }
    
    // Table
    public DefaultTableModel getTableModel(){ return (DefaultTableModel) tblAccountList.getModel(); }    
    public void setListenerTblAccountListSelection(ListSelectionListener listener) { this.tblAccountList.getSelectionModel().addListSelectionListener(listener); }
    public String getSelectedAccountListId() { try { return (String) this.tblAccountList.getValueAt(this.tblAccountList.getSelectedRow(), 0); } catch (Exception e) { return ""; } }
    public void setSelectedRowColumnList(int row, int column){ this.tblAccountList.changeSelection(row, column, false, false); }
    public void unselectRowList() { try { this.tblAccountList.removeRowSelectionInterval(this.getSelectedRowList(), this.getSelectedRowList()); } catch (Exception e) {} }
    public void removeRowFromList(int row) { try { this.getTableModel().removeRow(row); } catch (Exception e) {} this.tblAccountList.paintImmediately(this.tblAccountList.getVisibleRect()); }
    public int getSelectedRowList() { return this.tblAccountList.getSelectedRow(); }
    public int getNumOfListRows() { return this.tblAccountList.getRowCount(); }
    
    // Component Setters
    public void settxtListFilterValue(String value) { this.txtListFilterValue.setText(value); this.txtListFilterValue.paintImmediately(this.txtListFilterValue.getVisibleRect()); }
    public void settxtRowId(String value) { this.txtRowId.setText(value); this.txtRowId.paintImmediately(this.txtRowId.getVisibleRect()); }
    public void settxtAccountNumber(String value) { this.txtAccountNumber.setText(value); this.txtAccountNumber.paintImmediately(this.txtAccountNumber.getVisibleRect()); }
    public void settxtName(String value) { this.txtName.setText(value); this.txtName.paintImmediately(this.txtName.getVisibleRect()); }
    public void settxtSurname(String value) { this.txtSurname.setText(value); this.txtSurname.paintImmediately(this.txtSurname.getVisibleRect()); }
    public void settxtContactMPhone(String value) { this.txtContactMPhone.setText(value); this.txtContactMPhone.paintImmediately(this.txtContactMPhone.getVisibleRect()); }
    public void settxtContactEmail(String value) { this.txtContactEmail.setText(value); this.txtContactEmail.paintImmediately(this.txtContactEmail.getVisibleRect()); }
    public void settxtContactPhone(String value) { this.txtContactPhone.setText(value); this.txtContactPhone.paintImmediately(this.txtContactPhone.getVisibleRect()); }
    public void settxtContactEnterprise(String value) { this.txtContactEnterprise.setText(value); this.txtContactEnterprise.paintImmediately(this.txtContactEnterprise.getVisibleRect()); }
    public void settxtFacebook(String value) { this.txtFacebook.setText(value); this.txtFacebook.paintImmediately(this.txtFacebook.getVisibleRect()); }
    public void settxtInstagram(String value) { this.txtInstagram.setText(value); this.txtInstagram.paintImmediately(this.txtInstagram.getVisibleRect()); }
    public void settxtTwitter(String value) { this.txtTwitter.setText(value); this.txtTwitter.paintImmediately(this.txtTwitter.getVisibleRect()); }
    public void settxtFullAddress(String value) { this.txtFullAddress.setText(value); this.txtFullAddress.paintImmediately(this.txtFullAddress.getVisibleRect()); }
    
    public void setcbbListFilter(String value) { this.cbbListFilter.addItem(value); this.cbbListFilter.paintImmediately(this.cbbListFilter.getVisibleRect()); }
    public void setcbbSex(String value) { this.cbbSex.addItem(value); this.cbbSex.paintImmediately(this.cbbSex.getVisibleRect()); }
    
    // ComboBox Specific Setters
    public void setcbbUserListFilterItemIndex(int value) { this.cbbListFilter.setSelectedIndex(value); }
    public void setcbbSexItemIndex(int value) { this.cbbSex.setSelectedIndex(value); }
    
    public void setlblRecCount(String value) { this.lblRecCount.setText("Registros: " + value); this.lblRecCount.paintImmediately(this.lblRecCount.getVisibleRect()); }
    public void setlblAccountNameHeader(String value) { this.lblAccountNameHeader.setText(value); this.lblAccountNameHeader.paintImmediately(this.lblAccountNameHeader.getVisibleRect()); }
        
    // Component Getters
    public String gettxtRowId() { if(!"".equals(this.txtRowId.getText()) && this.txtRowId.getText() != null) { return this.txtRowId.getText(); } else { return null; } }
    public String gettxtAccountNumber() { if(!"".equals(this.txtAccountNumber.getText()) && this.txtAccountNumber.getText() != null) { return this.txtAccountNumber.getText(); } else { return null; } }
    public String gettxtName() { if(!"".equals(this.txtName.getText()) && this.txtName.getText() != null) { return this.txtName.getText(); } else { return null; } }
    public String gettxtSurname() { if(!"".equals(this.txtSurname.getText()) && this.txtSurname.getText() != null) { return this.txtSurname.getText(); } else { return null; } }
    public String gettxtListFilterValue() { if(!"".equals(this.txtListFilterValue.getText()) && this.txtListFilterValue.getText() != null) { return this.txtListFilterValue.getText(); } else { return null; } }
    public String gettxtContactMPhone() { if(!"".equals(this.txtContactMPhone.getText()) && !" ".equals(this.txtContactMPhone.getText()) && !"(  )     -    ".equals(this.txtContactMPhone.getText()) && this.txtContactMPhone.getText() != null) { return this.txtContactMPhone.getText(); } else { return null; } }
    public String gettxtContactEmail() { if(!"".equals(this.txtContactEmail.getText()) && this.txtContactEmail.getText() != null) { return this.txtContactEmail.getText(); } else { return null; } }
    public String gettxtContactPhone() { if(!"".equals(this.txtContactPhone.getText()) && !" ".equals(this.txtContactPhone.getText()) && !"(  )     -    ".equals(this.txtContactPhone.getText()) && this.txtContactPhone.getText() != null) { return this.txtContactPhone.getText(); } else { return null; } }
    public String gettxtContactEnterprise() { if(!"".equals(this.txtContactEnterprise.getText()) && !" ".equals(this.txtContactEnterprise.getText()) && !"(  )     -    ".equals(this.txtContactEnterprise.getText()) && this.txtContactEnterprise.getText() != null) { return this.txtContactEnterprise.getText(); } else { return null; } }
    public String gettxtFacebook() { if(!"".equals(this.txtFacebook.getText()) && this.txtFacebook.getText() != null) { return this.txtFacebook.getText(); } else { return null; } }
    public String gettxtInstagram() { if(!"".equals(this.txtInstagram.getText()) && this.txtInstagram.getText() != null) { return this.txtInstagram.getText(); } else { return null; } }
    public String gettxtTwitter() { if(!"".equals(this.txtTwitter.getText()) && this.txtTwitter.getText() != null) { return this.txtTwitter.getText(); } else { return null; } }    
    public String gettxtFullAddress() { if(!"".equals(this.txtFullAddress.getText()) && this.txtFullAddress.getText() != null) { return this.txtFullAddress.getText(); } else { return null; } }
    
    public String getcbbListFilter() { if(!"".equals(this.cbbListFilter.getSelectedItem().toString()) && !"Selecione...".equals(this.cbbListFilter.getSelectedItem().toString()) && this.cbbListFilter.getSelectedItem().toString() != null) { return this.cbbListFilter.getSelectedItem().toString(); } else { return null; } }
    public String getcbbSex() { if(!"".equals(this.cbbSex.getSelectedItem().toString()) && !"Selecione...".equals(this.cbbSex.getSelectedItem().toString()) && this.cbbSex.getSelectedItem().toString() != null) { return this.cbbSex.getSelectedItem().toString(); } else { return null; } }
    
    // ComboBox Specific Getters
    public int getcbbUserListFilterItemIndex(String value) { if(!"".equals(value) && value != null) { for(int i = 0; i < this.cbbListFilter.getItemCount(); i++){ if(value.equals(this.cbbListFilter.getItemAt(i))){ return i; }}} else { return 0; } return 0; }
    public int getcbbSexItemIndex(String value) { if(!"".equals(value) && value != null) { for(int i = 0; i < this.cbbSex.getItemCount(); i++){ if(value.equals(this.cbbSex.getItemAt(i))){ return i; }}} else { return 0; } return 0; }
        
    public String getlblRecCount() { return this.lblRecCount.getText(); }
    public String getlblAccountNameHeader() { return this.lblAccountNameHeader.getText(); }
    
    // Component Clear
    public void cleartxtListFilterValue() { this.txtListFilterValue.setText(""); this.txtListFilterValue.paintImmediately(this.txtListFilterValue.getVisibleRect()); }
    public void cleartxtRowId() { this.txtRowId.setText(""); this.txtRowId.paintImmediately(this.txtRowId.getVisibleRect()); }
    public void cleartxtAccountNumber() { this.txtAccountNumber.setText(""); this.txtAccountNumber.paintImmediately(this.txtAccountNumber.getVisibleRect()); }
    public void cleartxtName() { this.txtName.setText(""); this.txtName.paintImmediately(this.txtName.getVisibleRect()); }
    public void cleartxtSurname() { this.txtSurname.setText(""); this.txtSurname.paintImmediately(this.txtSurname.getVisibleRect()); }
    public void cleartxtContactMPhone() { this.txtContactMPhone.setText(""); this.txtContactMPhone.paintImmediately(this.txtContactMPhone.getVisibleRect()); }
    public void cleartxtContactEmail() { this.txtContactEmail.setText(""); this.txtContactEmail.paintImmediately(this.txtContactEmail.getVisibleRect()); }
    public void cleartxtContactPhone() { this.txtContactPhone.setText(""); this.txtContactPhone.paintImmediately(this.txtContactPhone.getVisibleRect()); }
    public void cleartxtContactEnterprise() { this.txtContactEnterprise.setText(""); this.txtContactEnterprise.paintImmediately(this.txtContactEnterprise.getVisibleRect()); }
    public void cleartxtFacebook() { this.txtFacebook.setText(""); this.txtFacebook.paintImmediately(this.txtFacebook.getVisibleRect()); }
    public void cleartxtInstagram() { this.txtInstagram.setText(""); this.txtInstagram.paintImmediately(this.txtInstagram.getVisibleRect()); }
    public void cleartxtTwitter() { this.txtTwitter.setText(""); this.txtTwitter.paintImmediately(this.txtTwitter.getVisibleRect()); }    
    public void cleartxtFullAddress() { this.txtFullAddress.setText(""); this.txtFullAddress.paintImmediately(this.txtFullAddress.getVisibleRect()); }
    
    public void clearcbbUserListFilter() { this.cbbListFilter.removeAllItems(); this.cbbListFilter.paintImmediately(this.cbbListFilter.getVisibleRect()); }
    public void clearcbbSex() { this.cbbSex.removeAllItems(); this.cbbSex.paintImmediately(this.cbbSex.getVisibleRect()); }
     
    public void clearlblRecCount() { this.lblRecCount.setText(""); this.lblRecCount.paintImmediately(this.lblRecCount.getVisibleRect()); }
    public void clearlblAccountNameHeader() { this.lblAccountNameHeader.setText(""); this.lblAccountNameHeader.paintImmediately(this.lblAccountNameHeader.getVisibleRect()); }

    // Enable or Disable Components
    public void settxtUserListFilterValueEnabled(boolean status) { this.txtListFilterValue.setEnabled(status); }
    public void settxtRowIdEnabled(boolean status) { this.txtRowId.setEnabled(status); }
    public void settxtAccountNumberEnabled(boolean status) { this.txtAccountNumber.setEnabled(status); }
    public void settxtNameEnabled(boolean status) { this.txtName.setEnabled(status); }
    public void settxtSurnameEnabled(boolean status) { this.txtSurname.setEnabled(status); }
    public void settxtContactMPhoneEnabled(boolean status) { this.txtContactMPhone.setEnabled(status); }
    public void settxtContactEmailEnabled(boolean status) { this.txtContactEmail.setEnabled(status); }
    public void settxtContactPhoneEnabled(boolean status) { this.txtContactPhone.setEnabled(status); }
    public void settxtContactEnterpriseEnabled(boolean status) { this.txtContactEnterprise.setEnabled(status); }
    public void settxtFacebookEnabled(boolean status) { this.txtFacebook.setEnabled(status); }
    public void settxtInstagramEnabled(boolean status) { this.txtInstagram.setEnabled(status); }
    public void settxtTwitterEnabled(boolean status) { this.txtTwitter.setEnabled(status); }    
    public void settxtFullAddressEnabled(boolean status) { this.txtFullAddress.setEnabled(status); }
    
    public void setcbbUserListFilterEnabled(boolean status) { this.cbbListFilter.setEnabled(status); }
    public void setcbbSexEnabled(boolean status) { this.cbbSex.setEnabled(status); }
    
    public void setlblRecCountEnabled(boolean status) { this.lblRecCount.setEnabled(status); }
    public void setlblAccountNameHeaderEnabled(boolean status) { this.lblAccountNameHeader.setEnabled(status); }
    
    public void setTblEnabled(boolean status) { this.tblAccountList.setEnabled(status); }
    
    public void setbtnEditEnabled(boolean status) { this.btnEdit.setEnabled(status); }
    public void setbtnNewEnabled(boolean status) { this.btnNew.setEnabled(status); }
    public void setbtnSaveEnabled(boolean status) { this.btnSave.setEnabled(status); }
    public void setbtnDeleteEnabled(boolean status) { this.btnDelete.setEnabled(status); }
    public void setbtnCancelEnabled(boolean status) { this.btnCancel.setEnabled(status); }
    public void setbtnAddAddressEnabled(boolean status) { this.btnAddAddress.setEnabled(status); }
    
    // Return componet status
    public boolean istxtUserListFilterValueEnabled() { return this.txtListFilterValue.isEnabled(); }
    public boolean istxtRowIdEnabled() { return this.txtRowId.isEnabled(); }
    public boolean istxtAccountNumberEnabled() { return this.txtAccountNumber.isEnabled(); }
    public boolean istxtNameEnabled() { return this.txtName.isEnabled(); }
    public boolean istxtSurnameEnabled() { return this.txtSurname.isEnabled(); }
    public boolean istxtContactMPhoneEnabled() { return this.txtContactMPhone.isEnabled(); }
    public boolean istxtContactEmailEnabled() { return this.txtContactEmail.isEnabled(); }
    public boolean istxtContactPhoneEnabled() { return this.txtContactPhone.isEnabled(); }
    public boolean istxtContactEnterpriseEnabled() { return this.txtContactEnterprise.isEnabled(); }
    public boolean istxtFacebookEnabled() { return this.txtFacebook.isEnabled(); }
    public boolean istxtInstagramEnabled() { return this.txtInstagram.isEnabled(); }
    public boolean istxtTwitterEnabled() { return this.txtTwitter.isEnabled(); }    
    public boolean istxtFullAddressEnabled() { return this.txtFullAddress.isEnabled(); }
    
    public boolean iscbbUserListFilterEnabled() { return this.cbbListFilter.isEnabled(); }
    public boolean iscbbSexEnabled() { return this.cbbSex.isEnabled(); }
    
    public boolean islblRecCountEnabled() { return this.lblRecCount.isEnabled(); }
    public boolean islblAccountNameHeaderEnabled() { return this.lblAccountNameHeader.isEnabled(); }
    
    public boolean isbtnEditEnabled() { return this.btnEdit.isEnabled(); }
    public boolean isbtnNewEnabled() { return this.btnNew.isEnabled(); }
    public boolean isbtnSaveEnabled() { return this.btnSave.isEnabled(); }
    public boolean isbtnCancelEnabled() { return this.btnCancel.isEnabled(); }
    public boolean isbtnDeleteEnabled() { return this.btnDelete.isEnabled(); }
    public boolean isbtnAddAddressEnabled() { return this.btnAddAddress.isEnabled(); }
    
    // Button Functions
    public void clickSave(){ this.btnSave.setEnabled(true); this.btnSave.doClick(); this.btnSave.setEnabled(false); }
    public void clickNew(){ this.btnNew.setEnabled(true); this.btnNew.doClick(); this.btnNew.setEnabled(false); }
    public void clickEdit(){ this.btnEdit.setEnabled(true); this.btnEdit.doClick(); this.btnEdit.setEnabled(false); }
    public void clickCancel(){ this.btnCancel.setEnabled(true); this.btnCancel.doClick(); this.btnCancel.setEnabled(false); }
    public void clickDelete(){ this.btnDelete.setEnabled(true); this.btnDelete.doClick(); this.btnDelete.setEnabled(false); }
    
    // Set Focus on Specific component
    public void setFocus(String component) {
        switch (component) {
        case "FILTRO_VALOR":
            this.txtListFilterValue.requestFocus();
            break;
        case "ID":
            this.txtRowId.requestFocus();
            break;
        case "NOME":
            this.txtName.requestFocus();
            break;
        case "SOBRENOME":
            this.txtSurname.requestFocus();
            break;
        case "SEXO":
            this.cbbSex.requestFocus();
            break;
        case "FILTRO":
            this.cbbListFilter.requestFocus();
            break;
        case "CONTATO_CELULAR":
            this.txtContactMPhone.requestFocus();
            break;
        case "CONTATO_EMAIL":
            this.txtContactEmail.requestFocus();
            break;
        case "CONTATO_TELEFONE_FIXO":
            this.txtContactPhone.requestFocus();
            break;
        case "CONTATO_TELEFONE_COMERCIAL":
            this.txtContactEnterprise.requestFocus();
            break;
        case "REDE_SOCIAL_FACEBOOK":
            this.txtFacebook.requestFocus();
            break;
        case "REDE_SOCIAL_INSTAGRAM":
            this.txtInstagram.requestFocus();
            break;
        case "REDE_SOCIAL_TWITTER":
            this.txtTwitter.requestFocus();
            break;
        case "ENDERECO_COMPLETO":
            this.txtFullAddress.requestFocus();
            break;
        case "BOTAO_EDITAR":
            this.btnEdit.requestFocus();
            break;
        case "BOTAO_NOVO":
            this.btnNew.requestFocus();
            break;
        case "BOTAO_SALVAR":
            this.btnSave.requestFocus();
            break;
        case "BOTAO_CANCELAR":
            this.btnCancel.requestFocus();
            break;
        case "BOTAO_DELETAR":
            this.btnDelete.requestFocus();
            break;
        case "BOTAO_ADD_ENDERECO":
            this.btnAddAddress.requestFocus();
            break;
        default:
            break;
        }
    }
    
    public void enableFields(String funcao) {
	switch (funcao){
            case "LOAD_SCREEN":
                settxtUserListFilterValueEnabled(true);
                settxtRowIdEnabled(false);
                settxtAccountNumberEnabled(false);
                settxtNameEnabled(false);
                settxtSurnameEnabled(false);
                settxtContactMPhoneEnabled(false);
                settxtContactEmailEnabled(false);
                settxtContactPhoneEnabled(false);
                settxtContactEnterpriseEnabled(false);
                settxtFacebookEnabled(false);
                settxtInstagramEnabled(false);
                settxtTwitterEnabled(false);                
                settxtFullAddressEnabled(false);

                setcbbUserListFilterEnabled(true);
                setcbbSexEnabled(false);
                
                setTblEnabled(true);

                setbtnEditEnabled(false);
                setbtnNewEnabled(true);
                setbtnSaveEnabled(false);
                setbtnDeleteEnabled(false);
                setbtnCancelEnabled(false);
                setbtnAddAddressEnabled(false);
                break;
            case "NOVO":
                settxtUserListFilterValueEnabled(true);
                settxtRowIdEnabled(false);
                settxtAccountNumberEnabled(false);
                settxtNameEnabled(true);
                settxtSurnameEnabled(true);
                settxtContactMPhoneEnabled(true);
                settxtContactEmailEnabled(true);
                settxtContactPhoneEnabled(true);
                settxtContactEnterpriseEnabled(true);
                settxtFacebookEnabled(true);
                settxtInstagramEnabled(true);
                settxtTwitterEnabled(true);
                settxtFullAddressEnabled(false);

                setcbbUserListFilterEnabled(true);
                setcbbSexEnabled(true);
                
                setTblEnabled(false);
                
                setbtnEditEnabled(false);
                setbtnNewEnabled(false);
                setbtnSaveEnabled(true);
                setbtnCancelEnabled(true);
                setbtnDeleteEnabled(false);
                setbtnAddAddressEnabled(true);
                break;
            case "EDITAR":
                settxtUserListFilterValueEnabled(true);
                settxtRowIdEnabled(false);
                settxtAccountNumberEnabled(false);
                settxtNameEnabled(true);
                settxtSurnameEnabled(true);
                settxtContactMPhoneEnabled(true);
                settxtContactEmailEnabled(true);
                settxtContactPhoneEnabled(true);
                settxtContactEnterpriseEnabled(true);
                settxtFacebookEnabled(true);
                settxtInstagramEnabled(true);
                settxtTwitterEnabled(true);
                settxtFullAddressEnabled(false);

                setcbbUserListFilterEnabled(true);
                setcbbSexEnabled(true);
                
                setTblEnabled(false);
                
                setbtnEditEnabled(false);
                setbtnDeleteEnabled(false);
                setbtnNewEnabled(false);
                setbtnSaveEnabled(true);
                setbtnCancelEnabled(true);
                setbtnAddAddressEnabled(true);
                break;
            case "CANCELAR":
                settxtUserListFilterValueEnabled(true);
                settxtRowIdEnabled(false);
                settxtAccountNumberEnabled(false);
                settxtNameEnabled(false);
                settxtSurnameEnabled(false);
                settxtContactMPhoneEnabled(false);
                settxtContactEmailEnabled(false);
                settxtContactPhoneEnabled(false);
                settxtContactEnterpriseEnabled(false);
                settxtFacebookEnabled(false);
                settxtInstagramEnabled(false);
                settxtTwitterEnabled(false);
                settxtFullAddressEnabled(false);

                setcbbUserListFilterEnabled(true);
                setcbbSexEnabled(false);
                
                setTblEnabled(true);
                
                setbtnEditEnabled(false);
                setbtnDeleteEnabled(false);
                setbtnNewEnabled(true);
                setbtnSaveEnabled(false);
                setbtnCancelEnabled(false);
                setbtnAddAddressEnabled(false);
                break;
            case "DELETAR":
                settxtUserListFilterValueEnabled(true);
                settxtRowIdEnabled(false);
                settxtAccountNumberEnabled(false);
                settxtNameEnabled(false);
                settxtSurnameEnabled(false);
                settxtContactMPhoneEnabled(false);
                settxtContactEmailEnabled(false);
                settxtContactPhoneEnabled(false);
                settxtContactEnterpriseEnabled(false);
                settxtFacebookEnabled(false);
                settxtInstagramEnabled(false);
                settxtTwitterEnabled(false);
                settxtFullAddressEnabled(false);

                setcbbUserListFilterEnabled(true);
                setcbbSexEnabled(false);
                
                setTblEnabled(true);
                
                setbtnEditEnabled(true);
                setbtnDeleteEnabled(true);
                setbtnNewEnabled(true);
                setbtnSaveEnabled(false);
                setbtnCancelEnabled(false);
                setbtnAddAddressEnabled(false);
                break;
            case "SALVAR":
                settxtUserListFilterValueEnabled(true);
                settxtRowIdEnabled(false);
                settxtAccountNumberEnabled(false);
                settxtNameEnabled(false);
                settxtSurnameEnabled(false);
                settxtContactMPhoneEnabled(false);
                settxtContactEmailEnabled(false);
                settxtContactPhoneEnabled(false);
                settxtContactEnterpriseEnabled(false);
                settxtFacebookEnabled(false);
                settxtInstagramEnabled(false);
                settxtTwitterEnabled(false);
                settxtFullAddressEnabled(false);

                setcbbUserListFilterEnabled(true);
                setcbbSexEnabled(false);
                
                setTblEnabled(true);
                
                setbtnEditEnabled(true);
                setbtnDeleteEnabled(true);
                setbtnNewEnabled(true);
                setbtnSaveEnabled(false);
                setbtnCancelEnabled(false);
                setbtnAddAddressEnabled(false);
                break;
            default:
                break;
	}	
    }

    public void clearFields() {
        //cleartxtListFilterValue();
        cleartxtRowId();
        cleartxtAccountNumber();
        cleartxtName();
        cleartxtSurname();
        cleartxtContactMPhone();
        cleartxtContactEmail();
        cleartxtContactPhone();
        cleartxtContactEnterprise();
        cleartxtFacebook();
        cleartxtInstagram();
        cleartxtTwitter();                
        cleartxtFullAddress();
        
        setcbbSexItemIndex(0);
        
        clearlblAccountNameHeader();
    }
    
    public void clearComboBoxes(){
        clearcbbUserListFilter();
        clearcbbSex();
    }
    
    public void insertSelectComboBox(){
        this.setcbbListFilter("Selecione...");
        this.setcbbSex("Selecione...");
    }
    
    public final void FocusTraversalKeys(){
        this.txtListFilterValue.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtRowId.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtAccountNumber.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtName.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtSurname.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtContactMPhone.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtContactEmail.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtContactPhone.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtContactEnterprise.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtFacebook.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtInstagram.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtTwitter.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtFullAddress.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);

        this.cbbListFilter.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.cbbSex.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);

        this.lblRecCount.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelAccount = new javax.swing.JPanel();
        PanelAccountList = new javax.swing.JPanel();
        PanelAccountListHeader = new javax.swing.JPanel();
        lblAccountList = new javax.swing.JLabel();
        lblImage = new javax.swing.JLabel();
        cbbListFilter = new javax.swing.JComboBox<>();
        txtListFilterValue = new javax.swing.JTextField();
        lblInformation = new javax.swing.JLabel();
        lblRecCount = new javax.swing.JLabel();
        PanelListAccount = new javax.swing.JPanel();
        sPanelAccountList = new javax.swing.JScrollPane();
        tblAccountList = new javax.swing.JTable();
        PanelAccountForm = new javax.swing.JPanel();
        PanelAccountFormHeader = new javax.swing.JPanel();
        lblAccountNameHeader = new javax.swing.JLabel();
        lblAccountFormInformation = new javax.swing.JLabel();
        btnQuery = new javax.swing.JButton();
        btnGoQuery = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        btnEdit = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        PanelAccountIdentity = new javax.swing.JPanel();
        sPanelAccountIdentityForm = new javax.swing.JScrollPane();
        PanelFormAccountIdentity = new javax.swing.JPanel();
        lblSurname = new javax.swing.JLabel();
        lblPersonalData = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        txtSurname = new javax.swing.JTextField();
        cbbSex = new javax.swing.JComboBox<>();
        txtName = new javax.swing.JTextField();
        lblSex = new javax.swing.JLabel();
        lblRowId = new javax.swing.JLabel();
        txtRowId = new javax.swing.JTextField();
        lblContactMPhone = new javax.swing.JLabel();
        lblContactEmail = new javax.swing.JLabel();
        txtContactEmail = new javax.swing.JTextField();
        lblContactPhone = new javax.swing.JLabel();
        lblContactEnterprise = new javax.swing.JLabel();
        lblContactInformation = new javax.swing.JLabel();
        btnAddAddress = new javax.swing.JButton();
        lblFullAddress = new javax.swing.JLabel();
        lblSocialMedia = new javax.swing.JLabel();
        txtFullAddress = new javax.swing.JTextField();
        lblFacebook = new javax.swing.JLabel();
        txtFacebook = new javax.swing.JTextField();
        lblInstagram = new javax.swing.JLabel();
        txtInstagram = new javax.swing.JTextField();
        lblTwitter = new javax.swing.JLabel();
        txtTwitter = new javax.swing.JTextField();
        lblAddressInformation = new javax.swing.JLabel();
        lblAddAddress = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        txtAccountNumber = new javax.swing.JTextField();
        txtContactMPhone = new javax.swing.JFormattedTextField();
        txtContactPhone = new javax.swing.JFormattedTextField();
        txtContactEnterprise = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Clientes");
        setResizable(false);

        PanelAccount.setBackground(new java.awt.Color(255, 255, 255));
        PanelAccount.setPreferredSize(new java.awt.Dimension(1366, 757));

        lblAccountList.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        lblAccountList.setText("Clientes");

        lblImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/20px/Filter 20x20.png"))); // NOI18N

        cbbListFilter.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        cbbListFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbListFilter.setMaximumSize(new java.awt.Dimension(250, 32767));
        cbbListFilter.setPreferredSize(new java.awt.Dimension(250, 23));
        cbbListFilter.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbListFilterItemStateChanged(evt);
            }
        });

        txtListFilterValue.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtListFilterValue.setToolTipText("");
        txtListFilterValue.setMaximumSize(new java.awt.Dimension(250, 2147483647));
        txtListFilterValue.setPreferredSize(new java.awt.Dimension(250, 23));

        lblInformation.setBackground(new java.awt.Color(255, 255, 255));
        lblInformation.setText("Pressione Enter para pesquisar");
        lblInformation.setEnabled(false);

        lblRecCount.setBackground(new java.awt.Color(255, 255, 255));
        lblRecCount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblRecCount.setText("Registro: 0 - 100");
        lblRecCount.setToolTipText("");
        lblRecCount.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblRecCount.setMaximumSize(new java.awt.Dimension(410, 14));

        javax.swing.GroupLayout PanelAccountListHeaderLayout = new javax.swing.GroupLayout(PanelAccountListHeader);
        PanelAccountListHeader.setLayout(PanelAccountListHeaderLayout);
        PanelAccountListHeaderLayout.setHorizontalGroup(
            PanelAccountListHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAccountListHeaderLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(lblAccountList, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(lblImage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbbListFilter, 0, 162, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtListFilterValue, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInformation)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRecCount, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                .addContainerGap())
        );
        PanelAccountListHeaderLayout.setVerticalGroup(
            PanelAccountListHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelAccountListHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelAccountListHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbbListFilter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblAccountList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblImage, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblRecCount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblInformation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtListFilterValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        sPanelAccountList.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        sPanelAccountList.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        sPanelAccountList.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N

        tblAccountList.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        tblAccountList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Número do Cliente", "Nome", "Sobrenome", "Celular/WhatsApp", "Email", "Facebook", "Instagram", "Twitter", "Endereço"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblAccountList.setGridColor(new java.awt.Color(204, 204, 204));
        tblAccountList.setRowHeight(22);
        tblAccountList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        sPanelAccountList.setViewportView(tblAccountList);

        javax.swing.GroupLayout PanelListAccountLayout = new javax.swing.GroupLayout(PanelListAccount);
        PanelListAccount.setLayout(PanelListAccountLayout);
        PanelListAccountLayout.setHorizontalGroup(
            PanelListAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sPanelAccountList)
        );
        PanelListAccountLayout.setVerticalGroup(
            PanelListAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sPanelAccountList, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PanelAccountListLayout = new javax.swing.GroupLayout(PanelAccountList);
        PanelAccountList.setLayout(PanelAccountListLayout);
        PanelAccountListLayout.setHorizontalGroup(
            PanelAccountListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelAccountListLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelAccountListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelListAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelAccountListHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        PanelAccountListLayout.setVerticalGroup(
            PanelAccountListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAccountListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelAccountListHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelListAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        lblAccountNameHeader.setBackground(new java.awt.Color(255, 255, 255));
        lblAccountNameHeader.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        lblAccountNameHeader.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblAccountNameHeader.setToolTipText("");
        lblAccountNameHeader.setMinimumSize(new java.awt.Dimension(0, 30));

        lblAccountFormInformation.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblAccountFormInformation.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAccountFormInformation.setText("Campos Obrigatórios (*)");
        lblAccountFormInformation.setEnabled(false);

        btnQuery.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnQuery.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/20px/Lupa 20x20.png"))); // NOI18N
        btnQuery.setToolTipText("Pesquisar");
        btnQuery.setBorderPainted(false);
        btnQuery.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnQuery.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnQuery.setIconTextGap(0);
        btnQuery.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnQuery.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnQueryKeyPressed(evt);
            }
        });

        btnGoQuery.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnGoQuery.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/20px/Go 20x20.png"))); // NOI18N
        btnGoQuery.setToolTipText("Ir");
        btnGoQuery.setBorderPainted(false);
        btnGoQuery.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnGoQuery.setEnabled(false);
        btnGoQuery.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnGoQuery.setIconTextGap(3);
        btnGoQuery.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnGoQueryKeyPressed(evt);
            }
        });

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btnEdit.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/20px/Edit 20x20.png"))); // NOI18N
        btnEdit.setToolTipText("Editar");
        btnEdit.setBorderPainted(false);
        btnEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEdit.setEnabled(false);
        btnEdit.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnEdit.setIconTextGap(3);
        btnEdit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnEditKeyPressed(evt);
            }
        });

        btnNew.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/20px/New 20x20.png"))); // NOI18N
        btnNew.setToolTipText("Novo");
        btnNew.setBorderPainted(false);
        btnNew.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNew.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnNew.setIconTextGap(0);
        btnNew.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnNew.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnNewKeyPressed(evt);
            }
        });

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btnSave.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/20px/Save 20x20.png"))); // NOI18N
        btnSave.setToolTipText("Salvar");
        btnSave.setEnabled(false);
        btnSave.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnSave.setIconTextGap(3);
        btnSave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnSaveKeyPressed(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/20px/Cancel 20x20.png"))); // NOI18N
        btnCancel.setToolTipText("Cancelar");
        btnCancel.setEnabled(false);
        btnCancel.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnCancel.setIconTextGap(3);
        btnCancel.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnCancel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnCancelKeyPressed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/20px/Delete 20x20.png"))); // NOI18N
        btnDelete.setToolTipText("Excluir");
        btnDelete.setBorderPainted(false);
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDelete.setEnabled(false);
        btnDelete.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnDelete.setIconTextGap(3);
        btnDelete.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnDeleteKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout PanelAccountFormHeaderLayout = new javax.swing.GroupLayout(PanelAccountFormHeader);
        PanelAccountFormHeader.setLayout(PanelAccountFormHeaderLayout);
        PanelAccountFormHeaderLayout.setHorizontalGroup(
            PanelAccountFormHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelAccountFormHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAccountNameHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAccountFormInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnQuery, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGoQuery, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        PanelAccountFormHeaderLayout.setVerticalGroup(
            PanelAccountFormHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAccountFormHeaderLayout.createSequentialGroup()
                .addGroup(PanelAccountFormHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAccountFormInformation, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblAccountNameHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnQuery, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGoQuery, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        PanelAccountIdentity.setPreferredSize(new java.awt.Dimension(1027, 50));

        sPanelAccountIdentityForm.setBorder(null);
        sPanelAccountIdentityForm.setMinimumSize(new java.awt.Dimension(0, 0));

        PanelFormAccountIdentity.setBackground(new java.awt.Color(255, 255, 255));
        PanelFormAccountIdentity.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        PanelFormAccountIdentity.setPreferredSize(new java.awt.Dimension(670, 50));

        lblSurname.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblSurname.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSurname.setText("Sobrenome*:");
        lblSurname.setEnabled(false);

        lblPersonalData.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.light"));
        lblPersonalData.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblPersonalData.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPersonalData.setText("   Dados Pessoais");
        lblPersonalData.setToolTipText("");
        lblPersonalData.setEnabled(false);
        lblPersonalData.setOpaque(true);

        lblName.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblName.setText("Nome*:");
        lblName.setEnabled(false);

        txtSurname.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtSurname.setText("jTextField1");
        txtSurname.setEnabled(false);
        txtSurname.setMaximumSize(new java.awt.Dimension(165, 22));
        txtSurname.setMinimumSize(new java.awt.Dimension(165, 22));
        txtSurname.setPreferredSize(new java.awt.Dimension(165, 22));
        txtSurname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSurnameKeyPressed(evt);
            }
        });

        cbbSex.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        cbbSex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbSex.setEnabled(false);
        cbbSex.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbSexItemStateChanged(evt);
            }
        });
        cbbSex.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbbSexKeyPressed(evt);
            }
        });

        txtName.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtName.setText("Matheus Cabral Rosa");
        txtName.setEnabled(false);
        txtName.setMaximumSize(new java.awt.Dimension(165, 22));
        txtName.setMinimumSize(new java.awt.Dimension(165, 22));
        txtName.setPreferredSize(new java.awt.Dimension(165, 22));
        txtName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNameKeyPressed(evt);
            }
        });

        lblSex.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblSex.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSex.setText("Sexo*:");
        lblSex.setEnabled(false);

        lblRowId.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblRowId.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblRowId.setText("Id:");
        lblRowId.setEnabled(false);

        txtRowId.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtRowId.setText("jTextField1");
        txtRowId.setEnabled(false);
        txtRowId.setMaximumSize(new java.awt.Dimension(165, 22));
        txtRowId.setMinimumSize(new java.awt.Dimension(165, 22));
        txtRowId.setPreferredSize(new java.awt.Dimension(165, 22));

        lblContactMPhone.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblContactMPhone.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblContactMPhone.setText("Celular/WhatsApp*:");
        lblContactMPhone.setEnabled(false);

        lblContactEmail.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblContactEmail.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblContactEmail.setText("Email:");
        lblContactEmail.setToolTipText("");
        lblContactEmail.setEnabled(false);

        txtContactEmail.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtContactEmail.setText("matheuscabralrosa@gmail.com");
        txtContactEmail.setToolTipText("");
        txtContactEmail.setEnabled(false);
        txtContactEmail.setMaximumSize(new java.awt.Dimension(165, 22));
        txtContactEmail.setMinimumSize(new java.awt.Dimension(165, 22));
        txtContactEmail.setPreferredSize(new java.awt.Dimension(165, 22));
        txtContactEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtContactEmailKeyPressed(evt);
            }
        });

        lblContactPhone.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblContactPhone.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblContactPhone.setText("Telefone Fixo:");
        lblContactPhone.setEnabled(false);

        lblContactEnterprise.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblContactEnterprise.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblContactEnterprise.setText("Telefone Comercial:");
        lblContactEnterprise.setEnabled(false);

        lblContactInformation.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.light"));
        lblContactInformation.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblContactInformation.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblContactInformation.setText("   Informações de Contato");
        lblContactInformation.setToolTipText("");
        lblContactInformation.setEnabled(false);
        lblContactInformation.setOpaque(true);

        btnAddAddress.setText("Visualizar/Cadastrar");
        btnAddAddress.setEnabled(false);
        btnAddAddress.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                btnAddAddressFocusLost(evt);
            }
        });
        btnAddAddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnAddAddressKeyPressed(evt);
            }
        });

        lblFullAddress.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblFullAddress.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFullAddress.setText("Endereço Completo:");
        lblFullAddress.setEnabled(false);

        lblSocialMedia.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.light"));
        lblSocialMedia.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblSocialMedia.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblSocialMedia.setText("   Redes Sociais");
        lblSocialMedia.setToolTipText("");
        lblSocialMedia.setEnabled(false);
        lblSocialMedia.setOpaque(true);

        txtFullAddress.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtFullAddress.setText("jTextField1");
        txtFullAddress.setEnabled(false);
        txtFullAddress.setMaximumSize(new java.awt.Dimension(165, 22));
        txtFullAddress.setMinimumSize(new java.awt.Dimension(165, 22));
        txtFullAddress.setPreferredSize(new java.awt.Dimension(165, 22));
        txtFullAddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFullAddressKeyPressed(evt);
            }
        });

        lblFacebook.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblFacebook.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFacebook.setText("Facebook:");
        lblFacebook.setEnabled(false);

        txtFacebook.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtFacebook.setText("jTextField1");
        txtFacebook.setEnabled(false);
        txtFacebook.setMaximumSize(new java.awt.Dimension(165, 22));
        txtFacebook.setMinimumSize(new java.awt.Dimension(165, 22));
        txtFacebook.setPreferredSize(new java.awt.Dimension(165, 22));
        txtFacebook.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFacebookKeyPressed(evt);
            }
        });

        lblInstagram.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblInstagram.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblInstagram.setText("Instagram:");
        lblInstagram.setEnabled(false);

        txtInstagram.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtInstagram.setText("jTextField1");
        txtInstagram.setEnabled(false);
        txtInstagram.setMaximumSize(new java.awt.Dimension(165, 22));
        txtInstagram.setMinimumSize(new java.awt.Dimension(165, 22));
        txtInstagram.setPreferredSize(new java.awt.Dimension(165, 22));
        txtInstagram.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtInstagramKeyPressed(evt);
            }
        });

        lblTwitter.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblTwitter.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTwitter.setText("Twitter");
        lblTwitter.setEnabled(false);

        txtTwitter.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtTwitter.setText("jTextField1");
        txtTwitter.setEnabled(false);
        txtTwitter.setMaximumSize(new java.awt.Dimension(165, 22));
        txtTwitter.setMinimumSize(new java.awt.Dimension(165, 22));
        txtTwitter.setPreferredSize(new java.awt.Dimension(165, 22));
        txtTwitter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTwitterKeyPressed(evt);
            }
        });

        lblAddressInformation.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.light"));
        lblAddressInformation.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblAddressInformation.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblAddressInformation.setText("   Informações de Endereço");
        lblAddressInformation.setEnabled(false);
        lblAddressInformation.setOpaque(true);

        lblAddAddress.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblAddAddress.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAddAddress.setText("Endereço:");
        lblAddAddress.setEnabled(false);

        lblUser.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblUser.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblUser.setText("Número do Cliente:");
        lblUser.setEnabled(false);

        txtAccountNumber.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtAccountNumber.setText("jTextField1");
        txtAccountNumber.setEnabled(false);
        txtAccountNumber.setMaximumSize(new java.awt.Dimension(165, 22));
        txtAccountNumber.setMinimumSize(new java.awt.Dimension(165, 22));
        txtAccountNumber.setPreferredSize(new java.awt.Dimension(165, 22));
        txtAccountNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAccountNumberKeyPressed(evt);
            }
        });

        try {
            txtContactMPhone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtContactMPhone.setToolTipText("");
        txtContactMPhone.setEnabled(false);
        txtContactMPhone.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        txtContactMPhone.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtContactMPhone.setMaximumSize(new java.awt.Dimension(165, 22));
        txtContactMPhone.setMinimumSize(new java.awt.Dimension(165, 22));
        txtContactMPhone.setPreferredSize(new java.awt.Dimension(165, 22));

        try {
            txtContactPhone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtContactPhone.setText("");
        txtContactPhone.setEnabled(false);
        txtContactPhone.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        txtContactPhone.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtContactPhone.setMaximumSize(new java.awt.Dimension(165, 22));
        txtContactPhone.setMinimumSize(new java.awt.Dimension(165, 22));
        txtContactPhone.setPreferredSize(new java.awt.Dimension(165, 22));

        try {
            txtContactEnterprise.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtContactEnterprise.setText("");
        txtContactEnterprise.setToolTipText("");
        txtContactEnterprise.setEnabled(false);
        txtContactEnterprise.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        txtContactEnterprise.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtContactEnterprise.setMaximumSize(new java.awt.Dimension(165, 22));
        txtContactEnterprise.setMinimumSize(new java.awt.Dimension(165, 22));
        txtContactEnterprise.setPreferredSize(new java.awt.Dimension(165, 22));

        javax.swing.GroupLayout PanelFormAccountIdentityLayout = new javax.swing.GroupLayout(PanelFormAccountIdentity);
        PanelFormAccountIdentity.setLayout(PanelFormAccountIdentityLayout);
        PanelFormAccountIdentityLayout.setHorizontalGroup(
            PanelFormAccountIdentityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFormAccountIdentityLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelFormAccountIdentityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelFormAccountIdentityLayout.createSequentialGroup()
                        .addGroup(PanelFormAccountIdentityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblPersonalData, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(PanelFormAccountIdentityLayout.createSequentialGroup()
                                .addComponent(lblRowId, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtRowId, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(PanelFormAccountIdentityLayout.createSequentialGroup()
                        .addGroup(PanelFormAccountIdentityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblSurname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblUser, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblSex, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelFormAccountIdentityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelFormAccountIdentityLayout.createSequentialGroup()
                                .addComponent(txtAccountNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(PanelFormAccountIdentityLayout.createSequentialGroup()
                                .addGroup(PanelFormAccountIdentityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PanelFormAccountIdentityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtSurname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cbbSex, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGroup(PanelFormAccountIdentityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblContactInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelFormAccountIdentityLayout.createSequentialGroup()
                        .addGroup(PanelFormAccountIdentityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblContactPhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblContactEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblContactMPhone, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(lblContactEnterprise, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelFormAccountIdentityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtContactMPhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtContactPhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtContactEnterprise, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtContactEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelFormAccountIdentityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblSocialMedia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PanelFormAccountIdentityLayout.createSequentialGroup()
                        .addComponent(lblFacebook, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFacebook, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelFormAccountIdentityLayout.createSequentialGroup()
                        .addComponent(lblInstagram, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtInstagram, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelFormAccountIdentityLayout.createSequentialGroup()
                        .addComponent(lblTwitter, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTwitter, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblAddressInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelFormAccountIdentityLayout.createSequentialGroup()
                        .addComponent(lblAddAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelFormAccountIdentityLayout.createSequentialGroup()
                        .addComponent(lblFullAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFullAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PanelFormAccountIdentityLayout.setVerticalGroup(
            PanelFormAccountIdentityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFormAccountIdentityLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelFormAccountIdentityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelFormAccountIdentityLayout.createSequentialGroup()
                        .addComponent(lblSocialMedia, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelFormAccountIdentityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFacebook, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFacebook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(PanelFormAccountIdentityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblInstagram, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtInstagram, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelFormAccountIdentityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTwitter, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTwitter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PanelFormAccountIdentityLayout.createSequentialGroup()
                        .addGroup(PanelFormAccountIdentityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPersonalData, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblContactInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelFormAccountIdentityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblRowId, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblContactMPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRowId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtContactMPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelFormAccountIdentityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAccountNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblContactEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtContactEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(PanelFormAccountIdentityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblContactPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtContactPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelFormAccountIdentityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSurname, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblContactEnterprise, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAddressInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtContactEnterprise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelFormAccountIdentityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSex, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbSex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAddAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddAddress))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelFormAccountIdentityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFullAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFullAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        sPanelAccountIdentityForm.setViewportView(PanelFormAccountIdentity);

        javax.swing.GroupLayout PanelAccountIdentityLayout = new javax.swing.GroupLayout(PanelAccountIdentity);
        PanelAccountIdentity.setLayout(PanelAccountIdentityLayout);
        PanelAccountIdentityLayout.setHorizontalGroup(
            PanelAccountIdentityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sPanelAccountIdentityForm, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelAccountIdentityLayout.setVerticalGroup(
            PanelAccountIdentityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sPanelAccountIdentityForm, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PanelAccountFormLayout = new javax.swing.GroupLayout(PanelAccountForm);
        PanelAccountForm.setLayout(PanelAccountFormLayout);
        PanelAccountFormLayout.setHorizontalGroup(
            PanelAccountFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelAccountFormHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PanelAccountFormLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelAccountIdentity, javax.swing.GroupLayout.DEFAULT_SIZE, 997, Short.MAX_VALUE)
                .addContainerGap())
        );
        PanelAccountFormLayout.setVerticalGroup(
            PanelAccountFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAccountFormLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelAccountFormHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelAccountIdentity, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout PanelAccountLayout = new javax.swing.GroupLayout(PanelAccount);
        PanelAccount.setLayout(PanelAccountLayout);
        PanelAccountLayout.setHorizontalGroup(
            PanelAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelAccountList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelAccountForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelAccountLayout.setVerticalGroup(
            PanelAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAccountLayout.createSequentialGroup()
                .addComponent(PanelAccountList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelAccountForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelAccount, javax.swing.GroupLayout.DEFAULT_SIZE, 1017, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelAccount, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbbListFilterItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbListFilterItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            setFocus("FILTRO_VALOR");
        }
    }//GEN-LAST:event_cbbListFilterItemStateChanged

    private void txtSurnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSurnameKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("APELIDO");
        }
    }//GEN-LAST:event_txtSurnameKeyPressed

    private void cbbSexItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbSexItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            setFocus("NASCIMENTO_DIA");
        }
    }//GEN-LAST:event_cbbSexItemStateChanged

    private void cbbSexKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbbSexKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_TAB){
            setFocus("NASCIMENTO_DIA");
        }
    }//GEN-LAST:event_cbbSexKeyPressed

    private void txtNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("SOBRENOME");
        }
    }//GEN-LAST:event_txtNameKeyPressed

    private void txtContactEmailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContactEmailKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContactEmailKeyPressed

    private void btnAddAddressFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnAddAddressFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddAddressFocusLost

    private void btnAddAddressKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAddAddressKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddAddressKeyPressed

    private void txtFullAddressKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFullAddressKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFullAddressKeyPressed

    private void txtFacebookKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFacebookKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFacebookKeyPressed

    private void txtInstagramKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtInstagramKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtInstagramKeyPressed

    private void txtTwitterKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTwitterKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTwitterKeyPressed

    private void btnQueryKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnQueryKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnQueryKeyPressed

    private void btnGoQueryKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnGoQueryKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGoQueryKeyPressed

    private void btnEditKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnEditKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_TAB){
            setFocus("BOTAO_NOVO");
        }
    }//GEN-LAST:event_btnEditKeyPressed

    private void btnNewKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnNewKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_TAB){
            setFocus("BOTAO_EDITAR");
        }
    }//GEN-LAST:event_btnNewKeyPressed

    private void btnSaveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSaveKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_TAB){
            setFocus("BOTAO_CANCELAR");
        }
    }//GEN-LAST:event_btnSaveKeyPressed

    private void btnCancelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCancelKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_TAB){
            setFocus("BOTAO_SALVAR");
        }
    }//GEN-LAST:event_btnCancelKeyPressed

    private void btnDeleteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnDeleteKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteKeyPressed

    private void txtAccountNumberKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAccountNumberKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_TAB){
            setFocus("SENHA");
        }
    }//GEN-LAST:event_txtAccountNumberKeyPressed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelAccount;
    private javax.swing.JPanel PanelAccountForm;
    private javax.swing.JPanel PanelAccountFormHeader;
    private javax.swing.JPanel PanelAccountIdentity;
    private javax.swing.JPanel PanelAccountList;
    private javax.swing.JPanel PanelAccountListHeader;
    private javax.swing.JPanel PanelFormAccountIdentity;
    private javax.swing.JPanel PanelListAccount;
    private javax.swing.JButton btnAddAddress;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnGoQuery;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnQuery;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cbbListFilter;
    private javax.swing.JComboBox<String> cbbSex;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblAccountFormInformation;
    private javax.swing.JLabel lblAccountList;
    private javax.swing.JLabel lblAccountNameHeader;
    private javax.swing.JLabel lblAddAddress;
    private javax.swing.JLabel lblAddressInformation;
    private javax.swing.JLabel lblContactEmail;
    private javax.swing.JLabel lblContactEnterprise;
    private javax.swing.JLabel lblContactInformation;
    private javax.swing.JLabel lblContactMPhone;
    private javax.swing.JLabel lblContactPhone;
    private javax.swing.JLabel lblFacebook;
    private javax.swing.JLabel lblFullAddress;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblInformation;
    private javax.swing.JLabel lblInstagram;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPersonalData;
    private javax.swing.JLabel lblRecCount;
    private javax.swing.JLabel lblRowId;
    private javax.swing.JLabel lblSex;
    private javax.swing.JLabel lblSocialMedia;
    private javax.swing.JLabel lblSurname;
    private javax.swing.JLabel lblTwitter;
    private javax.swing.JLabel lblUser;
    private javax.swing.JScrollPane sPanelAccountIdentityForm;
    private javax.swing.JScrollPane sPanelAccountList;
    private javax.swing.JTable tblAccountList;
    private javax.swing.JTextField txtAccountNumber;
    private javax.swing.JTextField txtContactEmail;
    private javax.swing.JFormattedTextField txtContactEnterprise;
    private javax.swing.JFormattedTextField txtContactMPhone;
    private javax.swing.JFormattedTextField txtContactPhone;
    private javax.swing.JTextField txtFacebook;
    private javax.swing.JTextField txtFullAddress;
    private javax.swing.JTextField txtInstagram;
    private javax.swing.JTextField txtListFilterValue;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtRowId;
    private javax.swing.JTextField txtSurname;
    private javax.swing.JTextField txtTwitter;
    // End of variables declaration//GEN-END:variables
}
