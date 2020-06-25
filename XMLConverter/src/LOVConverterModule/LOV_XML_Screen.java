/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOVConverterModule;
import SystemSettingsModule.AboutViewScreen;
import SystemSettingsModule.AboutSystemScreen;
import java.awt.event.ActionListener;
/**
 *
 * @author Matheus Cabral Rosa
 */
public class LOV_XML_Screen extends javax.swing.JFrame {
    // Class Instances
    AboutViewScreen aboutView;
    AboutSystemScreen aboutSystem;  
    
    
    // Constructor
    public LOV_XML_Screen() {
        initComponents();
        aboutView = new AboutViewScreen();
        aboutSystem = new AboutSystemScreen();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.clearLblLog();
    }
    
    // Control functions
    // Functions to set data on Components
    public void setTxtPath(String item){ txtPath.setText(item); txtPath.paintImmediately(txtPath.getVisibleRect()); }
    public void setLblLog(String log) {lblLog.setText(log); lblLog.paintImmediately(lblLog.getVisibleRect());}
    public void setTxtIfRowBatchNum(String item){ txtIfRowBatchNum.setText(item); txtIfRowBatchNum.paintImmediately(txtIfRowBatchNum.getVisibleRect()); }
    public void setTxtIfRowStat(String item){ txtIfRowStat.setText(item); txtIfRowStat.paintImmediately(txtIfRowStat.getVisibleRect()); }
    public void setTxtLovWSId(String item){ txtLovWSId.setText(item); txtLovWSId.paintImmediately(txtLovWSId.getVisibleRect()); }
    public void setCbbLovMorgDsalwFlg(String item){ cbbLovMorgDsalwFlg.addItem(item); cbbLovMorgDsalwFlg.paintImmediately(cbbLovMorgDsalwFlg.getVisibleRect());}
    public void setCbbLovReqdLicFlg(String item){ cbbLovReqdLicFlg.addItem(item); cbbLovReqdLicFlg.paintImmediately(cbbLovReqdLicFlg.getVisibleRect());}
    
    // Functions to clear the Components data
    public void clearTxtPath(){ txtPath.setText(""); txtPath.paintImmediately(txtPath.getVisibleRect()); }
    public void clearLblLog() {lblLog.setText(""); lblLog.paintImmediately(lblLog.getVisibleRect());}
    public void clearTxtIfRowBatchNum(){ txtIfRowBatchNum.setText(""); txtIfRowBatchNum.paintImmediately(txtIfRowBatchNum.getVisibleRect()); }
    public void clearTxtIfRowStat(){ txtIfRowStat.setText(""); txtIfRowStat.paintImmediately(txtIfRowStat.getVisibleRect()); }
    public void clearTxtLovWSId(){ txtLovWSId.setText(""); txtLovWSId.paintImmediately(txtLovWSId.getVisibleRect()); }
    public void clearCbbLovMorgDsalwFlg(){ cbbLovMorgDsalwFlg.removeAllItems(); cbbLovMorgDsalwFlg.paintImmediately(cbbLovMorgDsalwFlg.getVisibleRect());}
    public void clearCbbLovReqdLicFlg(){ cbbLovReqdLicFlg.removeAllItems(); cbbLovReqdLicFlg.paintImmediately(cbbLovReqdLicFlg.getVisibleRect());}
    
    // Functions to return data from Components
    public String getTxtPath(){ return txtPath.getText().toString(); }
    public String getTxtIfRowBatchNum(){ return txtIfRowBatchNum.getText().toString(); }
    public String getTxtIfRowStat(){ return txtIfRowStat.getText().toString(); }
    public String getTxtLovWSId(){ return txtLovWSId.getText().toString(); }
    public String getCbbLovMorgDsalwFlg(){ return cbbLovMorgDsalwFlg.getSelectedItem().toString(); }
    public String getCbbLovReqdLicFlg(){ return cbbLovReqdLicFlg.getSelectedItem().toString(); }
    
        
    // Functions to enable or disable Components
    public void setTxtPathEnabled(boolean status){ this.txtPath.setEnabled(status); }
    public void setLoadFileEnabled(boolean status){ this.btnLoadFile.setEnabled(status); }
    public void setBtnSaveEnabled(boolean status){ this.btnSave.setEnabled(status); }
    public void setTxtIfRowBatchNumEnabled(boolean status){ this.txtIfRowBatchNum.setEnabled(status); }
    public void setTxtIfRowStatEnabled(boolean status){ this.txtIfRowStat.setEnabled(status); }
    public void setTxtLovWSIdEnabled(boolean status){ this.txtLovWSId.setEnabled(status); }
    public void setCbbLovMorgDsalwFlgEnabled(boolean status){ this.cbbLovMorgDsalwFlg.setEnabled(status); }
    public void setCbbLovReqdLicFlgEnabled(boolean status){ this.cbbLovReqdLicFlg.setEnabled(status); }
        
