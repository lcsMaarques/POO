package trab01;

public class Salgadinho {
    private String tipo;
    private String massa;
    private String recheio;
    private LocalDate dataValidade;

    public Salgadinho(String tipo, String massa, String recheio, LocalDate dataValidade) {
        this.tipo = tipo;
        this.massa = massa;
        this.recheio = recheio;
        this.dataValidade = dataValidade;
    }

    public boolean estaDentroDaValidade() {
        LocalDate hoje = LocalDate.now();
        return hoje.isBefore(dataValidade);
    }

    
}