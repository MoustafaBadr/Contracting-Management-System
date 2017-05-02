/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation;

import com.mysql.jdbc.PreparedStatement;
import database.Dataconnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mustafa
 */
public class employee {
    

    String FirstName;
    String LastName;
    String email;
    String phone;
    String address;
    String State;
    String job;
    String salary;
    
     Connection con = Dataconnection.mkDataBase();
    java.sql.PreparedStatement pst = null;
    ResultSet rs = null;
 //   public void insert(String fiName,String lasNmae, String phone,String salary,String email,String address,String state,String job){
        
//        try {
//          
//        
//            this.FirstName=fiName;
//            this.LastName=lasNmae;
//            this.State=state;
//            this.address=address;
//            this.email = email;
//            this.job=job;
//            this.phone=phone;
//            this.salary = salary;
//           
//            
//            String Sql = "INSERT INTO `contracting`.`employee` (`firstName`, `lastName`, `phone`, `salary`, `email`, `address`, `state`, `job`) VALUES "
//                    + "( '" + this.FirstName + "' ,  '" + this.LastName + "' , '" + this.salary + "','" + this.email + "' , '" + this.address + "' , '" + this.State + "' , '" + this.job + "'  )";
//            
//            pst = con.prepareStatement(Sql);
//            pst.execute();
//        } catch (SQLException ex) {
//
//            ex.printStackTrace();
//        }
//        
   // }
    public ResultSet searchemail(String n){
        try {
           
            
            String selectsql = "SELECT idemployee,firstName,lastName,phone,salary,email,address,state,job FROM contracting.employee where email=? ";
            
            
             pst = con.prepareStatement(selectsql);
            pst.setString(1, n);
            rs = pst.executeQuery();
        } catch (SQLException ex) {

            ex.printStackTrace();
        }
        return rs;
        
    }
    public ResultSet search(String jop){
        try {
            
            String selectsql = "SELECT idemployee,firstName,lastName,phone,salary,email,address,state,job FROM contracting.employee where job=? ";
            pst = con.prepareStatement(selectsql);
            pst.setString(1,jop);
            rs = pst.executeQuery();
        } catch (SQLException ex) {

            ex.printStackTrace();
        }
        return rs;
    }
    public boolean update(String fiName,String lasNmae, String phone,String salary,String email,String address,String state,String job){
       
        
        try {
            this.FirstName=fiName;
            this.LastName=lasNmae;
            this.State=state;
            this.address=address;
            this.email = email;
            this.job=job;
            this.phone=phone;
            this.salary = salary;
        

            
            String sql2 = "UPDATE `contracting`.`employee` SET  `firstName`='" + FirstName + "', `lastName`='" + LastName + "', `phone`='" + this.phone + "', `salary`='" + this.salary + "', `email`= '" + this.email + "', `address`='" + this.address + "', `state`='" + this.State + "', `job`='" + this.job + "' WHERE `email`='";
            
            pst = con.prepareStatement(sql2);
            pst.execute();
        } catch (SQLException ex) {

        
            ex.printStackTrace();
        }
        return true;
    }
    public boolean delete(String email){
         try{
            
        String sql2 = "DELETE FROM `contracting`.`employee` WHERE `email`='" + email + "' ";

               pst = con.prepareStatement(sql2);
                pst.execute();
        }catch(Exception ex){
            ex.printStackTrace();
        }
         return true;
    
    }
    
    
}
