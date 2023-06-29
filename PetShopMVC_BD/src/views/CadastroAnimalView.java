package PetShopDB.mvc.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class CadastroAnimalView extends JPanel {

	private static final long serialVersionUID = 1L;

	// Define os componentes
	private static JTextField textIdAnimal, textNomeAnimal, textIdadeAnimal, textRacaAnimal, textCorAnimal,
			textPesoAnimal, textNumeroAnilhaAnimal;
	private static JRadioButton sexoFemeaButton, sexoMachoButton, caoButton, gatoButton;
	private static JButton botaoAnimal;
	private static JComboBox<String> comboPortes;
	private static JLabel labelPeso, labelPorte, labelNumeroAnilha;

	private static String especie = "Cao";
	private static String sexo = "F";

	public CadastroAnimalView() {

		// Cria os componentes
		JLabel labelTitulo = new JLabel("Cadastro do Animal");
		JLabel labelId = new JLabel("ID:");
		JLabel labelNome = new JLabel("Nome:");
		JLabel labelIdade = new JLabel("Idade:");
		JLabel labelRaca = new JLabel("Raça:");
		JLabel labelCor = new JLabel("Cor:");
		labelPeso = new JLabel("Peso (kg):");
		JLabel labelSexo = new JLabel("Sexo:");
		labelPorte = new JLabel("Porte:");
		labelNumeroAnilha = new JLabel("Número da Anilha:");
		JLabel labelEspecie = new JLabel("Espécie:");

		textIdAnimal = new JTextField(8);
		textNomeAnimal = new JTextField(8);
		textIdadeAnimal = new JTextField(8);
		textRacaAnimal = new JTextField(8);
		textCorAnimal = new JTextField(8);
		textPesoAnimal = new JTextField(8);
		textNumeroAnilhaAnimal = new JTextField(8);

		JPanel radioPanel = new JPanel();
		ButtonGroup sexoGroup = new ButtonGroup();
		sexoFemeaButton = new JRadioButton("F");
		sexoMachoButton = new JRadioButton("M");
		sexoFemeaButton.setSelected(true);
		sexoGroup.add(sexoFemeaButton);
		sexoGroup.add(sexoMachoButton);
		radioPanel.add(sexoFemeaButton);
		radioPanel.add(sexoMachoButton);

		JPanel radio2Panel = new JPanel();
		ButtonGroup especieGroup = new ButtonGroup();
		gatoButton = new JRadioButton("Gato");
		caoButton = new JRadioButton("Cachorro");
		JRadioButton passaroButton = new JRadioButton("Pássaro");
		caoButton.setSelected(true);
		especieGroup.add(caoButton);
		especieGroup.add(gatoButton);
		especieGroup.add(passaroButton);
		radio2Panel.add(caoButton);
		radio2Panel.add(gatoButton);
		radio2Panel.add(passaroButton);

		comboPortes = new JComboBox<>(new String[] { "Pequeno", "Médio", "Grande" });

		JPanel esquerdaPanel = new JPanel();
		JPanel direitaPanel = new JPanel();
		JPanel containerPanel = new JPanel();

		botaoAnimal = new JButton("Salvar");

		setarFormularioVisivel();

		// Personalização dos componentes
		labelTitulo.setFont(new Font("Arial", Font.BOLD, 17));
		labelTitulo.setForeground(Color.DARK_GRAY);

		labelId.setBorder(BorderFactory.createEmptyBorder(20, 0, 5, 0));
		labelId.setFont(new Font("Arial", Font.BOLD, 14));
		labelId.setForeground(Color.DARK_GRAY);

		labelNome.setBorder(BorderFactory.createEmptyBorder(10, 0, 5, 0));
		labelNome.setFont(new Font("Arial", Font.BOLD, 14));
		labelNome.setForeground(Color.DARK_GRAY);

		labelIdade.setBorder(BorderFactory.createEmptyBorder(10, 0, 5, 0));
		labelIdade.setFont(new Font("Arial", Font.BOLD, 14));
		labelIdade.setForeground(Color.DARK_GRAY);

		labelRaca.setBorder(BorderFactory.createEmptyBorder(10, 0, 5, 0));
		labelRaca.setFont(new Font("Arial", Font.BOLD, 14));
		labelRaca.setForeground(Color.DARK_GRAY);

		labelCor.setBorder(BorderFactory.createEmptyBorder(10, 0, 5, 0));
		labelCor.setFont(new Font("Arial", Font.BOLD, 14));
		labelCor.setForeground(Color.DARK_GRAY);

		labelPeso.setBorder(BorderFactory.createEmptyBorder(10, 0, 5, 0));
		labelPeso.setFont(new Font("Arial", Font.BOLD, 14));
		labelPeso.setForeground(Color.DARK_GRAY);

		labelSexo.setBorder(BorderFactory.createEmptyBorder(15, 0, 5, 0));
		labelSexo.setFont(new Font("Arial", Font.BOLD, 14));
		labelSexo.setForeground(Color.DARK_GRAY);

		labelPorte.setBorder(BorderFactory.createEmptyBorder(10, 0, 5, 0));
		labelPorte.setFont(new Font("Arial", Font.BOLD, 14));
		labelPorte.setForeground(Color.DARK_GRAY);

		labelNumeroAnilha.setBorder(BorderFactory.createEmptyBorder(10, 0, 5, 0));
		labelNumeroAnilha.setFont(new Font("Arial", Font.BOLD, 14));
		labelNumeroAnilha.setForeground(Color.DARK_GRAY);

		labelEspecie.setBorder(BorderFactory.createEmptyBorder(20, 0, 5, 0));
		labelEspecie.setFont(new Font("Arial", Font.BOLD, 14));
		labelEspecie.setForeground(Color.DARK_GRAY);

		textIdAnimal.setAlignmentX(LEFT_ALIGNMENT);
		textNomeAnimal.setAlignmentX(LEFT_ALIGNMENT);
		textIdadeAnimal.setAlignmentX(LEFT_ALIGNMENT);
		textCorAnimal.setAlignmentX(LEFT_ALIGNMENT);
		textRacaAnimal.setAlignmentX(LEFT_ALIGNMENT);
		textNumeroAnilhaAnimal.setMaximumSize(new Dimension(Integer.MAX_VALUE, 26));
		textPesoAnimal.setMaximumSize(new Dimension(Integer.MAX_VALUE, 26));
		comboPortes.setMaximumSize(new Dimension(Integer.MAX_VALUE, 26));

		botaoAnimal.setBackground(Color.DARK_GRAY);
		botaoAnimal.setForeground(Color.WHITE);
		botaoAnimal.setFont(new Font("Arial", Font.BOLD, 14));

		radioPanel.setAlignmentX(LEFT_ALIGNMENT);
		radioPanel.setLayout(new BoxLayout(radioPanel, BoxLayout.X_AXIS));
		radio2Panel.setAlignmentX(LEFT_ALIGNMENT);
		radio2Panel.setLayout(new BoxLayout(radio2Panel, BoxLayout.X_AXIS));

		comboPortes.setAlignmentX(LEFT_ALIGNMENT);

		esquerdaPanel.setLayout(new BoxLayout(esquerdaPanel, BoxLayout.PAGE_AXIS));
		esquerdaPanel.setPreferredSize(new Dimension(200, 300));
		direitaPanel.setLayout(new BoxLayout(direitaPanel, BoxLayout.PAGE_AXIS));
		direitaPanel.setPreferredSize(new Dimension(200, 300));
		containerPanel.setLayout(new FlowLayout());
		containerPanel.setAlignmentX(LEFT_ALIGNMENT);
		containerPanel.setBorder(BorderFactory.createEmptyBorder(0, -5, 0, -5));

		// Adiciona os componentes ao container usando o BoxLayout
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		add(labelTitulo);
		esquerdaPanel.add(labelId);
		esquerdaPanel.add(textIdAnimal);
		esquerdaPanel.add(labelNome);
		esquerdaPanel.add(textNomeAnimal);
		esquerdaPanel.add(labelIdade);
		esquerdaPanel.add(textIdadeAnimal);
		esquerdaPanel.add(labelRaca);
		esquerdaPanel.add(textRacaAnimal);
		esquerdaPanel.add(labelCor);
		esquerdaPanel.add(textCorAnimal);
		direitaPanel.add(labelEspecie);
		direitaPanel.add(radio2Panel);
		direitaPanel.add(labelSexo);
		direitaPanel.add(radioPanel);
		direitaPanel.add(labelPeso);
		direitaPanel.add(textPesoAnimal);
		direitaPanel.add(labelPorte);
		direitaPanel.add(comboPortes);
		direitaPanel.add(labelNumeroAnilha);
		direitaPanel.add(textNumeroAnilhaAnimal);
		containerPanel.add(esquerdaPanel);
		containerPanel.add(Box.createRigidArea(new Dimension(30, 30)));
		containerPanel.add(direitaPanel);
		add(containerPanel);
		add(Box.createRigidArea(new Dimension(0, 20)));
		add(botaoAnimal);

		passaroButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				especie = "Passaro";
				setarFormularioVisivel();
			}
		});

		caoButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				especie = "Cao";
				setarFormularioVisivel();
			}
		});

		gatoButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				especie = "Gato";
				setarFormularioVisivel();
			}
		});

		sexoFemeaButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sexo = "F";
			}
		});

		sexoMachoButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sexo = "M";
			}
		});

		setVisible(true);
	}

	private static void setarFormularioVisivel() {
		if (especie.equals("Passaro")) {
			labelNumeroAnilha.setVisible(true);
			textNumeroAnilhaAnimal.setVisible(true);
			labelPeso.setVisible(false);
			labelPorte.setVisible(false);
			textPesoAnimal.setVisible(false);
			comboPortes.setVisible(false);
		} else {
			labelNumeroAnilha.setVisible(false);
			textNumeroAnilhaAnimal.setVisible(false);
			labelPeso.setVisible(true);
			labelPorte.setVisible(true);
			textPesoAnimal.setVisible(true);
			comboPortes.setVisible(true);
		}
	}

	public void exibirMensagem(String mensagem) {
		JOptionPane.showMessageDialog(this, mensagem);
	}

	public String getTextEspecieAnimal() {
		return especie;
	}

	public String getTextIdAnimal() {
		return textIdAnimal.getText();
	}

	public String getTextNomeAnimal() {
		return textNomeAnimal.getText();
	}

	public String getTextIdadeAnimal() {
		return textIdadeAnimal.getText();
	}

	public String getTextRacaAnimal() {
		return textRacaAnimal.getText();
	}

	public String getTextCorAnimal() {
		return textCorAnimal.getText();
	}

	public String getTextPesoAnimal() {
		return textPesoAnimal.getText();
	}

	public String getTextNumeroAnilhaAnimal() {
		return textNumeroAnilhaAnimal.getText();
	}

	public String getTextSexoAnimal() {
		return sexo;
	}

	public String getTextPorteAnimal() {
		return (String) comboPortes.getSelectedItem();
	}

	public void setBotaoAnimal(ActionListener botaoProprietario) {
		botaoAnimal.addActionListener(botaoProprietario);
	}

	public void limparCamposAnimal() {
		textIdAnimal.setText("");
		textNomeAnimal.setText("");
		textIdadeAnimal.setText("");
		textRacaAnimal.setText("");
		textCorAnimal.setText("");
		textPesoAnimal.setText("");
		textNumeroAnilhaAnimal.setText("");
		sexo = "F";
		sexoFemeaButton.setSelected(true);
		especie = "Cao";
		caoButton.setSelected(true);
		comboPortes.setSelectedIndex(0);
		setarFormularioVisivel();
	}

}