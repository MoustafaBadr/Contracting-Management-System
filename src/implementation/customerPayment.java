/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation;

import database.connectDataBase;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Pos;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 *
 * @author Mustafa
 */
public class customerPayment {
    
    int id;
    String userName;
    int cash;
    int customerID;
    LocalDate date;
    
    ResultSet re;
    public void payment(int cash,int customerId,String customerName){
        
        this.cash = cash;
        this.customerID = customerId;
        this.userName = admin.userName;
        
        int ret=0;
             
             connectDataBase c = new connectDataBase();
		try {
                ResultSet re=  c.s.executeQuery("SELECT * FROM contracting.customer where idcustomer ="+this.customerID+"");
                while(re.next()){
                    int payment = re.getInt("payment");
                     ret = payment-this.cash;
                     
                     
                      
                    
                }
                
                c.s.executeUpdate("update contracting.customer set payment = "+ret+ " where idcustomer = "+this.customerID+"");
//                Notifications notificationBuildeer = Notifications.create().
//                    title("Information").
//                    text(" the payment reminder is "+ret+"").
//                    graphic(null).
//                    hideAfter(Duration.seconds(6)).
//                    position(Pos.TOP_RIGHT).
//                    onAction(e -> {
//                        System.out.println("information Noti ");
//                    });
//            notificationBuildeer.showInformation();
//
//                    System.out.println("payment is updated");
            } catch (SQLException ex) {

                ex.printStackTrace();
            }
                String date = "";
        int day;
        int month;
        int year;
                GregorianCalendar tday = (GregorianCalendar) GregorianCalendar.getInstance();
        day = tday.get(Calendar.DAY_OF_MONTH);
        GregorianCalendar tmonth = (GregorianCalendar) GregorianCalendar.getInstance();
        month = tmonth.get(GregorianCalendar.MONTH) + 1;
        GregorianCalendar tyear = (GregorianCalendar) GregorianCalendar.getInstance();
        year = tyear.get(GregorianCalendar.YEAR);
        date += year + "-" + month + "-" + day;
        
        try {
            c.s.executeUpdate("insert into contracting.customerpayment(cash , userName,cusstomerId,date,customerName) values ("+this.cash+",'"+this.userName+"',"+this.customerID+",'"+date+"','"+customerName+"')" );
            System.out.println("inserted");
             Notifications notificationBuildeer = Notifications.create().
                    title("Sucess").
                    text("ADD Successfuly").
                    graphic(null).
                    hideAfter(Duration.seconds(4)).
                    position(Pos.TOP_RIGHT).
                    onAction(e -> {
                        System.out.println("");
                    });
            notificationBuildeer.show();
            
        } catch (SQLException ex) {

            ex.printStackTrace();
        }
    }
    public ResultSet search(LocalDate date,String user){
        this.date=date;
        this.userName=user;
        connectDataBase c = new connectDataBase();
        if(date==null&&user==null){
            try {
                 re = c.s.executeQuery("SELECT * FROM contracting.customerpayment");
                 System.out.println("both");
            } catch (SQLException ex) {

                ex.printStackTrace();
            }
        }else if(date!=null&&user==null){
            try {
                 re = c.s.executeQuery("SELECT * FROM contracting.customerpayment where date = '"+this.date+"'");
                 System.out.println("date");
            } catch (SQLException ex) {

                ex.printStackTrace();
            }
        }else{
                try {
                 re = c.s.executeQuery("SELECT * FROM contracting.customerpayment where userName = '"+this.userName+"'");
                    System.out.println("user ");
            } catch (SQLException ex) {

                ex.printStackTrace();
            }
                }
        return re;
    }
    public int total(LocalDate date , String user){
        this.date = date;
        this.userName = user;
        int total=0;
        connectDataBase c = new connectDataBase();
        if(date==null&&user==null){
            try {
                 re = c.s.executeQuery("SELECT * FROM contracting.customerpayment");
                 while(re.next()){
                     total+=Integer.parseInt(re.getString("cash"));
                 }
            } catch (SQLException ex) {

                ex.printStackTrace();
            }
        }else if (date!=null&&user==null){
            try {
                 re = c.s.executeQuery("SELECT * FROM contracting.customerpayment where date = '"+this.date+"'");
                 while(re.next()){
                     total+=Integer.parseInt(re.getString("cash"));
                 }
            } catch (SQLException ex) {

                ex.printStackTrace();
            }
        }else{
            try {
                 re = c.s.executeQuery("SELECT * FROM contracting.customerpayment where userName = '"+this.userName+"'");
                 while(re.next()){
                     total+=Integer.parseInt(re.getString("cash"));
                 }
            } catch (SQLException ex) {

                ex.printStackTrace();
            }
        }
        return total;
        
    }
    
    
}
