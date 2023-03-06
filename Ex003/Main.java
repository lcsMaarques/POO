package Ex003;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {

	public static void main(String[] args) throws ParseException {
	
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		
		Aluno aluno = new Aluno("Lucas Marques", "11.222.333-44", formato.parse("05/04/1999"), 15);
		Professor professor = new Professor("Roberto Martins", "222.333.444-55", formato.parse("01/03/1965"), "Geografia", 2700);
		Funcionario funcionario = new Funcionario("Ricardo Mão Sega", "333.444.555-66", formato.parse("18/09/1969"), "Faxineiro", 2200, formato.parse("02/012/2002"));		
		
		
		System.out.println("Informações do aluno: ");
		System.out.println("NOME: " +aluno.getNome());
		System.out.println("CPF: " +aluno.getCpf());
		System.out.println("Data de Nascimento: " +aluno.getData_nascimento());
		System.out.println("Matricula: " +aluno.getMatricula());
		System.out.println("Preço de 1000 cópias: " +aluno.tirarCopias(1000));
		
		System.out.println("\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
		
		System.out.println("Informações do professor: ");
		System.out.println("NOME: " +professor.getNome());
		System.out.println("CPF: " +professor.getCpf());
		System.out.println("Data de Nascimento: " +professor.getData_nascimento());
		System.out.println("Disciplina " +professor.getDisciplina());
		System.out.println("Salário: " +professor.getSalario());
		System.out.println("Preço de 1000 cópias: " +aluno.tirarCopias(1000));
		
		System.out.println("\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
		
		System.out.println("Informações do Funcionário: ");
		System.out.println("NOME: " +funcionario.getNome());
		System.out.println("CPF: " +funcionario.getCpf());
		System.out.println("Data de Nascimento: " +funcionario.getData_nascimento());
		System.out.println("Cargo " +funcionario.getCargo());
		System.out.println("Salário: " +funcionario.getSalario());
		System.out.println("Data de Admissão: " +funcionario.getData_admissao());
		System.out.println("Preço de 1000 cópias: " +aluno.tirarCopias(1000));

		System.out.println("\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");

	}
	
}
