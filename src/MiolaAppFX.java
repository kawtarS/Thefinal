/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author hp
 */
public class MiolaAppFX extends Application {
  @Override     public void start(Stage stage) throws Exception {  
      Parent parent = FXMLLoader.load(getClass().getResource("IHM/Emprunttry2.fxml")); 
      Scene scene = new Scene(parent);     
      stage.setScene(scene);      
      stage.initStyle(StageStyle.TRANSPARENT);       
      stage.show();     }    
  public static void main(String[] args) {   
      launch(args);    
      
  }
    
}
