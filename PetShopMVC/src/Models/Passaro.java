package Models;

public class Passaro extends Animais {
    private int numeroAnilha;

    public Passaro(String nome, int idade, String raça, String cor, String sexo, int numeroAnilha) {
        super(nome, idade, raça, cor, sexo);
        this.numeroAnilha = numeroAnilha;
    }

    public int getNumeroAnilha() {
        return numeroAnilha;
    }

    public void setNumeroAnilha(int numeroAnilha) {
        this.numeroAnilha = numeroAnilha;
    }
}

