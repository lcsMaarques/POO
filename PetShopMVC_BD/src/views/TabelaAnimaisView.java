package PetShopDB.mvc.views;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import PetShopDB.mvc.models.Animal;
import PetShopDB.mvc.models.CaoModel;
import PetShopDB.mvc.models.GatoModel;
import PetShopDB.mvc.models.PassaroModel;
import PetShopDB.mvc.models.ProprietarioModel;

public class TabelaAnimaisView extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTable tabela;
	private DefaultTableModel modeloTabela;

	public TabelaAnimaisView() {
		modeloTabela = new DefaultTableModel();
		modeloTabela.addColumn("ID");
		modeloTabela.addColumn("Nome");
		modeloTabela.addColumn("Idade");
		modeloTabela.addColumn("Raça");
		modeloTabela.addColumn("Cor");
		modeloTabela.addColumn("sexo");
		modeloTabela.addColumn("nº Anilha");
		modeloTabela.addColumn("Porte");
		modeloTabela.addColumn("Peso");
		modeloTabela.addColumn("Proprietários");

		tabela = new JTable(modeloTabela);
		tabela.setPreferredScrollableViewportSize(new Dimension(800, 400));
		tabela.getColumnModel().getColumn(9).setCellRenderer(new MultiLineTableCellRenderer());
		tabela.setRowHeight(tabela.getRowHeight() * 3);

		JScrollPane scrollPane = new JScrollPane(tabela);

		setLayout(new BorderLayout());
		add(scrollPane, BorderLayout.CENTER);

		setVisible(true);
	}

	public void renderizarAnimais(ArrayList<Animal> animais) {
		modeloTabela.setRowCount(0);
		Object[] linha;
		for (Animal a : animais) {
			String proprietarios = "";
			for (ProprietarioModel p : a.getProprietarios()) {
				proprietarios += p.getNome() + "\n";
			}
			if (!proprietarios.isBlank())
				proprietarios = proprietarios.substring(0, proprietarios.length() - 1);
			if (a.getClass().getSimpleName().equals("PassaroModel")) {
				linha = new Object[] { a.getID(), a.getNome(), a.getIdade(), a.getRaca(), a.getCor(), a.getSexo(),
						((PassaroModel) a).getNumeroAnilha(), "", "", proprietarios };
			} else if (a.getClass().getSimpleName().equals("CaoModel")) {
				linha = new Object[] { a.getID(), a.getNome(), a.getIdade(), a.getRaca(), a.getCor(), a.getSexo(), "",
						((CaoModel) a).getPorte(), ((CaoModel) a).getPeso(), proprietarios };
			} else {
				linha = new Object[] { a.getID(), a.getNome(), a.getIdade(), a.getRaca(), a.getCor(), a.getSexo(), "",
						((GatoModel) a).getPorte(), ((GatoModel) a).getPeso(), proprietarios };
			}
			modeloTabela.addRow(linha);
		}
	}

	public class MultiLineTableCellRenderer implements TableCellRenderer {
		private JTextArea textArea;

		public MultiLineTableCellRenderer() {
			textArea = new JTextArea();
		}

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			textArea.setText((String) value);
			int lineHeight = textArea.getFontMetrics(textArea.getFont()).getHeight();
			int desiredHeight = (lineHeight * textArea.getLineCount()) + 3; // Define a altura mínima da célula
			if (table.getRowHeight(row) != desiredHeight) {
				table.setRowHeight(row, desiredHeight);
			}
			return textArea;
		}
	}

}