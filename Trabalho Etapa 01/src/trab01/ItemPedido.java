public abstract class ItemPedido {
    protected double precoVenda;
    protected Date dataValidade;
    protected double peso;

    public ItemPedido(double precoVenda, Date dataValidade, double peso) {
        this.precoVenda = precoVenda;
        this.dataValidade = dataValidade;
        this.peso = peso;
    }

    public abstract String getDescricao();

    public double calcularValor() {
        return precoVenda * peso;
    }
}