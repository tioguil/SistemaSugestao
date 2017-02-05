package utili;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.*;
import java.text.ParseException;
import javax.swing.JOptionPane;
import form.*;


public class CadastraBanco {
   private String login, senha, senha2, nome, sexo, email, email2, cpf, nivel = "0",atuacao;
   private Date data;
   private int id;
   private Date dataNascimento;
    
   ConectaBanco conectaBanco = new ConectaBanco();
   
   public CadastraBanco(){          
   
   }
   
   
   public CadastraBanco(String login, String senha, String senha2, String nome, String sexo, String email,String email2,
     String cpf, Date data,String atuacao){
      this.login = login;
      this.senha2 = senha2;
      this.senha = senha;
      this.nome = nome;
      if(sexo.equals("Masculino")){
         this.sexo = "m";
      }
      else {
         this.sexo = "f";
      }
        
      this.email = email;
      this.email2 = email2;
      this.cpf = cpf;
        
      this.data = data;
      this.atuacao = atuacao;
   }
    
   public void setDataNascimento(Date data){
      dataNascimento = data;
   }
   
   public String Carregar(int id){
      
       try {
         conectaBanco.conecta();
         conectaBanco.executaSQL("");
         conectaBanco.rs.next();
         
         
         
       }catch(SQLException ex){
         JOptionPane.showMessageDialog(null, "Cadastro não localizado!\n Erro: " + ex);
       
       }finally  {
        
         conectaBanco.desconecta();
      } 
       
       return "";  
   }
   
   
   //Atualiza os dados
   public void atualizar(int id, String nomeAtu, String senhaAtu, String senha2Atu, String email, String email2, String genero, String atuacao){
         
         
      if(genero.equals("Masculino")){
         genero = "m";
      }
      else {
         genero = "f";
      }
      
      try {
         conectaBanco.conecta();
         conectaBanco.conn.setAutoCommit(false);
         if(senhaAtu.equals(senhaAtu) ){
             
            if(email.equals(email2)){
               PreparedStatement pst = conectaBanco.conn.prepareStatement("update cadastro set nome =? , sexo =? ,email =? , atuacao =? where login_id_login =? ");
               pst.setString(1,nomeAtu);
               pst.setString(2,genero);
               pst.setString(3,email);
               pst.setString(4,atuacao);
               pst.setInt(5,id);
               pst.executeUpdate();
               
               PreparedStatement pst2 = conectaBanco.conn.prepareStatement("update login set senha = ? where id_login = ?");
               pst2.setString(1,senhaAtu);
               pst2.setInt(2,id);
               pst2.executeUpdate();
               
               JOptionPane.showMessageDialog(null, "Dados Atualizados ! ");
                              
               conectaBanco.conn.commit();              
               
            
            }else {
            JOptionPane.showMessageDialog(null, "E-mails não conferem");
         
         }
       
         }else {
            JOptionPane.showMessageDialog(null, "Senhas não conferem");
         
         }  
       
       } catch (SQLException ex) {
         JOptionPane.showMessageDialog(null, "Erro ao atualizar dados!\n Erro: " + ex);
         
            
         try{
            if(conectaBanco.conn != null){
               conectaBanco.conn.rollback();//desfazer
            }
         } 
         catch (SQLException e1){
            JOptionPane.showMessageDialog(null, "Erro: " + e1);
         }
      }
      finally  {
        
         conectaBanco.desconecta();
      }    
      
   }
   
   
   //Cadastra novo Usuario 
   public void Cadastrar(){
      TelaCadastro telaCadastro = new TelaCadastro();
      try {
         conectaBanco.conecta();
         conectaBanco.conn.setAutoCommit(false);
         if(senha.equals(senha2) ){
             
            if(email.equals(email2)){
               PreparedStatement pst = conectaBanco.conn.prepareStatement(" INSERT INTO `login`(login, senha, nivel)values(?,?,?)");
               pst.setString(1,login);
               pst.setString(2,senha);
               pst.setString(3,"0");
               pst.executeUpdate();
                  
                  
                  
                  
               conectaBanco.executaSQL("SELECT LAST_INSERT_ID()");
               conectaBanco.rs.next();       
               id = conectaBanco.rs.getInt("LAST_INSERT_ID()");
                  //SimpleDateFormat format = new SimpleDateFormat("YYYY/MM/DD");
               PreparedStatement pst2 = conectaBanco.conn.prepareStatement(" INSERT INTO `cadastro`(nome, nascimento, sexo, cpf, email, atuacao, login_id_login)values(?,?,?,?,?,?,?)");
               pst2.setString(1,nome);
               pst2.setDate(2,new java.sql.Date(data.getTime()));
               pst2.setString(3,sexo);
               pst2.setString(4,cpf);
               pst2.setString(5,email);
               pst2.setString(6,atuacao);
               pst2.setInt(7,id);
               pst2.executeUpdate();           
               JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso! ");
                              
               conectaBanco.conn.commit();
               Login login = new Login();
               login.setVisible(true);
            }
            else { 
               JOptionPane.showMessageDialog(null, "E-mails não conferem");
               telaCadastro.setVisible(true);
                   
            }
            
            
         }
         else { 
            JOptionPane.showMessageDialog(null, "Senhas não conferem");
            telaCadastro.setVisible(true);
                
         }
            
           
      
            
      } 
      catch (SQLException ex) {
         JOptionPane.showMessageDialog(null, "Erro ao Cadastrar!\n Erro: " + ex);
         telaCadastro.setVisible(true);
            
         try{
            if(conectaBanco.conn != null){
               conectaBanco.conn.rollback();//desfazer
            }
         } 
         catch (SQLException e1){
            JOptionPane.showMessageDialog(null, "Erro: " + e1);
         }
      }
      finally  {
        
         conectaBanco.desconecta();
      }
    
    
   }
    
    
    
    
}