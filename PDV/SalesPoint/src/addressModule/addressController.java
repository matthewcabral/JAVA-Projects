/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressModule;

import databaseModule.DataController;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import org.json.JSONObject;

/**
 *
 * @author MatheusCabral
 */
public class AddressController extends DataController {

    AddressScreen addrScr;
    addressRowIdClass addrRowId;
    private ArrayList<addressRowIdClass> addrRowIdArray = new ArrayList<>();
    private ArrayList<zipcode> cepList;

    private String userId;
    private String accountId;
    private String openFromScreen;
    private String lastAddrAdd;
    private String lastAddrUpd;
    private int count;
    private String oldPrimaryAddrId = null;

    public AddressController() throws InterruptedException {
        this.cepList = null;
    }

    public void setListenerAddressScreen(WindowListener listener) { addrScr.addWindowListener(listener); }
    
    public ArrayList<addressRowIdClass> getAddressRowIdArray() { return this.addrRowIdArray; }
    
    public void clearAddressRowIdArray() { this.addrRowIdArray.clear(); }
    
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getAccountId() { return accountId; }
    public void setAccountId(String accountId) { this.accountId = accountId; }

    public String getOpenFromScreen() { return openFromScreen; }
    public void setOpenFromScreen(String openFromScreen) { this.openFromScreen = openFromScreen; }

    public String getLastAddrAdd() { return lastAddrAdd; }
    public void setLastAddrAdd(String lastAddrAdd) { this.lastAddrAdd = lastAddrAdd; }
    
    public String getLastAddrUpd() { return lastAddrUpd; }
    public void setLastAddrUpd(String lastAddrUpd) { this.lastAddrUpd = lastAddrUpd; }

    public int getCount() { return count; }
    public void setCount(int count) { this.count = count; }
    public void clearCount() { this.count = 0; }

    public String getOldPrimaryAddrId() { return oldPrimaryAddrId; }
    public void setOldPrimaryAddrId(String oldPrimaryAddrId) { this.oldPrimaryAddrId = oldPrimaryAddrId; }
    
    public void openAddressScreen(String query, String function) {
        if(this.getOpenFromScreen() != null && !"".equals(this.getOpenFromScreen())){
            switch(this.getOpenFromScreen()){
                case "USER":
                    switch(function){
                        case "NEW_USER_ADDRESS":
                            addrScr = new AddressScreen();
                            addrScr.setListenerBtnNew(new newAddress());
                            addrScr.setListenerBtnEdit(new editAddress());
                            addrScr.setListenerBtnSave(new saveAddress());
                            addrScr.setListenerBtnCancel(new cancelAddress());
                            addrScr.setListenerBtnDelete(new deleteAddress());
                            addrScr.setListenerBtnSearch(new searchAddress());
                            addrScr.setListenerTblAddressListSelection(new addressListSelected());
                            this.setListenerAddressScreen(new addressScreenListener());
                            addrScr.enableFields("LOAD_SCREEN", this.getOpenFromScreen());
                            //addrScr.setListenerAddressScreen(new addressScreenListener());
                            break;
                        default:
                            break;
                    }                    
                    break;
                case "ACCOUNT":
                    switch(function){
                        case "NEW_ACCOUNT_ADDRESS":
                            addrScr = new AddressScreen();
                            addrScr.setListenerBtnNew(new newAddress());
                            addrScr.setListenerBtnEdit(new editAddress());
                            addrScr.setListenerBtnSave(new saveAddress());
                            addrScr.setListenerBtnCancel(new cancelAddress());
                            addrScr.setListenerBtnDelete(new deleteAddress());
                            addrScr.setListenerBtnSearch(new searchAddress());
                            addrScr.setListenerTblAddressListSelection(new addressListSelected());
                            this.setListenerAddressScreen(new addressScreenListener());
                            addrScr.enableFields("LOAD_SCREEN", this.getOpenFromScreen());
                            //addrScr.setListenerAddressScreen(new addressScreenListener());
                            break;
                        default:
                            break;
                    }                    
                    break;
                default:
                    break;
            }
        }
        addrScr.clearFields();
        addrScr.clearComboBoxes();        
        addrScr.insertSelectComboBox();
        
        this.fillComboBoxes("STREET_TYPE");
        this.fillComboBoxes("CITY_ZONE");
        this.fillComboBoxes("STATE");
        this.fillComboBoxes("COUNTRY");
        this.fillComboBoxes("PROPERTY_TYPE");
        
        this.fillList(query, "LOAD");
    }

