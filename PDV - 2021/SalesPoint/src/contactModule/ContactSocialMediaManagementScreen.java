/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactModule;

import java.awt.KeyboardFocusManager;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowListener;
import java.util.Collections;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Matheus Cabral Rosa
 */
public class ContactSocialMediaManagementScreen extends javax.swing.JFrame {

    /**
     * Creates new form ContactManagement
     */
    public ContactSocialMediaManagementScreen() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.FocusTraversalKeys();
    }
    
    // Listeners
    public void setListenerBtnEditContact(ActionListener listener) { this.btnEditContact.addActionListener(listener); }
    public void setListenerBtnNewContact(ActionListener listener) { this.btnNewContact.addActionListener(listener); }
    public void setListenerBtnSaveContact(ActionListener listener) { this.btnSaveContact.addActionListener(listener); }
    public void setListenerBtnCancelContact(ActionListener listener) { this.btnCancelContact.addActionListener(listener); }
    public void setListenerContactSocialMediaScreen(WindowListener listener) { this.addWindowListener(listener); }
    
    // Table Model
    public DefaultTableModel getTableModel(){ return (DefaultTableModel) tblSocialMediaList.getModel(); }
    
    // Component Setters
    public void settxtRowId(String value) { this.txtRowId.setText(value); this.txtRowId.paintImmediately(this.txtRowId.getVisibleRect()); }
    public void settxtTwitter(String value) { this.txtUser.setText(value); this.txtUser.paintImmediately(this.txtUser.getVisibleRect()); }
    public void setcbbSocialMediaType(String value) { this.cbbSocialMediaType.addItem(value); this.cbbSocialMediaType.paintImmediately(this.cbbSocialMediaType.getVisibleRect()); }
    public void setckbMainSocialMediaFlg(String value) { if("Y".equals(value)) { this.ckbMainSocialMediaFlg.setSelected(true); } else { this.ckbMainSocialMediaFlg.setSelected(false); } this.ckbMainSocialMediaFlg.paintImmediately(this.ckbMainSocialMediaFlg.getVisibleRect()); }
    public void setlblRecCount(String value) { this.lblRecCount.setText("Total de Registros: " + value); this.lblRecCount.paintImmediately(this.lblRecCount.getVisibleRect()); }
    public void setlblSocialMediaHeader(String value) { this.lblSocialMediaHeader.setText(value); this.lblSocialMediaHeader.paintImmediately(this.lblSocialMediaHeader.getVisibleRect()); }
        
    // Component Getters
    public String gettxtRowId() { return this.txtRowId.getText(); }
    public String gettxtUser() { return this.txtUser.getText(); }    
    public String getcbbSocialMediaType() { return this.cbbSocialMediaType.getSelectedItem().toString(); }
    public String getckbMainSocialMediaFlg() { if(this.ckbMainSocialMediaFlg.isSelected()) { return "Y"; } else { return "N"; } }
    public String getlblRecCount() { return this.lblRecCount.getText(); }
    public String getlblContactNameHeader() { return this.lblSocialMediaHeader.getText(); }
    
    // Component Clear
    public void cleartxtRowId() { this.txtRowId.setText(""); this.txtRowId.paintImmediately(this.txtRowId.getVisibleRect()); }
    public void cleartxtUser() { this.txtUser.setText(""); this.txtUser.paintImmediately(this.txtUser.getVisibleRect()); }    
    public void clearcbbSocialMediaType() { this.cbbSocialMediaType.removeAllItems(); this.cbbSocialMediaType.paintImmediately(this.cbbSocialMediaType.getVisibleRect()); }
    public void clearckbMainSocialMediaFlg() { this.ckbMainSocialMediaFlg.setSelected(false); this.ckbMainSocialMediaFlg.paintImmediately(this.ckbMainSocialMediaFlg.getVisibleRect()); }
    public void clearlblRecCount() { this.lblRecCount.setText(""); this.lblRecCount.paintImmediately(this.lblRecCount.getVisibleRect()); }
    public void clearlblContactNameHeader() { this.lblSocialMediaHeader.setText(""); this.lblSocialMediaHeader.paintImmediately(this.lblSocialMediaHeader.getVisibleRect()); }

    // Enable or Disable Components
    public void settxtRowIdEnabled(boolean status) { this.txtRowId.setEnabled(status); }
    public void settxtUserEnabled(boolean status) { this.txtUser.setEnabled(status); }    
    public void setcbbSocialMediaTypeEnabled(boolean status) { this.cbbSocialMediaType.setEnabled(status); }
    public void setckbMainSocialMediaFlgEnabled(boolean status) { this.ckbMainSocialMediaFlg.setEnabled(status); }
    public void setlblRecCountEnabled(boolean status) { this.lblRecCount.setEnabled(status); }
    public void setlblContactNameHeaderEnabled(boolean status) { this.lblSocialMediaHeader.setEnabled(status); }
    
    public void setbtnEditContactEnabled(boolean status) { this.btnEditContact.setEnabled(status); }
    public void setbtnNewContactEnabled(boolean status) { this.btnNewContact.setEnabled(status); }
    public void setbtnSaveContactEnabled(boolean status) { this.btnSaveContact.setEnabled(status); }
    public void setbtnCancelContactEnabled(boolean status) { this.btnCancelContact.setEnabled(status); }
    
    // Return componet status
    public boolean istxtRowIdEnabled() { return this.txtRowId.isEnabled(); }
    public boolean istxtUserEnabled() { return this.txtUser.isEnabled(); }
    public boolean iscbbSocialMediaTypeEnabled() { return this.cbbSocialMediaType.isEnabled(); }
    public boolean isckbMainSocialMediaFlgEnabled() { return this.ckbMainSocialMediaFlg.isEnabled(); }
    public boolean islblRecCountEnabled() { return this.lblRecCount.isEnabled(); }
    public boolean islblContactNameHeaderEnabled() { return this.lblSocialMediaHeader.isEnabled(); }
    
    public boolean isbtnEditContactEnabled() { return this.btnEditContact.isEnabled(); }
    public boolean isbtnNewContactEnabled() { return this.btnNewContact.isEnabled(); }
    public boolean isbtnSaveContactEnabled() { return this.btnSaveContact.isEnabled(); }
    public boolean isbtnCancelContactEnabled() { return this.btnCancelContact.isEnabled(); }
    
    // Button Functions
    public void clickSave(){ this.btnSaveContact.setEnabled(true); this.btnSaveContact.doClick(); this.btnSaveContact.setEnabled(false); }
    public void clickNew(){ this.btnNewContact.setEnabled(true); this.btnNewContact.doClick(); this.btnNewContact.setEnabled(false); }
    public void clickEdit(){ this.btnEditContact.setEnabled(true); this.btnEditContact.doClick(); this.btnEditContact.setEnabled(false); }
    public void clickCancel(){ this.btnCancelContact.setEnabled(true); this.btnCancelContact.doClick(); this.btnCancelContact.setEnabled(false); }
    
    // Set Focus on Specific component
    public void setFocus(String component) {
        switch (component) {
            case "ID":
                this.txtRowId.requestFocus();
                break;
            case "CONTATO_PRINCIPAL_FLG":
                this.ckbMainSocialMediaFlg.requestFocus();
                break;
            case "TIPO_REDE_SOCIAL":
                this.cbbSocialMediaType.requestFocus();
                break;
            case "USUARIO":
                this.txtUser.requestFocus();
                break;
            case "BOTAO_EDITAR":
                this.btnEditContact.requestFocus();
                break;
            case "BOTAO_NOVO":
                this.btnNewContact.requestFocus();
                break;
            case "BOTAO_SALVAR":
                this.btnSaveContact.requestFocus();
                break;
            case "BOTAO_CANCELAR":
                this.btnCancelContact.requestFocus();
                break;
            default:
                break;
        }
    }
    
    public void enableFields(String funcao) {
        switch (funcao){
            case "LOAD_SCREEN":
                settxtRowIdEnabled(false);
                settxtUserEnabled(false);
                setcbbSocialMediaTypeEnabled(false);
                setckbMainSocialMediaFlgEnabled(false);

                setbtnEditContactEnabled(true);
                setbtnNewContactEnabled(true);
                setbtnSaveContactEnabled(false);
                setbtnCancelContactEnabled(false);
                break;
            case "NOVO":
                settxtRowIdEnabled(false);
                settxtUserEnabled(true);
                setcbbSocialMediaTypeEnabled(true);
                setckbMainSocialMediaFlgEnabled(true);

                setbtnEditContactEnabled(false);
                setbtnNewContactEnabled(false);
                setbtnSaveContactEnabled(true);
                setbtnCancelContactEnabled(true);
                break;
            case "EDITAR":
                settxtRowIdEnabled(false);
                settxtUserEnabled(true);
                setcbbSocialMediaTypeEnabled(true);
                setckbMainSocialMediaFlgEnabled(true);

                setbtnEditContactEnabled(false);
                setbtnNewContactEnabled(false);
                setbtnSaveContactEnabled(true);
                setbtnCancelContactEnabled(true);
                break;
            case "CANCELAR":
                settxtRowIdEnabled(false);
                settxtUserEnabled(false);
                setcbbSocialMediaTypeEnabled(false);
                setckbMainSocialMediaFlgEnabled(false);

                setbtnEditContactEnabled(true);
                setbtnNewContactEnabled(true);
                setbtnSaveContactEnabled(false);
                setbtnCancelContactEnabled(false);
                break;
            case "SALVAR":
                settxtRowIdEnabled(false);
                settxtUserEnabled(false);
                setcbbSocialMediaTypeEnabled(false);
                setckbMainSocialMediaFlgEnabled(false);

                setbtnEditContactEnabled(true);
                setbtnNewContactEnabled(true);
                setbtnSaveContactEnabled(false);
                setbtnCancelContactEnabled(false);
                break;
            default:
                break;
        }
    }

    public void clearFields() {
        cleartxtRowId();
        cleartxtUser();
        clearcbbSocialMediaType();
        clearckbMainSocialMediaFlg();
        clearlblRecCount();
        clearlblContactNameHeader();
    }
    
    public final void FocusTraversalKeys(){
        this.txtRowId.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.txtUser.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.cbbSocialMediaType.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.ckbMainSocialMediaFlg.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
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

        PanelUser = new javax.swing.JPanel();
        PanelContactList = new javax.swing.JPanel();
        PanelContactListHeader = new javax.swing.JPanel();
        lblContactList = new javax.swing.JLabel();
        lblRecCount = new javax.swing.JLabel();
        PanelListContact = new javax.swing.JPanel();
        sPanelUserList = new javax.swing.JScrollPane();
        tblSocialMediaList = new javax.swing.JTable();
        PanelContactForm = new javax.swing.JPanel();
        PanelContactFormHeader = new javax.swing.JPanel();
        lblSocialMediaHeader = new javax.swing.JLabel();
        lblContactFormInformation = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        btnEditContact = new javax.swing.JButton();
        btnNewContact = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        btnSaveContact = new javax.swing.JButton();
        btnCancelContact = new javax.swing.JButton();
        sPanelUserForm = new javax.swing.JScrollPane();
        PanelFormUser = new javax.swing.JPanel();
        lblContactInformation = new javax.swing.JLabel();
        lblRowId = new javax.swing.JLabel();
        txtRowId = new javax.swing.JTextField();
        lblMainSocialMediaFlg = new javax.swing.JLabel();
        ckbMainSocialMediaFlg = new javax.swing.JCheckBox();
        lblSocialMediaType = new javax.swing.JLabel();
        cbbSocialMediaType = new javax.swing.JComboBox<>();
        lblUser = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Redes Sociais");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(255, 255, 255));
        setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        PanelUser.setBackground(new java.awt.Color(255, 255, 255));
        PanelUser.setPreferredSize(new java.awt.Dimension(1366, 757));

        lblContactList.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        lblContactList.setText("Lista de Redes Sociais");

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

        tblSocialMediaList.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
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

        btnEditContact.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnEditContact.setText("Editar");
        btnEditContact.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10));
        btnEditContact.setBorderPainted(false);
        btnEditContact.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEditContact.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnEditContact.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnEditContactKeyPressed(evt);
            }
        });

        btnNewContact.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnNewContact.setText("Novo");
        btnNewContact.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10));
        btnNewContact.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnNewContact.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnNewContactKeyPressed(evt);
            }
        });

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btnSaveContact.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnSaveContact.setText("Salvar");
        btnSaveContact.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10));
        btnSaveContact.setEnabled(false);
        btnSaveContact.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnSaveContact.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnSaveContactKeyPressed(evt);
            }
        });

        btnCancelContact.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnCancelContact.setText("Cancelar");
        btnCancelContact.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10));
        btnCancelContact.setEnabled(false);
        btnCancelContact.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnCancelContact.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnCancelContactKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout PanelContactFormHeaderLayout = new javax.swing.GroupLayout(PanelContactFormHeader);
        PanelContactFormHeader.setLayout(PanelContactFormHeaderLayout);
        PanelContactFormHeaderLayout.setHorizontalGroup(
            PanelContactFormHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelContactFormHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSocialMediaHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblContactFormInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEditContact, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNewContact, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSaveContact, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelContact, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        PanelContactFormHeaderLayout.setVerticalGroup(
            PanelContactFormHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelContactFormHeaderLayout.createSequentialGroup()
                .addGroup(PanelContactFormHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addComponent(btnEditContact, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblContactFormInformation, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSaveContact, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PanelContactFormHeaderLayout.createSequentialGroup()
                        .addComponent(lblSocialMediaHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnCancelContact, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNewContact, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        lblMainSocialMediaFlg.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblMainSocialMediaFlg.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMainSocialMediaFlg.setText("Principal*:");
        lblMainSocialMediaFlg.setEnabled(false);
        lblMainSocialMediaFlg.setMaximumSize(new java.awt.Dimension(150, 22));
        lblMainSocialMediaFlg.setMinimumSize(new java.awt.Dimension(150, 22));
        lblMainSocialMediaFlg.setPreferredSize(new java.awt.Dimension(150, 22));

        ckbMainSocialMediaFlg.setBackground(new java.awt.Color(255, 255, 255));
        ckbMainSocialMediaFlg.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        ckbMainSocialMediaFlg.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        ckbMainSocialMediaFlg.setBorderPainted(true);
        ckbMainSocialMediaFlg.setEnabled(false);
        ckbMainSocialMediaFlg.setMaximumSize(new java.awt.Dimension(165, 21));
        ckbMainSocialMediaFlg.setPreferredSize(new java.awt.Dimension(165, 21));

        lblSocialMediaType.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblSocialMediaType.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSocialMediaType.setText("Rede Social*:");
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
        cbbSocialMediaType.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbbSocialMediaTypeKeyPressed(evt);
            }
        });

        lblUser.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        lblUser.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblUser.setText("Usuário*:");
        lblUser.setEnabled(false);
        lblUser.setMaximumSize(new java.awt.Dimension(150, 22));
        lblUser.setMinimumSize(new java.awt.Dimension(150, 22));
        lblUser.setPreferredSize(new java.awt.Dimension(150, 22));

        txtUser.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtUser.setText("jTextField1");
        txtUser.setToolTipText("/matheuscabralrosa");
        txtUser.setEnabled(false);
        txtUser.setMaximumSize(new java.awt.Dimension(165, 22));
        txtUser.setMinimumSize(new java.awt.Dimension(165, 22));
        txtUser.setPreferredSize(new java.awt.Dimension(165, 22));
        txtUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUserKeyPressed(evt);
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
                        .addComponent(txtRowId, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMainSocialMediaFlg, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ckbMainSocialMediaFlg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblContactInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 642, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelFormUserLayout.createSequentialGroup()
                        .addComponent(lblSocialMediaType, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbSocialMediaType, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelFormUserLayout.setVerticalGroup(
            PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelFormUserLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblContactInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblRowId, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtRowId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblMainSocialMediaFlg, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ckbMainSocialMediaFlg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelFormUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSocialMediaType, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbSocialMediaType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(331, Short.MAX_VALUE))
        );

        sPanelUserForm.setViewportView(PanelFormUser);

        javax.swing.GroupLayout PanelContactFormLayout = new javax.swing.GroupLayout(PanelContactForm);
        PanelContactForm.setLayout(PanelContactFormLayout);
        PanelContactFormLayout.setHorizontalGroup(
            PanelContactFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelContactFormHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PanelContactFormLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sPanelUserForm, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        PanelContactFormLayout.setVerticalGroup(
            PanelContactFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelContactFormLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelContactFormHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sPanelUserForm, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PanelContactForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelUser, javax.swing.GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelUser, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditContactKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnEditContactKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_TAB){
            setFocus("BOTAO_NOVO");
        }
    }//GEN-LAST:event_btnEditContactKeyPressed

    private void btnNewContactKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnNewContactKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_TAB){
            setFocus("BOTAO_EDITAR");
        }
    }//GEN-LAST:event_btnNewContactKeyPressed

    private void btnSaveContactKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSaveContactKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_TAB){
            setFocus("BOTAO_CANCELAR");
        }
    }//GEN-LAST:event_btnSaveContactKeyPressed

    private void btnCancelContactKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCancelContactKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_TAB){
            setFocus("BOTAO_SALVAR");
        }
    }//GEN-LAST:event_btnCancelContactKeyPressed

    private void txtUserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_TAB)){
            setFocus("BOTAO_ADD_ENDERECO");
        }
    }//GEN-LAST:event_txtUserKeyPressed

    private void cbbSocialMediaTypeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbbSocialMediaTypeKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbSocialMediaTypeKeyPressed

    private void cbbSocialMediaTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbSocialMediaTypeItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbSocialMediaTypeItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelContactForm;
    private javax.swing.JPanel PanelContactFormHeader;
    private javax.swing.JPanel PanelContactList;
    private javax.swing.JPanel PanelContactListHeader;
    private javax.swing.JPanel PanelFormUser;
    private javax.swing.JPanel PanelListContact;
    private javax.swing.JPanel PanelUser;
    private javax.swing.JButton btnCancelContact;
    private javax.swing.JButton btnEditContact;
    private javax.swing.JButton btnNewContact;
    private javax.swing.JButton btnSaveContact;
    private javax.swing.JComboBox<String> cbbSocialMediaType;
    private javax.swing.JCheckBox ckbMainSocialMediaFlg;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblContactFormInformation;
    private javax.swing.JLabel lblContactInformation;
    private javax.swing.JLabel lblContactList;
    private javax.swing.JLabel lblMainSocialMediaFlg;
    private javax.swing.JLabel lblRecCount;
    private javax.swing.JLabel lblRowId;
    private javax.swing.JLabel lblSocialMediaHeader;
    private javax.swing.JLabel lblSocialMediaType;
    private javax.swing.JLabel lblUser;
    private javax.swing.JScrollPane sPanelUserForm;
    private javax.swing.JScrollPane sPanelUserList;
    private javax.swing.JTable tblSocialMediaList;
    private javax.swing.JTextField txtRowId;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
