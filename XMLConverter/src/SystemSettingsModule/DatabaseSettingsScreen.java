/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SystemSettingsModule;

import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

/**
 *
 * @author Matheus Cabral Rosa
 */
public class DatabaseSettingsScreen extends javax.swing.JFrame {

    /**
     * Creates new form DatabaseSettingsScreen
     */
    public DatabaseSettingsScreen() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    // Listeners
    // Enviroments
    public void setListenerEnvCbbProjectFilter(ItemListener listener) { cbbEnvProjectFilter.addItemListener(listener); }
    public void setListenerBtnEnvSave(ActionListener listener) { btnEnvSave.addActionListener(listener); }
    public void setListenerBtnEnvSaveAdd(ActionListener listener) { btnEnvSaveAdd.addActionListener(listener); }
    public void setListenerBtnEnvDelete(ActionListener listener) { btnEnvDelete.addActionListener(listener); }
    
    // DBLINKS
    public void setListenerBtnDbLinkSave(ActionListener listener) { btnDbLinkSave.addActionListener(listener); }    
    public void setListenerBtnDbLinkSaveAdd(ActionListener listener) { btnDbLinkSaveAdd.addActionListener(listener); }
    public void setListenerBtnDbLinkDelete(ActionListener listener) { btnDBLinkDelete.addActionListener(listener); }
    
    
    // Control functions
    
    // Functions to insert data on Components
    // Enviroments
    public void insertcbbProjectFilter(String item){ cbbEnvProjectFilter.addItem(item); txtDbLinkName.paintImmediately(txtDbLinkName.getVisibleRect()); }
    public void inserttxtProj(String item){ txtProj.setText(item); txtProj.paintImmediately(txtProj.getVisibleRect()); }
    public void insertcbbType(String item){ cbbType.addItem(item); cbbType.paintImmediately(cbbType.getVisibleRect()); }
    public void inserttxtObjType(String item){ txtObjType.setText(item); txtObjType.paintImmediately(txtObjType.getVisibleRect()); }
    public void inserttxtOrder(String item){ txtOrder.setText(item); txtOrder.paintImmediately(txtOrder.getVisibleRect()); }
    public void inserttxtDescription(String item){ txtDescription.setText(item); txtDescription.paintImmediately(txtDescription.getVisibleRect()); }
    public void inserttxtTableN0(String item){ txtTableN0.setText(item); txtTableN0.paintImmediately(txtTableN0.getVisibleRect()); }
    public void inserttxtTableN1(String item){ txtTableN1.setText(item); txtTableN1.paintImmediately(txtTableN1.getVisibleRect()); }
    public void inserttxtTableN2(String item){ txtTableN2.setText(item); txtTableN2.paintImmediately(txtTableN2.getVisibleRect()); }
    public void inserttxtTableN3(String item){ txtTableN3.setText(item); txtTableN3.paintImmediately(txtTableN3.getVisibleRect()); }
    public void inserttxtTable(String item){ txtTable.setText(item); txtTable.paintImmediately(txtTable.getVisibleRect()); }
    public void inserttxtJoinN0(String item){ txtJoinN0.setText(item); txtJoinN0.paintImmediately(txtJoinN0.getVisibleRect()); }
    public void inserttxtJoinN1(String item){ txtJoinN1.setText(item); txtJoinN1.paintImmediately(txtJoinN1.getVisibleRect()); }
    public void inserttxtJoinN2(String item){ txtJoinN2.setText(item); txtJoinN2.paintImmediately(txtJoinN2.getVisibleRect()); }
    public void inserttxtJoinN3(String item){ txtJoinN3.setText(item); txtJoinN3.paintImmediately(txtJoinN3.getVisibleRect()); }
    public void inserttxtSearchSpec(String item){ txtSearchSpec.setText(item); txtSearchSpec.paintImmediately(txtSearchSpec.getVisibleRect()); }
    public void inserttxtKeyField(String item){ txtKeyField.setText(item); txtKeyField.paintImmediately(txtKeyField.getVisibleRect()); }
    public void inserttxtLine(String item){ txtLine.setText(item); txtLine.paintImmediately(txtLine.getVisibleRect()); }
    public void insertrdbActive(String item){ 
        if("Y".equals(item)){
            rdbActiveYes.setSelected(true);
            rdbActiveNo.setSelected(false);
            rdbActiveYes.paintImmediately(rdbActiveYes.getVisibleRect());
            rdbActiveNo.paintImmediately(rdbActiveNo.getVisibleRect());
        } else {
            rdbActiveYes.setSelected(false);
            rdbActiveNo.setSelected(true);
            rdbActiveYes.paintImmediately(rdbActiveYes.getVisibleRect());
            rdbActiveNo.paintImmediately(rdbActiveNo.getVisibleRect());
        }
    }
    // DBLINKS
    public void inserttxtDbLinkName(String item){ txtDbLinkName.setText(item); txtDbLinkName.paintImmediately(txtDbLinkName.getVisibleRect()); }
    public void inserttxtDbLinkUser(String item){ txtDbLinkUser.setText(item); txtDbLinkUser.paintImmediately(txtDbLinkUser.getVisibleRect()); }
    public void inserttxtDbLinkPassword(String item){ txtDbLinkPassword.setText(item); txtDbLinkPassword.paintImmediately(txtDbLinkPassword.getVisibleRect()); }
    public void inserttxtDbLinkPasswordConf(String item){ txtDbLinkPasswordConf.setText(item); txtDbLinkPasswordConf.paintImmediately(txtDbLinkPasswordConf.getVisibleRect()); }
    public void inserttxtDbLinkServName(String item){ txtDbLinkServName.setText(item); txtDbLinkServName.paintImmediately(txtDbLinkServName.getVisibleRect()); }
    public void insertrdbDbLinkPub(String item){ 
        if("Y".equals(item)){
            rdbDbLinkPubYes.setSelected(true);
            rdbDbLinkPubNo.setSelected(false);
            rdbDbLinkPubYes.paintImmediately(rdbDbLinkPubYes.getVisibleRect());
            rdbDbLinkPubNo.paintImmediately(rdbDbLinkPubNo.getVisibleRect());
        } else {
            rdbDbLinkPubYes.setSelected(false);
            rdbDbLinkPubNo.setSelected(true);
            rdbDbLinkPubYes.paintImmediately(rdbDbLinkPubYes.getVisibleRect());
            rdbDbLinkPubNo.paintImmediately(rdbDbLinkPubNo.getVisibleRect());
        }
    }
    
