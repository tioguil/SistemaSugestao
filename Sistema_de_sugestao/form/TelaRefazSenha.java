package form;
import java.awt.*;
import javax.swing.*;
import javax.swing.text.*;
import java.text.*;
import java.awt.event.*;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Date;
import java.sql.SQLException;
import java.sql.ResultSet;
import utili.*;

public class TelaRefazSenha extends JFrame{
   
   private JFormattedTextField txtNasc, txtCpf;
   private JLabel lblNasc,lblCpf,lblTitulo,lblSub,lblConfirma ,logo;
   private JPasswordField novaSenha, confirmaSenha;
   private JButton btnEnviar,btnVoltar;
   private DateFormat formatter;
   
public  TelaRefazSenha(){
   super("Nova Senha");
   txtNasc = new JFormattedTextField();
   txtNasc.setPreferredSize(new Dimension(78,20));
   txtCpf = new JFormattedTextField();
   txtCpf.setPreferredSize(new Dimension(95,20));
   lblNasc = new JLabel ("Inserir nascimento:");
   lblNasc.setFont(new Font("Monospaced", Font.ITALIC, 15));
   lblNasc.setForeground(Color.BLACK);
   lblCpf = new JLabel("Inserir CPF:");
   lblCpf.setFont(new Font("Monospaced", Font.ITALIC, 15));
   lblCpf.setForeground(Color.BLACK);
   lblTitulo = new JLabel ("Esqueceu a senha?");
   lblTitulo.setFont(new Font("Monospaced", Font.ITALIC, 17));
   lblTitulo.setForeground(Color.BLACK);
   lblSub = new JLabel("Digite uma nova senha:");
   lblSub.setFont(new Font("Monospaced", Font.ITALIC, 15));
   lblSub.setForeground(Color.BLACK);
   lblConfirma = new JLabel("Confirmar senha:");
   lblConfirma.setFont(new Font("Monospaced", Font.ITALIC, 15));
   lblConfirma.setForeground(Color.BLACK);
   btnEnviar = new JButton ("Enviar");
   btnEnviar.setForeground(Color.BLACK);
   Color envia= new Color(207,207,207);
   btnEnviar.setBackground(envia);
   btnVoltar = new JButton ("Voltar");
   btnVoltar.setForeground(Color.BLACK);
   Color volta= new Color(207,207,207);
   btnVoltar.setBackground(volta);
   novaSenha = new JPasswordField(20);
   confirmaSenha = new JPasswordField(20); 
   
   formatter = new SimpleDateFormat("dd/MM/yyyy");
 
   //mascara data de nascimento
      try {
         txtNasc.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/####")));
      } 
      catch (ParseException ex) {
         ex.printStackTrace();
      }
      
      try {
         txtCpf.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("###.###.###-##")));
      } 
      catch (ParseException ex) {
         ex.printStackTrace();
      }  
 
   Container refazSenha = getContentPane(); 
   refazSenha.setLayout( new GridLayout(4,1)); 
   JPanel linha1 = new JPanel (new BorderLayout());
   JPanel campo1 = new JPanel (new FlowLayout());
   JPanel campo2 = new JPanel (new FlowLayout());
   JPanel linha2 = new JPanel (new GridLayout(2,1));
   JPanel linha3 = new JPanel (new FlowLayout());
   JPanel linha4 = new JPanel (new FlowLayout());
   JPanel linha5 = new JPanel (new BorderLayout());
 
      logo = new JLabel();
      logo.setIcon(new ImageIcon(getClass().getResource("/img/logo.png")));
      
      linha1.add(logo,BorderLayout.NORTH);
      campo1.add(lblTitulo);
      Color c1 = new Color(154,233,233);
      campo1.setBackground(c1);
      linha1.add(campo1);
      Color l1 = new Color(154,233,233);
      linha1.setBackground(l1);
            
      campo2.add(lblCpf);
      campo2.add(txtCpf);
      campo2.add(lblNasc);
      campo2.add(txtNasc);
      Color c2 = new Color(154,233,233);
      campo2.setBackground(c2);
      linha2.add(campo2);
      Color l2 = new Color(154,233,233);
      linha2.setBackground(l2);
      
      linha3.add(lblSub);
      linha3.add(novaSenha);
      linha3.add(lblConfirma);
      linha3.add(confirmaSenha);
      Color l3 = new Color(154,233,233);
      linha3.setBackground(l3);
    
      
      linha4.add(btnVoltar);
      linha4.add(btnEnviar);
      Color l4 = new Color(154,233,233);
      linha4.setBackground(l4);
      linha5.add(linha4,BorderLayout.SOUTH);
      Color l5 = new Color(154,233,233);
      linha5.setBackground(l5);
      
      add(linha1);
      add(linha2);
      add(linha3);
      add(linha5);
      
      setResizable(false);
      setVisible(false);
      setSize(513,236);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);
      
     btnVoltar.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
               btnVoltarActionPerformed(evt);
            }
         });
       
       btnEnviar.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
               btnEnviarActionPerformed(evt);
            }
         });  
         
      UIManager.getDefaults().put("OptionPane.background",new Color(154,233,233));
      UIManager.put ("Panel.background", new Color(154,233,233)); 
 
 }//Fim Construtor
 
   public void btnVoltarActionPerformed(ActionEvent evt){
      Login login = new Login();
      login.setVisible(true);
      dispose();
   
   }
   
   public void btnEnviarActionPerformed(ActionEvent evt){
   
      String cpf = txtCpf.getText();
             cpf = cpf.replaceAll("[.-]", "");
      
      RecuperaSenha recupera = new RecuperaSenha(cpf, txtNasc.getText(),novaSenha.getText(), confirmaSenha.getText());
      recupera.alterarSenha();
      dispose();
   
   }
 
   public static void main (String [] args ){
      new TelaRefazSenha ();
   
   
   }
}
