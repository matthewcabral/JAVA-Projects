/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactModule;

import java.awt.KeyboardFocusManager;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowListener;
import java.util.Collections;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Matheus Cabral Rosa
 */
public class ContactScreen extends javax.swing.JFrame {

    /**
     * Creates new form ContactManagement
     */
    public ContactScreen() {
        initComponents();
    }
    
    // Listeners
    public void setListenerBtnEdit(ActionListener listener) { this.btnEdit.addActionListener(listener); }
    public void setListenerBtnNew(ActionListener listener) { this.btnNew.addActionListener(listener); }
    public void setListenerBtnSave(ActionListener listener) { this.btnSave.addActionListener(listener); }
    public void setListenerBtnCancel(ActionListener listener) { this.btnCancel.addActionListener(listener); }
    public void setListenerBtnDelete(ActionListener listener) { this.btnDelete.addActionListener(listener); }
    public void setListenerBtnAddSocialMedia(ActionListener listener) { this.btnAddSocialMedia.addActionListener(listener); }
    public void setListenerContactManagementScreen(WindowListener listener) { this.addWindowListener(listener); }
    
    // Table
    public DefaultTableModel getTableModel(){ return (DefaultTableModel) tblContactList.getModel(); }
    public void setListenerTblContactListSelection(ListSelectionListener listener) { this.tblContactList.getSelectionModel().addListSelectionListener(listener); }
    public String getSelectedRowIdContactList() { try { return (String) this.tblContactList.getValueAt(this.tblContactList.getSelectedRow(), 0); } catch (Exception e) { return ""; } }
    public void setSelectedRowColumnList(int row, int column){ this.tblContactList.changeSelection(row, column, false, false); }
    public int getSelectedRowList() { return this.tblContactList.getSelectedRow(); }
    public int getNumOfListRows() { return this.tblContactList.getRowCount(); }
    
    // Component Setters
    public void settxtContactListFilterValue(String value) { this.txtContactListFilterValue.setText(value); this.txtContactListFilterValue.paintImmediately(this.txtContactListFilterValue.getVisibleRect()); }
    public void settxtRowId(String value) { this.txtRowId.setText(value); this.txtRowId.paintImmediately(this.txtRowId.getVisibleRect()); }
    public void settxtDocNum(String value) { this.txtDocNum.setText(value); this.txtDocNum.paintImmediately(this.txtDocNum.getVisibleRect()); }
    public void settxtName(String value) { this.txtName.setText(value); this.txtName.paintImmediately(this.txtName.getVisibleRect()); }
    public void settxtSurname(String value) { this.txtSurname.setText(value); this.txtSurname.paintImmediately(this.txtSurname.getVisibleRect()); }
    public void settxtNickName(String value) { this.txtNickName.setText(value); this.txtNickName.paintImmediately(this.txtNickName.getVisibleRect()); }
    public void settxtYear(String value) { this.txtYear.setText(value); this.txtYear.paintImmediately(this.txtYear.getVisibleRect()); }
    public void settxtBornLocation(String value) { this.txtBornLocation.setText(value); this.txtBornLocation.paintImmediately(this.txtBornLocation.getVisibleRect()); }
    public void settxtSpouseName(String value) { this.txtSpouseName.setText(value); this.txtSpouseName.paintImmediately(this.txtSpouseName.getVisibleRect()); }
    public void settxtMotherName(String value) { this.txtMotherName.setText(value); this.txtMotherName.paintImmediately(this.txtMotherName.getVisibleRect()); }
    public void settxtFatherName(String value) { this.txtFatherName.setText(value); this.txtFatherName.paintImmediately(this.txtFatherName.getVisibleRect()); }
    public void settxtContactMPhone(String value) { this.txtContactMPhone.setText(value); this.txtContactMPhone.paintImmediately(this.txtContactMPhone.getVisibleRect()); }
    public void settxtContactEmail(String value) { this.txtContactEmail.setText(value); this.txtContactEmail.paintImmediately(this.txtContactEmail.getVisibleRect()); }
    public void settxtContactPhone(String value) { this.txtContactPhone.setText(value); this.txtContactPhone.paintImmediately(this.txtContactPhone.getVisibleRect()); }
    public void settxtContactEnterprise(String value) { this.txtContactEnterprise.setText(value); this.txtContactEnterprise.paintImmediately(this.txtContactEnterprise.getVisibleRect()); }
    public void settxtFacebook(String value) { this.txtFacebook.setText(value); this.txtFacebook.paintImmediately(this.txtFacebook.getVisibleRect()); }
    public void settxtInstagram(String value) { this.txtInstagram.setText(value); this.txtInstagram.paintImmediately(this.txtInstagram.getVisibleRect()); }
    public void settxtTwitter(String value) { this.txtTwitter.setText(value); this.txtTwitter.paintImmediately(this.txtTwitter.getVisibleRect()); }
    
    public void setcbbContactListFilter(String value) { this.cbbContactListFilter.addItem(value); this.cbbContactListFilter.paintImmediately(this.cbbContactListFilter.getVisibleRect()); }
    public void setcbbCivilState(String value) { this.cbbCivilState.addItem(value); this.cbbCivilState.paintImmediately(this.cbbCivilState.getVisibleRect()); }
    public void setcbbDay(String value) { this.cbbDay.addItem(value); this.cbbDay.paintImmediately(this.cbbDay.getVisibleRect()); }
    public void setcbbDocType(String value) { this.cbbDocType.addItem(value); this.cbbDocType.paintImmediately(this.cbbDocType.getVisibleRect()); }
    public void setcbbMonth(String value) { this.cbbMonth.addItem(value); this.cbbMonth.paintImmediately(this.cbbMonth.getVisibleRect()); }
    public void setcbbSex(String value) { this.cbbSex.addItem(value); this.cbbSex.paintImmediately(this.cbbSex.getVisibleRect()); }
    public void setcbbContactEmailType(String value) { this.cbbContactEmailType.addItem(value); this.cbbContactEmailType.paintImmediately(this.cbbContactEmailType.getVisibleRect()); }

    public void setckbMainConFlg(String value) { if("Y".equals(value)) { this.ckbMainConFlg.setSelected(true); } else { this.ckbMainConFlg.setSelected(false); } this.ckbMainConFlg.paintImmediately(this.ckbMainConFlg.getVisibleRect()); }
    public void setckbAllowCallFlg(String value) { if("Y".equals(value)) { this.ckbAllowCallFlg.setSelected(true); } else { this.ckbAllowCallFlg.setSelected(false); } this.ckbAllowCallFlg.paintImmediately(this.ckbAllowCallFlg.getVisibleRect()); }
    public void setckbAllowEmailFlg(String value) { if("Y".equals(value)) { this.ckbAllowEmailFlg.setSelected(true); } else { this.ckbAllowEmailFlg.setSelected(false); } this.ckbAllowEmailFlg.paintImmediately(this.ckbAllowEmailFlg.getVisibleRect()); }
    public void setckbSendNewsFlg(String value) { if("Y".equals(value)) { this.ckbSendNewsFlg.setSelected(true); } else { this.ckbSendNewsFlg.setSelected(false); } this.ckbSendNewsFlg.paintImmediately(this.ckbSendNewsFlg.getVisibleRect()); }
    public void setckbSendPromFlg(String value) { if("Y".equals(value)) { this.ckbSendPromFlg.setSelected(true); } else { this.ckbSendPromFlg.setSelected(false); } this.ckbSendPromFlg.paintImmediately(this.ckbSendPromFlg.getVisibleRect()); }
    public void setckbWhatsAppFlg(String value) { if("Y".equals(value)) { this.ckbWhatsAppFlg.setSelected(true); } else { this.ckbWhatsAppFlg.setSelected(false); } this.ckbWhatsAppFlg.paintImmediately(this.ckbWhatsAppFlg.getVisibleRect()); }
    
    public void setlblRecCount(String value) { this.lblRecCount.setText("Registros: " + value); this.lblRecCount.paintImmediately(this.lblRecCount.getVisibleRect()); }
    public void setlblContactNameHeader(String value) { this.lblContactNameHeader.setText(value); this.lblContactNameHeader.paintImmediately(this.lblContactNameHeader.getVisibleRect()); }
    
    // ComboBox Specific Setters
    public void setcbbContactListFilterItemIndex(int value) { this.cbbContactListFilter.setSelectedIndex(value); }
    public void setcbbCivilStateItemIndex(int value) { this.cbbCivilState.setSelectedIndex(value); }
    public void setcbbDayItemIndex(int value) { this.cbbDay.setSelectedIndex(value); }
    public void setcbbDocTypeItemIndex(int value) { this.cbbDocType.setSelectedIndex(value); }
    public void setcbbContactEmailTypeItemIndex(int value) { this.cbbContactEmailType.setSelectedIndex(value); }
    //public void setcbbIdentityTypeItemIndex(int value) { this.cbbIdentityType.setSelectedIndex(value); }
    public void setcbbMonthItemIndex(int value) { this.cbbMonth.setSelectedIndex(value); }
    //public void setcbbPositionItemIndex(int value) { this.cbbPosition.setSelectedIndex(value); }
    public void setcbbSexItemIndex(int value) { this.cbbSex.setSelectedIndex(value); }
    
    // Component Getters
    public String gettxtRowId() { if(!"".equals(this.txtRowId.getText()) && this.txtRowId.getText() != null) { return this.txtRowId.getText(); } else { return null; } }
    public String gettxtDocNum() { if(!"".equals(this.txtDocNum.getText()) && this.txtDocNum.getText() != null) { return this.txtDocNum.getText(); } else { return null; } }
    public String gettxtName() { if(!"".equals(this.txtName.getText()) && this.txtName.getText() != null) { return this.txtName.getText(); } else { return null; } }
    public String gettxtSurname() { if(!"".equals(this.txtSurname.getText()) && this.txtSurname.getText() != null) { return this.txtSurname.getText(); } else { return null; } }
    public String gettxtNickName() { if(!"".equals(this.txtNickName.getText()) && this.txtNickName.getText() != null) { return this.txtNickName.getText(); } else { return null; } }
    public String gettxtYear() { if(!"".equals(this.txtYear.getText()) && this.txtYear.getText() != null) { return this.txtYear.getText(); } else { return null; } }
    public String gettxtBornLocation() { if(!"".equals(this.txtBornLocation.getText()) && this.txtBornLocation.getText() != null) { return this.txtBornLocation.getText(); } else { return null; } }
    public String gettxtSpouseName() { if(!"".equals(this.txtSpouseName.getText()) && this.txtSpouseName.getText() != null) { return this.txtSpouseName.getText(); } else { return null; } }
    public String gettxtMotherName() { if(!"".equals(this.txtMotherName.getText()) && this.txtMotherName.getText() != null) { return this.txtMotherName.getText(); } else { return null; } }
    public String gettxtFatherName() { if(!"".equals(this.txtFatherName.getText()) && this.txtFatherName.getText() != null) { return this.txtFatherName.getText(); } else { return null; } }
    public String gettxtContactListFilterValue() { if(!"".equals(this.txtContactListFilterValue.getText()) && this.txtContactListFilterValue.getText() != null) { return this.txtContactListFilterValue.getText(); } else { return null; } }
    public String gettxtContactMPhone() { if(!"".equals(this.txtContactMPhone.getText()) && this.txtContactMPhone.getText() != null) { return this.txtContactMPhone.getText(); } else { return null; } }
    public String gettxtContactEmail() { if(!"".equals(this.txtContactEmail.getText()) && this.txtContactEmail.getText() != null) { return this.txtContactEmail.getText(); } else { return null; } }
    public String gettxtContactPhone() { if(!"".equals(this.txtContactPhone.getText()) && this.txtContactPhone.getText() != null) { return this.txtContactPhone.getText(); } else { return null; } }
    public String gettxtContactEnterprise() { if(!"".equals(this.txtContactEnterprise.getText()) && this.txtContactEnterprise.getText() != null) { return this.txtContactEnterprise.getText(); } else { return null; } }
    public String gettxtFacebook() { if(!"".equals(this.txtFacebook.getText()) && this.txtFacebook.getText() != null) { return this.txtFacebook.getText(); } else { return null; } }
    public String gettxtInstagram() { if(!"".equals(this.txtInstagram.getText()) && this.txtInstagram.getText() != null) { return this.txtInstagram.getText(); } else { return null; } }
    public String gettxtTwitter() { if(!"".equals(this.txtTwitter.getText()) && this.txtTwitter.getText() != null) { return this.txtTwitter.getText(); } else { return null; } }    
    
