/*
 * Classe responsável por fazer a camada de comunicação com o banco de dados Sqlite
 */
package com.sgt.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/*
 * @author Henrique Rocha
 */
public class DaoClass {
    
    
    public static Connection conectar(){
        
        Connection conn = null;
       
        try {                       
            String db = "jdbc:sqlite:C:/SGT/db/emt.db";
            conn = DriverManager.getConnection(db); 
            return conn;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Falha ao conectar ao banco de dados: "+ e);
            return null;
        }
               
    }
    
    
    
}
