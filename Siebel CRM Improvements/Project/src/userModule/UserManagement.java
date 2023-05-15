/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userModule;

import java.awt.event.ActionListener;

/**
 *
 * @author Matheus Cabral Rosa
 */
public class UserManagement extends javax.swing.JFrame {

    /**
     * Creates new form UserManagement
     */
    public UserManagement() {
        initComponents();
    }
    
    // Listeners
    public void setListenerBtnSave(ActionListener listener) { this.btnSave.addActionListener(listener); }
    public void setListenerBtnBack(ActionListener listener) { this.btnBack.addActionListener(listener); }
        
    // Control functions
    // Functions to insert data on Components
    public void insertTxtDocNumber(String item) { txtDocNum.setText(item); txtDocNum.paintImmediately(txtDocNum.getVisibleRect()); }
    public void insertTxtName(String item) { txtName.setText(item); txtName.paintImmediately(txtName.getVisibleRect()); }
    public void insertTxtSurname(String item) {txtLastName.setText(item); txtLastName.paintImmediately(txtLastName.getVisibleRect()); }
    public void insertTxtEmail(String item){ txtEmail.setText(item); txtEmail.paintImmediately(txtEmail.getVisibleRect()); }
    public void insertTxtBornDate(String item){ txtBornDate.setText(item); txtBornDate.paintImmediately(txtBornDate.getVisibleRect()); }
    public void insertCbbQuestionOne(String item){ cbbQuestionOne.addItem(item); cbbQuestionOne.paintImmediately(cbbQuestionOne.getVisibleRect()); }
    public void insertTxtAnswerOne(String item){ txtAnswerOne.setText(item); txtAnswerOne.paintImmediately(txtAnswerOne.getVisibleRect()); }
    public void insertCbbQuestionTwo(String item){ cbbQuestionTwo.addItem(item); cbbQuestionTwo.paintImmediately(cbbQuestionTwo.getVisibleRect()); }
    public void insertTxtAnswerTwo(String item){ txtAnswerTwo.setText(item); txtAnswerTwo.paintImmediately(txtAnswerTwo.getVisibleRect()); }
    public void insertCbbQuestionThree(String item){ cbbQuestionThree.addItem(item); cbbQuestionThree.paintImmediately(cbbQuestionThree.getVisibleRect()); }
    public void insertTxtUser(String item){ txtUser.setText(item); txtUser.paintImmediately(txtUser.getVisibleRect()); }
    public void insertTxtPassword(String item){ txtPassword.setText(item); txtPassword.paintImmediately(txtPassword.getVisibleRect()); }
    public void insertTxtPasswordConf(String item){ txtPasswordConf.setText(item); txtPasswordConf.paintImmediately(txtPasswordConf.getVisibleRect()); }
    
    // Functions to return data from Components
    public String getTxtDocNumber() { return this.txtDocNum.getText(); }
    public String getTxtName() { return this.txtName.getText(); }
    public String getTxtSurname() { return this.txtLastName.getText(); }
    public String getTxtEmail() { return this.txtEmail.getText(); }
    public String getTxtBornDate() { return this.txtBornDate.getText(); }
    public String getCbbQuestionOne() { return this.cbbQuestionOne.getSelectedItem().toString(); }
    public String getTxtAnswerOne() { return this.txtAnswerOne.getText(); }
    public String getCbbQuestionTwo() { return this.cbbQuestionTwo.getSelectedItem().toString(); }
    public String getTxtAnswerTwo() { return this.txtAnswerTwo.getText(); }
    public String getCbbQuestionThree() { return this.cbbQuestionThree.getSelectedItem().toString(); }
    public String getTxtAnswerThree() { return this.txtAnswerThree.getText(); }
    public String getTxtUser() { return this.txtUser.getText(); }
    public String getTxtPassword() { return this.txtPassword.getText(); }
    public String getTxtPasswordConf() { return this.txtPasswordConf.getText(); }
    
    // Functions to clear the Components data
    public void clearTxtDocNumber(){ txtDocNum.setText(""); txtDocNum.paintImmediately(txtDocNum.getVisibleRect()); }
    public void clearTxtName() { txtName.setText(""); txtName.paintImmediately(txtName.getVisibleRect()); }
    public void clearTxtSurname() {txtLastName.setText(""); txtLastName.paintImmediately(txtLastName.getVisibleRect()); }
    public void clearTxtEmail(){ txtEmail.setText(""); txtEmail.paintImmediately(txtEmail.getVisibleRect()); }
    public void clearTxtBornDate(){ txtBornDate.setText(""); txtBornDate.paintImmediately(txtBornDate.getVisibleRect()); }
    public void clearCbbQuestionOne(){ cbbQuestionOne.removeAllItems(); cbbQuestionOne.paintImmediately(cbbQuestionOne.getVisibleRect()); }
    public void clearTxtAnswerOne(){ txtAnswerOne.setText(""); txtAnswerOne.paintImmediately(txtAnswerOne.getVisibleRect()); }
    public void clearCbbQuestionTwo(){ cbbQuestionTwo.removeAllItems(); cbbQuestionTwo.paintImmediately(cbbQuestionTwo.getVisibleRect()); }
    public void clearTxtAnswerTwo(){ txtAnswerTwo.setText(""); txtAnswerTwo.paintImmediately(txtAnswerTwo.getVisibleRect()); }
    public void clearCbbQuestionThree(){ cbbQuestionThree.removeAllItems(); cbbQuestionThree.paintImmediately(cbbQuestionThree.getVisibleRect()); }
    public void clearTxtUser(){ txtUser.setText(""); txtUser.paintImmediately(txtUser.getVisibleRect()); }
    public void clearTxtPassword(){ txtPassword.setText(""); txtPassword.paintImmediately(txtPassword.getVisibleRect()); }
    public void clearTxtPasswordConf(){ txtPasswordConf.setText(""); txtPasswordConf.paintImmediately(txtPasswordConf.getVisibleRect()); }
    
