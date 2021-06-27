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
import javax.swing.text.PlainDocument;
import org.json.JSONObject;

/**
 *
 * @author MatheusCabral
 */
public class addressController extends DataController {

    addressScreen addrScr;

    private ArrayList<zipcode> cepList;

    private String userId;
    private String accountId;
    private String openFromScreen;
    private String lastAddrAdd;
    private String lastAddrUpd;
    private int count;

    public addressController() throws InterruptedException {
        this.cepList = null;
    }

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
    
    public void setListenerAddressScreen(WindowListener listener) { addrScr.addWindowListener(listener); }

    public void openAddressScreen(String query, String function) {
        addrScr = new addressScreen();
        addrScr.setListenerBtnNew(new newAddress());
        addrScr.setListenerBtnEdit(new editAddress());
        addrScr.setListenerBtnSave(new saveAddress());
        addrScr.setListenerBtnCancel(new cancelAddress());
        addrScr.setListenerBtnDelete(new deleteAddress());
        addrScr.setListenerBtnSearch(new searchAddress());
        this.setListenerAddressScreen(new addressScreenListener());
        addrScr.setListenerTblAddressListSelection(new addressListSelected());
        //addrScr.setListenerAddressScreen(new addressScreenListener());
        
        addrScr.clearFields();
        addrScr.clearComboBoxes();
        addrScr.enableFields("LOAD_SCREEN");
        addrScr.insertSelectComboBox();
        
        this.fillComboBoxesAddressScreen("STREET_TYPE");
        this.fillComboBoxesAddressScreen("CITY_ZONE");
        this.fillComboBoxesAddressScreen("STATE");
        this.fillComboBoxesAddressScreen("COUNTRY");
        this.fillComboBoxesAddressScreen("PROPERTY_TYPE");
        
        this.fillListAddressScreen(query);
    }

