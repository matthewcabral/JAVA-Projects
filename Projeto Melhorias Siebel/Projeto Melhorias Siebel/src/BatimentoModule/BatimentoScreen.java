/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BatimentoModule;
import SystemSettingsModule.AboutViewScreen;
import SystemSettingsModule.AboutSystemScreen;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
/**
 *
 * @author Matheus Cabral Rosa
 */
public class BatimentoScreen extends javax.swing.JFrame {
    // Class Instances
    AboutViewScreen aboutView;
    AboutSystemScreen aboutSystem;  
    
    
    // Constructor
    public BatimentoScreen() {
        initComponents();
        aboutView = new AboutViewScreen();
        aboutSystem = new AboutSystemScreen();
        this.setLog("");
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    // Control functions
    // Functions to insert data on Components
    public void insertCbbProj(String item){ cbbProj.addItem(item); cbbProj.paintImmediately(cbbProj.getVisibleRect()); }
    public void insertTxtDateSearchSpec(String item){ txtDateSearchSpec.setText(item); txtDateSearchSpec.paintImmediately(txtDateSearchSpec.getVisibleRect()); }
    public void insertCbbAmbOri(String item){ cbbFistAmb.addItem(item); cbbFistAmb.paintImmediately(cbbFistAmb.getVisibleRect()); }
    public void insertCbbAmbDest(String item){ cbbSecAmb.addItem(item); cbbSecAmb.paintImmediately(cbbSecAmb.getVisibleRect()); }
    public void insertCbbRepOri(String item){ cbbFistRep.addItem(item); cbbFistRep.paintImmediately(cbbFistRep.getVisibleRect()); }
    public void insertCbbRepDest(String item){ cbbSecRep.addItem(item); cbbSecRep.paintImmediately(cbbSecRep.getVisibleRect()); }
    
    // Functions to clear the Components data 
    public void clearCbbProj(){ cbbProj.removeAllItems(); cbbProj.paintImmediately(cbbProj.getVisibleRect()); }
    public void clearTxtDateSearchSpec(){ txtDateSearchSpec.setText(""); txtDateSearchSpec.paintImmediately(txtDateSearchSpec.getVisibleRect()); }
    public void clearCbbAmbOri(){ cbbFistAmb.removeAllItems(); cbbFistAmb.paintImmediately(cbbFistAmb.getVisibleRect()); }
    public void clearCbbAmbDest(){ cbbSecAmb.removeAllItems(); cbbSecAmb.paintImmediately(cbbSecAmb.getVisibleRect()); }
    public void clearCbbRepOri(){ cbbFistRep.removeAllItems(); cbbFistRep.paintImmediately(cbbFistRep.getVisibleRect()); }
    public void clearCbbRepDest(){ cbbSecRep.removeAllItems(); cbbSecRep.paintImmediately(cbbSecRep.getVisibleRect()); }
    
    // Functions to return data from Components
    public String getCbbProj(){ return cbbProj.getSelectedItem().toString(); }
    public String getTxtDateSearchSpec(){ return txtDateSearchSpec.getText(); }
    public String getCbbAmbOri(){ return cbbFistAmb.getSelectedItem().toString(); }
    public String getCbbAmbDest(){ return cbbSecAmb.getSelectedItem().toString(); }
    public String getCbbRepOri(){ return cbbFistRep.getSelectedItem().toString(); }
    public String getCbbRepDest(){ return cbbSecRep.getSelectedItem().toString(); }
        
    // Functions to enable or disable Components
    public void setCbbProjEnabled(boolean status){ this.cbbProj.setEnabled(status); }
    public void setTxtDateSearchSpecEnabled(boolean status){ this.txtDateSearchSpec.setEnabled(status); }
    public void setCbbAmbOriEnabled(boolean status){ this.cbbFistAmb.setEnabled(status); }
    public void setCbbAmbDestEnabled(boolean status){ this.cbbSecAmb.setEnabled(status); }
    public void setCbbRepOriEnabled(boolean status){ this.cbbFistRep.setEnabled(status); }
    public void setCbbRepDestEnabled(boolean status){ this.cbbSecRep.setEnabled(status); }
    public void setBtnExecEnabled(boolean status){ this.btnExecBatimento.setEnabled(status); }
    public void setBtnSaveEnabled(boolean status){ this.btnSave.setEnabled(status); }
    
    // Functions to return the Components Status
    public boolean isCbbProjEnabled(){ return this.cbbProj.isEnabled(); }
    public boolean isTxtDateSearchSpecEnabled(){ return this.txtDateSearchSpec.isEnabled(); }
    public boolean isCbbAmbOriEnabled(){ return this.cbbFistAmb.isEnabled(); }
    public boolean isCbbAmbDestEnabled(){ return this.cbbSecAmb.isEnabled(); }
    public boolean isCbbRepOriEnabled(){ return this.cbbFistRep.isEnabled(); }
    public boolean isCbbRepDestEnabled(){ return this.cbbSecRep.isEnabled(); }
    public boolean isBtnExecEnabled(){ return this.btnExecBatimento.isEnabled(); }
    public boolean isBtnSaveEnabled(){ return this.btnSave.isEnabled(); }
    
    // Functions to return the Components items quantity
    public int getCbbProjSize(){ return this.cbbProj.getItemCount(); }
    public int getCbbAmbOriSize(){ return this.cbbFistAmb.getItemCount(); }
    public int getCbbAmbDestSize(){ return this.cbbSecAmb.getItemCount(); }
    public int getCbbRepOriSize(){ return this.cbbFistRep.getItemCount(); }
    public int getCbbRepDestSize(){ return this.cbbSecRep.getItemCount(); }
        
    // Function used to display Log on screen
    public void setLog(String logMessage){
        lblLog.setText("");
        lblLog.setText(logMessage);
        lblLog.paintImmediately(lblLog.getVisibleRect());
    }
    
    public void clickSave(){ this.btnSave.setEnabled(true); this.btnSave.doClick(); this.btnSave.setEnabled(false); }
        
    // Listeners
    public void setListenerExecBat(ActionListener exec) { btnExecBatimento.addActionListener(exec); }
    public void setListenerSave(ActionListener save) { btnSave.addActionListener(save); }
    public void setListenerCbbProj(ItemListener state){ cbbProj.addItemListener(state); }
    public void setListenerAmbOri(ItemListener state){ cbbFistAmb.addItemListener(state); }
    public void setListenerAmbDest(ItemListener state){ cbbSecAmb.addItemListener(state); }
    public void setListenerAboutSystem(ActionListener about) { aboutSystemMenuBtn.addActionListener(about); }
            
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelMain = new javax.swing.JPanel();
        PanelGeneralConf = new javax.swing.JPanel();
        SubPanelGeneralConfItems = new javax.swing.JPanel();
        SubPCGProj = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbbProj = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        txtDateSearchSpec = new javax.swing.JFormattedTextField();
        SubPCGAmbOri = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbbFistAmb = new javax.swing.JComboBox();
        cbbFistRep = new javax.swing.JComboBox();
        SubPCGAmbDes = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cbbSecAmb = new javax.swing.JComboBox();
        cbbSecRep = new javax.swing.JComboBox();
        btnExecBatimento = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        PanelResultComp = new javax.swing.JPanel();
        SubPanelResultCompRel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dtRelatorioBatimento = new javax.swing.JTable();
        btnSave = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lblLog = new javax.swing.JLabel();
        defaultMenu = new javax.swing.JMenuBar();
        fileMenuBtn = new javax.swing.JMenu();
        closeMenuBtn = new javax.swing.JMenuItem();
        helpMenuBtn = new javax.swing.JMenu();
        aboutViewMenuBtn = new javax.swing.JMenuItem();
        aboutSystemMenuBtn = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ferramenta de Comparação de Ambientes Siebel");
        setBackground(new java.awt.Color(255, 255, 255));
        setLocationByPlatform(true);
        setName("BatimentoFrame"); // NOI18N
        setSize(new java.awt.Dimension(1366, 768));

        PanelMain.setBackground(new java.awt.Color(255, 255, 255));
        PanelMain.setName("Configurações do ambiente"); // NOI18N

        PanelGeneralConf.setBackground(new java.awt.Color(237, 237, 237));
        PanelGeneralConf.setName(""); // NOI18N

        SubPanelGeneralConfItems.setBackground(new java.awt.Color(255, 255, 255));

        SubPCGProj.setBackground(new java.awt.Color(255, 255, 255));
        SubPCGProj.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Configurações Gerais", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 0, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Projeto:");
        jLabel1.setToolTipText("");

