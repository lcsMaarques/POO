package ex004;

import java.util.ArrayList;
import java.util.List;

public class Dono {
	
	private String nome;
    private List<Animais> animais;

    private static List<Dono> proprietarios = new ArrayList<>();
    
    public Dono(String nome) {
        this.nome = nome;
        this.animais = new ArrayList<>();
        dono.add(this);
    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Animais> getAnimais() {
		return animais;
	}

	public void setAnimais(ArrayList<Animais> animais) {
		this.animais = animais;
	}
	
	public void cadastrarAnimais(Animais animais) {
        animais.add(animais);
    }
	
	public static List<Proprietario> getProprietarios() {
	    return proprietarios;
	}
}
