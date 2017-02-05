package form;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import utili.*;
//import javax.swing.JPanel;
//import java.awt.BorderLayout;
//import java.awt.FlowLayout;
//import java.awt.GridLayout;
public class Login extends JFrame implements ActionListener{
   
   private JTextField txtUsuario;
   private JPasswordField txtSenha;
   private JLabel lblUsuario,lblSenha,lblTitulo,logo;
   private JButton btnRecupera,btnLogar,btnCadastrar;
   private int idLogin, nivel;
   
   public Login(){
      super("Login - TIP HERE");
      txtUsuario = new JTextField(20);
      lblUsuario= new JLabel("Usuáro: ");
         lblUsuario.setFont(new Font("Monospaced", Font.ITALIC, 15));
            lblUsuario.setForeground(Color.BLACK);
      lblSenha = new JLabel ("Senha: ");
         lblSenha.setFont(new Font("Monospaced", Font.ITALIC, 15));
            lblSenha.setForeground(Color.BLACK);
      txtSenha = new JPasswordField(20);
      btnRecupera = new JButton("Esqueceu a sua senha?");
          btnRecupera.setForeground(Color.BLACK);
            Color recupera = new Color(207,207,207);
                btnRecupera.setBackground(recupera);
      btnCadastrar = new JButton("Cadastrar");
          btnCadastrar.setForeground(Color.BLACK);
            Color cadastra= new Color(207,207,207);
                btnCadastrar.setBackground(cadastra);
      btnLogar = new JButton ("Login");
         btnLogar.setForeground(Color.BLACK);
         btnLogar.setPreferredSize(new Dimension(100,35));
            Color log= new Color(207,207,207);
                btnLogar.setBackground(log);

   
      Container caixaLogin = getContentPane(); 
      caixaLogin.setLayout( new BorderLayout());
        
      logo = new JLabel();
		logo.setIcon(new ImageIcon(getClass().getResource("/img/logo.png")));
      
      JPanel pnlSul = new JPanel(new FlowLayout());
      JPanel pnlLinha1 = new JPanel(new FlowLayout());
      JPanel pnlLinha2 = new JPanel(new FlowLayout());
      JPanel pnlLinha3 = new JPanel(new FlowLayout());
      JPanel pnlCentro = new JPanel(new GridLayout(3,1));
      JPanel pnlLogo = new JPanel(new FlowLayout());
      JPanel pnlNorte = new JPanel(new BorderLayout());
      JPanel caixa = new JPanel( new BorderLayout());
      
      pnlLogo.add(logo);
         Color lo = new Color(154,233,233);
            pnlLogo.setBackground(lo);
      pnlNorte.add(pnlLogo);
      pnlLinha1.add(lblUsuario);
      pnlLinha1.add(txtUsuario);
         Color l1 = new Color(154,233,233);
             pnlLinha1.setBackground(l1);
      pnlLinha2.add(lblSenha);
      pnlLinha2.add(txtSenha);
         Color l2 = new Color(154,233,233);
             pnlLinha2.setBackground(l2);
      pnlLinha3.add(btnLogar);
         Color l3 = new Color(154,233,233);
             pnlLinha3.setBackground(l3);
      pnlCentro.add(pnlLinha1);
      pnlCentro.add(pnlLinha2);
      pnlCentro.add(pnlLinha3);
       Color c = new Color(154,233,233);
            pnlCentro.setBackground(c);      
      add(pnlNorte,BorderLayout.NORTH);
      add(pnlCentro, BorderLayout.CENTER);
      
      pnlSul.add(btnCadastrar);
      pnlSul.add(btnRecupera);
         Color s = new Color(154,233,233);
            pnlSul.setBackground(s);
      add(pnlSul, BorderLayout.SOUTH);
        
   
      btnRecupera.addActionListener(this);
      btnCadastrar.addActionListener(this);
      btnLogar.addActionListener(this);
             
      setResizable(false); 
      setVisible(false);
      setSize(335,240);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);
   
      UIManager.getDefaults().put("OptionPane.background",new Color(154,233,233));
      UIManager.put ("Panel.background", new Color(154,233,233));   
      
      
      btnLogar.addKeyListener(
         new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
               btnLogarActionPerformed(evt);     
         }
      });
      
      
        
   } //Fim Construtor --- 
   
   
   
   
   public void keyPressed(KeyEvent ke){
    if(ke.getKeyCode() == ke.VK_ENTER){ 
            Loga loga = new Loga (txtUsuario.getText(), txtSenha.getText());
            loga.VerificaLogin();
            dispose();
       }  
   }
   
   
   
   private void btnLogarActionPerformed(KeyEvent evt) {
            Loga loga = new Loga (txtUsuario.getText(), txtSenha.getText());
            loga.VerificaLogin();
            dispose();
   }
   
   
   public void actionPerformed(ActionEvent evento1){
      if(evento1.getSource() == btnLogar){
            
            setVisible(false);
            Loga loga = new Loga (txtUsuario.getText(), txtSenha.getText());
            loga.VerificaLogin();
            
            
				            
                     
            
      } else if (evento1.getSource() == btnCadastrar){
             TelaCadastro telaCadastro = new TelaCadastro();
             telaCadastro.setVisible(true);
             setVisible(false);
                 
            
        }else {
            
            TelaRefazSenha recupera = new TelaRefazSenha();
            recupera.setVisible(true);
            setVisible(false);            
        
        }
   
       
   
   }
   
   public void setTxtUsuario (String usuario){
      txtUsuario.setText(usuario);
      
   
   }
   
   public void setTxtSenha (String senha){
      txtSenha.setText(senha);
   }
   
  
}