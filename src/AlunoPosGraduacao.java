
public class AlunoPosGraduacao extends Pessoa {	
	
	public AlunoPosGraduacao() {
		duracaoEmprestimo = 7;
		quantidadeMaxima = 5;
	}
		
	public String consultaPorNome() {
		
		String pessoa = "";
		
		pessoa = "\nNome do aluno: " + nome + "\nRA do aluno: " + id + "\n";
		
		pessoa = pessoa + super.printLivrosAlugados();
		
		return pessoa + "--------------------------------------";
	}	
}