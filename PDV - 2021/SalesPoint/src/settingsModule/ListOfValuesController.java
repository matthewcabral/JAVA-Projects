/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package settingsModule;

import databaseModule.DataController;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mathe
 */
public class ListOfValuesController extends DataController {
    ListOfValuesScreen lovScr;
    
    private String user;
    private String password;
    private String lastLOVAdd;
    private String lastLOVUpd;
    private int count;
    private final int LOVTypeSize = 30;
    private final int LOVNameSize = 50;
    private final int LOVValueSize = 50;
    private final int LOVLanguageSize = 15;
    private final int LOVOrderSize = 22;
    private final int LOVRplctnLevelSize = 30;
    private final int LOVCodeSize = 30;
    private final int LOVSubtypeSize = 30;
    private final int LOVDescriptionSize = 255;
    
    LOVRowIdClass lovRowId;
    private ArrayList<LOVRowIdClass> lovRowIdArray = new ArrayList<>();

    public ListOfValuesController() throws InterruptedException { }
    
    public String getUser() { return user; }
    public void setUser(String user) { this.user = user; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getLastLOVAdd() { return lastLOVAdd; }
    public void setLastLOVAdd(String lastLOVAdd) { this.lastLOVAdd = lastLOVAdd; }

    public String getLastLOVUpd() { return lastLOVUpd; }
    public void setLastLOVUpd(String lastLOVUpd) { this.lastLOVUpd = lastLOVUpd; }
    
    public int getCount() { return count; }
    public void setCount(int count) { this.count += count; }
    public void clearCount() { this.count = 0; }

    public int getLOVTypeSize() { return LOVTypeSize; }
    public int getLOVNameSize() { return LOVNameSize; }
    public int getLOVValueSize() { return LOVValueSize; }
    public int getLOVLanguageSize() { return LOVLanguageSize; }
    public int getLOVOrderSize() { return LOVOrderSize; }
    public int getLOVRplctnLevelSize() { return LOVRplctnLevelSize; }
    public int getLOVCodeSize() { return LOVCodeSize; }
    public int getLOVSubtypeSize() { return LOVSubtypeSize; }
    public int getLOVDescriptionSize() { return LOVDescriptionSize; }
    
    public void openScreen() {
        lovScr = new ListOfValuesScreen();
        lovScr.setListenerBtnNew(new buttonNew());
        lovScr.setListenerBtnEdit(new buttonEdit());
        lovScr.setListenerBtnDelete(new buttonDelete());
        lovScr.setListenerBtnSave(new buttonSave());
        lovScr.setListenerBtnCancel(new buttonCancel());
        lovScr.setListenerBtnQuery(new buttonQuery());
        lovScr.setListenerBtnGoQuery(new buttonGoQuery());
        lovScr.setListenerTblListSelection(new ListSelected());
        lovScr.setListenercbbListFilterValue(new CbbListFilterItemState());
        lovScr.setListenertxtListFilterValue(new TxtListFilterValue());
        lovScr.setListenertxtOrder(new TxtOrderKeyEvent());
        //lovScr.setListenertxtLOVType(new KeyTypedInteger());
        
        lovScr.clearFields();
        lovScr.clearFilters();
        lovScr.clearComboBoxes();
        lovScr.enableFields("LOAD_SCREEN");
        lovScr.insertSelectComboBox();
        this.fillComboBoxes("LOV_FILTER");
        this.fillComboBoxes("LOV_TYPE");
        this.fillComboBoxes("LANG_TYPE");
        fillList("SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblLstOfVal() + " LOV\nORDER BY LOV.TYPE, LOV.NAME, LOV.VAL, LOV.ORDER_BY ASC", "");
    }

    private void fillComboBoxes(String type){
        try{
            if("LANG_TYPE".equals(type)){
                ArrayList<LanguageClass> lang = super.LookupLangList();
                
                if(lang.size() > 0) {
                    for(int i = 0; i < lang.size(); i++){
                        lovScr.setcbbLanguage(lang.get(i).getVALUE());
                    }
                }
            } else {
                ArrayList<ListOfValuesClass> lov = super.LookupList(type);
            
                if(lov.size() > 0){
                    for(int i = 0; i < lov.size(); i++){
                        if(null == type){
                            JOptionPane.showMessageDialog(null, "O LOV_TYPE 'null' não existe!");
                        } else switch (type) {
                            case "LOV_FILTER":
                                lovScr.setcbbListFilter(lov.get(i).getValue());
                                break;
                            case "LOV_TYPE":
                                lovScr.setcbbLOVType(lov.get(i).getValue());
                                //lovScr.setcbbSubType(lov.get(i).getValue());
                                break;
                            /*case "SEX_MF":
                                lovScr.setcbbSex(lov.get(i).getValue());
                                break;
                            case "MONTH_DAY":
                                lovScr.setcbbDay(lov.get(i).getValue());
                                break;
                            case "MONTH":
                                userScreen.setcbbMonth(lov.get(i).getValue());
                                break;
                            case "CIVIL_STATE":
                                userScreen.setcbbCivilState(lov.get(i).getValue());
                                break;
                            case "DOCUMENT_TYPE":
                                userScreen.setcbbIdentityType(lov.get(i).getValue());
                                break;
                            case "STATE":
                                userScreen.setcbbEmissionUF(lov.get(i).getValue());
                                break;*/
                            default:
                                JOptionPane.showMessageDialog(null, "O LOV_TYPE '" + type +  "' não é utilizado por nenhum ComboBox!");
                                break;
                        }
                    }
                }
            }
            
        } catch(HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher ComboBoxes...\nErro: " + e);
        }
    }
    
    private void fillList(String query, String method){
        DefaultTableModel table = (DefaultTableModel) lovScr.getTableModel();
        int countRecord = 0;
        switch(method){
            case "INSERT_RECORD":
                int newRow = table.getRowCount() + 1;
                //table.setRowCount(newRow);
                try{
                    table.addRow(
                        new Object[] {
                            lovScr.getcbbLOVType(),
                            lovScr.gettxtName(),
                            lovScr.gettxtValue(),
                            super.LookupLangCodeByValue(lovScr.getcbbLanguage()),
                            lovScr.gettxtOrder(),
                            ("Y".equals(lovScr.getckbActiveFlg())),
                            lovScr.gettxtReplicationLevel(),
                            lovScr.gettxtCode(),
                            lovScr.gettxtSubType(),
                            lovScr.gettxtDescription()
                        }
                    );
                } catch(Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro ao preencher tabela...\nErro: " + e);
                }
                break;
            case "UPDATE_RECORD":
                try{
                    table.setValueAt(lovScr.getcbbLOVType(), lovScr.getSelectedRowList(), 0);
                    table.setValueAt(lovScr.gettxtName(), lovScr.getSelectedRowList(), 1);
                    table.setValueAt(lovScr.gettxtValue(), lovScr.getSelectedRowList(), 2);
                    table.setValueAt(super.LookupLangCodeByValue(lovScr.getcbbLanguage()), lovScr.getSelectedRowList(), 3);
                    table.setValueAt(lovScr.gettxtOrder(), lovScr.getSelectedRowList(), 4);
                    table.setValueAt(("Y".equals(lovScr.getckbActiveFlg())), lovScr.getSelectedRowList(), 5);
                    table.setValueAt(lovScr.gettxtReplicationLevel(), lovScr.getSelectedRowList(), 6);
                    table.setValueAt(lovScr.gettxtCode(), lovScr.getSelectedRowList(), 7);
                    table.setValueAt(lovScr.gettxtSubType(), lovScr.getSelectedRowList(), 8);
                    table.setValueAt(lovScr.gettxtDescription(), lovScr.getSelectedRowList(), 9);
                } catch(Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro ao preencher tabela...\nErro: " + e);
                }
                break;
            default:
                try{
                    ArrayList<ListOfValuesClass> lovList = super.queryListOfValues(query);
                                        
                    try{ lovRowIdArray.clear(); } catch (Exception e) {}

                    if(lovList.size() > 0){
                        try{ table.setRowCount(lovList.size()); } catch (Exception e) {}
                        try{ table.setNumRows(lovList.size()); } catch (Exception e) {}
                        
                        for(int i = 0; i < lovList.size(); i++){
                            lovRowId = new LOVRowIdClass();
                            lovRowId.setRowId(lovList.get(i).getRow_id());
                            lovRowIdArray.add(lovRowId);
                            table.setValueAt(lovList.get(i).getType(), i, 0);
                            table.setValueAt(lovList.get(i).getName(), i, 1);
                            table.setValueAt(lovList.get(i).getValue(), i, 2);
                            table.setValueAt(lovList.get(i).getLang_id(), i, 3);
                            table.setValueAt(lovList.get(i).getOrder_by(), i, 4);
                            table.setValueAt(("Y".equals(lovList.get(i).getActive_flg())), i, 5);
                            table.setValueAt(lovList.get(i).getRplctn_lvl_cd(), i, 6);
                            table.setValueAt(lovList.get(i).getCode(), i, 7);
                            table.setValueAt(lovList.get(i).getSubtype(), i, 8);
                            table.setValueAt(lovList.get(i).getDesc_text(), i, 9);

                            countRecord++;
                        }
                    } else {
                        table.setRowCount(0);
                    }

                } catch(Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro ao preencher tabela...\nErro: " + e);
                }
                break;
        }
        lovScr.setlblRecCount("0 - " + String.valueOf(lovRowIdArray.size()));
    }
    
    private void fillFields(String query) {
        try{
            ArrayList<ListOfValuesClass> lovList = super.queryListOfValues(query);
        
            if(lovList.size() > 0){
                for(int i = 0; i < lovList.size(); i++){
                    lovScr.setlblLOVNameHeader(lovList.get(i).getType());
                    lovScr.settxtRowId(lovList.get(i).getRow_id());
                    lovScr.setcbbLOVTypeItemIndex(lovScr.getcbbLOVTypeItemIndex(lovList.get(i).getType()));
                    lovScr.settxtName(lovList.get(i).getName());
                    lovScr.settxtValue(lovList.get(i).getValue());
                    lovScr.setcbbLanguageItemIndex(lovScr.getcbbLanguageItemIndex(super.LookupLangValueByCode(lovList.get(i).getLang_id())));
                    lovScr.settxtOrder(lovList.get(i).getOrder_by());
                    lovScr.setckbActiveFlg(lovList.get(i).getActive_flg());
                    lovScr.settxtReplicationLevel(lovList.get(i).getRplctn_lvl_cd());
                    lovScr.settxtCode(lovList.get(i).getCode());                    
                    lovScr.settxtSubType(lovList.get(i).getSubtype());
                    lovScr.settxtDescription(lovList.get(i).getDesc_text());
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher Campos...\nErro: " + e);
        }
    }
    
    public void fillFieldsNewRecord(){
        lovScr.settxtRowId(getNextRowId());
        lovScr.setckbActiveFlg("Y");
        lovScr.setcbbLanguageItemIndex(lovScr.getcbbLanguageItemIndex(super.LookupLangValueByCode("PTB")));
        lovScr.settxtReplicationLevel("All");
    }
        
    private boolean validateMandatoryFields(){
        String mensagem = "";
        int i = 0;
        
        if(lovScr.getcbbLOVType() == null) { mensagem += "\n- " + "Tipo" + ";"; i = (i < 1) ? 1 : i; }
        if(lovScr.gettxtName() == null) { mensagem += "\n- " + "Nome" + ";"; i = (i < 2 && i != 0) ? i : 2; }
        if(lovScr.gettxtValue() == null) { mensagem += "\n- " + "Exibir Valor" + ";"; i = (i < 3 && i != 0) ? i : 3; }
        if(lovScr.getcbbLanguage() == null) { mensagem += "\n- " + "Idioma" + ";"; i = (i < 4 && i != 0) ? i : 4; }
        
        switch(i){
            case 1: lovScr.setFocus("TYPE"); break;
            case 2: lovScr.setFocus("NAME"); break;
            case 3: lovScr.setFocus("VAL"); break;
            case 4: lovScr.setFocus("LANGUAGE"); break;
            default: break;
        }
        
        if(!"".equals(mensagem) && mensagem != null){
            JOptionPane.showMessageDialog(null, "Os campos abaixo são obrigatórios. Favor preencher os mesmos:" + mensagem);
            return false;
        } else {
            return true;
        }
    }
    
    private boolean validateFieldValues(){
        int countLovType = 0;
        int countUniqueValue = 0;
        
        // Validate Field Sizes
        if((lovScr.getcbbLOVType() != null) && (lovScr.getcbbLOVType().length() > getLOVTypeSize())) { JOptionPane.showMessageDialog(null, "O tamanho do campo 'Tipo' deve ter no máximo: " + getLOVTypeSize() + " caractere(s)"); return false; }
        if((lovScr.gettxtName() != null) && (lovScr.gettxtName().length() > getLOVNameSize())) { JOptionPane.showMessageDialog(null, "O tamanho do campo 'Nome' deve ter no máximo: " + getLOVNameSize() + " caractere(s)"); return false; }
        if((lovScr.gettxtValue() != null) && (lovScr.gettxtValue().length() > getLOVValueSize())) { JOptionPane.showMessageDialog(null, "O tamanho do campo 'Exibir Valor' deve ter no máximo: " + getLOVValueSize() + " caractere(s)"); return false; }
        if((lovScr.getcbbLanguage() != null) && (super.LookupLangCodeByValue(lovScr.getcbbLanguage()).length() > getLOVLanguageSize())) { JOptionPane.showMessageDialog(null, "O tamanho do campo 'Idioma' deve ter no máximo: " + getLOVLanguageSize() + " caractere(s)"); return false; }
        if((lovScr.gettxtOrder() != null) && (lovScr.gettxtOrder().length() > getLOVOrderSize())) { JOptionPane.showMessageDialog(null, "O tamanho do campo 'Ordem' deve ter no máximo: " + getLOVOrderSize() + " caractere(s)"); return false; }
        if((lovScr.gettxtReplicationLevel() != null) && (lovScr.gettxtReplicationLevel().length() > getLOVRplctnLevelSize())) { JOptionPane.showMessageDialog(null, "O tamanho do campo 'Nível de Replicação' deve ter no máximo: " + getLOVRplctnLevelSize() + " caractere(s)"); return false; }
        if((lovScr.gettxtCode() != null) && (lovScr.gettxtCode().length() > getLOVCodeSize())) { JOptionPane.showMessageDialog(null, "O tamanho do campo 'Código' deve ter no máximo: " + getLOVCodeSize() + " caractere(s)"); return false; }
        if((lovScr.gettxtSubType() != null) && (lovScr.gettxtSubType().length() > getLOVSubtypeSize())) { JOptionPane.showMessageDialog(null, "O tamanho do campo 'Subtipo' deve ter no máximo: " + getLOVSubtypeSize() + " caractere(s)"); return false; }
        if((lovScr.gettxtDescription() != null) && (lovScr.gettxtDescription().length() > getLOVDescriptionSize())) { JOptionPane.showMessageDialog(null, "O tamanho do campo 'Descrição' deve ter no máximo: " + getLOVDescriptionSize() + " caractere(s)"); return false; }
        
        // Validate Field Types
        if (lovScr.gettxtOrder() != null) {
            try{ Integer.valueOf(lovScr.gettxtOrder()); } catch (NumberFormatException e) { JOptionPane.showMessageDialog(null, "O campo 'Ordem' deve ser do tipo numérico."); return false; }
        }
        
        if(!"LOV_TYPE".equals(lovScr.getcbbLOVType())){
            // Validate if LOV_TYPE exists
            super.clearCondition();
            super.setCondition("TYPE = 'LOV_TYPE'");
            super.setCondition("\nAND " + "NAME = '" + lovScr.getcbbLOVType() + "'");
            super.setCondition("\nAND " + "VAL = '" + lovScr.getcbbLOVType() + "'");
            super.setCondition("\nAND " + "LANG_ID = '" + super.LookupLangCodeByValue(lovScr.getcbbLanguage()) + "'");

            countLovType = super.queryTableCount(super.getTblLstOfVal(), super.getCondition());

            if(countLovType < 1) {
                JOptionPane.showMessageDialog(null, "Erro: O LOV_TYPE '" + lovScr.getcbbLOVType() + "' não existe ou existem somente em outro idioma.\nFavor criar o LOV_TYPE antes de continuar a criação dos valores atuais.");
                return false;
            }
        }        
        
        // Validate if values exists
        super.clearCondition();
        super.setCondition("TYPE = '" + lovScr.getcbbLOVType() + "'");
        super.setCondition("\nAND " + "NAME = '" + lovScr.gettxtName() + "'");
        super.setCondition("\nAND " + "VAL = '" + lovScr.gettxtValue() + "'");
        super.setCondition("\nAND " + "LANG_ID = '" + super.LookupLangCodeByValue(lovScr.getcbbLanguage()) + "'");
        super.setCondition("\nAND " + "ROW_ID <> '" + lovScr.gettxtRowId() + "'");
        
        countUniqueValue = super.queryTableCount(super.getTblLstOfVal(), super.getCondition());
        
        if(countUniqueValue > 0) {
            JOptionPane.showMessageDialog(null, "Um registro que contém valores idênticos ao que você criou já existe.\n\nSe você deseja criar um novo registro, certifique-se que os campos tenham valores únicos.");
            return false;
        }
        
        return true;
    }
    
    private boolean validateBeforeDelete(){
        int countUniqueValue = 0;
        
        if("LOV_TYPE".equals(lovScr.getcbbLOVType())){
            // Validate if LOV_TYPE being deleted has child values
            super.clearCondition();
            super.setCondition("TYPE = '" + lovScr.gettxtName() + "'");
            super.setCondition("\nAND " + "LANG_ID = '" + lovScr.getcbbLanguage() + "'");

            countUniqueValue = super.queryTableCount(super.getTblLstOfVal(), super.getCondition());
            
            if(countUniqueValue > 0) {
                JOptionPane.showMessageDialog(null, "Atenção: O LOV_TYPE '" + lovScr.gettxtName() + "' com o idioma '" + lovScr.getcbbLanguage() + "' possui itens filhos cadastrados.\nPara excluir o mesmo, antes devem ser excluídos os itens filhos.");
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }        
    }
    
    private boolean insert(){
        String lovId = super.getNextRowId();
        super.clearColumns();
        super.clearValues();
        super.setColumns(",\n\t" + "PAR_ROW_ID"); super.setValues(",\n\t" + "NULL");        
        super.setColumns(",\n\t" + "TYPE"); super.setValues(",\n\t" + ((lovScr.getcbbLOVType() != null) ? "'" + lovScr.getcbbLOVType() + "'" : "NULL"));
        super.setColumns(",\n\t" + "NAME"); super.setValues(",\n\t" + ((lovScr.gettxtName() != null) ? "'" + lovScr.gettxtName() + "'" : "NULL"));
        super.setColumns(",\n\t" + "VAL"); super.setValues(",\n\t" + ((lovScr.gettxtValue() != null) ? "'" + lovScr.gettxtValue() + "'" : "NULL"));
        super.setColumns(",\n\t" + "LANG_ID"); super.setValues(",\n\t" + ((lovScr.getcbbLanguage() != null) ? "'" + super.LookupLangCodeByValue(lovScr.getcbbLanguage()) + "'" : "NULL"));
        super.setColumns(",\n\t" + "RPLCTN_LVL_CD"); super.setValues(",\n\t" + ((lovScr.gettxtReplicationLevel() != null) ? "'" + lovScr.gettxtReplicationLevel() + "'" : "NULL"));
        super.setColumns(",\n\t" + "ACTIVE_FLG"); super.setValues(",\n\t" + "'" + lovScr.getckbActiveFlg() + "'");
        super.setColumns(",\n\t" + "ORDER_BY"); super.setValues(",\n\t" + ((lovScr.gettxtOrder() != null) ? "'" + lovScr.gettxtOrder() + "'" : "NULL"));
        super.setColumns(",\n\t" + "CODE"); super.setValues(",\n\t" + ((lovScr.gettxtCode() != null) ? "'" + lovScr.gettxtCode() + "'" : "NULL"));
        super.setColumns(",\n\t" + "SUB_TYPE"); super.setValues(",\n\t" + ((lovScr.gettxtSubType() != null) ? "'" + lovScr.gettxtSubType() + "'" : "NULL"));
        super.setColumns(",\n\t" + "DESC_TEXT"); super.setValues(",\n\t" + ((lovScr.gettxtDescription() != null) ? "'" + lovScr.gettxtDescription() + "'" : "NULL"));
        
        try {
            if("true".equals(super.insertRecord(super.getTblLstOfVal(), super.getColumns(), super.getValues()))){
                lovRowId = new LOVRowIdClass();
                lovRowId.setRowId(lovId);
                lovRowIdArray.add(lovRowId);
                this.setLastLOVAdd(lovId);
                this.fillList(null, "INSERT_RECORD");
                this.clearColumns();
                this.clearValues();
                return true;
            } else {
                lovId = null;
                this.clearColumns();
                this.clearValues();
                return false;
            }
        } catch (Exception e) {
            lovId = null;
            this.clearColumns();
            this.clearValues();
            return false;
        }
    }
    
    private boolean update(){
        boolean retorno = false;
        
        super.clearColumnsValues();
        super.clearCondition();
        
        // Custom Columns
        super.setColumnsValues(",\n\t" + "MODIFICATION_NUM = (SELECT MODIFICATION_NUM + 1 FROM " + super.getDbOwner() + "." + super.getTblLstOfVal() + " WHERE ROW_ID = '" + lovScr.gettxtRowId() + "')");
        super.setColumnsValues(",\n\t" + "TYPE = " + ((lovScr.getcbbLOVType() != null) ?  "'" + lovScr.getcbbLOVType() + "'" : "NULL"));
        super.setColumnsValues(",\n\t" + "NAME = " + ((lovScr.gettxtName() != null) ?  "'" + lovScr.gettxtName() + "'" : "NULL"));
        super.setColumnsValues(",\n\t" + "VAL = " + ((lovScr.gettxtValue() != null) ?  "'" + lovScr.gettxtValue() + "'" : "NULL"));    
        super.setColumnsValues(",\n\t" + "LANG_ID = " + ((lovScr.getcbbLanguage() != null) ?  "'" + super.LookupLangCodeByValue(lovScr.getcbbLanguage()) + "'" : "NULL"));
        super.setColumnsValues(",\n\t" + "ORDER_BY = " + ((lovScr.gettxtOrder() != null) ?  "'" + lovScr.gettxtOrder() + "'" : "NULL"));
        super.setColumnsValues(",\n\t" + "ACTIVE_FLG = '" + lovScr.getckbActiveFlg() + "'");
        super.setColumnsValues(",\n\t" + "RPLCTN_LVL_CD = " + ((lovScr.gettxtReplicationLevel() != null) ?  "'" + lovScr.gettxtReplicationLevel() + "'" : "NULL"));
        super.setColumnsValues(",\n\t" + "CODE = " + ((lovScr.gettxtCode() != null) ?  "'" + lovScr.gettxtCode() + "'" : "NULL"));
        super.setColumnsValues(",\n\t" + "SUB_TYPE = " + ((lovScr.gettxtSubType() != null) ?  "'" + lovScr.gettxtSubType() + "'" : "NULL"));
        super.setColumnsValues(",\n\t" + "DESC_TEXT = " + ((lovScr.gettxtDescription() != null) ?  "'" + lovScr.gettxtDescription() + "'" : "NULL"));
        
        super.setCondition("ROW_ID = '" + lovScr.gettxtRowId() + "'");
        
        try{
            this.clearCount();
            this.setCount(super.updateRecord(super.getTblLstOfVal(), super.getColumnsValues(), super.getCondition()));
            if(this.getCount() > 0){
                this.setLastLOVUpd(lovScr.gettxtRowId());   
                this.fillList(null, "UPDATE_RECORD");
                super.clearColumnsValues();
                super.clearCondition();
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
    
    private void save() {
        if(validateMandatoryFields() && validateFieldValues()){
            DefaultTableModel table = (DefaultTableModel) lovScr.getTableModel();
            table.getRowCount();
            try{
                ArrayList<ListOfValuesClass> lovList = queryListOfValues("SELECT *\nFROM " + getDbOwner() + "." + getTblLstOfVal() + "\nWHERE ROW_ID = '" + lovScr.gettxtRowId() + "'");

                if(lovList.size() > 0) {
                    if(update()){
                        lovScr.enableFields("SALVAR");
                    }
                } else {
                    if(insert()){
                        lovScr.enableFields("SALVAR");

                        boolean foundRow = true;
                        int i = 0;
                        int o = lovScr.getNumOfListRows();
                        do {
                            if(i < o){
                                try{                                    
                                    if(getLastLOVAdd().equals(lovRowIdArray.get(i).getRowId())){
                                        lovScr.setSelectedRowColumnList(i, 0);
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
                lovScr.setlblRecCount((lovScr.getSelectedRowList() + 1) + " - " + String.valueOf(lovRowIdArray.size()));
            } catch(Exception e) {
                System.out.println(getDateTime() + "\tContactModule.ContactController\t\tSaveSocialMedia\tInsertUpdateSocialMedia\tError Exception\tError: " + e);
            }
        }
    }
    
    public boolean delete(){
        int countLOV = 0;
        
        if(super.wishDeleteRecord()){
            if(validateBeforeDelete()){
                super.clearCondition();
                super.setCondition("ROW_ID = '" + lovRowIdArray.get(lovScr.getSelectedRowList()).getRowId() + "'");
                try{
                    countLOV = super.deleteRecord(super.getTblLstOfVal(), super.getCondition());
                    if(countLOV > 0){
                        lovRowIdArray.remove(lovScr.getSelectedRowList());
                        lovScr.removeRowFromList(lovScr.getSelectedRowList());
                        JOptionPane.showMessageDialog(null, "Registro(s) removido(s) com sucesso! Total de registros removidos: " + countLOV + " registro(s)");
                        super.clearCondition();
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
        } else {
            return false;
        }
    }
    
    private class buttonEdit implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            lovScr.enableFields("EDITAR");
            lovScr.setFocus("NAME");
        }
    }
    
    private class buttonNew implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            lovScr.enableFields("NOVO");
            lovScr.clearFields();
            lovScr.clearComboBoxes();
            lovScr.insertSelectComboBox();
            fillComboBoxes("LOV_FILTER");
            fillComboBoxes("LOV_TYPE");
            fillComboBoxes("LANG_TYPE");
            fillFieldsNewRecord();
            lovScr.setFocus("TYPE");
        }
    }
    
    private class buttonSave implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            save();
            //lovScr.enableFields("SALVAR");
        }
    }
    
    private class buttonCancel implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            lovScr.enableFields("CANCELAR");
            lovScr.clearFields();
            if(lovScr.getSelectedRowList() >= 0){
                fillFields("SELECT *\nFROM " + getDbOwner() + "." + getTblLstOfVal() + " LOV\nWHERE LOV.ROW_ID = '" + lovRowIdArray.get(lovScr.getSelectedRowList()).getRowId() + "'");
            }            
            lovScr.setFocus("FILTRO_VALOR");
        }
    }
    
    private class buttonDelete implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            //DefaultTableModel table = (DefaultTableModel) lovScr.getTableModel();
            if(delete()){
                lovScr.enableFields("DELETAR");
                lovScr.clearFields();
                lovScr.setFocus("FILTRO_VALOR");
            } else {
                lovScr.enableFields("CANCELAR");
                lovScr.setFocus("FILTRO_VALOR");
            }
        }
    }

    private class buttonQuery implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            lovScr.enableFields("QUERY");
            lovScr.clearFields();
            lovScr.setcbbLOVTypeItemIndex(0);
            lovScr.setcbbLanguageItemIndex(1);
            lovScr.setckbActiveFlg("Y");
            lovScr.setFocus("ID");
        }
        
    }
    
    private class buttonGoQuery implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            String condition = "";
            lovScr.enableFields("GO_QUERY");
            lovScr.unselectRowList();
            //lovScr.setFocus("TYPE");
            if(lovScr.gettxtRowId() != null || lovScr.getcbbLOVType() != null || lovScr.gettxtName() != null || lovScr.gettxtValue() != null || lovScr.gettxtOrder() != null || lovScr.gettxtReplicationLevel() != null || lovScr.gettxtCode() != null || lovScr.gettxtSubType() != null || lovScr.gettxtDescription() != null){
                if(lovScr.gettxtRowId() != null){ condition += ((!"".equals(condition)) ? "AND " + processFilterCondition("Id", lovScr.gettxtRowId(), "LOV_FILTER", "LOV") : processFilterCondition("Id", lovScr.gettxtRowId(), "LOV_FILTER", "LOV")); }
                if(lovScr.getcbbLOVType() != null){ condition += ((!"".equals(condition)) ? "AND " + processFilterCondition("Tipo", lovScr.getcbbLOVType(), "LOV_FILTER", "LOV") : processFilterCondition("Tipo", lovScr.getcbbLOVType(), "LOV_FILTER", "LOV")); }
                if(lovScr.gettxtName() != null){ condition += ((!"".equals(condition)) ? "AND " + processFilterCondition("Nome", lovScr.gettxtName(), "LOV_FILTER", "LOV") : processFilterCondition("Nome", lovScr.gettxtName(), "LOV_FILTER", "LOV")); }
                if(lovScr.gettxtValue() != null){ condition += ((!"".equals(condition)) ? "AND " + processFilterCondition("Exibir Valor", lovScr.gettxtValue(), "LOV_FILTER", "LOV") : processFilterCondition("Exibir Valor", lovScr.gettxtValue(), "LOV_FILTER", "LOV")); }                
                if(lovScr.gettxtOrder() != null){ condition += ((!"".equals(condition)) ? "AND " + processFilterCondition("Ordem", lovScr.gettxtOrder(), "LOV_FILTER", "LOV") : processFilterCondition("Ordem", lovScr.gettxtOrder(), "LOV_FILTER", "LOV")); }
                if(lovScr.gettxtReplicationLevel() != null){ condition += ((!"".equals(condition)) ? "AND " + processFilterCondition("Nível de Replicação", lovScr.gettxtReplicationLevel(), "LOV_FILTER", "LOV") : processFilterCondition("Nível de Replicação", lovScr.gettxtReplicationLevel(), "LOV_FILTER", "LOV")); }
                if(lovScr.gettxtCode() != null){ condition += ((!"".equals(condition)) ? "AND " + processFilterCondition("Código", lovScr.gettxtCode(), "LOV_FILTER", "LOV") : processFilterCondition("Código", lovScr.gettxtCode(), "LOV_FILTER", "LOV")); }
                if(lovScr.gettxtSubType() != null){ condition += ((!"".equals(condition)) ? "AND " + processFilterCondition("Subtipo", lovScr.gettxtSubType(), "LOV_FILTER", "LOV") : processFilterCondition("Subtipo", lovScr.gettxtSubType(), "LOV_FILTER", "LOV")); }
                if(lovScr.gettxtDescription() != null){ condition += ((!"".equals(condition)) ? "AND " + processFilterCondition("Descrição", lovScr.gettxtDescription(), "LOV_FILTER", "LOV") : processFilterCondition("Descrição", lovScr.gettxtDescription(), "LOV_FILTER", "LOV")); }
                if(lovScr.getcbbLanguage() != null){ condition += ((!"".equals(condition)) ? "AND " + processFilterCondition("Idioma", LookupLangCodeByValue(lovScr.getcbbLanguage()), "LOV_FILTER", "LOV") : processFilterCondition("Idioma", LookupLangCodeByValue(lovScr.getcbbLanguage()), "LOV_FILTER", "LOV")); }
                condition += ((!"".equals(condition)) ? "AND " + processFilterCondition("Ativo", lovScr.getckbActiveFlg(), "LOV_FILTER", "LOV") : processFilterCondition("Ativo", lovScr.getckbActiveFlg(), "LOV_FILTER", "LOV"));
                
                fillList(
                    "SELECT *\n" +
                    "FROM " + getDbOwner() + "." + getTblLstOfVal() + " LOV\n" +
                    "WHERE " + condition +
                    "ORDER BY LOV.TYPE, LOV.ORDER_BY, LOV.NAME, LOV.VAL ASC", ""
                );
            } else {
                fillList("SELECT *\nFROM " + getDbOwner() + "." + getTblLstOfVal() + " LOV\nWHERE LOV.ACTIVE_FLG = '" + lovScr.getckbActiveFlg() + "'\nAND LOV.LANG_ID = '" + LookupLangCodeByValue(lovScr.getcbbLanguage()) + "'\nORDER BY LOV.TYPE, LOV.NAME, LOV.VAL, LOV.ORDER_BY ASC", "");
            }
            lovScr.setSelectedRowColumnList(0, 0);
        }
        
    }
    
    private class ListSelected implements ListSelectionListener {
        
        private int count;

        private ListSelected() {
            this.count = 0;
        }
        
        @Override
        public void valueChanged(ListSelectionEvent lse) {
            if(count < 1){
                lovScr.clearFields();
                fillFields("SELECT *\nFROM " + getDbOwner() + "." + getTblLstOfVal() + "\nWHERE ROW_ID = '" + lovRowIdArray.get(lovScr.getSelectedRowList()).getRowId() + "'");
                lovScr.setlblRecCount((lovScr.getSelectedRowList() + 1) + " - " + String.valueOf(lovRowIdArray.size()));
                lovScr.setbtnEditEnabled(true);
                lovScr.setbtnDeleteEnabled(true);
                count++;
            } else {
                count = 0;
            }
        }
        
    }
    
    private class LOVRowIdClass {
        private String rowId;

        public LOVRowIdClass() {
            this.rowId = null;
        }

        public String getRowId() { return rowId; }
        public void setRowId(String rowId) { this.rowId = rowId; }
        
        
    }

    private class KeyEventString implements java.awt.event.KeyListener {

        @Override
        public void keyTyped(KeyEvent ke) {            
            String chr = String.valueOf(ke.getKeyChar());
            try{
                Integer.valueOf(chr);
            } catch (NumberFormatException e){
                //ke.consume();
                JOptionPane.showMessageDialog(null, "String");
            }
        }

        @Override
        public void keyPressed(KeyEvent ke) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void keyReleased(KeyEvent ke) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
    
    private class TxtOrderKeyEvent implements java.awt.event.KeyListener {

        @Override
        public void keyTyped(KeyEvent ke) {
            String chr = String.valueOf(ke.getKeyChar());
            try{
                Integer.valueOf(chr);
                //JOptionPane.showMessageDialog(null, "Integer");
                if(lovScr.gettxtOrder() != null) {
                    if(lovScr.gettxtOrder().length() > (getLOVOrderSize() - 1)) {
                        if((ke.getKeyCode() != KeyEvent.VK_ENTER) || (ke.getKeyCode() != KeyEvent.VK_TAB)){
                            //JOptionPane.showMessageDialog(null, "Passou de 22");
                            ke.consume();
                        }                        
                    }
                }                
            } catch (NumberFormatException e){
                ke.consume();
            }            
        }

        @Override
        public void keyPressed(KeyEvent ke) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void keyReleased(KeyEvent ke) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
    
    private class TxtListFilterValue implements java.awt.event.KeyListener {

        @Override
        public void keyTyped(KeyEvent ke) { }

        @Override
        public void keyPressed(KeyEvent ke) {
            if(ke.getKeyCode() == KeyEvent.VK_ENTER){
                lovScr.unselectRowList();
                if(lovScr.getcbbListFilter() != null && lovScr.gettxtListFilterValue() != null) {
                    fillList(
                        "SELECT *\n" +
                        "FROM " + getDbOwner() + "." + getTblLstOfVal() + " LOV\n" +
                        "WHERE " + processFilterCondition(lovScr.getcbbListFilter(), lovScr.gettxtListFilterValue(), "LOV_FILTER", "LOV") +
                        "ORDER BY LOV.TYPE, LOV.ORDER_BY, LOV.NAME, LOV.VAL ASC", ""
                    );
                } else {
                    fillList("SELECT *\nFROM " + getDbOwner() + "." + getTblLstOfVal() + " LOV\nORDER BY LOV.TYPE, LOV.NAME, LOV.VAL, LOV.ORDER_BY ASC", "");
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent ke) { }
        
    }
    
    private class CbbListFilterItemState implements java.awt.event.ItemListener {

        @Override
        public void itemStateChanged(ItemEvent ie) {
            if(ie.getStateChange() == ItemEvent.SELECTED){
                if(lovScr.getcbbListFilter() == null) {
                    lovScr.cleartxtListFilterValue();
                }
                lovScr.setFocus("FILTRO_VALOR");
            }
        }
        
    }
    
}
