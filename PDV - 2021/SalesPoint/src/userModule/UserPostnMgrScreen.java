/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userModule;

import settingsModule.*;
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
 * @author Matheus Cabral Rosa
 */
public class UserPostnMgrScreen extends javax.swing.JFrame {

    /**
     * Creates new form ListOfValuesScreen
     */
    public UserPostnMgrScreen() {
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

    // =============================================== LISTENERS ===============================================
    // List: Position - Permission
    public void setListenercbbListFilterValue(ItemListener listener) { this.cbbListFilter.addItemListener(listener); }
    public void setListenertxtListFilterValue(KeyListener listener) { this.txtListFilterValue.addKeyListener(listener); }
    
    // Position
    public void setListenerBtnEditPosition(ActionListener listener) { this.btnEditPosition.addActionListener(listener); }
    public void setListenerBtnNewPosition(ActionListener listener) { this.btnNewPosition.addActionListener(listener); }
    public void setListenerBtnSavePosition(ActionListener listener) { this.btnSavePosition.addActionListener(listener); }
    public void setListenerBtnCancelPosition(ActionListener listener) { this.btnCancelPosition.addActionListener(listener); }
    public void setListenerBtnDeletePosition(ActionListener listener) { this.btnDeletePosition.addActionListener(listener); }
    public void setListenerBtnQueryPosition(ActionListener listener) { this.btnQueryPosition.addActionListener(listener); }
    public void setListenerBtnGoQueryPosition(ActionListener listener) { this.btnGoQueryPosition.addActionListener(listener); }
    public void setKeyListenerBtnEditPosition(KeyListener listener) { this.btnEditPosition.addKeyListener(listener); }
    public void setKeyListenerBtnNewPosition(KeyListener listener) { this.btnNewPosition.addKeyListener(listener); }
    public void setKeyListenerBtnSavePosition(KeyListener listener) { this.btnSavePosition.addKeyListener(listener); }
    public void setKeyListenerBtnCancelPosition(KeyListener listener) { this.btnCancelPosition.addKeyListener(listener); }
    public void setKeyListenerBtnDeletePosition(KeyListener listener) { this.btnDeletePosition.addKeyListener(listener); }
    public void setKeyListenerBtnQueryPosition(KeyListener listener) { this.btnQueryPosition.addKeyListener(listener); }
    public void setKeyListenerBtnGoQueryPosition(KeyListener listener) { this.btnGoQueryPosition.addKeyListener(listener); }
    public void setKeyListenerTxtPositionName(KeyListener listener) { this.txtPositionName.addKeyListener(listener); }
    public void setKeyListenerTxtPositionType(KeyListener listener) { this.txtPositionType.addKeyListener(listener); }
    public void setKeyListenerTxtPositionDesc(KeyListener listener) { this.txtPositionDesc.addKeyListener(listener); }
    public void setListenerPanelList(ComponentListener listener) { this.PanelList.addComponentListener(listener); }
    public void setListenerPanelPosition(ComponentListener listener) { this.PanelPosition.addComponentListener(listener); }
    
    // Permission
    public void setListenerBtnEditPermission(ActionListener listener) { this.btnEditPermission.addActionListener(listener); }
    public void setListenerBtnNewPermission(ActionListener listener) { this.btnNewPermission.addActionListener(listener); }
    public void setListenerBtnSavePermission(ActionListener listener) { this.btnSavePermission.addActionListener(listener); }
    public void setListenerBtnCancelPermission(ActionListener listener) { this.btnCancelPermission.addActionListener(listener); }
    public void setListenerBtnDeletePermission(ActionListener listener) { this.btnDeletePermission.addActionListener(listener); }
    public void setListenerBtnQueryPermission(ActionListener listener) { this.btnQueryPermission.addActionListener(listener); }
    public void setListenerBtnGoQueryPermission(ActionListener listener) { this.btnGoQueryPermission.addActionListener(listener); }
    public void setKeyListenerBtnEditPermission(KeyListener listener) { this.btnEditPermission.addKeyListener(listener); }
    public void setKeyListenerBtnNewPermission(KeyListener listener) { this.btnNewPermission.addKeyListener(listener); }
    public void setKeyListenerBtnSavePermission(KeyListener listener) { this.btnSavePermission.addKeyListener(listener); }
    public void setKeyListenerBtnCancelPermission(KeyListener listener) { this.btnCancelPermission.addKeyListener(listener); }
    public void setKeyListenerBtnDeletePermission(KeyListener listener) { this.btnDeletePermission.addKeyListener(listener); }
    public void setKeyListenerBtnQueryPermission(KeyListener listener) { this.btnQueryPermission.addKeyListener(listener); }
    public void setKeyListenerBtnGoQueryPermission(KeyListener listener) { this.btnGoQueryPermission.addKeyListener(listener); }
    public void setKeyListenerTxtPermissionName(KeyListener listener) { this.txtPermissionName.addKeyListener(listener); }
    public void setKeyListenerCkbPermissionFlg(KeyListener listener) { this.ckbPermissionFlg.addKeyListener(listener); }
    public void setKeyListenerTxtPermissionValue(KeyListener listener) { this.txtPermissionValue.addKeyListener(listener); }
    public void setKeyListenerTxtPermissionDesc(KeyListener listener) { this.txtPermissionDesc.addKeyListener(listener); }
    public void setListenercbbListPermission(ItemListener listener) { this.cbbListPosition.addItemListener(listener); }
    public void setListenerPanelPermission(ComponentListener listener) { this.PanelPermission.addComponentListener(listener); }    
    // =========================================================================================================
    
    // =============================================== TABLE ===============================================
    // Lista: Position - Permition
    public DefaultTableModel getTableModelPosition(){ return (DefaultTableModel) tblListPos.getModel(); }    
    public void setListenerTblListSelectionPosition(ListSelectionListener listener) { this.tblListPos.getSelectionModel().addListSelectionListener(listener); }
    public void setSelectedRowColumnListPosition(int row, int column){ this.tblListPos.changeSelection(row, column, false, false); }
    public void unselectRowListPosition() { try { this.tblListPos.removeRowSelectionInterval(this.getSelectedRowListPosition(), this.getSelectedRowListPosition()); } catch (Exception e) {} }
    public void removeRowFromListPosition(int row) { try { this.getTableModelPosition().removeRow(row); } catch (Exception e) {} this.tblListPos.paintImmediately(this.tblListPos.getVisibleRect()); }
    public void setListRowCountPosition(int count) { this.getTableModelPosition().setRowCount(count); this.tblListPos.paintImmediately(this.tblListPos.getVisibleRect()); }
    public int getSelectedRowListPosition() { return this.tblListPos.getSelectedRow(); }
    public int getNumOfListRowsPosition() { return this.tblListPos.getRowCount(); }
    
    public DefaultTableModel getTableModelPermission(){ return (DefaultTableModel) tblListPerm.getModel(); }    
    public void setListenerTblListSelectionPermission(ListSelectionListener listener) { this.tblListPerm.getSelectionModel().addListSelectionListener(listener); }
    public void setSelectedRowColumnListPermission(int row, int column){ this.tblListPerm.changeSelection(row, column, false, false); }
    public void unselectRowListPermission() { try { this.tblListPerm.removeRowSelectionInterval(this.getSelectedRowListPermission(), this.getSelectedRowListPermission()); } catch (Exception e) {} }
    public void removeRowFromListPermission(int row) { try { this.getTableModelPermission().removeRow(row); } catch (Exception e) {} this.tblListPerm.paintImmediately(this.tblListPerm.getVisibleRect()); }
    public void setListRowCountPermission(int count) { this.getTableModelPermission().setRowCount(count); this.tblListPerm.paintImmediately(this.tblListPerm.getVisibleRect()); }
    public int getSelectedRowListPermission() { return this.tblListPerm.getSelectedRow(); }
    public int getNumOfListRowsPermission() { return this.tblListPerm.getRowCount(); }
        
    // Position
    public DefaultTableModel getPositionTableModel(){ return (DefaultTableModel) tblPositionList.getModel(); }    
    public void setListenerTblPositionListSelection(ListSelectionListener listener) { this.tblPositionList.getSelectionModel().addListSelectionListener(listener); }
    public void setSelectedRowColumnPositionList(int row, int column){ this.tblPositionList.changeSelection(row, column, false, false); }
    public void unselectRowPositionList() { try { this.tblPositionList.removeRowSelectionInterval(this.getSelectedRowPositionList(), this.getSelectedRowPositionList()); } catch (Exception e) {} }
    public void removeRowFromPositionList(int row) { try { this.getPositionTableModel().removeRow(row); } catch (Exception e) {} this.tblPositionList.paintImmediately(this.tblPositionList.getVisibleRect()); }
    public void setPositionListRowCount(int count) { this.getPositionTableModel().setRowCount(count); this.tblPositionList.paintImmediately(this.tblPositionList.getVisibleRect()); }
    public String getPositionListValue(int column) { return this.tblPositionList.getValueAt(this.getSelectedRowPositionList(), column).toString(); }
    public int getSelectedRowPositionList() { return this.tblPositionList.getSelectedRow(); }
    public int getNumOfPositionListRows() { return this.tblPositionList.getRowCount(); }
    
    // Permition
    public DefaultTableModel getPermissionTableModel(){ return (DefaultTableModel) tblPermissionList.getModel(); }    
    public void setListenerTblPermissionListSelection(ListSelectionListener listener) { this.tblPermissionList.getSelectionModel().addListSelectionListener(listener); }
    public void setSelectedRowColumnPermissionList(int row, int column){ this.tblPermissionList.changeSelection(row, column, false, false); }
    public void unselectRowPermissionList() { try { this.tblPermissionList.removeRowSelectionInterval(this.getSelectedRowPermissionList(), this.getSelectedRowPermissionList()); } catch (Exception e) {} }
    public void removeRowFromPermissionList(int row) { try { this.getPermissionTableModel().removeRow(row); } catch (Exception e) {} this.tblPermissionList.paintImmediately(this.tblPermissionList.getVisibleRect()); }
    public void setPermissionListRowCount(int count) { this.getPermissionTableModel().setRowCount(count); this.tblPermissionList.paintImmediately(this.tblPermissionList.getVisibleRect()); }
    public String getPermissionListValue(int column) { return this.tblPermissionList.getValueAt(this.getSelectedRowPermissionList(), column).toString(); }
    public int getSelectedRowPermissionList() { return this.tblPermissionList.getSelectedRow(); }
    public int getNumOfPermissionListRows() { return this.tblPermissionList.getRowCount(); }
    // =========================================================================================================
    
    // =============================================== Component Setters ===============================================
    // Lista: Position - Permition
    public void settxtListFilterValue(String value) { this.txtListFilterValue.setText(value); this.txtListFilterValue.paintImmediately(this.txtListFilterValue.getVisibleRect()); }
    public void setcbbListFilter(String value) { this.cbbListFilter.addItem(value); this.cbbListFilter.paintImmediately(this.cbbListFilter.getVisibleRect()); }
    public void setcbbListFilterItemIndex(int value) { this.cbbListFilter.setSelectedIndex(value); }
    public void setlblRecCountPos(String value) { this.lblRecCountPos.setText("Registros: " + value); this.lblRecCountPos.paintImmediately(this.lblRecCountPos.getVisibleRect()); }
    public void setlblRecCountPerm(String value) { this.lblRecCountPerm.setText("Registros: " + value); this.lblRecCountPerm.paintImmediately(this.lblRecCountPerm.getVisibleRect()); }
    
    // Position
    public void settxtPositionRowId(String value) { this.txtPositionRowId.setText(value); this.txtPositionRowId.paintImmediately(this.txtPositionRowId.getVisibleRect()); }
    public void settxtPositionName(String value) { this.txtPositionName.setText(value); this.txtPositionName.paintImmediately(this.txtPositionName.getVisibleRect()); }
    public void settxtPositionType(String value) { this.txtPositionType.setText(value); this.txtPositionType.paintImmediately(this.txtPositionType.getVisibleRect()); }    
    public void settxtPositionDesc(String value) { this.txtPositionDesc.setText(value); this.txtPositionDesc.paintImmediately(this.txtPositionDesc.getVisibleRect()); }
    public void setlblFormPositionNameHeader(String value) { this.lblFormPositionNameHeader.setText(value); this.lblFormPositionNameHeader.paintImmediately(this.lblFormPositionNameHeader.getVisibleRect()); }
    public void setlblRecCountPosList(String value) { this.lblRecCountPosList.setText("Registros: " + value); this.lblRecCountPosList.paintImmediately(this.lblRecCountPosList.getVisibleRect()); }
    
    // Permition
    public void setcbbListPosition(String value) { this.cbbListPosition.addItem(value); this.cbbListPosition.paintImmediately(this.cbbListPosition.getVisibleRect()); }
    public void settxtPermissionRowId(String value) { this.txtPermissionRowId.setText(value); this.txtPermissionRowId.paintImmediately(this.txtPermissionRowId.getVisibleRect()); }
    public void settxtPermitionName(String value) { this.txtPermissionName.setText(value); this.txtPermissionName.paintImmediately(this.txtPermissionName.getVisibleRect()); }
    public void settxtPermitionValue(String value) { this.txtPermissionValue.setText(value); this.txtPermissionValue.paintImmediately(this.txtPermissionValue.getVisibleRect()); }
    public void setckbPermitionFlg(String value) { this.ckbPermissionFlg.setSelected(("Y".equals(value))); this.ckbPermissionFlg.paintImmediately(this.ckbPermissionFlg.getVisibleRect()); }
    public void settxtPermitionDesc(String value) { this.txtPermissionDesc.setText(value); this.txtPermissionDesc.paintImmediately(this.txtPermissionDesc.getVisibleRect()); }
    public void setcbbListPositionItemIndex(int value) { this.cbbListPosition.setSelectedIndex(value); }
    //public void setcbbPermitionNameItemIndex(int value) { this.cbbPermissionName.setSelectedIndex(value); }
    public void setlblFormPermitionNameHeader(String value) { this.lblFormPermissionNameHeader.setText(value); this.lblFormPermissionNameHeader.paintImmediately(this.lblFormPermissionNameHeader.getVisibleRect()); }
    public void setlblRecCountPermList(String value) { this.lblRecCountPermList.setText("Registros: " + value); this.lblRecCountPermList.paintImmediately(this.lblRecCountPermList.getVisibleRect()); }
    // =========================================================================================================
    
    // =============================================== Component Getters ===============================================
    // Lista: Position - Permition
    public String getcbbListFilter() { return ((!"".equals(this.cbbListFilter.getSelectedItem().toString()) && !"Selecione...".equals(this.cbbListFilter.getSelectedItem().toString()) && this.cbbListFilter.getSelectedItem().toString() != null) ? this.cbbListFilter.getSelectedItem().toString() : null); }
    public String gettxtListFilterValue() { return ((!"".equals(this.txtListFilterValue.getText()) && this.txtListFilterValue.getText() != null) ? this.txtListFilterValue.getText() : null); }
    public int getcbbListFilterItemIndex(String value) { if(!"".equals(value) && value != null) { for(int i = 0; i < this.cbbListFilter.getItemCount(); i++){ if(value.equals(this.cbbListFilter.getItemAt(i))){ return i; }}} else { return 0; } return 0; }
    public String getlblRecCountPos() { return this.lblRecCountPos.getText(); }
    public String getlblRecCountPerm() { return this.lblRecCountPerm.getText(); }
    
    // Position
    public String gettxtPositionRowId() { return ((!"".equals(this.txtPositionRowId.getText()) && this.txtPositionRowId.getText() != null) ? this.txtPositionRowId.getText() : null); }
    public String gettxtPositionName() { return ((!"".equals(this.txtPositionName.getText()) && this.txtPositionName.getText() != null) ? this.txtPositionName.getText() : null); }
    public String gettxtPositionType() { return ((!"".equals(this.txtPositionType.getText()) && this.txtPositionType.getText() != null) ? this.txtPositionType.getText() : null); }
    public String gettxtPositionDesc() { return ((!"".equals(this.txtPositionDesc.getText()) && this.txtPositionDesc.getText() != null) ? this.txtPositionDesc.getText() : null); }
    public String getlblRecCountPosList() { return this.lblRecCountPosList.getText(); }
    public String getlblFormPositionNameHeader() { return this.lblFormPositionNameHeader.getText(); }
    
    // Permition
    public String getcbbListPositionName() { return ((!"".equals(this.cbbListPosition.getSelectedItem().toString()) && !"Selecione...".equals(this.cbbListPosition.getSelectedItem().toString()) && this.cbbListPosition.getSelectedItem().toString() != null) ? this.cbbListPosition.getSelectedItem().toString() : null); }
    public String gettxtPermissionRowId() { return ((!"".equals(this.txtPermissionRowId.getText()) && this.txtPermissionRowId.getText() != null) ? this.txtPermissionRowId.getText() : null); }
    public String gettxtPermissionName() { return ((!"".equals(this.txtPermissionName.getText()) && this.txtPermissionName.getText() != null) ? this.txtPermissionName.getText() : null); }
    //public int getcbbPermitionNameItemIndex(String value) { if(!"".equals(value) && value != null) { for(int i = 0; i < this.cbbPermissionName.getItemCount(); i++){ if(value.equals(this.cbbPermissionName.getItemAt(i))){ return i; }}} else { return 0; } return 0; }
    public String gettxtPermissionValue() { return ((!"".equals(this.txtPermissionValue.getText()) && this.txtPermissionValue.getText() != null) ? this.txtPermissionValue.getText() : null); }
    public String getckbPermissionFlg() { return (this.ckbPermissionFlg.isSelected()) ? "Y" : "N"; }
    public String gettxtPermissionDesc() { return ((!"".equals(this.txtPermissionDesc.getText()) && this.txtPermissionDesc.getText() != null) ? this.txtPermissionDesc.getText() : null); }
    public String getlblRecCountPermList() { return this.lblRecCountPermList.getText(); }
    public String getlblFormPermitionNameHeader() { return this.lblFormPermissionNameHeader.getText(); }
    // =========================================================================================================
    
    // =============================================== Component Clear ===============================================
    // Lista: Position - Permition
    public void clearcbbListFilter() { this.cbbListFilter.removeAllItems(); this.cbbListFilter.paintImmediately(this.cbbListFilter.getVisibleRect()); }
    public void cleartxtListFilterValue() { this.txtListFilterValue.setText(""); this.txtListFilterValue.paintImmediately(this.txtListFilterValue.getVisibleRect()); }
    public void clearlblRecCountPos() { this.lblRecCountPos.setText(""); this.lblRecCountPos.paintImmediately(this.lblRecCountPos.getVisibleRect()); }
    public void clearlblRecCountPerm() { this.lblRecCountPerm.setText(""); this.lblRecCountPerm.paintImmediately(this.lblRecCountPerm.getVisibleRect()); }
    
    // Position
    public void cleartxtPositionRowId() { this.txtPositionRowId.setText(""); this.txtPositionRowId.paintImmediately(this.txtPositionRowId.getVisibleRect()); }
    public void cleartxtPositionName() { this.txtPositionName.setText(""); this.txtPositionName.paintImmediately(this.txtPositionName.getVisibleRect()); }
    public void cleartxtPositionType() { this.txtPositionType.setText(""); this.txtPositionType.paintImmediately(this.txtPositionType.getVisibleRect()); }
    public void cleartxtPositionDesc() { this.txtPositionDesc.setText(""); this.txtPositionDesc.paintImmediately(this.txtPositionDesc.getVisibleRect()); }
    public void clearlblRecCountPosList() { this.lblRecCountPosList.setText(""); this.lblRecCountPosList.paintImmediately(this.lblRecCountPosList.getVisibleRect()); }
    public void clearlblFormPositionNameHeader() { this.lblFormPositionNameHeader.setText(""); this.lblFormPositionNameHeader.paintImmediately(this.lblFormPositionNameHeader.getVisibleRect()); }
    
    // Permition    
    public void clearcbbListPosition() { this.cbbListPosition.removeAllItems(); this.cbbListPosition.paintImmediately(this.cbbListPosition.getVisibleRect()); }
    public void cleartxtPermissionRowId() { this.txtPermissionRowId.setText(""); this.txtPermissionRowId.paintImmediately(this.txtPermissionRowId.getVisibleRect()); }
    public void cleartxtPermissionName() { this.txtPermissionName.setText(""); this.txtPermissionName.paintImmediately(this.txtPermissionName.getVisibleRect()); }
    public void cleartxtPermissionValue() { this.txtPermissionValue.setText(""); this.txtPermissionValue.paintImmediately(this.txtPermissionValue.getVisibleRect()); }
    public void clearckbPermissionFlg() { this.ckbPermissionFlg.setSelected(false); this.ckbPermissionFlg.paintImmediately(this.ckbPermissionFlg.getVisibleRect()); }
    public void cleartxtPermissionDesc() { this.txtPermissionDesc.setText(""); this.txtPermissionDesc.paintImmediately(this.txtPermissionDesc.getVisibleRect()); }
    public void clearlblRecCountPermList() { this.lblRecCountPermList.setText(""); this.lblRecCountPermList.paintImmediately(this.lblRecCountPermList.getVisibleRect()); }
    public void clearlblFormPermitionNameHeader() { this.lblFormPermissionNameHeader.setText(""); this.lblFormPermissionNameHeader.paintImmediately(this.lblFormPermissionNameHeader.getVisibleRect()); }
    // =========================================================================================================
    
    // =============================================== Enable or Disable Components ===============================================
    // Lista: Position - Permition
    public void setcbbListFilterEnabled(boolean status) { this.cbbListFilter.setEnabled(status); }
    public void settxtLOVTypeListFilterValueEnabled(boolean status) { this.txtListFilterValue.setEnabled(status); }
    public void settblListPosEnabled(boolean status) { this.tblListPos.setEnabled(status); }
    public void settblListPermEnabled(boolean status) { this.tblListPerm.setEnabled(status); }
    
    // Position
    public void settxtPositionRowIdEnabled(boolean status) { this.txtPositionRowId.setEnabled(status); }    
    public void settxtPositionNameEnabled(boolean status) { this.txtPositionName.setEnabled(status); }
    public void settxtPositionTypeEnabled(boolean status) { this.txtPositionType.setEnabled(status); }
    public void settxtPositionDescEnabled(boolean status) { this.txtPositionDesc.setEnabled(status); }
    public void setlblRecCountPosListEnabled(boolean status) { this.lblRecCountPosList.setEnabled(status); }
    public void setlblFormPositionNameHeaderEnabled(boolean status) { this.lblFormPositionNameHeader.setEnabled(status); }
    public void settblPositionListEnabled(boolean status) { this.tblPositionList.setEnabled(status); }
    public void setbtnEditPositionEnabled(boolean status) { this.btnEditPosition.setEnabled(status); }
    public void setbtnNewPositionEnabled(boolean status) { this.btnNewPosition.setEnabled(status); }
    public void setbtnSavePositionEnabled(boolean status) { this.btnSavePosition.setEnabled(status); }
    public void setbtnDeletePositionEnabled(boolean status) { this.btnDeletePosition.setEnabled(status); }
    public void setbtnQueryPositionEnabled(boolean status) { this.btnQueryPosition.setEnabled(status); }
    public void setbtnGoQueryPositionEnabled(boolean status) { this.btnGoQueryPosition.setEnabled(status); }
    public void setbtnCancelPositionEnabled(boolean status) { this.btnCancelPosition.setEnabled(status); }
    
    // Permition
    public void setcbbListPositionEnabled(boolean status) { this.cbbListPosition.setEnabled(status); }    
    public void settxtPermitionRowIdEnabled(boolean status) { this.txtPermissionRowId.setEnabled(status); }    
    public void settxtPermissionNameEnabled(boolean status) { this.txtPermissionName.setEnabled(status); }
    public void settxtPermitionValueEnabled(boolean status) { this.txtPermissionValue.setEnabled(status); }
    public void setckbPermitionFlgEnabled(boolean status) { this.ckbPermissionFlg.setEnabled(status); }
    public void settxtPermitionDescEnabled(boolean status) { this.txtPermissionDesc.setEnabled(status); }
    public void setlblRecCountPermListEnabled(boolean status) { this.lblRecCountPermList.setEnabled(status); }
    public void setlblFormPermitionNameHeaderEnabled(boolean status) { this.lblFormPermissionNameHeader.setEnabled(status); }
    public void settblPermitionListEnabled(boolean status) { this.tblPermissionList.setEnabled(status); }
    public void setbtnEditPermitionEnabled(boolean status) { this.btnEditPermission.setEnabled(status); }
    public void setbtnNewPermitionEnabled(boolean status) { this.btnNewPermission.setEnabled(status); }
    public void setbtnSavePermitionEnabled(boolean status) { this.btnSavePermission.setEnabled(status); }
    public void setbtnDeletePermitionEnabled(boolean status) { this.btnDeletePermission.setEnabled(status); }
    public void setbtnQueryPermitionEnabled(boolean status) { this.btnQueryPermission.setEnabled(status); }
    public void setbtnGoQueryPermitionEnabled(boolean status) { this.btnGoQueryPermission.setEnabled(status); }
    public void setbtnCancelPermitionEnabled(boolean status) { this.btnCancelPermission.setEnabled(status); }
    // =========================================================================================================
    
    // =============================================== Return componet status ===============================================
    // Lista: Position - Permition
    public boolean iscbbListFilterEnabled() { return this.cbbListFilter.isEnabled(); }
    public boolean istxtLOVTypeListFilterValueEnabled() { return this.txtListFilterValue.isEnabled(); }
    public boolean istblListPosEnabled() { return this.tblListPos.isEnabled(); }
    public boolean istblListPermEnabled() { return this.tblListPerm.isEnabled(); }
    
    // Position
    public boolean istxtPositionRowIdEnabled() { return this.txtPositionRowId.isEnabled(); }
    public boolean istxtPositionNameEnabled() { return this.txtPositionName.isEnabled(); }
    public boolean istxtPositionTypeEnabled() { return this.txtPositionType.isEnabled(); }
    public boolean istxtPositionDescEnabled() { return this.txtPositionDesc.isEnabled(); }
    public boolean istblPositionListEnabled() { return this.tblPositionList.isEnabled(); }
    public boolean isbtnEditPositionEnabled() { return this.btnEditPosition.isEnabled(); }
    public boolean isbtnNewPositionEnabled() { return this.btnNewPosition.isEnabled(); }
    public boolean isbtnSavePositionEnabled() { return this.btnSavePosition.isEnabled(); }
    public boolean isbtnCancelPositionEnabled() { return this.btnCancelPosition.isEnabled(); }
    public boolean isbtnDeletePositionEnabled() { return this.btnDeletePosition.isEnabled(); }
    public boolean isbtnQueryPositionEnabled() { return this.btnQueryPosition.isEnabled(); }
    public boolean isbtnGoQueryPositionEnabled() { return this.btnGoQueryPosition.isEnabled(); }
    
    // Permition
    public boolean iscbbListPositionEnabled() { return this.cbbListPosition.isEnabled(); }
    public boolean istxtPermitionRowIdEnabled() { return this.txtPermissionRowId.isEnabled(); }
    public boolean istxtPermissionNameEnabled() { return this.txtPermissionName.isEnabled(); }
    public boolean istxttxtPermitionValueEnabled() { return this.txtPermissionValue.isEnabled(); }
    public boolean istxtPermitionDescEnabled() { return this.txtPermissionDesc.isEnabled(); }
    public boolean istblPermitionListEnabled() { return this.tblPermissionList.isEnabled(); }
    public boolean isbtnEditPermitionEnabled() { return this.btnEditPermission.isEnabled(); }
    public boolean isbtnNewPermitionEnabled() { return this.btnNewPermission.isEnabled(); }
    public boolean isbtnSavePermitionEnabled() { return this.btnSavePermission.isEnabled(); }
    public boolean isbtnCancelPermitionEnabled() { return this.btnCancelPermission.isEnabled(); }
    public boolean isbtnDeletePermitionEnabled() { return this.btnDeletePermission.isEnabled(); }
    public boolean isbtnQueryPermitionEnabled() { return this.btnQueryPermission.isEnabled(); }
    public boolean isbtnGoQueryPermitionEnabled() { return this.btnGoQueryPermission.isEnabled(); }
    // =========================================================================================================
    
    // =============================================== Button Functions ===============================================    
    // Position
    public void clickSavePosition(){ this.btnSavePosition.setEnabled(true); this.btnSavePosition.doClick(); this.btnSavePosition.setEnabled(false); }
    public void clickNewPosition(){ this.btnNewPosition.setEnabled(true); this.btnNewPosition.doClick(); this.btnNewPosition.setEnabled(false); }
    public void clickEditPosition(){ this.btnEditPosition.setEnabled(true); this.btnEditPosition.doClick(); this.btnEditPosition.setEnabled(false); }
    public void clickCancelPosition(){ this.btnCancelPosition.setEnabled(true); this.btnCancelPosition.doClick(); this.btnCancelPosition.setEnabled(false); }
    public void clickDeletePosition(){ this.btnDeletePosition.setEnabled(true); this.btnDeletePosition.doClick(); this.btnDeletePosition.setEnabled(false); }
    public void clickQueryPosition(){ this.btnQueryPosition.setEnabled(true); this.btnQueryPosition.doClick(); this.btnQueryPosition.setEnabled(false); }
    public void clickGoQueryPosition(){ this.btnGoQueryPosition.setEnabled(true); this.btnGoQueryPosition.doClick(); this.btnGoQueryPosition.setEnabled(false); }
    
    // Permition
    public void clickSavePermition(){ this.btnSavePermission.setEnabled(true); this.btnSavePermission.doClick(); this.btnSavePermission.setEnabled(false); }
    public void clickNewPermition(){ this.btnNewPermission.setEnabled(true); this.btnNewPermission.doClick(); this.btnNewPermission.setEnabled(false); }
    public void clickEditPermition(){ this.btnEditPermission.setEnabled(true); this.btnEditPermission.doClick(); this.btnEditPermission.setEnabled(false); }
    public void clickCancelPermition(){ this.btnCancelPermission.setEnabled(true); this.btnCancelPermission.doClick(); this.btnCancelPermission.setEnabled(false); }
    public void clickDeletePermition(){ this.btnDeletePermission.setEnabled(true); this.btnDeletePermission.doClick(); this.btnDeletePermission.setEnabled(false); }
    public void clickQueryPermition(){ this.btnQueryPermission.setEnabled(true); this.btnQueryPermission.doClick(); this.btnQueryPermission.setEnabled(false); }
    public void clickGoQueryPermition(){ this.btnGoQueryPermission.setEnabled(true); this.btnGoQueryPermission.doClick(); this.btnGoQueryPermission.setEnabled(false); }
    // =========================================================================================================
    
    // Set Focus on Specific component
    public void setFocus(String component) {
        switch (component) {
            case "FILTRO": this.cbbListFilter.requestFocus(); break;
            case "FILTRO_VALOR": this.txtListFilterValue.requestFocus(); break;
            case "ID_POSITION": this.txtPositionRowId.requestFocus(); break;
            case "NAME_POSITION": this.txtPositionName.requestFocus(); break;
            case "TYPE_POSITION": this.txtPositionType.requestFocus(); break;
            case "DESC_POSITION": this.txtPositionDesc.requestFocus(); break;
            case "BOTAO_EDITAR_POSITION": this.btnEditPosition.requestFocus(); break;
            case "BOTAO_NOVO_POSITION": this.btnNewPosition.requestFocus(); break;
            case "BOTAO_SALVAR_POSITION": this.btnSavePosition.requestFocus(); break;
            case "BOTAO_CANCELAR_POSITION": this.btnCancelPosition.requestFocus(); break;
            case "BOTAO_DELETAR_POSITION": this.btnDeletePosition.requestFocus(); break;
            case "BOTAO_QUERY_POSITION": this.btnQueryPosition.requestFocus(); break;
            case "BOTAO_GO_QUERY_POSITION": this.btnGoQueryPosition.requestFocus(); break;
            case "ID_PERMITION": this.txtPermissionRowId.requestFocus(); break;
            case "NAME_PERMISSION": this.txtPermissionName.requestFocus(); break;
            case "VALUE_PERMISSION": this.txtPermissionValue.requestFocus(); break;
            case "DESC_PERMISSION": this.txtPermissionDesc.requestFocus(); break;
            case "FLAG_PERMISSION": this.ckbPermissionFlg.requestFocus(); break;
            case "BOTAO_EDITAR_PERMISSION": this.btnEditPermission.requestFocus(); break;
            case "BOTAO_NOVO_PERMISSION": this.btnNewPermission.requestFocus(); break;
            case "BOTAO_SALVAR_PERMISSION": this.btnSavePermission.requestFocus(); break;
            case "BOTAO_CANCELAR_PERMISSION": this.btnCancelPermission.requestFocus(); break;
            case "BOTAO_DELETAR_PERMISSION": this.btnDeletePermission.requestFocus(); break;
            case "BOTAO_QUERY_PERMISSION": this.btnQueryPermission.requestFocus(); break;
            case "BOTAO_GO_QUERY_PERMISSION": this.btnGoQueryPermission.requestFocus(); break;
            case "PANEL_LIST": this.PanelList.requestFocus(); break;
            default: break;
        }
    }
    
    public void enableFields(String funcao) {
	switch (funcao){
            case "LOAD_SCREEN":
                // List: Position - Permition
                setcbbListFilterEnabled(true);
                settxtLOVTypeListFilterValueEnabled(true);
                
                // Position
                settxtPositionRowIdEnabled(false);
                settxtPositionNameEnabled(false);
                settxtPositionTypeEnabled(false);
                settxtPositionDescEnabled(false);
                settblPositionListEnabled(true);
                setbtnQueryPositionEnabled(true);
                setbtnGoQueryPositionEnabled(false);
                setbtnNewPositionEnabled(true);
                setbtnEditPositionEnabled(false);
                setbtnDeletePositionEnabled(false);
                setbtnSavePositionEnabled(false);
                setbtnCancelPositionEnabled(false);
                
                // Permition
                setcbbListPositionEnabled(true);
                settxtPermitionRowIdEnabled(false);
                settxtPermissionNameEnabled(false);
                settxtPermitionValueEnabled(false);
                setckbPermitionFlgEnabled(false);
                settxtPermitionDescEnabled(false);
                settblPermitionListEnabled(true);
                setbtnQueryPermitionEnabled(false);
                setbtnGoQueryPermitionEnabled(false);
                setbtnNewPermitionEnabled(true);
                setbtnEditPermitionEnabled(false);
                setbtnDeletePermitionEnabled(false);
                setbtnSavePermitionEnabled(false);
                setbtnCancelPermitionEnabled(false);
                
                break;
            case "NOVO_POSITION":                
                // Position
                settxtPositionRowIdEnabled(false);
                settxtPositionNameEnabled(true);
                settxtPositionTypeEnabled(true);
                settxtPositionDescEnabled(true);
                settblPositionListEnabled(false);
                setbtnQueryPositionEnabled(false);
                setbtnGoQueryPositionEnabled(false);
                setbtnNewPositionEnabled(false);
                setbtnEditPositionEnabled(false);
                setbtnDeletePositionEnabled(false);
                setbtnSavePositionEnabled(true);
                setbtnCancelPositionEnabled(true);
                break;
            case "NOVO_PERMISSION":
                // Permition
                setcbbListPositionEnabled(false);
                settxtPermitionRowIdEnabled(false);
                settxtPermissionNameEnabled(true);
                settxtPermitionValueEnabled(true);
                setckbPermitionFlgEnabled(true);
                settxtPermitionDescEnabled(true);
                settblPermitionListEnabled(false);
                setbtnQueryPermitionEnabled(false);
                setbtnGoQueryPermitionEnabled(false);
                setbtnNewPermitionEnabled(false);
                setbtnEditPermitionEnabled(false);
                setbtnDeletePermitionEnabled(false);
                setbtnSavePermitionEnabled(true);
                setbtnCancelPermitionEnabled(true);
                break;
            case "EDITAR_POSITION":
                // Position
                settxtPositionRowIdEnabled(false);
                settxtPositionNameEnabled(true);
                settxtPositionTypeEnabled(true);
                settxtPositionDescEnabled(true);
                settblPositionListEnabled(false);
                setbtnQueryPositionEnabled(false);
                setbtnGoQueryPositionEnabled(false);
                setbtnNewPositionEnabled(false);
                setbtnEditPositionEnabled(false);
                setbtnDeletePositionEnabled(false);
                setbtnSavePositionEnabled(true);
                setbtnCancelPositionEnabled(true);
                break;
            case "EDITAR_PERMISSION":
                // Permition
                setcbbListPositionEnabled(false);
                settxtPermitionRowIdEnabled(false);
                settxtPermissionNameEnabled(true);
                settxtPermitionValueEnabled(true);
                setckbPermitionFlgEnabled(true);
                settxtPermitionDescEnabled(true);
                settblPermitionListEnabled(false);
                setbtnQueryPermitionEnabled(false);
                setbtnGoQueryPermitionEnabled(false);
                setbtnNewPermitionEnabled(false);
                setbtnEditPermitionEnabled(false);
                setbtnDeletePermitionEnabled(false);
                setbtnSavePermitionEnabled(true);
                setbtnCancelPermitionEnabled(true);
                break;
            case "CANCELAR_POSITION":
                // Position
                settxtPositionRowIdEnabled(false);
                settxtPositionNameEnabled(false);
                settxtPositionTypeEnabled(false);
                settxtPositionDescEnabled(false);
                settblPositionListEnabled(true);
                setbtnQueryPositionEnabled(true);
                setbtnGoQueryPositionEnabled(false);
                setbtnNewPositionEnabled(true);
                setbtnEditPositionEnabled(true);
                setbtnDeletePositionEnabled(true);
                setbtnSavePositionEnabled(false);
                setbtnCancelPositionEnabled(false);
                break;
            case "CANCELAR_PERMISSION":
                // Permition
                setcbbListPositionEnabled(true);
                settxtPermitionRowIdEnabled(false);
                settxtPermissionNameEnabled(false);
                settxtPermitionValueEnabled(false);
                setckbPermitionFlgEnabled(false);
                settxtPermitionDescEnabled(false);
                settblPermitionListEnabled(true);
                setbtnQueryPermitionEnabled(false);
                setbtnGoQueryPermitionEnabled(false);
                setbtnNewPermitionEnabled(true);
                setbtnEditPermitionEnabled(true);
                setbtnDeletePermitionEnabled(true);
                setbtnSavePermitionEnabled(false);
                setbtnCancelPermitionEnabled(false);
                break;
            case "DELETAR_POSITION":
                // Position
                settxtPositionRowIdEnabled(false);
                settxtPositionNameEnabled(false);
                settxtPositionTypeEnabled(false);
                settxtPositionDescEnabled(false);
                settblPositionListEnabled(true);
                setbtnQueryPositionEnabled(true);
                setbtnGoQueryPositionEnabled(false);
                setbtnNewPositionEnabled(true);
                setbtnEditPositionEnabled(true);
                setbtnDeletePositionEnabled(false);
                setbtnSavePositionEnabled(false);
                setbtnCancelPositionEnabled(false);
                break;
            case "DELETAR_PERMISSION":
                // Permition
                setcbbListPositionEnabled(true);
                settxtPermitionRowIdEnabled(false);
                settxtPermissionNameEnabled(false);
                settxtPermitionValueEnabled(false);
                setckbPermitionFlgEnabled(false);
                settxtPermitionDescEnabled(false);
                settblPermitionListEnabled(true);
                setbtnQueryPermitionEnabled(false);
                setbtnGoQueryPermitionEnabled(false);
                setbtnNewPermitionEnabled(true);
                setbtnEditPermitionEnabled(true);
                setbtnDeletePermitionEnabled(false);
                setbtnSavePermitionEnabled(false);
                setbtnCancelPermitionEnabled(false);
                break;
            case "SALVAR_POSITION":
                // Position
                settxtPositionRowIdEnabled(false);
                settxtPositionNameEnabled(false);
                settxtPositionTypeEnabled(false);
                settxtPositionDescEnabled(false);
                settblPositionListEnabled(true);
                setbtnQueryPositionEnabled(true);
                setbtnGoQueryPositionEnabled(false);
                setbtnNewPositionEnabled(true);
                setbtnEditPositionEnabled(true);
                setbtnDeletePositionEnabled(true);
                setbtnSavePositionEnabled(false);
                setbtnCancelPositionEnabled(false);
                break;
            case "SALVAR_PERMISSION":
                // Permition
                setcbbListPositionEnabled(true);
                settxtPermitionRowIdEnabled(false);
                settxtPermissionNameEnabled(false);
                settxtPermitionValueEnabled(false);
                setckbPermitionFlgEnabled(false);
                settxtPermitionDescEnabled(false);
                settblPermitionListEnabled(true);
                setbtnQueryPermitionEnabled(false);
                setbtnGoQueryPermitionEnabled(false);
                setbtnNewPermitionEnabled(true);
                setbtnEditPermitionEnabled(true);
                setbtnDeletePermitionEnabled(true);
                setbtnSavePermitionEnabled(false);
                setbtnCancelPermitionEnabled(false);
                break;
            case "QUERY_POSITION":
                // Position
                settxtPositionRowIdEnabled(true);
                settxtPositionNameEnabled(true);
                settxtPositionTypeEnabled(true);
                settxtPositionDescEnabled(true);
                settblPositionListEnabled(false);
                setbtnQueryPositionEnabled(false);
                setbtnGoQueryPositionEnabled(true);
                setbtnNewPositionEnabled(false);
                setbtnEditPositionEnabled(false);
                setbtnDeletePositionEnabled(false);
                setbtnSavePositionEnabled(false);
                setbtnCancelPositionEnabled(true);
                break;
            case "QUERY_PERMISSION":
                // Permition
                setcbbListPositionEnabled(true);
                settxtPermitionRowIdEnabled(false);
                settxtPermissionNameEnabled(false);
                settxtPermitionValueEnabled(false);
                setckbPermitionFlgEnabled(false);
                settxtPermitionDescEnabled(false);
                settblPermitionListEnabled(true);
                setbtnQueryPermitionEnabled(false);
                setbtnGoQueryPermitionEnabled(false);
                setbtnNewPermitionEnabled(true);
                setbtnEditPermitionEnabled(true);
                setbtnDeletePermitionEnabled(false);
                setbtnSavePermitionEnabled(false);
                setbtnCancelPermitionEnabled(false);
                break;
            case "GO_QUERY_POSITION":
                // Position
                settxtPositionRowIdEnabled(false);
                settxtPositionNameEnabled(false);
                settxtPositionTypeEnabled(false);
                settxtPositionDescEnabled(false);
                settblPositionListEnabled(true);
                setbtnQueryPositionEnabled(true);
                setbtnGoQueryPositionEnabled(false);
                setbtnNewPositionEnabled(true);
                setbtnEditPositionEnabled(true);
                setbtnDeletePositionEnabled(true);
                setbtnSavePositionEnabled(false);
                setbtnCancelPositionEnabled(false);
                break;
            case "GO_QUERY_PERMISSION":
                // Permition
                setcbbListPositionEnabled(true);
                settxtPermitionRowIdEnabled(false);
                settxtPermissionNameEnabled(false);
                settxtPermitionValueEnabled(false);
                setckbPermitionFlgEnabled(false);
                settxtPermitionDescEnabled(false);
                settblPermitionListEnabled(true);
                setbtnQueryPermitionEnabled(false);
                setbtnGoQueryPermitionEnabled(false);
                setbtnNewPermitionEnabled(true);
                setbtnEditPermitionEnabled(true);
                setbtnDeletePermitionEnabled(false);
                setbtnSavePermitionEnabled(false);
                setbtnCancelPermitionEnabled(false);
                break;
            default:
                break;
	}	
    }

    public void clearFields(String screen) {
        switch(screen) {
            case "POSITION":
                // Position
                cleartxtPositionRowId();
                cleartxtPositionName();
                cleartxtPositionName();
                cleartxtPositionType();
                cleartxtPositionDesc();
                clearlblRecCountPosList();
                clearlblFormPositionNameHeader();
                break;
            case "PERMISSION":
                // Permition
                cleartxtPermissionRowId();
                cleartxtPermissionName();
                cleartxtPermissionValue();
                clearckbPermissionFlg();
                cleartxtPermissionDesc();
                clearlblRecCountPermList();
                clearlblFormPermitionNameHeader();
                break;
            default:
                // Position
                cleartxtPositionRowId();
                cleartxtPositionName();
                cleartxtPositionName();
                cleartxtPositionType();
                cleartxtPositionDesc();
                clearlblRecCountPosList();
                clearlblFormPositionNameHeader();
                // Permition
                cleartxtPermissionRowId();
                cleartxtPermissionName();
                cleartxtPermissionValue();
                clearckbPermissionFlg();
                cleartxtPermissionDesc();
                clearlblRecCountPermList();
                clearlblFormPermitionNameHeader();
                break;
        }
        
        
        
    }
    
    public void clearFilters() {
        setcbbListFilterItemIndex(0);
        cleartxtListFilterValue();
    }
    
    public void clearComboBoxes(String screen){
        clearcbbListFilter();
        switch(screen) {
            case "PERMISSION":
                clearcbbListPosition();
                break;
            default:
                break;
        }
    }
    
    public void insertSelectComboBox(){
        this.setcbbListFilter("Selecione...");
        this.setcbbListPosition("Selecione...");
    }
    
    public final void FocusTraversalKeys(){
        // List: Position - Permition
        this.cbbListFilter.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtListFilterValue.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        // Position
        this.txtPositionRowId.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtPositionName.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtPositionType.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtPositionDesc.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.btnQueryPosition.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.btnGoQueryPosition.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.btnNewPosition.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.btnEditPosition.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.btnDeletePosition.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.btnSavePosition.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.btnCancelPosition.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        // Permition
        this.cbbListPosition.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtPermissionRowId.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtPermissionName.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtPermissionValue.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.ckbPermissionFlg.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtPermissionDesc.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.btnQueryPermission.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.btnGoQueryPermission.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.btnNewPermission.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.btnEditPermission.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.btnDeletePermission.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.btnSavePermission.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.btnCancelPermission.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelLanguage = new javax.swing.JPanel();
        jPanelList = new javax.swing.JTabbedPane();
        PanelList = new javax.swing.JPanel();
        PanelListPosition = new javax.swing.JPanel();
        PanelListPosHeader = new javax.swing.JPanel();
        lblScreenNamePos = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblImage = new javax.swing.JLabel();
        cbbListFilter = new javax.swing.JComboBox<>();
        txtListFilterValue = new javax.swing.JTextField();
        lblInformation = new javax.swing.JLabel();
        lblRecCountPos = new javax.swing.JLabel();
        PanelListPos = new javax.swing.JPanel();
        sPanelListPos = new javax.swing.JScrollPane();
        tblListPos = new javax.swing.JTable();
        PanelListPermission = new javax.swing.JPanel();
        PanelListPermHeader = new javax.swing.JPanel();
        lblScreenNamePerm = new javax.swing.JLabel();
        lblRecCountPerm = new javax.swing.JLabel();
        PanelListPerm = new javax.swing.JPanel();
        sPanelListPerm = new javax.swing.JScrollPane();
        tblListPerm = new javax.swing.JTable();
        PanelPosition = new javax.swing.JPanel();
        PanelListPosition1 = new javax.swing.JPanel();
        PanelListPosHeader1 = new javax.swing.JPanel();
        lblScreenNamePos1 = new javax.swing.JLabel();
        lblRecCountPosList = new javax.swing.JLabel();
        PanelListPos1 = new javax.swing.JPanel();
        sPanelListPos1 = new javax.swing.JScrollPane();
        tblPositionList = new javax.swing.JTable();
        MainPanelForm = new javax.swing.JPanel();
        PanelFormHeader = new javax.swing.JPanel();
        lblFormPositionNameHeader = new javax.swing.JLabel();
        lblFormInformation = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        btnEditPosition = new javax.swing.JButton();
        btnNewPosition = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        btnSavePosition = new javax.swing.JButton();
        btnCancelPosition = new javax.swing.JButton();
        btnDeletePosition = new javax.swing.JButton();
        btnQueryPosition = new javax.swing.JButton();
        btnGoQueryPosition = new javax.swing.JButton();
        sPanelForm = new javax.swing.JScrollPane();
        PanelForm = new javax.swing.JPanel();
        lblPositionRowId = new javax.swing.JLabel();
        txtPositionRowId = new javax.swing.JTextField();
        lblPositionName = new javax.swing.JLabel();
        txtPositionName = new javax.swing.JTextField();
        lblPositionType = new javax.swing.JLabel();
        txtPositionType = new javax.swing.JTextField();
        lblPositionDesc = new javax.swing.JLabel();
        txtPositionDesc = new javax.swing.JTextField();
        PanelPermission = new javax.swing.JPanel();
        PanelList1 = new javax.swing.JPanel();
        PanelListPermission1 = new javax.swing.JPanel();
        PanelListPermHeader1 = new javax.swing.JPanel();
        lblScreenNamePerm1 = new javax.swing.JLabel();
        lblRecCountPermList = new javax.swing.JLabel();
        cbbListPosition = new javax.swing.JComboBox<>();
        PanelListPerm1 = new javax.swing.JPanel();
        sPanelListPerm1 = new javax.swing.JScrollPane();
        tblPermissionList = new javax.swing.JTable();
        MainPanelForm2 = new javax.swing.JPanel();
        PanelFormHeader2 = new javax.swing.JPanel();
        lblFormPermissionNameHeader = new javax.swing.JLabel();
        lblFormInformation2 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        btnEditPermission = new javax.swing.JButton();
        btnNewPermission = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JSeparator();
        btnSavePermission = new javax.swing.JButton();
        btnCancelPermission = new javax.swing.JButton();
        btnDeletePermission = new javax.swing.JButton();
        btnQueryPermission = new javax.swing.JButton();
        btnGoQueryPermission = new javax.swing.JButton();
        sPanelForm1 = new javax.swing.JScrollPane();
        PanelForm1 = new javax.swing.JPanel();
        lblPermitionRowId = new javax.swing.JLabel();
        txtPermissionRowId = new javax.swing.JTextField();
        lblPermitionName = new javax.swing.JLabel();
        lblPermitionValue = new javax.swing.JLabel();
        txtPermissionValue = new javax.swing.JTextField();
        lblPermitionDesc = new javax.swing.JLabel();
        txtPermissionDesc = new javax.swing.JTextField();
        lblPermitionPerm = new javax.swing.JLabel();
        ckbPermissionFlg = new javax.swing.JCheckBox();
        txtPermissionName = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lista de Valores");

        PanelLanguage.setBackground(new java.awt.Color(255, 255, 255));
        PanelLanguage.setPreferredSize(new java.awt.Dimension(1366, 757));

        jPanelList.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        PanelList.setBackground(new java.awt.Color(255, 255, 255));

        lblScreenNamePos.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        lblScreenNamePos.setText("Posições");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        lblImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/20px/Filter 20x20.png"))); // NOI18N

        cbbListFilter.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        cbbListFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbListFilter.setMaximumSize(new java.awt.Dimension(250, 32767));
        cbbListFilter.setPreferredSize(new java.awt.Dimension(250, 23));

        txtListFilterValue.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtListFilterValue.setToolTipText("");
        txtListFilterValue.setMaximumSize(new java.awt.Dimension(250, 2147483647));
        txtListFilterValue.setPreferredSize(new java.awt.Dimension(250, 23));

        lblInformation.setBackground(new java.awt.Color(255, 255, 255));
        lblInformation.setText("Pressione Enter para pesquisar");
        lblInformation.setEnabled(false);

        lblRecCountPos.setBackground(new java.awt.Color(255, 255, 255));
        lblRecCountPos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblRecCountPos.setText("Registros: 0 - 100");
        lblRecCountPos.setToolTipText("");
        lblRecCountPos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblRecCountPos.setMaximumSize(new java.awt.Dimension(410, 14));

        javax.swing.GroupLayout PanelListPosHeaderLayout = new javax.swing.GroupLayout(PanelListPosHeader);
        PanelListPosHeader.setLayout(PanelListPosHeaderLayout);
        PanelListPosHeaderLayout.setHorizontalGroup(
            PanelListPosHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelListPosHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblScreenNamePos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblImage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbbListFilter, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtListFilterValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInformation)
                .addGap(180, 180, 180)
                .addComponent(lblRecCountPos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        PanelListPosHeaderLayout.setVerticalGroup(
            PanelListPosHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelListPosHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelListPosHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelListPosHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblScreenNamePos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblRecCountPos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbbListFilter, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtListFilterValue, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblInformation, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        sPanelListPos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        sPanelListPos.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        sPanelListPos.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        sPanelListPos.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N

        tblListPos.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        tblListPos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nome", "Tipo", "Comentários"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblListPos.setGridColor(new java.awt.Color(204, 204, 204));
        tblListPos.setRowHeight(22);
        tblListPos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblListPos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblListPosKeyPressed(evt);
            }
        });
        sPanelListPos.setViewportView(tblListPos);

        javax.swing.GroupLayout PanelListPosLayout = new javax.swing.GroupLayout(PanelListPos);
        PanelListPos.setLayout(PanelListPosLayout);
        PanelListPosLayout.setHorizontalGroup(
            PanelListPosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelListPosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sPanelListPos)
                .addContainerGap())
        );
        PanelListPosLayout.setVerticalGroup(
            PanelListPosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sPanelListPos, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PanelListPositionLayout = new javax.swing.GroupLayout(PanelListPosition);
        PanelListPosition.setLayout(PanelListPositionLayout);
        PanelListPositionLayout.setHorizontalGroup(
            PanelListPositionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelListPosHeader, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelListPos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelListPositionLayout.setVerticalGroup(
            PanelListPositionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelListPositionLayout.createSequentialGroup()
                .addComponent(PanelListPosHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelListPos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        lblScreenNamePerm.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        lblScreenNamePerm.setText("Permissões");

        lblRecCountPerm.setBackground(new java.awt.Color(255, 255, 255));
        lblRecCountPerm.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblRecCountPerm.setText("Registros: 0 - 100");
        lblRecCountPerm.setToolTipText("");
        lblRecCountPerm.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblRecCountPerm.setMaximumSize(new java.awt.Dimension(410, 14));

        javax.swing.GroupLayout PanelListPermHeaderLayout = new javax.swing.GroupLayout(PanelListPermHeader);
        PanelListPermHeader.setLayout(PanelListPermHeaderLayout);
        PanelListPermHeaderLayout.setHorizontalGroup(
            PanelListPermHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelListPermHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblScreenNamePerm)
                .addGap(947, 947, 947)
                .addComponent(lblRecCountPerm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        PanelListPermHeaderLayout.setVerticalGroup(
            PanelListPermHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelListPermHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelListPermHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblScreenNamePerm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblRecCountPerm, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        sPanelListPerm.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        sPanelListPerm.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        sPanelListPerm.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        sPanelListPerm.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N

        tblListPerm.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        tblListPerm.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nome", "Valor", "Permitido", "Descrição"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblListPerm.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        tblListPerm.setGridColor(new java.awt.Color(204, 204, 204));
        tblListPerm.setRowHeight(22);
        tblListPerm.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblListPerm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblListPermKeyPressed(evt);
            }
        });
        sPanelListPerm.setViewportView(tblListPerm);

        javax.swing.GroupLayout PanelListPermLayout = new javax.swing.GroupLayout(PanelListPerm);
        PanelListPerm.setLayout(PanelListPermLayout);
        PanelListPermLayout.setHorizontalGroup(
            PanelListPermLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelListPermLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sPanelListPerm)
                .addContainerGap())
        );
        PanelListPermLayout.setVerticalGroup(
            PanelListPermLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sPanelListPerm, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PanelListPermissionLayout = new javax.swing.GroupLayout(PanelListPermission);
        PanelListPermission.setLayout(PanelListPermissionLayout);
        PanelListPermissionLayout.setHorizontalGroup(
            PanelListPermissionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelListPermHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelListPerm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelListPermissionLayout.setVerticalGroup(
            PanelListPermissionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelListPermissionLayout.createSequentialGroup()
                .addComponent(PanelListPermHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelListPerm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout PanelListLayout = new javax.swing.GroupLayout(PanelList);
        PanelList.setLayout(PanelListLayout);
        PanelListLayout.setHorizontalGroup(
            PanelListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelListPosition, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelListPermission, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelListLayout.setVerticalGroup(
            PanelListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelListLayout.createSequentialGroup()
                .addComponent(PanelListPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelListPermission, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelList.addTab("Lista de Posições e Permissões", PanelList);

        PanelPosition.setBackground(new java.awt.Color(255, 255, 255));

        lblScreenNamePos1.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        lblScreenNamePos1.setText("Posições");

        lblRecCountPosList.setBackground(new java.awt.Color(255, 255, 255));
        lblRecCountPosList.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblRecCountPosList.setText("Registros: 0 - 100");
        lblRecCountPosList.setToolTipText("");
        lblRecCountPosList.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblRecCountPosList.setMaximumSize(new java.awt.Dimension(410, 14));

        javax.swing.GroupLayout PanelListPosHeader1Layout = new javax.swing.GroupLayout(PanelListPosHeader1);
        PanelListPosHeader1.setLayout(PanelListPosHeader1Layout);
        PanelListPosHeader1Layout.setHorizontalGroup(
            PanelListPosHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelListPosHeader1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblScreenNamePos1)
                .addGap(957, 957, 957)
                .addComponent(lblRecCountPosList, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                .addContainerGap())
        );
        PanelListPosHeader1Layout.setVerticalGroup(
            PanelListPosHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelListPosHeader1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelListPosHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblScreenNamePos1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblRecCountPosList, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        sPanelListPos1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        sPanelListPos1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        sPanelListPos1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        sPanelListPos1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N

        tblPositionList.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        tblPositionList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nome", "Tipo", "Descrição"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPositionList.setGridColor(new java.awt.Color(204, 204, 204));
        tblPositionList.setRowHeight(22);
        tblPositionList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblPositionList.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblPositionListKeyPressed(evt);
            }
        });
        sPanelListPos1.setViewportView(tblPositionList);

        javax.swing.GroupLayout PanelListPos1Layout = new javax.swing.GroupLayout(PanelListPos1);
        PanelListPos1.setLayout(PanelListPos1Layout);
        PanelListPos1Layout.setHorizontalGroup(
            PanelListPos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelListPos1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sPanelListPos1)
                .addContainerGap())
        );
        PanelListPos1Layout.setVerticalGroup(
            PanelListPos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sPanelListPos1, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PanelListPosition1Layout = new javax.swing.GroupLayout(PanelListPosition1);
        PanelListPosition1.setLayout(PanelListPosition1Layout);
        PanelListPosition1Layout.setHorizontalGroup(
            PanelListPosition1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelListPosHeader1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelListPos1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelListPosition1Layout.setVerticalGroup(
            PanelListPosition1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelListPosition1Layout.createSequentialGroup()
                .addComponent(PanelListPosHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelListPos1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        lblFormPositionNameHeader.setBackground(new java.awt.Color(255, 255, 255));
        lblFormPositionNameHeader.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        lblFormPositionNameHeader.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblFormPositionNameHeader.setToolTipText("");
        lblFormPositionNameHeader.setMinimumSize(new java.awt.Dimension(0, 30));

        lblFormInformation.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblFormInformation.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFormInformation.setText("Campos Obrigatórios (*)");
        lblFormInformation.setEnabled(false);

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btnEditPosition.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnEditPosition.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/20px/Edit 20x20.png"))); // NOI18N
        btnEditPosition.setToolTipText("Editar");
        btnEditPosition.setBorderPainted(false);
        btnEditPosition.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEditPosition.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnEditPosition.setIconTextGap(3);

        btnNewPosition.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnNewPosition.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/20px/New 20x20.png"))); // NOI18N
        btnNewPosition.setToolTipText("Novo");
        btnNewPosition.setBorderPainted(false);
        btnNewPosition.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNewPosition.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnNewPosition.setIconTextGap(0);
        btnNewPosition.setMargin(new java.awt.Insets(2, 2, 2, 2));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btnSavePosition.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnSavePosition.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/20px/Save 20x20.png"))); // NOI18N
        btnSavePosition.setToolTipText("Salvar");
        btnSavePosition.setEnabled(false);
        btnSavePosition.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnSavePosition.setIconTextGap(3);

        btnCancelPosition.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnCancelPosition.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/20px/Cancel 20x20.png"))); // NOI18N
        btnCancelPosition.setToolTipText("Cancelar");
        btnCancelPosition.setEnabled(false);
        btnCancelPosition.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnCancelPosition.setIconTextGap(3);
        btnCancelPosition.setMargin(new java.awt.Insets(2, 5, 2, 5));

        btnDeletePosition.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnDeletePosition.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/20px/Delete 20x20.png"))); // NOI18N
        btnDeletePosition.setToolTipText("Excluir");
        btnDeletePosition.setBorderPainted(false);
        btnDeletePosition.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDeletePosition.setEnabled(false);
        btnDeletePosition.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnDeletePosition.setIconTextGap(3);

        btnQueryPosition.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnQueryPosition.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/20px/Lupa 20x20.png"))); // NOI18N
        btnQueryPosition.setToolTipText("Pesquisar");
        btnQueryPosition.setBorderPainted(false);
        btnQueryPosition.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnQueryPosition.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnQueryPosition.setIconTextGap(0);
        btnQueryPosition.setMargin(new java.awt.Insets(2, 2, 2, 2));

        btnGoQueryPosition.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnGoQueryPosition.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/20px/Go 20x20.png"))); // NOI18N
        btnGoQueryPosition.setToolTipText("Ir");
        btnGoQueryPosition.setBorderPainted(false);
        btnGoQueryPosition.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnGoQueryPosition.setEnabled(false);
        btnGoQueryPosition.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnGoQueryPosition.setIconTextGap(3);

        javax.swing.GroupLayout PanelFormHeaderLayout = new javax.swing.GroupLayout(PanelFormHeader);
        PanelFormHeader.setLayout(PanelFormHeaderLayout);
        PanelFormHeaderLayout.setHorizontalGroup(
            PanelFormHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelFormHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblFormPositionNameHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFormInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnQueryPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGoQueryPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNewPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDeletePosition, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSavePosition, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        PanelFormHeaderLayout.setVerticalGroup(
            PanelFormHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFormHeaderLayout.createSequentialGroup()
                .addGroup(PanelFormHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNewPosition, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblFormInformation, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSavePosition, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelPosition, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblFormPositionNameHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditPosition, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDeletePosition, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnQueryPosition, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGoQueryPosition, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        sPanelForm.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        sPanelForm.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        sPanelForm.setMinimumSize(new java.awt.Dimension(0, 0));
        sPanelForm.setPreferredSize(new java.awt.Dimension(2000, 607));

        PanelForm.setBackground(new java.awt.Color(255, 255, 255));
        PanelForm.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        PanelForm.setPreferredSize(new java.awt.Dimension(800, 80));

        lblPositionRowId.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblPositionRowId.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPositionRowId.setText("Id:");
        lblPositionRowId.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        lblPositionRowId.setEnabled(false);
        lblPositionRowId.setOpaque(true);

        txtPositionRowId.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtPositionRowId.setText("jTextField1");
        txtPositionRowId.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.background")), javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5)));
        txtPositionRowId.setEnabled(false);

        lblPositionName.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblPositionName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPositionName.setText("Nome*:");
        lblPositionName.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        lblPositionName.setEnabled(false);
        lblPositionName.setOpaque(true);

        txtPositionName.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtPositionName.setText("jTextField1");
        txtPositionName.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.background")), javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5)));
        txtPositionName.setEnabled(false);

        lblPositionType.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblPositionType.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPositionType.setText("Tipo*:");
        lblPositionType.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        lblPositionType.setEnabled(false);
        lblPositionType.setOpaque(true);

        txtPositionType.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtPositionType.setText("jTextField1");
        txtPositionType.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.background")), javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5)));
        txtPositionType.setEnabled(false);

        lblPositionDesc.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblPositionDesc.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPositionDesc.setText("Descrição:");
        lblPositionDesc.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        lblPositionDesc.setEnabled(false);
        lblPositionDesc.setOpaque(true);

        txtPositionDesc.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtPositionDesc.setText("jTextField1");
        txtPositionDesc.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.background")), javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5)));
        txtPositionDesc.setEnabled(false);

        javax.swing.GroupLayout PanelFormLayout = new javax.swing.GroupLayout(PanelForm);
        PanelForm.setLayout(PanelFormLayout);
        PanelFormLayout.setHorizontalGroup(
            PanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPositionRowId, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPositionRowId, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelFormLayout.createSequentialGroup()
                        .addComponent(txtPositionName, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPositionType, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelFormLayout.createSequentialGroup()
                        .addComponent(lblPositionName, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPositionType, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPositionDesc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPositionDesc, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE))
                .addContainerGap())
        );
        PanelFormLayout.setVerticalGroup(
            PanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelFormLayout.createSequentialGroup()
                        .addComponent(lblPositionDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPositionDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelFormLayout.createSequentialGroup()
                        .addGroup(PanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPositionType, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblPositionRowId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblPositionName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPositionRowId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPositionName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPositionType, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        sPanelForm.setViewportView(PanelForm);

        javax.swing.GroupLayout MainPanelFormLayout = new javax.swing.GroupLayout(MainPanelForm);
        MainPanelForm.setLayout(MainPanelFormLayout);
        MainPanelFormLayout.setHorizontalGroup(
            MainPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelFormHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(MainPanelFormLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sPanelForm, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        MainPanelFormLayout.setVerticalGroup(
            MainPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainPanelFormLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelFormHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sPanelForm, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout PanelPositionLayout = new javax.swing.GroupLayout(PanelPosition);
        PanelPosition.setLayout(PanelPositionLayout);
        PanelPositionLayout.setHorizontalGroup(
            PanelPositionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelListPosition1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(MainPanelForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelPositionLayout.setVerticalGroup(
            PanelPositionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPositionLayout.createSequentialGroup()
                .addComponent(PanelListPosition1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MainPanelForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanelList.addTab("Posições", PanelPosition);

        PanelPermission.setBackground(new java.awt.Color(255, 255, 255));

        PanelList1.setBackground(new java.awt.Color(255, 255, 255));

        lblScreenNamePerm1.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        lblScreenNamePerm1.setText("Permissões da Posição:");

        lblRecCountPermList.setBackground(new java.awt.Color(255, 255, 255));
        lblRecCountPermList.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblRecCountPermList.setText("Registros: 0 - 100");
        lblRecCountPermList.setToolTipText("");
        lblRecCountPermList.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblRecCountPermList.setMaximumSize(new java.awt.Dimension(410, 14));

        cbbListPosition.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        cbbListPosition.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbListPosition.setMaximumSize(new java.awt.Dimension(250, 32767));
        cbbListPosition.setPreferredSize(new java.awt.Dimension(250, 23));

        javax.swing.GroupLayout PanelListPermHeader1Layout = new javax.swing.GroupLayout(PanelListPermHeader1);
        PanelListPermHeader1.setLayout(PanelListPermHeader1Layout);
        PanelListPermHeader1Layout.setHorizontalGroup(
            PanelListPermHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelListPermHeader1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblScreenNamePerm1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbbListPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblRecCountPermList, javax.swing.GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE)
                .addContainerGap())
        );
        PanelListPermHeader1Layout.setVerticalGroup(
            PanelListPermHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelListPermHeader1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelListPermHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PanelListPermHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblScreenNamePerm1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbbListPosition, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                    .addComponent(lblRecCountPermList, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        sPanelListPerm1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        sPanelListPerm1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        sPanelListPerm1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        sPanelListPerm1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N

        tblPermissionList.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        tblPermissionList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nome", "Valor", "Permitido", "Descrição"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPermissionList.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        tblPermissionList.setGridColor(new java.awt.Color(204, 204, 204));
        tblPermissionList.setRowHeight(22);
        tblPermissionList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblPermissionList.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblPermissionListKeyPressed(evt);
            }
        });
        sPanelListPerm1.setViewportView(tblPermissionList);

        javax.swing.GroupLayout PanelListPerm1Layout = new javax.swing.GroupLayout(PanelListPerm1);
        PanelListPerm1.setLayout(PanelListPerm1Layout);
        PanelListPerm1Layout.setHorizontalGroup(
            PanelListPerm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelListPerm1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sPanelListPerm1)
                .addContainerGap())
        );
        PanelListPerm1Layout.setVerticalGroup(
            PanelListPerm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sPanelListPerm1, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PanelListPermission1Layout = new javax.swing.GroupLayout(PanelListPermission1);
        PanelListPermission1.setLayout(PanelListPermission1Layout);
        PanelListPermission1Layout.setHorizontalGroup(
            PanelListPermission1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelListPermHeader1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelListPerm1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelListPermission1Layout.setVerticalGroup(
            PanelListPermission1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelListPermission1Layout.createSequentialGroup()
                .addComponent(PanelListPermHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelListPerm1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout PanelList1Layout = new javax.swing.GroupLayout(PanelList1);
        PanelList1.setLayout(PanelList1Layout);
        PanelList1Layout.setHorizontalGroup(
            PanelList1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelListPermission1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelList1Layout.setVerticalGroup(
            PanelList1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelListPermission1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        lblFormPermissionNameHeader.setBackground(new java.awt.Color(255, 255, 255));
        lblFormPermissionNameHeader.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        lblFormPermissionNameHeader.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblFormPermissionNameHeader.setToolTipText("");
        lblFormPermissionNameHeader.setMinimumSize(new java.awt.Dimension(0, 30));

        lblFormInformation2.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblFormInformation2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFormInformation2.setText("Campos Obrigatórios (*)");
        lblFormInformation2.setEnabled(false);

        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btnEditPermission.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnEditPermission.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/20px/Edit 20x20.png"))); // NOI18N
        btnEditPermission.setToolTipText("Editar");
        btnEditPermission.setBorderPainted(false);
        btnEditPermission.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEditPermission.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnEditPermission.setIconTextGap(3);

        btnNewPermission.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnNewPermission.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/20px/New 20x20.png"))); // NOI18N
        btnNewPermission.setToolTipText("Novo");
        btnNewPermission.setBorderPainted(false);
        btnNewPermission.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNewPermission.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnNewPermission.setIconTextGap(0);
        btnNewPermission.setMargin(new java.awt.Insets(2, 2, 2, 2));

        jSeparator8.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btnSavePermission.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnSavePermission.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/20px/Save 20x20.png"))); // NOI18N
        btnSavePermission.setToolTipText("Salvar");
        btnSavePermission.setEnabled(false);
        btnSavePermission.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnSavePermission.setIconTextGap(3);

        btnCancelPermission.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnCancelPermission.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/20px/Cancel 20x20.png"))); // NOI18N
        btnCancelPermission.setToolTipText("Cancelar");
        btnCancelPermission.setEnabled(false);
        btnCancelPermission.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnCancelPermission.setIconTextGap(3);
        btnCancelPermission.setMargin(new java.awt.Insets(2, 5, 2, 5));

        btnDeletePermission.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnDeletePermission.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/20px/Delete 20x20.png"))); // NOI18N
        btnDeletePermission.setToolTipText("Excluir");
        btnDeletePermission.setBorderPainted(false);
        btnDeletePermission.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDeletePermission.setEnabled(false);
        btnDeletePermission.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnDeletePermission.setIconTextGap(3);

        btnQueryPermission.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnQueryPermission.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/20px/Lupa 20x20.png"))); // NOI18N
        btnQueryPermission.setToolTipText("Pesquisar");
        btnQueryPermission.setBorderPainted(false);
        btnQueryPermission.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnQueryPermission.setEnabled(false);
        btnQueryPermission.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnQueryPermission.setIconTextGap(0);
        btnQueryPermission.setMargin(new java.awt.Insets(2, 2, 2, 2));

        btnGoQueryPermission.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnGoQueryPermission.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/20px/Go 20x20.png"))); // NOI18N
        btnGoQueryPermission.setToolTipText("Ir");
        btnGoQueryPermission.setBorderPainted(false);
        btnGoQueryPermission.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnGoQueryPermission.setEnabled(false);
        btnGoQueryPermission.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnGoQueryPermission.setIconTextGap(3);

        javax.swing.GroupLayout PanelFormHeader2Layout = new javax.swing.GroupLayout(PanelFormHeader2);
        PanelFormHeader2.setLayout(PanelFormHeader2Layout);
        PanelFormHeader2Layout.setHorizontalGroup(
            PanelFormHeader2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelFormHeader2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblFormPermissionNameHeader, javax.swing.GroupLayout.DEFAULT_SIZE, 667, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFormInformation2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnQueryPermission, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGoQueryPermission, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNewPermission, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditPermission, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDeletePermission, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSavePermission, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelPermission, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        PanelFormHeader2Layout.setVerticalGroup(
            PanelFormHeader2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFormHeader2Layout.createSequentialGroup()
                .addGroup(PanelFormHeader2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNewPermission, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator8)
                    .addComponent(jSeparator7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblFormInformation2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSavePermission, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelPermission, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblFormPermissionNameHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditPermission, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDeletePermission, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnQueryPermission, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGoQueryPermission, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        sPanelForm1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        sPanelForm1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        sPanelForm1.setMinimumSize(new java.awt.Dimension(0, 0));
        sPanelForm1.setPreferredSize(new java.awt.Dimension(2000, 607));

        PanelForm1.setBackground(new java.awt.Color(255, 255, 255));
        PanelForm1.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        PanelForm1.setPreferredSize(new java.awt.Dimension(800, 80));

        lblPermitionRowId.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblPermitionRowId.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPermitionRowId.setText("Id:");
        lblPermitionRowId.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        lblPermitionRowId.setEnabled(false);
        lblPermitionRowId.setOpaque(true);

        txtPermissionRowId.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtPermissionRowId.setText("jTextField1");
        txtPermissionRowId.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.background")), javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5)));
        txtPermissionRowId.setEnabled(false);

        lblPermitionName.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblPermitionName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPermitionName.setText("Nome*:");
        lblPermitionName.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        lblPermitionName.setEnabled(false);
        lblPermitionName.setOpaque(true);

        lblPermitionValue.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblPermitionValue.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPermitionValue.setText("Valor*:");
        lblPermitionValue.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        lblPermitionValue.setEnabled(false);
        lblPermitionValue.setOpaque(true);

        txtPermissionValue.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtPermissionValue.setText("jTextField1");
        txtPermissionValue.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.background")), javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5)));
        txtPermissionValue.setEnabled(false);

        lblPermitionDesc.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblPermitionDesc.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPermitionDesc.setText("Descrição:");
        lblPermitionDesc.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        lblPermitionDesc.setEnabled(false);
        lblPermitionDesc.setOpaque(true);

        txtPermissionDesc.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtPermissionDesc.setText("jTextField1");
        txtPermissionDesc.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.background")), javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5)));
        txtPermissionDesc.setEnabled(false);

        lblPermitionPerm.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblPermitionPerm.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPermitionPerm.setText("Permitido*:");
        lblPermitionPerm.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        lblPermitionPerm.setEnabled(false);
        lblPermitionPerm.setOpaque(true);

        ckbPermissionFlg.setBackground(new java.awt.Color(255, 255, 255));
        ckbPermissionFlg.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        ckbPermissionFlg.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        ckbPermissionFlg.setBorderPainted(true);
        ckbPermissionFlg.setEnabled(false);
        ckbPermissionFlg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ckbPermissionFlg.setMaximumSize(new java.awt.Dimension(165, 21));
        ckbPermissionFlg.setPreferredSize(new java.awt.Dimension(165, 21));

        txtPermissionName.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtPermissionName.setText("jTextField1");
        txtPermissionName.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.background")), javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5)));
        txtPermissionName.setEnabled(false);

        javax.swing.GroupLayout PanelForm1Layout = new javax.swing.GroupLayout(PanelForm1);
        PanelForm1.setLayout(PanelForm1Layout);
        PanelForm1Layout.setHorizontalGroup(
            PanelForm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelForm1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelForm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPermissionRowId, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPermitionRowId, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelForm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblPermitionName, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPermissionName, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelForm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPermitionValue, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPermissionValue, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelForm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblPermitionPerm, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                    .addComponent(ckbPermissionFlg, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelForm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPermitionDesc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPermissionDesc, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE))
                .addContainerGap())
        );
        PanelForm1Layout.setVerticalGroup(
            PanelForm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelForm1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelForm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelForm1Layout.createSequentialGroup()
                        .addComponent(lblPermitionPerm, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ckbPermissionFlg, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelForm1Layout.createSequentialGroup()
                        .addComponent(lblPermitionDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPermissionDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelForm1Layout.createSequentialGroup()
                        .addGroup(PanelForm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPermitionValue, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelForm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblPermitionRowId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblPermitionName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelForm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPermissionRowId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPermissionValue, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPermissionName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        sPanelForm1.setViewportView(PanelForm1);

        javax.swing.GroupLayout MainPanelForm2Layout = new javax.swing.GroupLayout(MainPanelForm2);
        MainPanelForm2.setLayout(MainPanelForm2Layout);
        MainPanelForm2Layout.setHorizontalGroup(
            MainPanelForm2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelFormHeader2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(MainPanelForm2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sPanelForm1, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        MainPanelForm2Layout.setVerticalGroup(
            MainPanelForm2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainPanelForm2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelFormHeader2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sPanelForm1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout PanelPermissionLayout = new javax.swing.GroupLayout(PanelPermission);
        PanelPermission.setLayout(PanelPermissionLayout);
        PanelPermissionLayout.setHorizontalGroup(
            PanelPermissionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanelForm2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelList1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelPermissionLayout.setVerticalGroup(
            PanelPermissionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPermissionLayout.createSequentialGroup()
                .addComponent(PanelList1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MainPanelForm2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanelList.addTab("Permissões", PanelPermission);

        javax.swing.GroupLayout PanelLanguageLayout = new javax.swing.GroupLayout(PanelLanguage);
        PanelLanguage.setLayout(PanelLanguageLayout);
        PanelLanguageLayout.setHorizontalGroup(
            PanelLanguageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelList)
        );
        PanelLanguageLayout.setVerticalGroup(
            PanelLanguageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelList)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelLanguage, javax.swing.GroupLayout.DEFAULT_SIZE, 1187, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelLanguage, javax.swing.GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblListPosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblListPosKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tblListPosKeyPressed

    private void tblListPermKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblListPermKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tblListPermKeyPressed

    private void tblPositionListKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblPositionListKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tblPositionListKeyPressed

    private void tblPermissionListKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblPermissionListKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tblPermissionListKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MainPanelForm;
    private javax.swing.JPanel MainPanelForm2;
    private javax.swing.JPanel PanelForm;
    private javax.swing.JPanel PanelForm1;
    private javax.swing.JPanel PanelFormHeader;
    private javax.swing.JPanel PanelFormHeader2;
    private javax.swing.JPanel PanelLanguage;
    private javax.swing.JPanel PanelList;
    private javax.swing.JPanel PanelList1;
    private javax.swing.JPanel PanelListPerm;
    private javax.swing.JPanel PanelListPerm1;
    private javax.swing.JPanel PanelListPermHeader;
    private javax.swing.JPanel PanelListPermHeader1;
    private javax.swing.JPanel PanelListPermission;
    private javax.swing.JPanel PanelListPermission1;
    private javax.swing.JPanel PanelListPos;
    private javax.swing.JPanel PanelListPos1;
    private javax.swing.JPanel PanelListPosHeader;
    private javax.swing.JPanel PanelListPosHeader1;
    private javax.swing.JPanel PanelListPosition;
    private javax.swing.JPanel PanelListPosition1;
    private javax.swing.JPanel PanelPermission;
    private javax.swing.JPanel PanelPosition;
    private javax.swing.JButton btnCancelPermission;
    private javax.swing.JButton btnCancelPosition;
    private javax.swing.JButton btnDeletePermission;
    private javax.swing.JButton btnDeletePosition;
    private javax.swing.JButton btnEditPermission;
    private javax.swing.JButton btnEditPosition;
    private javax.swing.JButton btnGoQueryPermission;
    private javax.swing.JButton btnGoQueryPosition;
    private javax.swing.JButton btnNewPermission;
    private javax.swing.JButton btnNewPosition;
    private javax.swing.JButton btnQueryPermission;
    private javax.swing.JButton btnQueryPosition;
    private javax.swing.JButton btnSavePermission;
    private javax.swing.JButton btnSavePosition;
    private javax.swing.JComboBox<String> cbbListFilter;
    private javax.swing.JComboBox<String> cbbListPosition;
    private javax.swing.JCheckBox ckbPermissionFlg;
    private javax.swing.JTabbedPane jPanelList;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JLabel lblFormInformation;
    private javax.swing.JLabel lblFormInformation2;
    private javax.swing.JLabel lblFormPermissionNameHeader;
    private javax.swing.JLabel lblFormPositionNameHeader;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblInformation;
    private javax.swing.JLabel lblPermitionDesc;
    private javax.swing.JLabel lblPermitionName;
    private javax.swing.JLabel lblPermitionPerm;
    private javax.swing.JLabel lblPermitionRowId;
    private javax.swing.JLabel lblPermitionValue;
    private javax.swing.JLabel lblPositionDesc;
    private javax.swing.JLabel lblPositionName;
    private javax.swing.JLabel lblPositionRowId;
    private javax.swing.JLabel lblPositionType;
    private javax.swing.JLabel lblRecCountPerm;
    private javax.swing.JLabel lblRecCountPermList;
    private javax.swing.JLabel lblRecCountPos;
    private javax.swing.JLabel lblRecCountPosList;
    private javax.swing.JLabel lblScreenNamePerm;
    private javax.swing.JLabel lblScreenNamePerm1;
    private javax.swing.JLabel lblScreenNamePos;
    private javax.swing.JLabel lblScreenNamePos1;
    private javax.swing.JScrollPane sPanelForm;
    private javax.swing.JScrollPane sPanelForm1;
    private javax.swing.JScrollPane sPanelListPerm;
    private javax.swing.JScrollPane sPanelListPerm1;
    private javax.swing.JScrollPane sPanelListPos;
    private javax.swing.JScrollPane sPanelListPos1;
    private javax.swing.JTable tblListPerm;
    private javax.swing.JTable tblListPos;
    private javax.swing.JTable tblPermissionList;
    private javax.swing.JTable tblPositionList;
    private javax.swing.JTextField txtListFilterValue;
    private javax.swing.JTextField txtPermissionDesc;
    private javax.swing.JTextField txtPermissionName;
    private javax.swing.JTextField txtPermissionRowId;
    private javax.swing.JTextField txtPermissionValue;
    private javax.swing.JTextField txtPositionDesc;
    private javax.swing.JTextField txtPositionName;
    private javax.swing.JTextField txtPositionRowId;
    private javax.swing.JTextField txtPositionType;
    // End of variables declaration//GEN-END:variables
}
