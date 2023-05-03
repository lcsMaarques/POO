package Models;

public class Animais {
    private String nome;
    private int idade;
    private String raça;
    private String cor;
    private String sexo;

    public Animais(String nome, int idade, String raça, String cor, String sexo) {
        this.nome = nome;
        this.idade = idade;
        this.raça = raça;
        this.cor = cor;
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getRaça() {
        return raça;
    }

    public void setRaça(String raça) {
        this.raça = raça;
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

	public void add(Animais animais) {
		
		
	}

	public void remove(Animais animais) {
		
		
	}
}

