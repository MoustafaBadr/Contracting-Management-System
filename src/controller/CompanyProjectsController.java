/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import implementation.company;
import database.connectDataBase;
import implementation.customer;
import implementation.projects;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
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

/**
 * FXML Controller class
 *
 * @author Mustafa
 */
public class CompanyProjectsController implements Initializable {

    @FXML
    private TableView<companyDetails> table_view;
    @FXML
    private TableColumn<String, companyDetails> id;
    @FXML
    private TableColumn<String, companyDetails> name;
    @FXML
    private TableColumn<String, companyDetails> address;
    @FXML
    private TableColumn<String, companyDetails> date;
    @FXML
    private TableColumn<String, companyDetails> paymentCoulmn;
    @FXML
    private DatePicker date1;
    @FXML
    private JFXTextField payment1;
    @FXML
    private JFXTextField name1;
    @FXML
    private JFXTextField address1;

    @FXML
    private JFXButton delete;
    @FXML
    private JFXButton update;
    @FXML
    private JFXButton insert;
    @FXML
    private JFXButton reset;
    @FXML
    private JFXComboBox<String> companyName;
    @FXML
    private JFXComboBox<String> discount1;

    @FXML
    private JFXTextField after;

    private ObservableList<companyDetails> data;
    companyDetails cd;

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

        discount1.getItems().removeAll(discount1.getItems());
        for (int i = 1; i < 30; i++) {
            discount1.getItems().add(i + "%");
        }
        companyName.getItems().removeAll(companyName.getItems());

        customer c = new customer();
        ResultSet r = c.searchTybe("company");
        try {
            while (r.next()) {
                companyName.getItems().add(r.getString("name"));
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
        companyName.setValue(null);
        discount1.setValue(null);
        after.setText("");


    }

    @FXML
    private void update(MouseEvent event) { 

        if (name1.getText().length() == 0 || address1.getText().length() == 0 || payment1.getText().length() == 0  ) {
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
            ResultSet rss = null;

            int selectedItem = table_view.getSelectionModel().getSelectedIndex();
            String name2 = name1.getText();
            for (int i = 0; i < name2.length(); i++) {
                Character c = name2.charAt(i);
                if (!c.isLetter(c)) {
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
            if (date3 == null) {
                date2 = data.get(selectedItem).DateProperty().getValue();
            }else{
                date2 = date3.toString();
            }
            int payment2;
            if (after.getText().length() == 0) {
                for (int i = 0; i < payment1.getText().length(); i++) {
                    Character c = payment1.getText().charAt(i);

                    if (c.isLetter(c)) {

                        Notifications notificationBuildeer = Notifications.create().
                                title("warning").
                                text(" The payment shoud be integer number can,t contain any Letter or Sign ").
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
                payment2 = Integer.parseInt(payment1.getText());
            } else {
                payment2 = Integer.parseInt(after.getText());

            }
            String com = companyName.getValue();

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

            projects p = new projects();
            p.update(name2, date2, address2, payment2, com, "company", projectId);

            retrive();
             name1.setText("");
        address1.setText("");
        payment1.setText("");
        date1.setValue(null);
        companyName.setValue(null);
        discount1.setValue(null);
        after.setText("");


        }
    }

    @FXML
    private void insert(MouseEvent event) {
        if (name1.getText().length() == 0 || address1.getText().length() == 0 || payment1.getText().length() == 0 || date1.getValue() == null || companyName.getValue() == null) {
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
            for (int i = 0; i < name2.length(); i++) {
                Character c = name2.charAt(i);
                if (!c.isLetter(c)) {
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

            String company = companyName.getValue();
            int payment2;
            System.out.println(date.getText());
            if (after.getText().length() == 0) {
                for (int i = 0; i < payment1.getText().length(); i++) {
                    Character c = payment1.getText().charAt(i);

                    if (c.isLetter(c)) {
                        Notifications notificationBuildeer = Notifications.create().
                                title("warning").
                                text(" the payment shoud be integer number ").
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
                payment2 = Integer.parseInt(payment1.getText());
            } else {
                payment2 = Integer.parseInt(after.getText());

            }
            projects p = new projects();
            p.insert(name2, date2, address2, payment2, company, "company");

            retrive();
             name1.setText("");
        address1.setText("");
        payment1.setText("");
        date1.setValue(null);
        companyName.setValue(null);
        discount1.setValue(null);
        after.setText("");

        }
    }

    @FXML
    private void computeDiscont(MouseEvent event) {

        if (discount1.getValue() == null || payment1.getText().length() == 0) {
            Notifications notificationBuildeer = Notifications.create().
                    title("warning").
                    text(" you must enter the payment and choose the percent of discount ").
                    graphic(null).
                    hideAfter(Duration.seconds(4)).
                    position(Pos.TOP_RIGHT).
                    onAction(e -> {
                        System.out.println("warning Noti ");
                    });
            notificationBuildeer.showWarning();
        } else {
            for (int i = 0; i < payment1.getText().length(); i++) {
                Character c = payment1.getText().charAt(i);

                if (c.isLetter(c)) {

                    Notifications notificationBuildeer = Notifications.create().
                            title("warning").
                            text(" the payment shoud be integer number ").
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

            String s = discount1.getValue();
            if (s.length() == 2) {
                String sub = s.substring(0, 1);
                int i = Integer.parseInt(sub);
                int p = Integer.parseInt(payment1.getText());
                company c = new company();
                int payafter = c.computeDiscount(i, p);
                after.setText(payafter + "");
            }
        }

    }

    public void retrive() {
        data = FXCollections.observableArrayList();
        try {
            projects p = new projects();
            ResultSet re = p.search("company");
            while (re.next()) {

                data.add(new companyDetails(re.getString("idprojects"), re.getString("name"), re.getString("address"), re.getString("timeLine"), re.getString("payment")));

            }
            id.setCellValueFactory(new PropertyValueFactory<>("id"));
            name.setCellValueFactory(new PropertyValueFactory<>("name"));
            address.setCellValueFactory(new PropertyValueFactory<>("address"));
            date.setCellValueFactory(new PropertyValueFactory<>("date"));
            paymentCoulmn.setCellValueFactory(new PropertyValueFactory<>("payment"));

            table_view.setItems(null);
            table_view.setItems(data);

            // TODO
        } catch (SQLException ex) {

            ex.printStackTrace();
        }

    }

    public void setTextField() {
        this.name1.setText(cd != null ? cd.NameProperty().getValue() : "");

        this.address1.setText(cd != null ? cd.AddressProperty().getValue() : "");
        this.payment1.setText(cd != null ? cd.PaymentProperty().getValue() : "");
        
    }

    @FXML
    public void reset(MouseEvent event) {
        name1.setText("");
        address1.setText("");
        payment1.setText("");
        date1.setValue(null);
        companyName.setValue(null);
        discount1.setValue(null);
        after.setText("");

    }

}
