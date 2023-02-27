package Ex002;

public class livros {

	private String nome;
	private String autor;
	private String idLivro;
	private String ano_publicacao;
	
	 public livros(String nome, String autor, String idLivro, String ano_publicacao) {
		super();
		this.nome = nome;
		this.autor = autor;
		this.idLivro = idLivro;
		this.ano_publicacao = ano_publicacao;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getIdLivro() {
		return idLivro;
	}
	public void setIdLivro(String string) {
		this.idLivro = string;
	}
	public String getAno_publicacao() {
		return ano_publicacao;
	}
	public void setAno_publicacao(String ano_publicacao) {
		this.ano_publicacao = ano_publicacao;
	}
	
	
}