    public String getcbbContactListFilter() { if(!"".equals(this.cbbContactListFilter.getSelectedItem().toString()) && !"Selecione...".equals(this.cbbContactListFilter.getSelectedItem().toString()) && this.cbbContactListFilter.getSelectedItem().toString() != null) { return this.cbbContactListFilter.getSelectedItem().toString(); } else { return null; } }
    public String getcbbCivilState() { if(!"".equals(this.cbbCivilState.getSelectedItem().toString()) && !"Selecione...".equals(this.cbbCivilState.getSelectedItem().toString()) && this.cbbCivilState.getSelectedItem().toString() != null) { return this.cbbCivilState.getSelectedItem().toString(); } else { return null; } }
    public String getcbbDay() { if(!"".equals(this.cbbDay.getSelectedItem().toString()) && !"Selecione...".equals(this.cbbDay.getSelectedItem().toString()) && this.cbbDay.getSelectedItem().toString() != null) { return this.cbbDay.getSelectedItem().toString(); } else { return null; } }
    public String getcbbDocType() { if(!"".equals(this.cbbDocType.getSelectedItem().toString()) && !"Selecione...".equals(this.cbbDocType.getSelectedItem().toString()) && this.cbbDocType.getSelectedItem().toString() != null) { return this.cbbDocType.getSelectedItem().toString(); } else { return null; } }
    public String getcbbMonth() { if(!"".equals(this.cbbMonth.getSelectedItem().toString()) && !"Selecione...".equals(this.cbbMonth.getSelectedItem().toString()) && this.cbbMonth.getSelectedItem().toString() != null) { return this.cbbMonth.getSelectedItem().toString(); } else { return null; } }
    public String getcbbSex() { if(!"".equals(this.cbbSex.getSelectedItem().toString()) && !"Selecione...".equals(this.cbbSex.getSelectedItem().toString()) && this.cbbSex.getSelectedItem().toString() != null) { return this.cbbSex.getSelectedItem().toString(); } else { return null; } }
    public String getcbbContactEmailType() { if(!"".equals(this.cbbContactEmailType.getSelectedItem().toString()) && !"Selecione...".equals(this.cbbContactEmailType.getSelectedItem().toString()) && this.cbbContactEmailType.getSelectedItem().toString() != null) { return this.cbbContactEmailType.getSelectedItem().toString(); } else { return null; } }

    public String getckbMainConFlg() { if(this.ckbMainConFlg.isSelected()) { return "Y"; } else { return "N"; } }
    public String getckbAllowCallFlg() { if(this.ckbAllowCallFlg.isSelected()) { return "Y"; } else { return "N"; } }
    public String getckbAllowEmailFlg() { if(this.ckbAllowEmailFlg.isSelected()) { return "Y"; } else { return "N"; } }
    public String getckbSendNewsFlg() { if(this.ckbSendNewsFlg.isSelected()) { return "Y"; } else { return "N"; } }
    public String getckbSendPromFlg() { if(this.ckbSendPromFlg.isSelected()) { return "Y"; } else { return "N"; } }
    public String getckbWhatsAppFlg() { if(this.ckbWhatsAppFlg.isSelected()) { return "Y"; } else { return "N"; } }
    
    public String getlblRecCount() { return this.lblRecCount.getText(); }
    public String getlblContactNameHeader() { return this.lblContactNameHeader.getText(); }

    // ComboBox Specific Getters
    public int getcbbUserListFilterItemIndex(String value) { if(!"".equals(value) && value != null) { for(int i = 0; i < this.cbbContactListFilter.getItemCount(); i++){ if(value.equals(this.cbbContactListFilter.getItemAt(i))){ return i; }}} else { return 0; } return 0; }
    public int getcbbCivilStateItemIndex(String value) { if(!"".equals(value) && value != null) { for(int i = 0; i < this.cbbCivilState.getItemCount(); i++){ if(value.equals(this.cbbCivilState.getItemAt(i))){ return i; }}} else { return 0; } return 0; }
    public int getcbbDayItemIndex(String value) { if(!"".equals(value) && value != null) { for(int i = 0; i < this.cbbDay.getItemCount(); i++){ if(value.equals(this.cbbDay.getItemAt(i))){ return i; }}} else { return 0; } return 0; }
    public int getcbbDocTypeItemIndex(String value) { if(!"".equals(value) && value != null) { for(int i = 0; i < this.cbbDocType.getItemCount(); i++){ if(value.equals(this.cbbDocType.getItemAt(i))){ return i; }}} else { return 0; } return 0; }
    //public int getcbbEmissionUFItemIndex(String value) { if(!"".equals(value) && value != null) { for(int i = 0; i < this.cbbEmissionUF.getItemCount(); i++){ if(value.equals(this.cbbEmissionUF.getItemAt(i))){ return i; }}} else { return 0; } return 0; }
    public int getcbbContactEmailTypeItemIndex(String value) { if(!"".equals(value) && value != null) { for(int i = 0; i < this.cbbContactEmailType.getItemCount(); i++){ if(value.equals(this.cbbContactEmailType.getItemAt(i))){ return i; }}} else { return 0; } return 0; }
    public int getcbbMonthItemIndex(String value) { if(!"".equals(value) && value != null) { for(int i = 0; i < this.cbbMonth.getItemCount(); i++) { if(value.equals(this.cbbMonth.getItemAt(i))) { return i; }}} else { return 0; } return 0; }
    //public int getcbbPositionItemIndex(String value) { if(!"".equals(value) && value != null) { for(int i = 0; i < this.cbbPosition.getItemCount(); i++){ if(value.equals(this.cbbPosition.getItemAt(i))){ return i; }}} else { return 0; } return 0; }
    public int getcbbSexItemIndex(String value) { if(!"".equals(value) && value != null) { for(int i = 0; i < this.cbbSex.getItemCount(); i++){ if(value.equals(this.cbbSex.getItemAt(i))){ return i; }}} else { return 0; } return 0; }
    
    
    // Component Clear
    public void cleartxtContactListFilterValue() { this.txtContactListFilterValue.setText(""); this.txtContactListFilterValue.paintImmediately(this.txtContactListFilterValue.getVisibleRect()); }
    public void cleartxtRowId() { this.txtRowId.setText(""); this.txtRowId.paintImmediately(this.txtRowId.getVisibleRect()); }
    public void cleartxtDocNum() { this.txtDocNum.setText(""); this.txtDocNum.paintImmediately(this.txtDocNum.getVisibleRect()); }
    public void cleartxtName() { this.txtName.setText(""); this.txtName.paintImmediately(this.txtName.getVisibleRect()); }
    public void cleartxtSurname() { this.txtSurname.setText(""); this.txtSurname.paintImmediately(this.txtSurname.getVisibleRect()); }
    public void cleartxtNickName() { this.txtNickName.setText(""); this.txtNickName.paintImmediately(this.txtNickName.getVisibleRect()); }
    public void cleartxtYear() { this.txtYear.setText(""); this.txtYear.paintImmediately(this.txtYear.getVisibleRect()); }
    public void cleartxtBornLocation() { this.txtBornLocation.setText(""); this.txtBornLocation.paintImmediately(this.txtBornLocation.getVisibleRect()); }
    public void cleartxtSpouseName() { this.txtSpouseName.setText(""); this.txtSpouseName.paintImmediately(this.txtSpouseName.getVisibleRect()); }
    public void cleartxtMotherName() { this.txtMotherName.setText(""); this.txtMotherName.paintImmediately(this.txtMotherName.getVisibleRect()); }
    public void cleartxtFatherName() { this.txtFatherName.setText(""); this.txtFatherName.paintImmediately(this.txtFatherName.getVisibleRect()); }
    public void cleartxtContactMPhone() { this.txtContactMPhone.setText(""); this.txtContactMPhone.paintImmediately(this.txtContactMPhone.getVisibleRect()); }
    public void cleartxtContactEmail() { this.txtContactEmail.setText(""); this.txtContactEmail.paintImmediately(this.txtContactEmail.getVisibleRect()); }
    public void cleartxtContactPhone() { this.txtContactPhone.setText(""); this.txtContactPhone.paintImmediately(this.txtContactPhone.getVisibleRect()); }
    public void cleartxtContactEnterprise() { this.txtContactEnterprise.setText(""); this.txtContactEnterprise.paintImmediately(this.txtContactEnterprise.getVisibleRect()); }
    public void cleartxtFacebook() { this.txtFacebook.setText(""); this.txtFacebook.paintImmediately(this.txtFacebook.getVisibleRect()); }
    public void cleartxtInstagram() { this.txtInstagram.setText(""); this.txtInstagram.paintImmediately(this.txtInstagram.getVisibleRect()); }
    public void cleartxtTwitter() { this.txtTwitter.setText(""); this.txtTwitter.paintImmediately(this.txtTwitter.getVisibleRect()); }    
    
