package Controllers;

import java.util.ArrayList;
import java.util.Scanner;

public class PassaroController {
    private PetShopModel model;
    private Scanner scanner;

    public PassaroController(PetShopModel model, Scanner scanner) {
        this.model = model;
        this.scanner = scanner;
    }

    public void cadastrarPassaro() {
        System.out.println("Digite o nome do pássaro:");
        String nome = scanner.next();
        System.out.println("Digite a idade do pássaro:");
        int idade = scanner.nextInt();
        System.out.println("Digite a raça do pássaro:");
        String raca = scanner.next();
        System.out.println("Digite a cor do pássaro:");
        String cor = scanner.next();
        System.out.println("Digite o sexo do pássaro:");
        String sexo = scanner.next();
        System.out.println("Digite o número da anilha do pássaro:");
        int numeroAnilha = scanner.nextInt();
        Passaro passaro = new Passaro(nome, idade, raca, cor, sexo, numeroAnilha);
        System.out.println("Digite o CPF do dono do pássaro:");
        String cpf = scanner.next();
        Proprietario proprietario = model.getProprietarioByCpf(cpf);
        if (proprietario == null) {
            System.out.println("Proprietario não encontrado!");
        } else {
        	proprietario.adicionarAnimal(passaro);
            System.out.println("Pássaro cadastrado com sucesso!");
        }
        mostrarMenu();
    }

    public void listarPassaros() {
        ArrayList<Proprietario> proprietario = model.getProprietario();
        for (Proprietario dono : proprietario) {
            ArrayList<Animal> animais = proprietario.getAnimais();
            for (Animais animal : animais) {
                if (animal instanceof Passaro) {
                    System.out.println("Proprietario: " + proprietario.getNome() + " | Pássaro: " + animal.getNome());
                }
            }
        }
        mostrarMenu();
    }

    public void mostrarMenu() {
        System.out.println("---- Menu Pássaro ----");
        System.out.println("1. Cadastrar pássaro");
        System.out.println("2. Listar pássaros");
        System.out.println("3. Voltar ao menu principal");
        int opcao = scanner.nextInt();
        switch (opcao) {
            case 1:
                cadastrarPassaro();
                break;
            case 2:
                listarPassaros();
                break;
            case 3:
                PetShopView view = new PetShopView(model);
                view.mostrarMenu();
                break;
            default:
                System.out.println("Opção inválida!");
                mostrarMenu();
                break;
        }
    }
}

