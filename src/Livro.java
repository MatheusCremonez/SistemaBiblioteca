
public class Livro {

	protected String titulo;
	protected int quantidade;
	
	// Getters and Setters
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String tituloLivro) {
		titulo = tituloLivro;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidadeLivro) {
		quantidade = quantidadeLivro;
	}
	
	//Metodos
	
	public String consultaPorTitulo() {
		return "\nTitulo do livro: " + titulo + "\nQuantidade de exemplares disponiveis para emprestimo: " + quantidade + "\n" + "--------------------------------------";
	}	
	
}