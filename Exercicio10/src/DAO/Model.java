package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CadastroDAO {
    private Connection conexao;

    public CadastroDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public List<Cadastro> listarTodos() throws SQLException {
        List<Cadastro> cadastros = new ArrayList<>();

        String sql = "SELECT * FROM cadastro";

        try (PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Cadastro cadastro = new Cadastro();
                cadastro.setCPF(rs.getString("CPF"));
                cadastro.setNome(rs.getString("nome"));
                cadastro.setEndereco(rs.getString("endereco"));
                cadastro.setDataNascimento(rs.getDate("data_nascimento"));
                cadastros.add(cadastro);
            }
        }

        return cadastros;
    }

    // Implementar os métodos para inserção, atualização e exclusão de registros.
    // Exemplo de método para inserir um registro:
    /*
    public void inserir(Cadastro cadastro) throws SQLException {
        String sql = "INSERT INTO cadastro (CPF, nome, endereco, data_nascimento) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, cadastro.getCPF());
            stmt.setString(2, cadastro.getNome());
            stmt.setString(3, cadastro.getEndereco());
            stmt.setDate(4, cadastro.getDataNascimento());

            stmt.executeUpdate();
        }
    }
    */
}

public class Cadastro {
    private String CPF;
    private String nome;
    private String endereco;
    private Date dataNascimento;

    // Getters e Setters

    // Outros métodos, se necessário
}
