/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accountModule;

import addressModule.AddressController;
import contactModule.ContactController;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mathe
 */
public class AccountController extends Account {

    private String view; // ACCOUNT_INFO, ACCOUNT_CONT_ADDR, ACCOUNT_MORE_INFO, ACCOUNT_ORDERS
    
    public AccountController() throws InterruptedException { }

    public String getView() { return view; }
    public void setView(String view) { this.view = view; }

    @Override
    public void openAccountScreen(String screen, String query) {
        try {
            contCtrl = new ContactController();
            contCtrl.setDbUser(super.getDbUser());
            contCtrl.setDbPassword(super.getDbPassword());
        } catch (InterruptedException ex) {
            Logger.getLogger(AccountController.class.getName()).log(Level.SEVERE, null, ex);
        }
        accntScreen = new AccountScreen();
        accntScreen.setListenerBtnEdit(new buttonEdit());
        accntScreen.setListenerBtnNew(new buttonNew());
        accntScreen.setListenerBtnSave(new buttonSave());
        accntScreen.setListenerBtnCancel(new buttonCancel());
        accntScreen.setListenerBtnDelete(new buttonDelete());
        accntScreen.setListenerBtnAddContact(new manageContact());
        accntScreen.setListenerBtnAddAddress(new manageAddress());
        accntScreen.setListenerTblAccountListSelection(new ListSelected());
        accntScreen.setListenercbbListFilterValue(new CbbListFilterItemState());
        accntScreen.setListenertxtListFilterValue(new TxtListFilterValue());
        accntScreen.setListenerPanelAccountInfo(new PanelAccountInfoListener());
        accntScreen.setListenerPanelAccountContAddr(new PanelAccountContAddrListener());
        accntScreen.setListenerPanelAccountMoreInfo(new PanelAccountMoreInfoListener());
        accntScreen.setListenePanelAccountOrders(new PanelAccountOrdersListener());
        accntScreen.setListenercbbDocumentType(new CbbDocumentTypeItemState());
        
        switch(screen) {
            case "MAIN":
                query = "SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblAccount() + " ACC\nORDER BY ACC.ACCNT_NUMBER ASC";
                break;
            default:
                break;
        }
        
        accntScreen.clearFields();
        accntScreen.clearComboBoxes();
        accntScreen.enableFields("LOAD_SCREEN");
        accntScreen.insertSelectComboBox();
        this.setView("ACCOUNT_INFO");
        //this.setFunction("LOAD");
        this.fillComboBoxes("ACCOUNT_FILTER");
        this.fillComboBoxes("SEX_MF");
        this.fillComboBoxes("DOC_TYPE");
        this.fillComboBoxes("MONTH_DAY");
        this.fillComboBoxes("MONTH");
        this.fillComboBoxes("CIVIL_STATE");
        this.fillComboBoxes("DOCUMENT_TYPE");
        this.fillComboBoxes("STATE");
        this.fillComboBoxes("ACCOUNT_STATUS");
        this.fillComboBoxes("ACCOUNT_TYPE");
        
        this.fillList(query, "");
        accntScreen.setSelectedRowColumnList(0, 0);
        
        accntScreen.setFocus("FILTRO_VALOR");
    }

    @Override
    public void fillComboBoxes(String LovType) {
        try{
            ArrayList<ListOfValuesClass> lov = super.LookupList(LovType);
            
            if(lov.size() > 0){
                for(int i = 0; i < lov.size(); i++){
                    if(null == LovType){
                        JOptionPane.showMessageDialog(null, "O LOV_TYPE 'null' não existe!");
                    } else switch (LovType) {
                        case "ACCOUNT_FILTER": accntScreen.setcbbListFilter(lov.get(i).getValue()); break;
                        case "SEX_MF": accntScreen.setcbbSex(lov.get(i).getValue()); break;
                        case "DOC_TYPE": accntScreen.setcbbDocType(lov.get(i).getValue()); break;
                        case "MONTH_DAY": accntScreen.setcbbDay(lov.get(i).getValue()); break;
                        case "MONTH": accntScreen.setcbbMonth(lov.get(i).getValue()); break;
                        case "CIVIL_STATE": accntScreen.setcbbCivilState(lov.get(i).getValue()); break;
                        case "DOCUMENT_TYPE": accntScreen.setcbbIdentityType(lov.get(i).getValue()); break;
                        case "STATE": accntScreen.setcbbEmissionUF(lov.get(i).getValue()); break;
                        case "ACCOUNT_STATUS": accntScreen.setcbbAccountStatus(lov.get(i).getValue()); break;
                        case "ACCOUNT_TYPE": accntScreen.setcbbAccountType(lov.get(i).getValue()); break;
                        default: JOptionPane.showMessageDialog(null, "O LOV_TYPE '" + LovType +  "' não é utilizado por nenhum ComboBox!"); break;
                    }
                }
            }
        } catch(HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher ComboBoxes...\nErro: " + e);
        }
    }

    @Override
    public void fillList(String query, String method) {
        DefaultTableModel table = (DefaultTableModel) accntScreen.getTableModel();
        switch(method){
            case "INSERT_RECORD":
                //int newRow = table.getRowCount() + 1;
                try{
                    table.addRow(
                        new Object[] {
                            accntScreen.gettxtAccountNumber(),
                            accntScreen.gettxtDocNum(),
                            accntScreen.gettxtName() + " " + accntScreen.gettxtSurname(),
                            accntScreen.gettxtNickName(),
                            accntScreen.getcbbDay() + "/" + super.LookupName("MONTH", accntScreen.getcbbMonth()) + "/" + accntScreen.gettxtYear(),
                            accntScreen.getcbbCivilState(),
                            accntScreen.getcbbAccountStatus()
                        }
                    );
                } catch(Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro ao preencher tabela...\nErro: " + e);
                }
                break;
            case "UPDATE_RECORD":
                try{
                    table.setValueAt((accntScreen.gettxtAccountNumber() != null ? accntScreen.gettxtAccountNumber() : ""), accntScreen.getSelectedRowList(), 0);
                    table.setValueAt((accntScreen.gettxtDocNum() != null ? accntScreen.gettxtDocNum() : ""), accntScreen.getSelectedRowList(), 1);
                    table.setValueAt((accntScreen.gettxtName() != null ? accntScreen.gettxtName() + " " + accntScreen.gettxtSurname() : ""), accntScreen.getSelectedRowList(), 2);
                    table.setValueAt(accntScreen.gettxtNickName(), accntScreen.getSelectedRowList(), 3);
                    table.setValueAt((accntScreen.getcbbDay() != null && accntScreen.getcbbMonth() != null && accntScreen.gettxtYear() != null ? accntScreen.getcbbDay() + "/" + super.LookupName("MONTH", accntScreen.getcbbMonth()) + "/" + accntScreen.gettxtYear() : ""), accntScreen.getSelectedRowList(), 4);
                    table.setValueAt((accntScreen.getcbbCivilState() != null ? accntScreen.getcbbCivilState() : ""), accntScreen.getSelectedRowList(), 5);
                    table.setValueAt((accntScreen.getcbbAccountStatus() != null ? accntScreen.getcbbAccountStatus() : ""), accntScreen.getSelectedRowList(), 6);
                } catch(Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro ao preencher tabela...\nErro: " + e);
                }
                break;
            default:
                try{
                    ArrayList<AccountClass> accntList = super.queryAccountRecord(query);
                    
                    try{ AccntIdArray.clear(); } catch (Exception e) {}

                    if(!accntList.isEmpty()){
                        int count = accntList.size();
                        try{ table.setRowCount(count); } catch (Exception e) {}
                        try{ table.setNumRows(count); } catch (Exception e) {}
                        
                        for(int i = 0; i < count; i++){
                            AccntId = new accountIdClass();
                            AccntId.setRowId(accntList.get(i).getRowId());
                            AccntIdArray.add(AccntId);
                            table.setValueAt(accntList.get(i).getACCNT_NUMBER(), i, 0);
                            table.setValueAt(accntList.get(i).getDOC_NUM(), i, 1);
                            table.setValueAt(accntList.get(i).getFULL_NAME(), i, 2);
                            table.setValueAt(accntList.get(i).getNICK_NAME(), i, 3);
                            table.setValueAt(accntList.get(i).getBIRTH_DT(), i, 4);
                            table.setValueAt(accntList.get(i).getMARITAL_STAT_CD(), i, 5);
                            table.setValueAt(accntList.get(i).getSTATUS_CD(), i, 6);
                        }
                        
                    } else {
                        table.setRowCount(0);
                    }

                } catch(Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro ao preencher tabela...\nErro: " + e);
                }
                break;
        }
        accntScreen.setlblRecCount("0 - " + String.valueOf(AccntIdArray.size()));
    }

