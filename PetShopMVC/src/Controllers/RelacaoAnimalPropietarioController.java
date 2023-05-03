package Controllers;

import java.util.Scanner;

public class RelacaoAnimalProprietarioController {
    private PetShopModel model;
    private Scanner scanner;

    public RelacaoAnimalProprietarioController(PetShopModel model, Scanner scanner) {
        this.model = model;
        this.scanner = scanner;
    }

    public void listarAnimaisPorProprietario() {
        System.out.println("Digite o CPF do proprietário:");
        String cpf = scanner.next();
        Proprietario proprietario = model.getProprietarioByCpf(cpf);
        if (proprietario == null) {
            System.out.println("Proprietário não encontrado!");
        } else {
            ArrayList<Animais> animais = proprietario.getAnimais();
            System.out.println("Animais do proprietário " + proprietario.getNome() + ":");
            for (Animais animal : animais) {
                System.out.println(animal.getNome() + " (" + animal.getEspecie() + ")");
            }
        }
        mostrarMenu();
    }

    public void listarAnimaisPorDono() {
        ArrayList<Dono> donos = model.getProprietario();
        for (Proprietario proprietario : proprietario) {
            System.out.println("Proprietário: " + proprietario.getNome());
            ArrayList<Animais> animais = proprietario.getAnimais();
            for (Animal animal : animais) {
                System.out.println("  - " + animal.getNome() + " (" + animal.getEspecie() + ")");
            }
        }
        mostrarMenu();
    }

    public void mostrarMenu() {
        System.out.println("---- Menu Relação Animal-Proprietário ----");
        System.out.println("1. Listar animais de um proprietário");
        System.out.println("2. Listar todos os animais e seus respectivos proprietários");
        System.out.println("3. Voltar ao menu principal");
        int opcao = scanner.nextInt();
        switch (opcao) {
            case 1:
                listarAnimaisPorProprietario();
                break;
            case 2:
                listarAnimaisPorDono();
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
