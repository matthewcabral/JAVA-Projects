/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SystemSettingsModule;

import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author mcabralr
 */
public class GeneralSettingsScreen extends javax.swing.JFrame {
    
    /** Creates new form GeneralSettingsScreen */
    public GeneralSettingsScreen() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    // Listeners
    // Enviroments
    public void setListenerBtnTestDB(ActionListener listener) { btnTestDB.addActionListener(listener); }
    public void setListenerBtnSaveDBParam(ActionListener listener) { btnSaveDBParam.addActionListener(listener); }
    
    // Control functions
    
    // Functions to insert data on Components
    public void inserttxtDriver(String item){ txtDriver.setText(item); txtDriver.paintImmediately(txtDriver.getVisibleRect()); }
    public void inserttxtURL(String item){ txtURL.setText(item); txtURL.paintImmediately(txtURL.getVisibleRect()); }
    public void inserttxtLocal(String item){ txtLocal.setText(item); txtLocal.paintImmediately(txtLocal.getVisibleRect()); }
    public void inserttxtPort(String item){ txtPort.setText(item); txtPort.paintImmediately(txtPort.getVisibleRect()); }
    public void inserttxtDBName(String item){ txtDBName.setText(item); txtDBName.paintImmediately(txtDBName.getVisibleRect()); }
    public void inserttxtOwner(String item){ txtOwner.setText(item); txtOwner.paintImmediately(txtOwner.getVisibleRect()); }
    
    
    // Functions to clear the Components data 
    public void cleartxtDriver(){ txtDriver.setText(""); txtDriver.paintImmediately(txtDriver.getVisibleRect()); }
    public void cleartxtURL(){ txtURL.setText(""); txtURL.paintImmediately(txtURL.getVisibleRect()); }
    public void cleartxtLocal(){ txtLocal.setText(""); txtLocal.paintImmediately(txtLocal.getVisibleRect()); }
    public void cleartxtPort(){ txtPort.setText(""); txtPort.paintImmediately(txtPort.getVisibleRect()); }
    public void cleartxtDBName(){ txtDBName.setText(""); txtDBName.paintImmediately(txtDBName.getVisibleRect()); }
    public void cleartxtOwner(){ txtOwner.setText(""); txtOwner.paintImmediately(txtOwner.getVisibleRect()); }
    
    // Functions to return data from Components
    public String gettxtDriver(){ return txtDriver.getText(); }
    public String gettxtURL(){ return txtURL.getText(); }
    public String gettxtLocal(){ return txtLocal.getText(); }
    public String gettxtPort(){ return txtPort.getText(); }
    public String gettxtDBName(){ return txtDBName.getText(); }
    public String gettxtOwner(){ return txtOwner.getText(); }
        
    // Functions to enable or disable Components
    public void settxtDriverEnabled(boolean status){ this.txtDriver.setEnabled(status); }
    public void settxtURLEnabled(boolean status){ this.txtURL.setEnabled(status); }
    public void settxtLocalEnabled(boolean status){ this.txtLocal.setEnabled(status); }
    public void settxtPortEnabled(boolean status){ this.txtPort.setEnabled(status); }
    public void settxtDBNameEnabled(boolean status){ this.txtDBName.setEnabled(status); }
    public void settxtOwnerEnabled(boolean status){ this.txtOwner.setEnabled(status); }
    public void setbtnTestDBEnabled(boolean status){ this.btnTestDB.setEnabled(status); }
    public void setbtnSaveDBParamEnabled(boolean status){ this.btnSaveDBParam.setEnabled(status); }
    
    // Functions to return the Components Status
    public boolean istxtDriverEnabled(){ return txtDriver.isEnabled(); }
    public boolean istxtURLEnabled(){ return txtURL.isEnabled(); }
    public boolean istxtLocalEnabled(){ return txtLocal.isEnabled(); }
    public boolean istxtPortEnabled(){ return txtPort.isEnabled(); }
    public boolean istxtDBNamerEnabled(){ return txtDBName.isEnabled(); }
    public boolean istxtOwnerEnabled(){ return txtOwner.isEnabled(); }
    public boolean isbtnTestDBEnabled(){ return btnTestDB.isEnabled(); }
    public boolean isbtnSaveDBParamEnabled(){ return btnSaveDBParam.isEnabled(); }
    
    
    public void setFocus(String component) {
        switch(component) {
            case "TXT_DRIVER":
                txtDriver.requestFocus();
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
        txtDriver = new javax.swing.JTextField();
        txtURL = new javax.swing.JTextField();
        txtLocal = new javax.swing.JTextField();
        txtPort = new javax.swing.JTextField();
        txtDBName = new javax.swing.JTextField();
        txtOwner = new javax.swing.JTextField();
        btnTestDB = new javax.swing.JButton();
        btnSaveDBParam = new javax.swing.JButton();
        lblOwner = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblLlocal = new javax.swing.JLabel();
        lblPort = new javax.swing.JLabel();
        lblDriver = new javax.swing.JLabel();
        lblURL = new javax.swing.JLabel();
        lblDBName = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Configurações Gerais");
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        lblScreen.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblScreen.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblScreen.setText("Geral");
        lblScreen.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        txtDriver.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtDriver.setText("oracle.jdbc.OracleDriver");

        txtURL.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtURL.setText("jdbc:oracle:thin:@");

        txtLocal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtLocal.setText("localhost");

        txtPort.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtPort.setText("1521");

        txtDBName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtDBName.setText("SIEBELDEV");

        txtOwner.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtOwner.setText("SADMIN");

        btnTestDB.setText("Testar");

        btnSaveDBParam.setText("Salvar");
        btnSaveDBParam.setEnabled(false);

        lblOwner.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblOwner.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblOwner.setText("Owner:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Parâmetros do Banco de Dados");

        lblLlocal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblLlocal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblLlocal.setText("Local:");

        lblPort.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblPort.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPort.setText("Porta:");

        lblDriver.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblDriver.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDriver.setText("Driver:");

        lblURL.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblURL.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblURL.setText("URL:");

        lblDBName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblDBName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDBName.setText("Nome do BD:");

        jLabel8.setText("Caminho do arquivo: C:\\Program Files (x86)\\Java\\db_conf.conf");
        jLabel8.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTestDB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSaveDBParam))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblLlocal, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblDBName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblOwner, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtOwner, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDBName, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblDriver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblURL, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtURL, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtDriver, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPort, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSaveDBParam)
                    .addComponent(btnTestDB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDriver)
                    .addComponent(txtDriver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPort)
                    .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblURL)
                            .addComponent(txtURL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblLlocal)
                            .addComponent(txtLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDBName)
                            .addComponent(txtDBName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblOwner)
                            .addComponent(txtOwner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(40, 40, 40)
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblScreen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSaveDBParam;
    private javax.swing.JButton btnTestDB;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblDBName;
    private javax.swing.JLabel lblDriver;
    private javax.swing.JLabel lblLlocal;
    private javax.swing.JLabel lblOwner;
    private javax.swing.JLabel lblPort;
    private javax.swing.JLabel lblScreen;
    private javax.swing.JLabel lblURL;
    private javax.swing.JTextField txtDBName;
    private javax.swing.JTextField txtDriver;
    private javax.swing.JTextField txtLocal;
    private javax.swing.JTextField txtOwner;
    private javax.swing.JTextField txtPort;
    private javax.swing.JTextField txtURL;
    // End of variables declaration//GEN-END:variables

}
