/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation;

import database.connectDataBase;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import javafx.geometry.Pos;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;

/**
 *
 * @author Mustafa
 */
public class supplier {
    
   int id;
    String name;
    String timeLine;
    int payment;
    String address;
    String email;
    String phone;
    
    ResultSet re ;
    
    public boolean insert(String name ,int Payment ,String timeline ,String Address ,String email ,String phone){
        try {
            connectDataBase c = new connectDataBase();
            c.s.executeUpdate("insert into contracting.supplier (name , payment,timeLine,address,email,phone)values('"+name+"',"+Payment+",'"+timeline+"','"+Address+"','"+email+"','"+phone+"')");
//            Notifications notificationBuildeer = Notifications.create().
//                                    title("Success").
//                                    text(" insert sucessfuly").
//                                    graphic(null).
//                                    hideAfter(Duration.seconds(4)).
//                                    position(Pos.TOP_RIGHT).
//                                    onAction(e -> {
//                                        System.out.println("sucess ");
//                                    });
//                            notificationBuildeer.show();
        } catch (SQLException ex) {

            ex.printStackTrace();
        }
        return true;
    }
    public ResultSet search(int id){
        try {
            connectDataBase c = new connectDataBase();
            if(id==0){
            re=c.s.executeQuery("SELECT * FROM contracting.supplier");
            }else{
                re=c.s.executeQuery("SELECT * FROM contracting.supplier where idsupplier ="+id+"");
            }
        } catch (Exception ex) {

            ex.printStackTrace();
        }
       
        return re;
    }
    public boolean update(int id ,String name ,String timeline ,String Address ,String email ,String phone){
        
        try {
            connectDataBase c = new connectDataBase();
            c.s.executeUpdate("update contracting.supplier set name = '"+name+"' where idsupplier = "+id+"");
            
            c.s.executeUpdate("update contracting.supplier set timeLine = '"+timeline+"' where idsupplier = "+id+"");
            c.s.executeUpdate("update contracting.supplier set address = '"+Address+"' where idsupplier = "+id+"");
            c.s.executeUpdate("update contracting.supplier set email = '"+email+"' where idsupplier = "+id+"");
            c.s.executeUpdate("update contracting.supplier set phone = '"+phone+"' where idsupplier = "+id+"");
//            Notifications notificationBuildeer = Notifications.create().
//                                    title("Success").
//                                    text(" update sucessfuly").
//                                    graphic(null).
//                                    hideAfter(Duration.seconds(4)).
//                                    position(Pos.TOP_RIGHT).
//                                    onAction(e -> {
//                                        System.out.println("sucess ");
//                                    });
//                            notificationBuildeer.show();
        } catch (SQLException ex) {

            ex.printStackTrace();
        }
        return true;
    }
    public boolean delete(int id){
        try {
            
            
            connectDataBase c = new connectDataBase();
           
            c.s.executeUpdate("DELETE FROM `supplier` WHERE idsupplier = "+id+"");
//             Notifications notificationBuildeer = Notifications.create().
//                                    title("delete").
//                                    text(" delete sucessfuly").
//                                    graphic(null).
//                                    hideAfter(Duration.seconds(4)).
//                                    position(Pos.TOP_RIGHT).
//                                    onAction(e -> {
//                                        System.out.println("sucess ");
//                                    });
//                            notificationBuildeer.show();
        } catch (SQLException ex) {

//           Notifications notificationBuildeer = Notifications.create().
//                                    title("Warming").
//                                    text(" you must end your dael with this supplier to enable to delete ").
//                                    graphic(null).
//                                    hideAfter(Duration.seconds(4)).
//                                    position(Pos.TOP_RIGHT).
//                                    onAction(e -> {
//                                        System.out.println("warming ");
//                                    });
//                            notificationBuildeer.showWarning();
//                            return;
        }
        return true;
    }
  
}
