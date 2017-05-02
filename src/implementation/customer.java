/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation;

import database.connectDataBase;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Pos;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 *
 * @author Mustafa
 */
public class customer {
    
    int id;
    int payment;
    String name;
    String phone;
    String address;
    String email;
    String tybe;
    
    ResultSet re;
    
    public boolean insert(String name , String phone , String email , String address , int payment , String tybe){
        
        this.name = name;
        this.address=address;
        this.payment=payment;
        this.email=email;
        this.phone = phone;
        this.tybe = tybe;
        
        connectDataBase C = new connectDataBase();
            try {
                C.s.executeUpdate("insert into contracting.customer (name , tybe , phone , email , address , payment )values( '"+this.name+"','"+this.tybe+"','"+this.phone+"','"+this.email+"','"+this.address+"',"+this.payment+")");
            
//                 Notifications notificationBuildeer = Notifications.create().
//                    title("Sucess").
//                    text("ADD Successfuly").
//                    graphic(null).
//                    hideAfter(Duration.seconds(4)).
//                    position(Pos.TOP_RIGHT).
//                    onAction(e -> {
//                        System.out.println("");
//                    });
//            notificationBuildeer.show();
            } catch (Exception ex) {
              
                ex.printStackTrace();
            }
           
		
        return true;
        
    }
    public ResultSet search(){
        connectDataBase c = new connectDataBase();
        
        try {
            re = c.s.executeQuery("select * from contracting.customer");
        } catch (SQLException ex) {

            ex.printStackTrace();
        }
        return re;
        
    }
    public boolean update(int id,String name , String phone , String email , String address ,  String tybe){
        
       
        this.name = name;
        this.address=address;
       
        this.email=email;
        this.phone = phone;
        this.tybe = tybe;
        this.id = id;
        
        connectDataBase c = new connectDataBase();
        
        try {
            //c.s.executeUpdate("update contracting.customer set name='"+name+"'and address ='"+this.address+"'and email='"+this.email+"'and phone = '"+this.phone+"'and tybe='"+this.tybe+"'where idcustomer="+this.id);
            
            c.s.executeUpdate("update contracting.customer set name = '"+name+"' where idcustomer ="+this.id);
            c.s.executeUpdate("update contracting.customer set phone = '"+this.phone+"' where idcustomer ="+this.id);
            c.s.executeUpdate("update contracting.customer set email = '"+this.email+"' where idcustomer ="+this.id);
            c.s.executeUpdate("update contracting.customer set address = '"+this.address+"' where idcustomer ="+this.id);
            c.s.executeUpdate("update contracting.customer set tybe = '"+this.tybe+"' where idcustomer ="+this.id);
            c.s.executeUpdate("update contracting.customer set payment = '"+this.payment+"' where idcustomer ="+this.id);
//             Notifications notificationBuildeer = Notifications.create().
//                    title("Sucess").
//                    text("UPDATED Successfuly").
//                    graphic(null).
//                    hideAfter(Duration.seconds(4)).
//                    position(Pos.TOP_RIGHT).
//                    onAction(e -> {
//                        System.out.println("");
//                    });
//            notificationBuildeer.show();
//            
        } catch (SQLException ex) {

            ex.printStackTrace();
        }
         return  true;
        
    }
    public boolean delete(int id){
       this.id = id;
        connectDataBase c = new connectDataBase();
        try {
             c.s.executeUpdate("delete from contracting.projects where customerId= " + this.id);
             c.s.executeUpdate("delete from contracting.customerpayment where cusstomerId= " + this.id);
                c.s.executeUpdate("delete from contracting.customer where idcustomer = "+this.id);
//                 Notifications notificationBuildeer = Notifications.create().
//                    title("Sucess").
//                    text("DELETED  Successfuly").
//                    graphic(null).
//                    hideAfter(Duration.seconds(4)).
//                    position(Pos.TOP_RIGHT).
//                    onAction(e -> {
//                        System.out.println("");
//                    });
//            notificationBuildeer.show();
            } catch (SQLException ex) {

                ex.printStackTrace();
            }
           return true;
    }
    public ResultSet searchTybe(String tybe){
        this.tybe=tybe;
        connectDataBase c = new connectDataBase();
        
        try {
            re = c.s.executeQuery("select * from contracting.customer where tybe = '"+this.tybe+"'");
        } catch (SQLException ex) {

            ex.printStackTrace();
        }
        System.out.println("sssssssssssssssss");
        return re;
    }
    
}
