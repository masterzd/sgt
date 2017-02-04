package com.sgt.model;
import com.sgt.db.DaoClass;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 * Classe Responsável por Executar as consultas no banco de dados
 * @author Henrique Rocha
 */
public class Model {
        
    /* Metodo usado para checar se o usuário tem permissão para entrar no sistema */
    public boolean MLogar(String User, String Senha){
       
        String Sql = "SELECT usuario from usuarios WHERE usuario = ? AND senha = ?";
        
        try {
            PreparedStatement Pmp = DaoClass.conectar().prepareStatement(Sql);
            Pmp.setString(1, User);
            Pmp.setString(2, Senha);
            ResultSet Rset  = Pmp.executeQuery();
            
            return Rset.next();
                     
        } catch (Exception e) {            
            JOptionPane.showMessageDialog(null, "Falha ao consultar dos dados" + e);
            return false;
        }        
    }
    /* Metodo usado para listar todos os estudantes matriculados*/
    public ArrayList GetEstudantes(){        
        String Sql = "SELECT est_nome FROM estudantes ORDER BY est_nome ASC";        
        try {           
            PreparedStatement Pmp = DaoClass.conectar().prepareStatement(Sql);
            ResultSet Rset = Pmp.executeQuery();

            ArrayList Estudantes = new ArrayList();
            
            while(Rset.next()){
                Estudantes.add(Rset.getString("est_nome"));
            }
            
            return Estudantes;
        } catch (SQLException e) {
            
            ArrayList Error = new ArrayList();
            Error.add("Faha ao buscar os dados. - " + e);            
            return Error;            
        }
        
        
        
        
        
        
        
    }
   
    
    
    
    
    
    
}