    // Functions to clear the Components data 
    // Enviroments
    public void clearcbbProjectFilter(){ cbbEnvProjectFilter.removeAllItems(); txtDbLinkName.paintImmediately(txtDbLinkName.getVisibleRect()); }
    public void cleartxtProj(){ txtProj.setText(""); txtProj.paintImmediately(txtProj.getVisibleRect()); }
    public void clearcbbType(){ cbbType.removeAllItems(); cbbType.paintImmediately(cbbType.getVisibleRect()); }
    public void cleartxtObjType(){ txtObjType.setText(""); txtObjType.paintImmediately(txtObjType.getVisibleRect()); }
    public void cleartxtOrder(){ txtOrder.setText(""); txtOrder.paintImmediately(txtOrder.getVisibleRect()); }
    public void cleartxtDescription(){ txtDescription.setText(""); txtDescription.paintImmediately(txtDescription.getVisibleRect()); }
    public void cleartxtTableN0(){ txtTableN0.setText(""); txtTableN0.paintImmediately(txtTableN0.getVisibleRect()); }
    public void cleartxtTableN1(){ txtTableN1.setText(""); txtTableN1.paintImmediately(txtTableN1.getVisibleRect()); }
    public void cleartxtTableN2(){ txtTableN2.setText(""); txtTableN2.paintImmediately(txtTableN2.getVisibleRect()); }
    public void cleartxtTableN3(){ txtTableN3.setText(""); txtTableN3.paintImmediately(txtTableN3.getVisibleRect()); }
    public void cleartxtTable(){ txtTable.setText(""); txtTable.paintImmediately(txtTable.getVisibleRect()); }
    public void cleartxtJoinN0(){ txtJoinN0.setText(""); txtJoinN0.paintImmediately(txtJoinN0.getVisibleRect()); }
    public void cleartxtJoinN1(){ txtJoinN1.setText(""); txtJoinN1.paintImmediately(txtJoinN1.getVisibleRect()); }
    public void cleartxtJoinN2(){ txtJoinN2.setText(""); txtJoinN2.paintImmediately(txtJoinN2.getVisibleRect()); }
    public void cleartxtJoinN3(){ txtJoinN3.setText(""); txtJoinN3.paintImmediately(txtJoinN3.getVisibleRect()); }
    public void cleartxtSearchSpec(){ txtSearchSpec.setText(""); txtSearchSpec.paintImmediately(txtSearchSpec.getVisibleRect()); }
    public void cleartxtKeyField(){ txtKeyField.setText(""); txtKeyField.paintImmediately(txtKeyField.getVisibleRect()); }
    public void cleartxtLine(){ txtLine.setText(""); txtLine.paintImmediately(txtLine.getVisibleRect()); }
    public void clearrdbActive(){
        rdbActiveYes.setSelected(false);
        rdbActiveNo.setSelected(false);
        rdbActiveYes.paintImmediately(rdbActiveYes.getVisibleRect());
        rdbActiveNo.paintImmediately(rdbActiveNo.getVisibleRect());
    }
    // DBLINKS
    public void cleartxtDbLinkName(){ txtDbLinkName.setText(""); txtDbLinkName.paintImmediately(txtDbLinkName.getVisibleRect()); }
    public void cleartxtDbLinkUser(){ txtDbLinkUser.setText(""); txtDbLinkUser.paintImmediately(txtDbLinkUser.getVisibleRect()); }
    public void cleartxtDbLinkPassword(){ txtDbLinkPassword.setText(""); txtDbLinkPassword.paintImmediately(txtDbLinkPassword.getVisibleRect()); }
    public void cleartxtDbLinkPasswordConf(){ txtDbLinkPasswordConf.setText(""); txtDbLinkPasswordConf.paintImmediately(txtDbLinkPasswordConf.getVisibleRect()); }
    public void cleartxtDbLinkServName(){ txtDbLinkServName.setText(""); txtDbLinkServName.paintImmediately(txtDbLinkServName.getVisibleRect()); }
    public void clearrdbDbLinkPub(){
        rdbDbLinkPubYes.setSelected(false);
        rdbDbLinkPubNo.setSelected(false);
        rdbDbLinkPubYes.paintImmediately(rdbDbLinkPubYes.getVisibleRect());
        rdbDbLinkPubNo.paintImmediately(rdbDbLinkPubNo.getVisibleRect());
    }
    
