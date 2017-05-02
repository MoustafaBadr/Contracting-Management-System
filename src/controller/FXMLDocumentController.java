/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import database.Dataconnection;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import tables.employee;
import org.controlsfx.control.Notifications;

/**
 *
 * @author mostafa
 */
public class FXMLDocumentController implements Initializable {
     ObservableList<String> joplist = FXCollections.observableArrayList("Email", "Jop_name");
     ObservableList<String> statelist = FXCollections.observableArrayList("free", "busy");
   
     @FXML
    private JFXTextField choise;
     @FXML
    private JFXTextField first_name;
     @FXML
    private JFXTextField last_name;
     @FXML
    private JFXTextField phone;
     @FXML
    private JFXTextField salary;
     @FXML
    private JFXTextField email;
     @FXML
    private JFXTextField address;
     @FXML
    private JFXComboBox statebox;
     @FXML
    private JFXComboBox jopBox;

   
    
    
    
   @FXML
    private TableView<employee> table;

   
   
    @FXML
    private TableColumn<employee, String> firstnameColumn;

    @FXML
    private TableColumn<employee, String> lastnameColumn;

    @FXML
    private TableColumn<employee, String> phoneColumn;

    @FXML
    private TableColumn<employee, Integer> salaryColumn;

    @FXML
    private TableColumn<employee, String> emailColumn;

    @FXML
    private TableColumn<employee, String> addressColumn;

    @FXML
    private TableColumn<employee,String> statColumn;
    @FXML
    private TableColumn<employee,String> jopColumn;


    private ObservableList<employee> list;
    
    employee emploeeopject;
    
  Connection con = Dataconnection.mkDataBase();
    PreparedStatement pst = null;
    ResultSet rs = null;
    @FXML
    private JFXComboBox<String> job2;
    
    
    
   
    
     
     
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         retrive();
            

        jopBox.setValue("Email");
        jopBox.setItems(joplist);     
        statebox.setValue("free");
        statebox.setItems(statelist);     
        
        
         table.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override

