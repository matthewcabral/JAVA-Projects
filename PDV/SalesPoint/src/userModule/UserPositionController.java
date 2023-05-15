/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userModule;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Matheus Cabral Rosa
 */
public class UserPositionController extends UserController {
    UserPostnMgrScreen posScreen;
    
    // Position Class & ArrayList
    postnRowIdClass postnRowId;
    private ArrayList<postnRowIdClass> postnRowIdArray = new ArrayList<>();
    // Permition Class & ArrayList
    permRowIdClass permRowId;
    private ArrayList<permRowIdClass> permRowIdArray = new ArrayList<>();
    
    // Variables    
    private int count;
    // Position Variables
    private String lastPostnAdd;
    private String lastPostnUpd;
    private final int postnNameSize = 50;
    private final int postnTypeSize = 30;
    private final int postnDescSize = 255;
    // Permition Variables
    private String lastPermAdd;
    private String lastPermUpd;
    private String permName;
    private String permValue;
    private String permFlg;
    private String permDesc;
    private final int permNameSize = 50;
    private final int permValueSize = 50;
    private final int permDescSize = 250;
    private String activeView = "LIST_VIEW";
    
    public UserPositionController() throws InterruptedException {
        this.lastPostnAdd = null;
        this.lastPostnUpd = null;
        this.lastPermAdd = null;
        this.lastPermUpd = null;
        this.permName = null;
        this.permValue = null;
        this.permFlg = null;
        this.permDesc = null;
    }
    
    public int getCount() { return count; }
    public void setCount(int count) { this.count += count; }
    public void clearCount() { this.count = 0; }
    
    public String getLastPostnAdd() { return lastPostnAdd; }
    public void setLastPostnAdd(String lastPostnAdd) { this.lastPostnAdd = lastPostnAdd; }

    public String getLastPostnUpd() { return lastPostnUpd; }
    public void setLastPostnUpd(String lastPostnUpd) { this.lastPostnUpd = lastPostnUpd; }
    
    public String getLastPermAdd() { return lastPermAdd; }
    public void setLastPermAdd(String lastPermAdd) { this.lastPermAdd = lastPermAdd; }

    public String getLastPermUpd() { return lastPermUpd; }
    public void setLastPermUpd(String lastPermUpd) { this.lastPermUpd = lastPermUpd; }
    
    public String getPermName() { return permName; }
    public void setPermName(String permName) { this.permName = permName; }
    
    public String getPermValue() { return permValue; }
    public void setPermValue(String permValue) { this.permValue = permValue; }
    
    public String getPermFlg() { return permFlg; }
    public void setPermFlg(String permFlg) { this.permFlg = permFlg; }
    
    public String getPermDesc() { return permDesc; }
    public void setPermDesc(String permDesc) { this.permDesc = permDesc; }
    
    public int getPostnNameSize() { return postnNameSize; }
    public int getPostnTypeSize() { return postnTypeSize; }
    public int getPostnDescSize() { return postnDescSize; }
    public int getPermNameSize() { return permNameSize; }
    public int getPermValueSize() { return permValueSize; }
    public int getPermDescSize() { return permDescSize; }

    public String getActiveView() { return activeView; }
    public void setActiveView(String activeView) { this.activeView = activeView; }
    
    public void openUserPositionScreen(){
        posScreen = new UserPostnMgrScreen();
        // List: Position - Permition
        posScreen.setListenerTblListSelectionPosition(new positionListViewSelected());
        posScreen.setListenerTblListSelectionPermission(new permissionListViewSelected());
        //posScreen.setListenercbbListFilterValue();
        //posScreen.setListenertxtListFilterValue();
        // Position
        posScreen.setListenerBtnEditPosition(new buttonEditPosition());
        posScreen.setListenerBtnNewPosition(new buttonNewPosition());
        posScreen.setListenerBtnSavePosition(new buttonSavePosition());
        posScreen.setListenerBtnCancelPosition(new buttonCancelPosition());
        posScreen.setListenerBtnDeletePosition(new buttonDeletePosition());
        //posScreen.setListenerBtnQueryPosition();
        //posScreen.setListenerBtnGoQueryPosition();
        posScreen.setKeyListenerBtnEditPosition(new btnEditPositionKeyListener());
        posScreen.setKeyListenerBtnNewPosition(new btnNewPositionKeyListener());
        posScreen.setKeyListenerBtnSavePosition(new btnSavePositionKeyListener());
        posScreen.setKeyListenerBtnCancelPosition(new btnCancelPositionKeyListener());
        posScreen.setKeyListenerBtnDeletePosition(new btnDeletePositionKeyListener());
        posScreen.setKeyListenerBtnQueryPosition(new btnQueryPositionKeyListener());
        posScreen.setKeyListenerBtnGoQueryPosition(new btnGoQueryPositionKeyListener());
        posScreen.setKeyListenerTxtPositionName(new txtPositionNameKeyListener());
        posScreen.setKeyListenerTxtPositionType(new txtPositionTypeKeyListener());
        posScreen.setKeyListenerTxtPositionDesc(new txtPositionDescKeyListener());
        posScreen.setListenerTblPositionListSelection(new positionListSelected());
        posScreen.setListenerPanelList(new PanelListFocusGained());
        posScreen.setListenerPanelPosition(new PanelPositionFocusGained());
        posScreen.setListenerPanelPermission(new PanelPermitionFocusGained());
        // Permition
        posScreen.setListenerBtnEditPermission(new buttonEditPermission());
        posScreen.setListenerBtnNewPermission(new buttonNewPermission());
        posScreen.setListenerBtnSavePermission(new buttonSavePermission());
        posScreen.setListenerBtnCancelPermission(new buttonCancelPermission());
        posScreen.setListenerBtnDeletePermission(new buttonDeletePermission());
        //posScreen.setListenerBtnQueryPermission();
        //posScreen.setListenerBtnGoQueryPermission();
        posScreen.setKeyListenerBtnEditPermission(new btnEditPermissionKeyListener());
        posScreen.setKeyListenerBtnNewPermission(new btnNewPermissionKeyListener());
        posScreen.setKeyListenerBtnSavePermission(new btnSavePermissionKeyListener());
        posScreen.setKeyListenerBtnCancelPermission(new btnCancelPermissionKeyListener());
        posScreen.setKeyListenerBtnDeletePermission(new btnDeletePermissionKeyListener());
        posScreen.setKeyListenerBtnQueryPermission(new btnQueryPermissionKeyListener());
        posScreen.setKeyListenerBtnGoQueryPermission(new btnGoQueryPermissionKeyListener());
        posScreen.setKeyListenerTxtPermissionName(new txtPermissionNameKeyListener());
        posScreen.setKeyListenerCkbPermissionFlg(new ckbPermissionFlgKeyListener());
        posScreen.setKeyListenerTxtPermissionValue(new txtPermissionValueKeyListener());
        posScreen.setKeyListenerTxtPermissionDesc(new txtPermissionDescKeyListener());
        posScreen.setListenercbbListPermission(new cbbListPositionItemState());
        posScreen.setListenerTblPermissionListSelection(new permissionListSelected());
        
        this.setActiveView("LIST_VIEW");
        posScreen.unselectRowListPosition();
        posScreen.unselectRowListPermission();
        posScreen.unselectRowPositionList();
        posScreen.unselectRowPermissionList();
        posScreen.clearFields("LIST");
        posScreen.clearComboBoxes("LIST");
        posScreen.enableFields("LOAD_SCREEN");
        posScreen.insertSelectComboBox();
        this.fillComboBoxes("POSITION_FILTER");
        fillPositionList("SELECT *\nFROM " + getDbOwner() + "." + getTblPosition() + " POS\nORDER BY POS.NAME ASC", "LOAD_RECORD", "LIST_VIEW");
        posScreen.setSelectedRowColumnListPosition(0, 0);
        posScreen.setFocus("FILTRO_VALOR");
    }
    
    private void fillComboBoxes(String LovType){
        try{
            ArrayList<ListOfValuesClass> lov = super.LookupList(LovType);
            
            if(lov.size() > 0){
                for(int i = 0; i < lov.size(); i++){
                    if(null == LovType){
                        JOptionPane.showMessageDialog(null, "O LOV_TYPE 'null' não existe!");
                    } else switch (LovType) {
                        case "POSITION_FILTER": posScreen.setcbbListFilter(lov.get(i).getValue()); break;
                        case "POSITION_TYPE": posScreen.setcbbListPosition(lov.get(i).getValue()); break;
                        //case "POSTN_PER": posScreen.settxtPermitionName(lov.get(i).getName()); break;
                        default: JOptionPane.showMessageDialog(null, "O LOV_TYPE '" + LovType +  "' não é utilizado por nenhum ComboBox!"); break;
                    }
                }
            }
        } catch(HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher ComboBoxes...\nErro: " + e);
        }
    }
    
