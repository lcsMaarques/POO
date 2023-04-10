package Ex006;

public class PrincipalCategoriaController {
    private PrincipalCategoriaDAO principalCategoriaDAO;
    
    public PrincipalCategoriaController() {
        principalCategoriaDAO = new PrincipalCategoriaDAO();
    }
    
    public void criarPrincipalCategoria(String nome) {
        PrincipalCategoria principalCategoria = new PrincipalCategoria();
        principalCategoria.setNome(nome);
        
        principalCategoriaDAO.adicionarPrincipalCategoria(principalCategoria);
    }
    public void excluirPrincipalCategoria(int id) {
        principalCategoriaDAO.excluirPrincipalCategoria(id);
    }
    
    public List<PrincipalCategoria> listarPrincipalCategorias() {
        return principalCategoriaDAO.listarPrincipalCategorias();
    }
    
    
}