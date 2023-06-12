package DAO;

import conexão.ConexaoBancoDados;
import model.Cadastro;
import model.CadastroDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (Connection conexao = ConexaoBancoDados.obterConexao()) {
            CadastroDAO cadastroDAO = new CadastroDAO(conexao);

            // a. Realizar o select * na base;
            List<Cadastro> cadastros = cadastroDAO.listarTodos();

            for (Cadastro cadastro : cadastros) {
                System.out.println(cadastro.getCPF() + " - " + cadastro.getNome() + " - " +
                        cadastro.getEndereco() + " - " + cadastro.getDataNascimento());
            }

            // b. Inserir 5 registros de pessoas na tabela cadastro;
            // Implemente a lógica para inserir os registros aqui

            // c. Realizar o select * na base;
            cadastros = cadastroDAO.listarTodos();

            for (Cadastro cadastro : cadastros) {
                System.out.println(cadastro.getCPF() + " - " + cadastro.getNome() + " - " +
                        cadastro.getEndereco() + " - " + cadastro.getDataNascimento());
            }

            // d. Atualizar o 3 registro alterando o CPF para "1234567890" e o nome para "Beltrano";
            // Implemente a lógica para atualizar o registro aqui

            // e. Realizar o select * na base;
            cadastros = cadastroDAO.listarTodos();

            for (Cadastro cadastro : cadastros) {
                System.out.println(cadastro.getCPF() + " - " + cadastro.getNome() + " - " +
                        cadastro.getEndereco() + " - " + cadastro.getDataNascimento());
            }

            // f. Deletar 3 desses 5 registros;
            // Implemente a lógica para excluir os registros aqui

            // g. Realizar o select * na base;
            cadastros = cadastroDAO.listarTodos();

            for (Cadastro cadastro : cadastros) {
                System.out.println(cadastro.getCPF() + " - " + cadastro.getNome() + " - " +
                        cadastro.getEndereco() + " - " + cadastro.getDataNascimento());
            }

            // h. Realizar o delete de todos os registros;
            // Implemente a lógica para excluir todos os registros aqui

            // i. Realizar o select * na base;
            cadastros = cadastroDAO.listarTodos();

            for (Cadastro cadastro : cadastros) {
                System.out.println(cadastro.getCPF() + " - " + cadastro.getNome() + " - " +
                        cadastro.getEndereco() + " - " + cadastro.getDataNascimento());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}