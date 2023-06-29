package PetShopDB.mvc.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import PetShopDB.mvc.models.Animal;
import PetShopDB.mvc.models.ProprietarioModel;

public class RelacionarAnimalProprietarioView extends JPanel {

	private static final long serialVersionUID = 1L;

	// Define os componentes
	private static JComboBox<Animal> comboAnimais = new JComboBox<>();
	private static JComboBox<ProprietarioModel> comboProprietarios = new JComboBox<>();

	JButton botaoRelacionar;

	public RelacionarAnimalProprietarioView() {

		// Cria os componentes
		JLabel labelTitulo = new JLabel("Relacionar Proprietário e Animal");
		JLabel labelProprietario = new JLabel("Proprietário:");
		JLabel labelAnimal = new JLabel("Animal:");
		botaoRelacionar = new JButton("Relacionar");

		// Personalização dos componentes
		labelTitulo.setFont(new Font("Arial", Font.BOLD, 17));
		labelTitulo.setForeground(Color.DARK_GRAY);

		labelProprietario.setBorder(BorderFactory.createEmptyBorder(10, 0, 5, 0));
		labelProprietario.setFont(new Font("Arial", Font.BOLD, 14));
		labelProprietario.setForeground(Color.DARK_GRAY);

		labelAnimal.setBorder(BorderFactory.createEmptyBorder(20, 0, 5, 0));
		labelAnimal.setFont(new Font("Arial", Font.BOLD, 14));
		labelAnimal.setForeground(Color.DARK_GRAY);

		comboProprietarios.setMaximumSize(new Dimension(Integer.MAX_VALUE, 26));
		comboProprietarios.setAlignmentX(LEFT_ALIGNMENT);

		comboAnimais.setMaximumSize(new Dimension(Integer.MAX_VALUE, 26));
		comboAnimais.setAlignmentX(LEFT_ALIGNMENT);

		botaoRelacionar.setBackground(Color.DARK_GRAY);
		botaoRelacionar.setForeground(Color.WHITE);
		botaoRelacionar.setFont(new Font("Arial", Font.BOLD, 14));

		// Adiciona os componentes ao container usando o BoxLayout
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		add(labelTitulo);
		add(Box.createRigidArea(new Dimension(0, 30)));
		add(labelProprietario);
		add(comboProprietarios);
		add(labelAnimal);
		add(comboAnimais);
		add(Box.createRigidArea(new Dimension(0, 30)));
		add(botaoRelacionar);
		setVisible(true);
	}

	public void exibirMensagem(String mensagem) {
		JOptionPane.showMessageDialog(this, mensagem);
	}

	public void setBotaoRelacionar(ActionListener actionListener) {
		botaoRelacionar.addActionListener(actionListener);
	}

	public ProprietarioModel getProprietarioSelecionado() {
		return (ProprietarioModel) comboProprietarios.getSelectedItem();
	}

	public Animal getAnimalSelecionado() {
		return (Animal) comboAnimais.getSelectedItem();
	}

	public void setComboProprietarios(ArrayList<ProprietarioModel> proprietarios) {
		comboProprietarios.setModel(new DefaultComboBoxModel<>(proprietarios.toArray(new ProprietarioModel[0])));
	}

	public void setComboAnimais(ArrayList<Animal> animais) {
		comboAnimais.setModel(new DefaultComboBoxModel<>(animais.toArray(new Animal[0])));
	}

	public void limparCamposRelacionamento() {
		if (comboProprietarios.getItemCount() > 0)
			comboProprietarios.setSelectedIndex(0);
		if (comboAnimais.getItemCount() > 0)
			comboAnimais.setSelectedIndex(0);
	}

}