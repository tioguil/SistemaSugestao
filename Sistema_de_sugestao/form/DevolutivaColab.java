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


public class DevolutivaColab extends JFrame{
   private JButton btnNext, btnVoltar, btnPrincipal;
   private JLabel lblTitulo,lblMinhas,lblArea ,lblMinhaData,lblRespondida,lblData,lblAprovacao;
   private JLabel logo;
   private JTextField txtArea, txtMinhaData , txtData, txtAprovacao;
   private JEditorPane editorPergunta,editorResposta;
   private int idLogin, pontero;
   private DateFormat formatter;
   
   CarregaDevolutivas d = new CarregaDevolutivas();
        
   public DevolutivaColab(int idLogin)  {
      super("Tela Inicial");
      this.idLogin = idLogin;
      lblTitulo  = new JLabel("Devolutivas");
      lblTitulo.setFont(new Font("Monospaced", Font.ITALIC, 20));
      lblTitulo.setForeground(Color.BLACK);
      
      lblMinhas = new JLabel ("Minhas sugestões: ");
      lblMinhas.setFont(new Font("Monospaced", Font.ITALIC, 15));
      lblMinhas.setForeground(Color.BLACK);  
      
      lblArea = new JLabel ("Área sugerida:");
      lblArea.setFont(new Font("Monospaced", Font.ITALIC, 15));
      lblArea.setForeground(Color.BLACK); 
      
      txtArea = new JTextField (20);
      txtMinhaData = new JTextField (20);
      txtData = new JTextField(20);
      txtAprovacao = new JTextField(20);
      
      lblMinhaData = new JLabel ("Data: ");
      lblMinhaData.setFont(new Font("Monospaced", Font.ITALIC, 15));
      lblMinhaData.setForeground(Color.BLACK); 
      
      lblRespondida = new JLabel ("Sugestões avaliadas: ");
      lblRespondida.setFont(new Font("Monospaced", Font.ITALIC, 15));
      lblRespondida.setForeground(Color.BLACK); 
      
      lblData = new JLabel ("Data: ");
      lblData.setFont(new Font("Monospaced", Font.ITALIC, 15));
      lblData.setForeground(Color.BLACK); 
   
      lblAprovacao = new JLabel ("Validação: ");
      lblAprovacao.setFont(new Font("Monospaced", Font.ITALIC, 15));
      lblAprovacao.setForeground(Color.BLACK); 
   
      btnNext = new JButton();
      btnNext.setIcon(new ImageIcon(getClass().getResource("/img/direita.png")));
      Color ir = new Color(154,233,233);
      btnNext.setBackground(ir);
      
      btnVoltar = new JButton();
      btnVoltar.setIcon(new ImageIcon(getClass().getResource("/img/seta.png")));
      Color voltar = new Color(154,233,233);
      btnVoltar.setBackground(voltar);
      
      btnPrincipal = new JButton("Voltar para tela principal");
      btnPrincipal.setForeground(Color.BLACK);
      Color voltaP = new Color(225,119,119);
      btnPrincipal.setBackground(voltaP);
      
      editorPergunta = new JEditorPane();
      JScrollPane scrollPergunta = new JScrollPane(editorPergunta);
      scrollPergunta.setPreferredSize(new Dimension(500,80));
      
      editorResposta = new JEditorPane();
      JScrollPane scrollResposta = new JScrollPane(editorResposta);
      scrollResposta.setPreferredSize(new Dimension(500,80));
      
      formatter = new SimpleDateFormat("dd/MM/yyyy");
   
    //mascara data de nascimento
      /*try {
         txtData.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/####")));
      } 
      catch (ParseException ex) {
         ex.printStackTrace();
      }  */
   
   
      Container caixaDevolutivas = getContentPane(); 
      caixaDevolutivas.setLayout( new GridLayout(7,1)); 
      
      Color cX= new Color(154,233,233);
      caixaDevolutivas.setBackground(cX);
      
      JPanel linha1 = new JPanel (new BorderLayout());
      JPanel linha2 = new JPanel (new FlowLayout()); 
      JPanel linha3 = new JPanel (new BorderLayout());
      JPanel campo1 = new JPanel (new FlowLayout());
      JPanel linha4 = new JPanel (new FlowLayout());
     
      JPanel linha5 = new JPanel (new BorderLayout());
      JPanel campo2 = new JPanel (new FlowLayout());
      
      JPanel linha6 = new JPanel (new FlowLayout());
      JPanel campo3 = new JPanel (new FlowLayout());
      JPanel campoPrincipal = new JPanel (new FlowLayout());
      JPanel linha7 = new JPanel (new FlowLayout());
      logo = new JLabel();
      logo.setIcon(new ImageIcon(getClass().getResource("/img/logo.png")));
      
      
      
      linha1.add(logo,BorderLayout.NORTH);
      linha2.add(lblTitulo);
      Color l2= new Color(154,233,233);
      linha2.setBackground(l2);
      linha1.add(linha2);
      Color l1= new Color(154,233,233);
      linha1.setBackground(l1);
      
      
      linha3.add(lblMinhas,BorderLayout.NORTH);
      Color l3= new Color(154,233,233);
      linha3.setBackground(l3);
      
            
      campo1.add(lblArea);
      campo1.add(txtArea);
      campo1.add(lblMinhaData);
      campo1.add(txtMinhaData);
      Color c1= new Color(154,233,233);
      campo1.setBackground(c1);
      linha3.add(campo1);   
      
      linha4.add(scrollPergunta);
      Color l4= new Color(154,233,233);
      linha4.setBackground(l4);
      
    
      linha5.add(lblRespondida,BorderLayout.NORTH);
      Color l5= new Color(154,233,233);
      linha5.setBackground(l5);
      campo2.add(lblData);
      campo2.add(txtData);
      campo2.add(lblAprovacao);
      campo2.add(txtAprovacao);
      Color c2= new Color(154,233,233);
      campo2.setBackground(c2);
      linha5.add(campo2);
      
      linha6.add(scrollResposta);
      Color l6= new Color(154,233,233);
      linha6.setBackground(l6);
      
      
      campo3.add(btnVoltar);
      campo3.add(btnNext);
      Color c3= new Color(154,233,233);
      campo3.setBackground(c3);
      linha7.add(campo3); 
      Color l7= new Color(154,233,233);
      linha7.setBackground(l7);
     
      campoPrincipal.add(btnPrincipal);
      Color cP= new Color(154,233,233);
      campoPrincipal.setBackground(cP);
     
      add(linha1);
      add(linha3);
      add(linha4);
      add(linha5);
      add(linha6);   
      add(linha7);
      add(campoPrincipal);
      
            
      setVisible(true);
      setSize(715,513);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);
      
