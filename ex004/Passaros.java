package ex004;

public class Passaros extends Animais{

	private String porte;
	private Integer peso;
	private String anilha;
	
	public Passaros() {
		super();
	}
	
	public Passaros(String nome, String idade, String raca, String cor, String sexo, String porte, Integer peso, String anilha) {
		super();
		this.peso = peso;
		this.porte = porte;
		this.setAnilha(anilha);
	}

	public String getPorte() {
		return porte;
	}

	public void setPorte(String porte) {
		this.porte = porte;
	}

	public Integer getPeso() {
		return peso;
	}

	public void setPeso(Integer peso) {
		this.peso = peso;
	}

	public String getAnilha() {
		return anilha;
	}

	public void setAnilha(String anilha) {
		this.anilha = anilha;
	}
}