    @Override
    public void fillFields(String query) {
        try{
            ArrayList<AccountClass> accntList = queryAccountRecord(query);
            ArrayList<ContactClass> contList;
            ArrayList<SocialMediaClass> socMedList;
            ArrayList<AddressClass> addrList;

            if(!accntList.isEmpty()){
                for(int i = 0; i < accntList.size(); i++){
                    accntScreen.setlblAccountNameHeader(accntList.get(i).getFULL_NAME());
                    accntScreen.settxtRowId(accntList.get(i).getRowId());
                    accntScreen.settxtAccountNumber(accntList.get(i).getACCNT_NUMBER());
                    accntScreen.setcbbDocTypeItemIndex(accntScreen.getcbbDocTypeItemIndex(super.LookupValue("DOC_TYPE", accntList.get(i).getDOC_TYPE())));
                    accntScreen.settxtDocNum(accntList.get(i).getDOC_NUM());
                    accntScreen.settxtName(accntList.get(i).getFST_NAME());
                    accntScreen.settxtSurname(accntList.get(i).getLAST_NAME());
                    accntScreen.setcbbSexItemIndex(accntScreen.getcbbSexItemIndex(super.LookupValue("SEX_MF", accntList.get(i).getSEX_MF())));
                    accntScreen.settxtNickName(accntList.get(i).getNICK_NAME());
                    accntScreen.setcbbDayItemIndex(accntScreen.getcbbDayItemIndex(super.LookupValue("MONTH_DAY", accntList.get(i).getBIRTH_DAY())));
                    accntScreen.setcbbMonthItemIndex(accntScreen.getcbbMonthItemIndex(super.LookupValue("MONTH", accntList.get(i).getBIRTH_MONTH())));
                    accntScreen.settxtYear(accntList.get(i).getBIRTH_YEAR());
                    accntScreen.settxtBornLocation(accntList.get(i).getPLACE_OF_BIRTH());
                    accntScreen.setcbbAccountStatusItemIndex(accntScreen.getcbbAccountStatusItemIndex(super.LookupValue("ACCOUNT_STATUS", accntList.get(i).getSTATUS_CD())));
                    accntScreen.setcbbAccountTypeItemIndex(accntScreen.getcbbAccountTypeItemIndex(super.LookupValue("ACCOUNT_TYPE", accntList.get(i).getACCNT_TYPE_CD())));
                    accntScreen.setcbbCivilStateItemIndex(accntScreen.getcbbCivilStateItemIndex(super.LookupValue("CIVIL_STATE", accntList.get(i).getMARITAL_STAT_CD())));
                    accntScreen.settxtSpouseName(accntList.get(i).getNAME_CONJUGE());
                    accntScreen.settxtMotherName(accntList.get(i).getMOTHER_FULL_NAME());
                    accntScreen.settxtFatherName(accntList.get(i).getFATHER_FULL_NAME());
                    accntScreen.setcbbIdentityTypeItemIndex(accntScreen.getcbbIdentityTypeItemIndex(super.LookupValue("DOCUMENT_TYPE", accntList.get(i).getDOCUMENT_TYPE())));
                    accntScreen.settxtRecNum(accntList.get(i).getREGISTER_NUM());
                    accntScreen.settxtSerieNum(accntList.get(i).getREGISTER_SERIE());
                    accntScreen.settxtEmissor(accntList.get(i).getORGAO_EMISSOR());
                    accntScreen.setcbbEmissionUFItemIndex(accntScreen.getcbbEmissionUFItemIndex(super.LookupValue("STATE", accntList.get(i).getUF_EMISSAO())));
                    accntScreen.settxtEmissionDate(accntList.get(i).getEMISSION_DT());
                    accntScreen.settxtValidThru(accntList.get(i).getVALIDATION_DT());
                    accntScreen.settxtNaturalness(accntList.get(i).getNATURALNESS());
                    accntScreen.settxtNationality(accntList.get(i).getNATIONALITY());
                }
                
                contList = super.queryContactRecord("SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblContact() + " CON\nWHERE CON.PAR_ROW_ID = '" + AccntIdArray.get(accntScreen.getSelectedRowList()).getRowId() + "'\nAND CON.PR_CON_FLG = 'Y'");
                    
                if(!contList.isEmpty()){
                    accntScreen.settxtContactMPhone(contList.get(0).getMAIN_PH_NUM());
                    accntScreen.settxtContactEmail(contList.get(0).getEMAIL_ADDR());
                    accntScreen.settxtContactPhone(contList.get(0).getALT_PH_NUM());
                    accntScreen.settxtContactEnterprise(contList.get(0).getWORK_PH_NUM());
                    // Social Media Information
                    socMedList = super.querySocialMediaRecord("SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblSocialMedia()+ " SOC\nWHERE SOC.PAR_ROW_ID = '" + contList.get(0).getRow_id() + "'");
                    for(int cx = 0; cx < socMedList.size(); cx++) {
                        if(null != socMedList.get(cx).getSOCIAL_M_NAME()) {
                            switch (socMedList.get(cx).getSOCIAL_M_NAME()) {
                                case "Facebook":
                                    accntScreen.settxtFacebook(socMedList.get(cx).getSOCIAL_M_VALUE());
                                    break;
                                case "Twitter":
                                    accntScreen.settxtTwitter(socMedList.get(cx).getSOCIAL_M_VALUE());
                                    break;
                                case "Instagram":
                                    accntScreen.settxtInstagram(socMedList.get(cx).getSOCIAL_M_VALUE());
                                    break;
                                default:
                                    break;
                            }
                        }
                    }
                }

                addrList = super.queryAddressRecord("SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblAddress() + " ADDR\nWHERE ADDR.PAR_ROW_ID = '" + AccntIdArray.get(accntScreen.getSelectedRowList()).getRowId() +  "'\nAND ADDR.PR_ADDR_FLG = 'Y'");

                if(!addrList.isEmpty()) {
                    for(int a = 0; a < addrList.size(); a++) {
                        accntScreen.settxtFullAddress(addrList.get(a).getADDR_NAME());
                    }
                }
            }

        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher Campos...\nErro: " + e);
        }
    }

    @Override
    public void fillFieldsNewRecord() {
        accntScreen.settxtRowId(super.getNextRowId());
        accntScreen.settxtAccountNumber(super.getNextAccountNumber());
        accntScreen.setcbbAccountStatusItemIndex(accntScreen.getcbbAccountStatusItemIndex(super.LookupValue("ACCOUNT_STATUS", "Potential")));
        accntScreen.setcbbAccountTypeItemIndex(accntScreen.getcbbAccountTypeItemIndex(super.LookupValue("ACCOUNT_TYPE", "Customer")));
    }

    /**
     *
     * @return
     */
    @Override
    public boolean validateMandatoryFields() {
        String mensagem = "";
        int i = 0;
        String docType = super.LookupName("DOC_TYPE", accntScreen.getcbbDocType());
        String name = accntScreen.gettxtName();
        String surname = accntScreen.gettxtSurname();
        String sex = accntScreen.getcbbSex();
        
        if(name == null) { mensagem += "\n- " + "Nome" + ";"; i = (i < 1) ? 1 : i; }
        if(surname == null) {
            switch(docType) {
                case "CPF":
                    mensagem += "\n- " + "Sobrenome" + ";"; i = (i < 2 && i != 0) ? i : 2; 
                    break;
                case "CNPJ":
                    mensagem += "\n- " + "Nome Fantasia" + ";"; i = (i < 2 && i != 0) ? i : 2; 
                    break;
                default:
                    break;
            }
        }        
        if(sex == null) {
            if("CPF".equals(docType)) {
                mensagem += "\n- " + "Sexo" + ";"; i = (i < 3 && i != 0) ? i : 3;
            }
        }
        
        switch(i){
            case 1: accntScreen.setFocus("NOME"); break;
            case 2: accntScreen.setFocus("SOBRENOME"); break;
            case 3: accntScreen.setFocus("SEXO"); break;
            default: break;
        }
        
        if(!"".equals(mensagem)){
            JOptionPane.showMessageDialog(null, "Os campos abaixo são obrigatórios. Favor preencher os mesmos:" + mensagem);
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean validateFieldValues() {
        // Validate Field Sizes
        String AccntNum = accntScreen.gettxtAccountNumber();
        String docType = super.LookupName("DOC_TYPE", accntScreen.getcbbDocType());
        String docNumber = accntScreen.gettxtDocNum();
        String name = accntScreen.gettxtName();
        String lastName = accntScreen.gettxtSurname();
        String nickName = accntScreen.gettxtNickName();
        String birthYear = accntScreen.gettxtYear();
        String placeBirth = accntScreen.gettxtBornLocation();
        String maritalStatus = accntScreen.getcbbCivilState();
        String spouseName = accntScreen.gettxtSpouseName();
        String motherName = accntScreen.gettxtMotherName();
        String fatherName = accntScreen.gettxtFatherName();
        String identityType = accntScreen.getcbbIdentityType();
        String registerNum = accntScreen.gettxtRecNum();
        String serieNum = accntScreen.gettxtSerieNum();
        String emissorName = accntScreen.gettxtEmissor();
        String emissionState = accntScreen.getcbbEmissionUF();
        String emissionDate = ((accntScreen.gettxtEmissionDate() != null) ? super.convertDate(accntScreen.gettxtEmissionDate()) : null);
        String validThru = ((accntScreen.gettxtValidThru() != null) ? super.convertDate(accntScreen.gettxtValidThru()) : null);
        String naturalness = accntScreen.gettxtNaturalness();
        String nationality = accntScreen.gettxtNationality();
        
        if((AccntNum != null) && (AccntNum.length() > getAccntNumberColumnSize())) { JOptionPane.showMessageDialog(null, "O tamanho do campo 'Número do Cliente' deve ter no máximo: " + getAccntNumberColumnSize() + " caractere(s)"); return false; }
        if((docNumber != null) && (docNumber.length() > getDocNumberColumnSize())) { JOptionPane.showMessageDialog(null, "O tamanho do campo 'Documento' deve ter no máximo: " + getDocNumberColumnSize() + " caractere(s)"); return false; }
        if((name != null) && (name.length() > getFirstNameColumnSize())) { JOptionPane.showMessageDialog(null, "O tamanho do campo 'Nome' deve ter no máximo: " + getFirstNameColumnSize() + " caractere(s)"); return false; }
        switch(docType){
            case "CPF":
                if((lastName != null) && (lastName.length() > getLastNameColumnSize())) { JOptionPane.showMessageDialog(null, "O tamanho do campo 'Sobrenome' deve ter no máximo: " + getLastNameColumnSize() + " caractere(s)"); return false; }
                if((nickName != null) && (nickName.length() > getNickNameColumnSize())) { JOptionPane.showMessageDialog(null, "O tamanho do campo 'Apelido' deve ter no máximo: " + getNickNameColumnSize() + " caractere(s)"); return false; }
                if((birthYear != null) && (birthYear.length() > getDataNascimentoAno())) { JOptionPane.showMessageDialog(null, "O tamanho do campo 'Data de Nascimento - Ano' deve ter no máximo: " + getDataNascimentoAno() + " caractere(s)"); return false; }
                
                break;
            default:
                if((lastName != null) && (lastName.length() > getLastNameColumnSize())) { JOptionPane.showMessageDialog(null, "O tamanho do campo 'Nome Fantasia' deve ter no máximo: " + getLastNameColumnSize() + " caractere(s)"); return false; }
                if((birthYear != null) && (birthYear.length() > getDataNascimentoAno())) { JOptionPane.showMessageDialog(null, "O tamanho do campo 'Data de Abertura - Ano' deve ter no máximo: " + getDataNascimentoAno() + " caractere(s)"); return false; }
                break;
        }
        if((placeBirth != null) && (placeBirth.length() > getPlaceOfBirtColumnSize())) { JOptionPane.showMessageDialog(null, "O tamanho do campo 'Local do Nascimento' deve ter no máximo: " + getPlaceOfBirtColumnSize() + " caractere(s)"); return false; }
        if((maritalStatus != null) && (maritalStatus.length() > getMaritalStatusColumnSize())) { JOptionPane.showMessageDialog(null, "O tamanho do campo 'Estado Civil' deve ter no máximo: " + getMaritalStatusColumnSize() + " caractere(s)"); return false; }
        if((spouseName != null) && (spouseName.length() > getConjugeNameColumnSize())) { JOptionPane.showMessageDialog(null, "O tamanho do campo 'Nome do Cônjuge' deve ter no máximo: " + getConjugeNameColumnSize() + " caractere(s)"); return false; }
        if((motherName != null) && (motherName.length() > getMotherNameColumnSize())) { JOptionPane.showMessageDialog(null, "O tamanho do campo 'Nome da Mãe' deve ter no máximo: " + getMotherNameColumnSize() + " caractere(s)"); return false; }
        if((fatherName != null) && (fatherName.length() > getFatherNameColumnSize())) { JOptionPane.showMessageDialog(null, "O tamanho do campo 'Nome do Pai' deve ter no máximo: " + getFatherNameColumnSize() + " caractere(s)"); return false; }
        if((identityType != null) && (identityType.length() > getDocumentTypeColumnSize())) { JOptionPane.showMessageDialog(null, "O tamanho do campo 'Tipo de Identificação' deve ter no máximo: " + getDocumentTypeColumnSize() + " caractere(s)"); return false; }
        if((registerNum != null) && (registerNum.length() > getRegisterNumColumnSize())) { JOptionPane.showMessageDialog(null, "O tamanho do campo 'Registro' deve ter no máximo: " + getRegisterNumColumnSize() + " caractere(s)"); return false; }
        if((serieNum != null) && (serieNum.length() > getRegisterSerieColumnSize())) { JOptionPane.showMessageDialog(null, "O tamanho do campo 'Série' deve ter no máximo: " + getRegisterSerieColumnSize() + " caractere(s)"); return false; }
        if((emissorName != null) && (emissorName.length() > getOrgaoEmissorColumnSize())) { JOptionPane.showMessageDialog(null, "O tamanho do campo 'Órgão Emissor' deve ter no máximo: " + getOrgaoEmissorColumnSize() + " caractere(s)"); return false; }
        if((emissionState != null) && (emissionState.length() > getUfEmissaoColumnSize())) { JOptionPane.showMessageDialog(null, "O tamanho do campo 'UF Emissão' deve ter no máximo: " + getUfEmissaoColumnSize() + " caractere(s)"); return false; }
        if((emissionDate != null) && (emissionDate.length() > getEmissionDate())) { JOptionPane.showMessageDialog(null, "O tamanho do campo 'Data Emissão' deve ter no máximo: " + getEmissionDate() + " caractere(s)"); return false; }
        if((validThru != null) && (validThru.length() > getValidThru())) { JOptionPane.showMessageDialog(null, "O tamanho do campo 'Data de Validade' deve ter no máximo: " + getValidThru() + " caractere(s)"); return false; }
        if((naturalness != null) && (naturalness.length() > getNaturalnessColumnSize())) { JOptionPane.showMessageDialog(null, "O tamanho do campo 'Naturalidade' deve ter no máximo: " + getNaturalnessColumnSize() + " caractere(s)"); return false; }
        if((nationality != null) && (nationality.length() > getNaturalityColumnSize())) { JOptionPane.showMessageDialog(null, "O tamanho do campo 'Nacionalidade' deve ter no máximo: " + getNaturalityColumnSize() + " caractere(s)"); return false; }
        
        return true;
    }

    @Override
    public boolean insert() {
        long age = 0;
        
        String accntId = super.getNextRowId();
        String accntNumber = super.getNextAccountNumber();
        String docType = super.LookupName("DOC_TYPE", accntScreen.getcbbDocType());
        String docNumber = accntScreen.gettxtDocNum();
        String name = accntScreen.gettxtName();
        String lastName = accntScreen.gettxtSurname();
        String sex = super.LookupName("SEX_MF", accntScreen.getcbbSex());
        String nickName = accntScreen.gettxtNickName();
        String birthDay = accntScreen.getcbbDay();
        String birthMonth = super.LookupName("MONTH", accntScreen.getcbbMonth());
        String birthYear = accntScreen.gettxtYear();
        String birthCompleteENU = super.convertDate(birthMonth + "/" + birthDay + "/" + birthYear);
        String placeBirth = accntScreen.gettxtBornLocation();
        String status = super.LookupName("ACCOUNT_STATUS", accntScreen.getcbbAccountStatus());
        String accntType = accntScreen.getcbbAccountType();
        String maritalStatus = accntScreen.getcbbCivilState();
        String spouseName = accntScreen.gettxtSpouseName();
        String motherName = accntScreen.gettxtMotherName();
        String fatherName = accntScreen.gettxtFatherName();
        String identityType = accntScreen.getcbbIdentityType();
        String registerNum = accntScreen.gettxtRecNum();
        String serieNum = accntScreen.gettxtSerieNum();
        String emissorName = accntScreen.gettxtEmissor();
        String emissionState = accntScreen.getcbbEmissionUF();
        String emissionDate = super.convertDate(accntScreen.gettxtEmissionDate());
        String validThru = super.convertDate(accntScreen.gettxtValidThru());
        String naturalness = accntScreen.gettxtNaturalness();
        String nationality = accntScreen.gettxtNationality();
        
        String month = super.LookupValue("MONTH_TRANSLATION", accntScreen.getcbbMonth()).toUpperCase();
        
        if(!"".equals(month) && month != null) {
            LocalDate today = LocalDate.now();
            LocalDate birthDate = LocalDate.of(Integer.parseInt(birthYear), Month.valueOf(month), Integer.parseInt(birthDay));
            age = ChronoUnit.YEARS.between(birthDate, today);

            if(today.getMonthValue() >= birthDate.getMonthValue()) {
                if(today.getDayOfMonth() >= birthDate.getDayOfMonth()) {
                    age++;
                }
            }
        }
        
        super.clearColumns();
        super.clearValues();
        
        super.setColumns(",\n\t" + "PAR_ROW_ID"); super.setValues(",\n\t" + "NULL");
        super.setColumns(",\n\t" + "ACCNT_NUMBER"); super.setValues(",\n\t" + "'" + accntNumber + "'");
        super.setColumns(",\n\t" + "DOC_TYPE"); super.setValues(",\n\t" + ((docType != null) ? "'" + docType + "'" : "NULL"));
        super.setColumns(",\n\t" + "DOC_NUM"); super.setValues(",\n\t" + ((docNumber != null) ? "'" + docNumber + "'" : "NULL"));
        
        switch(docType) {
            case "CPF":
                super.setColumns(",\n\t" + "ALIAS_NAME"); super.setValues(",\n\t" + "NULL");
                super.setColumns(",\n\t" + "NOME_FANTASIA"); super.setValues(",\n\t" + "NULL");
                super.setColumns(",\n\t" + "FST_NAME"); super.setValues(",\n\t" + ((name != null) ? "'" + name + "'" : "NULL"));
                super.setColumns(",\n\t" + "LAST_NAME"); super.setValues(",\n\t" + ((lastName != null) ? "'" + lastName + "'" : "NULL"));
                super.setColumns(",\n\t" + "FULL_NAME"); super.setValues(",\n\t" + ((name != null && lastName != null) ? "'" + name + " " + lastName + "'" : "NULL"));
                super.setColumns(",\n\t" + "NICK_NAME"); super.setValues(",\n\t" + ((nickName != null) ? nickName : "NULL"));
                super.setColumns(",\n\t" + "AGE"); super.setValues(",\n\t" + ((age >= 0) ? age : "NULL"));
                super.setColumns(",\n\t" + "ENTERPRISE_FLAG"); super.setValues(",\n\t" + "'N'");
                super.setColumns(",\n\t" + "PODER_PUBLICO_FLG"); super.setValues(",\n\t" + "'N'");
                super.setColumns(",\n\t" + "PARTNER_FLG"); super.setValues(",\n\t" + "'N'");
                super.setColumns(",\n\t" + "ATIV_COMERCIAL"); super.setValues(",\n\t" + "NULL");
                super.setColumns(",\n\t" + "INSCR_MUNICIPAL"); super.setValues(",\n\t" + "NULL");
                super.setColumns(",\n\t" + "INSCR_ESTADUAL"); super.setValues(",\n\t" + "NULL");
                break;
            case "CNPJ":
                super.setColumns(",\n\t" + "ALIAS_NAME"); super.setValues(",\n\t" + ((name != null) ? "'" + name + "'" : "NULL"));
                super.setColumns(",\n\t" + "NOME_FANTASIA"); super.setValues(",\n\t" + ((lastName != null) ? "'" + lastName + "'" : "NULL"));
                super.setColumns(",\n\t" + "FST_NAME"); super.setValues(",\n\t" + "NULL");
                super.setColumns(",\n\t" + "LAST_NAME"); super.setValues(",\n\t" + "NULL");
                super.setColumns(",\n\t" + "FULL_NAME"); super.setValues(",\n\t" + "NULL");
                super.setColumns(",\n\t" + "NICK_NAME"); super.setValues(",\n\t" + "NULL");
                super.setColumns(",\n\t" + "AGE"); super.setValues(",\n\t" + "NULL");
                super.setColumns(",\n\t" + "ENTERPRISE_FLAG"); super.setValues(",\n\t" + "'Y'");
                super.setColumns(",\n\t" + "PODER_PUBLICO_FLG"); super.setValues(",\n\t" + "'N'");
                super.setColumns(",\n\t" + "PARTNER_FLG"); super.setValues(",\n\t" + "'N'");
                super.setColumns(",\n\t" + "ATIV_COMERCIAL"); super.setValues(",\n\t" + "NULL");
                super.setColumns(",\n\t" + "INSCR_MUNICIPAL"); super.setValues(",\n\t" + "NULL");
                super.setColumns(",\n\t" + "INSCR_ESTADUAL"); super.setValues(",\n\t" + "NULL");
                break;
            default:
                break;
        }
        super.setColumns(",\n\t" + "BIRTH_DT"); super.setValues(",\n\t" + ((birthDay != null && birthMonth != null && birthYear != null) ? birthCompleteENU : "NULL"));
        super.setColumns(",\n\t" + "PLACE_OF_BIRTH"); super.setValues(",\n\t" + ((placeBirth != null) ? "'" + placeBirth + "'" : "NULL"));
        super.setColumns(",\n\t" + "SEX_MF"); super.setValues(",\n\t" + ((sex != null) ? "'" + sex + "'" : "NULL"));
        super.setColumns(",\n\t" + "MARITAL_STAT_CD"); super.setValues(",\n\t" + ((maritalStatus != null) ? "'" + maritalStatus + "'" : "NULL"));
        super.setColumns(",\n\t" + "NAME_CONJUGE"); super.setValues(",\n\t" + ((spouseName != null) ? "'" + spouseName + "'" : "NULL"));
        super.setColumns(",\n\t" + "MOTHER_FULL_NAME"); super.setValues(",\n\t" + ((motherName != null) ? "'" + motherName + "'" : "NULL"));
        super.setColumns(",\n\t" + "FATHER_FULL_NAME"); super.setValues(",\n\t" + ((fatherName != null) ? "'" + fatherName + "'" : "NULL"));
        super.setColumns(",\n\t" + "ACCNT_TYPE_CD"); super.setValues(",\n\t" + ((accntType != null) ? "'" + accntType + "'" : "NULL"));
        super.setColumns(",\n\t" + "CREATOR_LOGIN"); super.setValues(",\n\t" + "'" + super.getDbUser() + "'");
        super.setColumns(",\n\t" + "DESC_TEXT"); super.setValues(",\n\t" + "NULL");
        super.setColumns(",\n\t" + "PR_ADDR_ID"); super.setValues(",\n\t" + "NULL");
        super.setColumns(",\n\t" + "PR_CON_ID"); super.setValues(",\n\t" + "NULL");
        super.setColumns(",\n\t" + "PR_PHONE_ID"); super.setValues(",\n\t" + "NULL");
        super.setColumns(",\n\t" + "STATUS_CD"); super.setValues(",\n\t" + ((status != null) ? "'" + status + "'" : "NULL"));
        super.setColumns(",\n\t" + "DOCUMENT_TYPE"); super.setValues(",\n\t" + ((identityType != null) ? "'" + identityType + "'" : "NULL"));
        super.setColumns(",\n\t" + "REGISTER_NUM"); super.setValues(",\n\t" + ((registerNum != null) ? "'" + registerNum + "'" : "NULL"));
        super.setColumns(",\n\t" + "REGISTER_SERIE"); super.setValues(",\n\t" + ((serieNum != null) ? "'" + serieNum + "'" : "NULL"));
        super.setColumns(",\n\t" + "ORGAO_EMISSOR"); super.setValues(",\n\t" + ((emissorName != null) ? "'" + emissorName + "'" : "NULL"));
        super.setColumns(",\n\t" + "UF_EMISSAO"); super.setValues(",\n\t" + ((emissionState != null) ? "'" + emissionState + "'" : "NULL"));
        super.setColumns(",\n\t" + "NATURALNESS"); super.setValues(",\n\t" + ((naturalness != null) ? "'" + naturalness + "'" : "NULL"));
        super.setColumns(",\n\t" + "NATIONALITY"); super.setValues(",\n\t" + ((nationality != null) ? "'" + nationality + "'" : "NULL"));
        super.setColumns(",\n\t" + "EMISSION_DT"); super.setValues(",\n\t" + ((emissionDate != null) ? emissionDate : "NULL"));
        super.setColumns(",\n\t" + "VALIDATION_DT"); super.setValues(",\n\t" + ((validThru != null) ? validThru : "NULL"));
        super.setColumns(",\n\t" + "ACTIVE_FLG"); super.setValues(",\n\t" + "'Y'");
        super.setColumns(",\n\t" + "ACCNT_FLG"); super.setValues(",\n\t" + "'Y'");
        super.setColumns(",\n\t" + "POTENTIAL_FLG"); super.setValues(",\n\t" + "'Y'");
        
        try {
            if("true".equals(super.insertRecord(super.getTblAccount(), super.getColumns(), super.getValues()))){
                super.generateAccountNumberTrigger();
                AccntId = new accountIdClass();
                AccntId.setRowId(accntId);
                AccntIdArray.add(AccntId);
                this.setLastAccntAdd(accntId);
                this.clearColumns();
                this.clearValues();
                super.setSilentInsertMode(true);
                
                try{
                    if(!contCtrl.getContRowIdArray().isEmpty()){
                        for(int i = 0; i < contCtrl.getContRowIdArray().size(); i ++){
                            super.clearColumnsValues();
                            super.clearCondition();
                            super.setColumnsValues(",\n\t" + "PAR_ROW_ID = '" + AccntId + "'");
                            super.setColumnsValues(",\n\t" + "PAR_USR_ID = 'NULL'");
                            super.setColumnsValues(",\n\t" + "EMP_FLG = 'N'");

                            try{
                                contCtrl.updateContact("ACCOUNT", super.getColumnsValues(), super.getCondition(), contCtrl.getContRowIdArray().get(i).getRow_id());
                            } catch(Exception e) {
                                System.out.println(super.getDateTime() + "\tContactModule.ContactController\t\tinsertContact\nUpdateSocialMedia\tError Exception\tError: " + e);
                            }
                        }
                        contCtrl.clearContRowIdArray();
                    }
                } catch(Exception e) { }
                
                try{
                    if(!contCtrl.getSocialMediaRowIdArray().isEmpty()){
                        for(int i = 0; i < contCtrl.getSocialMediaRowIdArray().size(); i ++){
                            super.clearColumnsValues();
                            super.clearCondition();
                            super.setColumnsValues(",\n\t" + "PAR_ACCNT_ID = '" + AccntId + "'");

                            try{
                                contCtrl.updateSocialMedia("ACCOUNT", super.getColumnsValues(), super.getCondition(), contCtrl.getSocialMediaRowIdArray().get(i).getRow_id());
                            } catch(Exception e) {
                                System.out.println(super.getDateTime() + "\tContactModule.ContactController\t\tinsertContact\nUpdateSocialMedia\tError Exception\tError: " + e);
                            }
                        }
                        contCtrl.clearSocialMediaRowIdArray();
                        
                    }
                } catch(Exception e) { }
                
                try{
                    if(!addrCtrl.getAddressRowIdArray().isEmpty()){
                        for(int i = 0; i < addrCtrl.getAddressRowIdArray().size(); i ++){
                            super.clearColumnsValues();
                            super.clearCondition();
                            super.setColumnsValues(",\n\t" + "PAR_ROW_ID = '" + accntId + "'");

                            try{
                                addrCtrl.update("ACCOUNT", super.getColumnsValues(), super.getCondition(), addrCtrl.getAddressRowIdArray().get(i).getRow_id());
                            } catch(Exception e) {
                                System.out.println(super.getDateTime() + "\tContactModule.ContactController\t\tinsertContact\nUpdateSocialMedia\tError Exception\tError: " + e);
                            }
                        }
                        addrCtrl.clearAddressRowIdArray();
                    }
                } catch(Exception e) { }
                
                this.updateAccountPrimaryContactAddress(accntId);
                
                super.setSilentInsertMode(false);
                this.fillList(null, "INSERT_RECORD");
                return true;
            } else {
                accntId = null;
                this.clearColumns();
                this.clearValues();
                return false;
            }
        } catch (Exception e) {
            accntId = null;
            this.clearColumns();
            this.clearValues();
            return false;
        }
    }

    @Override
    public boolean update() {
        boolean retorno = false;
        long age = 0;
        
        String docType = super.LookupName("DOC_TYPE", accntScreen.getcbbDocType());
        String docNumber = accntScreen.gettxtDocNum();
        String name = accntScreen.gettxtName();
        String lastName = accntScreen.gettxtSurname();
        String fullName = ((name != null && lastName != null) ? name + " " + lastName : null);
        String sex = super.LookupName("SEX_MF", accntScreen.getcbbSex());
        String nickName = accntScreen.gettxtNickName();
        String birthDay = accntScreen.getcbbDay();
        String birthMonth = super.LookupName("MONTH", accntScreen.getcbbMonth());
        String birthYear = accntScreen.gettxtYear();
        String birthCompleteENU = ((birthDay != null && birthMonth != null && birthYear!= null) ? super.convertDate(birthMonth + "/" + birthDay + "/" + birthYear) : null);
        String placeBirth = accntScreen.gettxtBornLocation();
        String accntType = accntScreen.getcbbAccountType();
        String maritalStatus = accntScreen.getcbbCivilState();
        String spouseName = accntScreen.gettxtSpouseName();
        String motherName = accntScreen.gettxtMotherName();
        String fatherName = accntScreen.gettxtFatherName();
        String identityType = accntScreen.getcbbIdentityType();
        String registerNum = accntScreen.gettxtRecNum();
        String serieNum = accntScreen.gettxtSerieNum();
        String emissorName = accntScreen.gettxtEmissor();
        String emissionState = accntScreen.getcbbEmissionUF();
        String emissionDate = ((accntScreen.gettxtEmissionDate() != null) ? super.convertDate(accntScreen.gettxtEmissionDate()) : null);
        String validThru = ((accntScreen.gettxtValidThru() != null) ? super.convertDate(accntScreen.gettxtValidThru()) : null);
        String naturalness = accntScreen.gettxtNaturalness();
        String nationality = accntScreen.gettxtNationality();
        
        String month = ((accntScreen.getcbbMonth() != null) ? super.LookupValue("MONTH_TRANSLATION", accntScreen.getcbbMonth()).toUpperCase() : null);
        
        if(!"".equals(month) && month != null) {
            LocalDate today = LocalDate.now();
            LocalDate birthDate = LocalDate.of(Integer.parseInt(birthYear), Month.valueOf(month), Integer.parseInt(birthDay));
            age = ChronoUnit.YEARS.between(birthDate, today);


            if(today.getMonthValue() >= birthDate.getMonthValue()) {
                if(today.getDayOfMonth() >= birthDate.getDayOfMonth()) {
                    age++;
                }
            }
        }
        
        super.clearColumnsValues();
        super.clearCondition();
        
        // Custom Columns
        super.setColumnsValues(",\n\t" + "MODIFICATION_NUM = (SELECT MODIFICATION_NUM + 1 FROM " + super.getDbOwner() + "." + super.getTblAccount() + " WHERE ROW_ID = '" + AccntIdArray.get(accntScreen.getSelectedRowList()).getRowId() + "')");
        super.setColumnsValues(",\n\t" + "DOC_TYPE = " + ((docType != null) ? "'" + docType + "'" : "NULL"));
        super.setColumnsValues(",\n\t" + "DOC_NUM = " + ((docNumber != null) ? "'" + docNumber + "'" : "NULL"));
        switch(docType) {
            case "CPF":
                super.setColumnsValues(",\n\t" + "FST_NAME = " + ((name != null) ? "'" + name + "'" : "NULL"));
                super.setColumnsValues(",\n\t" + "LAST_NAME = " + ((lastName != null) ? "'" + lastName + "'" : "NULL"));
                super.setColumnsValues(",\n\t" + "FULL_NAME = " + ((fullName != null) ? "'" + fullName + "'" : "NULL"));
                super.setColumnsValues(",\n\t" + "ALIAS_NAME = " + "NULL");
                super.setColumnsValues(",\n\t" + "NOME_FANTASIA = " + "NULL");
                super.setColumnsValues(",\n\t" + "NICK_NAME = " + ((nickName != null) ? "'" + nickName + "'" : "NULL"));
                super.setColumnsValues(",\n\t" + "AGE = " + ((age >= 0) ? "'" + age + "'" : "NULL"));
                super.setColumnsValues(",\n\t" + "BIRTH_DT = " + ((birthCompleteENU != null) ? birthCompleteENU : "NULL"));
                super.setColumnsValues(",\n\t" + "PLACE_OF_BIRTH = " + ((placeBirth != null) ? "'" + placeBirth + "'" : "NULL"));
                super.setColumnsValues(",\n\t" + "SEX_MF = " + ((sex != null) ? "'" + sex + "'" : "NULL"));
                super.setColumnsValues(",\n\t" + "ENTERPRISE_FLAG = " + "'N'");
                super.setColumnsValues(",\n\t" + "PODER_PUBLICO_FLG = " + "'N'");
                super.setColumnsValues(",\n\t" + "PARTNER_FLG = " + "'N'");
                super.setColumnsValues(",\n\t" + "ATIV_COMERCIAL = " + "NULL");
                super.setColumnsValues(",\n\t" + "INSCR_MUNICIPAL = " + "NULL");
                super.setColumnsValues(",\n\t" + "INSCR_ESTADUAL = " + "NULL");
                break;
            case "CNPJ":
                super.setColumnsValues(",\n\t" + "FST_NAME = " + "NULL");
                super.setColumnsValues(",\n\t" + "LAST_NAME = " + "NULL");
                super.setColumnsValues(",\n\t" + "FULL_NAME = " + "NULL");
                super.setColumnsValues(",\n\t" + "ALIAS_NAME = " + ((name != null) ? "'" + name + "'" : "NULL"));
                super.setColumnsValues(",\n\t" + "NOME_FANTASIA = " + ((lastName != null) ? "'" + lastName + "'" : "NULL"));
                super.setColumnsValues(",\n\t" + "NICK_NAME = " + "NULL");
                super.setColumnsValues(",\n\t" + "AGE = " + "NULL");
                super.setColumnsValues(",\n\t" + "PLACE_OF_BIRTH = " + "NULL");
                super.setColumnsValues(",\n\t" + "SEX_MF = " + "NULL");
                super.setColumnsValues(",\n\t" + "ENTERPRISE_FLAG = " + "'Y'");
                super.setColumnsValues(",\n\t" + "PODER_PUBLICO_FLG = " + "'N'");
                super.setColumnsValues(",\n\t" + "PARTNER_FLG = " + "'N'");
                super.setColumnsValues(",\n\t" + "ATIV_COMERCIAL = " + "NULL");
                super.setColumnsValues(",\n\t" + "INSCR_MUNICIPAL = " + "NULL");
                super.setColumnsValues(",\n\t" + "INSCR_ESTADUAL = " + "NULL");
                break;
            default:
                break;
        }
        super.setColumnsValues(",\n\t" + "MARITAL_STAT_CD = " + ((maritalStatus != null) ? "'" + maritalStatus + "'" : "NULL"));
        super.setColumnsValues(",\n\t" + "NAME_CONJUGE = " + ((spouseName != null) ? "'" + spouseName + "'" : "NULL"));
        super.setColumnsValues(",\n\t" + "MOTHER_FULL_NAME = " + ((motherName != null) ? "'" + motherName + "'" : "NULL"));
        super.setColumnsValues(",\n\t" + "FATHER_FULL_NAME = " + ((fatherName != null) ? "'" + fatherName + "'" : "NULL"));
        super.setColumnsValues(",\n\t" + "DOCUMENT_TYPE = " + ((identityType != null) ? "'" + identityType + "'" : "NULL"));
        super.setColumnsValues(",\n\t" + "REGISTER_NUM = " + ((registerNum != null) ? "'" + registerNum + "'" : "NULL"));
        super.setColumnsValues(",\n\t" + "REGISTER_SERIE = " + ((serieNum != null) ? "'" + serieNum + "'" : "NULL"));
        super.setColumnsValues(",\n\t" + "ORGAO_EMISSOR = " + ((emissorName != null) ? "'" + emissorName + "'" : "NULL"));
        super.setColumnsValues(",\n\t" + "UF_EMISSAO = " + ((emissionState != null) ? "'" + emissionState + "'" : "NULL"));
        super.setColumnsValues(",\n\t" + "EMISSION_DT = " + ((emissionDate != null) ?  emissionDate  : "NULL"));
        super.setColumnsValues(",\n\t" + "VALIDATION_DT = " + ((validThru != null) ? validThru : "NULL"));
        super.setColumnsValues(",\n\t" + "NATURALNESS = " + ((naturalness != null) ? "'" + naturalness + "'" : "NULL"));
        super.setColumnsValues(",\n\t" + "NATIONALITY = " + ((nationality != null) ? "'" + nationality + "'" : "NULL"));
        super.setColumnsValues(",\n\t" + "ACCNT_TYPE_CD = " + ((accntType != null) ? "'" + accntType + "'" : "NULL"));
        super.setColumnsValues(",\n\t" + "ACTIVE_FLG = " + "'Y'");
        super.setColumnsValues(",\n\t" + "ACCNT_FLG = " + "'Y'");
        super.setColumnsValues(",\n\t" + "POTENTIAL_FLG = " + "'Y'");
        
        super.setCondition("ROW_ID = '" + AccntIdArray.get(accntScreen.getSelectedRowList()).getRowId() + "'");
        
        try{
            this.clearCount();
            this.setCount(super.updateRecord(super.getTblAccount(), super.getColumnsValues(), super.getCondition()));
            if(this.getCount() > 0){
                this.setLastAccntUpd(AccntIdArray.get(accntScreen.getSelectedRowList()).getRowId());   
                super.clearColumnsValues();
                super.clearCondition();
                super.setSilentInsertMode(true);
                
                try{
                    if(!contCtrl.getContRowIdArray().isEmpty()){
                        for(int i = 0; i < contCtrl.getContRowIdArray().size(); i ++){
                            super.clearColumnsValues();
                            super.clearCondition();
                            super.setColumnsValues(",\n\t" + "PAR_ROW_ID = '" + AccntIdArray.get(accntScreen.getSelectedRowList()).getRowId() + "'");
                            super.setColumnsValues(",\n\t" + "PAR_USR_ID = NULL");
                            super.setColumnsValues(",\n\t" + "EMP_FLG = 'N'");
                            
                            try{
                                contCtrl.updateContact("ACCOUNT", super.getColumnsValues(), super.getCondition(), contCtrl.getContRowIdArray().get(i).getRow_id());
                            } catch(Exception e) {
                                System.out.println(super.getDateTime() + "\tContactModule.ContactController\t\tinsertContact\nUpdateSocialMedia\tError Exception\tError: " + e);
                            }
                        }
                        contCtrl.clearContRowIdArray();
                    }
                } catch (Exception e) { }

                try{
                    if(!contCtrl.getSocialMediaRowIdArray().isEmpty()){
                        for(int i = 0; i < contCtrl.getSocialMediaRowIdArray().size(); i ++){
                            super.clearColumnsValues();
                            super.clearCondition();
                            super.setColumnsValues(",\n\t" + "PAR_ROW_ID = '" + AccntIdArray.get(accntScreen.getSelectedRowList()).getRowId() + "'");

                            try{
                                contCtrl.updateSocialMedia("ACCOUNT", super.getColumnsValues(), super.getCondition(), contCtrl.getSocialMediaRowIdArray().get(i).getRow_id());
                            } catch(Exception e) {
                                System.out.println(super.getDateTime() + "\tContactModule.ContactController\t\tinsertContact\nUpdateSocialMedia\tError Exception\tError: " + e);
                            }
                        }
                        contCtrl.clearSocialMediaRowIdArray();
                    }
                } catch(Exception e) { }

                try{
                    if(!addrCtrl.getAddressRowIdArray().isEmpty()){
                        for(int i = 0; i < addrCtrl.getAddressRowIdArray().size(); i ++){
                            super.clearColumnsValues();
                            super.clearCondition();
                            super.setColumnsValues(",\n\t" + "PAR_ROW_ID = '" + AccntIdArray.get(accntScreen.getSelectedRowList()).getRowId() + "'");
                            
                            try{
                                addrCtrl.update("ACCOUNT", super.getColumnsValues(), super.getCondition(), addrCtrl.getAddressRowIdArray().get(i).getRow_id());
                            } catch(Exception e) {
                                System.out.println(super.getDateTime() + "\tContactModule.ContactController\t\tinsertContact\nUpdateSocialMedia\tError Exception\tError: " + e);
                            }
                        }
                        addrCtrl.clearAddressRowIdArray();
                    }
                } catch (Exception e) { }
                
                this.updateAccountPrimaryContactAddress(AccntIdArray.get(accntScreen.getSelectedRowList()).getRowId());
                
                super.setSilentInsertMode(false);
                this.fillList(null, "UPDATE_RECORD");
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

    @Override
    public boolean delete() {
        int countAccount = 0;
        int countContact = 0;
        int countSocialMedia = 0;
        int countAddress = 0;
        
        if(super.wishDeleteRecord()){
            try{
                super.clearCondition();

                ArrayList<ContactClass> contact = null;
                ArrayList<SocialMediaClass> socialMedia = null;
                ArrayList<AddressClass> addr = null;

                // Query Account Contacts
                contact = super.queryContactRecord("SELECT *\nFROM " + super.getDbOwner() + "." + getTblContact() + " CON\nWHERE CON.PAR_ROW_ID = '" + AccntIdArray.get(accntScreen.getSelectedRowList()).getRowId() + "'");

                // If Contact records were found, query Social Media Recods
                if(!contact.isEmpty()) {
                    // Prepare condition to query Social Media Records
                    super.setCondition("PAR_ROW_ID IN (");
                    for(int i = 0; i < contact.size(); i++){
                        if(i == 0){
                            super.setCondition("\n\t'" + contact.get(i).getRow_id() + "'");
                        } else {
                            super.setCondition(",\n\t'" + contact.get(i).getRow_id() + "'");
                        }
                    }
                    super.setCondition("\n)");

                    // Query Social Media Recods
                    socialMedia = super.querySocialMediaRecord("SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblSocialMedia() + " SOC\nWHERE " + super.getCondition());

                    // If Social Media were found, we delete then
                    if(!socialMedia.isEmpty()){
                        countSocialMedia = super.deleteRecord(super.getTblSocialMedia(), super.getCondition());
                    }

                    super.clearCondition();

                    // Prepare condition to DELETE Contact Records
                    super.setCondition("ROW_ID IN (");
                    for(int i = 0; i < contact.size(); i++){
                        if(i == 0){
                            super.setCondition("\n\t'" + contact.get(i).getRow_id() + "'");
                        } else {
                            super.setCondition(",\n\t'" + contact.get(i).getRow_id() + "'");
                        }
                    }
                    super.setCondition("\n)");

                    // Deleting Contats
                    countContact = super.deleteRecord(super.getTblContact(), super.getCondition());
                    super.clearCondition();
                }
                
                addr = queryAddressRecord("SELECT *\nFROM " + super.getDbOwner() + "." + getTblAddress() + " ADDR\nWHERE ADDR.PAR_ROW_ID = '" + AccntIdArray.get(accntScreen.getSelectedRowList()).getRowId() + "'");
                
                if(!addr.isEmpty()) {
                    super.clearCondition();

                    // Prepare condition to DELETE Contact Records
                    super.setCondition("ROW_ID IN (");
                    for(int i = 0; i < addr.size(); i++){
                        if(i == 0){
                            super.setCondition("\n\t'" + addr.get(i).getRow_id() + "'");
                        } else {
                            super.setCondition(",\n\t'" + addr.get(i).getRow_id() + "'");
                        }
                    }
                    super.setCondition("\n)");

                    // Deleting Contats
                    countAddress = super.deleteRecord(super.getTblAddress(), super.getCondition());
                    super.clearCondition();
                }
                
            } catch (HeadlessException e) { }
            
            super.clearCondition();
            super.setCondition("ROW_ID = '" + AccntIdArray.get(accntScreen.getSelectedRowList()).getRowId() + "'");
            try{
                countAccount = super.deleteRecord(super.getTblAccount(), super.getCondition());
                if(countAccount > 0){
                    AccntIdArray.remove(accntScreen.getSelectedRowList());
                    accntScreen.removeRowFromList(accntScreen.getSelectedRowList());
                    JOptionPane.showMessageDialog(null, "Registro(s) removido(s) com sucesso! Total de registros removidos:\nClientes: " + countAccount + " registro(s)\nContato: " + countContact + " registro(s)\nRedes Sociais: " + countSocialMedia + " registro(s)\nEndereço: " + countAddress + " registro(s)");
                    accntScreen.setSelectedRowColumnList(0, 0);
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

    @Override
    public void save() {
        if(validateMandatoryFields() && validateFieldValues()){
            DefaultTableModel table = (DefaultTableModel) accntScreen.getTableModel();
            table.getRowCount();
            try{
                ArrayList<AccountClass> accntList = queryAccountRecord("SELECT *\nFROM " + getDbOwner() + "." + getTblAccount()+ " ACC\nWHERE ACC.ROW_ID = '" + accntScreen.gettxtRowId() + "'");

                if(!accntList.isEmpty()) {
                    if(update()){
                        accntScreen.enableFields("SALVAR");
                    }
                } else {
                    if(insert()){
                        accntScreen.enableFields("SALVAR");

                        boolean foundRow = true;
                        int i = 0;
                        int o = accntScreen.getNumOfListRows();
                        do {
                            if(i < o){
                                try{                                    
                                    if(getLastAccntAdd().equals(AccntIdArray.get(i).getRowId())){
                                        accntScreen.setSelectedRowColumnList(i, 0);
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
                accntScreen.setlblRecCount((accntScreen.getSelectedRowList() + 1) + " - " + String.valueOf(AccntIdArray.size()));
            } catch(Exception e) {
                System.out.println(getDateTime() + "\tContactModule.ContactController\t\tSaveSocialMedia\tInsertUpdateSocialMedia\tError Exception\tError: " + e);
            }
        }
    }

    @Override
    public void updateAccountPrimaryContactAddress(String accountId) {
        ArrayList<AddressClass> addrList;
        ArrayList<ContactClass> contList;
        
        super.clearColumnsValues();
        super.clearCondition();
        
        addrList = queryAddressRecord("SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblAddress() + " ADDR\nWHERE ADDR.PAR_ROW_ID = '" + accountId + "'\nAND ADDR.PR_ADDR_FLG = 'Y'");
        super.setColumnsValues(",\n\t" + "PR_ADDR_ID = " + ((!addrList.isEmpty()) ? "'" + addrList.get(0).getRow_id() + "'": "NULL"));
        accntScreen.settxtFullAddress(((!addrList.isEmpty()) ? addrList.get(0).getADDR_NAME() : ""));
        
        contList = queryContactRecord("SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblContact()+ " CON\nWHERE CON.PAR_ROW_ID = '" + accountId + "'\nAND CON.PR_CON_FLG = 'Y'");
        super.setColumnsValues(",\n\t" + "PR_CON_ID = " + ((!contList.isEmpty()) ? "'" + contList.get(0).getRow_id() + "'": "NULL"));
        
        super.setCondition("ROW_ID = '" + accountId + "'");
        
        try{
            this.clearCount();
            this.setCount(super.updateRecord(super.getTblAccount(), super.getColumnsValues(), super.getCondition()));
            if(this.getCount() > 0){
                System.out.println(super.getDateTime() + "\t" + "AccountModule" + "." + "AccountLightController" + "\t\t" + "UpdateAccountPrimaryContactAddress" + "\t" + "GenericLog" + "\t" + "GenericInfo" + "\t" + "Atualizando o Contato e Endereço Principal" + "\t\t" + "Contato e Endereço Principal do Cliente atualizados com sucesso");
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
        
        this.setLastAccntUpd(accountId);
    }
    
    protected class buttonEdit implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            accntScreen.enableFields("EDITAR");
            switch(getView()){
                case "ACCOUNT_INFO":
                    accntScreen.setFocus((accntScreen.iscbbDocTypeEnabled()) ? "DOCUMENTO_TIPO": "NOME");
                    break;
                case "ACCOUNT_CONT_ADDR":
                    accntScreen.setFocus("BOTAO_ADD_CONTATO");
                    break;
                case "ACCOUNT_MORE_INFO":
                    accntScreen.setFocus("ESTADO_CIVIL");
                    break;
                case "ACCOUNT_ORDERS":
                    accntScreen.setFocus("");
                    break;
                default:
                    break;
            }
        }
    }
    
    protected class buttonNew implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            accntScreen.enableFields("NOVO");
            accntScreen.clearFields();
            fillFieldsNewRecord();
            switch(getView()){
                case "ACCOUNT_INFO":
                    accntScreen.setFocus("DOCUMENTO_TIPO");
                    break;
                case "ACCOUNT_CONT_ADDR":
                    accntScreen.setFocus("BOTAO_ADD_CONTATO");
                    break;
                case "ACCOUNT_MORE_INFO":
                    accntScreen.setFocus("ESTADO_CIVIL");
                    break;
                case "ACCOUNT_ORDERS":
                    accntScreen.setFocus("");
                    break;
                default:
                    break;
            }
        }
    }
    
    protected class buttonSave implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            save();
        }
    }
    
    protected class buttonCancel implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            accntScreen.enableFields("CANCELAR");
            if(accntScreen.getSelectedRowList() >= 0){
                fillFields("SELECT *\nFROM " + getDbOwner() + "." + getTblAccount() + " ACC\nWHERE ACC.ROW_ID = '" + AccntIdArray.get(accntScreen.getSelectedRowList()).getRowId() + "'");
            } else {
                accntScreen.clearFields();
            }
            accntScreen.setFocus("FILTRO_VALOR");
        }
    }
    
    protected class buttonDelete implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if(delete()){
                accntScreen.enableFields("DELETAR");
                accntScreen.clearFields();
                accntScreen.setFocus("FILTRO_VALOR");
            } else {
                accntScreen.enableFields("CANCELAR");
                accntScreen.setFocus("FILTRO_VALOR");
            }
        }
    }
    
    protected class manageContact implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            String condition = "";
            try{
                // This Array is cleaned everytime when user is saved
                if(contCtrl.getContRowIdArray().size() > 0) {
                    for(int i = 0; i < contCtrl.getContRowIdArray().size(); i++) {
                        if(i != contCtrl.getContRowIdArray().size() - 1){
                            condition += "'" + contCtrl.getContRowIdArray().get(i).getRow_id() + "',\n\t";
                        } else {
                            condition += "'" + contCtrl.getContRowIdArray().get(i).getRow_id() + "'\n";
                        }
                    }
                } else {
                    try {
                        contCtrl = new ContactController();
                    } catch (InterruptedException ex) { }
                }
            } catch (Exception e) {
                try {
                    contCtrl = new ContactController();                    
                } catch (InterruptedException ex) { }
            }
            contCtrl.setDbUser(getDbUser());
            contCtrl.setDbPassword(getDbPassword());
            contCtrl.clearVariables();
            contCtrl.setOpenFromScreen("ACCOUNT");
            contCtrl.setAccountId(accntScreen.gettxtRowId());
            contCtrl.openContactScreen("SELECT *\nFROM " + getDbOwner() + "." + getTblContact() + " CON\nWHERE CON.PAR_ROW_ID = '" + accntScreen.gettxtRowId() + "'" + ((!"".equals(condition)) ? "\nOR ROW_ID IN (\n\t" + condition + ")\n" : "\n") + "ORDER BY CON.FST_NAME ASC","NEW_ACCOUNT_CONTACT");
            contCtrl.setListenerConMgrScreen(new contactScreenListener());
            //cont.setContactScrenOpen(true);
            accntScreen.setEnabled(false);
        }
        
    }
    
    protected class manageAddress implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            String condition = "";
            try{
                // This Array is cleaned everytime when accntLightScreen is saved
                if(addrCtrl.getAddressRowIdArray().size() > 0){
                    for(int i = 0; i < addrCtrl.getAddressRowIdArray().size(); i++) {
                        if(i != addrCtrl.getAddressRowIdArray().size() - 1){
                            condition += "'" + addrCtrl.getAddressRowIdArray().get(i).getRow_id() + "',\n\t";
                        } else {
                            condition += "'" + addrCtrl.getAddressRowIdArray().get(i).getRow_id() + "'\n";
                        }
                    }
                } else {
                    try {
                        addrCtrl = new AddressController();
                    } catch (InterruptedException ex) { }
                }
            } catch (Exception e) {
                try {
                    addrCtrl = new AddressController();
                } catch (InterruptedException ex) { }
            }
            
            addrCtrl.setDbUser(getDbUser());
            addrCtrl.setDbPassword(getDbPassword());
            addrCtrl.setOpenFromScreen("ACCOUNT");
            addrCtrl.setAccountId(accntScreen.gettxtRowId());        
            addrCtrl.openAddressScreen("SELECT *\nFROM " + getDbOwner() + "." + getTblAddress() + " ADDR\nWHERE ADDR.PAR_ROW_ID = '" + accntScreen.gettxtRowId() + "'" + ((!"".equals(condition)) ? "\nOR ROW_ID IN (\n\t" + condition + ")\n" : "\n") + "ORDER BY ADDR.ROW_ID ASC", "NEW_ACCOUNT_ADDRESS");
            addrCtrl.setListenerAddressScreen(new addressScreenListener());
            accntScreen.setEnabled(false);
        }
    }
    
    private class CbbListFilterItemState implements java.awt.event.ItemListener {

        @Override
        public void itemStateChanged(ItemEvent ie) {
            if(ie.getStateChange() == ItemEvent.SELECTED){
                if(accntScreen.getcbbListFilter() == null) {
                    accntScreen.cleartxtListFilterValue();
                }
                accntScreen.setFocus("FILTRO_VALOR");
            }
        }
        
    }
    
    private class CbbDocumentTypeItemState implements java.awt.event.ItemListener {
            
            @Override
            public void itemStateChanged(ItemEvent ie) {
                String docType = "";
                if(ie.getStateChange() == ItemEvent.SELECTED){
                    if(accntScreen.getcbbDocType() != null ) {
                        if(accntScreen.iscbbDocTypeEnabled()) {
                            docType = LookupName("DOC_TYPE", accntScreen.getcbbDocType());
                            switch(docType){
                                case "CPF":
                                    accntScreen.setlblSurname("Sobrenome*:");
                                    accntScreen.setlblBirthDate("Data de Nascimento:");
                                    accntScreen.setcbbSexEnabled(true);
                                    accntScreen.settxtNickNameEnabled(true);
                                    accntScreen.setcbbCivilStateEnabled(true);
                                    accntScreen.settxtSpouseNameEnabled(true);
                                    accntScreen.settxtMotherNameEnabled(true);
                                    accntScreen.settxtFatherNameEnabled(true);
                                    break;
                                case "CNPJ":
                                    accntScreen.setlblSurname("Nome Fantasia:");
                                    accntScreen.setlblBirthDate("Data de Abertura:");
                                    accntScreen.setcbbSexEnabled(false);
                                    accntScreen.settxtNickNameEnabled(false);
                                    accntScreen.setcbbCivilStateEnabled(false);
                                    accntScreen.settxtSpouseNameEnabled(false);
                                    accntScreen.settxtMotherNameEnabled(false);
                                    accntScreen.settxtFatherNameEnabled(false);
                                    break;
                                default:
                                    accntScreen.setlblSurname("Sobrenome*:");
                                    accntScreen.setcbbSexEnabled(true);
                                    accntScreen.settxtNickNameEnabled(true);
                                    accntScreen.setcbbCivilStateEnabled(true);
                                    accntScreen.settxtSpouseNameEnabled(true);
                                    accntScreen.settxtMotherNameEnabled(true);
                                    accntScreen.settxtFatherNameEnabled(true);
                                    break;
                            }
                        }
                    }
                }
            }

    }
    
    private class TxtListFilterValue implements java.awt.event.KeyListener {

        @Override
        public void keyTyped(KeyEvent ke) { }

        @Override
        public void keyPressed(KeyEvent ke) {
            String filterValue = "";
            if(ke.getKeyCode() == KeyEvent.VK_ENTER){
                accntScreen.unselectRowList();
                if(accntScreen.getcbbListFilter() != null && accntScreen.gettxtListFilterValue() != null) {
                    switch(accntScreen.getcbbListFilter()) {
                        case "Sexo":
                            filterValue = LookupName("SEX_MF", accntScreen.gettxtListFilterValue());
                            break;
                        default:
                            filterValue = accntScreen.gettxtListFilterValue();
                            break;
                    }
                    fillList(
                        "SELECT *\n" +
                        "FROM " + getDbOwner() + "." + getTblAccount() + " ACC\n" +
                        "WHERE " + processFilterCondition(accntScreen.getcbbListFilter(), filterValue, "ACCOUNT_FILTER", "ACC") +
                        "ORDER BY ACC.ACCNT_NUMBER ASC",
                        ""
                    );
                } else {
                    fillList("SELECT *\nFROM " + getDbOwner() + "." + getTblAccount() + " ACC\nORDER BY ACC.ACCNT_NUMBER ASC", "");
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent ke) { }
        
    }
    
    protected class ListSelected implements ListSelectionListener {

        private int count = 0;
        
        @Override
        public void valueChanged(ListSelectionEvent lse) {
            if(count < 1){
                accntScreen.clearFields();
                switch(getView()) {
                    case "ACCOUNT_INFO":
                        fillFields("SELECT *\nFROM " + getDbOwner() + "." + getTblAccount() + " ACC\nWHERE ACC.ROW_ID = '" + AccntIdArray.get(accntScreen.getSelectedRowList()).getRowId() + "'");
                        break;
                    case "ACCOUNT_CONT_ADDR":
                        fillFields(null);
                        break;
                    case "ACCOUNT_MORE_INFO":
                        fillFields("SELECT *\nFROM " + getDbOwner() + "." + getTblAccount() + " ACC\nWHERE ACC.ROW_ID = '" + AccntIdArray.get(accntScreen.getSelectedRowList()).getRowId() + "'");
                        break;
                    case "ACCOUNT_ORDERS":
                        break;
                    default:
                        break;
                }
                accntScreen.setlblRecCount((accntScreen.getSelectedRowList() + 1) + " - " + String.valueOf(AccntIdArray.size()));
                accntScreen.setbtnEditEnabled(true);
                accntScreen.setbtnDeleteEnabled(true);
                count++;
            } else {
                count = 0;
            }
        }
        
    }
    
    private class contactScreenListener implements WindowListener {

        @Override
        public void windowOpened(WindowEvent we) { }

        @Override
        public void windowClosing(WindowEvent we) { }

        @Override
        public void windowClosed(WindowEvent we) {
            accntScreen.setEnabled(true);
            accntScreen.setVisible(true);
        }

        @Override
        public void windowIconified(WindowEvent we) { }

        @Override
        public void windowDeiconified(WindowEvent we) { }

        @Override
        public void windowActivated(WindowEvent we) { }

        @Override
        public void windowDeactivated(WindowEvent we) { }

    }

    private class addressScreenListener implements WindowListener {

        @Override
        public void windowOpened(WindowEvent we) { }

        @Override
        public void windowClosing(WindowEvent we) { }

        @Override
        public void windowClosed(WindowEvent we) {
            accntScreen.setEnabled(true);
            accntScreen.setVisible(true);
        }

        @Override
        public void windowIconified(WindowEvent we) { }

        @Override
        public void windowDeiconified(WindowEvent we) { }

        @Override
        public void windowActivated(WindowEvent we) { }

        @Override
        public void windowDeactivated(WindowEvent we) { }
        
    }
    
    private class PanelAccountInfoListener implements ComponentListener {

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
            setView("ACCOUNT_INFO");
            /*// Tem que carregar os campos nas seguintes situações
            // Tabela habilitada para seleção
            // Botão editar estiver habilitado ou desabilitado independente da lista estar habilitada
            // Botao novo estiver habilitado
            switch(getFunction()){
                case "LOAD":
                    accntScreen.clearFields();
                
                    fillFields("SELECT *\nFROM " + getDbOwner() + "." + getTblAccount() + " ACC\nWHERE ACC.ROW_ID = '" + AccntIdArray.get(accntScreen.getSelectedRowList()).getRowId() + "'");
                    accntScreen.setlblRecCount((accntScreen.getSelectedRowList() + 1) + " - " + String.valueOf(AccntIdArray.size()));

                    if(accntScreen.isTblAccountListEnabled()) {
                        accntScreen.setbtnEditEnabled(true);
                        accntScreen.setbtnDeleteEnabled(true);
                    }
                    setAccntInfoStatus("LOADED");
                    break;
                case "EDIT":
                    if(!"LOADED".equals(getAccntInfoStatus())) {
                        accntScreen.clearFields();
                
                        fillFields("SELECT *\nFROM " + getDbOwner() + "." + getTblAccount() + " ACC\nWHERE ACC.ROW_ID = '" + AccntIdArray.get(accntScreen.getSelectedRowList()).getRowId() + "'");
                        accntScreen.setlblRecCount((accntScreen.getSelectedRowList() + 1) + " - " + String.valueOf(AccntIdArray.size()));

                        if(accntScreen.isTblAccountListEnabled()) {
                            accntScreen.setbtnEditEnabled(true);
                            accntScreen.setbtnDeleteEnabled(true);
                        }
                        setAccntInfoStatus("LOADED");
                    }
                    break;
                default:
                    break;
            }
            accntScreen.setFocus("DOCUMENTO_TIPO");*/
        }

        @Override
        public void componentHidden(ComponentEvent ce) {
            //JOptionPane.showMessageDialog(null, "Perdeu Foco");
        }
        
    }
    
    private class PanelAccountContAddrListener implements ComponentListener {

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
            setView("ACCOUNT_CONT_ADDR");
            /*switch(getFunction()){
                case "LOAD":
                    accntScreen.clearFields();
                    fillFields(null);
                    accntScreen.setlblRecCount((accntScreen.getSelectedRowList() + 1) + " - " + String.valueOf(AccntIdArray.size()));
                    if(accntScreen.isTblAccountListEnabled()) {
                        accntScreen.setbtnEditEnabled(true);
                        accntScreen.setbtnDeleteEnabled(true);
                    }
                    setAccntContAddrStatus("LOADED");
                    break;
                case "EDIT":
                    if(!"LOADED".equals(getAccntContAddrStatus())) {
                        accntScreen.clearFields();
                        fillFields(null);
                        accntScreen.setlblRecCount((accntScreen.getSelectedRowList() + 1) + " - " + String.valueOf(AccntIdArray.size()));
                        if(accntScreen.isTblAccountListEnabled()) {
                            accntScreen.setbtnEditEnabled(true);
                            accntScreen.setbtnDeleteEnabled(true);
                        }
                        setAccntContAddrStatus("LOADED");
                    }
                    break;
                default:
                    break;
            }
            accntScreen.setFocus("BOTAO_ADD_CONTATO");*/
        }

        @Override
        public void componentHidden(ComponentEvent ce) {
            //JOptionPane.showMessageDialog(null, "Perdeu Foco");
        }
        
    }
    
    private class PanelAccountMoreInfoListener implements ComponentListener {

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
            setView("ACCOUNT_MORE_INFO");
            /*switch(getFunction()){
                case "LOAD":
                    accntScreen.clearFields();
                    fillFields("SELECT *\nFROM " + getDbOwner() + "." + getTblAccount() + " ACC\nWHERE ACC.ROW_ID = '" + AccntIdArray.get(accntScreen.getSelectedRowList()).getRowId() + "'");
                    accntScreen.setlblRecCount((accntScreen.getSelectedRowList() + 1) + " - " + String.valueOf(AccntIdArray.size()));
                    if(accntScreen.isTblAccountListEnabled()) {
                        accntScreen.setbtnEditEnabled(true);
                        accntScreen.setbtnDeleteEnabled(true);
                    }
                    setAccntMoreInfoStatus("LOADED");
                    break;
                case "EDIT":
                    if(!"LOADED".equals(getAccntMoreInfoStatus())) {
                        accntScreen.clearFields();
                        fillFields("SELECT *\nFROM " + getDbOwner() + "." + getTblAccount() + " ACC\nWHERE ACC.ROW_ID = '" + AccntIdArray.get(accntScreen.getSelectedRowList()).getRowId() + "'");
                        accntScreen.setlblRecCount((accntScreen.getSelectedRowList() + 1) + " - " + String.valueOf(AccntIdArray.size()));
                        if(accntScreen.isTblAccountListEnabled()) {
                            accntScreen.setbtnEditEnabled(true);
                            accntScreen.setbtnDeleteEnabled(true);
                        }
                        setAccntMoreInfoStatus("LOADED");
                    }
                    break;
                default:
                    break;
            }
            accntScreen.setFocus("ESTADO_CIVIL");*/
        }

        @Override
        public void componentHidden(ComponentEvent ce) {
            //JOptionPane.showMessageDialog(null, "Perdeu Foco");
        }
        
    }
    
    private class PanelAccountOrdersListener implements ComponentListener {

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
            setView("ACCOUNT_ORDERS");
            /*postnRowIdArray.clear();
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
            posScreen.setFocus("FILTRO_VALOR");*/
        }

        @Override
        public void componentHidden(ComponentEvent ce) {
            JOptionPane.showMessageDialog(null, "Perdeu Foco");
        }
        
    }

}
