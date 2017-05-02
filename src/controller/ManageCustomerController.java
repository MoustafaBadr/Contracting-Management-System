/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import database.connectDataBase;
import implementation.customer;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;
import tables.companyDetails;
import tables.customerDetails;

/**
 * FXML Controller class
 *
 * @author Mustafa
 */
public class ManageCustomerController implements Initializable {
    @FXML
    private Pane customer;
    @FXML
    private TableView<customerDetails> table_view;
    @FXML
    private TableColumn<String, customerDetails> id;
    @FXML
    private TableColumn<String, customerDetails> name;
    @FXML
    private TableColumn<String,customerDetails> phone;
    @FXML
    private TableColumn<String, customerDetails> address;
    @FXML
    private TableColumn<String, customerDetails> email;
    @FXML
    private TableColumn<String, customerDetails> payment;
    @FXML
    private TableColumn<String,customerDetails> tybe;
    @FXML
    private JFXButton insert;
    @FXML
    private JFXButton update;
    @FXML
    private JFXButton delete;
    @FXML
    private JFXTextField name1;
    @FXML
    private JFXTextField phone1;
    @FXML
    private JFXTextField address1;
    @FXML
    private JFXTextField email1;
    @FXML
    private JFXButton reset;
    @FXML
    private JFXComboBox<String> tybe2;
    
        private ObservableList<customerDetails> data;
        customerDetails cd;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        table_view.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override

