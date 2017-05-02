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

/**
 *
 * @author Mustafa
 */
public class supplierPayment {
    
    int id;
    String userName;
    int cash;
    int supplierID;
    
    LocalDate date;
    
    ResultSet re;
    
    public boolean payment(int cash,int supplierId,String supplierName){
        
        this.cash = cash;
        this.supplierID = supplierId;
        this.userName = admin.userName;
        
        int ret=0;
             
             connectDataBase c = new connectDataBase();
		try {
                ResultSet re=  c.s.executeQuery("SELECT * FROM contracting.supplier where idsupplier ="+this.supplierID+"");
                while(re.next()){
                    int payment = re.getInt("payment");
                     ret = payment-this.cash;
                     
                     
                      
                    
                }
                
                c.s.executeUpdate("update contracting.supplier set payment = "+ret+ " where idsupplier = "+this.supplierID+"");
                    System.out.println("payment is updated");
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
            c.s.executeUpdate("insert into contracting.supplierpayment(cash , userName,supplierId,date,supplierName) values ("+this.cash+",'"+this.userName+"',"+this.supplierID+",'"+date+"','"+supplierName+"')" );
            System.out.println("inserted");
        } catch (SQLException ex) {

            ex.printStackTrace();
        }
        return true;
    }
    public ResultSet search(LocalDate date){
        this.date=date;
        connectDataBase c = new connectDataBase();
        if(date==null){
            try {
                 re = c.s.executeQuery("SELECT * FROM contracting.supplierpayment");
            } catch (SQLException ex) {

                ex.printStackTrace();
            }
        }else{
            try {
                 re = c.s.executeQuery("SELECT * FROM contracting.supplierpayment where date = '"+this.date+"'");
            } catch (SQLException ex) {

                ex.printStackTrace();
            }
        }
        return re;
    }
    
        
    }
    