    public void fillComboBoxes(String LovType) {
        try{
            ArrayList<ListOfValuesClass> lov = super.LookupList(LovType);
            
            if(lov.size() > 0){
                for(int i = 0; i < lov.size(); i++){
                    if(null == LovType){
                        JOptionPane.showMessageDialog(null, "O LOV_TYPE 'null' não existe!");
                    } else switch (LovType) {
                        case "STREET_TYPE":
                            addrScr.setcbbAddressType(lov.get(i).getValue());
                            break;
                        case "CITY_ZONE":
                            addrScr.setcbbAddressZone(lov.get(i).getValue());
                            break;
                        case "STATE":
                            addrScr.setcbbAddressState(lov.get(i).getValue());
                            break;
                        case "COUNTRY":
                            addrScr.setcbbAddressCountry(lov.get(i).getValue());
                            break;
                        case "PROPERTY_TYPE":
                            addrScr.setcbbHomeType(lov.get(i).getValue());
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "O LOV_TYPE '" + LovType +  "' não é utilizado por nenhum ComboBox!");
                            break;
                    }
                }
            }
        } catch(HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher ComboBoxes...\nErro: " + e);
        }
    }
    
    public void fillList(String query, String method) {
        DefaultTableModel table = (DefaultTableModel) addrScr.getTableModel();
        int countRecord = 0;
        switch(method){
            case "INSERT_RECORD":
                int newRow = table.getRowCount() + 1;
                //table.setRowCount(newRow);
                try{
                    table.addRow(
                        new Object[] {
                            addrScr.gettxtRowId(),
                            ("Y".equals(addrScr.getckbMainAddress())),
                            addrScr.getcbbAddressType(),
                            addrScr.gettxtAddressName(),
                            addrScr.gettxtAddressNumber(),
                            addrScr.gettxtAddressComplement(),
                            addrScr.gettxtNeighborhood(),
                            addrScr.getcbbAddressZone(),
                            addrScr.gettxtAddressCity(),
                            addrScr.getcbbAddressState(),
                            addrScr.getcbbAddressCountry(),
                            addrScr.getcbbHomeType(),
                            addrScr.gettxtHomeFloor(),
                            addrScr.gettxtHomeNumber(),
                            addrScr.gettxtHomeBlock(),
                            addrScr.gettxtComments()                        }
                    );
                } catch(Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro ao preencher tabela...\nErro: " + e);
                }
                break;
            case "UPDATE_RECORD":
                try{
                    table.setValueAt(addrScr.gettxtRowId(), addrScr.getSelectedRowList(), 0);
                    table.setValueAt(("Y".equals(addrScr.getckbMainAddress())), addrScr.getSelectedRowList(), 1);
                    table.setValueAt(addrScr.getcbbAddressType(), addrScr.getSelectedRowList(), 2);
                    table.setValueAt(addrScr.gettxtAddressName(), addrScr.getSelectedRowList(), 3);
                    table.setValueAt(addrScr.gettxtAddressNumber(), addrScr.getSelectedRowList(), 4);
                    table.setValueAt(addrScr.gettxtAddressComplement(), addrScr.getSelectedRowList(), 5);
                    table.setValueAt(addrScr.gettxtNeighborhood(), addrScr.getSelectedRowList(), 6);
                    table.setValueAt(addrScr.getcbbAddressZone(), addrScr.getSelectedRowList(), 7);
                    table.setValueAt(addrScr.gettxtAddressCity(), addrScr.getSelectedRowList(), 8);                    
                    table.setValueAt(addrScr.getcbbAddressState(), addrScr.getSelectedRowList(), 9);
                    table.setValueAt(addrScr.getcbbAddressCountry(), addrScr.getSelectedRowList(), 10);
                    table.setValueAt(addrScr.getcbbHomeType(), addrScr.getSelectedRowList(), 11);
                    table.setValueAt(addrScr.gettxtHomeFloor(), addrScr.getSelectedRowList(), 12);
                    table.setValueAt(addrScr.gettxtHomeNumber(), addrScr.getSelectedRowList(), 13);
                    table.setValueAt(addrScr.gettxtHomeBlock(), addrScr.getSelectedRowList(), 14);
                    table.setValueAt(addrScr.gettxtComments(), addrScr.getSelectedRowList(), 15);
                } catch(Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro ao preencher tabela...\nErro: " + e);
                }
                break;
            default:
                try{
                    ArrayList<AddressClass> addrList = super.queryAddressRecord(query);

                    try{ addrRowIdArray.clear(); } catch (Exception e) {}

                    if(addrList.size() > 0){
                        try{ table.setRowCount(addrList.size()); } catch (Exception e) {}
                        try{ table.setNumRows(addrList.size()); } catch (Exception e) {}

                        for(int i = 0; i < addrList.size(); i++){
                            addrRowId = new addressRowIdClass();
                            addrRowId.setRow_id(addrList.get(i).getRow_id());
                            addrRowIdArray.add(addrRowId);
                            table.setValueAt(addrList.get(i).getRow_id(), i, 0);
                            if("Y".equals(addrList.get(i).getPR_ADDR_FLG())) { table.setValueAt(true, i, 1); } else { table.setValueAt(false, i, 1); }
                            table.setValueAt(super.LookupValue("STREET_TYPE", addrList.get(i).getADDR_TYPE_CD()), i, 2);
                            table.setValueAt(addrList.get(i).getADDR(), i, 3);
                            table.setValueAt(addrList.get(i).getADDR_NUM(), i, 4);
                            table.setValueAt(addrList.get(i).getADDR_LINE_2(), i, 5);
                            table.setValueAt(addrList.get(i).getNEIGHBORHOOD(), i, 6);
                            table.setValueAt(super.LookupName("CITY_ZONE", addrList.get(i).getX_ZONA()), i, 7);
                            table.setValueAt(addrList.get(i).getCITY(), i, 8);                    
                            table.setValueAt(addrList.get(i).getSTATE(), i, 9);
                            table.setValueAt(addrList.get(i).getCOUNTRY(), i, 10);
                            table.setValueAt(super.LookupValue("PROPERTY_TYPE", addrList.get(i).getPROPERTY_TYPE_CD()), i, 11);
                            table.setValueAt(addrList.get(i).getX_ANDAR(), i, 12);
                            table.setValueAt(addrList.get(i).getX_NUM_AP(), i, 13);
                            table.setValueAt(addrList.get(i).getX_COD_BLOCO(), i, 14);
                            table.setValueAt(addrList.get(i).getCOMMENTS(), i, 15);

                            countRecord++;
                        }
                    } else {
                        table.setRowCount(0);
                    }

                    addrScr.setlblRecCount("0 - " + String.valueOf(countRecord));

                } catch(Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro ao preencher tabela...\nErro: " + e);
                }
                break;
        }
        addrScr.setlblRecCount("0 - " + String.valueOf(addrRowIdArray.size()));
    }
    
    private void fillFields(String query) {
        try{
            ArrayList<AddressClass> AddressList = queryAddressRecord(query);
            
            //AddressList = super.queryAddressRecord("SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblAddress() + "\nWHERE PAR_ROW_ID = '" + userList.get(i).getRow_id() +  "'\nAND PR_ADDR_FLG = 'Y'");
            if(AddressList.size() > 0) {
                for(int i = 0; i < AddressList.size(); i++) {
                    addrScr.settxtRowId(AddressList.get(i).getRow_id());
                    addrScr.settxtZipcodePart1(AddressList.get(i).getZIPCODE().substring(0, 5));
                    addrScr.settxtZipcodePart2(AddressList.get(i).getZIPCODE().substring(6, 9));
                    addrScr.setcbbAddressTypeItemIndex(addrScr.getcbbAddressTypeItemIndex(super.LookupValue("STREET_TYPE", AddressList.get(i).getADDR_TYPE_CD())));
                    addrScr.settxtAddressName(AddressList.get(i).getADDR());
                    addrScr.settxtAddressNumber(AddressList.get(i).getADDR_NUM());
                    addrScr.settxtAddressComplement(AddressList.get(i).getADDR_LINE_2());
                    addrScr.setckbMainAddress(AddressList.get(i).getPR_ADDR_FLG());
                    addrScr.settxtNeighborhood(AddressList.get(i).getNEIGHBORHOOD());
                    addrScr.setcbbAddressZoneItemIndex(addrScr.getcbbAddressZoneItemIndex(super.LookupValue("CITY_ZONE", AddressList.get(i).getX_ZONA())));
                    addrScr.settxtAddressCity(AddressList.get(i).getCITY());
                    addrScr.setcbbAddressStateItemIndex(addrScr.getcbbAddressStateItemIndex(AddressList.get(i).getSTATE()));
                    addrScr.setcbbAddressCountryItemIndex(addrScr.getcbbAddressCountryItemIndex(AddressList.get(i).getCOUNTRY()));
                    addrScr.setcbbHomeTypeItemIndex(addrScr.getcbbHomeTypeItemIndex(super.LookupValue("PROPERTY_TYPE", AddressList.get(i).getPROPERTY_TYPE_CD())));
                    addrScr.settxtHomeFloor(AddressList.get(i).getX_ANDAR());
                    addrScr.settxtHomeNumber(AddressList.get(i).getX_NUM_AP());
                    addrScr.settxtHomeBlock(AddressList.get(i).getX_COD_BLOCO());
                    addrScr.settxtComments(AddressList.get(i).getCOMMENTS());
                }
            }
            
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher Campos...\nErro: " + e);
        }
    }
    
    public void fillNewAddressFields() {
        addrScr.settxtRowId(getNextRowId());
        if(this.getOpenFromScreen() != null && !"".equals(this.getOpenFromScreen())){
            ArrayList<AddressClass> addrList;
            switch(this.getOpenFromScreen()){
                case "USER":
                    addrList = super.queryAddressRecord("SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblAddress() + "\nWHERE PAR_ROW_ID = '" + this.getUserId() + "' AND PR_ADDR_FLG = 'Y'");
                    if(addrList.size() > 0){
                        addrScr.setckbMainAddress("N");
                    } else {
                        addrScr.setckbMainAddress("Y");
                    }
                    break;
                case "ACCOUNT":
                    addrList = super.queryAddressRecord("SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblAddress() + "\nWHERE PAR_ROW_ID = '" + this.getAccountId() + "' AND PR_ADDR_FLG = 'Y'");
                    if(addrList.size() > 0){
                        addrScr.setckbMainAddress("N");
                    } else {
                        addrScr.setckbMainAddress("Y");
                    }
                    break;
                case "MAIN":
                    addrScr.setckbMainAddress("Y");
                    break;
                default:
                    addrScr.setckbMainAddress("Y");
                    break;
            }
        }
    }
    
    public boolean insert() {
        String addressId = "";
        String condition = "";
        if(validateFields()){
            ArrayList<AddressClass> addrList = null;
            addressId = super.getNextRowId();
            super.clearColumns();
            super.clearValues();
            super.setColumns(",\n\t" + "ACTIVE_FLG"); super.setValues(",\n\t" + "'Y'");
            super.setColumns(",\n\t" + "PAR_ADDR_ID"); super.setValues(",\n\t" + "NULL");
            super.setColumns(",\n\t" + "PAR_ROW_ID"); super.setValues(",\n\t" + "NULL");
            
            if("Y".equals(addrScr.getckbMainAddress())){
                if(this.addrRowIdArray.size() > 0){
                    for(int i = 0; i < this.addrRowIdArray.size(); i++) {
                        if(i != this.addrRowIdArray.size() - 1){
                            condition += "'" + this.addrRowIdArray.get(i).getRow_id() + "',\n\t\t";
                        } else {
                            condition += "'" + this.addrRowIdArray.get(i).getRow_id() + "'\n\t";
                        }
                    }
                }
                if(this.getOpenFromScreen() != null && !"".equals(this.getOpenFromScreen())){
                    switch(this.getOpenFromScreen()){
                        case "USER":
                            addrList = super.queryAddressRecord("SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblAddress() + " ADDR\nWHERE ADDR.PAR_ROW_ID = '" + this.getUserId() + "'\nAND ADDR.PR_ADDR_FLG = 'Y'" + ((!"".equals(condition)) ? "\nOR (\n\tADDR.ROW_ID IN (\n\t\t" + condition + ")\n\tAND ADDR.PR_ADDR_FLG = 'Y'\n)" : ""));
                            break;
                        case "ACCOUNT":
                            addrList = super.queryAddressRecord("SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblAddress() + " ADDR\nWHERE ADDR.PAR_ROW_ID = '" + this.getAccountId() + "'\nAND ADDR.PR_ADDR_FLG = 'Y'" + ((!"".equals(condition)) ? "\nOR (\n\tADDR.ROW_ID IN (\n\t\t" + condition + ")\n\tAND ADDR.PR_ADDR_FLG = 'Y'\n)" : ""));
                            break;
                        default:
                            addrList = null;
                            super.setColumns(",\n\t" + "PAR_ROW_ID"); super.setValues(",\n\t" + "NULL");
                            super.setColumns(",\n\t" + "PAR_CON_ID"); super.setValues(",\n\t" + "NULL");
                            break;
                    }
                }
                if(addrList.size() > 0){
                    for(int i = 0; i < addrList.size(); i++){
                        if("Y".equals(addrList.get(i).getPR_ADDR_FLG())){
                            super.clearColumnsValues();
                            super.clearCondition();
                            super.setColumnsValues(",\n\t" + "PR_ADDR_FLG = 'N'");
                            super.setCondition("ROW_ID = '" + addrList.get(i).getRow_id() + "'");
                            this.setOldPrimaryAddrId(addrList.get(i).getRow_id());
                            try{
                                this.clearCount();                                            
                                this.setCount(super.updateRecord(super.getTblAddress(), super.getColumnsValues(), super.getCondition()));
                                if(this.getCount() > 0){
                                    super.clearColumnsValues();
                                    super.clearCondition();
                                    super.setColumns(",\n\t" + "PR_ADDR_FLG"); super.setValues(",\n\t" + "'Y'");
                                } else {
                                    super.clearColumnsValues();
                                    super.clearCondition();
                                    super.setColumns(",\n\t" + "PR_ADDR_FLG"); super.setValues(",\n\t" + "'N'");
                                }
                            } catch (Exception e) {
                                super.clearColumnsValues();
                                super.clearCondition();
                                super.setColumns(",\n\t" + "PR_ADDR_FLG"); super.setValues(",\n\t" + "'N'");
                            }
                        }
                    }
                } else {
                    super.setColumns(",\n\t" + "PR_ADDR_FLG"); super.setValues(",\n\t" + "'Y'");
                }
            } else {
                super.setColumns(",\n\t" + "PR_ADDR_FLG"); super.setValues(",\n\t" + "'N'");
            }
            
            super.setColumns(",\n\t" + "ZIPCODE"); super.setValues(",\n\t" + ((addrScr.gettxtZipcode() != null) ? "'" + addrScr.gettxtZipcode() + "'" : "NULL"));
            super.setColumns(",\n\t" + "ADDR_TYPE_CD"); super.setValues(",\n\t" + ((addrScr.getcbbAddressType() != null) ? "'" +  super.LookupName("STREET_TYPE", addrScr.getcbbAddressType()) + "'" : "NULL"));
            super.setColumns(",\n\t" + "ADDR"); super.setValues(",\n\t" + ((addrScr.gettxtAddressName() != null) ? "'" + addrScr.gettxtAddressName() + "'" : "NULL"));
            super.setColumns(",\n\t" + "ADDR_NUM"); super.setValues(",\n\t" + ((addrScr.gettxtAddressNumber() != null) ?  "'" +  addrScr.gettxtAddressNumber() + "'" : "NULL"));
            super.setColumns(",\n\t" + "NEIGHBORHOOD"); super.setValues(",\n\t" + ((addrScr.gettxtNeighborhood() != null) ?  "'" +  addrScr.gettxtNeighborhood() + "'" : "NULL"));
            super.setColumns(",\n\t" + "X_ZONA"); super.setValues(",\n\t" + ((addrScr.getcbbAddressZone() != null) ?  "'" +  super.LookupName("CITY_ZONE", addrScr.getcbbAddressZone()) + "'" : "NULL"));
            super.setColumns(",\n\t" + "CITY"); super.setValues(",\n\t" + ((addrScr.gettxtAddressCity() != null) ?  "'" +  addrScr.gettxtAddressCity() + "'" : "NULL"));
            super.setColumns(",\n\t" + "STATE"); super.setValues(",\n\t" + ((addrScr.getcbbAddressState() != null) ?  "'" +  addrScr.getcbbAddressState() + "'" : "NULL"));          
            super.setColumns(",\n\t" + "NATIONALITY"); super.setValues(",\n\t" + ((addrScr.getcbbAddressCountry() != null) ?  "'" +  super.LookupValue("NATIONALITY", addrScr.getcbbAddressCountry()) + "'" : "NULL"));
            super.setColumns(",\n\t" + "COUNTRY"); super.setValues(",\n\t" + ((addrScr.getcbbAddressCountry() != null) ?  "'" +  addrScr.getcbbAddressCountry() + "'" : "NULL"));
            super.setColumns(",\n\t" + "COUNTRY_CODE"); super.setValues(",\n\t" + ((addrScr.getcbbAddressCountry() != null) ?  "'" +  super.LookupValue("COUNTRY_CODE", addrScr.getcbbAddressCountry()) + "'" : "NULL"));
            super.setColumns(",\n\t" + "COUNTRY_INITIAL"); super.setValues(",\n\t" + ((addrScr.getcbbAddressCountry() != null) ?  "'" +  super.LookupValue("COUNTRY_INITIAL", super.LookupName("COUNTRY", addrScr.getcbbAddressCountry())) + "'" : "NULL"));
            super.setColumns(",\n\t" + "PROPERTY_TYPE_CD"); super.setValues(",\n\t" + ((addrScr.getcbbHomeType() != null) ? "'" +  super.LookupName("PROPERTY_TYPE", addrScr.getcbbHomeType()) + "'" : "NULL"));
            super.setColumns(",\n\t" + "ADDR_LINE_2"); super.setValues(",\n\t" + ((addrScr.gettxtAddressComplement() != null) ?  "'" +  addrScr.gettxtAddressComplement()+ "'" : "NULL"));
            super.setColumns(",\n\t" + "X_ANDAR"); super.setValues(",\n\t" + ((addrScr.gettxtHomeFloor() != null) ?  "'" +  addrScr.gettxtHomeFloor() + "'" : "NULL"));
            super.setColumns(",\n\t" + "X_NUM_AP"); super.setValues(",\n\t" + ((addrScr.gettxtHomeNumber() != null) ?  "'" +  addrScr.gettxtHomeNumber() + "'" : "NULL"));
            super.setColumns(",\n\t" + "X_COD_BLOCO"); super.setValues(",\n\t" + ((addrScr.gettxtHomeBlock() != null) ?  "'" +  addrScr.gettxtHomeBlock() + "'" : "NULL"));
            super.setColumns(",\n\t" + "ADDR_NAME");
            super.setValues(
                ",\n\t" + "'" + addrScr.getcbbAddressType() + " " +
                addrScr.gettxtAddressName() + ", " + 
                addrScr.gettxtAddressNumber() + ", " + 
                addrScr.gettxtNeighborhood() + ", " + 
                addrScr.gettxtAddressCity() + " / " + 
                addrScr.getcbbAddressState() +  " - " + 
                addrScr.gettxtZipcode() +  " - " + 
                addrScr.getcbbAddressCountry() + "'"
            );
            super.setColumns(",\n\t" + "COMMENTS"); super.setValues(",\n\t" + ((addrScr.gettxtComments() != null) ?  "'" +  addrScr.gettxtComments() + "'" : "NULL"));
            
            try{
                if("true".equals(super.insertRecord(super.getTblAddress(), super.getColumns(), super.getValues()))){
                    addrRowId = new addressRowIdClass();
                    addrRowId.setRow_id(addressId);
                    setLastAddrAdd(addressId);
                    addrRowIdArray.add(addrRowId);
                    this.setLastAddrAdd(addressId);
                    this.fillList(null, "INSERT_RECORD");
                    super.clearColumns();
                    super.clearValues();
                    
                    return true;
                } else {
                    addressId = "";
                    super.clearColumns();
                    super.clearValues();
                    return false;
                }
            } catch (Exception e) {
                addressId = "";
                super.clearColumns();
                super.clearValues();
                return false;
            }
        } else {
            return false;
        }
    }
    
    public boolean update(String screen, String columnsValues, String condition, String rowId) {
        super.clearColumnsValues();
        super.clearCondition();
        if("ADDRESS".equals(screen)){
            if(validateFields()){        
                this.setLastAddrUpd(rowId);
                
                if("Y".equals(addrScr.getckbMainAddress())){
                    ArrayList<AddressClass> addrList;
                    switch(this.getOpenFromScreen()) {
                        case "USER":
                            addrList = super.queryAddressRecord("SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblAddress() + "\nWHERE PAR_ROW_ID = '" + this.getUserId() + "'\nAND ROW_ID <> '" + rowId + "'\nAND PR_ADDR_FLG = 'Y'");
                            break;
                        case "ACCOUNT":
                            addrList = super.queryAddressRecord("SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblAddress() + "\nWHERE PAR_ROW_ID = '" + this.getAccountId() + "'\nAND ROW_ID <> '" + rowId + "'\nAND PR_ADDR_FLG = 'Y'");
                            break;
                        default:
                            addrList = null;
                            break;
                    }
                    
                    if(addrList.size() > 0){
                        for(int i = 0; i < addrList.size(); i++){
                            if("Y".equals(addrList.get(i).getPR_ADDR_FLG())){
                                super.clearColumnsValues();
                                super.clearCondition();
                                super.setColumnsValues(",\n\t" + "PR_ADDR_FLG = 'N'");
                                super.setCondition("ROW_ID = '" + addrList.get(i).getRow_id() + "'");
                                this.setOldPrimaryAddrId(addrList.get(i).getRow_id());
                                try{
                                    this.clearCount();                                            
                                    this.setCount(super.updateRecord(super.getTblAddress(), super.getColumnsValues(), super.getCondition()));
                                    if(this.getCount() > 0){
                                        super.clearColumnsValues();
                                        super.clearCondition();
                                        super.setColumnsValues(",\n\t" + "PR_ADDR_FLG = 'Y'");
                                    } else {
                                        super.clearColumnsValues();
                                        super.clearCondition();
                                        super.setColumnsValues(",\n\t" + "PR_ADDR_FLG = 'N'");
                                    }
                                } catch (Exception e) {
                                    super.clearColumnsValues();
                                    super.clearCondition();
                                    super.setColumnsValues(",\n\t" + "PR_ADDR_FLG = 'N'");
                                }
                            }
                        }
                    } else {
                        super.setColumnsValues(",\n\t" + "PR_ADDR_FLG = 'Y'");
                    }
                } else {
                    super.setColumnsValues(",\n\t" + "PR_ADDR_FLG = 'N'");
                }
                super.setColumnsValues(",\n\t" + "ACTIVE_FLG = 'Y'");
                super.setColumnsValues(",\n\t" + "MODIFICATION_NUM = (SELECT MODIFICATION_NUM + 1 FROM " + super.getDbOwner() + "." + super.getTblAddress() + " WHERE ROW_ID = '" + rowId + "')");
                super.setColumnsValues(",\n\t" + "PAR_ADDR_ID = NULL");
                super.setColumnsValues(",\n\t" + "ZIPCODE = " + ((addrScr.gettxtZipcode() != null) ? "'" + addrScr.gettxtZipcode() + "'" : "NULL"));
                super.setColumnsValues(",\n\t" + "ADDR_TYPE_CD = " + ((addrScr.getcbbAddressType() != null) ? "'" +  super.LookupName("STREET_TYPE", addrScr.getcbbAddressType()) + "'" : "NULL"));
                super.setColumnsValues(",\n\t" + "ADDR = " + ((addrScr.gettxtAddressName() != null) ? "'" + addrScr.gettxtAddressName() + "'" : "NULL"));
                super.setColumnsValues(",\n\t" + "ADDR_NUM = " + ((addrScr.gettxtAddressNumber() != null) ?  "'" +  addrScr.gettxtAddressNumber() + "'" : "NULL"));
                super.setColumnsValues(",\n\t" + "NEIGHBORHOOD = " + ((addrScr.gettxtNeighborhood() != null) ?  "'" +  addrScr.gettxtNeighborhood() + "'" : "NULL"));
                super.setColumnsValues(",\n\t" + "X_ZONA = " + ((addrScr.getcbbAddressZone() != null) ?  "'" +  super.LookupName("CITY_ZONE", addrScr.getcbbAddressZone()) + "'" : "NULL"));
                super.setColumnsValues(",\n\t" + "CITY = " + ((addrScr.gettxtAddressCity() != null) ?  "'" +  addrScr.gettxtAddressCity() + "'" : "NULL"));
                super.setColumnsValues(",\n\t" + "STATE = " + ((addrScr.getcbbAddressState() != null) ?  "'" +  addrScr.getcbbAddressState() + "'" : "NULL"));          
                super.setColumnsValues(",\n\t" + "NATIONALITY = " + ((addrScr.getcbbAddressCountry() != null) ?  "'" +  super.LookupValue("NATIONALITY", addrScr.getcbbAddressCountry()) + "'" : "NULL"));
                super.setColumnsValues(",\n\t" + "COUNTRY = " + ((addrScr.getcbbAddressCountry() != null) ?  "'" +  addrScr.getcbbAddressCountry() + "'" : "NULL"));
                super.setColumnsValues(",\n\t" + "COUNTRY_CODE = " + ((addrScr.getcbbAddressCountry() != null) ?  "'" +  super.LookupValue("COUNTRY_CODE", addrScr.getcbbAddressCountry()) + "'" : "NULL"));
                super.setColumnsValues(",\n\t" + "COUNTRY_INITIAL = " + ((addrScr.getcbbAddressCountry() != null) ?  "'" +  super.LookupValue("COUNTRY_INITIAL", super.LookupName("COUNTRY", addrScr.getcbbAddressCountry())) + "'" : "NULL"));
                super.setColumnsValues(",\n\t" + "PROPERTY_TYPE_CD = " + ((addrScr.getcbbHomeType() != null) ? "'" +  super.LookupName("PROPERTY_TYPE", addrScr.getcbbHomeType()) + "'" : "NULL"));
                super.setColumnsValues(",\n\t" + "ADDR_LINE_2 = " + ((addrScr.gettxtAddressComplement() != null) ?  "'" +  addrScr.gettxtAddressComplement()+ "'" : "NULL"));
                super.setColumnsValues(",\n\t" + "X_ANDAR = " + ((addrScr.gettxtHomeFloor() != null) ?  "'" +  addrScr.gettxtHomeFloor() + "'" : "NULL"));
                super.setColumnsValues(",\n\t" + "X_NUM_AP = " + ((addrScr.gettxtHomeNumber() != null) ?  "'" +  addrScr.gettxtHomeNumber() + "'" : "NULL"));
                super.setColumnsValues(",\n\t" + "X_COD_BLOCO = " + ((addrScr.gettxtHomeBlock() != null) ?  "'" +  addrScr.gettxtHomeBlock() + "'" : "NULL"));
                super.setColumnsValues(",\n\t" + "ADDR_NAME = " +
                    "'" + addrScr.getcbbAddressType() + " " +
                    addrScr.gettxtAddressName() + ", " + 
                    addrScr.gettxtAddressNumber() + ", " + 
                    addrScr.gettxtNeighborhood() + ", " + 
                    addrScr.gettxtAddressCity() + " / " + 
                    addrScr.getcbbAddressState() +  " - " + 
                    addrScr.gettxtZipcode() +  " - " + 
                    addrScr.getcbbAddressCountry() + "'"
                );
                super.setColumnsValues(",\n\t" + "COMMENTS = " + ((addrScr.gettxtComments() != null) ?  "'" +  addrScr.gettxtComments() + "'" : "NULL"));
                
                if(!"".equals(columnsValues) && columnsValues != null){
                    super.setColumnsValues(columnsValues);
                }
                super.setCondition("ROW_ID = '" + rowId + "'");
                if(!"".equals(condition) && condition != null){
                    super.setCondition(condition);
                }

                try{
                    this.clearCount();
                    this.setCount(super.updateRecord(super.getTblAddress(), super.getColumnsValues(), super.getCondition()));
                    if(this.getCount() > 0){
                        //JOptionPane.showMessageDialog(null, "Registros atualizados com sucesso!\nTotal de registros alterados: " + this.getCount());
                        this.setLastAddrUpd(addrScr.gettxtRowId());
                        this.fillList(null, "UPDATE_RECORD");
                        super.clearColumnsValues();
                        super.clearCondition();
                        return true;
                    } else {
                        super.clearColumnsValues();
                        super.clearCondition();
                        return false;
                    }
                } catch (Exception e) {
                    super.clearColumnsValues();
                    super.clearCondition();
                    return false;
                }
            } else {
                return false;
            }
        } else if("USER".equals(screen) || "ACCOUNT".equals(screen)) {
            this.setLastAddrUpd(rowId);
            super.clearColumnsValues();
            super.clearCondition();
            super.setColumnsValues(",\n\t" + "ACTIVE_FLG = 'Y'");
            super.setColumnsValues(",\n\t" + "MODIFICATION_NUM = (SELECT MODIFICATION_NUM + 1 FROM " + super.getDbOwner() + "." + super.getTblAddress() + " WHERE ROW_ID = '" + rowId + "')");
            super.setColumnsValues(",\n\t" + "PAR_ADDR_ID = NULL");
            if(!"".equals(columnsValues) && columnsValues != null){
                super.setColumnsValues(columnsValues);
            }
            super.setCondition("ROW_ID = '" + rowId + "'");
            if(!"".equals(condition) && condition != null){
                super.setCondition(condition);
            }
            
            try{
                this.clearCount();
                this.setCount(super.updateRecord(super.getTblAddress(), super.getColumnsValues(), super.getCondition()));
                if(this.getCount() > 0){
                    super.clearColumnsValues();
                    super.clearCondition();
                    return true;
                } else {
                    super.clearColumnsValues();
                    super.clearCondition();
                    return false;
                }
            } catch (Exception e) {
                super.clearColumnsValues();
                super.clearCondition();
                return false;
            }
        } else {
            return false;
        }
        
    }
    
    public boolean delete(String function, String condition) {
        if("DELETE_BUTTON".equals(function)){
            if(!super.wishDeleteRecord()){
                return false;
            }
        }
        
        super.clearCondition();
        super.setCondition(condition);
        
        try{
            int count = super.deleteRecord(super.getTblAddress(), super.getCondition());
            if(count > 0){
                addrRowIdArray.remove(addrScr.getSelectedRowList());
                if("DELETE_BUTTON".equals(function)){ JOptionPane.showMessageDialog(null, "Registro(s) removido(s) com sucesso!\nTotal de registros removidos: " + count + " registro(s)"); }
                super.clearColumnsValues();
                super.clearCondition();
                return true;
            } else {
                super.clearColumnsValues();
                super.clearCondition();
                return false;
            }
        } catch (HeadlessException e) {
            super.clearColumnsValues();
            super.clearCondition();
            return false;
        }
        
    }
    
    private void save() {
        if(validateFields()){
            try{
                ArrayList<AddressClass> addrList = queryAddressRecord("SELECT *\nFROM " + getDbOwner() + "." + getTblAddress() + "\nWHERE ROW_ID = '" + addrScr.gettxtRowId() + "'");

                if(addrList.size() > 0) {
                    if(update("ADDRESS", null, null, addrScr.gettxtRowId())){
                        addrScr.enableFields("SALVAR", this.getOpenFromScreen());
                    }
                } else {
                    if(insert()){
                        addrScr.enableFields("SALVAR", this.getOpenFromScreen());

                        boolean foundRow = true;
                        int i = 0;
                        int o = addrScr.getNumOfListRows();
                        do {
                            if(i < o){
                                try{                                    
                                    if(getLastAddrAdd().equals(addrRowIdArray.get(i).getRow_id())){
                                        addrScr.setSelectedRowColumnList(i, 0);
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
                
                DefaultTableModel table = (DefaultTableModel) addrScr.getTableModel();
                table.getRowCount();
                
                if(getOldPrimaryAddrId() != null && !"".equals(getOldPrimaryAddrId())){
                    for(int i = 0; i < table.getRowCount(); i++) {
                        if(addrRowIdArray.get(i).getRow_id().equals(getOldPrimaryAddrId())) {
                            table.setValueAt(false, i, 1);
                            this.setOldPrimaryAddrId(null);
                        }
                    }
                }
                addrScr.setlblRecCount((addrScr.getSelectedRowList() + 1) + " - " + String.valueOf(addrRowIdArray.size()));
            } catch(Exception e) {
                System.out.println(getDateTime() + "\tContactModule.ContactController\t\tSaveSocialMedia\tInsertUpdateSocialMedia\tError Exception\tError: " + e);
            }
        }
    }
    
    public boolean validateFields() {
        String mensagem = "";
        int i = 0;
        
        if(addrScr.gettxtZipcode() == null) { mensagem += "\n- " + "CEP" + ";"; i = (i < 1) ? 1 : i; }
        if(addrScr.getcbbAddressType() == null) { mensagem += "\n- " + "Tipo de Logradouro" + ";"; i = (i < 2 && i != 0) ? i : 2; }
        if(addrScr.gettxtAddressName() == null) { mensagem += "\n- " + "Logradouro" + ";"; i = (i < 3 && i != 0) ? i : 3; }
        if(addrScr.gettxtAddressNumber() == null) { mensagem += "\n- " + "Número" + ";"; i = (i < 4 && i != 0) ? i : 4; }
        if(addrScr.gettxtNeighborhood() == null) { mensagem += "\n- " + "Bairro" + ";"; i = (i < 5 && i != 0) ? i : 5; }
        if(addrScr.getcbbAddressZone() == null) { mensagem += "\n- " + "Zona" + ";"; i = (i < 6 && i != 0) ? i : 6; }
        if(addrScr.gettxtAddressCity() == null) { mensagem += "\n- " + "Cidade" + ";"; i = (i < 7 && i != 0) ? i : 7; }
        if(addrScr.getcbbAddressState() == null) { mensagem += "\n- " + "Estado" + ";"; i = (i < 8 && i != 0) ? i : 8; }
        if(addrScr.getcbbAddressCountry() == null) { mensagem += "\n- " + "País" + ";"; i = (i < 9 && i != 0) ? i : 9; }
        if(addrScr.getcbbHomeType() == null) { mensagem += "\n- " + "Tipo de Imóvel" + ";"; i = (i < 10 && i != 0) ? i : 10; }

        switch(i){
            case 1:
                addrScr.setFocus("CEP_PARTE_1");
                break;
            case 2:
                addrScr.setFocus("TIPO_LOGRADOURO");
                break;
            case 3:
                addrScr.setFocus("LOGRADOURO");
                break;
            case 4:
                addrScr.setFocus("NUMERO");
                break;
            case 5:
                addrScr.setFocus("BAIRRO");
                break;
            case 6:
                addrScr.setFocus("ZONA");
                break;
            case 7:
                addrScr.setFocus("CIDADE");
                break;
            case 8:
                addrScr.setFocus("ESTADO");
                break;
            case 9:
                addrScr.setFocus("PAIS");
                break;
            case 10:
                addrScr.setFocus("TIPO_IMOVEL");
                break;
            default:
                break;
        }
        
        
        if(!"".equals(mensagem)){
            JOptionPane.showMessageDialog(null, "Os campos abaixo são obrigatórios. Favor preencher os mesmos:" + mensagem);
            return false;
        } else {
            return true;
        }
    }
    
    public boolean searchAddress() {
        if(!"".equals(addrScr.gettxtZipcode()) && addrScr.gettxtZipcode() != null){
            cepList = getCEPJSON(addrScr.gettxtZipcode());
            
            if (cepList.size() > 0) {
                for (int i = 0; i < cepList.size(); i++) {
                    String streetType = cepList.get(i).getStreet().toUpperCase();
                    int streetLength = cepList.get(i).getStreet().length();
                    int count = 0;
                    
                    // Reset Fields
                    addrScr.setcbbAddressTypeItemIndex(0);
                    addrScr.cleartxtAddressName();
                    addrScr.cleartxtNeighborhood();
                    addrScr.setcbbAddressZoneItemIndex(0);
                    addrScr.cleartxtAddressCity();
                    addrScr.setcbbAddressStateItemIndex(0);
                    addrScr.cleartxtAddressComplement();
                    addrScr.setcbbAddressCountryItemIndex(0);
                    
                    if(streetType.startsWith("AVENIDA")) {
                        addrScr.setcbbAddressTypeItemIndex(addrScr.getcbbAddressTypeItemIndex("Avenida"));
                        count = 8;
                    } else if(streetType.startsWith("ESTRADA")){
                        addrScr.setcbbAddressTypeItemIndex(addrScr.getcbbAddressTypeItemIndex("Estrada"));
                        count = 8;
                    } else {
                        addrScr.setcbbAddressTypeItemIndex(addrScr.getcbbAddressTypeItemIndex("Rua"));
                        count = 4;
                    }
                    
                    addrScr.settxtAddressName(cepList.get(i).getStreet().substring(count, streetLength));                    
                    addrScr.settxtNeighborhood(cepList.get(i).getNeighborhood());
                    addrScr.setcbbAddressZoneItemIndex(addrScr.getcbbAddressZoneItemIndex(super.LookupValue("CITY_NEIGHBORHOOD", cepList.get(i).getNeighborhood())));
                    addrScr.settxtAddressCity(cepList.get(i).getCity());
                    addrScr.setcbbAddressStateItemIndex(addrScr.getcbbAddressStateItemIndex(cepList.get(i).getUf()));
                    addrScr.settxtAddressComplement(cepList.get(i).getComplement());
                    addrScr.setcbbAddressCountryItemIndex(addrScr.getcbbAddressCountryItemIndex("Brasil"));
                    //System.out.println("CEP: " + cepList.get(i).getZipcode());
                    //System.out.println("Rua: " + cepList.get(i).getStreet());
                    //System.out.println("Bairro: " + cepList.get(i).getNeighborhood());
                    //System.out.println("Cidade: " + cepList.get(i).getCity());
                    //System.out.println("UF: " + cepList.get(i).getUf());
                    //System.out.println("Complemento: " + cepList.get(i).getComplement());
                }
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private ArrayList<zipcode> getCEPJSON(String cep) {
        ArrayList<zipcode> result = new ArrayList<>();

        // define a url
        String url = "http://viacep.com.br/ws/" + cep + "/json/";

        try {
            // define os dados
            JSONObject obj = new JSONObject(getHttpGET(url));

            if (!obj.has("erro")) {
                zipcode novoCEP = new zipcode(
                        obj.getString("cep"),
                        obj.getString("logradouro"),
                        obj.getString("complemento"),
                        obj.getString("bairro"),
                        obj.getString("localidade"),
                        obj.getString("uf"),
                        obj.getString("ibge"),
                        obj.getString("gia")
                );

                // insere o novo CEP
                result.add(novoCEP);

            } else {
                System.out.println("Não foi possível encontrar o CEP");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        return result;
    }

    private String getHttpGET(String urlToRead) {
        StringBuilder result = new StringBuilder();

        try {
            URL url = new URL(urlToRead);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }

        } catch (MalformedURLException | ProtocolException e) {
            System.out.println("Error: " + e);
        } catch (IOException e) {
            for (int i = 0; i < e.toString().length() - 3; i++) {
                if ("400".equals(e.toString().substring(i, i + 3))) {
                    System.out.println("Verifique a sua URL");
                    i = e.toString().length();
                }
            }
            System.out.println("Error: " + e);
        }

        return result.toString();
    }

    public class zipcode {
        private String zipcode;
        private String street;
        private String complement;
        private String neighborhood;
        private String city;
        private String uf;
        private String Ibge;
        private String Gia;

        public zipcode() {
            this.street = null;
            this.complement = null;
            this.neighborhood = null;
            this.city = null;
            this.uf = null;
            this.Ibge = null;
            this.Gia = null;
        }

        public zipcode(String zipcode, String street, String complement, String neighborhood, String city, String uf, String Ibge, String Gia) {
            this.zipcode = zipcode;
            this.street = street;
            this.complement = complement;
            this.neighborhood = neighborhood;
            this.city = city;
            this.uf = uf;
            this.Ibge = Ibge;
            this.Gia = Gia;
        }

        public zipcode(String street, String city, String uf) {
            this.street = street;
            this.city = city;
            this.uf = uf;
        }

        public String getZipcode() {
            return zipcode;
        }

        public void setZipcode(String CEP) {
            this.zipcode = CEP;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String Logradouro) {
            this.street = Logradouro;
        }

        public String getComplement() {
            return complement;
        }

        public void setComplement(String Complemento) {
            this.complement = Complemento;
        }

        public String getNeighborhood() {
            return neighborhood;
        }

        public void setNeighborhood(String Bairro) {
            this.neighborhood = Bairro;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String Localidade) {
            this.city = Localidade;
        }

        public String getUf() {
            return uf;
        }

        public void setUf(String Uf) {
            this.uf = Uf;
        }

        public String getIbge() {
            return Ibge;
        }

        public void setIbge(String Ibge) {
            this.Ibge = Ibge;
        }

        public String getGia() {
            return Gia;
        }

        public void setGia(String Gia) {
            this.Gia = Gia;
        }
    }

    private class newAddress implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            addrScr.enableFields("NOVO", getOpenFromScreen());
            addrScr.clearFields();
            fillNewAddressFields();
            addrScr.setFocus("CEP_PARTE_1");
        }

    }

    private class editAddress implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            addrScr.enableFields("EDITAR", getOpenFromScreen());
            addrScr.setFocus("CEP_PARTE_1");
        }

    }

    private class saveAddress implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            save();
        }

    }

    private class cancelAddress implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            addrScr.enableFields("CANCELAR", getOpenFromScreen());
            if(!"".equals(addrScr.getSelectedRowIdAddressList()) && addrScr.getSelectedRowIdAddressList() != null){
                fillFields(
                    "SELECT *\n" +
                    "FROM " + getDbOwner() + "." + getTblAddress() + " ADDR\n" +
                    "WHERE ADDR.ROW_ID = '" + addrScr.getSelectedRowIdAddressList() + "'"
                );
            } else {
                addrScr.clearFields();
            }
            addrScr.setFocus("FILTRO_VALOR");
        }

    }

    private class deleteAddress implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            String condition = "";
            if(delete("DELETE_BUTTON", "ROW_ID = '" + addrScr.gettxtRowId() + "'")){
                addrScr.enableFields("DELETAR", getOpenFromScreen());
                
                switch(getOpenFromScreen()){
                    case "USER":
                        ArrayList<UserClass> userList = queryUserRecord("SELECT *\nFROM " + getDbOwner() + "." + getTblUser() + " USR\nWHERE USR.ROW_ID = '" + getUserId() + "'");
                        if(userList.size() > 0){
                            if(addrRowIdArray.size() > 0){
                                for(int i = 0; i < addrRowIdArray.size(); i++) {
                                    if(i != addrRowIdArray.size() - 1){
                                        condition += "'" + addrRowIdArray.get(i).getRow_id() + "',\n\t";
                                    } else {
                                        condition += "'" + addrRowIdArray.get(i).getRow_id() + "'\n";
                                    }
                                }
                                openAddressScreen("SELECT *\nFROM " + getDbOwner() + "." + getTblAddress() + " ADDR\nWHERE ADDR.PAR_ROW_ID = '" + getUserId() + "'\nOR ADDR.ROW_ID IN (\n\t" + condition + ")", "DELETE_ADDRESS");
                            } else {
                                openAddressScreen("SELECT *\nFROM " + getDbOwner() + "." + getTblAddress() + " ADDR\nWHERE ADDR.PAR_ROW_ID = '" + getUserId() + "'", "DELETE_ADDRESS");
                            }
                        } else {
                            if(addrRowIdArray.size() > 0){
                                for(int i = 0; i < addrRowIdArray.size(); i++) {
                                    if(i != addrRowIdArray.size() - 1){
                                        condition += "'" + addrRowIdArray.get(i).getRow_id() + "',\n\t";
                                    } else {
                                        condition += "'" + addrRowIdArray.get(i).getRow_id() + "'\n";
                                    }
                                }
                                openAddressScreen("SELECT *\nFROM " + getDbOwner() + "." + getTblAddress() + " ADDR\nWHERE ADDR.ROW_ID IN (\n\t" + condition + ")", "DELETE_ADDRESS");
                            } else {
                                // Force to not find any Address
                                openAddressScreen("SELECT *\nFROM " + getDbOwner() + "." + getTblAddress() + " ADDR\nWHERE ADDR.PAR_ROW_ID = '" + getUserId() + "'", "DELETE_ADDRESS");
                            }
                        }
                        break;
                    case "ACCOUNT":
                        ArrayList<AccountClass> AccountList = queryAccountRecord("SELECT *\nFROM " + getDbOwner() + "." + getTblAccount() + " ACC\nWHERE ACC.ROW_ID = '" + getAccountId() + "'");
                        if(AccountList.size() > 0){
                            if(addrRowIdArray.size() > 0){
                                for(int i = 0; i < addrRowIdArray.size(); i++) {
                                    if(i != addrRowIdArray.size() - 1){
                                        condition += "'" + addrRowIdArray.get(i).getRow_id() + "',\n\t";
                                    } else {
                                        condition += "'" + addrRowIdArray.get(i).getRow_id() + "'\n";
                                    }
                                }
                                openAddressScreen("SELECT *\nFROM " + getDbOwner() + "." + getTblAddress() + " ADDR\nWHERE ADDR.PAR_ROW_ID = '" + getAccountId() + "'\nOR ADDR.ROW_ID IN (\n\t" + condition + ")", "DELETE_ADDRESS");
                            } else {
                                openAddressScreen("SELECT *\nFROM " + getDbOwner() + "." + getTblAddress() + " ADDR\nWHERE ADDR.PAR_ROW_ID = '" + getAccountId() + "'", "DELETE_ADDRESS");
                            }
                        } else {
                            if(addrRowIdArray.size() > 0){
                                for(int i = 0; i < addrRowIdArray.size(); i++) {
                                    if(i != addrRowIdArray.size() - 1){
                                        condition += "'" + addrRowIdArray.get(i).getRow_id() + "',\n\t";
                                    } else {
                                        condition += "'" + addrRowIdArray.get(i).getRow_id() + "'\n";
                                    }
                                }
                                openAddressScreen("SELECT *\nFROM " + getDbOwner() + "." + getTblAddress() + " ADDR\nWHERE ADDR.ROW_ID IN (\n\t" + condition + ")", "DELETE_ADDRESS");
                            } else {
                                // Force to not find any Address
                                openAddressScreen("SELECT *\nFROM " + getDbOwner() + "." + getTblAddress() + " ADDR\nWHERE ADDR.PAR_ROW_ID = '" + getAccountId() + "'", "DELETE_ADDRESS");
                            }
                        }
                        break;
                    case "MAIN":
                        openAddressScreen("SELECT *\nFROM " + getDbOwner() + "." + getTblAddress() + " ADDR", "DELETE_ADDRESS");
                        break;
                    default:
                        openAddressScreen("SELECT *\nFROM " + getDbOwner() + "." + getTblAddress() + " ADDR", "DELETE_ADDRESS");
                        break;
                }
                
            } else {
                addrScr.enableFields("SALVAR", getOpenFromScreen());
                if(!"".equals(addrScr.getSelectedRowIdAddressList()) && addrScr.getSelectedRowIdAddressList() != null){
                    fillFields(
                        "SELECT *\n" +
                        "FROM " + getDbOwner() + "." + getTblAddress() + "\n" +
                        "WHERE ROW_ID = '" + addrScr.getSelectedRowIdAddressList() + "'"
                    );
                } else {
                    addrScr.clearFields();
                }
            }
        }

    }

    private class searchAddress implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if(searchAddress()) {
                addrScr.enableFields("SEARCH", getOpenFromScreen());
                addrScr.setFocus("NUMERO");
            } else {
                if(JOptionPane.showConfirmDialog(null, "O CEP informado não foi encontrado! Deseja continuar mesmo assim?","Atenção",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION){
                    addrScr.enableFields("SEARCH", getOpenFromScreen());
                    addrScr.setFocus("TIPO_LOGRADOURO");
                } else {
                    addrScr.setFocus("CEP_PARTE_1");
                }
            }
        }
        
    }
    
    private class addressScreenListener implements WindowListener {

        @Override
        public void windowOpened(WindowEvent we) { }

        @Override
        public void windowClosing(WindowEvent we) {
            addrScr.dispose();
        }

        @Override
        public void windowClosed(WindowEvent we) { }

        @Override
        public void windowIconified(WindowEvent we) { }

        @Override
        public void windowDeiconified(WindowEvent we) { }

        @Override
        public void windowActivated(WindowEvent we) { }

        @Override
        public void windowDeactivated(WindowEvent we) { }
        
    }
    
    private class addressListSelected implements ListSelectionListener {
        
        private int count;

        private addressListSelected() {
            this.count = 0;
        }
        
        @Override
        public void valueChanged(ListSelectionEvent lse) {
            DefaultTableModel table = (DefaultTableModel) addrScr.getTableModel();
            
            if(count < 1){
                if(table.getRowCount() > 0) {
                    addrScr.clearFields();
                    fillFields("SELECT *\nFROM " + getDbOwner() + "." + getTblAddress() + "\nWHERE ROW_ID = '" + addrScr.getSelectedRowIdAddressList() + "'");
                    addrScr.setlblRecCount(addrScr.getSelectedRowList() + 1 + " - " + String.valueOf(addrScr.getNumOfListRows()));
                    addrScr.setbtnEditEnabled(true);
                    addrScr.setbtnDeleteEnabled(true);
                }
                count++;
            } else {
                count = 0;
            }
        }
        
    }
    
    public class addressRowIdClass {
        private String row_id;

        public addressRowIdClass() {
            this.row_id = null;
        }

        public String getRow_id() { return row_id; }
        public void setRow_id(String row_id) { this.row_id = row_id; }
        
    }
    
}