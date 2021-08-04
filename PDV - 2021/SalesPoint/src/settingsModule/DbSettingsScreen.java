/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package settingsModule;

import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

/**
 *
 * @author mcabralr
 */
public class DbSettingsScreen extends javax.swing.JFrame {
    
    /** Creates new form GeneralSettingsScreen */
    public DbSettingsScreen() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        clearLblPath();
        setLblPath("Caminho do arquivo: " + System.getProperty("user.home") + "\\SalesPoint\\Settings\\db_conf.conf");
        
    }
    
    // Listeners
    // Enviroments
    public void setListenerBtnTestDB(ActionListener listener) { btnTestDB.addActionListener(listener); }
    public void setListenerBtnSaveDBParam(ActionListener listener) { btnSaveDBParam.addActionListener(listener); }
    public void setListenerCbbDriverName(ItemListener listener) { cbbDriverName.addItemListener(listener); }
    public void setListenerCbbDriver(ItemListener listener) { cbbDriver.addItemListener(listener); }
    
    // Control functions
    
    // Functions to insert data on Components    
    public void settxtURL(String item){ txtURL.setText(item); txtURL.paintImmediately(txtURL.getVisibleRect()); }
    public void settxtLocal(String item){ txtLocal.setText(item); txtLocal.paintImmediately(txtLocal.getVisibleRect()); }
    public void settxtPort(String item){ txtPort.setText(item); txtPort.paintImmediately(txtPort.getVisibleRect()); }
    public void settxtDBName(String item){ txtDBName.setText(item); txtDBName.paintImmediately(txtDBName.getVisibleRect()); }
    public void settxtOwner(String item){ txtOwner.setText(item); txtOwner.paintImmediately(txtOwner.getVisibleRect()); }
    public void settxtUser(String item) { txtUser.setText(item); txtUser.paintImmediately(txtUser.getVisibleRect()); }
    public void settxtPassword(String item) { txtPassword.setText(item); txtPassword.paintImmediately(txtPassword.getVisibleRect()); }
    public void setcbbDriver(String item){ cbbDriver.addItem(item); cbbDriver.paintImmediately(cbbDriver.getVisibleRect()); }
    public void setcbbDriverName(String item){ cbbDriverName.addItem(item); cbbDriverName.paintImmediately(cbbDriverName.getVisibleRect()); }
    
    public void setCbbDriverItemIndex(int item) { cbbDriver.setSelectedIndex(item); cbbDriver.paintImmediately(cbbDriver.getVisibleRect()); }
    public void setCbbDriverNameItemIndex(int item) { cbbDriverName.setSelectedIndex(item); cbbDriverName.paintImmediately(cbbDriverName.getVisibleRect()); }
    public void setLblPath(String item) { lblPath.setText(item); lblPath.paintImmediately(lblPath.getVisibleRect()); }
    
    // Functions to clear the Components data    
    public void cleartxtURL(){ txtURL.setText(""); txtURL.paintImmediately(txtURL.getVisibleRect()); }
    public void cleartxtLocal(){ txtLocal.setText(""); txtLocal.paintImmediately(txtLocal.getVisibleRect()); }
    public void cleartxtPort(){ txtPort.setText(""); txtPort.paintImmediately(txtPort.getVisibleRect()); }
    public void cleartxtDBName(){ txtDBName.setText(""); txtDBName.paintImmediately(txtDBName.getVisibleRect()); }
    public void cleartxtOwner(){ txtOwner.setText(""); txtOwner.paintImmediately(txtOwner.getVisibleRect()); }
    public void cleartxtUser() { txtUser.setText(""); txtUser.paintImmediately(txtUser.getVisibleRect()); }
    public void cleartxtPassword() { txtPassword.setText(""); txtPassword.paintImmediately(txtPassword.getVisibleRect()); }
    public void clearcbbDriver() { cbbDriver.removeAllItems(); cbbDriver.paintImmediately(cbbDriver.getVisibleRect()); }
    public void clearcbbDriverName(){ cbbDriverName.removeAllItems(); cbbDriverName.paintImmediately(cbbDriverName.getVisibleRect()); }
    public void clearLblPath() { lblPath.setText(""); lblPath.paintImmediately(lblPath.getVisibleRect()); }
    
    // Functions to return data from Components
    public String gettxtURL(){ return txtURL.getText(); }
    public String gettxtLocal(){ return txtLocal.getText(); }
    public String gettxtPort(){ return txtPort.getText(); }
    public String gettxtDBName(){ return txtDBName.getText(); }
    public String gettxtOwner(){ return txtOwner.getText(); }
    public String getcbbDriver(){ return ((!"Selecione...".equals(cbbDriver.getSelectedItem().toString()) && cbbDriver.getSelectedItem().toString() != null) ? cbbDriver.getSelectedItem().toString() : null); }
    public String getCbbDriverName() { return ((!"Selecione...".equals(cbbDriverName.getSelectedItem().toString()) && cbbDriverName.getSelectedItem().toString() != null) ? cbbDriverName.getSelectedItem().toString() : null ); }
    public String gettxtUser() { return txtUser.getText(); }
    public String gettxtPassword() { return txtPassword.getText(); }

    public int getCbbDriverItemIndex(String value) { if(!"".equals(value) && value != null) { for(int i = 0; i < this.cbbDriver.getItemCount(); i++){ if(value.equals(this.cbbDriver.getItemAt(i))){ return i; }}} else { return 0; } return 0; }
    public int getCbbDriverNameItemIndex(String value) { if(!"".equals(value) && value != null) { for(int i = 0; i < this.cbbDriverName.getItemCount(); i++){ if(value.equals(this.cbbDriverName.getItemAt(i))){ return i; }}} else { return 0; } return 0; }
    
    // Functions to enable or disable Components
    public void setcbbDriverEnabled(boolean status){ this.cbbDriver.setEnabled(status); }
    public void settxtURLEnabled(boolean status){ this.txtURL.setEnabled(status); }
    public void settxtLocalEnabled(boolean status){ this.txtLocal.setEnabled(status); }
    public void settxtPortEnabled(boolean status){ this.txtPort.setEnabled(status); }
    public void settxtDBNameEnabled(boolean status){ this.txtDBName.setEnabled(status); }
    public void settxtOwnerEnabled(boolean status){ this.txtOwner.setEnabled(status); }
    public void setbtnTestDBEnabled(boolean status){ this.btnTestDB.setEnabled(status); }
    public void setbtnSaveDBParamEnabled(boolean status){ this.btnSaveDBParam.setEnabled(status); }
    public void settxtUserEnabled(boolean status) { this.txtUser.setEnabled(status); }
    public void settxtPasswordEnabled(boolean status) { this.txtPassword.setEnabled(status); }
        
    // Functions to return the Components Status
    public boolean iscbbDriverEnabled(){ return cbbDriver.isEnabled(); }
    public boolean istxtURLEnabled(){ return txtURL.isEnabled(); }
    public boolean istxtLocalEnabled(){ return txtLocal.isEnabled(); }
    public boolean istxtPortEnabled(){ return txtPort.isEnabled(); }
    public boolean istxtDBNamerEnabled(){ return txtDBName.isEnabled(); }
    public boolean istxtOwnerEnabled(){ return txtOwner.isEnabled(); }
    public boolean isbtnTestDBEnabled(){ return btnTestDB.isEnabled(); }
    public boolean isbtnSaveDBParamEnabled(){ return btnSaveDBParam.isEnabled(); }
    public boolean istxtUserEnabled(){ return txtUser.isEnabled(); }
    public boolean istxtPasswordEnabled(){ return txtPassword.isEnabled(); }
    
    public void setFocus(String component) {
        switch(component) {
            case "TXT_DRIVER":
                cbbDriver.requestFocus();
                break;
            case "TXT_URL":
                txtURL.requestFocus();
                break;
            case "TXT_LOCAL":
                txtLocal.requestFocus();
                break;
            case "TXT_PORTA":
                txtPort.requestFocus();
                break;
            case "TXT_NAME":
                txtDBName.requestFocus();
                break;
            case "TXT_OWNER":
                txtOwner.requestFocus();
                break;
            case "BTN_TESTE":
                btnTestDB.requestFocus();
            case "BTN_SAVE":
                btnSaveDBParam.requestFocus();    
            default:
                break;
        }
    }
    
    public void clearComboBoxes(){
        clearcbbDriver();
        clearcbbDriverName();
    }
    
    public void clearFields() {
        cleartxtDBName();
        cleartxtLocal();
        cleartxtOwner();
        cleartxtPassword();
        cleartxtPort();
        cleartxtURL();
        cleartxtUser();
    }
    
    public void insertSelectComboBox(){
        this.setcbbDriver("Selecione...");
        this.setcbbDriverName("Selecione...");
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblScreen = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtLocal = new javax.swing.JTextField();
        txtPort = new javax.swing.JTextField();
        txtDBName = new javax.swing.JTextField();
        txtOwner = new javax.swing.JTextField();
        lblOwner = new javax.swing.JLabel();
        lblLlocal = new javax.swing.JLabel();
        lblPort = new javax.swing.JLabel();
        lblDriver = new javax.swing.JLabel();
        lblDBName = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblDriver1 = new javax.swing.JLabel();
        cbbDriverName = new javax.swing.JComboBox<>();
        txtUser = new javax.swing.JTextField();
        lblOwner1 = new javax.swing.JLabel();
        lblOwner2 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        lblPath = new javax.swing.JLabel();
        lblURL = new javax.swing.JLabel();
        txtURL = new javax.swing.JTextField();
        btnTestDB = new javax.swing.JButton();
        cbbDriver = new javax.swing.JComboBox<>();
        btnSaveDBParam = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Assistente de Nova Conexão");
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        lblScreen.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblScreen.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblScreen.setText("Conexão com o Banco de Dados");
        lblScreen.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Personalizar Conexão", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        txtLocal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtLocal.setText("localhost");

        txtPort.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtPort.setText("1521");

        txtDBName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtDBName.setText("SALESPOINT");
        txtDBName.setToolTipText("");

        txtOwner.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtOwner.setText("SALESPOINT");
        txtOwner.setToolTipText("");

        lblOwner.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblOwner.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblOwner.setText("Table Owner:");

        lblLlocal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblLlocal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLlocal.setText("HOST:");

        lblPort.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblPort.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPort.setText("Porta:");

        lblDriver.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblDriver.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblDriver.setText("Driver:");

        lblDBName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblDBName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDBName.setText("SID, TNS ou Serviço:");
        lblDBName.setToolTipText("");

        lblDriver1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblDriver1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblDriver1.setText("Nome do Driver:");

        cbbDriverName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SID", "Service Name", "TNS" }));

        txtUser.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lblOwner1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblOwner1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblOwner1.setText("Nome do Usuário:");

        lblOwner2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblOwner2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblOwner2.setText("Senha:");

        lblPath.setText("Caminho do arquivo: C:\\Users\\userName\\XMLConverter\\Settings\\db_conf.conf");
        lblPath.setEnabled(false);

        lblURL.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblURL.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblURL.setText("JDBC URL:");

        txtURL.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtURL.setText("jdbc:oracle:thin:@");

        btnTestDB.setText("Testar Conexão");

        cbbDriver.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione...", "ORACLE SQL", "MySQL" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblLlocal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(565, 565, 565))
                    .addComponent(lblPath, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblOwner1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblOwner2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUser)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnTestDB)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtPassword)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(lblDriver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbDriver, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDBName)
                                    .addComponent(lblOwner, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtDBName, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(txtLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblPort)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtOwner, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel10)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(lblDriver1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(9, 9, 9))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(lblURL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(3, 3, 3)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtURL)
                                    .addComponent(cbbDriverName, 0, 497, Short.MAX_VALUE))))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDriver)
                    .addComponent(cbbDriver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDriver1)
                    .addComponent(cbbDriverName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtURL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblURL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLlocal)
                    .addComponent(txtLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPort)
                    .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDBName)
                    .addComponent(txtDBName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOwner)
                    .addComponent(txtOwner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblOwner1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOwner2)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTestDB)
                .addGap(23, 23, 23)
                .addComponent(lblPath)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10))
        );

        btnSaveDBParam.setText("Salvar");
        btnSaveDBParam.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblScreen, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSaveDBParam, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblScreen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSaveDBParam)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSaveDBParam;
    private javax.swing.JButton btnTestDB;
    private javax.swing.JComboBox<String> cbbDriver;
    private javax.swing.JComboBox<String> cbbDriverName;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblDBName;
    private javax.swing.JLabel lblDriver;
    private javax.swing.JLabel lblDriver1;
    private javax.swing.JLabel lblLlocal;
    private javax.swing.JLabel lblOwner;
    private javax.swing.JLabel lblOwner1;
    private javax.swing.JLabel lblOwner2;
    private javax.swing.JLabel lblPath;
    private javax.swing.JLabel lblPort;
    private javax.swing.JLabel lblScreen;
    private javax.swing.JLabel lblURL;
    private javax.swing.JTextField txtDBName;
    private javax.swing.JTextField txtLocal;
    private javax.swing.JTextField txtOwner;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtPort;
    private javax.swing.JTextField txtURL;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables

}
