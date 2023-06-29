package PetShopDB.mvc.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import PetShopDB.mvc.db.connection.ConexaoBanco;
import PetShopDB.mvc.models.Animal;
import PetShopDB.mvc.models.CaoModel;
import PetShopDB.mvc.models.GatoModel;
import PetShopDB.mvc.models.PassaroModel;

public class AnimalDAO {

	public ArrayList<Animal> buscarTodosAnimais() throws SQLException {
		ConexaoBanco.conectarBanco();

		Statement stmt = ConexaoBanco.getConnection().createStatement();
		ResultSet resultSet = stmt.executeQuery("SELECT a.*, c.porte as c_porte, c.peso as c_peso, "
				+ "g.porte as g_porte, g.peso as g_peso, p.numero_anilha,\r\n"
				+ "    CASE\r\n"
				+ "        WHEN c.id_animal IS NOT NULL THEN 'cao'\r\n"
				+ "        WHEN g.id_animal IS NOT NULL THEN 'gato'\r\n"
				+ "        WHEN p.id_animal IS NOT NULL THEN 'passaro'\r\n"
				+ "        ELSE 'desconhecido'\r\n"
				+ "    END AS tipo_animal\r\n"
				+ "FROM animais a\r\n"
				+ "LEFT JOIN caes c ON c.id_animal = a.id\r\n"
				+ "LEFT JOIN gatos g ON g.id_animal = a.id\r\n"
				+ "LEFT JOIN passaros p ON p.id_animal = a.id;");

		ArrayList<Animal> animais = new ArrayList<>();

		while (resultSet.next()) {
			Integer id = resultSet.getInt("id");
			String nome = resultSet.getString("nome");
			Integer idade = resultSet.getInt("idade");
			String raca = resultSet.getString("raca");
			String cor = resultSet.getString("cor");
			String sexo = resultSet.getString("sexo");
			String porteCao = resultSet.getString("c_porte");
            Double pesoCao = resultSet.getDouble("c_peso");
            String porteGato = resultSet.getString("g_porte");
            Double pesoGato = resultSet.getDouble("g_peso");
            String numeroAnilhaPassaro = resultSet.getString("numero_anilha");
            String tipoAnimal = resultSet.getString("tipo_animal");
			
            if (tipoAnimal.equals("cao")) {
            	animais.add(new CaoModel(id, nome, idade, raca, cor, sexo, porteCao, pesoCao));
            } else if (tipoAnimal.equals("gato")) {
            	animais.add(new GatoModel(id, nome, idade, raca, cor, sexo, porteGato, pesoGato));
            } else if (tipoAnimal.equals("passaro")) {
            	animais.add(new PassaroModel(id, nome, idade, raca, cor, sexo, numeroAnilhaPassaro));
            }
            
		}

		resultSet.close();
		stmt.close();
		ConexaoBanco.fecharConexao();

		System.out.println("Busca de animais realizada com sucesso!");
		return animais;
	}

	public void cadastrarAnimal(Animal animal) throws SQLException {
		ConexaoBanco.conectarBanco();
		// Inserindo dados
		String sql = "INSERT INTO animais (id, nome, idade, raca, cor, sexo) VALUES (?, ?, ?, ?, ?, ?)";

		PreparedStatement stmt = ConexaoBanco.getConnection().prepareStatement(sql);
		// Configurar os parâmetros da declaração preparada
		stmt.setInt(1, animal.getID());
		stmt.setString(2, animal.getNome());
		stmt.setInt(3, animal.getIdade());
		stmt.setString(4, animal.getRaca());
		stmt.setString(5, animal.getCor());
		stmt.setString(6, animal.getSexo());

		// Executar a declaração preparada
		int linhasAfetadas1 = stmt.executeUpdate();

		// Inserindo dados
		if (animal.getClass().getSimpleName().equals("PassaroModel"))
			sql = "INSERT INTO passaros (id_animal, numero_anilha) VALUES (?, ?)";
		else if (animal.getClass().getSimpleName().equals("CaoModel")) {
			sql = "INSERT INTO caes (id_animal, porte, peso) VALUES (?, ?, ?)";
		} else if (animal.getClass().getSimpleName().equals("GatoModel")) {
			sql = "INSERT INTO gatos (id_animal, porte, peso) VALUES (?, ?, ?)";
		}

		PreparedStatement stmt2 = ConexaoBanco.getConnection().prepareStatement(sql);
		// Configurar os parâmetros da declaração preparada
		stmt2.setInt(1, animal.getID());
		if (animal.getClass().getSimpleName().equals("PassaroModel")) {
			stmt2.setString(2, ((PassaroModel) animal).getNumeroAnilha());
		} else if (animal.getClass().getSimpleName().equals("CaoModel")) {
			stmt2.setString(2, ((CaoModel) animal).getPorte());
			stmt2.setDouble(3, ((CaoModel) animal).getPeso());
		} else if (animal.getClass().getSimpleName().equals("GatoModel")) {
			stmt2.setString(2, ((GatoModel) animal).getPorte());
			stmt2.setDouble(3, ((GatoModel) animal).getPeso());
		}

		// Executar a declaração preparada
		int linhasAfetadas2 = stmt2.executeUpdate();

		// Verificar se a inserção foi bem-sucedida
		if (linhasAfetadas1 > 0 && linhasAfetadas2 > 0) {
			System.out.println("Animal cadastrado com sucesso!");
		} else {
			System.out.println("Falha ao cadastrar o animal.");
		}

		stmt.close();
		stmt2.close();
		ConexaoBanco.fecharConexao();
	}

	public boolean existeAnimalPorId(Integer id) throws SQLException {
		ConexaoBanco.conectarBanco();
		boolean existe = false;

		String sql = "SELECT id FROM animais where id=?";

		PreparedStatement stmt = ConexaoBanco.getConnection().prepareStatement(sql);
		// Configurar os parâmetros da declaração preparada
		stmt.setInt(1, id);

		ResultSet resultSet = stmt.executeQuery();

		if (resultSet.next()) {
			existe = true;
		}

		resultSet.close();
		stmt.close();
		ConexaoBanco.fecharConexao();

		return existe;
	}
	
	public boolean existePassaroPorAnilha(String n_anilha) throws SQLException {
		ConexaoBanco.conectarBanco();
		boolean existe = false;

		String sql = "SELECT a.id FROM animais a\r\n"
				+ "JOIN passaros p ON p.id_animal = a.id\r\n"
				+ "WHERE p.numero_anilha = ?";

		PreparedStatement stmt = ConexaoBanco.getConnection().prepareStatement(sql);
		// Configurar os parâmetros da declaração preparada
		stmt.setString(1, n_anilha);

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