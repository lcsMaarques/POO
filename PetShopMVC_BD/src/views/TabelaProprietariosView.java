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
import PetShopDB.mvc.models.ProprietarioModel;

public class TabelaProprietariosView extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTable tabela;
	private DefaultTableModel modeloTabela;

	public TabelaProprietariosView() {
		modeloTabela = new DefaultTableModel();
		modeloTabela.addColumn("ID");
		modeloTabela.addColumn("Nome");
		modeloTabela.addColumn("CPF");
		modeloTabela.addColumn("Endereço");
		modeloTabela.addColumn("Animais");

		tabela = new JTable(modeloTabela);
		tabela.setPreferredScrollableViewportSize(new Dimension(600, 320));
		tabela.getColumnModel().getColumn(4).setCellRenderer(new MultiLineTableCellRenderer());
		tabela.setRowHeight(tabela.getRowHeight() * 3);

		JScrollPane scrollPane = new JScrollPane(tabela);

		setLayout(new BorderLayout());
		add(scrollPane, BorderLayout.CENTER);

		setVisible(true);
	}

	public void renderizarProprietarios(ArrayList<ProprietarioModel> proprietarios) {
		modeloTabela.setRowCount(0);
		for (ProprietarioModel p : proprietarios) {
			String animais = "";
			for (Animal a : p.getAnimais()) {
				animais += a.getNome() + "\n";
			}
			if (!animais.isBlank())
				animais = animais.substring(0, animais.length() - 1);
			modeloTabela.addRow(new Object[] { p.getID(), p.getNome(), p.getCpf(), p.getEndereco(), animais });
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