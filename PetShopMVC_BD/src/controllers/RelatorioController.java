package PetShopDB.mvc.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import PetShopDB.mvc.dao.RelatorioDAO;
import PetShopDB.mvc.models.Animal;
import PetShopDB.mvc.models.ProprietarioModel;
import PetShopDB.mvc.pdf.HtmlPdf;
import PetShopDB.mvc.views.RelatorioView;

public class RelatorioController {

	private static RelatorioView rv;
	
	private static RelatorioDAO relatorioDao;

	public RelatorioController(RelatorioView _rv) {
		rv = _rv;
		
		carregarAnimais();

		rv.setBotaoRelatorio(gerarRelatorio);
		relatorioDao = new RelatorioDAO();
	}

	public static void carregarAnimais() {
		ArrayList<Animal> animais = new ArrayList<>();
		animais.add(null);
		animais.addAll(AnimalController.animais);
		rv.setComboAnimais(animais);
	}

	ActionListener gerarRelatorio = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			rv.limparCamposRelatorio();
			
			String cpf = rv.getTextCpfProprietario();
			Animal animal = rv.getAnimalSelecionado();
			
			String tituloPdf = "";
			String conteudoPdf = "";
			String nomePdf = "";
			
			if(animal == null && cpf.replace("_", "").length() != 14) {
				nomePdf = "animais_por_proprietarios_completo";
				tituloPdf = "Animais por Proprietários";
				conteudoPdf = gerarHtmlAnimaisPorProprietarios(ProprietarioController.proprietarios);
				boolean sucesso = HtmlPdf.gerarPdf(tituloPdf, conteudoPdf, nomePdf);
				if(sucesso)
					rv.exibirMensagem("PDF gerado com sucesso!");
				else
					rv.exibirMensagem("Erro ao gerar o PDF.");
				return;
			}
			
			if(animal == null) {
				tituloPdf = "Animais por Proprietário";
				ArrayList<ProprietarioModel> proprietario = new ArrayList<>();
				for(ProprietarioModel p : ProprietarioController.proprietarios) {
					if(p.getCpf().equals(cpf)) {
						nomePdf = "animais_proprietario_" + p.getCpf() + "_" + p.getNome();
						proprietario.add(p); break;
					}
				}
				conteudoPdf = gerarHtmlAnimaisPorProprietarios(proprietario);
				boolean sucesso = HtmlPdf.gerarPdf(tituloPdf, conteudoPdf, nomePdf);
				if(sucesso)
					rv.exibirMensagem("PDF gerado com sucesso!");
				else
					rv.exibirMensagem("Erro ao gerar o PDF.");
				return;
			}

			if (cpf.replace("_", "").length() != 14) {
				nomePdf = "proprietarios_animal_" + animal.getID() + "_" + animal.getNome();
				tituloPdf = "Proprietários por Animal";
				conteudoPdf = gerarHtmlProprietariosPorAnimal(animal);
				boolean sucesso = HtmlPdf.gerarPdf(tituloPdf, conteudoPdf, nomePdf);
				if(sucesso)
					rv.exibirMensagem("PDF gerado com sucesso!");
				else
					rv.exibirMensagem("Erro ao gerar o PDF.");
				return;
			}
			
			tituloPdf = "Animais por Proprietário";
			ArrayList<ProprietarioModel> proprietario = new ArrayList<>();
			for(ProprietarioModel p : ProprietarioController.proprietarios) {
				if(p.getCpf().equals(cpf)) {
					nomePdf = "animais_proprietarios_" + p.getCpf() + "_" + p.getNome() + "_" +  animal.getID() + "_" + animal.getNome();
					proprietario.add(p); break;
				}
			}
			conteudoPdf += gerarHtmlAnimaisPorProprietarios(proprietario);
			conteudoPdf += "<h1>Proprietários por Animal</h1>";
			conteudoPdf += gerarHtmlProprietariosPorAnimal(animal);
			System.out.println(conteudoPdf);
			boolean sucesso = HtmlPdf.gerarPdf(tituloPdf, conteudoPdf, nomePdf);
			if(sucesso)
				rv.exibirMensagem("PDF gerado com sucesso!");
			else
				rv.exibirMensagem("Erro ao gerar o PDF.");
			return;

		}
	};
	
	public static String gerarHtmlAnimaisPorProprietarios(ArrayList<ProprietarioModel> proprietarios) {
		String conteudoPdf = "";
		for(ProprietarioModel p : proprietarios) {
			conteudoPdf += "\n<h2>{{nomeProprietario}}</h2>\r\n"
					+ "  <table>\r\n"
					+ "    <tr>\r\n"
					+ "      <th>Animal</th>\r\n"
					+ "      <th>Espécie</th>\r\n"
					+ "    </tr>";
			conteudoPdf = conteudoPdf.replace("{{nomeProprietario}}", p.getNome());
			ArrayList<Animal> animais = new ArrayList<>();
			try {
				animais = relatorioDao.buscarAnimaisPorCpfProprietario(p.getCpf());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			for(Animal a : animais) {
				String tipoAnimal = "";
				if(a.getClass().getSimpleName().equals("CaoModel")) {
					tipoAnimal = "Cachorro";
				} else if (a.getClass().getSimpleName().equals("GatoModel")) {
					tipoAnimal = "Gato";
				} else if (a.getClass().getSimpleName().equals("PassaroModel")) {
					tipoAnimal = "Pássaro";
				}
				conteudoPdf += "<tr>\r\n"
						+ "      <td class=\"animal-name\">{{nomeAnimal}}</td>\r\n"
						+ "      <td class=\"animal-species\">{{tipoAnimal}}</td>\r\n"
						+ "    </tr>";
				conteudoPdf = conteudoPdf.replace("{{nomeAnimal}}", a.getNome());
				conteudoPdf = conteudoPdf.replace("{{tipoAnimal}}", tipoAnimal);
			}
			conteudoPdf += "\n</table>";
		}
		return conteudoPdf;
	}
	
	public static String gerarHtmlProprietariosPorAnimal(Animal animal) {
		String conteudoPdf = "";
		String tipoAnimal = "";
		if(animal.getClass().getSimpleName().equals("CaoModel")) {
			tipoAnimal = "Cachorro";
		} else if (animal.getClass().getSimpleName().equals("GatoModel")) {
			tipoAnimal = "Gato";
		} else if (animal.getClass().getSimpleName().equals("PassaroModel")) {
			tipoAnimal = "Pássaro";
		}
		conteudoPdf += "\n<h2>{{nomeAnimal}} - <span style=\"color:#ff33ff;font-size:18px\">{{tipoAnimal}}</span></h2>\r\n"
				+ "  <table>\r\n"
				+ "    <tr>\r\n"
				+ "      <th>Proprietários</th>\r\n"
				+ "    </tr>";
		conteudoPdf = conteudoPdf.replace("{{nomeAnimal}}", animal.getNome());
		conteudoPdf = conteudoPdf.replace("{{tipoAnimal}}", tipoAnimal);
		ArrayList<ProprietarioModel> proprietarios = new ArrayList<>();
		try {
			proprietarios = relatorioDao.buscarProprietariosPorAnimal(animal.getID());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(ProprietarioModel p : proprietarios) {
			conteudoPdf += "<tr>\r\n"
					+ "      <td class=\"animal-name\">{{nomeProprietario}}</td>\r\n"
					+ "    </tr>";
			conteudoPdf = conteudoPdf.replace("{{nomeProprietario}}", p.getNome());
		}
		conteudoPdf += "\n</table>";
		return conteudoPdf;
	}

}