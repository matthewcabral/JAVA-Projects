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
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Matheus Cabral Rosa
 */
public class SocialMediaScreen extends javax.swing.JFrame {

    /**
     * Creates new form ContactManagement
     */
    public SocialMediaScreen() {
        initComponents();
    }
    
    // Listeners
    public void setListenerBtnEdit(ActionListener listener) { this.btnEdit.addActionListener(listener); }
    public void setListenerBtnNew(ActionListener listener) { this.btnNew.addActionListener(listener); }
    public void setListenerBtnSave(ActionListener listener) { this.btnSave.addActionListener(listener); }
    public void setListenerBtnCancel(ActionListener listener) { this.btnCancel.addActionListener(listener); }
    public void setListenerBtnDelete(ActionListener listener) { this.btnDelete.addActionListener(listener); }
    public void setListenerContactSocialMediaScreen(WindowListener listener) { this.addWindowListener(listener); }
    
    // Table
    public DefaultTableModel getTableModel(){ return (DefaultTableModel) tblSocialMediaList.getModel(); }
    public void setListenerTblContactSocialMediaListSelection(ListSelectionListener listener) { this.tblSocialMediaList.getSelectionModel().addListSelectionListener(listener); }
    public String getSelectedRowIdContactSocialMediaList() { try { return (String) this.tblSocialMediaList.getValueAt(this.tblSocialMediaList.getSelectedRow(), 0); } catch (Exception e) { return ""; } }
    public void setSelectedRowColumnList(int row, int column){ this.tblSocialMediaList.changeSelection(row, column, false, false); }
    public int getSelectedRowList() { return this.tblSocialMediaList.getSelectedRow(); }
    public int getNumOfListRows() { return this.tblSocialMediaList.getRowCount(); }
    
    // Component Setters
    public void settxtRowId(String value) { this.txtRowId.setText(value); this.txtRowId.paintImmediately(this.txtRowId.getVisibleRect()); }
    public void settxtSocialMediaValue(String value) { this.txtSocialMediaValue.setText(value); this.txtSocialMediaValue.paintImmediately(this.txtSocialMediaValue.getVisibleRect()); }
    public void setcbbSocialMediaType(String value) { this.cbbSocialMediaType.addItem(value); this.cbbSocialMediaType.paintImmediately(this.cbbSocialMediaType.getVisibleRect()); }
    //public void setckbMainSocialMediaFlg(String value) { if("Y".equals(value)) { this.ckbMainSocialMediaFlg.setSelected(true); } else { this.ckbMainSocialMediaFlg.setSelected(false); } this.ckbMainSocialMediaFlg.paintImmediately(this.ckbMainSocialMediaFlg.getVisibleRect()); }
    public void setlblRecCount(String value) { this.lblRecCount.setText("Registros: " + value); this.lblRecCount.paintImmediately(this.lblRecCount.getVisibleRect()); }
    public void setlblSocialMediaHeader(String value) { this.lblSocialMediaHeader.setText(value); this.lblSocialMediaHeader.paintImmediately(this.lblSocialMediaHeader.getVisibleRect()); }
        
    // Component Getters
    public String gettxtRowId() { return this.txtRowId.getText(); }
    public String gettxtSocialMediaValue() { return this.txtSocialMediaValue.getText(); }    
    public String getcbbSocialMediaType() { return this.cbbSocialMediaType.getSelectedItem().toString(); }
    //public String getckbMainSocialMediaFlg() { if(this.ckbMainSocialMediaFlg.isSelected()) { return "Y"; } else { return "N"; } }
    public String getlblRecCount() { return this.lblRecCount.getText(); }
    public String getlblContactNameHeader() { return this.lblSocialMediaHeader.getText(); }
    
    // Component Clear
    public void cleartxtRowId() { this.txtRowId.setText(""); this.txtRowId.paintImmediately(this.txtRowId.getVisibleRect()); }
    public void cleartxtSocialMediaValue() { this.txtSocialMediaValue.setText(""); this.txtSocialMediaValue.paintImmediately(this.txtSocialMediaValue.getVisibleRect()); }    
    public void clearcbbSocialMediaType() { this.cbbSocialMediaType.removeAllItems(); this.cbbSocialMediaType.paintImmediately(this.cbbSocialMediaType.getVisibleRect()); }
    //public void clearckbMainSocialMediaFlg() { this.ckbMainSocialMediaFlg.setSelected(false); this.ckbMainSocialMediaFlg.paintImmediately(this.ckbMainSocialMediaFlg.getVisibleRect()); }
    public void clearlblRecCount() { this.lblRecCount.setText(""); this.lblRecCount.paintImmediately(this.lblRecCount.getVisibleRect()); }
    public void clearlblContactNameHeader() { this.lblSocialMediaHeader.setText(""); this.lblSocialMediaHeader.paintImmediately(this.lblSocialMediaHeader.getVisibleRect()); }

