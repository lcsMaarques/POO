package Models;

import java.util.ArrayList;

public class Proprietario {
    private String cpf;
    private String nome;
    private String telefone;
    private String endereco;
    private ArrayList<Animal> animais;

    public Proprietario(String cpf, String nome, String telefone, String endereco) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.animais = new ArrayList<Animal>();
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void adicionarAnimal(Animais animais) {
        animais.add(animais);
    }

    public void removerAnimal(Animais animais) {
        animais.remove(animais);
    }

    public ArrayList<Animais> getAnimais() {
        return animais;
    }

    public void setAnimais(ArrayList<Animais> animais) {
        this.animais = animais;
    }
}

