/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation;

import database.Dataconnection;
import database.connectDataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mustafa
 */
public class employeesSalary extends employee {

    Connection con = Dataconnection.mkDataBase();
    PreparedStatement pst = null;
    ResultSet rs = null;

    public ResultSet computeBouns(String bouns) {
        try {
            connectDataBase c = new connectDataBase();

            if (bouns.equals("10% bouns")) {

                try {
                    String selectsql = "SELECT firstName,lastName,job,salary,idemployee FROM contracting.employee  ";
                    pst = con.prepareStatement(selectsql);
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        int salary = rs.getInt(4);
                        salary += (salary * 10) / 100;
                        int id = rs.getInt(5);
                        c.s.executeUpdate("UPDATE contracting.employee set salary= " + salary + " where idemployee= " + id + "");

                    }
                } catch (SQLException ex) {

                    ex.printStackTrace();
                }

            } else if (bouns.equals("50% bouns")) {
                try {
                    String selectsql = "SELECT firstName,lastName,job,salary,idemployee FROM contracting.employee  ";
                    pst = con.prepareStatement(selectsql);
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        int salary = rs.getInt(4);
                        salary += (salary * 50) / 100;
                        int id = rs.getInt(5);
                        c.s.executeUpdate("UPDATE contracting.employee set salary= " + salary + " where idemployee= " + id + "");

                    }
                } catch (SQLException ex) {

                    ex.printStackTrace();
                }

            } else if (bouns.equals("70% bouns")) {
                try {
                    String selectsql = "SELECT firstName,lastName,job,salary,idemployee FROM contracting.employee  ";
                    pst = con.prepareStatement(selectsql);
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        int salary = rs.getInt(4);
                        salary += (salary * 70) / 100;
                        int id = rs.getInt(5);
                        c.s.executeUpdate("UPDATE contracting.employee set salary= " + salary + " where idemployee= " + id + "");

                    }
                } catch (SQLException ex) {

                    ex.printStackTrace();
                }

            }
            String selectsql = "SELECT firstName,lastName,job,salary,idemployee FROM contracting.employee  ";
            pst = con.prepareStatement(selectsql);
            rs = pst.executeQuery();

        } catch (SQLException ex) {

            ex.printStackTrace();
        }
        return rs;

    }

    public int computeTotal() {
        int i = 0;
        try {

            String selectsql = "select * from contracting.employee";
            pst = con.prepareStatement(selectsql);
            rs = pst.executeQuery();

            while (rs.next()) {
                i += rs.getInt("salary");
            }
        } catch (SQLException ex) {

            ex.printStackTrace();
        }
        return i;

    }

    public static void main(String[] args) {
        employeesSalary e = new employeesSalary();

        System.out.println(e.computeTotal());
    }

}
