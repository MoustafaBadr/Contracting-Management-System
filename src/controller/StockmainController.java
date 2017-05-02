/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author mustafa
 */
public class StockmainController implements Initializable {

    @FXML
    private JFXButton stock;
    @FXML
    private AnchorPane Anchor_pane;
    @FXML
    private JFXButton payment_bt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
             FXMLLoader fxmlLoader = new FXMLLoader();
        try {
            fxmlLoader.load(getClass().getResource("/view/Supplier.fxml").openStream());
        } catch (IOException e) {
            
        }
        AnchorPane root = fxmlLoader.getRoot();
        Anchor_pane.getChildren().clear();
        Anchor_pane.getChildren().add(root);
    }    

    @FXML
    private void Supplier_pane(MouseEvent event) {
        
                FXMLLoader fxmlLoader = new FXMLLoader();
        try {
            fxmlLoader.load(getClass().getResource("/view/Supplier.fxml").openStream());
        } catch (IOException e) {
            
        }
        AnchorPane root = fxmlLoader.getRoot();
        Anchor_pane.getChildren().clear();
        Anchor_pane.getChildren().add(root);
    }

    @FXML
    private void stock_pane(MouseEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        try {
            fxmlLoader.load(getClass().getResource("/view/Stock.fxml").openStream());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        AnchorPane root = fxmlLoader.getRoot();
        Anchor_pane.getChildren().clear();
        Anchor_pane.getChildren().add(root);
    }

    @FXML
    private void apyment(MouseEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        try {
            fxmlLoader.load(getClass().getResource("/view/supplierPayment.fxml").openStream());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        Pane root = fxmlLoader.getRoot();
        Anchor_pane.getChildren().clear();
        Anchor_pane.getChildren().add(root);
    }
    
}
