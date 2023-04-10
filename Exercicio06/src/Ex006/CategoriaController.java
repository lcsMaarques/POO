package Ex006;

public class CategoriaController {
    private CategoriaDAO categoriaDAO;
    
    public CategoriaController() {
        categoriaDAO = new CategoriaDAO();
    }
    
    public void criarCategoria(String nome) {
        Categoria categoria = new Categoria();
        categoria.setNome(nome);
        
        categoriaDAO.adicionarCategoria(categoria);
    }
    
    public void excluirCategoria(int id) {
        categoriaDAO.excluirCategoria(id);
    }
    
    public List<Categoria> listarCategorias() {
        return categoriaDAO.listarCategorias();
    }
    
    //outros métodos de gerenciamento de categorias
}
