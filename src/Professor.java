
public class Professor extends Pessoa {	

	public Professor() {
		duracaoEmprestimo = 10;
		quantidadeMaxima = 5;
	}
		
	public String consultaPorNome() {
		
		String pessoa = "";
		
		pessoa = "\nNome do professor: " + nome + "\nID do professor: " + id + "\n";
		
		pessoa = pessoa + super.printLivrosAlugados();
		
		return pessoa + "--------------------------------------";
	}	
}