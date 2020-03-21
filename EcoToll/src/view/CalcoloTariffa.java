package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.VeicoloCTRL;
import model.components.Autostrada;
import model.components.Casello;
import model.components.Pedaggio;
import model.components.Percorso;
import model.components.Tariffe;
import model.components.Veicolo;
import view.Login;
import Controller.AutostradaCTRL;
import Controller.CaselloCTRL;
import Controller.LoginController;
import Controller.*;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.SwingConstants;
import javax.swing.DropMode;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class CalcoloTariffa extends JFrame {// da rifare
	/**
	 * 
	 */

	public String id = null;
	private JTextField textField;
	private JTextField textField_1;

	private final ButtonGroup buttonGroup = new ButtonGroup();
	private String entrata = "";
	private String uscita = "";
	private String autostrada = "";
	Autostrada a;

	public CalcoloTariffa(String username) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		// BOTTONE INDIETRO
		JButton btnIndietro = new JButton("indietro");
		btnIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				FinestraPrincipale u = new FinestraPrincipale(username);
				u.setVisible(true);
			}
		});
		btnIndietro.setBounds(536, 17, 117, 29);
		getContentPane().add(btnIndietro);

		JButton btnRefresh = new JButton("refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalcoloTariffa f = new CalcoloTariffa(username);
				f.setVisible(true);
				dispose();
			}
		});
		// DIMENSIONI BOTTONE REFRESH

		getContentPane().setLayout(null);

		JLabel lblCalcoloPedaggio = new JLabel("Calcolo Pedaggio");
		lblCalcoloPedaggio.setBounds(21, 23, 108, 16);
		getContentPane().add(lblCalcoloPedaggio);

		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(33, 99, 155, 19);
		getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setBounds(33, 169, 155, 19);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JRadioButton rdbtnCarta = new JRadioButton("carta");
		buttonGroup.add(rdbtnCarta);
		rdbtnCarta.setSelected(true);
		rdbtnCarta.setBounds(33, 244, 103, 21);
		getContentPane().add(rdbtnCarta);

		JRadioButton rdbtnContanti = new JRadioButton("contanti");
		buttonGroup.add(rdbtnContanti);
		rdbtnContanti.setBounds(33, 282, 103, 21);
		getContentPane().add(rdbtnContanti);

		JButton btnAcquisisciTarga = new JButton("acquisisci targa");
		btnAcquisisciTarga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String g = new VeicoloCTRL().getv().getTarga();
				textField.setText(g);
			}
		});
		btnAcquisisciTarga.setBounds(257, 98, 123, 21);
		getContentPane().add(btnAcquisisciTarga);

		JButton btnEffettuaPagamento = new JButton("effettua pagamento");
		btnEffettuaPagamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_1.getText().equals("")) {JOptionPane.showMessageDialog(null, "calcola l'importo da pagare");return;}
				if(rdbtnContanti.isSelected())JOptionPane.showMessageDialog(null, "Pagamento Effettuato in contanti");
				else
				
				JOptionPane.showMessageDialog(null, "Pagamento Effettuato con carta");
				btnRefresh.doClick();
			}
		});
		btnEffettuaPagamento.setBounds(235, 244, 167, 29);
		getContentPane().add(btnEffettuaPagamento);

		JLabel lblTarga = new JLabel("targa");
		lblTarga.setBounds(32, 76, 45, 13);
		getContentPane().add(lblTarga);

		JLabel lblImporto = new JLabel("importo");
		lblImporto.setBounds(32, 150, 97, 13);
		getContentPane().add(lblImporto);

		JLabel lblAutostrada = new JLabel("autostrada");
		lblAutostrada.setBounds(484, 74, 96, 16);
		getContentPane().add(lblAutostrada);

		JLabel lblEntrata = new JLabel("entrata");
		lblEntrata.setBounds(484, 130, 56, 16);
		getContentPane().add(lblEntrata);

		JLabel lblUscita = new JLabel("uscita");
		lblUscita.setBounds(484, 179, 56, 16);
		getContentPane().add(lblUscita);

		ArrayList<String> codlist = new ArrayList<String>();

		codlist = new AutostradaCTRL().getCodAutostrada();
		codlist.add(0, "");
		String[] codicevar = new String[codlist.size()];
		JComboBox<String> jComboBox = new JComboBox(codlist.toArray(codicevar));
		JComboBox<String> codiceComboBox = jComboBox;

		// DIMENSIONI COMBO BOX

		codiceComboBox.setBounds(550, 71, 103, 22);
		getContentPane().add(codiceComboBox);

		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.setBounds(550, 127, 103, 22);
		getContentPane().add(comboBox_1);
		// COMBO BOX

		JComboBox<String> comboBox_2 = new JComboBox<String>();
		comboBox_2.setBounds(550, 176, 103, 22);
		getContentPane().add(comboBox_2);

		codiceComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String codiceSelected = codiceComboBox.getSelectedItem().toString();
				autostrada = codiceSelected;
				create2(comboBox_1);
				create2(comboBox_2);

			}
		});

		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String codiceSelected = (String) comboBox_1.getSelectedItem();

				entrata = codiceSelected;
				System.out.println(entrata);

			}
		});

		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String codiceSelected = (String) comboBox_2.getSelectedItem();

				uscita = codiceSelected;
				System.out.println(uscita);

			}
		});

		JButton btnCalcola = new JButton("calcola");
		btnCalcola.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (entrata.equals("") || uscita.equals("") || textField.getText().equals("")|| entrata.equals(uscita)) {
					JOptionPane.showMessageDialog(null,
			"Seleziona il casello di entrata e il casello di uscita e acqusire la targa del veicolo");
				} else {

					Casello en = new CaselloCTRL().getCaselli(entrata);
					Casello us = new CaselloCTRL().getCaselli(uscita);
					Percorso p = new Percorso(en, us);

					Veicolo g = new VeicoloCTRL().getv(textField.getText());
					Autostrada A = new AutostradaCTRL().getAutostrada(autostrada);
					Tariffe t = new TariffeCTRL().createTariffe();
					A.setTariffe(t.getTariffa(A));
					Pedaggio pedaggio = new Pedaggio(p, A, g, t);

					JOptionPane.showMessageDialog(null, "oneri  " + pedaggio.oneri() + "\niva  " + pedaggio.getIva());
					textField_1.setText(String.valueOf(pedaggio.tariffaFinale()));

				}
			}
		});

		///////////////////////////////////////////////////////
		btnCalcola.setBounds(257, 167, 123, 21);
		getContentPane().add(btnCalcola);
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
