package Controllers;

import java.util.ArrayList;
import java.util.Scanner;

import Models.Cachorro;
import Models.Proprietario;

public class CachorroController {
    private PetShopModel model;
    private Scanner scanner;

    public CachorroController(PetShopModel model, Scanner scanner) {
        this.model = model;
        this.scanner = scanner;
    }

    public void cadastrarCachorro() {
        System.out.println("Digite o nome do cachorro:");
        String nome = scanner.next();
        System.out.println("Digite a idade do cachorro:");
        int idade = scanner.nextInt();
        System.out.println("Digite a raça do cachorro:");
        String raca = scanner.next();
        System.out.println("Digite a cor do cachorro:");
        String cor = scanner.next();
        System.out.println("Digite o sexo do cachorro:");
        String sexo = scanner.next();
        System.out.println("Digite o porte do cachorro:");
        String porte = scanner.next();
        System.out.println("Digite o peso do cachorro:");
        double peso = scanner.nextDouble();
        Cachorro cachorro = new Cachorro(nome, idade, raca, cor, sexo, porte, peso);
        System.out.println("Digite o CPF do dono do cachorro:");
        String cpf = scanner.next();
        Proprietario proprietario = model.getProprietarioByCpf(cpf);
        if (proprietario == null) {
            System.out.println("Dono não encontrado!");
        } else {
        	proprietario.adicionarAnimal(cachorro);
            System.out.println("Cachorro cadastrado com sucesso!");
        }
        mostrarMenu();
    }

    public void listarCachorros() {
        ArrayList<Proprietario> proprietarios = model.getProprietario();
        for (Proprietario proprietario : proprietario) {
            ArrayList<Animais> animais = proprietario.getAnimais();
            for (Animais animal : animais) {
                if (animal instanceof Cachorro) {
                    System.out.println("Proprietario: " + proprietario.getNome() + " | Cachorro: " + animal.getNome());
                }
            }
        }
        mostrarMenu();
    }

    public void mostrarMenu() {
        System.out.println("---- Menu Cachorro ----");
        System.out.println("1. Cadastrar cachorro");
        System.out.println("2. Listar cachorros");
        System.out.println("3. Voltar ao menu principal");
        int opcao = scanner.nextInt();
        switch (opcao) {
            case 1:
                cadastrarCachorro();
                break;
            case 2:
                listarCachorros();
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

