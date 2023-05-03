package View;

public interface InterfaceBanco {
	void manutencaoConta(Conta conta);
    boolean saque(Conta conta, double valor);
    boolean deposito(Conta conta, double valor);
    void extrato(Conta conta);
}
