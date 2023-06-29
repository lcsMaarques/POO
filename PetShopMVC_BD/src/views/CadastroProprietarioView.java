package PetShopDB.mvc.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class CadastroProprietarioView extends JPanel {

	private static final long serialVersionUID = 1L;
	
	// Define os componentes
	JTextField textIdProprietario, textNomeProprietario, textEnderecoProprietario;
	JButton botaoProprietario;
	JFormattedTextField formattedTextCpf;
	
	public CadastroProprietarioView() {
		
		//Cria os componentes
		JLabel labelTitulo = new JLabel("Cadastro do Proprietário");
		JLabel labelId = new JLabel("ID:");
		JLabel labelCfp = new JLabel("CPF:");
		JLabel labelNome = new JLabel("Nome:");
		JLabel labelEndereco = new JLabel("Endereço:");
		
		textIdProprietario = new JTextField(8);
		textNomeProprietario = new JTextField(8);
		textEnderecoProprietario = new JTextField(8);
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
        
		botaoProprietario = new JButton("Salvar");
		
		// Personalização dos componentes
		labelTitulo.setFont(new Font("Arial", Font.BOLD, 17));
		labelTitulo.setForeground(Color.DARK_GRAY);
		
		labelId.setBorder(BorderFactory.createEmptyBorder(20, 0, 5, 0));
		labelId.setFont(new Font("Arial", Font.BOLD, 14));
		labelId.setForeground(Color.DARK_GRAY);
		
		labelCfp.setBorder(BorderFactory.createEmptyBorder(10, 0, 5, 0));
		labelCfp.setFont(new Font("Arial", Font.BOLD, 14));
		labelCfp.setForeground(Color.DARK_GRAY);
		
		labelNome.setBorder(BorderFactory.createEmptyBorder(10, 0, 5, 0));
		labelNome.setFont(new Font("Arial", Font.BOLD, 14));
		labelNome.setForeground(Color.DARK_GRAY);
		
		labelEndereco.setBorder(BorderFactory.createEmptyBorder(10, 0, 5, 0));
		labelEndereco.setFont(new Font("Arial", Font.BOLD, 14));
		labelEndereco.setForeground(Color.DARK_GRAY);
		
		textIdProprietario.setPreferredSize(new Dimension(200, 25));
		formattedTextCpf.setPreferredSize(new Dimension(200, 25));
		textNomeProprietario.setPreferredSize(new Dimension(200, 25));
		textEnderecoProprietario.setPreferredSize(new Dimension(200, 25));
		
		botaoProprietario.setBackground(Color.DARK_GRAY);
		botaoProprietario.setForeground(Color.WHITE);
		botaoProprietario.setFont(new Font("Arial", Font.BOLD, 14));
		
		// Adiciona os componentes ao container usando o BoxLayout
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(labelTitulo);
		add(labelId);
		add(textIdProprietario);
		add(labelCfp);
		add(formattedTextCpf);
		add(labelNome);
		add(textNomeProprietario);
		add(labelEndereco);
		add(textEnderecoProprietario);
		add(Box.createRigidArea(new Dimension(0, 20)));
		add(botaoProprietario);
		
		setVisible(true);
	}
	
	public void exibirMensagem(String mensagem) {
		JOptionPane.showMessageDialog(this, mensagem);
	}

	public String getTextIdProprietario() {
		return textIdProprietario.getText();
	}

	public String getTextCpfProprietario() {
		return formattedTextCpf.getText();
	}

	public String getTextNomeProprietario() {
		return textNomeProprietario.getText();
	}

	public String getTextEnderecoProprietario() {
		return textEnderecoProprietario.getText();
	}
	
	public void setBotaoProprietario(ActionListener botaoProprietario){
		this.botaoProprietario.addActionListener(botaoProprietario);
	}
	
	public void limparCamposProprietario() {
		textIdProprietario.setText("");
		formattedTextCpf.setText("");
		textNomeProprietario.setText("");
		textEnderecoProprietario.setText("");
	}

}
