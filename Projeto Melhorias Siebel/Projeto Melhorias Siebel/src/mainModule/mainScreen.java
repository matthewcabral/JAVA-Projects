/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainModule;

import databaseModule.DataController;
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
    public void setListenerBatimento(ActionListener listener) { btnOpenBatimentoScreen.addActionListener(listener); }
    //public void setListenerBatimentoSOM(ActionListener listener) { btnOpenBatimentoSOM.addActionListener(listener); }
    public void setListenerLockSystem(ActionListener listener) { btnBloqSystem.addActionListener(listener); }
    public void setListenerAboutSystem(ActionListener listener) { aboutSystemMenuBtn.addActionListener(listener); }
    public void setListenerEnvReport(ActionListener listener) { btnOpenEnvRep.addActionListener(listener); }
    public void setListenerBtnSettings(ActionListener listener) { btnSettings.addActionListener(listener); }
        
    
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
        btnOpenBatimentoScreen = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnBloqSystem = new javax.swing.JButton();
        btnExitSystem = new javax.swing.JButton();
        btnOpenClientCreator = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        PanelReports = new javax.swing.JPanel();
        btnOpenEnvRep = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        PanelSettings = new javax.swing.JPanel();
        btnSettings = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        btnOpenBatimentoScreen2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnOpenBatimentoScreen3 = new javax.swing.JButton();
        PanelLogo = new javax.swing.JPanel();
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
        setTitle("Sistema ainda sem nome");
        setBackground(new java.awt.Color(255, 255, 255));
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

        btnOpenBatimentoScreen.setBackground(new java.awt.Color(237, 237, 237));
        btnOpenBatimentoScreen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/Checklist 50x50.png"))); // NOI18N
        btnOpenBatimentoScreen.setText("Batimento Amb.");
        btnOpenBatimentoScreen.setBorderPainted(false);
        btnOpenBatimentoScreen.setContentAreaFilled(false);
        btnOpenBatimentoScreen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOpenBatimentoScreen.setIconTextGap(0);
        btnOpenBatimentoScreen.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnOpenBatimentoScreen.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jLabel1.setBackground(new java.awt.Color(237, 237, 237));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ferramentas");
        jLabel1.setEnabled(false);
        jLabel1.setOpaque(true);

        jLabel4.setBackground(new java.awt.Color(237, 237, 237));
        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Sair");
        jLabel4.setEnabled(false);
        jLabel4.setOpaque(true);

        btnBloqSystem.setBackground(new java.awt.Color(237, 237, 237));
        btnBloqSystem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/Lock.png"))); // NOI18N
        btnBloqSystem.setText("Bloq. Sistema");
        btnBloqSystem.setBorderPainted(false);
        btnBloqSystem.setContentAreaFilled(false);
        btnBloqSystem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBloqSystem.setIconTextGap(0);
        btnBloqSystem.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnBloqSystem.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnExitSystem.setBackground(new java.awt.Color(237, 237, 237));
        btnExitSystem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/Shutdown.png"))); // NOI18N
        btnExitSystem.setText("Sair");
        btnExitSystem.setBorderPainted(false);
        btnExitSystem.setContentAreaFilled(false);
        btnExitSystem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExitSystem.setIconTextGap(0);
        btnExitSystem.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnExitSystem.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnExitSystem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitSystemActionPerformed(evt);
            }
        });

        btnOpenClientCreator.setBackground(new java.awt.Color(237, 237, 237));
        btnOpenClientCreator.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/Massa 50x50.png"))); // NOI18N
        btnOpenClientCreator.setText("Gerador de Massa");
        btnOpenClientCreator.setBorderPainted(false);
        btnOpenClientCreator.setContentAreaFilled(false);
        btnOpenClientCreator.setEnabled(false);
        btnOpenClientCreator.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOpenClientCreator.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnOpenClientCreator.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jSeparator3.setBackground(new java.awt.Color(237, 237, 237));
        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator3.setEnabled(false);

        javax.swing.GroupLayout PanelMainLayout = new javax.swing.GroupLayout(PanelMain);
        PanelMain.setLayout(PanelMainLayout);
        PanelMainLayout.setHorizontalGroup(
            PanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMainLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(PanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PanelMainLayout.createSequentialGroup()
                        .addComponent(btnOpenBatimentoScreen, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOpenClientCreator, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelMainLayout.createSequentialGroup()
                        .addComponent(btnBloqSystem, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btnExitSystem, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        PanelMainLayout.setVerticalGroup(
            PanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMainLayout.createSequentialGroup()
                .addGroup(PanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PanelMainLayout.createSequentialGroup()
                        .addGroup(PanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBloqSystem, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnExitSystem, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4))
                    .addGroup(PanelMainLayout.createSequentialGroup()
                        .addGroup(PanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnOpenClientCreator, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnOpenBatimentoScreen, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1))
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("PRINCIPAL", PanelMain);

        PanelReports.setBackground(new java.awt.Color(255, 255, 255));
        PanelReports.setForeground(new java.awt.Color(255, 255, 255));
        PanelReports.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        btnOpenEnvRep.setBackground(new java.awt.Color(237, 237, 237));
        btnOpenEnvRep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/relatorio 50x50.png"))); // NOI18N
        btnOpenEnvRep.setText("Batimento Amb.");
        btnOpenEnvRep.setBorderPainted(false);
        btnOpenEnvRep.setContentAreaFilled(false);
        btnOpenEnvRep.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOpenEnvRep.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnOpenEnvRep.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jLabel12.setBackground(new java.awt.Color(237, 237, 237));
        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Relatórios");
        jLabel12.setEnabled(false);
        jLabel12.setOpaque(true);

        javax.swing.GroupLayout PanelReportsLayout = new javax.swing.GroupLayout(PanelReports);
        PanelReports.setLayout(PanelReportsLayout);
        PanelReportsLayout.setHorizontalGroup(
            PanelReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelReportsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnOpenEnvRep, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
                .addContainerGap(898, Short.MAX_VALUE))
        );
        PanelReportsLayout.setVerticalGroup(
            PanelReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelReportsLayout.createSequentialGroup()
                .addComponent(btnOpenEnvRep, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("RELATÓRIOS", PanelReports);

        PanelSettings.setBackground(new java.awt.Color(255, 255, 255));
        PanelSettings.setEnabled(false);

        btnSettings.setBackground(new java.awt.Color(237, 237, 237));
        btnSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/System 50x50.png"))); // NOI18N
        btnSettings.setText("Sistema");
        btnSettings.setToolTipText("");
        btnSettings.setBorderPainted(false);
        btnSettings.setContentAreaFilled(false);
        btnSettings.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSettings.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnSettings.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jLabel2.setBackground(new java.awt.Color(237, 237, 237));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Sistema");
        jLabel2.setToolTipText("");
        jLabel2.setEnabled(false);
        jLabel2.setOpaque(true);

        jSeparator2.setBackground(java.awt.Color.lightGray);
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator2.setToolTipText("");

        btnOpenBatimentoScreen2.setBackground(new java.awt.Color(237, 237, 237));
        btnOpenBatimentoScreen2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/User 50x50.png"))); // NOI18N
        btnOpenBatimentoScreen2.setText("Usuários");
        btnOpenBatimentoScreen2.setToolTipText("");
        btnOpenBatimentoScreen2.setBorderPainted(false);
        btnOpenBatimentoScreen2.setContentAreaFilled(false);
        btnOpenBatimentoScreen2.setEnabled(false);
        btnOpenBatimentoScreen2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOpenBatimentoScreen2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnOpenBatimentoScreen2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jLabel3.setBackground(new java.awt.Color(237, 237, 237));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Usuários");
        jLabel3.setToolTipText("");
        jLabel3.setEnabled(false);
        jLabel3.setOpaque(true);

        btnOpenBatimentoScreen3.setBackground(new java.awt.Color(237, 237, 237));
        btnOpenBatimentoScreen3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons/Change Password 50x50.png"))); // NOI18N
        btnOpenBatimentoScreen3.setText("Alterar Senha");
        btnOpenBatimentoScreen3.setToolTipText("");
        btnOpenBatimentoScreen3.setBorderPainted(false);
        btnOpenBatimentoScreen3.setContentAreaFilled(false);
        btnOpenBatimentoScreen3.setEnabled(false);
        btnOpenBatimentoScreen3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOpenBatimentoScreen3.setIconTextGap(0);
        btnOpenBatimentoScreen3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnOpenBatimentoScreen3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout PanelSettingsLayout = new javax.swing.GroupLayout(PanelSettings);
        PanelSettings.setLayout(PanelSettingsLayout);
        PanelSettingsLayout.setHorizontalGroup(
            PanelSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSettingsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSettings, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PanelSettingsLayout.createSequentialGroup()
                        .addComponent(btnOpenBatimentoScreen2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOpenBatimentoScreen3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(412, 412, 412))
        );
        PanelSettingsLayout.setVerticalGroup(
            PanelSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(PanelSettingsLayout.createSequentialGroup()
                .addGroup(PanelSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnOpenBatimentoScreen2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOpenBatimentoScreen3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3))
            .addGroup(PanelSettingsLayout.createSequentialGroup()
                .addComponent(btnSettings, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2))
        );

        jTabbedPane1.addTab("CONFIGURAÇÕES", PanelSettings);

        PanelLogo.setBackground(new java.awt.Color(255, 255, 255));
        PanelLogo.setOpaque(false);

        javax.swing.GroupLayout PanelLogoLayout = new javax.swing.GroupLayout(PanelLogo);
        PanelLogo.setLayout(PanelLogoLayout);
        PanelLogoLayout.setHorizontalGroup(
            PanelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        PanelLogoLayout.setVerticalGroup(
            PanelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 352, Short.MAX_VALUE)
        );

        PanelInfo.setBackground(new java.awt.Color(237, 237, 237));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Usuário Conectado:");
        jLabel6.setEnabled(false);

        lblUser.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblUser.setText("TESTE");
        lblUser.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("© Copyright 2019");
        jLabel7.setEnabled(false);

        lblYear.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblYear.setText("2019.");
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
            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
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
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void btnExitSystemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitSystemActionPerformed
        if(JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?","Atenção",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION){
            System.exit(0);
        } 
    }//GEN-LAST:event_btnExitSystemActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if(JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?","Atenção",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_formWindowClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelInfo;
    private javax.swing.JPanel PanelLogo;
    private javax.swing.JPanel PanelMain;
    private javax.swing.JPanel PanelReports;
    private javax.swing.JPanel PanelSettings;
    private javax.swing.JMenuItem aboutSystemMenuBtn;
    private javax.swing.JMenuItem aboutViewMenuBtn;
    private javax.swing.JButton btnBloqSystem;
    private javax.swing.JButton btnExitSystem;
    private javax.swing.JButton btnOpenBatimentoScreen;
    private javax.swing.JButton btnOpenBatimentoScreen2;
    private javax.swing.JButton btnOpenBatimentoScreen3;
    private javax.swing.JButton btnOpenClientCreator;
    private javax.swing.JButton btnOpenEnvRep;
    private javax.swing.JButton btnSettings;
    private javax.swing.JMenuItem closeMenuBtn;
    private javax.swing.JMenuBar defaultMenu;
    private javax.swing.JMenu fileMenuBtn;
    private javax.swing.JMenu helpMenuBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblUser;
    private javax.swing.JLabel lblYear;
    private javax.swing.JPanel pnlMain;
    // End of variables declaration//GEN-END:variables
}