    // Functions to return data from Components
    // Enviroments
    public String getcbbProjectFilter(){ return cbbEnvProjectFilter.getSelectedItem().toString(); }
    public String gettxtProj(){ return txtProj.getText(); }
    public String getcbbType(){ return cbbType.getSelectedItem().toString(); }
    public String gettxtObjType(){ return txtObjType.getText(); }
    public String gettxtOrder(){ return txtOrder.getText(); }
    public String gettxtDescription(){ return txtDescription.getText(); }
    public String gettxtTableN0(){ return txtTableN0.getText(); }
    public String gettxtTableN1(){ return txtTableN1.getText(); }
    public String gettxtTableN2(){ return txtTableN2.getText(); }
    public String gettxtTableN3(){ return txtTableN3.getText(); }
    public String gettxtTable(){ return txtTable.getText(); }
    public String gettxtJoinN0(){ return txtJoinN0.getText(); }
    public String gettxtJoinN1(){ return txtJoinN1.getText(); }
    public String gettxtJoinN2(){ return txtJoinN2.getText(); }
    public String gettxtJoinN3(){ return txtJoinN3.getText(); }
    public String gettxtSearchSpec(){ return txtSearchSpec.getText(); }
    public String gettxtKeyField(){ return txtKeyField.getText(); }
    public String gettxtLine(){ return txtLine.getText(); }
    public String getrdbActive() {
        if (rdbActiveYes.isSelected()){
            return "N";
        } else {
            return "Y";
        }
    }    
    // DBLINKS
    public String gettxtDbLinkName(){ return txtDbLinkName.getText(); }
    public String gettxtDbLinkUser(){ return txtDbLinkUser.getText(); }
    public String gettxtDbLinkPassword() { return txtDbLinkPassword.getText(); }
    public String gettxtDbLinkPasswordConf() { return txtDbLinkPasswordConf.getText(); }
    public String gettxtDbLinkServName() { return txtDbLinkServName.getText(); }
    public String getrdbDbLinkPub() {
        if (rdbDbLinkPubYes.isSelected()){
            return "Y";
        } else {
            return "N";
        }
    }
        
    // Functions to enable or disable Components
    // Enviroments
    public void setcbbProjectFilterEnabled(boolean status){ this.cbbEnvProjectFilter.setEnabled(status); }
    public void settxtProjEnabled(boolean status){ this.txtProj.setEnabled(status); }
    public void setcbbTypeEnabled(boolean status){ this.cbbType.setEnabled(status); }
    public void settxtObjTypeEnabled(boolean status){ this.txtObjType.setEnabled(status); }
    public void settxtOrderEnabled(boolean status){ this.txtOrder.setEnabled(status); }
    public void settxtDescriptionEnabled(boolean status){ this.txtDescription.setEnabled(status); }
    public void settxtTableN0Enabled(boolean status){ this.txtTableN0.setEnabled(status); }
    public void settxtTableN1Enabled(boolean status){ this.txtTableN1.setEnabled(status); }
    public void settxtTableN2Enabled(boolean status){ this.txtTableN2.setEnabled(status); }
    public void settxtTableN3Enabled(boolean status){ this.txtTableN3.setEnabled(status); }
    public void settxtTableEnabled(boolean status){ this.txtTable.setEnabled(status); }
    public void settxtJoinN0Enabled(boolean status){ this.txtJoinN0.setEnabled(status); }
    public void settxtJoinN1Enabled(boolean status){ this.txtJoinN1.setEnabled(status); }
    public void settxtJoinN2Enabled(boolean status){ this.txtJoinN2.setEnabled(status); }
    public void settxtJoinN3Enabled(boolean status){ this.txtJoinN3.setEnabled(status); }
    public void settxtSearchSpecEnabled(boolean status){ this.txtSearchSpec.setEnabled(status); }
    public void settxtKeyFieldEnabled(boolean status){ this.txtKeyField.setEnabled(status); }
    public void settxtLineEnabled(boolean status){ this.txtLine.setEnabled(status); }
    public void setrdbActiveYesEnabled(boolean status){ this.rdbActiveYes.setEnabled(status); }
    public void setrdbActiveNoEnabled(boolean status){ this.rdbActiveNo.setEnabled(status); }
    // DBLINKS
    public void settxtDbLinkNameEnabled(boolean status){ this.txtDbLinkName.setEnabled(status); }
    public void settxtDbLinkUserEnabled(boolean status){ this.txtDbLinkUser.setEnabled(status); }
    public void settxtDbLinkPasswordEnabled(boolean status){ this.txtDbLinkPassword.setEnabled(status); }
    public void settxtDbLinkPasswordConfEnabled(boolean status){ this.txtDbLinkPasswordConf.setEnabled(status); }
    public void settxtDbLinkServNameEnabled(boolean status){ this.txtDbLinkServName.setEnabled(status); }
    public void setrdbDbLinkPubYesEnabled(boolean status){ this.rdbDbLinkPubYes.setEnabled(status); }
    public void setrdbDbLinkPubNoEnabled(boolean status){ this.rdbDbLinkPubNo.setEnabled(status); }
    //public void setbtnDbLinkCancelEnabled(boolean status){ this.btnDbLinkCancel.setEnabled(status); }
    public void setbtnDbLinkSaveEnabled(boolean status){ this.btnDbLinkSave.setEnabled(status); }
    public void setbtnDbLinkSaveAddEnabled(boolean status){ this.btnDbLinkSaveAdd.setEnabled(status); }
    
