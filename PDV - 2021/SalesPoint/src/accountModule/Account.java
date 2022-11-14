/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accountModule;

import addressModule.AddressController;
import contactModule.ContactController;
import databaseModule.DataController;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author mathe
 */
public abstract class Account extends DataController {

    AccountScreen accntScreen;
    AccountLightScreen accntLightScreen;
    AccountInsertScreen accntInsScreen;
    ContactController contCtrl;
    AddressController addrCtrl;
    
    private String lastAccntAdd;
    private String lastAccntUpd;
    private int count;
    // Account Field Column Sizes
    private final int AccntNumberColumnSize = 50;
    private final int DocTypeColumnSize = 30;
    private final int DocNumberColumnSize = 30;
    private final int AliasNameColumnSize = 50;
    private final int NomeFantasiaColumnSize = 100;
    private final int FirstNameColumnSize = 50;
    private final int LastNameColumnSize = 50;
    private final int FullNameColumnSize = 100;
    private final int NickNameColumnSize = 50;
    private final int PlaceOfBirtColumnSize = 100;
    private final int MaritalStatusColumnSize = 30;
    private final int ConjugeNameColumnSize = 100;
    private final int MotherNameColumnSize = 100;
    private final int FatherNameColumnSize = 100;
    private final int AccntTypeColumnSize = 30;
    private final int DescTextColumnSize = 255;
    private final int StatusCdColumnSize = 30;
    private final int AtivComercialColumnSize = 30;
    private final int InscMunicipalColumnSize = 30;
    private final int InscEstadualColumnSize = 30;
    private final int DocumentTypeColumnSize = 30;
    private final int RegisterNumColumnSize = 30;
    private final int RegisterSerieColumnSize = 30;
    private final int OrgaoEmissorColumnSize = 30;
    private final int UfEmissaoColumnSize = 30;
    private final int NaturalnessColumnSize = 100;
    private final int NaturalityColumnSize = 100;
    private final int dataNascimentoAno = 4;
    private final int EmissionDate = 10;
    private final int ValidThru = 10;
    // Contact Field Column Sizes
    private final int ContMainPhNumColumnSize = 15;
    private final int ContPhNumColumnSize = 15;
    private final int ContWorkPhNumColumnSize = 15;
    private final int ContEmailAddrColumnSize = 100;
    // Social Media Field Column Sizes
    private final int SocMedValueColumnSize = 100;
    
    protected accountIdClass AccntId;
    protected ArrayList<accountIdClass> AccntIdArray = new ArrayList<>();
    protected ArrayList<String> socialName = new ArrayList<>();
    
    public Account() throws InterruptedException { }
    
    public String getLastAccntAdd() { return lastAccntAdd; }
    public void setLastAccntAdd(String lastAccntAdd) { this.lastAccntAdd = lastAccntAdd; }

    public String getLastAccntUpd() { return lastAccntUpd; }
    public void setLastAccntUpd(String lastAccntUpd) { this.lastAccntUpd = lastAccntUpd; }
    
    public int getCount() { return count; }
    public void setCount(int count) { this.count += count; }
    public void clearCount() { this.count = 0; }

    public int getAccntNumberColumnSize() { return AccntNumberColumnSize; }
    public int getDocTypeColumnSize() { return DocTypeColumnSize; }
    public int getDocNumberColumnSize() { return DocNumberColumnSize; }
    public int getAliasNameColumnSize() { return AliasNameColumnSize; }
    public int getNomeFantasiaColumnSize() { return NomeFantasiaColumnSize; }
    public int getFirstNameColumnSize() { return FirstNameColumnSize; }
    public int getLastNameColumnSize() { return LastNameColumnSize; }
    public int getFullNameColumnSize() { return FullNameColumnSize; }
    public int getNickNameColumnSize() { return NickNameColumnSize; }
    public int getPlaceOfBirtColumnSize() { return PlaceOfBirtColumnSize; }
    public int getMaritalStatusColumnSize() { return MaritalStatusColumnSize; }
    public int getConjugeNameColumnSize() { return ConjugeNameColumnSize; }
    public int getMotherNameColumnSize() { return MotherNameColumnSize; }
    public int getFatherNameColumnSize() { return FatherNameColumnSize; }
    public int getAccntTypeColumnSize() { return AccntTypeColumnSize; }
    public int getDescTextColumnSize() { return DescTextColumnSize; }
    public int getStatusCdColumnSize() { return StatusCdColumnSize; }
    public int getAtivComercialColumnSize() { return AtivComercialColumnSize; }
    public int getInscMunicipalColumnSize() { return InscMunicipalColumnSize; }
    public int getInscEstadualColumnSize() { return InscEstadualColumnSize; }
    public int getDocumentTypeColumnSize() { return DocumentTypeColumnSize; }
    public int getRegisterNumColumnSize() { return RegisterNumColumnSize; }
    public int getRegisterSerieColumnSize() { return RegisterSerieColumnSize; }
    public int getOrgaoEmissorColumnSize() { return OrgaoEmissorColumnSize; }
    public int getUfEmissaoColumnSize() { return UfEmissaoColumnSize; }
    public int getNaturalnessColumnSize() { return NaturalnessColumnSize; }
    public int getNaturalityColumnSize() { return NaturalityColumnSize; }
    public int getDataNascimentoAno() { return dataNascimentoAno; }
    public int getEmissionDate() { return EmissionDate; }
    public int getValidThru() { return ValidThru; }
    // Contact Field Column Sizes
    public int getContMainPhNumColumnSize() { return ContMainPhNumColumnSize; }
    public int getContPhNumColumnSize() { return ContPhNumColumnSize; }
    public int getContWorkPhNumColumnSize() { return ContWorkPhNumColumnSize; }
    public int getContEmailAddrColumnSize() { return ContEmailAddrColumnSize; }
    // Social Media Field Column Sizes
    public int getSocMedValueColumnSize() { return SocMedValueColumnSize; }
    
    public void clearSocialNameArray() { try { socialName.clear(); } catch(Exception e) { } }
    
    public abstract void openAccountScreen(String screen, String query);
    public abstract void fillComboBoxes(String LovType);
    public abstract void fillList(String query, String method);
    public abstract void fillFields(String query);
    public abstract void fillFieldsNewRecord();
    public abstract boolean validateMandatoryFields();
    public abstract boolean validateFieldValues();
    public abstract boolean insert();
    public abstract boolean update();
    public abstract boolean delete();
    public abstract void save();
    public abstract void updateAccountPrimaryContactAddress(String accountId);
    protected abstract class buttonEdit implements ActionListener {};
    protected abstract class buttonNew implements ActionListener {};
    protected abstract class buttonSave implements ActionListener {};
    protected abstract class buttonCancel implements ActionListener {};
    protected abstract class buttonDelete implements ActionListener {};
    protected abstract class ListSelected implements ListSelectionListener {};
    protected abstract class manageAddress implements ActionListener {};
    protected abstract class manageContact implements ActionListener {};
    
    protected class accountIdClass {
        private String rowId;
        
        public accountIdClass() { this.rowId = null; }

        public String getRowId() { return rowId; }
        public void setRowId(String rowId) { this.rowId = rowId; }
    }

}
