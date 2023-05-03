package View;

public class BancoB implements InterfaceBanco {

    private Map<String, Conta> contas = new HashMap<>();

    @Override
    public void manutencaoConta(Conta conta) {
        contas.put(conta.getConta(), conta);
    }

    @Override
    public boolean saque(Conta conta, double valor) {
        Conta c = contas.get(conta.getConta());
        if (c != null && c.getSaldo() >= valor && (c.getSaldo() - valor) >= -500) {
            c.setSaldo(c.getSaldo() - valor);
            return true;
        }
        return false;
    }

    @Override
    public boolean deposito(Conta conta, double valor) {
        Conta c = contas.get(conta.getConta());
        if (c != null) {
            c.setSaldo(c.getSaldo() + valor);
            return true;
        }
        return false;
    }

    @Override
    public void extrato(Conta conta) {
        Conta c = contas.get(conta.getConta());
        if (c != null) {
            System.out.println("Conta: " + c.getConta());
            System.out.println("Dono: " + c.getDono());
            System.out.println("Saldo: " + c.getSaldo());
        }
    }

    @Override
    public boolean transferencia(Conta contaOrigem, Conta contaDestino, double valor) {
        if (saque(contaOrigem, valor)) {
            deposito(contaDestino, valor);
            return true;
        }
        return false;
    }
}

