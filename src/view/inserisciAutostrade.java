package view;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

import Controller.AutostradaCTRL;
import Controller.CaselloCTRL;
import Controller.LoginController;
import Controller.TariffeCTRL;
import model.DAO.AutostradaDAO;
import model.components.Autostrada;
import model.components.Database;
import view.Login;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;

public class inserisciAutostrade extends JFrame {

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	String a;

	// FINESTRA PRINCIPALE

	public inserisciAutostrade(String user) {

		getContentPane().setLayout(null);
		setBounds(100, 100, 453, 346);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// BOTTONE REFRESH

		JButton btnRefresh = new JButton("refresh");
		btnRefresh.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				inserisciAutostrade f = new inserisciAutostrade(user);
				f.setVisible(true);
				dispose();
			}
		});
		// DIMENSIONI BOTTONE REFRESH

//btnRefresh.setBounds(198, 6, 117, 29);
//getContentPane().add(btnRefresh);

		// BOTTONE INDIETRO

		JButton btnIndietro = new JButton("indietro");
		btnIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestioneAutostrade f = new GestioneAutostrade(user);
				f.setVisible(true);
				dispose();
			}
		});
		// DIMENSIONI BOTTONE INDIETRO

		btnIndietro.setBounds(327, 6, 117, 29);
		getContentPane().add(btnIndietro);

		// BOTTONE INSERISCI

		JButton btnInserisci = new JButton("inserisci");
		btnInserisci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cod = textField.getText();
				String tipo = textField_1.getText();
				String nome = textField_2.getText();
				if (cod.isEmpty() || tipo.isEmpty() || nome.isEmpty()) {
					JOptionPane.showMessageDialog(null, "campi vuoti");
					// btnRefresh.doClick();
				} else {
					Autostrada y = new Autostrada(cod, nome, tipo, user);
					y.setTariffe(new TariffeCTRL().createTariffe().getTariffa(y));

					int J = JOptionPane.showConfirmDialog(null, "vuoi?", "", 0);
					if (J == 1) {
						btnRefresh.doClick();
					} else {

						new AutostradaCTRL().insert(y);

						btnRefresh.doClick();
						// JOptionPane.showMessageDialog(null, "autostrada inserita");

					}
				}
			}
		});
		// DIMENSIONE BOTTONE INSERISCI

		btnInserisci.setBounds(39, 227, 117, 29);
		getContentPane().add(btnInserisci);

		// SERIE DI TEXTFIELD

		textField = new JTextField();
		textField.setBounds(263, 60, 130, 26);
		getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(263, 111, 130, 26);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(263, 149, 130, 26);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);

		// SERIE DI LABEL

		JLabel lblCodice = new JLabel("Codice");
		lblCodice.setBounds(39, 65, 61, 16);
		getContentPane().add(lblCodice);

		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(39, 116, 61, 16);
		getContentPane().add(lblTipo);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(39, 154, 61, 16);
		getContentPane().add(lblNome);

		// Bottone Mostra Tutto

		JButton btnMostraTutto = new JButton("Mostra Tutto");
		btnMostraTutto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				mostra t = new mostra();
				t.setVisible(true);
				t.setBounds(200, 200, 450, 339);

			}
		});

		// Dimensioni bottone Mostra Tutto

		btnMostraTutto.setBounds(276, 227, 117, 29);
		getContentPane().add(btnMostraTutto);

		// Label Gestione Autostrade

		JLabel lblGestioneAutostrade = new JLabel("inserisci Autostrade");
		lblGestioneAutostrade.setBounds(39, 19, 130, 16);
		getContentPane().add(lblGestioneAutostrade);

		// COMBO BOX

		ArrayList<String> codlist = new ArrayList<String>();
		codlist = new AutostradaCTRL().getCodAutostrada();
		codlist.add(0, "");
		String[] codicevar = new String[codlist.size()];
		JComboBox jComboBox = new JComboBox(codlist.toArray(codicevar));
		JComboBox codiceComboBox = jComboBox;

		codiceComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String codiceSelected = codiceComboBox.getSelectedItem().toString();
				textField.setText(codiceSelected);
				ArrayList<String> codlist = new AutostradaCTRL().getCodAutostrada();
				String[] codicevar = new String[codlist.size()];

			}
		});
		// DIMENSIONI COMBO BOX

		codiceComboBox.setBounds(130, 61, 130, 27);
		getContentPane().add(codiceComboBox);

	}

}
