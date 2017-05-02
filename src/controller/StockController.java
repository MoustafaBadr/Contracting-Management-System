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
import implementation.store;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
import javafx.util.Duration;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author mustafa
 */
public class StockController implements Initializable {

    @FXML
    private JFXTextField ID_txt;
    @FXML
    private JFXTextField PName_txt;
    @FXML
    private JFXTextField Amount;
    @FXML
    private JFXTextField Price_txt;
    @FXML
    private JFXComboBox<?> supplier_combo;
    @FXML
    private JFXButton Add;
    @FXML
    private JFXButton Update;
    @FXML
    private TableView<Stockvo> table;
    @FXML
    private TableColumn<Stockvo, Integer> ID_table;
    @FXML
    private TableColumn<Stockvo, String> PName_table;
    @FXML
    private TableColumn<Stockvo, Integer> Amount_table;
    @FXML
    private TableColumn<Stockvo, Integer> Supplier_table;
    @FXML
    private TableColumn<Stockvo, Integer> price_table;
    @FXML
    private JFXTextField ID_Search;
    @FXML
    private JFXButton Delet;
    
    public ObservableList option = FXCollections.observableArrayList();
    public ObservableList<Stockvo> data = FXCollections.observableArrayList();
    @FXML
    private JFXButton Search_bt;
    Stockvo su;
    
     void clear(){
        ID_Search.setText("");
        ID_txt.setText("");
        PName_txt.setText("");
        Amount.setText("");
        Price_txt.setText("");
     
    }
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            connectDataBase c =new connectDataBase() ;
            String sql1 = "select idsupplier from supplier ";
            ResultSet rs2 = null;
            PreparedStatement ps = c.conection.prepareCall(sql1);
            rs2 = ps.executeQuery();

