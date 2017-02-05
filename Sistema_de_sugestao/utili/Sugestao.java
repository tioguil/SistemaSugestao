package utili;
import java.sql.Date;

public class Sugestao {
	
	private String nome,area, sugestao;
   private int id_sugestao;
   private Date data;
	
	public Sugestao (String nome,Date data, String area, String sugestao, int id_sugestao){
		this.nome = nome;
		this.area = area;
		this.data = data;
		this.sugestao = sugestao;
      this.id_sugestao = id_sugestao;		
		
	}
   
   public int getId_sugestao(){
      return this.id_sugestao;
   }
	
	public String getNome(){
		return this.nome;
	}
	public String getArea(){
		return this.area;
	
	}
	
	public Date getData(){
		return this.data;
	}
	
	public String getSugestao(){
		return this.sugestao;
	}
	
	

}