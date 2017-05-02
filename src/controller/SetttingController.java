/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import database.connectDataBase;
import implementation.admin;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author mustafa
 */
public class SetttingController implements Initializable {
connectDataBase c =new connectDataBase() ;
    Statement st = null;
    ResultSet rs = null;
    @FXML
    private PasswordField CurrentPass;
    @FXML
    private PasswordField NewPass;
    @FXML
    private PasswordField RePass;
    @FXML
    private ImageView imgCurrentPassMatch;
    @FXML
    private ImageView imgNewPassMatch;
    @FXML
    private Button btnChangePass;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void change(MouseEvent event) {
        try {
            
         String currentpassword=CurrentPass.getText();
         String newpassward=NewPass.getText();
         String retype=RePass.getText();
                     

        if (newpassward.equals(retype))
            {
            String userName = admin.getUserName();
            String pass = admin.getPassword();
            if(pass.equals(currentpassword)){

        c.s.executeUpdate("update admin set password = '"+newpassward+"'  where userName = '"+userName+"'");
        Notifications notificationBuildeer = Notifications.create().
                            title("Success").
                            text(" Password Change ").
                            graphic(null).
                            hideAfter(Duration.seconds(4)).
                            position(Pos.TOP_RIGHT).
                            onAction(e -> {
                                System.out.println("Sucess");
                            });
                    notificationBuildeer.show();
        
        
       CurrentPass.setText("");
        NewPass.setText("");
        RePass.setText("");
            
            }else{
        Notifications notificationBuildeer = Notifications.create().
                            title("warning").
                            text(" Re-enter the password ").
                            graphic(null).
                            hideAfter(Duration.seconds(4)).
                            position(Pos.TOP_RIGHT).
                            onAction(e -> {
                                System.out.println("warning Noti ");
                            });
                    notificationBuildeer.showWarning();
        
        
       CurrentPass.setText("");
        NewPass.setText("");
        RePass.setText("");
    }

}
else{
Notifications notificationBuildeer = Notifications.create().
                            title("warning").
                            text(" Re-enter the password ").
                            graphic(null).
                            hideAfter(Duration.seconds(4)).
                            position(Pos.TOP_RIGHT).
                            onAction(e -> {
                                System.out.println("warning Noti ");
                            });
                    notificationBuildeer.showWarning();    
}
                 
     } catch (SQLException ex) {
         }
    }
    
}
