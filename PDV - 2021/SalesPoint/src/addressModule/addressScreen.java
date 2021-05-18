/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressModule;

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
public class addressScreen extends javax.swing.JFrame {

    /**
     * Creates new form ContactManagement
     */
    public addressScreen() {
        initComponents();
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
    public void setListenerBtnSearchAddress(ActionListener listener) { this.btnSearchAddress.addActionListener(listener); }
    public void setListenerContactManagementScreen(WindowListener listener) { this.addWindowListener(listener); }
    
    // Table
    public DefaultTableModel getTableModel(){ return (DefaultTableModel) tblAddressList.getModel(); }
    public void setListenerTblAddressListSelection(ListSelectionListener listener) { this.tblAddressList.getSelectionModel().addListSelectionListener(listener); }
    public String getSelectedRowIdAddressList() { try { return (String) this.tblAddressList.getValueAt(this.tblAddressList.getSelectedRow(), 0); } catch (Exception e) { return ""; } }
    public void setSelectedRowColumnList(int row, int column){ this.tblAddressList.changeSelection(row, column, false, false); }
    public int getSelectedRowList() { return this.tblAddressList.getSelectedRow(); }
    public int getNumOfListRows() { return this.tblAddressList.getRowCount(); }
    
    // Component Setters
    public void settxtAddressListFilterValue(String value) { this.txtAddressListFilterValue.setText(value); this.txtAddressListFilterValue.paintImmediately(this.txtAddressListFilterValue.getVisibleRect()); }
    public void settxtRowId(String value) { this.txtRowId.setText(value); this.txtRowId.paintImmediately(this.txtRowId.getVisibleRect()); }
    public void settxtZipcodePart1(String value) { this.txtZipcodePart1.setText(value); this.txtZipcodePart1.paintImmediately(this.txtZipcodePart1.getVisibleRect()); }
    public void settxtZipcodePart2(String value) { this.txtZipcodePart2.setText(value); this.txtZipcodePart2.paintImmediately(this.txtZipcodePart2.getVisibleRect()); }
    public void settxtAddressName(String value) { this.txtAddressName.setText(value); this.txtAddressName.paintImmediately(this.txtAddressName.getVisibleRect()); }
    public void settxtAddressNumber(String value) { this.txtAddressNumber.setText(value); this.txtAddressNumber.paintImmediately(this.txtAddressNumber.getVisibleRect()); }
    public void settxtAddressComplement(String value) { this.txtAddressComplement.setText(value); this.txtAddressComplement.paintImmediately(this.txtAddressComplement.getVisibleRect()); }
    public void settxtNeighborhood(String value) { this.txtNeighborhood.setText(value); this.txtNeighborhood.paintImmediately(this.txtNeighborhood.getVisibleRect()); }
    public void settxtAddressCity(String value) { this.txtAddressCity.setText(value); this.txtAddressCity.paintImmediately(this.txtAddressCity.getVisibleRect()); }
    public void settxtAddressState(String value) { this.txtAddressState.setText(value); this.txtAddressState.paintImmediately(this.txtAddressState.getVisibleRect()); }
    public void settxtHomeFloor(String value) { this.txtHomeFloor.setText(value); this.txtHomeFloor.paintImmediately(this.txtHomeFloor.getVisibleRect()); }
    public void settxtHomeNumber(String value) { this.txtHomeNumber.setText(value); this.txtHomeNumber.paintImmediately(this.txtHomeNumber.getVisibleRect()); }
    public void settxtHomeBlock(String value) { this.txtHomeBlock.setText(value); this.txtHomeBlock.paintImmediately(this.txtHomeBlock.getVisibleRect()); }
    public void settxtComments(String value) { this.txtComments.setText(value); this.txtComments.paintImmediately(this.txtComments.getVisibleRect()); }
    
    public void setcbbContactListFilter(String value) { this.cbbAddressListFilter.addItem(value); this.cbbAddressListFilter.paintImmediately(this.cbbAddressListFilter.getVisibleRect()); }
    public void setcbbAddressType(String value) { this.cbbAddressType.addItem(value); this.cbbAddressType.paintImmediately(this.cbbAddressType.getVisibleRect()); }
    public void setcbbAddressZone(String value) { this.cbbAddressZone.addItem(value); this.cbbAddressZone.paintImmediately(this.cbbAddressZone.getVisibleRect()); }
    public void setcbbAddressCountry(String value) { this.cbbAddressCountry.addItem(value); this.cbbAddressCountry.paintImmediately(this.cbbAddressCountry.getVisibleRect()); }
    public void setcbbHomeType(String value) { this.cbbHomeType.addItem(value); this.cbbHomeType.paintImmediately(this.cbbHomeType.getVisibleRect()); }
    
    public void setcbkMainAddress(String value) { if("Y".equals(value)) { this.cbkMainAddress.setSelected(true); } else { this.cbkMainAddress.setSelected(false); } this.cbkMainAddress.paintImmediately(this.cbkMainAddress.getVisibleRect()); }
    
    public void setlblRecCount(String value) { this.lblRecCount.setText("Total de Registros: " + value); this.lblRecCount.paintImmediately(this.lblRecCount.getVisibleRect()); }
    public void setlblAddressNameHeader(String value) { this.lblAddressNameHeader.setText(value); this.lblAddressNameHeader.paintImmediately(this.lblAddressNameHeader.getVisibleRect()); }
    
    // ComboBox Specific Setters
    public void setcbbAddressListFilterItemIndex(int value) { this.cbbAddressListFilter.setSelectedIndex(value); }
    public void setcbbAddressTypeItemIndex(int value) { this.cbbAddressType.setSelectedIndex(value); }
    public void setcbbAddressZoneItemIndex(int value) { this.cbbAddressZone.setSelectedIndex(value); }
    public void setcbbAddressCountryItemIndex(int value) { this.cbbAddressCountry.setSelectedIndex(value); }
    public void setcbbHomeTypeItemIndex(int value) { this.cbbHomeType.setSelectedIndex(value); }
    
    // Component Getters
    public String gettxtAddressListFilterValue() { if(!"".equals(this.txtAddressListFilterValue.getText()) && this.txtAddressListFilterValue.getText() != null) { return this.txtAddressListFilterValue.getText(); } else { return null; } }
    public String gettxtRowId() { if(!"".equals(this.txtRowId.getText()) && this.txtRowId.getText() != null) { return this.txtRowId.getText(); } else { return null; } }
    public String gettxtZipcodePart1() { if(!"".equals(this.txtZipcodePart1.getText()) && this.txtZipcodePart1.getText() != null) { return this.txtZipcodePart1.getText(); } else { return null; } }
    public String gettxtZipcodePart2() { if(!"".equals(this.txtZipcodePart2.getText()) && this.txtZipcodePart2.getText() != null) { return this.txtZipcodePart2.getText(); } else { return null; } }
    public String gettxtAddressName() { if(!"".equals(this.txtAddressName.getText()) && this.txtAddressName.getText() != null) { return this.txtAddressName.getText(); } else { return null; } }
    public String gettxtAddressNumber() { if(!"".equals(this.txtAddressNumber.getText()) && this.txtAddressNumber.getText() != null) { return this.txtAddressNumber.getText(); } else { return null; } }
    public String gettxtAddressComplement() { if(!"".equals(this.txtAddressComplement.getText()) && this.txtAddressComplement.getText() != null) { return this.txtAddressComplement.getText(); } else { return null; } }
    public String gettxtNeighborhood() { if(!"".equals(this.txtNeighborhood.getText()) && this.txtNeighborhood.getText() != null) { return this.txtNeighborhood.getText(); } else { return null; } }
    public String gettxtAddressCity() { if(!"".equals(this.txtAddressCity.getText()) && this.txtAddressCity.getText() != null) { return this.txtAddressCity.getText(); } else { return null; } }
    public String gettxtAddressState() { if(!"".equals(this.txtAddressState.getText()) && this.txtAddressState.getText() != null) { return this.txtAddressState.getText(); } else { return null; } }
    public String gettxtHomeFloor() { if(!"".equals(this.txtHomeFloor.getText()) && this.txtHomeFloor.getText() != null) { return this.txtHomeFloor.getText(); } else { return null; } }
    public String gettxtHomeNumber() { if(!"".equals(this.txtHomeNumber.getText()) && this.txtHomeNumber.getText() != null) { return this.txtHomeNumber.getText(); } else { return null; } }
    public String gettxtHomeBlock() { if(!"".equals(this.txtHomeBlock.getText()) && this.txtHomeBlock.getText() != null) { return this.txtHomeBlock.getText(); } else { return null; } }
    public String gettxtComments() { if(!"".equals(this.txtComments.getText()) && this.txtComments.getText() != null) { return this.txtComments.getText(); } else { return null; } }
    
    public String getcbbContactListFilter() { if(!"".equals(this.cbbAddressListFilter.getSelectedItem().toString()) && !"Selecione...".equals(this.cbbAddressListFilter.getSelectedItem().toString()) && this.cbbAddressListFilter.getSelectedItem().toString() != null) { return this.cbbAddressListFilter.getSelectedItem().toString(); } else { return null; } }
    public String getcbbAddressType() { if(!"".equals(this.cbbAddressType.getSelectedItem().toString()) && !"Selecione...".equals(this.cbbAddressType.getSelectedItem().toString()) && this.cbbAddressType.getSelectedItem().toString() != null) { return this.cbbAddressType.getSelectedItem().toString(); } else { return null; } }
    public String getcbbAddressZone() { if(!"".equals(this.cbbAddressZone.getSelectedItem().toString()) && !"Selecione...".equals(this.cbbAddressZone.getSelectedItem().toString()) && this.cbbAddressZone.getSelectedItem().toString() != null) { return this.cbbAddressZone.getSelectedItem().toString(); } else { return null; } }
    public String getcbbAddressCountry() { if(!"".equals(this.cbbAddressCountry.getSelectedItem().toString()) && !"Selecione...".equals(this.cbbAddressCountry.getSelectedItem().toString()) && this.cbbAddressCountry.getSelectedItem().toString() != null) { return this.cbbAddressCountry.getSelectedItem().toString(); } else { return null; } }
    public String getcbbHomeType() { if(!"".equals(this.cbbHomeType.getSelectedItem().toString()) && !"Selecione...".equals(this.cbbHomeType.getSelectedItem().toString()) && this.cbbHomeType.getSelectedItem().toString() != null) { return this.cbbHomeType.getSelectedItem().toString(); } else { return null; } }
    
    public String getcbkMainAddress() { if(this.cbkMainAddress.isSelected()) { return "Y"; } else { return "N"; } }
    
    public String getlblRecCount() { return this.lblRecCount.getText(); }
    public String getlblAddressNameHeader() { return this.lblAddressNameHeader.getText(); }

    // ComboBox Specific Getters
    public int getcbbUserListFilterItemIndex(String value) { if(!"".equals(value) && value != null) { for(int i = 0; i < this.cbbAddressListFilter.getItemCount(); i++){ if(value.equals(this.cbbAddressListFilter.getItemAt(i))){ return i; }}} else { return 0; } return 0; }
    public int getcbbAddressTypeItemIndex(String value) { if(!"".equals(value) && value != null) { for(int i = 0; i < this.cbbAddressType.getItemCount(); i++){ if(value.equals(this.cbbAddressType.getItemAt(i))){ return i; }}} else { return 0; } return 0; }
    public int getcbbAddressZoneItemIndex(String value) { if(!"".equals(value) && value != null) { for(int i = 0; i < this.cbbAddressZone.getItemCount(); i++){ if(value.equals(this.cbbAddressZone.getItemAt(i))){ return i; }}} else { return 0; } return 0; }
    public int getcbbAddressCountryItemIndex(String value) { if(!"".equals(value) && value != null) { for(int i = 0; i < this.cbbAddressCountry.getItemCount(); i++){ if(value.equals(this.cbbAddressCountry.getItemAt(i))){ return i; }}} else { return 0; } return 0; }
    public int getcbbHomeTypeItemIndex(String value) { if(!"".equals(value) && value != null) { for(int i = 0; i < this.cbbHomeType.getItemCount(); i++){ if(value.equals(this.cbbHomeType.getItemAt(i))){ return i; }}} else { return 0; } return 0; }
    
    
    // Component Clear
    public void cleartxtAddressListFilterValue() { this.txtAddressListFilterValue.setText(""); this.txtAddressListFilterValue.paintImmediately(this.txtAddressListFilterValue.getVisibleRect()); }
    public void cleartxtRowId() { this.txtRowId.setText(""); this.txtRowId.paintImmediately(this.txtRowId.getVisibleRect()); }
    public void cleartxtZipcodePart1() { this.txtZipcodePart1.setText(""); this.txtZipcodePart1.paintImmediately(this.txtZipcodePart1.getVisibleRect()); }
    public void cleartxtZipcodePart2() { this.txtZipcodePart2.setText(""); this.txtZipcodePart2.paintImmediately(this.txtZipcodePart2.getVisibleRect()); }
    public void cleartxtAddressName() { this.txtAddressName.setText(""); this.txtAddressName.paintImmediately(this.txtAddressName.getVisibleRect()); }
    public void cleartxtAddressNumber() { this.txtAddressNumber.setText(""); this.txtAddressNumber.paintImmediately(this.txtAddressNumber.getVisibleRect()); }
    public void cleartxtAddressComplement() { this.txtAddressComplement.setText(""); this.txtAddressComplement.paintImmediately(this.txtAddressComplement.getVisibleRect()); }
    public void cleartxtNeighborhood() { this.txtNeighborhood.setText(""); this.txtNeighborhood.paintImmediately(this.txtNeighborhood.getVisibleRect()); }
    public void cleartxtAddressCity() { this.txtAddressCity.setText(""); this.txtAddressCity.paintImmediately(this.txtAddressCity.getVisibleRect()); }
    public void cleartxtAddressState() { this.txtAddressState.setText(""); this.txtAddressState.paintImmediately(this.txtAddressState.getVisibleRect()); }
    public void cleartxtHomeFloor() { this.txtHomeFloor.setText(""); this.txtHomeFloor.paintImmediately(this.txtHomeFloor.getVisibleRect()); }
    public void cleartxtHomeNumber() { this.txtHomeNumber.setText(""); this.txtHomeNumber.paintImmediately(this.txtHomeNumber.getVisibleRect()); }
    public void cleartxtHomeBlock() { this.txtHomeBlock.setText(""); this.txtHomeBlock.paintImmediately(this.txtHomeBlock.getVisibleRect()); }
    public void cleartxtComments() { this.txtComments.setText(""); this.txtComments.paintImmediately(this.txtComments.getVisibleRect()); }
    
    public void clearcbbContactListFilter() { this.cbbAddressListFilter.removeAllItems(); this.cbbAddressListFilter.paintImmediately(this.cbbAddressListFilter.getVisibleRect()); }
    public void clearcbbAddressType() { this.cbbAddressType.removeAllItems(); this.cbbAddressType.paintImmediately(this.cbbAddressType.getVisibleRect()); }
    public void clearcbbAddressZone() { this.cbbAddressZone.removeAllItems(); this.cbbAddressZone.paintImmediately(this.cbbAddressZone.getVisibleRect()); }
    public void clearcbbAddressCountry() { this.cbbAddressCountry.removeAllItems(); this.cbbAddressCountry.paintImmediately(this.cbbAddressCountry.getVisibleRect()); }
    public void clearcbbHomeType() { this.cbbHomeType.removeAllItems(); this.cbbHomeType.paintImmediately(this.cbbHomeType.getVisibleRect()); }

    public void clearcbkMainAddress() { this.cbkMainAddress.setSelected(false); this.cbkMainAddress.paintImmediately(this.cbkMainAddress.getVisibleRect()); }
    
    public void clearlblRecCount() { this.lblRecCount.setText(""); this.lblRecCount.paintImmediately(this.lblRecCount.getVisibleRect()); }
    public void clearlblAddressNameHeader() { this.lblAddressNameHeader.setText(""); this.lblAddressNameHeader.paintImmediately(this.lblAddressNameHeader.getVisibleRect()); }

    // Enable or Disable Components
    public void settxtAddressListFilterValueEnabled(boolean status) { this.txtAddressListFilterValue.setEnabled(status); }
    public void settxtRowIdEnabled(boolean status) { this.txtRowId.setEnabled(status); }
    public void settxtZipcodePart1Enabled(boolean status) { this.txtZipcodePart1.setEnabled(status); }
    public void settxtZipcodePart2Enabled(boolean status) { this.txtZipcodePart2.setEnabled(status); }
    public void settxtAddressNameEnabled(boolean status) { this.txtAddressName.setEnabled(status); }
    public void settxtAddressNumberEnabled(boolean status) { this.txtAddressNumber.setEnabled(status); }
    public void settxtAddressComplementEnabled(boolean status) { this.txtAddressComplement.setEnabled(status); }
    public void settxtNeighborhoodEnabled(boolean status) { this.txtNeighborhood.setEnabled(status); }
    public void settxtAddressCityEnabled(boolean status) { this.txtAddressCity.setEnabled(status); }
    public void settxtAddressStateEnabled(boolean status) { this.txtAddressState.setEnabled(status); }
    public void settxtHomeFloorEnabled(boolean status) { this.txtHomeFloor.setEnabled(status); }
    public void settxtHomeNumberEnabled(boolean status) { this.txtHomeNumber.setEnabled(status); }
    public void settxtHomeBlockEnabled(boolean status) { this.txtHomeBlock.setEnabled(status); }
    public void settxtCommentslEnabled(boolean status) { this.txtComments.setEnabled(status); }
    
    public void setcbbContactListFilterEnabled(boolean status) { this.cbbAddressListFilter.setEnabled(status); }
    public void setcbbAddressTypeEnabled(boolean status) { this.cbbAddressType.setEnabled(status); }
    public void setcbbAddressZoneEnabled(boolean status) { this.cbbAddressZone.setEnabled(status); }
    public void setcbbAddressCountryEnabled(boolean status) { this.cbbAddressCountry.setEnabled(status); }
    public void setcbbHomeTypeEnabled(boolean status) { this.cbbHomeType.setEnabled(status); }

    public void setcbkMainAddressEnabled(boolean status) { this.cbkMainAddress.setEnabled(status); }
    
    public void setlblRecCountEnabled(boolean status) { this.lblRecCount.setEnabled(status); }
    public void setlblAddressNameHeaderEnabled(boolean status) { this.lblAddressNameHeader.setEnabled(status); }
    
    public void setTblEnabled(boolean status) { this.tblAddressList.setEnabled(status); }
    
    public void setbtnEditEnabled(boolean status) { this.btnEdit.setEnabled(status); }
    public void setbtnNewEnabled(boolean status) { this.btnNew.setEnabled(status); }
    public void setbtnSaveEnabled(boolean status) { this.btnSave.setEnabled(status); }
    public void setbtnCancelEnabled(boolean status) { this.btnCancel.setEnabled(status); }
    public void setbtnDeleteEnabled(boolean status) { this.btnDelete.setEnabled(status); }
    public void setbtnSearchAddressEnabled(boolean status) { this.btnSearchAddress.setEnabled(status); }

    // Return componet status
    public boolean istxtAddressListFilterValueEnabled() { return this.txtAddressListFilterValue.isEnabled(); }
    public boolean istxtRowIdEnabled() { return this.txtRowId.isEnabled(); }
    public boolean istxtZipcodePart1Enabled() { return this.txtZipcodePart1.isEnabled(); }
    public boolean istxtZipcodePart2Enabled() { return this.txtZipcodePart2.isEnabled(); }
    public boolean istxtAddressNameEnabled() { return this.txtAddressName.isEnabled(); }
    public boolean istxtAddressNumberEnabled() { return this.txtAddressNumber.isEnabled(); }
    public boolean istxtAddressComplementEnabled() { return this.txtAddressComplement.isEnabled(); }
    public boolean istxtNeighborhoodEnabled() { return this.txtNeighborhood.isEnabled(); }
    public boolean istxtAddressCityEnabled() { return this.txtAddressCity.isEnabled(); }
    public boolean istxtAddressStateEnabled() { return this.txtAddressState.isEnabled(); }
    public boolean istxtHomeFloorEnabled() { return this.txtHomeFloor.isEnabled(); }
    public boolean istxtHomeNumberEnabled() { return this.txtHomeNumber.isEnabled(); }
    public boolean istxtHomeBlockEnabled() { return this.txtHomeBlock.isEnabled(); }
    public boolean istxtCommentsEnabled() { return this.txtComments.isEnabled(); }
    
    public boolean iscbbContactListFilterEnabled() { return this.cbbAddressListFilter.isEnabled(); }
    public boolean iscbbAddressTypeEnabled() { return this.cbbAddressType.isEnabled(); }
    public boolean iscbbAddressZoneEnabled() { return this.cbbAddressZone.isEnabled(); }
    public boolean iscbbAddressCountryEnabled() { return this.cbbAddressCountry.isEnabled(); }
    public boolean iscbbHomeTypeEnabled() { return this.cbbHomeType.isEnabled(); }

    public boolean iscbkMainAddressEnabled() { return this.cbkMainAddress.isEnabled(); }
    
    public boolean islblRecCountEnabled() { return this.lblRecCount.isEnabled(); }
    public boolean islblAddressNameHeaderEnabled() { return this.lblAddressNameHeader.isEnabled(); }
    
    public boolean isbtnEditEnabled() { return this.btnEdit.isEnabled(); }
    public boolean isbtnNewEnabled() { return this.btnNew.isEnabled(); }
    public boolean isbtnSaveEnabled() { return this.btnSave.isEnabled(); }
    public boolean isbtnCancelEnabled() { return this.btnCancel.isEnabled(); }
    public boolean isbtnDeleteEnabled() { return this.btnDelete.isEnabled(); }
    public boolean isbtnSearchAddress() { return this.btnSearchAddress.isEnabled(); }
    
    // Button Functions
    public void clickSave(){ this.btnSave.setEnabled(true); this.btnSave.doClick(); this.btnSave.setEnabled(false); }
    public void clickNew(){ this.btnNew.setEnabled(true); this.btnNew.doClick(); this.btnNew.setEnabled(false); }
    public void clickEdit(){ this.btnEdit.setEnabled(true); this.btnEdit.doClick(); this.btnEdit.setEnabled(false); }
    public void clickCancel(){ this.btnCancel.setEnabled(true); this.btnCancel.doClick(); this.btnCancel.setEnabled(false); }
    public void clickDelete(){ this.btnDelete.setEnabled(true); this.btnDelete.doClick(); this.btnDelete.setEnabled(false); }
    public void clickSearchAddress(){ this.btnSearchAddress.setEnabled(true); this.btnSearchAddress.doClick(); this.btnSearchAddress.setEnabled(false); }
    
    // Set Focus on Specific component
    public void setFocus(String component) {
        switch (component) {
        case "FILTRO_VALOR":
            this.txtAddressListFilterValue.requestFocus();
            break;
        case "FILTRO":
            this.cbbAddressListFilter.requestFocus();
            break;
        case "ID":
            this.txtRowId.requestFocus();
            break;
        case "ENDERECO_PRINCIPAL":
            this.cbkMainAddress.requestFocus();
            break;
        case "CEP_PARTE_1":
            this.txtZipcodePart1.requestFocus();
            break;
        case "CEP_PARTE_2":
            this.txtZipcodePart2.requestFocus();
            break;
        case "TIPO_LOGRADOURO":
            this.cbbAddressType.requestFocus();
            break;
        case "LOGRADOURO":
            this.txtAddressName.requestFocus();
            break;
        case "NUMERO":
            this.txtAddressNumber.requestFocus();
            break;
	case "COMPLEMENTO":
            this.txtAddressComplement.requestFocus();
            break;
        case "BAIRRO":
            this.txtNeighborhood.requestFocus();
            break;
        case "ZONA":
            this.cbbAddressZone.requestFocus();
            break;
        case "CIDADE":
            this.txtAddressCity.requestFocus();			
            break;
        case "ESTADO":
            this.txtAddressState.requestFocus();
            break;
        case "PAIS":
            this.cbbAddressCountry.requestFocus();
            break;
        case "TIPO_IMOVEL":
            this.cbbHomeType.requestFocus();
            break;
        case "ANDAR":
            this.txtHomeFloor.requestFocus();
            break;
        case "NUMERO_CASA":
            this.txtHomeNumber.requestFocus();
            break;
        case "BLOCO":
            this.txtHomeBlock.requestFocus();
            break;
        case "COMENTARIOS":
            this.txtComments.requestFocus();
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
        
        default:
            break;
        }
    }
    
    public void enableFields(String funcao) {
        switch (funcao){
            case "LOAD_SCREEN":
                settxtAddressListFilterValueEnabled(true);
                settxtRowIdEnabled(false);
                settxtZipcodePart1Enabled(false);
                settxtZipcodePart2Enabled(false);
                settxtAddressNameEnabled(false);
                settxtAddressNumberEnabled(false);
                settxtAddressComplementEnabled(false);
                settxtNeighborhoodEnabled(false);
                settxtAddressCityEnabled(false);
                settxtAddressStateEnabled(false);
                settxtHomeFloorEnabled(false);
                settxtHomeNumberEnabled(false);
                settxtHomeBlockEnabled(false);
                settxtCommentslEnabled(false);          

                setcbbContactListFilterEnabled(true);
                setcbbAddressTypeEnabled(false);
                setcbbAddressZoneEnabled(false);
                setcbbAddressCountryEnabled(false);
                setcbbHomeTypeEnabled(false);

                setcbkMainAddressEnabled(false);

                setTblEnabled(true);
                
                setbtnEditEnabled(false);
                setbtnDeleteEnabled(false);
                setbtnNewEnabled(true);                
                setbtnSaveEnabled(false);
                setbtnCancelEnabled(false);
                setbtnSearchAddressEnabled(false);
                break;
            case "NOVO":
                settxtAddressListFilterValueEnabled(true);
                settxtRowIdEnabled(false);
                settxtZipcodePart1Enabled(false);
                settxtZipcodePart2Enabled(false);
                settxtAddressNameEnabled(false);
                settxtAddressNumberEnabled(false);
                settxtAddressComplementEnabled(false);
                settxtNeighborhoodEnabled(false);
                settxtAddressCityEnabled(false);
                settxtAddressStateEnabled(false);
                settxtHomeFloorEnabled(false);
                settxtHomeNumberEnabled(false);
                settxtHomeBlockEnabled(true);
                settxtCommentslEnabled(true);

                setcbbContactListFilterEnabled(true);
                setcbbAddressTypeEnabled(false);
                setcbbAddressZoneEnabled(false);
                setcbbAddressCountryEnabled(false);
                setcbbHomeTypeEnabled(false);

                setcbkMainAddressEnabled(true);

                setTblEnabled(false);
                
                setbtnEditEnabled(false);
                setbtnDeleteEnabled(false);
                setbtnNewEnabled(false);
                setbtnSaveEnabled(true);
                setbtnCancelEnabled(true);
                setbtnSearchAddressEnabled(true);
                break;
            case "EDITAR":
                settxtAddressListFilterValueEnabled(true);
                settxtRowIdEnabled(false);
                settxtZipcodePart1Enabled(false);
                settxtZipcodePart2Enabled(false);
                settxtAddressNameEnabled(false);
                settxtAddressNumberEnabled(false);
                settxtAddressComplementEnabled(false);
                settxtNeighborhoodEnabled(false);
                settxtAddressCityEnabled(false);
                settxtAddressStateEnabled(false);
                settxtHomeFloorEnabled(false);
                settxtHomeNumberEnabled(false);
                settxtHomeBlockEnabled(true);
                settxtCommentslEnabled(true);

                setcbbContactListFilterEnabled(true);
                setcbbAddressTypeEnabled(false);
                setcbbAddressZoneEnabled(false);
                setcbbAddressCountryEnabled(false);
                setcbbHomeTypeEnabled(false);

                setcbkMainAddressEnabled(true);

                setTblEnabled(false);
                
                setbtnEditEnabled(false);
                setbtnDeleteEnabled(false);
                setbtnNewEnabled(false);
                setbtnSaveEnabled(true);
                setbtnCancelEnabled(true);
                setbtnSearchAddressEnabled(true);
                break;
            case "CANCELAR":
                settxtAddressListFilterValueEnabled(true);
                settxtRowIdEnabled(false);
                settxtZipcodePart1Enabled(false);
                settxtZipcodePart2Enabled(false);
                settxtAddressNameEnabled(false);
                settxtAddressNumberEnabled(false);
                settxtAddressComplementEnabled(false);
                settxtNeighborhoodEnabled(false);
                settxtAddressCityEnabled(false);
                settxtAddressStateEnabled(false);
                settxtHomeFloorEnabled(false);
                settxtHomeNumberEnabled(false);
                settxtHomeBlockEnabled(false);
                settxtCommentslEnabled(false);

                setcbbContactListFilterEnabled(true);
                setcbbAddressTypeEnabled(false);
                setcbbAddressZoneEnabled(false);
                setcbbAddressCountryEnabled(false);
                setcbbHomeTypeEnabled(false);
                
                setcbkMainAddressEnabled(false);

                setTblEnabled(true);
                
                setbtnEditEnabled(true);
                setbtnDeleteEnabled(true);
                setbtnNewEnabled(true);
                setbtnSaveEnabled(false);
                setbtnCancelEnabled(false);
                setbtnSearchAddressEnabled(false);
                break;
            case "DELETAR":
                settxtAddressListFilterValueEnabled(true);
                settxtRowIdEnabled(false);
                settxtZipcodePart1Enabled(false);
                settxtZipcodePart2Enabled(false);
                settxtAddressNameEnabled(false);
                settxtAddressNumberEnabled(false);
                settxtAddressComplementEnabled(false);
                settxtNeighborhoodEnabled(false);
                settxtAddressCityEnabled(false);
                settxtAddressStateEnabled(false);
                settxtHomeFloorEnabled(false);
                settxtHomeNumberEnabled(false);
                settxtHomeBlockEnabled(false);
                settxtCommentslEnabled(false);

                setcbbContactListFilterEnabled(true);
                setcbbAddressTypeEnabled(false);
                setcbbAddressZoneEnabled(false);
                setcbbAddressCountryEnabled(false);
                setcbbHomeTypeEnabled(false);

                setcbkMainAddressEnabled(false);

                setTblEnabled(true);
                
                setbtnEditEnabled(true);
                setbtnDeleteEnabled(true);
                setbtnNewEnabled(true);
                setbtnSaveEnabled(false);
                setbtnCancelEnabled(false);
                setbtnSearchAddressEnabled(false);
                break;
            case "SALVAR":
                settxtAddressListFilterValueEnabled(true);
                settxtRowIdEnabled(false);
                settxtZipcodePart1Enabled(false);
                settxtZipcodePart2Enabled(false);
                settxtAddressNameEnabled(false);
                settxtAddressNumberEnabled(false);
                settxtAddressComplementEnabled(false);
                settxtNeighborhoodEnabled(false);
                settxtAddressCityEnabled(false);
                settxtAddressStateEnabled(false);
                settxtHomeFloorEnabled(false);
                settxtHomeNumberEnabled(false);
                settxtHomeBlockEnabled(false);
                settxtCommentslEnabled(false);

                setcbbContactListFilterEnabled(true);
                setcbbAddressTypeEnabled(false);
                setcbbAddressZoneEnabled(false);
                setcbbAddressCountryEnabled(false);
                setcbbHomeTypeEnabled(false);

                setcbkMainAddressEnabled(false);

                setTblEnabled(true);
                
                setbtnEditEnabled(true);
                setbtnDeleteEnabled(true);
                setbtnNewEnabled(true);
                setbtnSaveEnabled(false);
                setbtnCancelEnabled(false);
                setbtnSearchAddressEnabled(false);
                break;
            default:
                break;
        }
    }

    public void clearFields() {
        cleartxtAddressListFilterValue();
        cleartxtRowId();
        cleartxtZipcodePart1();
        cleartxtZipcodePart2();
        cleartxtAddressName();
        cleartxtAddressNumber();
        cleartxtAddressComplement();
        cleartxtNeighborhood();
        cleartxtAddressCity();
        cleartxtAddressState();
        cleartxtHomeFloor();
        cleartxtHomeNumber();
        cleartxtHomeBlock();
        cleartxtComments();
        
        clearcbkMainAddress();
        
        setcbbAddressTypeItemIndex(0);
        setcbbHomeTypeItemIndex(0);
        setcbbAddressListFilterItemIndex(0);
        setcbbAddressZoneItemIndex(0);
        setcbbAddressCountryItemIndex(0);
                
        clearlblAddressNameHeader();
    }
    
    public void clearComboBoxes(){
        clearcbbContactListFilter();
        clearcbbAddressType();
        clearcbbAddressZone();
        clearcbbAddressCountry();
        clearcbbHomeType();
    }
    
    public void insertSelectComboBox(){
        this.setcbbContactListFilter("Selecione...");
        this.setcbbAddressType("Selecione...");
        this.setcbbAddressZone("Selecione...");
        this.setcbbAddressCountry("Selecione...");
        this.setcbbHomeType("Selecione...");
    }
    
    public final void FocusTraversalKeys(){
        this.txtAddressListFilterValue.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtRowId.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtZipcodePart1.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtZipcodePart2.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtAddressName.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtAddressNumber.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtAddressComplement.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtNeighborhood.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtAddressCity.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtAddressState.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtHomeFloor.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtHomeNumber.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtHomeBlock.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtComments.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        
        this.cbbAddressListFilter.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.cbbAddressType.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.cbbAddressZone.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.cbbAddressCountry.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.cbbHomeType.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);

        this.cbkMainAddress.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
    
        this.lblRecCount.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.lblAddressNameHeader.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
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
        PanelContactList = new javax.swing.JPanel();
        PanelContactListHeader = new javax.swing.JPanel();
        lblContactList = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblImage = new javax.swing.JLabel();
        cbbAddressListFilter = new javax.swing.JComboBox<>();
        txtAddressListFilterValue = new javax.swing.JTextField();
        lblInformation = new javax.swing.JLabel();
        lblRecCount = new javax.swing.JLabel();
        PanelListContact = new javax.swing.JPanel();
        sPanelUserList = new javax.swing.JScrollPane();
        tblAddressList = new javax.swing.JTable();
        PanelContactForm = new javax.swing.JPanel();
        PanelContactFormHeader = new javax.swing.JPanel();
        lblAddressNameHeader = new javax.swing.JLabel();
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
        cbkMainAddress = new javax.swing.JCheckBox();
        lblWhatsAppFlg = new javax.swing.JLabel();
        lblContactEmail = new javax.swing.JLabel();
        txtAddressNumber = new javax.swing.JTextField();
        cbbAddressType = new javax.swing.JComboBox<>();
        lblSendNewsFlg = new javax.swing.JLabel();
        lblAllowEmailFlg = new javax.swing.JLabel();
        lblSendPromFlg = new javax.swing.JLabel();
        lblAllowCallFlg = new javax.swing.JLabel();
        lblContactPhone = new javax.swing.JLabel();
        txtAddressName = new javax.swing.JTextField();
        lblContactMPhone = new javax.swing.JLabel();
        txtZipcodePart1 = new javax.swing.JTextField();
        lblContactEnterprise = new javax.swing.JLabel();
        txtAddressCity = new javax.swing.JTextField();
        lblSocialMedia = new javax.swing.JLabel();
        lblAddSocialMedia = new javax.swing.JLabel();
        lblFacebook = new javax.swing.JLabel();
        txtHomeNumber = new javax.swing.JTextField();
        lblInstagram = new javax.swing.JLabel();
        txtHomeBlock = new javax.swing.JTextField();
        lblTwitter = new javax.swing.JLabel();
        txtComments = new javax.swing.JTextField();
        lblContactEmail2 = new javax.swing.JLabel();
        txtZipcodePart2 = new javax.swing.JTextField();
        btnSearchAddress = new javax.swing.JButton();
        txtAddressState = new javax.swing.JTextField();
        cbbAddressCountry = new javax.swing.JComboBox<>();
        txtAddressComplement = new javax.swing.JTextField();
        cbbHomeType = new javax.swing.JComboBox<>();
        txtHomeFloor = new javax.swing.JTextField();
        lblWhatsAppFlg1 = new javax.swing.JLabel();
        txtNeighborhood = new javax.swing.JTextField();
        lblWhatsAppFlg2 = new javax.swing.JLabel();
        cbbAddressZone = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Contatos");
        setBackground(new java.awt.Color(255, 255, 255));
        setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        setResizable(false);

        PanelUser.setBackground(new java.awt.Color(255, 255, 255));
        PanelUser.setPreferredSize(new java.awt.Dimension(1366, 757));

        lblContactList.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        lblContactList.setText("Lista de Endereços");
        lblContactList.setToolTipText("");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        lblImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/Lupa white 20x20.png"))); // NOI18N

        cbbAddressListFilter.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        cbbAddressListFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbAddressListFilter.setMaximumSize(new java.awt.Dimension(250, 32767));
        cbbAddressListFilter.setPreferredSize(new java.awt.Dimension(250, 23));
        cbbAddressListFilter.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbAddressListFilterItemStateChanged(evt);
            }
        });

        txtAddressListFilterValue.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtAddressListFilterValue.setToolTipText("");
        txtAddressListFilterValue.setMaximumSize(new java.awt.Dimension(250, 2147483647));
        txtAddressListFilterValue.setPreferredSize(new java.awt.Dimension(250, 23));

        lblInformation.setBackground(new java.awt.Color(255, 255, 255));
        lblInformation.setText("Pressione Enter para pesquisar");
        lblInformation.setEnabled(false);

        lblRecCount.setBackground(new java.awt.Color(255, 255, 255));
        lblRecCount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblRecCount.setText("Total de Registros: 100");
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
                .addComponent(cbbAddressListFilter, 0, 270, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAddressListFilterValue, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInformation)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRecCount, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                .addContainerGap())
        );
        PanelContactListHeaderLayout.setVerticalGroup(
            PanelContactListHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelContactListHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelContactListHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbbAddressListFilter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblContactList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addComponent(lblImage, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblRecCount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblInformation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtAddressListFilterValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        lblRecCount.getAccessibleContext().setAccessibleDescription("");

        sPanelUserList.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        sPanelUserList.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        sPanelUserList.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N

        tblAddressList.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        tblAddressList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Tipo de Logradouro", "Logradouro", "Número", "Complemento", "Bairro", "Zona", "Cidade", "Estado", "País", "Tipo de Imóvel", "Andar", "Número do APTO/Casa", "Bloco", "Comentários"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblAddressList.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblAddressList.setGridColor(new java.awt.Color(204, 204, 204));
        tblAddressList.setRowHeight(22);
        sPanelUserList.setViewportView(tblAddressList);

        javax.swing.GroupLayout PanelListContactLayout = new javax.swing.GroupLayout(PanelListContact);
        PanelListContact.setLayout(PanelListContactLayout);
        PanelListContactLayout.setHorizontalGroup(
            PanelListContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sPanelUserList)
        );
        PanelListContactLayout.setVerticalGroup(
            PanelListContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sPanelUserList, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
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

        lblAddressNameHeader.setBackground(new java.awt.Color(255, 255, 255));
        lblAddressNameHeader.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        lblAddressNameHeader.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblAddressNameHeader.setMinimumSize(new java.awt.Dimension(0, 30));

        lblContactFormInformation.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblContactFormInformation.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblContactFormInformation.setText("Campos Obrigatórios (*)");
        lblContactFormInformation.setEnabled(false);

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btnEdit.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnEdit.setText("Editar");
        btnEdit.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10));
        btnEdit.setBorderPainted(false);
        btnEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEdit.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnEdit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnEditKeyPressed(evt);
            }
        });

        btnNew.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnNew.setText("Novo");
        btnNew.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10));
        btnNew.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnNew.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnNewKeyPressed(evt);
            }
        });

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btnSave.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnSave.setText("Salvar");
        btnSave.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10));
        btnSave.setEnabled(false);
        btnSave.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnSave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnSaveKeyPressed(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnCancel.setText("Cancelar");
        btnCancel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10));
        btnCancel.setEnabled(false);
        btnCancel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnCancel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnCancelKeyPressed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnDelete.setText("Excluir");
        btnDelete.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10));
        btnDelete.setBorderPainted(false);
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDelete.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
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
                .addComponent(lblAddressNameHeader, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
                .addGap(49, 49, 49)
                .addComponent(lblContactFormInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        PanelContactFormHeaderLayout.setVerticalGroup(
            PanelContactFormHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelContactFormHeaderLayout.createSequentialGroup()
                .addGroup(PanelContactFormHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblContactFormInformation, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblAddressNameHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        sPanelContactForm.setBorder(null);
        sPanelContactForm.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        sPanelContactForm.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        sPanelContactForm.setMinimumSize(new java.awt.Dimension(0, 0));
        sPanelContactForm.setPreferredSize(new java.awt.Dimension(1366, 427));

        PanelFormContact.setBackground(new java.awt.Color(255, 255, 255));
        PanelFormContact.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        PanelFormContact.setPreferredSize(new java.awt.Dimension(1340, 425));

        lblContactInformation.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.light"));
        lblContactInformation.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblContactInformation.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblContactInformation.setText("   Informações do Endereço");
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
        lblMainContFlg.setText("Endereço Principal:");
        lblMainContFlg.setToolTipText("");
        lblMainContFlg.setEnabled(false);
        lblMainContFlg.setMaximumSize(new java.awt.Dimension(150, 22));
        lblMainContFlg.setMinimumSize(new java.awt.Dimension(150, 22));
        lblMainContFlg.setPreferredSize(new java.awt.Dimension(150, 22));

        cbkMainAddress.setBackground(new java.awt.Color(255, 255, 255));
        cbkMainAddress.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        cbkMainAddress.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cbkMainAddress.setBorderPainted(true);
        cbkMainAddress.setEnabled(false);
        cbkMainAddress.setMaximumSize(new java.awt.Dimension(165, 21));
        cbkMainAddress.setPreferredSize(new java.awt.Dimension(165, 21));
        cbkMainAddress.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbkMainAddressItemStateChanged(evt);
            }
        });
        cbkMainAddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbkMainAddressKeyPressed(evt);
            }
        });

        lblWhatsAppFlg.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblWhatsAppFlg.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblWhatsAppFlg.setText("Cidade*:");
        lblWhatsAppFlg.setEnabled(false);
        lblWhatsAppFlg.setMaximumSize(new java.awt.Dimension(150, 22));
        lblWhatsAppFlg.setMinimumSize(new java.awt.Dimension(150, 22));
        lblWhatsAppFlg.setPreferredSize(new java.awt.Dimension(150, 22));

        lblContactEmail.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblContactEmail.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblContactEmail.setText("Número*:");
        lblContactEmail.setToolTipText("");
        lblContactEmail.setEnabled(false);
        lblContactEmail.setMaximumSize(new java.awt.Dimension(150, 22));
        lblContactEmail.setMinimumSize(new java.awt.Dimension(150, 22));
        lblContactEmail.setPreferredSize(new java.awt.Dimension(150, 22));

        txtAddressNumber.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtAddressNumber.setText("matheuscabralrosa");
        txtAddressNumber.setToolTipText("");
        txtAddressNumber.setEnabled(false);
        txtAddressNumber.setMaximumSize(new java.awt.Dimension(304, 22));
        txtAddressNumber.setPreferredSize(new java.awt.Dimension(304, 22));
        txtAddressNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAddressNumberKeyPressed(evt);
            }
        });

        cbbAddressType.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        cbbAddressType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbAddressType.setEnabled(false);
        cbbAddressType.setMaximumSize(new java.awt.Dimension(165, 22));
        cbbAddressType.setMinimumSize(new java.awt.Dimension(165, 22));
        cbbAddressType.setPreferredSize(new java.awt.Dimension(165, 22));
        cbbAddressType.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbAddressTypeItemStateChanged(evt);
            }
        });
        cbbAddressType.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbbAddressTypeKeyPressed(evt);
            }
        });

        lblSendNewsFlg.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblSendNewsFlg.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSendNewsFlg.setText("Tipo de Imóvel*:");
        lblSendNewsFlg.setEnabled(false);
        lblSendNewsFlg.setMaximumSize(new java.awt.Dimension(150, 22));
        lblSendNewsFlg.setMinimumSize(new java.awt.Dimension(150, 22));
        lblSendNewsFlg.setPreferredSize(new java.awt.Dimension(150, 22));

        lblAllowEmailFlg.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblAllowEmailFlg.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAllowEmailFlg.setText("Complemento:");
        lblAllowEmailFlg.setEnabled(false);
        lblAllowEmailFlg.setMaximumSize(new java.awt.Dimension(150, 22));
        lblAllowEmailFlg.setMinimumSize(new java.awt.Dimension(150, 22));
        lblAllowEmailFlg.setPreferredSize(new java.awt.Dimension(150, 22));

        lblSendPromFlg.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblSendPromFlg.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSendPromFlg.setText("País*:");
        lblSendPromFlg.setEnabled(false);
        lblSendPromFlg.setMaximumSize(new java.awt.Dimension(150, 22));
        lblSendPromFlg.setMinimumSize(new java.awt.Dimension(150, 22));
        lblSendPromFlg.setPreferredSize(new java.awt.Dimension(150, 22));

        lblAllowCallFlg.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblAllowCallFlg.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAllowCallFlg.setText("Estado*:");
        lblAllowCallFlg.setEnabled(false);
        lblAllowCallFlg.setMaximumSize(new java.awt.Dimension(150, 22));
        lblAllowCallFlg.setMinimumSize(new java.awt.Dimension(150, 22));
        lblAllowCallFlg.setPreferredSize(new java.awt.Dimension(150, 22));

        lblContactPhone.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblContactPhone.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblContactPhone.setText("Tipo de Logradouro:");
        lblContactPhone.setEnabled(false);
        lblContactPhone.setMaximumSize(new java.awt.Dimension(150, 16));
        lblContactPhone.setPreferredSize(new java.awt.Dimension(150, 22));

        txtAddressName.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtAddressName.setText("jTextField1");
        txtAddressName.setEnabled(false);
        txtAddressName.setMaximumSize(new java.awt.Dimension(165, 22));
        txtAddressName.setMinimumSize(new java.awt.Dimension(165, 22));
        txtAddressName.setPreferredSize(new java.awt.Dimension(165, 22));
        txtAddressName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAddressNameKeyPressed(evt);
            }
        });

        lblContactMPhone.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblContactMPhone.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblContactMPhone.setText("CEP*:");
        lblContactMPhone.setEnabled(false);
        lblContactMPhone.setMaximumSize(new java.awt.Dimension(150, 16));
        lblContactMPhone.setPreferredSize(new java.awt.Dimension(150, 16));

        txtZipcodePart1.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtZipcodePart1.setText("23036");
        txtZipcodePart1.setEnabled(false);
        txtZipcodePart1.setMaximumSize(new java.awt.Dimension(165, 22));
        txtZipcodePart1.setMinimumSize(new java.awt.Dimension(165, 22));
        txtZipcodePart1.setPreferredSize(new java.awt.Dimension(165, 22));
        txtZipcodePart1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtZipcodePart1KeyPressed(evt);
            }
        });

        lblContactEnterprise.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblContactEnterprise.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblContactEnterprise.setText("Logradouro*:");
        lblContactEnterprise.setEnabled(false);
        lblContactEnterprise.setMaximumSize(new java.awt.Dimension(150, 16));
        lblContactEnterprise.setPreferredSize(new java.awt.Dimension(150, 16));

        txtAddressCity.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtAddressCity.setText("jTextField1");
        txtAddressCity.setEnabled(false);
        txtAddressCity.setMaximumSize(new java.awt.Dimension(165, 22));
        txtAddressCity.setMinimumSize(new java.awt.Dimension(165, 22));
        txtAddressCity.setPreferredSize(new java.awt.Dimension(165, 22));
        txtAddressCity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAddressCityKeyPressed(evt);
            }
        });

        lblSocialMedia.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.light"));
        lblSocialMedia.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblSocialMedia.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblSocialMedia.setText("   Informações do Imóvel:");
        lblSocialMedia.setToolTipText("");
        lblSocialMedia.setEnabled(false);
        lblSocialMedia.setOpaque(true);

        lblAddSocialMedia.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblAddSocialMedia.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAddSocialMedia.setText("Andar:");
        lblAddSocialMedia.setEnabled(false);
        lblAddSocialMedia.setPreferredSize(new java.awt.Dimension(150, 16));

        lblFacebook.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblFacebook.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFacebook.setText("Número APTO/Casa:");
        lblFacebook.setEnabled(false);
        lblFacebook.setMaximumSize(new java.awt.Dimension(150, 22));
        lblFacebook.setMinimumSize(new java.awt.Dimension(150, 22));
        lblFacebook.setPreferredSize(new java.awt.Dimension(150, 22));

        txtHomeNumber.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtHomeNumber.setText("jTextField1");
        txtHomeNumber.setEnabled(false);
        txtHomeNumber.setMaximumSize(new java.awt.Dimension(165, 22));
        txtHomeNumber.setMinimumSize(new java.awt.Dimension(165, 22));
        txtHomeNumber.setPreferredSize(new java.awt.Dimension(165, 22));
        txtHomeNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtHomeNumberKeyPressed(evt);
            }
        });

        lblInstagram.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblInstagram.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblInstagram.setText("Bloco:");
        lblInstagram.setEnabled(false);
        lblInstagram.setMaximumSize(new java.awt.Dimension(150, 22));
        lblInstagram.setMinimumSize(new java.awt.Dimension(150, 22));
        lblInstagram.setPreferredSize(new java.awt.Dimension(150, 22));

        txtHomeBlock.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtHomeBlock.setText("jTextField1");
        txtHomeBlock.setEnabled(false);
        txtHomeBlock.setMaximumSize(new java.awt.Dimension(165, 22));
        txtHomeBlock.setMinimumSize(new java.awt.Dimension(165, 22));
        txtHomeBlock.setPreferredSize(new java.awt.Dimension(165, 22));
        txtHomeBlock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtHomeBlockKeyPressed(evt);
            }
        });

        lblTwitter.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblTwitter.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTwitter.setText("Comentários:");
        lblTwitter.setEnabled(false);
        lblTwitter.setMaximumSize(new java.awt.Dimension(150, 22));
        lblTwitter.setMinimumSize(new java.awt.Dimension(150, 22));
        lblTwitter.setPreferredSize(new java.awt.Dimension(150, 22));

        txtComments.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtComments.setText("jTextField1");
        txtComments.setEnabled(false);
        txtComments.setMaximumSize(new java.awt.Dimension(165, 22));
        txtComments.setMinimumSize(new java.awt.Dimension(165, 22));
        txtComments.setPreferredSize(new java.awt.Dimension(165, 22));
        txtComments.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCommentsKeyPressed(evt);
            }
        });

        lblContactEmail2.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblContactEmail2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblContactEmail2.setText("-");
        lblContactEmail2.setEnabled(false);
        lblContactEmail2.setMaximumSize(new java.awt.Dimension(22, 16));

        txtZipcodePart2.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtZipcodePart2.setText("030");
        txtZipcodePart2.setEnabled(false);
        txtZipcodePart2.setMaximumSize(new java.awt.Dimension(165, 22));
        txtZipcodePart2.setMinimumSize(new java.awt.Dimension(165, 22));
        txtZipcodePart2.setPreferredSize(new java.awt.Dimension(165, 22));
        txtZipcodePart2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtZipcodePart2KeyPressed(evt);
            }
        });

        btnSearchAddress.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        btnSearchAddress.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/Lupa 10x10.png"))); // NOI18N
        btnSearchAddress.setEnabled(false);

        txtAddressState.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtAddressState.setText("jTextField1");
        txtAddressState.setEnabled(false);
        txtAddressState.setMaximumSize(new java.awt.Dimension(165, 22));
        txtAddressState.setMinimumSize(new java.awt.Dimension(165, 22));
        txtAddressState.setPreferredSize(new java.awt.Dimension(165, 22));
        txtAddressState.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAddressStateKeyPressed(evt);
            }
        });

        cbbAddressCountry.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        cbbAddressCountry.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbAddressCountry.setEnabled(false);
        cbbAddressCountry.setMaximumSize(new java.awt.Dimension(165, 22));
        cbbAddressCountry.setMinimumSize(new java.awt.Dimension(165, 22));
        cbbAddressCountry.setPreferredSize(new java.awt.Dimension(165, 22));
        cbbAddressCountry.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbAddressCountryItemStateChanged(evt);
            }
        });
        cbbAddressCountry.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbbAddressCountryKeyPressed(evt);
            }
        });

        txtAddressComplement.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtAddressComplement.setText("matheuscabralrosa");
        txtAddressComplement.setToolTipText("");
        txtAddressComplement.setEnabled(false);
        txtAddressComplement.setMaximumSize(new java.awt.Dimension(304, 22));
        txtAddressComplement.setPreferredSize(new java.awt.Dimension(304, 22));
        txtAddressComplement.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAddressComplementKeyPressed(evt);
            }
        });

        cbbHomeType.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        cbbHomeType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbHomeType.setEnabled(false);
        cbbHomeType.setMaximumSize(new java.awt.Dimension(165, 22));
        cbbHomeType.setMinimumSize(new java.awt.Dimension(165, 22));
        cbbHomeType.setPreferredSize(new java.awt.Dimension(165, 22));
        cbbHomeType.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbHomeTypeItemStateChanged(evt);
            }
        });
        cbbHomeType.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbbHomeTypeKeyPressed(evt);
            }
        });

        txtHomeFloor.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtHomeFloor.setText("jTextField1");
        txtHomeFloor.setEnabled(false);
        txtHomeFloor.setMaximumSize(new java.awt.Dimension(165, 22));
        txtHomeFloor.setMinimumSize(new java.awt.Dimension(165, 22));
        txtHomeFloor.setPreferredSize(new java.awt.Dimension(165, 22));
        txtHomeFloor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtHomeFloorKeyPressed(evt);
            }
        });

        lblWhatsAppFlg1.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblWhatsAppFlg1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblWhatsAppFlg1.setText("Bairro*:");
        lblWhatsAppFlg1.setEnabled(false);
        lblWhatsAppFlg1.setMaximumSize(new java.awt.Dimension(150, 22));
        lblWhatsAppFlg1.setMinimumSize(new java.awt.Dimension(150, 22));
        lblWhatsAppFlg1.setPreferredSize(new java.awt.Dimension(150, 22));

        txtNeighborhood.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtNeighborhood.setText("jTextField1");
        txtNeighborhood.setEnabled(false);
        txtNeighborhood.setMaximumSize(new java.awt.Dimension(165, 22));
        txtNeighborhood.setMinimumSize(new java.awt.Dimension(165, 22));
        txtNeighborhood.setPreferredSize(new java.awt.Dimension(165, 22));
        txtNeighborhood.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNeighborhoodKeyPressed(evt);
            }
        });

        lblWhatsAppFlg2.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblWhatsAppFlg2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblWhatsAppFlg2.setText("Zona*:");
        lblWhatsAppFlg2.setEnabled(false);
        lblWhatsAppFlg2.setMaximumSize(new java.awt.Dimension(150, 22));
        lblWhatsAppFlg2.setMinimumSize(new java.awt.Dimension(150, 22));
        lblWhatsAppFlg2.setPreferredSize(new java.awt.Dimension(150, 22));

        cbbAddressZone.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        cbbAddressZone.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbAddressZone.setEnabled(false);
        cbbAddressZone.setMaximumSize(new java.awt.Dimension(165, 22));
        cbbAddressZone.setMinimumSize(new java.awt.Dimension(165, 22));
        cbbAddressZone.setPreferredSize(new java.awt.Dimension(165, 22));
        cbbAddressZone.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbAddressZoneItemStateChanged(evt);
            }
        });
        cbbAddressZone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbbAddressZoneKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout PanelFormContactLayout = new javax.swing.GroupLayout(PanelFormContact);
        PanelFormContact.setLayout(PanelFormContactLayout);
        PanelFormContactLayout.setHorizontalGroup(
            PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFormContactLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblContactInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 642, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(PanelFormContactLayout.createSequentialGroup()
                            .addComponent(lblRowId, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtRowId, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblMainContFlg, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cbkMainAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(PanelFormContactLayout.createSequentialGroup()
                            .addComponent(lblContactMPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtZipcodePart1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblContactEmail2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtZipcodePart2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnSearchAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblWhatsAppFlg1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtNeighborhood, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PanelFormContactLayout.createSequentialGroup()
                        .addGroup(PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelFormContactLayout.createSequentialGroup()
                                .addComponent(lblContactPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbbAddressType, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelFormContactLayout.createSequentialGroup()
                                .addComponent(lblContactEnterprise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAddressName, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelFormContactLayout.createSequentialGroup()
                                .addComponent(lblAllowEmailFlg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAddressComplement, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelFormContactLayout.createSequentialGroup()
                                .addComponent(lblContactEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAddressNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(PanelFormContactLayout.createSequentialGroup()
                                .addComponent(lblWhatsAppFlg, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAddressCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelFormContactLayout.createSequentialGroup()
                                .addComponent(lblAllowCallFlg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAddressState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelFormContactLayout.createSequentialGroup()
                                .addComponent(lblSendPromFlg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbbAddressCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelFormContactLayout.createSequentialGroup()
                                .addComponent(lblWhatsAppFlg2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbbAddressZone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(PanelFormContactLayout.createSequentialGroup()
                                .addComponent(lblTwitter, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtComments, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelFormContactLayout.createSequentialGroup()
                                .addComponent(lblInstagram, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtHomeBlock, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(PanelFormContactLayout.createSequentialGroup()
                            .addGroup(PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelFormContactLayout.createSequentialGroup()
                                        .addComponent(lblFacebook, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtHomeNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(PanelFormContactLayout.createSequentialGroup()
                                        .addComponent(lblAddSocialMedia, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtHomeFloor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(lblSocialMedia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(0, 0, 0)))
                    .addGroup(PanelFormContactLayout.createSequentialGroup()
                        .addComponent(lblSendNewsFlg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbHomeType, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(359, Short.MAX_VALUE))
        );
        PanelFormContactLayout.setVerticalGroup(
            PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelFormContactLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSocialMedia, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblContactInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelFormContactLayout.createSequentialGroup()
                        .addGroup(PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblRowId, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtRowId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblMainContFlg, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbkMainAddress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelFormContactLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblContactMPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtZipcodePart1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtZipcodePart2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblContactEmail2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnSearchAddress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblContactPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbAddressType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtAddressName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblContactEnterprise, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelFormContactLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblContactEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtAddressNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAllowEmailFlg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAddressComplement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PanelFormContactLayout.createSequentialGroup()
                        .addGroup(PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSendNewsFlg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbHomeType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAddSocialMedia, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHomeFloor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblWhatsAppFlg1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNeighborhood, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFacebook, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHomeNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblWhatsAppFlg2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbAddressZone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelFormContactLayout.createSequentialGroup()
                                .addGroup(PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtHomeBlock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblInstagram, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtComments, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblTwitter, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(PanelFormContactLayout.createSequentialGroup()
                                .addGroup(PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblWhatsAppFlg, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtAddressCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 5, 5)
                                .addGroup(PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblAllowCallFlg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtAddressState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelFormContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblSendPromFlg, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbbAddressCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(222, Short.MAX_VALUE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PanelContactFormHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sPanelContactForm, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110))
        );

        javax.swing.GroupLayout PanelUserLayout = new javax.swing.GroupLayout(PanelUser);
        PanelUser.setLayout(PanelUserLayout);
        PanelUserLayout.setHorizontalGroup(
            PanelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelContactList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelContactForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelUserLayout.setVerticalGroup(
            PanelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelUserLayout.createSequentialGroup()
                .addComponent(PanelContactList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelContactForm, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelUser, javax.swing.GroupLayout.DEFAULT_SIZE, 1130, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelUser, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)
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

    private void cbbAddressListFilterItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbAddressListFilterItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            setFocus("FILTRO_VALOR");
        }
    }//GEN-LAST:event_cbbAddressListFilterItemStateChanged

    private void txtCommentsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCommentsKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("BOTAO_ADD_ENDERECO");
        }
    }//GEN-LAST:event_txtCommentsKeyPressed

    private void txtHomeBlockKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHomeBlockKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("REDE_SOCIAL_TWITTER");
        }
    }//GEN-LAST:event_txtHomeBlockKeyPressed

    private void txtHomeNumberKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHomeNumberKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("REDE_SOCIAL_INSTAGRAM");
        }
    }//GEN-LAST:event_txtHomeNumberKeyPressed

    private void txtZipcodePart1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtZipcodePart1KeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("CONTATO_TELEFONE_FIXO");
        }
    }//GEN-LAST:event_txtZipcodePart1KeyPressed

    private void txtAddressNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAddressNameKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("CONTATO_TELEFONE_COMERCIAL");
        }
    }//GEN-LAST:event_txtAddressNameKeyPressed

    private void txtAddressNumberKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAddressNumberKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("CONTATO_EMAIL_TIPO");
        }
    }//GEN-LAST:event_txtAddressNumberKeyPressed

    private void txtAddressCityKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAddressCityKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("CONTATO_EMAIL");
        }
    }//GEN-LAST:event_txtAddressCityKeyPressed

    private void cbbAddressTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbAddressTypeItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            setFocus("PERMITE_EMAIL_FLG");
        }
    }//GEN-LAST:event_cbbAddressTypeItemStateChanged

    private void cbkMainAddressKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbkMainAddressKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("WHATSAPP_FLG");
        }
    }//GEN-LAST:event_cbkMainAddressKeyPressed

    private void cbkMainAddressItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbkMainAddressItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            setFocus("WHATSAPP_FLG");
        }
    }//GEN-LAST:event_cbkMainAddressItemStateChanged

    private void btnDeleteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnDeleteKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_TAB){
            setFocus("BOTAO_NOVO");
        }
    }//GEN-LAST:event_btnDeleteKeyPressed

    private void cbbAddressTypeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbbAddressTypeKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_TAB){
            setFocus("PERMITE_EMAIL_FLG");
        }
    }//GEN-LAST:event_cbbAddressTypeKeyPressed

    private void txtZipcodePart2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtZipcodePart2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtZipcodePart2KeyPressed

    private void txtAddressStateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAddressStateKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddressStateKeyPressed

    private void cbbAddressCountryItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbAddressCountryItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbAddressCountryItemStateChanged

    private void cbbAddressCountryKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbbAddressCountryKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbAddressCountryKeyPressed

    private void txtAddressComplementKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAddressComplementKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddressComplementKeyPressed

    private void cbbHomeTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbHomeTypeItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbHomeTypeItemStateChanged

    private void cbbHomeTypeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbbHomeTypeKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbHomeTypeKeyPressed

    private void txtHomeFloorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHomeFloorKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHomeFloorKeyPressed

    private void txtNeighborhoodKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNeighborhoodKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNeighborhoodKeyPressed

    private void cbbAddressZoneItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbAddressZoneItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbAddressZoneItemStateChanged

    private void cbbAddressZoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbbAddressZoneKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbAddressZoneKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelContactForm;
    private javax.swing.JPanel PanelContactFormHeader;
    private javax.swing.JPanel PanelContactList;
    private javax.swing.JPanel PanelContactListHeader;
    private javax.swing.JPanel PanelFormContact;
    private javax.swing.JPanel PanelListContact;
    private javax.swing.JPanel PanelUser;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearchAddress;
    private javax.swing.JComboBox<String> cbbAddressCountry;
    private javax.swing.JComboBox<String> cbbAddressListFilter;
    private javax.swing.JComboBox<String> cbbAddressType;
    private javax.swing.JComboBox<String> cbbAddressZone;
    private javax.swing.JComboBox<String> cbbHomeType;
    private javax.swing.JCheckBox cbkMainAddress;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblAddSocialMedia;
    private javax.swing.JLabel lblAddressNameHeader;
    private javax.swing.JLabel lblAllowCallFlg;
    private javax.swing.JLabel lblAllowEmailFlg;
    private javax.swing.JLabel lblContactEmail;
    private javax.swing.JLabel lblContactEmail2;
    private javax.swing.JLabel lblContactEnterprise;
    private javax.swing.JLabel lblContactFormInformation;
    private javax.swing.JLabel lblContactInformation;
    private javax.swing.JLabel lblContactList;
    private javax.swing.JLabel lblContactMPhone;
    private javax.swing.JLabel lblContactPhone;
    private javax.swing.JLabel lblFacebook;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblInformation;
    private javax.swing.JLabel lblInstagram;
    private javax.swing.JLabel lblMainContFlg;
    private javax.swing.JLabel lblRecCount;
    private javax.swing.JLabel lblRowId;
    private javax.swing.JLabel lblSendNewsFlg;
    private javax.swing.JLabel lblSendPromFlg;
    private javax.swing.JLabel lblSocialMedia;
    private javax.swing.JLabel lblTwitter;
    private javax.swing.JLabel lblWhatsAppFlg;
    private javax.swing.JLabel lblWhatsAppFlg1;
    private javax.swing.JLabel lblWhatsAppFlg2;
    private javax.swing.JScrollPane sPanelContactForm;
    private javax.swing.JScrollPane sPanelUserList;
    private javax.swing.JTable tblAddressList;
    private javax.swing.JTextField txtAddressCity;
    private javax.swing.JTextField txtAddressComplement;
    private javax.swing.JTextField txtAddressListFilterValue;
    private javax.swing.JTextField txtAddressName;
    private javax.swing.JTextField txtAddressNumber;
    private javax.swing.JTextField txtAddressState;
    private javax.swing.JTextField txtComments;
    private javax.swing.JTextField txtHomeBlock;
    private javax.swing.JTextField txtHomeFloor;
    private javax.swing.JTextField txtHomeNumber;
    private javax.swing.JTextField txtNeighborhood;
    private javax.swing.JTextField txtRowId;
    private javax.swing.JTextField txtZipcodePart1;
    private javax.swing.JTextField txtZipcodePart2;
    // End of variables declaration//GEN-END:variables
}
