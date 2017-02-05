package utili;

import java.util.Date;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.text.*;
import form.*;




public class RecuperaSenha{
      private String cpf,senha,senhaConfirma;
      private String data, dataBanco;
      private int idLogin;
      
      
      ConectaBanco conectaBanco = new ConectaBanco();
      
      public RecuperaSenha(String cpf, String data, String senha, String senhaConfirma){
         this.cpf = cpf;
         this.data = data;
         this.senha = senha;
         this.senhaConfirma = senhaConfirma;
      }
   
   
   
   public void alterarSenha(){
      TelaRefazSenha recupera = new TelaRefazSenha();
      try{
            conectaBanco.conecta();
            conectaBanco.conn.setAutoCommit(false);
            if(senha.equals(senhaConfirma) ){
               conectaBanco.executaSQL("select * from cadastro where cpf = " + cpf);
               conectaBanco.rs.first();
               idLogin = conectaBanco.rs.getInt("login_id_login");
                  
               SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
 
               String dataBanco = f.format(conectaBanco.rs.getDate("nascimento"));
               
               if(this.data.equals(dataBanco)){
                  PreparedStatement pst = conectaBanco.conn.prepareStatement("update login set senha = ? where id_login = ?");
                  pst.setString(1,senha);
                  pst.setInt(2, idLogin);
                  pst.executeUpdate();
                  JOptionPane.showMessageDialog(null, "Senha Alterada com sucesso! ");
                  
                  conectaBanco.conn.commit();
                  
                  Login login = new Login();
                  login.setVisible(true);               
                 }else {
                  JOptionPane.showMessageDialog(null, "Data de Nascimento não conferem ! ");
                  recupera.setVisible(true);
                  
                 }
                              
             }else {
               JOptionPane.showMessageDialog(null, "Senhas não conferem !");
               recupera.setVisible(true);
             }
             
       }catch (SQLException e1){
            JOptionPane.showMessageDialog(null, "CPF não Localizado\n " + e1);
            
            recupera.setVisible(true);
            
            try{
               if(conectaBanco.conn != null){
                  conectaBanco.conn.rollback();//desfazer
               }
            } 
            catch (SQLException e2){
               JOptionPane.showMessageDialog(null, "Erro: " + e2);
            }
       
       }finally  {
        
         conectaBanco.desconecta();
      }      
           
   }

}