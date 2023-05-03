package Controllers;

public class ProprietarioController {
    private PetShopModel model;
    private Scanner scanner;

    public ProprietarioController(PetShopModel model, Scanner scanner) {
        this.model = model;
        this.scanner = scanner;
    }

    public void cadastrarProprietario() {
        System.out.println("Digite o nome do proprietário:");
        String nome = scanner.next();
        System.out.println("Digite o CPF do proprietário:");
        String cpf = scanner.next();
        System.out.println("Digite o telefone do proprietário:");
        String telefone = scanner.next();
        Dono dono = new Dono(nome, cpf, telefone);
        model.adicionarDono(dono);
        System.out.println("Proprietário cadastrado com sucesso!");
        mostrarMenu();
    }
}