    // Enable or Disable Components
    public void settxtRowIdEnabled(boolean status) { this.txtRowId.setEnabled(status); }
    public void settxtSocialMediaValueEnabled(boolean status) { this.txtSocialMediaValue.setEnabled(status); }    
    public void setcbbSocialMediaTypeEnabled(boolean status) { this.cbbSocialMediaType.setEnabled(status); }
    //public void setckbMainSocialMediaFlgEnabled(boolean status) { this.ckbMainSocialMediaFlg.setEnabled(status); }
    public void setlblRecCountEnabled(boolean status) { this.lblRecCount.setEnabled(status); }
    public void setlblContactNameHeaderEnabled(boolean status) { this.lblSocialMediaHeader.setEnabled(status); }
    
    public void setbtnEditEnabled(boolean status) { this.btnEdit.setEnabled(status); }
    public void setbtnNewEnabled(boolean status) { this.btnNew.setEnabled(status); }
    public void setbtnSaveEnabled(boolean status) { this.btnSave.setEnabled(status); }
    public void setbtnCancelEnabled(boolean status) { this.btnCancel.setEnabled(status); }
    public void setbtnDeleteEnabled(boolean status) { this.btnDelete.setEnabled(status); }
    
    // Return componet status
    public boolean istxtRowIdEnabled() { return this.txtRowId.isEnabled(); }
    public boolean istxtSocialMediaValueEnabled() { return this.txtSocialMediaValue.isEnabled(); }
    public boolean iscbbSocialMediaTypeEnabled() { return this.cbbSocialMediaType.isEnabled(); }
    //public boolean isckbMainSocialMediaFlgEnabled() { return this.ckbMainSocialMediaFlg.isEnabled(); }
    public boolean islblRecCountEnabled() { return this.lblRecCount.isEnabled(); }
    public boolean islblContactNameHeaderEnabled() { return this.lblSocialMediaHeader.isEnabled(); }
    
    public boolean isbtnEditEnabled() { return this.btnEdit.isEnabled(); }
    public boolean isbtnNewEnabled() { return this.btnNew.isEnabled(); }
    public boolean isbtnSaveEnabled() { return this.btnSave.isEnabled(); }
    public boolean isbtnCancelEnabled() { return this.btnCancel.isEnabled(); }
    public boolean isbtnDeleteEnabled() { return this.btnDelete.isEnabled(); }
    
    // ComboBox Specific Setters
    public void setcbbSocialMediaTypeItemIndex(int value) { this.cbbSocialMediaType.setSelectedIndex(value); }
    
    // ComboBox Specific Getters
    public int getcbbSocialMediaTypeItemIndex(String value) { if(!"".equals(value) && value != null) { for(int i = 0; i < this.cbbSocialMediaType.getItemCount(); i++){ if(value.equals(this.cbbSocialMediaType.getItemAt(i))){ return i; }}} else { return 0; } return 0; }
    
    // Button Functions
    public void clickSave(){ this.btnSave.setEnabled(true); this.btnSave.doClick(); this.btnSave.setEnabled(false); }
    public void clickNew(){ this.btnNew.setEnabled(true); this.btnNew.doClick(); this.btnNew.setEnabled(false); }
    public void clickEdit(){ this.btnEdit.setEnabled(true); this.btnEdit.doClick(); this.btnEdit.setEnabled(false); }
    public void clickCancel(){ this.btnCancel.setEnabled(true); this.btnCancel.doClick(); this.btnCancel.setEnabled(false); }
    public void clickDelete(){ this.btnDelete.setEnabled(true); this.btnDelete.doClick(); this.btnDelete.setEnabled(false); }
    
