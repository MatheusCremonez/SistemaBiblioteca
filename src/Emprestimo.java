
public class Emprestimo {
	
	private Livro livro = new Livro();
	private int dataInicial;
	private int dura��oEmprestimo;
	
	public Emprestimo(Livro livro, int dataInicial, int dura��oEmprestimo) {
		this.livro = livro;
		this.dataInicial = dataInicial;
		this.dura��oEmprestimo = dura��oEmprestimo;
	}

	public int getDataInicial() {
		return dataInicial;
	}	
	
	public Livro getLivro() {
		return livro;
	}	
	
	//M�todos
	
	public String printEmprestimo() {
		return "\nLivro: " + livro.getTitulo() + "\nDia da devolucao: " + (dataInicial + dura��oEmprestimo) + "\n";
	}
	
}