    // Functions to return the Components Status
    // Enviroments
    public boolean iscbbProjectFilterEnabled(){ return cbbEnvProjectFilter.isEnabled(); }
    public boolean istxtProjEnabled(){ return txtProj.isEnabled(); }
    public boolean iscbbTypeEnabled(){ return cbbType.isEnabled(); }
    public boolean istxtObjTypeEnabled(){ return txtObjType.isEnabled(); }
    public boolean istxtOrderEnabled(){ return txtOrder.isEnabled(); }
    public boolean istxtDescriptionEnabled(){ return txtDescription.isEnabled(); }
    public boolean istxtTableN0Enabled(){ return txtTableN0.isEnabled(); }
    public boolean istxtTableN1Enabled(){ return txtTableN1.isEnabled(); }
    public boolean istxtTableN2Enabled(){ return txtTableN2.isEnabled(); }
    public boolean istxtTableN3Enabled(){ return txtTableN3.isEnabled(); }
    public boolean istxtTableEnabled(){ return txtTable.isEnabled(); }
    public boolean istxtJoinN0Enabled(){ return txtJoinN0.isEnabled(); }
    public boolean istxtJoinN1Enabled(){ return txtJoinN1.isEnabled(); }
    public boolean istxtJoinN2Enabled(){ return txtJoinN2.isEnabled(); }
    public boolean istxtJoinN3Enabled(){ return txtJoinN3.isEnabled(); }
    public boolean istxtSearchSpecEnabled(){ return txtSearchSpec.isEnabled(); }
    public boolean istxtKeyFieldEnabled(){ return txtKeyField.isEnabled(); }
    public boolean istxtLineEnabled(){ return txtLine.isEnabled(); }
    public boolean isrdbActiveYesEnabled(){ return rdbActiveYes.isEnabled(); }
    public boolean isrdbActiveNoEnabled(){ return rdbActiveNo.isEnabled(); }
    // DBLINKS
    public boolean istxtDbLinkNameEnabled(){ return this.txtDbLinkName.isEnabled(); }
    public boolean istxtDbLinkUserEnabled(){ return this.txtDbLinkUser.isEnabled(); }
    public boolean istxtDbLinkPasswordEnabled(){ return this.txtDbLinkPassword.isEnabled(); }
    public boolean istxtDbLinkPasswordConfEnabled(){ return this.txtDbLinkPasswordConf.isEnabled(); }
    public boolean istxtDbLinkServNameEnabled(){ return this.txtDbLinkServName.isEnabled(); }
    public boolean isrdbDbLinkPubYesEnabled(){ return this.rdbDbLinkPubYes.isEnabled(); }
    public boolean isrdbDbLinkPubNoEnabled(){ return this.rdbDbLinkPubNo.isEnabled(); }
    //public boolean isbtnDbLinkCancelEnabled(){ return this.btnDbLinkCancel.isEnabled(); }
    public boolean isbtnDbLinkSaveEnabled(){ return this.btnDbLinkSave.isEnabled(); }
    public boolean isbtnDbLinkSaveAddEnabled(){ return this.btnDbLinkSaveAdd.isEnabled(); }
    
    // Functions to return the Components items quantity
    // Enviroments
    public int getcbbProjectFilterSize(){ return this.cbbEnvProjectFilter.getItemCount(); }
    public int getcbbTypeSize(){ return this.cbbType.getItemCount(); }
    
    // Function to return the index of selected item on ComboBox
    // Enviroments
    public int getcbbProjectFilterIndex() { return this.cbbEnvProjectFilter.getSelectedIndex() - 1; }
    public int getcbbTypeIndex(){ return this.cbbType.getSelectedIndex() - 1; }
    