    // Set Focus on Specific component
    public void setFocus(String component) {
        switch (component) {
            case "ID":
                this.txtRowId.requestFocus();
                break;
            //case "CONTATO_PRINCIPAL_FLG":
                //this.ckbMainSocialMediaFlg.requestFocus();
                //break;
            case "TIPO_REDE_SOCIAL":
                this.cbbSocialMediaType.requestFocus();
                break;
            case "USUARIO":
                this.txtSocialMediaValue.requestFocus();
                break;
            case "BOTAO_EDITAR":
                this.btnDelete.requestFocus();
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
                settxtRowIdEnabled(false);
                settxtSocialMediaValueEnabled(false);
                setcbbSocialMediaTypeEnabled(false);
                //setckbMainSocialMediaFlgEnabled(false);

                setbtnEditEnabled(false);
                setbtnNewEnabled(true);                
                setbtnDeleteEnabled(false);
                setbtnSaveEnabled(false);
                setbtnCancelEnabled(false);
                break;
            case "NOVO":
                settxtRowIdEnabled(false);
                settxtSocialMediaValueEnabled(true);
                setcbbSocialMediaTypeEnabled(true);
                //setckbMainSocialMediaFlgEnabled(true);

                setbtnEditEnabled(false);
                setbtnNewEnabled(false);
                setbtnSaveEnabled(true);
                setbtnCancelEnabled(true);
                setbtnDeleteEnabled(false);
                break;
            case "EDITAR":
                settxtRowIdEnabled(false);
                settxtSocialMediaValueEnabled(true);
                setcbbSocialMediaTypeEnabled(true);
                //setckbMainSocialMediaFlgEnabled(true);

                setbtnEditEnabled(false);
                setbtnNewEnabled(false);
                setbtnSaveEnabled(true);
                setbtnCancelEnabled(true);
                setbtnDeleteEnabled(false);
                break;
            case "CANCELAR":
                settxtRowIdEnabled(false);
                settxtSocialMediaValueEnabled(false);
                setcbbSocialMediaTypeEnabled(false);
                //setckbMainSocialMediaFlgEnabled(false);

                setbtnEditEnabled(true);
                setbtnNewEnabled(true);
                setbtnSaveEnabled(false);
                setbtnCancelEnabled(false);
                setbtnDeleteEnabled(true);
                break;
            case "DELETAR":
                settxtRowIdEnabled(false);
                settxtSocialMediaValueEnabled(false);
                setcbbSocialMediaTypeEnabled(false);
                //setckbMainSocialMediaFlgEnabled(false);

                setbtnEditEnabled(true);
                setbtnNewEnabled(true);
                setbtnDeleteEnabled(true);
                setbtnSaveEnabled(false);
                setbtnCancelEnabled(false);                
                break;
            case "SALVAR":
                settxtRowIdEnabled(false);
                settxtSocialMediaValueEnabled(false);
                setcbbSocialMediaTypeEnabled(false);
                //setckbMainSocialMediaFlgEnabled(false);

                setbtnEditEnabled(true);
                setbtnNewEnabled(true);
                setbtnSaveEnabled(false);
                setbtnCancelEnabled(false);
                setbtnDeleteEnabled(true);
                break;
            default:
                break;
        }
    }

    public void clearFields() {
        cleartxtRowId();
        cleartxtSocialMediaValue();
        setcbbSocialMediaTypeItemIndex(0);
        //clearckbMainSocialMediaFlg();
        clearlblContactNameHeader();
    }
    
    public void clearComboBoxes(){
        this.clearcbbSocialMediaType();
    }
    
    public void insertSelectComboBox(){
        this.setcbbSocialMediaType("Selecione...");
    }
    
