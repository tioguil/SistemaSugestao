package utili;

import java.util.ArrayList;
import java.sql.Date;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.SQLException;

public class CarregaSugestao {
   
  // private String nome,area,data, sugestao;
   private ArrayList <Sugestao> dados;
   
   ConectaBanco conectaBanco = new ConectaBanco();
   
   public CarregaSugestao(){
   
      dados = new ArrayList<Sugestao>();
   
   }
   
   
   public void coletaDoBanco (){
      	 	
				String SQL = "select \n" +
                  " su.id_sugestao , \n" +            
                  " su.sugestao, \n" +
                  " su.data,\n" +
                  " ca.nome , \n" +
                  " dp.nome_departamento\n" +
                  "	from login lo\n" +
                  "		join sugestao su on (lo.id_login = su.login_id_login)\n" +
                  "		join cadastro ca on (lo.id_login = ca.login_id_login)\n" +
                  "        join departamento dp on (dp.id_departamento = su.departamento_id_departamento)\n" +
                  " join validacao va on (va.id_validacao = su.validacao_id_validacao) where va.estado = 1 order by su.data desc ;";
			 
      try {
            conectaBanco.conecta();
            conectaBanco.executaSQL(SQL);
            conectaBanco.rs.first();
            
            
            
            
            do{
				
					Sugestao s = new Sugestao( conectaBanco.rs.getString("nome"),conectaBanco.rs.getDate("data"),  
					conectaBanco.rs.getString("nome_departamento"), conectaBanco.rs.getString("sugestao"), conectaBanco.rs.getInt("id_sugestao"));
               
               
					
                dados.add(s);
					                 
                
            }while(conectaBanco.rs.next());
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
        }finally {
                conectaBanco.desconecta();
       }
   
   
   }
	
	public Sugestao getSugestao(int posicao){
		
      
		if(posicao >= 0 && posicao < dados.size()){
         return dados.get(posicao);
      } else {
         return null;
      }
	
	}
   
   
    public int getQuantidadeDeSugestao(){
      
      return dados.size();
   
   }
   
  
}   
   

         
