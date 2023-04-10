package Ex006;

import java.util.List;

public class LivroController {
    private LivroDAO livroDAO;
    
    public LivroController() {
        livroDAO = new LivroDAO();
    }
    
    public void adicionarLivro(String titulo, String autor, String descricao) {
        Livro livro = new Livro();
        livro.setTitulo(titulo);
        livro.setAutor(autor);
        livro.setDescricao(descricao);
        
        livroDAO.adicionarLivro(livro);
    }
    
    public void excluirLivro(int id) {
        livroDAO.excluirLivro(id);
    }
    
    public List<Livro> listarLivros() {
        return livroDAO.listarLivros();
    }
    
}
