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
import java.util.ArrayList;
import utili.*;


public class TelaSuperior extends JFrame{
   private JButton btnNext, btnVoltar, btnSair,btnEditar,btnDevolutivas,btnAprovadas,btnRanking;
   private JLabel lblTitulo,lblRecentes,lblLogado;
   private JLabel logo;
   private JTextField txtNome,txtArea;
   private  JFormattedTextField txtData;
   private JComboBox<String>jComboArea;
   private String logador;
   private int idLogin, pontero;
   private JEditorPane editorPane;
   
   public TelaSuperior(int idLogin)  {
      super("Tela Inicial - Superior");
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
      Color editar = new Color(207,207,207);
      btnEditar.setBackground(editar);
      btnDevolutivas = new JButton("Consultar indice de devolutivas");
      btnDevolutivas.setForeground(Color.BLACK);
      Color devolutivas= new Color(207,207,207);
      btnDevolutivas.setBackground(devolutivas);
      btnAprovadas = new JButton("Consultar sugestões aprovadas");
      btnAprovadas.setForeground(Color.BLACK);
      Color aprovadas= new Color(207,207,207);
      btnAprovadas.setBackground(aprovadas);
      btnRanking = new JButton("Ranking Colaboradores ");
      btnRanking.setForeground(Color.BLACK);
      Color Ranking= new Color(207,207,207);
      btnRanking.setBackground(Ranking);
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
      caixaTelaAvaliador.setBackground(Color.GRAY);
      
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
      Color linha1 = new Color(154,233,233);
      pnlLinha1.setBackground(linha1);
      pnlLinha2.add(lblTitulo);
      Color linha2 = new Color(154,233,233);
      pnlLinha2.setBackground(linha2);
              
      pnlLinhalogador.add(lblLogado);
      Color linhalogador = new Color(154,233,233);
      pnlLinhalogador.setBackground(linhalogador);
      pnlLinha3.add(txtNome);
      Color linha3 = new Color(154,233,233);
      pnlLinha3.setBackground(linha3);
      pnlLinha5.add(txtArea);
      Color linha5 = new Color(154,233,233);
      pnlLinha5.setBackground(linha5);
      pnlLinha4.add(txtData);
      Color linha4 = new Color(154,233,233);
      pnlLinha4.setBackground(linha4);
      recente.add(lblRecentes,BorderLayout.WEST);
      Color recente1 = new Color(154,233,233);
      recente.setBackground(recente1); 
      pnlLinha6.add(btnVoltar); 
      pnlLinha6.add(btnNext);
      Color linha6 = new Color(154,233,233);
      pnlLinha6.setBackground(linha6);
    
      caixa1.add(pnlLinhalogador,BorderLayout.EAST);
      caixa1.add(pnlLinha1,BorderLayout.WEST);  
      caixa2.add(pnlLinha3,BorderLayout.WEST);
      caixa2.add(pnlLinha5,BorderLayout.CENTER);
      caixa2.add(pnlLinha4,BorderLayout.EAST);
      caixa3.add(editorScrollPane);
      caixaTitulo.add(pnlLinha2,BorderLayout.NORTH);
      caixa4.add(pnlLinha6,BorderLayout.NORTH);
      caixa5.add(recente,BorderLayout.SOUTH);     
      
           
      pnlSul.add(btnSair);
      pnlSul.add(btnEditar);
      pnlSul.add(btnAprovadas);
      pnlSul.add(btnDevolutivas);
      pnlSul.add(btnRanking);
      Color sul = new Color(154,233,233);
      pnlSul.setBackground(sul);
      pnlSul2.add(pnlSul,BorderLayout.SOUTH);
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
      
      setResizable(false);            
      editorPane.setEditable(false);
      txtNome.setEditable(false);
      txtArea.setEditable(false);
      txtData.setEditable(false);
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
        
        btnRanking.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
               btnRankingActionPerformed(evt);
            }
        }); 
        
        
        btnAprovadas.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
               btnAprovadasActionPerformed(evt);
            }
        });
        
        btnDevolutivas.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnDevolutivasActionPerformed(evt);
            }
        });    
      
      UIManager.getDefaults().put("OptionPane.background",new Color(154,233,233));
      UIManager.put ("Panel.background", new Color(154,233,233));
      
   }//Fim Construtor 
   
 
  ConectaBanco c = new ConectaBanco();
  CarregaSugestao s = new CarregaSugestao();
     
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
   
   
    public void btnDevolutivasActionPerformed(ActionEvent evt){
         ConectaBanco conectaBanco = new ConectaBanco();
      
        try{
            conectaBanco.conecta();
            conectaBanco.executaSQL("select \n" +
            "    count(val.estado) as 'total', val.estado\n" +
            "    from sugestao sug\n" +
            "		inner join validacao val on (sug.validacao_id_validacao = val.id_validacao)\n" +
            "        where val.estado > 0 \n" +
            "        group by val.estado;" );
            
            conectaBanco.rs.first();
            
            int aprov = conectaBanco.rs.getInt("total");
            conectaBanco.rs.next();
            int repro = conectaBanco.rs.getInt("total");
      
            
            JLabel aprovadas, reprovadas, titulo;

            JPanel p = new JPanel( new GridLayout(3,1));
            
            titulo = new JLabel("Indice de aprovações");
            aprovadas = new JLabel("Sugestões aprovadas: " + aprov );
            reprovadas = new JLabel("Sugestões Reprovadas: " + repro);
            
            p.add(titulo);
            p.add(aprovadas);
            p.add(reprovadas);
            
            JOptionPane.showMessageDialog(this, p ,"Indice de aprovações",JOptionPane.PLAIN_MESSAGE);

         }catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Indices não Localizados");
              
            
         }finally {
           conectaBanco.desconecta();
                
         }
    }
   
   public void btnAprovadasActionPerformed(ActionEvent evt){
        ConectaBanco conectaBanco = new ConectaBanco();
   
        ArrayList <Aprovadas> dados = new ArrayList <>();
                  
        try {
            conectaBanco.conecta();
            conectaBanco.executaSQL("select dep.nome_departamento as 'departamento', \n" +
            "        count(val.estado) as 'total'\n" +
            "    from sugestao	sug\n" +
            "		inner join validacao val on (val.id_validacao = sug.validacao_id_validacao)\n" +
            "		inner join departamento dep on (dep.id_departamento = sug.departamento_id_departamento) \n" +
            "		where val.estado = 1\n" +
            "			group by (dep.nome_departamento);");
             conectaBanco.rs.first();
               
            do{
                Aprovadas aprovadas = new Aprovadas(conectaBanco.rs.getString("departamento"), conectaBanco.rs.getInt("total") );
               
                dados.add(aprovadas);
                
                
            }while(conectaBanco.rs.next());
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
        }finally  {
        
         conectaBanco.desconecta();
         }
        
        
        String [] colunas = {"Area","Quant. de sugestões Aprovadas"};
        String[][] saida = new String[dados.size()][colunas.length];
        Aprovadas aprovadas;
        for(int i = 0; i < dados.size(); i++){
         aprovadas = dados.get(i);
         saida[i][0] = dados.get(i).getArea();
         saida[i][1] = dados.get(i).getQuantidade() + "";

      }
      
         JTable jTableMural;
         JScrollPane jScrollPane1;
         jTableMural = new JTable(saida, colunas);
         jScrollPane1 = new JScrollPane();
         
         Color linha3 = new Color(154,233,233);
         jTableMural.setBackground(linha3);
         
         jScrollPane1.setViewportView(jTableMural);        
        
   
      JOptionPane.showMessageDialog(this, jScrollPane1 ,"Ranking",JOptionPane.PLAIN_MESSAGE);
   }   
      
   public void btnRankingActionPerformed(ActionEvent evt){
      ConectaBanco conectaBanco = new ConectaBanco();
      
        ArrayList <Ranking> dados = new ArrayList<>();
                          
        try {
            conectaBanco.conecta();
            conectaBanco.executaSQL("select \n" +
            "    cadastro.nome,\n" +
            "    count(sugestao.login_id_login) as 'total'\n" +
            "    from sugestao\n" +
            "		inner join login on (login.id_login = sugestao.login_id_login)\n" +
            "        inner join cadastro on(login.id_login = cadastro.login_id_login)\n" +
            "        group by(login.id_login)\n" +
            "			order by (sugestao.login_id_login);");
             conectaBanco.rs.first();
            
            do{
            
                Ranking ranking = new Ranking(conectaBanco.rs.getString("nome"), conectaBanco.rs.getInt("total") );
                dados.add(ranking);
                
                
            }while(conectaBanco.rs.next());
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
        }finally  {
        
         conectaBanco.desconecta();
         }
         
         
         String [] colunas = {"Nome","Quant. de Sugestões enviadas"};
         String[][] saida = new String[dados.size()][colunas.length];
         
         for(int i = 0; i < dados.size(); i++){
            saida[i][0] = dados.get(i).getNome();
            saida[i][1] = dados.get(i).getQuantidade() + "";
   
         }

                 
            
         JTable jTableMural;
         JScrollPane jScrollPane1;
         jTableMural = new JTable(saida, colunas);
         jScrollPane1 = new JScrollPane();
         
         Color linha3 = new Color(154,233,233);
         jTableMural.setBackground(linha3);
         
         jScrollPane1.setViewportView(jTableMural);
      
         
         
         
   
      JOptionPane.showMessageDialog(this, jScrollPane1 ,"Ranking de colaboradores",JOptionPane.PLAIN_MESSAGE);      
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
      new TelaSuperior(2);
   
   }

}


