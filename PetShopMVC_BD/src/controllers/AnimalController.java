package PetShopDB.mvc.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import PetShopDB.mvc.dao.AnimalDAO;
import PetShopDB.mvc.dao.RelacionamentoDAO;
import PetShopDB.mvc.models.Animal;
import PetShopDB.mvc.models.CaoModel;
import PetShopDB.mvc.models.GatoModel;
import PetShopDB.mvc.models.PassaroModel;
import PetShopDB.mvc.views.CadastroAnimalView;
import PetShopDB.mvc.views.RelacionarAnimalProprietarioView;
import PetShopDB.mvc.views.RelatorioView;
import PetShopDB.mvc.views.TabelaAnimaisView;

public class AnimalController {

	static CadastroAnimalView cav;
	static TabelaAnimaisView tav;
	static RelacionarAnimalProprietarioView rapv;
	static RelatorioView rv;

	static AnimalDAO animalDao;
	static ArrayList<Animal> animais;
	static RelacionamentoDAO relacionamentoDao;

	public AnimalController(CadastroAnimalView _cav, TabelaAnimaisView _tav, RelacionarAnimalProprietarioView _rapv,
			RelatorioView _rv) {
		cav = _cav;
		tav = _tav;
		rapv = _rapv;
		rv = _rv;
		cav.setBotaoAnimal(new BotaoAnimal());

		animalDao = new AnimalDAO();
		relacionamentoDao = new RelacionamentoDAO();
		iniciarAnimais();
	}

	class BotaoAnimal implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (cav.getTextIdAnimal().isBlank() || cav.getTextNomeAnimal().isBlank() || cav.getTextCorAnimal().isBlank()
					|| cav.getTextRacaAnimal().isBlank() || cav.getTextIdadeAnimal().isBlank()
					|| cav.getTextSexoAnimal().isBlank()) {
				cav.exibirMensagem("Preencha todos os campos!");
				return;
			}

			Integer idadeMaxima = 25;

			if (cav.getTextEspecieAnimal().equals("Passaro")) {
				idadeMaxima = 80;
				if (cav.getTextNumeroAnilhaAnimal().isBlank()) {
					cav.exibirMensagem("Preencha todos os campos!");
					return;
				}
			} else {
				if (cav.getTextPesoAnimal().isBlank() || cav.getTextPorteAnimal().isBlank()) {
					cav.exibirMensagem("Preencha todos os campos!");
					return;
				}
			}

			Integer ID = null;
			Integer idade = null;

			try {
				ID = Integer.parseInt(cav.getTextIdAnimal());
				idade = Integer.parseInt(cav.getTextIdadeAnimal());
				if (ID < 0) {
					cav.exibirMensagem("O ID não pode ser negativo!");
					return;
				}
				if (idade < 0 || idade > idadeMaxima) {
					cav.exibirMensagem("Idade Inválida!");
					return;
				}
			} catch (Exception ex) {
				cav.exibirMensagem("O ID e idade do animal precisam ser númericos!");
				return;
			}

			Double peso = null;

			if (!cav.getTextEspecieAnimal().equals("Passaro")) {
				try {
					peso = Double.parseDouble(cav.getTextPesoAnimal().replace(",", "."));
					if (peso < 0) {
						cav.exibirMensagem("O peso não pode ser negativo!");
						return;
					}
				} catch (Exception ex) {
					cav.exibirMensagem("O peso do animal precisa ser númerico!");
					return;
				}
			}

			String nome = cav.getTextNomeAnimal();
			String raca = cav.getTextRacaAnimal();
			String sexo = cav.getTextSexoAnimal();
			String cor = cav.getTextCorAnimal();
			String numeroAnilha = cav.getTextNumeroAnilhaAnimal();
			String porte = cav.getTextPorteAnimal();

			try {
				if (animalDao.existeAnimalPorId(ID)) {
					cav.exibirMensagem("Já existe um animal cadastrado com o ID '" + ID + "'");
					return;
				}
			} catch (SQLException e2) {
				System.out.println("Falha ao verificar a existência do animal.");
				return;
			}

			Animal animal;
			String especie = "Passaro";

			if (cav.getTextEspecieAnimal().equals("Passaro")) {

				try {
					if (animalDao.existePassaroPorAnilha(numeroAnilha)) {
						cav.exibirMensagem("Já existe um pássaro cadastrado com a anilha '" + numeroAnilha + "'");
						return;
					}
				} catch (SQLException e1) {
					System.out.println("Falha ao verificar a existência do passaro.");
					return;
				}

				animal = new PassaroModel(ID, nome, idade, raca, cor, sexo, numeroAnilha);
			} else if (cav.getTextEspecieAnimal().equals("Cao")) {
				especie = "Cachorro";
				animal = new CaoModel(ID, nome, idade, raca, cor, sexo, porte, peso);
			} else {
				especie = "Gato";
				animal = new GatoModel(ID, nome, idade, raca, cor, sexo, porte, peso);
			}

			try {
				animalDao.cadastrarAnimal(animal);
			} catch (SQLException e1) {
				cav.exibirMensagem("Falha ao cadastrar o animal.");
				return;
			}

			cav.exibirMensagem(especie + " cadastrado com sucesso!");

			iniciarAnimais();

		}

	}

	public static void atualizarAnimais() {
		for (Animal a : animais) {
			try {
				a.setProprietarios(relacionamentoDao.buscarProprietariosPorAnimal(a.getID()));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private static void iniciarAnimais() {
		try {
			animais = animalDao.buscarTodosAnimais();
		} catch (SQLException e1) {
			cav.exibirMensagem("Falha ao buscar os animais.");
			return;
		}

		atualizarAnimais();

		rapv.setComboAnimais(animais);
		ArrayList<Animal> animaisCombo = new ArrayList<>();
		animaisCombo.add(null);
		animaisCombo.addAll(animais);
		rv.setComboAnimais(animaisCombo);

		animais.sort((a, b) -> {
			return a.getIdade().compareTo(b.getIdade());
		});

		cav.limparCamposAnimal();
		tav.renderizarAnimais(animais);
	} 

}