import java.util.ArrayList;

public class Pizza {
    private String nome;
    private double preco;
    private String dataValidade;
    private double peso;
    private ArrayList<String> recheios;
    private ArrayList<String> bordas;
    private ArrayList<String> molhos;
    
    public Pizza(String nome, double preco, String dataValidade, double peso, ArrayList<String> recheios, ArrayList<String> bordas, ArrayList<String> molhos) {
        this.nome = nome;
        this.preco = preco;
        this.dataValidade = dataValidade;
        this.peso = peso;
        this.recheios = recheios;
        this.bordas = bordas;
        this.molhos = molhos;
    }
    
    // Métodos para acesso aos atributos
    public String getNome() {
        return nome;
    }
    
    public double getPreco() {
        return preco;
    }
    
    public String getDataValidade() {
        return dataValidade;
    }
    
    public double getPeso() {
        return peso;
    }
    
    public ArrayList<String> getRecheios() {
        return recheios;
    }
    
    public ArrayList<String> getBordas() {
        return bordas;
    }
    
    public ArrayList<String> getMolhos() {
        return molhos;
    }
    
    // Método para exibir informações da pizza
    public void exibirPizza() {
        System.out.println("Nome: " + nome);
        System.out.println("Preço: R$" + preco);
        System.out.println("Data de validade: " + dataValidade);
        System.out.println("Peso: " + peso + " g");
        System.out.println("Recheios disponíveis: " + recheios);
        System.out.println("Bordas disponíveis: " + bordas);
        System.out.println("Molhos disponíveis: " + molhos);
    }
}