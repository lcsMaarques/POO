package PetShopDB.mvc.models;

public class PassaroModel extends Animal {

	private String numeroAnilha;

	public PassaroModel(String nome) {
		super();
		super.setNome(nome);
	}

	public PassaroModel(Integer ID, String nome, Integer idade, String raca, String cor, String sexo,
			String numeroAnilha) {
		super(ID, nome, idade, raca, cor, sexo);
		this.numeroAnilha = numeroAnilha;
	}

	public String getNumeroAnilha() {
		return numeroAnilha;
	}

	public void setNumeroAnilha(String numeroAnilha) {
		this.numeroAnilha = numeroAnilha;
	}

}