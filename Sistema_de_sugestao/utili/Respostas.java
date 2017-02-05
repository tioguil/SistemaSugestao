package utili;
import java.sql.Date;

public class Respostas {

   private String nome, nomeArea, sugestao;
   private Date dataEnvio;
   private int idValidacao;

   public Respostas(String nome, String nomeArea, String sugestao, Date dataEnvio, int idValidacao) {
        this.nome = nome;
        this.nomeArea = nomeArea;
        this.sugestao = sugestao;
        this.dataEnvio = dataEnvio;
        this.idValidacao = idValidacao;
    }

    public String getNome() {
        return nome;
    }

    public int getIdValidacao() {
        return idValidacao;
    }

    public String getNomeArea() {
        return nomeArea;
    }

    public String getSugestao() {
        return sugestao;
    }

    public Date getDataEnvio() {
        return dataEnvio;
    }
   
   

}