    // Functions to return the Components Status
    public boolean isTxtPathEnabled(){ return this.txtPath.isEnabled(); }
    public boolean isLoadFileEnabled(){ return this.btnLoadFile.isEnabled(); }
    public boolean isBtnSaveEnabled(){ return this.btnSave.isEnabled(); }
    public boolean isTxtIfRowBatchNumEnabled(){ return this.txtIfRowBatchNum.isEnabled(); }
    public boolean isTxtIfRowStatEnabled(){ return this.txtIfRowStat.isEnabled(); }
    public boolean isTxtLovWSIdEnabled(){ return this.txtLovWSId.isEnabled(); }
    public boolean isCbbLovMorgDsalwFlgEnabled(){ return this.cbbLovMorgDsalwFlg.isEnabled(); }
    public boolean isCbbLovReqdLicFlgEnabled(){ return this.cbbLovReqdLicFlg.isEnabled(); }
         
    public void clickSave(){ this.btnSave.setEnabled(true); this.btnSave.doClick(); this.btnSave.setEnabled(false); }
    
    // Listeners
    public void setListenerLoadFile(ActionListener loadFile) { btnLoadFile.addActionListener(loadFile); }
    public void setListenerSave(ActionListener save) { btnSave.addActionListener(save); }
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
        btnLoadFile = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtPath = new javax.swing.JFormattedTextField();
        jLabel16 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtIfRowBatchNum = new javax.swing.JFormattedTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtIfRowStat = new javax.swing.JFormattedTextField();
        lbl3 = new javax.swing.JLabel();
        txtLovWSId = new javax.swing.JFormattedTextField();
        lbl4 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        cbbLovReqdLicFlg = new javax.swing.JComboBox<>();
        cbbLovMorgDsalwFlg = new javax.swing.JComboBox<>();
        PanelResultComp = new javax.swing.JPanel();
        SubPanelResultCompRel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLOVResult = new javax.swing.JTable();
        btnSave = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lblLog = new javax.swing.JLabel();
        defaultMenu = new javax.swing.JMenuBar();
        fileMenuBtn = new javax.swing.JMenu();
        closeMenuBtn = new javax.swing.JMenuItem();
        helpMenuBtn = new javax.swing.JMenu();
        aboutViewMenuBtn = new javax.swing.JMenuItem();
        aboutSystemMenuBtn = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("XML Converter");
        setBackground(new java.awt.Color(255, 255, 255));
        setLocationByPlatform(true);
        setName("BatimentoFrame"); // NOI18N
        setSize(new java.awt.Dimension(1366, 768));

        PanelMain.setBackground(new java.awt.Color(255, 255, 255));
        PanelMain.setName("Configurações do ambiente"); // NOI18N

        PanelGeneralConf.setBackground(new java.awt.Color(255, 255, 255));
        PanelGeneralConf.setName(""); // NOI18N

        btnLoadFile.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnLoadFile.setText("Carregar");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Conversor de XML de LOV");

        txtPath.setEditable(false);
        txtPath.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        txtPath.setToolTipText("01/01/2001");
        txtPath.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setText("Arquivo:");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Configurações Gerais"));

        txtIfRowBatchNum.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        txtIfRowBatchNum.setText("2010");
        txtIfRowBatchNum.setToolTipText("01/01/2001");
        txtIfRowBatchNum.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel17.setText("IF_ROW_BATCH_NUM:");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel18.setText("IF_ROW_STAT:");

        txtIfRowStat.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        txtIfRowStat.setText("FOR_IMPORT");
        txtIfRowStat.setToolTipText("01/01/2001");
        txtIfRowStat.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lbl3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl3.setText("LOV_WS_ID:");

        txtLovWSId.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        txtLovWSId.setText("1@981");
        txtLovWSId.setToolTipText("01/01/2001");
        txtLovWSId.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lbl4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl4.setText("LOV_REQD_LIC_FLG:");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel21.setText("LOV_MORG_DSALW_FLG:");

