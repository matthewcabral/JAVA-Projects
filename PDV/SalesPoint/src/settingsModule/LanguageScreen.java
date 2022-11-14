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
public class LanguageScreen extends javax.swing.JFrame {

    /**
     * Creates new form ListOfValuesScreen
     */
    public LanguageScreen() {
        initComponents();
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();
        /*if(width <= 1366 && height <= 768){
            this.setExtendedState(MAXIMIZED_BOTH);
        }*/
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
    public DefaultTableModel getTableModel(){ return (DefaultTableModel) tblList.getModel(); }    
    public void setListenerTblListSelection(ListSelectionListener listener) { this.tblList.getSelectionModel().addListSelectionListener(listener); }
    public void setSelectedRowColumnList(int row, int column){ this.tblList.changeSelection(row, column, false, false); }
    public void unselectRowList() { try { this.tblList.removeRowSelectionInterval(this.getSelectedRowList(), this.getSelectedRowList()); } catch (Exception e) {} }
    public void removeRowFromList(int row) { try { this.getTableModel().removeRow(row); } catch (Exception e) {} this.tblList.paintImmediately(this.tblList.getVisibleRect()); }
    public void setListRowCount(int count) { this.getTableModel().setRowCount(count); this.tblList.paintImmediately(this.tblList.getVisibleRect()); }
    public int getSelectedRowList() { return this.tblList.getSelectedRow(); }
    public int getNumOfListRows() { return this.tblList.getRowCount(); }
    
    // Component Setters
    public void settxtListFilterValue(String value) { this.txtListFilterValue.setText(value); this.txtListFilterValue.paintImmediately(this.txtListFilterValue.getVisibleRect()); }
    public void settxtRowId(String value) { this.txtRowId.setText(value); this.txtRowId.paintImmediately(this.txtRowId.getVisibleRect()); }
    public void settxtCode(String value) { this.txtCode.setText(value); this.txtCode.paintImmediately(this.txtCode.getVisibleRect()); }
    public void settxtName(String value) { this.txtName.setText(value); this.txtName.paintImmediately(this.txtName.getVisibleRect()); }
    public void settxtValue(String value) { this.txtValue.setText(value); this.txtValue.paintImmediately(this.txtValue.getVisibleRect()); }    
    public void settxtOrder(String value) { this.txtOrder.setText(value); this.txtOrder.paintImmediately(this.txtOrder.getVisibleRect()); }
    public void setcbbListFilter(String value) { this.cbbListFilter.addItem(value); this.cbbListFilter.paintImmediately(this.cbbListFilter.getVisibleRect()); }
    public void setlblLOVNameHeader(String value) { this.lblFormNameHeader.setText(value); this.lblFormNameHeader.paintImmediately(this.lblFormNameHeader.getVisibleRect()); }
    public void setlblRecCount(String value) { this.lblRecCount.setText("Registros: " + value); this.lblRecCount.paintImmediately(this.lblRecCount.getVisibleRect()); }
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
    
    public String getlblRecCount() { return this.lblRecCount.getText(); }
    public String getlblLOVNameHeader() { return this.lblFormNameHeader.getText(); }
    
    // Component Clear
    public void cleartxtListFilterValue() { this.txtListFilterValue.setText(""); this.txtListFilterValue.paintImmediately(this.txtListFilterValue.getVisibleRect()); }
    public void cleartxtRowId() { this.txtRowId.setText(""); this.txtRowId.paintImmediately(this.txtRowId.getVisibleRect()); }
    public void cleartxtCode() { this.txtCode.setText(""); this.txtCode.paintImmediately(this.txtCode.getVisibleRect()); }    
    public void cleartxtName() { this.txtName.setText(""); this.txtName.paintImmediately(this.txtName.getVisibleRect()); }
    public void cleartxtValue() { this.txtValue.setText(""); this.txtValue.paintImmediately(this.txtValue.getVisibleRect()); }
    public void cleartxtOrder() { this.txtOrder.setText(""); this.txtOrder.paintImmediately(this.txtOrder.getVisibleRect()); }
    public void clearcbbListFilter() { this.cbbListFilter.removeAllItems(); this.cbbListFilter.paintImmediately(this.cbbListFilter.getVisibleRect()); }
    public void clearlblRecCount() { this.lblRecCount.setText(""); this.lblRecCount.paintImmediately(this.lblRecCount.getVisibleRect()); }
    public void clearlblLOVNameHeader() { this.lblFormNameHeader.setText(""); this.lblFormNameHeader.paintImmediately(this.lblFormNameHeader.getVisibleRect()); }

    // Enable or Disable Components
    public void settxtLOVTypeListFilterValueEnabled(boolean status) { this.txtListFilterValue.setEnabled(status); }
    public void settxtRowIdEnabled(boolean status) { this.txtRowId.setEnabled(status); }    
    public void settxtCodeEnabled(boolean status) { this.txtCode.setEnabled(status); }
    public void settxtNameEnabled(boolean status) { this.txtName.setEnabled(status); }
    public void settxtValueEnabled(boolean status) { this.txtValue.setEnabled(status); }
    public void settxtOrderEnabled(boolean status) { this.txtOrder.setEnabled(status); }
    public void setcbbListFilterEnabled(boolean status) { this.cbbListFilter.setEnabled(status); }    
    public void setlblRecCountEnabled(boolean status) { this.lblRecCount.setEnabled(status); }
    public void setlblLOVNameHeaderEnabled(boolean status) { this.lblFormNameHeader.setEnabled(status); }
    
    public void setTblEnabled(boolean status) { this.tblList.setEnabled(status); }
    
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
    public boolean islblRecCountEnabled() { return this.lblRecCount.isEnabled(); }
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
        this.lblRecCount.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
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
        MainPanelList = new javax.swing.JPanel();
        PanelListHeader = new javax.swing.JPanel();
        lblScreenName = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblImage = new javax.swing.JLabel();
        cbbListFilter = new javax.swing.JComboBox<>();
        txtListFilterValue = new javax.swing.JTextField();
        lblInformation = new javax.swing.JLabel();
        lblRecCount = new javax.swing.JLabel();
        PanelList = new javax.swing.JPanel();
        sPanelList = new javax.swing.JScrollPane();
        tblList = new javax.swing.JTable();
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
        lblCode = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblValue = new javax.swing.JLabel();
        txtValue = new javax.swing.JTextField();
        lblOrder = new javax.swing.JLabel();
        txtOrder = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lista de Valores");
        setResizable(false);

        PanelLanguage.setBackground(new java.awt.Color(255, 255, 255));
        PanelLanguage.setPreferredSize(new java.awt.Dimension(1366, 757));

        lblScreenName.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        lblScreenName.setText("Lista de Idiomas");

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

        lblRecCount.setBackground(new java.awt.Color(255, 255, 255));
        lblRecCount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblRecCount.setText("Registros: 0 - 100");
        lblRecCount.setToolTipText("");
        lblRecCount.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblRecCount.setMaximumSize(new java.awt.Dimension(410, 14));

        javax.swing.GroupLayout PanelListHeaderLayout = new javax.swing.GroupLayout(PanelListHeader);
        PanelListHeader.setLayout(PanelListHeaderLayout);
        PanelListHeaderLayout.setHorizontalGroup(
            PanelListHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelListHeaderLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(lblScreenName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblImage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbbListFilter, 0, 160, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtListFilterValue, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInformation)
                .addGap(59, 59, 59)
                .addComponent(lblRecCount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        PanelListHeaderLayout.setVerticalGroup(
            PanelListHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelListHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelListHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbbListFilter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblScreenName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addComponent(lblImage, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblRecCount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblInformation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtListFilterValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        sPanelList.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        sPanelList.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        sPanelList.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        sPanelList.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N

        tblList.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        tblList.setModel(new javax.swing.table.DefaultTableModel(
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
                "Código", "Nome", "Valor", "Ordem"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        tblList.setGridColor(new java.awt.Color(204, 204, 204));
        tblList.setRowHeight(22);
        tblList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblList.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblListKeyPressed(evt);
            }
        });
        sPanelList.setViewportView(tblList);

        javax.swing.GroupLayout PanelListLayout = new javax.swing.GroupLayout(PanelList);
        PanelList.setLayout(PanelListLayout);
        PanelListLayout.setHorizontalGroup(
            PanelListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sPanelList)
        );
        PanelListLayout.setVerticalGroup(
            PanelListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sPanelList, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout MainPanelListLayout = new javax.swing.GroupLayout(MainPanelList);
        MainPanelList.setLayout(MainPanelListLayout);
        MainPanelListLayout.setHorizontalGroup(
            MainPanelListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainPanelListLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MainPanelListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelListHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        MainPanelListLayout.setVerticalGroup(
            MainPanelListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelListHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        lblCode.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblCode.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCode.setText("Código*:");
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
        lblValue.setText("Valor*:");
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

        javax.swing.GroupLayout PanelFormLayout = new javax.swing.GroupLayout(PanelForm);
        PanelForm.setLayout(PanelFormLayout);
        PanelFormLayout.setHorizontalGroup(
            PanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtRowId, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRowId, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCode, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelFormLayout.createSequentialGroup()
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtValue, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelFormLayout.createSequentialGroup()
                        .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblValue, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                            .addComponent(lblValue, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblRowId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblCode, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtRowId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtValue, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
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

        javax.swing.GroupLayout PanelLanguageLayout = new javax.swing.GroupLayout(PanelLanguage);
        PanelLanguage.setLayout(PanelLanguageLayout);
        PanelLanguageLayout.setHorizontalGroup(
            PanelLanguageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanelList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(MainPanelForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelLanguageLayout.setVerticalGroup(
            PanelLanguageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLanguageLayout.createSequentialGroup()
                .addComponent(MainPanelList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MainPanelForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelLanguage, javax.swing.GroupLayout.DEFAULT_SIZE, 867, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelLanguage, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
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

    private void tblListKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblListKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tblListKeyPressed

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

    private void txtCodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodeKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodeKeyPressed

    private void txtOrderKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOrderKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOrderKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MainPanelForm;
    private javax.swing.JPanel MainPanelList;
    private javax.swing.JPanel PanelForm;
    private javax.swing.JPanel PanelFormHeader;
    private javax.swing.JPanel PanelLanguage;
    private javax.swing.JPanel PanelList;
    private javax.swing.JPanel PanelListHeader;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnGoQuery;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnQuery;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cbbListFilter;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblCode;
    private javax.swing.JLabel lblFormInformation;
    private javax.swing.JLabel lblFormNameHeader;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblInformation;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblOrder;
    private javax.swing.JLabel lblRecCount;
    private javax.swing.JLabel lblRowId;
    private javax.swing.JLabel lblScreenName;
    private javax.swing.JLabel lblValue;
    private javax.swing.JScrollPane sPanelForm;
    private javax.swing.JScrollPane sPanelList;
    private javax.swing.JTable tblList;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtListFilterValue;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtOrder;
    private javax.swing.JTextField txtRowId;
    private javax.swing.JTextField txtValue;
    // End of variables declaration//GEN-END:variables
}
