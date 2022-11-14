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
public class LanguageController extends DataController {
    LanguageScreen langScr;
    
    private String lastLangAdd;
    private String lastLangUpd;
    private int count;
    private final int LangCodeSize = 5;
    private final int LangNameSize = 50;
    private final int LangValueSize = 50;
    private final int LOVOrderSize = 22;
    
    LangRowIdClass langRowId;
    private ArrayList<LangRowIdClass> langRowIdArray = new ArrayList<>();

    public LanguageController() throws InterruptedException { }
    
    public String getLastLangAdd() { return lastLangAdd; }
    public void setLastLangAdd(String lastLOVAdd) { this.lastLangAdd = lastLOVAdd; }

    public String getLastLangUpd() { return lastLangUpd; }
    public void setLastLangUpd(String lastLOVUpd) { this.lastLangUpd = lastLOVUpd; }
    
    public int getCount() { return count; }
    public void setCount(int count) { this.count += count; }
    public void clearCount() { this.count = 0; }

    public int getLangCodeSize() { return LangCodeSize; }
    public int getLangNameSize() { return LangNameSize; }
    public int getLangValueSize() { return LangValueSize; }
    public int getLangOrderSize() { return LOVOrderSize; }
    
    public void openScreen() {
        langScr = new LanguageScreen();
        langScr.setListenerBtnNew(new buttonNew());
        langScr.setListenerBtnEdit(new buttonEdit());
        langScr.setListenerBtnDelete(new buttonDelete());
        langScr.setListenerBtnSave(new buttonSave());
        langScr.setListenerBtnCancel(new buttonCancel());
        langScr.setListenerBtnQuery(new buttonQuery());
        langScr.setListenerBtnGoQuery(new buttonGoQuery());
        langScr.setListenerTblListSelection(new ListSelected());
        langScr.setListenercbbListFilterValue(new CbbListFilterItemState());
        langScr.setListenertxtListFilterValue(new TxtListFilterValue());
        langScr.setListenertxtOrder(new TxtOrderKeyEvent());
        
        langScr.clearFields();
        langScr.clearFilters();
        langScr.clearComboBoxes();
        langScr.enableFields("LOAD_SCREEN");
        langScr.insertSelectComboBox();
        this.fillComboBoxes("LANG_FILTER");
        fillList("SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblLang() + " LAN\nORDER BY LAN.ORDER_BY ASC", "");
    }

    private void fillComboBoxes(String type){
        try{
            ArrayList<ListOfValuesClass> lov = super.LookupList(type);

            if(lov.size() > 0){
                for(int i = 0; i < lov.size(); i++){
                    if(null == type){
                        JOptionPane.showMessageDialog(null, "O LOV_TYPE 'null' não existe!");
                    } else switch (type) {
                        case "LANG_FILTER":
                            langScr.setcbbListFilter(lov.get(i).getValue());
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "O LOV_TYPE '" + type +  "' não é utilizado por nenhum ComboBox!");
                            break;
                    }
                }
            }
            
        } catch(HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher ComboBoxes...\nErro: " + e);
        }
    }
    
