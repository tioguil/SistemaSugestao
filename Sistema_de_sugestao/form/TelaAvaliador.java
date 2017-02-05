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


public class TelaAvaliador extends JFrame{
   private JButton btnNext, btnVoltar, btnSair,btnEditar,btnValidar, btnIndice, btnConsultar;
   private JLabel lblTitulo,lblRecentes,lblData,lblLogado;
   private JLabel logo;
   private JTextField txtNome,txtArea;
   private  JFormattedTextField txtData;
   private JComboBox<String>jComboArea;
   private int idLogin, pontero;
   private JEditorPane editorPane;
 
   public TelaAvaliador(int idLogin)  {
      super("Tela Inicial - Avaliador");
      this.idLogin = idLogin;
      lblTitulo  = new JLabel("Bem vindo ao Sistema de Sugestões");
      lblTitulo.setFont(new Font("Monospaced", Font.ITALIC, 24));
      lblTitulo.setForeground(Color.BLACK);
      lblLogado = new JLabel ();
      lblLogado.setFont(new Font("Monospaced", Font.ITALIC, 17));
      lblRecentes = new JLabel ("Sugestões Recentes:");
      lblRecentes.setFont(new Font("Monospaced", Font.ITALIC, 17));
      lblRecentes.setForeground(Color.BLACK); 
      txtNome = new JTextField(20);
      txtArea = new JTextField(20);
      lblData = new JLabel ("Data Sugestão");
      txtData = new JFormattedTextField();
      txtData.setPreferredSize(new Dimension(80,20));
      btnNext = new JButton();
      btnNext.setIcon(new ImageIcon(getClass().getResource("/img/direita.png")));
      Color ir = new Color(154,233,233);
      btnNext.setBackground(ir);
      btnVoltar = new JButton();
      btnVoltar.setIcon(new ImageIcon(getClass().getResource("/img/seta.png")));
      Color voltar = new Color(154,233,233);
      btnVoltar.setBackground(voltar);
   
      btnSair = new JButton("Sair");
      btnSair.setForeground(Color.BLACK);
      Color sair = new Color(225,119,119);
      btnSair.setBackground(sair);
      
      btnEditar = new JButton("Editar meu Perfil");
      btnEditar.setForeground(Color.BLACK);
      Color edit= new Color(207,207,207);
      btnEditar.setBackground(edit);

      btnIndice = new JButton("Consultar indice de aprovação");
      btnIndice.setForeground(Color.BLACK);
      Color aprova= new Color(207,207,207);
      btnIndice.setBackground(aprova);

      btnValidar = new JButton("Validar Sugestões");
      btnValidar.setForeground(Color.BLACK);
      Color valida= new Color(207,207,207);
      btnValidar.setBackground(valida);

      btnConsultar = new JButton("Consultar Participação");
      btnConsultar.setForeground(Color.BLACK);
      Color consulta = new Color(207,207,207);
      btnConsultar.setBackground(consulta);

      
      editorPane = new JEditorPane();
      JScrollPane editorScrollPane = new JScrollPane(editorPane);
      editorScrollPane.setPreferredSize(new Dimension(800,70));
   
    //mascara data de nascimento
      try {
         txtData.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/####")));
      } 
      catch (ParseException ex) {
         ex.printStackTrace();
      }  
   
   
      Container caixaTelaAvaliador = getContentPane(); 
      caixaTelaAvaliador.setLayout( new GridLayout(7,1));
      
      
          
      
      
      logo = new JLabel();
      logo.setIcon(new ImageIcon(getClass().getResource("/img/logo.png")));
      //1ªLinha
      JPanel pnlLinha1 = new JPanel ( new FlowLayout());
      JPanel pnlLinhalogador = new JPanel ( new FlowLayout());
      JPanel caixa1 = new JPanel ( new BorderLayout());
      JPanel pnlLinha2 = new JPanel ( new FlowLayout());
      JPanel caixaTitulo = new JPanel(new BorderLayout());
      
      //2ºLinha
      JPanel pnlLinha3 = new JPanel ( new GridLayout(3,3));
      JPanel pnlLinha4 = new JPanel ( new GridLayout(3,3));
      JPanel pnlLinha5 = new JPanel ( new GridLayout(3,3));
      JPanel caixa2 = new JPanel ( new FlowLayout());
      // 3ª Linha
      JPanel recente = new JPanel (new BorderLayout());
      JPanel caixa5 = new JPanel(new BorderLayout());
      
      // 4ªlinha
           
      JPanel caixa3 = new JPanel ( new FlowLayout());
                 
      //5ª Linha
      JPanel pnlLinha6 = new JPanel ( new FlowLayout());
      JPanel caixa4 = new JPanel ( new FlowLayout());
     //6ªLinha
      JPanel pnlSul = new JPanel(new FlowLayout ());
      JPanel pnlSul2 = new JPanel (new BorderLayout());
     
   
      pnlLinha1.add(logo);
       Color l1= new Color(154,233,233);
                 pnlLinha1.setBackground(l1);
      pnlLinha2.add(lblTitulo);
       Color l2= new Color(154,233,233);
                 pnlLinha2.setBackground(l2);
      caixa1.add(pnlLinha1,BorderLayout.WEST);
      caixaTitulo.add(pnlLinha2,BorderLayout.NORTH);
      
      pnlLinhalogador.add(lblLogado);
      Color linhalogador = new Color(154,233,233);
      pnlLinhalogador.setBackground(linhalogador);
      
      pnlLinha3.add(txtNome);
      Color l3= new Color(154,233,233);
      pnlLinha3.setBackground(l3);
      pnlLinha5.add(txtArea);
      Color l5= new Color(154,233,233);
      pnlLinha5.setBackground(l5);
      pnlLinha4.add(txtData);
      Color l4= new Color(154,233,233);
      pnlLinha4.setBackground(l4);
      
      caixa2.add(pnlLinha3,BorderLayout.WEST);
      caixa2.add(pnlLinha5,BorderLayout.CENTER);
      caixa2.add(pnlLinha4,BorderLayout.EAST);
     
   
      recente.add(lblRecentes,BorderLayout.WEST);
      Color r= new Color(154,233,233);
      recente.setBackground(r);
      caixa5.add(recente,BorderLayout.SOUTH);
        
   
      caixa3.add(editorScrollPane);
      
      
      pnlLinha6.add(btnVoltar); 
      pnlLinha6.add(btnNext);
      Color l6 = new Color(154,233,233);
      pnlLinha6.setBackground(l6);
      caixa4.add(pnlLinha6,BorderLayout.NORTH);
        
      pnlSul.add(btnSair);
      pnlSul.add(btnEditar);
      pnlSul.add(btnIndice);
      pnlSul.add(btnConsultar);
      pnlSul.add(btnValidar);
      pnlSul2.add(pnlSul,BorderLayout.SOUTH); 
      
      caixa1.add(pnlLinhalogador,BorderLayout.EAST); 
      Color sul = new Color(154,233,233);
      pnlSul.setBackground(sul);      
      add(caixa1);
      Color c1 = new Color(154,233,233);
      caixa1.setBackground(c1);
      add(caixaTitulo);
      Color ct = new Color(154,233,233);
      caixaTitulo.setBackground(ct);
      add(caixa2);
      Color c2 = new Color(154,233,233);
      caixa2.setBackground(c2);
      add(caixa5);
      Color c5 = new Color(154,233,233);
      caixa5.setBackground(c5);
      add(caixa3);
      Color c3 = new Color(154,233,233);
      caixa3.setBackground(c3);
      add(caixa4);
      Color c4 = new Color(154,233,233);
      caixa4.setBackground(c4);
      add(pnlSul2);
      Color sul2 = new Color(154,233,233);
      pnlSul2.setBackground(sul2);
      
            
      editorPane.setEditable(false);
      txtNome.setEditable(false);
      txtArea.setEditable(false);
      txtData.setEditable(false);
      editorPane.setEditable(false); 
      setResizable(false);
      setVisible(true);
      setSize(830,600);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);
      
