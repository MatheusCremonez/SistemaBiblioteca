import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;

public class ConsultaLivroTituloIHC extends JFrame {
	
	private JTextField tituloC;
	private JLabel mensagem1;
	private JButton ok, cancel;
	private ConsultaLivroTituloHandler consultaLivroTituloHandler = new ConsultaLivroTituloHandler();
	private Dimension tamanho = new Dimension(300, 25);
	
	public ConsultaLivroTituloIHC(){
		
		super("Consulta Livro por Titulo");
		setLayout(new FlowLayout());
		
		//Labels e botões
		
		mensagem1 = new JLabel("Digite o titulo do Livro: ");
		mensagem1.setPreferredSize(tamanho);
		add(mensagem1);
		
		tituloC = new JTextField(27);
		add(tituloC);
		
		ok = new JButton("Ok");
		add(ok);
		
		cancel = new JButton("Cancel");
		add(cancel);
		
		//Listeners
		
		tituloC.addActionListener(consultaLivroTituloHandler);
		ok.addActionListener(consultaLivroTituloHandler);
		cancel.addActionListener(consultaLivroTituloHandler);
		
	}
	
	//Handler Consulta
	
	private class ConsultaLivroTituloHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			
			if(event.getSource() == ok){
				try {
					JOptionPane.showMessageDialog(null, Biblioteca.getInstance().consultaLivro(tituloC.getText()));
				}
				catch(LivroNaoEncontradoException livroNaoEncontradoException) {
					JOptionPane.showMessageDialog(null, "Livro não encontrado, tente novamente...", "Erro", JOptionPane.ERROR_MESSAGE);
				}
				dispose();
			}
			else if(event.getSource() == cancel){
				dispose();
			}
		}
	}
}
