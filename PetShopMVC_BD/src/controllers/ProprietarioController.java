package PetShopDB.mvc.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import PetShopDB.mvc.dao.ProprietarioDAO;
import PetShopDB.mvc.dao.RelacionamentoDAO;
import PetShopDB.mvc.models.ProprietarioModel;
import PetShopDB.mvc.views.CadastroProprietarioView;
import PetShopDB.mvc.views.RelacionarAnimalProprietarioView;
import PetShopDB.mvc.views.TabelaProprietariosView;

public class ProprietarioController {

	static CadastroProprietarioView cpv;
	static TabelaProprietariosView tpv;
	static RelacionarAnimalProprietarioView rapv;

	static ProprietarioDAO proprietarioDao;
	static RelacionamentoDAO relacionamentoDao;
	
	static ArrayList<ProprietarioModel> proprietarios;

	public ProprietarioController(CadastroProprietarioView _cpv, TabelaProprietariosView _tpv,
			RelacionarAnimalProprietarioView _rapv) {
		cpv = _cpv;
		tpv = _tpv;
		rapv = _rapv;
		cpv.setBotaoProprietario(new BotaoProprietario());

		proprietarioDao = new ProprietarioDAO();
		relacionamentoDao = new RelacionamentoDAO();
		iniciarProprietarios();
	}

	class BotaoProprietario implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			String cpf = cpv.getTextCpfProprietario();

			if (cpv.getTextIdProprietario().isBlank() || cpv.getTextNomeProprietario().isBlank()
					|| cpf.replace("-", "").replace(".", "").replace("_", "").length() == 0
					|| cpv.getTextEnderecoProprietario().isBlank()) {
				cpv.exibirMensagem("Preencha todos os campos!");
				return;
			}

			Integer ID = null;

			try {
				ID = Integer.parseInt(cpv.getTextIdProprietario());
				if (ID < 0) {
					cpv.exibirMensagem("O ID não pode ser negativo!");
					return;
				}
			} catch (Exception ex) {
				cpv.exibirMensagem("O ID informado precisa ser númerico!");
				return;
			}

			String nome = cpv.getTextNomeProprietario();
			String endereco = cpv.getTextEnderecoProprietario();

			try {
				if (proprietarioDao.existeProprietario("id", ID)) {
					cpv.exibirMensagem("Já existe um proprietário cadastrado com o ID '" + ID + "'");
					return;
				}
			} catch (SQLException e2) {
				cpv.exibirMensagem("Falha ao verificar a existência do proprietário.");
				return;
			}

			try {
				if (proprietarioDao.existeProprietario("cpf", cpf)) {
					cpv.exibirMensagem("Já existe um proprietário cadastrado com o CPF informado!");
					return;
				}
			} catch (SQLException e2) {
				cpv.exibirMensagem("Falha ao verificar a existência do proprietário.");
				return;
			}

			try {
				proprietarioDao.cadastrarProprietario(new ProprietarioModel(ID, cpf, nome, endereco));
			} catch (SQLException e1) {
				cpv.exibirMensagem("Falha ao cadastrar o proprietário.");
				return;
			}
			cpv.exibirMensagem("Proprietário cadastrado com sucesso!");
			cpv.limparCamposProprietario();

			iniciarProprietarios();
		}

	}
	
	public static void atualizarProprietarios() {
		for (ProprietarioModel p : proprietarios) {
			try {
				p.setAnimais(relacionamentoDao.buscarAnimaisPorProprietario(p.getID()));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private static void iniciarProprietarios() {
		try {
			proprietarios = proprietarioDao.buscarTodosProprietarios();
		} catch (SQLException e1) {
			cpv.exibirMensagem("Falha ao buscar os proprietários.");
			return;
		}

		atualizarProprietarios();

		rapv.setComboProprietarios(proprietarios);
		tpv.renderizarProprietarios(proprietarios);
	}

}