      //Eventos **********************
      
      
   
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
         
      btnSair.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
               btnSairActionPerformed(evt);
            }
         });
         
       btnEditar.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
               btnEditarActionPerformed(evt);
            }
        });
        
        
        btnIndice.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
               btnIndiceActionPerformed(evt);
            }
        });
        
        
        btnConsultar.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
               btnConsultarActionPerformed(evt);
            }
        });
        
       
       btnValidar.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
               btnValidarActionPerformed(evt);
            }
        });
          
   
      UIManager.getDefaults().put("OptionPane.background",new Color(154,233,233));
      UIManager.put ("Panel.background", new Color(154,233,233));
      
   }//Fim Construtor
   
  CarregaSugestao s = new CarregaSugestao();
  ConectaBanco c = new ConectaBanco();
   
   public void carregar(){

      try{
      c.conecta();
      c.executaSQL("select nome from cadastro where login_id_login =" + idLogin);
      c.rs.first();
      lblLogado.setText("Bem vindo " + c.rs.getString("nome"));
      }catch(SQLException ex){
         JOptionPane.showMessageDialog(null, "Erro: " + ex);
      }finally {
         c.desconecta();
      }
      
      
      s.coletaDoBanco();
   
      SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
      String data  =  f.format(s.getSugestao(pontero).getData());
      
      
      txtNome.setText(s.getSugestao(pontero).getNome());
      txtArea.setText(s.getSugestao(pontero).getArea());
      txtData.setText(data);
      editorPane.setText(s.getSugestao(pontero).getSugestao());
   }
   
   public void btnValidarActionPerformed(ActionEvent evt){
   
      setVisible(false);
      TelaValidacao telaValidacao = new TelaValidacao(idLogin);
      telaValidacao.setVisible(true);
      telaValidacao.carregar();
           
   
   }
   
   
   public void btnConsultarActionPerformed(ActionEvent evt){
      int idDep = 0, total;
      String nomeDep = "";
      ConectaBanco conectaBanco = new ConectaBanco();
      try{
            conectaBanco.conecta();
            conectaBanco.executaSQL("select de.nome_departamento, de.id_departamento\n" +
            "	from avaliador av\n" +
            "		inner join departamento de\n" +
            "			on de.id_departamento = av.departamento_id_departamento\n" +
            "				where av.login_id_login = " + idLogin);
            conectaBanco.rs.first();
            idDep = conectaBanco.rs.getInt("id_departamento");
            nomeDep = conectaBanco.rs.getString("nome_departamento");
            
            
            conectaBanco.executaSQL("select \n" +
            "        dep.id_departamento,\n" +
            "        dep.nome_departamento,\n" +
            "        count(id_departamento) as 'total'\n" +
            "        from sugestao sug \n" +
            "			inner join departamento dep on (dep.id_departamento = sug.departamento_id_departamento)\n" +
            "				where dep.id_departamento = " + idDep);
            
            conectaBanco.rs.first();
            total =  conectaBanco.rs.getInt("total");
            
            JPanel p = new JPanel( new GridLayout(2,1));
            JLabel consul, titulo;
            
            titulo = new JLabel("Total de sugestões enviadas para o departamento " + nomeDep);
            consul = new JLabel("Total : " + total ); 
            
            p.add(titulo);
            p.add(consul);
            
          JOptionPane.showMessageDialog(this, p ,"Consulta",JOptionPane.PLAIN_MESSAGE);


            
            
      }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Indices não Localizados");
              
            
       }finally {
           conectaBanco.desconecta();
                
       }   
   
   }
   
   
   private void btnIndiceActionPerformed(ActionEvent evt){
      
      ConectaBanco conectaBanco = new ConectaBanco();
      
      try{
         conectaBanco.conecta();
         conectaBanco.executaSQL("select \n" +
"val.estado,\n" +
"count(estado) as 'Contagem',\n" +
"(select format (count((estado) * 10) / (select count(estado) from validacao) * 100,2)) as 'Porcentagem'\n" +
"from validacao val\n" +
"	group by(estado)");
         conectaBanco.rs.first();
         double anali = conectaBanco.rs.getDouble("Porcentagem");
         conectaBanco.rs.next();
         double aprov = conectaBanco.rs.getDouble("Porcentagem");
         conectaBanco.rs.next();
         double reprov = conectaBanco.rs.getDouble("Porcentagem");
         
         
         
         conectaBanco.executaSQL("select count(id_validacao) as 'total'\n" +
"		from validacao val");
         conectaBanco.rs.first();
         int tot = conectaBanco.rs.getInt("total");
         
         
         JLabel analise, aprovadas, reprovadas, titulo, total;
      
      
         JPanel p = new JPanel( new GridLayout(5,1));
         
         titulo = new JLabel("Inice de aprovações");
         analise = new JLabel("Sugestões em analise: " + anali + "%");
         aprovadas = new JLabel("Sugestões aprovadas: " + aprov + "%");
         reprovadas = new JLabel("Sugestões reprovadas: " + reprov + "%");
         total = new JLabel("Total de sugestões enviadas: " + tot);
         
         //double analise = 0.0, aprovadas = 0.0, reprovadas = 0.0;
         //int total = 0;
         
         p.add(titulo);
         p.add(analise);
         p.add(aprovadas);
         p.add(reprovadas);
         p.add(total);
             
         
         JOptionPane.showMessageDialog(this, p ,"Indice de aprovações",JOptionPane.PLAIN_MESSAGE);
         
      
      
      }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Indices não Localizados");
              
            
       }finally {
           conectaBanco.desconecta();
                
       }
       
      
      
      
      
      
      
         
      
   }
        
   private void btnVoltarActionPerformed(ActionEvent evt) {
   
      if(pontero > 0){
         pontero--;
      }
      SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
      String data  =  f.format(s.getSugestao(pontero).getData());
   
      txtNome.setText(s.getSugestao(pontero).getNome());
      txtArea.setText(s.getSugestao(pontero).getArea());
      txtData.setText(data);
      editorPane.setText(s.getSugestao(pontero).getSugestao());
          
   		
      
   }
   
   private void btnNextActionPerformed(ActionEvent evt) {
      
      if(pontero < s.getQuantidadeDeSugestao() - 1){
         pontero++;
      }
      SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
      String data  =  f.format(s.getSugestao(pontero).getData());
          		
      txtNome.setText(s.getSugestao(pontero).getNome());
      txtArea.setText(s.getSugestao(pontero).getArea());
      txtData.setText(data);
      editorPane.setText(s.getSugestao(pontero).getSugestao());
          
   		 
      
   }
   
   private void btnSairActionPerformed(ActionEvent evt) {
      
        int opcao = JOptionPane.showConfirmDialog(null,"Deseja realmente sair?", "Atenção !", JOptionPane.YES_NO_OPTION);
        if(opcao == JOptionPane.YES_OPTION){
            System.exit(0);
        }            
           
   }
   
   private void btnEditarActionPerformed(ActionEvent evt){
      
      EditarPerfil editar = new EditarPerfil(idLogin);
      editar.setVisible(true);
      editar.carregar(idLogin);
      setVisible(false);
      
   }
 
   
   
   
   public static void main (String []CARGS){
      new TelaAvaliador(2);
   
   }

}


