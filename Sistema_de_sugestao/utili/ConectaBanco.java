package utili;
import com.mysql.jdbc.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ConectaBanco {
    
    public Statement stm;// Realizar pesquisa no banco
    public ResultSet rs; // Armazena resultado de uma pesquisa
    private String driver = "com.mysql.jdbc.Driver";
    private String caminho = "jdbc:mysql://localhost/projeto";
    private String usuario = "root"; //Usuario Host
    private String senha = "root"; // senha Host
    public Connection conn;
    
    public void executaSQL (String sql){
        try {
        stm = (Statement) conn.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
        rs = stm.executeQuery(sql);
        
        } catch (SQLException ex) {
                
        }        
    }
    
    public void conecta(){ //Realiza conexao com o Banco
        try {
            System.setProperty("jdbc.Drivers", driver);
            conn = DriverManager.getConnection(caminho, usuario,senha);
            //JOptionPane.showMessageDialog(null, "Conectado com sucesso ");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
        }
        
    }
    
    // desconecta com o Banco
    public void desconecta(){
        try {
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
        }
    }
        
}
