package utili;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.sql.*;
import java.util.Date;
import form.*;

public class CarregaRespostas {
   private boolean semSugestao = true;
   private ArrayList <Respostas> dados;
   private ArrayList <Respostas> carregadas;
   
     ConectaBanco conectaBanco = new ConectaBanco();

    public CarregaRespostas() {
        
        dados = new ArrayList <Respostas>();
        carregadas  = new ArrayList <Respostas>();
    }

        
    public void carregaDados(int idLogin, int idDepartamento){
            String SQL ="select ca.nome, de.nome_departamento, su.sugestao, su.data, va.id_validacao\n" +
               "        from sugestao su \n" +
               "			inner join cadastro ca \n" +
               "				on su.login_id_login = ca.login_id_login\n" +
               "					join validacao va\n" +
               "                     on va.id_validacao = su.validacao_id_validacao\n" +
               "						join departamento de\n" +
               "                         on de.id_departamento = su.departamento_id_departamento \n" +
               "							where va.estado = 0 and su.departamento_id_departamento = " + idDepartamento;
            
            int idAvaliador =  idAvaliador(idLogin);
            
            for(int i = dados.size() - 1; i >= 0; i--){
               deletaDados(i);
            }
            
        try {
            conectaBanco.conecta();
            conectaBanco.executaSQL(SQL);
            
            if(conectaBanco.rs.first()){
               int i = 0;
               do{
                  
                   Respostas r = new Respostas(conectaBanco.rs.getString("nome" ), conectaBanco.rs.getString("nome_departamento"),
                   conectaBanco.rs.getString("sugestao"), conectaBanco.rs.getDate("data"), conectaBanco.rs.getInt("id_validacao"));
                   int idValidacao = conectaBanco.rs.getInt("id_validacao");
                   
   
                   PreparedStatement pst = conectaBanco.conn.prepareStatement("update validacao set avaliador_id_avaliador = ? where id_validacao = ?");
                   pst.setInt(1, idAvaliador);
                   pst.setInt(2, idValidacao);
                   pst.executeUpdate();
   
                       dados.add(r);
                   i++;
   
                  }while(conectaBanco.rs.next() && i < 5);
                  
                  JOptionPane.showMessageDialog(null, "Sugestões Carregadas com sucesso");
                  
            }else {
               semSugestao = false;
               JOptionPane.showMessageDialog(null, "Sem sugestao para avaliar !");
            }
            
        }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro metodo carregaDados : " + ex);
        }finally {
                    conectaBanco.desconecta();
        }

    }
    
    
    public void carregaArray(int idLogin){
           String SQL ="select ca.nome, de.nome_departamento, su.sugestao, su.data, va.id_validacao\n" +
                  "        from sugestao su \n" +
                  "			inner join cadastro ca \n" +
                  "				on su.login_id_login = ca.login_id_login\n" +
                  "					join validacao va\n" +
                  "                     on va.id_validacao = su.validacao_id_validacao\n" +
                  "						join departamento de\n" +
                  "                         on de.id_departamento = su.departamento_id_departamento \n" +
                  "							where va.estado = 0 and va.avaliador_id_avaliador = " + idAvaliador(idLogin);

            for(int i = carregadas.size() - 1; i >= 0; i--){
               deletaArray(i);
            }      
        try {
            conectaBanco.conecta();
            conectaBanco.executaSQL(SQL);
            
            if(conectaBanco.rs.first()){
               do{
                  
                   Respostas r = new Respostas(conectaBanco.rs.getString("nome" ), conectaBanco.rs.getString("nome_departamento"),
                   conectaBanco.rs.getString("sugestao"), conectaBanco.rs.getDate("data"), conectaBanco.rs.getInt("id_validacao"));
                                    
   
                   carregadas.add(r);
   
                  }while(conectaBanco.rs.next());
                  semSugestao = true;
            }else {
               semSugestao = false;
               JOptionPane.showMessageDialog(null, "Sem sugestao para avaliar !");
            }
     
        }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro: " + ex);
        }finally {
                    conectaBanco.desconecta();
        } 
      
         
      
      
    
    }
    
    public int idAvaliador(int idlogin){
         
      try {
         conectaBanco.conecta();
         conectaBanco.executaSQL("select * from avaliador where login_id_login = " + idlogin);
                     
          if(conectaBanco.rs.first()){
            int idAvaliador =  conectaBanco.rs.getInt("id_avaliador");
            return idAvaliador;
          }else{
            JOptionPane.showMessageDialog(null, "Erro ao buscas Id avaliador !");
            return -1;
          }
          
        }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro: " + ex);
                return -1;
                
        }finally {
                    conectaBanco.desconecta();
        }      
    }
    
    
    public boolean Responder(int idLogin, String aprovado, String resposta, int IdValidacao ){
      ConectaBanco conectaBanco = new ConectaBanco();
      
      
      Date hoje = new Date();
      try{
           conectaBanco.conecta();
           conectaBanco.conn.setAutoCommit(false);
           
           conectaBanco.executaSQL("select ava.id_avaliador\n" +
                     "		from login lo\n" +
                     "			join avaliador ava\n" +
                     "				on lo.id_login = ava.login_id_login\n" +
                     "					where lo.id_login = " + idLogin);
                     
           conectaBanco.rs.first();
           int idAvaliador = conectaBanco.rs.getInt("id_avaliador");          
           
           PreparedStatement pst = conectaBanco.conn.prepareStatement("update validacao set resposta = ?, data = ?, estado = ? where id_validacao = ?");
           pst.setString(1, resposta);
           pst.setDate(2, new java.sql.Date(hoje.getTime()));
           pst.setString(3,aprovado );
           pst.setInt(4, IdValidacao);
           pst.executeUpdate(); 
           
           JOptionPane.showMessageDialog(null,"Resposta enviada !");
           conectaBanco.conn.commit();
           return true;
                    
      }catch(SQLException ex){
         JOptionPane.showMessageDialog(null, "Erro: " + ex);
         try{
            if(conectaBanco.conn != null){
               conectaBanco.conn.rollback();//desfazer
            }
         } 
         catch (SQLException e1){
            JOptionPane.showMessageDialog(null, "Erro: " + e1);
         }
         
      }finally {
              conectaBanco.desconecta();
        }
        
      return false;  
    
    }
    
    public void deletaArray(int posicao){
      carregadas.remove(posicao);
    
    }
    
     public void deletaDados(int posicao){
      dados.remove(posicao);
    
    }


    public Respostas getRespostas(int posicao){


                    if(posicao >= 0 && posicao < carregadas.size()){
             return carregadas.get(posicao);
          } else {
             return null;
          }


    }
    
    public int getQuantidadeDeRespostas(){
    
      return carregadas.size();
    
    } 
    
    public boolean getSemSugestao(){
      return semSugestao;
    }
    

}