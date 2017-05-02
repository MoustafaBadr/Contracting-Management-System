/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation;

import database.connectDataBase;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Pos;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 *
 * @author Mustafa
 */
public class projects {

    String name;
    String address;
    String timeLine;

    int payment;

    ResultSet re;

    public boolean insert(String name, String date, String address, int payment, String comName, String tybe) {
        this.name = name;
        this.address = address;

        this.timeLine = date;
        int employeeid = 0;
        connectDataBase c = new connectDataBase();

        try {
            ResultSet r = c.s.executeQuery("select * from contracting.customer where name = '" + comName + "' and tybe = '" + tybe + "'");
            while (r.next()) {
                employeeid = r.getInt(1);
                this.payment = r.getInt("payment") + payment;

            }

            c.s.executeUpdate("insert into contracting.projects (name , timeLine,address,customerId,payment,tybe)Values ( '" + this.name + "','" + this.timeLine + "','" + this.address + "'," + employeeid + "," + payment + ",'" + tybe + "')");

            c.s.executeUpdate("update contracting.customer set payment = " + this.payment + " where idcustomer = " + employeeid);
            System.out.println("updated");
//             Notifications notificationBuildeer = Notifications.create().
//                    title("Sucess").
//                    text("ADD Successfuly").
//                    graphic(null).
//                    hideAfter(Duration.seconds(4)).
//                    position(Pos.TOP_RIGHT).
//                    onAction(e -> {
//                        System.out.println("");
//                    });
//            notificationBuildeer.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
      return true;

    }

    public boolean update(String name, String date, String address, int payment, String comName, String tybe, int id) {
               this.name = name;
        this.address = address;

        this.timeLine = date;
        int employeeid = 0;
        int lastPayment = 0;
        connectDataBase c = new connectDataBase();
        try {

            ResultSet r = c.s.executeQuery("select * from contracting.customer where name = '" + comName + "' and tybe = '" + tybe + "'");
            while (r.next()) {
                employeeid = r.getInt(1);
                this.payment = r.getInt("payment");

            }
            ResultSet res = c.s.executeQuery("SELECT * FROM contracting.projects where idprojects=" + id);
            while (res.next()) {
                lastPayment = res.getInt("payment");
            }
            int payment1 = this.payment - lastPayment + payment;

            c.s.executeUpdate("update contracting.customer set payment = " + payment1 + " where idcustomer = " + employeeid);

            // c.s.executeUpdate("update contracting.projects set name = '" + name + "' and payment = " + payment + "and timeLine = '" + date + "' and customerId = " + employeeid + " and address = '" + address + "where idprojects = " + id);
            c.s.executeUpdate("update contracting.projects set address = '" + address + "' where idprojects =" + id);
            c.s.executeUpdate("update contracting.projects set name = '" + name + "' where idprojects =" + id);
            c.s.executeUpdate("update contracting.projects set timeLine = '" + date + "' where idprojects =" + id);
            c.s.executeUpdate("update contracting.projects set payment = '" + payment + "' where idprojects =" + id);
            c.s.executeUpdate("update contracting.projects set customerId = '" + employeeid + "' where idprojects =" + id);
//
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;

    }

    public ResultSet search(String tybe) {

        try {
            connectDataBase c = new connectDataBase();
            re = c.s.executeQuery("SELECT * FROM contracting.projects where tybe = '" + tybe + "'");
        } catch (SQLException ex) {

            ex.printStackTrace();
        }
        return re;
    }

    public boolean delete(int id) {
        connectDataBase c = new connectDataBase();
        int customerId = 0;
        int pay = 0;
        int payment1 = 0;
        String tybe = null;
        try {
            ResultSet re = c.s.executeQuery("SELECT * FROM contracting.projects where idprojects = " + id + "");
            while (re.next()) {
                customerId = re.getInt(4);
                pay = re.getInt(6);

            }
        } catch (Exception ex) {

            ex.printStackTrace();
        }

        try {
            c.s.executeUpdate("delete from contracting.projects where idprojects= " + id);
        } catch (SQLException ex) {

            ex.printStackTrace();
        }
        try {
            ResultSet r = c.s.executeQuery("select * from contracting.customer where idcustomer = " + customerId + "");
            while (r.next()) {
                payment1 = r.getInt(7);
                tybe = r.getString(6);
            }
 
                payment1 -= pay;
                c.s.executeUpdate("update contracting.customer set payment = " + payment1 + " where idcustomer = " + customerId);

//                 Notifications notificationBuildeer = Notifications.create().
//                    title("Sucess").
//                    text("DELETED Successfuly").
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
}
