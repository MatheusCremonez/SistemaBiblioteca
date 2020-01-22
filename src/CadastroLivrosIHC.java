import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;

public class CadastroLivrosIHC extends JFrame {

	private JTextField tituloL, quantidadeL;
	private JLabel mensagem1, mensagem2;
	private JButton ok, cancel;
	private CadastroLivrosHandler cadastroLivrosHandler = new CadastroLivrosHandler();
	private Dimension tamanho = new Dimension(300, 25);
	
	public CadastroLivrosIHC(){
		
		super("Cadastro de Livros");
		setLayout(new FlowLayout());
		
		//Labels e os botões
		
		mensagem1 = new JLabel("Digite o titulo do livro: ");
		mensagem1.setPreferredSize(tamanho);
		add(mensagem1);
		
		tituloL = new JTextField(27);
		add(tituloL);
		
		mensagem2 = new JLabel("Digite a quantidade de exemplares do Livro: ");
		mensagem2.setPreferredSize(tamanho);
		add(mensagem2);
		
		quantidadeL = new JTextField(27);
		add(quantidadeL);
		
		ok = new JButton("Ok");
		add(ok);
		
		cancel = new JButton("Cancel");
		add(cancel);
		
		//Listeners
		
		ok.addActionListener(cadastroLivrosHandler);
		cancel.addActionListener(cadastroLivrosHandler);
		
	}
	
	//Handler Cadastro Livros
	
	private class CadastroLivrosHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {

			if(event.getSource() == ok){
				if(Biblioteca.getInstance().cadastroDeLivros(tituloL.getText(), Integer.parseInt(quantidadeL.getText()))){
					JOptionPane.showMessageDialog(null, "Livro cadastrado com sucesso!");
					dispose();
				}
				else JOptionPane.showMessageDialog(null, "Cadastro Invalido!", "Erro", JOptionPane.ERROR_MESSAGE);
				
				//Mostrar cadastro realizado no console
				//System.err.println("\n    Titulo: " + Biblioteca.getInstance().livros[0].titulo + "   Quantidade: " + Biblioteca.getInstance().livros[0].quantidade);
			}
			else if(event.getSource() == cancel){
				dispose();
			}
		}
	}
}