    private void fillPositionList(String query, String method, String view) {
        DefaultTableModel table;
        
        switch(view){
            case "LIST_VIEW": table = (DefaultTableModel) posScreen.getTableModelPosition(); break;
            case "POSITION_VIEW": table = (DefaultTableModel) posScreen.getPositionTableModel(); break;
            default: table = (DefaultTableModel) posScreen.getTableModelPosition(); break;
        }
        
        switch(method){
            case "INSERT_RECORD":
                int newRow = table.getRowCount() + 1;
                //table.setRowCount(newRow);
                try{
                    table.addRow(
                        new Object[] {
                            posScreen.gettxtPositionName(),
                            posScreen.gettxtPositionType(),
                            posScreen.gettxtPositionDesc()
                        }
                    );
                } catch(Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro ao preencher tabela...\nErro: " + e);
                }
                break;
            case "UPDATE_RECORD":
                try{
                    table.setValueAt(posScreen.gettxtPositionName(), posScreen.getSelectedRowPositionList(), 0);
                    table.setValueAt(posScreen.gettxtPositionType(), posScreen.getSelectedRowPositionList(), 1);
                    table.setValueAt(posScreen.gettxtPositionDesc(), posScreen.getSelectedRowPositionList(), 2);
                } catch(Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro ao preencher tabela...\nErro: " + e);
                }
                break;
            default:
                try{
                    ArrayList<PositionClass> positionList = queryPositionRecord(query);
                    try{ postnRowIdArray.clear(); } catch (Exception e) {}
                    
                    switch(view){
                        case "LIST_VIEW": try{ posScreen.setListRowCountPosition(0); } catch (Exception e) {}; break;
                        case "POSITION_VIEW": try{ posScreen.setPositionListRowCount(0); } catch (Exception e) {}; break;
                        default: try{ posScreen.setListRowCountPosition(0); } catch (Exception e) {}; break;
                    }
                    
                    if(positionList.size() > 0){
                        try{ table.setRowCount(positionList.size()); } catch (Exception e) {}
                        try{ table.setNumRows(positionList.size()); } catch (Exception e) {}

                        for(int i = 0; i < positionList.size(); i++){
                            postnRowId = new postnRowIdClass();
                            postnRowId.setRowId(positionList.get(i).getRow_id());
                            postnRowIdArray.add(postnRowId);
                            table.setValueAt(positionList.get(i).getNAME(), i, 0);
                            table.setValueAt(positionList.get(i).getPOSTN_TYPE_CD(), i, 1);
                            table.setValueAt(positionList.get(i).getDESC_TEXT(), i, 2);
                        }
                    }
                } catch(Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro ao preencher tabela...\nErro: " + e);
                }
                break;
        }
        
        switch(view){
            case "LIST_VIEW":  posScreen.setlblRecCountPos("0 - " + String.valueOf(postnRowIdArray.size())); break;
            case "POSITION_VIEW": posScreen.setlblRecCountPosList("0 - " + String.valueOf(postnRowIdArray.size())); break;
            default: break;
        }
    }
    
    private void fillPermissionList(String query, String method, String view) {
        DefaultTableModel table;
        
        switch(view){
            case "LIST_VIEW": table = (DefaultTableModel) posScreen.getTableModelPermission(); break;
            case "PERMISSION_VIEW": table = (DefaultTableModel) posScreen.getPermissionTableModel(); break;
            default: table = (DefaultTableModel) posScreen.getTableModelPermission(); break;
        }
        
        switch(method){
            case "INSERT_RECORD":
                int newRow = table.getRowCount() + 1;
                try{
                    table.addRow(
                        new Object[] {
                            posScreen.gettxtPermissionName(),
                            posScreen.gettxtPermissionValue(),
                            ("Y".equals(posScreen.getckbPermissionFlg())),
                            posScreen.gettxtPermissionDesc()
                        }
                    );
                } catch(Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro ao preencher tabela...\nErro: " + e);
                }
                break;
            case "UPDATE_RECORD":
                try{
                    table.setValueAt(posScreen.gettxtPermissionName(), posScreen.getSelectedRowPermissionList(), 0);
                    table.setValueAt(posScreen.gettxtPermissionValue(), posScreen.getSelectedRowPermissionList(), 1);
                    table.setValueAt(("Y".equals(posScreen.getckbPermissionFlg())), posScreen.getSelectedRowPermissionList(), 2);
                    table.setValueAt(posScreen.gettxtPermissionDesc(), posScreen.getSelectedRowPermissionList(), 3);
                } catch(Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro ao preencher tabela...\nErro: " + e);
                }
                break;
            default:
                try{
                    ArrayList<PositionPerClass> permitionList = queryPostnPermissionRecord(query);
                    try{ permRowIdArray.clear(); } catch (Exception e) {}
                    switch(view){
                        case "LIST_VIEW": try{ posScreen.setListRowCountPermission(0); } catch (Exception e) {}; break;
                        case "PERMISSION_VIEW": try{ posScreen.setPermissionListRowCount(0); } catch (Exception e) {};  break;
                        default: try{ posScreen.setListRowCountPermission(0); } catch (Exception e) {}; break;
                    }
                    
                    if(permitionList.size() > 0){
                        try{ table.setRowCount(permitionList.size()); } catch (Exception e) {}
                        try{ table.setNumRows(permitionList.size()); } catch (Exception e) {}
                        
                        for(int i = 0; i < permitionList.size(); i++){
                            permRowId = new permRowIdClass();
                            permRowId.setRowId(permitionList.get(i).getRow_id());
                            permRowIdArray.add(permRowId);
                            table.setValueAt(permitionList.get(i).getPERMITION_NAME(), i, 0);
                            table.setValueAt(permitionList.get(i).getPERMITION_VALUE(), i, 1);
                            table.setValueAt(("Y".equals(permitionList.get(i).getPERMITION_FLG())), i, 2);
                            table.setValueAt(permitionList.get(i).getPERMITION_DESC(), i, 3);
                        }
                    }
                } catch(Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro ao preencher tabela...\nErro: " + e);
                }
                break;
        }
        switch(view){
            case "LIST_VIEW": posScreen.setlblRecCountPerm("0 - " + String.valueOf(permRowIdArray.size())); break;
            case "PERMISSION_VIEW": posScreen.setlblRecCountPermList("0 - " + String.valueOf(permRowIdArray.size())); break;
            default: break;
        }
    }
    
    private void fillFieldsPositionScreen(String query){
        try{
            ArrayList<PositionClass> postnList = queryPositionRecord(query);
            
            if(postnList.size() > 0) {
                posScreen.setlblFormPositionNameHeader(postnList.get(0).getNAME());
                posScreen.settxtPositionRowId(postnList.get(0).getRow_id());
                posScreen.settxtPositionName(postnList.get(0).getNAME());
                posScreen.settxtPositionType(postnList.get(0).getPOSTN_TYPE_CD());
                posScreen.settxtPositionDesc(postnList.get(0).getDESC_TEXT());
            }

        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher Campos...\nErro: " + e);
        }
    }
    
    private void fillFieldsPermissionScreen(String query){
        try{
            ArrayList<PositionPerClass> permList = queryPostnPermissionRecord(query);
            
            if(permList.size() > 0) {
                posScreen.setlblFormPermitionNameHeader(permList.get(0).getPERMITION_VALUE());
                posScreen.settxtPermissionRowId(permList.get(0).getRow_id());
                posScreen.settxtPermitionName(permList.get(0).getPERMITION_NAME());
                posScreen.settxtPermitionValue(permList.get(0).getPERMITION_VALUE());
                posScreen.setckbPermitionFlg(permList.get(0).getPERMITION_FLG());
                posScreen.settxtPermitionDesc(permList.get(0).getPERMITION_DESC());
            }

        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher Campos...\nErro: " + e);
        }
    }
    
    private boolean validateMandatoryPositionFields(){
        String mensagem = "";
        int i = 0;
        
        if(posScreen.gettxtPositionName() == null) { mensagem += "\n- " + "Nome" + ";"; i = (i < 1) ? 1 : i; }
        if(posScreen.gettxtPositionType() == null) { mensagem += "\n- " + "Tipo" + ";"; i = (i < 2 && i != 0) ? i : 2; }
        
        switch(i){
            case 1: posScreen.setFocus("NAME_POSITION"); break;
            case 2: posScreen.setFocus("TYPE_POSITION"); break;
            default: break;
        }
        
        if(!"".equals(mensagem) && mensagem != null){
            JOptionPane.showMessageDialog(null, "Os campos abaixo são obrigatórios. Favor preencher os mesmos:" + mensagem);
            return false;
        } else {
            return true;
        }
    }
    
