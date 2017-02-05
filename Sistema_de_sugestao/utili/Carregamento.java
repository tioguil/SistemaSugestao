package utili;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import form.*;
import java.sql.*;
import java.sql.SQLException;

public class Carregamento extends javax.swing.JFrame {
    
    private Timer t;                   
    private JLabel jLabelCarregamento, lblInforma;
    private JProgressBar barra;

    
        
    public Carregamento(){
        
        jLabelCarregamento = new JLabel();
        lblInforma = new JLabel("Conexão com banco: Conectando");
        
         lblInforma.setFont(new Font("Monospaced", Font.ITALIC, 13));
         lblInforma.setForeground(Color.BLACK);

        barra = new JProgressBar();
        
        Container container = getContentPane();
        container.setLayout(new FlowLayout());
        
        jLabelCarregamento.setIcon(new ImageIcon(getClass().getResource("/img/carregando2.gif")));
        container.add(jLabelCarregamento);
        JPanel caixa = new JPanel (new GridLayout(2,1));
        //container.add(barra);
        //container.add(lblInforma);
        caixa.add(barra);
        caixa.add(lblInforma);
        container.add(caixa);        
        setUndecorated(true);
        
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(360, 230);
        setLocationRelativeTo(null);
        
        carregar(); 
        
    }
    
    
    public void carregar(){

            ActionListener acao = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                  
                  if(barra.getValue() < 100 ){
                        barra.setValue(barra.getValue() + 2);
                        if (barra.getValue() == 40){
                           lblInforma.setText("Conexão com banco: Conectando.");
                        }else if (barra.getValue() == 60){
                           lblInforma.setText("Conexão com banco: Conectando..");
                        }else if (barra.getValue() == 80){
                           lblInforma.setText("Conexão com banco: Conectando...");
                           ConectaBanco c = new ConectaBanco();                           
                           
                           
                       
                          c.conecta();
                        //catch(IllegalArgumentException ex){
                          //JOptionPane.showMessageDialog(null, "Erro:/n Não foi conectar o banco! ");
                        // }

     
                           

                        }else if (barra.getValue() == 90){
                           lblInforma.setText("Conexão com banco: Finalizada!");
                        }
                     }else{
                     t.stop();
                     setVisible(false);
                     Login login = new Login();
                     login.setVisible(true);

                    }
                }
            };
        
         t = new Timer (50, acao );
         t.start();
    
    }   
    
}
