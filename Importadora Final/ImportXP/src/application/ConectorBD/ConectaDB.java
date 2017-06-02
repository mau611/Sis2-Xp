/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.ConectorBD; 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Henry
 */
public class ConectaDB {
    public static final String driver = "org.postgresql.Driver";
    public static final String BDurl = "jdbc:postgresql://localhost:5432/importadoraDB";
    public static final String user = "postgres";
    public static final String password = "sis2";
    public static Statement st;
    public static Connection con;
    
    
    public ConectaDB(){
        try {
            System.out.println("...");
            System.out.println("... iniciando Conexion");
            st=conectaCon().createStatement();
            
        } catch (Exception e) {
            System.err.println("Problemas al obtener el Statement : " +e);
        }
    }
    public static Connection conectaCon(){
        try {
            Class.forName(driver);
            System.out.println(".... cargando Driver JDBC PostgreSQL");
            con=DriverManager.getConnection(BDurl, user, password);
            System.out.println(".... Conexion Exitosa!!!!");
        } catch (Exception e) {
            System.err.println(e.getClass().getName()+" : "+e.getMessage());
        }
        return con;
    }
     public static ResultSet consultar(String sql){
        
        ResultSet resultado= null;
        try{
              System.out.println("..... realizando consulta");  
//              System.out.println(sql);
              resultado=st.executeQuery(sql);
              System.out.println("..... consulta exitosa");    
                
        }catch(SQLException e){
           // e.printStackTrace();
            System.err.println("error consultando");
            resultado=null;
        }
        return resultado;
    }
}
    