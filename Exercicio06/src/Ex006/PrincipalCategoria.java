package Ex006;

import java.util.List;

public class PrincipalCategoria {
    private int id;
    private String nome;
    private List<Categoria> subcategorias;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Categoria> getSubcategorias() {
		return subcategorias;
	}
	public void setSubcategorias(List<Categoria> subcategorias) {
		this.subcategorias = subcategorias;
	}
    
   
}
