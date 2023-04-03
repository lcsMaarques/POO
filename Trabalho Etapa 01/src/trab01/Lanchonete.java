import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Lanchonete {
    private List<Pedido> pedidos;
    private Cardapio cardapio;

    public Lanchonete() {
        pedidos = new ArrayList<>();
        cardapio = new Cardapio();
    }

    public void realizarPedido(String nomeCliente, List<ItemPedido> itens, double taxaServico) {
        Pedido pedido = new Pedido(nomeCliente, itens, taxaServico);
        pedidos.add(pedido);
        double valorTotal = pedido.calcularValorTotal();
        System.out.println("Valor total do pedido: R$ " + valorTotal);
    }

    public void gerarNotaFiscal(Pedido pedido, double valorPago) {
        double troco = valorPago - pedido.calcularValorTotal();
        System.out.println("Nome do cliente: " + pedido.getNomeCliente());
        System.out.println("Itens consumidos: ");
        for (ItemPedido item : pedido.getItens()) {
            System.out.println(item.getDescricao());
        }
        System.out.println("Taxa de serviço: R$ " + pedido.getTaxaServico());
        System.out.println("Valor total do pedido: R$ " + pedido.calcularValorTotal());
        System.out.println("Valor pago: R$ " + valorPago);
        System.out.println("Troco: R$ " + troco);
    }

    public void adicionarPizza(Pizza pizza) {
        cardapio.adicionarPizza(pizza);
    }

    public void adicionarLanche(Lanche lanche) {
        cardapio.adicionarLanche(lanche);
    }

    public void adicionarSalgadinho(Salgadinho salgadinho) {
        cardapio.adicionarSalgadinho(salgadinho);
    }

    public void exibirCardapio() {
        cardapio.exibir();
    }
}import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Lanchonete {
    private List<Pedido> pedidos;
    private Cardapio cardapio;

    public Lanchonete() {
        pedidos = new ArrayList<>();
        cardapio = new Cardapio();
    }

    public void realizarPedido(String nomeCliente, List<ItemPedido> itens, double taxaServico) {
        Pedido pedido = new Pedido(nomeCliente, itens, taxaServico);
        pedidos.add(pedido);
        double valorTotal = pedido.calcularValorTotal();
        System.out.println("Valor total do pedido: R$ " + valorTotal);
    }

    public void gerarNotaFiscal(Pedido pedido, double valorPago) {
        double troco = valorPago - pedido.calcularValorTotal();
        System.out.println("Nome do cliente: " + pedido.getNomeCliente());
        System.out.println("Itens consumidos: ");
        for (ItemPedido item : pedido.getItens()) {
            System.out.println(item.getDescricao());
        }
        System.out.println("Taxa de serviço: R$ " + pedido.getTaxaServico());
        System.out.println("Valor total do pedido: R$ " + pedido.calcularValorTotal());
        System.out.println("Valor pago: R$ " + valorPago);
        System.out.println("Troco: R$ " + troco);
    }

    public void adicionarPizza(Pizza pizza) {
        cardapio.adicionarPizza(pizza);
    }

    public void adicionarLanche(Lanche lanche) {
        cardapio.adicionarLanche(lanche);
    }

    public void adicionarSalgadinho(Salgadinho salgadinho) {
        cardapio.adicionarSalgadinho(salgadinho);
    }

    public void exibirCardapio() {
        cardapio.exibir();
    }
}