    public void fillComboBoxesAddressScreen(String LovType){
        try{
            ArrayList<ListOfValuesClass> lov = super.LookupList(LovType);
            
            if(lov.size() > 0){
                for(int i = 0; i < lov.size(); i++){
                    if(null == LovType){
                        JOptionPane.showMessageDialog(null, "O LOV_TYPE 'null' não existe!");
                    } else switch (LovType) {
                        case "STREET_TYPE":
                            addrScr.setcbbAddressType(lov.get(i).getName());
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
                            addrScr.setcbbHomeType(lov.get(i).getName());
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
    
    public void fillListAddressScreen(String query){
        int countRecord = 0;
        
        try{
            ArrayList<AddressClass> addrList = super.queryAddressRecord(query);
            
            DefaultTableModel table = (DefaultTableModel) addrScr.getTableModel();
            table.setRowCount(0);
            
            if(addrList.size() > 0){
                table.setNumRows(addrList.size());
                
                for(int i = 0; i < addrList.size(); i++){
                    table.setValueAt(addrList.get(i).getRow_id(), i, 0);
                    if("Y".equals(addrList.get(i).getPR_ADDR_FLG())) { table.setValueAt(true, i, 1); } else { table.setValueAt(false, i, 1); }
                    table.setValueAt(addrList.get(i).getADDR_TYPE_CD(), i, 2);
                    table.setValueAt(addrList.get(i).getADDR(), i, 3);
                    table.setValueAt(addrList.get(i).getADDR_NUM(), i, 4);
                    table.setValueAt(addrList.get(i).getADDR_LINE_2(), i, 5);
                    table.setValueAt(addrList.get(i).getNEIGHBORHOOD(), i, 6);
                    table.setValueAt(addrList.get(i).getX_ZONA(), i, 7);
                    table.setValueAt(addrList.get(i).getCITY(), i, 8);                    
                    table.setValueAt(addrList.get(i).getSTATE(), i, 9);
                    table.setValueAt(addrList.get(i).getCOUNTRY(), i, 10);
                    table.setValueAt(addrList.get(i).getPROPERTY_TYPE_CD(), i, 11);
                    table.setValueAt(addrList.get(i).getX_ANDAR(), i, 12);
                    table.setValueAt(addrList.get(i).getX_NUM_AP(), i, 13);
                    table.setValueAt(addrList.get(i).getX_COD_BLOCO(), i, 14);
                    table.setValueAt(addrList.get(i).getCOMMENTS(), i, 15);
                    
                    countRecord++;
                }
            }
            
            addrScr.setlblRecCount(String.valueOf(countRecord));
            
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher tabela...\nErro: " + e);
        }
    }
    
    private void fillFieldsAddressScreen(String query){
        try{
            ArrayList<AddressClass> AddressList = queryAddressRecord(query);
            
            //AddressList = super.queryAddressRecord("SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblAddress() + "\nWHERE PAR_ROW_ID = '" + userList.get(i).getRow_id() +  "'\nAND PR_ADDR_FLG = 'Y'");
            if(AddressList.size() > 0) {
                for(int a = 0; a < AddressList.size(); a++) {
                    addrScr.settxtRowId(AddressList.get(a).getRow_id());
                    addrScr.settxtZipcodePart1(AddressList.get(a).getZIPCODE().substring(0, 5));
                    addrScr.settxtZipcodePart2(AddressList.get(a).getZIPCODE().substring(6, 9));
                    addrScr.setcbbAddressTypeItemIndex(addrScr.getcbbAddressTypeItemIndex(super.LookupName("STREET_TYPE", AddressList.get(a).getADDR_TYPE_CD())));
                    addrScr.settxtAddressName(AddressList.get(a).getADDR());
                    addrScr.settxtAddressNumber(AddressList.get(a).getADDR_NUM());
                    addrScr.settxtAddressComplement(AddressList.get(a).getADDR_LINE_2());
                    addrScr.setcbkMainAddress(AddressList.get(a).getPR_ADDR_FLG());
                    addrScr.settxtNeighborhood(AddressList.get(a).getNEIGHBORHOOD());
                    addrScr.setcbbAddressZoneItemIndex(addrScr.getcbbAddressZoneItemIndex(super.LookupValue("CITY_ZONE", AddressList.get(a).getX_ZONA())));
                    addrScr.settxtAddressCity(AddressList.get(a).getCITY());
                    addrScr.setcbbAddressStateItemIndex(addrScr.getcbbAddressStateItemIndex(AddressList.get(a).getSTATE()));
                    addrScr.setcbbAddressCountryItemIndex(addrScr.getcbbAddressCountryItemIndex(AddressList.get(a).getCOUNTRY()));
                    addrScr.setcbbHomeTypeItemIndex(addrScr.getcbbHomeTypeItemIndex(super.LookupName("PROPERTY_TYPE", AddressList.get(a).getPROPERTY_TYPE_CD())));
                    addrScr.settxtHomeFloor(AddressList.get(a).getX_ANDAR());
                    addrScr.settxtHomeNumber(AddressList.get(a).getX_NUM_AP());
                    addrScr.settxtHomeBlock(AddressList.get(a).getX_COD_BLOCO());
                    addrScr.settxtComments(AddressList.get(a).getCOMMENTS());
                }
            }
            
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher Campos...\nErro: " + e);
        }
    }
    
    /*public boolean deleteAddress(){
        int countUser = 0;
        int countContact = 0;
        int countSocialMedia = 0;
        
        if(super.wishDeleteRecord()){
            ArrayList<ContactClass> contact = null;
            ArrayList<SocialMediaClass> socialMedia = null;            
            super.clearCondition();
            
            contact = super.queryContactRecord("SELECT *\nFROM " + super.getDbOwner() + "." + getTblContact() + "\nWHERE PAR_USR_ID = '" + userScreen.gettxtRowId() + "'\nAND PAR_ROW_ID = '" + userScreen.gettxtRowId() + "'");
            
            if(contact.size() > 0){
                super.setCondition("PAR_ROW_ID IN (");
                for(int i = 0; i < contact.size(); i++){
                    if(i == 0){
                        super.setCondition("\n\t'" + contact.get(i).getRow_id() + "'");
                    } else {
                        super.setCondition(",\n\t'" + contact.get(i).getRow_id() + "'");
                    }
                }
                super.setCondition("\n)\nAND PAR_USR_ID = '" + userScreen.gettxtRowId() + "'");
                
                socialMedia = super.querySocialMediaRecord("SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblSocialMedia() + "\nWHERE " + super.getCondition());
                
                if(socialMedia.size() > 0) {
                    countSocialMedia = super.deleteRecord(super.getTblSocialMedia(), super.getCondition());
                    if(countSocialMedia > 0){
                        cont.updateArrayAfterDelete("CONTACT");
                    }
                }
                
                super.clearCondition();
                
                super.setCondition("PAR_ROW_ID = '" + userScreen.gettxtRowId() + "'");
                super.setCondition("\nAND PAR_USR_ID = '" + userScreen.gettxtRowId() + "'");
                
                countContact = super.deleteRecord(super.getTblContact(), super.getCondition());
                
                if(countContact > 0){
                    cont.updateArrayAfterDelete("CONTACT");
                }
                super.clearCondition();
            }
            
            super.setCondition("ROW_ID = '" + userScreen.gettxtRowId() + "'");
            try{
                countUser = super.deleteRecord(super.getTblUser(), super.getCondition());
                if(countUser > 0){
                    JOptionPane.showMessageDialog(null, "Registro(s) removido(s) com sucesso! Total de registros removidos:\nUsuário: " + countUser + " registro(s)\nContato: " + countContact + " registro(s)\nRedes Sociais: " + countSocialMedia + " registro(s)");
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
    }*/
    
    public boolean validateFields(){
        String mensagem = "";
        int i = 0;
        
        if(addrScr.gettxtZipcode() == null) { mensagem += "\n- " + "CEP" + ";"; i = (i < 1) ? 1 : i; }
        if(addrScr.getcbbAddressType() == null) { mensagem += "\n- " + "Tipo de Logradouro" + ";"; i = (i < 2 && i != 0) ? i : 2;  }
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
            addrScr.enableFields("NOVO");
            addrScr.clearFields();
            addrScr.setFocus("CEP_PARTE_1");
        }

    }

    private class editAddress implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            addrScr.enableFields("EDITAR");
            addrScr.setFocus("CEP_PARTE_1");
        }

    }

    private class saveAddress implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if(validateFields()) {
                addrScr.enableFields("SALVAR");
                addrScr.setFocus("FILTRO_VALOR");
            }
        }

    }

