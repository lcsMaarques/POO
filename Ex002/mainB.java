package Ex002;

import java.text.ParseException;

public class mainB {
	public mainB(String[] args) throws ParseException {
		
		livros livros = new livros(null, null, null, null);
		categoria categoria = new categoria(null,null);
		
		//1º livro
		System.out.println("Informe o nome de um livro: \n");
		System.out.println("Nome do livro: \n" +livros.getNome());
		System.out.println("Autor do livro: \n"+livros.getAutor());
		System.out.println("ID do livro: \n"+livros.getIdLivro());
		System.out.println("Ano de Publicacão do livro: \n"+livros.getAno_publicacao());
		System.out.println("Qual a categoria do livro: \n"+categoria.getNomeCat());
		System.out.println("ID do livro: \n"+categoria.getIdCategoria());
	
		livros.setNome("Harry Porteira e a Pedra Filosofica");
		livros.setAutor("Homer Simpson");
		livros.setIdLivro("01");
		livros.setAno_publicacao("19/05/1950");
		categoria.setNomeCat("Ficção");
		categoria.setIdCategoria("01");
		
		//2º livro
		System.out.println("Informe o nome de um livro: \n");
		System.out.println("Nome do livro: \n" +livros.getNome());
		System.out.println("Autor do livro: \n"+livros.getAutor());
		System.out.println("ID do livro: \n"+livros.getIdLivro());
		System.out.println("Ano de Publicacão do livro: \n"+livros.getAno_publicacao());
		System.out.println("Qual a categoria do livro: \n"+categoria.getNomeCat());
		System.out.println("ID do livro: \n"+categoria.getIdCategoria());
	
		livros.setNome("Rapidos e Nervosos");
		livros.setAutor("Marge Simpson");
		livros.setIdLivro("02");
		livros.setAno_publicacao("24/04/1944");
		categoria.setNomeCat("Corrida");
		categoria.setIdCategoria("02");
			
		//3º Livro
		System.out.println("Informe o nome de um livro: \n");
		System.out.println("Nome do livro: \n" +livros.getNome());
		System.out.println("Autor do livro: \n"+livros.getAutor());
		System.out.println("ID do livro: \n"+livros.getIdLivro());
		System.out.println("Ano de Publicacão do livro: \n"+livros.getAno_publicacao());
		System.out.println("Qual a categoria do livro: \n"+categoria.getNomeCat());
		System.out.println("ID do livro: \n"+categoria.getIdCategoria());
	
		livros.setNome("Segunda-feia 13");
		livros.setAutor("Michael Jackson");
		livros.setIdLivro("03");
		livros.setAno_publicacao("13/03/1933");
		categoria.setNomeCat("Terror");
		categoria.setIdCategoria("03");
		
		//4º Livro
		System.out.println("Informe o nome de um livro: \n");
		System.out.println("Nome do livro: \n" +livros.getNome());
		System.out.println("Autor do livro: \n"+livros.getAutor());
		System.out.println("ID do livro: \n"+livros.getIdLivro());
		System.out.println("Ano de Publicacão do livro: \n"+livros.getAno_publicacao());
		System.out.println("Qual a categoria do livro: \n"+categoria.getNomeCat());
		System.out.println("ID do livro: \n"+categoria.getIdCategoria());
	
		livros.setNome("Manda Gastar");
		livros.setAutor("Rei Julian");
		livros.setIdLivro("04");
		livros.setAno_publicacao("01/02/1999");
		categoria.setNomeCat("Aventura");
		categoria.setIdCategoria("04");
		
		//5º Livro
		System.out.println("Informe o nome de um livro: \n");
		System.out.println("Nome do livro: \n" +livros.getNome());
		System.out.println("Autor do livro: \n"+livros.getAutor());
		System.out.println("ID do livro: \n"+livros.getIdLivro());
		System.out.println("Ano de Publicacão do livro: \n"+livros.getAno_publicacao());
		System.out.println("Qual a categoria do livro: \n"+categoria.getNomeCat());
		System.out.println("ID do livro: \n"+categoria.getIdCategoria());
	
		livros.setNome("A Bruxa");
		livros.setAutor("Darth Vader");
		livros.setIdLivro("05");
		livros.setAno_publicacao("10/07/2015");
		categoria.setNomeCat("Terror");
		categoria.setIdCategoria("03");
		
		//6º Livro
		System.out.println("Informe o nome de um livro: \n");
		System.out.println("Nome do livro: \n" +livros.getNome());
		System.out.println("Autor do livro: \n"+livros.getAutor());
		System.out.println("ID do livro: \n"+livros.getIdLivro());
		System.out.println("Ano de Publicacão do livro: \n"+livros.getAno_publicacao());
		System.out.println("Qual a categoria do livro: \n"+categoria.getNomeCat());
		System.out.println("ID do livro: \n"+categoria.getIdCategoria());
	
		livros.setNome("Rei Arthur");
		livros.setAutor("Arthur");
		livros.setIdLivro("06");
		livros.setAno_publicacao("15/02/2012");
		categoria.setNomeCat("Aventura");
		categoria.setIdCategoria("04");
		
		//7º Livro
		System.out.println("Informe o nome de um livro: \n");
		System.out.println("Nome do livro: \n" +livros.getNome());
		System.out.println("Autor do livro: \n"+livros.getAutor());
		System.out.println("ID do livro: \n"+livros.getIdLivro());
		System.out.println("Ano de Publicacão do livro: \n"+livros.getAno_publicacao());
		System.out.println("Qual a categoria do livro: \n"+categoria.getNomeCat());
		System.out.println("ID do livro: \n"+categoria.getIdCategoria());
	
		livros.setNome("Juras que Parque ?");
		livros.setAutor("Peixonauta");
		livros.setIdLivro("07");
		livros.setAno_publicacao("07/04/2001");
		categoria.setNomeCat("Ficção");
		categoria.setIdCategoria("01");
		
		//8º Livro
		System.out.println("Informe o nome de um livro: \n");
		System.out.println("Nome do livro: \n" +livros.getNome());
		System.out.println("Autor do livro: \n"+livros.getAutor());
		System.out.println("ID do livro: \n"+livros.getIdLivro());
		System.out.println("Ano de Publicacão do livro: \n"+livros.getAno_publicacao());
		System.out.println("Qual a categoria do livro: \n"+categoria.getNomeCat());
		System.out.println("ID do livro: \n"+categoria.getIdCategoria());
	
		livros.setNome("Corrida Maluca");
		livros.setAutor("Vin Gasolina");
		livros.setIdLivro("08");
		livros.setAno_publicacao("01/03/2023");
		categoria.setNomeCat("Corrida");
		categoria.setIdCategoria("02");
		
		//9º Livro
		System.out.println("Informe o nome de um livro: \n");
		System.out.println("Nome do livro: \n" +livros.getNome());
		System.out.println("Autor do livro: \n"+livros.getAutor());
		System.out.println("ID do livro: \n"+livros.getIdLivro());
		System.out.println("Ano de Publicacão do livro: \n"+livros.getAno_publicacao());
		System.out.println("Qual a categoria do livro: \n"+categoria.getNomeCat());
		System.out.println("ID do livro: \n"+categoria.getIdCategoria());
	
		livros.setNome("A Faculdade");
		livros.setAutor("Andradas");
		livros.setIdLivro("08");
		livros.setAno_publicacao("10/07/2015");
		categoria.setNomeCat("Terror");
		categoria.setIdCategoria("03");
		
		//10º Livro
		System.out.println("Informe o nome de um livro: \n");
		System.out.println("Nome do livro: \n" +livros.getNome());
		System.out.println("Autor do livro: \n"+livros.getAutor());
		System.out.println("ID do livro: \n"+livros.getIdLivro());
		System.out.println("Ano de Publicacão do livro: \n"+livros.getAno_publicacao());
		System.out.println("Qual a categoria do livro: \n"+categoria.getNomeCat());
		System.out.println("ID do livro: \n"+categoria.getIdCategoria());
	
		livros.setNome("Homem Aranha");
		livros.setAutor("Naruto Uzumaki");
		livros.setIdLivro("10");
		livros.setAno_publicacao("12/01/1999");
		categoria.setNomeCat("Ficção");
		categoria.setIdCategoria("01");
	}
}