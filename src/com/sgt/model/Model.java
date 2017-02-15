package com.sgt.model;

import com.sgt.db.DaoClass;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 * Classe Responsável por Executar as consultas no banco de dados
 *
 * @author Henrique Rocha
 */
public class Model {

    
    Connection Conexao = DaoClass.conectar();
    Map Retorno = new HashMap();
        
    /* Metodo usado para checar se o usuário tem permissão para entrar no sistema */
    public boolean MLogar(String User, String Senha) {

        String Sql = "SELECT usuario from usuarios WHERE usuario = ? AND senha = ?";

        try {
            PreparedStatement Pmp = Conexao.prepareStatement(Sql);
            Pmp.setString(1, User);
            Pmp.setString(2, Senha);
            ResultSet Rset = Pmp.executeQuery();
            Conexao.close();
            return Rset.next();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falha ao consultar dos dados" + e);
            return false;
        }
    }

    /* Metodo usado para listar todos os estudantes matriculados*/
    public ArrayList GetEstudantes() {
        String Sql = "SELECT est_nome FROM estudantes ORDER BY est_nome ASC";
        try {
            PreparedStatement Pmp = Conexao.prepareStatement(Sql);
            ResultSet Rset = Pmp.executeQuery();

            ArrayList Estudantes = new ArrayList();

            while (Rset.next()) {
                Estudantes.add(Rset.getString("est_nome"));
            }
            Rset.close();
            Conexao.close();
            return Estudantes;
        } catch (SQLException e) {
            ArrayList Error = new ArrayList();
            Error.add("Faha ao buscar os dados. - " + e);
            return Error;
        }

    }

