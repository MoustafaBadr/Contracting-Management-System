
package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class test extends Application{

    @Override                                           
    public void start(Stage primaryStage) throws Exception {
            Parent root=FXMLLoader.load(getClass().getResource("/view/Login.fxml"));
            Scene scene =new Scene(root);
            primaryStage.setScene(scene); 
            primaryStage.setTitle("Log in"); 
            primaryStage.setResizable(false);
            primaryStage.show();
         }
    public static void main(String[] args) {
        launch(args);
    }
    
}
