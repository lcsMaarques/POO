package PetShopDB.mvc.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import PetShopDB.mvc.db.connection.ConexaoBanco;
import PetShopDB.mvc.models.ProprietarioModel;

public class ProprietarioDAO {

	public ArrayList<ProprietarioModel> buscarTodosProprietarios() throws SQLException {
		ConexaoBanco.conectarBanco();

		Statement stmt = ConexaoBanco.getConnection().createStatement();
		ResultSet resultSet = stmt.executeQuery("SELECT * FROM proprietarios");

		ArrayList<ProprietarioModel> proprietarios = new ArrayList<>();

		while (resultSet.next()) {
			Integer id = resultSet.getInt("id");
			String cpf = resultSet.getString("cpf");
			String nome = resultSet.getString("nome");
			String endereco = resultSet.getString("endereco");
			proprietarios.add(new ProprietarioModel(id, cpf, nome, endereco));
		}

		resultSet.close();
		stmt.close();
		ConexaoBanco.fecharConexao();

		System.out.println("Busca de proprietários realizada com sucesso!");
		return proprietarios;
	}

	public void cadastrarProprietario(ProprietarioModel proprietario) throws SQLException {
		ConexaoBanco.conectarBanco();
		// Inserindo dados
		String sql = "INSERT INTO proprietarios (id, cpf, nome, endereco) VALUES (?, ?, ?, ?)";

		PreparedStatement stmt = ConexaoBanco.getConnection().prepareStatement(sql);
		// Configurar os parâmetros da declaração preparada
		stmt.setString(1, proprietario.getID().toString());
		stmt.setString(2, proprietario.getCpf());
		stmt.setString(3, proprietario.getNome());
		stmt.setString(4, proprietario.getEndereco());

		// Executar a declaração preparada
		int linhasAfetadas = stmt.executeUpdate();

		// Verificar se a inserção foi bem-sucedida
		if (linhasAfetadas > 0) {
			System.out.println("Proprietário cadastrado com sucesso!");
		} else {
			System.out.println("Falha ao cadastrar o proprietário.");
		}

		stmt.close();
		ConexaoBanco.fecharConexao();
	}

	public boolean existeProprietario(String propriedade, Object valor) throws SQLException {
		ConexaoBanco.conectarBanco();
		boolean existe = false;

		String sql = "SELECT id FROM proprietarios where " + propriedade + "=?";

		PreparedStatement stmt = ConexaoBanco.getConnection().prepareStatement(sql);
		// Configurar os parâmetros da declaração preparada
		stmt.setString(1, valor.toString());

		ResultSet resultSet = stmt.executeQuery();

		if (resultSet.next()) {
			existe = true;
		}

		resultSet.close();
		stmt.close();
		ConexaoBanco.fecharConexao();

		return existe;
	}

}