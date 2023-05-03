package Views;

import java.util.Scanner;

import Controllers.CachorroController;

public class CachorroView {

    private CachorroController cachorroController;

    public CachorroView(CachorroController cachorroController) {
        this.cachorroController = cachorroController;
    }

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Menu Cachorro:");
        System.out.println("1. Cadastrar Cachorro");
        System.out.println("2. Listar Cachorros");
        System.out.println("3. Voltar");
        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                System.out.println("Digite o nome do cachorro:");
                String nome = scanner.next();
                System.out.println("Digite a idade do cachorro:");
                int idade = scanner.nextInt();
                System.out.println("Digite a raça do cachorro:");
                String raca = scanner.next();
                System.out.println("Digite a cor do cachorro:");
                String cor = scanner.next();
                System.out.println("Digite o sexo do cachorro:");
                char sexo = scanner.next().charAt(0);
                System.out.println("Digite o porte do cachorro:");
                String porte = scanner.next();
                System.out.println("Digite o peso do cachorro:");
                double peso = scanner.nextDouble();
                cachorroController.cadastrarCachorro(nome, idade, raca, cor, sexo, porte, peso);
                mostrarMenu();
                break;
            case 2:
                cachorroController.listarCachorros();
                mostrarMenu();
                break;
            case 3:
                // Voltar ao menu principal
                break;
            default:
                System.out.println("Opção inválida!");
                mostrarMenu();
                break;
        }
    }
}