    public void clearcbbContactListFilter() { this.cbbContactListFilter.removeAllItems(); this.cbbContactListFilter.paintImmediately(this.cbbContactListFilter.getVisibleRect()); }
    public void clearcbbCivilState() { this.cbbCivilState.removeAllItems(); this.cbbCivilState.paintImmediately(this.cbbCivilState.getVisibleRect()); }
    public void clearcbbDay() { this.cbbDay.removeAllItems(); this.cbbDay.paintImmediately(this.cbbDay.getVisibleRect()); }
    public void clearcbbDocType() { this.cbbDocType.removeAllItems(); this.cbbDocType.paintImmediately(this.cbbDocType.getVisibleRect()); }
    public void clearcbbMonth() { this.cbbMonth.removeAllItems(); this.cbbMonth.paintImmediately(this.cbbMonth.getVisibleRect()); }
    public void clearcbbSex() { this.cbbSex.removeAllItems(); this.cbbSex.paintImmediately(this.cbbSex.getVisibleRect()); }
    public void clearcbbContactEmailType() { this.cbbContactEmailType.removeAllItems(); this.cbbContactEmailType.paintImmediately(this.cbbContactEmailType.getVisibleRect()); }

    public void clearckbMainConFlg() { this.ckbMainConFlg.setSelected(false); this.ckbMainConFlg.paintImmediately(this.ckbMainConFlg.getVisibleRect()); }
    public void clearckbAllowCallFlg() { this.ckbAllowCallFlg.setSelected(false); this.ckbAllowCallFlg.paintImmediately(this.ckbAllowCallFlg.getVisibleRect()); }
    public void clearckbAllowEmailFlg() { this.ckbAllowEmailFlg.setSelected(false); this.ckbAllowEmailFlg.paintImmediately(this.ckbAllowEmailFlg.getVisibleRect()); }
    public void clearckbSendNewsFlg() { this.ckbSendNewsFlg.setSelected(false); this.ckbSendNewsFlg.paintImmediately(this.ckbSendNewsFlg.getVisibleRect()); }
    public void clearckbSendPromFlg() { this.ckbSendPromFlg.setSelected(false); this.ckbSendPromFlg.paintImmediately(this.ckbSendPromFlg.getVisibleRect()); }
    public void clearckbWhatsAppFlg() { this.ckbWhatsAppFlg.setSelected(false); this.ckbWhatsAppFlg.paintImmediately(this.ckbWhatsAppFlg.getVisibleRect()); }
    
    public void clearlblRecCount() { this.lblRecCount.setText(""); this.lblRecCount.paintImmediately(this.lblRecCount.getVisibleRect()); }
    public void clearlblContactNameHeader() { this.lblContactNameHeader.setText(""); this.lblContactNameHeader.paintImmediately(this.lblContactNameHeader.getVisibleRect()); }

    // Enable or Disable Components
    public void settxtContactListFilterValueEnabled(boolean status) { this.txtContactListFilterValue.setEnabled(status); }
    public void settxtRowIdEnabled(boolean status) { this.txtRowId.setEnabled(status); }
    public void settxtDocNumEnabled(boolean status) { this.txtDocNum.setEnabled(status); }
    public void settxtNameEnabled(boolean status) { this.txtName.setEnabled(status); }
    public void settxtSurnameEnabled(boolean status) { this.txtSurname.setEnabled(status); }
    public void settxtNickNameEnabled(boolean status) { this.txtNickName.setEnabled(status); }
    public void settxtYearEnabled(boolean status) { this.txtYear.setEnabled(status); }
    public void settxtBornLocationEnabled(boolean status) { this.txtBornLocation.setEnabled(status); }
    public void settxtSpouseNameEnabled(boolean status) { this.txtSpouseName.setEnabled(status); }
    public void settxtMotherNameEnabled(boolean status) { this.txtMotherName.setEnabled(status); }
    public void settxtFatherNameEnabled(boolean status) { this.txtFatherName.setEnabled(status); }
    public void settxtContactMPhoneEnabled(boolean status) { this.txtContactMPhone.setEnabled(status); }
    public void settxtContactEmailEnabled(boolean status) { this.txtContactEmail.setEnabled(status); }
    public void settxtContactPhoneEnabled(boolean status) { this.txtContactPhone.setEnabled(status); }
    public void settxtContactEnterpriseEnabled(boolean status) { this.txtContactEnterprise.setEnabled(status); }
    public void settxtFacebookEnabled(boolean status) { this.txtFacebook.setEnabled(status); }
    public void settxtInstagramEnabled(boolean status) { this.txtInstagram.setEnabled(status); }
    public void settxtTwitterEnabled(boolean status) { this.txtTwitter.setEnabled(status); }    
    
    public void setcbbContactListFilterEnabled(boolean status) { this.cbbContactListFilter.setEnabled(status); }
    public void setcbbCivilStateEnabled(boolean status) { this.cbbCivilState.setEnabled(status); }
    public void setcbbDayEnabled(boolean status) { this.cbbDay.setEnabled(status); }
    public void setcbbDocTypeEnabled(boolean status) { this.cbbDocType.setEnabled(status); }
    public void setcbbMonthEnabled(boolean status) { this.cbbMonth.setEnabled(status); }
    public void setcbbSexEnabled(boolean status) { this.cbbSex.setEnabled(status); }
    public void setcbbContactEmailTypeEnabled(boolean status) { this.cbbContactEmailType.setEnabled(status); }

    public void setckbMainConFlgEnabled(boolean status) { this.ckbMainConFlg.setEnabled(status); }
    public void setckbAllowCallFlgEnabled(boolean status) { this.ckbAllowCallFlg.setEnabled(status); }
    public void setckbAllowEmailFlgEnabled(boolean status) { this.ckbAllowEmailFlg.setEnabled(status); }
    public void setckbSendNewsFlgEnabled(boolean status) { this.ckbSendNewsFlg.setEnabled(status); }
    public void setckbSendPromFlgEnabled(boolean status) { this.ckbSendPromFlg.setEnabled(status); }
    public void setckbWhatsAppFlgEnabled(boolean status) { this.ckbWhatsAppFlg.setEnabled(status); }
    
    public void setlblRecCountEnabled(boolean status) { this.lblRecCount.setEnabled(status); }
    public void setlblContactNameHeaderEnabled(boolean status) { this.lblContactNameHeader.setEnabled(status); }
    
    public void setTblEnabled(boolean status) { this.tblContactList.setEnabled(status); }
    
    public void setbtnEditEnabled(boolean status) { this.btnEdit.setEnabled(status); }
    public void setbtnNewEnabled(boolean status) { this.btnNew.setEnabled(status); }
    public void setbtnSaveEnabled(boolean status) { this.btnSave.setEnabled(status); }
    public void setbtnCancelEnabled(boolean status) { this.btnCancel.setEnabled(status); }
    public void setbtnDeleteEnabled(boolean status) { this.btnDelete.setEnabled(status); }
    public void setbtnAddSocialMediaEnabled(boolean status) { this.btnAddSocialMedia.setEnabled(status); }

    // Return componet status
    public boolean istxtContactListFilterValueEnabled() { return this.txtContactListFilterValue.isEnabled(); }
    public boolean istxtRowIdEnabled() { return this.txtRowId.isEnabled(); }
    public boolean istxtDocNumEnabled() { return this.txtDocNum.isEnabled(); }
    public boolean istxtNameEnabled() { return this.txtName.isEnabled(); }
    public boolean istxtSurnameEnabled() { return this.txtSurname.isEnabled(); }
    public boolean istxtNickNameEnabled() { return this.txtNickName.isEnabled(); }
    public boolean istxtYearEnabled() { return this.txtYear.isEnabled(); }
    public boolean istxtBornLocationEnabled() { return this.txtBornLocation.isEnabled(); }
    public boolean istxtSpouseNameEnabled() { return this.txtSpouseName.isEnabled(); }
    public boolean istxtMotherNameEnabled() { return this.txtMotherName.isEnabled(); }
    public boolean istxtFatherNameEnabled() { return this.txtFatherName.isEnabled(); }
    public boolean istxtContactMPhoneEnabled() { return this.txtContactMPhone.isEnabled(); }
    public boolean istxtContactEmailEnabled() { return this.txtContactEmail.isEnabled(); }
    public boolean istxtContactPhoneEnabled() { return this.txtContactPhone.isEnabled(); }
    public boolean istxtContactEnterpriseEnabled() { return this.txtContactEnterprise.isEnabled(); }
    public boolean istxtFacebookEnabled() { return this.txtFacebook.isEnabled(); }
    public boolean istxtInstagramEnabled() { return this.txtInstagram.isEnabled(); }
    public boolean istxtTwitterEnabled() { return this.txtTwitter.isEnabled(); }    
    
    public boolean iscbbContactListFilterEnabled() { return this.cbbContactListFilter.isEnabled(); }
    public boolean iscbbCivilStateEnabled() { return this.cbbCivilState.isEnabled(); }
    public boolean iscbbDayEnabled() { return this.cbbDay.isEnabled(); }
    public boolean iscbbDocTypeEnabled() { return this.cbbDocType.isEnabled(); }
    public boolean iscbbMonthEnabled() { return this.cbbMonth.isEnabled(); }
    public boolean iscbbSexEnabled() { return this.cbbSex.isEnabled(); }
    public boolean iscbbContactEmailTypeEnabled() { return this.cbbContactEmailType.isEnabled(); }

    public boolean isckbMainConFlgEnabled() { return this.ckbMainConFlg.isEnabled(); }
    public boolean isckbAllowCallFlgEnabled() { return this.ckbAllowCallFlg.isEnabled(); }
    public boolean isckbAllowEmailFlgEnabled() { return this.ckbAllowEmailFlg.isEnabled(); }
    public boolean isckbSendNewsFlgEnabled() { return this.ckbSendNewsFlg.isEnabled(); }
    public boolean isckbSendPromFlgEnabled() { return this.ckbSendPromFlg.isEnabled(); }
    public boolean isckbWhatsAppFlgEnabled() { return this.ckbWhatsAppFlg.isEnabled(); }
    
    public boolean islblRecCountEnabled() { return this.lblRecCount.isEnabled(); }
    public boolean islblContactNameHeaderEnabled() { return this.lblContactNameHeader.isEnabled(); }
    
