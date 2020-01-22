
public class Aluno extends Pessoa {	
	
	public Aluno() {
		duracaoEmprestimo = 7;
		quantidadeMaxima = 3;
	}
		
	public String consultaPorNome() {
		
		String pessoa = "";
		
		pessoa = "\nNome do aluno: " + nome + "\nRA do aluno: " + id + "\n";
		
		pessoa = pessoa + super.printLivrosAlugados();
		
		return pessoa + "--------------------------------------";
	}
}