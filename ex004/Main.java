package ex004;

import java.util.Scanner;

public class Main {

	Gatos gato = new Gatos ("Juarez", "3", "Persa", "Amarelo", "Macho", "Pequeno", 6);
	Caes cachorro = new Caes("Bolota", "7", "Pitbull", "Preto", "Femea", "Grande", 3);
	Passaros passaro = new Passaros("Tagarela", "1", "Canãrio", "Verde", "Macho", "Pequeno", 1, "002362");
	Dono dono = new Dono("Fábio", "Roberta", "Paulo");
	
	Scanner scanner = new Scanner(System.in);

    System.out.print("Digite o seu nome: ");
    String nome = scanner.nextLine();
	 
  
	
}
