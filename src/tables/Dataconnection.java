/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tables;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Dataconnection {

    static Connection con = null;

    public static Connection mkDataBase() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/contracting", "mmg", "123");
            System.out.println("true");
            return con;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Dataconnection.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("false");
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(Dataconnection.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("false");

            return null;

        }

    }
}
