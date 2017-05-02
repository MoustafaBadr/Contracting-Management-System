
package controller;

import implementation.admin;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author mustafa
 */
public class ApplicationController implements Initializable {

    @FXML
    private AnchorPane acMain;
    @FXML
    private AnchorPane acDashBord;
    @FXML
    private ScrollPane leftSideBarScroolPan;
    @FXML
    private Button btnHome;
    @FXML
    private ImageView imgHomeBtn;
    @FXML
    private Button btnStore;
    @FXML
    private ImageView imgStoreBtn;
    @FXML
    private Button btnEmplopye;
    @FXML
    private ImageView imgEmployeBtn;
    @FXML
    private Button btnSell;
    @FXML
    private ImageView imgSellBtn;
    @FXML
    private Button btnSettings;
    @FXML
    private ImageView imgSettingsBtn;
    @FXML
    private Button btnAbout;
    @FXML
    private ImageView imgAboutBtn;
    @FXML
    private BorderPane appContent;
    @FXML
    private AnchorPane acHead;
    @FXML
    private MenuButton mbtnUsrInfoBox;
    @FXML
    private MenuItem miPopOver;
    @FXML
    private Circle circleImgUsr;
    @FXML
    private Label lblUsrNamePopOver;
    @FXML
    private Label lblFullName;
    @FXML
    private Button btnLogOut;
    @FXML
    private Circle imgUsrTop;
    @FXML
    private Label lblUsrName;
    @FXML
    private StackPane acContent;
    @FXML
    private AnchorPane anchor_pane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblUsrName.setText(admin.getUserName());
        lblUsrNamePopOver.setText(admin.getUserName());
        lblFullName.setText(admin.getName());
        FXMLLoader fxmlLoader = new FXMLLoader();
        try {
            fxmlLoader.load(getClass().getResource("/view/mian.fxml").openStream());
        } catch (IOException e) {
            
        }
        Pane root = fxmlLoader.getRoot();
        anchor_pane.getChildren().clear();
        anchor_pane.getChildren().add(root);
    }    

    @FXML
    private void btnHomeOnClick(MouseEvent event) {
       FXMLLoader fxmlLoader = new FXMLLoader();
        try {
            fxmlLoader.load(getClass().getResource("/view/mian.fxml").openStream());
        } catch (IOException e) {
            
        }
        Pane root = fxmlLoader.getRoot();
        anchor_pane.getChildren().clear();
        anchor_pane.getChildren().add(root);
    }

    @FXML
    private void btnStoreOnClick(MouseEvent event) {
         FXMLLoader fxmlLoader = new FXMLLoader();
        try {
            fxmlLoader.load(getClass().getResource("/view/stockmain.fxml").openStream());
        } catch (IOException e) {
            
        }
        AnchorPane root = fxmlLoader.getRoot();
        anchor_pane.getChildren().clear();
        anchor_pane.getChildren().add(root);
    }

    @FXML
    private void btnEmplopyeOnClick(MouseEvent event) {
            FXMLLoader fxmlLoader = new FXMLLoader();
        try {
            fxmlLoader.load(getClass().getResource("/view/MainEmployee.fxml").openStream());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "hghhghg");
        }
        AnchorPane root = fxmlLoader.getRoot();
        anchor_pane.getChildren().clear();
        anchor_pane.getChildren().add(root);
    }


    @FXML
    private void btnSellOnClick(MouseEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        try {
            fxmlLoader.load(getClass().getResource("/view/sales.fxml").openStream());
        } catch (IOException e) {
            
        }
        Pane root = fxmlLoader.getRoot();
        anchor_pane.getChildren().clear();
        anchor_pane.getChildren().add(root);
    }


    @FXML
    private void btnSettingsOnClick(MouseEvent event) {
        
        FXMLLoader fxmlLoader = new FXMLLoader();
        try {
            fxmlLoader.load(getClass().getResource("/view/setting.fxml").openStream());
        } catch (IOException e) {
            
        }
        Pane root = fxmlLoader.getRoot();
        anchor_pane.getChildren().clear();
        anchor_pane.getChildren().add(root);
        

        
    }

    @FXML
    private void btnAboutOnClick(MouseEvent event) {
         FXMLLoader fxmlLoader = new FXMLLoader();
        try {
            fxmlLoader.load(getClass().getResource("/view/AboutUs.fxml").openStream());
        } catch (IOException e) {
            
        }
        AnchorPane root = fxmlLoader.getRoot();
        anchor_pane.getChildren().clear();
        anchor_pane.getChildren().add(root);
    }


    @FXML
    private void btnLogOut(ActionEvent event) throws IOException {
        
         Stage stage1 = (Stage) anchor_pane.getScene().getWindow();
        stage1.close();
        Stage primaryStage =new Stage();
         Parent root=FXMLLoader.load(getClass().getResource("/view/Login.fxml"));
            Scene scene =new Scene(root);
            primaryStage.setScene(scene); 
            primaryStage.setTitle("Log in"); 
            primaryStage.setResizable(false);
            primaryStage.show();
            
        
    }

    @FXML
    private void mbtnOnClick(ActionEvent event) {
    }


    @FXML
    private void acMain(KeyEvent event) {
    }

    @FXML
    private void acMainOnMouseMove(MouseEvent event) {
    }

    

    
}
