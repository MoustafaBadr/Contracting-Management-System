/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation;

import controller.WorkerfxmlController;
import database.Dataconnection;
import database.connectDataBase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mustafa
 */
public class civilEmployees extends employee {
public int  JoinProject(int n,  String project) {
        int x=0;
        Connection con = Dataconnection.mkDataBase();

        try {
            String sql = "UPDATE contracting.employee SET  state ='busy'   WHERE idemployee= ? ";
            pst = con.prepareStatement(sql);
            pst.setInt(1, n);
            pst.execute();
            connectDataBase c = new connectDataBase();
         x=    c.s.executeUpdate("UPDATE contracting.employee SET  project ='" + project + "'   WHERE idemployee=  " + n + "");

        } catch (SQLException ex) {

            ex.printStackTrace();
        }
    return x;
    }

    public int LeftProject(int n, String project) {
     int x=0;
        try {
            Connection con = Dataconnection.mkDataBase();

            String sql = "UPDATE contracting.employee SET  state ='free'   WHERE idemployee= ? ";
            pst = con.prepareStatement(sql);
            pst.setInt(1, n);
            pst.execute();
            connectDataBase c = new connectDataBase();
         x=   c.s.executeUpdate("UPDATE contracting.employee SET  project ='" + null + "'   WHERE idemployee=  " + n + "");
        } catch (SQLException ex) {
            Logger.getLogger(civilEmployees.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return x;
    }

    public ResultSet search(String n) {
        try {
            Connection con = Dataconnection.mkDataBase();
            String selectsql = "SELECT firstName,lastName,job,state,project FROM contracting.employee where employee.job=? ";

            pst = con.prepareStatement(selectsql);
            pst.setString(1, n);
            rs = pst.executeQuery();
        } catch (SQLException ex) {

            ex.printStackTrace();
        }
        return rs;
    }
public static void main(String[] args) {
        civilEmployees e= new civilEmployees();
        int x=e.JoinProject(1, "el mostafa");
        System.out.println(x);
       int y = e.LeftProject(1, "el mostafa");
      System.out.println(y);
       e.search("ali");
        
        System.out.println("1111111111111111111111111111");
    
}
}
