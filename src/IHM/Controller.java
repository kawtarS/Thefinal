/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;


import BD.CRUD_Emprunt;
import BD.CRUD_Historique;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import model.Emprunt;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class Controller implements Initializable {

   

      @FXML
    private TableView<Emprunt> tables_historique;


      @FXML
    private TableColumn<Emprunt, Integer> col_empruntId1;

      @FXML
    private TableColumn<Emprunt,Integer> col_idclient1;

      @FXML
    private TableColumn<Emprunt,Integer> col_voitureId1;

      @FXML
    private TableColumn<Emprunt,Date> col_dateE1;

      @FXML
    private TableColumn<Emprunt, Date> col_dateR1;

      @FXML
    private TableColumn<Emprunt, String> col_etat1;
    ObservableList<Emprunt> listM1;
    int index=-1;
    Connection con=null;
    ResultSet rs=null;
    PreparedStatement pst = null;
    

@FXML
    private ImageView back;
  

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       UpdateTable();
    }    

    @FXML
    private void getSelected(MouseEvent event) {
    }

    @FXML
    private void switchback(MouseEvent event) {
        try{back.getScene().getWindow().hide();
                Parent root=FXMLLoader.load(getClass().getResource("Emprunttry2.fxml"));
                Stage mainStage=new Stage();
                Scene scene=new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();}catch (Exception e){
                }
    }
      private void UpdateTable() {
        col_empruntId1.setCellValueFactory(new PropertyValueFactory<Emprunt,Integer>("empruntId"));
      col_idclient1.setCellValueFactory(new PropertyValueFactory<>("clientId"));
     col_voitureId1.setCellValueFactory(new PropertyValueFactory<>("voitureId"));
      col_dateE1.setCellValueFactory(new PropertyValueFactory<>("dateEmprunt"));
            col_dateR1.setCellValueFactory(new PropertyValueFactory<>("dateRetour"));
              col_etat1.setCellValueFactory(new PropertyValueFactory<>("etatEmprunt"));
         listM1= CRUD_Historique.getDatausers2();
           tables_historique.setItems(listM1);
    }

    @FXML
    private void DeleteH(ActionEvent event) {
         con= CRUD_Emprunt.getConnection();
         String var="non";
    String sql="delete from emprunts2 where etatEmprunt= '"+var+"'";
    /*String sql2="select * FROM db_project.emprunts2 where etatEmprunt= '"+var+"'" ;
        PreparedStatement ps1=con.prepareStatement(sql2);
                ResultSet rs1=ps1.executeQuery(); */  
       try {
           pst=con.prepareStatement(sql);
           
           pst.execute();
            JOptionPane.showMessageDialog(null, "Delete bien fait");
              UpdateTable();
          
       } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
       }
    }
}
