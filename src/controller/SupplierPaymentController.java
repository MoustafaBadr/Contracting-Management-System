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
import implementation.customerPayment;
import implementation.supplierPayment;
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
import tables.paymentDetails;

/**
 * FXML Controller class
 *
 * @author Mustafa
 */
public class SupplierPaymentController implements Initializable {

    @FXML
    private JFXButton search;
    @FXML
    private DatePicker date1;
    @FXML
    private TableView<paymentDetails> table_view;
    @FXML
    private TableColumn<String, paymentDetails> supplierName;
    @FXML
    private TableColumn<String, paymentDetails> Date;
    @FXML
    private TableColumn<String, paymentDetails> userName;
    @FXML
    private TableColumn<String, paymentDetails> cash;
    @FXML
    private JFXButton pay;
    @FXML
    private JFXTextField cash1;
    @FXML
    private JFXComboBox<String> names;

    private ObservableList<paymentDetails> data;
    private String[] Names;
    private int[] Ids;
    int count = 0;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            names.getItems().removeAll(names.getItems());

            retrive();
            connectDataBase c1 = new connectDataBase();
            ResultSet r = c1.s.executeQuery(" SELECT COUNT(*)FROM contracting.supplier ");
            while (r.next()) {
                count = r.getInt(1);
            }
            Names = new String[count];
            Ids = new int[count];
            ResultSet re = c1.s.executeQuery("SELECT * FROM contracting.supplier");
            int i = 0;
            while (re.next()) {
                Names[i] = re.getString(2);
                Ids[i] = re.getInt(1);
                names.getItems().add(re.getString(2));

            }

            // TODO
        } catch (SQLException ex) {

            ex.printStackTrace();
        }
    }

    @FXML
    private void search(MouseEvent event) {

        if (date1.getValue() == null) {
            Notifications notificationBuildeer = Notifications.create().
                    title("warning").
                    text("You Must CHOOSE The date").
                    graphic(null).
                    hideAfter(Duration.seconds(4)).
                    position(Pos.TOP_RIGHT).
                    onAction(e -> {
                        System.out.println("warning Noti ");
                    });
            notificationBuildeer.showWarning();
        } else {
        data = FXCollections.observableArrayList();

            LocalDate date3 = date1.getValue();
            supplierPayment cp = new supplierPayment();
            ResultSet re = cp.search(date3);

            try {
                while (re.next()) {
                    data.add(new paymentDetails(re.getString("supplierName"), re.getString("userName"), re.getString("date"), re.getString("cash")));
                }
            } catch (SQLException ex) {

                ex.printStackTrace();
            }
            Date.setCellValueFactory(new PropertyValueFactory<>("date"));
            supplierName.setCellValueFactory(new PropertyValueFactory<>("name"));
            userName.setCellValueFactory(new PropertyValueFactory<>("userName"));
            cash.setCellValueFactory(new PropertyValueFactory<>("cash"));

            table_view.setItems(null);
            table_view.setItems(data);

        }

    }

    @FXML
    private void pay(MouseEvent event) {

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

            int id = 0;
            for (int i = 0; i < count; i++) {
                System.out.println("for");
                if (comName.equalsIgnoreCase(Names[i])) {
                    System.out.println("if");
                    for (int k = i + 1; k < count; k++) {
                        System.out.println("for");
                        if (comName.equalsIgnoreCase(Names[k])) {
                            String phone = JOptionPane.showInputDialog(" the name is dublicated you must enter the phone ");
                            connectDataBase c = new connectDataBase();

                            try {
                                ResultSet re = c.s.executeQuery("select * from contracting.supplier where name ='" + comName + "'and phone = '" + phone + "'");
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
                        id = Ids[i];
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
                    }
                    int cash3 = Integer.parseInt(cash1.getText());
                    System.out.println("cash = " + cash1.getText());
                    System.out.println("id=" + id);
                    supplierPayment cp = new supplierPayment();
                    cp.payment(cash3, id, comName);
                }
            }

            retrive();
        }
    }

    public void retrive() {
        data = FXCollections.observableArrayList();
        supplierPayment c = new supplierPayment();
        ResultSet re = c.search(null);
        try {
            while (re.next()) {
                data.add(new paymentDetails(re.getString("supplierName"), re.getString("userName"), re.getString("date"), re.getString("cash")));

            }
        } catch (SQLException ex) {

            ex.printStackTrace();
        }
        Date.setCellValueFactory(new PropertyValueFactory<>("date"));
        supplierName.setCellValueFactory(new PropertyValueFactory<>("name"));
        userName.setCellValueFactory(new PropertyValueFactory<>("userName"));
        cash.setCellValueFactory(new PropertyValueFactory<>("cash"));
        table_view.setItems(null);
        table_view.setItems(data);
    }

}
