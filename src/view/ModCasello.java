package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.AutostradaCTRL;
import Controller.CaselloCTRL;
import view.Login;
import Controller.AutostradaCTRL;
import Controller.LoginController;
import model.components.Autostrada;
import model.components.Casello;

import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ModCasello extends JFrame {
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private String autostrada;

	private Casello c;

	public ModCasello(String user) {

		getContentPane().setLayout(null);
		setBounds(100, 100, 450, 339);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JLabel lblInserisciIdAutostrada = new JLabel("Inserisci Codice Casello da modificare");
		lblInserisciIdAutostrada.setBounds(20, 55, 263, 16);
		getContentPane().add(lblInserisciIdAutostrada);

		JLabel lblInserisciNuoviCampi = new JLabel("Inserisci nuovi campi");
		lblInserisciNuoviCampi.setBounds(166, 110, 142, 16);
		getContentPane().add(lblInserisciNuoviCampi);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(20, 162, 130, 26);
		getContentPane().add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(20, 201, 130, 26);
		getContentPane().add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(303, 162, 130, 26);
		getContentPane().add(textField_3);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(303, 201, 130, 26);
		getContentPane().add(textField_4);

		JLabel lblNewLabel = new JLabel("Codice");
		lblNewLabel.setBounds(63, 143, 61, 16);
		getContentPane().add(lblNewLabel);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(63, 186, 61, 16);
		getContentPane().add(lblNome);

		JLabel lblTipo = new JLabel("Km");
		lblTipo.setBounds(344, 143, 61, 16);
		getContentPane().add(lblTipo);

		JLabel lblAmministratore = new JLabel("Autostrada");
		lblAmministratore.setBounds(323, 186, 98, 16);
		getContentPane().add(lblAmministratore);

		JButton btnModifica = new JButton("Modifica");
		btnModifica.setBounds(173, 243, 117, 29);
		getContentPane().add(btnModifica);

		// BOTTONE INDIETRO

		JButton btnIndietro = new JButton("Indietro");

		btnIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				GestioneCaselli l = new GestioneCaselli(user);
				l.setVisible(true);
			}
		});

		btnIndietro.setBounds(327, 6, 117, 29);
		getContentPane().add(btnIndietro);

		btnModifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String codice = textField_1.getText();
				String km = textField_3.getText();
				System.out.println(km);
				String nome = textField_2.getText();
				String autostrada = textField_4.getText();

				int J = JOptionPane.showConfirmDialog(null, "vuoi?", "", 0);
				if (J == 1) {
					// ModCasello q = new ModCasello(user);
					// q.setVisible(true);
					// dispose();

				} else {
					c = new Casello(Integer.valueOf(km), codice, autostrada, nome);

					new CaselloCTRL().modCasello(c);

					ModCasello q = new ModCasello(user);
					q.setVisible(true);
					dispose();

				}
			}
		});

		// COMBO BOX

		ArrayList<String> codlist = new ArrayList<String>();

		codlist = new AutostradaCTRL().getCodAutostrada();
		codlist.add(0, "");
		String[] codicevar = new String[codlist.size()];
		JComboBox<String> jComboBox = new JComboBox(codlist.toArray(codicevar));
		JComboBox<String> codiceComboBox = jComboBox;

		// DIMENSIONI COMBO BOX

		codiceComboBox.setBounds(318, 55, 103, 22);
		getContentPane().add(codiceComboBox);

		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.setBounds(318, 87, 103, 22);
		getContentPane().add(comboBox_1);
		// COMBO BOX

		codiceComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String codiceSelected = codiceComboBox.getSelectedItem().toString();

				autostrada = codiceSelected;
				// textField_1.setText(codiceSelected);
				create2(comboBox_1);

			}
		});

		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String codiceSelected = (String) comboBox_1.getSelectedItem();

				c = new CaselloCTRL().getCaselli(codiceSelected);

				textField_1.setText(c.getId());
				textField_4.setText(c.getIdAuto());
				textField_3.setText(Integer.toString(c.getKm()));
				textField_2.setText(c.getNome());

			}
		});

	}

	public void create2(JComboBox<String> combo) {
		combo.removeAllItems();
		combo.addItem("");
		Autostrada b = new AutostradaCTRL().getAutostrada(autostrada);
		System.out.println(b.getId());
		ArrayList<Casello> c = new CaselloCTRL().getCaselli(b);

		for (Casello p : c) {
			combo.addItem(p.getId());
		}
		getContentPane().add(combo);
	};
}