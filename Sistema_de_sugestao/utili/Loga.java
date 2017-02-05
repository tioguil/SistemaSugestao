package utili;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;
import form.*;

public class Loga {
   
   private String login, senha;
   private int idLogin,nivel;

   ConectaBanco conectaBanco = new ConectaBanco();
   
   
   public Loga(){
            
   }
   
   public Loga(String login, String senha) {
      this.login = login;
      this.senha = senha;
      
          
   }
   Login lo = new Login();
   public void VerificaLogin(){
            
      
             
     		
				try {
            conectaBanco.conecta();
            conectaBanco.executaSQL("select * from login where login='" + this.login + "'");
            conectaBanco.rs.first();
            if(conectaBanco.rs.getString("senha").equals(this.senha) ){
               
                             
                          
               this.idLogin = conectaBanco.rs.getInt("id_login");
                
               
               
               this.nivel = Integer.parseInt(conectaBanco.rs.getString("nivel"));
                
                switch (this.nivel){
                    case 0:
                            
                            TelaColaborador colaborador = new TelaColaborador(this.idLogin);
                            colaborador.setVisible(true);
                            colaborador.carregar();
                            


                            
                            break;
                    case 1:
                            TelaAvaliador avaliador = new TelaAvaliador(idLogin);
                            avaliador.setVisible(true);
                            avaliador.carregar();
                             
                           
                           
                           break;
                    case 2:
                                                      
                            TelaSuperior superior = new TelaSuperior(idLogin);
                            superior.setVisible(true);
                            superior.carregar();
                            
                           
                           break;
                     case 3:
                                                      
                            TelaAdm adm = new TelaAdm();
                            adm.setVisible(true);                           
                           
                           break;      
                }
             
               
               
            }else { JOptionPane.showMessageDialog(null, " Usuário ou senha não conferem ! " );
                     
                     lo.setVisible(true);
             }
            
         }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Usuario não localizado");
               
               lo.setVisible(true);
              
            
         }finally {
                conectaBanco.desconecta();
                
          }
   
      
        
   }
   
   public int getId(){
      JOptionPane.showMessageDialog(null, idLogin);
      return this.idLogin;
      
   }
   
}