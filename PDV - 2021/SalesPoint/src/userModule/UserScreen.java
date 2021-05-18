/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userModule;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.util.Collections;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Matheus Cabral Rosa
 */
public class UserScreen extends javax.swing.JFrame {

    /**
     * Creates new form UserManagement
     */
    public UserScreen() {
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
    public void setListenerBtnEditUser(ActionListener listener) { this.btnEditUser.addActionListener(listener); }
    public void setListenerBtnNewUser(ActionListener listener) { this.btnNewUser.addActionListener(listener); }
    public void setListenerBtnSaveUser(ActionListener listener) { this.btnSaveUser.addActionListener(listener); }
    public void setListenerBtnCancelUser(ActionListener listener) { this.btnCancelUser.addActionListener(listener); }
    public void setListenerBtnDelete(ActionListener listener) { this.btnDelete.addActionListener(listener); }
    public void setListenerBtnAddContact(ActionListener listener) { this.btnAddContact.addActionListener(listener); }
    public void setListenerBtnAddAddress(ActionListener listener) { this.btnAddAddress.addActionListener(listener); }
    public void setListenerBtnPermitions(ActionListener listener) { this.btnPermitions.addActionListener(listener); }
    
    // Table
    public DefaultTableModel getTableModel(){ return (DefaultTableModel) tblUserList.getModel(); }    
    public void setListenerTblUserListSelection(ListSelectionListener listener) { this.tblUserList.getSelectionModel().addListSelectionListener(listener); }
    public String getSelectedUserListId() { try { return (String) this.tblUserList.getValueAt(this.tblUserList.getSelectedRow(), 0); } catch (Exception e) { return ""; } }
    
    // Component Setters
    public void settxtUserListFilterValue(String value) { this.txtUserListFilterValue.setText(value); this.txtUserListFilterValue.paintImmediately(this.txtUserListFilterValue.getVisibleRect()); }
    public void settxtRowId(String value) { this.txtRowId.setText(value); this.txtRowId.paintImmediately(this.txtRowId.getVisibleRect()); }
    public void settxtUser(String value) { this.txtUser.setText(value); this.txtUser.paintImmediately(this.txtUser.getVisibleRect()); }
    public void settxtPass(String value) { this.txtPass.setText(value); this.txtPass.paintImmediately(this.txtPass.getVisibleRect()); }
    public void settxtPassVerification(String value) { this.txtPassVerification.setText(value); this.txtPassVerification.paintImmediately(this.txtPassVerification.getVisibleRect()); }
    public void settxtSecQuestion1(String value) { this.txtSecQuestion1.setText(value); this.txtSecQuestion1.paintImmediately(this.txtSecQuestion1.getVisibleRect()); }
    public void settxtSecAnswer1(String value) { this.txtSecAnswer1.setText(value); this.txtSecAnswer1.paintImmediately(this.txtSecAnswer1.getVisibleRect()); }
    public void settxtSecQuestion2(String value) { this.txtSecQuestion2.setText(value); this.txtSecQuestion2.paintImmediately(this.txtSecQuestion2.getVisibleRect()); }
    public void settxtSecAnswer2(String value) { this.txtSecAnswer2.setText(value); this.txtSecAnswer2.paintImmediately(this.txtSecAnswer2.getVisibleRect()); }
    public void settxtSecQuestion3(String value) { this.txtSecQuestion3.setText(value); this.txtSecQuestion3.paintImmediately(this.txtSecQuestion3.getVisibleRect()); }
    public void settxtSecAnswer3(String value) { this.txtSecAnswer3.setText(value); this.txtSecAnswer3.paintImmediately(this.txtSecAnswer3.getVisibleRect()); }
    public void settxtDocNum(String value) { this.txtDocNum.setText(value); this.txtDocNum.paintImmediately(this.txtDocNum.getVisibleRect()); }
    public void settxtName(String value) { this.txtName.setText(value); this.txtName.paintImmediately(this.txtName.getVisibleRect()); }
    public void settxtSurname(String value) { this.txtSurname.setText(value); this.txtSurname.paintImmediately(this.txtSurname.getVisibleRect()); }
    public void settxtNickName(String value) { this.txtNickName.setText(value); this.txtNickName.paintImmediately(this.txtNickName.getVisibleRect()); }
    public void settxtYear(String value) { this.txtYear.setText(value); this.txtYear.paintImmediately(this.txtYear.getVisibleRect()); }
    public void settxtBornLocation(String value) { this.txtBornLocation.setText(value); this.txtBornLocation.paintImmediately(this.txtBornLocation.getVisibleRect()); }
    public void settxtSpouseName(String value) { this.txtSpouseName.setText(value); this.txtSpouseName.paintImmediately(this.txtSpouseName.getVisibleRect()); }
    public void settxtMotherName(String value) { this.txtMotherName.setText(value); this.txtMotherName.paintImmediately(this.txtMotherName.getVisibleRect()); }
    public void settxtFatherName(String value) { this.txtFatherName.setText(value); this.txtFatherName.paintImmediately(this.txtFatherName.getVisibleRect()); }
    public void settxtRecNum(String value) { this.txtRecNum.setText(value); this.txtRecNum.paintImmediately(this.txtRecNum.getVisibleRect()); }
    public void settxtSerieNum(String value) { this.txtSerieNum.setText(value); this.txtSerieNum.paintImmediately(this.txtSerieNum.getVisibleRect()); }
    public void settxtEmissor(String value) { this.txtEmissor.setText(value); this.txtEmissor.paintImmediately(this.txtEmissor.getVisibleRect()); }
    public void settxtEmissionDate(String value) { this.txtEmissionDate.setText(value); this.txtEmissionDate.paintImmediately(this.txtEmissionDate.getVisibleRect()); }
    public void settxtValidThru(String value) { this.txtValidThru.setText(value); this.txtValidThru.paintImmediately(this.txtValidThru.getVisibleRect()); }
    public void settxtNaturalness(String value) { this.txtNaturalness.setText(value); this.txtNaturalness.paintImmediately(this.txtNaturalness.getVisibleRect()); }
    public void settxtNationality(String value) { this.txtNationality.setText(value); this.txtNationality.paintImmediately(this.txtNationality.getVisibleRect()); }
    public void settxtContactMPhone(String value) { this.txtContactMPhone.setText(value); this.txtContactMPhone.paintImmediately(this.txtContactMPhone.getVisibleRect()); }
    public void settxtContactEmail(String value) { this.txtContactEmail.setText(value); this.txtContactEmail.paintImmediately(this.txtContactEmail.getVisibleRect()); }
    public void settxtContactPhone(String value) { this.txtContactPhone.setText(value); this.txtContactPhone.paintImmediately(this.txtContactPhone.getVisibleRect()); }
    public void settxtContactEnterprise(String value) { this.txtContactEnterprise.setText(value); this.txtContactEnterprise.paintImmediately(this.txtContactEnterprise.getVisibleRect()); }
    public void settxtFacebook(String value) { this.txtFacebook.setText(value); this.txtFacebook.paintImmediately(this.txtFacebook.getVisibleRect()); }
    public void settxtInstagram(String value) { this.txtInstagram.setText(value); this.txtInstagram.paintImmediately(this.txtInstagram.getVisibleRect()); }
    public void settxtTwitter(String value) { this.txtTwitter.setText(value); this.txtTwitter.paintImmediately(this.txtTwitter.getVisibleRect()); }
    public void settxtFullAddress(String value) { this.txtFullAddress.setText(value); this.txtFullAddress.paintImmediately(this.txtFullAddress.getVisibleRect()); }
    
    public void setcbbUserListFilter(String value) { this.cbbUserListFilter.addItem(value); this.cbbUserListFilter.paintImmediately(this.cbbUserListFilter.getVisibleRect()); }
    public void setcbbCivilState(String value) { this.cbbCivilState.addItem(value); this.cbbCivilState.paintImmediately(this.cbbCivilState.getVisibleRect()); }
    public void setcbbDay(String value) { this.cbbDay.addItem(value); this.cbbDay.paintImmediately(this.cbbDay.getVisibleRect()); }
    public void setcbbDocType(String value) { this.cbbDocType.addItem(value); this.cbbDocType.paintImmediately(this.cbbDocType.getVisibleRect()); }
    public void setcbbEmissionUF(String value) { this.cbbEmissionUF.addItem(value); this.cbbEmissionUF.paintImmediately(this.cbbEmissionUF.getVisibleRect()); }
    public void setcbbIdentityType(String value) { this.cbbIdentityType.addItem(value); this.cbbIdentityType.paintImmediately(this.cbbIdentityType.getVisibleRect()); }
    public void setcbbMonth(String value) { this.cbbMonth.addItem(value); this.cbbMonth.paintImmediately(this.cbbMonth.getVisibleRect()); }
    public void setcbbPosition(String value) { this.cbbPosition.addItem(value); this.cbbPosition.paintImmediately(this.cbbPosition.getVisibleRect()); }
    public void setcbbSex(String value) { this.cbbSex.addItem(value); this.cbbSex.paintImmediately(this.cbbSex.getVisibleRect()); }

    // ComboBox Specific Setters
    public void setcbbUserListFilterItemIndex(int value) { this.cbbUserListFilter.setSelectedIndex(value); }
    public void setcbbCivilStateItemIndex(int value) { this.cbbCivilState.setSelectedIndex(value); }
    public void setcbbDayItemIndex(int value) { this.cbbDay.setSelectedIndex(value); }
    public void setcbbDocTypeItemIndex(int value) { this.cbbDocType.setSelectedIndex(value); }
    public void setcbbEmissionUFItemIndex(int value) { this.cbbEmissionUF.setSelectedIndex(value); }
    public void setcbbIdentityTypeItemIndex(int value) { this.cbbIdentityType.setSelectedIndex(value); }
    public void setcbbMonthItemIndex(int value) { this.cbbMonth.setSelectedIndex(value); }
    public void setcbbPositionItemIndex(int value) { this.cbbPosition.setSelectedIndex(value); }
    public void setcbbSexItemIndex(int value) { this.cbbSex.setSelectedIndex(value); }
    
    public void setlblRecCount(String value) { this.lblRecCount.setText("Total de Registros: " + value); this.lblRecCount.paintImmediately(this.lblRecCount.getVisibleRect()); }
    public void setlblUserNameHeader(String value) { this.lblUserNameHeader.setText(value); this.lblUserNameHeader.paintImmediately(this.lblUserNameHeader.getVisibleRect()); }
        
    // Component Getters
    public String gettxtRowId() { if(!"".equals(this.txtRowId.getText()) && this.txtRowId.getText() != null) { return this.txtRowId.getText(); } else { return null; } }
    public String gettxtUser() { if(!"".equals(this.txtUser.getText()) && this.txtUser.getText() != null) { return this.txtUser.getText(); } else { return null; } }
    public String gettxtPass() { if(!"".equals(this.txtPass.getText()) && this.txtPass.getText() != null) { return this.txtPass.getText(); } else { return null; } }
    public String gettxtPassVerification() { if(!"".equals(this.txtPassVerification.getText()) && this.txtPassVerification.getText() != null) { return this.txtPassVerification.getText(); } else { return null; } }
    public String gettxtSecQuestion1() { if(!"".equals(this.txtSecQuestion1.getText()) && this.txtSecQuestion1.getText() != null) { return this.txtSecQuestion1.getText(); } else { return null; } }
    public String gettxtSecAnswer1() { if(!"".equals(this.txtSecAnswer1.getText()) && this.txtSecAnswer1.getText() != null) { return this.txtSecAnswer1.getText(); } else { return null; } }
    public String gettxtSecQuestion2() { if(!"".equals(this.txtSecQuestion2.getText()) && this.txtSecQuestion2.getText() != null) { return this.txtSecQuestion2.getText(); } else { return null; } }
    public String gettxtSecAnswer2() { if(!"".equals(this.txtSecAnswer2.getText()) && this.txtSecAnswer2.getText() != null) { return this.txtSecAnswer2.getText(); } else { return null; } }
    public String gettxtSecQuestion3() { if(!"".equals(this.txtSecQuestion3.getText()) && this.txtSecQuestion3.getText() != null) { return this.txtSecQuestion3.getText(); } else { return null; } }
    public String gettxtSecAnswer3() { if(!"".equals(this.txtSecAnswer3.getText()) && this.txtSecAnswer3.getText() != null) { return this.txtSecAnswer3.getText(); } else { return null; } }
    public String gettxtDocNum() { if(!"".equals(this.txtDocNum.getText()) && this.txtDocNum.getText() != null) { return this.txtDocNum.getText(); } else { return null; } }
    public String gettxtName() { if(!"".equals(this.txtName.getText()) && this.txtName.getText() != null) { return this.txtName.getText(); } else { return null; } }
    public String gettxtSurname() { if(!"".equals(this.txtSurname.getText()) && this.txtSurname.getText() != null) { return this.txtSurname.getText(); } else { return null; } }
    public String gettxtNickName() { if(!"".equals(this.txtNickName.getText()) && this.txtNickName.getText() != null) { return this.txtNickName.getText(); } else { return null; } }
    public String gettxtYear() { if(!"".equals(this.txtYear.getText()) && this.txtYear.getText() != null) { return this.txtYear.getText(); } else { return null; } }
    public String gettxtBornLocation() { if(!"".equals(this.txtBornLocation.getText()) && this.txtBornLocation.getText() != null) { return this.txtBornLocation.getText(); } else { return null; } }
    public String gettxtSpouseName() { if(!"".equals(this.txtSpouseName.getText()) && this.txtSpouseName.getText() != null) { return this.txtSpouseName.getText(); } else { return null; } }
    public String gettxtMotherName() { if(!"".equals(this.txtMotherName.getText()) && this.txtMotherName.getText() != null) { return this.txtMotherName.getText(); } else { return null; } }
    public String gettxtFatherName() { if(!"".equals(this.txtFatherName.getText()) && this.txtFatherName.getText() != null) { return this.txtFatherName.getText(); } else { return null; } }
    public String gettxtRecNum() { if(!"".equals(this.txtRecNum.getText()) && this.txtRecNum.getText() != null) { return this.txtRecNum.getText(); } else { return null; } }
    public String gettxtSerieNum() { if(!"".equals(this.txtSerieNum.getText()) && this.txtSerieNum.getText() != null) { return this.txtSerieNum.getText(); } else { return null; } }
    public String gettxtEmissor() { if(!"".equals(this.txtEmissor.getText()) && this.txtEmissor.getText() != null) { return this.txtEmissor.getText(); } else { return null; } }
    public String gettxtEmissionDate() { if(!"".equals(this.txtEmissionDate.getText()) && this.txtEmissionDate.getText() != null) { return this.txtEmissionDate.getText(); } else { return null; } }
    public String gettxtValidThru() { if(!"".equals(this.txtValidThru.getText()) && this.txtValidThru.getText() != null) { return this.txtValidThru.getText(); } else { return null; } }
    public String gettxtNaturalness() { if(!"".equals(this.txtNaturalness.getText()) && this.txtNaturalness.getText() != null) { return this.txtNaturalness.getText(); } else { return null; } }
    public String gettxtNationality() { if(!"".equals(this.txtNationality.getText()) && this.txtNationality.getText() != null) { return this.txtNationality.getText(); } else { return null; } }
    public String gettxtUserListFilterValue() { if(!"".equals(this.txtUserListFilterValue.getText()) && this.txtUserListFilterValue.getText() != null) { return this.txtUserListFilterValue.getText(); } else { return null; } }
    public String gettxtContactMPhone() { if(!"".equals(this.txtContactMPhone.getText()) && this.txtContactMPhone.getText() != null) { return this.txtContactMPhone.getText(); } else { return null; } }
    public String gettxtContactEmail() { if(!"".equals(this.txtContactEmail.getText()) && this.txtContactEmail.getText() != null) { return this.txtContactEmail.getText(); } else { return null; } }
    public String gettxtContactPhone() { if(!"".equals(this.txtContactPhone.getText()) && this.txtContactPhone.getText() != null) { return this.txtContactPhone.getText(); } else { return null; } }
    public String gettxtContactEnterprise() { if(!"".equals(this.txtContactEnterprise.getText()) && this.txtContactEnterprise.getText() != null) { return this.txtContactEnterprise.getText(); } else { return null; } }
    public String gettxtFacebook() { if(!"".equals(this.txtFacebook.getText()) && this.txtFacebook.getText() != null) { return this.txtFacebook.getText(); } else { return null; } }
    public String gettxtInstagram() { if(!"".equals(this.txtInstagram.getText()) && this.txtInstagram.getText() != null) { return this.txtInstagram.getText(); } else { return null; } }
    public String gettxtTwitter() { if(!"".equals(this.txtTwitter.getText()) && this.txtTwitter.getText() != null) { return this.txtTwitter.getText(); } else { return null; } }    
    public String gettxtFullAddress() { if(!"".equals(this.txtFullAddress.getText()) && this.txtFullAddress.getText() != null) { return this.txtFullAddress.getText(); } else { return null; } }
    
    public String getcbbUserListFilter() { if(!"".equals(this.cbbUserListFilter.getSelectedItem().toString()) && !"Selecione...".equals(this.cbbUserListFilter.getSelectedItem().toString()) && this.cbbUserListFilter.getSelectedItem().toString() != null) { return this.cbbUserListFilter.getSelectedItem().toString(); } else { return null; } }
    public String getcbbCivilState() { if(!"".equals(this.cbbCivilState.getSelectedItem().toString()) && !"Selecione...".equals(this.cbbCivilState.getSelectedItem().toString()) && this.cbbCivilState.getSelectedItem().toString() != null) { return this.cbbCivilState.getSelectedItem().toString(); } else { return null; } }
    public String getcbbDay() { if(!"".equals(this.cbbDay.getSelectedItem().toString()) && !"Selecione...".equals(this.cbbDay.getSelectedItem().toString()) && this.cbbDay.getSelectedItem().toString() != null) { return this.cbbDay.getSelectedItem().toString(); } else { return null; } }
    public String getcbbDocType() { if(!"".equals(this.cbbDocType.getSelectedItem().toString()) && !"Selecione...".equals(this.cbbDocType.getSelectedItem().toString()) && this.cbbDocType.getSelectedItem().toString() != null) { return this.cbbDocType.getSelectedItem().toString(); } else { return null; } }
    public String getcbbEmissionUF() { if(!"".equals(this.cbbEmissionUF.getSelectedItem().toString()) && !"Selecione...".equals(this.cbbEmissionUF.getSelectedItem().toString()) && this.cbbEmissionUF.getSelectedItem().toString() != null) { return this.cbbEmissionUF.getSelectedItem().toString(); } else { return null; } }
    public String getcbbIdentityType() { if(!"".equals(this.cbbIdentityType.getSelectedItem().toString()) && !"Selecione...".equals(this.cbbIdentityType.getSelectedItem().toString()) && this.cbbIdentityType.getSelectedItem().toString() != null) { return this.cbbIdentityType.getSelectedItem().toString(); } else { return null; } }
    public String getcbbMonth() { if(!"".equals(this.cbbMonth.getSelectedItem().toString()) && !"Selecione...".equals(this.cbbMonth.getSelectedItem().toString()) && this.cbbMonth.getSelectedItem().toString() != null) { return this.cbbMonth.getSelectedItem().toString(); } else { return null; } }
    public String getcbbPosition() { if(!"".equals(this.cbbPosition.getSelectedItem().toString()) && !"Selecione...".equals(this.cbbPosition.getSelectedItem().toString()) && this.cbbPosition.getSelectedItem().toString() != null) { return this.cbbPosition.getSelectedItem().toString(); } else { return null; } }
    public String getcbbSex() { if(!"".equals(this.cbbSex.getSelectedItem().toString()) && !"Selecione...".equals(this.cbbSex.getSelectedItem().toString()) && this.cbbSex.getSelectedItem().toString() != null) { return this.cbbSex.getSelectedItem().toString(); } else { return null; } }
    
    // ComboBox Specific Getters
    public int getcbbUserListFilterItemIndex(String value) { if(!"".equals(value) && value != null) { for(int i = 0; i < this.cbbUserListFilter.getItemCount(); i++){ if(value.equals(this.cbbUserListFilter.getItemAt(i))){ return i; }}} else { return 0; } return 0; }
    public int getcbbCivilStateItemIndex(String value) { if(!"".equals(value) && value != null) { for(int i = 0; i < this.cbbCivilState.getItemCount(); i++){ if(value.equals(this.cbbCivilState.getItemAt(i))){ return i; }}} else { return 0; } return 0; }
    public int getcbbDayItemIndex(String value) { if(!"".equals(value) && value != null) { for(int i = 0; i < this.cbbDay.getItemCount(); i++){ if(value.equals(this.cbbDay.getItemAt(i))){ return i; }}} else { return 0; } return 0; }
    public int getcbbDocTypeItemIndex(String value) { if(!"".equals(value) && value != null) { for(int i = 0; i < this.cbbDocType.getItemCount(); i++){ if(value.equals(this.cbbDocType.getItemAt(i))){ return i; }}} else { return 0; } return 0; }
    public int getcbbEmissionUFItemIndex(String value) { if(!"".equals(value) && value != null) { for(int i = 0; i < this.cbbEmissionUF.getItemCount(); i++){ if(value.equals(this.cbbEmissionUF.getItemAt(i))){ return i; }}} else { return 0; } return 0; }
    public int getcbbIdentityTypeItemIndex(String value) { if(!"".equals(value) && value != null) { for(int i = 0; i < this.cbbIdentityType.getItemCount(); i++){ if(value.equals(this.cbbIdentityType.getItemAt(i))){ return i; }}} else { return 0; } return 0; }
    public int getcbbMonthItemIndex(String value) { if(!"".equals(value) && value != null) { for(int i = 0; i < this.cbbMonth.getItemCount(); i++) { if(value.equals(this.cbbMonth.getItemAt(i))) { return i; }}} else { return 0; } return 0; }
    public int getcbbPositionItemIndex(String value) { if(!"".equals(value) && value != null) { for(int i = 0; i < this.cbbPosition.getItemCount(); i++){ if(value.equals(this.cbbPosition.getItemAt(i))){ return i; }}} else { return 0; } return 0; }
    public int getcbbSexItemIndex(String value) { if(!"".equals(value) && value != null) { for(int i = 0; i < this.cbbSex.getItemCount(); i++){ if(value.equals(this.cbbSex.getItemAt(i))){ return i; }}} else { return 0; } return 0; }
        
    public String getlblRecCount() { return this.lblRecCount.getText(); }
    public String getlblUserNameHeader() { return this.lblUserNameHeader.getText(); }
    

    // Component Clear
    public void cleartxtUserListFilterValue() { this.txtUserListFilterValue.setText(""); this.txtUserListFilterValue.paintImmediately(this.txtUserListFilterValue.getVisibleRect()); }
    public void cleartxtRowId() { this.txtRowId.setText(""); this.txtRowId.paintImmediately(this.txtRowId.getVisibleRect()); }
    public void cleartxtUser() { this.txtUser.setText(""); this.txtUser.paintImmediately(this.txtUser.getVisibleRect()); }
    public void cleartxtPass() { this.txtPass.setText(""); this.txtPass.paintImmediately(this.txtPass.getVisibleRect()); }
    public void cleartxtPassVerification() { this.txtPassVerification.setText(""); this.txtPassVerification.paintImmediately(this.txtPassVerification.getVisibleRect()); }
    public void cleartxtSecQuestion1() { this.txtSecQuestion1.setText(""); this.txtSecQuestion1.paintImmediately(this.txtSecQuestion1.getVisibleRect()); }
    public void cleartxtSecAnswer1() { this.txtSecAnswer1.setText(""); this.txtSecAnswer1.paintImmediately(this.txtSecAnswer1.getVisibleRect()); }
    public void cleartxtSecQuestion2() { this.txtSecQuestion2.setText(""); this.txtSecQuestion2.paintImmediately(this.txtSecQuestion2.getVisibleRect()); }
    public void cleartxtSecAnswer2() { this.txtSecAnswer2.setText(""); this.txtSecAnswer2.paintImmediately(this.txtSecAnswer2.getVisibleRect()); }
    public void cleartxtSecQuestion3() { this.txtSecQuestion3.setText(""); this.txtSecQuestion3.paintImmediately(this.txtSecQuestion3.getVisibleRect()); }
    public void cleartxtSecAnswer3() { this.txtSecAnswer3.setText(""); this.txtSecAnswer3.paintImmediately(this.txtSecAnswer3.getVisibleRect()); }
    public void cleartxtDocNum() { this.txtDocNum.setText(""); this.txtDocNum.paintImmediately(this.txtDocNum.getVisibleRect()); }
    public void cleartxtName() { this.txtName.setText(""); this.txtName.paintImmediately(this.txtName.getVisibleRect()); }
    public void cleartxtSurname() { this.txtSurname.setText(""); this.txtSurname.paintImmediately(this.txtSurname.getVisibleRect()); }
    public void cleartxtNickName() { this.txtNickName.setText(""); this.txtNickName.paintImmediately(this.txtNickName.getVisibleRect()); }
    public void cleartxtYear() { this.txtYear.setText(""); this.txtYear.paintImmediately(this.txtYear.getVisibleRect()); }
    public void cleartxtBornLocation() { this.txtBornLocation.setText(""); this.txtBornLocation.paintImmediately(this.txtBornLocation.getVisibleRect()); }
    public void cleartxtSpouseName() { this.txtSpouseName.setText(""); this.txtSpouseName.paintImmediately(this.txtSpouseName.getVisibleRect()); }
    public void cleartxtMotherName() { this.txtMotherName.setText(""); this.txtMotherName.paintImmediately(this.txtMotherName.getVisibleRect()); }
    public void cleartxtFatherName() { this.txtFatherName.setText(""); this.txtFatherName.paintImmediately(this.txtFatherName.getVisibleRect()); }
    public void cleartxtRecNum() { this.txtRecNum.setText(""); this.txtRecNum.paintImmediately(this.txtRecNum.getVisibleRect()); }
    public void cleartxtSerieNum() { this.txtSerieNum.setText(""); this.txtSerieNum.paintImmediately(this.txtSerieNum.getVisibleRect()); }
    public void cleartxtEmissor() { this.txtEmissor.setText(""); this.txtEmissor.paintImmediately(this.txtEmissor.getVisibleRect()); }
    public void cleartxtEmissionDate() { this.txtEmissionDate.setText(""); this.txtEmissionDate.paintImmediately(this.txtEmissionDate.getVisibleRect()); }
    public void cleartxtValidThru() { this.txtValidThru.setText(""); this.txtValidThru.paintImmediately(this.txtValidThru.getVisibleRect()); }
    public void cleartxtNaturalness() { this.txtNaturalness.setText(""); this.txtNaturalness.paintImmediately(this.txtNaturalness.getVisibleRect()); }
    public void cleartxtNationality() { this.txtNationality.setText(""); this.txtNationality.paintImmediately(this.txtNationality.getVisibleRect()); }
    public void cleartxtContactMPhone() { this.txtContactMPhone.setText(""); this.txtContactMPhone.paintImmediately(this.txtContactMPhone.getVisibleRect()); }
    public void cleartxtContactEmail() { this.txtContactEmail.setText(""); this.txtContactEmail.paintImmediately(this.txtContactEmail.getVisibleRect()); }
    public void cleartxtContactPhone() { this.txtContactPhone.setText(""); this.txtContactPhone.paintImmediately(this.txtContactPhone.getVisibleRect()); }
    public void cleartxtContactEnterprise() { this.txtContactEnterprise.setText(""); this.txtContactEnterprise.paintImmediately(this.txtContactEnterprise.getVisibleRect()); }
    public void cleartxtFacebook() { this.txtFacebook.setText(""); this.txtFacebook.paintImmediately(this.txtFacebook.getVisibleRect()); }
    public void cleartxtInstagram() { this.txtInstagram.setText(""); this.txtInstagram.paintImmediately(this.txtInstagram.getVisibleRect()); }
    public void cleartxtTwitter() { this.txtTwitter.setText(""); this.txtTwitter.paintImmediately(this.txtTwitter.getVisibleRect()); }    
    public void cleartxtFullAddress() { this.txtFullAddress.setText(""); this.txtFullAddress.paintImmediately(this.txtFullAddress.getVisibleRect()); }
    
    public void clearcbbUserListFilter() { this.cbbUserListFilter.removeAllItems(); this.cbbUserListFilter.paintImmediately(this.cbbUserListFilter.getVisibleRect()); }
    public void clearcbbCivilState() { this.cbbCivilState.removeAllItems(); this.cbbCivilState.paintImmediately(this.cbbCivilState.getVisibleRect()); }
    public void clearcbbDay() { this.cbbDay.removeAllItems(); this.cbbDay.paintImmediately(this.cbbDay.getVisibleRect()); }
    public void clearcbbDocType() { this.cbbDocType.removeAllItems(); this.cbbDocType.paintImmediately(this.cbbDocType.getVisibleRect()); }
    public void clearcbbEmissionUF() { this.cbbEmissionUF.removeAllItems(); this.cbbEmissionUF.paintImmediately(this.cbbEmissionUF.getVisibleRect()); }
    public void clearcbbIdentityType() { this.cbbIdentityType.removeAllItems(); this.cbbIdentityType.paintImmediately(this.cbbIdentityType.getVisibleRect()); }
    public void clearcbbMonth() { this.cbbMonth.removeAllItems(); this.cbbMonth.paintImmediately(this.cbbMonth.getVisibleRect()); }
    public void clearcbbPosition() { this.cbbPosition.removeAllItems(); this.cbbPosition.paintImmediately(this.cbbPosition.getVisibleRect()); }
    public void clearcbbSex() { this.cbbSex.removeAllItems(); this.cbbSex.paintImmediately(this.cbbSex.getVisibleRect()); }
    
    public void clearlblRecCount() { this.lblRecCount.setText(""); this.lblRecCount.paintImmediately(this.lblRecCount.getVisibleRect()); }
    public void clearlblUserNameHeader() { this.lblUserNameHeader.setText(""); this.lblUserNameHeader.paintImmediately(this.lblUserNameHeader.getVisibleRect()); }

    // Enable or Disable Components
    public void settxtUserListFilterValueEnabled(boolean status) { this.txtUserListFilterValue.setEnabled(status); }
    public void settxtRowIdEnabled(boolean status) { this.txtRowId.setEnabled(status); }
    public void settxtUserEnabled(boolean status) { this.txtUser.setEnabled(status); }
    public void settxtPassEnabled(boolean status) { this.txtPass.setEnabled(status); }
    public void settxtPassVerificationEnabled(boolean status) { this.txtPassVerification.setEnabled(status); }
    public void settxtSecQuestion1Enabled(boolean status) { this.txtSecQuestion1.setEnabled(status); }
    public void settxtSecAnswer1Enabled(boolean status) { this.txtSecAnswer1.setEnabled(status); }
    public void settxtSecQuestion2Enabled(boolean status) { this.txtSecQuestion2.setEnabled(status); }
    public void settxtSecAnswer2Enabled(boolean status) { this.txtSecAnswer2.setEnabled(status); }
    public void settxtSecQuestion3Enabled(boolean status) { this.txtSecQuestion3.setEnabled(status); }
    public void settxtSecAnswer3Enabled(boolean status) { this.txtSecAnswer3.setEnabled(status); }
    public void settxtDocNumEnabled(boolean status) { this.txtDocNum.setEnabled(status); }
    public void settxtNameEnabled(boolean status) { this.txtName.setEnabled(status); }
    public void settxtSurnameEnabled(boolean status) { this.txtSurname.setEnabled(status); }
    public void settxtNickNameEnabled(boolean status) { this.txtNickName.setEnabled(status); }
    public void settxtYearEnabled(boolean status) { this.txtYear.setEnabled(status); }
    public void settxtBornLocationEnabled(boolean status) { this.txtBornLocation.setEnabled(status); }
    public void settxtSpouseNameEnabled(boolean status) { this.txtSpouseName.setEnabled(status); }
    public void settxtMotherNameEnabled(boolean status) { this.txtMotherName.setEnabled(status); }
    public void settxtFatherNameEnabled(boolean status) { this.txtFatherName.setEnabled(status); }
    public void settxtRecNumEnabled(boolean status) { this.txtRecNum.setEnabled(status); }
    public void settxtSerieNumEnabled(boolean status) { this.txtSerieNum.setEnabled(status); }
    public void settxtEmissorEnabled(boolean status) { this.txtEmissor.setEnabled(status); }
    public void settxtEmissionDateEnabled(boolean status) { this.txtEmissionDate.setEnabled(status); }
    public void settxtValidThruEnabled(boolean status) { this.txtValidThru.setEnabled(status); }
    public void settxtNaturalnessEnabled(boolean status) { this.txtNaturalness.setEnabled(status); }
    public void settxtNationalityEnabled(boolean status) { this.txtNationality.setEnabled(status); }
    public void settxtContactMPhoneEnabled(boolean status) { this.txtContactMPhone.setEnabled(status); }
    public void settxtContactEmailEnabled(boolean status) { this.txtContactEmail.setEnabled(status); }
    public void settxtContactPhoneEnabled(boolean status) { this.txtContactPhone.setEnabled(status); }
    public void settxtContactEnterpriseEnabled(boolean status) { this.txtContactEnterprise.setEnabled(status); }
    public void settxtFacebookEnabled(boolean status) { this.txtFacebook.setEnabled(status); }
    public void settxtInstagramEnabled(boolean status) { this.txtInstagram.setEnabled(status); }
    public void settxtTwitterEnabled(boolean status) { this.txtTwitter.setEnabled(status); }    
    public void settxtFullAddressEnabled(boolean status) { this.txtFullAddress.setEnabled(status); }
    
    public void setcbbUserListFilterEnabled(boolean status) { this.cbbUserListFilter.setEnabled(status); }
    public void setcbbCivilStateEnabled(boolean status) { this.cbbCivilState.setEnabled(status); }
    public void setcbbDayEnabled(boolean status) { this.cbbDay.setEnabled(status); }
    public void setcbbDocTypeEnabled(boolean status) { this.cbbDocType.setEnabled(status); }
    public void setcbbEmissionUFEnabled(boolean status) { this.cbbEmissionUF.setEnabled(status); }
    public void setcbbIdentityTypeEnabled(boolean status) { this.cbbIdentityType.setEnabled(status); }
    public void setcbbMonthEnabled(boolean status) { this.cbbMonth.setEnabled(status); }
    public void setcbbPositionEnabled(boolean status) { this.cbbPosition.setEnabled(status); }
    public void setcbbSexEnabled(boolean status) { this.cbbSex.setEnabled(status); }
    
    public void setlblRecCountEnabled(boolean status) { this.lblRecCount.setEnabled(status); }
    public void setlblUserNameHeaderEnabled(boolean status) { this.lblUserNameHeader.setEnabled(status); }
    
    public void setTblEnabled(boolean status) { this.tblUserList.setEnabled(status); }
    
    public void setbtnEditUserEnabled(boolean status) { this.btnEditUser.setEnabled(status); }
    public void setbtnNewUserEnabled(boolean status) { this.btnNewUser.setEnabled(status); }
    public void setbtnSaveUserEnabled(boolean status) { this.btnSaveUser.setEnabled(status); }
    public void setbtnDeleteEnabled(boolean status) { this.btnDelete.setEnabled(status); }
    public void setbtnCancelUserEnabled(boolean status) { this.btnCancelUser.setEnabled(status); }
    public void setbtnAddContactEnabled(boolean status) { this.btnAddContact.setEnabled(status); }
    public void setbtnAddAddressEnabled(boolean status) { this.btnAddAddress.setEnabled(status); }
    public void setbtnPermitionsEnabled(boolean status) { this.btnPermitions.setEnabled(status); }

    // Return componet status
    public boolean istxtUserListFilterValueEnabled() { return this.txtUserListFilterValue.isEnabled(); }
    public boolean istxtRowIdEnabled() { return this.txtRowId.isEnabled(); }
    public boolean istxtUserEnabled() { return this.txtUser.isEnabled(); }
    public boolean istxtPassEnabled() { return this.txtPass.isEnabled(); }
    public boolean istxtPassVerificationEnabled() { return this.txtPassVerification.isEnabled(); }
    public boolean istxtSecQuestion1Enabled() { return this.txtSecQuestion1.isEnabled(); }
    public boolean istxtSecAnswer1Enabled() { return this.txtSecAnswer1.isEnabled(); }
    public boolean istxtSecQuestion2Enabled() { return this.txtSecQuestion2.isEnabled(); }
    public boolean istxtSecAnswer2Enabled() { return this.txtSecAnswer2.isEnabled(); }
    public boolean istxtSecQuestion3Enabled() { return this.txtSecQuestion3.isEnabled(); }
    public boolean istxtSecAnswer3Enabled() { return this.txtSecAnswer3.isEnabled(); }
    public boolean istxtDocNumEnabled() { return this.txtDocNum.isEnabled(); }
    public boolean istxtNameEnabled() { return this.txtName.isEnabled(); }
    public boolean istxtSurnameEnabled() { return this.txtSurname.isEnabled(); }
    public boolean istxtNickNameEnabled() { return this.txtNickName.isEnabled(); }
    public boolean istxtYearEnabled() { return this.txtYear.isEnabled(); }
    public boolean istxtBornLocationEnabled() { return this.txtBornLocation.isEnabled(); }
    public boolean istxtSpouseNameEnabled() { return this.txtSpouseName.isEnabled(); }
    public boolean istxtMotherNameEnabled() { return this.txtMotherName.isEnabled(); }
    public boolean istxtFatherNameEnabled() { return this.txtFatherName.isEnabled(); }
    public boolean istxtRecNumEnabled() { return this.txtRecNum.isEnabled(); }
    public boolean istxtSerieNumEnabled() { return this.txtSerieNum.isEnabled(); }
    public boolean istxtEmissorEnabled() { return this.txtEmissor.isEnabled(); }
    public boolean istxtEmissionDateEnabled() { return this.txtEmissionDate.isEnabled(); }
    public boolean istxtValidThruEnabled() { return this.txtValidThru.isEnabled(); }
    public boolean istxtNaturalnessEnabled() { return this.txtNaturalness.isEnabled(); }
    public boolean istxtNationalityEnabled() { return this.txtNationality.isEnabled(); }
    public boolean istxtContactMPhoneEnabled() { return this.txtContactMPhone.isEnabled(); }
    public boolean istxtContactEmailEnabled() { return this.txtContactEmail.isEnabled(); }
    public boolean istxtContactPhoneEnabled() { return this.txtContactPhone.isEnabled(); }
    public boolean istxtContactEnterpriseEnabled() { return this.txtContactEnterprise.isEnabled(); }
    public boolean istxtFacebookEnabled() { return this.txtFacebook.isEnabled(); }
    public boolean istxtInstagramEnabled() { return this.txtInstagram.isEnabled(); }
    public boolean istxtTwitterEnabled() { return this.txtTwitter.isEnabled(); }    
    public boolean istxtFullAddressEnabled() { return this.txtFullAddress.isEnabled(); }
    
    public boolean iscbbUserListFilterEnabled() { return this.cbbUserListFilter.isEnabled(); }
    public boolean iscbbCivilStateEnabled() { return this.cbbCivilState.isEnabled(); }
    public boolean iscbbDayEnabled() { return this.cbbDay.isEnabled(); }
    public boolean iscbbDocTypeEnabled() { return this.cbbDocType.isEnabled(); }
    public boolean iscbbEmissionUFEnabled() { return this.cbbEmissionUF.isEnabled(); }
    public boolean iscbbIdentityTypeEnabled() { return this.cbbIdentityType.isEnabled(); }
    public boolean iscbbMonthEnabled() { return this.cbbMonth.isEnabled(); }
    public boolean iscbbPositionEnabled() { return this.cbbPosition.isEnabled(); }
    public boolean iscbbSexEnabled() { return this.cbbSex.isEnabled(); }
    
    public boolean islblRecCountEnabled() { return this.lblRecCount.isEnabled(); }
    public boolean islblUserNameHeaderEnabled() { return this.lblUserNameHeader.isEnabled(); }
    
    public boolean isbtnEditUserEnabled() { return this.btnEditUser.isEnabled(); }
    public boolean isbtnNewUserEnabled() { return this.btnNewUser.isEnabled(); }
    public boolean isbtnSaveUserEnabled() { return this.btnSaveUser.isEnabled(); }
    public boolean isbtnCancelUserEnabled() { return this.btnCancelUser.isEnabled(); }
    public boolean isbtnDeleteEnabled() { return this.btnDelete.isEnabled(); }
    public boolean isbtnAddContactEnabled() { return this.btnAddContact.isEnabled(); }
    public boolean isbtnAddAddressEnabled() { return this.btnAddAddress.isEnabled(); }
    public boolean isbtnPermitionsEnabled() { return this.btnPermitions.isEnabled(); }
    
    // Button Functions
    public void clickSave(){ this.btnSaveUser.setEnabled(true); this.btnSaveUser.doClick(); this.btnSaveUser.setEnabled(false); }
    public void clickNew(){ this.btnNewUser.setEnabled(true); this.btnNewUser.doClick(); this.btnNewUser.setEnabled(false); }
    public void clickEdit(){ this.btnEditUser.setEnabled(true); this.btnEditUser.doClick(); this.btnEditUser.setEnabled(false); }
    public void clickCancel(){ this.btnCancelUser.setEnabled(true); this.btnCancelUser.doClick(); this.btnCancelUser.setEnabled(false); }
    public void clickDelete(){ this.btnDelete.setEnabled(true); this.btnDelete.doClick(); this.btnDelete.setEnabled(false); }
    
    // Set Focus on Specific component
    public void setFocus(String component) {
        switch (component) {
        case "FILTRO_VALOR":
            this.txtUserListFilterValue.requestFocus();
            break;
        case "ID":
            this.txtRowId.requestFocus();
            break;
        case "USUARIO":
            this.txtUser.requestFocus();
            break;
        case "SENHA":
            this.txtPass.requestFocus();
            break;
        case "SENHA_CONFIRMACAO":
            this.txtPassVerification.requestFocus();
            break;
        case "PERGUNTA_SEG_1":
            this.txtSecQuestion1.requestFocus();
            break;
        case "RESPOSTA_SEG_1":
            this.txtSecAnswer1.requestFocus();
            break;
        case "PERGUNTA_SEG_2":
            this.txtSecQuestion2.requestFocus();
            break;
        case "RESPOSTA_SEG_2":
            this.txtSecAnswer2.requestFocus();
            break;
        case "PERGUNTA_SEG_3":
            this.txtSecQuestion3.requestFocus();
            break;
        case "RESPOSTA_SEG_3":
            this.txtSecAnswer3.requestFocus();
            break;
        case "DOCUMENTO_TIPO":
            this.cbbDocType.requestFocus();
            break;
        case "NUM_DOCUMENTO":
            this.txtDocNum.requestFocus();
            break;
        case "NOME":
            this.txtName.requestFocus();
            break;
        case "SOBRENOME":
            this.txtSurname.requestFocus();
            break;
        case "APELIDO":
            this.txtNickName.requestFocus();
            break;
        case "SEXO":
            this.cbbSex.requestFocus();
            break;
        case "NASCIMENTO_DIA":
            this.cbbDay.requestFocus();
            break;
        case "NASCIMENTO_MES":
            this.cbbMonth.requestFocus();
            break;
        case "NASCIMENTO_ANO":
            this.txtYear.requestFocus();
            break;
        case "NASCIMENTO_LOCAL":
            this.txtBornLocation.requestFocus();
            break;
        case "NOME_CONJUJE":
            this.txtSpouseName.requestFocus();
            break;
        case "NOME_MAE":
            this.txtMotherName.requestFocus();
            break;
        case "NOME_PAI":
            this.txtFatherName.requestFocus();
            break;
        case "REGISTRO_TIPO":
            this.cbbIdentityType.requestFocus();
            break;
        case "REGISTRO_NUMERO":
            this.txtRecNum.requestFocus();
            break;
        case "REGISTRO_SERIE":
            this.txtSerieNum.requestFocus();
            break;
        case "REGISTRO_EMISSOR":
            this.txtEmissor.requestFocus();
            break;
        case "REGISTRO_DT_EMISSAO":
            this.txtEmissionDate.requestFocus();
            break;
        case "REGISTRO_DT_VALIDADE":
            this.txtValidThru.requestFocus();
            break;
        case "REGISTRO_UF_EMISSAO":
            this.cbbEmissionUF.requestFocus();
            break;
        case "REGISTRO_NATURALIDADE":
            this.txtNaturalness.requestFocus();
            break;
        case "REGISTRO_NACIONALIDADE":
            this.txtNationality.requestFocus();
            break;
        case "FILTRO":
            this.cbbUserListFilter.requestFocus();
            break;
        case "ESTADO_CIVIL":
            this.cbbCivilState.requestFocus();
            break;
        case "POSICAO":
            this.cbbPosition.requestFocus();
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
            this.btnEditUser.requestFocus();
            break;
        case "BOTAO_NOVO":
            this.btnNewUser.requestFocus();
            break;
        case "BOTAO_SALVAR":
            this.btnSaveUser.requestFocus();
            break;
        case "BOTAO_CANCELAR":
            this.btnCancelUser.requestFocus();
            break;
        case "BOTAO_DELETAR":
            this.btnDelete.requestFocus();
            break;
        case "BOTAO_ADD_CONTATO":
            this.btnAddContact.requestFocus();
            break;
        case "BOTAO_ADD_ENDERECO":
            this.btnAddAddress.requestFocus();
            break;
        case "BOTAO_PERMISSAO":
            this.btnPermitions.requestFocus();
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
                settxtUserEnabled(false);
                settxtPassEnabled(false);
                settxtPassVerificationEnabled(false);
                settxtSecQuestion1Enabled(false);
                settxtSecAnswer1Enabled(false);
                settxtSecQuestion2Enabled(false);
                settxtSecAnswer2Enabled(false);
                settxtSecQuestion3Enabled(false);
                settxtSecAnswer3Enabled(false);
                settxtDocNumEnabled(false);
                settxtNameEnabled(false);
                settxtSurnameEnabled(false);
                settxtNickNameEnabled(false);
                settxtYearEnabled(false);
                settxtBornLocationEnabled(false);
                settxtSpouseNameEnabled(false);
                settxtMotherNameEnabled(false);
                settxtFatherNameEnabled(false);
                settxtRecNumEnabled(false);
                settxtSerieNumEnabled(false);
                settxtEmissorEnabled(false);
                settxtEmissionDateEnabled(false);
                settxtValidThruEnabled(false);
                settxtNaturalnessEnabled(false);
                settxtNationalityEnabled(false);
                settxtContactMPhoneEnabled(false);
                settxtContactEmailEnabled(false);
                settxtContactPhoneEnabled(false);
                settxtContactEnterpriseEnabled(false);
                settxtFacebookEnabled(false);
                settxtInstagramEnabled(false);
                settxtTwitterEnabled(false);                
                settxtFullAddressEnabled(false);

                setcbbUserListFilterEnabled(true);
                setcbbCivilStateEnabled(false);
                setcbbDayEnabled(false);
                setcbbDocTypeEnabled(false);
                setcbbEmissionUFEnabled(false);
                setcbbIdentityTypeEnabled(false);
                setcbbMonthEnabled(false);
                setcbbPositionEnabled(false);
                setcbbSexEnabled(false);
                
                setTblEnabled(true);

                setbtnEditUserEnabled(false);
                setbtnNewUserEnabled(true);
                setbtnSaveUserEnabled(false);
                setbtnDeleteEnabled(false);
                setbtnCancelUserEnabled(false);
                setbtnAddContactEnabled(false);
                setbtnAddAddressEnabled(false);
                setbtnPermitionsEnabled(false);
                break;
            case "NOVO":
                settxtUserListFilterValueEnabled(true);
                settxtRowIdEnabled(false);
                settxtUserEnabled(true);
                settxtPassEnabled(true);
                settxtPassVerificationEnabled(true);
                settxtSecQuestion1Enabled(true);
                settxtSecAnswer1Enabled(true);
                settxtSecQuestion2Enabled(true);
                settxtSecAnswer2Enabled(true);
                settxtSecQuestion3Enabled(true);
                settxtSecAnswer3Enabled(true);
                settxtDocNumEnabled(true);
                settxtNameEnabled(true);
                settxtSurnameEnabled(true);
                settxtNickNameEnabled(true);
                settxtYearEnabled(true);
                settxtBornLocationEnabled(true);
                settxtSpouseNameEnabled(true);
                settxtMotherNameEnabled(true);
                settxtFatherNameEnabled(true);
                settxtRecNumEnabled(true);
                settxtSerieNumEnabled(true);
                settxtEmissorEnabled(true);
                settxtEmissionDateEnabled(true);
                settxtValidThruEnabled(true);
                settxtNaturalnessEnabled(true);
                settxtNationalityEnabled(true);
                settxtContactMPhoneEnabled(false);
                settxtContactEmailEnabled(false);
                settxtContactPhoneEnabled(false);
                settxtContactEnterpriseEnabled(false);
                settxtFacebookEnabled(false);
                settxtInstagramEnabled(false);
                settxtTwitterEnabled(false);
                settxtFullAddressEnabled(false);

                setcbbUserListFilterEnabled(true);
                setcbbCivilStateEnabled(true);
                setcbbDayEnabled(true);
                setcbbDocTypeEnabled(true);
                setcbbEmissionUFEnabled(true);
                setcbbIdentityTypeEnabled(true);
                setcbbMonthEnabled(true);
                setcbbPositionEnabled(true);
                setcbbSexEnabled(true);

                setTblEnabled(false);
                
                setbtnEditUserEnabled(false);
                setbtnNewUserEnabled(false);
                setbtnSaveUserEnabled(true);
                setbtnCancelUserEnabled(true);
                setbtnDeleteEnabled(false);
                setbtnAddContactEnabled(true);
                setbtnAddAddressEnabled(true);
                setbtnPermitionsEnabled(true);
                break;
            case "EDITAR":
                settxtUserListFilterValueEnabled(true);
                settxtRowIdEnabled(false);
                settxtUserEnabled(true);
                settxtPassEnabled(true);
                settxtPassVerificationEnabled(true);
                settxtSecQuestion1Enabled(true);
                settxtSecAnswer1Enabled(true);
                settxtSecQuestion2Enabled(true);
                settxtSecAnswer2Enabled(true);
                settxtSecQuestion3Enabled(true);
                settxtSecAnswer3Enabled(true);
                settxtDocNumEnabled(false);
                settxtNameEnabled(true);
                settxtSurnameEnabled(true);
                settxtNickNameEnabled(true);
                settxtYearEnabled(true);
                settxtBornLocationEnabled(true);
                settxtSpouseNameEnabled(true);
                settxtMotherNameEnabled(true);
                settxtFatherNameEnabled(true);
                settxtRecNumEnabled(true);
                settxtSerieNumEnabled(true);
                settxtEmissorEnabled(true);
                settxtEmissionDateEnabled(true);
                settxtValidThruEnabled(true);
                settxtNaturalnessEnabled(true);
                settxtNationalityEnabled(true);
                settxtContactMPhoneEnabled(false);
                settxtContactEmailEnabled(false);
                settxtContactPhoneEnabled(false);
                settxtContactEnterpriseEnabled(false);
                settxtFacebookEnabled(false);
                settxtInstagramEnabled(false);
                settxtTwitterEnabled(false);
                settxtFullAddressEnabled(false);

                setcbbUserListFilterEnabled(true);
                setcbbCivilStateEnabled(true);
                setcbbDayEnabled(true);
                setcbbDocTypeEnabled(false);
                setcbbEmissionUFEnabled(true);
                setcbbIdentityTypeEnabled(true);
                setcbbMonthEnabled(true);
                setcbbPositionEnabled(true);
                setcbbSexEnabled(true);

                setTblEnabled(false);
                
                setbtnEditUserEnabled(false);
                setbtnDeleteEnabled(false);
                setbtnNewUserEnabled(false);
                setbtnSaveUserEnabled(true);
                setbtnCancelUserEnabled(true);
                setbtnAddContactEnabled(true);
                setbtnAddAddressEnabled(true);
                setbtnPermitionsEnabled(true);
                break;
            case "CANCELAR":
                settxtUserListFilterValueEnabled(true);
                settxtRowIdEnabled(false);
                settxtUserEnabled(false);
                settxtPassEnabled(false);
                settxtPassVerificationEnabled(false);
                settxtSecQuestion1Enabled(false);
                settxtSecAnswer1Enabled(false);
                settxtSecQuestion2Enabled(false);
                settxtSecAnswer2Enabled(false);
                settxtSecQuestion3Enabled(false);
                settxtSecAnswer3Enabled(false);
                settxtDocNumEnabled(false);
                settxtNameEnabled(false);
                settxtSurnameEnabled(false);
                settxtNickNameEnabled(false);
                settxtYearEnabled(false);
                settxtBornLocationEnabled(false);
                settxtSpouseNameEnabled(false);
                settxtMotherNameEnabled(false);
                settxtFatherNameEnabled(false);
                settxtRecNumEnabled(false);
                settxtSerieNumEnabled(false);
                settxtEmissorEnabled(false);
                settxtEmissionDateEnabled(false);
                settxtValidThruEnabled(false);
                settxtNaturalnessEnabled(false);
                settxtNationalityEnabled(false);
                settxtContactMPhoneEnabled(false);
                settxtContactEmailEnabled(false);
                settxtContactPhoneEnabled(false);
                settxtContactEnterpriseEnabled(false);
                settxtFacebookEnabled(false);
                settxtInstagramEnabled(false);
                settxtTwitterEnabled(false);
                settxtFullAddressEnabled(false);

                setcbbUserListFilterEnabled(true);
                setcbbCivilStateEnabled(false);
                setcbbDayEnabled(false);
                setcbbDocTypeEnabled(false);
                setcbbEmissionUFEnabled(false);
                setcbbIdentityTypeEnabled(false);
                setcbbMonthEnabled(false);
                setcbbPositionEnabled(false);
                setcbbSexEnabled(false);

                setTblEnabled(true);
                
                setbtnEditUserEnabled(true);
                setbtnDeleteEnabled(true);
                setbtnNewUserEnabled(true);
                setbtnSaveUserEnabled(false);
                setbtnCancelUserEnabled(false);
                setbtnAddContactEnabled(false);
                setbtnAddAddressEnabled(false);
                setbtnPermitionsEnabled(false);
                break;
            case "DELETAR":
                settxtUserListFilterValueEnabled(true);
                settxtRowIdEnabled(false);
                settxtUserEnabled(false);
                settxtPassEnabled(false);
                settxtPassVerificationEnabled(false);
                settxtSecQuestion1Enabled(false);
                settxtSecAnswer1Enabled(false);
                settxtSecQuestion2Enabled(false);
                settxtSecAnswer2Enabled(false);
                settxtSecQuestion3Enabled(false);
                settxtSecAnswer3Enabled(false);
                settxtDocNumEnabled(false);
                settxtNameEnabled(false);
                settxtSurnameEnabled(false);
                settxtNickNameEnabled(false);
                settxtYearEnabled(false);
                settxtBornLocationEnabled(false);
                settxtSpouseNameEnabled(false);
                settxtMotherNameEnabled(false);
                settxtFatherNameEnabled(false);
                settxtRecNumEnabled(false);
                settxtSerieNumEnabled(false);
                settxtEmissorEnabled(false);
                settxtEmissionDateEnabled(false);
                settxtValidThruEnabled(false);
                settxtNaturalnessEnabled(false);
                settxtNationalityEnabled(false);
                settxtContactMPhoneEnabled(false);
                settxtContactEmailEnabled(false);
                settxtContactPhoneEnabled(false);
                settxtContactEnterpriseEnabled(false);
                settxtFacebookEnabled(false);
                settxtInstagramEnabled(false);
                settxtTwitterEnabled(false);
                settxtFullAddressEnabled(false);

                setcbbUserListFilterEnabled(true);
                setcbbCivilStateEnabled(false);
                setcbbDayEnabled(false);
                setcbbDocTypeEnabled(false);
                setcbbEmissionUFEnabled(false);
                setcbbIdentityTypeEnabled(false);
                setcbbMonthEnabled(false);
                setcbbPositionEnabled(false);
                setcbbSexEnabled(false);

                setTblEnabled(true);
                
                setbtnEditUserEnabled(true);
                setbtnDeleteEnabled(true);
                setbtnNewUserEnabled(true);
                setbtnSaveUserEnabled(false);
                setbtnCancelUserEnabled(false);
                setbtnAddContactEnabled(false);
                setbtnAddAddressEnabled(false);
                setbtnPermitionsEnabled(false);
                break;
            case "SALVAR":
                settxtUserListFilterValueEnabled(true);
                settxtRowIdEnabled(false);
                settxtUserEnabled(false);
                settxtPassEnabled(false);
                settxtPassVerificationEnabled(false);
                settxtSecQuestion1Enabled(false);
                settxtSecAnswer1Enabled(false);
                settxtSecQuestion2Enabled(false);
                settxtSecAnswer2Enabled(false);
                settxtSecQuestion3Enabled(false);
                settxtSecAnswer3Enabled(false);
                settxtDocNumEnabled(false);
                settxtNameEnabled(false);
                settxtSurnameEnabled(false);
                settxtNickNameEnabled(false);
                settxtYearEnabled(false);
                settxtBornLocationEnabled(false);
                settxtSpouseNameEnabled(false);
                settxtMotherNameEnabled(false);
                settxtFatherNameEnabled(false);
                settxtRecNumEnabled(false);
                settxtSerieNumEnabled(false);
                settxtEmissorEnabled(false);
                settxtEmissionDateEnabled(false);
                settxtValidThruEnabled(false);
                settxtNaturalnessEnabled(false);
                settxtNationalityEnabled(false);
                settxtContactMPhoneEnabled(false);
                settxtContactEmailEnabled(false);
                settxtContactPhoneEnabled(false);
                settxtContactEnterpriseEnabled(false);
                settxtFacebookEnabled(false);
                settxtInstagramEnabled(false);
                settxtTwitterEnabled(false);
                settxtFullAddressEnabled(false);

                setcbbUserListFilterEnabled(true);
                setcbbCivilStateEnabled(false);
                setcbbDayEnabled(false);
                setcbbDocTypeEnabled(false);
                setcbbEmissionUFEnabled(false);
                setcbbIdentityTypeEnabled(false);
                setcbbMonthEnabled(false);
                setcbbPositionEnabled(false);
                setcbbSexEnabled(false);

                setTblEnabled(true);
                
                setbtnEditUserEnabled(true);
                setbtnDeleteEnabled(true);
                setbtnNewUserEnabled(true);
                setbtnSaveUserEnabled(false);
                setbtnCancelUserEnabled(false);
                setbtnAddContactEnabled(false);
                setbtnAddAddressEnabled(false);
                setbtnPermitionsEnabled(false);
                break;
            default:
                break;
	}	
    }

    public void clearFields() {
        cleartxtUserListFilterValue();
        cleartxtRowId();
        cleartxtUser();
        cleartxtPass();
        cleartxtPassVerification();
        cleartxtSecQuestion1();
        cleartxtSecAnswer1();
        cleartxtSecQuestion2();
        cleartxtSecAnswer2();
        cleartxtSecQuestion3();
        cleartxtSecAnswer3();
        cleartxtDocNum();
        cleartxtName();
        cleartxtSurname();
        cleartxtNickName();
        cleartxtYear();
        cleartxtBornLocation();
        cleartxtSpouseName();
        cleartxtMotherName();
        cleartxtFatherName();
        cleartxtRecNum();
        cleartxtSerieNum();
        cleartxtEmissor();
        cleartxtEmissionDate();
        cleartxtValidThru();
        cleartxtNaturalness();
        cleartxtNationality();
        cleartxtContactMPhone();
        cleartxtContactEmail();
        cleartxtContactPhone();
        cleartxtContactEnterprise();
        cleartxtFacebook();
        cleartxtInstagram();
        cleartxtTwitter();                
        cleartxtFullAddress();
        
        setcbbCivilStateItemIndex(0);
        setcbbDayItemIndex(0);
        setcbbDocTypeItemIndex(0);
        setcbbEmissionUFItemIndex(0);
        setcbbIdentityTypeItemIndex(0);
        setcbbMonthItemIndex(0);
        setcbbPositionItemIndex(0);
        setcbbSexItemIndex(0);
        setcbbUserListFilterItemIndex(0);
        
        clearlblUserNameHeader();
    }
    
    public void clearComboBoxes(){
        clearcbbUserListFilter();
        clearcbbCivilState();
        clearcbbDay();
        clearcbbDocType();
        clearcbbEmissionUF();
        clearcbbIdentityType();
        clearcbbMonth();
        clearcbbPosition();
        clearcbbSex();
    }
    
    public void insertSelectComboBox(){
        this.setcbbUserListFilter("Selecione...");
        this.setcbbCivilState("Selecione...");
        this.setcbbDay("Selecione...");
        this.setcbbDocType("Selecione...");
        this.setcbbEmissionUF("Selecione...");
        this.setcbbIdentityType("Selecione...");
        this.setcbbMonth("Selecione...");
        this.setcbbPosition("Selecione...");
        this.setcbbSex("Selecione...");
    }
    
    public final void FocusTraversalKeys(){
        this.txtUserListFilterValue.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtRowId.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtUser.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtPass.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtPassVerification.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtSecQuestion1.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtSecAnswer1.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtSecQuestion2.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtSecAnswer2.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtSecQuestion3.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtSecAnswer3.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtDocNum.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtName.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtSurname.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtNickName.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtYear.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtBornLocation.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtSpouseName.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtMotherName.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtFatherName.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtRecNum.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtSerieNum.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtEmissor.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtEmissionDate.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtValidThru.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtNaturalness.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtNationality.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtContactMPhone.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtContactEmail.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtContactPhone.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtContactEnterprise.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtFacebook.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtInstagram.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtTwitter.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtFullAddress.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);

        this.cbbUserListFilter.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.cbbCivilState.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.cbbDay.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.cbbDocType.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.cbbEmissionUF.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.cbbIdentityType.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.cbbMonth.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.cbbPosition.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.cbbSex.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);

