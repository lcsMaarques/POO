package ex001;

import java.util.Date;

public class alunos {


	private String nome;
	private Integer Cpf;
	private Date dataNascimento;
	private String email;
	
	public alunos() {
		super();
	}


	public alunos(String nome, Integer Cpf, Date dataNascimento, String email) {
		super();
		this.nome = nome;
		this.Cpf = Cpf;
		this.dataNascimento = dataNascimento;
		this.email = email;
	}

	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}

	public void setCpf(Integer Cpf) {
		this.Cpf = Cpf;
	}

	public Integer getCpf() {
		return Cpf;
	}

	public Date getdataNascimento() {
		return dataNascimento;
	}
	public void setdataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public void setemail(String email) {
		this.email = email;
	}
	public String getemail() {
		return email;
	}
	public static Integer idade(alunos aluno) {
		Integer idade = 0;
		idade = new Date().getYear() - aluno.getdataNascimento().getYear();
		return idade;
	}

	
}
