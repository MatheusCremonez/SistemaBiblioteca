public class Biblioteca {
	
	private static Biblioteca singleton = new Biblioteca();
	private int qtdPessoas = 0, qtdLivros = 0;
	
	public Pessoa[] usuarios = new Pessoa[15];
	public Livro[] livros = new Livro[15];
	
	//Opcao 1
	
	public boolean cadastroDePessoas(String tipoPessoas, int id, String nome) {
		
		if(qtdPessoas < 15) {
			switch (tipoPessoas) {
				case "Aluno":
					usuarios[qtdPessoas] = new Aluno();		
					break;
				case "Aluno Pós-Graduação":
					usuarios[qtdPessoas] = new AlunoPosGraduacao();
					break;
				case "Professor":
					usuarios[qtdPessoas] = new Professor();
					break;
			}
			
			for (int i = 0; i < qtdPessoas; i++) {	//Verfica se ja tem o Ra
				if (id == usuarios[i].getId()){
					return false;
				}
			}
			
			usuarios[qtdPessoas].setId(id);
			usuarios[qtdPessoas].setNome(nome);
			
			qtdPessoas++; //contador
		}
		else {
			return false;
		}
		
		return true;
	}

	//Opcao 2

	public boolean cadastroDeLivros(String titulo, int quantidade) {
		
		if(qtdLivros < 15) {		
			
			int verificador = 0;
			
			for (int i = 0; i < qtdLivros; i++) {	//Verifica se ja possui o Titulo
				if (livros[i].getTitulo().equals(titulo)){
						
					verificador = 1;
					break;
				
				}
			}
				
			if (verificador == 0) { 			//Para livros novos
				
					livros[qtdLivros] = new Livro();
					
					livros[qtdLivros].setTitulo(titulo);
					livros[qtdLivros].setQuantidade(quantidade);
						
					qtdLivros++; //contador de livros
					
			}
			else{		//Para livros já existentes
								
				qtdLivros = qtdLivros + quantidade; //so adiciona mais			

			}
			
			return true;
		
		}
		
		return false;
		
	}	
	
	//Opcao 3
	
	public boolean emprestimoDeLivros(String titulo, int id, int data) throws UsuarioNaoEncontradoException, LivroNaoEncontradoException {
		
		boolean verificacao = true;
		int indicePessoa = (qtdPessoas - 1), indiceLivro;
		
		//o for abaixo serve para ver se o Pessoa existe, tem iniciar com o indice -1 pois o contador
		//ja comeca com 1 e o vetor é de 0 a 14, e se chegar a -1 quer dizer que nao tem o Pessoa
			
		try {
			for (indicePessoa = (qtdPessoas - 1); indicePessoa > -2; indicePessoa--){
				if (id == usuarios[indicePessoa].getId()) {
					verificacao = false;
					break;
				}
			}		
		}
		catch(ArrayIndexOutOfBoundsException usuarioNaoEncontradoException) {	
			UsuarioNaoEncontradoException exception = new UsuarioNaoEncontradoException();
			//exception.printStackTrace();
			throw exception;
		}
		
		if(verificacao == true) return false;
		
		verificacao = true;
		
		//Mesmo caso do for descrito acima, porem aqui vai de 0 ate 14 normal
		
		try {
			for(indiceLivro = (qtdLivros - 1); indiceLivro > -2; indiceLivro--){
				if((livros[indiceLivro].getTitulo().equals(titulo)) && (livros[indiceLivro].getQuantidade() != 0)){
					int verificador = usuarios[indicePessoa].alugaLivro(livros[indiceLivro], data);
					if(verificador == 0) return false;
					else livros[indiceLivro].setQuantidade(livros[indiceLivro].getQuantidade() - 1);					
					
					verificacao = false;
					
					break;
				}
			}
		}
		catch(ArrayIndexOutOfBoundsException livroNaoEncontradoException) {
			LivroNaoEncontradoException exception = new LivroNaoEncontradoException();
			//exception.printStackTrace();
			throw exception;
		}
		
		if(verificacao == true) return false;
		
		return true;
	}
	
	//Opcao 4
	
	public int devolverLivros(String titulo, int id, int data) throws UsuarioNaoEncontradoException, LivroNaoEncontradoException {
		
		boolean verificacao = true;
		int indicePessoa, indiceLivro;
			
		//o for abaixo serve para ver se o Pessoa existe, tem iniciar com o indice -1 pois o contador
		//ja comeca com 1 e o vetor é de 0 a 14, e se chegar a -1 quer dizer que nao tem o Pessoa
	
			try {
				for (indicePessoa = (qtdPessoas - 1); indicePessoa > -2; indicePessoa--){
					if (id == usuarios[indicePessoa].getId()) {
						verificacao = false;
						break;
					}
				}
			}catch(ArrayIndexOutOfBoundsException usuarioNaoEncontradoException) {	
					UsuarioNaoEncontradoException exception = new UsuarioNaoEncontradoException();
					//exception.printStackTrace();
					throw exception;
			}
			
			if(verificacao == true) return 0;
					
				//Mesmo caso do for descrito acima, porem aqui vai de 0 ate 14 normal
						
				try {
					for(indiceLivro = (qtdLivros - 1); indiceLivro > -2; indiceLivro--){
						if(livros[indiceLivro].getTitulo().equals(titulo)){
									
							int verificador = usuarios[indicePessoa].devolveLivro(livros[indiceLivro], data);
							if(verificador == 0) verificacao = true;
							else{
										
								if(verificador == 1){
										
									livros[indiceLivro].setQuantidade(livros[indiceLivro].getQuantidade() + 1);
									verificacao = false;
									return 1;
											
								}
								else{
																			
									livros[indiceLivro].setQuantidade(livros[indiceLivro].getQuantidade() + 1);
									verificacao = false;
									return 2;
								}
											
							}
						}
					}
				}
				catch(ArrayIndexOutOfBoundsException livroNaoEncontradoException) {
					LivroNaoEncontradoException exception = new LivroNaoEncontradoException();
					//exception.printStackTrace();
					throw exception;
				}
			
		return 0;
			
	}
	
	//Opcao 5
	
	public String consultaLivro(String titulo) throws LivroNaoEncontradoException {

		int i;
		
		for(i = 0; i < qtdLivros; i++) {
			if(livros[i].getTitulo().equals(titulo)) {
				return livros[i].consultaPorTitulo();
			}
		}
		if(i >= qtdLivros) {
			LivroNaoEncontradoException exception = new LivroNaoEncontradoException();
			//exception.printStackTrace();
			throw exception;
		}
		return "";
	}
	
	//Opcao 6
	
	public String consultaPessoa(String Pessoa) throws UsuarioNaoEncontradoException {

		int i;
		
		for(i = 0; i < qtdPessoas; i++) {
			if(usuarios[i].getNome().equals(Pessoa)) {
				return usuarios[i].consultaPorNome(); //nome e ra
			}
			
		}
		if(i >= qtdPessoas) {
			UsuarioNaoEncontradoException exception = new UsuarioNaoEncontradoException();
			//exception.printStackTrace();
			throw exception;
		}
		
		return "";
	}
	
	//Opcao 7
	
	public String consultaAtraso(int data){
		
		String stringFinal = "";
		
		stringFinal = "Os Pessoas com livros atrasados para devolver sao: \n";
		
		for (int i = 0; i < qtdPessoas; i++){
			
			if(usuarios[i].aluguelAtrasado(data) == 1) stringFinal = stringFinal + usuarios[i].getNome() + "\n";
		
		}
		
		return stringFinal;
		
	}
	
	//Opcao 8
	
	public String printLivros(){
		
		String stringFinal = "";
		
		for (int i = 0; i < qtdLivros; i++){
			
			stringFinal = stringFinal + livros[i].consultaPorTitulo();
			
		}
		
		return stringFinal;
	}
	
	//Opcao 9
	
	public String printPessoas(){
		
		String stringFinal = "";
		
		for (int i = 0; i < qtdPessoas; i++){
			
			stringFinal = stringFinal + usuarios[i].consultaPorNome();
			
		}
		
		return stringFinal;
	}
	
	//Singleton
	
	public static Biblioteca getInstance() {
		if (singleton == null)
			singleton = new Biblioteca();

		return singleton;
	}
}