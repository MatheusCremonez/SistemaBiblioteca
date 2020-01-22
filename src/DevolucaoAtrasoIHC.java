import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;

public class DevolucaoAtrasoIHC extends JFrame {
	
	private DevolucaoAtrasoHandler devolucaoAtrasoHandler = new DevolucaoAtrasoHandler();
	private JTextField dataC;
	private JLabel mensagem1;
	private Dimension tamanho = new Dimension(300, 25);
	private JButton ok, cancel;
	
	public DevolucaoAtrasoIHC(){
		
		super("Devolução em Atraso");
		setLayout(new FlowLayout());
		
		mensagem1 = new JLabel("Digite a data de Hoje: ");
		mensagem1.setPreferredSize(tamanho);
		add(mensagem1);
		
		dataC = new JTextField(27);
		add(dataC);
		
		ok = new JButton("Ok");
		add(ok);
		
		cancel = new JButton("Cancel");
		add(cancel);
		
		dataC.addActionListener(devolucaoAtrasoHandler);
		ok.addActionListener(devolucaoAtrasoHandler);
		cancel.addActionListener(devolucaoAtrasoHandler);
	}
	
	private class DevolucaoAtrasoHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == ok){
				JOptionPane.showMessageDialog(null, Biblioteca.getInstance().consultaAtraso(Integer.parseInt(dataC.getText())));
				dispose();
			}
			else if(event.getSource() == cancel){
				dispose();
			}
		}
	}
}
