/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package settingsModule;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author mathe
 */
public class ListOfValuesController {
    ListOfValuesScreen lovScr;
    
    private String user;
    private String password;

    public ListOfValuesController() {
    }
    
    public String getUser() { return user; }
    public void setUser(String user) { this.user = user; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public void openLOVScreen(){
        lovScr = new ListOfValuesScreen();
        lovScr.setListenerBtnNew(new newLOV());
        lovScr.setListenerBtnEdit(new editLOV());
        lovScr.setListenerBtnDelete(new deleteLOV());
        lovScr.setListenerBtnSave(new saveLOV());
        lovScr.setListenerBtnCancel(new cancelLOV());
    }

    private class editLOV implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            lovScr.enableFields("EDITAR");
            lovScr.setFocus("USUARIO");
        }
    }
    
    private class newLOV implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            lovScr.enableFields("NOVO");
            lovScr.clearFields();
            //fillNewUserFields();
            lovScr.setFocus("USUARIO");
        }
    }
    
    private class saveLOV implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            lovScr.enableFields("SALVAR");
        }
    }
    
    private class cancelLOV implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            /*lovScr.enableFields("CANCELAR");
            if(!"".equals(lovScr.getSelectedUserListId()) && lovScr.getSelectedUserListId() != null){
                fillFieldsUserScreen("SELECT *\n" +
                    "FROM " + getDbOwner() + "." + getTblUser()+ " USR\n" +
                    "WHERE USR.ROW_ID = '" + userScreen.getSelectedUserListId() + "'"
                );
            } else {
                lovScr.clearFields();
            }*/
            lovScr.enableFields("CANCELAR");
            lovScr.clearFields();
            lovScr.setFocus("FILTRO_VALOR");
        }
    }
    
    private class deleteLOV implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            /*if(deleteUser()){
                lovScr.enableFields("DELETAR");
                openUserScreen("USER", "SELECT *\nFROM " + getDbOwner() + "." + getTblUser() + " USR\nORDER BY USR.FST_NAME ASC");
                lovScr.setFocus("FILTRO_VALOR");
            } else {
                lovScr.enableFields("CANCELAR");
                if(!"".equals(userScreen.getSelectedUserListId()) && userScreen.getSelectedUserListId() != null){
                    fillFieldsUserScreen("SELECT *\nFROM " + getDbOwner() + "." + getTblUser()+ " USR\nWHERE USR.ROW_ID = '" + userScreen.getSelectedUserListId() + "'");
                } else {
                    lovScr.clearFields();
                }
                lovScr.setFocus("FILTRO_VALOR");
            }*/
            lovScr.enableFields("DELETAR");
            lovScr.clearFields();
            lovScr.setFocus("FILTRO_VALOR");
        }
    }
}