        cbbProj.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setText("Data a partir:");

        txtDateSearchSpec.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        txtDateSearchSpec.setToolTipText("01/01/2001");
        txtDateSearchSpec.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout SubPCGProjLayout = new javax.swing.GroupLayout(SubPCGProj);
        SubPCGProj.setLayout(SubPCGProjLayout);
        SubPCGProjLayout.setHorizontalGroup(
            SubPCGProjLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SubPCGProjLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SubPCGProjLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SubPCGProjLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDateSearchSpec)
                    .addComponent(cbbProj, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        SubPCGProjLayout.setVerticalGroup(
            SubPCGProjLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SubPCGProjLayout.createSequentialGroup()
                .addGroup(SubPCGProjLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbbProj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SubPCGProjLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDateSearchSpec, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        SubPCGAmbOri.setBackground(new java.awt.Color(255, 255, 255));
        SubPCGAmbOri.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ambiente de Origem", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 0, 14))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Repositório:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Ambiente:");

        cbbFistAmb.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbbFistAmb.setEnabled(false);

        cbbFistRep.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbbFistRep.setEnabled(false);
        cbbFistRep.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbFistRepItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout SubPCGAmbOriLayout = new javax.swing.GroupLayout(SubPCGAmbOri);
        SubPCGAmbOri.setLayout(SubPCGAmbOriLayout);
        SubPCGAmbOriLayout.setHorizontalGroup(
            SubPCGAmbOriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SubPCGAmbOriLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SubPCGAmbOriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SubPCGAmbOriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbbFistAmb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbbFistRep, 0, 190, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        SubPCGAmbOriLayout.setVerticalGroup(
            SubPCGAmbOriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SubPCGAmbOriLayout.createSequentialGroup()
                .addGroup(SubPCGAmbOriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cbbFistAmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SubPCGAmbOriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cbbFistRep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        SubPCGAmbDes.setBackground(new java.awt.Color(255, 255, 255));
        SubPCGAmbDes.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ambiente de Destino", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 0, 14))); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("Repositório:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("Ambiente:");

        cbbSecAmb.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbbSecAmb.setEnabled(false);

        cbbSecRep.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbbSecRep.setEnabled(false);
        cbbSecRep.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbSecRepItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout SubPCGAmbDesLayout = new javax.swing.GroupLayout(SubPCGAmbDes);
        SubPCGAmbDes.setLayout(SubPCGAmbDesLayout);
        SubPCGAmbDesLayout.setHorizontalGroup(
            SubPCGAmbDesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SubPCGAmbDesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SubPCGAmbDesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SubPCGAmbDesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbbSecAmb, 0, 190, Short.MAX_VALUE)
                    .addComponent(cbbSecRep, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        SubPCGAmbDesLayout.setVerticalGroup(
            SubPCGAmbDesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SubPCGAmbDesLayout.createSequentialGroup()
                .addGroup(SubPCGAmbDesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbSecAmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SubPCGAmbDesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbSecRep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout SubPanelGeneralConfItemsLayout = new javax.swing.GroupLayout(SubPanelGeneralConfItems);
        SubPanelGeneralConfItems.setLayout(SubPanelGeneralConfItemsLayout);
        SubPanelGeneralConfItemsLayout.setHorizontalGroup(
            SubPanelGeneralConfItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SubPanelGeneralConfItemsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SubPCGProj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SubPCGAmbOri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SubPCGAmbDes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(195, Short.MAX_VALUE))
        );
        SubPanelGeneralConfItemsLayout.setVerticalGroup(
            SubPanelGeneralConfItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SubPCGAmbOri, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(SubPanelGeneralConfItemsLayout.createSequentialGroup()
                .addComponent(SubPCGProj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(SubPCGAmbDes, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        btnExecBatimento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnExecBatimento.setText("Executar");
        btnExecBatimento.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Batimento de Ambientes");

        javax.swing.GroupLayout PanelGeneralConfLayout = new javax.swing.GroupLayout(PanelGeneralConf);
        PanelGeneralConf.setLayout(PanelGeneralConfLayout);
        PanelGeneralConfLayout.setHorizontalGroup(
            PanelGeneralConfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SubPanelGeneralConfItems, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PanelGeneralConfLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExecBatimento)
                .addContainerGap())
        );
        PanelGeneralConfLayout.setVerticalGroup(
            PanelGeneralConfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelGeneralConfLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelGeneralConfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btnExecBatimento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(SubPanelGeneralConfItems, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );

        PanelResultComp.setBackground(new java.awt.Color(237, 237, 237));

        SubPanelResultCompRel.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setOpaque(false);

        dtRelatorioBatimento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        dtRelatorioBatimento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STATUS", "TIPO", "GRUPO_OBJETO", "NOME", "PAR_N1", "PAR_N2", "PAR_N3", "ORDEM", "DESCRICAO", "NOME_OBJETO_CAMPO", "COLUNA_TABELA", "VALOR_ORIGEM", "VALOR_DESTINO", "ULT_ATUAL_ORIGEM", "ULT_ATUAL_DEST", "ATUAL_POR_ORIGEM", "ATUAL_POR_DETINO", "ID_TAB_PAI", "ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        dtRelatorioBatimento.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        dtRelatorioBatimento.setColumnSelectionAllowed(true);
        dtRelatorioBatimento.setGridColor(new java.awt.Color(255, 255, 255));
        dtRelatorioBatimento.setName("dtRelatorioBatimento"); // NOI18N
        dtRelatorioBatimento.setOpaque(false);
        jScrollPane1.setViewportView(dtRelatorioBatimento);
        dtRelatorioBatimento.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        javax.swing.GroupLayout SubPanelResultCompRelLayout = new javax.swing.GroupLayout(SubPanelResultCompRel);
        SubPanelResultCompRel.setLayout(SubPanelResultCompRelLayout);
        SubPanelResultCompRelLayout.setHorizontalGroup(
            SubPanelResultCompRelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1040, Short.MAX_VALUE)
        );
        SubPanelResultCompRelLayout.setVerticalGroup(
            SubPanelResultCompRelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        btnSave.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSave.setText("Salvar");
        btnSave.setToolTipText("");
        btnSave.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Resultado");

        lblLog.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblLog.setText("LOG");

        javax.swing.GroupLayout PanelResultCompLayout = new javax.swing.GroupLayout(PanelResultComp);
        PanelResultComp.setLayout(PanelResultCompLayout);
        PanelResultCompLayout.setHorizontalGroup(
            PanelResultCompLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SubPanelResultCompRel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PanelResultCompLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSave)
                .addContainerGap())
        );
        PanelResultCompLayout.setVerticalGroup(
            PanelResultCompLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelResultCompLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelResultCompLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSave)
                    .addComponent(jLabel3)
                    .addComponent(lblLog, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SubPanelResultCompRel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PanelMainLayout = new javax.swing.GroupLayout(PanelMain);
        PanelMain.setLayout(PanelMainLayout);
        PanelMainLayout.setHorizontalGroup(
            PanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelGeneralConf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelResultComp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelMainLayout.setVerticalGroup(
            PanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMainLayout.createSequentialGroup()
                .addComponent(PanelGeneralConf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelResultComp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        fileMenuBtn.setText("Arquivo");

        closeMenuBtn.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        closeMenuBtn.setText("Sair");
        closeMenuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeMenuBtnActionPerformed(evt);
            }
        });
        fileMenuBtn.add(closeMenuBtn);

        defaultMenu.add(fileMenuBtn);

        helpMenuBtn.setText("Ajuda");

        aboutViewMenuBtn.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_K, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        aboutViewMenuBtn.setText("Sobre a visualização");
        aboutViewMenuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutViewMenuBtnActionPerformed(evt);
            }
        });
        helpMenuBtn.add(aboutViewMenuBtn);

        aboutSystemMenuBtn.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        aboutSystemMenuBtn.setText("Sobre o sistema");
        helpMenuBtn.add(aboutSystemMenuBtn);

        defaultMenu.add(helpMenuBtn);

        setJMenuBar(defaultMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelMain, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeMenuBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeMenuBtnActionPerformed
        this.dispose();
    }//GEN-LAST:event_closeMenuBtnActionPerformed

    private void aboutViewMenuBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutViewMenuBtnActionPerformed
        aboutView.openScreen(
            "[Módulo 1]: Batimento; " + 
            "[Módulo 2]: Database;",
            "[Screen 1]: BatimentoScreen; ",
            "<html>" +
            "[Classe 1]: BatimentoController; <br/>" +
            "<p>[Classe 1.1]: BatimentoThread; <br/></p>" +
            "<p>[Classe 1.2]: RelatorioBatimentoController; <br/></p>" +
            "<p>[Classe 1.3]: RelatorioBatimentoBS; <br/></p>" +
            "[Classe 2]: Controller; <br/>" +
            "<p>[Classe 2.1]: DataController; <br/></p>" +
            "<p>[Classe 2.2]: SqlInstructions; <br/></p>" +
            "<p>[Classe 2.3]: exceptionsController;</p>" +
            "</html>"
        );
    }//GEN-LAST:event_aboutViewMenuBtnActionPerformed

    private void cbbFistRepItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbFistRepItemStateChanged
        cbbSecAmb.setEnabled(true);  
    }//GEN-LAST:event_cbbFistRepItemStateChanged

    private void cbbSecRepItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbSecRepItemStateChanged
        if(cbbSecRep.isEnabled()){
            btnExecBatimento.setEnabled(true);
        }
    }//GEN-LAST:event_cbbSecRepItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelGeneralConf;
    private javax.swing.JPanel PanelMain;
    private javax.swing.JPanel PanelResultComp;
    private javax.swing.JPanel SubPCGAmbDes;
    private javax.swing.JPanel SubPCGAmbOri;
    private javax.swing.JPanel SubPCGProj;
    private javax.swing.JPanel SubPanelGeneralConfItems;
    private javax.swing.JPanel SubPanelResultCompRel;
    private javax.swing.JMenuItem aboutSystemMenuBtn;
    private javax.swing.JMenuItem aboutViewMenuBtn;
    private javax.swing.JButton btnExecBatimento;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox cbbFistAmb;
    private javax.swing.JComboBox cbbFistRep;
    private javax.swing.JComboBox cbbProj;
    private javax.swing.JComboBox cbbSecAmb;
    private javax.swing.JComboBox cbbSecRep;
    private javax.swing.JMenuItem closeMenuBtn;
    private javax.swing.JMenuBar defaultMenu;
    public javax.swing.JTable dtRelatorioBatimento;
    private javax.swing.JMenu fileMenuBtn;
    private javax.swing.JMenu helpMenuBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblLog;
    private javax.swing.JFormattedTextField txtDateSearchSpec;
    // End of variables declaration//GEN-END:variables
}
