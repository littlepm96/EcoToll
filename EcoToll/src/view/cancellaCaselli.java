package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import Controller.AutostradaCTRL;
import Controller.CaselloCTRL;
import model.components.Autostrada;
import model.components.Casello;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JTextField;

public class cancellaCaselli extends JFrame {

	private JTextField textField;
	private JTextField textField_1;
	String a;

	// SCHERMATA INIZIALE

	public cancellaCaselli(String username) {
		getContentPane().setLayout(null);
		setBounds(100, 100, 462, 353);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// BOTTONE INDIETRO

		JButton btnIndietro = new JButton("indietro");
		btnIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				GestioneCaselli u = new GestioneCaselli(username);
				u.setVisible(true);
			}
		});
		// DIMENSIONI BOTTONE INDIETRO

		btnIndietro.setBounds(327, 6, 117, 29);
		getContentPane().add(btnIndietro);

		// SERIE DI TEXTFIELD
		textField = new JTextField();
		textField.setBounds(272, 60, 130, 26);
		getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(272, 99, 130, 26);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);

		// BOTTONE REFRESH

		JButton btnRefresh = new JButton("refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancellaCaselli f = new cancellaCaselli(username);
				f.setVisible(true);
				dispose();

			}
		});
		// DIMENSIONI BOTTONE REFRESH

//btnRefresh.setBounds(198, 6, 117, 29);
//getContentPane().add(btnRefresh);

		// SERIE DI LABEL
		JLabel lblAutostrada = new JLabel("autostrada");
		lblAutostrada.setBounds(47, 65, 61, 16);
		getContentPane().add(lblAutostrada);

		JLabel lblID = new JLabel("ID");
		lblID.setBounds(47, 104, 76, 16);
		getContentPane().add(lblID);

		// BOTTONE CANCELLA

		JButton btnCancella = new JButton("Cancella");
		btnCancella.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Casello c = new Casello(1, textField_1.getText(),textField.getText());
				new CaselloCTRL().delete(c);

				
				btnRefresh.doClick();
				

			}
		});
		// DIMENSIONI BOTTONE CANCELLA

		btnCancella.setBounds(47, 224, 117, 29);
		getContentPane().add(btnCancella);

		// Bottone Mostra Tutto

		JButton btnMostraTutto = new JButton("Mostra Tutto");
		btnMostraTutto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Autostrada q = new AutostradaCTRL().getAutostrada(textField.getText());
				mostra m = new mostra(q);
				m.setVisible(true);
				m.setBounds(200, 200, 450, 339);
			}
		});
		// Dimensioni bottone Mostra Tutto

		btnMostraTutto.setBounds(285, 224, 117, 29);
		getContentPane().add(btnMostraTutto);

		// LABEL CASELLI

		JLabel lblGestioneCaselli = new JLabel("Gestione Caselli");
		lblGestioneCaselli.setBounds(20, 11, 103, 16);
		getContentPane().add(lblGestioneCaselli);

		ArrayList<String> codlist = new ArrayList<String>();

		codlist = new AutostradaCTRL().getCodAutostrada();
		codlist.add(0, "");
		String[] codicevar = new String[codlist.size()];
		JComboBox jComboBox = new JComboBox(codlist.toArray(codicevar));
		JComboBox codiceComboBox = jComboBox;

		// DIMENSIONI COMBO BOX

		codiceComboBox.setBounds(157, 62, 103, 22);
		getContentPane().add(codiceComboBox);

		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.setBounds(157, 101, 103, 22);
		getContentPane().add(comboBox_1);
		// COMBO BOX

		codiceComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String codiceSelected = codiceComboBox.getSelectedItem().toString();
				textField.setText(codiceSelected);
				create2(comboBox_1);

			}
		});

		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String codiceSelected = (String) comboBox_1.getSelectedItem();
				textField_1.setText(codiceSelected);

			}
		});

	}

	public void create2(JComboBox<String> combo) {
		combo.removeAllItems();
		combo.addItem("");
		Autostrada b = new AutostradaCTRL().getAutostrada(textField.getText());
		System.out.println(b.getId());
		ArrayList<Casello> c = new CaselloCTRL().getCaselli(b);

		for (Casello p : c) {
			combo.addItem(p.getId());
		}
		getContentPane().add(combo);
	};

}
