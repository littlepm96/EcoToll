package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import Controller.AutostradaCTRL;
import model.components.Autostrada;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import Controller.AutostradaCTRL;

public class GestioneCaselli extends JFrame {

	String a;

	// SCHERMATA INIZIALE

	public GestioneCaselli(String user) {
		getContentPane().setLayout(null);
		setBounds(100, 100, 462, 353);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// BOTTONE INDIETRO

		JButton btnIndietro = new JButton("indietro");
		btnIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				FinestraPrincipale u = new FinestraPrincipale(user);
				u.setVisible(true);
			}
		});
		// DIMENSIONI BOTTONE INDIETRO

		btnIndietro.setBounds(327, 6, 117, 29);
		getContentPane().add(btnIndietro);

		// BOTTONE INSERISCI

		JButton btnInserisci = new JButton("inserisci");
		btnInserisci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inserisciCaselli f = new inserisciCaselli(user);
				f.setVisible(true);
				dispose();

			}
		});
		// DIMENSIONE BOTTONE INSERISCI

		btnInserisci.setBounds(20, 77, 117, 29);
		getContentPane().add(btnInserisci);

		// BOTTONE MODIFICA

		JButton button = new JButton("sotto menù modifica");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// CHIAMATE VIEW "ModAUTOSTRADA"

				{
					dispose();
					ModCasello p = new ModCasello(user);
					p.setVisible(true);
				}
			}
		});

		// DIMENSIONE BOTTONE MODIFICA
		button.setBounds(167, 77, 117, 29);
		getContentPane().add(button);

		// BOTTONE CANCELLA

		JButton btnCancella = new JButton("Cancella");
		btnCancella.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				cancellaCaselli f = new cancellaCaselli(user);
				f.setVisible(true);
				dispose();

			}
		});
		// DIMENSIONI BOTTONE CANCELLA

		btnCancella.setBounds(327, 77, 117, 29);
		getContentPane().add(btnCancella);

		JButton btnMostraTutto = new JButton("mostra tutti");
		btnMostraTutto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Autostrada> a = new AutostradaCTRL().getAutostrada();

				mostra t = new mostra(a);
				t.setVisible(true);
				t.setBounds(200, 200, 450, 339);

			}
		});
		btnMostraTutto.setBounds(163, 168, 117, 29);
		getContentPane().add(btnMostraTutto);

		// LABEL CASELLI

		JLabel lblGestioneCaselli = new JLabel("Gestione Caselli");
		lblGestioneCaselli.setBounds(20, 11, 103, 16);
		getContentPane().add(lblGestioneCaselli);

	}

}
