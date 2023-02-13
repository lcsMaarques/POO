package ex001;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class main {

	public static void main(String[] args) throws ParseException {
		alunos aluno1 = new alunos(); 
		alunos aluno2 = new alunos();
		alunos aluno3 = new alunos();

		int idadeAluno1 = 0;
		int idadeAluno2 = 0;
		int idadeAluno3 = 0;
		
		
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
		Date dataNascimento = formato.parse("23/11/1986");

		aluno1.setNome("Lucas Marques");
		aluno1.setCpf(11223344);
		aluno1.setdataNascimento(formato.parse("01/01/1900"));
		aluno1.setemail("lucas@gmail.com");
		
		System.out.println("Informações do primeiro aluno: ");
		System.out.println("Nome: "+aluno1.getNome());
		System.out.println("CPF: "+aluno1.getCpf());
		System.out.println("Data de Nascimento: "+aluno1.getdataNascimento());
		System.out.println("E-mail: "+aluno1.getemail());
		System.out.println("\n+++++++++++++++++++++++++++++++++++++++\n");
		
		aluno2.setNome("Rodrigo de Souza");
		aluno2.setCpf(22334455);
		aluno2.setdataNascimento(formato.parse("02/02/1800"));
		aluno2.setemail("rodrigo@gmail.com");
		System.out.println("Informações do segundo aluno:");
		System.out.println("Nome: "+aluno2.getNome());
		System.out.println("CPF: "+aluno2.getCpf());
		System.out.println("Data de Nascimento: "+aluno2.getdataNascimento());
		System.out.println("E-mail: "+aluno2.getemail());
		System.out.println("\n+++++++++++++++++++++++++++++++++++++++\n");
		
		aluno3.setNome("Anderson Marcos ");
		aluno3.setCpf(33445566);
		aluno3.setdataNascimento(formato.parse("03/03/1700"));
		aluno3.setemail("anderson@gmail.com");
		System.out.println("Informações do terceiro aluno:");
		System.out.println("Nome: "+aluno3.getNome());
		System.out.println("CPF: "+aluno3.getCpf());
		System.out.println("Data de Nascimento: "+aluno3.getdataNascimento());
		System.out.println("E-mail: "+aluno3.getemail());

		idadeAluno1 = alunos.idade(aluno1);
		idadeAluno2 = alunos.idade(aluno2);
		idadeAluno3 = alunos.idade(aluno3);
				
	
		if(idadeAluno1 > idadeAluno2) {
			if(idadeAluno1 > idadeAluno3) {
			System.out.println("O aluno " +aluno1.getNome()+ "é mais velho que o aluno " +aluno2.getNome());
			}
			else {
				System.out.println("O aluno " +aluno3.getNome()+ "é mais velho que o aluno " +aluno1.getNome());
			}
		}
		else if(idadeAluno2 > idadeAluno3){
			System.out.println("O aluno " +aluno2.getNome()+ "é mais velho que o aluno " +aluno3.getNome()+ " e mais velho que o aluno " +aluno1);
		}
		else {
			System.out.println("O aluno " +aluno3.getNome()+ "é mais velho que o aluno " +aluno1.getNome()+ " e mais velho que o aluno " +aluno2.getNome());
		}
	}
			
		
	}



