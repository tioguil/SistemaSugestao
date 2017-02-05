package utili;
import java.sql.Date;




public class Devolutiva {
    
    private String sugestao, devolutiva, estado, area;
    private Date dataEnvio,dataResposta;
    

    public Devolutiva(String sugestao, String devolutiva, String estado, String area, Date dataEnvio, Date dataResposta) {
        this.sugestao = sugestao;
        this.devolutiva = devolutiva;
        this.estado = estado;
        this.area = area;
        this.dataEnvio = dataEnvio;
        this.dataResposta = dataResposta;
    }

    public String getSugestao() {
        return sugestao;
    }

    public String getDevolutiva() {
        if(devolutiva.equals(null)){
        return "1";
        }else {
         return devolutiva;
        }
    }

    public String getEstado() {
         if(estado.equals("0")){
            return "Em Analise";
         }else if(estado.equals("1")){
            return "Aprovada";
         }else{
            return "Reprovada";
          }
    }

    public String getArea() {
        return area;
    }

    public Date getDataEnvio() {
        return dataEnvio;
    }

    public Date getDataResposta() {
        return dataResposta;
    }
    
    
    
}