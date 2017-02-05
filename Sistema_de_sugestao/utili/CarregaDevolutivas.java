package utili;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class CarregaDevolutivas {
    
    private ArrayList <Devolutiva> dados;
    
    
     ConectaBanco conectaBanco = new ConectaBanco();

    public CarregaDevolutivas() {
        
        dados = new ArrayList <Devolutiva>();
    }

        
    public void carregaDados(int idLogin){
            String SQL ="select de.nome_departamento, su.data as dataSugestao, su.sugestao, va.resposta, va.data as dataResposta, va.estado\n" +
"	from sugestao su\n" +
"		inner join validacao va\n" +
"         on su.validacao_id_validacao = va.id_validacao\n" +
"			join departamento de\n" +
"			 on su.departamento_id_departamento = de.id_departamento\n" +
"				join login lo\n" +
"                 on su.login_id_login = " + idLogin;


        try {
            conectaBanco.conecta();
            conectaBanco.executaSQL(SQL);
            if(conectaBanco.rs.first()){
               do{
   
                   Devolutiva d = new Devolutiva(conectaBanco.rs.getString("sugestao"), conectaBanco.rs.getString("resposta"), 
                           conectaBanco.rs.getString("estado"), conectaBanco.rs.getString("nome_departamento"),
                           conectaBanco.rs.getDate("dataSugestao"), conectaBanco.rs.getDate("dataResposta"));
   
   
   
                       dados.add(d);
   
   
                   }while(conectaBanco.rs.next());
            }else {
               JOptionPane.showMessageDialog(null, "Você ainda não envio nenhum sugestão !");
            }
            
                  


                
              
            

        }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro: " + ex);
        }finally {
                    conectaBanco.desconecta();
        }

    }


    public Devolutiva getDevolutiva(int posicao){


                    if(posicao >= 0 && posicao < dados.size()){
             return dados.get(posicao);
          } else {
             return null;
          }


    }
    
    public int getQuantidadeDeDevolutivas(){
    
      return dados.size();
    
    }  
}