/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;
//import model.Clients;
import model.Emprunt;
public class CRUD_Historique {
    public static Connection getConnection() {
		Connection con=null;
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/db_project";
		con = DriverManager.getConnection(url,"root","");
             // JOptionPane.showMessageDialog(null,"connectionEstablised");
		}catch(ClassNotFoundException | SQLException e) {
			  JOptionPane.showMessageDialog(null,e);
		}
		return con;
}public static ObservableList<Emprunt> getDatausers2() {
        try {
            Connection con =CRUD_Historique.getConnection();
         ObservableList<Emprunt> list =FXCollections.observableArrayList();
         String var="non";
       String sql2="select * FROM db_project.emprunts2 where etatEmprunt= '"+var+"'" ;
        PreparedStatement ps1=con.prepareStatement(sql2);
                ResultSet rs1=ps1.executeQuery();       
                
                while(rs1.next()) {
            int id = Integer.parseInt(rs1.getString("empruntId"));
           int idclient = Integer.parseInt(rs1.getString("clientId"));
          int voitureid =Integer.parseInt(rs1.getString("voitureId"));
            Date DE;
                DE = rs1.getDate("dateEmprunt");
                  
          Date DR = rs1.getDate("dateRetour");
                       String Dispo = rs1.getString("etatEmprunt");
                 // vehicule   vi =  new vehicule(id , imm , type , marque , model,Dispo);
              Emprunt K= new Emprunt(DE,DR,voitureid,idclient,id,Dispo);
                    System.out.println("patata :" +K.getClientId());
                    System.out.println("patata :" +K.getClientId());
                    System.out.println("patata :" +K.getClientId());
                    System.out.println("patata :" +K.getClientId());
           list.add(K);
        }
        return list;
        }catch (Exception e3) {
            return null;}
    }   
}
