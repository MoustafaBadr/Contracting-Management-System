/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import database.connectDataBase;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class Controllers implements Initializable {

    @FXML
    private Label total_employee;

    @FXML
    private Label total_customer;

    @FXML
    private Label total_store;

    @FXML
    private Label total_supplyer;

    @FXML
    private Label total_poject;

    connectDataBase c=new connectDataBase();
    ResultSet rs = null;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            
            ResultSet rs = c.s.executeQuery("SELECT count(*) FROM contracting.customer");
            while (rs.next()) {
                total_customer.setText(rs.getString(1));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        try {
            
            ResultSet rs = c.s.executeQuery("SELECT count(*) FROM contracting.employee;");
            while (rs.next()) {
                total_employee.setText(rs.getString(1));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        try {
            
            ResultSet rs = c.s.executeQuery("SELECT count(*) FROM contracting.projects;");
            while (rs.next()) {
                total_poject.setText(rs.getString(1));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        try {
            
            ResultSet rs = c.s.executeQuery("SELECT count(*) FROM contracting.supplier");
            while (rs.next()) {
                total_supplyer.setText(rs.getString(1));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        try {
            
            ResultSet rs = c.s.executeQuery("SELECT count(*) FROM contracting.store;");
            while (rs.next()) {
                total_store.setText(rs.getString(1));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }


    void show(ActionEvent event)  {
//        try {
//
//            st = con.createStatement();
//
//            total_customer.setText(st.executeQuery("select  COUNT (*) from customer  ").toString());
//            total_employee.setText(st.executeQuery("select  COUNT (*) from employee ").toString());
//            total_poject.setText(st.executeQuery("select  COUNT (*) from projects ").toString());
//            total_store.setText(st.executeQuery("select  COUNT (*) from store ").toString());
//            total_supplyer.setText(st.executeQuery("select  COUNT (*) from supplier ").toString());
//
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            System.out.println(ex.toString());
//
//        }
    }

    @FXML
    private void add(MouseEvent event) {
    }

}
