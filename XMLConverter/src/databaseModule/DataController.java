/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseModule;

import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Matheus Cabral Rosa
 */
public abstract class DataController extends Controller{
    
    // Empty Constructor
    public DataController() throws InterruptedException { }
    
    @Override
    public String openConnection(String message){
        try {
            Class.forName(super.getDbDriver());
            System.out.println("Oracle JDBC Driver Registered! " + message + "...");
        } catch (ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, super.exc.getDbODBCEx() + "\n" + super.exc.getMsgReturn() + e, "Erro", JOptionPane.ERROR_MESSAGE);
        }
        try {
            conn = DriverManager.getConnection(getDbURL(), getDbUser(), getDbPassword());
            System.out.println("Connected Successfuly! " + message + "...");
            return "true";
        } catch(SQLException e) {
            if(!"Realizando Login".equals(message)){
                JOptionPane.showMessageDialog(null, super.exc.getDbConnectionEx()+ "\n" + super.exc.getMsgReturn() + e,"Erro",JOptionPane.ERROR_MESSAGE);
            } else {
                System.out.println(super.exc.getDbConnectionEx()+ "\n" + super.exc.getMsgReturn() + e);
            }            
            return "" + e;
        }
    }
    
    @Override
    public String closeConnection(String message){
        try {
            Class.forName(super.getDbDriver());
            System.out.println("Oracle JDBC Driver Registered! " + message + "...");
        } catch (ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, super.exc.getDbODBCEx()+ "\n" + super.exc.getMsgReturn() + e,"Erro",JOptionPane.ERROR_MESSAGE);
        }
        try {
            conn.close();
            System.out.println(message + "... Disconnected Successfuly!");
            return "true";
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, super.exc.getDbDisconnectEx() + "\n" + super.exc.getMsgReturn() + e,"Erro",JOptionPane.ERROR_MESSAGE);
            return "false";
        }
    }
}
