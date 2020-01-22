import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class InterfaceGrafica extends JFrame {
	
	private JLabel labelmenu;
	private JButton button1, button2, button3, button4, button5, button6, button7, button8, button9;
	private MenuHandler menuHandler = new MenuHandler();
	private Dimension tamanho = new Dimension(300, 25);
	private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	
	public InterfaceGrafica() {
		
		super( "Bibilioteca" );
		setLayout( new FlowLayout() );
		
		//Labels e os botões
		
		labelmenu = new JLabel("Menu", SwingConstants.CENTER);
		labelmenu.setPreferredSize(tamanho);
		add(labelmenu);
		
		button1 = new JButton("Cadastrar Pessoas");
		button1.setPreferredSize(tamanho);
		add(button1);
		
		button2 = new JButton("Cadastrar Livros");
		button2.setPreferredSize(tamanho);
		add(button2);
		
		button3 = new JButton("Emprestar Livros");
		button3.setPreferredSize(tamanho);
		add(button3);
		
		button4 = new JButton("Devolver Livros");
		button4.setPreferredSize(tamanho);
		add(button4);
		
		button5 = new JButton("Consultar Livro por Titulo");
		button5.setPreferredSize(tamanho);
		add(button5);
		
		button6 = new JButton("Consultar Usuário por Nome");
		button6.setPreferredSize(tamanho);
		add(button6);
		
		button7 = new JButton("Verificar Usuários com Devolução em Atraso");
		button7.setPreferredSize(tamanho);
		add(button7);
		
		button8 = new JButton("Consultar Lista de Todos os Livros");
		button8.setPreferredSize(tamanho);
		add(button8);
		
		button9 = new JButton("Consultar Lista de Todos as Pessoas");
		button9.setPreferredSize(tamanho);
		add(button9);
		
		//Listeners
		
		button1.addActionListener(menuHandler);
		button2.addActionListener(menuHandler);
		button3.addActionListener(menuHandler);
		button4.addActionListener(menuHandler);
		button5.addActionListener(menuHandler);
		button6.addActionListener(menuHandler);
		button7.addActionListener(menuHandler);
		button8.addActionListener(menuHandler);
		button9.addActionListener(menuHandler);

	}
	
	//Handler Menu
	
	private class MenuHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			
			if(event.getSource() == button1) {
				CadastroPessoasIHC cadastro = new CadastroPessoasIHC();
				cadastro.setSize(350, 250);
				cadastro.setResizable(false);
				cadastro.setVisible(true);
				cadastro.setLocation(dim.width/2-cadastro.getSize().width/2, dim.height/2-cadastro.getSize().height/2);
			}
			else if(event.getSource() == button2){
				CadastroLivrosIHC cadastro = new CadastroLivrosIHC();
				cadastro.setSize(350, 185);
				cadastro.setResizable(false);
				cadastro.setVisible(true);
				cadastro.setLocation(dim.width/2-cadastro.getSize().width/2, dim.height/2-cadastro.getSize().height/2);
			}
			else if(event.getSource() == button3){
				EmprestimoIHC emprestimo = new EmprestimoIHC();
				emprestimo.setSize(350, 240);
				emprestimo.setResizable(false);
				emprestimo.setVisible(true);
				emprestimo.setLocation(dim.width/2-emprestimo.getSize().width/2, dim.height/2-emprestimo.getSize().height/2);
			}
			else if(event.getSource() == button4){
				DevolverLivrosIHC devolverLivros = new DevolverLivrosIHC();
				devolverLivros.setSize(350, 240);
				devolverLivros.setResizable(false);
				devolverLivros.setVisible(true);
				devolverLivros.setLocation(dim.width/2-devolverLivros.getSize().width/2, dim.height/2-devolverLivros.getSize().height/2);
			}
			else if(event.getSource() == button5){
				ConsultaLivroTituloIHC consultaLivroTitulo = new ConsultaLivroTituloIHC();
				consultaLivroTitulo.setSize(350, 140);
				consultaLivroTitulo.setResizable(false);
				consultaLivroTitulo.setVisible(true);
				consultaLivroTitulo.setLocation(dim.width/2-consultaLivroTitulo.getSize().width/2, dim.height/2-consultaLivroTitulo.getSize().height/2);
			}
			else if(event.getSource() == button6){
				ConsultaPessoaNomeIHC consultaPessoaNome = new ConsultaPessoaNomeIHC();
				consultaPessoaNome.setSize(350, 140);
				consultaPessoaNome.setResizable(false);
				consultaPessoaNome.setVisible(true);
				consultaPessoaNome.setLocation(dim.width/2-consultaPessoaNome.getSize().width/2, dim.height/2-consultaPessoaNome.getSize().height/2);
			}
			else if(event.getSource() == button7){
				DevolucaoAtrasoIHC devolucaoAtraso = new DevolucaoAtrasoIHC();
				devolucaoAtraso.setSize(350, 140);
				devolucaoAtraso.setResizable(false);
				devolucaoAtraso.setVisible(true);
				devolucaoAtraso.setLocation(dim.width/2-devolucaoAtraso.getSize().width/2, dim.height/2-devolucaoAtraso.getSize().height/2);
			}
			else if(event.getSource() == button8){
				JOptionPane.showMessageDialog(null, Biblioteca.getInstance().printLivros());
			}
			else if(event.getSource() == button9){
				JOptionPane.showMessageDialog(null, Biblioteca.getInstance().printPessoas());
			}
		}
	}
}