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
import java.sql.SQLException;
import java.sql.PreparedStatement;
import utili.*;


public class TelaSugestaoColab extends JFrame{

      
   private JLabel lblTitulo,lblSubTitulo,logo;
   private JButton btnVoltar,btnLimpar,btnEnviar;
   private JComboBox<String>jComboArea;
   private JEditorPane editorPane;
   private int idLogin;
     
       
   public TelaSugestaoColab(int idLogin){
      super ("Tela Sugestao Colaborador");
      this.idLogin = idLogin;
      lblTitulo = new JLabel("Sugestão: ");
      lblTitulo.setFont(new Font("Monospaced", Font.ITALIC, 20));
      lblTitulo.setForeground(Color.BLACK);
      lblSubTitulo = new JLabel("Escolha à área:");
      lblSubTitulo.setFont(new Font("Monospaced", Font.ITALIC, 17));
      lblSubTitulo.setForeground(Color.BLACK);
      jComboArea = new JComboBox<>();
      jComboArea.setForeground(Color.BLACK);
      Color a= new Color(207,207,207);
      jComboArea.setBackground(a);
      btnVoltar = new JButton("Voltar");
      btnVoltar.setForeground(Color.BLACK);
      Color voltar= new Color(207,207,207);
      btnVoltar.setBackground(voltar);
      btnLimpar = new JButton("Limpar");
      btnLimpar.setForeground(Color.BLACK);
      Color limpar= new Color(207,207,207);
      btnLimpar.setBackground(limpar);
      btnEnviar = new JButton("Enviar");
      btnEnviar.setForeground(Color.BLACK);
      Color enviar= new Color(207,207,207);
      btnEnviar.setBackground(enviar);
           
           
      Container caixaTelaSugestaoColab = getContentPane(); 
      caixaTelaSugestaoColab.setLayout( new BorderLayout()); 
      logo = new JLabel();
      logo.setIcon(new ImageIcon(getClass().getResource("/img/logo.png")));
   
       //Topo
      JPanel pnlLogo = new JPanel (new GridLayout(3,2));
      JPanel pnlTitulo = new JPanel ( new BorderLayout());
      JPanel pnlSubTitulo = new JPanel ( new BorderLayout());
   
       
       //Centro 1 
      JPanel pnlCentro1 = new JPanel(new GridLayout(5,5));
      editorPane = new JEditorPane();
      JScrollPane editorScrollPane = new JScrollPane(editorPane);
      JPanel editor =  new JPanel (new FlowLayout()); 
      editorScrollPane.setPreferredSize(new Dimension(350,250));  
       
       
        // Botoes Sul 
     
       
      JPanel pnlNorte = new JPanel( new BorderLayout());
      JPanel pnlSul = new JPanel(new FlowLayout ());
      JPanel pnlSul2 = new JPanel (new BorderLayout());
   
       
       
      pnlLogo.add(logo,BorderLayout.NORTH);
      pnlLogo.add(pnlTitulo,BorderLayout.SOUTH);
      pnlTitulo.add(lblTitulo,BorderLayout.SOUTH);
      Color titulo = new Color(154,233,233);
      pnlTitulo.setBackground(titulo); 
      pnlSubTitulo.add(lblTitulo,BorderLayout.WEST);
      pnlSubTitulo.add(lblSubTitulo,BorderLayout.EAST);
      Color sub = new Color(154,233,233);
      pnlSubTitulo.setBackground(sub); 
      pnlLogo.add(pnlSubTitulo);
      Color logo = new Color(154,233,233);
      pnlLogo.setBackground(logo); 
        
      editor.add(editorScrollPane);   
      Color ed = new Color(154,233,233);
      editor.setBackground(ed);   
        
      pnlNorte.add(jComboArea,BorderLayout.NORTH); 
      Color n = new Color(154,233,233);
      pnlNorte.setBackground(n); 
      pnlSul.add(btnLimpar);
      pnlSul.add(btnVoltar);
      pnlSul.add(btnEnviar);
      pnlSul2.add(pnlSul,BorderLayout.CENTER);
      Color sul = new Color(154,233,233);
      pnlSul.setBackground(sul); 
   
      add(pnlLogo,BorderLayout.NORTH);
        
      add(editor);
      add(pnlNorte,BorderLayout.EAST);
      add(pnlSul2,BorderLayout.SOUTH);
       
      jComboArea.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Financeiro", "Pedagógica","Departamento Pessoal","Infra-estrutura","Outros"}));
      jComboArea.setToolTipText("");
           
      
      
      setResizable(false);
      setVisible(true);
      setSize(564,415);
      //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setDefaultCloseOperation(0);
      setLocationRelativeTo(null);
      
      UIManager.getDefaults().put("OptionPane.background",new Color(154,233,233));
      UIManager.put ("Panel.background", new Color(154,233,233));
      
      //Events
      jComboArea.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
               jComboAreaActionPerformed(evt);
            }
         }); 
      
      
      btnEnviar.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
               btnEnviarActionPerformed(evt);
            }
         });
      btnLimpar.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
               btnLimparActionPerformed(evt);
            }
         });
      btnVoltar.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
               btnVoltarActionPerformed(evt);
            }
         }); 
   
   
   
   }


   private void jComboAreaActionPerformed(ActionEvent evt) { } 
      
   private void  btnVoltarActionPerformed(ActionEvent evt) { 
    this.setVisible(false);


   } 
       
   private void btnLimparActionPerformed(ActionEvent evt) {
      editorPane.setText("");
   } 
      
     
   private void btnEnviarActionPerformed(ActionEvent evt) {
   
      if(!editorPane.getText().equals("")){   
      CadastraSugestao cadastrar = new CadastraSugestao(editorPane.getText(), String.valueOf(jComboArea.getSelectedItem()), idLogin);
         boolean cadastrado = cadastrar.cadastraSugestao();
         if(cadastrado){
            editorPane.setText("");
         }
      }else{
         JOptionPane.showMessageDialog(this,"Por gentileza\nreencha o campo de susgestão !", "Preencha o campo de susgestão !", JOptionPane.ERROR_MESSAGE);
      }      
                   
   }

    
    
   public static void main (String[]args){
   }
     
     
}