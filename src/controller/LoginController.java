/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import database.connectDataBase;
import implementation.admin;
import java.awt.JobAttributes;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author mustafa
 */
public class LoginController implements Initializable {

    @FXML
    private TextField username_txt;
    @FXML
    private PasswordField password_txt;
    @FXML
    private Button login_bt;
    @FXML
    private Hyperlink link;
    @FXML
    private Button cancel_bt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void login(MouseEvent event) throws SQLException {
        boolean isEmpty = isEmpty(username_txt.getText(), password_txt.getText());
        if (isEmpty) {

            Notifications notificationBuildeer = Notifications.create().
                    title("warning").
                    text("You Must Enter The Value").
                    graphic(null).
                    hideAfter(Duration.seconds(4)).
                    position(Pos.TOP_RIGHT).
                    onAction(e -> {
                        System.out.println("warning Noti ");
                    });
            notificationBuildeer.showWarning();
        } else {

            ResultSet rs = null;

            try {
                connectDataBase c =new connectDataBase() ;
                String sql = "SELECT * FROM `admin`where userName='"
                        + username_txt.getText()
                        + "'  AND password='"
                        + password_txt.getText() + "'  ";

                PreparedStatement ps = c.conection.prepareStatement(sql);
                rs = ps.executeQuery();

                if (rs.next()) {
                    admin.setPassword(rs.getString(2));
                    admin.setUserName(rs.getString(1));
                    
                   
                    Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    System.out.println("mmm");
        app_stage.hide(); //optional
        
       
                    Parent root = null;
                    try {
                        root = FXMLLoader.load(getClass().getResource("/view/Application.fxml"));
                    } catch (IOException ex) {

                    }
                    Scene Scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(Scene);
                    stage.setResizable(true);
                    stage.setMaximized(true);
                    stage.setTitle("Home");
                    stage.show();
                    Notifications notificationBuildeer = Notifications.create().
                            title("Welcome").
                            text("Welcom In our program").
                            graphic(null).
                            hideAfter(Duration.seconds(4)).
                            position(Pos.TOP_RIGHT).
                            onAction(e -> {
                                System.out.println("warning Noti ");
                            });
                    notificationBuildeer.showInformation();

                } else {

                    Notifications notificationBuildeer = Notifications.create().
                            title("warning").
                            text("Please ,Enter The Correct UserName And Password").
                            graphic(null).
                            hideAfter(Duration.seconds(4)).
                            position(Pos.TOP_RIGHT).
                            onAction(e -> {
                                System.out.println("warning Noti ");
                            });
                    notificationBuildeer.showWarning();
                    username_txt.setText("");
                    password_txt.setText("");

                }

            } catch (Exception ex) {
                ex.printStackTrace();
                
            }

        }
    }

  

    @FXML
    private void Link(MouseEvent event) {
        Stage stage1 = (Stage) login_bt.getScene().getWindow();
        stage1.close();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/view/Registration.fxml"));
        } catch (IOException ex) {

        }
        Scene Scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(Scene);
        stage.setMaximized(true);
        stage.setResizable(true);
        stage.setTitle("Registration");
        stage.show();

    }

    public boolean isEmpty(String... text) {
        for (String s : text) {
            if (s.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    @FXML
    private void Cancel(MouseEvent event) {
        System.exit(0);
    }

}
