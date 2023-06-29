package PetShopDB.mvc.models;

import java.util.ArrayList;

public abstract class Animal {

	private Integer ID;
	private String nome;
	private Integer idade;
	private String raca;
	private String cor;
	private String sexo;
	private ArrayList<ProprietarioModel> proprietarios;

	public Animal() {
		super();
		this.proprietarios = new ArrayList<>();
	}

	public Animal(Integer ID, String nome, Integer idade, String raca, String cor, String sexo) {
		super();
		this.ID = ID;
		this.nome = nome;
		this.idade = idade;
		this.raca = raca;
		this.cor = cor;
		this.sexo = sexo;
		this.proprietarios = new ArrayList<>();
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
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

	public ArrayList<ProprietarioModel> getProprietarios() {
		return proprietarios;
	}

	public void setProprietarios(ArrayList<ProprietarioModel> proprietarios) {
		this.proprietarios = proprietarios;
	}

	public void adicionarProprietario(ProprietarioModel proprietario) {
		this.proprietarios.add(proprietario);
	}

	@Override
	public String toString() {
		return ID + " - " + nome;
	}

}