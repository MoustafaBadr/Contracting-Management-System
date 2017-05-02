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
import implementation.customerPayment;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import tables.paymentDetails;

/**
 * FXML Controller class
 *
 * @author Mustafa
 */
public class CustomerPaymentController implements Initializable {

    @FXML
    private JFXComboBox<String> tybe;
    @FXML
    private JFXComboBox<String> names;
    @FXML
    private JFXTextField cash1;
    @FXML
    private JFXButton pay;
    @FXML
    private TableView<paymentDetails> table_view;
    @FXML
    private TableColumn<String, paymentDetails> customerName;
    @FXML
    private TableColumn<String, paymentDetails> Date1;
    @FXML
    private TableColumn<String, paymentDetails> userName;
    @FXML
    private TableColumn<String, paymentDetails> cash;
    @FXML
    private DatePicker date;
    @FXML
    private JFXButton search;

    private ObservableList<paymentDetails> data;
    private String[] companyNames;
    private String[] individualNames;
    private int[] companyIds;
    private int[] individualIds;
    int in = 0;
    int co = 0;
    String tybef;
    @FXML
    private JFXComboBox<String> user;
    @FXML
    private JFXButton total;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {

            retrive();
            connectDataBase c1 = new connectDataBase();
            ResultSet r = c1.s.executeQuery(" SELECT COUNT(*)FROM contracting.customer Where tybe ='individual'");
            while (r.next()) {
                in = r.getInt(1);
            }
            ResultSet r1 = c1.s.executeQuery(" SELECT COUNT(*)FROM contracting.customer Where tybe ='company'");
            while (r1.next()) {
                co = r1.getInt(1);
            }
            companyNames = new String[co];
            individualNames = new String[in];
            companyIds = new int[co];
            individualIds = new int[in];

            tybe.getItems().removeAll(tybe.getItems());
            tybe.getItems().addAll("individual", "company");
            tybe.setValue("individual");
            tybef = "individual";
            names.getItems().removeAll(names.getItems());

            user.getItems().removeAll(user.getItems());
            ResultSet r3 = c1.s.executeQuery("select * from contracting.admin");
            while (r3.next()) {
                user.getItems().add(r3.getString(1));
            }
//             ResultSet r4 = c1.s.executeQuery("select * from contracting.customer");
//            while(r3.next()){
//                user.getItems().add(r3.getString(2));
//            }

        } catch (SQLException ex) {

            ex.printStackTrace();
        }

    }

    @FXML
    private void pay(MouseEvent event) {
        if (tybe.getValue() != tybef) {

            Notifications notificationBuildeer = Notifications.create().
                    title("warning").
                    text("you have change the tybe you must choose the tybe then choose the name ").
                    graphic(null).
                    hideAfter(Duration.seconds(4)).
                    position(Pos.TOP_RIGHT).
                    onAction(e -> {
                        System.out.println("warning Noti ");
                    });
            notificationBuildeer.showWarning();

        } else {
            try {
                String comName = names.getValue();
                if (comName == null || cash1.getText().length() == 0) {

                    Notifications notificationBuildeer = Notifications.create().
                            title("warning").
                            text("you must choose the name and enter the amount of cash").
                            graphic(null).
                            hideAfter(Duration.seconds(4)).
                            position(Pos.TOP_RIGHT).
                            onAction(e -> {
                                System.out.println("warning Noti ");
                            });
                    notificationBuildeer.showWarning();

                } else {
                    System.out.println("pay is clicked");

                    if (tybef.equalsIgnoreCase("individual")) {
                        System.out.println("individual");
                        int id = 0;
                        for (int i = 0; i < in; i++) {
                            System.out.println("for");
                            if (comName.equalsIgnoreCase(individualNames[i])) {
                                System.out.println("if");
                                for (int k = i + 1; k < in; k++) {
                                    System.out.println("for");
                                    if (comName.equalsIgnoreCase(individualNames[k])) {
                                        String phone = JOptionPane.showInputDialog(" the name is dublicated you must enter the phone ");
                                        connectDataBase c = new connectDataBase();

                                        try {
                                            ResultSet re = c.s.executeQuery("select * from contracting.customer where name ='" + comName + "'and phone = '" + phone + "'");
                                            while (re.next()) {
                                                id = re.getInt(1);
                                                System.out.println("" + id);
                                            }
                                        } catch (SQLException ex) {

                                            ex.printStackTrace();
                                        }
                                    }
                                }
                                if (id == 0) {
                                    id = individualIds[i];
                                    System.out.println("" + id);
                                    for (int j = 0; j < cash1.getText().length(); j++) {
                                        Character m = cash1.getText().charAt(j);
                                        if (!m.isDigit(m)) {
                                            Notifications notificationBuildeer = Notifications.create().
                                                    title("warning").
                                                    text(" the cash must be integer number ").
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
                                    int cash3 = Integer.parseInt(cash1.getText());
                                    System.out.println("cash = " + cash1.getText());
                                    System.out.println("id=" + id);
                                    customerPayment cp = new customerPayment();
                                    cp.payment(cash3, id, comName);

                                } else {
                                    for (int j = 0; j < cash1.getText().length(); j++) {
                                        Character m = cash1.getText().charAt(j);
                                        if (!m.isDigit(m)) {
                                            Notifications notificationBuildeer = Notifications.create().
                                                    title("warning").
                                                    text(" the cash must be integer number ").
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

                                    int cash3 = Integer.parseInt(cash1.getText());
                                    System.out.println("cash =" + cash1.getText());
                                    customerPayment cp = new customerPayment();
                                    cp.payment(cash3, id, comName);
                                    System.out.println("paid");

                                }

                            }
                        }
                        }
                     else {
                        int id = 0;
                        for (int i = 0; i < co; i++) {
                            if (comName.equalsIgnoreCase(companyNames[i])) {
                                for (int k = i + 1; k < co; k++) {
                                    if (comName.equalsIgnoreCase(companyNames[k])) {
                                        String phone = JOptionPane.showInputDialog(" the name is dublicated you must enter the phone ");
                                        connectDataBase c = new connectDataBase();

                                        try {
                                            ResultSet re = c.s.executeQuery("select * from contracting.customer where name ='" + comName + "'and phone = '" + phone + "'");
                                            while (re.next()) {
                                                id = re.getInt(1);
                                            }
                                        } catch (SQLException ex) {

                                            ex.printStackTrace();
                                        }
                                    }
                                }
                                        if (id == 0) {
                                            id = companyIds[i];
                                            System.out.println("id");
                                            for (int j = 0; j < cash1.getText().length(); j++) {
                                                Character m = cash1.getText().charAt(j);
                                                if (!m.isDigit(m)) {
                                                    Notifications notificationBuildeer = Notifications.create().
                                                            title("warning").
                                                            text(" the cash must be integer number ").
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
                                            int cash3 = Integer.parseInt(cash1.getText());
                                            customerPayment cp = new customerPayment();
                                            cp.payment(cash3, id, comName);

                                        } else {
                                            for (int j = 0; j < cash1.getText().length(); j++) {
                                                Character m = cash1.getText().charAt(j);
                                                if (!m.isDigit(m)) {
                                                    Notifications notificationBuildeer = Notifications.create().
                                                            title("warning").
                                                            text(" the cash must be integer number ").
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

                                            int cash3 = Integer.parseInt(cash1.getText());
                                            customerPayment cp = new customerPayment();
                                            cp.payment(cash3, id, comName);

                                        }
                                    }
                                }

                           
                }
                retrive();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            } 
        }
        
        
    }

    @FXML
    private void compoBoxCustomer(MouseEvent event) {
        names.getItems().removeAll(names.getItems());

        if (tybe.getValue() == null) {
            Notifications notificationBuildeer = Notifications.create().
                    title("warning").
                    text("you must choose the tybe first").
                    graphic(null).
                    hideAfter(Duration.seconds(4)).
                    position(Pos.TOP_RIGHT).
                    onAction(e -> {
                        System.out.println("warning Noti ");
                    });
            notificationBuildeer.showWarning();
        } else {

            String tybe3 = tybe.getValue();
            System.out.println(tybe3);
            tybef = tybe3;

            if (tybe3.equalsIgnoreCase("individual")) {
                customer c = new customer();
                ResultSet re = c.searchTybe(tybe3);
                try { 
                    int i = 0;
                    while (re.next()) {
                        names.getItems().add(re.getString("name"));
                        individualIds[i] = re.getInt(1);
                        individualNames[i] = re.getString("name");
                        System.out.println(individualNames[i]);
                        i++;
                      
                    }
                    System.out.println("    "+i);
                } catch (Exception ex) {

                    ex.printStackTrace();
                }

            } else {
                customer c = new customer();
                ResultSet re = c.searchTybe(tybe.getValue());
                try {
                    int i = 0;
                    while (re.next()) {
                        names.getItems().add(re.getString("name"));
                        companyIds[i] = re.getInt(1);
                        companyNames[i] = re.getString("name");
                        i++;
                    }
                } catch (SQLException ex) {

                    ex.printStackTrace();
                }

            }
        }

    }
    

    @FXML
    private void search(MouseEvent event) {
        if (date.getValue() == null && user.getValue() == null) {
            Notifications notificationBuildeer = Notifications.create().
                    title("warning").
                    text("You Must CHOOSE The date Or choose the user Or BoTH").
                    graphic(null).
                    hideAfter(Duration.seconds(4)).
                    position(Pos.TOP_RIGHT).
                    onAction(e -> {
                        System.out.println("warning Noti ");
                    });
            notificationBuildeer.showWarning();
        } else {

            data = FXCollections.observableArrayList();
            LocalDate date3 = date.getValue();
            String user1 = user.getValue();
            System.out.println("  "+user1);
            customerPayment cp = new customerPayment();
            ResultSet re = cp.search(date3, user1);

            try {
                while (re.next()) {
                data.add(new paymentDetails(re.getString("customerName"), re.getString("userName"), re.getString("date"), re.getString("cash")));
                }
            } catch (SQLException ex) {

                ex.printStackTrace();
            }
            Date1.setCellValueFactory(new PropertyValueFactory<>("date"));
            customerName.setCellValueFactory(new PropertyValueFactory<>("name"));
            userName.setCellValueFactory(new PropertyValueFactory<>("userName"));
            cash.setCellValueFactory(new PropertyValueFactory<>("cash"));

            table_view.setItems(null);
            table_view.setItems(data);

        }
    }

    public void retrive() {
        data = FXCollections.observableArrayList();
        customerPayment c = new customerPayment();
        ResultSet re = c.search(null, null);
        try {
            while (re.next()) {
                data.add(new paymentDetails(re.getString("customerName"), re.getString("userName"), re.getString("date"), re.getString("cash")));
            }
        } catch (SQLException ex) {

            ex.printStackTrace();
        }
        Date1.setCellValueFactory(new PropertyValueFactory<>("date"));
        customerName.setCellValueFactory(new PropertyValueFactory<>("name"));
        userName.setCellValueFactory(new PropertyValueFactory<>("userName"));
        cash.setCellValueFactory(new PropertyValueFactory<>("cash"));
        table_view.setItems(null);
        table_view.setItems(data);
    }

    @FXML
    private void total(MouseEvent event) {
        
            LocalDate date3 = date.getValue();
            String user1 = user.getValue();
            customerPayment cp = new customerPayment();
            int total1 = cp.total(date3, user1);
            Notifications notificationBuildeer = Notifications.create().
                    title("Information").
                    text(" the total payment is " + total1 + "").
                    graphic(null).
                    hideAfter(Duration.seconds(10)).
                    position(Pos.TOP_RIGHT).
                    onAction(e -> {
                        System.out.println("information Noti ");
                    });
            notificationBuildeer.showInformation();

        

    }

}
