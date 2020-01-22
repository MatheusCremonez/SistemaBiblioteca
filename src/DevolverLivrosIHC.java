import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;

public class DevolverLivrosIHC extends JFrame {
	
	private JTextField idD, tituloD, dataD;
	private JLabel mensagem1, mensagem2, mensagem3;
	private JButton ok, cancel;
	private DevolverLivrosHandler devolverLivrosHandler = new DevolverLivrosHandler();
	private Dimension tamanho = new Dimension(300, 25);
	
	public DevolverLivrosIHC(){
		
		super("Devolução de Livros");
		setLayout(new FlowLayout());
		
		//Labels e botões
		
		mensagem1 = new JLabel("Digite o RA/ID: ");
		mensagem1.setPreferredSize(tamanho);
		add(mensagem1);
		
		idD = new JTextField(27);
		add(idD);
		
		mensagem2 = new JLabel("Digite o titulo do Livro: ");
		mensagem2.setPreferredSize(tamanho);
		add(mensagem2);
		
		tituloD = new JTextField(27);
		add(tituloD);
		
		mensagem3 = new JLabel("Digite a data de hoje: ");
		mensagem3.setPreferredSize(tamanho);
		add(mensagem3);
		
		dataD = new JTextField(27);
		add(dataD);
		
		ok = new JButton("Ok");
		add(ok);
		
		cancel = new JButton("Cancel");
		add(cancel);
		
		//Listeners
		
		ok.addActionListener(devolverLivrosHandler);
		cancel.addActionListener(devolverLivrosHandler);
	}
	
	//Handler Devolucao do Livro
	
	private class DevolverLivrosHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			
			if(event.getSource() == ok){
				
				int verificador = 0;
				
				try {
					verificador = Biblioteca.getInstance().devolverLivros(tituloD.getText(), Integer.parseInt(idD.getText()), Integer.parseInt(dataD.getText()));
				}
				catch(UsuarioNaoEncontradoException usuarioNaoEncontradoException) {
					JOptionPane.showMessageDialog(null, "Usuário não encontrado.");
				}
				catch(LivroNaoEncontradoException livroNaoEncontradoException) {
					JOptionPane.showMessageDialog(null, "Livro não encontrado.");
				}
				
				if (verificador == 1) JOptionPane.showMessageDialog(null, "Devolvido com Sucesso.");
				if (verificador == 2) JOptionPane.showMessageDialog(null, "Devolvido com Sucesso, porém com atraso.", "Devolução", JOptionPane.WARNING_MESSAGE);
					
				dispose();
			
			}
			else if(event.getSource() == cancel){
				dispose();
			}
		}
	}
	
}
