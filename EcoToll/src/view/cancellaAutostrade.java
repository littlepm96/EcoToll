package view;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

import Controller.AutostradaCTRL;
import Controller.LoginController;
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

public class cancellaAutostrade extends JFrame {

	private JTextField textField;
	String a;

	// FINESTRA PRINCIPALE

	public cancellaAutostrade(String user) {
		getContentPane().setLayout(null);
		setBounds(100, 100, 453, 346);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// refresh

		JButton btnRefresh = new JButton("refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancellaAutostrade f = new cancellaAutostrade(user);
				f.setVisible(true);
				dispose();
			}
		});
		// DIMENSIONI BOTTONE REFRESH

		// btnRefresh.setBounds(198, 6, 117, 29);
		// getContentPane().add(btnRefresh);

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

		// BOTTONE CANCELLA

		JButton btnCancella = new JButton("cancella");
		btnCancella.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Autostrada y = new AutostradaCTRL().getAutostrada(textField.getText());

				int J = JOptionPane.showConfirmDialog(null, "vuoi?", "", 0);
				if (J == 1) {
					btnRefresh.doClick();
				} else {

					new AutostradaCTRL().delete(y);

					btnRefresh.doClick();

				}
			}
		});
		// DIMENSIONI BOTTONE CANCELLA

		btnCancella.setBounds(39, 226, 117, 29);
		getContentPane().add(btnCancella);

		// SERIE DI TEXTFIELD

		textField = new JTextField();
		textField.setBounds(270, 61, 130, 26);
		getContentPane().add(textField);
		textField.setColumns(10);

		// SERIE DI LABEL

		JLabel lblCodice = new JLabel("Codice");
		lblCodice.setBounds(39, 65, 61, 16);
		getContentPane().add(lblCodice);

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

		btnMostraTutto.setBounds(286, 226, 117, 29);
		getContentPane().add(btnMostraTutto);

		// Label Gestione Autostrade

		JLabel lblGestioneAutostrade = new JLabel("Gestione Autostrade");
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

		codiceComboBox.setBounds(130, 61, 130, 26);
		getContentPane().add(codiceComboBox);

	}
}
