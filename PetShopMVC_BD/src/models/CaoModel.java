package PetShopDB.mvc.models;

public class CaoModel extends Animal {

	private String porte;
	private Double peso;

	public CaoModel(String nome) {
		super();
		super.setNome(nome);
	}

	public CaoModel(Integer ID, String nome, Integer idade, String raca, String cor, String sexo, String porte,
			Double peso) {
		super(ID, nome, idade, raca, cor, sexo);
		this.porte = porte;
		this.peso = peso;
	}

	public String getPorte() {
		return porte;
	}

	public void setPorte(String porte) {
		this.porte = porte;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

}