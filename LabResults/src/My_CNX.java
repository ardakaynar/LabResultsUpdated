/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ardakaynar
 */



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class My_CNX {
    static Connection con;
       
       public My_CNX() {
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");  
            con=DriverManager.getConnection("jdbc:derby://localhost:1527/ardakaynar","root","1234");  
        }catch(ClassNotFoundException | SQLException e){ System.out.println(e);}
       try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            System.out.println("DRİVER VAR");
        } catch (ClassNotFoundException ex) {
            System.out.println("DRİVER YOK");
        }
       try {
         con=DriverManager.getConnection("jdbc:derby://localhost:1527/ardakaynar","root","1234");  
        Statement stmt=con.createStatement(); 
        
            System.out.println("BAGLANTI BASARILI");
        } catch (SQLException ex){
            System.out.println("BAGLANTI BASARISIZ");
        }
        
    }
   
}