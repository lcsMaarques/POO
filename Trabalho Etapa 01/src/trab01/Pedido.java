public class Pedido {
    private String nomeCliente;
    private List<ItemPedido> itens;
    private double taxaServico;

    public Pedido(String nomeCliente, List<ItemPedido> itens, double taxaServico) {
        this.nomeCliente = nomeCliente;
        this.itens = itens;
        this.taxaServico = taxaServico;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public double getTaxaServico() {
        return taxaServico;
    }

    public double calcularValorTotal() {
        double valorTotal = 0;
        for (ItemPedido item : itens) {
            valorTotal += item.calcularValor();
        }
        valorTotal += taxaServico;
        return valorTotal;
    }
}