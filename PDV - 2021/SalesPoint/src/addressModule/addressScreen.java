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
    public void setListenerBtnSearch(ActionListener listener) { this.btnSearchAddress.addActionListener(listener); }
    public void setListenerAddressScreen(WindowListener listener) { this.addWindowListener(listener); }
    
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
    
    public void settxtHomeFloor(String value) { this.txtHomeFloor.setText(value); this.txtHomeFloor.paintImmediately(this.txtHomeFloor.getVisibleRect()); }
    public void settxtHomeNumber(String value) { this.txtHomeNumber.setText(value); this.txtHomeNumber.paintImmediately(this.txtHomeNumber.getVisibleRect()); }
    public void settxtHomeBlock(String value) { this.txtHomeBlock.setText(value); this.txtHomeBlock.paintImmediately(this.txtHomeBlock.getVisibleRect()); }
    public void settxtComments(String value) { this.txtComments.setText(value); this.txtComments.paintImmediately(this.txtComments.getVisibleRect()); }
    
    public void setcbbAddressListFilter(String value) { this.cbbAddressListFilter.addItem(value); this.cbbAddressListFilter.paintImmediately(this.cbbAddressListFilter.getVisibleRect()); }
    public void setcbbAddressType(String value) { this.cbbAddressType.addItem(value); this.cbbAddressType.paintImmediately(this.cbbAddressType.getVisibleRect()); }
    public void setcbbAddressZone(String value) { this.cbbAddressZone.addItem(value); this.cbbAddressZone.paintImmediately(this.cbbAddressZone.getVisibleRect()); }
    public void setcbbAddressState(String value) { this.cbbAddressState.addItem(value); this.cbbAddressState.paintImmediately(this.cbbAddressState.getVisibleRect()); }
    public void setcbbAddressCountry(String value) { this.cbbAddressCountry.addItem(value); this.cbbAddressCountry.paintImmediately(this.cbbAddressCountry.getVisibleRect()); }
    public void setcbbHomeType(String value) { this.cbbHomeType.addItem(value); this.cbbHomeType.paintImmediately(this.cbbHomeType.getVisibleRect()); }
    
    public void setcbkMainAddress(String value) { if("Y".equals(value)) { this.cbkMainAddress.setSelected(true); } else { this.cbkMainAddress.setSelected(false); } this.cbkMainAddress.paintImmediately(this.cbkMainAddress.getVisibleRect()); }
    
    public void setlblRecCount(String value) { this.lblRecCount.setText("Total de Registros: " + value); this.lblRecCount.paintImmediately(this.lblRecCount.getVisibleRect()); }
    public void setlblAddressNameHeader(String value) { this.lblAddressNameHeader.setText(value); this.lblAddressNameHeader.paintImmediately(this.lblAddressNameHeader.getVisibleRect()); }
    
    // ComboBox Specific Setters
    public void setcbbAddressListFilterItemIndex(int value) { this.cbbAddressListFilter.setSelectedIndex(value); this.cbbAddressListFilter.paintImmediately(this.cbbAddressListFilter.getVisibleRect()); }
    public void setcbbAddressTypeItemIndex(int value) { this.cbbAddressType.setSelectedIndex(value); this.cbbAddressType.paintImmediately(this.cbbAddressType.getVisibleRect()); }
    public void setcbbAddressStateItemIndex(int value) { this.cbbAddressState.setSelectedIndex(value); this.cbbAddressState.paintImmediately(this.cbbAddressState.getVisibleRect()); }
    public void setcbbAddressZoneItemIndex(int value) { this.cbbAddressZone.setSelectedIndex(value); this.cbbAddressZone.paintImmediately(this.cbbAddressZone.getVisibleRect()); }
    public void setcbbAddressCountryItemIndex(int value) { this.cbbAddressCountry.setSelectedIndex(value); this.cbbAddressCountry.paintImmediately(this.cbbAddressCountry.getVisibleRect()); }
    public void setcbbHomeTypeItemIndex(int value) { this.cbbHomeType.setSelectedIndex(value); this.cbbHomeType.paintImmediately(this.cbbHomeType.getVisibleRect()); }
    
    // Component Getters
    public String gettxtAddressListFilterValue() { return (!"".equals(this.txtAddressListFilterValue.getText()) && this.txtAddressListFilterValue.getText() != null) ? this.txtAddressListFilterValue.getText() : null; }
    public String gettxtRowId() { return (!"".equals(this.txtRowId.getText()) && this.txtRowId.getText() != null) ? this.txtRowId.getText() : null; }
    public String gettxtZipcodePart1() { return (!"".equals(this.txtZipcodePart1.getText()) && this.txtZipcodePart1.getText() != null) ? this.txtZipcodePart1.getText() : null; }
    public String gettxtZipcodePart2() { return (!"".equals(this.txtZipcodePart2.getText()) && this.txtZipcodePart2.getText() != null) ? this.txtZipcodePart2.getText() : null; }
    public String gettxtZipcode() { return (gettxtZipcodePart1() != null) ? (gettxtZipcodePart2() != null) ? gettxtZipcodePart1() + "-" + gettxtZipcodePart2() : null : null; }
    public String gettxtAddressName() { return (!"".equals(this.txtAddressName.getText()) && this.txtAddressName.getText() != null) ? this.txtAddressName.getText() : null; }
    public String gettxtAddressNumber() { return (!"".equals(this.txtAddressNumber.getText()) && this.txtAddressNumber.getText() != null) ? this.txtAddressNumber.getText() : null; }
    public String gettxtAddressComplement() { return (!"".equals(this.txtAddressComplement.getText()) && this.txtAddressComplement.getText() != null) ? this.txtAddressComplement.getText() : null; }
    public String gettxtNeighborhood() { return (!"".equals(this.txtNeighborhood.getText()) && this.txtNeighborhood.getText() != null) ? this.txtNeighborhood.getText() : null; }
    public String gettxtAddressCity() { return (!"".equals(this.txtAddressCity.getText()) && this.txtAddressCity.getText() != null) ? this.txtAddressCity.getText() : null; }
    
    public String gettxtHomeFloor() { if(!"".equals(this.txtHomeFloor.getText()) && this.txtHomeFloor.getText() != null) { return this.txtHomeFloor.getText(); } else { return null; } }
    public String gettxtHomeNumber() { if(!"".equals(this.txtHomeNumber.getText()) && this.txtHomeNumber.getText() != null) { return this.txtHomeNumber.getText(); } else { return null; } }
    public String gettxtHomeBlock() { if(!"".equals(this.txtHomeBlock.getText()) && this.txtHomeBlock.getText() != null) { return this.txtHomeBlock.getText(); } else { return null; } }
    public String gettxtComments() { if(!"".equals(this.txtComments.getText()) && this.txtComments.getText() != null) { return this.txtComments.getText(); } else { return null; } }
    
    public String getcbbAddresstListFilter() { if(!"".equals(this.cbbAddressListFilter.getSelectedItem().toString()) && !"Selecione...".equals(this.cbbAddressListFilter.getSelectedItem().toString()) && this.cbbAddressListFilter.getSelectedItem().toString() != null) { return this.cbbAddressListFilter.getSelectedItem().toString(); } else { return null; } }
    public String getcbbAddressType() { if(!"".equals(this.cbbAddressType.getSelectedItem().toString()) && !"Selecione...".equals(this.cbbAddressType.getSelectedItem().toString()) && this.cbbAddressType.getSelectedItem().toString() != null) { return this.cbbAddressType.getSelectedItem().toString(); } else { return null; } }
    public String getcbbAddressState() { if(!"".equals(this.cbbAddressState.getSelectedItem().toString()) && !"Selecione...".equals(this.cbbAddressState.getSelectedItem().toString()) && this.cbbAddressState.getSelectedItem().toString() != null) { return this.cbbAddressState.getSelectedItem().toString(); } else { return null; } }
    public String getcbbAddressZone() { if(!"".equals(this.cbbAddressZone.getSelectedItem().toString()) && !"Selecione...".equals(this.cbbAddressZone.getSelectedItem().toString()) && this.cbbAddressZone.getSelectedItem().toString() != null) { return this.cbbAddressZone.getSelectedItem().toString(); } else { return null; } }
    public String getcbbAddressCountry() { if(!"".equals(this.cbbAddressCountry.getSelectedItem().toString()) && !"Selecione...".equals(this.cbbAddressCountry.getSelectedItem().toString()) && this.cbbAddressCountry.getSelectedItem().toString() != null) { return this.cbbAddressCountry.getSelectedItem().toString(); } else { return null; } }
    public String getcbbHomeType() { if(!"".equals(this.cbbHomeType.getSelectedItem().toString()) && !"Selecione...".equals(this.cbbHomeType.getSelectedItem().toString()) && this.cbbHomeType.getSelectedItem().toString() != null) { return this.cbbHomeType.getSelectedItem().toString(); } else { return null; } }
    
    public String getcbkMainAddress() { if(this.cbkMainAddress.isSelected()) { return "Y"; } else { return "N"; } }
    
    public String getlblRecCount() { return this.lblRecCount.getText(); }
    public String getlblAddressNameHeader() { return this.lblAddressNameHeader.getText(); }

    // ComboBox Specific Getters
    public int getcbbUserListFilterItemIndex(String value) { if(!"".equals(value) && value != null) { for(int i = 0; i < this.cbbAddressListFilter.getItemCount(); i++){ if(value.equals(this.cbbAddressListFilter.getItemAt(i))){ return i; }}} else { return 0; } return 0; }
    public int getcbbAddressTypeItemIndex(String value) { if(!"".equals(value) && value != null) { for(int i = 0; i < this.cbbAddressType.getItemCount(); i++){ if(value.equals(this.cbbAddressType.getItemAt(i))){ return i; }}} else { return 0; } return 0; }
    public int getcbbAddressStateItemIndex(String value) { if(!"".equals(value) && value != null) { for(int i = 0; i < this.cbbAddressState.getItemCount(); i++){ if(value.equals(this.cbbAddressState.getItemAt(i))){ return i; }}} else { return 0; } return 0; }
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
    public void cleartxtHomeFloor() { this.txtHomeFloor.setText(""); this.txtHomeFloor.paintImmediately(this.txtHomeFloor.getVisibleRect()); }
    public void cleartxtHomeNumber() { this.txtHomeNumber.setText(""); this.txtHomeNumber.paintImmediately(this.txtHomeNumber.getVisibleRect()); }
    public void cleartxtHomeBlock() { this.txtHomeBlock.setText(""); this.txtHomeBlock.paintImmediately(this.txtHomeBlock.getVisibleRect()); }
    public void cleartxtComments() { this.txtComments.setText(""); this.txtComments.paintImmediately(this.txtComments.getVisibleRect()); }
    
    public void clearcbbAddressListFilter() { this.cbbAddressListFilter.removeAllItems(); this.cbbAddressListFilter.paintImmediately(this.cbbAddressListFilter.getVisibleRect()); }
    public void clearcbbAddressType() { this.cbbAddressType.removeAllItems(); this.cbbAddressType.paintImmediately(this.cbbAddressType.getVisibleRect()); }
    public void clearcbbAddressState() { this.cbbAddressState.removeAllItems(); this.cbbAddressState.paintImmediately(this.cbbAddressState.getVisibleRect()); }
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
    public void settxtHomeFloorEnabled(boolean status) { this.txtHomeFloor.setEnabled(status); }
    public void settxtHomeNumberEnabled(boolean status) { this.txtHomeNumber.setEnabled(status); }
    public void settxtHomeBlockEnabled(boolean status) { this.txtHomeBlock.setEnabled(status); }
    public void settxtCommentslEnabled(boolean status) { this.txtComments.setEnabled(status); }
    
    public void setcbbAddressListFilterEnabled(boolean status) { this.cbbAddressListFilter.setEnabled(status); }
    public void setcbbAddressTypeEnabled(boolean status) { this.cbbAddressType.setEnabled(status); }
    public void setcbbAddressStateEnabled(boolean status) { this.cbbAddressState.setEnabled(status); }
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
    public boolean istxtHomeFloorEnabled() { return this.txtHomeFloor.isEnabled(); }
    public boolean istxtHomeNumberEnabled() { return this.txtHomeNumber.isEnabled(); }
    public boolean istxtHomeBlockEnabled() { return this.txtHomeBlock.isEnabled(); }
    public boolean istxtCommentsEnabled() { return this.txtComments.isEnabled(); }
    
    public boolean iscbbAddressListFilterEnabled() { return this.cbbAddressListFilter.isEnabled(); }
    public boolean iscbbAddressTypeEnabled() { return this.cbbAddressType.isEnabled(); }
    public boolean iscbbAddressStateEnabled() { return this.cbbAddressState.isEnabled(); }
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
            this.cbbAddressState.requestFocus();
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
        case "BOTAO_PESQUISAR":
            this.btnSearchAddress.requestFocus();
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
                setcbbAddressStateEnabled(false);
                settxtHomeFloorEnabled(false);
                settxtHomeNumberEnabled(false);
                settxtHomeBlockEnabled(false);
                settxtCommentslEnabled(false);          

                setcbbAddressListFilterEnabled(true);
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
                settxtAddressListFilterValueEnabled(false);
                settxtRowIdEnabled(false);
                settxtZipcodePart1Enabled(true);
                settxtZipcodePart2Enabled(true);
                settxtAddressNameEnabled(false);
                settxtAddressNumberEnabled(false);
                settxtAddressComplementEnabled(false);
                settxtNeighborhoodEnabled(false);
                settxtAddressCityEnabled(false);
                setcbbAddressStateEnabled(false);
                settxtHomeFloorEnabled(false);
                settxtHomeNumberEnabled(false);
                settxtHomeBlockEnabled(false);
                settxtCommentslEnabled(false);

                setcbbAddressListFilterEnabled(true);
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
                settxtAddressListFilterValueEnabled(false);
                settxtRowIdEnabled(false);
                settxtZipcodePart1Enabled(true);
                settxtZipcodePart2Enabled(true);
                settxtAddressNameEnabled(true);
                settxtAddressNumberEnabled(true);
                settxtAddressComplementEnabled(true);
                settxtNeighborhoodEnabled(true);
                settxtAddressCityEnabled(true);
                setcbbAddressStateEnabled(true);
                settxtHomeFloorEnabled(true);
                settxtHomeNumberEnabled(true);
                settxtHomeBlockEnabled(true);
                settxtCommentslEnabled(true);

                setcbbAddressListFilterEnabled(true);
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
                setcbbAddressStateEnabled(false);
                settxtHomeFloorEnabled(false);
                settxtHomeNumberEnabled(false);
                settxtHomeBlockEnabled(false);
                settxtCommentslEnabled(false);

                setcbbAddressListFilterEnabled(true);
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
                setcbbAddressStateEnabled(false);
                settxtHomeFloorEnabled(false);
                settxtHomeNumberEnabled(false);
                settxtHomeBlockEnabled(false);
                settxtCommentslEnabled(false);

                setcbbAddressListFilterEnabled(true);
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
                setcbbAddressStateEnabled(false);
                settxtHomeFloorEnabled(false);
                settxtHomeNumberEnabled(false);
                settxtHomeBlockEnabled(false);
                settxtCommentslEnabled(false);

                setcbbAddressListFilterEnabled(true);
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
            case "SEARCH":
                settxtAddressListFilterValueEnabled(false);
                settxtRowIdEnabled(false);
                settxtZipcodePart1Enabled(true);
                settxtZipcodePart2Enabled(true);
                settxtAddressNameEnabled(true);
                settxtAddressNumberEnabled(true);
                settxtAddressComplementEnabled(true);
                settxtNeighborhoodEnabled(true);
                settxtAddressCityEnabled(true);
                setcbbAddressStateEnabled(true);
                settxtHomeFloorEnabled(true);
                settxtHomeNumberEnabled(true);
                settxtHomeBlockEnabled(true);
                settxtCommentslEnabled(true);

                setcbbAddressListFilterEnabled(false);
                setcbbAddressTypeEnabled(true);
                setcbbAddressZoneEnabled(true);
                setcbbAddressCountryEnabled(true);
                setcbbHomeTypeEnabled(true);

                setcbkMainAddressEnabled(true);

                setTblEnabled(false);
                
                setbtnEditEnabled(false);
                setbtnDeleteEnabled(false);
                setbtnNewEnabled(false);
                setbtnSaveEnabled(true);
                setbtnCancelEnabled(true);
                setbtnSearchAddressEnabled(true);
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
        cleartxtHomeFloor();
        cleartxtHomeNumber();
        cleartxtHomeBlock();
        cleartxtComments();
        
        clearcbkMainAddress();
        
        setcbbAddressTypeItemIndex(0);
        setcbbHomeTypeItemIndex(0);
        setcbbAddressListFilterItemIndex(0);
        setcbbAddressZoneItemIndex(0);
        setcbbAddressStateItemIndex(0);
        setcbbAddressCountryItemIndex(0);
                
        //clearlblAddressNameHeader();
    }
    
    public void clearComboBoxes(){
        clearcbbAddressListFilter();
        clearcbbAddressType();
        clearcbbAddressZone();
        clearcbbAddressState();
        clearcbbAddressCountry();
        clearcbbHomeType();
    }
    
    public void insertSelectComboBox(){
        this.setcbbAddressListFilter("Selecione...");
        this.setcbbAddressType("Selecione...");
        this.setcbbAddressZone("Selecione...");
        this.setcbbAddressCountry("Selecione...");
        this.setcbbHomeType("Selecione...");
        this.setcbbAddressState("Selecione...");
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
        this.txtHomeFloor.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtHomeNumber.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtHomeBlock.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtComments.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        
        this.cbbAddressListFilter.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.cbbAddressType.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.cbbAddressState.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.cbbAddressZone.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.cbbAddressCountry.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.cbbHomeType.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);

        this.cbkMainAddress.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
    
        this.lblRecCount.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.lblAddressNameHeader.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        
        this.btnCancel.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.btnDelete.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.btnEdit.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.btnNew.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.btnSave.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.btnSearchAddress.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
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
        PanelAddressList = new javax.swing.JPanel();
        PanelAddressListHeader = new javax.swing.JPanel();
        lblAddressList = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblImage = new javax.swing.JLabel();
        cbbAddressListFilter = new javax.swing.JComboBox<>();
        txtAddressListFilterValue = new javax.swing.JTextField();
        lblInformation = new javax.swing.JLabel();
        lblRecCount = new javax.swing.JLabel();
        PanelListAddress = new javax.swing.JPanel();
        sPanelAddressList = new javax.swing.JScrollPane();
        tblAddressList = new javax.swing.JTable();
        PanelAddressForm = new javax.swing.JPanel();
        PanelAddressFormHeader = new javax.swing.JPanel();
        lblAddressNameHeader = new javax.swing.JLabel();
        lblAddressFormInformation = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        btnEdit = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        sPanelAddressForm = new javax.swing.JScrollPane();
        PanelFormAddress = new javax.swing.JPanel();
        lblAddressInformation = new javax.swing.JLabel();
        lblRowId = new javax.swing.JLabel();
        txtRowId = new javax.swing.JTextField();
        lblZipcode = new javax.swing.JLabel();
        txtZipcodePart1 = new javax.swing.JTextField();
        lblDash = new javax.swing.JLabel();
        txtZipcodePart2 = new javax.swing.JTextField();
        btnSearchAddress = new javax.swing.JButton();
        lblAddressType = new javax.swing.JLabel();
        cbbAddressType = new javax.swing.JComboBox<>();
        lblAddressName = new javax.swing.JLabel();
        txtAddressName = new javax.swing.JTextField();
        lblAddressNumber = new javax.swing.JLabel();
        txtAddressNumber = new javax.swing.JTextField();
        lblAddressComplement = new javax.swing.JLabel();
        txtAddressComplement = new javax.swing.JTextField();
        lblMainAddrFlg = new javax.swing.JLabel();
        cbkMainAddress = new javax.swing.JCheckBox();
        lblNeighborhood = new javax.swing.JLabel();
        txtNeighborhood = new javax.swing.JTextField();
        lblAddressZone = new javax.swing.JLabel();
        cbbAddressZone = new javax.swing.JComboBox<>();
        lblAddressCity = new javax.swing.JLabel();
        txtAddressCity = new javax.swing.JTextField();
        lblAdressState = new javax.swing.JLabel();
        lblAddressCountry = new javax.swing.JLabel();
        cbbAddressCountry = new javax.swing.JComboBox<>();
        lblSocialMedia = new javax.swing.JLabel();
        lblHomeType = new javax.swing.JLabel();
        cbbHomeType = new javax.swing.JComboBox<>();
        lblHomeFloor = new javax.swing.JLabel();
        txtHomeFloor = new javax.swing.JTextField();
        lblHomeNumber = new javax.swing.JLabel();
        txtHomeNumber = new javax.swing.JTextField();
        lblHomeBlock = new javax.swing.JLabel();
        txtHomeBlock = new javax.swing.JTextField();
        lblComments = new javax.swing.JLabel();
        txtComments = new javax.swing.JTextField();
        cbbAddressState = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Endereço");
        setBackground(new java.awt.Color(255, 255, 255));
        setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        setResizable(false);

        PanelUser.setBackground(new java.awt.Color(255, 255, 255));
        PanelUser.setPreferredSize(new java.awt.Dimension(1366, 757));

        lblAddressList.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        lblAddressList.setText("Lista de Endereços");
        lblAddressList.setToolTipText("");

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

        javax.swing.GroupLayout PanelAddressListHeaderLayout = new javax.swing.GroupLayout(PanelAddressListHeader);
        PanelAddressListHeader.setLayout(PanelAddressListHeaderLayout);
        PanelAddressListHeaderLayout.setHorizontalGroup(
            PanelAddressListHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAddressListHeaderLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(lblAddressList, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblImage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbbAddressListFilter, 0, 221, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAddressListFilterValue, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInformation)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRecCount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        PanelAddressListHeaderLayout.setVerticalGroup(
            PanelAddressListHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelAddressListHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelAddressListHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbbAddressListFilter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblAddressList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addComponent(lblImage, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblRecCount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblInformation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtAddressListFilterValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        lblRecCount.getAccessibleContext().setAccessibleDescription("");

        sPanelAddressList.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        sPanelAddressList.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        sPanelAddressList.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N

        tblAddressList.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        tblAddressList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Principal", "Tipo de Logradouro", "Logradouro", "Número", "Complemento", "Bairro", "Zona", "Cidade", "Estado", "País", "Tipo de Imóvel", "Andar", "Número do APTO/Casa", "Bloco", "Comentários"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
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
        sPanelAddressList.setViewportView(tblAddressList);

        javax.swing.GroupLayout PanelListAddressLayout = new javax.swing.GroupLayout(PanelListAddress);
        PanelListAddress.setLayout(PanelListAddressLayout);
        PanelListAddressLayout.setHorizontalGroup(
            PanelListAddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sPanelAddressList)
        );
        PanelListAddressLayout.setVerticalGroup(
            PanelListAddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sPanelAddressList, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PanelAddressListLayout = new javax.swing.GroupLayout(PanelAddressList);
        PanelAddressList.setLayout(PanelAddressListLayout);
        PanelAddressListLayout.setHorizontalGroup(
            PanelAddressListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelAddressListLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelAddressListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelListAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelAddressListHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        PanelAddressListLayout.setVerticalGroup(
            PanelAddressListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAddressListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelAddressListHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelListAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        lblAddressNameHeader.setBackground(new java.awt.Color(255, 255, 255));
        lblAddressNameHeader.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        lblAddressNameHeader.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblAddressNameHeader.setText("Detalhes do Endereço");
        lblAddressNameHeader.setMinimumSize(new java.awt.Dimension(0, 30));

        lblAddressFormInformation.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblAddressFormInformation.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAddressFormInformation.setText("Campos Obrigatórios (*)");
        lblAddressFormInformation.setEnabled(false);

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

        javax.swing.GroupLayout PanelAddressFormHeaderLayout = new javax.swing.GroupLayout(PanelAddressFormHeader);
        PanelAddressFormHeader.setLayout(PanelAddressFormHeaderLayout);
        PanelAddressFormHeaderLayout.setHorizontalGroup(
            PanelAddressFormHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelAddressFormHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAddressNameHeader, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
                .addGap(49, 49, 49)
                .addComponent(lblAddressFormInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        PanelAddressFormHeaderLayout.setVerticalGroup(
            PanelAddressFormHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAddressFormHeaderLayout.createSequentialGroup()
                .addGroup(PanelAddressFormHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblAddressFormInformation, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblAddressNameHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        sPanelAddressForm.setBorder(null);
        sPanelAddressForm.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        sPanelAddressForm.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        sPanelAddressForm.setMinimumSize(new java.awt.Dimension(0, 0));
        sPanelAddressForm.setPreferredSize(new java.awt.Dimension(1366, 427));

        PanelFormAddress.setBackground(new java.awt.Color(255, 255, 255));
        PanelFormAddress.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        PanelFormAddress.setPreferredSize(new java.awt.Dimension(1340, 425));

        lblAddressInformation.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.light"));
        lblAddressInformation.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblAddressInformation.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblAddressInformation.setText("   Informações do Endereço");
        lblAddressInformation.setToolTipText("");
        lblAddressInformation.setEnabled(false);
        lblAddressInformation.setMaximumSize(new java.awt.Dimension(644, 16));
        lblAddressInformation.setMinimumSize(new java.awt.Dimension(644, 16));
        lblAddressInformation.setOpaque(true);

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

        lblZipcode.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblZipcode.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblZipcode.setText("CEP*:");
        lblZipcode.setEnabled(false);
        lblZipcode.setMaximumSize(new java.awt.Dimension(150, 16));
        lblZipcode.setPreferredSize(new java.awt.Dimension(150, 16));

        txtZipcodePart1.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtZipcodePart1.setText("23036");
        txtZipcodePart1.setToolTipText("");
        txtZipcodePart1.setEnabled(false);
        txtZipcodePart1.setMaximumSize(new java.awt.Dimension(165, 22));
        txtZipcodePart1.setMinimumSize(new java.awt.Dimension(165, 22));
        txtZipcodePart1.setPreferredSize(new java.awt.Dimension(165, 22));
        txtZipcodePart1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtZipcodePart1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtZipcodePart1KeyTyped(evt);
            }
        });

        lblDash.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblDash.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDash.setText("-");
        lblDash.setEnabled(false);
        lblDash.setMaximumSize(new java.awt.Dimension(22, 16));

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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtZipcodePart2KeyTyped(evt);
            }
        });

        btnSearchAddress.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        btnSearchAddress.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/Lupa 10x10.png"))); // NOI18N
        btnSearchAddress.setEnabled(false);
        btnSearchAddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnSearchAddressKeyPressed(evt);
            }
        });

        lblAddressType.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblAddressType.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAddressType.setText("Tipo de Logradouro*:");
        lblAddressType.setToolTipText("");
        lblAddressType.setEnabled(false);
        lblAddressType.setMaximumSize(new java.awt.Dimension(150, 16));
        lblAddressType.setPreferredSize(new java.awt.Dimension(150, 22));

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

        lblAddressName.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblAddressName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAddressName.setText("Logradouro*:");
        lblAddressName.setEnabled(false);
        lblAddressName.setMaximumSize(new java.awt.Dimension(150, 16));
        lblAddressName.setPreferredSize(new java.awt.Dimension(150, 16));

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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAddressNameKeyTyped(evt);
            }
        });

        lblAddressNumber.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblAddressNumber.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAddressNumber.setText("Número*:");
        lblAddressNumber.setToolTipText("");
        lblAddressNumber.setEnabled(false);
        lblAddressNumber.setMaximumSize(new java.awt.Dimension(150, 22));
        lblAddressNumber.setMinimumSize(new java.awt.Dimension(150, 22));
        lblAddressNumber.setPreferredSize(new java.awt.Dimension(150, 22));

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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAddressNumberKeyTyped(evt);
            }
        });

        lblAddressComplement.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblAddressComplement.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAddressComplement.setText("Complemento:");
        lblAddressComplement.setEnabled(false);
        lblAddressComplement.setMaximumSize(new java.awt.Dimension(150, 22));
        lblAddressComplement.setMinimumSize(new java.awt.Dimension(150, 22));
        lblAddressComplement.setPreferredSize(new java.awt.Dimension(150, 22));

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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAddressComplementKeyTyped(evt);
            }
        });

        lblMainAddrFlg.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblMainAddrFlg.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMainAddrFlg.setText("Endereço Principal:");
        lblMainAddrFlg.setToolTipText("");
        lblMainAddrFlg.setEnabled(false);
        lblMainAddrFlg.setMaximumSize(new java.awt.Dimension(150, 22));
        lblMainAddrFlg.setMinimumSize(new java.awt.Dimension(150, 22));
        lblMainAddrFlg.setPreferredSize(new java.awt.Dimension(150, 22));

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

        lblNeighborhood.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblNeighborhood.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNeighborhood.setText("Bairro*:");
        lblNeighborhood.setEnabled(false);
        lblNeighborhood.setMaximumSize(new java.awt.Dimension(150, 22));
        lblNeighborhood.setMinimumSize(new java.awt.Dimension(150, 22));
        lblNeighborhood.setPreferredSize(new java.awt.Dimension(150, 22));

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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNeighborhoodKeyTyped(evt);
            }
        });

        lblAddressZone.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblAddressZone.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAddressZone.setText("Zona*:");
        lblAddressZone.setEnabled(false);
        lblAddressZone.setMaximumSize(new java.awt.Dimension(150, 22));
        lblAddressZone.setMinimumSize(new java.awt.Dimension(150, 22));
        lblAddressZone.setPreferredSize(new java.awt.Dimension(150, 22));

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

        lblAddressCity.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblAddressCity.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAddressCity.setText("Cidade*:");
        lblAddressCity.setEnabled(false);
        lblAddressCity.setMaximumSize(new java.awt.Dimension(150, 22));
        lblAddressCity.setMinimumSize(new java.awt.Dimension(150, 22));
        lblAddressCity.setPreferredSize(new java.awt.Dimension(150, 22));

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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAddressCityKeyTyped(evt);
            }
        });

        lblAdressState.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblAdressState.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAdressState.setText("Estado*:");
        lblAdressState.setEnabled(false);
        lblAdressState.setMaximumSize(new java.awt.Dimension(150, 22));
        lblAdressState.setMinimumSize(new java.awt.Dimension(150, 22));
        lblAdressState.setPreferredSize(new java.awt.Dimension(150, 22));

        lblAddressCountry.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblAddressCountry.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAddressCountry.setText("País*:");
        lblAddressCountry.setEnabled(false);
        lblAddressCountry.setMaximumSize(new java.awt.Dimension(150, 22));
        lblAddressCountry.setMinimumSize(new java.awt.Dimension(150, 22));
        lblAddressCountry.setPreferredSize(new java.awt.Dimension(150, 22));

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

        lblSocialMedia.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.light"));
        lblSocialMedia.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblSocialMedia.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblSocialMedia.setText("   Informações do Imóvel:");
        lblSocialMedia.setToolTipText("");
        lblSocialMedia.setEnabled(false);
        lblSocialMedia.setOpaque(true);

        lblHomeType.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblHomeType.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblHomeType.setText("Tipo de Imóvel*:");
        lblHomeType.setEnabled(false);
        lblHomeType.setMaximumSize(new java.awt.Dimension(150, 22));
        lblHomeType.setMinimumSize(new java.awt.Dimension(150, 22));
        lblHomeType.setPreferredSize(new java.awt.Dimension(150, 22));

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

        lblHomeFloor.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblHomeFloor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblHomeFloor.setText("Andar:");
        lblHomeFloor.setEnabled(false);
        lblHomeFloor.setPreferredSize(new java.awt.Dimension(150, 16));

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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHomeFloorKeyTyped(evt);
            }
        });

        lblHomeNumber.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblHomeNumber.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblHomeNumber.setText("Número APTO/Casa:");
        lblHomeNumber.setEnabled(false);
        lblHomeNumber.setMaximumSize(new java.awt.Dimension(150, 22));
        lblHomeNumber.setMinimumSize(new java.awt.Dimension(150, 22));
        lblHomeNumber.setPreferredSize(new java.awt.Dimension(150, 22));

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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHomeNumberKeyTyped(evt);
            }
        });

        lblHomeBlock.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblHomeBlock.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblHomeBlock.setText("Bloco:");
        lblHomeBlock.setEnabled(false);
        lblHomeBlock.setMaximumSize(new java.awt.Dimension(150, 22));
        lblHomeBlock.setMinimumSize(new java.awt.Dimension(150, 22));
        lblHomeBlock.setPreferredSize(new java.awt.Dimension(150, 22));

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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHomeBlockKeyTyped(evt);
            }
        });

        lblComments.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblComments.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblComments.setText("Comentários:");
        lblComments.setEnabled(false);
        lblComments.setMaximumSize(new java.awt.Dimension(150, 22));
        lblComments.setMinimumSize(new java.awt.Dimension(150, 22));
        lblComments.setPreferredSize(new java.awt.Dimension(150, 22));

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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCommentsKeyTyped(evt);
            }
        });

        cbbAddressState.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        cbbAddressState.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbAddressState.setEnabled(false);
        cbbAddressState.setMaximumSize(new java.awt.Dimension(165, 22));
        cbbAddressState.setMinimumSize(new java.awt.Dimension(165, 22));
        cbbAddressState.setPreferredSize(new java.awt.Dimension(165, 22));
        cbbAddressState.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbAddressStateItemStateChanged(evt);
            }
        });
        cbbAddressState.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbbAddressStateKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout PanelFormAddressLayout = new javax.swing.GroupLayout(PanelFormAddress);
        PanelFormAddress.setLayout(PanelFormAddressLayout);
        PanelFormAddressLayout.setHorizontalGroup(
            PanelFormAddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFormAddressLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelFormAddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAddressInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 642, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelFormAddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(PanelFormAddressLayout.createSequentialGroup()
                            .addComponent(lblRowId, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtRowId, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblMainAddrFlg, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cbkMainAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(PanelFormAddressLayout.createSequentialGroup()
                            .addComponent(lblZipcode, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtZipcodePart1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblDash, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtZipcodePart2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnSearchAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblNeighborhood, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtNeighborhood, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PanelFormAddressLayout.createSequentialGroup()
                        .addGroup(PanelFormAddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelFormAddressLayout.createSequentialGroup()
                                .addComponent(lblAddressType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbbAddressType, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelFormAddressLayout.createSequentialGroup()
                                .addComponent(lblAddressName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAddressName, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelFormAddressLayout.createSequentialGroup()
                                .addComponent(lblAddressNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAddressNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelFormAddressLayout.createSequentialGroup()
                                .addComponent(lblAddressComplement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAddressComplement, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelFormAddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(PanelFormAddressLayout.createSequentialGroup()
                                .addComponent(lblAddressCity, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAddressCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelFormAddressLayout.createSequentialGroup()
                                .addComponent(lblAdressState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbbAddressState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelFormAddressLayout.createSequentialGroup()
                                .addComponent(lblAddressCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbbAddressCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelFormAddressLayout.createSequentialGroup()
                                .addComponent(lblAddressZone, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbbAddressZone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelFormAddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelFormAddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(PanelFormAddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(PanelFormAddressLayout.createSequentialGroup()
                                .addComponent(lblComments, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtComments, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelFormAddressLayout.createSequentialGroup()
                                .addComponent(lblHomeBlock, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtHomeBlock, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(PanelFormAddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelFormAddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelFormAddressLayout.createSequentialGroup()
                                    .addComponent(lblHomeNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtHomeNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(PanelFormAddressLayout.createSequentialGroup()
                                    .addComponent(lblHomeFloor, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtHomeFloor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lblSocialMedia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(PanelFormAddressLayout.createSequentialGroup()
                        .addComponent(lblHomeType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbHomeType, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(359, Short.MAX_VALUE))
        );
        PanelFormAddressLayout.setVerticalGroup(
            PanelFormAddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelFormAddressLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelFormAddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSocialMedia, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAddressInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelFormAddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelFormAddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblHomeType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbbHomeType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelFormAddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(PanelFormAddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblRowId, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRowId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(PanelFormAddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMainAddrFlg, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbkMainAddress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelFormAddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelFormAddressLayout.createSequentialGroup()
                        .addGroup(PanelFormAddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblHomeFloor, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHomeFloor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNeighborhood, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNeighborhood, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearchAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelFormAddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblHomeNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHomeNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAddressZone, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbAddressZone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAddressType, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbAddressType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelFormAddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelFormAddressLayout.createSequentialGroup()
                                .addGroup(PanelFormAddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtHomeBlock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblHomeBlock, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelFormAddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtComments, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblComments, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(PanelFormAddressLayout.createSequentialGroup()
                                .addGroup(PanelFormAddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblAddressCity, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtAddressCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtAddressName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblAddressName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 5, 5)
                                .addGroup(PanelFormAddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblAdressState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbbAddressState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblAddressNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtAddressNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelFormAddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblAddressCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbbAddressCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblAddressComplement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtAddressComplement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(PanelFormAddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblZipcode, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtZipcodePart1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtZipcodePart2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblDash, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(223, 223, 223))
        );

        sPanelAddressForm.setViewportView(PanelFormAddress);

        javax.swing.GroupLayout PanelAddressFormLayout = new javax.swing.GroupLayout(PanelAddressForm);
        PanelAddressForm.setLayout(PanelAddressFormLayout);
        PanelAddressFormLayout.setHorizontalGroup(
            PanelAddressFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAddressFormLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sPanelAddressForm, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(PanelAddressFormHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelAddressFormLayout.setVerticalGroup(
            PanelAddressFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelAddressFormLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PanelAddressFormHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sPanelAddressForm, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110))
        );

        javax.swing.GroupLayout PanelUserLayout = new javax.swing.GroupLayout(PanelUser);
        PanelUser.setLayout(PanelUserLayout);
        PanelUserLayout.setHorizontalGroup(
            PanelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelAddressList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelAddressForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelUserLayout.setVerticalGroup(
            PanelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelUserLayout.createSequentialGroup()
                .addComponent(PanelAddressList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelAddressForm, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelUser, javax.swing.GroupLayout.DEFAULT_SIZE, 1012, Short.MAX_VALUE)
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
            setFocus("BOTAO_SALVAR");
        }
    }//GEN-LAST:event_txtCommentsKeyPressed

    private void txtHomeBlockKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHomeBlockKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("COMENTARIOS");
        }
    }//GEN-LAST:event_txtHomeBlockKeyPressed

    private void txtHomeNumberKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHomeNumberKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("BLOCO");
        }
    }//GEN-LAST:event_txtHomeNumberKeyPressed

    private void txtZipcodePart1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtZipcodePart1KeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("CEP_PARTE_2");
        }
    }//GEN-LAST:event_txtZipcodePart1KeyPressed

    private void txtAddressNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAddressNameKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("NUMERO");
        }
    }//GEN-LAST:event_txtAddressNameKeyPressed

    private void txtAddressNumberKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAddressNumberKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("COMPLEMENTO");
        }
    }//GEN-LAST:event_txtAddressNumberKeyPressed

    private void txtAddressCityKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAddressCityKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("ESTADO");
        }
    }//GEN-LAST:event_txtAddressCityKeyPressed

    private void cbbAddressTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbAddressTypeItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            setFocus("LOGRADOURO");
        }
    }//GEN-LAST:event_cbbAddressTypeItemStateChanged

    private void cbkMainAddressKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbkMainAddressKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("BAIRRO");
        }
    }//GEN-LAST:event_cbkMainAddressKeyPressed

    private void cbkMainAddressItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbkMainAddressItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            setFocus("BAIRRO");
        }
    }//GEN-LAST:event_cbkMainAddressItemStateChanged

    private void btnDeleteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnDeleteKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_TAB){
            setFocus("BOTAO_NOVO");
        }
    }//GEN-LAST:event_btnDeleteKeyPressed

    private void cbbAddressTypeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbbAddressTypeKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_TAB){
            setFocus("LOGRADOURO");
        }
    }//GEN-LAST:event_cbbAddressTypeKeyPressed

    private void txtZipcodePart2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtZipcodePart2KeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("BOTAO_PESQUISAR");
        }
    }//GEN-LAST:event_txtZipcodePart2KeyPressed

    private void cbbAddressCountryItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbAddressCountryItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            setFocus("TIPO_IMOVEL");
        }
    }//GEN-LAST:event_cbbAddressCountryItemStateChanged

    private void cbbAddressCountryKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbbAddressCountryKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_TAB){
            setFocus("TIPO_IMOVEL");
        }
    }//GEN-LAST:event_cbbAddressCountryKeyPressed

    private void txtAddressComplementKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAddressComplementKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("ENDERECO_PRINCIPAL");
        }
    }//GEN-LAST:event_txtAddressComplementKeyPressed

    private void cbbHomeTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbHomeTypeItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            setFocus("ANDAR");
        }
    }//GEN-LAST:event_cbbHomeTypeItemStateChanged

    private void cbbHomeTypeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbbHomeTypeKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_TAB){
            setFocus("ANDAR");
        }
    }//GEN-LAST:event_cbbHomeTypeKeyPressed

    private void txtHomeFloorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHomeFloorKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("NUMERO_CASA");
        }
    }//GEN-LAST:event_txtHomeFloorKeyPressed

    private void txtNeighborhoodKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNeighborhoodKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("ZONA");
        }
    }//GEN-LAST:event_txtNeighborhoodKeyPressed

    private void cbbAddressZoneItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbAddressZoneItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            setFocus("CIDADE");
        }
    }//GEN-LAST:event_cbbAddressZoneItemStateChanged

    private void cbbAddressZoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbbAddressZoneKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_TAB){
            setFocus("CIDADE");
        }
    }//GEN-LAST:event_cbbAddressZoneKeyPressed

    private void cbbAddressStateItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbAddressStateItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            setFocus("PAIS");
        }
    }//GEN-LAST:event_cbbAddressStateItemStateChanged

    private void cbbAddressStateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbbAddressStateKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_TAB){
            setFocus("PAIS");
        }
    }//GEN-LAST:event_cbbAddressStateKeyPressed

    private void btnSearchAddressKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSearchAddressKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("TIPO_LOGRADOURO");
        }
    }//GEN-LAST:event_btnSearchAddressKeyPressed

    private void txtZipcodePart1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtZipcodePart1KeyTyped
        String chr = String.valueOf(evt.getKeyChar());
        try{
            Integer.valueOf(chr);
            
            if(txtZipcodePart1.getText().length() > 4){
                if((evt.getKeyCode() != KeyEvent.VK_ENTER) || (evt.getKeyCode() != KeyEvent.VK_TAB)){
                    evt.consume();
                }
            }
        } catch (NumberFormatException e){
            evt.consume();
        }
    }//GEN-LAST:event_txtZipcodePart1KeyTyped

    private void txtZipcodePart2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtZipcodePart2KeyTyped
        String chr = String.valueOf(evt.getKeyChar());
        try{
            Integer.valueOf(chr);
            
            if(txtZipcodePart2.getText().length() > 2){
                if((evt.getKeyCode() != KeyEvent.VK_ENTER) || (evt.getKeyCode() != KeyEvent.VK_TAB)){
                    evt.consume();
                }
            }
        } catch (NumberFormatException e){
            evt.consume();
        }
    }//GEN-LAST:event_txtZipcodePart2KeyTyped

    private void txtAddressNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAddressNameKeyTyped
        if(txtAddressName.getText().length() > 199){
            if((evt.getKeyCode() != KeyEvent.VK_ENTER) || (evt.getKeyCode() != KeyEvent.VK_TAB)){
                evt.consume();
            }
        }
    }//GEN-LAST:event_txtAddressNameKeyTyped

    private void txtAddressNumberKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAddressNumberKeyTyped
        if(txtAddressNumber.getText().length() > 29){
            if((evt.getKeyCode() != KeyEvent.VK_ENTER) || (evt.getKeyCode() != KeyEvent.VK_TAB)){
                evt.consume();
            }
        }
    }//GEN-LAST:event_txtAddressNumberKeyTyped

    private void txtAddressComplementKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAddressComplementKeyTyped
        if(txtAddressComplement.getText().length() > 99){
            if((evt.getKeyCode() != KeyEvent.VK_ENTER) || (evt.getKeyCode() != KeyEvent.VK_TAB)){
                evt.consume();
            }
        }
    }//GEN-LAST:event_txtAddressComplementKeyTyped

    private void txtNeighborhoodKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNeighborhoodKeyTyped
        if(txtNeighborhood.getText().length() > 49){
            if((evt.getKeyCode() != KeyEvent.VK_ENTER) || (evt.getKeyCode() != KeyEvent.VK_TAB)){
                evt.consume();
            }
        }
    }//GEN-LAST:event_txtNeighborhoodKeyTyped

    private void txtAddressCityKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAddressCityKeyTyped
        if(txtAddressCity.getText().length() > 49){
            if((evt.getKeyCode() != KeyEvent.VK_ENTER) || (evt.getKeyCode() != KeyEvent.VK_TAB)){
                evt.consume();
            }
        }
    }//GEN-LAST:event_txtAddressCityKeyTyped

    private void txtHomeFloorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHomeFloorKeyTyped
        if(txtHomeFloor.getText().length() > 29){
            if((evt.getKeyCode() != KeyEvent.VK_ENTER) || (evt.getKeyCode() != KeyEvent.VK_TAB)){
                evt.consume();
            }
        }
    }//GEN-LAST:event_txtHomeFloorKeyTyped

    private void txtHomeNumberKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHomeNumberKeyTyped
        if(txtHomeNumber.getText().length() > 29){
            if((evt.getKeyCode() != KeyEvent.VK_ENTER) || (evt.getKeyCode() != KeyEvent.VK_TAB)){
                evt.consume();
            }
        }
    }//GEN-LAST:event_txtHomeNumberKeyTyped

    private void txtHomeBlockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHomeBlockKeyTyped
        if(txtHomeBlock.getText().length() > 29){
            if((evt.getKeyCode() != KeyEvent.VK_ENTER) || (evt.getKeyCode() != KeyEvent.VK_TAB)){
                evt.consume();
            }
        }
    }//GEN-LAST:event_txtHomeBlockKeyTyped

    private void txtCommentsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCommentsKeyTyped
        if(txtComments.getText().length() > 254){
            if((evt.getKeyCode() != KeyEvent.VK_ENTER) || (evt.getKeyCode() != KeyEvent.VK_TAB)){
                evt.consume();
            }
        }
    }//GEN-LAST:event_txtCommentsKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelAddressForm;
    private javax.swing.JPanel PanelAddressFormHeader;
    private javax.swing.JPanel PanelAddressList;
    private javax.swing.JPanel PanelAddressListHeader;
    private javax.swing.JPanel PanelFormAddress;
    private javax.swing.JPanel PanelListAddress;
    private javax.swing.JPanel PanelUser;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearchAddress;
    private javax.swing.JComboBox<String> cbbAddressCountry;
    private javax.swing.JComboBox<String> cbbAddressListFilter;
    private javax.swing.JComboBox<String> cbbAddressState;
    private javax.swing.JComboBox<String> cbbAddressType;
    private javax.swing.JComboBox<String> cbbAddressZone;
    private javax.swing.JComboBox<String> cbbHomeType;
    private javax.swing.JCheckBox cbkMainAddress;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblAddressCity;
    private javax.swing.JLabel lblAddressComplement;
    private javax.swing.JLabel lblAddressCountry;
    private javax.swing.JLabel lblAddressFormInformation;
    private javax.swing.JLabel lblAddressInformation;
    private javax.swing.JLabel lblAddressList;
    private javax.swing.JLabel lblAddressName;
    private javax.swing.JLabel lblAddressNameHeader;
    private javax.swing.JLabel lblAddressNumber;
    private javax.swing.JLabel lblAddressType;
    private javax.swing.JLabel lblAddressZone;
    private javax.swing.JLabel lblAdressState;
    private javax.swing.JLabel lblComments;
    private javax.swing.JLabel lblDash;
    private javax.swing.JLabel lblHomeBlock;
    private javax.swing.JLabel lblHomeFloor;
    private javax.swing.JLabel lblHomeNumber;
    private javax.swing.JLabel lblHomeType;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblInformation;
    private javax.swing.JLabel lblMainAddrFlg;
    private javax.swing.JLabel lblNeighborhood;
    private javax.swing.JLabel lblRecCount;
    private javax.swing.JLabel lblRowId;
    private javax.swing.JLabel lblSocialMedia;
    private javax.swing.JLabel lblZipcode;
    private javax.swing.JScrollPane sPanelAddressForm;
    private javax.swing.JScrollPane sPanelAddressList;
    private javax.swing.JTable tblAddressList;
    private javax.swing.JTextField txtAddressCity;
    private javax.swing.JTextField txtAddressComplement;
    private javax.swing.JTextField txtAddressListFilterValue;
    private javax.swing.JTextField txtAddressName;
    private javax.swing.JTextField txtAddressNumber;
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