            public void handle(MouseEvent t) {
                cd = table_view.getSelectionModel().getSelectedItem() != null ? table_view.getSelectionModel().getSelectedItem() : null;
                if (cd != null) {
                    setTextField();
                }
            }
        });
        retrive();
        
       
        tybe2.getItems().removeAll(tybe2.getItems());
        tybe2.getItems().addAll("individual","company");
    }    

    @FXML
    private void insert(MouseEvent event) {
        
        if(name1.getText().length()==0||phone1.getText().length()==0||tybe2.getValue()==null){
            Notifications notificationBuildeer = Notifications.create().
                            title("warning").
                            text(" name , phone and tybe is required ").
                            graphic(null).
                            hideAfter(Duration.seconds(4)).
                            position(Pos.TOP_RIGHT).
                            onAction(e -> {
                                System.out.println("warning Noti ");
                            });
                    notificationBuildeer.showWarning();

        }else{
        
        String name2 = name1.getText();
        for(int i=0;i<name2.length();i++){
            Character c = name2.charAt(i);
            if(!c.isLetter(c)){
                if(c.equals(' ')){
                    
                    continue;
                    
                }else{

                Notifications notificationBuildeer = Notifications.create().
                            title("warning").
                            text(" the name must not contain digits or signs ").
                            graphic(null).
                            hideAfter(Duration.seconds(4)).
                            position(Pos.TOP_RIGHT).
                            onAction(e -> {
                                System.out.println("warning Noti ");
                            });
                    notificationBuildeer.showWarning();

                return;
            }}
        }
        String phone2 = phone1.getText();
        for(int i=0;i<phone2.length();i++){
            Character c = phone2.charAt(i);
            if(!c.isDigit(c)){

                Notifications notificationBuildeer = Notifications.create().
                            title("warning").
                            text(" the number phone can't contain letters or sign ").
                            graphic(null).
                            hideAfter(Duration.seconds(4)).
                            position(Pos.TOP_RIGHT).
                            onAction(e -> {
                                System.out.println("warning Noti ");
                            });
                    notificationBuildeer.showWarning();

                return;
            }
        }
        String email2 = email1.getText();
        if(email2.length()!=0){
            for(int i=0;i<email2.length();i++){
                Character c = email2.charAt(i);
                if(c.equals('@')){
                    break;
                }else{
                if(i==email2.length()-1){

                    Notifications notificationBuildeer = Notifications.create().
                            title("warning").
                            text(" the email must contain the sign @ ").
                            graphic(null).
                            hideAfter(Duration.seconds(4)).
                            position(Pos.TOP_RIGHT).
                            onAction(e -> {
                                System.out.println("warning Noti ");
                            });
                    notificationBuildeer.showWarning();

                    return;
                }
            }
            }
        }
        String address2 = address1.getText();
        String tybe3 = tybe2.getValue();
        
        customer c = new customer();
        c.insert(name2, phone2, email2, address2, 0, tybe3);
        retrive();
         name1.setText("");
        address1.setText("");
        phone1.setText("");
        tybe2.setValue(null);
        email1.setText("");
        
        }
    }

    @FXML
    private void update(MouseEvent event) {
        
        if(name1.getText().length()==0||phone1.getText().length()==0){
            Notifications notificationBuildeer = Notifications.create().
                            title("warning").
                            text(" name , phone is required ").
                            graphic(null).
                            hideAfter(Duration.seconds(4)).
                            position(Pos.TOP_RIGHT).
                            onAction(e -> {
                                System.out.println("warning Noti ");
                            });
                    notificationBuildeer.showWarning();

        }else{
        
        
         String name2 = name1.getText();
        for(int i=0;i<name2.length();i++){
            Character c = name2.charAt(i);
            if(!c.isLetter(c)){
                if(c.equals(' ')){
                    
                    continue;
                    
                }else{
                

                Notifications notificationBuildeer = Notifications.create().
                            title("warning").
                            text(" the name must not contain digits or signs ").
                            graphic(null).
                            hideAfter(Duration.seconds(4)).
                            position(Pos.TOP_RIGHT).
                            onAction(e -> {
                                System.out.println("warning Noti ");
                            });
                    notificationBuildeer.showWarning();

                return;
                }}
        }
        String phone2 = phone1.getText();
        for(int i=0;i<phone2.length();i++){
            Character c = phone2.charAt(i);
            if(!c.isDigit(c)){

                Notifications notificationBuildeer = Notifications.create().
                            title("warning").
                            text(" the number phone can't contain letters or sign ").
                            graphic(null).
                            hideAfter(Duration.seconds(4)).
                            position(Pos.TOP_RIGHT).
                            onAction(e -> {
                                System.out.println("warning Noti ");
                            });
                    notificationBuildeer.showWarning();

                return;
            }
        }
        String email2 = email1.getText();
        if(email2.length()!=0){
            for(int i=0;i<email2.length();i++){
                Character c = email2.charAt(i);
                if(c.equals('@')){
                    break;
                }else{
                if(i==email2.length()-1){

                    Notifications notificationBuildeer = Notifications.create().
                            title("warning").
                            text(" the email must contain the sign @ ").
                            graphic(null).
                            hideAfter(Duration.seconds(4)).
                            position(Pos.TOP_RIGHT).
                            onAction(e -> {
                                System.out.println("warning Noti ");
                            });
                    notificationBuildeer.showWarning();

                    return;
                }
            }
            }
        }
        String address2 = address1.getText();
        
         ResultSet rss = null;
        
        int selectedItem = table_view.getSelectionModel().getSelectedIndex();
        int customerId = Integer.parseInt(data.get(selectedItem).IdProperty().getValue());
        
        String tybe3 = tybe2.getValue();
        if(tybe3==null){
             try {
                 connectDataBase c = new connectDataBase();
                 ResultSet re = c.s.executeQuery("select * from contracting.customer where idcustomer = "+customerId);
                 while(re.next()){
                     tybe3 = re.getString("tybe");
                 }
             } catch (Exception ex) {

                 ex.printStackTrace();
             }
        }
        customer c = new customer();
        c.update(customerId, name2, phone2, email2, address2,  tybe3);
        
        retrive();
        name1.setText("");
        address1.setText("");
        phone1.setText("");
        tybe2.setValue(null);
        email1.setText("");
        
    }
    }
    @FXML
    private void delete(MouseEvent event) {
        
        ResultSet rss = null;
        
        int selectedItem = table_view.getSelectionModel().getSelectedIndex();
        int customerId = Integer.parseInt(data.get(selectedItem).IdProperty().getValue());
        customer c = new customer();
        c.delete(customerId);
        retrive();
         name1.setText("");
        address1.setText("");
        phone1.setText("");
        tybe2.setValue(null);
        email1.setText("");
        
        
        
    }
    public void retrive(){
        data = FXCollections.observableArrayList();
         customer customer = new customer();
        ResultSet re=customer.search();
        try {
            while(re.next()){
                data.add(new customerDetails(re.getString("idcustomer"), re.getString("name"), re.getString("address"), re.getString("phone"), re.getString("payment"), re.getString("email"), re.getString("tybe")));
            }
            id.setCellValueFactory(new PropertyValueFactory<>("id"));
            name.setCellValueFactory(new PropertyValueFactory<>("name"));
            address.setCellValueFactory(new PropertyValueFactory<>("address"));
            tybe.setCellValueFactory(new PropertyValueFactory<>("tybe"));
            payment.setCellValueFactory(new PropertyValueFactory<>("payment"));
            phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
            email.setCellValueFactory(new PropertyValueFactory<>("email"));
            
            table_view.setItems(null);
            table_view.setItems(data);
            
            
            // TODO
        } catch (SQLException ex) {

            ex.printStackTrace();
        }
    }
    public void setTextField(){
        this.name1.setText(cd != null ? cd.NameProperty().getValue() : "");
        this.address1.setText(cd != null ? cd.AddressProperty().getValue() : "");
        this.email1.setText(cd != null ? cd.emailProperty().getValue() : "");
        this.phone1.setText(cd != null ? cd.phoneProperty().getValue() : "");
     
        
        
    }
    @FXML
    public void reset(MouseEvent event) {
        name1.setText("");
        address1.setText("");
        phone1.setText("");
        tybe2.setValue(null);
        email1.setText("");
        
    }
}
