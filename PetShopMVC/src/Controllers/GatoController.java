package Controllers;

import java.util.ArrayList;
import java.util.Scanner;

import Models.Gato;
import Models.Proprietario;

public class GatoController {
    private PetShopModel model;
    private Scanner scanner;

    public GatoController(PetShopModel model, Scanner scanner) {
        this.model = model;
        this.scanner = scanner;
    }

    public void cadastrarGato() {
        System.out.println("Digite o nome do gato:");
        String nome = scanner.next();
        System.out.println("Digite a idade do gato:");
        int idade = scanner.nextInt();
        System.out.println("Digite a raça do gato:");
        String raca = scanner.next();
        System.out.println("Digite a cor do gato:");
        String cor = scanner.next();
        System.out.println("Digite o sexo do gato:");
        String sexo = scanner.next();
        System.out.println("Digite o porte do gato:");
        String porte = scanner.next();
        System.out.println("Digite o peso do gato:");
        double peso = scanner.nextDouble();
        Gato gato = new Gato(nome, idade, raca, cor, sexo, porte, peso);
        System.out.println("Digite o CPF do dono do gato:");
        String cpf = scanner.next();
        Proprietario proprietario = model.getPropietarioByCpf(cpf);
        if (proprietario == null) {
            System.out.println("Proprietario não encontrado!");
        } else {
        	proprietario.adicionarAnimal(gato);
            System.out.println("Gato cadastrado com sucesso!");
        }
        mostrarMenu();
    }

    public void listarGatos() {
        ArrayList<Proprietario> proprietarios = model.getDonos();
        for (Proprietario proprietario : proprietario) {
            ArrayList<Animais> animais = proprietario.getAnimais();
            for (Animais animal : animais) {
                if (animal instanceof Gato) {
                    System.out.println("Proprietario: " + proprietario.getNome() + " | Gato: " + animal.getNome());
                }
            }
        }
        mostrarMenu();
    }

    public void mostrarMenu() {
        System.out.println("---- Menu Gato ----");
        System.out.println("1. Cadastrar gato");
        System.out.println("2. Listar gatos");
        System.out.println("3. Voltar ao menu principal");
        int opcao = scanner.nextInt();
        switch (opcao) {
            case 1:
                cadastrarGato();
                break;
            case 2:
                listarGatos();
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