            while (rs2.next()) {

                option.add(rs2.getString("idsupplier"));

            }
        } catch (Exception ex) {

        }
        supplier_combo.getItems().addAll(option);
          table.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override

            public void handle(MouseEvent t) {
                su = table.getSelectionModel().getSelectedItem() != null ? table.getSelectionModel().getSelectedItem() : null;
                if (su!= null) {
                    setTextField();
                }
            }
        });
          table_insert();
       
    }     
        public void setTextField() {
            try{
        Integer x=su.supplierIdProperty().getValue();
        this.ID_txt.setText( (su != null ?String.valueOf(su.idstoreProperty().getValue()): ""));
        this.PName_txt.setText(su != null ? su.prodectNameProperty().getValue() : "");
        this.Price_txt.setText( (su != null ? String.valueOf(su.PriceProperty().getValue()) : ""));
        this.Amount.setText( (su != null ? String.valueOf( su.amountProperty().getValue()) : ""));
       
        
    }catch(Exception ex){
    JOptionPane.showMessageDialog(null, ex.getMessage());
    }
    }

    @FXML
    private void ADD(MouseEvent event) {
         boolean x = supplier_combo.getSelectionModel().isEmpty();
        
         boolean empty = isEmpty(ID_txt.getText(),Amount.getText(),Price_txt.getText(),PName_txt.getText());
               if(empty){
               
                 Notifications notificationBuildeer = Notifications.create().
                    title("warning").
                    text("Your Must Enter The Value").
                    graphic(null).
                    hideAfter(Duration.seconds(4)).
                    position(Pos.TOP_RIGHT).
                    onAction(e -> {
                        System.out.println("warning Noti ");
                    });
            notificationBuildeer.showWarning();
                clear();
            return;
        }
        else if (x) {
             Notifications notificationBuildeer = Notifications.create().
                    title("warning").
                    text("Your Must Choice The Value").
                    graphic(null).
                    hideAfter(Duration.seconds(4)).
                    position(Pos.TOP_RIGHT).
                    onAction(e -> {
                        System.out.println("warning Noti ");
                    });
            notificationBuildeer.showWarning();
            return;
        }
        
        Pattern p = Pattern.compile("[a-zA-Z]");
        Pattern p2 = Pattern.compile("[0-9]");
        Matcher PName_txtValidation = p2.matcher(PName_txt.getText());
        Matcher ID_txtVaild = p.matcher(ID_txt.getText());
        Matcher AmountVaild = p.matcher(Amount.getText());
        Matcher Price_txtVaild = p.matcher(Price_txt.getText());
        boolean c=PName_txtValidation.find();
        boolean c2=ID_txtVaild.find();
        boolean c3=AmountVaild.find();
        boolean c4=Price_txtVaild.find();
        if(c){
              Notifications notificationBuildeer = Notifications.create().
                    title("warning").
                    text("Your Must Enter The Number Value").
                    graphic(null).
                    hideAfter(Duration.seconds(4)).
                    position(Pos.TOP_RIGHT).
                    onAction(e -> {
                        System.out.println("warning Noti ");
                    });
            notificationBuildeer.showWarning();
             PName_txt.setText("");
             return;
        
        }else if(c2||c3||c4){
        ID_txt.setText("");
        Amount.setText("");
        Price_txt.setText("");
        Notifications notificationBuildeer = Notifications.create().
                    title("warning").
                    text("Your Must String The Value").
                    graphic(null).
                    hideAfter(Duration.seconds(4)).
                    position(Pos.TOP_RIGHT).
                    onAction(e -> {
                        System.out.println("warning Noti ");
                    });
            notificationBuildeer.showWarning();
        return;
        
        }
        
        int id =Integer.parseInt(ID_txt.getText());
        String combo=supplier_combo.getValue().toString();
        int Supplier =Integer.parseInt(combo);
        int amount =Integer.parseInt(Amount.getText());
        int price =Integer.parseInt(Price_txt.getText());
        String ProudcutName=PName_txt.getText();
           
            
           
       
            
            new store().insert(id,ProudcutName, amount, Supplier, price);
            clear();
            table_insert();
        
    }

    @FXML
    private void UPDATE(MouseEvent event) {
        boolean x = supplier_combo.getSelectionModel().isEmpty();
        
         boolean empty = isEmpty(ID_txt.getText(),Amount.getText(),Price_txt.getText(),PName_txt.getText());
               if(empty){
               
                 Notifications notificationBuildeer = Notifications.create().
                    title("warning").
                    text("Your Must Enter The Value").
                    graphic(null).
                    hideAfter(Duration.seconds(4)).
                    position(Pos.TOP_RIGHT).
                    onAction(e -> {
                        System.out.println("warning Noti ");
                    });
            notificationBuildeer.showWarning();
            return;
        }
        else if (x) {
            Notifications notificationBuildeer = Notifications.create().
                    title("warning").
                    text("Your Must Choice The Value").
                    graphic(null).
                    hideAfter(Duration.seconds(4)).
                    position(Pos.TOP_RIGHT).
                    onAction(e -> {
                        System.out.println("warning Noti ");
                    });
            notificationBuildeer.showWarning();
            return;
        }
        Pattern p = Pattern.compile("[a-zA-Z]");
        Pattern p2 = Pattern.compile("[0-9]");
        Matcher PName_txtValidation = p2.matcher(PName_txt.getText());
        Matcher ID_txtVaild = p.matcher(ID_txt.getText());
        Matcher AmountVaild = p.matcher(Amount.getText());
        Matcher Price_txtVaild = p.matcher(Price_txt.getText());
        boolean c=PName_txtValidation.find();
        boolean c2=ID_txtVaild.find();
        boolean c3=AmountVaild.find();
        boolean c4=Price_txtVaild.find();
        if(c){
              Notifications notificationBuildeer = Notifications.create().
                    title("warning").
                    text("Your Must Enter The numeric Value").
                    graphic(null).
                    hideAfter(Duration.seconds(4)).
                    position(Pos.TOP_RIGHT).
                    onAction(e -> {
                        System.out.println("warning Noti ");
                    });
            notificationBuildeer.showWarning();
             PName_txt.setText("");
             return;
        
        }else if(c2||c3||c4){
        ID_txt.setText("");
        Amount.setText("");
        Price_txt.setText("");
         Notifications notificationBuildeer = Notifications.create().
                    title("warning").
                    text("Your Must Enter The String Value").
                    graphic(null).
                    hideAfter(Duration.seconds(4)).
                    position(Pos.TOP_RIGHT).
                    onAction(e -> {
                        System.out.println("warning Noti ");
                    });
            notificationBuildeer.showWarning();
        return;
        
        }
       
            int id =Integer.parseInt(ID_txt.getText());
            String combo=supplier_combo.getValue().toString();
            int Supplier =Integer.parseInt(combo);
            int amount =Integer.parseInt(Amount.getText());
            int price =Integer.parseInt(Price_txt.getText());
            String ProudcutName=PName_txt.getText();

            new store().Update(id,ProudcutName, amount, Supplier, price);
            clear();
            table_insert();
    }

    @FXML
    private void DELETE(MouseEvent event) {
       
        
         boolean empty = isEmpty(ID_Search.getText());
               if(empty){
               
                Notifications notificationBuildeer = Notifications.create().
                    title("warning").
                    text("Your Must Enter The Value").
                    graphic(null).
                    hideAfter(Duration.seconds(4)).
                    position(Pos.TOP_RIGHT).
                    onAction(e -> {
                        System.out.println("warning Noti ");
                    });
            notificationBuildeer.showWarning();
            return;
        }
        Pattern p2 = Pattern.compile("[a-zA-Z]");
        Matcher courseaValidation = p2.matcher(ID_Search.getText());
        boolean c = courseaValidation.find();
       if (c ) {
            Notifications notificationBuildeer = Notifications.create().
                    title("warning").
                    text("Your Must Enter The numeric Value").
                    graphic(null).
                    hideAfter(Duration.seconds(4)).
                    position(Pos.TOP_RIGHT).
                    onAction(e -> {
                        System.out.println("warning Noti ");
                    });
            notificationBuildeer.showWarning();
            ID_Search.setText("");
            return;
       }
            int id_search =Integer.parseInt(ID_Search.getText());
            new store().delete(id_search);
            clear();
            table_insert();
    }
    
    @FXML
    private void search(MouseEvent event) throws SQLException {
        
         boolean empty = isEmpty(ID_Search.getText());
               if(empty){
               
                 Notifications notificationBuildeer = Notifications.create().
                    title("warning").
                    text("Your Must Enter The Value").
                    graphic(null).
                    hideAfter(Duration.seconds(4)).
                    position(Pos.TOP_RIGHT).
                    onAction(e -> {
                        System.out.println("warning Noti ");
                    });
            notificationBuildeer.showWarning();
            return;
        }
                 Pattern p2 = Pattern.compile("[a-zA-Z]");
        Matcher courseaValidation = p2.matcher(ID_Search.getText());
        boolean c = courseaValidation.find();
       if (c ) {
             Notifications notificationBuildeer = Notifications.create().
                    title("warning").
                    text("Your Must Enter The numeric Value").
                    graphic(null).
                    hideAfter(Duration.seconds(4)).
                    position(Pos.TOP_RIGHT).
                    onAction(e -> {
                        System.out.println("warning Noti ");
                    });
            notificationBuildeer.showWarning();
            ID_Search.setText("");
            return;
       }
          int id_search =Integer.parseInt(ID_Search.getText());
          table.getItems().clear();
         ResultSet makeReport = new store().makeReport(id_search);
         while (makeReport.next()) {
     
             data.add(new Stockvo( makeReport.getInt(1),makeReport.getString(2), makeReport.getInt(3), makeReport.getInt(4) ,makeReport.getInt(5)));
                

            }
            PName_table.setCellValueFactory(new PropertyValueFactory<>("prodectName"));
            ID_table.setCellValueFactory(new PropertyValueFactory<>("idstore"));
            Amount_table.setCellValueFactory(new PropertyValueFactory<>("amount"));
            Supplier_table.setCellValueFactory(new PropertyValueFactory<>("supplierId"));
            price_table.setCellValueFactory(new PropertyValueFactory<>("Price"));
            table.setItems(null);
            table.setItems(data);
            
            clear();
            
        
    }
    
    void table_insert() {

        table.getItems().clear();
       
        
        ResultSet rs = null;
        ResultSet rs2 = null;

        try {
           connectDataBase c =new connectDataBase() ;
            String sql = "SELECT * FROM store";
            PreparedStatement ps = c.conection.prepareCall(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                try{
                data.add(new Stockvo( rs.getInt(1),rs.getString(2), rs.getInt(3), rs.getInt(4) ,rs.getInt(5)));
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "ERROR");
                
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error1");
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"error");

        }

        PName_table.setCellValueFactory(new PropertyValueFactory<>("prodectName"));
        ID_table.setCellValueFactory(new PropertyValueFactory<>("idstore"));
        Amount_table.setCellValueFactory(new PropertyValueFactory<>("amount"));
        Supplier_table.setCellValueFactory(new PropertyValueFactory<>("supplierId"));
        price_table.setCellValueFactory(new PropertyValueFactory<>("Price"));
        table.setItems(null);
        table.setItems(data);
    }

      public boolean isEmpty(String ... text){
     for(String s:text){
         if(s.isEmpty())
         {
             return true;
         }
     }
     return false;
    }
    
}