    /* Método usado para salvar os dados da programação semanal  */
    public Map GrvProg(Map DadosProg) {
        String Sql = "INSERT INTO programacao (prog_data, prog_sala, prog_discurso1, prog_oradorD1, prog_pontoD1, prog_discurso2, prog_oradorD2, prog_ajudanteD2, prog_pontoD2, prog_discurso3, prog_oradorD3, prog_ajudanteD3,prog_pontoD3, prog_discurso4, prog_oradorD4, prog_ajudanteD4, prog_pontoD4) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
        String Query3 = "SELECT prog_data FROM programacao WHERE prog_data = ?";
        try {
            
            PreparedStatement Pmp = Conexao.prepareStatement(Query3);
            Pmp.setString(1, DadosProg.get("Data").toString());
            ResultSet Rs = Pmp.executeQuery();
            if(Rs.next()){
                Retorno.put("Retorno", false);
                Retorno.put("Mensagem", "Já existe um  programa cadastrado com essa data. Verifique os dados e tente novamente");
                return Retorno;
            }
            
            Pmp = Conexao.prepareStatement(Sql);
            Pmp.setString(1, DadosProg.get("Data").toString());
            Pmp.setString(2, DadosProg.get("Sala").toString());
            Pmp.setString(3, DadosProg.get("Leitura").toString());
            Pmp.setString(4, DadosProg.get("Leitura Participante").toString());
            Pmp.setString(5, DadosProg.get("Leitura Ponto").toString());
            Pmp.setString(6, DadosProg.get("Pri Visita").toString());
            Pmp.setString(7, DadosProg.get("PVisita Participante").toString());
            Pmp.setString(8, DadosProg.get("PVisita Ajudante").toString());
            Pmp.setString(9, DadosProg.get("PVisita Ponto").toString());
            Pmp.setString(10, DadosProg.get("Revisita").toString());
            Pmp.setString(11, DadosProg.get("Revisita Participante").toString());
            Pmp.setString(12, DadosProg.get("Revisita Ajudante").toString());
            Pmp.setString(13, DadosProg.get("Revisita Ponto").toString());
            Pmp.setString(14, DadosProg.get("Estudo Biblico").toString());
            Pmp.setString(15, DadosProg.get("EsBiblico Participante").toString());
            Pmp.setString(16, DadosProg.get("EsBiblico Ajudante").toString());
            Pmp.setString(17, DadosProg.get("EsBiblico Ponto").toString());
            int rel = Pmp.executeUpdate();
            Pmp.close();
            
            if (rel >= 1) {
                System.out.println("Lop");
                /*Atualizar os dados dos participantes*/
                String Query2 = "SELECT * FROM estudantes WHERE est_nome in (?,?,?,?)";
                String pontoCons;
                String participante;
                String ajudante;
                
                Pmp = Conexao.prepareStatement(Query2);
                Pmp.setString(1, DadosProg.get("Leitura Participante").toString());
                Pmp.setString(2, DadosProg.get("PVisita Participante").toString());
                Pmp.setString(3, DadosProg.get("Revisita Participante").toString());
                Pmp.setString(4, DadosProg.get("EsBiblico Participante").toString());
                ResultSet Rset = Pmp.executeQuery();

                String updateLastData = " UPDATE estudantes SET  est_dt_ult_dis = ? WHERE est_nome = ?";
                String updatePart = "UPDATE estudantes SET est_dt_desig = ? , est_pnt_cs = ?, est_sala = ? WHERE est_nome = ?";
                String updateAju = "UPDATE estudantes SET est_dt_aju = ? WHERE est_nome = ?";
                int ctlPonto = 1;

                while (Rset.next()) {
                    
                    PreparedStatement Prep = Conexao.prepareStatement(updateLastData);
                    Prep.setString(1, Rset.getString("est_dt_desig"));
                    Prep.setString(2, Rset.getString("est_nome"));
                    int ln = Prep.executeUpdate();
                    Prep.close();
                    
                pontoCons = ctlPonto == 1 ? DadosProg.get("Leitura Ponto").toString() : (ctlPonto == 2 ? DadosProg.get("PVisita Ponto").toString() : (ctlPonto == 3 ? DadosProg.get("Revisita Ponto").toString() : (                              ctlPonto == 4 ? DadosProg.get("EsBiblico Ponto").toString() : null)));
                participante = ctlPonto == 1 ? DadosProg.get("Leitura Participante").toString() : (ctlPonto == 2 ? DadosProg.get("PVisita Participante").toString() : (ctlPonto == 3 ? DadosProg.get("Revisita Participante").                    toString() : (ctlPonto == 4 ? DadosProg.get("EsBiblico Participante").toString() : null)));

                       /* Atualizando os dados do participante da parte */
                       Prep = Conexao.prepareStatement(updatePart);
                       Prep.setString(1, DadosProg.get("Data").toString());
                       Prep.setString(2, pontoCons);
                       Prep.setString(3, DadosProg.get("Sala").toString());
                       Prep.setString(4, participante);                       
                       int Exe = Prep.executeUpdate();
                       Prep.close();
                       
                       if (ctlPonto > 1) {
                            ajudante = ctlPonto == 2 ? DadosProg.get("PVisita Ajudante").toString() : (ctlPonto == 3 ? DadosProg.get("Revisita Ajudante").toString() : (ctlPonto == 4 ? DadosProg.get("EsBiblico Ajudante").                                toString() : null));                            
                            /* Atualizando os dados do Ajudante */
                            Prep = Conexao.prepareStatement(updateAju);
                            Prep.setString(1, DadosProg.get("Data").toString());
                            Prep.setString(2, ajudante);
                            int Aju = Prep.executeUpdate(); 
                            Prep.close();
                       }
                       
                       ctlPonto ++;
                }
                Rset.close();
                Pmp.close();
                Conexao.close();
                Retorno.put("Retorno", true);
                Retorno.put("Messagem", "Dados Salvos com sucesso!! Gostaria de cadastrar um novo programa?");
                return Retorno;
            }else{
                Retorno.put("Retorno", false);
                Retorno.put("Mensagem", "Falha ao gravar os dados. Veriifique os dados e tente novamente");
                return Retorno;
            }

        } catch (SQLException e) {
            System.out.println("Falha ao cadastrar o programa" + e);
            return Retorno;
        }

    }
    
    
    /* Metodo para cadastrar um novo estudante */
    public Map CadastraEstudante(Map Dados){
        
        String Sql1 = "SELECT est_nome FROM estudantes WHERE est_nome = ?";
        String Sql2 = "INSERT INTO estudantes (est_nome, est_tel, est_sit, est_sex) VALUES (?,?,?,?)";
        try {
           
            PreparedStatement Pmp = Conexao.prepareStatement(Sql1);
            Pmp.setString(1, Dados.get("Nome").toString());
            ResultSet Rs = Pmp.executeQuery();            
            if(Rs.next()){
                Retorno.put("Retorno", false);
                Retorno.put("Mensagem", "Esse Estudante já está matriculado!");
                return Retorno;
            }
            
            Pmp = Conexao.prepareStatement(Sql2);
            Pmp.setString(1, Dados.get("Nome").toString());
            Pmp.setString(2, Dados.get("Tel").toString());
            Pmp.setString(3, Dados.get("Priv").toString());
            Pmp.setString(4, Dados.get("Sexo").toString());
            int Exe = Pmp.executeUpdate();
            Conexao.close();
            if(Exe >= 1){
                Retorno.put("Retorno", true);
                return Retorno;
            }else{
                Retorno.put("Retorno", false);
                Retorno.put("Mensagem", "Falha ao cadastrar o estudante!!");
                return Retorno;
            }            
            
        } catch (SQLException e) {
             Retorno.put("Retorno", false);
             Retorno.put("Mensagem", e);
             return Retorno;
        }
          
    }

