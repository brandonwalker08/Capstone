/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dwandsonsapplication;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * Application Developed By Brandon Walker in the Spring '18 Semester
 * 
 * 
 * @author Brandon Walker
 */
public class DWandSonsApplication extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("DWandSons.fxml"));
        
        Scene scene = new Scene(root);
        stage.setTitle("Doug Walker & Sons Portal");
        
        Image icon = new Image(getClass().getResourceAsStream("dw.png"));
        stage.getIcons().add(icon);        
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