    private class cancelAddress implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            addrScr.enableFields("CANCELAR");
            if(!"".equals(addrScr.getSelectedRowIdAddressList()) && addrScr.getSelectedRowIdAddressList() != null){
                fillFieldsAddressScreen(
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
            /*if(deleteAddress()){
                addrScr.enableFields("DELETAR");
                //openAddressScreen("USER");
            } else {
                addrScr.enableFields("CANCELAR");
                if(!"".equals(addrScr.getSelectedUserListId()) && addrScr.getSelectedUserListId() != null){
                    fillFieldsAddressScreen(
                        "SELECT *\n" +
                        "FROM " + getDbOwner() + "." + getTblUser()+ " USR\n" +
                        "WHERE USR.ROW_ID = '" + addrScr.getSelectedUserListId() + "'"
                    );
                } else {
                    addrScr.clearFields();
                }
                addrScr.setFocus("FILTRO_VALOR");
            }*/
        }

    }

    private class searchAddress implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if(searchAddress()) {
                addrScr.enableFields("SEARCH");
                addrScr.setFocus("NUMERO");
            } else {
                if(JOptionPane.showConfirmDialog(null, "O CEP informado não foi encontrado! Deseja continuar mesmo assim?","Atenção",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION){
                    addrScr.enableFields("SEARCH");
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
            if(count < 1){
                addrScr.clearFields();
                fillFieldsAddressScreen("SELECT *\nFROM " + getDbOwner() + "." + getTblAddress() + "\nWHERE ROW_ID = '" + addrScr.getSelectedRowIdAddressList() + "'");
                addrScr.setbtnEditEnabled(true);
                addrScr.setbtnDeleteEnabled(true);
                count++;
            } else {
                count = 0;
            }
        }
        
    }
    
}