    public Map AtualizaUser(Map DadosUP) {
        
        String Sql = "UPDATE usuarios SET nome = ?, usuario = ? , senha = ?, email = ? WHERE id = ? ";
        try {
            
            PreparedStatement Pmp = Conexao.prepareStatement(Sql);
            Pmp.setString(1, DadosUP.get("Nome").toString());
            Pmp.setString(2, DadosUP.get("NomeUser").toString());
            Pmp.setString(3, DadosUP.get("Senha").toString());
            Pmp.setString(4, DadosUP.get("Email").toString());
            Pmp.setString(5, DadosUP.get("id").toString());
            
            int Exe = Pmp.executeUpdate();
            Conexao.close();
            if(Exe >= 1){
                
                Retorno.put("Result", true);
                Retorno.put("Mensagem", "Dados atualizados com sucesso!!!");
                
                return Retorno;
                
            }else{
               
                Retorno.put("Result", false);
                Retorno.put("Mensagem", "Falha ao atualizar os dados!!!");
                return Retorno;            
            }
            
        } catch (SQLException e) {            
             Retorno.put("Result", false);
             Retorno.put("Mensagem", e.getMessage());                
             return Retorno;            
        }
        
    }

    public Map CadastraUser(Map DadosCAD) {
        
        String Sql = "INSERT INTO usuarios (nome, usuario, senha, email) VALUES (?,?,?,?)";
        String Sql2 = "SELECT * FROM usuarios WHERE id = ?";
        try {
            
            PreparedStatement Pmp = Conexao.prepareStatement(Sql2);
            Pmp.setString(1, DadosCAD.get("id").toString());
            ResultSet rs = Pmp.executeQuery();
            
            if(rs.next()){
                Retorno.put("Result", false);
                Retorno.put("Mensagem", "Esse usuário já existe");
                return Retorno;  
            }
            
            Pmp = Conexao.prepareStatement(Sql);
            Pmp.setString(1, DadosCAD.get("Nome").toString());
            Pmp.setString(2, DadosCAD.get("NomeUser").toString());
            Pmp.setString(3, DadosCAD.get("Senha").toString());
            Pmp.setString(4, DadosCAD.get("Email").toString());
            
            int Exe = Pmp.executeUpdate();
            Conexao.close();
            if(Exe >= 1){                
                Retorno.put("Result", true);
                Retorno.put("Mensagem", "Usuário cadastrado com sucesso!!!");               
                return Retorno;               
            }else{
                Retorno.put("Result", false);
                Retorno.put("Mensagem", "Falha ao cadastrar os dados!!!");
                return Retorno;            
            }            
        } catch (SQLException e) {
             Retorno.put("Result", false);
             Retorno.put("Mensagem", e.getMessage());                
             return Retorno;          
        }

    }
    
    
    
    

}
