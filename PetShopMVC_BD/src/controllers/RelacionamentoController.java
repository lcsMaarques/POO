package PetShopDB.mvc.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Objects;

import PetShopDB.mvc.dao.RelacionamentoDAO;
import PetShopDB.mvc.models.Animal;
import PetShopDB.mvc.models.ProprietarioModel;
import PetShopDB.mvc.views.RelacionarAnimalProprietarioView;
import PetShopDB.mvc.views.TabelaAnimaisView;
import PetShopDB.mvc.views.TabelaProprietariosView;

public class RelacionamentoController {

	private RelacionarAnimalProprietarioView rapv;
	private TabelaAnimaisView tav;
	private TabelaProprietariosView tpv;

	RelacionamentoDAO relacionamentoDAO;

	public RelacionamentoController(RelacionarAnimalProprietarioView rapv, TabelaAnimaisView tav,
			TabelaProprietariosView tpv) {
		this.rapv = rapv;
		this.tav = tav;
		this.tpv = tpv;

		rapv.setBotaoRelacionar(relacionar);

		relacionamentoDAO = new RelacionamentoDAO();
	}

	ActionListener relacionar = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

			Animal animal = rapv.getAnimalSelecionado();
			ProprietarioModel proprietario = rapv.getProprietarioSelecionado();

			if (Objects.isNull(proprietario)) {
				rapv.exibirMensagem("Selecione um proprietário.");
				return;
			}

			if (Objects.isNull(animal)) {
				rapv.exibirMensagem("Selecione um animal.");
				return;
			}

			try {
				if (relacionamentoDAO.existeRelacionamento(proprietario.getID(), animal.getID())) {
					rapv.exibirMensagem("O relacionamento informado já existe.");
					return;
				}
			} catch (SQLException e1) {
				rapv.exibirMensagem("Falha ao verificar a existência do relacionamento.");
				return;
			}

			try {
				relacionamentoDAO.relacionarProprietarioAnimal(proprietario.getID(), animal.getID());
			} catch (SQLException e1) {
				rapv.exibirMensagem("Falha ao realizar o relacionamento.");
				return;
			}

			rapv.exibirMensagem("Relacionamento realizado com sucesso!");
			
			AnimalController.atualizarAnimais();
			ProprietarioController.atualizarProprietarios();

			tav.renderizarAnimais(AnimalController.animais);
			tpv.renderizarProprietarios(ProprietarioController.proprietarios);

		}
	};

}