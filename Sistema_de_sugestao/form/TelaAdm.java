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
import java.awt.Color.*;
import java.sql.SQLException;
import utili.*;


public class TelaAdm extends JFrame{
   
   private JFormattedTextField txtCpf;
   private JLabel lblCpf,lblTitulo,lblArea,lblNivel;
   private JButton btnAlterar,btnSair;
   private JComboBox<String>jComboArea ,jComboNivel;
   
public  TelaAdm(){
   super("Nil One");
   
   txtCpf = new JFormattedTextField();
   txtCpf.setPreferredSize(new Dimension(95,20));
   lblCpf = new JLabel("Inserir CPF:");
   lblCpf.setFont(new Font("Monospaced", Font.ITALIC, 15));
   lblCpf.setForeground(Color.BLACK);
   
   lblTitulo = new JLabel ("Alterar niveis");
   lblTitulo.setFont(new Font("Monospaced", Font.ITALIC, 17));
   lblTitulo.setForeground(Color.BLACK);
  
   lblArea = new JLabel ("Área");
   lblArea.setFont(new Font("Monospaced", Font.ITALIC, 15));
   lblArea.setForeground(Color.BLACK);

   lblNivel = new JLabel ("Nivel");
   lblNivel.setFont(new Font("Monospaced", Font.ITALIC, 15));
   lblNivel.setForeground(Color.BLACK);


   btnAlterar = new JButton ("Alterar");
   btnAlterar.setForeground(Color.BLACK);
   Color altera= new Color(207,207,207);
   btnAlterar.setBackground(altera);
   
   btnSair = new JButton ("Sair");
   btnSair.setForeground(Color.BLACK);
   Color sair= new Color(225,119,119);
   btnSair.setBackground(sair);
   
   jComboArea = new JComboBox<>();
   jComboArea.setForeground(Color.BLACK);
   Color a= new Color(207,207,207);
   jComboArea.setBackground(a);

   jComboNivel = new JComboBox<>();
   jComboNivel.setForeground(Color.BLACK);
   Color n= new Color(207,207,207);
   jComboNivel.setBackground(n);
   
   //mascara data de CPF
     
      try {
         txtCpf.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("###.###.###-##")));
      } 
      catch (ParseException ex) {
         ex.printStackTrace();
      }  
 
   Container alteraNivel = getContentPane(); 
   alteraNivel.setLayout( new GridLayout(3,1)); 
   
   JPanel linha1 = new JPanel (new BorderLayout());
   JPanel linha2 = new JPanel (new FlowLayout());
   JPanel linha3 = new JPanel (new FlowLayout());
   
   
      linha1.add(lblTitulo,BorderLayout.CENTER);
      linha2.add(lblCpf);
      linha2.add(txtCpf);
      linha2.add(lblNivel);
      linha2.add(jComboNivel);
      linha2.add(lblArea);
      linha2.add(jComboArea);
      linha3.add(btnSair);
      linha3.add(btnAlterar);
   
   
   
      add(linha1);
      Color l1 = new Color(154,233,233);
      linha1.setBackground(l1);
      add(linha2);
      Color l2 = new Color(154,233,233);
      linha2.setBackground(l2);
      add(linha3);
      Color l3 = new Color(154,233,233);
      linha3.setBackground(l3);
   
 
      jComboArea.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Financeiro", "Pedagógica","Departamento Pessoal","Infra-estrutura","Outros"}));
      jComboArea.setToolTipText(""); 
      
      jComboNivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"0-Colaborador","1-Avaliador","2-Superior"}));
      jComboNivel.setToolTipText("");             
            
      setResizable(false);
      setVisible(true);
      setSize(613,236);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);
     
     
     //Events
      jComboArea.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
               jComboAreaActionPerformed(evt);
            }
         }); 
      
      jComboNivel.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
               jComboNivelActionPerformed(evt);
            }
         }); 
      
     btnSair.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
               btnSairActionPerformed(evt);
            }
         });
       
       btnAlterar.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
               btnAlterarActionPerformed(evt);
            }
         });  
         
      UIManager.getDefaults().put("OptionPane.background",new Color(154,233,233));
      UIManager.put ("Panel.background", new Color(154,233,233)); 
 
 }//Fim Construtor
 
 
 
   private void jComboAreaActionPerformed(ActionEvent evt) { } 
   
   
   
   private void jComboNivelActionPerformed(ActionEvent evt) { } 
   
   
   
   
   public void btnSairActionPerformed(ActionEvent evt){
      dispose();
      Login login = new Login();
      login.setVisible(true);
         
   }
   
   public void btnAlterarActionPerformed(ActionEvent evt){
      CadastraAvaliador cadastraAvaliador = new CadastraAvaliador(txtCpf.getText(), String.valueOf(jComboNivel.getSelectedItem()),
      String.valueOf(jComboArea.getSelectedItem()));
      cadastraAvaliador.alterarLogin();
   }
 
   public static void main (String [] args ){
      new TelaAdm();
   
   
   }
}
