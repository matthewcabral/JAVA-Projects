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
public class UserPositionScreen extends javax.swing.JFrame {

    /**
     * Creates new form ListOfValuesScreen
     */
    public UserPositionScreen() {
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
    public void setListenerBtnQuery(ActionListener listener) { this.btnQuery.addActionListener(listener); }
    public void setListenerBtnGoQuery(ActionListener listener) { this.btnGoQuery.addActionListener(listener); }
    
    public void setListenercbbListFilterValue(ItemListener listener) { this.cbbListFilter.addItemListener(listener); }
    public void setListenertxtListFilterValue(KeyListener listener) { this.txtListFilterValue.addKeyListener(listener); }
    public void setListenertxtOrder(KeyListener listener) { this.txtOrder.addKeyListener(listener); }
    
    // Table
    public DefaultTableModel getTableModel(){ return (DefaultTableModel) tblListPos.getModel(); }    
    public void setListenerTblListSelection(ListSelectionListener listener) { this.tblListPos.getSelectionModel().addListSelectionListener(listener); }
    public void setSelectedRowColumnList(int row, int column){ this.tblListPos.changeSelection(row, column, false, false); }
    public void unselectRowList() { try { this.tblListPos.removeRowSelectionInterval(this.getSelectedRowList(), this.getSelectedRowList()); } catch (Exception e) {} }
    public void removeRowFromList(int row) { try { this.getTableModel().removeRow(row); } catch (Exception e) {} this.tblListPos.paintImmediately(this.tblListPos.getVisibleRect()); }
    public void setListRowCount(int count) { this.getTableModel().setRowCount(count); this.tblListPos.paintImmediately(this.tblListPos.getVisibleRect()); }
    public int getSelectedRowList() { return this.tblListPos.getSelectedRow(); }
    public int getNumOfListRows() { return this.tblListPos.getRowCount(); }
    
    // Component Setters
    public void settxtListFilterValue(String value) { this.txtListFilterValue.setText(value); this.txtListFilterValue.paintImmediately(this.txtListFilterValue.getVisibleRect()); }
    public void settxtRowId(String value) { this.txtRowId.setText(value); this.txtRowId.paintImmediately(this.txtRowId.getVisibleRect()); }
    public void settxtCode(String value) { this.txtCode.setText(value); this.txtCode.paintImmediately(this.txtCode.getVisibleRect()); }
    public void settxtName(String value) { this.txtName.setText(value); this.txtName.paintImmediately(this.txtName.getVisibleRect()); }
    public void settxtValue(String value) { this.txtValue.setText(value); this.txtValue.paintImmediately(this.txtValue.getVisibleRect()); }    
    public void settxtOrder(String value) { this.txtOrder.setText(value); this.txtOrder.paintImmediately(this.txtOrder.getVisibleRect()); }
    public void setcbbListFilter(String value) { this.cbbListFilter.addItem(value); this.cbbListFilter.paintImmediately(this.cbbListFilter.getVisibleRect()); }
    public void setlblLOVNameHeader(String value) { this.lblFormNameHeader.setText(value); this.lblFormNameHeader.paintImmediately(this.lblFormNameHeader.getVisibleRect()); }
    public void setlblRecCount(String value) { this.lblRecCountPerm.setText("Registros: " + value); this.lblRecCountPerm.paintImmediately(this.lblRecCountPerm.getVisibleRect()); }
    // ComboBox Specific Setters
    public void setcbbListFilterItemIndex(int value) { this.cbbListFilter.setSelectedIndex(value); }
    
    // Component Getters
    public String gettxtListFilterValue() { return ((!"".equals(this.txtListFilterValue.getText()) && this.txtListFilterValue.getText() != null) ? this.txtListFilterValue.getText() : null); }
    public String gettxtRowId() { return ((!"".equals(this.txtRowId.getText()) && this.txtRowId.getText() != null) ? this.txtRowId.getText() : null); }
    public String gettxtCode() { return ((!"".equals(this.txtCode.getText()) && this.txtCode.getText() != null) ? this.txtCode.getText() : null); }
    public String gettxtName() { return ((!"".equals(this.txtName.getText()) && this.txtName.getText() != null) ? this.txtName.getText() : null); }
    public String gettxtOrder() { return ((!"".equals(this.txtOrder.getText()) && this.txtOrder.getText() != null) ? this.txtOrder.getText() : null); }
    public String gettxtValue() { return ((!"".equals(this.txtValue.getText()) && this.txtValue.getText() != null) ? this.txtValue.getText() : null); }
    
    public String getcbbListFilter() { return ((!"".equals(this.cbbListFilter.getSelectedItem().toString()) && !"Selecione...".equals(this.cbbListFilter.getSelectedItem().toString()) && this.cbbListFilter.getSelectedItem().toString() != null) ? this.cbbListFilter.getSelectedItem().toString() : null); }
    // ComboBox Specific Getters
    public int getcbbListFilterItemIndex(String value) { if(!"".equals(value) && value != null) { for(int i = 0; i < this.cbbListFilter.getItemCount(); i++){ if(value.equals(this.cbbListFilter.getItemAt(i))){ return i; }}} else { return 0; } return 0; }
    
    public String getlblRecCount() { return this.lblRecCountPerm.getText(); }
    public String getlblLOVNameHeader() { return this.lblFormNameHeader.getText(); }
    
    // Component Clear
    public void cleartxtListFilterValue() { this.txtListFilterValue.setText(""); this.txtListFilterValue.paintImmediately(this.txtListFilterValue.getVisibleRect()); }
    public void cleartxtRowId() { this.txtRowId.setText(""); this.txtRowId.paintImmediately(this.txtRowId.getVisibleRect()); }
    public void cleartxtCode() { this.txtCode.setText(""); this.txtCode.paintImmediately(this.txtCode.getVisibleRect()); }    
    public void cleartxtName() { this.txtName.setText(""); this.txtName.paintImmediately(this.txtName.getVisibleRect()); }
    public void cleartxtValue() { this.txtValue.setText(""); this.txtValue.paintImmediately(this.txtValue.getVisibleRect()); }
    public void cleartxtOrder() { this.txtOrder.setText(""); this.txtOrder.paintImmediately(this.txtOrder.getVisibleRect()); }
    public void clearcbbListFilter() { this.cbbListFilter.removeAllItems(); this.cbbListFilter.paintImmediately(this.cbbListFilter.getVisibleRect()); }
    public void clearlblRecCount() { this.lblRecCountPerm.setText(""); this.lblRecCountPerm.paintImmediately(this.lblRecCountPerm.getVisibleRect()); }
    public void clearlblLOVNameHeader() { this.lblFormNameHeader.setText(""); this.lblFormNameHeader.paintImmediately(this.lblFormNameHeader.getVisibleRect()); }

    // Enable or Disable Components
    public void settxtLOVTypeListFilterValueEnabled(boolean status) { this.txtListFilterValue.setEnabled(status); }
    public void settxtRowIdEnabled(boolean status) { this.txtRowId.setEnabled(status); }    
    public void settxtCodeEnabled(boolean status) { this.txtCode.setEnabled(status); }
    public void settxtNameEnabled(boolean status) { this.txtName.setEnabled(status); }
    public void settxtValueEnabled(boolean status) { this.txtValue.setEnabled(status); }
    public void settxtOrderEnabled(boolean status) { this.txtOrder.setEnabled(status); }
    public void setcbbListFilterEnabled(boolean status) { this.cbbListFilter.setEnabled(status); }    
    public void setlblRecCountEnabled(boolean status) { this.lblRecCountPerm.setEnabled(status); }
    public void setlblLOVNameHeaderEnabled(boolean status) { this.lblFormNameHeader.setEnabled(status); }
    
    public void setTblEnabled(boolean status) { this.tblListPos.setEnabled(status); }
    
    public void setbtnEditEnabled(boolean status) { this.btnEdit.setEnabled(status); }
    public void setbtnNewEnabled(boolean status) { this.btnNew.setEnabled(status); }
    public void setbtnSaveEnabled(boolean status) { this.btnSave.setEnabled(status); }
    public void setbtnDeleteEnabled(boolean status) { this.btnDelete.setEnabled(status); }
    public void setbtnQueryEnabled(boolean status) { this.btnQuery.setEnabled(status); }
    public void setbtnGoQueryEnabled(boolean status) { this.btnGoQuery.setEnabled(status); }
    public void setbtnCancelEnabled(boolean status) { this.btnCancel.setEnabled(status); }

    // Return componet status
    public boolean istxtLOVTypeListFilterValueEnabled() { return this.txtListFilterValue.isEnabled(); }
    public boolean istxtRowIdEnabled() { return this.txtRowId.isEnabled(); }
    public boolean istxtCodeEnabled() { return this.txtCode.isEnabled(); }
    public boolean istxtNameEnabled() { return this.txtName.isEnabled(); }
    public boolean istxtValueEnabled() { return this.txtValue.isEnabled(); }
    public boolean istxtOrderEnabled() { return this.txtOrder.isEnabled(); }
    public boolean iscbbListFilterEnabled() { return this.cbbListFilter.isEnabled(); }
    public boolean islblRecCountEnabled() { return this.lblRecCountPerm.isEnabled(); }
    public boolean islblLOVNameHeaderEnabled() { return this.lblFormNameHeader.isEnabled(); }
    
    public boolean isbtnEditEnabled() { return this.btnEdit.isEnabled(); }
    public boolean isbtnNewEnabled() { return this.btnNew.isEnabled(); }
    public boolean isbtnSaveEnabled() { return this.btnSave.isEnabled(); }
    public boolean isbtnCancelEnabled() { return this.btnCancel.isEnabled(); }
    public boolean isbtnDeleteEnabled() { return this.btnDelete.isEnabled(); }
    public boolean isbtnQueryEnabled() { return this.btnQuery.isEnabled(); }
    public boolean isbtnGoQueryEnabled() { return this.btnGoQuery.isEnabled(); }
    
    // Button Functions
    public void clickSave(){ this.btnSave.setEnabled(true); this.btnSave.doClick(); this.btnSave.setEnabled(false); }
    public void clickNew(){ this.btnNew.setEnabled(true); this.btnNew.doClick(); this.btnNew.setEnabled(false); }
    public void clickEdit(){ this.btnEdit.setEnabled(true); this.btnEdit.doClick(); this.btnEdit.setEnabled(false); }
    public void clickCancel(){ this.btnCancel.setEnabled(true); this.btnCancel.doClick(); this.btnCancel.setEnabled(false); }
    public void clickDelete(){ this.btnDelete.setEnabled(true); this.btnDelete.doClick(); this.btnDelete.setEnabled(false); }
    public void clickQuery(){ this.btnQuery.setEnabled(true); this.btnQuery.doClick(); this.btnQuery.setEnabled(false); }
    public void clickGoQuery(){ this.btnGoQuery.setEnabled(true); this.btnGoQuery.doClick(); this.btnGoQuery.setEnabled(false); }
    
    // Set Focus on Specific component
    public void setFocus(String component) {
        switch (component) {
        case "FILTRO_VALOR":
            this.txtListFilterValue.requestFocus();
            break;
        case "ID":
            this.txtRowId.requestFocus();
            break;
        case "CODE":
            this.txtCode.requestFocus();
            break;
        case "NAME":
            this.txtName.requestFocus();
            break;
        case "VAL":
            this.txtValue.requestFocus();
            break;
        case "ORDER":
            this.txtOrder.requestFocus();
            break;
        case "FILTRO":
            this.cbbListFilter.requestFocus();
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
        case "BOTAO_QUERY":
            this.btnQuery.requestFocus();
            break;
        case "BOTAO_GO_QUERY":
            this.btnGoQuery.requestFocus();
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
                settxtCodeEnabled(false);
                settxtNameEnabled(false);
                settxtValueEnabled(false);
                settxtOrderEnabled(false);

                setcbbListFilterEnabled(true);                
                setTblEnabled(true);

                setbtnEditEnabled(false);
                setbtnNewEnabled(true);
                setbtnSaveEnabled(false);
                setbtnDeleteEnabled(false);
                setbtnCancelEnabled(false);
                setbtnQueryEnabled(true);
                setbtnGoQueryEnabled(false);
                break;
            case "NOVO":
                settxtLOVTypeListFilterValueEnabled(true);
                settxtRowIdEnabled(false);
                settxtCodeEnabled(true);
                settxtNameEnabled(true);
                settxtValueEnabled(true);
                settxtOrderEnabled(true);

                setcbbListFilterEnabled(true);
                setTblEnabled(false);
                
                setbtnEditEnabled(false);
                setbtnNewEnabled(false);
                setbtnSaveEnabled(true);
                setbtnCancelEnabled(true);
                setbtnDeleteEnabled(false);
                setbtnQueryEnabled(false);
                setbtnGoQueryEnabled(false);
                break;
            case "EDITAR":
                settxtLOVTypeListFilterValueEnabled(true);
                settxtRowIdEnabled(false);
                settxtCodeEnabled(true);
                settxtNameEnabled(true);
                settxtValueEnabled(true);
                settxtOrderEnabled(true);
                
                setcbbListFilterEnabled(true);
                setTblEnabled(false);
                
                setbtnEditEnabled(false);
                setbtnDeleteEnabled(false);
                setbtnNewEnabled(false);
                setbtnSaveEnabled(true);
                setbtnCancelEnabled(true);
                setbtnQueryEnabled(false);
                setbtnGoQueryEnabled(false);
                break;
            case "CANCELAR":
                settxtLOVTypeListFilterValueEnabled(true);
                settxtRowIdEnabled(false);
                settxtCodeEnabled(false);
                settxtNameEnabled(false);
                settxtValueEnabled(false);
                settxtOrderEnabled(false);
                
                setcbbListFilterEnabled(true);
                setTblEnabled(true);
                
                setbtnEditEnabled(true);
                setbtnDeleteEnabled(false);
                setbtnNewEnabled(true);
                setbtnSaveEnabled(false);
                setbtnCancelEnabled(false);
                setbtnQueryEnabled(true);
                setbtnGoQueryEnabled(false);
                break;
            case "DELETAR":
                settxtLOVTypeListFilterValueEnabled(true);
                settxtRowIdEnabled(false);
                settxtCodeEnabled(false);
                settxtNameEnabled(false);
                settxtValueEnabled(false);
                settxtOrderEnabled(false);
                
                setcbbListFilterEnabled(true);
                setTblEnabled(true);
                
                setbtnEditEnabled(true);
                setbtnDeleteEnabled(true);
                setbtnNewEnabled(true);
                setbtnSaveEnabled(false);
                setbtnCancelEnabled(false);
                setbtnQueryEnabled(true);
                setbtnGoQueryEnabled(false);
                break;
            case "SALVAR":
                settxtLOVTypeListFilterValueEnabled(true);
                settxtRowIdEnabled(false);
                settxtCodeEnabled(false);
                settxtNameEnabled(false);
                settxtValueEnabled(false);
                settxtOrderEnabled(false);

                setcbbListFilterEnabled(true);
                setTblEnabled(true);
                
                setbtnEditEnabled(true);
                setbtnDeleteEnabled(true);
                setbtnNewEnabled(true);
                setbtnSaveEnabled(false);
                setbtnCancelEnabled(false);
                setbtnQueryEnabled(true);
                setbtnGoQueryEnabled(false);
                break;
            case "QUERY":
                settxtLOVTypeListFilterValueEnabled(false);
                settxtRowIdEnabled(true);
                settxtCodeEnabled(true);
                settxtNameEnabled(true);
                settxtValueEnabled(true);
                settxtOrderEnabled(true);

                setcbbListFilterEnabled(false);
                setTblEnabled(false);
                
                setbtnEditEnabled(false);
                setbtnDeleteEnabled(false);
                setbtnNewEnabled(false);
                setbtnSaveEnabled(false);
                setbtnCancelEnabled(true);
                setbtnQueryEnabled(false);
                setbtnGoQueryEnabled(true);
                break;
            case "GO_QUERY":
                settxtLOVTypeListFilterValueEnabled(true);
                settxtRowIdEnabled(false);
                settxtCodeEnabled(false);
                settxtNameEnabled(false);
                settxtValueEnabled(false);
                settxtOrderEnabled(false);
                
                setcbbListFilterEnabled(true);
                setTblEnabled(true);
                
                setbtnEditEnabled(true);
                setbtnDeleteEnabled(true);
                setbtnNewEnabled(true);
                setbtnSaveEnabled(false);
                setbtnCancelEnabled(false);
                setbtnQueryEnabled(true);
                setbtnGoQueryEnabled(false);
                break;
            default:
                break;
	}	
    }

    public void clearFields() {
        cleartxtRowId();
        cleartxtCode();
        cleartxtName();
        cleartxtValue();
        cleartxtOrder();
        
        clearlblLOVNameHeader();
    }
    
    public void clearFilters() {
        setcbbListFilterItemIndex(0);
        cleartxtListFilterValue();
    }
    
    public void clearComboBoxes(){
        clearcbbListFilter();
    }
    
    public void insertSelectComboBox(){
        this.setcbbListFilter("Selecione...");
    }
    
    public final void FocusTraversalKeys(){
        this.txtListFilterValue.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtRowId.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtName.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtValue.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtCode.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtOrder.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.cbbListFilter.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.lblRecCountPerm.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.lblFormNameHeader.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
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
        PanelListPermition = new javax.swing.JPanel();
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
        lblRecCountPos1 = new javax.swing.JLabel();
        PanelListPos1 = new javax.swing.JPanel();
        sPanelListPos1 = new javax.swing.JScrollPane();
        tblListPos1 = new javax.swing.JTable();
        MainPanelForm = new javax.swing.JPanel();
        PanelFormHeader = new javax.swing.JPanel();
        lblFormNameHeader = new javax.swing.JLabel();
        lblFormInformation = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        btnEdit = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnQuery = new javax.swing.JButton();
        btnGoQuery = new javax.swing.JButton();
        sPanelForm = new javax.swing.JScrollPane();
        PanelForm = new javax.swing.JPanel();
        lblRowId = new javax.swing.JLabel();
        txtRowId = new javax.swing.JTextField();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblType = new javax.swing.JLabel();
        txtValue = new javax.swing.JTextField();
        lblOrder = new javax.swing.JLabel();
        txtOrder = new javax.swing.JTextField();
        PanelPermition = new javax.swing.JPanel();
        PanelList1 = new javax.swing.JPanel();
        PanelListPosition2 = new javax.swing.JPanel();
        PanelListPosHeader2 = new javax.swing.JPanel();
        lblScreenNamePos2 = new javax.swing.JLabel();
        lblRecCountPos2 = new javax.swing.JLabel();
        PanelListPos2 = new javax.swing.JPanel();
        sPanelListPos2 = new javax.swing.JScrollPane();
        tblListPos2 = new javax.swing.JTable();
        PanelListPermition1 = new javax.swing.JPanel();
        PanelListPermHeader1 = new javax.swing.JPanel();
        lblScreenNamePerm1 = new javax.swing.JLabel();
        lblRecCountPerm1 = new javax.swing.JLabel();
        PanelListPerm1 = new javax.swing.JPanel();
        sPanelListPerm1 = new javax.swing.JScrollPane();
        tblListPerm1 = new javax.swing.JTable();
        MainPanelForm2 = new javax.swing.JPanel();
        PanelFormHeader2 = new javax.swing.JPanel();
        lblFormNameHeader2 = new javax.swing.JLabel();
        lblFormInformation2 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        btnEdit2 = new javax.swing.JButton();
        btnNew2 = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JSeparator();
        btnSave2 = new javax.swing.JButton();
        btnCancel2 = new javax.swing.JButton();
        btnDelete2 = new javax.swing.JButton();
        btnQuery2 = new javax.swing.JButton();
        btnGoQuery2 = new javax.swing.JButton();
        sPanelForm1 = new javax.swing.JScrollPane();
        PanelForm1 = new javax.swing.JPanel();
        lblRowId1 = new javax.swing.JLabel();
        txtRowId1 = new javax.swing.JTextField();
        lblName1 = new javax.swing.JLabel();
        txtName1 = new javax.swing.JTextField();
        lblType1 = new javax.swing.JLabel();
        txtValue1 = new javax.swing.JTextField();
        lblOrder1 = new javax.swing.JLabel();
        txtOrder1 = new javax.swing.JTextField();

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
                false, false, false, true
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
        tblListPerm.setSelectionMode();
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

        javax.swing.GroupLayout PanelListPermitionLayout = new javax.swing.GroupLayout(PanelListPermition);
        PanelListPermition.setLayout(PanelListPermitionLayout);
        PanelListPermitionLayout.setHorizontalGroup(
            PanelListPermitionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelListPermHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelListPerm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelListPermitionLayout.setVerticalGroup(
            PanelListPermitionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelListPermitionLayout.createSequentialGroup()
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
            .addComponent(PanelListPermition, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelListLayout.setVerticalGroup(
            PanelListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelListLayout.createSequentialGroup()
                .addComponent(PanelListPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelListPermition, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelList.addTab("Lista de Posições e Permissões", PanelList);

        PanelPosition.setBackground(new java.awt.Color(255, 255, 255));

        lblScreenNamePos1.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        lblScreenNamePos1.setText("Posições");

        lblRecCountPos1.setBackground(new java.awt.Color(255, 255, 255));
        lblRecCountPos1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblRecCountPos1.setText("Registros: 0 - 100");
        lblRecCountPos1.setToolTipText("");
        lblRecCountPos1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblRecCountPos1.setMaximumSize(new java.awt.Dimension(410, 14));

        javax.swing.GroupLayout PanelListPosHeader1Layout = new javax.swing.GroupLayout(PanelListPosHeader1);
        PanelListPosHeader1.setLayout(PanelListPosHeader1Layout);
        PanelListPosHeader1Layout.setHorizontalGroup(
            PanelListPosHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelListPosHeader1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblScreenNamePos1)
                .addGap(957, 957, 957)
                .addComponent(lblRecCountPos1, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                .addContainerGap())
        );
        PanelListPosHeader1Layout.setVerticalGroup(
            PanelListPosHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelListPosHeader1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelListPosHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblScreenNamePos1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblRecCountPos1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        sPanelListPos1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        sPanelListPos1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        sPanelListPos1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        sPanelListPos1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N

        tblListPos1.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        tblListPos1.setModel(new javax.swing.table.DefaultTableModel(
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
        tblListPos1.setGridColor(new java.awt.Color(204, 204, 204));
        tblListPos1.setRowHeight(22);
        tblListPos1.setSelectionMode();
        tblListPos1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblListPos1KeyPressed(evt);
            }
        });
        sPanelListPos1.setViewportView(tblListPos1);

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

        lblFormNameHeader.setBackground(new java.awt.Color(255, 255, 255));
        lblFormNameHeader.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        lblFormNameHeader.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblFormNameHeader.setToolTipText("");
        lblFormNameHeader.setMinimumSize(new java.awt.Dimension(0, 30));

        lblFormInformation.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblFormInformation.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFormInformation.setText("Campos Obrigatórios (*)");
        lblFormInformation.setEnabled(false);

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

        javax.swing.GroupLayout PanelFormHeaderLayout = new javax.swing.GroupLayout(PanelFormHeader);
        PanelFormHeader.setLayout(PanelFormHeaderLayout);
        PanelFormHeaderLayout.setHorizontalGroup(
            PanelFormHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelFormHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblFormNameHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFormInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        PanelFormHeaderLayout.setVerticalGroup(
            PanelFormHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFormHeaderLayout.createSequentialGroup()
                .addGroup(PanelFormHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblFormInformation, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblFormNameHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnQuery, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGoQuery, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        sPanelForm.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        sPanelForm.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        sPanelForm.setMinimumSize(new java.awt.Dimension(0, 0));
        sPanelForm.setPreferredSize(new java.awt.Dimension(2000, 607));

        PanelForm.setBackground(new java.awt.Color(255, 255, 255));
        PanelForm.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        PanelForm.setPreferredSize(new java.awt.Dimension(800, 80));

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
        txtRowId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRowIdKeyPressed(evt);
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

        lblType.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblType.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblType.setText("Tipo*:");
        lblType.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        lblType.setEnabled(false);
        lblType.setOpaque(true);

        txtValue.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtValue.setText("jTextField1");
        txtValue.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.background")), javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5)));
        txtValue.setEnabled(false);
        txtValue.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtValueKeyPressed(evt);
            }
        });

        lblOrder.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblOrder.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblOrder.setText("Descrição:");
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

        javax.swing.GroupLayout PanelFormLayout = new javax.swing.GroupLayout(PanelForm);
        PanelForm.setLayout(PanelFormLayout);
        PanelFormLayout.setHorizontalGroup(
            PanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtRowId, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRowId, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelFormLayout.createSequentialGroup()
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtValue, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelFormLayout.createSequentialGroup()
                        .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblType, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtOrder, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE))
                .addContainerGap())
        );
        PanelFormLayout.setVerticalGroup(
            PanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelFormLayout.createSequentialGroup()
                        .addComponent(lblOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelFormLayout.createSequentialGroup()
                        .addGroup(PanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblType, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblRowId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtRowId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtValue, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
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

        PanelPermition.setBackground(new java.awt.Color(255, 255, 255));

        PanelList1.setBackground(new java.awt.Color(255, 255, 255));

        lblScreenNamePos2.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        lblScreenNamePos2.setText("Posições");

        lblRecCountPos2.setBackground(new java.awt.Color(255, 255, 255));
        lblRecCountPos2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblRecCountPos2.setText("Registros: 0 - 100");
        lblRecCountPos2.setToolTipText("");
        lblRecCountPos2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblRecCountPos2.setMaximumSize(new java.awt.Dimension(410, 14));

        javax.swing.GroupLayout PanelListPosHeader2Layout = new javax.swing.GroupLayout(PanelListPosHeader2);
        PanelListPosHeader2.setLayout(PanelListPosHeader2Layout);
        PanelListPosHeader2Layout.setHorizontalGroup(
            PanelListPosHeader2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelListPosHeader2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblScreenNamePos2)
                .addGap(957, 957, 957)
                .addComponent(lblRecCountPos2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        PanelListPosHeader2Layout.setVerticalGroup(
            PanelListPosHeader2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelListPosHeader2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelListPosHeader2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblScreenNamePos2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblRecCountPos2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        sPanelListPos2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        sPanelListPos2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        sPanelListPos2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        sPanelListPos2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N

        tblListPos2.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        tblListPos2.setModel(new javax.swing.table.DefaultTableModel(
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
        tblListPos2.setGridColor(new java.awt.Color(204, 204, 204));
        tblListPos2.setRowHeight(22);
        tblListPos2.setSelectionMode();
        tblListPos2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblListPos2KeyPressed(evt);
            }
        });
        sPanelListPos2.setViewportView(tblListPos2);

        javax.swing.GroupLayout PanelListPos2Layout = new javax.swing.GroupLayout(PanelListPos2);
        PanelListPos2.setLayout(PanelListPos2Layout);
        PanelListPos2Layout.setHorizontalGroup(
            PanelListPos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelListPos2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sPanelListPos2)
                .addContainerGap())
        );
        PanelListPos2Layout.setVerticalGroup(
            PanelListPos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sPanelListPos2, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PanelListPosition2Layout = new javax.swing.GroupLayout(PanelListPosition2);
        PanelListPosition2.setLayout(PanelListPosition2Layout);
        PanelListPosition2Layout.setHorizontalGroup(
            PanelListPosition2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelListPosHeader2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelListPos2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelListPosition2Layout.setVerticalGroup(
            PanelListPosition2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelListPosition2Layout.createSequentialGroup()
                .addComponent(PanelListPosHeader2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelListPos2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        lblScreenNamePerm1.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        lblScreenNamePerm1.setText("Permissões");

        lblRecCountPerm1.setBackground(new java.awt.Color(255, 255, 255));
        lblRecCountPerm1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblRecCountPerm1.setText("Registros: 0 - 100");
        lblRecCountPerm1.setToolTipText("");
        lblRecCountPerm1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblRecCountPerm1.setMaximumSize(new java.awt.Dimension(410, 14));

        javax.swing.GroupLayout PanelListPermHeader1Layout = new javax.swing.GroupLayout(PanelListPermHeader1);
        PanelListPermHeader1.setLayout(PanelListPermHeader1Layout);
        PanelListPermHeader1Layout.setHorizontalGroup(
            PanelListPermHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelListPermHeader1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblScreenNamePerm1)
                .addGap(947, 947, 947)
                .addComponent(lblRecCountPerm1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        PanelListPermHeader1Layout.setVerticalGroup(
            PanelListPermHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelListPermHeader1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelListPermHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblScreenNamePerm1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblRecCountPerm1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        sPanelListPerm1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        sPanelListPerm1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        sPanelListPerm1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        sPanelListPerm1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N

        tblListPerm1.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        tblListPerm1.setModel(new javax.swing.table.DefaultTableModel(
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
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblListPerm1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        tblListPerm1.setGridColor(new java.awt.Color(204, 204, 204));
        tblListPerm1.setRowHeight(22);
        tblListPerm1.setSelectionMode();
        tblListPerm1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblListPerm1KeyPressed(evt);
            }
        });
        sPanelListPerm1.setViewportView(tblListPerm1);

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
            .addComponent(sPanelListPerm1, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PanelListPermition1Layout = new javax.swing.GroupLayout(PanelListPermition1);
        PanelListPermition1.setLayout(PanelListPermition1Layout);
        PanelListPermition1Layout.setHorizontalGroup(
            PanelListPermition1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelListPermHeader1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelListPerm1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelListPermition1Layout.setVerticalGroup(
            PanelListPermition1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelListPermition1Layout.createSequentialGroup()
                .addComponent(PanelListPermHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelListPerm1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout PanelList1Layout = new javax.swing.GroupLayout(PanelList1);
        PanelList1.setLayout(PanelList1Layout);
        PanelList1Layout.setHorizontalGroup(
            PanelList1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelListPosition2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelListPermition1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelList1Layout.setVerticalGroup(
            PanelList1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelList1Layout.createSequentialGroup()
                .addComponent(PanelListPosition2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelListPermition1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblFormNameHeader2.setBackground(new java.awt.Color(255, 255, 255));
        lblFormNameHeader2.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        lblFormNameHeader2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblFormNameHeader2.setToolTipText("");
        lblFormNameHeader2.setMinimumSize(new java.awt.Dimension(0, 30));

        lblFormInformation2.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblFormInformation2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFormInformation2.setText("Campos Obrigatórios (*)");
        lblFormInformation2.setEnabled(false);

        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btnEdit2.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnEdit2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/20px/Edit 20x20.png"))); // NOI18N
        btnEdit2.setToolTipText("Editar");
        btnEdit2.setBorderPainted(false);
        btnEdit2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEdit2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnEdit2.setIconTextGap(3);
        btnEdit2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnEdit2KeyPressed(evt);
            }
        });

        btnNew2.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnNew2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/20px/New 20x20.png"))); // NOI18N
        btnNew2.setToolTipText("Novo");
        btnNew2.setBorderPainted(false);
        btnNew2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNew2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnNew2.setIconTextGap(0);
        btnNew2.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnNew2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnNew2KeyPressed(evt);
            }
        });

        jSeparator8.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btnSave2.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnSave2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/20px/Save 20x20.png"))); // NOI18N
        btnSave2.setToolTipText("Salvar");
        btnSave2.setEnabled(false);
        btnSave2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnSave2.setIconTextGap(3);
        btnSave2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnSave2KeyPressed(evt);
            }
        });

        btnCancel2.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnCancel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/20px/Cancel 20x20.png"))); // NOI18N
        btnCancel2.setToolTipText("Cancelar");
        btnCancel2.setEnabled(false);
        btnCancel2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnCancel2.setIconTextGap(3);
        btnCancel2.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnCancel2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnCancel2KeyPressed(evt);
            }
        });

        btnDelete2.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnDelete2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/20px/Delete 20x20.png"))); // NOI18N
        btnDelete2.setToolTipText("Excluir");
        btnDelete2.setBorderPainted(false);
        btnDelete2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDelete2.setEnabled(false);
        btnDelete2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnDelete2.setIconTextGap(3);
        btnDelete2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnDelete2KeyPressed(evt);
            }
        });

        btnQuery2.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnQuery2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/20px/Lupa 20x20.png"))); // NOI18N
        btnQuery2.setToolTipText("Pesquisar");
        btnQuery2.setBorderPainted(false);
        btnQuery2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnQuery2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnQuery2.setIconTextGap(0);
        btnQuery2.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnQuery2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnQuery2KeyPressed(evt);
            }
        });

        btnGoQuery2.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnGoQuery2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/20px/Go 20x20.png"))); // NOI18N
        btnGoQuery2.setToolTipText("Ir");
        btnGoQuery2.setBorderPainted(false);
        btnGoQuery2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnGoQuery2.setEnabled(false);
        btnGoQuery2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnGoQuery2.setIconTextGap(3);
        btnGoQuery2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnGoQuery2KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout PanelFormHeader2Layout = new javax.swing.GroupLayout(PanelFormHeader2);
        PanelFormHeader2.setLayout(PanelFormHeader2Layout);
        PanelFormHeader2Layout.setHorizontalGroup(
            PanelFormHeader2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelFormHeader2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblFormNameHeader2, javax.swing.GroupLayout.DEFAULT_SIZE, 667, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFormInformation2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnQuery2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGoQuery2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNew2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEdit2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSave2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        PanelFormHeader2Layout.setVerticalGroup(
            PanelFormHeader2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFormHeader2Layout.createSequentialGroup()
                .addGroup(PanelFormHeader2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNew2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator8)
                    .addComponent(jSeparator7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblFormInformation2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSave2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblFormNameHeader2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEdit2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelete2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnQuery2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGoQuery2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        sPanelForm1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        sPanelForm1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        sPanelForm1.setMinimumSize(new java.awt.Dimension(0, 0));
        sPanelForm1.setPreferredSize(new java.awt.Dimension(2000, 607));

        PanelForm1.setBackground(new java.awt.Color(255, 255, 255));
        PanelForm1.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        PanelForm1.setPreferredSize(new java.awt.Dimension(800, 80));

        lblRowId1.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblRowId1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblRowId1.setText("Id:");
        lblRowId1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        lblRowId1.setEnabled(false);
        lblRowId1.setOpaque(true);

        txtRowId1.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtRowId1.setText("jTextField1");
        txtRowId1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.background")), javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5)));
        txtRowId1.setEnabled(false);
        txtRowId1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRowId1KeyPressed(evt);
            }
        });

        lblName1.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblName1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblName1.setText("Nome*:");
        lblName1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        lblName1.setEnabled(false);
        lblName1.setOpaque(true);

        txtName1.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtName1.setText("jTextField1");
        txtName1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.background")), javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5)));
        txtName1.setEnabled(false);
        txtName1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtName1KeyPressed(evt);
            }
        });

        lblType1.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblType1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblType1.setText("Tipo*:");
        lblType1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        lblType1.setEnabled(false);
        lblType1.setOpaque(true);

        txtValue1.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtValue1.setText("jTextField1");
        txtValue1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.background")), javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5)));
        txtValue1.setEnabled(false);
        txtValue1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtValue1KeyPressed(evt);
            }
        });

        lblOrder1.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblOrder1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblOrder1.setText("Descrição:");
        lblOrder1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        lblOrder1.setEnabled(false);
        lblOrder1.setOpaque(true);

        txtOrder1.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtOrder1.setText("jTextField1");
        txtOrder1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.background")), javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5)));
        txtOrder1.setEnabled(false);
        txtOrder1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtOrder1KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout PanelForm1Layout = new javax.swing.GroupLayout(PanelForm1);
        PanelForm1.setLayout(PanelForm1Layout);
        PanelForm1Layout.setHorizontalGroup(
            PanelForm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelForm1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelForm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtRowId1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRowId1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelForm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelForm1Layout.createSequentialGroup()
                        .addComponent(txtName1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtValue1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelForm1Layout.createSequentialGroup()
                        .addComponent(lblName1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblType1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelForm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblOrder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtOrder1, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE))
                .addContainerGap())
        );
        PanelForm1Layout.setVerticalGroup(
            PanelForm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelForm1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelForm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelForm1Layout.createSequentialGroup()
                        .addComponent(lblOrder1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtOrder1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelForm1Layout.createSequentialGroup()
                        .addGroup(PanelForm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblType1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelForm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblRowId1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblName1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelForm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtRowId1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtName1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtValue1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
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

        javax.swing.GroupLayout PanelPermitionLayout = new javax.swing.GroupLayout(PanelPermition);
        PanelPermition.setLayout(PanelPermitionLayout);
        PanelPermitionLayout.setHorizontalGroup(
            PanelPermitionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanelForm2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelList1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelPermitionLayout.setVerticalGroup(
            PanelPermitionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPermitionLayout.createSequentialGroup()
                .addComponent(PanelList1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MainPanelForm2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanelList.addTab("Permissões", PanelPermition);

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

    private void txtNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_TAB){
            setFocus("VAL");
        }
    }//GEN-LAST:event_txtNameKeyPressed

    private void txtValueKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValueKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_TAB){
            setFocus("LANGUAGE");
        }
    }//GEN-LAST:event_txtValueKeyPressed

    private void tblListPosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblListPosKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tblListPosKeyPressed

    private void btnQueryKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnQueryKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnQueryKeyPressed

    private void btnGoQueryKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnGoQueryKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGoQueryKeyPressed

    private void txtRowIdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRowIdKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_TAB){
            setFocus("TYPE");
        }
    }//GEN-LAST:event_txtRowIdKeyPressed

    private void txtOrderKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOrderKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOrderKeyPressed

    private void tblListPermKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblListPermKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tblListPermKeyPressed

    private void tblListPos1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblListPos1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tblListPos1KeyPressed

    private void tblListPos2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblListPos2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tblListPos2KeyPressed

    private void tblListPerm1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblListPerm1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tblListPerm1KeyPressed

    private void btnEdit2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnEdit2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEdit2KeyPressed

    private void btnNew2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnNew2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNew2KeyPressed

    private void btnSave2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSave2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSave2KeyPressed

    private void btnCancel2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCancel2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancel2KeyPressed

    private void btnDelete2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnDelete2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDelete2KeyPressed

    private void btnQuery2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnQuery2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnQuery2KeyPressed

    private void btnGoQuery2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnGoQuery2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGoQuery2KeyPressed

    private void txtRowId1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRowId1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRowId1KeyPressed

    private void txtName1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtName1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtName1KeyPressed

    private void txtValue1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValue1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValue1KeyPressed

    private void txtOrder1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOrder1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOrder1KeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MainPanelForm;
    private javax.swing.JPanel MainPanelForm1;
    private javax.swing.JPanel MainPanelForm2;
    private javax.swing.JPanel PanelForm;
    private javax.swing.JPanel PanelForm1;
    private javax.swing.JPanel PanelFormHeader;
    private javax.swing.JPanel PanelFormHeader1;
    private javax.swing.JPanel PanelFormHeader2;
    private javax.swing.JPanel PanelLanguage;
    private javax.swing.JPanel PanelList;
    private javax.swing.JPanel PanelList1;
    private javax.swing.JPanel PanelListPerm;
    private javax.swing.JPanel PanelListPerm1;
    private javax.swing.JPanel PanelListPermHeader;
    private javax.swing.JPanel PanelListPermHeader1;
    private javax.swing.JPanel PanelListPermition;
    private javax.swing.JPanel PanelListPermition1;
    private javax.swing.JPanel PanelListPos;
    private javax.swing.JPanel PanelListPos1;
    private javax.swing.JPanel PanelListPos2;
    private javax.swing.JPanel PanelListPosHeader;
    private javax.swing.JPanel PanelListPosHeader1;
    private javax.swing.JPanel PanelListPosHeader2;
    private javax.swing.JPanel PanelListPosition;
    private javax.swing.JPanel PanelListPosition1;
    private javax.swing.JPanel PanelListPosition2;
    private javax.swing.JPanel PanelPermition;
    private javax.swing.JPanel PanelPosition;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCancel1;
    private javax.swing.JButton btnCancel2;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDelete1;
    private javax.swing.JButton btnDelete2;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnEdit1;
    private javax.swing.JButton btnEdit2;
    private javax.swing.JButton btnGoQuery;
    private javax.swing.JButton btnGoQuery1;
    private javax.swing.JButton btnGoQuery2;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnNew1;
    private javax.swing.JButton btnNew2;
    private javax.swing.JButton btnQuery;
    private javax.swing.JButton btnQuery1;
    private javax.swing.JButton btnQuery2;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSave1;
    private javax.swing.JButton btnSave2;
    private javax.swing.JComboBox<String> cbbListFilter;
    private javax.swing.JTabbedPane jPanelList;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JLabel lblFormInformation;
    private javax.swing.JLabel lblFormInformation1;
    private javax.swing.JLabel lblFormInformation2;
    private javax.swing.JLabel lblFormNameHeader;
    private javax.swing.JLabel lblFormNameHeader1;
    private javax.swing.JLabel lblFormNameHeader2;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblInformation;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblName1;
    private javax.swing.JLabel lblOrder;
    private javax.swing.JLabel lblOrder1;
    private javax.swing.JLabel lblRecCountPerm;
    private javax.swing.JLabel lblRecCountPerm1;
    private javax.swing.JLabel lblRecCountPos;
    private javax.swing.JLabel lblRecCountPos1;
    private javax.swing.JLabel lblRecCountPos2;
    private javax.swing.JLabel lblRowId;
    private javax.swing.JLabel lblRowId1;
    private javax.swing.JLabel lblScreenNamePerm;
    private javax.swing.JLabel lblScreenNamePerm1;
    private javax.swing.JLabel lblScreenNamePos;
    private javax.swing.JLabel lblScreenNamePos1;
    private javax.swing.JLabel lblScreenNamePos2;
    private javax.swing.JLabel lblType;
    private javax.swing.JLabel lblType1;
    private javax.swing.JScrollPane sPanelForm;
    private javax.swing.JScrollPane sPanelForm1;
    private javax.swing.JScrollPane sPanelListPerm;
    private javax.swing.JScrollPane sPanelListPerm1;
    private javax.swing.JScrollPane sPanelListPos;
    private javax.swing.JScrollPane sPanelListPos1;
    private javax.swing.JScrollPane sPanelListPos2;
    private javax.swing.JTable tblListPerm;
    private javax.swing.JTable tblListPerm1;
    private javax.swing.JTable tblListPos;
    private javax.swing.JTable tblListPos1;
    private javax.swing.JTable tblListPos2;
    private javax.swing.JTextField txtListFilterValue;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtName1;
    private javax.swing.JTextField txtOrder;
    private javax.swing.JTextField txtOrder1;
    private javax.swing.JTextField txtRowId;
    private javax.swing.JTextField txtRowId1;
    private javax.swing.JTextField txtValue;
    private javax.swing.JTextField txtValue1;
    // End of variables declaration//GEN-END:variables
}