    private boolean validateFieldValuesPosition(){
        int countUniqueValue = 0;
        
        // Validate Field Sizes
        if((posScreen.gettxtPositionName() != null) && (posScreen.gettxtPositionName().length() > getPostnNameSize())) { JOptionPane.showMessageDialog(null, "O tamanho do campo 'Nome' deve ter no máximo: " + getPostnNameSize() + " caractere(s)"); return false; }
        if((posScreen.gettxtPositionType() != null) && (posScreen.gettxtPositionType().length() > getPostnTypeSize())) { JOptionPane.showMessageDialog(null, "O tamanho do campo 'Tipo' deve ter no máximo: " + getPostnTypeSize() + " caractere(s)"); return false; }
        if((posScreen.gettxtPositionDesc() != null) && (posScreen.gettxtPositionDesc().length() > getPostnDescSize())) { JOptionPane.showMessageDialog(null, "O tamanho do campo 'Descrição' deve ter no máximo: " + getPostnDescSize() + " caractere(s)"); return false; }
        
        // Validate if values exists
        super.clearCondition();
        super.setCondition("NAME = '" + posScreen.gettxtPositionName() + "'");
        super.setCondition("\nAND " + "POSTN_TYPE_CD = '" + posScreen.gettxtPositionType() + "'");
        super.setCondition("\nAND " + "ROW_ID <> '" + posScreen.gettxtPositionRowId() + "'");
        
        countUniqueValue = super.queryTableCount(super.getTblPosition(), super.getCondition());
        
        if(countUniqueValue > 0) {
            JOptionPane.showMessageDialog(null, "Um registro que contém valores idênticos ao que você criou já existe.\n\nSe você deseja criar um novo registro, certifique-se que os campos tenham valores únicos.");
            return false;
        }
        
        return true;
    }
    
    private boolean validateMandatoryPermissionFields(){
        String mensagem = "";
        int i = 0;
        
        if(posScreen.gettxtPermissionName() == null) { mensagem += "\n- " + "Nome" + ";"; i = (i < 1) ? 1 : i; }
        if(posScreen.gettxtPermissionValue() == null) { mensagem += "\n- " + "Valor" + ";"; i = (i < 2 && i != 0) ? i : 2; }
        
        switch(i){
            case 1: posScreen.setFocus("NAME_PERMITION"); break;
            case 2: posScreen.setFocus("VALUE_PERMITION"); break;
            default: break;
        }
        
        if(!"".equals(mensagem) && mensagem != null){
            JOptionPane.showMessageDialog(null, "Os campos abaixo são obrigatórios. Favor preencher os mesmos:" + mensagem);
            return false;
        } else {
            return true;
        }
    }
    
    private boolean validateFieldValuesPermission(){
        int countUniqueValue = 0;
        
        // Validate Field Sizes
        if((posScreen.gettxtPermissionName() != null) && (posScreen.gettxtPermissionName().length() > getPermNameSize())) { JOptionPane.showMessageDialog(null, "O tamanho do campo 'Nome' deve ter no máximo: " + getPermNameSize() + " caractere(s)"); return false; }
        if((posScreen.gettxtPermissionValue() != null) && (posScreen.gettxtPermissionValue().length() > getPermValueSize())) { JOptionPane.showMessageDialog(null, "O tamanho do campo 'Valor' deve ter no máximo: " + getPermValueSize() + " caractere(s)"); return false; }
        if((posScreen.gettxtPermissionDesc() != null) && (posScreen.gettxtPermissionDesc().length() > getPermDescSize())) { JOptionPane.showMessageDialog(null, "O tamanho do campo 'Descrição' deve ter no máximo: " + getPermDescSize() + " caractere(s)"); return false; }
        
        // Validate if values exists
        super.clearCondition();
        super.setCondition("PERMITION_NAME = '" + posScreen.gettxtPermissionName() + "'");
        super.setCondition("\nAND " + "PERMITION_VALUE = '" + posScreen.gettxtPermissionValue() + "'");
        super.setCondition("\nAND " + "ROW_ID <> '" + posScreen.gettxtPermissionRowId() + "'");
        super.setCondition("\nAND " + "PAR_ROW_ID = '" + super.getPositionIdByName(posScreen.getcbbListPositionName()) + "'");
        
        countUniqueValue = super.queryTableCount(super.getTblPositionPermition(), super.getCondition());
        
        if(countUniqueValue > 0) {
            JOptionPane.showMessageDialog(null, "Um registro que contém valores idênticos ao que você criou já existe.\n\nSe você deseja criar um novo registro, certifique-se que os campos tenham valores únicos.");
            return false;
        }
        
        return true;
    }
    
