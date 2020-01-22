import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class CadastroPessoasIHC extends JFrame {
	
	private JTextField nomeC, idC;
	private JLabel mensagem0, mensagem1, mensagem2;
	private String[] tipoPessoas = {"Aluno", "Aluno Pós-Graduação", "Professor"};
	private JComboBox<String> opcoes;
	private JButton ok, cancel;
	private CadastroPessoasHandler cadastroAlunosHandler = new CadastroPessoasHandler();
	private Dimension tamanho = new Dimension(300, 25);
	
	public CadastroPessoasIHC(){
		
		super("Cadastro de Alunos");
		setLayout(new FlowLayout());
		
		//Labels e os botões
		
		mensagem0 = new JLabel("Escolha o tipo de cadastro: ");
		mensagem0.setPreferredSize(tamanho);
		add(mensagem0);
		
		opcoes = new JComboBox<String>(tipoPessoas);
		opcoes.setPreferredSize(tamanho);
		add(opcoes);
		
		mensagem1 = new JLabel("Digite o Nome: ");
		mensagem1.setPreferredSize(tamanho);
		add(mensagem1);
		
		nomeC = new JTextField(27);
		add(nomeC);
		
		mensagem2 = new JLabel("Digite o RA: ");
		mensagem2.setPreferredSize(tamanho);
		add(mensagem2);
		
		idC = new JTextField(27);
		add(idC);
		
		ok = new JButton("Ok");
		add(ok);
		
		cancel = new JButton("Cancel");
		add(cancel);
		
		//Listeners

		ok.addActionListener(cadastroAlunosHandler);
		cancel.addActionListener(cadastroAlunosHandler);
	}
	
	//Handler Cadastro Alunos
	
	private class CadastroPessoasHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			
			if(event.getSource() == ok){
				if(Biblioteca.getInstance().cadastroDePessoas((String)opcoes.getSelectedItem(), Integer.parseInt(idC.getText()), nomeC.getText())){
					
					JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso!");
					dispose();
					
				}
				else JOptionPane.showMessageDialog(null, "Cadastro Invalido!", "Erro", JOptionPane.ERROR_MESSAGE);
				
				//Mostrar cadastro realizado no console
				//System.err.println("\n    Nome: " + Biblioteca.getInstance().usuarios[0].nome + "   ID: " + Biblioteca.getInstance().usuarios[0].id + "    Duracao: " + Biblioteca.getInstance().usuarios[0].duracaoEmprestimo);
			
			}
			else if(event.getSource() == cancel){
				dispose();
			}
			
		}
		
	}
}
