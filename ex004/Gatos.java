package ex004;

public class Gatos extends Animais{
	
	private String porte;
	private Integer peso;
	
	public Gatos() {
		super();
	}
	
	public Gatos(String nome, String idade, String raca, String cor, String sexo, String porte, Integer peso) {
		super();
		this.peso = peso;
		this.porte = porte;
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
	
	
	
}
