
public abstract class Pessoa {
	protected String nome;
	protected Emprestimo[] emprestimos = new Emprestimo[5];
	protected int duracaoEmprestimo;
	protected int quantidadeMaxima;
	protected int id;
	
	// Getters and Setters
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	//Metodos
	
	public int alugaLivro(Livro livro, int dataInicial) {
		for(int i = 0; i < quantidadeMaxima; i++) {
			if(emprestimos[i] == null) {
				emprestimos[i] = new Emprestimo(livro, dataInicial, duracaoEmprestimo);
				
				return 1;
			}
		}
		
		return 0;
	}
	
	public int devolveLivro(Livro livro, int dataFinal) {
		for(int i = 0; i < quantidadeMaxima; i++) {
			if(emprestimos[i].getLivro().equals(livro)) {
				if((dataFinal - emprestimos[i].getDataInicial()) <= 7) {
					emprestimos[i] =  null;
					return 1;
				}
				else {
					emprestimos[i] =  null;
					return 2;
				}
			}
		}
		return 0;
	}
	
	public int aluguelAtrasado(int dataAtual){
		
		for(int i = 0; i < quantidadeMaxima; i++){	
			if(emprestimos[i] != null){
				if((dataAtual - emprestimos[i].getDataInicial()) > duracaoEmprestimo) return 1;
			}
		}
		return 0;
		
	}
	
	abstract String consultaPorNome();
	
	public String printLivrosAlugados() {
		
		String listaLivros = "";
		
		for(int i = 0; i < quantidadeMaxima; i++){	
			if(emprestimos[i] != null){
				listaLivros = listaLivros + emprestimos[i].printEmprestimo();
			}
		}
		
		return listaLivros;
	}
}
