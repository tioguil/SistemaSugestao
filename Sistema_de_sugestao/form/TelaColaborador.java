package form;
import java.awt.*;
import javax.swing.*;
import javax.swing.text.*;
import java.text.*;
import java.awt.event.*;
import javax.swing.JPanel;
import java.util.Date;
import java.sql.*;
import utili.*;


public class TelaColaborador extends JFrame{
   private JButton btnNext, btnVoltar, btnSair,btnEditar,btnDevolutivas,btnNovaSugestao;
   private JLabel lblTitulo,lblRecentes,lblData,lblGostei,lblNgostei;
   private JLabel logo, lblLogado, spaco;
   private JTextField txtNome,txtArea, txtData;
   //private  JFormattedTextField txtData;
   private ButtonGroup Grouplike;
   private JToggleButton toggleLike, toggleDislike;
   private JComboBox<String>jComboArea;
   private JEditorPane editorPane;
   private int idLogin, pontero;
   private String logador;
   
   private DateFormat formatter;
        
   public TelaColaborador(int idLogin)  {
      super("Tela Inicial - Colaborador ");
      this.idLogin = idLogin;
      lblTitulo  = new JLabel("Bem vindo ao Sistema de Sugestões");
      lblTitulo.setFont(new Font("Monospaced", Font.ITALIC, 24));
      lblTitulo.setForeground(Color.BLACK);
      lblLogado = new JLabel ();
      spaco = new JLabel ("                  ");
      lblLogado.setFont(new Font("Monospaced", Font.ITALIC, 17));
      lblRecentes = new JLabel ("Sugestões Recentes:");
      lblRecentes.setFont(new Font("Monospaced", Font.ITALIC, 17));
      lblRecentes.setForeground(Color.BLACK);   
      txtNome = new JTextField(20);
      txtArea = new JTextField(20);
      txtData = new JTextField();
      txtData.setPreferredSize(new Dimension(80,20));
      Grouplike = new ButtonGroup();
      lblGostei = new JLabel ();
      lblNgostei = new JLabel("     2");
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
      btnDevolutivas = new JButton("Devolutivas das suas Sugestões");
      btnDevolutivas.setForeground(Color.BLACK);  
      Color devolutivas= new Color(207,207,207);
      btnDevolutivas.setBackground(devolutivas);
      btnNovaSugestao = new JButton("Cadastrar nova Sugestão");
      btnNovaSugestao.setForeground(Color.BLACK);  
     
      Color nova= new Color(154,233,233);
      btnNovaSugestao.setBackground(devolutivas);
      
      toggleLike = new JToggleButton();
      toggleLike.setIcon(new ImageIcon(getClass().getResource("/img/gostei.png")));
      toggleDislike = new JToggleButton();
      toggleDislike.setIcon(new ImageIcon(getClass().getResource("/img/ngostei.png")));
      toggleLike.setForeground(Color.BLACK);
      toggleLike.setBackground(nova);
      toggleDislike.setForeground(Color.BLACK);
      toggleDislike.setBackground(nova);
      editorPane = new JEditorPane();
      JScrollPane editorScrollPane = new JScrollPane(editorPane);
      editorScrollPane.setPreferredSize(new Dimension(800,70));
      
      formatter = new SimpleDateFormat("dd/MM/yyyy");
   
    //mascara data de nascimento
      /*try {
         txtData.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/####")));
      } 
      catch (ParseException ex) {
         ex.printStackTrace();
      }  */
   
   
      Container caixaTelaColaborador = getContentPane(); 
      caixaTelaColaborador.setLayout( new GridLayout(7,1)); 
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
      Color l1 = new Color(154,233,233);
      pnlLinha1.setBackground(l1);
   
      pnlLinha2.add(lblTitulo);
      Color l2 = new Color(154,233,233);
      pnlLinha2.setBackground(l2);
   
      caixa1.add(pnlLinha1,BorderLayout.WEST);
      caixaTitulo.add(pnlLinha2,BorderLayout.NORTH);
       
      pnlLinhalogador.add(lblLogado);
      Color linhalogador = new Color(154,233,233);
      pnlLinhalogador.setBackground(linhalogador);
      
      pnlLinha3.add(txtNome);
      Color l3 = new Color(154,233,233);
      pnlLinha3.setBackground(l3);
      pnlLinha5.add(txtArea);
      Color l5 = new Color(154,233,233);
      pnlLinha5.setBackground(l5);
      pnlLinha4.add(txtData);
      Color l4 = new Color(154,233,233);
      pnlLinha4.setBackground(l4);
   
   
      caixa1.add(pnlLinhalogador,BorderLayout.EAST);
      
      caixa2.add(pnlLinha3);
      caixa2.add(pnlLinha5);
      caixa2.add(pnlLinha4);
        
      recente.add(lblRecentes,BorderLayout.WEST);
      Color r = new Color(154,233,233);
      recente.setBackground(r);
   
      caixa5.add(recente,BorderLayout.SOUTH);
   
      
      caixa3.add(editorScrollPane);
      
      
      pnlLinha6.add(btnVoltar); 
      pnlLinha6.add(btnNext);
      pnlLinha6.add(spaco);
      
      //Butons LIKE
      //Grouplike.add(toggleLike);
      //Grouplike.add(toggleDislike);
        
      
      Color l6 = new Color(154,233,233);
      pnlLinha6.setBackground(l6);
      pnlLinha6.add(lblGostei);
      pnlLinha6.add(toggleLike);
      pnlLinha6.add(lblNgostei);
      pnlLinha6.add(toggleDislike);
      caixa4.add(pnlLinha6,BorderLayout.NORTH);
        
      pnlSul.add(btnSair);
      pnlSul.add(btnEditar);
      pnlSul.add(btnDevolutivas);
      pnlSul.add(btnNovaSugestao);
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
      
      
      
      
      
      editorPane.setEditable(false);
      txtNome.setEditable(false);
      txtArea.setEditable(false);
      txtData.setEditable(false);
      editorPane.setEditable(false); 
      setResizable(false);
      setVisible(true);
      setSize(830,600);
      setDefaultCloseOperation(0);
      setLocationRelativeTo(null);
   
   
      UIManager.getDefaults().put("OptionPane.background",new Color(154,233,233));
      UIManager.put ("Panel.background", new Color(154,233,233));
      
      //Eventos **********************
      
      
            
      btnDevolutivas.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
               btnDevolutivasActionPerformed(evt);
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
        
      btnNovaSugestao.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
               btnNovaSugestaoActionPerformed(evt);
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
       
       toggleLike.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
               toggleLikeActionPerformed(evt);
            }
        });
       
       toggleDislike.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
               toggleDislikeActionPerformed(evt);
            }
        });
      
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
      verificaLike();
      contaLike();
      contaDisLike();
      
      
     }
         
   // Metodos Butons
   
   
   private void toggleDislikeActionPerformed(ActionEvent evt){
      
      try{
      
         
         
         
         if(verificaLike().equals("-1")){
            c.conecta();
         
            PreparedStatement pst = c.conn.prepareStatement("insert gostei ( gostei, login_id_login, sugestao_id_sugestao ) values(?, ?, ?) ");
            pst.setString(1,"0");
            pst.setInt(2,this.idLogin);
            pst.setInt(3,s.getSugestao(pontero).getId_sugestao());
            pst.executeUpdate();
         }else{
            c.conecta();
            PreparedStatement pst = c.conn.prepareStatement(" update gostei go set gostei = 0 where go.sugestao_id_sugestao = ? and go.login_id_login = ?");
            pst.setInt(1,s.getSugestao(pontero).getId_sugestao()); 
            pst.setInt(2,idLogin);
            pst.executeUpdate();
            
         }
         
         
         
        toggleLike.setSelected(false);
        toggleDislike.setSelected(true); 
      }catch(SQLException ex){
         JOptionPane.showMessageDialog(null, ex );
      }finally {
         c.desconecta();
      }
      contaLike();
      contaDisLike();
     
   
   }
   
   private void toggleLikeActionPerformed(ActionEvent evt){
   
      try{
      
         
         
         
         if(verificaLike().equals("-1")){
            c.conecta();
            PreparedStatement pst = c.conn.prepareStatement("insert gostei ( gostei, login_id_login, sugestao_id_sugestao ) values(?, ?, ?) ");
            pst.setString(1,"1");
            pst.setInt(2,this.idLogin);
            pst.setInt(3,s.getSugestao(pontero).getId_sugestao());
            pst.executeUpdate();
         }else{
            c.conecta();
            PreparedStatement pst = c.conn.prepareStatement(" update gostei go set gostei = 1 where go.sugestao_id_sugestao = ? and go.login_id_login = ?");
            pst.setInt(1,s.getSugestao(pontero).getId_sugestao()); 
            pst.setInt(2,idLogin);
            pst.executeUpdate();
            
         }
         
         
         
        toggleDislike.setSelected(false);
        toggleLike.setSelected(true);
      }catch(SQLException ex){
         JOptionPane.showMessageDialog(null, ex );
      }finally {
         c.desconecta();
       }
       
      contaLike();
      contaDisLike(); 
      
   }
   
   public String verificaLike(){
      try{
      
         c.conecta();
         c.executaSQL("select go.gostei\n" +
               "		from sugestao su\n" +
               "			join gostei go on su.id_sugestao = go.sugestao_id_sugestao\n" +
               "				where go.sugestao_id_sugestao = " + s.getSugestao(pontero).getId_sugestao() + " and go.login_id_login = " + idLogin);
         
         if(c.rs.first()){
         
            if(c.rs.getString("gostei").equals("0")){
                  this.toggleDislike.setSelected(true);
                  this.toggleLike.setSelected(false);
               }else{
                  toggleLike.setSelected(true);
                  toggleDislike.setSelected(false);
                  
               }
               
             return c.rs.getString("gostei");         
         }else {
            toggleLike.setSelected(false);
            toggleDislike.setSelected(false);
            
            return "-1";
            
         }
            
         
         
         
      }catch(SQLException ex){
         JOptionPane.showMessageDialog(null, ex );
         
         return "-1";
      }finally {
         c.desconecta();
      }
      
      
   }
   public void contaLike(){
        ConectaBanco conecta = new ConectaBanco();
        conecta.conecta();
          try{
          
              conecta.executaSQL("select count(go.idGostei) as 'gostei'\n" +
                        "	from sugestao su\n" +
                        "		join gostei go on su.id_sugestao = go.sugestao_id_sugestao\n" +
                        "			where go.gostei = '1' and go.sugestao_id_sugestao = " + s.getSugestao(pontero).getId_sugestao() );
               
               if(conecta.rs.first()){ 
               lblGostei.setText(""+ conecta.rs.getInt("gostei"));
               }else{
               lblGostei.setText("0");
                  
               }
               }catch(SQLException ex){
         lblGostei.setText("0");
         }finally {
         conecta.desconecta();
      }
   
   
   }
   
   public void contaDisLike(){
        ConectaBanco conecta = new ConectaBanco();
        conecta.conecta();
          try{
          
              conecta.executaSQL("select count(go.idGostei) as 'gostei'\n" +
                        "	from sugestao su\n" +
                        "		join gostei go on su.id_sugestao = go.sugestao_id_sugestao\n" +
                        "			where go.gostei = '0' and go.sugestao_id_sugestao = " + s.getSugestao(pontero).getId_sugestao() );
               
               if(conecta.rs.first()){ 
               lblNgostei.setText(""+ conecta.rs.getInt("gostei"));
               }else{
               lblNgostei.setText("0");
                  
               }
               }catch(SQLException ex){
         lblNgostei.setText("0");
         }finally {
         conecta.desconecta();
      }
   
   
   }
   
   private void btnEditarActionPerformed(ActionEvent evt){
      
      EditarPerfil editar = new EditarPerfil(idLogin);
      editar.setVisible(true);
      editar.carregar(idLogin);
      setVisible(false);
   }
   
   
   private void btnDevolutivasActionPerformed(ActionEvent evt){
      setVisible(false);
      DevolutivaColab devolutiva = new DevolutivaColab(this.idLogin);
      devolutiva.setVisible(true);
      devolutiva.carregar();
      
   }
   
   
        
   private void btnVoltarActionPerformed(ActionEvent evt) {
   
      if(pontero > 0){
         pontero--;
      }
      
      verificaLike();
      contaLike();
      contaDisLike();
      
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
      
      verificaLike();
      contaLike();
      contaDisLike();
      
      SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
      String data  =  f.format(s.getSugestao(pontero).getData());
          		
      txtNome.setText(s.getSugestao(pontero).getNome());
      txtArea.setText(s.getSugestao(pontero).getArea());
      txtData.setText(data);
      editorPane.setText(s.getSugestao(pontero).getSugestao());
          
   		 
      
   }
   
   
   private void btnNovaSugestaoActionPerformed(ActionEvent evt) {
      TelaSugestaoColab telaSugestaoColab = new TelaSugestaoColab(idLogin);
      
      telaSugestaoColab.setVisible(true);
      
      
   }
   
   
   private void btnSairActionPerformed(ActionEvent evt) {
      
        int opcao = JOptionPane.showConfirmDialog(null,"Deseja realmente sair?", "Atenção !", JOptionPane.YES_NO_OPTION);
        if(opcao == JOptionPane.YES_OPTION){
            System.exit(0);
        }            
           
   }
   
    
   
   public static void main (String []CARGS){
      int id = 0;
      TelaColaborador carrega = new TelaColaborador(id);
      carrega.setVisible(true);
      
      //carrega.carrega();      
   }

}


