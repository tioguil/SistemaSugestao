package utili;

public class Ranking{
   private String nome;
   private int quantidade;
   
   public Ranking(String nome, int quantidade){
        this.nome = nome;
        this.quantidade = quantidade;
   }
   
   public String getNome(){
      return this.nome;
   }
   
   public int getQuantidade(){
      return this.quantidade;
   }

}