            public void handle(MouseEvent t) {
                emploeeopject = table.getSelectionModel().getSelectedItem() != null ? table.getSelectionModel().getSelectedItem() : null;
                if (emploeeopject != null) {
                    setTextFieldData();
                }
            }
        });
        list = FXCollections.observableArrayList();
        job2.getItems().removeAll(job2.getItems());
        job2.getItems().addAll("engineer","reciptionist","builder","superviosur","manager");

       
    }  
    
    
    @FXML
    private void search(ActionEvent event) throws IOException, SQLException {
       list = FXCollections.observableArrayList();
        
       if(choise.getText().equals("")){
        Notifications notificationBuildeer = Notifications.create().
                        title("warning").
                        text("Your Choise is requied").
                        graphic(null).
                        hideAfter(Duration.seconds(4)).
                        position(Pos.TOP_RIGHT).
                        onAction(e -> {
                            System.out.println("warning Noti ");
                        });
                notificationBuildeer.showWarning();
        }  
        else if (jopBox.getValue().equals("Email")) {
           String n = choise.getText();
           implementation.employee e = new implementation.employee();
           rs=e.searchemail(n);
            
           if (!(rs.next())){
           
            Notifications notificationBuildeer = Notifications.create().
                        title("warning").
                        text(" not found ").
                        graphic(null).
                        hideAfter(Duration.seconds(4)).
                        position(Pos.TOP_RIGHT).
                        onAction(new EventHandler<ActionEvent>() {

                public void handle(ActionEvent e) {
                    System.out.println("warning Noti ");
                }
            });
                notificationBuildeer.showWarning();
           }
           else {
               do {
                   
                list.add(new employee(rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9)));
                
            }while (rs.next());
           }
           
            
           
            firstnameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
            lastnameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
            phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
            salaryColumn.setCellValueFactory(new PropertyValueFactory<>("Salary"));
            emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
            addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
            statColumn.setCellValueFactory(new PropertyValueFactory<>("state"));
            jopColumn.setCellValueFactory(new PropertyValueFactory<>("jop"));

            table.setItems(null);
             table.setItems(list);
        } else if (jopBox.getValue().equals("Jop_name")) {
            String Jop = choise.getText();
            implementation.employee e = new implementation.employee();
            rs =e.search(Jop);
            
            if (!(rs.next())){
           
            Notifications notificationBuildeer = Notifications.create().
                        title("warning").
                        text("Not Found").
                        graphic(null).
                        hideAfter(Duration.seconds(4)).
                        position(Pos.TOP_RIGHT).
                        onAction(new EventHandler<ActionEvent>() {

                public void handle(ActionEvent e) {
                    System.out.println("warning Noti ");
                }
            });
              notificationBuildeer.showWarning();
           }else{
            
    do {
                list.add(new employee(rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9)));
            }while(rs.next());
    }
            
        

         
            firstnameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
            lastnameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
            phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
            salaryColumn.setCellValueFactory(new PropertyValueFactory<>("Salary"));
            emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
            addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
            statColumn.setCellValueFactory(new PropertyValueFactory<>("state"));
            jopColumn.setCellValueFactory(new PropertyValueFactory<>("jop"));

            table.setItems(null);
             table.setItems(list);
        }

    
    
    }
    
     @FXML
    void resetFields(ActionEvent event) {
        first_name.clear();
        last_name.clear();
        phone.clear();
        email.clear();
        job2.setValue(null);
        address.clear();
        salary.clear();

    }
    
    
    
    
    @FXML
     void save(ActionEvent event) throws SQLException {
        int phoneNumberInt = 0;
        String email1 = this.email.getText();

        try {

            if (first_name.getText().equals("")) {
                Notifications notificationBuildeer = Notifications.create().
                        title("warning").
                        text("first  name is requied").
                        graphic(null).
                        hideAfter(Duration.seconds(4)).
                        position(Pos.TOP_RIGHT).
                        onAction(e -> {
                            System.out.println("warning Noti ");
                        });
                notificationBuildeer.showWarning();

            } else if (last_name.getText().equals("")) {
                Notifications notificationBuildeer = Notifications.create().
                        title("warning").
                        text("last  name is requied").
                        graphic(null).
                        hideAfter(Duration.seconds(4)).
                        position(Pos.TOP_RIGHT).
                        onAction(e -> {
                            System.out.println("warning Noti ");
                        });
                notificationBuildeer.showWarning();

            } else if (salary.getText().equals("")) {
                Notifications notificationBuildeer = Notifications.create().
                        title("warning").
                        text("salary  name is requied").
                        graphic(null).
                        hideAfter(Duration.seconds(4)).
                        position(Pos.TOP_RIGHT).
                        onAction(e -> {
                            System.out.println("warning Noti ");
                        });
                notificationBuildeer.showWarning();

            }  else {
                try {
                    phoneNumberInt = Integer.parseInt(phone.getText());
                } catch (NumberFormatException ex) {
                    Notifications notificationBuildeer = Notifications.create().
                            title("error").
                            text("phone number field must contained number values only").
                            graphic(null).
                            hideAfter(Duration.seconds(4)).
                            position(Pos.TOP_RIGHT);
                    notificationBuildeer.showWarning();
                    phone.clear();
                    throw new Exception();

                }
                try {
                    for (int i = 1; i < email1.length(); i++) {
                        if (!email1.contains("@")) {
                            throw new NullPointerException("email not valid");
                        }
                    }
                } catch (Exception ex) {
                    Notifications notificationBuildeer = Notifications.create().
                            title("error").
                            text("email not valid").
                            graphic(null).
                            hideAfter(Duration.seconds(4)).
                            position(Pos.TOP_RIGHT);
                    notificationBuildeer.showWarning();
                     email.clear();
                    throw new Exception();
                }

              String Sql = "INSERT INTO `contracting`.`employee` (`firstName`, `lastName`, `phone`, `salary`, `email`, `address`, `state`, `job`,`project`) VALUES "
                        + "( '" + first_name.getText() + "' ,  '" + last_name.getText() + "' , '" + phone.getText() + "' ,'" + salary.getText() + "','" + email.getText() + "' , '" + address.getText() + "' , '" + statebox.getValue()+ "' , '" + job2.getValue() + "','"+null+"'  )";

                pst = con.prepareStatement(Sql);
                pst.execute();
                Notifications notificationBuildeer = Notifications.create().
                        title("Saved").
                        text("The Document is saved").
                        graphic(null).
                        hideAfter(Duration.seconds(4)).
                        position(Pos.TOP_RIGHT).
                        onAction(new EventHandler<ActionEvent>() {

                    public void handle(ActionEvent e) {
                        System.out.println("saved Noti ");
                    }
                });
                notificationBuildeer.showConfirm();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        retrive();

    }
    @FXML
    void update() throws SQLException {
        int phoneNumberInt = 0;

        try {
            if (table.getSelectionModel().getSelectedIndex() == -1) {
                Notifications notificationBuildeer = Notifications.create().
                        title("warning").
                        text("you should selcect a row ").
                        graphic(null).
                        hideAfter(Duration.seconds(4)).
                        position(Pos.TOP_RIGHT).
                        onAction(e -> {

                            System.out.println("warning Noti ");

                        });
                notificationBuildeer.showError();
            } else {
                try {
                    phoneNumberInt = Integer.parseInt(phone.getText());
                } catch (NumberFormatException ex) {
                    Notifications notificationBuildeer = Notifications.create().
                            title("error").
                            text("phone number field must contained number values only").
                            graphic(null).
                            hideAfter(Duration.seconds(4)).
                            position(Pos.TOP_RIGHT);
                    notificationBuildeer.showWarning();
                    phone.clear();
                    throw new Exception();

                }
                int selectedItem = table.getSelectionModel().getSelectedIndex();
              
                
                implementation.employee e = new implementation.employee();
                                e.update(first_name.getText(), last_name.getText(), phone.getText(), salary.getText(), email.getText(), address.getText(),(String) statebox.getValue(), job2.getValue());

                
                
                Notifications notificationBuildeer;
                notificationBuildeer = Notifications.create().
                        title("updated").
                        text("The Document has been updated").
                        graphic(null).
                        hideAfter(Duration.seconds(4)).
                        position(Pos.TOP_RIGHT).
                        onAction(new EventHandler<ActionEvent>() {

                    public void handle(ActionEvent e) {
                        System.out.println("update Noti ");
                    }
                });
                notificationBuildeer.showConfirm();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        retrive();
    }
    
    
    
    @FXML
    void delete() throws SQLException {

        try {

            if (table.getSelectionModel().getSelectedIndex() == -1) {
                Notifications notificationBuildeer = Notifications.create().
                        title("warning").
                        text("you shoud select a row").
                        graphic(null).
                        hideAfter(Duration.seconds(4)).
                        position(Pos.TOP_RIGHT).
                        onAction(e -> {

                            System.out.println("warning Noti ");

                        });
                notificationBuildeer.showError();
            } else {

                ResultSet rss = null;

                int selectedItem = table.getSelectionModel().getSelectedIndex();
                String email =list.get(selectedItem).email().getValue();
                implementation.employee e = new implementation.employee();
                e.delete(email);
                Notifications notificationBuildeer = Notifications.create().
                        title("deleted").
                        text("The Document has been deleted").
                        graphic(null).
                        hideAfter(Duration.seconds(4)).
                        position(Pos.TOP_RIGHT).
                        onAction(new EventHandler<ActionEvent>() {

                    public void handle(ActionEvent e) {
                        System.out.println("delete Noti ");
                    }
                });
                notificationBuildeer.showConfirm();

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        retrive();

    }
    public void retrive() {
        try {
            list = FXCollections.observableArrayList();
          
            String selectsql1 ="SELECT * FROM contracting.employee";
                     pst = con.prepareStatement(selectsql1);
                     rs = pst.executeQuery();
            
           
            list.clear();
            while (rs.next()) {
                list.add(new employee( rs.getString(7), rs.getString(8), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(9)));
            }
        } catch (SQLException e) {

            System.out.println(e.getMessage());

            System.out.println(e.getMessage());

        }
       
        firstnameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastnameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        salaryColumn.setCellValueFactory(new PropertyValueFactory<>("Salary"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        statColumn.setCellValueFactory(new PropertyValueFactory<>("state"));
        jopColumn.setCellValueFactory(new PropertyValueFactory<>("jop"));
        

        table.setItems(null);
        table.setItems(list);
    }
    
    
    
    private void setTextFieldData() {
        this.first_name.setText(emploeeopject != null ? emploeeopject.firstName().getValue() : "");
        this.last_name.setText(emploeeopject != null ? emploeeopject.lastName().getValue() : "");
        this.phone.setText(emploeeopject != null ? emploeeopject.phone().getValue() : "");
        this.statebox.setValue(emploeeopject != null ? emploeeopject.state().getValue() : "");
        this.address.setText(emploeeopject != null ? emploeeopject.address().getValue() : "");
        this.email.setText(emploeeopject != null ? emploeeopject.email().getValue() : "");
        this.job2.setValue(emploeeopject != null ? emploeeopject.jop().getValue() : "");
        this.salary.setText((emploeeopject != null ? emploeeopject.Salary().getValue(): ""));
        
    }
    
     
     

}
