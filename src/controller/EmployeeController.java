package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mostafa
 */
public class EmployeeController implements Initializable {
    
     @FXML
    private Pane pane;
   

    
    @FXML
    public void salary(ActionEvent event) throws IOException {
      
        
         FXMLLoader fxmlLoader = new FXMLLoader();
        try {
            fxmlLoader.load(getClass().getResource("/view/salaryFXML.fxml").openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Pane root = fxmlLoader.getRoot();
        pane.getChildren().clear();
        pane.getChildren().add(root);
       
    }
    
     @FXML
     public void worker(ActionEvent event) throws IOException {
    
           FXMLLoader fxmlLoader = new FXMLLoader();
        try {
            fxmlLoader.load(getClass().getResource("/view/workerfxml.fxml").openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Pane root = fxmlLoader.getRoot();
        pane.getChildren().clear();
        pane.getChildren().add(root);
  

    }
     
      @FXML
     public void mange(ActionEvent event) throws IOException {
      
          FXMLLoader fxmlLoader = new FXMLLoader();
        try {
            fxmlLoader.load(getClass().getResource("/view/FXMLDocument.fxml").openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Pane root = fxmlLoader.getRoot();
        pane.getChildren().clear();
        pane.getChildren().add(root);
    

    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        try {
            fxmlLoader.load(getClass().getResource("/view/FXMLDocument.fxml").openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Pane root = fxmlLoader.getRoot();
        pane.getChildren().clear();
        pane.getChildren().add(root);
       
  
    }    
    
}
