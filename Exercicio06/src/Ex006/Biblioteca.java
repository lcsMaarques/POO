package Ex006;

import javax.swing.text.html.ListView;

public class Main {
    public static void main(String[] args) {
        //instanciando as classes controladoras e views
        LivroController livroController = new LivroController();
        CategoriaController categoriaController = new CategoriaController();
        PrincipalCategoriaController principalCategoriaController = new PrincipalCategoriaController();
        LivroCategoriaController livroCategoriaController = new LivroCategoriaController();
        
        LivroView livroView = new ListView();
        CategoriaView categoriaView = new CategoriaView();
        PrincipalCategoriaView principalCategoriaView = new PrincipalCategoriaView();
        LivroCategoriaView livroCategoriaView = new LivroCategoriaView();
        
        //exibindo as opções para o usuário
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        
        do {
            System.out.println("Selecione uma opção:");
            System.out.println("1 - Gerenciar livros");
            System.out.println("2 - Gerenciar categorias");
            System.out.println("3 - Gerenciar categorias principais");
            System.out.println("4 - Gerenciar relação entre livros e categorias");
            System.out.println("0 - Sair");
            opcao = scanner.nextInt();
            
            switch(opcao) {
                case 1:
                    livroView.exibirLivros();
                    break;
                case 2:
                    categoriaView.exibirCategorias();
                    break;
                case 3:
                    principalCategoriaView.exibirPrincipalCategorias();
                    break;
                case 4:
                    livroCategoriaView.exibirLivroCategorias();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
            
        } while(opcao != 0);
    }
}