      //Eventos *********************
      
      btnNext.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
               btnNextActionPerformed(evt);
            }
         });
        
      btnVoltar.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
               btnVoltarActionPerformed(evt);
            }
         });
        
      btnPrincipal.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
               btnPrincipalActionPerformed(evt);
            }
         });
      
      setResizable(false);
      txtArea.setEditable(false);
      txtMinhaData.setEditable(false);
      txtData.setEditable(false);
      txtAprovacao.setEditable(false);
      editorPergunta.setEditable(false);
      editorResposta.setEditable(false);
      
   }//Fim Construtor
  
  
   
   
   public void carregar(){
      
      d.carregaDados(idLogin);
      
      SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
      //String dataEnvio  =  f.format(d.getDevolutiva(pontero).getDataEnvio());
      //String DataResposta = f.format(d.getDevolutiva(pontero).getDataResposta());
      
      
      txtArea.setText(d.getDevolutiva(pontero).getArea());
      txtMinhaData.setText(f.format(d.getDevolutiva(pontero).getDataEnvio()));
      editorPergunta.setText(d.getDevolutiva(pontero).getSugestao());
      txtAprovacao.setText(d.getDevolutiva(pontero).getEstado());
      
      
      txtData.setText(f.format(d.getDevolutiva(pontero).getDataResposta()));    
      editorResposta.setText(d.getDevolutiva(pontero).getDevolutiva());

      
      
      
   }
  
  
  
  
  
  // Metodos Butons
  
   private void btnNextActionPerformed(ActionEvent evt){
      
      
      if(pontero < d.getQuantidadeDeDevolutivas() - 1){
         pontero++;
      }
      
      SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
      //String dataEnvio  =  f.format(d.getDevolutiva(pontero).getDataEnvio());
      String DataResposta = f.format(d.getDevolutiva(pontero).getDataResposta());
      
      
      txtArea.setText(d.getDevolutiva(pontero).getArea());
      txtMinhaData.setText(f.format(d.getDevolutiva(pontero).getDataEnvio()));
      editorPergunta.setText(d.getDevolutiva(pontero).getSugestao());
      txtAprovacao.setText(d.getDevolutiva(pontero).getEstado());
      editorResposta.setText(d.getDevolutiva(pontero).getDevolutiva());
      txtData.setText(DataResposta);    
      
      
      
   
   }
   
   private void btnVoltarActionPerformed(ActionEvent evt){
      
      if(pontero > 0){
         pontero--;
      }
      
      SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
      //String dataEnvio  =  f.format(d.getDevolutiva(pontero).getDataEnvio());
      //String DataResposta = f.format(d.getDevolutiva(pontero).getDataResposta());
      
      
      txtArea.setText(d.getDevolutiva(pontero).getArea());
      txtMinhaData.setText(f.format(d.getDevolutiva(pontero).getDataEnvio()));
      editorPergunta.setText(d.getDevolutiva(pontero).getSugestao());
      txtAprovacao.setText(d.getDevolutiva(pontero).getEstado());
      
      
      txtData.setText(f.format(d.getDevolutiva(pontero).getDataResposta()));    
      editorResposta.setText(d.getDevolutiva(pontero).getDevolutiva());
      
      
      
   }
   
   private void btnPrincipalActionPerformed(ActionEvent evt){
      TelaColaborador colaborador = new TelaColaborador(idLogin);
      colaborador.setVisible(true);
      colaborador.carregar();
      
      setVisible(false);   
   }
    
  
   public static void main (String args [] ){
   
   new DevolutivaColab(1);
   
   }
}