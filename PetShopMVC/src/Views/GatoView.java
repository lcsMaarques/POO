package Views;

import java.util.Scanner;

public class GatoView {

    private Scanner sc;
    private GatoController gatoController;

    public GatoView() {
        this.sc = new Scanner(System.in);
        this.gatoController = new GatoController();
    }

    public void exibirMenu() {
        int opcao = 0;

        do {
            System.out.println("\nMenu de Gatos:");
            System.out.println("1 - Cadastrar gato");
            System.out.println("2 - Listar gatos");
            System.out.println("0 - Voltar ao menu principal");

            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarGato();
                    break;
                case 2:
                    listarGatos();
                    break;
                case 0:
                    System.out.println("Retornando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }

        } while (opcao != 0);
    }

    private void cadastrarGato() {
        System.out.println("\nCadastro de Gato:");
        System.out.print("Nome: ");
        String nome = sc.next();
        System.out.print("Idade: ");
        int idade = sc.nextInt();
        System.out.print("Raça: ");
        String raca = sc.next();
        System.out.print("Cor: ");
        String cor = sc.next();
        System.out.print("Sexo (M/F): ");
        char sexo = sc.next().charAt(0);
        System.out.print("Pelagem: ");
        String pelagem = sc.next();

        gatoController.cadastrarGato(nome, idade, raca, cor, sexo, pelagem);
    }

    private void listarGatos() {
        gatoController.listarGatos();
    }
}

