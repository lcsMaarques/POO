package View;

public class Main {
    public static void main(String[] args) {
        BancoA bancoA = new BancoA();
        BancoB bancoB = new BancoB();

        Conta contaA = bancoA.criarConta("Cliente A", 1000);
        Conta contaB = bancoB.criarConta("Cliente B", 2000);

        bancoA.depositar(contaA, 500);
        bancoA.sacar(contaA, 300);
        bancoA.transferir(contaA, contaB, 400);

        bancoB.depositar(contaB, 1000);
        bancoB.sacar(contaB, 1500);
        bancoB.transferir(contaB, contaA, 800);

        System.out.println("Extrato da conta A:");
        System.out.println(contaA.getExtrato());

        System.out.println("Extrato da conta B:");
        System.out.println(contaB.getExtrato());
    }
}

