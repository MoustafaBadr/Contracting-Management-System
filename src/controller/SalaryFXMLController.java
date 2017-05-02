/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import implementation.employeesSalary;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
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
import javafx.stage.Stage;
import javafx.util.Duration;

import tables.Workers;
import tables.salary;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author mostafa
 */
public class SalaryFXMLController implements Initializable {
    ObservableList<String> percentlist = FXCollections.observableArrayList("10% bouns","50% bouns","70% bouns");
    
    
    @FXML
    private JFXComboBox percent;
    
    @FXML
    private TableView<salary> table;
    @FXML
    private TableColumn<salary, String> firstName;
    @FXML
    private TableColumn<salary,String> LastName;
    @FXML
    private TableColumn<salary, String> job;
    @FXML
    private TableColumn<salary,Integer> salary;
    
    
     private ObservableList<salary> list;
    
   
    
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    

    
    
    
     @FXML
     public void worker(ActionEvent event) throws IOException {
        System.out.println("You clicked me!");
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/view/workerfxml.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        app_stage.hide(); //optional
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
      @FXML
     public void mange(ActionEvent event) throws IOException {
        System.out.println("You clicked me!");
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/view/FXMLDocument.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        app_stage.hide(); //optional
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
    
    
     
     
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        percent.setValue("10% bouns");
        percent.setItems(percentlist);  
    }    
    @FXML
     private void total(ActionEvent e)throws IOException,SQLException{
         employeesSalary s = new employeesSalary();
         int i=s.computeTotal();
          Notifications notificationBuildeer = Notifications.create().
                    title("warning").
                    text(" the total reminder is "+i+"").
                    graphic(null).
                    hideAfter(Duration.seconds(4)).
                    position(Pos.TOP_RIGHT).
                    onAction(new EventHandler<ActionEvent>() {

             public void handle(ActionEvent e) {
                 System.out.println("information Noti ");
             }
         });
            notificationBuildeer.showInformation();

     
     }
     
     @FXML
     private void bouns(ActionEvent ex)throws IOException,SQLException{
     list = FXCollections.observableArrayList();
     if (percent.getValue().equals("10% bouns")){
         
         employeesSalary s = new employeesSalary();
         rs=s.computeBouns("10% bouns");
            while (rs.next()){
            list.add(new salary(rs.getString(1), rs.getString(2), rs.getString(3),rs.getInt(4)));
            }
            
            firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
            LastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
            job.setCellValueFactory(new PropertyValueFactory<>("jop"));
            salary.setCellValueFactory(new PropertyValueFactory<>("Salary"));
            
            

             table.setItems(null);
             table.setItems(list);
     
     }
     else if (percent.getValue().equals("50% bouns")){
         employeesSalary s = new employeesSalary();
          rs = s.computeBouns("50% bouns");
            while (rs.next()){
            list.add(new salary(rs.getString(1), rs.getString(2), rs.getString(3),rs.getInt(4)));
            }
            
            firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
            LastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
            job.setCellValueFactory(new PropertyValueFactory<>("jop"));
            salary.setCellValueFactory(new PropertyValueFactory<>("Salary"));
            
            

             table.setItems(null);
             table.setItems(list);
     
     }
     else if (percent.getValue().equals("70% bouns")){
         
         employeesSalary s = new employeesSalary();
          rs=s.computeBouns("70% bouns");
            
            while (rs.next()){
            list.add(new salary(rs.getString(1), rs.getString(2), rs.getString(3),rs.getInt(4)));
            }
            
            firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
            LastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
            job.setCellValueFactory(new PropertyValueFactory<>("jop"));
            salary.setCellValueFactory(new PropertyValueFactory<>("Salary"));
            
            

             table.setItems(null);
             table.setItems(list);
     
     }
     
     
     }
    
    
}
