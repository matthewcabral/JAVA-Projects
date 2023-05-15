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
import java.awt.event.ComponentListener;
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
public class AccountScreen extends javax.swing.JFrame {

    /**
     * Creates new form accountScreen
     */
    public AccountScreen() {
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
    public void setListenerBtnAddContact(ActionListener listener) { this.btnAddContact.addActionListener(listener); }
    public void setListenerBtnAddAddress(ActionListener listener) { this.btnAddAddress.addActionListener(listener); }
    
    public void setListenercbbListFilterValue(ItemListener listener) { this.cbbListFilter.addItemListener(listener); }
    public void setListenertxtListFilterValue(KeyListener listener) { this.txtListFilterValue.addKeyListener(listener); }
    
    public void setListenercbbDocumentType(ItemListener listener) { this.cbbDocType.addItemListener(listener); }
    
    public void setListenerPanelAccountInfo(ComponentListener listener) { this.PanelAccountInfo.addComponentListener(listener); }    
    public void setListenerPanelAccountContAddr(ComponentListener listener) { this.PanelAccountContAddr.addComponentListener(listener); }    
    public void setListenerPanelAccountMoreInfo(ComponentListener listener) { this.PanelAccountMoreInfo.addComponentListener(listener); }    
    public void setListenePanelAccountOrders(ComponentListener listener) { this.PanelAccountOrders.addComponentListener(listener); }    
    
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
    
    public void setcbbListFilter(String value) { this.cbbListFilter.addItem(value); this.cbbListFilter.paintImmediately(this.cbbListFilter.getVisibleRect()); }
    public void setcbbCivilState(String value) { this.cbbCivilState.addItem(value); this.cbbCivilState.paintImmediately(this.cbbCivilState.getVisibleRect()); }
    public void setcbbDay(String value) { this.cbbDay.addItem(value); this.cbbDay.paintImmediately(this.cbbDay.getVisibleRect()); }
    public void setcbbDocType(String value) { this.cbbDocType.addItem(value); this.cbbDocType.paintImmediately(this.cbbDocType.getVisibleRect()); }
    public void setcbbEmissionUF(String value) { this.cbbEmissionUF.addItem(value); this.cbbEmissionUF.paintImmediately(this.cbbEmissionUF.getVisibleRect()); }
    public void setcbbIdentityType(String value) { this.cbbIdentityType.addItem(value); this.cbbIdentityType.paintImmediately(this.cbbIdentityType.getVisibleRect()); }
    public void setcbbMonth(String value) { this.cbbMonth.addItem(value); this.cbbMonth.paintImmediately(this.cbbMonth.getVisibleRect()); }
    public void setcbbAccountStatus(String value) { this.cbbAccountStatus.addItem(value); this.cbbAccountStatus.paintImmediately(this.cbbAccountStatus.getVisibleRect()); }
    public void setcbbAccountType(String value) { this.cbbAccountType.addItem(value); this.cbbAccountType.paintImmediately(this.cbbAccountType.getVisibleRect()); }
    public void setcbbSex(String value) { this.cbbSex.addItem(value); this.cbbSex.paintImmediately(this.cbbSex.getVisibleRect()); }
    
    // ComboBox Specific Setters
    public void setcbbAccountListFilterItemIndex(int value) { this.cbbListFilter.setSelectedIndex(value); }
    public void setcbbCivilStateItemIndex(int value) { this.cbbCivilState.setSelectedIndex(value); }
    public void setcbbDayItemIndex(int value) { this.cbbDay.setSelectedIndex(value); }
    public void setcbbDocTypeItemIndex(int value) { this.cbbDocType.setSelectedIndex(value); }
    public void setcbbEmissionUFItemIndex(int value) { this.cbbEmissionUF.setSelectedIndex(value); }
    public void setcbbIdentityTypeItemIndex(int value) { this.cbbIdentityType.setSelectedIndex(value); }
    public void setcbbMonthItemIndex(int value) { this.cbbMonth.setSelectedIndex(value); }
    public void setcbbAccountStatusItemIndex(int value) { this.cbbAccountStatus.setSelectedIndex(value); }
    public void setcbbAccountTypeItemIndex(int value) { this.cbbAccountType.setSelectedIndex(value); }
    public void setcbbSexItemIndex(int value) { this.cbbSex.setSelectedIndex(value); }
    
    public void setlblRecCount(String value) { this.lblRecCount.setText("Registros: " + value); this.lblRecCount.paintImmediately(this.lblRecCount.getVisibleRect()); }
    public void setlblAccountNameHeader(String value) { this.lblAccountNameHeader.setText(value); this.lblAccountNameHeader.paintImmediately(this.lblAccountNameHeader.getVisibleRect()); }
    public void setlblSurname(String value) { this.lblSurname.setText(value); this.lblSurname.paintImmediately(this.lblSurname.getVisibleRect()); }
    public void setlblBirthDate(String value) { this.lblBirthDate.setText(value); this.lblBirthDate.paintImmediately(this.lblBirthDate.getVisibleRect()); }
    
    // Component Getters
    public String gettxtRowId() { return ((!"".equals(this.txtRowId.getText()) && this.txtRowId.getText() != null) ? this.txtRowId.getText() : null); }
    public String gettxtAccountNumber() { return ((!"".equals(this.txtAccountNumber.getText()) && this.txtAccountNumber.getText() != null) ? this.txtAccountNumber.getText() : null); }
    public String gettxtDocNum() { return ((!"".equals(this.txtDocNum.getText()) && this.txtDocNum.getText() != null) ? this.txtDocNum.getText() : null); }
    public String gettxtName() { return ((!"".equals(this.txtName.getText()) && this.txtName.getText() != null) ? this.txtName.getText() : null); }
    public String gettxtSurname() { return ((!"".equals(this.txtSurname.getText()) && this.txtSurname.getText() != null) ? this.txtSurname.getText() : null); }
    public String gettxtNickName() { return ((!"".equals(this.txtNickName.getText()) && this.txtNickName.getText() != null) ? this.txtNickName.getText() : null); }
    public String gettxtYear() { return ((!"".equals(this.txtYear.getText()) && this.txtYear.getText() != null) ? this.txtYear.getText() : null); }
    public String gettxtBornLocation() { return ((!"".equals(this.txtBornLocation.getText()) && this.txtBornLocation.getText() != null) ? this.txtBornLocation.getText() : null); }
    public String gettxtSpouseName() { return ((!"".equals(this.txtSpouseName.getText()) && this.txtSpouseName.getText() != null) ? this.txtSpouseName.getText() : null); }
    public String gettxtMotherName() { return ((!"".equals(this.txtMotherName.getText()) && this.txtMotherName.getText() != null) ? this.txtMotherName.getText() : null); }
    public String gettxtFatherName() { return ((!"".equals(this.txtFatherName.getText()) && this.txtFatherName.getText() != null) ? this.txtFatherName.getText() : null); }
    public String gettxtRecNum() { return ((!"".equals(this.txtRecNum.getText()) && this.txtRecNum.getText() != null) ? this.txtRecNum.getText() : null); }
    public String gettxtSerieNum() { return ((!"".equals(this.txtSerieNum.getText()) && this.txtSerieNum.getText() != null) ? this.txtSerieNum.getText() : null); }
    public String gettxtEmissor() { return ((!"".equals(this.txtEmissor.getText()) && this.txtEmissor.getText() != null) ? this.txtEmissor.getText() : null); }
    public String gettxtEmissionDate() { return ((!"".equals(this.txtEmissionDate.getText()) && this.txtEmissionDate.getText() != null) ? this.txtEmissionDate.getText() : null); }
    public String gettxtValidThru() { return ((!"".equals(this.txtValidThru.getText()) && this.txtValidThru.getText() != null) ? this.txtValidThru.getText() : null); }
    public String gettxtNaturalness() { return ((!"".equals(this.txtNaturalness.getText()) && this.txtNaturalness.getText() != null) ? this.txtNaturalness.getText() : null); }
    public String gettxtNationality() { return ((!"".equals(this.txtNationality.getText()) && this.txtNationality.getText() != null) ? this.txtNationality.getText() : null); }
    public String gettxtListFilterValue() { return ((!"".equals(this.txtListFilterValue.getText()) && this.txtListFilterValue.getText() != null) ? this.txtListFilterValue.getText() : null); }
    public String gettxtContactMPhone() { return ((!"".equals(this.txtContactMPhone.getText()) && this.txtContactMPhone.getText() != null) ? this.txtContactMPhone.getText() : null); }
    public String gettxtContactEmail() { return ((!"".equals(this.txtContactEmail.getText()) && this.txtContactEmail.getText() != null) ? this.txtContactEmail.getText() : null); }
    public String gettxtContactPhone() { return ((!"".equals(this.txtContactPhone.getText()) && this.txtContactPhone.getText() != null) ? this.txtContactPhone.getText() : null); }
    public String gettxtContactEnterprise() { return ((!"".equals(this.txtContactEnterprise.getText()) && this.txtContactEnterprise.getText() != null) ? this.txtContactEnterprise.getText() : null); }
    public String gettxtFacebook() { return ((!"".equals(this.txtFacebook.getText()) && this.txtFacebook.getText() != null) ? this.txtFacebook.getText() : null); }
    public String gettxtInstagram() { return ((!"".equals(this.txtInstagram.getText()) && this.txtInstagram.getText() != null) ? this.txtInstagram.getText() : null); }
    public String gettxtTwitter() { return ((!"".equals(this.txtTwitter.getText()) && this.txtTwitter.getText() != null) ? this.txtTwitter.getText() : null); }    
    public String gettxtFullAddress() { return ((!"".equals(this.txtFullAddress.getText()) && this.txtFullAddress.getText() != null) ? this.txtFullAddress.getText() : null); }
    
    public String getcbbListFilter() { return ((!"".equals(this.cbbListFilter.getSelectedItem().toString()) && !"Selecione...".equals(this.cbbListFilter.getSelectedItem().toString()) && this.cbbListFilter.getSelectedItem().toString() != null) ? this.cbbListFilter.getSelectedItem().toString() : null); }
    public String getcbbCivilState() { return ((!"".equals(this.cbbCivilState.getSelectedItem().toString()) && !"Selecione...".equals(this.cbbCivilState.getSelectedItem().toString()) && this.cbbCivilState.getSelectedItem().toString() != null) ? this.cbbCivilState.getSelectedItem().toString() : null); }
    public String getcbbDay() { return ((!"".equals(this.cbbDay.getSelectedItem().toString()) && !"Selecione...".equals(this.cbbDay.getSelectedItem().toString()) && this.cbbDay.getSelectedItem().toString() != null) ? this.cbbDay.getSelectedItem().toString() : null); }
    public String getcbbDocType() { return ((!"".equals(this.cbbDocType.getSelectedItem().toString()) && !"Selecione...".equals(this.cbbDocType.getSelectedItem().toString()) && this.cbbDocType.getSelectedItem().toString() != null) ? this.cbbDocType.getSelectedItem().toString() : null); }
    public String getcbbEmissionUF() { return ((!"".equals(this.cbbEmissionUF.getSelectedItem().toString()) && !"Selecione...".equals(this.cbbEmissionUF.getSelectedItem().toString()) && this.cbbEmissionUF.getSelectedItem().toString() != null) ? this.cbbEmissionUF.getSelectedItem().toString() : null); }
    public String getcbbIdentityType() { return ((!"".equals(this.cbbIdentityType.getSelectedItem().toString()) && !"Selecione...".equals(this.cbbIdentityType.getSelectedItem().toString()) && this.cbbIdentityType.getSelectedItem().toString() != null) ? this.cbbIdentityType.getSelectedItem().toString() : null); }
    public String getcbbMonth() { return ((!"".equals(this.cbbMonth.getSelectedItem().toString()) && !"Selecione...".equals(this.cbbMonth.getSelectedItem().toString()) && this.cbbMonth.getSelectedItem().toString() != null) ? this.cbbMonth.getSelectedItem().toString() : null); }
    public String getcbbAccountStatus() { return ((!"".equals(this.cbbAccountStatus.getSelectedItem().toString()) && !"Selecione...".equals(this.cbbAccountStatus.getSelectedItem().toString()) && this.cbbAccountStatus.getSelectedItem().toString() != null) ? this.cbbAccountStatus.getSelectedItem().toString() : null); }
    public String getcbbAccountType() { return ((!"".equals(this.cbbAccountType.getSelectedItem().toString()) && !"Selecione...".equals(this.cbbAccountType.getSelectedItem().toString()) && this.cbbAccountType.getSelectedItem().toString() != null) ? this.cbbAccountType.getSelectedItem().toString() : null); }
    public String getcbbSex() { return ((!"".equals(this.cbbSex.getSelectedItem().toString()) && !"Selecione...".equals(this.cbbSex.getSelectedItem().toString()) && this.cbbSex.getSelectedItem().toString() != null) ? this.cbbSex.getSelectedItem().toString() : null); }
    
    // ComboBox Specific Getters
    public int getcbbAccountListFilterItemIndex(String value) { if(!"".equals(value) && value != null) { for(int i = 0; i < this.cbbListFilter.getItemCount(); i++){ if(value.equals(this.cbbListFilter.getItemAt(i))){ return i; }}} else { return 0; } return 0; }
    public int getcbbCivilStateItemIndex(String value) { if(!"".equals(value) && value != null) { for(int i = 0; i < this.cbbCivilState.getItemCount(); i++){ if(value.equals(this.cbbCivilState.getItemAt(i))){ return i; }}} else { return 0; } return 0; }
    public int getcbbDayItemIndex(String value) { if(!"".equals(value) && value != null) { for(int i = 0; i < this.cbbDay.getItemCount(); i++){ if(value.equals(this.cbbDay.getItemAt(i))){ return i; }}} else { return 0; } return 0; }
    public int getcbbDocTypeItemIndex(String value) { if(!"".equals(value) && value != null) { for(int i = 0; i < this.cbbDocType.getItemCount(); i++){ if(value.equals(this.cbbDocType.getItemAt(i))){ return i; }}} else { return 0; } return 0; }
    public int getcbbEmissionUFItemIndex(String value) { if(!"".equals(value) && value != null) { for(int i = 0; i < this.cbbEmissionUF.getItemCount(); i++){ if(value.equals(this.cbbEmissionUF.getItemAt(i))){ return i; }}} else { return 0; } return 0; }
    public int getcbbIdentityTypeItemIndex(String value) { if(!"".equals(value) && value != null) { for(int i = 0; i < this.cbbIdentityType.getItemCount(); i++){ if(value.equals(this.cbbIdentityType.getItemAt(i))){ return i; }}} else { return 0; } return 0; }
    public int getcbbMonthItemIndex(String value) { if(!"".equals(value) && value != null) { for(int i = 0; i < this.cbbMonth.getItemCount(); i++) { if(value.equals(this.cbbMonth.getItemAt(i))) { return i; }}} else { return 0; } return 0; }
    public int getcbbAccountStatusItemIndex(String value) { if(!"".equals(value) && value != null) { for(int i = 0; i < this.cbbAccountStatus.getItemCount(); i++){ if(value.equals(this.cbbAccountStatus.getItemAt(i))){ return i; }}} else { return 0; } return 0; }
    public int getcbbAccountTypeItemIndex(String value) { if(!"".equals(value) && value != null) { for(int i = 0; i < this.cbbAccountType.getItemCount(); i++){ if(value.equals(this.cbbAccountType.getItemAt(i))){ return i; }}} else { return 0; } return 0; }
    public int getcbbSexItemIndex(String value) { if(!"".equals(value) && value != null) { for(int i = 0; i < this.cbbSex.getItemCount(); i++){ if(value.equals(this.cbbSex.getItemAt(i))){ return i; }}} else { return 0; } return 0; }
        
    public String getlblRecCount() { return this.lblRecCount.getText(); }
    public String getlblAccountNameHeader() { return this.lblAccountNameHeader.getText(); }
    
    // Component Clear
    public void cleartxtListFilterValue() { this.txtListFilterValue.setText(""); this.txtListFilterValue.paintImmediately(this.txtListFilterValue.getVisibleRect()); }
    public void cleartxtRowId() { this.txtRowId.setText(""); this.txtRowId.paintImmediately(this.txtRowId.getVisibleRect()); }
    public void cleartxtAccountNumber() { this.txtAccountNumber.setText(""); this.txtAccountNumber.paintImmediately(this.txtAccountNumber.getVisibleRect()); }
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
    
    public void clearcbbAccountListFilter() { this.cbbListFilter.removeAllItems(); this.cbbListFilter.paintImmediately(this.cbbListFilter.getVisibleRect()); }
    public void clearcbbCivilState() { this.cbbCivilState.removeAllItems(); this.cbbCivilState.paintImmediately(this.cbbCivilState.getVisibleRect()); }
    public void clearcbbDay() { this.cbbDay.removeAllItems(); this.cbbDay.paintImmediately(this.cbbDay.getVisibleRect()); }
    public void clearcbbDocType() { this.cbbDocType.removeAllItems(); this.cbbDocType.paintImmediately(this.cbbDocType.getVisibleRect()); }
    public void clearcbbEmissionUF() { this.cbbEmissionUF.removeAllItems(); this.cbbEmissionUF.paintImmediately(this.cbbEmissionUF.getVisibleRect()); }
    public void clearcbbIdentityType() { this.cbbIdentityType.removeAllItems(); this.cbbIdentityType.paintImmediately(this.cbbIdentityType.getVisibleRect()); }
    public void clearcbbMonth() { this.cbbMonth.removeAllItems(); this.cbbMonth.paintImmediately(this.cbbMonth.getVisibleRect()); }
    public void clearcbbAccountStatus() { this.cbbAccountStatus.removeAllItems(); this.cbbAccountStatus.paintImmediately(this.cbbAccountStatus.getVisibleRect()); }
    public void clearcbbAccountType() { this.cbbAccountType.removeAllItems(); this.cbbAccountType.paintImmediately(this.cbbAccountType.getVisibleRect()); }
    public void clearcbbSex() { this.cbbSex.removeAllItems(); this.cbbSex.paintImmediately(this.cbbSex.getVisibleRect()); }
    
    public void clearlblRecCount() { this.lblRecCount.setText(""); this.lblRecCount.paintImmediately(this.lblRecCount.getVisibleRect()); }
    public void clearlblAccountNameHeader() { this.lblAccountNameHeader.setText(""); this.lblAccountNameHeader.paintImmediately(this.lblAccountNameHeader.getVisibleRect()); }

    // Enable or Disable Components
    public void settxtAccountListFilterValueEnabled(boolean status) { this.txtListFilterValue.setEnabled(status); }
    public void settxtRowIdEnabled(boolean status) { this.txtRowId.setEnabled(status); }
    public void settxtAccountNumberEnabled(boolean status) { this.txtAccountNumber.setEnabled(status); }
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
    
    public void setcbbAccountListFilterEnabled(boolean status) { this.cbbListFilter.setEnabled(status); }
    public void setcbbCivilStateEnabled(boolean status) { this.cbbCivilState.setEnabled(status); }
    public void setcbbDayEnabled(boolean status) { this.cbbDay.setEnabled(status); }
    public void setcbbDocTypeEnabled(boolean status) { this.cbbDocType.setEnabled(status); }
    public void setcbbEmissionUFEnabled(boolean status) { this.cbbEmissionUF.setEnabled(status); }
    public void setcbbIdentityTypeEnabled(boolean status) { this.cbbIdentityType.setEnabled(status); }
    public void setcbbMonthEnabled(boolean status) { this.cbbMonth.setEnabled(status); }
    public void setcbbAccountStatusEnabled(boolean status) { this.cbbAccountStatus.setEnabled(status); }
    public void setcbbAccountTypeEnabled(boolean status) { this.cbbAccountType.setEnabled(status); }
    public void setcbbSexEnabled(boolean status) { this.cbbSex.setEnabled(status); }
    
    public void setlblRecCountEnabled(boolean status) { this.lblRecCount.setEnabled(status); }
    public void setlblAccountNameHeaderEnabled(boolean status) { this.lblAccountNameHeader.setEnabled(status); }
    
    public void setTblEnabled(boolean status) { this.tblAccountList.setEnabled(status); }
    
    public void setbtnEditEnabled(boolean status) { this.btnEdit.setEnabled(status); }
    public void setbtnNewEnabled(boolean status) { this.btnNew.setEnabled(status); }
    public void setbtnSaveEnabled(boolean status) { this.btnSave.setEnabled(status); }
    public void setbtnDeleteEnabled(boolean status) { this.btnDelete.setEnabled(status); }
    public void setbtnCancelEnabled(boolean status) { this.btnCancel.setEnabled(status); }
    public void setbtnAddContactEnabled(boolean status) { this.btnAddContact.setEnabled(status); }
    public void setbtnAddAddressEnabled(boolean status) { this.btnAddAddress.setEnabled(status); }
    
    // Return componet status
    public boolean istxtAccountListFilterValueEnabled() { return this.txtListFilterValue.isEnabled(); }
    public boolean istxtRowIdEnabled() { return this.txtRowId.isEnabled(); }
    public boolean istxtAccountNumberEnabled() { return this.txtAccountNumber.isEnabled(); }
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
    
    public boolean iscbbAccountListFilterEnabled() { return this.cbbListFilter.isEnabled(); }
    public boolean iscbbCivilStateEnabled() { return this.cbbCivilState.isEnabled(); }
    public boolean iscbbDayEnabled() { return this.cbbDay.isEnabled(); }
    public boolean iscbbDocTypeEnabled() { return this.cbbDocType.isEnabled(); }
    public boolean iscbbEmissionUFEnabled() { return this.cbbEmissionUF.isEnabled(); }
    public boolean iscbbIdentityTypeEnabled() { return this.cbbIdentityType.isEnabled(); }
    public boolean iscbbMonthEnabled() { return this.cbbMonth.isEnabled(); }
    public boolean iscbbAccountStatusEnabled() { return this.cbbAccountStatus.isEnabled(); }
    public boolean iscbbAccountTypeEnabled() { return this.cbbAccountType.isEnabled(); }
    public boolean iscbbSexEnabled() { return this.cbbSex.isEnabled(); }
    
    public boolean islblRecCountEnabled() { return this.lblRecCount.isEnabled(); }
    public boolean islblAccountNameHeaderEnabled() { return this.lblAccountNameHeader.isEnabled(); }
    
    public boolean isbtnEditEnabled() { return this.btnEdit.isEnabled(); }
    public boolean isbtnNewEnabled() { return this.btnNew.isEnabled(); }
    public boolean isbtnSaveEnabled() { return this.btnSave.isEnabled(); }
    public boolean isbtnCancelEnabled() { return this.btnCancel.isEnabled(); }
    public boolean isbtnDeleteEnabled() { return this.btnDelete.isEnabled(); }
    public boolean isbtnAddContactEnabled() { return this.btnAddContact.isEnabled(); }
    public boolean isbtnAddAddressEnabled() { return this.btnAddAddress.isEnabled(); }
    
    public boolean isTblAccountListEnabled() { return this.tblAccountList.isEnabled(); }
    
    // Button Functions
    public void clickSave(){ this.btnSave.setEnabled(true); this.btnSave.doClick(); this.btnSave.setEnabled(false); }
    public void clickNew(){ this.btnNew.setEnabled(true); this.btnNew.doClick(); this.btnNew.setEnabled(false); }
    public void clickEdit(){ this.btnEdit.setEnabled(true); this.btnEdit.doClick(); this.btnEdit.setEnabled(false); }
    public void clickCancel(){ this.btnCancel.setEnabled(true); this.btnCancel.doClick(); this.btnCancel.setEnabled(false); }
    public void clickDelete(){ this.btnDelete.setEnabled(true); this.btnDelete.doClick(); this.btnDelete.setEnabled(false); }
    
    // Set Focus on Specific component
    public void setFocus(String component) {
        switch (component) {
            case "FILTRO_VALOR": this.txtListFilterValue.requestFocus(); break;
            case "ID": this.txtRowId.requestFocus(); break;
            case "NUMERO_CLIENTE": this.txtAccountNumber.requestFocus(); break;
            case "DOCUMENTO_TIPO": this.cbbDocType.requestFocus(); break;
            case "NUM_DOCUMENTO": this.txtDocNum.requestFocus(); break;
            case "NOME": this.txtName.requestFocus(); break;
            case "SOBRENOME": this.txtSurname.requestFocus(); break;
            case "APELIDO": this.txtNickName.requestFocus(); break;
            case "SEXO": this.cbbSex.requestFocus(); break;
            case "NASCIMENTO_DIA": this.cbbDay.requestFocus(); break;
            case "NASCIMENTO_MES": this.cbbMonth.requestFocus(); break;
            case "NASCIMENTO_ANO": this.txtYear.requestFocus(); break;
            case "NASCIMENTO_LOCAL": this.txtBornLocation.requestFocus(); break;
            case "NOME_CONJUJE": this.txtSpouseName.requestFocus(); break;
            case "NOME_MAE": this.txtMotherName.requestFocus(); break;
            case "NOME_PAI": this.txtFatherName.requestFocus(); break;
            case "REGISTRO_TIPO": this.cbbIdentityType.requestFocus(); break;
            case "REGISTRO_NUMERO": this.txtRecNum.requestFocus(); break;
            case "REGISTRO_SERIE": this.txtSerieNum.requestFocus(); break;
            case "REGISTRO_EMISSOR": this.txtEmissor.requestFocus(); break;
            case "REGISTRO_DT_EMISSAO": this.txtEmissionDate.requestFocus(); break;
            case "REGISTRO_DT_VALIDADE": this.txtValidThru.requestFocus(); break;
            case "REGISTRO_UF_EMISSAO": this.cbbEmissionUF.requestFocus(); break;
            case "REGISTRO_NATURALIDADE": this.txtNaturalness.requestFocus(); break;
            case "REGISTRO_NACIONALIDADE": this.txtNationality.requestFocus(); break;
            case "FILTRO": this.cbbListFilter.requestFocus(); break;
            case "ESTADO_CIVIL": this.cbbCivilState.requestFocus(); break;
            case "STATUS": this.cbbAccountStatus.requestFocus(); break;
            case "TIPO": this.cbbAccountType.requestFocus(); break;
            case "CONTATO_CELULAR": this.txtContactMPhone.requestFocus(); break;
            case "CONTATO_EMAIL": this.txtContactEmail.requestFocus(); break;
            case "CONTATO_TELEFONE_FIXO": this.txtContactPhone.requestFocus(); break;
            case "CONTATO_TELEFONE_COMERCIAL": this.txtContactEnterprise.requestFocus(); break;
            case "REDE_SOCIAL_FACEBOOK": this.txtFacebook.requestFocus(); break;
            case "REDE_SOCIAL_INSTAGRAM": this.txtInstagram.requestFocus(); break;
            case "REDE_SOCIAL_TWITTER": this.txtTwitter.requestFocus(); break;
            case "ENDERECO_COMPLETO": this.txtFullAddress.requestFocus(); break;
            case "BOTAO_EDITAR": this.btnEdit.requestFocus(); break;
            case "BOTAO_NOVO": this.btnNew.requestFocus(); break;
            case "BOTAO_SALVAR": this.btnSave.requestFocus(); break;
            case "BOTAO_CANCELAR": this.btnCancel.requestFocus(); break;
            case "BOTAO_DELETAR": this.btnDelete.requestFocus(); break;
            case "BOTAO_ADD_CONTATO": this.btnAddContact.requestFocus(); break;
            case "BOTAO_ADD_ENDERECO": this.btnAddAddress.requestFocus(); break;
            default: break;
        }
    }
    
    public void enableFields(String funcao) {
	switch (funcao){
            case "LOAD_SCREEN":
                settxtAccountListFilterValueEnabled(true);
                settxtRowIdEnabled(false);
                settxtAccountNumberEnabled(false);
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

                setcbbAccountListFilterEnabled(true);
                setcbbCivilStateEnabled(false);
                setcbbDayEnabled(false);
                setcbbDocTypeEnabled(false);
                setcbbEmissionUFEnabled(false);
                setcbbIdentityTypeEnabled(false);
                setcbbMonthEnabled(false);
                setcbbAccountStatusEnabled(false);
                setcbbAccountTypeEnabled(false);
                setcbbSexEnabled(false);
                
                setTblEnabled(true);

                setbtnEditEnabled(false);
                setbtnNewEnabled(true);
                setbtnSaveEnabled(false);
                setbtnDeleteEnabled(false);
                setbtnCancelEnabled(false);
                setbtnAddContactEnabled(false);
                setbtnAddAddressEnabled(false);
                break;
            case "NOVO":
                settxtAccountListFilterValueEnabled(true);
                settxtRowIdEnabled(false);
                settxtAccountNumberEnabled(false);
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

                setcbbAccountListFilterEnabled(true);
                setcbbCivilStateEnabled(true);
                setcbbDayEnabled(true);
                setcbbDocTypeEnabled(true);
                setcbbEmissionUFEnabled(true);
                setcbbIdentityTypeEnabled(true);
                setcbbMonthEnabled(true);
                setcbbAccountStatusEnabled(true);
                setcbbAccountTypeEnabled(true);
                setcbbSexEnabled(true);
                
                setTblEnabled(false);
                
                setbtnEditEnabled(false);
                setbtnNewEnabled(false);
                setbtnSaveEnabled(true);
                setbtnCancelEnabled(true);
                setbtnDeleteEnabled(false);
                setbtnAddContactEnabled(true);
                setbtnAddAddressEnabled(true);
                break;
            case "EDITAR":
                settxtAccountListFilterValueEnabled(true);
                settxtRowIdEnabled(false);
                settxtAccountNumberEnabled(false);
                settxtDocNumEnabled((gettxtDocNum() == null));
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

                setcbbAccountListFilterEnabled(true);
                setcbbCivilStateEnabled(true);
                setcbbDayEnabled(true);
                setcbbDocTypeEnabled((getcbbDocType() == null));
                setcbbEmissionUFEnabled(true);
                setcbbIdentityTypeEnabled(true);
                setcbbMonthEnabled(true);
                setcbbAccountStatusEnabled(true);
                setcbbAccountTypeEnabled(true);
                setcbbSexEnabled(true);
                
                setTblEnabled(false);
                
                setbtnEditEnabled(false);
                setbtnDeleteEnabled(false);
                setbtnNewEnabled(false);
                setbtnSaveEnabled(true);
                setbtnCancelEnabled(true);
                setbtnAddContactEnabled(true);
                setbtnAddAddressEnabled(true);
                break;
            case "CANCELAR":
                settxtAccountListFilterValueEnabled(true);
                settxtRowIdEnabled(false);
                settxtAccountNumberEnabled(false);
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

                setcbbAccountListFilterEnabled(true);
                setcbbCivilStateEnabled(false);
                setcbbDayEnabled(false);
                setcbbDocTypeEnabled(false);
                setcbbEmissionUFEnabled(false);
                setcbbIdentityTypeEnabled(false);
                setcbbMonthEnabled(false);
                setcbbAccountStatusEnabled(false);
                setcbbAccountTypeEnabled(false);
                setcbbSexEnabled(false);
                
                setTblEnabled(true);
                
                setbtnEditEnabled(true);
                setbtnDeleteEnabled(true);
                setbtnNewEnabled(true);
                setbtnSaveEnabled(false);
                setbtnCancelEnabled(false);
                setbtnAddContactEnabled(false);
                setbtnAddAddressEnabled(false);
                break;
            case "DELETAR":
                settxtAccountListFilterValueEnabled(true);
                settxtRowIdEnabled(false);
                settxtAccountNumberEnabled(false);
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

                setcbbAccountListFilterEnabled(true);
                setcbbCivilStateEnabled(false);
                setcbbDayEnabled(false);
                setcbbDocTypeEnabled(false);
                setcbbEmissionUFEnabled(false);
                setcbbIdentityTypeEnabled(false);
                setcbbMonthEnabled(false);
                setcbbAccountStatusEnabled(false);
                setcbbAccountTypeEnabled(false);
                setcbbSexEnabled(false);
                
                setTblEnabled(true);
                
                setbtnEditEnabled(true);
                setbtnDeleteEnabled(true);
                setbtnNewEnabled(true);
                setbtnSaveEnabled(false);
                setbtnCancelEnabled(false);
                setbtnAddContactEnabled(false);
                setbtnAddAddressEnabled(false);
                break;
            case "SALVAR":
                settxtAccountListFilterValueEnabled(true);
                settxtRowIdEnabled(false);
                settxtAccountNumberEnabled(false);
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

                setcbbAccountListFilterEnabled(true);
                setcbbCivilStateEnabled(false);
                setcbbDayEnabled(false);
                setcbbDocTypeEnabled(false);
                setcbbEmissionUFEnabled(false);
                setcbbIdentityTypeEnabled(false);
                setcbbMonthEnabled(false);
                setcbbAccountStatusEnabled(false);
                setcbbAccountTypeEnabled(false);
                setcbbSexEnabled(false);
                
                setTblEnabled(true);
                
                setbtnEditEnabled(true);
                setbtnDeleteEnabled(true);
                setbtnNewEnabled(true);
                setbtnSaveEnabled(false);
                setbtnCancelEnabled(false);
                setbtnAddContactEnabled(false);
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
        setcbbAccountStatusItemIndex(0);
        setcbbAccountTypeItemIndex(0);
        setcbbSexItemIndex(0);
        
        clearlblAccountNameHeader();
    }
    
    public void clearComboBoxes(){
        clearcbbAccountListFilter();
        clearcbbCivilState();
        clearcbbDay();
        clearcbbDocType();
        clearcbbEmissionUF();
        clearcbbIdentityType();
        clearcbbMonth();
        clearcbbAccountStatus();
        clearcbbAccountType();
        clearcbbSex();
    }
    
    public void insertSelectComboBox(){
        this.setcbbListFilter("Selecione...");
        this.setcbbCivilState("Selecione...");
        this.setcbbDay("Selecione...");
        this.setcbbDocType("Selecione...");
        this.setcbbEmissionUF("Selecione...");
        this.setcbbIdentityType("Selecione...");
        this.setcbbMonth("Selecione...");
        this.setcbbAccountStatus("Selecione...");
        this.setcbbAccountType("Selecione...");
        this.setcbbSex("Selecione...");
    }
    
    public final void FocusTraversalKeys(){
        this.txtListFilterValue.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtRowId.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtAccountNumber.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
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

        this.cbbListFilter.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.cbbCivilState.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.cbbDay.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.cbbDocType.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.cbbEmissionUF.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.cbbIdentityType.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.cbbMonth.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.cbbAccountStatus.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.cbbAccountType.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.cbbSex.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);

        this.lblRecCount.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.lblAccountNameHeader.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
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
        TabPnlUserForm = new javax.swing.JTabbedPane();
        PanelAccountInfo = new javax.swing.JPanel();
        PanelAccountInfoForm = new javax.swing.JScrollPane();
        PanelFormAccountInfo = new javax.swing.JPanel();
        lblPersonalData = new javax.swing.JLabel();
        lblRowId = new javax.swing.JLabel();
        txtRowId = new javax.swing.JTextField();
        lblAccountNumber = new javax.swing.JLabel();
        txtAccountNumber = new javax.swing.JTextField();
        lblDocType = new javax.swing.JLabel();
        cbbDocType = new javax.swing.JComboBox<>();
        lblDocNum = new javax.swing.JLabel();
        txtDocNum = new javax.swing.JTextField();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblSurname = new javax.swing.JLabel();
        txtSurname = new javax.swing.JTextField();
        lblSex = new javax.swing.JLabel();
        cbbSex = new javax.swing.JComboBox<>();
        lblNickname = new javax.swing.JLabel();
        txtNickName = new javax.swing.JTextField();
        lblBirthDate = new javax.swing.JLabel();
        cbbDay = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cbbMonth = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        txtYear = new javax.swing.JTextField();
        lblBornLocation = new javax.swing.JLabel();
        txtBornLocation = new javax.swing.JTextField();
        lblAccountStatus = new javax.swing.JLabel();
        cbbAccountStatus = new javax.swing.JComboBox<>();
        lblAccountType = new javax.swing.JLabel();
        cbbAccountType = new javax.swing.JComboBox<>();
        PanelAccountContAddr = new javax.swing.JPanel();
        PanelAccountContAddrForm = new javax.swing.JScrollPane();
        PanelFormAccountContAddr = new javax.swing.JPanel();
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
        PanelAccountMoreInfo = new javax.swing.JPanel();
        PanelAccountMoreInfoForm = new javax.swing.JScrollPane();
        PanelFormAccountMoreInfo = new javax.swing.JPanel();
        lblIdentityInformation1 = new javax.swing.JLabel();
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
        PanelAccountOrders = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        PanelAccountOrderListView = new javax.swing.JPanel();
        PanelAccountOrderListHeader = new javax.swing.JPanel();
        lblAccountOrderList = new javax.swing.JLabel();
        lblOrderImage = new javax.swing.JLabel();
        cbbListOrderFilter = new javax.swing.JComboBox<>();
        txtListOrderFilterValue = new javax.swing.JTextField();
        lblInformation1 = new javax.swing.JLabel();
        lblAccountOrderRecCount = new javax.swing.JLabel();
        PanelAccountOrderList = new javax.swing.JScrollPane();
        tblAccountOrderList = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Clientes");

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
                .addComponent(cbbListFilter, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtListFilterValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInformation)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRecCount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                "Número do Cliente", "CPF", "Nome", "Apelido", "Data de Nascimento", "Estado Civil", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
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
            .addComponent(sPanelAccountList, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
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
        btnQuery.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
        btnNew.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
        btnSave.setBorderPainted(false);
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
        btnCancel.setBorderPainted(false);
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
                    .addComponent(lblAccountNameHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblAccountFormInformation, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        TabPnlUserForm.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        PanelAccountInfoForm.setBorder(null);
        PanelAccountInfoForm.setMinimumSize(new java.awt.Dimension(0, 0));

        PanelFormAccountInfo.setBackground(new java.awt.Color(255, 255, 255));
        PanelFormAccountInfo.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        PanelFormAccountInfo.setPreferredSize(new java.awt.Dimension(1004, 193));

        lblPersonalData.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblPersonalData.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPersonalData.setText("   Dados Pessoais");
        lblPersonalData.setToolTipText("");
        lblPersonalData.setEnabled(false);
        lblPersonalData.setOpaque(true);

        lblRowId.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblRowId.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblRowId.setText("Id:");
        lblRowId.setEnabled(false);

        txtRowId.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtRowId.setText("jTextField1");
        txtRowId.setEnabled(false);

        lblAccountNumber.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblAccountNumber.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAccountNumber.setText("Número do Cliente:");
        lblAccountNumber.setEnabled(false);

        txtAccountNumber.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtAccountNumber.setText("jTextField1");
        txtAccountNumber.setEnabled(false);
        txtAccountNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAccountNumberKeyPressed(evt);
            }
        });

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

        lblBirthDate.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblBirthDate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblBirthDate.setText("Data de Nascimento:");
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

        lblAccountStatus.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblAccountStatus.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAccountStatus.setText("Status:");
        lblAccountStatus.setEnabled(false);

        cbbAccountStatus.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        cbbAccountStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbAccountStatus.setEnabled(false);
        cbbAccountStatus.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbAccountStatusItemStateChanged(evt);
            }
        });
        cbbAccountStatus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbbAccountStatusKeyPressed(evt);
            }
        });

        lblAccountType.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblAccountType.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAccountType.setText("Tipo de Cliente:");
        lblAccountType.setEnabled(false);

        cbbAccountType.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        cbbAccountType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbAccountType.setEnabled(false);
        cbbAccountType.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbAccountTypeItemStateChanged(evt);
            }
        });
        cbbAccountType.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbbAccountTypeKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout PanelFormAccountInfoLayout = new javax.swing.GroupLayout(PanelFormAccountInfo);
        PanelFormAccountInfo.setLayout(PanelFormAccountInfoLayout);
        PanelFormAccountInfoLayout.setHorizontalGroup(
            PanelFormAccountInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFormAccountInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelFormAccountInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblPersonalData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PanelFormAccountInfoLayout.createSequentialGroup()
                        .addGroup(PanelFormAccountInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelFormAccountInfoLayout.createSequentialGroup()
                                .addGroup(PanelFormAccountInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(PanelFormAccountInfoLayout.createSequentialGroup()
                                        .addComponent(lblDocType, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbbDocType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelFormAccountInfoLayout.createSequentialGroup()
                                        .addGroup(PanelFormAccountInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lblRowId, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                            .addComponent(lblAccountNumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(PanelFormAccountInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtAccountNumber)
                                            .addComponent(txtRowId, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(PanelFormAccountInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PanelFormAccountInfoLayout.createSequentialGroup()
                                        .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(PanelFormAccountInfoLayout.createSequentialGroup()
                                        .addComponent(lblSurname, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtSurname, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblSex, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(PanelFormAccountInfoLayout.createSequentialGroup()
                                .addComponent(lblDocNum, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDocNum, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblNickname, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelFormAccountInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbbSex, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtNickName, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelFormAccountInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelFormAccountInfoLayout.createSequentialGroup()
                                .addGroup(PanelFormAccountInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblAccountType, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblAccountStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelFormAccountInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbbAccountStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbbAccountType, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(PanelFormAccountInfoLayout.createSequentialGroup()
                                .addGroup(PanelFormAccountInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblBirthDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblBornLocation, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelFormAccountInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtBornLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(PanelFormAccountInfoLayout.createSequentialGroup()
                                        .addComponent(cbbDay, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtYear, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        PanelFormAccountInfoLayout.setVerticalGroup(
            PanelFormAccountInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFormAccountInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPersonalData, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelFormAccountInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelFormAccountInfoLayout.createSequentialGroup()
                        .addGroup(PanelFormAccountInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelFormAccountInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblRowId, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtRowId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelFormAccountInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelFormAccountInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelFormAccountInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblBornLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtBornLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelFormAccountInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtAccountNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblAccountNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblSurname, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtSurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelFormAccountInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbSex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSex, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbDocType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDocType, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelFormAccountInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDocNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNickname, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNickName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDocNum, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PanelFormAccountInfoLayout.createSequentialGroup()
                        .addGroup(PanelFormAccountInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblBirthDate, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(cbbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(txtYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(PanelFormAccountInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAccountStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbAccountStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelFormAccountInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAccountType, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbAccountType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(76, Short.MAX_VALUE))
        );

        PanelAccountInfoForm.setViewportView(PanelFormAccountInfo);

        javax.swing.GroupLayout PanelAccountInfoLayout = new javax.swing.GroupLayout(PanelAccountInfo);
        PanelAccountInfo.setLayout(PanelAccountInfoLayout);
        PanelAccountInfoLayout.setHorizontalGroup(
            PanelAccountInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1168, Short.MAX_VALUE)
            .addGroup(PanelAccountInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanelAccountInfoForm, javax.swing.GroupLayout.DEFAULT_SIZE, 1168, Short.MAX_VALUE))
        );
        PanelAccountInfoLayout.setVerticalGroup(
            PanelAccountInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 246, Short.MAX_VALUE)
            .addGroup(PanelAccountInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanelAccountInfoForm, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
        );

        TabPnlUserForm.addTab("Informações Principais", PanelAccountInfo);

        PanelAccountContAddrForm.setBorder(null);
        PanelAccountContAddrForm.setMinimumSize(new java.awt.Dimension(0, 0));

        PanelFormAccountContAddr.setBackground(new java.awt.Color(255, 255, 255));
        PanelFormAccountContAddr.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        PanelFormAccountContAddr.setPreferredSize(new java.awt.Dimension(1004, 193));

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

        btnAddContact.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
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

        lblAddressInformation.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblAddressInformation.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblAddressInformation.setText("   Informações do Endereço Principal:");
        lblAddressInformation.setEnabled(false);
        lblAddressInformation.setOpaque(true);

        lblAddAddress.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblAddAddress.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAddAddress.setText("Endereço:");
        lblAddAddress.setEnabled(false);

        btnAddAddress.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
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

        javax.swing.GroupLayout PanelFormAccountContAddrLayout = new javax.swing.GroupLayout(PanelFormAccountContAddr);
        PanelFormAccountContAddr.setLayout(PanelFormAccountContAddrLayout);
        PanelFormAccountContAddrLayout.setHorizontalGroup(
            PanelFormAccountContAddrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFormAccountContAddrLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelFormAccountContAddrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblContactInformation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PanelFormAccountContAddrLayout.createSequentialGroup()
                        .addComponent(lblContactEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtContactEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelFormAccountContAddrLayout.createSequentialGroup()
                        .addGroup(PanelFormAccountContAddrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAddContact, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblContactMPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelFormAccountContAddrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtContactMPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAddContact, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PanelFormAccountContAddrLayout.createSequentialGroup()
                        .addComponent(lblContactPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtContactPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelFormAccountContAddrLayout.createSequentialGroup()
                        .addComponent(lblContactEnterprise, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtContactEnterprise, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelFormAccountContAddrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblSocialMedia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PanelFormAccountContAddrLayout.createSequentialGroup()
                        .addComponent(lblFacebook, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFacebook, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelFormAccountContAddrLayout.createSequentialGroup()
                        .addComponent(lblInstagram, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtInstagram, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelFormAccountContAddrLayout.createSequentialGroup()
                        .addComponent(lblTwitter, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTwitter, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelFormAccountContAddrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PanelFormAccountContAddrLayout.createSequentialGroup()
                        .addComponent(lblAddAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelFormAccountContAddrLayout.createSequentialGroup()
                        .addComponent(lblFullAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFullAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblAddressInformation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelFormAccountContAddrLayout.setVerticalGroup(
            PanelFormAccountContAddrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFormAccountContAddrLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelFormAccountContAddrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelFormAccountContAddrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(PanelFormAccountContAddrLayout.createSequentialGroup()
                            .addComponent(lblAddressInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(57, 57, 57))
                        .addGroup(PanelFormAccountContAddrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelFormAccountContAddrLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(PanelFormAccountContAddrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblFullAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFullAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(PanelFormAccountContAddrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblAddAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnAddAddress))))
                    .addGroup(PanelFormAccountContAddrLayout.createSequentialGroup()
                        .addGroup(PanelFormAccountContAddrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblContactInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSocialMedia, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelFormAccountContAddrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelFormAccountContAddrLayout.createSequentialGroup()
                                .addGroup(PanelFormAccountContAddrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblAddContact, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnAddContact))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelFormAccountContAddrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblContactMPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtContactMPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(7, 7, 7)
                                .addGroup(PanelFormAccountContAddrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblContactEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtContactEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(PanelFormAccountContAddrLayout.createSequentialGroup()
                                .addGroup(PanelFormAccountContAddrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblFacebook, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFacebook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(7, 7, 7)
                                .addGroup(PanelFormAccountContAddrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblInstagram, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtInstagram, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelFormAccountContAddrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblTwitter, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTwitter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelFormAccountContAddrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblContactPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtContactPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelFormAccountContAddrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblContactEnterprise, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtContactEnterprise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelAccountContAddrForm.setViewportView(PanelFormAccountContAddr);

        javax.swing.GroupLayout PanelAccountContAddrLayout = new javax.swing.GroupLayout(PanelAccountContAddr);
        PanelAccountContAddr.setLayout(PanelAccountContAddrLayout);
        PanelAccountContAddrLayout.setHorizontalGroup(
            PanelAccountContAddrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1168, Short.MAX_VALUE)
            .addGroup(PanelAccountContAddrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanelAccountContAddrForm, javax.swing.GroupLayout.DEFAULT_SIZE, 1168, Short.MAX_VALUE))
        );
        PanelAccountContAddrLayout.setVerticalGroup(
            PanelAccountContAddrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 246, Short.MAX_VALUE)
            .addGroup(PanelAccountContAddrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanelAccountContAddrForm, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
        );

        TabPnlUserForm.addTab("Contato e Endereço", PanelAccountContAddr);

        PanelAccountMoreInfoForm.setBorder(null);
        PanelAccountMoreInfoForm.setMinimumSize(new java.awt.Dimension(0, 0));
        PanelAccountMoreInfoForm.setPreferredSize(new java.awt.Dimension(1329, 413));

        PanelFormAccountMoreInfo.setBackground(new java.awt.Color(255, 255, 255));
        PanelFormAccountMoreInfo.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        PanelFormAccountMoreInfo.setPreferredSize(new java.awt.Dimension(1004, 193));

        lblIdentityInformation1.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblIdentityInformation1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblIdentityInformation1.setText("   Informações de Identificação");
        lblIdentityInformation1.setToolTipText("");
        lblIdentityInformation1.setEnabled(false);
        lblIdentityInformation1.setOpaque(true);

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

        javax.swing.GroupLayout PanelFormAccountMoreInfoLayout = new javax.swing.GroupLayout(PanelFormAccountMoreInfo);
        PanelFormAccountMoreInfo.setLayout(PanelFormAccountMoreInfoLayout);
        PanelFormAccountMoreInfoLayout.setHorizontalGroup(
            PanelFormAccountMoreInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFormAccountMoreInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelFormAccountMoreInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(PanelFormAccountMoreInfoLayout.createSequentialGroup()
                        .addComponent(lblCivilState, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbCivilState, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelFormAccountMoreInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelFormAccountMoreInfoLayout.createSequentialGroup()
                            .addComponent(lblSpouseName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtSpouseName, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelFormAccountMoreInfoLayout.createSequentialGroup()
                            .addComponent(lblFatherName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtFatherName, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelFormAccountMoreInfoLayout.createSequentialGroup()
                            .addComponent(lblMotherName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtMotherName, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblIdentityInformation1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelFormAccountMoreInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PanelFormAccountMoreInfoLayout.createSequentialGroup()
                        .addGroup(PanelFormAccountMoreInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(PanelFormAccountMoreInfoLayout.createSequentialGroup()
                                .addComponent(lblIdentityType, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbbIdentityType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(PanelFormAccountMoreInfoLayout.createSequentialGroup()
                                .addComponent(lblRecNum, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtRecNum, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelFormAccountMoreInfoLayout.createSequentialGroup()
                                .addComponent(lblSerieNum, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtSerieNum, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelFormAccountMoreInfoLayout.createSequentialGroup()
                                .addComponent(lblEmissor, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtEmissor, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelFormAccountMoreInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelFormAccountMoreInfoLayout.createSequentialGroup()
                                .addComponent(lblNaturalness, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNaturalness, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelFormAccountMoreInfoLayout.createSequentialGroup()
                                .addComponent(lblEmissionDate, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEmissionDate, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelFormAccountMoreInfoLayout.createSequentialGroup()
                                .addComponent(lblValidThru, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtValidThru, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelFormAccountMoreInfoLayout.createSequentialGroup()
                                .addComponent(lblNationality, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNationality, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(PanelFormAccountMoreInfoLayout.createSequentialGroup()
                        .addComponent(lblEmissionUF, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbEmissionUF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblIdentityInformation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(167, Short.MAX_VALUE))
        );
        PanelFormAccountMoreInfoLayout.setVerticalGroup(
            PanelFormAccountMoreInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFormAccountMoreInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelFormAccountMoreInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdentityInformation1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIdentityInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelFormAccountMoreInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelFormAccountMoreInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbbCivilState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblCivilState, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelFormAccountMoreInfoLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(PanelFormAccountMoreInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSpouseName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSpouseName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelFormAccountMoreInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMotherName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMotherName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelFormAccountMoreInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFatherName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFatherName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PanelFormAccountMoreInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblIdentityType, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbbIdentityType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelFormAccountMoreInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(PanelFormAccountMoreInfoLayout.createSequentialGroup()
                            .addGroup(PanelFormAccountMoreInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblEmissionDate, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtEmissionDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(PanelFormAccountMoreInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblValidThru, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtValidThru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblRecNum, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtRecNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(PanelFormAccountMoreInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(PanelFormAccountMoreInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblSerieNum, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSerieNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(PanelFormAccountMoreInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblNaturalness, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNaturalness, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(28, 28, 28))
                        .addGroup(PanelFormAccountMoreInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNationality, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNationality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEmissor, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmissor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelFormAccountMoreInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmissionUF, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbEmissionUF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        PanelAccountMoreInfoForm.setViewportView(PanelFormAccountMoreInfo);

        javax.swing.GroupLayout PanelAccountMoreInfoLayout = new javax.swing.GroupLayout(PanelAccountMoreInfo);
        PanelAccountMoreInfo.setLayout(PanelAccountMoreInfoLayout);
        PanelAccountMoreInfoLayout.setHorizontalGroup(
            PanelAccountMoreInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1168, Short.MAX_VALUE)
            .addGroup(PanelAccountMoreInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanelAccountMoreInfoForm, javax.swing.GroupLayout.DEFAULT_SIZE, 1168, Short.MAX_VALUE))
        );
        PanelAccountMoreInfoLayout.setVerticalGroup(
            PanelAccountMoreInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 246, Short.MAX_VALUE)
            .addGroup(PanelAccountMoreInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanelAccountMoreInfoForm, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
        );

        TabPnlUserForm.addTab("Outras Informações", PanelAccountMoreInfo);

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        PanelAccountOrderListView.setBackground(new java.awt.Color(255, 255, 255));
        PanelAccountOrderListView.setPreferredSize(new java.awt.Dimension(1004, 193));

        PanelAccountOrderListHeader.setBackground(new java.awt.Color(255, 255, 255));

        lblAccountOrderList.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        lblAccountOrderList.setText("Ordens de Vendas");

        lblOrderImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/20px/Filter 20x20.png"))); // NOI18N

        cbbListOrderFilter.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        cbbListOrderFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbListOrderFilter.setMaximumSize(new java.awt.Dimension(250, 32767));
        cbbListOrderFilter.setPreferredSize(new java.awt.Dimension(250, 23));
        cbbListOrderFilter.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbListOrderFilterItemStateChanged(evt);
            }
        });

        txtListOrderFilterValue.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtListOrderFilterValue.setToolTipText("");
        txtListOrderFilterValue.setMaximumSize(new java.awt.Dimension(250, 2147483647));
        txtListOrderFilterValue.setPreferredSize(new java.awt.Dimension(250, 23));

        lblInformation1.setBackground(new java.awt.Color(255, 255, 255));
        lblInformation1.setText("Pressione Enter para pesquisar");
        lblInformation1.setEnabled(false);

        lblAccountOrderRecCount.setBackground(new java.awt.Color(255, 255, 255));
        lblAccountOrderRecCount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAccountOrderRecCount.setText("Registro: 0 - 100");
        lblAccountOrderRecCount.setToolTipText("");
        lblAccountOrderRecCount.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblAccountOrderRecCount.setMaximumSize(new java.awt.Dimension(410, 14));

        javax.swing.GroupLayout PanelAccountOrderListHeaderLayout = new javax.swing.GroupLayout(PanelAccountOrderListHeader);
        PanelAccountOrderListHeader.setLayout(PanelAccountOrderListHeaderLayout);
        PanelAccountOrderListHeaderLayout.setHorizontalGroup(
            PanelAccountOrderListHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAccountOrderListHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAccountOrderList, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(lblOrderImage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbbListOrderFilter, 0, 293, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtListOrderFilterValue, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInformation1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAccountOrderRecCount, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                .addContainerGap())
        );
        PanelAccountOrderListHeaderLayout.setVerticalGroup(
            PanelAccountOrderListHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelAccountOrderListHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelAccountOrderListHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbbListOrderFilter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblAccountOrderList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblOrderImage, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblAccountOrderRecCount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblInformation1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtListOrderFilterValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        PanelAccountOrderList.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        PanelAccountOrderList.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        PanelAccountOrderList.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N

        tblAccountOrderList.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        tblAccountOrderList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

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
        tblAccountOrderList.setGridColor(new java.awt.Color(204, 204, 204));
        tblAccountOrderList.setRowHeight(22);
        tblAccountOrderList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        PanelAccountOrderList.setViewportView(tblAccountOrderList);

        javax.swing.GroupLayout PanelAccountOrderListViewLayout = new javax.swing.GroupLayout(PanelAccountOrderListView);
        PanelAccountOrderListView.setLayout(PanelAccountOrderListViewLayout);
        PanelAccountOrderListViewLayout.setHorizontalGroup(
            PanelAccountOrderListViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAccountOrderListViewLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelAccountOrderListViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelAccountOrderListHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelAccountOrderList))
                .addContainerGap())
        );
        PanelAccountOrderListViewLayout.setVerticalGroup(
            PanelAccountOrderListViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelAccountOrderListViewLayout.createSequentialGroup()
                .addComponent(PanelAccountOrderListHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelAccountOrderList, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                .addContainerGap())
        );

        jScrollPane1.setViewportView(PanelAccountOrderListView);

        javax.swing.GroupLayout PanelAccountOrdersLayout = new javax.swing.GroupLayout(PanelAccountOrders);
        PanelAccountOrders.setLayout(PanelAccountOrdersLayout);
        PanelAccountOrdersLayout.setHorizontalGroup(
            PanelAccountOrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1168, Short.MAX_VALUE)
        );
        PanelAccountOrdersLayout.setVerticalGroup(
            PanelAccountOrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        TabPnlUserForm.addTab("Ordens de Vendas", PanelAccountOrders);

        javax.swing.GroupLayout PanelAccountFormLayout = new javax.swing.GroupLayout(PanelAccountForm);
        PanelAccountForm.setLayout(PanelAccountFormLayout);
        PanelAccountFormLayout.setHorizontalGroup(
            PanelAccountFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelAccountFormHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PanelAccountFormLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TabPnlUserForm)
                .addContainerGap())
        );
        PanelAccountFormLayout.setVerticalGroup(
            PanelAccountFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelAccountFormLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelAccountFormHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TabPnlUserForm, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addComponent(PanelAccount, javax.swing.GroupLayout.DEFAULT_SIZE, 1193, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelAccount, javax.swing.GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbbListFilterItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbListFilterItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            setFocus("FILTRO_VALOR");
        }
    }//GEN-LAST:event_cbbListFilterItemStateChanged

    private void txtAccountNumberKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAccountNumberKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_TAB){
            setFocus("SENHA");
        }
    }//GEN-LAST:event_txtAccountNumberKeyPressed

    private void cbbAccountStatusItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbAccountStatusItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            setFocus("BOTAO_PERMISSAO");
        }
    }//GEN-LAST:event_cbbAccountStatusItemStateChanged

    private void cbbAccountStatusKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbbAccountStatusKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_TAB){
            if(!getcbbAccountStatus().equals("Selecione...")){
                setFocus("BOTAO_PERMISSAO");
            } else {
                //setbtnPermitionsEnabled(false);
            }
        }
    }//GEN-LAST:event_cbbAccountStatusKeyPressed

    private void cbbIdentityTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbIdentityTypeItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            setFocus("REGISTRO_NUMERO");
        }
    }//GEN-LAST:event_cbbIdentityTypeItemStateChanged

    private void cbbIdentityTypeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbbIdentityTypeKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_TAB){
            setFocus("REGISTRO_NUMERO");
        }
    }//GEN-LAST:event_cbbIdentityTypeKeyPressed

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

    private void cbbEmissionUFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbbEmissionUFKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_TAB){
            setFocus("REGISTRO_DT_EMISSAO");
        }
    }//GEN-LAST:event_cbbEmissionUFKeyPressed

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

    private void cbbCivilStateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbbCivilStateKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_TAB){
            setFocus("NOME_CONJUJE");
        }
    }//GEN-LAST:event_cbbCivilStateKeyPressed

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

    private void txtNickNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNickNameKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("SEXO");
        }
    }//GEN-LAST:event_txtNickNameKeyPressed

    private void cbbMonthItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbMonthItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            setFocus("NASCIMENTO_ANO");
        }
    }//GEN-LAST:event_cbbMonthItemStateChanged

    private void cbbMonthKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbbMonthKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_TAB){
            setFocus("NASCIMENTO_ANO");
        }
    }//GEN-LAST:event_cbbMonthKeyPressed

    private void cbbDocTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbDocTypeItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            setFocus("NUM_DOCUMENTO");
        }
    }//GEN-LAST:event_cbbDocTypeItemStateChanged

    private void cbbDocTypeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbbDocTypeKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_TAB){
            setFocus("NUM_DOCUMENTO");
        }
    }//GEN-LAST:event_cbbDocTypeKeyPressed

    private void cbbDayItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbDayItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            setFocus("NASCIMENTO_MES");
        }
    }//GEN-LAST:event_cbbDayItemStateChanged

    private void cbbDayKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbbDayKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_TAB){
            setFocus("NASCIMENTO_MES");
        }
    }//GEN-LAST:event_cbbDayKeyPressed

    private void txtSurnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSurnameKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("APELIDO");
        }
    }//GEN-LAST:event_txtSurnameKeyPressed

    private void txtDocNumKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDocNumKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("NOME");
        }
    }//GEN-LAST:event_txtDocNumKeyPressed

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

    private void txtYearKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtYearKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("NASCIMENTO_LOCAL");
        }
    }//GEN-LAST:event_txtYearKeyPressed

    private void btnAddContactFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnAddContactFocusLost
        setFocus("BOTAO_ADD_REDE_SOCIAL");
    }//GEN-LAST:event_btnAddContactFocusLost

    private void btnAddContactKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAddContactKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_TAB){
            setFocus("BOTAO_ADD_REDE_SOCIAL");
        }
    }//GEN-LAST:event_btnAddContactKeyPressed

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

    private void btnAddAddressFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnAddAddressFocusLost
        setFocus("BOTAO_SALVAR");
    }//GEN-LAST:event_btnAddAddressFocusLost

    private void btnAddAddressKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAddAddressKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_TAB){
            setFocus("BOTAO_SALVAR");
        }
    }//GEN-LAST:event_btnAddAddressKeyPressed

    private void txtFullAddressKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFullAddressKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("BOTAO_SALVAR");
        }
    }//GEN-LAST:event_txtFullAddressKeyPressed

    private void cbbAccountTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbAccountTypeItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbAccountTypeItemStateChanged

    private void cbbAccountTypeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbbAccountTypeKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbAccountTypeKeyPressed

    private void cbbListOrderFilterItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbListOrderFilterItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbListOrderFilterItemStateChanged

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelAccount;
    private javax.swing.JPanel PanelAccountContAddr;
    private javax.swing.JScrollPane PanelAccountContAddrForm;
    private javax.swing.JPanel PanelAccountForm;
    private javax.swing.JPanel PanelAccountFormHeader;
    private javax.swing.JPanel PanelAccountInfo;
    private javax.swing.JScrollPane PanelAccountInfoForm;
    private javax.swing.JPanel PanelAccountList;
    private javax.swing.JPanel PanelAccountListHeader;
    private javax.swing.JPanel PanelAccountMoreInfo;
    private javax.swing.JScrollPane PanelAccountMoreInfoForm;
    private javax.swing.JScrollPane PanelAccountOrderList;
    private javax.swing.JPanel PanelAccountOrderListHeader;
    private javax.swing.JPanel PanelAccountOrderListView;
    private javax.swing.JPanel PanelAccountOrders;
    private javax.swing.JPanel PanelFormAccountContAddr;
    private javax.swing.JPanel PanelFormAccountInfo;
    private javax.swing.JPanel PanelFormAccountMoreInfo;
    private javax.swing.JPanel PanelListAccount;
    private javax.swing.JTabbedPane TabPnlUserForm;
    private javax.swing.JButton btnAddAddress;
    private javax.swing.JButton btnAddContact;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnGoQuery;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnQuery;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cbbAccountStatus;
    private javax.swing.JComboBox<String> cbbAccountType;
    private javax.swing.JComboBox<String> cbbCivilState;
    private javax.swing.JComboBox<String> cbbDay;
    private javax.swing.JComboBox<String> cbbDocType;
    private javax.swing.JComboBox<String> cbbEmissionUF;
    private javax.swing.JComboBox<String> cbbIdentityType;
    private javax.swing.JComboBox<String> cbbListFilter;
    private javax.swing.JComboBox<String> cbbListOrderFilter;
    private javax.swing.JComboBox<String> cbbMonth;
    private javax.swing.JComboBox<String> cbbSex;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblAccountFormInformation;
    private javax.swing.JLabel lblAccountList;
    private javax.swing.JLabel lblAccountNameHeader;
    private javax.swing.JLabel lblAccountNumber;
    private javax.swing.JLabel lblAccountOrderList;
    private javax.swing.JLabel lblAccountOrderRecCount;
    private javax.swing.JLabel lblAccountStatus;
    private javax.swing.JLabel lblAccountType;
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
    private javax.swing.JLabel lblIdentityInformation1;
    private javax.swing.JLabel lblIdentityType;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblInformation;
    private javax.swing.JLabel lblInformation1;
    private javax.swing.JLabel lblInstagram;
    private javax.swing.JLabel lblMotherName;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNationality;
    private javax.swing.JLabel lblNaturalness;
    private javax.swing.JLabel lblNickname;
    private javax.swing.JLabel lblOrderImage;
    private javax.swing.JLabel lblPersonalData;
    private javax.swing.JLabel lblRecCount;
    private javax.swing.JLabel lblRecNum;
    private javax.swing.JLabel lblRowId;
    private javax.swing.JLabel lblSerieNum;
    private javax.swing.JLabel lblSex;
    private javax.swing.JLabel lblSocialMedia;
    private javax.swing.JLabel lblSpouseName;
    private javax.swing.JLabel lblSurname;
    private javax.swing.JLabel lblTwitter;
    private javax.swing.JLabel lblValidThru;
    private javax.swing.JScrollPane sPanelAccountList;
    private javax.swing.JTable tblAccountList;
    private javax.swing.JTable tblAccountOrderList;
    private javax.swing.JTextField txtAccountNumber;
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
    private javax.swing.JTextField txtListFilterValue;
    private javax.swing.JTextField txtListOrderFilterValue;
    private javax.swing.JTextField txtMotherName;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNationality;
    private javax.swing.JTextField txtNaturalness;
    private javax.swing.JTextField txtNickName;
    private javax.swing.JTextField txtRecNum;
    private javax.swing.JTextField txtRowId;
    private javax.swing.JTextField txtSerieNum;
    private javax.swing.JTextField txtSpouseName;
    private javax.swing.JTextField txtSurname;
    private javax.swing.JTextField txtTwitter;
    private javax.swing.JTextField txtValidThru;
    private javax.swing.JTextField txtYear;
    // End of variables declaration//GEN-END:variables
}