        this.lblRecCount.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.lblUserNameHeader.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelUser = new javax.swing.JPanel();
        PanelUserList = new javax.swing.JPanel();
        PanelUserListHeader = new javax.swing.JPanel();
        lblUserList = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblImage = new javax.swing.JLabel();
        cbbUserListFilter = new javax.swing.JComboBox<>();
        txtUserListFilterValue = new javax.swing.JTextField();
        lblInformation = new javax.swing.JLabel();
        lblRecCount = new javax.swing.JLabel();
        PanelListUser = new javax.swing.JPanel();
        sPanelUserList = new javax.swing.JScrollPane();
        tblUserList = new javax.swing.JTable();
        PanelUserForm = new javax.swing.JPanel();
        PanelUserFormHeader = new javax.swing.JPanel();
        lblUserNameHeader = new javax.swing.JLabel();
        lblUserFormInformation = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        btnEditUser = new javax.swing.JButton();
        btnNewUser = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        btnSaveUser = new javax.swing.JButton();
        btnCancelUser = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        sPanelUserForm = new javax.swing.JScrollPane();
        PanelFormUser = new javax.swing.JPanel();
        lblUserInformation = new javax.swing.JLabel();
        lblRowId = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        lblUser = new javax.swing.JLabel();
        txtRowId = new javax.swing.JTextField();
        lblPass = new javax.swing.JLabel();
        txtPass = new javax.swing.JPasswordField();
        lblPassVerification = new javax.swing.JLabel();
        txtPassVerification = new javax.swing.JPasswordField();
        lblPosition = new javax.swing.JLabel();
        cbbPosition = new javax.swing.JComboBox<>();
        lblPermitions = new javax.swing.JLabel();
        btnPermitions = new javax.swing.JButton();
        lblSecQuestion1 = new javax.swing.JLabel();
        txtSecQuestion1 = new javax.swing.JTextField();
        lblSecAnswer1 = new javax.swing.JLabel();
        txtSecAnswer1 = new javax.swing.JTextField();
        lblSecQuestion2 = new javax.swing.JLabel();
        txtSecQuestion2 = new javax.swing.JTextField();
        lblSecAnswer2 = new javax.swing.JLabel();
        txtSecAnswer2 = new javax.swing.JTextField();
        lblSecQuestion3 = new javax.swing.JLabel();
        txtSecQuestion3 = new javax.swing.JTextField();
        lblSecAnswer3 = new javax.swing.JLabel();
        txtSecAnswer3 = new javax.swing.JTextField();
        lblPersonalData = new javax.swing.JLabel();
        lblDocType = new javax.swing.JLabel();
        cbbDocType = new javax.swing.JComboBox<>();
        lblDocNum = new javax.swing.JLabel();
        txtDocNum = new javax.swing.JTextField();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblSurname = new javax.swing.JLabel();
        txtSurname = new javax.swing.JTextField();
        lblNickname = new javax.swing.JLabel();
        txtNickName = new javax.swing.JTextField();
        lblSex = new javax.swing.JLabel();
        cbbSex = new javax.swing.JComboBox<>();
        lblBirthDate = new javax.swing.JLabel();
        cbbDay = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cbbMonth = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        txtYear = new javax.swing.JTextField();
        lblBornLocation = new javax.swing.JLabel();
        txtBornLocation = new javax.swing.JTextField();
        lblCivilState = new javax.swing.JLabel();
        cbbCivilState = new javax.swing.JComboBox<>();
        lblSpouseName = new javax.swing.JLabel();
        txtSpouseName = new javax.swing.JTextField();
        lblMotherName = new javax.swing.JLabel();
        txtMotherName = new javax.swing.JTextField();
        lblFatherName = new javax.swing.JLabel();
        txtFatherName = new javax.swing.JTextField();
        lblIdentityInformation = new javax.swing.JLabel();
        lblIdentityType = new javax.swing.JLabel();
        cbbIdentityType = new javax.swing.JComboBox<>();
        lblRecNum = new javax.swing.JLabel();
        txtRecNum = new javax.swing.JTextField();
        lblSerieNum = new javax.swing.JLabel();
        txtSerieNum = new javax.swing.JTextField();
        lblEmissor = new javax.swing.JLabel();
        txtEmissor = new javax.swing.JTextField();
        lblEmissionUF = new javax.swing.JLabel();
        cbbEmissionUF = new javax.swing.JComboBox<>();
        lblEmissionDate = new javax.swing.JLabel();
        txtEmissionDate = new javax.swing.JTextField();
        lblValidThru = new javax.swing.JLabel();
        txtValidThru = new javax.swing.JTextField();
        lblNaturalness = new javax.swing.JLabel();
        txtNaturalness = new javax.swing.JTextField();
        lblNationality = new javax.swing.JLabel();
        txtNationality = new javax.swing.JTextField();
        lblContactInformation = new javax.swing.JLabel();
        lblAddContact = new javax.swing.JLabel();
        btnAddContact = new javax.swing.JButton();
        lblContactMPhone = new javax.swing.JLabel();
        txtContactMPhone = new javax.swing.JTextField();
        lblContactEmail = new javax.swing.JLabel();
        txtContactEmail = new javax.swing.JTextField();
        lblContactPhone = new javax.swing.JLabel();
        txtContactPhone = new javax.swing.JTextField();
        lblContactEnterprise = new javax.swing.JLabel();
        txtContactEnterprise = new javax.swing.JTextField();
        lblSocialMedia = new javax.swing.JLabel();
        lblFacebook = new javax.swing.JLabel();
        txtFacebook = new javax.swing.JTextField();
        lblInstagram = new javax.swing.JLabel();
        txtInstagram = new javax.swing.JTextField();
        lblTwitter = new javax.swing.JLabel();
        txtTwitter = new javax.swing.JTextField();
        lblAddressInformation = new javax.swing.JLabel();
        lblAddAddress = new javax.swing.JLabel();
        btnAddAddress = new javax.swing.JButton();
        lblFullAddress = new javax.swing.JLabel();
        txtFullAddress = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lblUserInformation1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Colaboradores");
        setBackground(new java.awt.Color(255, 255, 255));
        setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N

