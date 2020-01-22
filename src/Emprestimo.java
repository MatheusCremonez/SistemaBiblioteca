
public class Emprestimo {
	
	private Livro livro = new Livro();
	private int dataInicial;
	private int duraçãoEmprestimo;
	
	public Emprestimo(Livro livro, int dataInicial, int duraçãoEmprestimo) {
		this.livro = livro;
		this.dataInicial = dataInicial;
		this.duraçãoEmprestimo = duraçãoEmprestimo;
	}

	public int getDataInicial() {
		return dataInicial;
	}	
	
	public Livro getLivro() {
		return livro;
	}	
	
	//Métodos
	
	public String printEmprestimo() {
		return "\nLivro: " + livro.getTitulo() + "\nDia da devolucao: " + (dataInicial + duraçãoEmprestimo) + "\n";
	}
	
}