    // Functions to enable or disable Components
    public void setTxtDocNumberEnabled(Boolean status){ txtDocNum.setEnabled(status); txtDocNum.paintImmediately(txtDocNum.getVisibleRect()); }
    public void setTxtNameEnabled(Boolean status) { txtName.setEnabled(status); txtName.paintImmediately(txtName.getVisibleRect()); }
    public void setTxtSurnameEnabled(Boolean status) {txtLastName.setEnabled(status); txtLastName.paintImmediately(txtLastName.getVisibleRect()); }
    public void setTxtEmailEnabled(Boolean status){ txtEmail.setEnabled(status); txtEmail.paintImmediately(txtEmail.getVisibleRect()); }
    public void setTxtBornDateEnabled(Boolean status){ txtBornDate.setEnabled(status); txtBornDate.paintImmediately(txtBornDate.getVisibleRect()); }
    public void setCbbQuestionOneEnabled(Boolean status){ cbbQuestionOne.setEnabled(status); cbbQuestionOne.paintImmediately(cbbQuestionOne.getVisibleRect()); }
    public void setTxtAnswerOneEnabled(Boolean status){ txtAnswerOne.setEnabled(status); txtAnswerOne.paintImmediately(txtAnswerOne.getVisibleRect()); }
    public void setCbbQuestionTwoEnabled(Boolean status){ cbbQuestionTwo.setEnabled(status); cbbQuestionTwo.paintImmediately(cbbQuestionTwo.getVisibleRect()); }
    public void setTxtAnswerTwoEnabled(Boolean status){ txtAnswerTwo.setEnabled(status); txtAnswerTwo.paintImmediately(txtAnswerTwo.getVisibleRect()); }
    public void setCbbQuestionThreeEnabled(Boolean status){ cbbQuestionThree.setEnabled(status); cbbQuestionThree.paintImmediately(cbbQuestionThree.getVisibleRect()); }
    public void setTxtUserEnabled(Boolean status){ txtUser.setEnabled(status); txtUser.paintImmediately(txtUser.getVisibleRect()); }
    public void setTxtPasswordEnabled(Boolean status){ txtPassword.setEnabled(status); txtPassword.paintImmediately(txtPassword.getVisibleRect()); }
    public void setTxtPasswordConfEnabled(Boolean status){ txtPasswordConf.setEnabled(status); txtPasswordConf.paintImmediately(txtPasswordConf.getVisibleRect()); }
        
    // Functions to return the Components Status
    public boolean isTxtDocNumberEnabled(){ return txtDocNum.isEnabled(); }
    public boolean isTxtNameEnabled() { return txtName.isEnabled(); }
    public boolean isTxtSurnameEnabled() { return txtLastName.isEnabled(); }
    public boolean isTxtEmailEnabled(){ return txtEmail.isEnabled(); }
    public boolean isTxtBornDateEnabled(){ return txtBornDate.isEnabled(); }
    public boolean isCbbQuestionOneEnabled(){ return cbbQuestionOne.isEnabled(); }
    public boolean isTxtAnswerOneEnabled(){ return txtAnswerOne.isEnabled(); }
    public boolean isCbbQuestionTwoEnabled(){ return cbbQuestionTwo.isEnabled(); }
    public boolean isTxtAnswerTwoEnabled(){ return txtAnswerTwo.isEnabled(); }
    public boolean isCbbQuestionThreeEnabled(){ return cbbQuestionThree.isEnabled(); }
    public boolean isTxtUserEnabled(){ return txtUser.isEnabled(); }
    public boolean isTxtPasswordEnabled(){ return txtPassword.isEnabled(); }
    public boolean isTxtPasswordConfEnabled(){ return txtPasswordConf.isEnabled(); }
    
    // Functions to return the Components items quantity
    public int getCbbQuestionOneSize(){ return cbbQuestionOne.getItemCount(); }
    public int getCbbQuestionTwoSize(){ return cbbQuestionTwo.getItemCount(); }
    public int getCbbQuestionThreeSize(){ return cbbQuestionThree.getItemCount(); }
    
