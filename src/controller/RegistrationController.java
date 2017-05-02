package controller;


import database.connectDataBase;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
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
public class RegistrationController implements Initializable {

    @FXML
    private Hyperlink hlLogin;
    @FXML
    private TextField tfUserName;
    @FXML
    private TextField tfFullName;
    @FXML
    private PasswordField pfUserPassword;
    @FXML
    private PasswordField pfReUserPassword;
    @FXML
    private Button btnSignUp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void hlLogin(ActionEvent event) {
         Stage stage1 = (Stage) btnSignUp.getScene().getWindow();
                   stage1.close();
                   Parent root = null;
                   try {
                       root = FXMLLoader.load(getClass().getResource("/view/Login.fxml"));
                   } catch (IOException ex) {
                       
                   }
                   Scene Scene =new Scene(root);
                   Stage stage =new Stage();
                   stage.setScene(Scene);
                   stage.setResizable(true);
                   stage.setTitle("Home");
                   stage.show();
    }

    @FXML
    private void pfKeyTyped(KeyEvent event) {
    }

    @FXML
    private void btnRegistration(MouseEvent event) throws SQLException {
        Pattern p2 = Pattern.compile("[0-9]");
        Matcher PName_txtValidation = p2.matcher(tfFullName.getText());
        boolean c=PName_txtValidation.find();
        if (isEmpty(tfUserName.getText(), tfFullName.getText(), pfUserPassword.getText(), pfReUserPassword.getText())) {
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

        } else if(c){
            Notifications notificationBuildeer = Notifications.create().
                    title("warning").
                    text("Enter The Correct Value").
                    graphic(null).
                    hideAfter(Duration.seconds(4)).
                    position(Pos.TOP_RIGHT).
                    onAction(e -> {
                        System.out.println("warning Noti ");
                    });
            notificationBuildeer.showWarning();
            tfFullName.setText("");
            pfUserPassword.setText("");
            pfReUserPassword.setText("");
            return;
        
        
        }else if (!pfUserPassword.getText().equals(pfReUserPassword.getText())) {
             Notifications notificationBuildeer = Notifications.create().
                    title("warning").
                    text("Your password not Match To RePassword").
                    graphic(null).
                    hideAfter(Duration.seconds(4)).
                    position(Pos.TOP_RIGHT).
                    onAction(e -> {
                        System.out.println("warning Noti ");
                    });
            notificationBuildeer.showWarning();
            pfUserPassword.setText("");
            pfReUserPassword.setText("");
            return;
        }
        try{
          connectDataBase cc =new connectDataBase() ;
            String sql1 = "INSERT INTO admin (userName, password, name) VALUES ('"+tfUserName.getText()+"','"+pfUserPassword.getText()+"','"+tfFullName.getText()+"') ";
             PreparedStatement ps = cc.conection.prepareCall(sql1);
            ps.execute();
             Notifications notificationBuildeer = Notifications.create().
                    title("Success").
                    text("Sign Up Correct").
                    graphic(null).
                    hideAfter(Duration.seconds(4)).
                    position(Pos.TOP_RIGHT).
                    onAction(e -> {
                        System.out.println("Sucess ");
                    });
             notificationBuildeer.showInformation();
            tfFullName.setText("");
            pfUserPassword.setText("");
            pfReUserPassword.setText("");
            tfUserName.setText("");
             
            }catch(Exception ex){
             Notifications notificationBuildeer = Notifications.create().
                    title("Success").
                    text(ex.getMessage()).
                    graphic(null).
                    hideAfter(Duration.seconds(4)).
                    position(Pos.TOP_RIGHT).
                    onAction(e -> {
                        System.out.println("Sucess ");
                    });
             notificationBuildeer.showInformation();
            tfFullName.setText("");
            pfUserPassword.setText("");
            pfReUserPassword.setText("");
            tfUserName.setText("");
            }
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
