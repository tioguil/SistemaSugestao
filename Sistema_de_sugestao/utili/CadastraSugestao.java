package utili;
import javax.swing.*;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.Date;
import java.text.*;

public class CadastraSugestao {
   
   private String sugestao, area;
   private int idArea, idValidacao,idLogin;
   private Date data;
   private DateFormat formatter;
   
   public CadastraSugestao (String sugestao, String area, int idLogin){
        this.sugestao = sugestao;
        this.area = area;
		  this.idLogin = idLogin;
        
         
   }
   
     
   //cadastra Sugestao
   public boolean cadastraSugestao(){
      
      ConectaBanco conectaBanco = new ConectaBanco();
      formatter = new SimpleDateFormat("dd/MM/yyyy");
      try{
                this.data = formatter.parse("00/00/0000");
             } 
            catch(ParseException e){
                 JOptionPane.showMessageDialog(null, "Erro: " + e, "Data inv√°lida!",
                 JOptionPane.ERROR_MESSAGE);
            }
      
      
      try{  
         conectaBanco.conecta();
         conectaBanco.conn.setAutoCommit(false);
         
         //Cadastra Validacao   
         PreparedStatement pst = conectaBanco.conn.prepareStatement(" INSERT INTO `validacao`(estado, resposta, data)values(?,?,?)");
         pst.setString(1,"0");
         pst.setString(2," ");
         pst.setDate(3, new java.sql.Date(data.getTime()));
         pst.executeUpdate();
          
         conectaBanco.executaSQL("SELECT LAST_INSERT_ID()");
         conectaBanco.rs.next();       
         idValidacao = conectaBanco.rs.getInt("LAST_INSERT_ID()");        
            
                  
         //Verifica Area
         conectaBanco.executaSQL("select id_departamento from departamento where nome_Departamento = '" + area + "'");
            
         conectaBanco.rs.first();
         idArea = conectaBanco.rs.getInt("id_departamento");
         
         //Cadastra Sugestao   
         PreparedStatement pst2 = conectaBanco.conn.prepareStatement(" insert into sugestao (sugestao, departamento_id_departamento,validacao_id_validacao, login_id_login) values(?,?,?,?)");
         pst2.setString(1,sugestao);
         pst2.setInt(2,idArea);
         pst2.setInt(3,idValidacao);
			pst2.setInt(4, idLogin);
         pst2.executeUpdate();           
            
         JOptionPane.showMessageDialog(null, "Sugest„o Cadastada com sucesso!");
         conectaBanco.conn.commit();
         return true;
         
      }
      catch (SQLException ex) {
         JOptionPane.showMessageDialog(null, "Erro: " + ex);
         try{
            if(conectaBanco.conn != null){
               conectaBanco.conn.rollback();//desfazer
            }
         }
         catch (SQLException e1){
            JOptionPane.showMessageDialog(null, "Erro: " + e1);
         } 
       return false;   
            
      }
      finally {
         conectaBanco.desconecta();
      }
      
   }
   

}