    // Function to return the index of selected item on ComboBox
    public int getCbbQuestionOneIndex(){ return cbbQuestionOne.getSelectedIndex()- 1; }
    public int getCbbQuestionTwoIndex(){ return cbbQuestionTwo.getSelectedIndex() - 1; }
    public int getCbbQuestionThreeIndex(){ return cbbQuestionThree.getSelectedIndex() - 1; }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnBack = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDocNum = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtLastName = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtBornDate = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        rdbAdmin = new javax.swing.JRadioButton();
        rdbReadOnly = new javax.swing.JRadioButton();
        txtUser = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        txtPasswordConf = new javax.swing.JPasswordField();
        jPanel7 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cbbQuestionOne = new javax.swing.JComboBox<>();
        txtAnswerOne = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        cbbQuestionTwo = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        txtAnswerTwo = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        cbbQuestionThree = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        txtAnswerThree = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Criar ou Editar usuário");
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(237, 237, 237));

        btnBack.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        btnBack.setText("Voltar");
        btnBack.setBorder(null);
        btnBack.setBorderPainted(false);
        btnBack.setContentAreaFilled(false);
        btnBack.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        btnSave.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        btnSave.setText("Salvar");
        btnSave.setBorder(null);
        btnSave.setBorderPainted(false);
        btnSave.setContentAreaFilled(false);
        btnSave.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(237, 237, 237));

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel9.setText("Usuário");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Geral", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 0, 12))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel1.setText("Nome:");

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel2.setText("Sobrenome:");

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel3.setText("CPF ou CNPJ:");

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel4.setText("Email:");

        txtDocNum.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtDocNum.setNextFocusableComponent(txtName);

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel5.setText("Nascimento:");

        txtName.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtName.setNextFocusableComponent(txtLastName);

        txtLastName.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtLastName.setNextFocusableComponent(txtEmail);

        txtEmail.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtEmail.setNextFocusableComponent(txtBornDate);

        txtBornDate.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtBornDate.setNextFocusableComponent(cbbQuestionOne);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDocNum, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                    .addComponent(txtName)
                    .addComponent(txtLastName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(txtBornDate))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtDocNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtBornDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Usuário e Permissões", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 0, 12))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel6.setText("Usuário:");

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel7.setText("Senha:");

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel8.setText("Confirmar Senha:");

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Permissões", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 0, 12))); // NOI18N

        rdbAdmin.setBackground(new java.awt.Color(255, 255, 255));
        rdbAdmin.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        rdbAdmin.setText("Administrador");
        rdbAdmin.setNextFocusableComponent(rdbReadOnly);

        rdbReadOnly.setBackground(new java.awt.Color(255, 255, 255));
        rdbReadOnly.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        rdbReadOnly.setText("Somente visualização");
        rdbReadOnly.setNextFocusableComponent(btnSave);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdbAdmin)
                    .addComponent(rdbReadOnly)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(rdbAdmin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rdbReadOnly)
                .addContainerGap())
        );

        txtUser.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txtUser.setNextFocusableComponent(txtPassword);

        txtPassword.setNextFocusableComponent(txtPasswordConf);

        txtPasswordConf.setNextFocusableComponent(rdbAdmin);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUser)
                    .addComponent(txtPassword)
                    .addComponent(txtPasswordConf))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtPasswordConf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Perguntas de Segurança", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 0, 12))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel10.setText("Pergunta 1:");

        jLabel11.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel11.setText("Resposta 1:");

        cbbQuestionOne.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbQuestionOne.setNextFocusableComponent(txtAnswerOne);

        txtAnswerOne.setNextFocusableComponent(cbbQuestionTwo);

        jLabel13.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel13.setText("Pergunta 2:");

        cbbQuestionTwo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbQuestionTwo.setNextFocusableComponent(txtAnswerTwo);

        jLabel14.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel14.setText("Resposta 2:");

        txtAnswerTwo.setNextFocusableComponent(cbbQuestionThree);

        jLabel15.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel15.setText("Pergunta 3:");

        cbbQuestionThree.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbQuestionThree.setNextFocusableComponent(txtAnswerThree);

        jLabel16.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel16.setText("Resposta 3:");

        txtAnswerThree.setNextFocusableComponent(txtUser);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbbQuestionTwo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtAnswerTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbbQuestionOne, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtAnswerOne, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbbQuestionThree, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtAnswerThree, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cbbQuestionOne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtAnswerOne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(cbbQuestionTwo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtAnswerTwo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(cbbQuestionThree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtAnswerThree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cbbQuestionOne;
    private javax.swing.JComboBox<String> cbbQuestionThree;
    private javax.swing.JComboBox<String> cbbQuestionTwo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JRadioButton rdbAdmin;
    private javax.swing.JRadioButton rdbReadOnly;
    private javax.swing.JTextField txtAnswerOne;
    private javax.swing.JTextField txtAnswerThree;
    private javax.swing.JTextField txtAnswerTwo;
    private javax.swing.JTextField txtBornDate;
    private javax.swing.JTextField txtDocNum;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JPasswordField txtPasswordConf;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