    private boolean insertPosition(){
        String postnId = super.getNextRowId();
        super.clearColumns();
        super.clearValues();
        super.setColumns(",\n\t" + "PAR_POSTN_ID"); super.setValues(",\n\t" + "NULL");
        super.setColumns(",\n\t" + "NAME"); super.setValues(",\n\t" + ((posScreen.gettxtPositionName() != null) ? "'" + posScreen.gettxtPositionName() + "'" : "NULL"));
        super.setColumns(",\n\t" + "POSTN_TYPE_CD"); super.setValues(",\n\t" + ((posScreen.gettxtPositionType() != null) ? "'" + posScreen.gettxtPositionType() + "'" : "NULL"));
        super.setColumns(",\n\t" + "DESC_TEXT"); super.setValues(",\n\t" + ((posScreen.gettxtPositionDesc() != null) ? "'" + posScreen.gettxtPositionDesc() + "'" : "NULL"));
        
        try {
            if("true".equals(super.insertRecord(super.getTblPosition(), super.getColumns(), super.getValues()))){
                postnRowId = new postnRowIdClass();
                postnRowId.setRowId(postnId);
                postnRowIdArray.add(postnRowId);
                this.setLastPostnAdd(postnId);
                this.fillPositionList(null, "INSERT_RECORD", "POSITION_VIEW");
                
                // Automatic insert new Position on List Of Values. Type = 'POSITION_TYPE'
                this.clearColumns();
                this.clearValues();
                super.setColumns(",\n\t" + "PAR_ROW_ID"); super.setValues(",\n\t" + "NULL");        
                super.setColumns(",\n\t" + "TYPE"); super.setValues(",\n\t" + "'POSITION_TYPE'");
                super.setColumns(",\n\t" + "NAME"); super.setValues(",\n\t" + ((posScreen.gettxtPositionType() != null) ? "'" + posScreen.gettxtPositionType() + "'" : "NULL"));
                super.setColumns(",\n\t" + "VAL"); super.setValues(",\n\t" + ((posScreen.gettxtPositionName() != null) ? "'" + posScreen.gettxtPositionName() + "'" : "NULL"));
                super.setColumns(",\n\t" + "LANG_ID"); super.setValues(",\n\t" + "'PTB'");
                super.setColumns(",\n\t" + "RPLCTN_LVL_CD"); super.setValues(",\n\t" + "'All'");
                super.setColumns(",\n\t" + "ACTIVE_FLG"); super.setValues(",\n\t" + "'Y'");
                super.setColumns(",\n\t" + "ORDER_BY"); super.setValues(",\n\t" + "(SELECT (MAX(ORDER_BY) + 1) FROM " + super.getDbOwner() + "." + super.getTblLstOfVal() + " WHERE TYPE = 'POSITION_TYPE')");
                super.setColumns(",\n\t" + "CODE"); super.setValues(",\n\t" + "NULL");
                super.setColumns(",\n\t" + "SUB_TYPE"); super.setValues(",\n\t" + "NULL");
                super.setColumns(",\n\t" + "DESC_TEXT"); super.setValues(",\n\t" + ((posScreen.gettxtPositionDesc() != null) ? "'" + posScreen.gettxtPositionDesc() + "'" : "NULL"));

                super.setSilentInsertMode(true);
                if("true".equals(super.insertRecord(super.getTblLstOfVal(), super.getColumns(), super.getValues()))){
                    this.clearColumns();
                    this.clearValues();
                } else {
                    postnId = null;
                    this.clearColumns();
                    this.clearValues();
                }
                // Automatic set Permitions to new Position
                ArrayList<ListOfValuesClass> lovList = super.queryListOfValues("SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblLstOfVal() + " LOV\nWHERE LOV.TYPE = 'POSTN_PER'");
                if(lovList.size() > 0){
                    InsertMultipleLineClass insert;
                    ArrayList<InsertMultipleLineClass> insertArray = new ArrayList<>();
                    for(int i = 0; i < lovList.size(); i++){
                        String sqlColumn = ", PAR_ROW_ID, PERMITION_NAME, PERMITION_VALUE, PERMITION_FLG, PERMITION_DESC";
                        String sqlValue = "";
                        sqlValue += ", " + "'" + postnId + "'";
                        sqlValue += ", " + "'" + lovList.get(i).getName() + "'";
                        sqlValue += ", " + "'" + lovList.get(i).getValue() + "'";
                        sqlValue += ", " + "'N'";
                        sqlValue += ", " + ((!"".equals(lovList.get(i).getDesc_text()) && lovList.get(i).getDesc_text() != null) ? "'" + lovList.get(i).getDesc_text() + "'" : "NULL");
                        insert = new InsertMultipleLineClass();
                        insert.setSqlColumns(sqlColumn);
                        insert.setSqlValues(sqlValue);
                        insertArray.add(insert);
                    }
                    super.insertMultipleRecords(super.getTblPositionPermition(), insertArray);
                }
                super.setSilentInsertMode(false);
                return true;
            } else {
                postnId = null;
                this.clearColumns();
                this.clearValues();
                return false;
            }
            
        } catch (Exception e) {
            postnId = null;
            this.clearColumns();
            this.clearValues();
            return false;
        }
    }
    
    private boolean updatePosition(){
        boolean retorno = false;
        String oldPositonName = posScreen.getPositionListValue(0);
        String oldPositionType = posScreen.getPositionListValue(1);
        super.clearColumnsValues();
        super.clearCondition();
        
        super.setColumnsValues(",\n\t" + "MODIFICATION_NUM = (SELECT MODIFICATION_NUM + 1 FROM " + super.getDbOwner() + "." + super.getTblPosition()+ " WHERE ROW_ID = '" + postnRowIdArray.get(posScreen.getSelectedRowPositionList()).getRowId()+ "')");
        super.setColumnsValues(",\n\t" + "PAR_POSTN_ID = NULL");
        super.setColumnsValues(",\n\t" + "NAME = " + ((posScreen.gettxtPositionName() != null) ? "'" + posScreen.gettxtPositionName() + "'" : "NULL"));
        super.setColumnsValues(",\n\t" + "POSTN_TYPE_CD = " + ((posScreen.gettxtPositionType() != null) ? "'" + posScreen.gettxtPositionType() + "'" : "NULL"));
        super.setColumnsValues(",\n\t" + "DESC_TEXT = " + ((posScreen.gettxtPositionDesc() != null) ? "'" + posScreen.gettxtPositionDesc() + "'" : "NULL"));
        super.setCondition("ROW_ID = '" + postnRowIdArray.get(posScreen.getSelectedRowPositionList()).getRowId() + "'");
        try{
            this.clearCount();
            this.setCount(super.updateRecord(super.getTblPosition(), super.getColumnsValues(), super.getCondition()));
            if(this.getCount() > 0){
                this.setLastPostnUpd(postnRowIdArray.get(posScreen.getSelectedRowPositionList()).getRowId());   
                this.fillPositionList("", "UPDATE_RECORD", "POSITION_VIEW");
                super.clearColumnsValues();
                super.clearCondition();
                
                // Automatic update Position on List Of Values. Type = 'POSITION_TYPE'
                ArrayList<ListOfValuesClass> lovList = super.queryListOfValues("SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblLstOfVal() + " LOV\nWHERE LOV.TYPE = 'POSITION_TYPE'\nAND LOV.NAME = '" + oldPositionType + "'\nAND LOV.VAL = '" + oldPositonName + "'");
                
                if(lovList.size() > 0) {
                    super.setColumnsValues(",\n\t" + "MODIFICATION_NUM = (SELECT MODIFICATION_NUM + 1 FROM " + super.getDbOwner() + "." + super.getTblLstOfVal() + " WHERE ROW_ID = '" + lovList.get(0).getRow_id() + "')");
                    super.setColumnsValues(",\n\t" + "NAME = " + ((posScreen.gettxtPositionType() != null) ? "'" + posScreen.gettxtPositionType() + "'" : "NULL"));
                    super.setColumnsValues(",\n\t" + "VAL = " + ((posScreen.gettxtPositionName() != null) ? "'" + posScreen.gettxtPositionName() + "'" : "NULL"));
                    super.setColumnsValues(",\n\t" + "DESC_TEXT = " + ((posScreen.gettxtPositionDesc() != null) ? "'" + posScreen.gettxtPositionDesc() + "'" : "NULL"));
                    super.setCondition("ROW_ID = '" + lovList.get(0).getRow_id() + "'");
                    
                    try{
                        this.clearCount();
                        this.setCount(super.updateRecord(super.getTblLstOfVal(), super.getColumnsValues(), super.getCondition()));
                        if(this.getCount() > 0){
                            super.clearColumnsValues();
                            super.clearCondition();
                        } else {
                            super.clearColumnsValues();
                            super.clearCondition();
                        }
                    } catch (Exception e) {
                        super.clearColumnsValues();
                        super.clearCondition();
                    }
                }
                
                retorno = true;
            } else {
                super.clearColumnsValues();
                super.clearCondition();
                retorno = false;
            }
        } catch (Exception e) {
            super.clearColumnsValues();
            super.clearCondition();
            retorno = false;
        }
        
        return retorno;
    }
    
    public boolean deletePosition(){
        int countPostn = 0;
        int countLOV = 0;
        int countPerm = 0;
        
        if(super.wishDeleteRecord()){
            String oldPositionId = postnRowIdArray.get(posScreen.getSelectedRowPositionList()).getRowId();
            String oldPositonName = posScreen.getPositionListValue(0);
            String oldPositionType = posScreen.getPositionListValue(1);
            
            super.clearCondition();
            super.setCondition("ROW_ID = '" + postnRowIdArray.get(posScreen.getSelectedRowPositionList()).getRowId() + "'");
            try{
                countPostn = super.deleteRecord(super.getTblPosition(), super.getCondition());
                if(countPostn > 0){
                    postnRowIdArray.remove(posScreen.getSelectedRowPositionList());
                    posScreen.removeRowFromPositionList(posScreen.getSelectedRowPositionList());
                    super.clearCondition();
                    
                    // Automatic remove Position on List Of Values Table. Type = POSITION_TYPE
                    ArrayList<ListOfValuesClass> lovList = queryListOfValues("SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblLstOfVal() + " LOV\nWHERE LOV.TYPE = 'POSITION_TYPE'\nAND LOV.NAME = '" + oldPositionType + "'\nAND LOV.VAL = '" + oldPositonName + "'");
                    
                    if(lovList.size() > 0) {
                        super.setCondition("ROW_ID = '" + lovList.get(0).getRow_id() + "'");                        
                        try{
                            countLOV = super.deleteRecord(super.getTblLstOfVal(), super.getCondition());
                        } catch (HeadlessException e) {
                            JOptionPane.showMessageDialog(null, "Erro ao remover registros na tabela de Lista de Valores referente a Posição '" + oldPositonName + "'.\nErro: " + e.toString());
                        }                        
                    }                    
                    super.clearCondition();
                    
                    // Automatic remove Position Permitions
                    super.setCondition("PAR_ROW_ID = '" + oldPositionId + "'");           
                    try{
                        countPerm = super.deleteRecord(super.getTblPositionPermition(), super.getCondition());
                    } catch (HeadlessException e) {
                        JOptionPane.showMessageDialog(null, "Erro ao remover registros na tabela de Permissões referente a Posição '" + oldPositonName + "'.\nErro: " + e.toString());
                    } 
                    
                    JOptionPane.showMessageDialog(null, "Registro(s) removido(s) com sucesso! Total de registros removidos:\nPosição: " + countPostn + " registro(s)\nLista de Valores: " + countLOV + " registro(s)\nPermissões da Posição: " + countPerm + " registro(s)");
                    super.clearCondition();
                    posScreen.setSelectedRowColumnListPosition(0, 0);
                    posScreen.setlblRecCountPosList((posScreen.getSelectedRowPositionList() + 1) + " - " + String.valueOf(postnRowIdArray.size()));
                    return true;
                } else {
                    super.clearCondition();
                    return false;
                }
            } catch (HeadlessException e) {
                super.clearCondition();
                return false;
            }
        } else {
            return false;
        }
    }
    
    private void savePosition() {
        if(validateMandatoryPositionFields() && validateFieldValuesPosition()){
            try{
                ArrayList<PositionClass> postnList = queryPositionRecord("SELECT *\nFROM " + getDbOwner() + "." + getTblPosition() + "\nWHERE ROW_ID = '" + posScreen.gettxtPositionRowId() + "'");

                if(postnList.size() > 0) {
                    if(updatePosition()){
                        posScreen.enableFields("SALVAR_POSITION");
                    }
                } else {
                    if(insertPosition()){
                        posScreen.enableFields("SALVAR_POSITION");

                        boolean foundRow = true;
                        int i = 0;
                        int o = posScreen.getNumOfPositionListRows();
                        do {
                            if(i < o){
                                try{                                    
                                    if(getLastPostnAdd().equals(postnRowIdArray.get(i).getRowId())){
                                        posScreen.setSelectedRowColumnPositionList(i, 0);
                                        foundRow = false;
                                    }
                                } catch(Exception e){
                                    foundRow = false;
                                }
                            } else {
                                foundRow = false;
                            }
                            i++;
                        } while(foundRow);
                    }
                }
                posScreen.setlblRecCountPosList((posScreen.getSelectedRowPositionList() + 1) + " - " + String.valueOf(postnRowIdArray.size()));
                //posScreen.enableFields("SALVAR_POSITION");
            } catch(Exception e) {
                System.out.println(getDateTime() + "\tContactModule.ContactController\t\tSaveSocialMedia\tInsertUpdateSocialMedia\tError Exception\tError: " + e);
            }
        }
    }
    
    private boolean insertPermission(){
        String positionSelected = posScreen.getcbbListPositionName();
        String permId = null;
        String permName = posScreen.gettxtPermissionName();
        String permValue = posScreen.gettxtPermissionValue();
        String permFlg = posScreen.getckbPermissionFlg();
        String permDesc = posScreen.gettxtPermissionDesc();
        super.clearColumns();
        super.clearValues();
        
        ArrayList<PositionClass> postnList = queryPositionRecord("SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblPosition() + " POS\nORDER BY POS.NAME ASC");
        
        if(postnList.size() > 0){
            InsertMultipleLineClass insert;
            ArrayList<InsertMultipleLineClass> insertArray = new ArrayList<>();
            for(int i = 0; i < postnList.size(); i++){
                String sqlColumn = ", PAR_ROW_ID, PERMITION_NAME, PERMITION_VALUE, PERMITION_FLG, PERMITION_DESC";
                String sqlValue = "";
                sqlValue += ", " + "'" + postnList.get(i).getRow_id() + "'";         
                sqlValue += ", " + "'" + permName + "'";
                sqlValue += ", " + "'" + permValue + "'";
                if(positionSelected.equals(postnList.get(i).getNAME())){
                    sqlValue += ", " + "'" + permFlg + "'";
                } else {
                    sqlValue += ", " + "'N'";
                }
                sqlValue += ", " + ((permDesc != null) ? "'" + permDesc + "'" : "NULL");
                insert = new InsertMultipleLineClass();
                insert.setSqlColumns(sqlColumn);
                insert.setSqlValues(sqlValue);
                insertArray.add(insert);
            }
            try {
                if("true".equals(super.insertMultipleRecords(super.getTblPositionPermition(), insertArray))) {
                    ArrayList<PositionPerClass> permList = queryPostnPermissionRecord("SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblPositionPermition() + " PER\nWHERE PER.PAR_ROW_ID = '" + super.getPositionIdByName(positionSelected) + "'\nAND PER.PERMITION_NAME = '" + permName + "'\nAND PER.PERMITION_VALUE = '" + permValue + "'");
                    
                    permRowId = new permRowIdClass();
                    if(permList.size() > 0){
                        permId = permList.get(0).getRow_id();
                    }
                    permRowId.setRowId(permId);
                    permRowIdArray.add(permRowId);
                    this.setLastPermAdd(permId);
                    this.fillPermissionList(null, "INSERT_RECORD", "PERMISSION_VIEW");
                    
                    // Automatic insert new Position on List Of Values. Type = 'POSITION_TYPE'
                    this.clearColumns();
                    this.clearValues();
                    super.setColumns(",\n\t" + "PAR_ROW_ID"); super.setValues(",\n\t" + "NULL");
                    super.setColumns(",\n\t" + "TYPE"); super.setValues(",\n\t" + "'POSTN_PER'");
                    super.setColumns(",\n\t" + "NAME"); super.setValues(",\n\t" + "'" + permName + "'");
                    super.setColumns(",\n\t" + "VAL"); super.setValues(",\n\t" + "'" + permValue + "'");
                    super.setColumns(",\n\t" + "LANG_ID"); super.setValues(",\n\t" + "'PTB'");
                    super.setColumns(",\n\t" + "RPLCTN_LVL_CD"); super.setValues(",\n\t" + "'All'");
                    super.setColumns(",\n\t" + "ACTIVE_FLG"); super.setValues(",\n\t" + "'Y'");
                    super.setColumns(",\n\t" + "ORDER_BY"); super.setValues(",\n\t" + "(SELECT (MAX(ORDER_BY) + 1) FROM " + super.getDbOwner() + "." + super.getTblLstOfVal() + " WHERE TYPE = 'POSTN_PER')");
                    super.setColumns(",\n\t" + "CODE"); super.setValues(",\n\t" + "NULL");
                    super.setColumns(",\n\t" + "SUB_TYPE"); super.setValues(",\n\t" + "NULL");
                    super.setColumns(",\n\t" + "DESC_TEXT"); super.setValues(",\n\t" + "'" + permDesc + "'");

                    super.setSilentInsertMode(true);
                    try { super.insertRecord(super.getTblLstOfVal(), super.getColumns(), super.getValues()); } catch (Exception e) { }
                    this.clearColumns();
                    this.clearValues();
                    super.setSilentInsertMode(false);
                    return true;
                } else {
                    return false;
                }
            } catch (Exception e) {
                permId = null;
                this.clearColumns();
                this.clearValues();
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao inserir Registro! Não existem registros de posições, portanto não é possível inserir uma permissão.");
            return false;
        }
    }
    
    private boolean updatePermission(){
        boolean retorno = false;
        String oldPermissionName = posScreen.getPermissionListValue(0);
        String oldPermissionValue = posScreen.getPermissionListValue(1);
        String oldPermissionDesc = posScreen.getPermissionListValue(3);
        super.clearColumnsValues();
        super.clearCondition();
        
        super.setColumnsValues(",\n\t" + "MODIFICATION_NUM = (SELECT MODIFICATION_NUM + 1 FROM " + super.getDbOwner() + "." + super.getTblPositionPermition() + " WHERE ROW_ID = '" + permRowIdArray.get(posScreen.getSelectedRowPermissionList()).getRowId()+ "')");
        super.setColumnsValues(",\n\t" + "PERMITION_NAME = " + ((posScreen.gettxtPermissionName() != null) ? "'" + posScreen.gettxtPermissionName() + "'" : "NULL"));
        super.setColumnsValues(",\n\t" + "PERMITION_VALUE = " + ((posScreen.gettxtPermissionValue() != null) ? "'" + posScreen.gettxtPermissionValue() + "'" : "NULL"));
        super.setColumnsValues(",\n\t" + "PERMITION_FLG = " + "'" + posScreen.getckbPermissionFlg() + "'");
        super.setColumnsValues(",\n\t" + "PERMITION_DESC = " + ((posScreen.gettxtPermissionDesc() != null) ? "'" + posScreen.gettxtPermissionDesc() + "'" : "NULL"));
        super.setCondition("ROW_ID = '" + permRowIdArray.get(posScreen.getSelectedRowPermissionList()).getRowId() + "'");
        try{
            this.clearCount();
            this.setCount(super.updateRecord(super.getTblPositionPermition(), super.getColumnsValues(), super.getCondition()));
            if(this.getCount() > 0){
                this.setLastPermUpd(permRowIdArray.get(posScreen.getSelectedRowPermissionList()).getRowId());   
                this.fillPermissionList("", "UPDATE_RECORD", "PERMISSION_VIEW");
                super.clearColumnsValues();
                super.clearCondition();
                
                if(!oldPermissionName.equals(posScreen.gettxtPermissionName()) || !oldPermissionValue.equals(posScreen.gettxtPermissionValue()) || !oldPermissionDesc.equals(posScreen.gettxtPermissionDesc())){
                    ArrayList<PositionPerClass> permList = queryPostnPermissionRecord("SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblPositionPermition() + " PRM\nWHERE PERMITION_NAME = '" + oldPermissionName + "'\nAND PERMITION_VALUE = '" + oldPermissionValue + "'");
                    if(permList.size() > 0) {
                        for(int i = 0; i < permList.size(); i++){
                            super.setColumnsValues(",\n\t" + "MODIFICATION_NUM = (SELECT MODIFICATION_NUM + 1 FROM " + super.getDbOwner() + "." + super.getTblPositionPermition() + " WHERE ROW_ID = '" + permList.get(i).getRow_id() + "')");
                            super.setColumnsValues(",\n\t" + "PERMITION_NAME = " + ((posScreen.gettxtPermissionName() != null) ? "'" + posScreen.gettxtPermissionName() + "'" : "NULL"));
                            super.setColumnsValues(",\n\t" + "PERMITION_VALUE = " + ((posScreen.gettxtPermissionValue() != null) ? "'" + posScreen.gettxtPermissionValue() + "'" : "NULL"));
                            super.setColumnsValues(",\n\t" + "PERMITION_DESC = " + ((posScreen.gettxtPermissionDesc() != null) ? "'" + posScreen.gettxtPermissionDesc() + "'" : "NULL"));
                            super.setCondition("ROW_ID = '" + permList.get(i).getRow_id() + "'");
                            try { super.updateRecord(super.getTblPositionPermition(), super.getColumnsValues(), super.getCondition()); } catch (Exception e) {}
                            super.clearColumnsValues();
                            super.clearCondition();
                        }
                    }
                    // Automatic update Permition on List Of Values. Type = 'POSTN_PER'
                    ArrayList<ListOfValuesClass> lovList = super.queryListOfValues("SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblLstOfVal() + " LOV\nWHERE LOV.TYPE = 'POSTN_PER'\nAND LOV.NAME = '" + oldPermissionName + "'\nAND LOV.VAL = '" + oldPermissionValue + "'");

                    if(lovList.size() > 0) {
                        super.setColumnsValues(",\n\t" + "MODIFICATION_NUM = (SELECT MODIFICATION_NUM + 1 FROM " + super.getDbOwner() + "." + super.getTblLstOfVal() + " WHERE ROW_ID = '" + lovList.get(0).getRow_id() + "')");
                        super.setColumnsValues(",\n\t" + "NAME = " + ((posScreen.gettxtPermissionName() != null) ? "'" + posScreen.gettxtPermissionName() + "'" : "NULL"));
                        super.setColumnsValues(",\n\t" + "VAL = " + ((posScreen.gettxtPermissionValue() != null) ? "'" + posScreen.gettxtPermissionValue() + "'" : "NULL"));
                        super.setColumnsValues(",\n\t" + "DESC_TEXT = " + ((posScreen.gettxtPermissionDesc() != null) ? "'" + posScreen.gettxtPermissionDesc() + "'" : "NULL"));
                        super.setCondition("ROW_ID = '" + lovList.get(0).getRow_id() + "'");

                        try{
                            this.clearCount();
                            this.setCount(super.updateRecord(super.getTblLstOfVal(), super.getColumnsValues(), super.getCondition()));
                            if(this.getCount() > 0){
                                super.clearColumnsValues();
                                super.clearCondition();
                            } else {
                                super.clearColumnsValues();
                                super.clearCondition();
                            }
                        } catch (Exception e) {
                            super.clearColumnsValues();
                            super.clearCondition();
                        }
                    }
                }
                retorno = true;
            } else {
                super.clearColumnsValues();
                super.clearCondition();
                retorno = false;
            }
        } catch (Exception e) {
            super.clearColumnsValues();
            super.clearCondition();
            retorno = false;
        }
        
        return retorno;
    }
    
    public boolean deletePermission(){
        int countPerm = 0;
        int countLOV = 0;
        
        if(super.wishDeleteRecord()){
            String oldPermissionName = posScreen.getPermissionListValue(0);
            String oldPermissionValue = posScreen.getPermissionListValue(1);
            
            super.clearCondition();
            super.setCondition("ROW_ID IN (");
            try{
                ArrayList<PositionPerClass> permList = super.queryPostnPermissionRecord("SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblPositionPermition() + " PRM\nWHERE PRM.PERMITION_NAME = '" + oldPermissionName + "'\nAND PRM.PERMITION_VALUE = '" + oldPermissionValue + "'");
                if(permList.size() > 0) {
                    for(int i = 0; i < permList.size(); i++){
                        if(i == 0){
                            super.setCondition("\n\t'" + permList.get(i).getRow_id() + "'");
                        } else {
                            super.setCondition(",\n\t'" + permList.get(i).getRow_id() + "'");
                        }
                    }
                    super.setCondition("\n)");                
                    countPerm = super.deleteRecord(super.getTblPositionPermition(), super.getCondition());
                    if(countPerm > 0){
                        permRowIdArray.remove(posScreen.getSelectedRowPermissionList());
                        posScreen.removeRowFromPermissionList(posScreen.getSelectedRowPermissionList());
                        super.clearCondition();

                        // Automatic remove Permission on List Of Values Table. Type = POSTN_PER
                        ArrayList<ListOfValuesClass> lovList = queryListOfValues("SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblLstOfVal() + " LOV\nWHERE LOV.TYPE = 'POSTN_PER'\nAND LOV.NAME = '" + oldPermissionName + "'\nAND LOV.VAL = '" + oldPermissionValue + "'");

                        if(lovList.size() > 0) {
                            super.setCondition("ROW_ID = '" + lovList.get(0).getRow_id() + "'");                        
                            try{
                                countLOV = super.deleteRecord(super.getTblLstOfVal(), super.getCondition());
                            } catch (HeadlessException e) {
                                JOptionPane.showMessageDialog(null, "Erro ao remover registros na tabela de Lista de Valores referente a Permissão '" + oldPermissionValue + "'.\nErro: " + e.toString());
                            }                        
                        }                    
                        super.clearCondition();

                        JOptionPane.showMessageDialog(null, "Registro(s) removido(s) com sucesso! Total de registros removidos:\nPermissão: " + countPerm + " registro(s)\nLista de Valores: " + countLOV + " registro(s)");
                        super.clearCondition();
                        posScreen.setSelectedRowColumnListPermission(0, 0);
                        posScreen.setlblRecCountPosList((posScreen.getSelectedRowPermissionList() + 1) + " - " + String.valueOf(permRowIdArray.size()));
                        return true;
                    } else {
                        super.clearCondition();
                        return false;
                    }
                }
                return false;
            } catch (HeadlessException e) {
                super.clearCondition();
                return false;
            }
        } else {
            return false;
        }
    }
    
    private void savePermission() {
        if(validateMandatoryPermissionFields() && validateFieldValuesPermission()){
            try{
                ArrayList<PositionPerClass> permList = queryPostnPermissionRecord("SELECT *\nFROM " + getDbOwner() + "." + getTblPositionPermition() + "\nWHERE ROW_ID = '" + posScreen.gettxtPermissionRowId() + "'");

                if(permList.size() > 0) {
                    if(updatePermission()){
                        posScreen.enableFields("SALVAR_PERMISSION");
                    }
                } else {
                    if(insertPermission()){
                        posScreen.enableFields("SALVAR_PERMISSION");

                        boolean foundRow = true;
                        int i = 0;
                        int o = posScreen.getNumOfPermissionListRows();
                        do {
                            if(i < o){
                                try{                                    
                                    if(getLastPermAdd().equals(permRowIdArray.get(i).getRowId())){
                                        posScreen.setSelectedRowColumnPermissionList(i, 0);
                                        foundRow = false;
                                    }
                                } catch(Exception e){
                                    foundRow = false;
                                }
                            } else {
                                foundRow = false;
                            }
                            i++;
                        } while(foundRow);
                    }
                }
                posScreen.setlblRecCountPosList((posScreen.getSelectedRowPositionList() + 1) + " - " + String.valueOf(permRowIdArray.size()));
            } catch(Exception e) {
                System.out.println(getDateTime() + "\tContactModule.ContactController\t\tSaveSocialMedia\tInsertUpdateSocialMedia\tError Exception\tError: " + e);
            }
        }
    }
    
    private class buttonEditPosition implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            posScreen.enableFields("EDITAR_POSITION");
            posScreen.setFocus("NAME_POSITION");
        }
    }
    
    private class buttonNewPosition implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            //posScreen.unselectRowPositionList();
            posScreen.enableFields("NOVO_POSITION");
            posScreen.clearFields("POSITION");
            posScreen.settxtPositionRowId(getNextRowId());
            posScreen.setFocus("NAME_POSITION");
        }
    }
    
    private class buttonSavePosition implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            savePosition();
        }
    }
    
    private class buttonCancelPosition implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            posScreen.enableFields("CANCELAR_POSITION");
            if(posScreen.getSelectedRowPositionList() >= 0) {
                fillFieldsPositionScreen("SELECT *\nFROM " + getDbOwner() + "." + getTblPosition() + " POS\nWHERE POS.ROW_ID = '" + postnRowIdArray.get(posScreen.getSelectedRowPositionList()).getRowId() + "'");
            } else {
                posScreen.clearFields("POSITION");
            }
            posScreen.setFocus("FILTRO_VALOR");
        }
    }
    
    private class buttonDeletePosition implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if(deletePosition()){
                posScreen.enableFields("DELETAR_POSITION");
                posScreen.clearFields("POSITION");
                if(postnRowIdArray.size() > 0){
                    posScreen.setSelectedRowColumnPositionList(0, 0);
                }
            } else {
                posScreen.enableFields("CANCELAR_POSITION");                
            }
        }
    }
    
