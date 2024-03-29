/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import SystemSettingsModule.AboutViewScreen;
import SystemSettingsModule.AboutSystemScreen;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Matheus Cabral Rosa
 */
public class mainScreen extends javax.swing.JFrame {
    // Other's classes reference
    AboutViewScreen aboutView;
    Date date;
    SimpleDateFormat dateFormat;
    
    // Constructor
    public mainScreen() {
        initComponents();
        aboutView = new AboutViewScreen();
        date = new Date();
        dateFormat = new SimpleDateFormat("YYYY");
        this.setLocationRelativeTo(null);
        this.setLblYear(dateFormat.format(date) + ".");
        this.setVisible(true);
    }
    
    // Function to set user on label "lblUser"
    public void setLabelUser(String user) { lblUser.setText(user); lblUser.paintImmediately(lblUser.getVisibleRect()); }
    public void setLblYear(String year) { lblYear.setText(year); lblYear.paintImmediately(lblYear.getVisibleRect()); }
        
    // Listeners
    public void setListenerOpenLOV_XML_ConverterScreen(ActionListener listener) { btnOpenLOV_XML_ConverterScreen.addActionListener(listener); }
    public void setListenerOpenDBSettings(ActionListener listener) { btnOpenDBSettings.addActionListener(listener); }
    public void setListenerAboutSystem(ActionListener listener) { aboutSystemMenuBtn.addActionListener(listener); }
        
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        PanelMain = new javax.swing.JPanel();
        btnOpenLOV_XML_ConverterScreen = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnOpenClientCreator = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        PanelMain1 = new javax.swing.JPanel();
        btnOpenDBSettings = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnOpenClientCreator1 = new javax.swing.JButton();
        PanelLogo = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        PanelInfo = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblYear = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        defaultMenu = new javax.swing.JMenuBar();
        fileMenuBtn = new javax.swing.JMenu();
        closeMenuBtn = new javax.swing.JMenuItem();
        helpMenuBtn = new javax.swing.JMenu();
        aboutViewMenuBtn = new javax.swing.JMenuItem();
        aboutSystemMenuBtn = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("XML Converter");
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1366, 768));
        setSize(new java.awt.Dimension(1366, 768));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        pnlMain.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.light"));
        pnlMain.setFont(new java.awt.Font("Calibri Light", 0, 12)); // NOI18N

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.setOpaque(true);

        PanelMain.setBackground(new java.awt.Color(255, 255, 255));
        PanelMain.setForeground(new java.awt.Color(255, 255, 255));
        PanelMain.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        btnOpenLOV_XML_ConverterScreen.setBackground(new java.awt.Color(237, 237, 237));
        btnOpenLOV_XML_ConverterScreen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/xml_dba_Insert_50x50.png"))); // NOI18N
        btnOpenLOV_XML_ConverterScreen.setText("LOV");
        btnOpenLOV_XML_ConverterScreen.setToolTipText("");
        btnOpenLOV_XML_ConverterScreen.setBorderPainted(false);
        btnOpenLOV_XML_ConverterScreen.setContentAreaFilled(false);
        btnOpenLOV_XML_ConverterScreen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOpenLOV_XML_ConverterScreen.setIconTextGap(0);
        btnOpenLOV_XML_ConverterScreen.setMargin(new java.awt.Insets(0, 14, 0, 14));
        btnOpenLOV_XML_ConverterScreen.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnOpenLOV_XML_ConverterScreen.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jLabel1.setBackground(new java.awt.Color(237, 237, 237));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ferramentas de conversão de XML");
        jLabel1.setEnabled(false);
        jLabel1.setOpaque(true);

        btnOpenClientCreator.setBackground(new java.awt.Color(237, 237, 237));
        btnOpenClientCreator.setText("Outros");
        btnOpenClientCreator.setBorderPainted(false);
        btnOpenClientCreator.setContentAreaFilled(false);
        btnOpenClientCreator.setEnabled(false);
        btnOpenClientCreator.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOpenClientCreator.setMargin(new java.awt.Insets(0, 14, 0, 14));
        btnOpenClientCreator.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnOpenClientCreator.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel4.setBackground(new java.awt.Color(237, 237, 237));
        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Sair");
        jLabel4.setEnabled(false);
        jLabel4.setOpaque(true);

        btnExit.setBackground(new java.awt.Color(237, 237, 237));
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/Shutdown.png"))); // NOI18N
        btnExit.setText("Sair");
        btnExit.setBorderPainted(false);
        btnExit.setContentAreaFilled(false);
        btnExit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExit.setMargin(new java.awt.Insets(0, 14, 0, 14));
        btnExit.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnExit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExitMouseClicked(evt);
            }
        });
        btnExit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnExitKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout PanelMainLayout = new javax.swing.GroupLayout(PanelMain);
        PanelMain.setLayout(PanelMainLayout);
        PanelMainLayout.setHorizontalGroup(
            PanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMainLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(PanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PanelMainLayout.createSequentialGroup()
                        .addComponent(btnOpenLOV_XML_ConverterScreen, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOpenClientCreator, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(652, Short.MAX_VALUE))
        );
        PanelMainLayout.setVerticalGroup(
            PanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMainLayout.createSequentialGroup()
                .addGroup(PanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelMainLayout.createSequentialGroup()
                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelMainLayout.createSequentialGroup()
                        .addGroup(PanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnOpenClientCreator, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnOpenLOV_XML_ConverterScreen, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );

        jTabbedPane1.addTab("PRINCIPAL", PanelMain);

        PanelMain1.setBackground(new java.awt.Color(255, 255, 255));
        PanelMain1.setForeground(new java.awt.Color(255, 255, 255));
        PanelMain1.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        btnOpenDBSettings.setBackground(new java.awt.Color(237, 237, 237));
        btnOpenDBSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/Configuracoes.png"))); // NOI18N
        btnOpenDBSettings.setText("Conf. do BD");
        btnOpenDBSettings.setToolTipText("");
        btnOpenDBSettings.setBorderPainted(false);
        btnOpenDBSettings.setContentAreaFilled(false);
        btnOpenDBSettings.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOpenDBSettings.setIconTextGap(0);
        btnOpenDBSettings.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnOpenDBSettings.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jLabel2.setBackground(new java.awt.Color(237, 237, 237));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Sistema");
        jLabel2.setEnabled(false);
        jLabel2.setOpaque(true);

        btnOpenClientCreator1.setBackground(new java.awt.Color(237, 237, 237));
        btnOpenClientCreator1.setBorderPainted(false);
        btnOpenClientCreator1.setContentAreaFilled(false);
        btnOpenClientCreator1.setEnabled(false);
        btnOpenClientCreator1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOpenClientCreator1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnOpenClientCreator1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout PanelMain1Layout = new javax.swing.GroupLayout(PanelMain1);
        PanelMain1.setLayout(PanelMain1Layout);
        PanelMain1Layout.setHorizontalGroup(
            PanelMain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMain1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(PanelMain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnOpenDBSettings, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOpenClientCreator1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(779, 779, 779))
        );
        PanelMain1Layout.setVerticalGroup(
            PanelMain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMain1Layout.createSequentialGroup()
                .addGroup(PanelMain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnOpenClientCreator1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOpenDBSettings, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("CONFIGURAÇÕES", PanelMain1);

        PanelLogo.setBackground(new java.awt.Color(255, 255, 255));
        PanelLogo.setOpaque(false);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/XML Converter.png"))); // NOI18N
        jLabel3.setEnabled(false);

        javax.swing.GroupLayout PanelLogoLayout = new javax.swing.GroupLayout(PanelLogo);
        PanelLogo.setLayout(PanelLogoLayout);
        PanelLogoLayout.setHorizontalGroup(
            PanelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLogoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        PanelLogoLayout.setVerticalGroup(
            PanelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLogoLayout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );

        PanelInfo.setBackground(new java.awt.Color(237, 237, 237));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Usuário Conectado:");
        jLabel6.setEnabled(false);

        lblUser.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblUser.setText("TESTE");
        lblUser.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("© Copyright 2020");
        jLabel7.setEnabled(false);

        lblYear.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblYear.setText("2020.");
        lblYear.setEnabled(false);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("-");
        jLabel9.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Todos os Direitos Reservados.");
        jLabel10.setEnabled(false);

        javax.swing.GroupLayout PanelInfoLayout = new javax.swing.GroupLayout(PanelInfo);
        PanelInfo.setLayout(PanelInfoLayout);
        PanelInfoLayout.setHorizontalGroup(
            PanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblYear)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelInfoLayout.setVerticalGroup(
            PanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
            .addComponent(lblUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblYear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addComponent(PanelLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("PRINCIPAL");

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
            .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeMenuBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeMenuBtnActionPerformed
        if(JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?","Atenção",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_closeMenuBtnActionPerformed

    private void aboutViewMenuBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutViewMenuBtnActionPerformed
        aboutView.openScreen(
            "[Módulo 1]: Principal (Main); " + 
            "[Módulo 2]: Database;",
            "[Screen 1]: mainScreen; ",
            "<html>" +
            "[Classe 1]: Main; <br/>" +
            "<p>[Classe 1.1]: MainMenu; <br/></p>" +
            "[Classe 2]: DataController; <br/>" +
            "</html>"
        );
    }//GEN-LAST:event_aboutViewMenuBtnActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if(JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?","Atenção",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_formWindowClosing

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        if(JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?","Atenção",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_btnExitMouseClicked

    private void btnExitKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnExitKeyPressed
        if(JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?","Atenção",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_btnExitKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelInfo;
    private javax.swing.JPanel PanelLogo;
    private javax.swing.JPanel PanelMain;
    private javax.swing.JPanel PanelMain1;
    private javax.swing.JMenuItem aboutSystemMenuBtn;
    private javax.swing.JMenuItem aboutViewMenuBtn;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnOpenClientCreator;
    private javax.swing.JButton btnOpenClientCreator1;
    private javax.swing.JButton btnOpenDBSettings;
    private javax.swing.JButton btnOpenLOV_XML_ConverterScreen;
    private javax.swing.JMenuItem closeMenuBtn;
    private javax.swing.JMenuBar defaultMenu;
    private javax.swing.JMenu fileMenuBtn;
    private javax.swing.JMenu helpMenuBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblUser;
    private javax.swing.JLabel lblYear;
    private javax.swing.JPanel pnlMain;
    // End of variables declaration//GEN-END:variables
}
