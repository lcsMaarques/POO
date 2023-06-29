package PetShopDB.mvc.models;

import java.util.ArrayList;

public class ProprietarioModel {
	
	private Integer ID;
	private String cpf;
	private String nome;
	private String endereco;
	private ArrayList<Animal> animais;
	
	public ProprietarioModel(String nome) {
		this.nome = nome;
		this.animais = new ArrayList<>();
	}
	
	public ProprietarioModel() {
		super();
		this.animais = new ArrayList<>();
	}
	
	public ProprietarioModel(Integer iD, String cpf, String nome, String endereco) {
		super();
		ID = iD;
		this.cpf = cpf;
		this.nome = nome;
		this.endereco = endereco;
		this.animais = new ArrayList<>();
	}
	
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public ArrayList<Animal> getAnimais() {
		return animais;
	}
	public void setAnimais(ArrayList<Animal> animais) {
		this.animais = animais;
	}
	
	public void adicionarAnimal(Animal animal) {
		this.getAnimais().add(animal);
	}

	@Override
	public String toString() {
		return ID + " - " + nome;
	}

}