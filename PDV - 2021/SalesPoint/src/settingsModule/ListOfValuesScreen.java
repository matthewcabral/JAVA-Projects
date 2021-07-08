/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package settingsModule;

import static java.awt.Frame.MAXIMIZED_BOTH;
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
 * @author mathe
 */
public class ListOfValuesScreen extends javax.swing.JFrame {

    /**
     * Creates new form ListOfValuesScreen
     */
    public ListOfValuesScreen() {
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
    
    // Table
    public DefaultTableModel getTableModel(){ return (DefaultTableModel) tblLOVList.getModel(); }    
    public void setListenerTblLOVListSelection(ListSelectionListener listener) { this.tblLOVList.getSelectionModel().addListSelectionListener(listener); }
    public String getSelectedLOVListId() { try { return (String) this.tblLOVList.getValueAt(this.tblLOVList.getSelectedRow(), 0); } catch (Exception e) { return ""; } }
    public void setSelectedRowColumnList(int row, int column){ this.tblLOVList.changeSelection(row, column, false, false); }
    public int getSelectedRowList() { return this.tblLOVList.getSelectedRow(); }
    public int getNumOfListRows() { return this.tblLOVList.getRowCount(); }
    
    // Component Setters
    public void settxtLOVListFilterValue(String value) { this.txtLOVListFilterValue.setText(value); this.txtLOVListFilterValue.paintImmediately(this.txtLOVListFilterValue.getVisibleRect()); }
    public void settxtRowId(String value) { this.txtRowId.setText(value); this.txtRowId.paintImmediately(this.txtRowId.getVisibleRect()); }
    public void settxtLOVType(String value) { this.txtLOVType.setText(value); this.txtLOVType.paintImmediately(this.txtLOVType.getVisibleRect()); }
    public void settxtName(String value) { this.txtName.setText(value); this.txtName.paintImmediately(this.txtName.getVisibleRect()); }
    public void settxtValue(String value) { this.txtValue.setText(value); this.txtValue.paintImmediately(this.txtValue.getVisibleRect()); }
    public void settxtLanguage(String value) { this.txtLanguage.setText(value); this.txtLanguage.paintImmediately(this.txtLanguage.getVisibleRect()); }
    public void settxtOrder(String value) { this.txtOrder.setText(value); this.txtOrder.paintImmediately(this.txtOrder.getVisibleRect()); }
    public void settxtReplicationLevel(String value) { this.txtReplicationLevel.setText(value); this.txtReplicationLevel.paintImmediately(this.txtReplicationLevel.getVisibleRect()); }
    public void settxtCode(String value) { this.txtCode.setText(value); this.txtCode.paintImmediately(this.txtCode.getVisibleRect()); }
    public void settxtSubtype(String value) { this.txtSubtype.setText(value); this.txtSubtype.paintImmediately(this.txtSubtype.getVisibleRect()); }
    public void settxtDescription(String value) { this.txtDescription.setText(value); this.txtDescription.paintImmediately(this.txtDescription.getVisibleRect()); }
    
    public void setcbbUserListFilter(String value) { this.cbbLOVListFilter.addItem(value); this.cbbLOVListFilter.paintImmediately(this.cbbLOVListFilter.getVisibleRect()); }
    public void setckbActiveFlg(String value) { this.ckbActiveFlg.setSelected(("Y".equals(value))); this.ckbActiveFlg.paintImmediately(this.ckbActiveFlg.getVisibleRect()); }

    // ComboBox Specific Setters
    public void setcbbLOVListFilterItemIndex(int value) { this.cbbLOVListFilter.setSelectedIndex(value); }
    
    // Component Getters
    public String gettxtRowId() { return ((!"".equals(this.txtRowId.getText()) && this.txtRowId.getText() != null) ? this.txtRowId.getText() : null); }
    public String gettxtLOVType() { return ((!"".equals(this.txtLOVType.getText()) && this.txtLOVType.getText() != null) ? this.txtLOVType.getText() : null); }
    public String gettxtName() { return ((!"".equals(this.txtName.getText()) && this.txtName.getText() != null) ? this.txtName.getText() : null); }
    public String gettxtValue() { return ((!"".equals(this.txtValue.getText()) && this.txtValue.getText() != null) ? this.txtValue.getText() : null); }
    public String gettxtLanguage() { return ((!"".equals(this.txtLanguage.getText()) && this.txtLanguage.getText() != null) ? this.txtLanguage.getText() : null); }
    public String gettxtOrder() { return ((!"".equals(this.txtOrder.getText()) && this.txtOrder.getText() != null) ? this.txtOrder.getText() : null); }
    public String gettxtReplicationLevel() { return ((!"".equals(this.txtReplicationLevel.getText()) && this.txtReplicationLevel.getText() != null) ? this.txtReplicationLevel.getText() : null); }
    public String gettxtCode() { return ((!"".equals(this.txtCode.getText()) && this.txtCode.getText() != null) ? this.txtCode.getText() : null); }
    public String gettxtSubtype() { return ((!"".equals(this.txtSubtype.getText()) && this.txtSubtype.getText() != null) ? this.txtSubtype.getText() : null); }
    public String gettxtDescription() { return ((!"".equals(this.txtDescription.getText()) && this.txtDescription.getText() != null) ? this.txtDescription.getText() : null); }
    
    public String getcbbUserListFilter() { if(!"".equals(this.cbbLOVListFilter.getSelectedItem().toString()) && !"Selecione...".equals(this.cbbLOVListFilter.getSelectedItem().toString()) && this.cbbLOVListFilter.getSelectedItem().toString() != null) { return this.cbbLOVListFilter.getSelectedItem().toString(); } else { return null; } }
    public String getckbActiveFlg() { return (this.ckbActiveFlg.isSelected()) ? "Y" : "N"; }
    
    // ComboBox Specific Getters
    public int getcbbUserListFilterItemIndex(String value) { if(!"".equals(value) && value != null) { for(int i = 0; i < this.cbbLOVListFilter.getItemCount(); i++){ if(value.equals(this.cbbLOVListFilter.getItemAt(i))){ return i; }}} else { return 0; } return 0; }
    
    public String getlblRecCount() { return this.lblRecCount.getText(); }
    public String getlblLOVNameHeader() { return this.lblLOVNameHeader.getText(); }
    
    // Component Clear
    public void cleartxtLOVTypeListFilterValue() { this.txtLOVListFilterValue.setText(""); this.txtLOVListFilterValue.paintImmediately(this.txtLOVListFilterValue.getVisibleRect()); }
    public void cleartxtRowId() { this.txtRowId.setText(""); this.txtRowId.paintImmediately(this.txtRowId.getVisibleRect()); }
    public void cleartxtLOVType() { this.txtLOVType.setText(""); this.txtLOVType.paintImmediately(this.txtLOVType.getVisibleRect()); }
    public void cleartxtName() { this.txtName.setText(""); this.txtName.paintImmediately(this.txtName.getVisibleRect()); }
    public void cleartxtValue() { this.txtValue.setText(""); this.txtValue.paintImmediately(this.txtValue.getVisibleRect()); }
    public void cleartxtLanguage() { this.txtLanguage.setText(""); this.txtLanguage.paintImmediately(this.txtLanguage.getVisibleRect()); }
    public void cleartxtOrder() { this.txtOrder.setText(""); this.txtOrder.paintImmediately(this.txtOrder.getVisibleRect()); }
    public void cleartxtReplicationLevel() { this.txtReplicationLevel.setText(""); this.txtReplicationLevel.paintImmediately(this.txtReplicationLevel.getVisibleRect()); }
    public void cleartxtCode() { this.txtCode.setText(""); this.txtCode.paintImmediately(this.txtCode.getVisibleRect()); }
    public void cleartxtSubtype() { this.txtSubtype.setText(""); this.txtSubtype.paintImmediately(this.txtSubtype.getVisibleRect()); }
    public void cleartxtDescription() { this.txtDescription.setText(""); this.txtDescription.paintImmediately(this.txtDescription.getVisibleRect()); }
    
    public void clearcbbUserListFilter() { this.cbbLOVListFilter.removeAllItems(); this.cbbLOVListFilter.paintImmediately(this.cbbLOVListFilter.getVisibleRect()); }
    public void clearckbActiveFlg() { this.ckbActiveFlg.setSelected(false); this.ckbActiveFlg.paintImmediately(this.ckbActiveFlg.getVisibleRect()); }
    
    public void clearlblRecCount() { this.lblRecCount.setText(""); this.lblRecCount.paintImmediately(this.lblRecCount.getVisibleRect()); }
    public void clearlblLOVNameHeader() { this.lblLOVNameHeader.setText(""); this.lblLOVNameHeader.paintImmediately(this.lblLOVNameHeader.getVisibleRect()); }

    // Enable or Disable Components
    public void settxtLOVTypeListFilterValueEnabled(boolean status) { this.txtLOVListFilterValue.setEnabled(status); }
    public void settxtRowIdEnabled(boolean status) { this.txtRowId.setEnabled(status); }
    public void settxtLOVTypeEnabled(boolean status) { this.txtLOVType.setEnabled(status); }
    public void settxtNameEnabled(boolean status) { this.txtName.setEnabled(status); }
    public void settxtValueEnabled(boolean status) { this.txtValue.setEnabled(status); }
    public void settxtLanguageEnabled(boolean status) { this.txtLanguage.setEnabled(status); }
    public void settxtOrderEnabled(boolean status) { this.txtOrder.setEnabled(status); }
    public void settxtReplicationLevelEnabled(boolean status) { this.txtReplicationLevel.setEnabled(status); }
    public void settxtCodeEnabled(boolean status) { this.txtCode.setEnabled(status); }
    public void settxtSubtypeEnabled(boolean status) { this.txtSubtype.setEnabled(status); }
    public void settxtDescriptionEnabled(boolean status) { this.txtDescription.setEnabled(status); }
    
    public void setcbbUserListFilterEnabled(boolean status) { this.cbbLOVListFilter.setEnabled(status); }
    public void setckbActiveFlgEnabled(boolean status) { this.ckbActiveFlg.setEnabled(status); }
    
    public void setlblRecCountEnabled(boolean status) { this.lblRecCount.setEnabled(status); }
    public void setlblLOVNameHeaderEnabled(boolean status) { this.lblLOVNameHeader.setEnabled(status); }
    
    public void setTblEnabled(boolean status) { this.tblLOVList.setEnabled(status); }
    
    public void setbtnEditEnabled(boolean status) { this.btnEdit.setEnabled(status); }
    public void setbtnNewEnabled(boolean status) { this.btnNew.setEnabled(status); }
    public void setbtnSaveEnabled(boolean status) { this.btnSave.setEnabled(status); }
    public void setbtnDeleteEnabled(boolean status) { this.btnDelete.setEnabled(status); }
    public void setbtnCancelEnabled(boolean status) { this.btnCancel.setEnabled(status); }

    // Return componet status
    public boolean istxtLOVTypeListFilterValueEnabled() { return this.txtLOVListFilterValue.isEnabled(); }
    public boolean istxtRowIdEnabled() { return this.txtRowId.isEnabled(); }
    public boolean istxtLOVTypeEnabled() { return this.txtLOVType.isEnabled(); }
    public boolean istxtNameEnabled() { return this.txtName.isEnabled(); }
    public boolean istxtValueEnabled() { return this.txtValue.isEnabled(); }
    public boolean istxtLanguageEnabled() { return this.txtLanguage.isEnabled(); }
    public boolean istxtOrderEnabled() { return this.txtOrder.isEnabled(); }
    public boolean istxtReplicationLevelEnabled() { return this.txtReplicationLevel.isEnabled(); }
    public boolean istxtCodeEnabled() { return this.txtCode.isEnabled(); }
    public boolean istxtSubtypeEnabled() { return this.txtSubtype.isEnabled(); }
    public boolean istxtDescriptionEnabled() { return this.txtDescription.isEnabled(); }
    
    public boolean iscbbUserListFilterEnabled() { return this.cbbLOVListFilter.isEnabled(); }
    public boolean isckbActiveFlgEnabled() { return this.ckbActiveFlg.isEnabled(); }
    
    public boolean islblRecCountEnabled() { return this.lblRecCount.isEnabled(); }
    public boolean islblLOVNameHeaderEnabled() { return this.lblLOVNameHeader.isEnabled(); }
    
    public boolean isbtnEditEnabled() { return this.btnEdit.isEnabled(); }
    public boolean isbtnNewEnabled() { return this.btnNew.isEnabled(); }
    public boolean isbtnSaveEnabled() { return this.btnSave.isEnabled(); }
    public boolean isbtnCancelEnabled() { return this.btnCancel.isEnabled(); }
    public boolean isbtnDeleteEnabled() { return this.btnDelete.isEnabled(); }
    
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
            this.txtLOVListFilterValue.requestFocus();
            break;
        case "ID":
            this.txtRowId.requestFocus();
            break;
        case "TYPE":
            this.txtLOVType.requestFocus();
            break;
        case "NAME":
            this.txtName.requestFocus();
            break;
        case "VAL":
            this.txtValue.requestFocus();
            break;
        case "LANGUAGE":
            this.txtLanguage.requestFocus();
            break;
        case "ORDER":
            this.txtOrder.requestFocus();
            break;
        case "REPLICATION_LEVEL":
            this.txtReplicationLevel.requestFocus();
            break;
        case "CODE":
            this.txtCode.requestFocus();
            break;
        case "SUBTYPE":
            this.txtSubtype.requestFocus();
            break;
        case "DESCRIPTION":
            this.txtDescription.requestFocus();
            break;
        case "FILTRO":
            this.cbbLOVListFilter.requestFocus();
            break;
        case "ATIVO":
            this.ckbActiveFlg.requestFocus();
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
                settxtLOVTypeListFilterValueEnabled(true);
                settxtRowIdEnabled(false);
                settxtLOVTypeEnabled(false);
                settxtNameEnabled(false);
                settxtValueEnabled(false);
                settxtLanguageEnabled(false);
                settxtOrderEnabled(false);
                settxtReplicationLevelEnabled(false);
                settxtCodeEnabled(false);
                settxtSubtypeEnabled(false);
                settxtDescriptionEnabled(false);

                setcbbUserListFilterEnabled(true);
                setckbActiveFlgEnabled(false);
                
                setTblEnabled(true);

                setbtnEditEnabled(false);
                setbtnNewEnabled(true);
                setbtnSaveEnabled(false);
                setbtnDeleteEnabled(false);
                setbtnCancelEnabled(false);
                break;
            case "NOVO":
                settxtLOVTypeListFilterValueEnabled(true);
                settxtRowIdEnabled(false);
                settxtLOVTypeEnabled(true);
                settxtNameEnabled(true);
                settxtValueEnabled(true);
                settxtLanguageEnabled(true);
                settxtOrderEnabled(true);
                settxtReplicationLevelEnabled(true);
                settxtCodeEnabled(true);
                settxtSubtypeEnabled(true);
                settxtDescriptionEnabled(true);

                setcbbUserListFilterEnabled(true);
                setckbActiveFlgEnabled(true);

                setTblEnabled(false);
                
                setbtnEditEnabled(false);
                setbtnNewEnabled(false);
                setbtnSaveEnabled(true);
                setbtnCancelEnabled(true);
                setbtnDeleteEnabled(false);
                break;
            case "EDITAR":
                settxtLOVTypeListFilterValueEnabled(true);
                settxtRowIdEnabled(false);
                settxtLOVTypeEnabled(true);
                settxtNameEnabled(true);
                settxtValueEnabled(true);
                settxtLanguageEnabled(true);
                settxtOrderEnabled(true);
                settxtReplicationLevelEnabled(true);
                settxtCodeEnabled(true);
                settxtSubtypeEnabled(true);
                settxtDescriptionEnabled(true);

                setcbbUserListFilterEnabled(true);
                setckbActiveFlgEnabled(true);

                setTblEnabled(false);
                
                setbtnEditEnabled(false);
                setbtnDeleteEnabled(false);
                setbtnNewEnabled(false);
                setbtnSaveEnabled(true);
                setbtnCancelEnabled(true);
                break;
            case "CANCELAR":
                settxtLOVTypeListFilterValueEnabled(true);
                settxtRowIdEnabled(false);
                settxtLOVTypeEnabled(false);
                settxtNameEnabled(false);
                settxtValueEnabled(false);
                settxtLanguageEnabled(false);
                settxtOrderEnabled(false);
                settxtReplicationLevelEnabled(false);
                settxtCodeEnabled(false);
                settxtSubtypeEnabled(false);
                settxtDescriptionEnabled(false);

                setcbbUserListFilterEnabled(true);
                setckbActiveFlgEnabled(false);

                setTblEnabled(true);
                
                setbtnEditEnabled(true);
                setbtnDeleteEnabled(true);
                setbtnNewEnabled(true);
                setbtnSaveEnabled(false);
                setbtnCancelEnabled(false);
                break;
            case "DELETAR":
                settxtLOVTypeListFilterValueEnabled(true);
                settxtRowIdEnabled(false);
                settxtLOVTypeEnabled(false);
                settxtNameEnabled(false);
                settxtValueEnabled(false);
                settxtLanguageEnabled(false);
                settxtOrderEnabled(false);
                settxtReplicationLevelEnabled(false);
                settxtCodeEnabled(false);
                settxtSubtypeEnabled(false);
                settxtDescriptionEnabled(false);
                
                setcbbUserListFilterEnabled(true);                
                setckbActiveFlgEnabled(false);

                setTblEnabled(true);
                
                setbtnEditEnabled(true);
                setbtnDeleteEnabled(true);
                setbtnNewEnabled(true);
                setbtnSaveEnabled(false);
                setbtnCancelEnabled(false);
                break;
            case "SALVAR":
                settxtLOVTypeListFilterValueEnabled(true);
                settxtRowIdEnabled(false);
                settxtLOVTypeEnabled(false);
                settxtNameEnabled(false);
                settxtValueEnabled(false);
                settxtLanguageEnabled(false);
                settxtOrderEnabled(false);
                settxtReplicationLevelEnabled(false);
                settxtCodeEnabled(false);
                settxtSubtypeEnabled(false);
                settxtDescriptionEnabled(false);

                setcbbUserListFilterEnabled(true);
                setckbActiveFlgEnabled(false);

                setTblEnabled(true);
                
                setbtnEditEnabled(true);
                setbtnDeleteEnabled(true);
                setbtnNewEnabled(true);
                setbtnSaveEnabled(false);
                setbtnCancelEnabled(false);
                break;
            default:
                break;
	}	
    }

    public void clearFields() {
        cleartxtLOVTypeListFilterValue();
        cleartxtRowId();
        cleartxtLOVType();
        cleartxtName();
        cleartxtValue();
        cleartxtLanguage();
        cleartxtOrder();
        cleartxtReplicationLevel();
        cleartxtCode();
        cleartxtSubtype();
        cleartxtDescription();
        
        setcbbLOVListFilterItemIndex(0);        
        clearckbActiveFlg();
        
        clearlblLOVNameHeader();
    }
    
    public void clearComboBoxes(){
        clearcbbUserListFilter();
    }
    
    public void insertSelectComboBox(){
        this.setcbbUserListFilter("Selecione...");
    }
    
    public final void FocusTraversalKeys(){
        this.txtLOVListFilterValue.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtRowId.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtLOVType.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtName.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtValue.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtLanguage.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtOrder.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtReplicationLevel.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtCode.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtSubtype.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtDescription.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);

        this.cbbLOVListFilter.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.ckbActiveFlg.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        
        this.lblRecCount.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.lblLOVNameHeader.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelLOV = new javax.swing.JPanel();
        PanelLOVList = new javax.swing.JPanel();
        PanelLOVListHeader = new javax.swing.JPanel();
        lblLOVList = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblImage = new javax.swing.JLabel();
        cbbLOVListFilter = new javax.swing.JComboBox<>();
        txtLOVListFilterValue = new javax.swing.JTextField();
        lblInformation = new javax.swing.JLabel();
        lblRecCount = new javax.swing.JLabel();
        PanelListLOV = new javax.swing.JPanel();
        sPanelLOVList = new javax.swing.JScrollPane();
        tblLOVList = new javax.swing.JTable();
        PanelLOVForm = new javax.swing.JPanel();
        PanelLOVFormHeader = new javax.swing.JPanel();
        lblLOVNameHeader = new javax.swing.JLabel();
        lblUserFormInformation = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        btnEdit = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        sPanelLOVForm = new javax.swing.JScrollPane();
        PanelFormUser = new javax.swing.JPanel();
        lblRowId = new javax.swing.JLabel();
        txtRowId = new javax.swing.JTextField();
        lblLOVType = new javax.swing.JLabel();
        txtLOVType = new javax.swing.JTextField();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblValue = new javax.swing.JLabel();
        txtValue = new javax.swing.JTextField();
        lblLanguage = new javax.swing.JLabel();
        txtLanguage = new javax.swing.JTextField();
        lblOrder = new javax.swing.JLabel();
        txtOrder = new javax.swing.JTextField();
        lblActiveFlg = new javax.swing.JLabel();
        ckbActiveFlg = new javax.swing.JCheckBox();
        lblReplicationLevel = new javax.swing.JLabel();
        txtReplicationLevel = new javax.swing.JTextField();
        lblCode = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        lblSubtype = new javax.swing.JLabel();
        txtSubtype = new javax.swing.JTextField();
        lblDescription = new javax.swing.JLabel();
        txtDescription = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lista de Valores");

        PanelLOV.setBackground(new java.awt.Color(255, 255, 255));
        PanelLOV.setPreferredSize(new java.awt.Dimension(1366, 757));

        lblLOVList.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        lblLOVList.setText("Lista de Valores");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        lblImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/20px/Lupa 20x20.png"))); // NOI18N

        cbbLOVListFilter.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        cbbLOVListFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbLOVListFilter.setMaximumSize(new java.awt.Dimension(250, 32767));
        cbbLOVListFilter.setPreferredSize(new java.awt.Dimension(250, 23));
        cbbLOVListFilter.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbLOVListFilterItemStateChanged(evt);
            }
        });

        txtLOVListFilterValue.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtLOVListFilterValue.setToolTipText("");
        txtLOVListFilterValue.setMaximumSize(new java.awt.Dimension(250, 2147483647));
        txtLOVListFilterValue.setPreferredSize(new java.awt.Dimension(250, 23));

        lblInformation.setBackground(new java.awt.Color(255, 255, 255));
        lblInformation.setText("Pressione Enter para pesquisar");
        lblInformation.setEnabled(false);

        lblRecCount.setBackground(new java.awt.Color(255, 255, 255));
        lblRecCount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblRecCount.setText("Total de Registros: 100");
        lblRecCount.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblRecCount.setMaximumSize(new java.awt.Dimension(410, 14));

        javax.swing.GroupLayout PanelLOVListHeaderLayout = new javax.swing.GroupLayout(PanelLOVListHeader);
        PanelLOVListHeader.setLayout(PanelLOVListHeaderLayout);
        PanelLOVListHeaderLayout.setHorizontalGroup(
            PanelLOVListHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLOVListHeaderLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(lblLOVList)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblImage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbbLOVListFilter, 0, 297, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLOVListFilterValue, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInformation)
                .addGap(59, 59, 59)
                .addComponent(lblRecCount, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                .addContainerGap())
        );
        PanelLOVListHeaderLayout.setVerticalGroup(
            PanelLOVListHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLOVListHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelLOVListHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbbLOVListFilter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblLOVList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addComponent(lblImage, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblRecCount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblInformation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtLOVListFilterValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        sPanelLOVList.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        sPanelLOVList.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        sPanelLOVList.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N

        tblLOVList.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        tblLOVList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Tipo", "Nome", "Exibir Valor", "Idioma", "Ordem", "Ativo", "Nível de Replicação", "Codigo", "Subtipo", "Descrição"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblLOVList.setGridColor(new java.awt.Color(204, 204, 204));
        tblLOVList.setRowHeight(22);
        tblLOVList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        sPanelLOVList.setViewportView(tblLOVList);

        javax.swing.GroupLayout PanelListLOVLayout = new javax.swing.GroupLayout(PanelListLOV);
        PanelListLOV.setLayout(PanelListLOVLayout);
        PanelListLOVLayout.setHorizontalGroup(
            PanelListLOVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sPanelLOVList)
        );
        PanelListLOVLayout.setVerticalGroup(
            PanelListLOVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sPanelLOVList, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PanelLOVListLayout = new javax.swing.GroupLayout(PanelLOVList);
        PanelLOVList.setLayout(PanelLOVListLayout);
        PanelLOVListLayout.setHorizontalGroup(
            PanelLOVListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLOVListLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelLOVListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelListLOV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelLOVListHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        PanelLOVListLayout.setVerticalGroup(
            PanelLOVListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLOVListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelLOVListHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelListLOV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        lblLOVNameHeader.setBackground(new java.awt.Color(255, 255, 255));
        lblLOVNameHeader.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        lblLOVNameHeader.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLOVNameHeader.setToolTipText("");
        lblLOVNameHeader.setMinimumSize(new java.awt.Dimension(0, 30));

        lblUserFormInformation.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblUserFormInformation.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblUserFormInformation.setText("Campos Obrigatórios (*)");
        lblUserFormInformation.setEnabled(false);

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btnEdit.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/20px/edit 20x20.png"))); // NOI18N
        btnEdit.setToolTipText("Editar");
        btnEdit.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
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
        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/20px/new 20x20.png"))); // NOI18N
        btnNew.setToolTipText("Novo");
        btnNew.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
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
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/20px/save 20x20.png"))); // NOI18N
        btnSave.setToolTipText("Salvar");
        btnSave.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnSave.setEnabled(false);
        btnSave.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnSave.setIconTextGap(3);
        btnSave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnSaveKeyPressed(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/20px/cancel 20x20.png"))); // NOI18N
        btnCancel.setToolTipText("Cancelar");
        btnCancel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
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
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/20px/delete 20x20.png"))); // NOI18N
        btnDelete.setToolTipText("Excluir");
        btnDelete.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnDelete.setBorderPainted(false);
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDelete.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnDelete.setIconTextGap(3);
        btnDelete.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnDeleteKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout PanelLOVFormHeaderLayout = new javax.swing.GroupLayout(PanelLOVFormHeader);
        PanelLOVFormHeader.setLayout(PanelLOVFormHeaderLayout);
        PanelLOVFormHeaderLayout.setHorizontalGroup(
            PanelLOVFormHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLOVFormHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLOVNameHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUserFormInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
        PanelLOVFormHeaderLayout.setVerticalGroup(
            PanelLOVFormHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLOVFormHeaderLayout.createSequentialGroup()
                .addGroup(PanelLOVFormHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblUserFormInformation, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblLOVNameHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        sPanelLOVForm.setBorder(null);
        sPanelLOVForm.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        sPanelLOVForm.setMinimumSize(new java.awt.Dimension(0, 0));
        sPanelLOVForm.setPreferredSize(new java.awt.Dimension(2000, 607));

        PanelFormUser.setBackground(new java.awt.Color(255, 255, 255));
        PanelFormUser.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        PanelFormUser.setPreferredSize(new java.awt.Dimension(1427, 80));

        lblRowId.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblRowId.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblRowId.setText("Id:");
        lblRowId.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        lblRowId.setEnabled(false);
        lblRowId.setOpaque(true);

        txtRowId.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtRowId.setText("jTextField1");
        txtRowId.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.background")), javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5)));
        txtRowId.setEnabled(false);

        lblLOVType.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblLOVType.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLOVType.setText("Tipo*:");
        lblLOVType.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        lblLOVType.setEnabled(false);
        lblLOVType.setOpaque(true);

        txtLOVType.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtLOVType.setText("jTextField1");
        txtLOVType.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.background")), javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5)));
        txtLOVType.setEnabled(false);
        txtLOVType.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLOVTypeKeyPressed(evt);
            }
        });

        lblName.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblName.setText("Nome*:");
        lblName.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        lblName.setEnabled(false);
        lblName.setOpaque(true);

        txtName.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtName.setText("jTextField1");
        txtName.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.background")), javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5)));
        txtName.setEnabled(false);
        txtName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNameKeyPressed(evt);
            }
        });

        lblValue.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblValue.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblValue.setText("Exibir Valor*:");
        lblValue.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        lblValue.setEnabled(false);
        lblValue.setOpaque(true);

        txtValue.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtValue.setText("jTextField1");
        txtValue.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.background")), javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5)));
        txtValue.setEnabled(false);
        txtValue.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtValueKeyPressed(evt);
            }
        });

        lblLanguage.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblLanguage.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLanguage.setText("Idioma*:");
        lblLanguage.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        lblLanguage.setEnabled(false);
        lblLanguage.setOpaque(true);

        txtLanguage.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtLanguage.setText("jTextField1");
        txtLanguage.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.background")), javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5)));
        txtLanguage.setEnabled(false);
        txtLanguage.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLanguageKeyPressed(evt);
            }
        });

        lblOrder.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblOrder.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblOrder.setText("Ordem:");
        lblOrder.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        lblOrder.setEnabled(false);
        lblOrder.setOpaque(true);

        txtOrder.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtOrder.setText("jTextField1");
        txtOrder.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.background")), javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5)));
        txtOrder.setEnabled(false);
        txtOrder.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtOrderKeyPressed(evt);
            }
        });

        lblActiveFlg.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblActiveFlg.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblActiveFlg.setText("Ativo:");
        lblActiveFlg.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        lblActiveFlg.setEnabled(false);
        lblActiveFlg.setOpaque(true);

        ckbActiveFlg.setBackground(new java.awt.Color(255, 255, 255));
        ckbActiveFlg.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        ckbActiveFlg.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        ckbActiveFlg.setBorderPainted(true);
        ckbActiveFlg.setEnabled(false);
        ckbActiveFlg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ckbActiveFlg.setMaximumSize(new java.awt.Dimension(165, 21));
        ckbActiveFlg.setPreferredSize(new java.awt.Dimension(165, 21));
        ckbActiveFlg.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ckbActiveFlgItemStateChanged(evt);
            }
        });
        ckbActiveFlg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ckbActiveFlgKeyPressed(evt);
            }
        });

        lblReplicationLevel.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblReplicationLevel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblReplicationLevel.setText("Nível de Replicação:");
        lblReplicationLevel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        lblReplicationLevel.setEnabled(false);
        lblReplicationLevel.setOpaque(true);

        txtReplicationLevel.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtReplicationLevel.setText("jTextField1");
        txtReplicationLevel.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.background")), javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5)));
        txtReplicationLevel.setEnabled(false);
        txtReplicationLevel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtReplicationLevelKeyPressed(evt);
            }
        });

        lblCode.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblCode.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCode.setText("Código:");
        lblCode.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        lblCode.setEnabled(false);
        lblCode.setOpaque(true);

        txtCode.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtCode.setText("jTextField1");
        txtCode.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.background")), javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5)));
        txtCode.setEnabled(false);
        txtCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodeKeyPressed(evt);
            }
        });

        lblSubtype.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblSubtype.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblSubtype.setText("Subtipo:");
        lblSubtype.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        lblSubtype.setEnabled(false);
        lblSubtype.setOpaque(true);

        txtSubtype.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtSubtype.setText("jTextField1");
        txtSubtype.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.background")), javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5)));
        txtSubtype.setEnabled(false);
        txtSubtype.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSubtypeKeyPressed(evt);
            }
        });

        lblDescription.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblDescription.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblDescription.setText("Descrição:");
        lblDescription.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        lblDescription.setEnabled(false);
        lblDescription.setOpaque(true);

        txtDescription.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtDescription.setText("jTextField1");
        txtDescription.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.background")), javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5)));
        txtDescription.setEnabled(false);
        txtDescription.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDescriptionKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout PanelFormUserLayout = new javax.swing.GroupLayout(PanelFormUser);
        PanelFormUser.setLayout(PanelFormUserLayout);
        PanelFormUserLayout.setHorizontalGroup(
            PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFormUserLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtRowId, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRowId, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblLOVType, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLOVType, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelFormUserLayout.createSequentialGroup()
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtValue, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelFormUserLayout.createSequentialGroup()
                        .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblValue, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblActiveFlg, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ckbActiveFlg, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtReplicationLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblReplicationLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCode, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSubtype, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSubtype, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelFormUserLayout.setVerticalGroup(
            PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFormUserLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelFormUserLayout.createSequentialGroup()
                        .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblReplicationLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCode, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSubtype, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtReplicationLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSubtype, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PanelFormUserLayout.createSequentialGroup()
                        .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PanelFormUserLayout.createSequentialGroup()
                        .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblRowId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblLOVType, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblValue, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtRowId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLOVType, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtValue, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PanelFormUserLayout.createSequentialGroup()
                        .addComponent(lblActiveFlg, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ckbActiveFlg, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        sPanelLOVForm.setViewportView(PanelFormUser);

        javax.swing.GroupLayout PanelLOVFormLayout = new javax.swing.GroupLayout(PanelLOVForm);
        PanelLOVForm.setLayout(PanelLOVFormLayout);
        PanelLOVFormLayout.setHorizontalGroup(
            PanelLOVFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLOVFormLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sPanelLOVForm, javax.swing.GroupLayout.DEFAULT_SIZE, 1189, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(PanelLOVFormHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelLOVFormLayout.setVerticalGroup(
            PanelLOVFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLOVFormLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelLOVFormHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sPanelLOVForm, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PanelLOVLayout = new javax.swing.GroupLayout(PanelLOV);
        PanelLOV.setLayout(PanelLOVLayout);
        PanelLOVLayout.setHorizontalGroup(
            PanelLOVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelLOVList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelLOVForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelLOVLayout.setVerticalGroup(
            PanelLOVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLOVLayout.createSequentialGroup()
                .addComponent(PanelLOVList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelLOVForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelLOV, javax.swing.GroupLayout.DEFAULT_SIZE, 1209, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelLOV, javax.swing.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbbLOVListFilterItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbLOVListFilterItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            setFocus("FILTRO_VALOR");
        }
    }//GEN-LAST:event_cbbLOVListFilterItemStateChanged

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

    private void txtLOVTypeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLOVTypeKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_TAB){
            setFocus("SENHA");
        }
    }//GEN-LAST:event_txtLOVTypeKeyPressed

    private void txtLanguageKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLanguageKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("RESPOSTA_SEG_1");
        }
    }//GEN-LAST:event_txtLanguageKeyPressed

    private void txtOrderKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOrderKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("PERGUNTA_SEG_2");
        }
    }//GEN-LAST:event_txtOrderKeyPressed

    private void txtReplicationLevelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtReplicationLevelKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("RESPOSTA_SEG_2");
        }
    }//GEN-LAST:event_txtReplicationLevelKeyPressed

    private void txtCodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodeKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("PERGUNTA_SEG_3");
        }
    }//GEN-LAST:event_txtCodeKeyPressed

    private void txtSubtypeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSubtypeKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("RESPOSTA_SEG_3");
        }
    }//GEN-LAST:event_txtSubtypeKeyPressed

    private void txtDescriptionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescriptionKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            /*if(this.iscbbDocTypeEnabled()){
                setFocus("DOCUMENTO_TIPO");
            }*/
        }
    }//GEN-LAST:event_txtDescriptionKeyPressed

    private void ckbActiveFlgItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ckbActiveFlgItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            setFocus("WHATSAPP_FLG");
        }
    }//GEN-LAST:event_ckbActiveFlgItemStateChanged

    private void ckbActiveFlgKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ckbActiveFlgKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("WHATSAPP_FLG");
        }
    }//GEN-LAST:event_ckbActiveFlgKeyPressed

    private void txtNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameKeyPressed

    private void txtValueKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValueKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValueKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListOfValuesScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListOfValuesScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListOfValuesScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListOfValuesScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListOfValuesScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelFormUser;
    private javax.swing.JPanel PanelLOV;
    private javax.swing.JPanel PanelLOVForm;
    private javax.swing.JPanel PanelLOVFormHeader;
    private javax.swing.JPanel PanelLOVList;
    private javax.swing.JPanel PanelLOVListHeader;
    private javax.swing.JPanel PanelListLOV;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cbbLOVListFilter;
    private javax.swing.JCheckBox ckbActiveFlg;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblActiveFlg;
    private javax.swing.JLabel lblCode;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblInformation;
    private javax.swing.JLabel lblLOVList;
    private javax.swing.JLabel lblLOVNameHeader;
    private javax.swing.JLabel lblLOVType;
    private javax.swing.JLabel lblLanguage;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblOrder;
    private javax.swing.JLabel lblRecCount;
    private javax.swing.JLabel lblReplicationLevel;
    private javax.swing.JLabel lblRowId;
    private javax.swing.JLabel lblSubtype;
    private javax.swing.JLabel lblUserFormInformation;
    private javax.swing.JLabel lblValue;
    private javax.swing.JScrollPane sPanelLOVForm;
    private javax.swing.JScrollPane sPanelLOVList;
    private javax.swing.JTable tblLOVList;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtLOVListFilterValue;
    private javax.swing.JTextField txtLOVType;
    private javax.swing.JTextField txtLanguage;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtOrder;
    private javax.swing.JTextField txtReplicationLevel;
    private javax.swing.JTextField txtRowId;
    private javax.swing.JTextField txtSubtype;
    private javax.swing.JTextField txtValue;
    // End of variables declaration//GEN-END:variables
}
