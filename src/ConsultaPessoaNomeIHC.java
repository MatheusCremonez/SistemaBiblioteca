import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;

public class ConsultaPessoaNomeIHC extends JFrame {
	
	private JTextField nomeC;
	private JLabel mensagem1;
	private JButton ok, cancel;
	private ConsultaPessoaNomeHandler consultaPessoaNomeHandler = new ConsultaPessoaNomeHandler();
	private Dimension tamanho = new Dimension(300, 25);
	
	public ConsultaPessoaNomeIHC(){
		
		
		super("Consulta Pessoa por Nome");
		setLayout(new FlowLayout());
		
		//Labels e botões
		
		mensagem1 = new JLabel("Digite o nome da Pessoa: ");
		mensagem1.setPreferredSize(tamanho);
		add(mensagem1);
		
		nomeC = new JTextField(27);
		add(nomeC);
		
		ok = new JButton("Ok");
		add(ok);
		
		cancel = new JButton("Cancel");
		add(cancel);
		
		//Listeners
		
		nomeC.addActionListener(consultaPessoaNomeHandler);
		ok.addActionListener(consultaPessoaNomeHandler);
		cancel.addActionListener(consultaPessoaNomeHandler);
	}
	
	//Handler Consulta
	
	private class ConsultaPessoaNomeHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			
			if(event.getSource() == ok){
				try {
					JOptionPane.showMessageDialog(null, Biblioteca.getInstance().consultaPessoa(nomeC.getText()));
				}
				catch(UsuarioNaoEncontradoException usuarioNaoEncontradoException) {
					JOptionPane.showMessageDialog(null, "Usuário não encontrado, tente novamente...", "Erro", JOptionPane.ERROR_MESSAGE);;
				}
				dispose();
			}
			else if(event.getSource() == cancel){
				dispose();
			}
		}
	}
}
