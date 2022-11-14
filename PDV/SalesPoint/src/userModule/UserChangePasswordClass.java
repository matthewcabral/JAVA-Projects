/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userModule;

import databaseModule.EncryptDecryptWord;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author mathe
 */
public class UserChangePasswordClass extends UserController {
    UserChangePasswordScreen changePass;

    public UserChangePasswordClass() throws InterruptedException { }
    
    public void setWindowListenerChangeScreen(WindowListener listener) { changePass.addWindowListener(listener); }
    
    public void openChangePassword() {
        changePass = new UserChangePasswordScreen();
        changePass.setListenerBtnChangePassword(new BtnChangePassword());
        changePass.setKeyListenerTxtPassword(new TxtPassword());
        changePass.setKeyListenerTxtNewPassword(new TxtNewPassword());
        changePass.setKeyListenerTxtNewPasswordConf(new TxtNewPasswordConf());
        changePass.setKeyListenerBtnChangePassword(new btnChangePasswordKeyListener());
        encryptDecrypt = new EncryptDecryptWord();
    }
    
    @Override
    public boolean validateFields(){
        int i = 0;
        String mensagem = "";
        
        String password = changePass.gettxtPassword();
        String newPassword = changePass.gettxtNewPassword();
        String newPasswordConf = changePass.gettxtNewPasswordConf();
                
        if(password == null) { mensagem += "\n- " + "Senha Atual" + ";"; i = (i < 1) ? 1 : i; }
        if(newPassword == null) { mensagem += "\n- " + "Nova Senha" + ";"; i = (i < 2 && i != 0) ? i : 2; }
        if(newPasswordConf == null) { mensagem += "\n- " + "Confirmação de Senha" + ";"; i = (i < 3 && i != 0) ? i : 4; }

        switch(i){
            case 1: changePass.setFocus("PASSWORD"); break;
            case 2: changePass.setFocus("PASSWORD_NEW"); break;
            case 3: changePass.setFocus("PASSWORD_NEW_CONF"); break;
            default: break;
        }
        
        if(!"".equals(mensagem) && mensagem != null){
            JOptionPane.showMessageDialog(null, "Os campos abaixo são obrigatórios. Favor preencher os mesmos:" + mensagem);
            return false;
        } else {
            return true;
        }
    }
    
    public boolean ChangePassword(){
        if(this.validateFields()){
            ArrayList<UserClass> userList = super.queryUserRecord("SELECT *\nFROM " + super.getDbOwner() + "." + super.getTblUser() + " USR\nWHERE USR.LOGIN = '" + super.getDbUser() + "'");
        
            if(userList.size() > 0){
                if(changePass.gettxtPassword().equals(userList.get(0).getPASSWORD())){
                    if(super.validatePassword(super.getDbUser(), changePass.gettxtNewPassword(), changePass.gettxtNewPasswordConf(), userList.get(0).getFST_NAME(), userList.get(0).getBIRTH_DAY(), userList.get(0).getBIRTH_MONTH(), userList.get(0).getBIRTH_YEAR())) {
                        super.clearColumnsValues();
                        super.clearCondition();
                        super.setColumnsValues(",\n\t" + "PASSWORD = '" + encryptDecrypt.encryptWord(changePass.gettxtNewPassword())  + "'");
                        super.setCondition("ROW_ID = '" + userList.get(0).getRow_id() + "'");
                        try{
                            super.clearCount();
                            super.setCount(super.updateRecord(super.getTblUser(), super.getColumnsValues(), super.getCondition()));
                            if(super.getCount() > 0){
                                ArrayList<GenericCommandClass> sqlCommand = new ArrayList<>();
                                GenericCommandClass genCmd = new GenericCommandClass();

                                genCmd.setSqlCommand("ALTER USER \"" + super.getDbUser() + "\" IDENTIFIED BY \"" + changePass.gettxtNewPassword() + "\"");
                                sqlCommand.add(genCmd);

                                super.setSilentInsertMode(true);
                                if("true".equals(super.executeGenericDBCommand(sqlCommand))){
                                    super.setSilentInsertMode(false);
                                    JOptionPane.showMessageDialog(null, "Sua senha foi alterada com sucesso!");
                                    super.clearColumnsValues();
                                    super.clearCondition();
                                    super.setDbPassword(changePass.gettxtNewPassword());
                                    return true;
                                } else {
                                    super.setSilentInsertMode(false);
                                    super.clearColumnsValues();
                                    super.clearCondition();
                                    return false;
                                }
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
                    } else {
                        return false;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "A senha inserida está incorreta.");
                    return false;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar senha. Usuário não encontrado.");
                return false;
            }
        } else {
            return false;
        }
    }
    
    private class BtnChangePassword implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if(ChangePassword()){
                changePass.dispose();
            }            
        }
        
    }
    
    private class TxtPassword implements KeyListener {

        @Override
        public void keyTyped(KeyEvent ke) { }

        @Override
        public void keyPressed(KeyEvent ke) {
            if(ke.getKeyCode() == KeyEvent.VK_TAB || ke.getKeyCode() == KeyEvent.VK_ENTER){
                changePass.setFocus("PASSWORD_NEW");
            }
        }

        @Override
        public void keyReleased(KeyEvent ke) { }
        
    }
    
    private class TxtNewPassword implements KeyListener {

        @Override
        public void keyTyped(KeyEvent ke) { }

        @Override
        public void keyPressed(KeyEvent ke) {
            if(ke.getKeyCode() == KeyEvent.VK_TAB || ke.getKeyCode() == KeyEvent.VK_ENTER){
                changePass.setFocus("PASSWORD_NEW_CONF");
            }
        }

        @Override
        public void keyReleased(KeyEvent ke) { }
        
    }
    
    private class TxtNewPasswordConf implements KeyListener {

        @Override
        public void keyTyped(KeyEvent ke) { }

        @Override
        public void keyPressed(KeyEvent ke) {
            if(ke.getKeyCode() == KeyEvent.VK_TAB) { changePass.setFocus("BUTTON_CHANGE_PASSWORD"); }
            if(ke.getKeyCode() == KeyEvent.VK_ENTER) { changePass.clickBtnChangePassword(); }
        }

        @Override
        public void keyReleased(KeyEvent ke) { }
        
    }
    
    private class btnChangePasswordKeyListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent ke) { }

        @Override
        public void keyPressed(KeyEvent ke) {
            if(ke.getKeyCode() == KeyEvent.VK_TAB) { changePass.setFocus("PASSWORD"); }
            if(ke.getKeyCode() == KeyEvent.VK_ENTER) { changePass.clickBtnChangePassword(); }
        }

        @Override
        public void keyReleased(KeyEvent ke) { }
        
    }
    
}
