import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;

public class EmprestimoIHC extends JFrame {

	private JTextField idE, tituloE, dataE;
	private JLabel mensagem1, mensagem2, mensagem3;
	private EmprestimoHandler emprestimoHandler = new EmprestimoHandler();
	private Dimension tamanho = new Dimension(300, 25);
	
	private JButton ok, cancel;
	
	public EmprestimoIHC(){
		
		super("Emprestimo de Livros");
		setLayout(new FlowLayout());
		
		//Labels e botões
		
		mensagem1 = new JLabel("Digite o RA/ID: ");
		mensagem1.setPreferredSize(tamanho);
		add(mensagem1);
		
		idE = new JTextField(27);
		add(idE);
		
		mensagem2 = new JLabel("Digite o titulo do Livro: ");
		mensagem2.setPreferredSize(tamanho);
		add(mensagem2);
		
		tituloE = new JTextField(27);
		add(tituloE);
		
		mensagem3 = new JLabel("Digite a data de hoje: ");
		mensagem3.setPreferredSize(tamanho);
		add(mensagem3);
		
		dataE = new JTextField(27);
		add(dataE);
		
		ok = new JButton("Ok");
		add(ok);
		
		cancel = new JButton("Cancel");
		add(cancel);
		
		//Listeners
		
		ok.addActionListener(emprestimoHandler);
		cancel.addActionListener(emprestimoHandler);
	}
	
	//Handler Emprestimo
	
	private class EmprestimoHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			
			if(event.getSource() == ok){
				
				int verificador = 0;
				boolean expirar = true;
				
				try {
					expirar = Biblioteca.getInstance().emprestimoDeLivros(tituloE.getText(), Integer.parseInt(idE.getText()), Integer.parseInt(dataE.getText()));
				}
				catch(UsuarioNaoEncontradoException usuarioNaoEncontradoException) {
					JOptionPane.showMessageDialog(null, "Usuário não encontrado", "Erro", JOptionPane.ERROR_MESSAGE);
					verificador = 1;
				}
				catch(LivroNaoEncontradoException livroNaoEncontradoException) {
					JOptionPane.showMessageDialog(null, "Livro não encontrado ou esgotado.", "Erro", JOptionPane.ERROR_MESSAGE);
					verificador = 1;
				}
				
				if(expirar == false) JOptionPane.showMessageDialog(null, "Limite de Emprestimo excedido, não pode realizar.", "Erro", JOptionPane.ERROR_MESSAGE);
				else if (verificador == 0) JOptionPane.showMessageDialog(null, "Empréstimo feito com Sucesso.");
					
				dispose();
			
			}
			else if(event.getSource() == cancel){
				dispose();
			}
		}
	}
	
}
