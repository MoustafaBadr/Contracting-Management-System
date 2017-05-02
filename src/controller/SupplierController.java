/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import database.connectDataBase;
import implementation.supplier;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author mustafa
 */
public class SupplierController implements Initializable {

    @FXML
    private JFXTextField name;
    private JFXTextField payment;
    @FXML
    private JFXTextField address;
    @FXML
    private DatePicker date;
    @FXML
    private JFXTextField email;
    @FXML
    private JFXTextField phone;
    @FXML
    private JFXButton delete_bt;
    @FXML
    private TableView<SupplierVo> table;
    @FXML
    private TableColumn<SupplierVo, String> Cname;
    @FXML
    private TableColumn<SupplierVo, Integer> Cpayment;
    @FXML
    private TableColumn<SupplierVo, String> Caddress;
    @FXML
    private TableColumn<SupplierVo, String> Cdate;
    @FXML
    private TableColumn<SupplierVo, String> Cemail;
    @FXML
    private TableColumn<SupplierVo, String> Cphone;
    @FXML
    private JFXButton update_bt;
    @FXML
    private JFXButton add_bt;
    @FXML
    private JFXTextField id_search;
    @FXML
    private JFXButton Search_bt;
    @FXML
    private TableColumn<SupplierVo, Integer> ID_table;
    
    
    ObservableList<SupplierVo>   data = FXCollections.observableArrayList();
    SupplierVo su;
    /**
     * Initializes the controller class.
     */
       @Override
    public void initialize(URL url, ResourceBundle rb) {
         table_insert();
        table.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override

            public void handle(MouseEvent t) {
                su = table.getSelectionModel().getSelectedItem() != null ? table.getSelectionModel().getSelectedItem() : null;
                if (su != null) {
                    setTextField();
                }
            }
        });
       
        // TODO
    }

    @FXML
    private void Delete(MouseEvent event) {
        if(id_search.getText().length()==0){
            Notifications notificationBuildeer = Notifications.create().
                    title("warning").
                    text(" name , phone and date is required ").
                    graphic(null).
                    hideAfter(Duration.seconds(4)).
                    position(Pos.TOP_RIGHT).
                    onAction(e -> {
                        System.out.println("warning Noti ");
                    });
            notificationBuildeer.showWarning();
        }else{
            String s = id_search.getText();
       
            for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (!c.isDigit(c)) {
                Notifications notificationBuildeer = Notifications.create().
                        title("warning").
                        text(" your id must be integer number ").
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
       
        supplier su = new supplier();
        su.delete(Integer.parseInt(s));
       

        table_insert();
        clear();
        }
    }

    @FXML
    private void Update(MouseEvent event) {
        if(name.getText().length()==0||phone.getText().length()==0){
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
        
        
         String name2 = name.getText();
        for(int i=0;i<name2.length();i++){
            Character c = name2.charAt(i);
            if(!c.isLetter(c)){

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
            }
        }
        String phone2 = phone.getText();
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
        String email2 = email.getText();
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
        String address2 = address.getText();
        
         ResultSet rss = null;
        
        int selectedItem = table.getSelectionModel().getSelectedIndex();
        int supplierId = Integer.parseInt(data.get(selectedItem).getIdSupplierProperty().getValue());
        
        String date1="";
        if(date.getValue()==null){
            try {
                 connectDataBase c = new connectDataBase();
                 ResultSet re = c.s.executeQuery("select * from contracting.supplier where idsupplier = "+supplierId);
                 while(re.next()){
                     date1 = re.getString("timeLine");
                 }
             } catch (Exception ex) {

                 ex.printStackTrace();
             }
        }else{
            date1=date.getValue().toString();
        }

           
            supplier s = new supplier();
            s.update(supplierId, name.getText(), date1.toString(), address.getText(), email.getText(), phone.getText());

            table_insert();
            clear();
        }
    }

    @FXML
    private void ADD(MouseEvent event) {
        if (name.getText().length() == 0 || phone.getText().length() == 0 || date.getValue() == null) {
            Notifications notificationBuildeer = Notifications.create().
                    title("warning").
                    text(" name , phone and date is required ").
                    graphic(null).
                    hideAfter(Duration.seconds(4)).
                    position(Pos.TOP_RIGHT).
                    onAction(e -> {
                        System.out.println("warning Noti ");
                    });
            notificationBuildeer.showWarning();

        } else {
            String name2 = name.getText();
            for (int i = 0; i < name2.length(); i++) {
                Character c = name2.charAt(i);
                if (!c.isLetter(c)) {

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
                }
            }
            String phone2 = phone.getText();
            for (int i = 0; i < phone2.length(); i++) {
                Character c = phone2.charAt(i);
                if (!c.isDigit(c)) {

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
            String email2 = email.getText();
            if (email2.length() != 0) {
                for (int i = 0; i < email2.length(); i++) {
                    Character c = email2.charAt(i);
                    if (c.equals('@')) {
                        break;
                    } else {
                        if (i == email2.length() - 1) {

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

            try {
                String addressTxt = address.getText();
                String emailTxt = email.getText();
                String nameTxt = name.getText();

                String phoneTxt = phone.getText();
                String Date = date.getValue().toString();

                try {
                    new supplier().insert(nameTxt, 0, Date, addressTxt, emailTxt, phoneTxt);
                     
                    table_insert();
                    clear();
                } catch (Exception ex) {

                    ex.printStackTrace();
                    
                }table_insert();
                clear();
            } catch (Exception ex) {

                ex.printStackTrace();
            }
        }
    }

    @FXML
    private void Search(MouseEvent event) {
        String s = id_search.getText();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (!c.isDigit(c)) {
                Notifications notificationBuildeer = Notifications.create().
                        title("warning").
                        text(" your id must be integer number ").
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
        data = FXCollections.observableArrayList();
        int id = Integer.parseInt(s);
        supplier su = new supplier();
        ResultSet rs = su.search(id);
        try {
            while (rs.next()) {
                data.add(new SupplierVo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));

            }
        } catch (SQLException ex) {

            ex.printStackTrace();
        }
        Caddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        ID_table.setCellValueFactory(new PropertyValueFactory<>("idSupplier"));
        Cemail.setCellValueFactory(new PropertyValueFactory<>("email"));
        Cname.setCellValueFactory(new PropertyValueFactory<>("name"));
        Cpayment.setCellValueFactory(new PropertyValueFactory<>("payment"));
        Cphone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        Cdate.setCellValueFactory(new PropertyValueFactory<>("timeline"));

        table.setItems(null);
        table.setItems(data);

    }

    public void clear() {
        id_search.setText("");
        name.setText("");
        email.setText("");
        phone.setText("");
       address.setText("");
        date.setValue(null);

    }

    public void table_insert() {

        ResultSet rs = null;
        data = FXCollections.observableArrayList();

        try {
            connectDataBase c = new connectDataBase();
            String sql = "SELECT * FROM supplier";
            rs = c.s.executeQuery(sql);

            while (rs.next()) {
                try {

                    data.add(new SupplierVo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage() + "in");

                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error1");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "error");

        }

        Caddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        ID_table.setCellValueFactory(new PropertyValueFactory<>("idSupplier"));
        Cemail.setCellValueFactory(new PropertyValueFactory<>("email"));
        Cname.setCellValueFactory(new PropertyValueFactory<>("name"));
        Cpayment.setCellValueFactory(new PropertyValueFactory<>("payment"));
        Cphone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        Cdate.setCellValueFactory(new PropertyValueFactory<>("timeline"));

        table.setItems(null);
        table.setItems(data);
    }

    public void setTextField() {
        this.name.setText(su != null ? su.getNameProperty().getValue() : "");
        this.email.setText(su != null ? su.getEmailProperty().getValue() : "");
        this.address.setText(su != null ? su.getAddressProperty().getValue() : "");
        this.id_search.setText(su != null ? su.getIdSupplierProperty().getValue() : "");
        this.phone.setText(su != null ? su.getPhoneProperty().getValue() : "");
    }
}