    public final void FocusTraversalKeys(){
        this.txtRowId.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtSocialMediaValue.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.cbbSocialMediaType.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        //this.ckbMainSocialMediaFlg.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.lblRecCount.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.lblSocialMediaHeader.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelSocialMedia = new javax.swing.JPanel();
        PanelSocialMediaList = new javax.swing.JPanel();
        PanelContactListHeader = new javax.swing.JPanel();
        lblContactList = new javax.swing.JLabel();
        lblRecCount = new javax.swing.JLabel();
        PanelListContact = new javax.swing.JPanel();
        sPanelUserList = new javax.swing.JScrollPane();
        tblSocialMediaList = new javax.swing.JTable();
        PanelSocialMediaForm = new javax.swing.JPanel();
        PanelContactFormHeader = new javax.swing.JPanel();
        lblSocialMediaHeader = new javax.swing.JLabel();
        lblContactFormInformation = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        btnDelete = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        sPanelUserForm = new javax.swing.JScrollPane();
        PanelFormUser = new javax.swing.JPanel();
        lblContactInformation = new javax.swing.JLabel();
        lblRowId = new javax.swing.JLabel();
        txtRowId = new javax.swing.JTextField();
        lblSocialMediaType = new javax.swing.JLabel();
        cbbSocialMediaType = new javax.swing.JComboBox<>();
        lblSocialMediaValue = new javax.swing.JLabel();
        txtSocialMediaValue = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Redes Sociais");
        setBackground(new java.awt.Color(255, 255, 255));
        setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        setResizable(false);

        PanelSocialMedia.setBackground(new java.awt.Color(255, 255, 255));
        PanelSocialMedia.setPreferredSize(new java.awt.Dimension(1366, 757));

        lblContactList.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        lblContactList.setText("Lista de Redes Sociais");

        lblRecCount.setBackground(new java.awt.Color(255, 255, 255));
        lblRecCount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblRecCount.setText("Registros: 0 - 100");
        lblRecCount.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblRecCount.setMaximumSize(new java.awt.Dimension(410, 14));

        javax.swing.GroupLayout PanelContactListHeaderLayout = new javax.swing.GroupLayout(PanelContactListHeader);
        PanelContactListHeader.setLayout(PanelContactListHeaderLayout);
        PanelContactListHeaderLayout.setHorizontalGroup(
            PanelContactListHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelContactListHeaderLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(lblContactList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRecCount, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        PanelContactListHeaderLayout.setVerticalGroup(
            PanelContactListHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelContactListHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelContactListHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblContactList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblRecCount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        lblRecCount.getAccessibleContext().setAccessibleDescription("");

        sPanelUserList.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        sPanelUserList.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        sPanelUserList.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N

        tblSocialMediaList.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        tblSocialMediaList.setModel(new javax.swing.table.DefaultTableModel(
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
                "Id", "Nome da Rede Social", "Usuário"
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
        tblSocialMediaList.setGridColor(new java.awt.Color(204, 204, 204));
        sPanelUserList.setViewportView(tblSocialMediaList);

        javax.swing.GroupLayout PanelListContactLayout = new javax.swing.GroupLayout(PanelListContact);
        PanelListContact.setLayout(PanelListContactLayout);
        PanelListContactLayout.setHorizontalGroup(
            PanelListContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sPanelUserList)
        );
        PanelListContactLayout.setVerticalGroup(
            PanelListContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sPanelUserList, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PanelSocialMediaListLayout = new javax.swing.GroupLayout(PanelSocialMediaList);
        PanelSocialMediaList.setLayout(PanelSocialMediaListLayout);
        PanelSocialMediaListLayout.setHorizontalGroup(
            PanelSocialMediaListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelSocialMediaListLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelSocialMediaListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelListContact, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelContactListHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        PanelSocialMediaListLayout.setVerticalGroup(
            PanelSocialMediaListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSocialMediaListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelContactListHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelListContact, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        lblSocialMediaHeader.setBackground(new java.awt.Color(255, 255, 255));
        lblSocialMediaHeader.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        lblSocialMediaHeader.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblSocialMediaHeader.setText("Facebook");
        lblSocialMediaHeader.setMinimumSize(new java.awt.Dimension(0, 30));

        lblContactFormInformation.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblContactFormInformation.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblContactFormInformation.setText("Campos Obrigatórios (*)");
        lblContactFormInformation.setEnabled(false);

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btnDelete.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/20px/Delete 20x20.png"))); // NOI18N
        btnDelete.setToolTipText("Excluir");
        btnDelete.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnDelete.setBorderPainted(false);
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDelete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDelete.setIconTextGap(3);
        btnDelete.setMaximumSize(new java.awt.Dimension(76, 30));
        btnDelete.setMinimumSize(new java.awt.Dimension(76, 30));
        btnDelete.setPreferredSize(new java.awt.Dimension(76, 30));
        btnDelete.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnDeleteKeyPressed(evt);
            }
        });

        btnNew.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/20px/New 20x20.png"))); // NOI18N
        btnNew.setToolTipText("Novo");
        btnNew.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnNew.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNew.setIconTextGap(3);
        btnNew.setMaximumSize(new java.awt.Dimension(76, 30));
        btnNew.setMinimumSize(new java.awt.Dimension(76, 30));
        btnNew.setPreferredSize(new java.awt.Dimension(76, 30));
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
        btnSave.setMaximumSize(new java.awt.Dimension(76, 30));
        btnSave.setMinimumSize(new java.awt.Dimension(76, 30));
        btnSave.setPreferredSize(new java.awt.Dimension(76, 30));
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
        btnCancel.setMaximumSize(new java.awt.Dimension(76, 30));
        btnCancel.setMinimumSize(new java.awt.Dimension(76, 30));
        btnCancel.setPreferredSize(new java.awt.Dimension(76, 30));
        btnCancel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnCancelKeyPressed(evt);
            }
        });

        btnEdit.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/20px/Edit 20x20.png"))); // NOI18N
        btnEdit.setToolTipText("Editar");
        btnEdit.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnEdit.setBorderPainted(false);
        btnEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEdit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEdit.setIconTextGap(3);
        btnEdit.setMaximumSize(new java.awt.Dimension(76, 30));
        btnEdit.setMinimumSize(new java.awt.Dimension(76, 30));
        btnEdit.setPreferredSize(new java.awt.Dimension(76, 30));
        btnEdit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnEditKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout PanelContactFormHeaderLayout = new javax.swing.GroupLayout(PanelContactFormHeader);
        PanelContactFormHeader.setLayout(PanelContactFormHeaderLayout);
        PanelContactFormHeaderLayout.setHorizontalGroup(
            PanelContactFormHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelContactFormHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSocialMediaHeader, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblContactFormInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
        PanelContactFormHeaderLayout.setVerticalGroup(
            PanelContactFormHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelContactFormHeaderLayout.createSequentialGroup()
                .addGroup(PanelContactFormHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator3)
                    .addComponent(lblContactFormInformation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelContactFormHeaderLayout.createSequentialGroup()
                        .addGroup(PanelContactFormHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSocialMediaHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelContactFormHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(PanelContactFormHeaderLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(PanelContactFormHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        sPanelUserForm.setBorder(null);
        sPanelUserForm.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        sPanelUserForm.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        sPanelUserForm.setMinimumSize(new java.awt.Dimension(0, 0));
        sPanelUserForm.setPreferredSize(new java.awt.Dimension(1366, 427));

        PanelFormUser.setBackground(new java.awt.Color(255, 255, 255));
        PanelFormUser.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        PanelFormUser.setPreferredSize(new java.awt.Dimension(1340, 425));

        lblContactInformation.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.light"));
        lblContactInformation.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblContactInformation.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblContactInformation.setText("   Informações de Rede Social do Contato");
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

        lblSocialMediaType.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblSocialMediaType.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSocialMediaType.setText("Nome Rede Social*:");
        lblSocialMediaType.setEnabled(false);
        lblSocialMediaType.setMaximumSize(new java.awt.Dimension(150, 22));
        lblSocialMediaType.setMinimumSize(new java.awt.Dimension(150, 22));
        lblSocialMediaType.setPreferredSize(new java.awt.Dimension(150, 22));

        cbbSocialMediaType.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        cbbSocialMediaType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbSocialMediaType.setEnabled(false);
        cbbSocialMediaType.setMaximumSize(new java.awt.Dimension(165, 22));
        cbbSocialMediaType.setMinimumSize(new java.awt.Dimension(165, 22));
        cbbSocialMediaType.setPreferredSize(new java.awt.Dimension(165, 22));
        cbbSocialMediaType.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbSocialMediaTypeItemStateChanged(evt);
            }
        });

        lblSocialMediaValue.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblSocialMediaValue.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSocialMediaValue.setText("Usuário Rede Social*:");
        lblSocialMediaValue.setEnabled(false);
        lblSocialMediaValue.setMaximumSize(new java.awt.Dimension(150, 22));
        lblSocialMediaValue.setMinimumSize(new java.awt.Dimension(150, 22));
        lblSocialMediaValue.setPreferredSize(new java.awt.Dimension(150, 22));

        txtSocialMediaValue.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtSocialMediaValue.setText("jTextField1");
        txtSocialMediaValue.setToolTipText("/matheuscabralrosa");
        txtSocialMediaValue.setEnabled(false);
        txtSocialMediaValue.setMaximumSize(new java.awt.Dimension(165, 22));
        txtSocialMediaValue.setMinimumSize(new java.awt.Dimension(165, 22));
        txtSocialMediaValue.setPreferredSize(new java.awt.Dimension(165, 22));
        txtSocialMediaValue.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSocialMediaValueKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout PanelFormUserLayout = new javax.swing.GroupLayout(PanelFormUser);
        PanelFormUser.setLayout(PanelFormUserLayout);
        PanelFormUserLayout.setHorizontalGroup(
            PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFormUserLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelFormUserLayout.createSequentialGroup()
                        .addComponent(lblRowId, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRowId, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelFormUserLayout.createSequentialGroup()
                        .addComponent(lblSocialMediaType, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbSocialMediaType, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSocialMediaValue, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSocialMediaValue, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblContactInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 724, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(606, Short.MAX_VALUE))
        );
        PanelFormUserLayout.setVerticalGroup(
            PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelFormUserLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblContactInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRowId, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRowId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSocialMediaType, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbSocialMediaType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSocialMediaValue, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSocialMediaValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(331, Short.MAX_VALUE))
        );

        sPanelUserForm.setViewportView(PanelFormUser);

        javax.swing.GroupLayout PanelSocialMediaFormLayout = new javax.swing.GroupLayout(PanelSocialMediaForm);
        PanelSocialMediaForm.setLayout(PanelSocialMediaFormLayout);
        PanelSocialMediaFormLayout.setHorizontalGroup(
            PanelSocialMediaFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelContactFormHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PanelSocialMediaFormLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sPanelUserForm, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        PanelSocialMediaFormLayout.setVerticalGroup(
            PanelSocialMediaFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelSocialMediaFormLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelContactFormHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sPanelUserForm, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout PanelSocialMediaLayout = new javax.swing.GroupLayout(PanelSocialMedia);
        PanelSocialMedia.setLayout(PanelSocialMediaLayout);
        PanelSocialMediaLayout.setHorizontalGroup(
            PanelSocialMediaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelSocialMediaList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelSocialMediaForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelSocialMediaLayout.setVerticalGroup(
            PanelSocialMediaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSocialMediaLayout.createSequentialGroup()
                .addComponent(PanelSocialMediaList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PanelSocialMediaForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelSocialMedia, javax.swing.GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelSocialMedia, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnDeleteKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_TAB){
            setFocus("BOTAO_NOVO");
        }
    }//GEN-LAST:event_btnDeleteKeyPressed

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

    private void cbbSocialMediaTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbSocialMediaTypeItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            setFocus("USUARIO");
        }
    }//GEN-LAST:event_cbbSocialMediaTypeItemStateChanged

    private void txtSocialMediaValueKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSocialMediaValueKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("BOTAO_SALVAR");
        }
    }//GEN-LAST:event_txtSocialMediaValueKeyPressed

    private void btnEditKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnEditKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_TAB){
            setFocus("BOTAO_DELETAR");
        }
    }//GEN-LAST:event_btnEditKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelContactFormHeader;
    private javax.swing.JPanel PanelContactListHeader;
    private javax.swing.JPanel PanelFormUser;
    private javax.swing.JPanel PanelListContact;
    private javax.swing.JPanel PanelSocialMedia;
    private javax.swing.JPanel PanelSocialMediaForm;
    private javax.swing.JPanel PanelSocialMediaList;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cbbSocialMediaType;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblContactFormInformation;
    private javax.swing.JLabel lblContactInformation;
    private javax.swing.JLabel lblContactList;
    private javax.swing.JLabel lblRecCount;
    private javax.swing.JLabel lblRowId;
    private javax.swing.JLabel lblSocialMediaHeader;
    private javax.swing.JLabel lblSocialMediaType;
    private javax.swing.JLabel lblSocialMediaValue;
    private javax.swing.JScrollPane sPanelUserForm;
    private javax.swing.JScrollPane sPanelUserList;
    private javax.swing.JTable tblSocialMediaList;
    private javax.swing.JTextField txtRowId;
    private javax.swing.JTextField txtSocialMediaValue;
    // End of variables declaration//GEN-END:variables
}