    public void setFocus(String component) {
        switch(component) {
            case "DBLINK_NAME":
                txtDbLinkName.requestFocus();
                break;
            case "DBLINK_USER_NAME":
                txtDbLinkUser.requestFocus();
                break;
            case "DBLINK_PASSWORD":
                txtDbLinkPassword.requestFocus();
                break;
            case "DBLINK_PASSWORD_CONF":
                txtDbLinkPasswordConf.requestFocus();
                break;
            case "DBLINK_SERV_NAME":
                txtDbLinkServName.requestFocus();
                break;
            case "DBLINK_PUBLIC_YES":
                rdbDbLinkPubYes.requestFocus();
                break;
            case "DBLINK_PUBLIC_NO":
                rdbDbLinkPubNo.requestFocus();
                break;
            case "ENV_PROJECT_FILTER":
                cbbEnvProjectFilter.requestFocus();
                break;
            case "ENV_PROJ":
                txtProj.requestFocus();
                break;
            case "ENV_TYPE":
                cbbType.requestFocus();
                break;
            case "ENV_OBJTYPE":
                txtObjType.requestFocus();
                break;
            case "ENV_ORDER":
                txtOrder.requestFocus();
                break;
            case "ENV_DESCRIPTION":
                txtDescription.requestFocus();
                break;
            case "ENV_TABLEN0":
                txtTableN0.requestFocus();
                break;
            case "ENV_TABLEN1":
                txtTableN1.requestFocus();
                break;
            case "ENV_TABLEN2":
                txtTableN2.requestFocus();
                break;
            case "ENV_TABLEN3":
                txtTableN3.requestFocus();
                break;
            case "ENV_TABLE":
                txtTable.requestFocus();
                break;
            case "ENV_JOINN0":
                txtJoinN0.requestFocus();
                break;
            case "ENV_JOINN1":
                txtJoinN1.requestFocus();
                break;
            case "ENV_JOINN2":
                txtJoinN2.requestFocus();
                break;
            case "ENV_JOINN3":
                txtJoinN3.requestFocus();
                break;
            case "ENV_SEARCH_SPEC":
                txtSearchSpec.requestFocus();
                break;
            case "ENV_KEYFIELD":
                txtKeyField.requestFocus();
                break;
            case "ENV_LINE":
                txtLine.requestFocus();
                break;
            case "ENV_ACTIVE_YES":
                rdbActiveYes.requestFocus();
                break;
            case "ENV_ACTIVE_NO":
                rdbActiveNo.requestFocus();
                break;
            default:
                break;
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PnlMain = new javax.swing.JPanel();
        lblScreen = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        PnlEnviroments = new javax.swing.JPanel();
        lblEnv = new javax.swing.JLabel();
        lblProjectFilter = new javax.swing.JLabel();
        cbbEnvProjectFilter = new javax.swing.JComboBox<>();
        btnEnvSaveAdd = new javax.swing.JButton();
        btnEnvSave = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEnvList = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        lblProj = new javax.swing.JLabel();
        txtProj = new javax.swing.JTextField();
        lblType = new javax.swing.JLabel();
        cbbType = new javax.swing.JComboBox<>();
        lblObjType = new javax.swing.JLabel();
        lblOrder = new javax.swing.JLabel();
        txtOrder = new javax.swing.JTextField();
        lblDecription = new javax.swing.JLabel();
        txtDescription = new javax.swing.JTextField();
        lblTableN0 = new javax.swing.JLabel();
        txtTableN0 = new javax.swing.JTextField();
        lblTableN1 = new javax.swing.JLabel();
        txtTableN1 = new javax.swing.JTextField();
        lblTableN2 = new javax.swing.JLabel();
        txtTableN2 = new javax.swing.JTextField();
        lblTableN3 = new javax.swing.JLabel();
        txtTableN3 = new javax.swing.JTextField();
        txtQueryTable = new javax.swing.JLabel();
        txtTable = new javax.swing.JTextField();
        lblJoinN0 = new javax.swing.JLabel();
        txtJoinN0 = new javax.swing.JTextField();
        lblJoinN1 = new javax.swing.JLabel();
        txtJoinN1 = new javax.swing.JTextField();
        lblJoinN2 = new javax.swing.JLabel();
        txtJoinN2 = new javax.swing.JTextField();
        lblJoinN3 = new javax.swing.JLabel();
        txtJoinN3 = new javax.swing.JTextField();
        lblActive = new javax.swing.JLabel();
        rdbActiveYes = new javax.swing.JRadioButton();
        rdbActiveNo = new javax.swing.JRadioButton();
        lblSearchSpec = new javax.swing.JLabel();
        txtSearchSpec = new javax.swing.JTextField();
        lblKeyField = new javax.swing.JLabel();
        txtKeyField = new javax.swing.JTextField();
        lblLine = new javax.swing.JLabel();
        txtLine = new javax.swing.JTextField();
        txtObjType = new javax.swing.JTextField();
        btnEnvDelete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblDBLinks = new javax.swing.JPanel();
        lblList = new javax.swing.JLabel();
        btnDBLinkDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDbLinkList = new javax.swing.JTable();
        PnlAddDBLink = new javax.swing.JPanel();
        txtDbLinkName = new javax.swing.JTextField();
        txtDbLinkUser = new javax.swing.JTextField();
        txtDbLinkPassword = new javax.swing.JPasswordField();
        txtDbLinkPasswordConf = new javax.swing.JPasswordField();
        txtDbLinkServName = new javax.swing.JTextField();
        rdbDbLinkPubYes = new javax.swing.JRadioButton();
        rdbDbLinkPubNo = new javax.swing.JRadioButton();
        lblDBLinkName = new javax.swing.JLabel();
        lblDBLinkUser = new javax.swing.JLabel();
        lblDBLinkPassword = new javax.swing.JLabel();
        lblDBLinkConfPassword = new javax.swing.JLabel();
        lblDBLinkServ = new javax.swing.JLabel();
        lblDBLinkPub = new javax.swing.JLabel();
        btnDbLinkSave = new javax.swing.JButton();
        btnDbLinkSaveAdd = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Configurações do Banco de Dados");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        PnlMain.setBackground(new java.awt.Color(255, 255, 255));

        lblScreen.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblScreen.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblScreen.setText("Configurações do Banco de Dados");
        lblScreen.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jTabbedPane2.setToolTipText("");

        PnlEnviroments.setBackground(new java.awt.Color(255, 255, 255));

        lblEnv.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblEnv.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblEnv.setText("Lista de Objetos Verificados");
        lblEnv.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        lblProjectFilter.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblProjectFilter.setText("Filtrar por Projeto:");

        cbbEnvProjectFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnEnvSaveAdd.setText("Salvar e Novo");

        btnEnvSave.setText("Salvar");

        tblEnvList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "FILA", "PROJETO", "TIPO", "TIPO OBJETO", "ORDEM", "DESCRIÇÃO", "TABELA NVL 0", "TABELA NVL 1", "TABELA NVL 2", "TABELA NVL 3", "NOME TABELA", "JOIN NVL 0", "JOIN NVL 1", "JOIN NVL 2", "JOIN NVL 3", "INATIVO", "FIELD CHAVE", "SEARCH SPEC"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEnvList.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane2.setViewportView(tblEnvList);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Adicionar Novo Objeto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        lblProj.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblProj.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblProj.setText("Projeto*:");

        txtProj.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtProj.setText("jTextField1");

        lblType.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblType.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblType.setText("Tipo*:");

        cbbType.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbbType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblObjType.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblObjType.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblObjType.setText("Tipo de Objeto*:");

        lblOrder.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblOrder.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblOrder.setText("Ordem*:");

        txtOrder.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtOrder.setText("jTextField1");
        txtOrder.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtOrderKeyPressed(evt);
            }
        });

        lblDecription.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblDecription.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDecription.setText("Descrição*:");

        txtDescription.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtDescription.setText("jTextField1");

        lblTableN0.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblTableN0.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTableN0.setText("Tabela Nivel 0:");

        txtTableN0.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtTableN0.setText("jTextField1");

        lblTableN1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblTableN1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTableN1.setText("Tabela Nivel 1:");

        txtTableN1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtTableN1.setText("jTextField1");

        lblTableN2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblTableN2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTableN2.setText("Tabela Nivel 2:");

        txtTableN2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtTableN2.setText("jTextField1");

        lblTableN3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblTableN3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTableN3.setText("Tabela Nivel 3:");

        txtTableN3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtTableN3.setText("jTextField1");

        txtQueryTable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtQueryTable.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtQueryTable.setText("Tabela Query*:");

        txtTable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtTable.setText("jTextField1");

        lblJoinN0.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblJoinN0.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblJoinN0.setText("Join de Nivel 1 para 0:");

        txtJoinN0.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtJoinN0.setText("jTextField1");

        lblJoinN1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblJoinN1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblJoinN1.setText("Join de Nivel 2 para 1:");

        txtJoinN1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtJoinN1.setText("jTextField1");

        lblJoinN2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblJoinN2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblJoinN2.setText("Join de Nivel 3 para 2:");

        txtJoinN2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtJoinN2.setText("jTextField1");

        lblJoinN3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblJoinN3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblJoinN3.setText("Join de Query para 3:");

        txtJoinN3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtJoinN3.setText("jTextField1");

        lblActive.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblActive.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblActive.setText("Ativo*:");

        rdbActiveYes.setBackground(new java.awt.Color(255, 255, 255));
        rdbActiveYes.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rdbActiveYes.setText("Sim");
        rdbActiveYes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbActiveYesActionPerformed(evt);
            }
        });

        rdbActiveNo.setBackground(new java.awt.Color(255, 255, 255));
        rdbActiveNo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rdbActiveNo.setText("Não");
        rdbActiveNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbActiveNoActionPerformed(evt);
            }
        });

        lblSearchSpec.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblSearchSpec.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSearchSpec.setText("Search Spec:");

        txtSearchSpec.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtSearchSpec.setText("jTextField1");

        lblKeyField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblKeyField.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblKeyField.setText("Field Chave:");

        txtKeyField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtKeyField.setText("jTextField1");

        lblLine.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblLine.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblLine.setText("Fila/Thread*:");

        txtLine.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtLine.setText("jTextField1");

        txtObjType.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtObjType.setText("jTextField1");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(lblTableN0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTableN0, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(lblDecription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(lblOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblType, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblObjType, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblProj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtProj)
                            .addComponent(cbbType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtObjType, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblJoinN0, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                    .addComponent(lblJoinN1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtQueryTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTableN3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTableN2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTableN1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(txtTable, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSearchSpec, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearchSpec))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTableN1)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtTableN2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtTableN3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblJoinN2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblJoinN3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblActive, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(rdbActiveYes)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdbActiveNo))
                            .addComponent(txtJoinN2, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtJoinN3, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtJoinN1)
                            .addComponent(txtJoinN0, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblKeyField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblLine, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtKeyField)
                            .addComponent(txtLine, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProj)
                    .addComponent(txtProj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblType)
                    .addComponent(cbbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblObjType)
                    .addComponent(lblTableN3)
                    .addComponent(txtObjType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOrder)
                    .addComponent(txtOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtQueryTable))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDecription)
                    .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTableN0)
                    .addComponent(txtTableN0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSearchSpec)
                    .addComponent(txtSearchSpec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtJoinN0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblKeyField)
                    .addComponent(txtKeyField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblJoinN0))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtJoinN1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLine)
                    .addComponent(txtLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblJoinN1)))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblJoinN2)
                        .addComponent(txtJoinN2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTableN1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblTableN1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTableN2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblJoinN3)
                    .addComponent(txtJoinN3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTableN2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTableN3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblActive)
                    .addComponent(rdbActiveYes)
                    .addComponent(rdbActiveNo)))
        );

        btnEnvDelete.setText("Excluir");

        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("(*) Campos Obrigatórios");

        javax.swing.GroupLayout PnlEnviromentsLayout = new javax.swing.GroupLayout(PnlEnviroments);
        PnlEnviroments.setLayout(PnlEnviromentsLayout);
        PnlEnviromentsLayout.setHorizontalGroup(
            PnlEnviromentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlEnviromentsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnlEnviromentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlEnviromentsLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEnvSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEnvSaveAdd))
                    .addGroup(PnlEnviromentsLayout.createSequentialGroup()
                        .addComponent(lblEnv)
                        .addGap(18, 18, 18)
                        .addComponent(lblProjectFilter)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbEnvProjectFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEnvDelete)))
                .addContainerGap())
        );
        PnlEnviromentsLayout.setVerticalGroup(
            PnlEnviromentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlEnviromentsLayout.createSequentialGroup()
                .addGroup(PnlEnviromentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEnv)
                    .addComponent(lblProjectFilter)
                    .addComponent(cbbEnvProjectFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEnvDelete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PnlEnviromentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PnlEnviromentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnEnvSave)
                        .addComponent(btnEnvSaveAdd))
                    .addComponent(jLabel1))
                .addContainerGap())
        );

        jTabbedPane2.addTab("Ambientes", PnlEnviroments);

        lblDBLinks.setBackground(new java.awt.Color(255, 255, 255));

        lblList.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblList.setText("Lista de Links de Banco de Dados");

        btnDBLinkDelete.setText("Excluir");

        tblDbLinkList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "OWNER", "DB_LINK NAME", "USERNAME", "HOST", "CREATED"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblDbLinkList);

        PnlAddDBLink.setBackground(new java.awt.Color(255, 255, 255));
        PnlAddDBLink.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Adicionar Novo Link de Banco de Dados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        txtDbLinkName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtDbLinkName.setText("jTextField1");

        txtDbLinkUser.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtDbLinkUser.setText("jTextField1");

        txtDbLinkPassword.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtDbLinkPassword.setText("jPasswordField1");

        txtDbLinkPasswordConf.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtDbLinkPasswordConf.setText("jPasswordField1");

        txtDbLinkServName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtDbLinkServName.setText("jTextField1");

        rdbDbLinkPubYes.setBackground(new java.awt.Color(255, 255, 255));
        rdbDbLinkPubYes.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rdbDbLinkPubYes.setText("Sim");
        rdbDbLinkPubYes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbDbLinkPubYesActionPerformed(evt);
            }
        });

        rdbDbLinkPubNo.setBackground(new java.awt.Color(255, 255, 255));
        rdbDbLinkPubNo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rdbDbLinkPubNo.setText("Não");
        rdbDbLinkPubNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbDbLinkPubNoActionPerformed(evt);
            }
        });

        lblDBLinkName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblDBLinkName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDBLinkName.setText("Nome*:");

        lblDBLinkUser.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblDBLinkUser.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDBLinkUser.setText("Nome Usuário*:");

        lblDBLinkPassword.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblDBLinkPassword.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDBLinkPassword.setText("Senha*:");

        lblDBLinkConfPassword.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblDBLinkConfPassword.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDBLinkConfPassword.setText("Confirmar Senha*:");

        lblDBLinkServ.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblDBLinkServ.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDBLinkServ.setText("Nome Serviço*:");

        lblDBLinkPub.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblDBLinkPub.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDBLinkPub.setText("Público*:");

        javax.swing.GroupLayout PnlAddDBLinkLayout = new javax.swing.GroupLayout(PnlAddDBLink);
        PnlAddDBLink.setLayout(PnlAddDBLinkLayout);
        PnlAddDBLinkLayout.setHorizontalGroup(
            PnlAddDBLinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlAddDBLinkLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnlAddDBLinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PnlAddDBLinkLayout.createSequentialGroup()
                        .addComponent(lblDBLinkName, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDbLinkName, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PnlAddDBLinkLayout.createSequentialGroup()
                        .addComponent(lblDBLinkPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDbLinkPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(PnlAddDBLinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PnlAddDBLinkLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(lblDBLinkConfPassword)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDbLinkPasswordConf, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PnlAddDBLinkLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDBLinkUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDbLinkUser, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PnlAddDBLinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDBLinkPub, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDBLinkServ, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PnlAddDBLinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDbLinkServName, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PnlAddDBLinkLayout.createSequentialGroup()
                        .addComponent(rdbDbLinkPubYes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdbDbLinkPubNo)))
                .addContainerGap())
        );
        PnlAddDBLinkLayout.setVerticalGroup(
            PnlAddDBLinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlAddDBLinkLayout.createSequentialGroup()
                .addGroup(PnlAddDBLinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDBLinkName)
                    .addComponent(txtDbLinkName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDbLinkServName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDBLinkServ)
                    .addComponent(lblDBLinkUser)
                    .addComponent(txtDbLinkUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PnlAddDBLinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PnlAddDBLinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblDBLinkPub)
                        .addComponent(rdbDbLinkPubYes)
                        .addComponent(rdbDbLinkPubNo)
                        .addComponent(txtDbLinkPasswordConf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblDBLinkConfPassword))
                    .addGroup(PnlAddDBLinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblDBLinkPassword)
                        .addComponent(txtDbLinkPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        btnDbLinkSave.setText("Salvar");

        btnDbLinkSaveAdd.setText("Salvar e Novo");

        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("(*) Campos Obrigatórios");

        javax.swing.GroupLayout lblDBLinksLayout = new javax.swing.GroupLayout(lblDBLinks);
        lblDBLinks.setLayout(lblDBLinksLayout);
        lblDBLinksLayout.setHorizontalGroup(
            lblDBLinksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblDBLinksLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(lblDBLinksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(PnlAddDBLink, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lblDBLinksLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDbLinkSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDbLinkSaveAdd))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lblDBLinksLayout.createSequentialGroup()
                        .addComponent(lblList)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDBLinkDelete)))
                .addContainerGap())
        );
        lblDBLinksLayout.setVerticalGroup(
            lblDBLinksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblDBLinksLayout.createSequentialGroup()
                .addGroup(lblDBLinksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblList)
                    .addComponent(btnDBLinkDelete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PnlAddDBLink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lblDBLinksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lblDBLinksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnDbLinkSave)
                        .addComponent(btnDbLinkSaveAdd))
                    .addComponent(jLabel2))
                .addContainerGap())
        );

        jTabbedPane2.addTab("Links de Banco de Dados", lblDBLinks);

        javax.swing.GroupLayout PnlMainLayout = new javax.swing.GroupLayout(PnlMain);
        PnlMain.setLayout(PnlMainLayout);
        PnlMainLayout.setHorizontalGroup(
            PnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblScreen, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        PnlMainLayout.setVerticalGroup(
            PnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblScreen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane2))
        );

        jTabbedPane2.getAccessibleContext().setAccessibleName("tab2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        PnlMain.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rdbDbLinkPubYesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbDbLinkPubYesActionPerformed
        this.rdbDbLinkPubNo.setSelected(false);
        this.rdbDbLinkPubNo.paintImmediately(rdbDbLinkPubNo.getVisibleRect());
    }//GEN-LAST:event_rdbDbLinkPubYesActionPerformed
        
    private void rdbDbLinkPubNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbDbLinkPubNoActionPerformed
        this.rdbDbLinkPubYes.setSelected(false);
        this.rdbDbLinkPubYes.paintImmediately(rdbDbLinkPubYes.getVisibleRect());
    }//GEN-LAST:event_rdbDbLinkPubNoActionPerformed

    private void rdbActiveYesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbActiveYesActionPerformed
        this.rdbActiveNo.setSelected(false);
        this.rdbActiveNo.paintImmediately(rdbActiveNo.getVisibleRect());
    }//GEN-LAST:event_rdbActiveYesActionPerformed

    private void rdbActiveNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbActiveNoActionPerformed
        this.rdbActiveYes.setSelected(false);
        this.rdbActiveYes.paintImmediately(rdbActiveYes.getVisibleRect());
    }//GEN-LAST:event_rdbActiveNoActionPerformed

    private void txtOrderKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOrderKeyPressed
        
    }//GEN-LAST:event_txtOrderKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PnlAddDBLink;
    private javax.swing.JPanel PnlEnviroments;
    private javax.swing.JPanel PnlMain;
    private javax.swing.JButton btnDBLinkDelete;
    private javax.swing.JButton btnDbLinkSave;
    private javax.swing.JButton btnDbLinkSaveAdd;
    private javax.swing.JButton btnEnvDelete;
    private javax.swing.JButton btnEnvSave;
    private javax.swing.JButton btnEnvSaveAdd;
    private javax.swing.JComboBox<String> cbbEnvProjectFilter;
    private javax.swing.JComboBox<String> cbbType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel lblActive;
    private javax.swing.JLabel lblDBLinkConfPassword;
    private javax.swing.JLabel lblDBLinkName;
    private javax.swing.JLabel lblDBLinkPassword;
    private javax.swing.JLabel lblDBLinkPub;
    private javax.swing.JLabel lblDBLinkServ;
    private javax.swing.JLabel lblDBLinkUser;
    private javax.swing.JPanel lblDBLinks;
    private javax.swing.JLabel lblDecription;
    private javax.swing.JLabel lblEnv;
    private javax.swing.JLabel lblJoinN0;
    private javax.swing.JLabel lblJoinN1;
    private javax.swing.JLabel lblJoinN2;
    private javax.swing.JLabel lblJoinN3;
    private javax.swing.JLabel lblKeyField;
    private javax.swing.JLabel lblLine;
    private javax.swing.JLabel lblList;
    private javax.swing.JLabel lblObjType;
    private javax.swing.JLabel lblOrder;
    private javax.swing.JLabel lblProj;
    private javax.swing.JLabel lblProjectFilter;
    private javax.swing.JLabel lblScreen;
    private javax.swing.JLabel lblSearchSpec;
    private javax.swing.JLabel lblTableN0;
    private javax.swing.JLabel lblTableN1;
    private javax.swing.JLabel lblTableN2;
    private javax.swing.JLabel lblTableN3;
    private javax.swing.JLabel lblType;
    private javax.swing.JRadioButton rdbActiveNo;
    private javax.swing.JRadioButton rdbActiveYes;
    private javax.swing.JRadioButton rdbDbLinkPubNo;
    private javax.swing.JRadioButton rdbDbLinkPubYes;
    protected javax.swing.JTable tblDbLinkList;
    protected javax.swing.JTable tblEnvList;
    private javax.swing.JTextField txtDbLinkName;
    private javax.swing.JPasswordField txtDbLinkPassword;
    private javax.swing.JPasswordField txtDbLinkPasswordConf;
    private javax.swing.JTextField txtDbLinkServName;
    private javax.swing.JTextField txtDbLinkUser;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtJoinN0;
    private javax.swing.JTextField txtJoinN1;
    private javax.swing.JTextField txtJoinN2;
    private javax.swing.JTextField txtJoinN3;
    private javax.swing.JTextField txtKeyField;
    private javax.swing.JTextField txtLine;
    private javax.swing.JTextField txtObjType;
    private javax.swing.JTextField txtOrder;
    private javax.swing.JTextField txtProj;
    private javax.swing.JLabel txtQueryTable;
    private javax.swing.JTextField txtSearchSpec;
    private javax.swing.JTextField txtTable;
    private javax.swing.JTextField txtTableN0;
    private javax.swing.JTextField txtTableN1;
    private javax.swing.JTextField txtTableN2;
    private javax.swing.JTextField txtTableN3;
    // End of variables declaration//GEN-END:variables
}