        cbbLovReqdLicFlg.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "N", "Y" }));

        cbbLovMorgDsalwFlg.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "N", "Y" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIfRowStat, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIfRowBatchNum, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbl4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbLovReqdLicFlg, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbl3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtLovWSId, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbbLovMorgDsalwFlg, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(173, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIfRowBatchNum, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(txtLovWSId, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl3)
                    .addComponent(jLabel21)
                    .addComponent(cbbLovMorgDsalwFlg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIfRowStat, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(lbl4)
                    .addComponent(cbbLovReqdLicFlg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PanelGeneralConfLayout = new javax.swing.GroupLayout(PanelGeneralConf);
        PanelGeneralConf.setLayout(PanelGeneralConfLayout);
        PanelGeneralConfLayout.setHorizontalGroup(
            PanelGeneralConfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelGeneralConfLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelGeneralConfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PanelGeneralConfLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPath)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLoadFile)))
                .addContainerGap())
        );
        PanelGeneralConfLayout.setVerticalGroup(
            PanelGeneralConfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelGeneralConfLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelGeneralConfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelGeneralConfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPath, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16)
                        .addComponent(btnLoadFile))
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PanelResultComp.setBackground(new java.awt.Color(237, 237, 237));

        SubPanelResultCompRel.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setOpaque(false);

        tblLOVResult.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblLOVResult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TYPE", "NAME", "VAL", "SUB_TYPE", "ORDER_BY", "LOW", "HIGH", "ACTIVE_FLG", "TRANSLATE_FLG", "MULTILINGUAL_FLG", "RPLCTN_LVL_CD", "TARGET_LOW", "TARGET_HIGH", "LANG_ID", "PARENT_LANGUAGE", "DFLT_LIC_FLG", "MODIFIABLE", "PARENT_VALUE", "PARENT", "PARENT_TYPE", "CODE", "PARENT_SUBTYPE", "PARENT_ORGANIZATION", "FIBER_RELEASE", "WEIGHTING_FACTOR", "ORGANIZATION", "DESC_TEXT", "LANGUAGE_CODE", "LANGUAGE_NAME"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblLOVResult.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblLOVResult.setColumnSelectionAllowed(true);
        tblLOVResult.setGridColor(new java.awt.Color(255, 255, 255));
        tblLOVResult.setName("tblLOVResult"); // NOI18N
        tblLOVResult.setOpaque(false);
        jScrollPane1.setViewportView(tblLOVResult);
        tblLOVResult.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        javax.swing.GroupLayout SubPanelResultCompRelLayout = new javax.swing.GroupLayout(SubPanelResultCompRel);
        SubPanelResultCompRel.setLayout(SubPanelResultCompRelLayout);
        SubPanelResultCompRelLayout.setHorizontalGroup(
            SubPanelResultCompRelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        SubPanelResultCompRelLayout.setVerticalGroup(
            SubPanelResultCompRelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
        );

        btnSave.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSave.setText("Salvar");
        btnSave.setToolTipText("");
        btnSave.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Resultado");

        lblLog.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblLog.setText("LOG");
        lblLog.setEnabled(false);

        javax.swing.GroupLayout PanelResultCompLayout = new javax.swing.GroupLayout(PanelResultComp);
        PanelResultComp.setLayout(PanelResultCompLayout);
        PanelResultCompLayout.setHorizontalGroup(
            PanelResultCompLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SubPanelResultCompRel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PanelResultCompLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(lblLog, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addGroup(PanelResultCompLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lblLog, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
        aboutSystemMenuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutSystemMenuBtnActionPerformed(evt);
            }
        });
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
        System.exit(0);
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

    private void aboutSystemMenuBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutSystemMenuBtnActionPerformed
        aboutSystem.openScreen("", "");
    }//GEN-LAST:event_aboutSystemMenuBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelGeneralConf;
    private javax.swing.JPanel PanelMain;
    private javax.swing.JPanel PanelResultComp;
    private javax.swing.JPanel SubPanelResultCompRel;
    private javax.swing.JMenuItem aboutSystemMenuBtn;
    private javax.swing.JMenuItem aboutViewMenuBtn;
    private javax.swing.JButton btnLoadFile;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cbbLovMorgDsalwFlg;
    private javax.swing.JComboBox<String> cbbLovReqdLicFlg;
    private javax.swing.JMenuItem closeMenuBtn;
    private javax.swing.JMenuBar defaultMenu;
    private javax.swing.JMenu fileMenuBtn;
    private javax.swing.JMenu helpMenuBtn;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl3;
    private javax.swing.JLabel lbl4;
    private javax.swing.JLabel lblLog;
    public javax.swing.JTable tblLOVResult;
    private javax.swing.JFormattedTextField txtIfRowBatchNum;
    private javax.swing.JFormattedTextField txtIfRowStat;
    private javax.swing.JFormattedTextField txtLovWSId;
    private javax.swing.JFormattedTextField txtPath;
    // End of variables declaration//GEN-END:variables
}
