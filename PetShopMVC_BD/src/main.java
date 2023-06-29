package main;

import PetShopDB.mvc.controllers.AnimalController;
import PetShopDB.mvc.controllers.ProprietarioController;
import PetShopDB.mvc.controllers.RelacionamentoController;
import PetShopDB.mvc.controllers.RelatorioController;
import PetShopDB.mvc.views.CadastroAnimalView;
import PetShopDB.mvc.views.CadastroProprietarioView;
import PetShopDB.mvc.views.RelacionarAnimalProprietarioView;
import PetShopDB.mvc.views.RelatorioView;
import PetShopDB.mvc.views.TabelaAnimaisView;
import PetShopDB.mvc.views.TabelaProprietariosView;
import PetShopDB.mvc.views.TelaInicialView;

public class main {

	public static void main(String[] args) {
		CadastroProprietarioView cpv = new CadastroProprietarioView();
		CadastroAnimalView cav = new CadastroAnimalView();
		RelacionarAnimalProprietarioView rapv = new RelacionarAnimalProprietarioView();
		TabelaAnimaisView tav = new TabelaAnimaisView();
		TabelaProprietariosView tpv = new TabelaProprietariosView();
		RelatorioView rv = new RelatorioView();

		new AnimalController(cav, tav, rapv, rv);
		new ProprietarioController(cpv, tpv, rapv);
		new RelacionamentoController(rapv, tav, tpv);
		new RelatorioController(rv);

		new TelaInicialView(cpv, cav, tav, rapv, tpv, rv);
	}

}