    public boolean isbtnEditEnabled() { return this.btnEdit.isEnabled(); }
    public boolean isbtnNewEnabled() { return this.btnNew.isEnabled(); }
    public boolean isbtnSaveEnabled() { return this.btnSave.isEnabled(); }
    public boolean isbtnCancelEnabled() { return this.btnCancel.isEnabled(); }
    public boolean isbtnDeleteEnabled() { return this.btnDelete.isEnabled(); }
    public boolean isbtnAddSocialMediaEnabled() { return this.btnAddSocialMedia.isEnabled(); }
    
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
            this.txtContactListFilterValue.requestFocus();
            break;
        case "ID":
            this.txtRowId.requestFocus();
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
        case "FILTRO":
            this.cbbContactListFilter.requestFocus();
            break;
        case "ESTADO_CIVIL":
            this.cbbCivilState.requestFocus();
            break;
        case "CONTATO_CELULAR":
            this.txtContactMPhone.requestFocus();
            break;
        case "CONTATO_EMAIL":
            this.txtContactEmail.requestFocus();
            break;
	case "CONTATO_EMAIL_TIPO":
            this.cbbContactEmailType.requestFocus();
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
        case "BOTAO_ADD_REDE_SOCIAL":
            this.btnAddSocialMedia.requestFocus();
            break;
        case "CONTATO_PRINCIPAL_FLG":
            this.ckbMainConFlg.requestFocus();
            break;
	case "WHATSAPP_FLG":
            this.ckbWhatsAppFlg.requestFocus();
            break;
	case "PERMITE_NOVIDADES_FLG":
            this.ckbSendNewsFlg.requestFocus();
            break;
	case "PERMITE_EMAIL_FLG":
            this.ckbAllowEmailFlg.requestFocus();
            break;
	case "PERMITE_ENV_PROMO_FLG":
            this.ckbSendPromFlg.requestFocus();
            break;
	case "PERMITE_LIGACAO_FLG":
            this.ckbAllowCallFlg.requestFocus();
            break;
        default:
            break;
        }
    }
    
    public void enableFields(String funcao) {
        switch (funcao){
            case "LOAD_SCREEN":
                settxtContactListFilterValueEnabled(true);
                settxtRowIdEnabled(false);
                settxtDocNumEnabled(false);
                settxtNameEnabled(false);
                settxtSurnameEnabled(false);
                settxtNickNameEnabled(false);
                settxtYearEnabled(false);
                settxtBornLocationEnabled(false);
                settxtSpouseNameEnabled(false);
                settxtMotherNameEnabled(false);
                settxtFatherNameEnabled(false);
                settxtContactMPhoneEnabled(false);
                settxtContactEmailEnabled(false);
                settxtContactPhoneEnabled(false);
                settxtContactEnterpriseEnabled(false);
                settxtFacebookEnabled(false);
                settxtInstagramEnabled(false);
                settxtTwitterEnabled(false);                

                setcbbContactListFilterEnabled(true);
                setcbbCivilStateEnabled(false);
                setcbbDayEnabled(false);
                setcbbDocTypeEnabled(false);
                setcbbMonthEnabled(false);
                setcbbSexEnabled(false);
                setcbbContactEmailTypeEnabled(false);

                setckbMainConFlgEnabled(false);
                setckbAllowCallFlgEnabled(false);
                setckbAllowEmailFlgEnabled(false);
                setckbSendNewsFlgEnabled(false);
                setckbSendPromFlgEnabled(false);
                setckbWhatsAppFlgEnabled(false);

                setTblEnabled(true);
                
                setbtnEditEnabled(false);
                setbtnDeleteEnabled(false);
                setbtnNewEnabled(true);                
                setbtnSaveEnabled(false);
                setbtnCancelEnabled(false);
                setbtnAddSocialMediaEnabled(false);
                break;
            case "NOVO":
                settxtContactListFilterValueEnabled(true);
                settxtRowIdEnabled(false);
                settxtDocNumEnabled(false);
                settxtNameEnabled(false);
                settxtSurnameEnabled(false);
                settxtNickNameEnabled(false);
                settxtYearEnabled(false);
                settxtBornLocationEnabled(false);
                settxtSpouseNameEnabled(false);
                settxtMotherNameEnabled(false);
                settxtFatherNameEnabled(false);
                settxtContactMPhoneEnabled(true);
                settxtContactEmailEnabled(true);
                settxtContactPhoneEnabled(true);
                settxtContactEnterpriseEnabled(true);
                settxtFacebookEnabled(false);
                settxtInstagramEnabled(false);
                settxtTwitterEnabled(false);

                setcbbContactListFilterEnabled(true);
                setcbbCivilStateEnabled(false);
                setcbbDayEnabled(false);
                setcbbDocTypeEnabled(false);
                setcbbMonthEnabled(false);
                setcbbSexEnabled(false);
                setcbbContactEmailTypeEnabled(true);

                setckbMainConFlgEnabled(true);
                setckbAllowCallFlgEnabled(true);
                setckbAllowEmailFlgEnabled(true);
                setckbSendNewsFlgEnabled(true);
                setckbSendPromFlgEnabled(true);
                setckbWhatsAppFlgEnabled(true);

                setTblEnabled(false);
                
                setbtnEditEnabled(false);
                setbtnDeleteEnabled(false);
                setbtnNewEnabled(false);
                setbtnSaveEnabled(true);
                setbtnCancelEnabled(true);
                setbtnAddSocialMediaEnabled(true);
                break;
            case "EDITAR":
                settxtContactListFilterValueEnabled(true);
                settxtRowIdEnabled(false);
                settxtDocNumEnabled(false);
                settxtNameEnabled(false);
                settxtSurnameEnabled(false);
                settxtNickNameEnabled(false);
                settxtYearEnabled(false);
                settxtBornLocationEnabled(false);
                settxtSpouseNameEnabled(false);
                settxtMotherNameEnabled(false);
                settxtFatherNameEnabled(false);
                settxtContactMPhoneEnabled(true);
                settxtContactEmailEnabled(true);
                settxtContactPhoneEnabled(true);
                settxtContactEnterpriseEnabled(true);
                settxtFacebookEnabled(false);
                settxtInstagramEnabled(false);
                settxtTwitterEnabled(false);

                setcbbContactListFilterEnabled(true);
                setcbbCivilStateEnabled(false);
                setcbbDayEnabled(false);
                setcbbDocTypeEnabled(false);
                setcbbMonthEnabled(false);
                setcbbSexEnabled(false);
                setcbbContactEmailTypeEnabled(true);

                setckbMainConFlgEnabled(true);
                setckbAllowCallFlgEnabled(true);
                setckbAllowEmailFlgEnabled(true);
                setckbSendNewsFlgEnabled(true);
                setckbSendPromFlgEnabled(true);
                setckbWhatsAppFlgEnabled(true);

                setTblEnabled(false);
                
                setbtnEditEnabled(false);
                setbtnDeleteEnabled(false);
                setbtnNewEnabled(false);
                setbtnSaveEnabled(true);
                setbtnCancelEnabled(true);
                setbtnAddSocialMediaEnabled(true);
                break;
            case "CANCELAR":
                settxtContactListFilterValueEnabled(true);
                settxtRowIdEnabled(false);
                settxtDocNumEnabled(false);
                settxtNameEnabled(false);
                settxtSurnameEnabled(false);
                settxtNickNameEnabled(false);
                settxtYearEnabled(false);
                settxtBornLocationEnabled(false);
                settxtSpouseNameEnabled(false);
                settxtMotherNameEnabled(false);
                settxtFatherNameEnabled(false);
                settxtContactMPhoneEnabled(false);
                settxtContactEmailEnabled(false);
                settxtContactPhoneEnabled(false);
                settxtContactEnterpriseEnabled(false);
                settxtFacebookEnabled(false);
                settxtInstagramEnabled(false);
                settxtTwitterEnabled(false);

                setcbbContactListFilterEnabled(true);
                setcbbCivilStateEnabled(false);
                setcbbDayEnabled(false);
                setcbbDocTypeEnabled(false);
                setcbbMonthEnabled(false);
                setcbbSexEnabled(false);
                setcbbContactEmailTypeEnabled(false);
                
                setckbMainConFlgEnabled(false);
                setckbAllowCallFlgEnabled(false);
                setckbAllowEmailFlgEnabled(false);
                setckbSendNewsFlgEnabled(false);
                setckbSendPromFlgEnabled(false);
                setckbWhatsAppFlgEnabled(false);

                setTblEnabled(true);
                
                setbtnEditEnabled(true);
                setbtnDeleteEnabled(true);
                setbtnNewEnabled(true);
                setbtnSaveEnabled(false);
                setbtnCancelEnabled(false);
                setbtnAddSocialMediaEnabled(false);
                break;
            case "DELETAR":
                settxtContactListFilterValueEnabled(true);
                settxtRowIdEnabled(false);
                settxtDocNumEnabled(false);
                settxtNameEnabled(false);
                settxtSurnameEnabled(false);
                settxtNickNameEnabled(false);
                settxtYearEnabled(false);
                settxtBornLocationEnabled(false);
                settxtSpouseNameEnabled(false);
                settxtMotherNameEnabled(false);
                settxtFatherNameEnabled(false);
                settxtContactMPhoneEnabled(false);
                settxtContactEmailEnabled(false);
                settxtContactPhoneEnabled(false);
                settxtContactEnterpriseEnabled(false);
                settxtFacebookEnabled(false);
                settxtInstagramEnabled(false);
                settxtTwitterEnabled(false);

                setcbbContactListFilterEnabled(true);
                setcbbCivilStateEnabled(false);
                setcbbDayEnabled(false);
                setcbbDocTypeEnabled(false);
                setcbbMonthEnabled(false);
                setcbbSexEnabled(false);
                setcbbContactEmailTypeEnabled(false);

                setckbMainConFlgEnabled(false);
                setckbAllowCallFlgEnabled(false);
                setckbAllowEmailFlgEnabled(false);
                setckbSendNewsFlgEnabled(false);
                setckbSendPromFlgEnabled(false);
                setckbWhatsAppFlgEnabled(false);

                setTblEnabled(true);
                
                setbtnEditEnabled(true);
                setbtnDeleteEnabled(true);
                setbtnNewEnabled(true);
                setbtnSaveEnabled(false);
                setbtnCancelEnabled(false);
                setbtnAddSocialMediaEnabled(false);
                break;
            case "SALVAR":
                settxtContactListFilterValueEnabled(true);
                settxtRowIdEnabled(false);
                settxtDocNumEnabled(false);
                settxtNameEnabled(false);
                settxtSurnameEnabled(false);
                settxtNickNameEnabled(false);
                settxtYearEnabled(false);
                settxtBornLocationEnabled(false);
                settxtSpouseNameEnabled(false);
                settxtMotherNameEnabled(false);
                settxtFatherNameEnabled(false);
                settxtContactMPhoneEnabled(false);
                settxtContactEmailEnabled(false);
                settxtContactPhoneEnabled(false);
                settxtContactEnterpriseEnabled(false);
                settxtFacebookEnabled(false);
                settxtInstagramEnabled(false);
                settxtTwitterEnabled(false);

                setcbbContactListFilterEnabled(true);
                setcbbCivilStateEnabled(false);
                setcbbDayEnabled(false);
                setcbbDocTypeEnabled(false);
                setcbbMonthEnabled(false);
                setcbbSexEnabled(false);
                setcbbContactEmailTypeEnabled(false);

                setckbMainConFlgEnabled(false);
                setckbAllowCallFlgEnabled(false);
                setckbAllowEmailFlgEnabled(false);
                setckbSendNewsFlgEnabled(false);
                setckbSendPromFlgEnabled(false);
                setckbWhatsAppFlgEnabled(false);

                setTblEnabled(true);
                
                setbtnEditEnabled(true);
                setbtnDeleteEnabled(true);
                setbtnNewEnabled(true);
                setbtnSaveEnabled(false);
                setbtnCancelEnabled(false);
                setbtnAddSocialMediaEnabled(false);
                break;
            default:
                break;
        }
    }

    public void clearFields() {
        cleartxtContactListFilterValue();
        cleartxtRowId();
        cleartxtDocNum();
        cleartxtName();
        cleartxtSurname();
        cleartxtNickName();
        cleartxtYear();
        cleartxtBornLocation();
        cleartxtSpouseName();
        cleartxtMotherName();
        cleartxtFatherName();
        cleartxtContactMPhone();
        cleartxtContactEmail();
        cleartxtContactPhone();
        cleartxtContactEnterprise();
        cleartxtFacebook();
        cleartxtInstagram();
        cleartxtTwitter();
        
        clearckbMainConFlg();
        clearckbAllowCallFlg();
        clearckbAllowEmailFlg();
        clearckbSendNewsFlg();
        clearckbSendPromFlg();
        clearckbWhatsAppFlg();
        
        setcbbCivilStateItemIndex(0);
        setcbbContactEmailTypeItemIndex(0);
        setcbbContactListFilterItemIndex(0);
        setcbbDayItemIndex(0);
        setcbbMonthItemIndex(0);
        setcbbDocTypeItemIndex(0);
        setcbbSexItemIndex(0);
                
        clearlblContactNameHeader();
    }
    
    public void clearComboBoxes(){
        clearcbbContactListFilter();
        clearcbbCivilState();
        clearcbbDay();
        clearcbbDocType();
        clearcbbMonth();
        clearcbbSex();
        clearcbbContactEmailType();
    }
    
    public void insertSelectComboBox(){
        this.setcbbContactListFilter("Selecione...");
        this.setcbbCivilState("Selecione...");
        this.setcbbDay("Selecione...");
        this.setcbbDocType("Selecione...");
        this.setcbbMonth("Selecione...");
        this.setcbbSex("Selecione...");
        this.setcbbContactEmailType("Selecione...");
    }
    
    public final void FocusTraversalKeys(){
        this.txtContactListFilterValue.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtRowId.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtDocNum.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtName.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtSurname.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtNickName.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtYear.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtBornLocation.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtSpouseName.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtMotherName.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtFatherName.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtContactEnterprise.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtContactEmail.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtContactPhone.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtContactMPhone.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtFacebook.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtInstagram.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtTwitter.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        
        this.cbbContactListFilter.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.cbbCivilState.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.cbbDay.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.cbbDocType.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.cbbMonth.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.cbbSex.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.cbbContactEmailType.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);

        this.ckbMainConFlg.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.ckbAllowCallFlg.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.ckbAllowEmailFlg.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.ckbSendNewsFlg.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.ckbSendPromFlg.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.ckbWhatsAppFlg.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
    
        this.lblRecCount.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.lblContactNameHeader.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelContact = new javax.swing.JPanel();
        PanelContactList = new javax.swing.JPanel();
        PanelContactListHeader = new javax.swing.JPanel();
        lblContactList = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblImage = new javax.swing.JLabel();
        cbbContactListFilter = new javax.swing.JComboBox<>();
        txtContactListFilterValue = new javax.swing.JTextField();
        lblInformation = new javax.swing.JLabel();
        lblRecCount = new javax.swing.JLabel();
        PanelListContact = new javax.swing.JPanel();
        sPanelUserList = new javax.swing.JScrollPane();
        tblContactList = new javax.swing.JTable();
        PanelContactForm = new javax.swing.JPanel();
        PanelContactFormHeader = new javax.swing.JPanel();
        lblContactNameHeader = new javax.swing.JLabel();
        lblContactFormInformation = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        btnEdit = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        sPanelContactForm = new javax.swing.JScrollPane();
        PanelFormContact = new javax.swing.JPanel();
        lblContactInformation = new javax.swing.JLabel();
        lblRowId = new javax.swing.JLabel();
        txtRowId = new javax.swing.JTextField();
        lblMainContFlg = new javax.swing.JLabel();
        ckbMainConFlg = new javax.swing.JCheckBox();
        lblWhatsAppFlg = new javax.swing.JLabel();
        ckbWhatsAppFlg = new javax.swing.JCheckBox();
        lblContactEmail = new javax.swing.JLabel();
        txtContactEmail = new javax.swing.JTextField();
        lblContactEmail1 = new javax.swing.JLabel();
        cbbContactEmailType = new javax.swing.JComboBox<>();
        lblSendNewsFlg = new javax.swing.JLabel();
        ckbSendNewsFlg = new javax.swing.JCheckBox();
        lblAllowEmailFlg = new javax.swing.JLabel();
        ckbAllowEmailFlg = new javax.swing.JCheckBox();
        lblSendPromFlg = new javax.swing.JLabel();
        ckbSendPromFlg = new javax.swing.JCheckBox();
        lblAllowCallFlg = new javax.swing.JLabel();
        ckbAllowCallFlg = new javax.swing.JCheckBox();
        lblContactPhone = new javax.swing.JLabel();
        txtContactPhone = new javax.swing.JTextField();
        lblContactMPhone = new javax.swing.JLabel();
        txtContactMPhone = new javax.swing.JTextField();
        lblContactEnterprise = new javax.swing.JLabel();
        txtContactEnterprise = new javax.swing.JTextField();
        lblSocialMedia = new javax.swing.JLabel();
        lblAddSocialMedia = new javax.swing.JLabel();
        btnAddSocialMedia = new javax.swing.JButton();
        lblFacebook = new javax.swing.JLabel();
        txtFacebook = new javax.swing.JTextField();
        lblInstagram = new javax.swing.JLabel();
        txtInstagram = new javax.swing.JTextField();
        lblTwitter = new javax.swing.JLabel();
        txtTwitter = new javax.swing.JTextField();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Contatos");
        setBackground(new java.awt.Color(255, 255, 255));
        setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N

        PanelContact.setBackground(new java.awt.Color(255, 255, 255));
        PanelContact.setPreferredSize(new java.awt.Dimension(1366, 757));

        lblContactList.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        lblContactList.setText("Lista de Contatos");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        lblImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/20px/Filter 20x20.png"))); // NOI18N

        cbbContactListFilter.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        cbbContactListFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbContactListFilter.setMaximumSize(new java.awt.Dimension(250, 32767));
        cbbContactListFilter.setPreferredSize(new java.awt.Dimension(250, 23));
        cbbContactListFilter.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbContactListFilterItemStateChanged(evt);
            }
        });

        txtContactListFilterValue.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtContactListFilterValue.setToolTipText("");
        txtContactListFilterValue.setMaximumSize(new java.awt.Dimension(250, 2147483647));
        txtContactListFilterValue.setPreferredSize(new java.awt.Dimension(250, 23));

        lblInformation.setBackground(new java.awt.Color(255, 255, 255));
        lblInformation.setText("Pressione Enter para pesquisar");
        lblInformation.setEnabled(false);

        lblRecCount.setBackground(new java.awt.Color(255, 255, 255));
        lblRecCount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblRecCount.setText("Registro: 0 - 100");
        lblRecCount.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblRecCount.setMaximumSize(new java.awt.Dimension(410, 14));

        javax.swing.GroupLayout PanelContactListHeaderLayout = new javax.swing.GroupLayout(PanelContactListHeader);
        PanelContactListHeader.setLayout(PanelContactListHeaderLayout);
        PanelContactListHeaderLayout.setHorizontalGroup(
            PanelContactListHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelContactListHeaderLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(lblContactList, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblImage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbbContactListFilter, 0, 268, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtContactListFilterValue, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInformation)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRecCount, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                .addContainerGap())
        );
        PanelContactListHeaderLayout.setVerticalGroup(
            PanelContactListHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelContactListHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelContactListHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbbContactListFilter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblContactList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addComponent(lblImage, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblRecCount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblInformation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtContactListFilterValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        lblRecCount.getAccessibleContext().setAccessibleDescription("");

        sPanelUserList.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        sPanelUserList.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        sPanelUserList.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N

        tblContactList.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        tblContactList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Tipo de Documento", "Documento", "Conta", "Contato Principal", "Email", "Telefone Residencial", "WhatsApp", "Celular/WhatsApp", "Telefone Comercial", "Facebook", "Twitter", "Instagram", "Fax", "Endereço", "Número", "Bairro", "Cidade", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblContactList.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblContactList.setGridColor(new java.awt.Color(204, 204, 204));
        tblContactList.setRowHeight(22);
        sPanelUserList.setViewportView(tblContactList);

        javax.swing.GroupLayout PanelListContactLayout = new javax.swing.GroupLayout(PanelListContact);
        PanelListContact.setLayout(PanelListContactLayout);
        PanelListContactLayout.setHorizontalGroup(
            PanelListContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sPanelUserList)
        );
        PanelListContactLayout.setVerticalGroup(
            PanelListContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sPanelUserList, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PanelContactListLayout = new javax.swing.GroupLayout(PanelContactList);
        PanelContactList.setLayout(PanelContactListLayout);
        PanelContactListLayout.setHorizontalGroup(
            PanelContactListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelContactListLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelContactListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelListContact, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelContactListHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        PanelContactListLayout.setVerticalGroup(
            PanelContactListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelContactListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelContactListHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelListContact, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        lblContactNameHeader.setBackground(new java.awt.Color(255, 255, 255));
        lblContactNameHeader.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        lblContactNameHeader.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblContactNameHeader.setMinimumSize(new java.awt.Dimension(0, 30));

        lblContactFormInformation.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblContactFormInformation.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblContactFormInformation.setText("Campos Obrigatórios (*)");
        lblContactFormInformation.setEnabled(false);

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btnEdit.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/20px/Edit 20x20.png"))); // NOI18N
        btnEdit.setToolTipText("Editar");
        btnEdit.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnEdit.setBorderPainted(false);
        btnEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEdit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEdit.setIconTextGap(3);
        btnEdit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnEditKeyPressed(evt);
            }
        });

        btnNew.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/20px/New 20x20.png"))); // NOI18N
        btnNew.setToolTipText("Novo");
        btnNew.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnNew.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNew.setIconTextGap(3);
        btnNew.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnNewKeyPressed(evt);
            }
        });

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btnSave.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/20px/Save 20x20.png"))); // NOI18N
        btnSave.setToolTipText("Salvar");
        btnSave.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnSave.setEnabled(false);
        btnSave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSave.setIconTextGap(3);
        btnSave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnSaveKeyPressed(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/20px/Cancel 20x20.png"))); // NOI18N
        btnCancel.setToolTipText("Cancelar");
        btnCancel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnCancel.setEnabled(false);
        btnCancel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnCancelKeyPressed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/20px/Delete 20x20.png"))); // NOI18N
        btnDelete.setToolTipText("Excluir");
        btnDelete.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnDelete.setBorderPainted(false);
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDelete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDelete.setIconTextGap(3);
        btnDelete.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnDeleteKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout PanelContactFormHeaderLayout = new javax.swing.GroupLayout(PanelContactFormHeader);
        PanelContactFormHeader.setLayout(PanelContactFormHeaderLayout);
        PanelContactFormHeaderLayout.setHorizontalGroup(
            PanelContactFormHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelContactFormHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblContactNameHeader, javax.swing.GroupLayout.DEFAULT_SIZE, 707, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblContactFormInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        PanelContactFormHeaderLayout.setVerticalGroup(
            PanelContactFormHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelContactFormHeaderLayout.createSequentialGroup()
                .addGroup(PanelContactFormHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblContactFormInformation, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblContactNameHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        sPanelContactForm.setBorder(null);
        sPanelContactForm.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        sPanelContactForm.setMinimumSize(new java.awt.Dimension(0, 0));
        sPanelContactForm.setPreferredSize(new java.awt.Dimension(1366, 427));

        PanelFormContact.setBackground(new java.awt.Color(255, 255, 255));
        PanelFormContact.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        PanelFormContact.setPreferredSize(new java.awt.Dimension(1340, 425));

        lblContactInformation.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.light"));
        lblContactInformation.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblContactInformation.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblContactInformation.setText("   Informações do Contato");
        lblContactInformation.setToolTipText("");
        lblContactInformation.setEnabled(false);
        lblContactInformation.setMaximumSize(new java.awt.Dimension(644, 16));
        lblContactInformation.setMinimumSize(new java.awt.Dimension(644, 16));
        lblContactInformation.setOpaque(true);

        lblRowId.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblRowId.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblRowId.setText("Id:");
        lblRowId.setEnabled(false);
        lblRowId.setMaximumSize(new java.awt.Dimension(150, 22));
        lblRowId.setMinimumSize(new java.awt.Dimension(150, 22));
        lblRowId.setPreferredSize(new java.awt.Dimension(150, 22));

        txtRowId.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtRowId.setText("jTextField1");
        txtRowId.setEnabled(false);

        lblMainContFlg.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblMainContFlg.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMainContFlg.setText("Contato Principal:");
        lblMainContFlg.setToolTipText("");
        lblMainContFlg.setEnabled(false);
        lblMainContFlg.setMaximumSize(new java.awt.Dimension(150, 22));
        lblMainContFlg.setMinimumSize(new java.awt.Dimension(150, 22));
        lblMainContFlg.setPreferredSize(new java.awt.Dimension(150, 22));

        ckbMainConFlg.setBackground(new java.awt.Color(255, 255, 255));
        ckbMainConFlg.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        ckbMainConFlg.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        ckbMainConFlg.setBorderPainted(true);
        ckbMainConFlg.setEnabled(false);
        ckbMainConFlg.setMaximumSize(new java.awt.Dimension(165, 21));
        ckbMainConFlg.setPreferredSize(new java.awt.Dimension(165, 21));
        ckbMainConFlg.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ckbMainConFlgItemStateChanged(evt);
            }
        });
        ckbMainConFlg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ckbMainConFlgKeyPressed(evt);
            }
        });

        lblWhatsAppFlg.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblWhatsAppFlg.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblWhatsAppFlg.setText("WhatsApp:");
        lblWhatsAppFlg.setEnabled(false);
        lblWhatsAppFlg.setMaximumSize(new java.awt.Dimension(150, 22));
        lblWhatsAppFlg.setMinimumSize(new java.awt.Dimension(150, 22));
        lblWhatsAppFlg.setPreferredSize(new java.awt.Dimension(150, 22));

        ckbWhatsAppFlg.setBackground(new java.awt.Color(255, 255, 255));
        ckbWhatsAppFlg.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        ckbWhatsAppFlg.setAlignmentX(0.5F);
        ckbWhatsAppFlg.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        ckbWhatsAppFlg.setBorderPainted(true);
        ckbWhatsAppFlg.setEnabled(false);
        ckbWhatsAppFlg.setPreferredSize(new java.awt.Dimension(165, 21));
        ckbWhatsAppFlg.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ckbWhatsAppFlgItemStateChanged(evt);
            }
        });
        ckbWhatsAppFlg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ckbWhatsAppFlgKeyPressed(evt);
            }
        });

        lblContactEmail.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblContactEmail.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblContactEmail.setText("Email:");
        lblContactEmail.setToolTipText("");
        lblContactEmail.setEnabled(false);
        lblContactEmail.setMaximumSize(new java.awt.Dimension(150, 22));
        lblContactEmail.setMinimumSize(new java.awt.Dimension(150, 22));
        lblContactEmail.setPreferredSize(new java.awt.Dimension(150, 22));

        txtContactEmail.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtContactEmail.setText("matheuscabralrosa");
        txtContactEmail.setToolTipText("");
        txtContactEmail.setEnabled(false);
        txtContactEmail.setMaximumSize(new java.awt.Dimension(304, 22));
        txtContactEmail.setPreferredSize(new java.awt.Dimension(304, 22));
        txtContactEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtContactEmailKeyPressed(evt);
            }
        });

        lblContactEmail1.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblContactEmail1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblContactEmail1.setText("@");
        lblContactEmail1.setEnabled(false);
        lblContactEmail1.setMaximumSize(new java.awt.Dimension(22, 16));

        cbbContactEmailType.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        cbbContactEmailType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbContactEmailType.setEnabled(false);
        cbbContactEmailType.setMaximumSize(new java.awt.Dimension(165, 22));
        cbbContactEmailType.setMinimumSize(new java.awt.Dimension(165, 22));
        cbbContactEmailType.setPreferredSize(new java.awt.Dimension(165, 22));
        cbbContactEmailType.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbContactEmailTypeItemStateChanged(evt);
            }
        });
        cbbContactEmailType.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbbContactEmailTypeKeyPressed(evt);
            }
        });

        lblSendNewsFlg.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblSendNewsFlg.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSendNewsFlg.setText("Permite enviar novidades:");
        lblSendNewsFlg.setEnabled(false);
        lblSendNewsFlg.setMaximumSize(new java.awt.Dimension(150, 22));
        lblSendNewsFlg.setMinimumSize(new java.awt.Dimension(150, 22));
        lblSendNewsFlg.setPreferredSize(new java.awt.Dimension(150, 22));

        ckbSendNewsFlg.setBackground(new java.awt.Color(255, 255, 255));
        ckbSendNewsFlg.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        ckbSendNewsFlg.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        ckbSendNewsFlg.setEnabled(false);
        ckbSendNewsFlg.setMaximumSize(new java.awt.Dimension(165, 21));
        ckbSendNewsFlg.setMinimumSize(new java.awt.Dimension(165, 21));
        ckbSendNewsFlg.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ckbSendNewsFlgItemStateChanged(evt);
            }
        });
        ckbSendNewsFlg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ckbSendNewsFlgKeyPressed(evt);
            }
        });

        lblAllowEmailFlg.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblAllowEmailFlg.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAllowEmailFlg.setText("Permite enviar E-mail:");
        lblAllowEmailFlg.setEnabled(false);
        lblAllowEmailFlg.setMaximumSize(new java.awt.Dimension(150, 22));
        lblAllowEmailFlg.setMinimumSize(new java.awt.Dimension(150, 22));
        lblAllowEmailFlg.setPreferredSize(new java.awt.Dimension(150, 22));

        ckbAllowEmailFlg.setBackground(new java.awt.Color(255, 255, 255));
        ckbAllowEmailFlg.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        ckbAllowEmailFlg.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        ckbAllowEmailFlg.setEnabled(false);
        ckbAllowEmailFlg.setMaximumSize(new java.awt.Dimension(165, 21));
        ckbAllowEmailFlg.setPreferredSize(new java.awt.Dimension(165, 21));
        ckbAllowEmailFlg.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ckbAllowEmailFlgItemStateChanged(evt);
            }
        });
        ckbAllowEmailFlg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ckbAllowEmailFlgKeyPressed(evt);
            }
        });

        lblSendPromFlg.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblSendPromFlg.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSendPromFlg.setText("Permite enviar Promoções:");
        lblSendPromFlg.setEnabled(false);
        lblSendPromFlg.setMaximumSize(new java.awt.Dimension(150, 22));
        lblSendPromFlg.setMinimumSize(new java.awt.Dimension(150, 22));
        lblSendPromFlg.setPreferredSize(new java.awt.Dimension(150, 22));

        ckbSendPromFlg.setBackground(new java.awt.Color(255, 255, 255));
        ckbSendPromFlg.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        ckbSendPromFlg.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        ckbSendPromFlg.setEnabled(false);
        ckbSendPromFlg.setMaximumSize(new java.awt.Dimension(165, 21));
        ckbSendPromFlg.setMinimumSize(new java.awt.Dimension(165, 21));
        ckbSendPromFlg.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ckbSendPromFlgItemStateChanged(evt);
            }
        });
        ckbSendPromFlg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ckbSendPromFlgKeyPressed(evt);
            }
        });

        lblAllowCallFlg.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblAllowCallFlg.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAllowCallFlg.setText("Permite ligações:");
        lblAllowCallFlg.setEnabled(false);
        lblAllowCallFlg.setMaximumSize(new java.awt.Dimension(150, 22));
        lblAllowCallFlg.setMinimumSize(new java.awt.Dimension(150, 22));
        lblAllowCallFlg.setPreferredSize(new java.awt.Dimension(150, 22));

        ckbAllowCallFlg.setBackground(new java.awt.Color(255, 255, 255));
        ckbAllowCallFlg.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        ckbAllowCallFlg.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        ckbAllowCallFlg.setEnabled(false);
        ckbAllowCallFlg.setMaximumSize(new java.awt.Dimension(165, 21));
        ckbAllowCallFlg.setMinimumSize(new java.awt.Dimension(165, 21));
        ckbAllowCallFlg.setPreferredSize(new java.awt.Dimension(165, 21));
        ckbAllowCallFlg.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ckbAllowCallFlgItemStateChanged(evt);
            }
        });
        ckbAllowCallFlg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ckbAllowCallFlgKeyPressed(evt);
            }
        });

        lblContactPhone.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblContactPhone.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblContactPhone.setText("Telefone Fixo:");
        lblContactPhone.setEnabled(false);
        lblContactPhone.setMaximumSize(new java.awt.Dimension(150, 16));
        lblContactPhone.setPreferredSize(new java.awt.Dimension(150, 22));

        txtContactPhone.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtContactPhone.setText("jTextField1");
        txtContactPhone.setEnabled(false);
        txtContactPhone.setMaximumSize(new java.awt.Dimension(165, 22));
        txtContactPhone.setMinimumSize(new java.awt.Dimension(165, 22));
        txtContactPhone.setPreferredSize(new java.awt.Dimension(165, 22));
        txtContactPhone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtContactPhoneKeyPressed(evt);
            }
        });

        lblContactMPhone.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblContactMPhone.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblContactMPhone.setText("Celular/WhatsApp*:");
        lblContactMPhone.setEnabled(false);
        lblContactMPhone.setMaximumSize(new java.awt.Dimension(150, 16));
        lblContactMPhone.setPreferredSize(new java.awt.Dimension(150, 16));

        txtContactMPhone.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtContactMPhone.setText("jTextField1");
        txtContactMPhone.setEnabled(false);
        txtContactMPhone.setMaximumSize(new java.awt.Dimension(165, 22));
        txtContactMPhone.setMinimumSize(new java.awt.Dimension(165, 22));
        txtContactMPhone.setPreferredSize(new java.awt.Dimension(165, 22));
        txtContactMPhone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtContactMPhoneKeyPressed(evt);
            }
        });

        lblContactEnterprise.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblContactEnterprise.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblContactEnterprise.setText("Telefone Comercial:");
        lblContactEnterprise.setEnabled(false);
        lblContactEnterprise.setMaximumSize(new java.awt.Dimension(150, 16));
        lblContactEnterprise.setPreferredSize(new java.awt.Dimension(150, 16));

        txtContactEnterprise.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtContactEnterprise.setText("jTextField1");
        txtContactEnterprise.setEnabled(false);
        txtContactEnterprise.setMaximumSize(new java.awt.Dimension(165, 22));
        txtContactEnterprise.setMinimumSize(new java.awt.Dimension(165, 22));
        txtContactEnterprise.setPreferredSize(new java.awt.Dimension(165, 22));
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

        lblAddSocialMedia.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblAddSocialMedia.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAddSocialMedia.setText("Redes Sociais:");
        lblAddSocialMedia.setEnabled(false);
        lblAddSocialMedia.setPreferredSize(new java.awt.Dimension(150, 16));

        btnAddSocialMedia.setText("Visualizar/Cadastrar");
        btnAddSocialMedia.setEnabled(false);
        btnAddSocialMedia.setMaximumSize(new java.awt.Dimension(165, 22));
        btnAddSocialMedia.setMinimumSize(new java.awt.Dimension(165, 22));
        btnAddSocialMedia.setPreferredSize(new java.awt.Dimension(165, 22));
        btnAddSocialMedia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnAddSocialMediaKeyPressed(evt);
            }
        });

        lblFacebook.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblFacebook.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFacebook.setText("Facebook:");
        lblFacebook.setEnabled(false);
        lblFacebook.setMaximumSize(new java.awt.Dimension(150, 22));
        lblFacebook.setMinimumSize(new java.awt.Dimension(150, 22));
        lblFacebook.setPreferredSize(new java.awt.Dimension(150, 22));

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
        lblInstagram.setMaximumSize(new java.awt.Dimension(150, 22));
        lblInstagram.setMinimumSize(new java.awt.Dimension(150, 22));
        lblInstagram.setPreferredSize(new java.awt.Dimension(150, 22));

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
        lblTwitter.setMaximumSize(new java.awt.Dimension(150, 22));
        lblTwitter.setMinimumSize(new java.awt.Dimension(150, 22));
        lblTwitter.setPreferredSize(new java.awt.Dimension(150, 22));

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

        lblPersonalData.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.light"));
        lblPersonalData.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblPersonalData.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPersonalData.setText("   Dados Pessoais");
        lblPersonalData.setToolTipText("");
        lblPersonalData.setEnabled(false);
        lblPersonalData.setOpaque(true);

        lblDocType.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblDocType.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDocType.setText("Tipo de Documento:");
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
        lblDocNum.setText("Documento:");
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
        lblName.setText("Nome:");
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
        lblSurname.setText("Sobrenome:");
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
        lblSex.setText("Sexo:");
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
        lblBirthDate.setText("Data de Nascimento:");
        lblBirthDate.setEnabled(false);

        cbbDay.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        cbbDay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "26" }));
        cbbDay.setEnabled(false);
        cbbDay.setMaximumSize(new java.awt.Dimension(39, 22));
        cbbDay.setName(""); // NOI18N
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
        cbbMonth.setMaximumSize(new java.awt.Dimension(67, 22));
        cbbMonth.setName(""); // NOI18N
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
        txtYear.setMaximumSize(new java.awt.Dimension(33, 22));
        txtYear.setMinimumSize(new java.awt.Dimension(33, 22));
        txtYear.setName(""); // NOI18N
        txtYear.setPreferredSize(new java.awt.Dimension(33, 22));
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

        javax.swing.GroupLayout PanelFormContactLayout = new javax.swing.GroupLayout(PanelFormContact);
        PanelFormContact.setLayout(PanelFormContactLayout);
        PanelFormContactLayout.setHorizontalGroup(
            PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFormContactLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lblSocialMedia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(PanelFormContactLayout.createSequentialGroup()
                            .addGroup(PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelFormContactLayout.createSequentialGroup()
                                    .addComponent(lblFacebook, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtFacebook, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelFormContactLayout.createSequentialGroup()
                                    .addComponent(lblAddSocialMedia, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnAddSocialMedia, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(PanelFormContactLayout.createSequentialGroup()
                                    .addComponent(lblTwitter, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtTwitter, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(PanelFormContactLayout.createSequentialGroup()
                                    .addComponent(lblInstagram, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtInstagram, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(PanelFormContactLayout.createSequentialGroup()
                        .addGroup(PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(PanelFormContactLayout.createSequentialGroup()
                                    .addComponent(lblRowId, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtRowId, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblMainContFlg, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(ckbMainConFlg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(lblContactInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 642, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelFormContactLayout.createSequentialGroup()
                                .addComponent(lblContactMPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtContactMPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblWhatsAppFlg, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ckbWhatsAppFlg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelFormContactLayout.createSequentialGroup()
                                .addComponent(lblContactEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtContactEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblContactEmail1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbbContactEmailType, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelFormContactLayout.createSequentialGroup()
                                .addComponent(lblContactEnterprise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtContactEnterprise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblSendPromFlg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(ckbSendPromFlg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelFormContactLayout.createSequentialGroup()
                                .addComponent(lblAllowEmailFlg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ckbAllowEmailFlg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblSendNewsFlg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ckbSendNewsFlg, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelFormContactLayout.createSequentialGroup()
                                .addComponent(lblContactPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtContactPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblAllowCallFlg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(ckbAllowCallFlg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelFormContactLayout.createSequentialGroup()
                                .addGroup(PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PanelFormContactLayout.createSequentialGroup()
                                        .addComponent(lblSex, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbbSex, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(PanelFormContactLayout.createSequentialGroup()
                                        .addComponent(lblDocNum, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDocNum, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(PanelFormContactLayout.createSequentialGroup()
                                        .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(PanelFormContactLayout.createSequentialGroup()
                                        .addComponent(lblSurname, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtSurname, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(PanelFormContactLayout.createSequentialGroup()
                                        .addComponent(lblDocType, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbbDocType, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(PanelFormContactLayout.createSequentialGroup()
                                        .addComponent(lblNickname, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtNickName, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PanelFormContactLayout.createSequentialGroup()
                                        .addGroup(PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lblBornLocation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblBirthDate, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(PanelFormContactLayout.createSequentialGroup()
                                                .addComponent(cbbDay, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cbbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel12)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtYear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txtBornLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(PanelFormContactLayout.createSequentialGroup()
                                        .addGroup(PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lblSpouseName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblCivilState, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cbbCivilState, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtSpouseName, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(PanelFormContactLayout.createSequentialGroup()
                                        .addComponent(lblMotherName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtMotherName, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(PanelFormContactLayout.createSequentialGroup()
                                        .addComponent(lblFatherName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtFatherName, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(lblPersonalData, javax.swing.GroupLayout.PREFERRED_SIZE, 642, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 28, Short.MAX_VALUE))
        );
        PanelFormContactLayout.setVerticalGroup(
            PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelFormContactLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelFormContactLayout.createSequentialGroup()
                        .addComponent(lblPersonalData, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelFormContactLayout.createSequentialGroup()
                                .addGroup(PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblDocType, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbbDocType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblDocNum, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDocNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8)
                                .addGroup(PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblSurname, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(PanelFormContactLayout.createSequentialGroup()
                                .addGroup(PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblBirthDate, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbbDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)
                                    .addComponent(cbbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12)
                                    .addComponent(txtYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblBornLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtBornLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(7, 7, 7)
                                .addGroup(PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblCivilState, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbbCivilState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblSpouseName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSpouseName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblMotherName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMotherName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblNickname, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNickName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbbContactEmailType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblContactEmail1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtContactEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblContactEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(PanelFormContactLayout.createSequentialGroup()
                        .addComponent(lblContactInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblRowId, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtRowId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblMainContFlg, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ckbMainConFlg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(8, 8, 8)
                        .addGroup(PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ckbWhatsAppFlg, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblContactMPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtContactMPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblWhatsAppFlg, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(5, 5, 5)
                        .addGroup(PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(PanelFormContactLayout.createSequentialGroup()
                                .addGroup(PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblAllowCallFlg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ckbAllowCallFlg, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblSendPromFlg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ckbSendPromFlg, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(PanelFormContactLayout.createSequentialGroup()
                                .addGroup(PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblContactPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtContactPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblContactEnterprise, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtContactEnterprise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblSendNewsFlg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ckbSendNewsFlg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblAllowEmailFlg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ckbAllowEmailFlg, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblFatherName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtFatherName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbbSex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblSex, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(lblSocialMedia, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelFormContactLayout.createSequentialGroup()
                        .addGroup(PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAddSocialMedia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAddSocialMedia, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFacebook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFacebook, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PanelFormContactLayout.createSequentialGroup()
                        .addGroup(PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtInstagram, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblInstagram, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTwitter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTwitter, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        sPanelContactForm.setViewportView(PanelFormContact);

        javax.swing.GroupLayout PanelContactFormLayout = new javax.swing.GroupLayout(PanelContactForm);
        PanelContactForm.setLayout(PanelContactFormLayout);
        PanelContactFormLayout.setHorizontalGroup(
            PanelContactFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelContactFormLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sPanelContactForm, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(PanelContactFormHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelContactFormLayout.setVerticalGroup(
            PanelContactFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelContactFormLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelContactFormHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sPanelContactForm, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PanelContactLayout = new javax.swing.GroupLayout(PanelContact);
        PanelContact.setLayout(PanelContactLayout);
        PanelContactLayout.setHorizontalGroup(
            PanelContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelContactList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelContactForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelContactLayout.setVerticalGroup(
            PanelContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelContactLayout.createSequentialGroup()
                .addComponent(PanelContactList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PanelContactForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelContact, javax.swing.GroupLayout.DEFAULT_SIZE, 1130, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelContact, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnEditKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_TAB){
            setFocus("BOTAO_DELETAR");
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

    private void cbbContactListFilterItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbContactListFilterItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            setFocus("FILTRO_VALOR");
        }
    }//GEN-LAST:event_cbbContactListFilterItemStateChanged

    private void txtTwitterKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTwitterKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("BOTAO_ADD_ENDERECO");
        }
    }//GEN-LAST:event_txtTwitterKeyPressed

    private void txtInstagramKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtInstagramKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("REDE_SOCIAL_TWITTER");
        }
    }//GEN-LAST:event_txtInstagramKeyPressed

    private void txtFacebookKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFacebookKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("REDE_SOCIAL_INSTAGRAM");
        }
    }//GEN-LAST:event_txtFacebookKeyPressed

    private void btnAddSocialMediaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAddSocialMediaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_TAB){
            setFocus("BOTAO_SALVAR");
        }
    }//GEN-LAST:event_btnAddSocialMediaKeyPressed

    private void txtContactMPhoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContactMPhoneKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("CONTATO_TELEFONE_FIXO");
        }
    }//GEN-LAST:event_txtContactMPhoneKeyPressed

    private void txtContactPhoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContactPhoneKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("CONTATO_TELEFONE_COMERCIAL");
        }
    }//GEN-LAST:event_txtContactPhoneKeyPressed

    private void txtContactEmailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContactEmailKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("CONTATO_EMAIL_TIPO");
        }
    }//GEN-LAST:event_txtContactEmailKeyPressed

    private void txtContactEnterpriseKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContactEnterpriseKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("CONTATO_EMAIL");
        }
    }//GEN-LAST:event_txtContactEnterpriseKeyPressed

    private void txtFatherNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFatherNameKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("REGISTRO_TIPO");
        }
    }//GEN-LAST:event_txtFatherNameKeyPressed

    private void txtMotherNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMotherNameKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("NOME_PAI");
        }
    }//GEN-LAST:event_txtMotherNameKeyPressed

    private void txtSpouseNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSpouseNameKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("NOME_MAE");
        }
    }//GEN-LAST:event_txtSpouseNameKeyPressed

    private void cbbCivilStateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbbCivilStateKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_TAB){
            setFocus("NOME_CONJUJE");
        }
    }//GEN-LAST:event_cbbCivilStateKeyPressed

    private void cbbCivilStateItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbCivilStateItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            setFocus("NOME_CONJUJE");
        }
    }//GEN-LAST:event_cbbCivilStateItemStateChanged

    private void txtBornLocationKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBornLocationKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("ESTADO_CIVIL");
        }
    }//GEN-LAST:event_txtBornLocationKeyPressed

    private void txtYearKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtYearKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("NASCIMENTO_LOCAL");
        }
    }//GEN-LAST:event_txtYearKeyPressed

    private void cbbMonthKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbbMonthKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_TAB){
            setFocus("NASCIMENTO_ANO");
        }
    }//GEN-LAST:event_cbbMonthKeyPressed

    private void cbbMonthItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbMonthItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            setFocus("NASCIMENTO_ANO");
        }
    }//GEN-LAST:event_cbbMonthItemStateChanged

    private void cbbDayKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbbDayKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_TAB){
            setFocus("NASCIMENTO_MES");
        }
    }//GEN-LAST:event_cbbDayKeyPressed

    private void cbbDayItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbDayItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            setFocus("NASCIMENTO_MES");
        }
    }//GEN-LAST:event_cbbDayItemStateChanged

    private void cbbSexKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbbSexKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_TAB){
            setFocus("NASCIMENTO_DIA");
        }
    }//GEN-LAST:event_cbbSexKeyPressed

    private void cbbSexItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbSexItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            setFocus("NASCIMENTO_DIA");
        }
    }//GEN-LAST:event_cbbSexItemStateChanged

    private void txtNickNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNickNameKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("SEXO");
        }
    }//GEN-LAST:event_txtNickNameKeyPressed

    private void txtSurnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSurnameKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("APELIDO");
        }
    }//GEN-LAST:event_txtSurnameKeyPressed

    private void txtNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("SOBRENOME");
        }
    }//GEN-LAST:event_txtNameKeyPressed

    private void txtDocNumKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDocNumKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("NOME");
        }
    }//GEN-LAST:event_txtDocNumKeyPressed

    private void cbbDocTypeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbbDocTypeKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_TAB){
            setFocus("NUM_DOCUMENTO");
        }
    }//GEN-LAST:event_cbbDocTypeKeyPressed

    private void cbbDocTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbDocTypeItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            setFocus("NUM_DOCUMENTO");
        }
    }//GEN-LAST:event_cbbDocTypeItemStateChanged

    private void cbbContactEmailTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbContactEmailTypeItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            setFocus("PERMITE_EMAIL_FLG");
        }
    }//GEN-LAST:event_cbbContactEmailTypeItemStateChanged

    private void ckbAllowEmailFlgKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ckbAllowEmailFlgKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("CONTATO_PRINCIPAL_FLG");
        }
    }//GEN-LAST:event_ckbAllowEmailFlgKeyPressed

    private void ckbAllowEmailFlgItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ckbAllowEmailFlgItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            setFocus("CONTATO_PRINCIPAL_FLG");
        }
    }//GEN-LAST:event_ckbAllowEmailFlgItemStateChanged

    private void ckbMainConFlgKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ckbMainConFlgKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("WHATSAPP_FLG");
        }
    }//GEN-LAST:event_ckbMainConFlgKeyPressed

    private void ckbMainConFlgItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ckbMainConFlgItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            setFocus("WHATSAPP_FLG");
        }
    }//GEN-LAST:event_ckbMainConFlgItemStateChanged

    private void ckbWhatsAppFlgKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ckbWhatsAppFlgKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("PERMITE_LIGACAO_FLG");
        }
    }//GEN-LAST:event_ckbWhatsAppFlgKeyPressed

    private void ckbWhatsAppFlgItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ckbWhatsAppFlgItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            setFocus("PERMITE_LIGACAO_FLG");
        }
    }//GEN-LAST:event_ckbWhatsAppFlgItemStateChanged

    private void ckbAllowCallFlgKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ckbAllowCallFlgKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("PERMITE_ENV_PROMO_FLG");
        }
    }//GEN-LAST:event_ckbAllowCallFlgKeyPressed

    private void ckbAllowCallFlgItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ckbAllowCallFlgItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            setFocus("PERMITE_ENV_PROMO_FLG");
        }
    }//GEN-LAST:event_ckbAllowCallFlgItemStateChanged

    private void ckbSendPromFlgKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ckbSendPromFlgKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("PERMITE_NOVIDADES_FLG");
        }
    }//GEN-LAST:event_ckbSendPromFlgKeyPressed

    private void ckbSendPromFlgItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ckbSendPromFlgItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            setFocus("PERMITE_NOVIDADES_FLG");
        }
    }//GEN-LAST:event_ckbSendPromFlgItemStateChanged

    private void ckbSendNewsFlgKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ckbSendNewsFlgKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("BOTAO_ADD_REDE_SOCIAL");
        }
    }//GEN-LAST:event_ckbSendNewsFlgKeyPressed

    private void ckbSendNewsFlgItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ckbSendNewsFlgItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            setFocus("BOTAO_ADD_REDE_SOCIAL");
        }
    }//GEN-LAST:event_ckbSendNewsFlgItemStateChanged

    private void btnDeleteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnDeleteKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_TAB){
            setFocus("BOTAO_NOVO");
        }
    }//GEN-LAST:event_btnDeleteKeyPressed

    private void cbbContactEmailTypeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbbContactEmailTypeKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_TAB){
            setFocus("PERMITE_EMAIL_FLG");
        }
    }//GEN-LAST:event_cbbContactEmailTypeKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelContact;
    private javax.swing.JPanel PanelContactForm;
    private javax.swing.JPanel PanelContactFormHeader;
    private javax.swing.JPanel PanelContactList;
    private javax.swing.JPanel PanelContactListHeader;
    private javax.swing.JPanel PanelFormContact;
    private javax.swing.JPanel PanelListContact;
    private javax.swing.JButton btnAddSocialMedia;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cbbCivilState;
    private javax.swing.JComboBox<String> cbbContactEmailType;
    private javax.swing.JComboBox<String> cbbContactListFilter;
    private javax.swing.JComboBox<String> cbbDay;
    private javax.swing.JComboBox<String> cbbDocType;
    private javax.swing.JComboBox<String> cbbMonth;
    private javax.swing.JComboBox<String> cbbSex;
    private javax.swing.JCheckBox ckbAllowCallFlg;
    private javax.swing.JCheckBox ckbAllowEmailFlg;
    private javax.swing.JCheckBox ckbMainConFlg;
    private javax.swing.JCheckBox ckbSendNewsFlg;
    private javax.swing.JCheckBox ckbSendPromFlg;
    private javax.swing.JCheckBox ckbWhatsAppFlg;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblAddSocialMedia;
    private javax.swing.JLabel lblAllowCallFlg;
    private javax.swing.JLabel lblAllowEmailFlg;
    private javax.swing.JLabel lblBirthDate;
    private javax.swing.JLabel lblBornLocation;
    private javax.swing.JLabel lblCivilState;
    private javax.swing.JLabel lblContactEmail;
    private javax.swing.JLabel lblContactEmail1;
    private javax.swing.JLabel lblContactEnterprise;
    private javax.swing.JLabel lblContactFormInformation;
    private javax.swing.JLabel lblContactInformation;
    private javax.swing.JLabel lblContactList;
    private javax.swing.JLabel lblContactMPhone;
    private javax.swing.JLabel lblContactNameHeader;
    private javax.swing.JLabel lblContactPhone;
    private javax.swing.JLabel lblDocNum;
    private javax.swing.JLabel lblDocType;
    private javax.swing.JLabel lblFacebook;
    private javax.swing.JLabel lblFatherName;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblInformation;
    private javax.swing.JLabel lblInstagram;
    private javax.swing.JLabel lblMainContFlg;
    private javax.swing.JLabel lblMotherName;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNickname;
    private javax.swing.JLabel lblPersonalData;
    private javax.swing.JLabel lblRecCount;
    private javax.swing.JLabel lblRowId;
    private javax.swing.JLabel lblSendNewsFlg;
    private javax.swing.JLabel lblSendPromFlg;
    private javax.swing.JLabel lblSex;
    private javax.swing.JLabel lblSocialMedia;
    private javax.swing.JLabel lblSpouseName;
    private javax.swing.JLabel lblSurname;
    private javax.swing.JLabel lblTwitter;
    private javax.swing.JLabel lblWhatsAppFlg;
    private javax.swing.JScrollPane sPanelContactForm;
    private javax.swing.JScrollPane sPanelUserList;
    private javax.swing.JTable tblContactList;
    private javax.swing.JTextField txtBornLocation;
    private javax.swing.JTextField txtContactEmail;
    private javax.swing.JTextField txtContactEnterprise;
    private javax.swing.JTextField txtContactListFilterValue;
    private javax.swing.JTextField txtContactMPhone;
    private javax.swing.JTextField txtContactPhone;
    private javax.swing.JTextField txtDocNum;
    private javax.swing.JTextField txtFacebook;
    private javax.swing.JTextField txtFatherName;
    private javax.swing.JTextField txtInstagram;
    private javax.swing.JTextField txtMotherName;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNickName;
    private javax.swing.JTextField txtRowId;
    private javax.swing.JTextField txtSpouseName;
    private javax.swing.JTextField txtSurname;
    private javax.swing.JTextField txtTwitter;
    private javax.swing.JTextField txtYear;
    // End of variables declaration//GEN-END:variables
}
