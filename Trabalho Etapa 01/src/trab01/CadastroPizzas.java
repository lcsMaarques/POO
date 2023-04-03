import java.util.ArrayList;

public class CadastroPizzas {
    private ArrayList<Pizza> pizzas;
    
    public CadastroPizzas() {
        pizzas = new ArrayList<Pizza>();
    }
    
    // Método para cadastrar nova pizza
    public void cadastrarPizza(Pizza pizza) {
        pizzas.add(pizza);
    }
    
    // Método para exibir todas as pizzas cadastradas
    public void exibirPizzas() {
        for (Pizza pizza : pizzas) {
            pizza.exibirPizza();
        }
    }
    
    // Método para buscar pizza por nome
    public Pizza buscarPizza(String nome) {
        for (Pizza pizza : pizzas) {
            if (pizza.getNome().equalsIgnoreCase(nome)) {
                return pizza;
            }
        }
        return null;
    }
}