package Models;

public class Cachorro extends Animais {
    private String porte;
    private double peso;

    public Cachorro(String nome, int idade, String raça, String cor, String sexo, String porte, double peso) {
        super(nome, idade, raça, cor, sexo);
        this.porte = porte;
        this.peso = peso;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
}

