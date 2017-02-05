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
import java.sql.PreparedStatement;
import utili.*;



public class TelaValidacao extends JFrame{
   private JButton btnNext, btnVoltar, btnPrincipal,btnResponder, btnCarregar;
   private JLabel lblTitulo,lblMinhas,lblArea ,lblMinhaData,lblRespondida,lblData,lblAprovacao;
   private JLabel logo;
   private JTextField txtArea, txtMinhaData;
   private JEditorPane editorPergunta,editorResposta;
   private int idLogin, pontero;
   private DateFormat formatter;
   private JComboBox jComboAprovacao;
   
        
   public TelaValidacao(int idLogin)  {
      super("TIP HERE - Validacao");
      this.idLogin = idLogin;
      lblTitulo  = new JLabel("Área de Avaliação");
      lblTitulo.setFont(new Font("Monospaced", Font.ITALIC, 20));
      lblTitulo.setForeground(Color.BLACK);
      
      lblMinhas = new JLabel ();
      lblMinhas.setFont(new Font("Monospaced", Font.ITALIC, 15));
      lblMinhas.setForeground(Color.BLACK);  
      
      lblArea = new JLabel ("Área sugerida:");
      lblArea.setFont(new Font("Monospaced", Font.ITALIC, 15));
      lblArea.setForeground(Color.BLACK); 
      
      txtArea = new JTextField (20);
      txtMinhaData = new JTextField (10);
     
      
      
      jComboAprovacao = new JComboBox<>();
      jComboAprovacao.setPreferredSize(new Dimension(100,20));
      jComboAprovacao.setForeground(Color.BLACK);
      Color n= new Color(207,207,207);
      jComboAprovacao.setBackground(n);
      
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
      
      btnResponder = new JButton("Responder");
      Color responda = new Color(207,207,207);
      btnResponder.setBackground(responda);
      
      btnCarregar = new JButton("Carregar");
      btnCarregar.setBackground(responda);
      
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
      
      campo2.add(lblAprovacao);
      campo2.add(jComboAprovacao);
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
      campoPrincipal.add(btnCarregar);
      campoPrincipal.add(btnResponder);
      
      
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
      
      btnCarregar.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
               btnCarregarActionPerformed(evt);
            }
         });
      
      jComboAprovacao.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
               jComboAprovacaoActionPerformed(evt);
            }
         }); 
      

      
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
         
      btnResponder.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnResponderActionPerformed(evt);
            }
       });   
         
         
      jComboAprovacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"1-Aprovado","2-Reprovado"}));
      jComboAprovacao.setToolTipText("");    
      
      setResizable(false);
      txtArea.setEditable(false);
      txtMinhaData.setEditable(false);
     
      editorPergunta.setEditable(false);
      //editorResposta.setEditable(false);
      
   }//Fim Construtor
   CarregaRespostas r = new CarregaRespostas();
   
   public void carregar(){
      
      r.carregaArray(idLogin);
      
                
      
      if(r.getSemSugestao()){
      this.pontero = 0;
      lblMinhas.setText("Autor da sugestao: " + r.getRespostas(pontero).getNome());
      txtArea.setText(r.getRespostas(pontero).getNomeArea());
      editorPergunta.setText(r.getRespostas(pontero).getSugestao());
      SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
      String data  =  f.format(r.getRespostas(pontero).getDataEnvio());
      txtMinhaData.setText(data);
      }
      
   
   }
  
  // Metodos e Butons
  
    private void btnCarregarActionPerformed(ActionEvent evt){
    
      ConectaBanco conectaBanco = new ConectaBanco();
      
      int idDep = 0;
      
      try{
         conectaBanco.conecta();
         conectaBanco.executaSQL("select departamento_id_departamento from avaliador where login_id_login = " + idLogin);
         conectaBanco.rs.first();
         idDep = conectaBanco.rs.getInt("departamento_id_departamento");
         
         
      
      }catch(SQLException ex){
         JOptionPane.showMessageDialog(null, "Erro: " + ex);
         
      }finally {
              conectaBanco.desconecta();
        }
    
       r.carregaDados(idLogin, idDep);
       carregar();
      
    }
  
    private void jComboAprovacaoActionPerformed(ActionEvent evt){

    }
    
    private void btnResponderActionPerformed(ActionEvent evt){
      
         ConectaBanco conectaBanco = new ConectaBanco();
                  
         Date hoje = new Date();
                  
         String aprovado = "";
         if(String.valueOf(jComboAprovacao.getSelectedItem()).equals("1-Aprovado")){
            aprovado = "1";
         }else {
            aprovado = "2";
         }
         
                                       
     boolean retorno = r.Responder(idLogin, aprovado, editorResposta.getText(), r.getRespostas(pontero).getIdValidacao());
      if(retorno){
         r.deletaArray(pontero);
         lblMinhas.setText("Autor da sugestao: ");
         txtArea.setText("");
         editorPergunta.setText("");
         txtMinhaData.setText("");         
         editorResposta.setText("");
         carregar();
         
      }      
      
    }

  
   private void btnNextActionPerformed(ActionEvent evt){
      
      if(pontero < r.getQuantidadeDeRespostas() - 1){
         pontero++;
      }     
      
      lblMinhas.setText("Autor da sugestao: " + r.getRespostas(pontero).getNome());
      txtArea.setText(r.getRespostas(pontero).getNomeArea());
      editorPergunta.setText(r.getRespostas(pontero).getSugestao());
      SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
      String data  =  f.format(r.getRespostas(pontero).getDataEnvio());
      txtMinhaData.setText(data);
   
   }
   
   private void btnVoltarActionPerformed(ActionEvent evt){
      
      if(pontero > 0){
         pontero--;
      }
           
      lblMinhas.setText("Autor da sugestao: " + r.getRespostas(pontero).getNome());
      txtArea.setText(r.getRespostas(pontero).getNomeArea());
      editorPergunta.setText(r.getRespostas(pontero).getSugestao());
      SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
      String data  =  f.format(r.getRespostas(pontero).getDataEnvio());
      txtMinhaData.setText(data);
   }
   
   private void btnPrincipalActionPerformed(ActionEvent evt){
        
         setVisible(false);
         TelaAvaliador avaliador = new TelaAvaliador(idLogin);
         avaliador.setVisible(true);
         avaliador.carregar();   
      
     }    
  
   public static void main (String args [] ){
   
   new TelaValidacao(1);
   
   }
}