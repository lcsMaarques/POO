package PetShopDB.mvc.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.MaskFormatter;

import PetShopDB.mvc.models.Animal;

public class RelatorioView extends JPanel {

	private static final long serialVersionUID = 1L;

	// Define os componentes
	JButton botaoRelatorio;
	JFormattedTextField formattedTextCpf;
	private static JComboBox<Animal> comboAnimais = new JComboBox<>();

	public RelatorioView() {

		// Cria os componentes
		JLabel labelTitulo = new JLabel("Gerar Relatório");
		JLabel labelAnimal = new JLabel("Animal:");
		JLabel labelCfp = new JLabel("CPF:");

		formattedTextCpf = new JFormattedTextField();

		MaskFormatter formato = null;
		try {
			formato = new MaskFormatter("###.###.###-##");
			formato.setPlaceholderCharacter('_');
		} catch (ParseException ex) {
			ex.printStackTrace();
		}

		formattedTextCpf = new JFormattedTextField(formato);
		formattedTextCpf.setColumns(14);
		formattedTextCpf.setPreferredSize(new Dimension(120, 25));

		botaoRelatorio = new JButton("Gerar");

		// Personalização dos componentes
		labelTitulo.setFont(new Font("Arial", Font.BOLD, 17));
		labelTitulo.setForeground(Color.DARK_GRAY);

		labelAnimal.setBorder(BorderFactory.createEmptyBorder(20, 0, 5, 0));
		labelAnimal.setFont(new Font("Arial", Font.BOLD, 14));
		labelAnimal.setForeground(Color.DARK_GRAY);

		labelCfp.setBorder(BorderFactory.createEmptyBorder(30, 0, 5, 0));
		labelCfp.setFont(new Font("Arial", Font.BOLD, 14));
		labelCfp.setForeground(Color.DARK_GRAY);

		comboAnimais.setPreferredSize(new Dimension(120, 25));
		comboAnimais.setAlignmentX(LEFT_ALIGNMENT);

		botaoRelatorio.setBackground(Color.DARK_GRAY);
		botaoRelatorio.setForeground(Color.WHITE);
		botaoRelatorio.setFont(new Font("Arial", Font.BOLD, 14));

		// Adiciona os componentes ao container usando o BoxLayout
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(labelTitulo);
		add(labelCfp);
		add(formattedTextCpf);
		add(labelAnimal);
		add(comboAnimais);
		add(Box.createRigidArea(new Dimension(0, 25)));
		add(botaoRelatorio);
		setVisible(true);
	}

	public void exibirMensagem(String mensagem) {
		JOptionPane.showMessageDialog(this, mensagem);
	}

	public String getTextCpfProprietario() {
		return formattedTextCpf.getText();
	}

	public Animal getAnimalSelecionado() {
		return (Animal) comboAnimais.getSelectedItem();
	}

	public void setComboAnimais(ArrayList<Animal> animais) {
		comboAnimais.setModel(new DefaultComboBoxModel<>(animais.toArray(new Animal[0])));
	}

	public void limparCamposRelatorio() {
		if (comboAnimais.getItemCount() > 0)
			comboAnimais.setSelectedIndex(0);
		formattedTextCpf.setText("");
	}

	public void setBotaoRelatorio(ActionListener actionListener) {
		this.botaoRelatorio.addActionListener(actionListener);
	}

}