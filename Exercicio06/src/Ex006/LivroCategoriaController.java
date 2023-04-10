package Ex006;

public class LivroCategoriaController {
    private LivroCategoriaDAO livroCategoriaDAO;
    
    public LivroCategoriaController() {
        livroCategoriaDAO = new LivroCategoriaDAO();
    }
    
    public void adicionarLivroCategoria(int livroId, int categoriaId) {
        LivroCategoria livroCategoria = new LivroCategoria();
        livroCategoria.setLivroId(livroId);
        livroCategoria.setCategoriaId(categoriaId);
        
        livroCategoriaDAO.adicionarLivroCategoria(livroCategoria);
    }
    
    public void excluirLivroCategoria(int id) {
        livroCategoriaDAO.excluirLivroCategoria(id);
    }
    
    public List<LivroCategoria> listarLivroCategorias() {
        return livroCategoriaDAO.listarLivroCategorias();
    }
    
    //outros métodos de gerenciamento de relações entre livros e categorias
}
