package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.TariffeCTRL;
import model.components.Tariffe;
import view.Login;
import Controller.TariffeCTRL;
import Controller.LoginController;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import Controller.*;

public class GestioneTariffe extends JFrame {
	private JTextField pA;
	private JTextField pB;
	private JTextField p3;
	private JTextField p4;
	private JTextField p5;
	private JTextField e1;
	private JTextField e2;
	private JTextField e3;
	private JTextField e4;
	private JTextField e5;
	private JTextField e6;
	private JTextField mA;
	private JTextField mB;
	private JTextField m3;
	private JTextField m4;
	private JTextField m5;

	public GestioneTariffe(String username) {
		Tariffe t = new TariffeCTRL().createTariffe();
		double[] pianura = t.getTariffaP();
		double[] oneri = t.getOneri();
		double[] montagna = t.getTariffaM();
		double pianuraA = pianura[0]; // ("A", "pianura") ;
		double pianuraB = pianura[1];
		double pianura3 = pianura[2];
		double pianura4 = pianura[3];
		double pianura5 = pianura[4];
		double euro1 = oneri[0];
		double euro2 = oneri[1];
		double euro3 = oneri[2];
		double euro4 = oneri[3];
		double euro5 = oneri[4];
		double euro6 = oneri[5];
		double montagnaA = montagna[0];
		double montagnaB = montagna[1];
		double montagna3 = montagna[2];
		double montagna4 = montagna[3];
		double montagna5 = montagna[4];

		setBounds(100, 100, 450, 339);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// BOTTONE INDIETRO
		JButton btnIndietro = new JButton("indietro");
		btnIndietro.setBounds(335, 10, 93, 29);
		btnIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				FinestraPrincipale u = new FinestraPrincipale(username);
				u.setVisible(true);
			}
		});
		getContentPane().setLayout(null);
		getContentPane().add(btnIndietro);

		JLabel lblTariffe = new JLabel("Tariffe");
		lblTariffe.setBounds(28, 44, 61, 16);
		getContentPane().add(lblTariffe);

		JLabel lblOneri = new JLabel("Oneri");
		lblOneri.setBounds(303, 47, 61, 16);
		getContentPane().add(lblOneri);

		JLabel lblClasseA = new JLabel("Classe A");
		lblClasseA.setBounds(28, 84, 61, 16);
		getContentPane().add(lblClasseA);

		JLabel lblClasseB = new JLabel("Classe B");
		lblClasseB.setBounds(28, 112, 61, 16);
		getContentPane().add(lblClasseB);

		JLabel lblClasse = new JLabel("Classe 3");
		lblClasse.setBounds(28, 139, 61, 16);
		getContentPane().add(lblClasse);

		JLabel lblClasse_1 = new JLabel("Classe 4");
		lblClasse_1.setBounds(28, 167, 61, 16);
		getContentPane().add(lblClasse_1);

		JLabel lblClasse_2 = new JLabel("Classe 5");
		lblClasse_2.setBounds(28, 195, 61, 16);
		getContentPane().add(lblClasse_2);

		JLabel lblEuro = new JLabel("Euro 1");
		lblEuro.setBounds(264, 84, 61, 16);
		getContentPane().add(lblEuro);

		JLabel lblEuro_1 = new JLabel("Euro 2");
		lblEuro_1.setBounds(264, 112, 61, 16);
		getContentPane().add(lblEuro_1);

		JLabel lblEuro_2 = new JLabel("Euro 3");
		lblEuro_2.setBounds(264, 139, 61, 16);
		getContentPane().add(lblEuro_2);

		JLabel lblEuro_3 = new JLabel("Euro 4");
		lblEuro_3.setBounds(264, 167, 61, 16);
		getContentPane().add(lblEuro_3);

		JLabel lblEuro_4 = new JLabel("Euro 5");
		lblEuro_4.setBounds(264, 195, 61, 16);
		getContentPane().add(lblEuro_4);

		JLabel lblEuro_5 = new JLabel("Euro 6");
		lblEuro_5.setBounds(264, 223, 61, 16);
		getContentPane().add(lblEuro_5);

		pA = new JTextField();
		pA.setText(String.valueOf(pianuraA));
		pA.setBounds(101, 79, 58, 19);
		getContentPane().add(pA);
		pA.setColumns(10);

		pB = new JTextField();
		pB.setText(String.valueOf(pianuraB));
		pB.setBounds(101, 107, 58, 19);
		getContentPane().add(pB);
		pB.setColumns(10);

		p3 = new JTextField();
		p3.setText(String.valueOf(pianura3));
		p3.setBounds(101, 134, 58, 19);
		getContentPane().add(p3);
		p3.setColumns(10);

		p4 = new JTextField();
		p4.setText(String.valueOf(pianura4));
		p4.setBounds(101, 162, 58, 19);
		getContentPane().add(p4);
		p4.setColumns(10);

		p5 = new JTextField();
		p5.setText(String.valueOf(pianura5));
		p5.setBounds(101, 190, 58, 19);
		getContentPane().add(p5);
		p5.setColumns(10);

		e1 = new JTextField();
		e1.setText(String.valueOf(euro1));
		e1.setBounds(335, 81, 52, 19);
		getContentPane().add(e1);
		e1.setColumns(10);

		e2 = new JTextField();
		e2.setText(String.valueOf(euro2));
		e2.setBounds(335, 109, 52, 19);
		getContentPane().add(e2);
		e2.setColumns(10);

		e3 = new JTextField();
		e3.setText(String.valueOf(euro3));
		e3.setBounds(335, 136, 52, 19);
		getContentPane().add(e3);
		e3.setColumns(10);

		e4 = new JTextField();
		e4.setText(String.valueOf(euro4));
		e4.setBounds(335, 164, 52, 19);
		getContentPane().add(e4);
		e4.setColumns(10);

		e5 = new JTextField();
		e5.setText(String.valueOf(euro5));
		e5.setBounds(335, 192, 52, 19);
		getContentPane().add(e5);
		e5.setColumns(10);

		e6 = new JTextField();
		e6.setText(String.valueOf(euro6));
		e6.setBounds(335, 220, 52, 19);
		getContentPane().add(e6);
		e6.setColumns(10);

		JButton btnCambia = new JButton("Cambia");
		btnCambia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String pianuraA = pA.getText();
				String pianuraB = pB.getText();
				String pianura3 = p3.getText();
				String pianura4 = p4.getText();
				String pianura5 = p5.getText();
				String euro1 = e1.getText();
				String euro2 = e2.getText();
				String euro3 = e3.getText();
				String euro4 = e4.getText();
				String euro5 = e5.getText();
				String euro6 = e6.getText();
				String montagnaA = mA.getText();
				String montagnaB = mB.getText();
				String montagna3 = m3.getText();
				String montagna4 = m4.getText();
				String montagna5 = m5.getText();

				double[] pianura = { Double.valueOf(pianuraA), Double.valueOf(pianuraB), Double.valueOf(pianura3),
						Double.valueOf(pianura4), Double.valueOf(pianura5) };
				double[] oneri = { Double.valueOf(euro1), Double.valueOf(euro2), Double.valueOf(euro3),
						Double.valueOf(euro4), Double.valueOf(euro5), Double.valueOf(euro6) };
				double[] montagna = { Double.valueOf(montagnaA), Double.valueOf(montagnaB), Double.valueOf(montagna3),
						Double.valueOf(montagna4), Double.valueOf(montagna5) };

				t.setTariffaM(montagna);
				t.setOneri(oneri);
				t.setTariffaP(pianura);
				new TariffeCTRL().modtariffe(t);
			}
		});
		btnCambia.setBounds(162, 259, 117, 29);
		getContentPane().add(btnCambia);

		String[] pet = { "montagna", "pianura" };

		JSeparator separator = new JSeparator();
		separator.setBounds(243, 80, 1, 12);
		getContentPane().add(separator);

		mA = new JTextField();
		mA.setText(String.valueOf(montagnaA));
		mA.setBounds(175, 79, 58, 19);
		getContentPane().add(mA);
		mA.setColumns(10);

		mB = new JTextField();
		mB.setText(String.valueOf(montagnaB));
		mB.setBounds(175, 107, 58, 19);
		getContentPane().add(mB);
		mB.setColumns(10);

		m3 = new JTextField();
		m3.setText(String.valueOf(montagna3));
		m3.setBounds(175, 134, 58, 19);
		getContentPane().add(m3);
		m3.setColumns(10);

		m4 = new JTextField();
		m4.setText(String.valueOf(montagna4));
		m4.setBounds(175, 162, 58, 19);
		getContentPane().add(m4);
		m4.setColumns(10);

		m5 = new JTextField();
		m5.setText(String.valueOf(montagna5));
		m5.setBounds(175, 190, 58, 19);
		getContentPane().add(m5);
		m5.setColumns(10);

		JLabel lblNewLabel = new JLabel("Pianura");
		lblNewLabel.setBounds(99, 59, 45, 13);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Montagna");
		lblNewLabel_1.setBounds(175, 59, 69, 13);
		getContentPane().add(lblNewLabel_1);

	}
}
