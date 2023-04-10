package Ex006;

import java.util.List;

public class CategoriaView {
    private CategoriaController categoriaController;
    
    public CategoriaView() {
        categoriaController = new CategoriaController();
    }
    
    public void exibirCategorias() {
        List<Categoria> categorias = categoriaController.listarCategorias();
        
        for(Categoria categoria : categorias) {
            System.out.println(categoria.getId() + " - " + categoria.getNome());
        }
    }
    
    
}
