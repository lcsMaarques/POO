package ex004;

public class Animais {
	private String nome;
	private String idade;
	private String raca;
	private String cor;
	private String sexo;
	
	public Animais() {}
	
	public Animais(String nome, String idade, String raca, String cor, String sexo) {
		super();
		this.setIdade(idade);
		this.setRaca(raca);
		this.setCor(cor);
		this.setSexo(sexo);
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
