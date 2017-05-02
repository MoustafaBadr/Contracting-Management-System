/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Mustafa
 */
public class connectDataBase {
    
    public Statement s;
    public Connection conection;
    
    public connectDataBase(){
        
        try {
                Class.forName("com.mysql.jdbc.Driver");
                
               
                    conection = DriverManager.getConnection("jdbc:mysql://localhost/contracting", "root", "7asobaty");
                
                     s = conection.createStatement();
                     System.out.println("true");
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "hgfgdg");

                ex.printStackTrace();
            }
            
        
    }
    
}