    private class buttonEditPermission implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            posScreen.enableFields("EDITAR_PERMISSION");
            posScreen.setFocus("NAME_PERMISSION");
        }
    }
    
    private class buttonNewPermission implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            //posScreen.unselectRowPermissionList();
            posScreen.enableFields("NOVO_PERMISSION");
            posScreen.clearFields("PERMISSION");
            posScreen.settxtPermissionRowId(getNextRowId());
            posScreen.setFocus("NAME_PERMISSION");
        }
    }
    
    private class buttonSavePermission implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            savePermission();
        }
    }
    
    private class buttonCancelPermission implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            posScreen.enableFields("CANCELAR_PERMISSION");
            if(posScreen.getSelectedRowPermissionList() >= 0){
                fillFieldsPermissionScreen("SELECT *\nFROM " + getDbOwner() + "." + getTblPositionPermition() + " PER\nWHERE PER.ROW_ID = '" + permRowIdArray.get(posScreen.getSelectedRowPermissionList()).getRowId() + "'");
            } else {
                posScreen.clearFields("PERMISSION");
            }
            posScreen.setFocus("FILTRO_VALOR");
        }
    }
    
    private class buttonDeletePermission implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if(deletePermission()){
                posScreen.enableFields("DELETAR");
                posScreen.clearFields("PERMISSION");
                //posScreen.setFocus("FILTRO_VALOR");
            } else {
                posScreen.enableFields("CANCELAR_PERMISSION");
                //posScreen.setFocus("FILTRO_VALOR");
            }
        }
    }
    
    private class cbbListPositionItemState implements java.awt.event.ItemListener {

        @Override
        public void itemStateChanged(ItemEvent ie) {
            if(ie.getStateChange() == ItemEvent.SELECTED){
                if(posScreen.getcbbListPositionName() != null) {
                    posScreen.unselectRowPermissionList();
                    fillPermissionList("SELECT *\nFROM " + getDbOwner() + "." + getTblPositionPermition() + "\nWHERE PAR_ROW_ID = '" + getPositionIdByType(LookupName("POSITION_TYPE", posScreen.getcbbListPositionName())) + "'\nORDER BY PERMITION_NAME ASC", "LOAD_RECORD", "PERMISSION_VIEW");
                    if(posScreen.getNumOfPermissionListRows() > 0){
                        posScreen.setSelectedRowColumnPermissionList(0, 0);
                    }
                } else {
                    posScreen.unselectRowPermissionList();
                    posScreen.setPermissionListRowCount(0);
                }
            }
        }
        
    }
    
    private class positionListViewSelected implements ListSelectionListener {
        private int count;
        
        public positionListViewSelected() { this.count = 0; }
        
        @Override
        public void valueChanged(ListSelectionEvent lse) {
            if(count < 1){
                if("LIST_VIEW".equals(getActiveView()) && posScreen.getNumOfPositionListRows() > 0) {
                    fillPermissionList("SELECT *\nFROM " + getDbOwner() + "." + getTblPositionPermition() + "\nWHERE PAR_ROW_ID = '" + postnRowIdArray.get(posScreen.getSelectedRowListPosition()).getRowId() + "'\nORDER BY PERMITION_NAME ASC", "LOAD_RECORD", "LIST_VIEW");
                    posScreen.setlblRecCountPos((posScreen.getSelectedRowListPosition() + 1) + " - " + String.valueOf(posScreen.getNumOfListRowsPosition()));
                }
                count++;
            } else {
                count = 0;
            }
        }
    }
    
    private class permissionListViewSelected implements ListSelectionListener {
        private int count;
        
        private permissionListViewSelected() { this.count = 0; }
        
        @Override
        public void valueChanged(ListSelectionEvent lse) {
            if(count < 1){
                if("LIST_VIEW".equals(getActiveView()) && posScreen.getNumOfPermissionListRows() > 0) {
                    posScreen.setlblRecCountPerm((posScreen.getSelectedRowListPermission() + 1) + " - " + String.valueOf(posScreen.getNumOfListRowsPermission()));
                }
                count++;
            } else {
                count = 0;
            }
        }
    }
    
    private class positionListSelected implements ListSelectionListener {
        private int count;
        
        public positionListSelected() { this.count = 0; }
        
        @Override
        public void valueChanged(ListSelectionEvent lse) {
            if(count < 1){
                if("POSITION_VIEW".equals(getActiveView()) && posScreen.getNumOfPositionListRows() > 0){
                    posScreen.clearFields("POSITION");
                    posScreen.setbtnEditPositionEnabled(true);
                    posScreen.setbtnDeletePositionEnabled(true);
                    fillFieldsPositionScreen("SELECT *\nFROM " + getDbOwner() + "." + getTblPosition() + "\nWHERE ROW_ID = '" + postnRowIdArray.get(posScreen.getSelectedRowPositionList()).getRowId() + "'");
                    posScreen.setlblRecCountPosList((posScreen.getSelectedRowPositionList() + 1) + " - " + String.valueOf(posScreen.getNumOfPositionListRows()));
                }
                count++;
            } else {
                count = 0;
            }
        }
    }
    
    private class permissionListSelected implements ListSelectionListener {
        private int count;
        
        public permissionListSelected() { this.count = 0; }
        
        @Override
        public void valueChanged(ListSelectionEvent lse) {
            if(count < 1){
                if("PERMISSION_VIEW".equals(getActiveView()) && permRowIdArray.size() > 0 && !"Selecione...".equals(posScreen.getcbbListPositionName())){
                    posScreen.clearFields("PERMITION");                    
                    posScreen.setbtnEditPermitionEnabled(true);
                    posScreen.setbtnDeletePermitionEnabled(true);
                    fillFieldsPermissionScreen("SELECT *\nFROM " + getDbOwner() + "." + getTblPositionPermition() + "\nWHERE ROW_ID = '" + permRowIdArray.get(posScreen.getSelectedRowPermissionList()).getRowId() + "'");
                    posScreen.setlblRecCountPermList((posScreen.getSelectedRowPermissionList() + 1) + " - " + String.valueOf(posScreen.getNumOfPermissionListRows()));
                }
                count++;
            } else {
                count = 0;
            }
        }
    }
    
    private class PanelListFocusGained implements ComponentListener {

        @Override
        public void componentResized(ComponentEvent ce) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void componentMoved(ComponentEvent ce) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void componentShown(ComponentEvent ce) {
            postnRowIdArray.clear();
            permRowIdArray.clear();
            setActiveView("LIST_VIEW");
            posScreen.unselectRowListPosition();
            posScreen.unselectRowListPermission();
            posScreen.unselectRowPositionList();
            posScreen.unselectRowPermissionList();
            posScreen.clearFields("LIST");
            posScreen.clearComboBoxes("LIST");
            posScreen.enableFields("LOAD_SCREEN");
            posScreen.insertSelectComboBox();
            fillComboBoxes("POSITION_FILTER");
            fillPositionList("SELECT *\nFROM " + getDbOwner() + "." + getTblPosition() + "\nORDER BY NAME ASC", "LOAD_RECORD", "LIST_VIEW");
            posScreen.setSelectedRowColumnListPosition(0, 0);
            posScreen.setFocus("FILTRO_VALOR");
        }

        @Override
        public void componentHidden(ComponentEvent ce) {
            //JOptionPane.showMessageDialog(null, "Perdeu Foco");
        }
        
    }
    
    private class PanelPositionFocusGained implements ComponentListener {

        @Override
        public void componentResized(ComponentEvent ce) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void componentMoved(ComponentEvent ce) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void componentShown(ComponentEvent ce) {
            postnRowIdArray.clear();
            setActiveView("POSITION_VIEW");
            posScreen.unselectRowListPosition();
            posScreen.unselectRowListPermission();
            posScreen.unselectRowPositionList();
            posScreen.unselectRowPermissionList();
            posScreen.clearFields("POSITION");
            posScreen.enableFields("LOAD_SCREEN");
            fillPositionList("SELECT *\nFROM " + getDbOwner() + "." + getTblPosition() + "\nORDER BY NAME ASC", "LOAD_RECORD", "POSITION_VIEW");
            posScreen.setSelectedRowColumnPositionList(0, 0);
        }

        @Override
        public void componentHidden(ComponentEvent ce) {
            //JOptionPane.showMessageDialog(null, "Perdeu Foco");
        }
        
    }
    
    private class PanelPermitionFocusGained implements ComponentListener {

        @Override
        public void componentResized(ComponentEvent ce) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void componentMoved(ComponentEvent ce) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void componentShown(ComponentEvent ce) {
            permRowIdArray.clear();
            setActiveView("PERMISSION_VIEW");
            posScreen.unselectRowListPosition();
            posScreen.unselectRowListPermission();
            posScreen.unselectRowPositionList();
            posScreen.unselectRowPermissionList();
            posScreen.clearFields("PERMISSION");
            posScreen.clearComboBoxes("PERMISSION");
            posScreen.enableFields("LOAD_SCREEN");
            posScreen.insertSelectComboBox();
            fillComboBoxes("POSITION_TYPE");
            //fillComboBoxes("POSTN_PER");
        }

        @Override
        public void componentHidden(ComponentEvent ce) {
            //JOptionPane.showMessageDialog(null, "Perdeu Foco");
        }
        
    }
    
    private class txtPositionNameKeyListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent ke) { }

        @Override
        public void keyPressed(KeyEvent ke) {
            if(ke.getKeyCode() == KeyEvent.VK_ENTER || ke.getKeyCode() == KeyEvent.VK_TAB){
                posScreen.setFocus("TYPE_POSITION");
            }
        }

        @Override
        public void keyReleased(KeyEvent ke) { }
        
    }
    
    private class txtPositionTypeKeyListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent ke) { }

        @Override
        public void keyPressed(KeyEvent ke) {
            if(ke.getKeyCode() == KeyEvent.VK_ENTER || ke.getKeyCode() == KeyEvent.VK_TAB){
                posScreen.setFocus("DESC_POSITION");
            }
        }

        @Override
        public void keyReleased(KeyEvent ke) { }
        
    }
    
    private class txtPositionDescKeyListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent ke) { }

        @Override
        public void keyPressed(KeyEvent ke) {
            if(ke.getKeyCode() == KeyEvent.VK_ENTER || ke.getKeyCode() == KeyEvent.VK_TAB){
                posScreen.setFocus("BOTAO_SALVAR_POSITION");
            }
        }

        @Override
        public void keyReleased(KeyEvent ke) { }
        
    }
    
    private class btnQueryPositionKeyListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent ke) { }

        @Override
        public void keyPressed(KeyEvent ke) {
            if(ke.getKeyCode() == KeyEvent.VK_ENTER){
                posScreen.setFocus("ID_POSITION");
            }
            if(ke.getKeyCode() == KeyEvent.VK_TAB){
                posScreen.setFocus("BOTAO_GO_QUERY_POSITION");
            }
        }

        @Override
        public void keyReleased(KeyEvent ke) { }
        
    }
    
    private class btnGoQueryPositionKeyListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent ke) { }

        @Override
        public void keyPressed(KeyEvent ke) {
            if(ke.getKeyCode() == KeyEvent.VK_ENTER){
                //posScreen.setFocus("FILTRO_VALOR");
            }
            
            if(ke.getKeyCode() == KeyEvent.VK_TAB){
                posScreen.setFocus("ID_POSITION");
            }
        }

        @Override
        public void keyReleased(KeyEvent ke) { }
        
    }
    
    private class btnNewPositionKeyListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent ke) { }

        @Override
        public void keyPressed(KeyEvent ke) {
            if(ke.getKeyCode() == KeyEvent.VK_ENTER){
                posScreen.setFocus("NAME_POSITION");
            }
            if(ke.getKeyCode() == KeyEvent.VK_TAB){
                posScreen.setFocus("BOTAO_EDITAR_POSITION");
            }
        }

        @Override
        public void keyReleased(KeyEvent ke) { }
        
    }
    
    private class btnEditPositionKeyListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent ke) { }

        @Override
        public void keyPressed(KeyEvent ke) {
            if(ke.getKeyCode() == KeyEvent.VK_ENTER){
                posScreen.setFocus("NAME_POSITION");
            }
            if(ke.getKeyCode() == KeyEvent.VK_TAB){
                posScreen.setFocus("BOTAO_DELETAR_POSITION");
            }
        }

        @Override
        public void keyReleased(KeyEvent ke) { }
        
    }
    
    private class btnDeletePositionKeyListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent ke) { }

        @Override
        public void keyPressed(KeyEvent ke) {
            if(ke.getKeyCode() == KeyEvent.VK_ENTER){
                //posScreen.setFocus("VAL");
            }
            if(ke.getKeyCode() == KeyEvent.VK_TAB){
                posScreen.setFocus("BOTAO_NOVO_POSITION");
            }
        }

        @Override
        public void keyReleased(KeyEvent ke) { }
        
    }

    private class btnSavePositionKeyListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent ke) { }

        @Override
        public void keyPressed(KeyEvent ke) {
            if(ke.getKeyCode() == KeyEvent.VK_ENTER){
                //posScreen.setFocus("VAL");
            }
            if(ke.getKeyCode() == KeyEvent.VK_TAB){
                posScreen.setFocus("BOTAO_CANCELAR_POSITION");
            }
        }

        @Override
        public void keyReleased(KeyEvent ke) { }
        
    }
    
    private class btnCancelPositionKeyListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent ke) { }

        @Override
        public void keyPressed(KeyEvent ke) {
            if(ke.getKeyCode() == KeyEvent.VK_ENTER){
                //posScreen.setFocus("VAL");
            }
            if(ke.getKeyCode() == KeyEvent.VK_TAB){
                posScreen.setFocus("BOTAO_SALVAR_POSITION");
            }
        }

        @Override
        public void keyReleased(KeyEvent ke) { }
        
    }
    
    private class txtPermissionNameKeyListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent ke) { }

        @Override
        public void keyPressed(KeyEvent ke) {
            if(ke.getKeyCode() == KeyEvent.VK_ENTER || ke.getKeyCode() == KeyEvent.VK_TAB){
                posScreen.setFocus("VALUE_PERMISSION");
            }
        }

        @Override
        public void keyReleased(KeyEvent ke) { }
        
    }
    
    private class txtPermissionValueKeyListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent ke) { }

        @Override
        public void keyPressed(KeyEvent ke) {
            if(ke.getKeyCode() == KeyEvent.VK_ENTER || ke.getKeyCode() == KeyEvent.VK_TAB){
                posScreen.setFocus("FLAG_PERMISSION");
            }
        }

        @Override
        public void keyReleased(KeyEvent ke) { }
        
    }
    
    private class ckbPermissionFlgKeyListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent ke) { }

        @Override
        public void keyPressed(KeyEvent ke) {
            if(ke.getKeyCode() == KeyEvent.VK_ENTER || ke.getKeyCode() == KeyEvent.VK_TAB){
                posScreen.setFocus("DESC_PERMISSION");
            }
        }

        @Override
        public void keyReleased(KeyEvent ke) { }
        
    }
    
    private class txtPermissionDescKeyListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent ke) { }

        @Override
        public void keyPressed(KeyEvent ke) {
            if(ke.getKeyCode() == KeyEvent.VK_ENTER || ke.getKeyCode() == KeyEvent.VK_TAB){
                posScreen.setFocus("BOTAO_SALVAR_PERMISSION");
            }
        }

        @Override
        public void keyReleased(KeyEvent ke) { }
        
    }
    
    private class btnQueryPermissionKeyListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent ke) { }

        @Override
        public void keyPressed(KeyEvent ke) {
            if(ke.getKeyCode() == KeyEvent.VK_ENTER){
                posScreen.setFocus("ID_PERMITION");
            }
            if(ke.getKeyCode() == KeyEvent.VK_TAB){
                posScreen.setFocus("BOTAO_GO_QUERY_PERMISSION");
            }
        }

        @Override
        public void keyReleased(KeyEvent ke) { }
        
    }
    
    private class btnGoQueryPermissionKeyListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent ke) { }

        @Override
        public void keyPressed(KeyEvent ke) {
            if(ke.getKeyCode() == KeyEvent.VK_ENTER){
                //posScreen.setFocus("VAL");
            }
            if(ke.getKeyCode() == KeyEvent.VK_TAB){
                posScreen.setFocus("BOTAO_QUERY_PERMISSION");
            }
        }

        @Override
        public void keyReleased(KeyEvent ke) { }
        
    }
    
    private class btnNewPermissionKeyListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent ke) { }

        @Override
        public void keyPressed(KeyEvent ke) {
            if(ke.getKeyCode() == KeyEvent.VK_ENTER){
                posScreen.setFocus("NAME_PERMISSION");
            }
            if(ke.getKeyCode() == KeyEvent.VK_TAB){
                posScreen.setFocus("BOTAO_EDITAR_PERMISSION");
            }
        }

        @Override
        public void keyReleased(KeyEvent ke) { }
        
    }
    
    private class btnEditPermissionKeyListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent ke) { }

        @Override
        public void keyPressed(KeyEvent ke) {
            if(ke.getKeyCode() == KeyEvent.VK_ENTER){
                posScreen.setFocus("NAME_PERMISSION");
            }
            if(ke.getKeyCode() == KeyEvent.VK_TAB){
                posScreen.setFocus("BOTAO_DELETAR_PERMISSION");
            }
        }

        @Override
        public void keyReleased(KeyEvent ke) { }
        
    }
    
    private class btnDeletePermissionKeyListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent ke) { }

        @Override
        public void keyPressed(KeyEvent ke) {
            if(ke.getKeyCode() == KeyEvent.VK_ENTER){
                //posScreen.setFocus("VAL");
            }
            if(ke.getKeyCode() == KeyEvent.VK_TAB){
                posScreen.setFocus("BOTAO_NOVO_PERMISSION");
            }
        }

        @Override
        public void keyReleased(KeyEvent ke) { }
        
    }

    private class btnSavePermissionKeyListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent ke) { }

        @Override
        public void keyPressed(KeyEvent ke) {
            if(ke.getKeyCode() == KeyEvent.VK_ENTER){
                //posScreen.setFocus("VAL");
            }
            if(ke.getKeyCode() == KeyEvent.VK_TAB){
                posScreen.setFocus("BOTAO_CANCELAR_PERMISSION");
            }
        }

        @Override
        public void keyReleased(KeyEvent ke) { }
        
    }
    
    private class btnCancelPermissionKeyListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent ke) { }

        @Override
        public void keyPressed(KeyEvent ke) {
            if(ke.getKeyCode() == KeyEvent.VK_ENTER){
                //posScreen.setFocus("VAL");
            }
            if(ke.getKeyCode() == KeyEvent.VK_TAB){
                posScreen.setFocus("BOTAO_SALVAR_PERMISSION");
            }
        }

        @Override
        public void keyReleased(KeyEvent ke) { }
        
    }
    
    private class postnRowIdClass {
        private String rowId;
        
        public postnRowIdClass() { this.rowId = null; }

        public String getRowId() {
            return rowId;
        }

        public void setRowId(String rowId) {
            this.rowId = rowId;
        }
        
    }

    private class permRowIdClass {
        private String rowId;
        
        public permRowIdClass() { this.rowId = null; }

        public String getRowId() {
            return rowId;
        }

        public void setRowId(String rowId) {
            this.rowId = rowId;
        }
        
    }
    
}
