/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import database.Dataconnection;
import implementation.civilEmployees;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

import tables.Workers;
import tables.employee;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author mostafa
 */
public class WorkerfxmlController implements Initializable {
    
  
    
    @FXML
    private JFXTextField workerid;
   
  
    @FXML
    public JFXComboBox projectbox;
    @FXML
    private TableView<Workers> table;
    @FXML
    private TableColumn<Workers,String> firstName;
    @FXML
    private TableColumn<Workers,String> LastName;
    @FXML
    private TableColumn<Workers, String> job;
    @FXML
    private TableColumn<Workers, String> state;
    @FXML
    private TableColumn<Workers, String> project;
     
    
    private ObservableList<Workers> list;
    
   
    
   

     Connection con = Dataconnection.mkDataBase();
     PreparedStatement pst = null;
     ResultSet rs = null;
    @FXML
    private JFXComboBox<String> job1;
    @FXML
    private TableColumn<Workers, String> ID;
    

   
    
     public void mange(ActionEvent event) throws IOException {
        System.out.println("You clicked me!");
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/view/FXMLDocument.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        app_stage.hide(); //optional
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
    public void salary(ActionEvent event) throws IOException {
        System.out.println("You clicked me!");
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/view/salaryFXML.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        app_stage.hide(); //optional
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
     
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        
        try {
            projectbox.getItems().removeAll(projectbox.getItems());
            String selectsql2 ="SELECT name FROM contracting.projects";
            pst = con.prepareStatement(selectsql2);
            rs = pst.executeQuery();
            
            
            while(rs.next()){
                projectbox.getItems().add(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(WorkerfxmlController.class.getName()).log(Level.SEVERE, null, ex);
        }
        job1.getItems().removeAll(job1.getItems());
        job1.getItems().addAll("engineer","reciptionist","builder","superviosur","manager");

      
    }    
    
    @FXML
    private void search(ActionEvent event) throws IOException, SQLException {
       list = FXCollections.observableArrayList();
  
        if (job1.getValue().equals(null)) {
            Notifications notificationBuildeer = Notifications.create().
                    title("warning").
                    text("jop name is requied").
                    graphic(null).
                    hideAfter(Duration.seconds(4)).
                    position(Pos.TOP_RIGHT).
                    onAction(e -> {
                        System.out.println("warning Noti ");
                    });
            notificationBuildeer.showWarning();
        } else {
            String n = job1.getValue();

            civilEmployees c = new civilEmployees();
            rs = c.search(n);
            if (!(rs.next())) {

                Notifications notificationBuildeer = Notifications.create().
                        title("warning").
                        text("Not Found").
                        graphic(null).
                        hideAfter(Duration.seconds(4)).
                        position(Pos.TOP_RIGHT).
                        onAction(e -> {
                            System.out.println("warning Noti ");
                        });
                notificationBuildeer.showWarning();
            } else {
                do {

                    list.add(new Workers(rs.getString(6),rs.getString(1), rs.getString(2), rs.getString(4), rs.getString(3), rs.getString(5)));

                } while (rs.next());
            }

            firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
            LastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
            job.setCellValueFactory(new PropertyValueFactory<>("jop"));
            state.setCellValueFactory(new PropertyValueFactory<>("state"));
            project.setCellValueFactory(new PropertyValueFactory<>("project"));
            ID.setCellValueFactory(new PropertyValueFactory<>("id"));
            

            table.setItems(null);
            table.setItems(list);
        }
        
        
    }
    
    
    
    @FXML
    private void join() throws IOException, SQLException {
        
    if (workerid.getText().equals("")) {
            Notifications notificationBuildeer = Notifications.create().
                    title("warning").
                    text("ID is requied").
                    graphic(null).
                    hideAfter(Duration.seconds(4)).
                    position(Pos.TOP_RIGHT).
                    onAction(e -> {
                        System.out.println("warning Noti ");
                    });
            notificationBuildeer.showWarning();
        } else {
            int n = Integer.parseInt(workerid.getText());



            civilEmployees c = new civilEmployees();
            c.JoinProject(n, (String)projectbox.getValue());

            Notifications notificationBuildeer = Notifications.create().
                    title("updated").
                    text("The Worker has been Joined").
                    graphic(null).
                    hideAfter(Duration.seconds(4)).
                    position(Pos.TOP_RIGHT).
                    onAction(e -> {

                        System.out.println("update Noti ");
                    });
            notificationBuildeer.showConfirm();

        
        }

        }
    @FXML
    private void finsh() throws IOException, SQLException {
        
     if (workerid.getText().equals("")) {
            Notifications notificationBuildeer = Notifications.create().
                    title("warning").
                    text("ID is requied").
                    graphic(null).
                    hideAfter(Duration.seconds(4)).
                    position(Pos.TOP_RIGHT).
                    onAction(e -> {
                        System.out.println("warning Noti ");
                    });
            notificationBuildeer.showWarning();
        } else {
            int n = Integer.parseInt(workerid.getText());



            civilEmployees c = new civilEmployees();
            c.LeftProject(n, (String)projectbox.getValue());
            Notifications notificationBuildeer = Notifications.create().
                    title("updated").
                    text("The Worker is free ").
                    graphic(null).
                    hideAfter(Duration.seconds(4)).
                    position(Pos.TOP_RIGHT).
                    onAction(e -> {

                        System.out.println("update Noti ");
                    });
            notificationBuildeer.showConfirm();

        } 

    }
    
        
        
    }
    
    
    
    
    

