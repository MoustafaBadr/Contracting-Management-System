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
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Mustafa
 */
public class ProjectsController implements Initializable {
    @FXML
    private JFXButton companyProjects;
    @FXML
    private JFXButton individual;
    @FXML
    private Pane pane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         FXMLLoader fxmlLoader = new FXMLLoader();
        try {
            fxmlLoader.load(getClass().getResource("/view/IndividualProjects.fxml").openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Pane root = fxmlLoader.getRoot();
        pane.getChildren().clear();
        pane.getChildren().add(root);
        
        individual.setStyle("-fx-background-color:  #3f547c;");
        companyProjects.setStyle("-fx-background-color:  yellow;");
        
        // TODO
    }    

    @FXML
    private void companyProject(MouseEvent event) {
         FXMLLoader fxmlLoader = new FXMLLoader();
        try {
            fxmlLoader.load(getClass().getResource("/view/companyProjects.fxml").openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Pane root = fxmlLoader.getRoot();
        pane.getChildren().clear();
        pane.getChildren().add(root);
        
        companyProjects.setStyle("-fx-background-color:  #3f547c;");
        individual.setStyle("-fx-background-color:  yellow;");
        
    }

    @FXML
    private void individualProjects(MouseEvent event) {
        
         FXMLLoader fxmlLoader = new FXMLLoader();
        try {
            fxmlLoader.load(getClass().getResource("/view/IndividualProjects.fxml").openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Pane root = fxmlLoader.getRoot();
        pane.getChildren().clear();
        pane.getChildren().add(root);
        
        individual.setStyle("-fx-background-color:  #3f547c;");
        companyProjects.setStyle("-fx-background-color:  yellow;");
    }
    
}
