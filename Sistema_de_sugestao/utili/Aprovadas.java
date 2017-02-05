package utili;

public class Aprovadas {

   private String area;
   private int quantidade;
   
   public Aprovadas (String area, int quantidade){
      this.area = area;
      this.quantidade = quantidade;
   
   }
   
   public String getArea(){
      return this.area;
   }
   
   public int getQuantidade(){
      return this.quantidade;
   }
}