        PanelUser.setBackground(new java.awt.Color(255, 255, 255));
        PanelUser.setPreferredSize(new java.awt.Dimension(1366, 757));

        lblUserList.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        lblUserList.setText("Lista de Funcionários");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        lblImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/Lupa white 20x20.png"))); // NOI18N

        cbbUserListFilter.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        cbbUserListFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbUserListFilter.setMaximumSize(new java.awt.Dimension(250, 32767));
        cbbUserListFilter.setPreferredSize(new java.awt.Dimension(250, 23));
        cbbUserListFilter.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbUserListFilterItemStateChanged(evt);
            }
        });

        txtUserListFilterValue.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtUserListFilterValue.setToolTipText("");
        txtUserListFilterValue.setMaximumSize(new java.awt.Dimension(250, 2147483647));
        txtUserListFilterValue.setPreferredSize(new java.awt.Dimension(250, 23));

        lblInformation.setBackground(new java.awt.Color(255, 255, 255));
        lblInformation.setText("Pressione Enter para pesquisar");
        lblInformation.setEnabled(false);

        lblRecCount.setBackground(new java.awt.Color(255, 255, 255));
        lblRecCount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblRecCount.setText("Total de Registros: 100");
        lblRecCount.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblRecCount.setMaximumSize(new java.awt.Dimension(410, 14));

        javax.swing.GroupLayout PanelUserListHeaderLayout = new javax.swing.GroupLayout(PanelUserListHeader);
        PanelUserListHeader.setLayout(PanelUserListHeaderLayout);
        PanelUserListHeaderLayout.setHorizontalGroup(
            PanelUserListHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelUserListHeaderLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(lblUserList, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblImage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbbUserListFilter, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUserListFilterValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInformation)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRecCount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        PanelUserListHeaderLayout.setVerticalGroup(
            PanelUserListHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelUserListHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelUserListHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbbUserListFilter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblUserList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addComponent(lblImage, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblRecCount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblInformation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtUserListFilterValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        lblRecCount.getAccessibleContext().setAccessibleDescription("");

        sPanelUserList.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        sPanelUserList.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        sPanelUserList.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N

        tblUserList.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        tblUserList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Usuário", "Documento", "Nome", "Sobrenome", "Apelido", "Posição", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblUserList.setGridColor(new java.awt.Color(204, 204, 204));
        tblUserList.setRowHeight(22);
        tblUserList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        sPanelUserList.setViewportView(tblUserList);

        javax.swing.GroupLayout PanelListUserLayout = new javax.swing.GroupLayout(PanelListUser);
        PanelListUser.setLayout(PanelListUserLayout);
        PanelListUserLayout.setHorizontalGroup(
            PanelListUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sPanelUserList)
        );
        PanelListUserLayout.setVerticalGroup(
            PanelListUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sPanelUserList, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PanelUserListLayout = new javax.swing.GroupLayout(PanelUserList);
        PanelUserList.setLayout(PanelUserListLayout);
        PanelUserListLayout.setHorizontalGroup(
            PanelUserListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelUserListLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelUserListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelListUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelUserListHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        PanelUserListLayout.setVerticalGroup(
            PanelUserListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelUserListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelUserListHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelListUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        lblUserNameHeader.setBackground(new java.awt.Color(255, 255, 255));
        lblUserNameHeader.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        lblUserNameHeader.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblUserNameHeader.setToolTipText("");
        lblUserNameHeader.setMinimumSize(new java.awt.Dimension(0, 30));

        lblUserFormInformation.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblUserFormInformation.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblUserFormInformation.setText("Campos Obrigatórios (*)");
        lblUserFormInformation.setEnabled(false);

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btnEditUser.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnEditUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/edit 20x20.png"))); // NOI18N
        btnEditUser.setText("Editar");
        btnEditUser.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10));
        btnEditUser.setBorderPainted(false);
        btnEditUser.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEditUser.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnEditUser.setIconTextGap(3);
        btnEditUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnEditUserKeyPressed(evt);
            }
        });

        btnNewUser.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnNewUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/new 20x20.png"))); // NOI18N
        btnNewUser.setText("Novo");
        btnNewUser.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10));
        btnNewUser.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNewUser.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnNewUser.setIconTextGap(2);
        btnNewUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnNewUserKeyPressed(evt);
            }
        });

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btnSaveUser.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnSaveUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/save 20x20.png"))); // NOI18N
        btnSaveUser.setText("Salvar");
        btnSaveUser.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10));
        btnSaveUser.setEnabled(false);
        btnSaveUser.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnSaveUser.setIconTextGap(5);
        btnSaveUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnSaveUserKeyPressed(evt);
            }
        });

        btnCancelUser.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnCancelUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/cancel 20x20.png"))); // NOI18N
        btnCancelUser.setText("Cancelar");
        btnCancelUser.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        btnCancelUser.setEnabled(false);
        btnCancelUser.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCancelUser.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnCancelUser.setIconTextGap(3);
        btnCancelUser.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnCancelUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnCancelUserKeyPressed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/delete 20x20.png"))); // NOI18N
        btnDelete.setText("Excluir");
        btnDelete.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10));
        btnDelete.setBorderPainted(false);
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDelete.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDelete.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnDelete.setIconTextGap(3);
        btnDelete.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnDeleteKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout PanelUserFormHeaderLayout = new javax.swing.GroupLayout(PanelUserFormHeader);
        PanelUserFormHeader.setLayout(PanelUserFormHeaderLayout);
        PanelUserFormHeaderLayout.setHorizontalGroup(
            PanelUserFormHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelUserFormHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUserNameHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUserFormInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditUser, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNewUser, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSaveUser, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelUser, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        PanelUserFormHeaderLayout.setVerticalGroup(
            PanelUserFormHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelUserFormHeaderLayout.createSequentialGroup()
                .addGroup(PanelUserFormHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNewUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblUserFormInformation, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSaveUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblUserNameHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        sPanelUserForm.setBorder(null);
        sPanelUserForm.setMinimumSize(new java.awt.Dimension(0, 0));
        sPanelUserForm.setPreferredSize(new java.awt.Dimension(1329, 607));

        PanelFormUser.setBackground(new java.awt.Color(255, 255, 255));
        PanelFormUser.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        PanelFormUser.setPreferredSize(new java.awt.Dimension(1329, 607));

        lblUserInformation.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.light"));
        lblUserInformation.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblUserInformation.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblUserInformation.setText("   Informações de Usuário");
        lblUserInformation.setToolTipText("");
        lblUserInformation.setEnabled(false);
        lblUserInformation.setOpaque(true);

        lblRowId.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblRowId.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblRowId.setText("Id:");
        lblRowId.setEnabled(false);

        txtUser.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtUser.setText("jTextField1");
        txtUser.setEnabled(false);
        txtUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUserKeyPressed(evt);
            }
        });

        lblUser.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblUser.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblUser.setText("Usuário*:");
        lblUser.setEnabled(false);

        txtRowId.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtRowId.setText("jTextField1");
        txtRowId.setEnabled(false);

        lblPass.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblPass.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPass.setText("Senha*:");
        lblPass.setEnabled(false);

        txtPass.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtPass.setText("jPasswordField1");
        txtPass.setEnabled(false);
        txtPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPassKeyPressed(evt);
            }
        });

        lblPassVerification.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblPassVerification.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPassVerification.setText("Confirmação de Senha*:");
        lblPassVerification.setEnabled(false);

        txtPassVerification.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtPassVerification.setText("jPasswordField1");
        txtPassVerification.setToolTipText("");
        txtPassVerification.setEnabled(false);
        txtPassVerification.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPassVerificationKeyPressed(evt);
            }
        });

        lblPosition.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblPosition.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPosition.setText("Posição*:");
        lblPosition.setEnabled(false);

        cbbPosition.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        cbbPosition.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbPosition.setEnabled(false);
        cbbPosition.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbPositionItemStateChanged(evt);
            }
        });
        cbbPosition.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbbPositionKeyPressed(evt);
            }
        });

        lblPermitions.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblPermitions.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPermitions.setText("Permissões:");
        lblPermitions.setEnabled(false);

        btnPermitions.setText("Visualizar");
        btnPermitions.setEnabled(false);
        btnPermitions.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                btnPermitionsFocusLost(evt);
            }
        });
        btnPermitions.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnPermitionsKeyPressed(evt);
            }
        });

        lblSecQuestion1.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblSecQuestion1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSecQuestion1.setText("Pergunta de Segurança 1*:");
        lblSecQuestion1.setEnabled(false);

        txtSecQuestion1.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtSecQuestion1.setText("jTextField1");
        txtSecQuestion1.setEnabled(false);
        txtSecQuestion1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSecQuestion1KeyPressed(evt);
            }
        });

        lblSecAnswer1.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblSecAnswer1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSecAnswer1.setText("Resposta 1*:");
        lblSecAnswer1.setEnabled(false);

        txtSecAnswer1.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtSecAnswer1.setText("jTextField1");
        txtSecAnswer1.setEnabled(false);
        txtSecAnswer1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSecAnswer1KeyPressed(evt);
            }
        });

        lblSecQuestion2.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblSecQuestion2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSecQuestion2.setText("Pergunta de Segurança 2*:");
        lblSecQuestion2.setEnabled(false);

        txtSecQuestion2.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtSecQuestion2.setText("jTextField1");
        txtSecQuestion2.setEnabled(false);
        txtSecQuestion2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSecQuestion2KeyPressed(evt);
            }
        });

        lblSecAnswer2.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblSecAnswer2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSecAnswer2.setText("Resposta 2*:");
        lblSecAnswer2.setEnabled(false);

        txtSecAnswer2.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtSecAnswer2.setText("jTextField1");
        txtSecAnswer2.setEnabled(false);
        txtSecAnswer2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSecAnswer2KeyPressed(evt);
            }
        });

        lblSecQuestion3.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblSecQuestion3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSecQuestion3.setText("Pergunta de Segurança 3*:");
        lblSecQuestion3.setEnabled(false);

        txtSecQuestion3.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtSecQuestion3.setText("jTextField1");
        txtSecQuestion3.setEnabled(false);
        txtSecQuestion3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSecQuestion3KeyPressed(evt);
            }
        });

        lblSecAnswer3.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblSecAnswer3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSecAnswer3.setText("Resposta 3*:");
        lblSecAnswer3.setEnabled(false);

        txtSecAnswer3.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtSecAnswer3.setText("jTextField1");
        txtSecAnswer3.setEnabled(false);
        txtSecAnswer3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSecAnswer3KeyPressed(evt);
            }
        });

        lblPersonalData.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.light"));
        lblPersonalData.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblPersonalData.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPersonalData.setText("   Dados Pessoais");
        lblPersonalData.setToolTipText("");
        lblPersonalData.setEnabled(false);
        lblPersonalData.setOpaque(true);

        lblDocType.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblDocType.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDocType.setText("Tipo de Documento*:");
        lblDocType.setEnabled(false);

        cbbDocType.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        cbbDocType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbDocType.setEnabled(false);
        cbbDocType.setPreferredSize(new java.awt.Dimension(165, 22));
        cbbDocType.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbDocTypeItemStateChanged(evt);
            }
        });
        cbbDocType.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbbDocTypeKeyPressed(evt);
            }
        });

        lblDocNum.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblDocNum.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDocNum.setText("Documento*:");
        lblDocNum.setEnabled(false);

        txtDocNum.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtDocNum.setText("Matheus Cabral Rosa");
        txtDocNum.setEnabled(false);
        txtDocNum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDocNumKeyPressed(evt);
            }
        });

        lblName.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblName.setText("Nome*:");
        lblName.setEnabled(false);

        txtName.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtName.setText("Matheus Cabral Rosa");
        txtName.setEnabled(false);
        txtName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNameKeyPressed(evt);
            }
        });

        lblSurname.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblSurname.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSurname.setText("Sobrenome*:");
        lblSurname.setEnabled(false);

        txtSurname.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtSurname.setText("jTextField1");
        txtSurname.setEnabled(false);
        txtSurname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSurnameKeyPressed(evt);
            }
        });

        lblNickname.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblNickname.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNickname.setText("Apelido:");
        lblNickname.setEnabled(false);

        txtNickName.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtNickName.setText("jTextField1");
        txtNickName.setEnabled(false);
        txtNickName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNickNameKeyPressed(evt);
            }
        });

        lblSex.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblSex.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSex.setText("Sexo*:");
        lblSex.setEnabled(false);

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

        lblBirthDate.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblBirthDate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblBirthDate.setText("Data de Nascimento*:");
        lblBirthDate.setEnabled(false);

        cbbDay.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        cbbDay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "26" }));
        cbbDay.setEnabled(false);
        cbbDay.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbDayItemStateChanged(evt);
            }
        });
        cbbDay.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbbDayKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel2.setText("/");
        jLabel2.setEnabled(false);

        cbbMonth.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        cbbMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Janeiro" }));
        cbbMonth.setEnabled(false);
        cbbMonth.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbMonthItemStateChanged(evt);
            }
        });
        cbbMonth.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbbMonthKeyPressed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel12.setText("/");
        jLabel12.setEnabled(false);

        txtYear.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtYear.setText("1997");
        txtYear.setEnabled(false);
        txtYear.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtYearKeyPressed(evt);
            }
        });

        lblBornLocation.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblBornLocation.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblBornLocation.setText("Local do Nascimento:");
        lblBornLocation.setEnabled(false);

        txtBornLocation.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtBornLocation.setText("jTextField1");
        txtBornLocation.setEnabled(false);
        txtBornLocation.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBornLocationKeyPressed(evt);
            }
        });

        lblCivilState.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblCivilState.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCivilState.setText("Estado Civil:");
        lblCivilState.setEnabled(false);

        cbbCivilState.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        cbbCivilState.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbCivilState.setEnabled(false);
        cbbCivilState.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbCivilStateItemStateChanged(evt);
            }
        });
        cbbCivilState.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbbCivilStateKeyPressed(evt);
            }
        });

        lblSpouseName.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblSpouseName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSpouseName.setText("Nome do Cônjuje:");
        lblSpouseName.setEnabled(false);

        txtSpouseName.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtSpouseName.setText("jTextField1");
        txtSpouseName.setEnabled(false);
        txtSpouseName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSpouseNameKeyPressed(evt);
            }
        });

        lblMotherName.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblMotherName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMotherName.setText("Nome da Mãe:");
        lblMotherName.setEnabled(false);

        txtMotherName.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtMotherName.setText("jTextField1");
        txtMotherName.setEnabled(false);
        txtMotherName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMotherNameKeyPressed(evt);
            }
        });

        lblFatherName.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblFatherName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFatherName.setText("Nome do Pai:");
        lblFatherName.setEnabled(false);

        txtFatherName.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtFatherName.setText("jTextField1");
        txtFatherName.setEnabled(false);
        txtFatherName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFatherNameKeyPressed(evt);
            }
        });

        lblIdentityInformation.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.light"));
        lblIdentityInformation.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblIdentityInformation.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblIdentityInformation.setText("   Informações de Identificação");
        lblIdentityInformation.setToolTipText("");
        lblIdentityInformation.setEnabled(false);
        lblIdentityInformation.setOpaque(true);

        lblIdentityType.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblIdentityType.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblIdentityType.setText("Tipo de Identificação:");
        lblIdentityType.setEnabled(false);

        cbbIdentityType.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        cbbIdentityType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbIdentityType.setEnabled(false);
        cbbIdentityType.setPreferredSize(new java.awt.Dimension(165, 22));
        cbbIdentityType.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbIdentityTypeItemStateChanged(evt);
            }
        });
        cbbIdentityType.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbbIdentityTypeKeyPressed(evt);
            }
        });

        lblRecNum.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblRecNum.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblRecNum.setText("Registro:");
        lblRecNum.setEnabled(false);

        txtRecNum.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtRecNum.setText("jTextField1");
        txtRecNum.setEnabled(false);
        txtRecNum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRecNumKeyPressed(evt);
            }
        });

        lblSerieNum.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblSerieNum.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSerieNum.setText("Série:");
        lblSerieNum.setEnabled(false);

        txtSerieNum.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtSerieNum.setText("jTextField1");
        txtSerieNum.setEnabled(false);
        txtSerieNum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSerieNumKeyPressed(evt);
            }
        });

        lblEmissor.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblEmissor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblEmissor.setText("Órgão Emissor:");
        lblEmissor.setEnabled(false);

        txtEmissor.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtEmissor.setText("jTextField1");
        txtEmissor.setEnabled(false);
        txtEmissor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEmissorKeyPressed(evt);
            }
        });

        lblEmissionUF.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblEmissionUF.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblEmissionUF.setText("UF Emissão:");
        lblEmissionUF.setEnabled(false);

        cbbEmissionUF.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        cbbEmissionUF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbEmissionUF.setEnabled(false);
        cbbEmissionUF.setPreferredSize(new java.awt.Dimension(165, 22));
        cbbEmissionUF.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbEmissionUFItemStateChanged(evt);
            }
        });
        cbbEmissionUF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbbEmissionUFKeyPressed(evt);
            }
        });

        lblEmissionDate.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblEmissionDate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblEmissionDate.setText("Data Emissão:");
        lblEmissionDate.setEnabled(false);

        txtEmissionDate.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtEmissionDate.setText("jTextField1");
        txtEmissionDate.setEnabled(false);
        txtEmissionDate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEmissionDateKeyPressed(evt);
            }
        });

        lblValidThru.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblValidThru.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblValidThru.setText("Data de Validade:");
        lblValidThru.setEnabled(false);

        txtValidThru.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtValidThru.setText("jTextField1");
        txtValidThru.setEnabled(false);
        txtValidThru.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtValidThruKeyPressed(evt);
            }
        });

        lblNaturalness.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblNaturalness.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNaturalness.setText("Naturalidade:");
        lblNaturalness.setEnabled(false);

        txtNaturalness.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtNaturalness.setText("jTextField1");
        txtNaturalness.setEnabled(false);
        txtNaturalness.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNaturalnessKeyPressed(evt);
            }
        });

        lblNationality.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblNationality.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNationality.setText("Nacionalidade:");
        lblNationality.setEnabled(false);

        txtNationality.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtNationality.setText("jTextField1");
        txtNationality.setEnabled(false);
        txtNationality.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNationalityKeyPressed(evt);
            }
        });

        lblContactInformation.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.light"));
        lblContactInformation.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblContactInformation.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblContactInformation.setText("   Informações do Contato Principal");
        lblContactInformation.setToolTipText("");
        lblContactInformation.setEnabled(false);
        lblContactInformation.setOpaque(true);

        lblAddContact.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblAddContact.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAddContact.setText("Contato*:");
        lblAddContact.setEnabled(false);

        btnAddContact.setText("Visualizar/Cadastrar");
        btnAddContact.setEnabled(false);
        btnAddContact.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                btnAddContactFocusLost(evt);
            }
        });
        btnAddContact.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnAddContactKeyPressed(evt);
            }
        });

        lblContactMPhone.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblContactMPhone.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblContactMPhone.setText("Celular/WhatsApp*:");
        lblContactMPhone.setEnabled(false);

        txtContactMPhone.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtContactMPhone.setText("jTextField1");
        txtContactMPhone.setEnabled(false);
        txtContactMPhone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtContactMPhoneKeyPressed(evt);
            }
        });

        lblContactEmail.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblContactEmail.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblContactEmail.setText("Email:");
        lblContactEmail.setToolTipText("");
        lblContactEmail.setEnabled(false);

        txtContactEmail.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtContactEmail.setText("jTextField1");
        txtContactEmail.setEnabled(false);
        txtContactEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtContactEmailKeyPressed(evt);
            }
        });

        lblContactPhone.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblContactPhone.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblContactPhone.setText("Telefone Fixo:");
        lblContactPhone.setEnabled(false);

        txtContactPhone.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtContactPhone.setText("jTextField1");
        txtContactPhone.setEnabled(false);
        txtContactPhone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtContactPhoneKeyPressed(evt);
            }
        });

        lblContactEnterprise.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblContactEnterprise.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblContactEnterprise.setText("Telefone Comercial:");
        lblContactEnterprise.setEnabled(false);

        txtContactEnterprise.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtContactEnterprise.setText("jTextField1");
        txtContactEnterprise.setEnabled(false);
        txtContactEnterprise.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtContactEnterpriseKeyPressed(evt);
            }
        });

        lblSocialMedia.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.light"));
        lblSocialMedia.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblSocialMedia.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblSocialMedia.setText("   Redes Sociais");
        lblSocialMedia.setToolTipText("");
        lblSocialMedia.setEnabled(false);
        lblSocialMedia.setOpaque(true);

        lblFacebook.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblFacebook.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFacebook.setText("Facebook:");
        lblFacebook.setEnabled(false);

        txtFacebook.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtFacebook.setText("jTextField1");
        txtFacebook.setEnabled(false);
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
        txtTwitter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTwitterKeyPressed(evt);
            }
        });

        lblAddressInformation.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.light"));
        lblAddressInformation.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblAddressInformation.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblAddressInformation.setText("   Informações do Endereço Principal:");
        lblAddressInformation.setEnabled(false);
        lblAddressInformation.setOpaque(true);

        lblAddAddress.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblAddAddress.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAddAddress.setText("Endereço*:");
        lblAddAddress.setEnabled(false);

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

        txtFullAddress.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtFullAddress.setText("jTextField1");
        txtFullAddress.setEnabled(false);
        txtFullAddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFullAddressKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel1.setText("<html>\n<font size=\"4\"><b>Sua senha deve:</b></font></br>\n<p>• Ter pelo menos 8 caracteres</p></br>\n<p>• Ter pelo menos 1 letra MAIÚSCULA</p></br>\n<p>• Ter pelo menos 1 letra minúscula</p></br>\n<p>• Ter pelo menos 1 número</p></br>\n<p></br></p>\n<font size=\"4\"><b>Sua senha NÃO deve:</b></font></br>\n<p>• Conter mais de 2 caracteres idênticos consecutivos</p></br>\n<p>• Conter sua data de nascimento</p></br>\n<p>• Ter sido usada no último ano</p></br>\n<p>• Ser a mesma que o nome do usuário</p></br>\n<p>• Ser a mesma que o seu nome</p></br>\n<p>• Ser uma senha comum</p>\n</html>");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel1.setEnabled(false);

        lblUserInformation1.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.light"));
        lblUserInformation1.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblUserInformation1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblUserInformation1.setText("   Informações de Permissões e Segurança");
        lblUserInformation1.setToolTipText("");
        lblUserInformation1.setEnabled(false);
        lblUserInformation1.setOpaque(true);

        javax.swing.GroupLayout PanelFormUserLayout = new javax.swing.GroupLayout(PanelFormUser);
        PanelFormUser.setLayout(PanelFormUserLayout);
        PanelFormUserLayout.setHorizontalGroup(
            PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFormUserLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelFormUserLayout.createSequentialGroup()
                        .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(PanelFormUserLayout.createSequentialGroup()
                                    .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelFormUserLayout.createSequentialGroup()
                                            .addComponent(lblPassVerification, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtPassVerification))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelFormUserLayout.createSequentialGroup()
                                            .addGap(0, 0, Short.MAX_VALUE)
                                            .addComponent(lblRowId, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtRowId, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(PanelFormUserLayout.createSequentialGroup()
                                            .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblPass, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtUser, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                                                .addComponent(txtPass))
                                            .addGap(0, 0, Short.MAX_VALUE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(lblUserInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelFormUserLayout.createSequentialGroup()
                                .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PanelFormUserLayout.createSequentialGroup()
                                        .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblPermitions, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cbbPosition, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnPermitions, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(PanelFormUserLayout.createSequentialGroup()
                                        .addComponent(lblSecQuestion1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtSecQuestion1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(PanelFormUserLayout.createSequentialGroup()
                                        .addComponent(lblSecAnswer1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtSecAnswer1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(PanelFormUserLayout.createSequentialGroup()
                                        .addComponent(lblSecQuestion2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtSecQuestion2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(PanelFormUserLayout.createSequentialGroup()
                                        .addComponent(lblSecAnswer2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtSecAnswer2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(PanelFormUserLayout.createSequentialGroup()
                                        .addComponent(lblSecQuestion3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtSecQuestion3, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(PanelFormUserLayout.createSequentialGroup()
                                        .addComponent(lblSecAnswer3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtSecAnswer3, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(lblUserInformation1, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPersonalData, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelFormUserLayout.createSequentialGroup()
                                .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PanelFormUserLayout.createSequentialGroup()
                                        .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(PanelFormUserLayout.createSequentialGroup()
                                        .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(lblSex, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblNickname, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtNickName)
                                            .addComponent(cbbSex, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(PanelFormUserLayout.createSequentialGroup()
                                        .addComponent(lblSurname, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtSurname, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(PanelFormUserLayout.createSequentialGroup()
                                        .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblDocType, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblDocNum, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbbDocType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtDocNum, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PanelFormUserLayout.createSequentialGroup()
                                        .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(lblBirthDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblBornLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(PanelFormUserLayout.createSequentialGroup()
                                                .addComponent(cbbDay, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cbbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel12)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtYear))
                                            .addComponent(txtBornLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(PanelFormUserLayout.createSequentialGroup()
                                        .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(lblCivilState, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblSpouseName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtSpouseName)
                                            .addComponent(cbbCivilState, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(PanelFormUserLayout.createSequentialGroup()
                                        .addComponent(lblMotherName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtMotherName, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(PanelFormUserLayout.createSequentialGroup()
                                        .addComponent(lblFatherName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtFatherName, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(PanelFormUserLayout.createSequentialGroup()
                                .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblContactInformation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(PanelFormUserLayout.createSequentialGroup()
                                        .addComponent(lblContactEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtContactEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(PanelFormUserLayout.createSequentialGroup()
                                        .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblAddContact, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblContactMPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtContactMPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnAddContact, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(PanelFormUserLayout.createSequentialGroup()
                                        .addComponent(lblContactPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtContactPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(PanelFormUserLayout.createSequentialGroup()
                                        .addComponent(lblContactEnterprise, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtContactEnterprise, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblSocialMedia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(PanelFormUserLayout.createSequentialGroup()
                                        .addComponent(lblAddAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnAddAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(PanelFormUserLayout.createSequentialGroup()
                                        .addComponent(lblFullAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtFullAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblAddressInformation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(PanelFormUserLayout.createSequentialGroup()
                                        .addComponent(lblFacebook, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtFacebook, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(PanelFormUserLayout.createSequentialGroup()
                                        .addComponent(lblInstagram, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtInstagram, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(PanelFormUserLayout.createSequentialGroup()
                                        .addComponent(lblTwitter, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTwitter, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addComponent(lblIdentityInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelFormUserLayout.createSequentialGroup()
                        .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(PanelFormUserLayout.createSequentialGroup()
                                .addComponent(lblIdentityType, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbbIdentityType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(PanelFormUserLayout.createSequentialGroup()
                                .addComponent(lblRecNum, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtRecNum, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelFormUserLayout.createSequentialGroup()
                                .addComponent(lblSerieNum, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtSerieNum, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelFormUserLayout.createSequentialGroup()
                                .addComponent(lblEmissor, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtEmissor, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelFormUserLayout.createSequentialGroup()
                                .addComponent(lblNaturalness, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNaturalness, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelFormUserLayout.createSequentialGroup()
                                .addComponent(lblEmissionDate, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEmissionDate, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelFormUserLayout.createSequentialGroup()
                                .addComponent(lblValidThru, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtValidThru, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelFormUserLayout.createSequentialGroup()
                                .addComponent(lblNationality, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNationality, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(PanelFormUserLayout.createSequentialGroup()
                        .addComponent(lblEmissionUF, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbEmissionUF, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelFormUserLayout.setVerticalGroup(
            PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFormUserLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelFormUserLayout.createSequentialGroup()
                        .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(PanelFormUserLayout.createSequentialGroup()
                                .addGap(112, 112, 112)
                                .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblPassVerification, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPassVerification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(PanelFormUserLayout.createSequentialGroup()
                                .addComponent(lblUserInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PanelFormUserLayout.createSequentialGroup()
                                        .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(lblRowId, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtRowId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(PanelFormUserLayout.createSequentialGroup()
                                                .addGap(28, 28, 28)
                                                .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lblPass, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jLabel1))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblUserInformation1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelFormUserLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnPermitions)
                                    .addComponent(lblPermitions, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblSecAnswer2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSecAnswer2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbbPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblSecQuestion2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtSecQuestion2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSecQuestion1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSecQuestion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSecQuestion3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSecQuestion3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSecAnswer1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSecAnswer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSecAnswer3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSecAnswer3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PanelFormUserLayout.createSequentialGroup()
                        .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelFormUserLayout.createSequentialGroup()
                                .addComponent(lblPersonalData, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblDocType, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbbDocType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblDocNum, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblSurname, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblNickname, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNickName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblSex, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbbSex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(PanelFormUserLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblBirthDate, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbbDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)
                                    .addComponent(cbbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12)
                                    .addComponent(txtYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblBornLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtBornLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDocNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(7, 7, 7)
                                .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblCivilState, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbbCivilState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblSpouseName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSpouseName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblMotherName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMotherName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblFatherName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFatherName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(26, 26, 26)
                        .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblContactInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSocialMedia, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelFormUserLayout.createSequentialGroup()
                                .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblAddContact, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnAddContact))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblContactMPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtContactMPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(7, 7, 7)
                                .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblContactEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtContactEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(PanelFormUserLayout.createSequentialGroup()
                                .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblFacebook, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFacebook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(7, 7, 7)
                                .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblInstagram, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtInstagram, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblTwitter, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTwitter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelFormUserLayout.createSequentialGroup()
                                .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblContactPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtContactPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblContactEnterprise, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtContactEnterprise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29))
                            .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(PanelFormUserLayout.createSequentialGroup()
                                    .addComponent(lblAddressInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(57, 57, 57))
                                .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PanelFormUserLayout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lblFullAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtFullAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblAddAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnAddAddress)))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PanelFormUserLayout.createSequentialGroup()
                        .addComponent(lblIdentityInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblIdentityType, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbbIdentityType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(PanelFormUserLayout.createSequentialGroup()
                                    .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblEmissionDate, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtEmissionDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblValidThru, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtValidThru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblRecNum, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtRecNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNaturalness, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtNaturalness, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(28, 28, 28))
                                .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblNationality, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNationality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblEmissor, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEmissor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(PanelFormUserLayout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSerieNum, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSerieNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEmissionUF, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbEmissionUF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        sPanelUserForm.setViewportView(PanelFormUser);

        javax.swing.GroupLayout PanelUserFormLayout = new javax.swing.GroupLayout(PanelUserForm);
        PanelUserForm.setLayout(PanelUserFormLayout);
        PanelUserFormLayout.setHorizontalGroup(
            PanelUserFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelUserFormLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sPanelUserForm, javax.swing.GroupLayout.DEFAULT_SIZE, 1346, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(PanelUserFormHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelUserFormLayout.setVerticalGroup(
            PanelUserFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelUserFormLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelUserFormHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sPanelUserForm, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PanelUserLayout = new javax.swing.GroupLayout(PanelUser);
        PanelUser.setLayout(PanelUserLayout);
        PanelUserLayout.setHorizontalGroup(
            PanelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelUserList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelUserForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelUserLayout.setVerticalGroup(
            PanelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelUserLayout.createSequentialGroup()
                .addComponent(PanelUserList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelUserForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelUser, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_TAB){
            setFocus("SENHA");
        }
    }//GEN-LAST:event_txtUserKeyPressed

    private void txtPassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPassKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("SENHA_CONFIRMACAO");
        }
    }//GEN-LAST:event_txtPassKeyPressed

    private void txtPassVerificationKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPassVerificationKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("POSICAO");
        }
    }//GEN-LAST:event_txtPassVerificationKeyPressed

    private void txtSecQuestion1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSecQuestion1KeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("RESPOSTA_SEG_1");
        }
    }//GEN-LAST:event_txtSecQuestion1KeyPressed

    private void txtSecAnswer1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSecAnswer1KeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("PERGUNTA_SEG_2");
        }
    }//GEN-LAST:event_txtSecAnswer1KeyPressed

    private void txtSecQuestion2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSecQuestion2KeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("RESPOSTA_SEG_2");
        }
    }//GEN-LAST:event_txtSecQuestion2KeyPressed

    private void txtSecAnswer2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSecAnswer2KeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("PERGUNTA_SEG_3");
        }
    }//GEN-LAST:event_txtSecAnswer2KeyPressed

    private void txtSecQuestion3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSecQuestion3KeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("RESPOSTA_SEG_3");
        }
    }//GEN-LAST:event_txtSecQuestion3KeyPressed

    private void txtSecAnswer3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSecAnswer3KeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            if(this.iscbbDocTypeEnabled()){
                setFocus("DOCUMENTO_TIPO");
            }
        }
    }//GEN-LAST:event_txtSecAnswer3KeyPressed

    private void cbbDocTypeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbbDocTypeKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_TAB){
            setFocus("NUM_DOCUMENTO");
        }
    }//GEN-LAST:event_cbbDocTypeKeyPressed

    private void txtDocNumKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDocNumKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("NOME");
        }
    }//GEN-LAST:event_txtDocNumKeyPressed

    private void txtNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("SOBRENOME");
        }
    }//GEN-LAST:event_txtNameKeyPressed

    private void txtSurnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSurnameKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("APELIDO");
        }
    }//GEN-LAST:event_txtSurnameKeyPressed

    private void txtNickNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNickNameKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("SEXO");
        }
    }//GEN-LAST:event_txtNickNameKeyPressed

    private void cbbSexItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbSexItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            setFocus("NASCIMENTO_DIA");
        }
    }//GEN-LAST:event_cbbSexItemStateChanged

    private void cbbPositionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbPositionItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            setFocus("BOTAO_PERMISSAO");
        }
    }//GEN-LAST:event_cbbPositionItemStateChanged

    private void cbbDayItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbDayItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            setFocus("NASCIMENTO_MES");
        }
    }//GEN-LAST:event_cbbDayItemStateChanged

    private void cbbMonthItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbMonthItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            setFocus("NASCIMENTO_ANO");
        }
    }//GEN-LAST:event_cbbMonthItemStateChanged

    private void txtYearKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtYearKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("NASCIMENTO_LOCAL");
        }
    }//GEN-LAST:event_txtYearKeyPressed

    private void txtBornLocationKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBornLocationKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("ESTADO_CIVIL");
        }
    }//GEN-LAST:event_txtBornLocationKeyPressed

    private void cbbCivilStateItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbCivilStateItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            setFocus("NOME_CONJUJE");
        }
    }//GEN-LAST:event_cbbCivilStateItemStateChanged

    private void txtSpouseNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSpouseNameKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("NOME_MAE");
        }
    }//GEN-LAST:event_txtSpouseNameKeyPressed

    private void txtMotherNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMotherNameKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("NOME_PAI");
        }
    }//GEN-LAST:event_txtMotherNameKeyPressed

    private void txtFatherNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFatherNameKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("REGISTRO_TIPO");
        }
    }//GEN-LAST:event_txtFatherNameKeyPressed

    private void cbbIdentityTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbIdentityTypeItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            setFocus("REGISTRO_NUMERO");
        }
    }//GEN-LAST:event_cbbIdentityTypeItemStateChanged

    private void txtRecNumKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRecNumKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("REGISTRO_SERIE");
        }
    }//GEN-LAST:event_txtRecNumKeyPressed

    private void txtSerieNumKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSerieNumKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("REGISTRO_EMISSOR");
        }
    }//GEN-LAST:event_txtSerieNumKeyPressed

    private void txtEmissorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmissorKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("REGISTRO_UF_EMISSAO");
        }
    }//GEN-LAST:event_txtEmissorKeyPressed

    private void cbbEmissionUFItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbEmissionUFItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            setFocus("REGISTRO_DT_EMISSAO");
        }
    }//GEN-LAST:event_cbbEmissionUFItemStateChanged

    private void txtEmissionDateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmissionDateKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("REGISTRO_DT_VALIDADE");
        }
    }//GEN-LAST:event_txtEmissionDateKeyPressed

    private void txtValidThruKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValidThruKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("REGISTRO_NATURALIDADE");
        }
    }//GEN-LAST:event_txtValidThruKeyPressed

    private void txtNaturalnessKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNaturalnessKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("REGISTRO_NACIONALIDADE");
        }
    }//GEN-LAST:event_txtNaturalnessKeyPressed

    private void txtNationalityKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNationalityKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("BOTAO_ADD_CONTATO");
        }
    }//GEN-LAST:event_txtNationalityKeyPressed

    private void txtContactMPhoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContactMPhoneKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("CONTATO_EMAIL");
        }
    }//GEN-LAST:event_txtContactMPhoneKeyPressed

    private void txtContactEmailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContactEmailKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("CONTATO_TELEFONE_FIXO");
        }
    }//GEN-LAST:event_txtContactEmailKeyPressed

    private void txtContactPhoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContactPhoneKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("CONTATO_TELEFONE_COMERCIAL");
        }
    }//GEN-LAST:event_txtContactPhoneKeyPressed

    private void txtContactEnterpriseKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContactEnterpriseKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("BOTAO_ADD_REDE_SOCIAL");
        }
    }//GEN-LAST:event_txtContactEnterpriseKeyPressed

    private void txtFacebookKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFacebookKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("REDE_SOCIAL_INSTAGRAM");
        }
    }//GEN-LAST:event_txtFacebookKeyPressed

    private void txtInstagramKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtInstagramKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("REDE_SOCIAL_TWITTER");
        }
    }//GEN-LAST:event_txtInstagramKeyPressed

    private void txtTwitterKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTwitterKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("BOTAO_ADD_ENDERECO");
        }
    }//GEN-LAST:event_txtTwitterKeyPressed

    private void txtFullAddressKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFullAddressKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("BOTAO_SALVAR");
        }
    }//GEN-LAST:event_txtFullAddressKeyPressed

    private void btnPermitionsFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnPermitionsFocusLost
        setFocus("PERGUNTA_SEG_1");
    }//GEN-LAST:event_btnPermitionsFocusLost

    private void btnAddContactFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnAddContactFocusLost
        setFocus("BOTAO_ADD_REDE_SOCIAL");
    }//GEN-LAST:event_btnAddContactFocusLost

    private void btnAddAddressFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnAddAddressFocusLost
        setFocus("BOTAO_SALVAR");
    }//GEN-LAST:event_btnAddAddressFocusLost

    private void cbbPositionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbbPositionKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_TAB){
            if(!getcbbPosition().equals("Selecione...")){
                setbtnPermitionsEnabled(true);
                setFocus("BOTAO_PERMISSAO");
            } else {
                setbtnPermitionsEnabled(false);
            }
        }
    }//GEN-LAST:event_cbbPositionKeyPressed

    private void btnPermitionsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnPermitionsKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_TAB){
            setFocus("PERGUNTA_SEG_1");
        }
    }//GEN-LAST:event_btnPermitionsKeyPressed

    private void cbbDocTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbDocTypeItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            setFocus("NUM_DOCUMENTO");
        }
    }//GEN-LAST:event_cbbDocTypeItemStateChanged

    private void cbbSexKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbbSexKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_TAB){
            setFocus("NASCIMENTO_DIA");
        }
    }//GEN-LAST:event_cbbSexKeyPressed

    private void cbbDayKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbbDayKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_TAB){
            setFocus("NASCIMENTO_MES");
        }
    }//GEN-LAST:event_cbbDayKeyPressed

    private void cbbMonthKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbbMonthKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_TAB){
            setFocus("NASCIMENTO_ANO");
        }
    }//GEN-LAST:event_cbbMonthKeyPressed

    private void cbbCivilStateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbbCivilStateKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_TAB){
            setFocus("NOME_CONJUJE");
        }
    }//GEN-LAST:event_cbbCivilStateKeyPressed

    private void cbbIdentityTypeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbbIdentityTypeKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_TAB){
            setFocus("REGISTRO_NUMERO");
        }
    }//GEN-LAST:event_cbbIdentityTypeKeyPressed

    private void cbbEmissionUFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbbEmissionUFKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_TAB){
            setFocus("REGISTRO_DT_EMISSAO");
        }
    }//GEN-LAST:event_cbbEmissionUFKeyPressed

    private void btnAddContactKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAddContactKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_TAB){
            setFocus("BOTAO_ADD_REDE_SOCIAL");
        }
    }//GEN-LAST:event_btnAddContactKeyPressed

    private void btnAddAddressKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAddAddressKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_TAB){
            setFocus("BOTAO_SALVAR");
        }
    }//GEN-LAST:event_btnAddAddressKeyPressed

    private void btnEditUserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnEditUserKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_TAB){
            setFocus("BOTAO_NOVO");
        }
    }//GEN-LAST:event_btnEditUserKeyPressed

    private void btnNewUserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnNewUserKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_TAB){
            setFocus("BOTAO_EDITAR");
        }
    }//GEN-LAST:event_btnNewUserKeyPressed

    private void btnSaveUserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSaveUserKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_TAB){
            setFocus("BOTAO_CANCELAR");
        }
    }//GEN-LAST:event_btnSaveUserKeyPressed

    private void btnCancelUserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCancelUserKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_TAB){
            setFocus("BOTAO_SALVAR");
        }
    }//GEN-LAST:event_btnCancelUserKeyPressed

    private void cbbUserListFilterItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbUserListFilterItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            setFocus("FILTRO_VALOR");
        }
    }//GEN-LAST:event_cbbUserListFilterItemStateChanged

    private void btnDeleteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnDeleteKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelFormUser;
    private javax.swing.JPanel PanelListUser;
    private javax.swing.JPanel PanelUser;
    private javax.swing.JPanel PanelUserForm;
    private javax.swing.JPanel PanelUserFormHeader;
    private javax.swing.JPanel PanelUserList;
    private javax.swing.JPanel PanelUserListHeader;
    private javax.swing.JButton btnAddAddress;
    private javax.swing.JButton btnAddContact;
    private javax.swing.JButton btnCancelUser;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEditUser;
    private javax.swing.JButton btnNewUser;
    private javax.swing.JButton btnPermitions;
    private javax.swing.JButton btnSaveUser;
    private javax.swing.JComboBox<String> cbbCivilState;
    private javax.swing.JComboBox<String> cbbDay;
    private javax.swing.JComboBox<String> cbbDocType;
    private javax.swing.JComboBox<String> cbbEmissionUF;
    private javax.swing.JComboBox<String> cbbIdentityType;
    private javax.swing.JComboBox<String> cbbMonth;
    private javax.swing.JComboBox<String> cbbPosition;
    private javax.swing.JComboBox<String> cbbSex;
    private javax.swing.JComboBox<String> cbbUserListFilter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblAddAddress;
    private javax.swing.JLabel lblAddContact;
    private javax.swing.JLabel lblAddressInformation;
    private javax.swing.JLabel lblBirthDate;
    private javax.swing.JLabel lblBornLocation;
    private javax.swing.JLabel lblCivilState;
    private javax.swing.JLabel lblContactEmail;
    private javax.swing.JLabel lblContactEnterprise;
    private javax.swing.JLabel lblContactInformation;
    private javax.swing.JLabel lblContactMPhone;
    private javax.swing.JLabel lblContactPhone;
    private javax.swing.JLabel lblDocNum;
    private javax.swing.JLabel lblDocType;
    private javax.swing.JLabel lblEmissionDate;
    private javax.swing.JLabel lblEmissionUF;
    private javax.swing.JLabel lblEmissor;
    private javax.swing.JLabel lblFacebook;
    private javax.swing.JLabel lblFatherName;
    private javax.swing.JLabel lblFullAddress;
    private javax.swing.JLabel lblIdentityInformation;
    private javax.swing.JLabel lblIdentityType;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblInformation;
    private javax.swing.JLabel lblInstagram;
    private javax.swing.JLabel lblMotherName;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNationality;
    private javax.swing.JLabel lblNaturalness;
    private javax.swing.JLabel lblNickname;
    private javax.swing.JLabel lblPass;
    private javax.swing.JLabel lblPassVerification;
    private javax.swing.JLabel lblPermitions;
    private javax.swing.JLabel lblPersonalData;
    private javax.swing.JLabel lblPosition;
    private javax.swing.JLabel lblRecCount;
    private javax.swing.JLabel lblRecNum;
    private javax.swing.JLabel lblRowId;
    private javax.swing.JLabel lblSecAnswer1;
    private javax.swing.JLabel lblSecAnswer2;
    private javax.swing.JLabel lblSecAnswer3;
    private javax.swing.JLabel lblSecQuestion1;
    private javax.swing.JLabel lblSecQuestion2;
    private javax.swing.JLabel lblSecQuestion3;
    private javax.swing.JLabel lblSerieNum;
    private javax.swing.JLabel lblSex;
    private javax.swing.JLabel lblSocialMedia;
    private javax.swing.JLabel lblSpouseName;
    private javax.swing.JLabel lblSurname;
    private javax.swing.JLabel lblTwitter;
    private javax.swing.JLabel lblUser;
    private javax.swing.JLabel lblUserFormInformation;
    private javax.swing.JLabel lblUserInformation;
    private javax.swing.JLabel lblUserInformation1;
    private javax.swing.JLabel lblUserList;
    private javax.swing.JLabel lblUserNameHeader;
    private javax.swing.JLabel lblValidThru;
    private javax.swing.JScrollPane sPanelUserForm;
    private javax.swing.JScrollPane sPanelUserList;
    private javax.swing.JTable tblUserList;
    private javax.swing.JTextField txtBornLocation;
    private javax.swing.JTextField txtContactEmail;
    private javax.swing.JTextField txtContactEnterprise;
    private javax.swing.JTextField txtContactMPhone;
    private javax.swing.JTextField txtContactPhone;
    private javax.swing.JTextField txtDocNum;
    private javax.swing.JTextField txtEmissionDate;
    private javax.swing.JTextField txtEmissor;
    private javax.swing.JTextField txtFacebook;
    private javax.swing.JTextField txtFatherName;
    private javax.swing.JTextField txtFullAddress;
    private javax.swing.JTextField txtInstagram;
    private javax.swing.JTextField txtMotherName;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNationality;
    private javax.swing.JTextField txtNaturalness;
    private javax.swing.JTextField txtNickName;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JPasswordField txtPassVerification;
    private javax.swing.JTextField txtRecNum;
    private javax.swing.JTextField txtRowId;
    private javax.swing.JTextField txtSecAnswer1;
    private javax.swing.JTextField txtSecAnswer2;
    private javax.swing.JTextField txtSecAnswer3;
    private javax.swing.JTextField txtSecQuestion1;
    private javax.swing.JTextField txtSecQuestion2;
    private javax.swing.JTextField txtSecQuestion3;
    private javax.swing.JTextField txtSerieNum;
    private javax.swing.JTextField txtSpouseName;
    private javax.swing.JTextField txtSurname;
    private javax.swing.JTextField txtTwitter;
    private javax.swing.JTextField txtUser;
    private javax.swing.JTextField txtUserListFilterValue;
    private javax.swing.JTextField txtValidThru;
    private javax.swing.JTextField txtYear;
    // End of variables declaration//GEN-END:variables
}