    private void fillList(String query, String method){
        DefaultTableModel table = (DefaultTableModel) langScr.getTableModel();
        int countRecord = 0;
        switch(method){
            case "INSERT_RECORD":
                int newRow = table.getRowCount() + 1;
                //table.setRowCount(newRow);
                try{
                    table.addRow(new Object[] {
                            langScr.gettxtCode(),
                            langScr.gettxtName(),
                            langScr.gettxtValue(),
                            langScr.gettxtOrder()
                        }
                    );
                } catch(Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro ao preencher tabela...\nErro: " + e);
                }
                break;
            case "UPDATE_RECORD":
                try{
                    table.setValueAt(langScr.gettxtCode(), langScr.getSelectedRowList(), 0);
                    table.setValueAt(langScr.gettxtName(), langScr.getSelectedRowList(), 1);
                    table.setValueAt(langScr.gettxtValue(), langScr.getSelectedRowList(), 2);
                    table.setValueAt(langScr.gettxtOrder(), langScr.getSelectedRowList(), 3);
                } catch(Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro ao preencher tabela...\nErro: " + e);
                }
                break;
            default:
                try{
                    ArrayList<LanguageClass> langList = super.queryLanguageRecord(query);
                    
                    try{ langScr.setListRowCount(0); } catch (Exception e) {}
                    
                    try{ langRowIdArray.clear(); } catch (Exception e) {}

                    if(langList.size() > 0){
                        try{ table.setRowCount(langList.size()); } catch (Exception e) {}
                        try{ table.setNumRows(langList.size()); } catch (Exception e) {}
                        
                        for(int i = 0; i < langList.size(); i++){
                            langRowId = new LangRowIdClass();
                            langRowId.setRowId(langList.get(i).getRow_id());

                            langRowIdArray.add(langRowId);
                            table.setValueAt(langList.get(i).getLANG_CD(), i, 0);
                            table.setValueAt(langList.get(i).getNAME(), i, 1);
                            table.setValueAt(langList.get(i).getVALUE(), i, 2);
                            table.setValueAt(langList.get(i).getORDER_BY(), i, 3);

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
        langScr.setlblRecCount("0 - " + String.valueOf(langRowIdArray.size()));
    }
    
    private void fillFields(String query) {
        try{
            ArrayList<LanguageClass> lovList = super.queryLanguageRecord(query);
        
            if(lovList.size() > 0){
                for(int i = 0; i < lovList.size(); i++){
                    langScr.settxtRowId(lovList.get(i).getRow_id());
                    langScr.settxtCode(lovList.get(i).getLANG_CD());
                    langScr.settxtName(lovList.get(i).getNAME());
                    langScr.settxtValue(lovList.get(i).getVALUE());
                    langScr.settxtOrder(lovList.get(i).getORDER_BY());
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher Campos...\nErro: " + e);
        }
    }
    
    public void fillFieldsNewRecord(){
        langScr.settxtRowId(getNextRowId());
    }
        
    private boolean validateMandatoryFields(){
        String mensagem = "";
        int i = 0;
        
        if(langScr.gettxtCode() == null) { mensagem += "\n- " + "Código" + ";"; i = (i < 1) ? 1 : i; }
        if(langScr.gettxtName() == null) { mensagem += "\n- " + "Nome" + ";"; i = (i < 2 && i != 0) ? i : 2; }
        if(langScr.gettxtValue() == null) { mensagem += "\n- " + "Valor" + ";"; i = (i < 3 && i != 0) ? i : 3; }
        
        switch(i){
            case 1:
                langScr.setFocus("CODE");
                break;
            case 2:
                langScr.setFocus("NAME");
                break;
            case 3:
                langScr.setFocus("VAL");
                break;
            default:
                break;
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
        if((langScr.gettxtCode() != null) && (langScr.gettxtCode().length() > getLangCodeSize())) { JOptionPane.showMessageDialog(null, "O tamanho do campo 'Código' deve ter no máximo: " + getLangCodeSize() + " caractere(s)"); return false; }
        if((langScr.gettxtName() != null) && (langScr.gettxtName().length() > getLangNameSize())) { JOptionPane.showMessageDialog(null, "O tamanho do campo 'Nome' deve ter no máximo: " + getLangNameSize() + " caractere(s)"); return false; }
        if((langScr.gettxtValue() != null) && (langScr.gettxtValue().length() > getLangValueSize())) { JOptionPane.showMessageDialog(null, "O tamanho do campo 'Valor' deve ter no máximo: " + getLangValueSize() + " caractere(s)"); return false; }
        if((langScr.gettxtOrder() != null) && (langScr.gettxtOrder().length() > getLangOrderSize())) { JOptionPane.showMessageDialog(null, "O tamanho do campo 'Ordem' deve ter no máximo: " + getLangOrderSize() + " caractere(s)"); return false; }
        
        // Validate Field Types
        if (langScr.gettxtOrder() != null) {
            try{ Integer.valueOf(langScr.gettxtOrder()); } catch (NumberFormatException e) { JOptionPane.showMessageDialog(null, "O campo 'Ordem' deve ser do tipo numérico."); return false; }
        }
        
        // Validate if values exists
        super.clearCondition();
        super.setCondition("LANG_CD = '" + langScr.gettxtCode() + "'");
        super.setCondition("\nAND " + "NAME = '" + langScr.gettxtName() + "'");
        super.setCondition("\nAND " + "VALUE = '" + langScr.gettxtValue() + "'");
        super.setCondition("\nAND " + "ROW_ID <> '" + langScr.gettxtRowId() + "'");
        
        countUniqueValue = super.queryTableCount(super.getTblLang(), super.getCondition());
        
        if(countUniqueValue > 0) {
            JOptionPane.showMessageDialog(null, "Um registro que contém valores idênticos ao que você criou já existe.\n\nSe você deseja criar um novo registro, certifique-se que os campos tenham valores únicos.");
            return false;
        }
        
        return true;
    }
        
    private boolean insert(){
        String lovId = super.getNextRowId();
        super.clearColumns();
        super.clearValues();
        super.setColumns(",\n\t" + "LANG_CD"); super.setValues(",\n\t" + ((langScr.gettxtCode() != null) ? "'" + langScr.gettxtCode() + "'" : "NULL"));
        super.setColumns(",\n\t" + "NAME"); super.setValues(",\n\t" + ((langScr.gettxtName() != null) ? "'" + langScr.gettxtName() + "'" : "NULL"));
        super.setColumns(",\n\t" + "VALUE"); super.setValues(",\n\t" + ((langScr.gettxtValue() != null) ? "'" + langScr.gettxtValue() + "'" : "NULL"));
        super.setColumns(",\n\t" + "ORDER_BY"); super.setValues(",\n\t" + ((langScr.gettxtOrder() != null) ? langScr.gettxtOrder() : "NULL"));
        
        try {
            if("true".equals(super.insertRecord(super.getTblLang(), super.getColumns(), super.getValues()))){
                langRowId = new LangRowIdClass();
                langRowId.setRowId(lovId);
                langRowIdArray.add(langRowId);
                this.setLastLangAdd(lovId);
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
        super.setColumnsValues(",\n\t" + "MODIFICATION_NUM = (SELECT MODIFICATION_NUM + 1 FROM " + super.getDbOwner() + "." + super.getTblLang() + " WHERE ROW_ID = '" + langScr.gettxtRowId() + "')");
        super.setColumnsValues(",\n\t" + "LANG_CD = " + ((langScr.gettxtCode() != null) ?  "'" + langScr.gettxtCode() + "'" : "NULL"));
        super.setColumnsValues(",\n\t" + "NAME = " + ((langScr.gettxtName() != null) ?  "'" + langScr.gettxtName() + "'" : "NULL"));
        super.setColumnsValues(",\n\t" + "VALUE = " + ((langScr.gettxtValue() != null) ?  "'" + langScr.gettxtValue() + "'" : "NULL"));    
        super.setColumnsValues(",\n\t" + "ORDER_BY = " + ((langScr.gettxtOrder() != null) ? langScr.gettxtOrder() : "NULL"));
        
        super.setCondition("ROW_ID = '" + langScr.gettxtRowId() + "'");
        
        try{
            this.clearCount();
            this.setCount(super.updateRecord(super.getTblLang(), super.getColumnsValues(), super.getCondition()));
            if(this.getCount() > 0){
                this.setLastLangUpd(langScr.gettxtRowId());   
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
            DefaultTableModel table = (DefaultTableModel) langScr.getTableModel();
            table.getRowCount();
            try{
                ArrayList<LanguageClass> langList = queryLanguageRecord("SELECT *\nFROM " + getDbOwner() + "." + getTblLang() + "\nWHERE ROW_ID = '" + langScr.gettxtRowId() + "'");

                if(langList.size() > 0) {
                    if(update()){
                        langScr.enableFields("SALVAR");
                    }
                } else {
                    if(insert()){
                        langScr.enableFields("SALVAR");

                        boolean foundRow = true;
                        int i = 0;
                        int o = langScr.getNumOfListRows();
                        do {
                            if(i < o){
                                try{                                    
                                    if(getLastLangAdd().equals(langRowIdArray.get(i).getRowId())){
                                        langScr.setSelectedRowColumnList(i, 0);
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
                langScr.setlblRecCount((langScr.getSelectedRowList() + 1) + " - " + String.valueOf(langRowIdArray.size()));
            } catch(Exception e) {
                System.out.println(getDateTime() + "\tContactModule.ContactController\t\tSaveSocialMedia\tInsertUpdateSocialMedia\tError Exception\tError: " + e);
            }
        }
    }
    
    public boolean delete(){
        int countLang = 0;
        
        if(super.wishDeleteRecord()){
            super.clearCondition();
            super.setCondition("ROW_ID = '" + langRowIdArray.get(langScr.getSelectedRowList()).getRowId() + "'");
            try{
                countLang = super.deleteRecord(super.getTblLang(), super.getCondition());
                if(countLang > 0){
                    langRowIdArray.remove(langScr.getSelectedRowList());
                    langScr.removeRowFromList(langScr.getSelectedRowList());
                    JOptionPane.showMessageDialog(null, "Registro(s) removido(s) com sucesso! Total de registros removidos: " + countLang + " registro(s)");
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
    }
    
    private class buttonEdit implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            langScr.enableFields("EDITAR");
            langScr.setFocus("NAME");
        }
    }
    
    private class buttonNew implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            langScr.enableFields("NOVO");
            langScr.clearFields();
            langScr.clearComboBoxes();
            langScr.insertSelectComboBox();
            fillComboBoxes("LANG_FILTER");
            fillFieldsNewRecord();
            langScr.setFocus("TYPE");
        }
    }
    
    private class buttonSave implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            save();
        }
    }
    
    private class buttonCancel implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            langScr.enableFields("CANCELAR");
            langScr.clearFields();
            if(langScr.getSelectedRowList() >= 0){
                fillFields("SELECT *\nFROM " + getDbOwner() + "." + getTblLang() + " LAN\nWHERE LAN.ROW_ID = '" + langRowIdArray.get(langScr.getSelectedRowList()).getRowId() + "'");
            }            
            langScr.setFocus("FILTRO_VALOR");
        }
    }
    
    private class buttonDelete implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            DefaultTableModel table = (DefaultTableModel) langScr.getTableModel();
            //System.out.println("Item selectionado: " + langScr.getSelectedRowList());
            if(delete()){
                langScr.enableFields("DELETAR");
                langScr.clearFields();
                langScr.setFocus("FILTRO_VALOR");
            } else {
                langScr.enableFields("CANCELAR");                
                langScr.setFocus("FILTRO_VALOR");
            }
        }
    }

    private class buttonQuery implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            langScr.enableFields("QUERY");
            langScr.clearFields();
            langScr.setFocus("ID");
        }
        
    }
    
    private class buttonGoQuery implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            String condition = "";
            langScr.enableFields("GO_QUERY");
            langScr.unselectRowList();
            //lovScr.setFocus("TYPE");
            if(langScr.gettxtRowId() != null || langScr.gettxtCode() != null || langScr.gettxtName() != null || langScr.gettxtValue() != null || langScr.gettxtOrder() != null ){
                if(langScr.gettxtRowId() != null){ condition += ((!"".equals(condition)) ? "AND " + processFilterCondition("Id", langScr.gettxtRowId(), "LANG_FILTER", "LAN") : processFilterCondition("Id", langScr.gettxtRowId(), "LANG_FILTER", "LAN")); }
                if(langScr.gettxtCode() != null){ condition += ((!"".equals(condition)) ? "AND " + processFilterCondition("Código", langScr.gettxtCode(), "LANG_FILTER", "LAN") : processFilterCondition("Código", langScr.gettxtCode(), "LANG_FILTER", "LAN")); }
                if(langScr.gettxtName() != null){ condition += ((!"".equals(condition)) ? "AND " + processFilterCondition("Nome", langScr.gettxtName(), "LANG_FILTER", "LAN") : processFilterCondition("Nome", langScr.gettxtName(), "LANG_FILTER", "LAN")); }
                if(langScr.gettxtValue() != null){ condition += ((!"".equals(condition)) ? "AND " + processFilterCondition("Valor", langScr.gettxtValue(), "LANG_FILTER", "LAN") : processFilterCondition("Valor", langScr.gettxtValue(), "LANG_FILTER", "LAN")); }                
                if(langScr.gettxtOrder() != null){ condition += ((!"".equals(condition)) ? "AND " + processFilterCondition("Ordem", langScr.gettxtOrder(), "LANG_FILTER", "LAN") : processFilterCondition("Ordem", langScr.gettxtOrder(), "LANG_FILTER", "LAN")); }
                
                fillList(
                    "SELECT *\n" +
                    "FROM " + getDbOwner() + "." + getTblLang() + " LAN\n" +
                    "WHERE " + condition +
                    "ORDER BY LAN.ORDER_BY ASC", ""
                );
            } else {
                fillList("SELECT *\nFROM " + getDbOwner() + "." + getTblLang() + " LAN\nORDER BY LAN.ORDER_BY ASC", "");
            }
            langScr.setSelectedRowColumnList(0, 0);
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
                langScr.clearFields();
                fillFields("SELECT *\nFROM " + getDbOwner() + "." + getTblLang() + "\nWHERE ROW_ID = '" + langRowIdArray.get(langScr.getSelectedRowList()).getRowId() + "'");
                langScr.setlblRecCount((langScr.getSelectedRowList() + 1) + " - " + String.valueOf(langRowIdArray.size()));
                langScr.setbtnEditEnabled(true);
                langScr.setbtnDeleteEnabled(true);
                count++;
            } else {
                count = 0;
            }
        }
        
    }
    
    private class LangRowIdClass {
        private String rowId;

        public LangRowIdClass() {
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
                if(langScr.gettxtOrder() != null) {
                    if(langScr.gettxtOrder().length() > (getLangOrderSize() - 1)) {
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
                langScr.unselectRowList();
                if(langScr.getcbbListFilter() != null && langScr.gettxtListFilterValue() != null) {
                    fillList("SELECT *\n" +
                        "FROM " + getDbOwner() + "." + getTblLang() + " LAN\n" +
                        "WHERE " + processFilterCondition(langScr.getcbbListFilter(), langScr.gettxtListFilterValue(), "LANG_FILTER", "LAN") +
                        "ORDER BY LAN.ORDER_BY ASC", ""
                    );
                } else {
                    fillList("SELECT *\nFROM " + getDbOwner() + "." + getTblLang() + " LAN\nORDER BY LAN.ORDER_BY ASC", "");
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
                if(langScr.getcbbListFilter() == null) {
                    langScr.cleartxtListFilterValue();
                }
                langScr.setFocus("FILTRO_VALOR");
            }
        }
        
    }
    
}
