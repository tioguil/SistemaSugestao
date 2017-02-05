package form;
import java.awt.*;
import javax.swing.*;
import javax.swing.text.*;
import java.text.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import validar.CPF;
import java.util.Date;
import termo.TermoDeUso;
import java.sql.SQLException;
import utili.*;

public class EditarPerfil extends JFrame {
   private JTextField txtAllName,txtUsuarioCadastro,txtEmail,txtConfirmaEmail;  // ver se o cursando pode ser alterado para algo que abrange ou generalize não só os alunos mas profs e funcs da facul
   private JFormattedTextField txtNasc, txtCpf;
   private JComboBox<String> jComboSexo, jComboAtuacao;
   private JPasswordField txtSenhaCadastro , txtSenhaConfirma;
   private JLabel lblNomeTela, lblGenero,lblAtuacao, lblAllName,lblNasc,lblCpf, lblCursando ,lblUsuarioCadastro,lblSenhaCadastro,lblSenhaConfirma, lblEmail,lblConfirmaEmail;
   private JButton btnVoltar,btnAtualizar;
   private JTextArea textArea;
   private DateFormat formatter;
   private Date data;
   private int idLogin, nivel;
   
   public EditarPerfil(int idLogin){
      super("Editar Perfil");
      this.idLogin = idLogin;
      lblNomeTela = new JLabel("Editar Perfil");
      lblNomeTela.setFont(new Font("Monospaced", Font.ITALIC, 24));
      lblNomeTela.setForeground(Color.BLACK);
      txtAllName = new JTextField(35);
      txtNasc  = new JFormattedTextField();
      txtCpf = new JFormattedTextField();
      jComboSexo = new JComboBox<>();
      jComboSexo.setForeground(Color.BLACK);  
      Color sexo= new Color(207,207,207);
      jComboSexo.setBackground(sexo);
      jComboAtuacao = new JComboBox<>();
      jComboAtuacao.setForeground(Color.BLACK);  
      Color atuacao= new Color(207,207,207);
      jComboAtuacao.setBackground(atuacao);      
      txtUsuarioCadastro = new JTextField(15);
      txtSenhaCadastro = new JPasswordField(10);
      txtSenhaConfirma = new JPasswordField(10);
      txtEmail = new JTextField(30);
      txtConfirmaEmail = new JTextField(30);
      lblGenero = new JLabel ("Genero");
      lblAllName = new JLabel ("Nome Completo");
      lblNasc = new JLabel ("Nascimento");
      lblCpf =  new JLabel ("CPF");
      lblAtuacao = new JLabel ("Atuação");
      lblUsuarioCadastro = new JLabel ("Login");
      lblSenhaCadastro = new JLabel ("Senha");
      lblSenhaConfirma = new JLabel ("Confirmar Senha");
      lblEmail = new JLabel ("Email");
      lblConfirmaEmail = new JLabel ("Confirmar email");
      
      formatter = new SimpleDateFormat("dd/MM/yyyy");
      
      txtCpf.setPreferredSize(new Dimension(110,20));
      txtNasc.setPreferredSize(new Dimension(80,20));
      jComboSexo.setPreferredSize(new Dimension(110,20));
      jComboAtuacao.setPreferredSize(new Dimension(110,20));
      
      btnVoltar = new JButton ("Voltar");
      btnVoltar.setForeground(Color.BLACK);  
      Color volta= new Color(207,207,207);
      btnVoltar.setBackground(volta); 
      btnAtualizar = new JButton ("Atualizar");
      btnAtualizar.setForeground(Color.BLACK);  
      Color atualiza= new Color(207,207,207);
      btnAtualizar.setBackground(atualiza); 
      
      
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
       
        
   
      Container caixaTelaCadastro = getContentPane(); 
      caixaTelaCadastro.setLayout( new BorderLayout()); 
      Color cTela = new Color(154,233,233);
      caixaTelaCadastro.setBackground(cTela);

      
      JPanel pnlZero = new JPanel(new FlowLayout());      
      JPanel pnlSul = new JPanel(new FlowLayout());
      JPanel pnlLinha1 = new JPanel(new GridLayout(2,2));
      JPanel pnlLinha2 = new JPanel(new GridLayout(2,2)); 
      JPanel pnlLinha3 = new JPanel(new GridLayout(2,2));
      JPanel caixa1 = new JPanel(new FlowLayout());
        
      JPanel pnlLinha4 = new JPanel(new GridLayout(2,2));
      JPanel pnlLinha5 = new JPanel(new GridLayout(2,2));
      JPanel pnlLinha6 = new JPanel(new GridLayout(2,2));
      JPanel caixa2 = new JPanel(new FlowLayout());
      JPanel caixa3 = new JPanel(new GridLayout(3,1)); 
      JPanel pnlLinha7 = new JPanel(new GridLayout(2,2));
      JPanel pnlLinha8 = new JPanel(new GridLayout(2,2));
      JPanel pnlLinha81 = new JPanel(new GridLayout(2,2)); 
      JPanel pnlLinha9 = new JPanel(new GridLayout(2,2));
      JPanel pnlLinha10 = new JPanel(new GridLayout(2,2));
      JPanel caixa4 = new JPanel(new FlowLayout());  
      JPanel caixa5 = new JPanel(new FlowLayout()); 
      JPanel caixa51 = new JPanel(new FlowLayout()); 
      JPanel caixa6 = new JPanel(new GridLayout(3,2));  
      JPanel caixaLado = new JPanel(new FlowLayout());  
      
      pnlZero.add(lblNomeTela);
      Color zero = new Color(154,233,233);
      pnlZero.setBackground(zero);
      
      pnlLinha1.add(lblAllName);
      pnlLinha1.add(txtAllName);
      Color l1 = new Color(154,233,233);
      pnlLinha1.setBackground(l1);

      pnlLinha2.add(lblNasc);
      pnlLinha2.add(txtNasc);
      Color l2 = new Color(154,233,233);
      pnlLinha2.setBackground(l2);

      pnlLinha3.add(lblGenero);
      pnlLinha3.add(jComboSexo);
      Color l3 = new Color(154,233,233);
      pnlLinha3.setBackground(l3);

      
      pnlLinha4.add(lblCpf);
      pnlLinha4.add(txtCpf);
      Color l4 = new Color(154,233,233);
      pnlLinha4.setBackground(l4);
      pnlLinha5.add(lblAtuacao);
      pnlLinha5.add(jComboAtuacao);
      Color l5 = new Color(154,233,233);
      pnlLinha5.setBackground(l5);

     
                 
      
      caixa1.add(pnlLinha1);
      caixa2.add(pnlLinha2);
      caixa1.add(pnlLinha3);
      Color c1 = new Color(154,233,233);
      caixa1.setBackground(c1);
      caixa2.add(pnlLinha4);
      caixa2.add(pnlLinha5);                 
      caixa2.add(pnlLinha6);
      Color c2 = new Color(154,233,233);
      caixa2.setBackground(c2);
      caixa3.add(pnlZero);
      caixa3.add(caixa1);
      caixa3.add(caixa2);
      

                  
         
      pnlLinha7.add(lblUsuarioCadastro);
      pnlLinha7.add(txtUsuarioCadastro);
      Color l7 = new Color(154,233,233);
      pnlLinha7.setBackground(l7);

      pnlLinha8.add(lblSenhaCadastro);
      pnlLinha8.add(txtSenhaCadastro);
      Color l8 = new Color(154,233,233);
      pnlLinha8.setBackground(l8);

      pnlLinha81.add(lblSenhaConfirma);
      pnlLinha81.add(txtSenhaConfirma);
      Color l81 = new Color(154,233,233);
      pnlLinha81.setBackground(l81);

        
      pnlLinha9.add(lblEmail);
      pnlLinha9.add(txtEmail);
      Color l9 = new Color(154,233,233);
      pnlLinha9.setBackground(l9);
      pnlLinha10.add(lblConfirmaEmail);
      pnlLinha10.add(txtConfirmaEmail);
      Color l10 = new Color(154,233,233);
      pnlLinha10.setBackground(l10);
      
         
      caixa4.add(pnlLinha7);
      caixa4.add(pnlLinha8);
      caixa4.add(pnlLinha81);
      Color c4 = new Color(154,233,233);
      caixa4.setBackground(c4);

      caixa5.add(pnlLinha9);
      Color c5 = new Color(154,233,233);
      caixa5.setBackground(c5);

      caixa51.add(pnlLinha10);
      Color c51 = new Color(154,233,233);
      caixa51.setBackground(c51);
      caixa6.add(caixa4);
      caixa6.add(caixa5);
      caixa6.add(caixa51);
      caixaLado.add(caixa6);
     
     
      //Para os botões ao sul do container
         
      pnlSul.add(btnVoltar);
      pnlSul.add(btnAtualizar);
         
         
      add(pnlSul, BorderLayout.SOUTH);
      Color sul = new Color(154,233,233);
      pnlSul.setBackground(sul);
      add(caixa3,BorderLayout.NORTH);
      add(caixaLado,BorderLayout.WEST);
      Color cl = new Color(154,233,233);
      caixaLado.setBackground(cl);  
        
      // Config JBox sexo
      jComboSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Feminino" }));
      jComboSexo.setToolTipText("");
      jComboSexo.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
               jComboSexoActionPerformed(evt);
            }
         });
         
      // Config JBox Atuacao
      jComboAtuacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aluno","Ex-Aluno","Funcionário","Ex-Funcionário" }));
      jComboAtuacao.setToolTipText("");
      jComboAtuacao.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
               jComboAtuacaoActionPerformed(evt);
            }
         });   
      
      //Atualizar Dados
      btnAtualizar.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
             btnAtualizarActionPerformed(evt);
          }
        }); 
      
      //Voltar  
      btnVoltar.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
              btnVoltarActionPerformed(evt);
          }
        });
        
          
      
      txtCpf.setEditable(false);
      txtNasc.setEditable(false);
      txtUsuarioCadastro.setEditable(false);
      setResizable(false);
      setVisible(true);
      setSize(518,376);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);
      
      
      UIManager.getDefaults().put("OptionPane.background",new Color(154,233,233));
      UIManager.put ("Panel.background", new Color(154,233,233));
   
   } //Fim construtor
   
   
   
   public void carregar(int idLogin){
      ConectaBanco conectaBanco = new ConectaBanco();
      
      this.idLogin = idLogin;
       
      
      try {
         conectaBanco.conecta();
         
         conectaBanco.executaSQL("select * from login lo	join cadastro ca on lo.id_login = ca.login_id_login where lo.id_login =" + idLogin);
         conectaBanco.rs.first();
         
           
          this.nivel = conectaBanco.rs.getInt("nivel");
          txtAllName.setText(conectaBanco.rs.getString("nome"));
          txtUsuarioCadastro.setText(conectaBanco.rs.getString("login"));
          txtEmail.setText(conectaBanco.rs.getString("Email"));
          txtConfirmaEmail.setText(conectaBanco.rs.getString("Email"));
          txtCpf.setText(conectaBanco.rs.getString("cpf"));
          
          SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
          String data  =  f.format(conectaBanco.rs.getDate("nascimento"));
          txtNasc.setText(data);
          
      }catch(SQLException e1){
            JOptionPane.showMessageDialog(null, "Erro: " + e1);         
      }finally  {
        
         conectaBanco.desconecta();
      }
   }
   
   private void jComboSexoActionPerformed(ActionEvent evt) { }
   
   private void jComboAtuacaoActionPerformed(ActionEvent evt) { }
    
   private void btnAtualizarActionPerformed(ActionEvent evt) {
      CadastraBanco cadastraBanco = new CadastraBanco();
        cadastraBanco.atualizar(idLogin, txtAllName.getText(), txtSenhaCadastro.getText() , txtSenhaConfirma.getText(),
        txtEmail.getText(),txtConfirmaEmail.getText() , String.valueOf(jComboSexo.getSelectedItem()),
        String.valueOf(jComboAtuacao.getSelectedItem())); 
         
   
               
    }
    
     private void btnVoltarActionPerformed(ActionEvent evt) { 
      
      switch (this.nivel){
                    case 0:
                            
                            TelaColaborador colaborador = new TelaColaborador(this.idLogin);
                            colaborador.setVisible(true);
                            colaborador.carregar();
                            


                            
                            break;
                    case 1:
                            TelaAvaliador avaliador = new TelaAvaliador(this.idLogin);
                            avaliador.setVisible(true);
                            avaliador.carregar();
                             
                           
                           
                           break;
                    case 2:
                                                      
                            TelaSuperior superior = new TelaSuperior(this.idLogin);
                            superior.setVisible(true);
                            superior.carregar();
                            
                           
                           break;
                }
      
		setVisible(false);
      
      
         
     }
    

     public static void main (String args[]){
   
      //new EditarPerfil();
   }



}