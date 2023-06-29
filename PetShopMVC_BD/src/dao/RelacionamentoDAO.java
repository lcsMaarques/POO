package PetShopDB.mvc.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import PetShopDB.mvc.db.connection.ConexaoBanco;
import PetShopDB.mvc.models.Animal;
import PetShopDB.mvc.models.CaoModel;
import PetShopDB.mvc.models.GatoModel;
import PetShopDB.mvc.models.PassaroModel;
import PetShopDB.mvc.models.ProprietarioModel;

public class RelacionamentoDAO {

	public ArrayList<Animal> buscarAnimaisPorProprietario(Integer idProprietario) throws SQLException {
		ConexaoBanco.conectarBanco();
		
		String sql = "select a.nome,\r\n"
				+ "	CASE\r\n"
				+ "        WHEN c.id_animal IS NOT NULL THEN 'cao'\r\n"
				+ "        WHEN g.id_animal IS NOT NULL THEN 'gato'\r\n"
				+ "        WHEN ps.id_animal IS NOT NULL THEN 'passaro'\r\n"
				+ "        ELSE 'desconhecido'\r\n"
				+ "    END AS tipo_animal\r\n"
				+ "from animais a \r\n"
				+ "join proprietarios_animais pa on a.id = pa.id_animal\r\n"
				+ "join proprietarios p on p.id = pa.id_proprietario\r\n"
				+ "left join caes c on c.id_animal = a.id\r\n"
				+ "left join gatos g on g.id_animal = a.id\r\n"
				+ "left join passaros ps on ps.id_animal = a.id\r\n"
				+ "where p.id = ?";

		PreparedStatement stmt = ConexaoBanco.getConnection().prepareStatement(sql);
		// Configurar os parâmetros da declaração preparada
		stmt.setInt(1, idProprietario);

		ResultSet resultSet = stmt.executeQuery();

		ArrayList<Animal> animais = new ArrayList<>();

		while (resultSet.next()) {
			String nome = resultSet.getString("nome");
			String tipoAnimal = resultSet.getString("tipo_animal");
			if (tipoAnimal.equals("cao")){
				animais.add(new CaoModel(nome));
			} else if (tipoAnimal.equals("gato")) {
				animais.add(new GatoModel(nome));
			} else if (tipoAnimal.equals("passaro")) {
				animais.add(new PassaroModel(nome));
			}
		}

		resultSet.close();
		stmt.close();
		ConexaoBanco.fecharConexao();

		System.out.println("Busca de animais por proprietário realizada com sucesso!");
		return animais;
	}
	
	public ArrayList<ProprietarioModel> buscarProprietariosPorAnimal(Integer idAnimal) throws SQLException {
		ConexaoBanco.conectarBanco();
		
		String sql = "select p.nome from proprietarios p\r\n"
				+ "join proprietarios_animais pa on pa.id_proprietario = p.id\r\n"
				+ "join animais a on pa.id_animal = a.id\r\n"
				+ "where a.id = ?";

		PreparedStatement stmt = ConexaoBanco.getConnection().prepareStatement(sql);
		// Configurar os parâmetros da declaração preparada
		stmt.setInt(1, idAnimal);

		ResultSet resultSet = stmt.executeQuery();

		ArrayList<ProprietarioModel> proprietarios = new ArrayList<>();

		while (resultSet.next()) {
			String nome = resultSet.getString("nome");
			proprietarios.add(new ProprietarioModel(nome));
		}

		resultSet.close();
		stmt.close();
		ConexaoBanco.fecharConexao();

		System.out.println("Busca de proprietários por animal realizada com sucesso!");
		return proprietarios;
	}

	public void relacionarProprietarioAnimal(Integer idProprietario, Integer idAnimal) throws SQLException {
		ConexaoBanco.conectarBanco();
		// Inserindo dados
		String sql = "INSERT INTO proprietarios_animais (id_proprietario, id_animal) VALUES (?, ?)";

		PreparedStatement stmt = ConexaoBanco.getConnection().prepareStatement(sql);
		// Configurar os parâmetros da declaração preparada
		stmt.setInt(1, idProprietario);
		stmt.setInt(2, idAnimal);

		// Executar a declaração preparada
		int linhasAfetadas = stmt.executeUpdate();

		// Verificar se a inserção foi bem-sucedida
		if (linhasAfetadas > 0) {
			System.out.println("Relacionamento realizado com sucesso!");
		} else {
			System.out.println("Falha ao realizar o relacionamento.");
		}

		stmt.close();
		ConexaoBanco.fecharConexao();
	}

	public boolean existeRelacionamento(Integer idProprietario, Integer idAnimal) throws SQLException {
		ConexaoBanco.conectarBanco();
		boolean existe = false;

		String sql = "SELECT * FROM proprietarios_animais where id_proprietario=? and id_animal=?";

		PreparedStatement stmt = ConexaoBanco.getConnection().prepareStatement(sql);
		// Configurar os parâmetros da declaração preparada
		stmt.setInt(1, idProprietario);
		stmt.setInt(2, idAnimal);

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