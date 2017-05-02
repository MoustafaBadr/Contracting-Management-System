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
import implementation.projects;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;
import tables.companyDetails;
import tables.individualDetails;

/**
 * FXML Controller class
 *
 * @author Mustafa
 */
public class IndividualProjectsController implements Initializable {
    @FXML
    private TableView<individualDetails> table_view;
    @FXML
    private TableColumn<String, individualDetails> id;
    @FXML
    private TableColumn<String, individualDetails> name;
    @FXML
    private TableColumn<String, individualDetails> address;
    @FXML
    private TableColumn<String, individualDetails> date;
     @FXML
    private TableColumn<String, individualDetails> payment1;
    @FXML
    private JFXTextField payment;
    @FXML
    private JFXTextField name1;
    @FXML
    private JFXTextField address1;
    @FXML
    private DatePicker date1;
    @FXML
    private JFXButton delete;
    @FXML
    private JFXButton update;
    @FXML
    private JFXButton insert;
    @FXML
    private JFXButton reset;
    @FXML
    private JFXComboBox<String> customerName;

    private ObservableList<individualDetails> data;
    
    individualDetails ip;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        table_view.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override

            public void handle(MouseEvent t) {
                ip = table_view.getSelectionModel().getSelectedItem() != null ? table_view.getSelectionModel().getSelectedItem() : null;
                if (ip != null) {
                    setTextFields();
                }
            }
        });
        retrive();
        
        
        customerName.getItems().removeAll(customerName.getItems());

        customer c = new customer();
        ResultSet r = c.searchTybe("individual");
        try {
            while(r.next()){
                System.out.println(r.getString("name"));
                customerName.getItems().add(r.getString("name"));
                System.out.println(r.getString("name"));
            }
        } catch (SQLException ex) {

            ex.printStackTrace();
        }
        
        
    }    

    @FXML
    private void delete(MouseEvent event) {
        
        ResultSet rss = null;
        
        int selectedItem = table_view.getSelectionModel().getSelectedIndex();
        int projectId = Integer.parseInt(data.get(selectedItem).IdProperty().getValue());
        
        projects p = new projects();
        p.delete(projectId);
        
        retrive();
        name1.setText("");
        address1.setText("");
        payment1.setText("");
        date1.setValue(null);
        customerName.setValue(null);
        payment.setText("");
        
                
        
    }

    @FXML
    private void update(MouseEvent event) {
        if (name1.getText().length() == 0 || address1.getText().length() == 0 || payment1.getText().length() == 0  ) {
            Notifications notificationBuildeer = Notifications.create().
                    title("warning").
                    text(" name , address , payment   is required ").
                    graphic(null).
                    hideAfter(Duration.seconds(4)).
                    position(Pos.TOP_RIGHT).
                    onAction(e -> {
                        System.out.println("warning Noti ");
                    });
            notificationBuildeer.showWarning();
        } else {
        
        ResultSet rss = null;
        
        int selectedItem = table_view.getSelectionModel().getSelectedIndex();
        int idprojects = Integer.parseInt(data.get(selectedItem).IdProperty().getValue());
        
        String name2 = name1.getText();
        for(int i=0;i<name2.length();i++){
            Character c = name2.charAt(i);
            if(!c.isLetter(c)){
                if(c.equals(' ')){
                    
                    continue;
                    
                }else{

                Notifications notificationBuildeer = Notifications.create().
                    title("warning").
                    text(" the name must be letters can't be contain Digits or Sign ").
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
        String address2 = address1.getText();
        LocalDate date3 = date1.getValue();
        
        String date2 ;
        if(date3==null){
            date2 = data.get(selectedItem).DateProperty().getValue();
        }else{
            date2 = date3.toString();
        }
        
        String com = customerName.getValue();

            int projectId = Integer.parseInt(data.get(selectedItem).IdProperty().getValue());
            if (com == null) {
                try {
                    connectDataBase c = new connectDataBase();
                    int customerId = 0;
                    ResultSet re = c.s.executeQuery("SELECT * FROM contracting.projects where idprojects = " + projectId);
                    while (re.next()) {
                        customerId = re.getInt("customerId");

                    }
                    ResultSet r = c.s.executeQuery("select * from contracting.customer where idcustomer = " + customerId);
                    while (r.next()) {
                        com = r.getString("name");
                    }

                } catch (Exception ex) {

                    ex.printStackTrace();
                }
            }
       int payment2;
        
        for(int i=0;i<payment.getText().length();i++){
            Character c = payment.getText().charAt(i);
            if(c.isLetter(c)){
                

                Notifications notificationBuildeer = Notifications.create().
                    title("warning").
                    text(" The payment shoud be integer number can,t contain any letter or digit ").
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
        payment2=Integer.parseInt(payment.getText());
        
        projects p = new projects();
        p.update(name2, date2, address2, payment2, com, "individual",idprojects);
        
        retrive();
        name1.setText("");
        address1.setText("");
        payment1.setText("");
        date1.setValue(null);
        customerName.setValue(null);
        payment.setText("");
        
        
        
    }
    }

    @FXML
    private void insert(MouseEvent event) {
        
        if (name1.getText().length() == 0 || address1.getText().length() == 0 || payment.getText().length() == 0 || date1.getValue() == null||customerName.getValue()==null ) {
            Notifications notificationBuildeer = Notifications.create().
                    title("warning").
                    text(" name , address , payment , date , customerName is required ").
                    graphic(null).
                    hideAfter(Duration.seconds(4)).
                    position(Pos.TOP_RIGHT).
                    onAction(e -> {
                        System.out.println("warning Noti ");
                    });
            notificationBuildeer.showWarning();
        } else {
        
        String name2 = name1.getText();
        for(int i=0;i<name2.length();i++){
            Character c = name2.charAt(i);
            if(!c.isLetter(c)){
                if(c.equals(' ')){
                    
                    continue;
                    
                }else{

                Notifications notificationBuildeer = Notifications.create().
                    title("warning").
                    text(" the name must be letters can't be contain Digits or Sign ").
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
        String address2 = address1.getText();
        LocalDate date3 = date1.getValue();
        String date2 = date3.toString();
        String company = customerName.getValue();
        int payment2;
        System.out.println(date.getText());
        
        for(int i=0;i<payment.getText().length();i++){
            Character c = payment.getText().charAt(i);
            if(c.isLetter(c)){
                Notifications notificationBuildeer = Notifications.create().
                    title("warning").
                    text(" The payment shoud be integer number can,t contain any letter or digit ").
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
        payment2=Integer.parseInt(payment.getText());
        
        
        projects p = new projects();
        p.insert(name2, date2, address2, payment2, company, "individual");
        
        
        retrive();
        name1.setText("");
        address1.setText("");
        payment1.setText("");
        date1.setValue(null);
        customerName.setValue(null);
        payment.setText("");
        
    }
    }
    public void retrive(){
        data = FXCollections.observableArrayList();
        try {
            projects p = new projects();
            ResultSet re = p.search("individual");
            while(re.next()){
                
                data.add(new individualDetails(re.getString("idprojects"),re.getString("name") , re.getString("address"), re.getString("timeLine"), re.getString("payment")));
                
            }
            id.setCellValueFactory(new PropertyValueFactory<>("id"));
            name.setCellValueFactory(new PropertyValueFactory<>("name"));
            address.setCellValueFactory(new PropertyValueFactory<>("address"));
            date.setCellValueFactory(new PropertyValueFactory<>("date"));
            payment1.setCellValueFactory(new PropertyValueFactory<>("payment"));
            
            table_view.setItems(null);
            table_view.setItems(data);
            
            // TODO
        } catch (SQLException ex) {

            ex.printStackTrace();
        }
    }
    public void setTextFields(){
        this.name1.setText(ip != null ? ip.NameProperty().getValue() : "");
        
        this.address1.setText(ip != null ? ip.AddressProperty().getValue() : "");
        this.payment.setText(ip != null ? ip.PaymentProperty().getValue() : "");
        
        
    }
    @FXML
    public void reset(MouseEvent event) {
        name1.setText("");
        address1.setText("");
        payment1.setText("");
        date1.setValue(null);
        customerName.setValue(null);
        payment.setText("");
        

    }

}
