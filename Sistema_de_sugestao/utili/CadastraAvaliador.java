package utili;
import java.sql.*;
import javax.swing.*;


public class CadastraAvaliador{

   private String cpf, nivel, area;
   
   ConectaBanco conectaBanco = new ConectaBanco();
   
   public CadastraAvaliador(String cpf, String nivel, String area){
       
       this.cpf = cpf.replaceAll("[.-]", "");
       
      if(nivel.equals("0-Colaborador")){
         this.nivel = "0";
      }else if(nivel.equals("1-Avaliador")){
          this.nivel = "1";
      }else{
         this.nivel = "2";
      }
      
      this.area = area;
           
   
   }
   
   public void alterarLogin(){
      ConectaBanco conectaBanco = new ConectaBanco();
      try{
         conectaBanco.conecta();
         conectaBanco.conn.setAutoCommit(false);
         
         conectaBanco.executaSQL("select lo.id_login from login lo\n" +
               "	join cadastro ca\n" +
               "		on lo.id_login = ca.login_id_login \n" +
               "			where ca.cpf = " + this.cpf);
         
         if(conectaBanco.rs.first()){
               
               int idLogin = conectaBanco.rs.getInt("id_login");
               
               
               conectaBanco.executaSQL("select id_departamento from departamento where nome_Departamento = '" + this.area + "'");
                  
               conectaBanco.rs.first();
               int idArea = conectaBanco.rs.getInt("id_departamento");
               
               PreparedStatement pst = conectaBanco.conn.prepareStatement("update Login set nivel = ? where id_login = ? ");
               pst.setString(1,this.nivel);
               pst.setInt(2, idLogin);
               pst.executeUpdate();
               
               PreparedStatement pst2 = conectaBanco.conn.prepareStatement("Insert into avaliador (login_id_login, departamento_id_departamento) values (?,?)");
               pst2.setInt(1,idLogin);
               pst2.setInt(2,idArea);
               pst2.executeUpdate();
                        
               conectaBanco.conn.commit();
               JOptionPane.showMessageDialog(null, "Cadastro Atualizado com sucesso !");
            }else{
               JOptionPane.showMessageDialog(null, "Cadastro não localizado !");
            }
      }catch(SQLException e){
         JOptionPane.showMessageDialog(null, "Erro: " + e);
         
         try{
            if(conectaBanco.conn != null){
               conectaBanco.conn.rollback();//desfazer
            }
         } 
         catch (SQLException e1){
            JOptionPane.showMessageDialog(null, "Erro: " + e1);
         }
      }finally  {
        
         conectaBanco.desconecta();
      }
      
      
 
   }
   
   
   
   
}