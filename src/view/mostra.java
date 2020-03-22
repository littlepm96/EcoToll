package view;

import javax.swing.JFrame;
import Controller.AutostradaCTRL;
import Controller.CaselloCTRL;
import model.components.Autostrada;
import model.components.Casello;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JLabel;

import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class mostra extends JFrame {
	public mostra() {
		this.setBounds(200, 200, 484, 364);
		this.setLocation(1000, 1000);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lblMostraTutto = new JLabel("mostra tutto");
		lblMostraTutto.setBounds(105, 10, 247, 16);
		lblMostraTutto.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblMostraTutto);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 28, 434, 283);
		getContentPane().add(scrollPane);

		JTextArea ta = new JTextArea();
		scrollPane.setViewportView(ta);

		ArrayList<Autostrada> alist = new ArrayList<Autostrada>();
		String li = "";

		//

		alist = new AutostradaCTRL().getAutostrada();

		//

		li = "autostrada\t tipo\t nome\t\n";
		for (Autostrada s : alist) {
			{
				li = li + s.getId() + "\t" + s.getTipoToString() + "\t" + s.getNome() + "\n";
			}

			ta.setText(li);

			JButton btnRefresh = new JButton("refresh");
			btnRefresh.setBounds(311, 8, 117, 20);
			btnRefresh.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostra m = new mostra();
					m.setVisible(true);
					m.setBounds(200, 200, 450, 339);
					dispose();
				}
			});
			{
				getContentPane().add(btnRefresh);
			}
		}
	}

	public mostra(Autostrada a) {

		this.setBounds(200, 200, 484, 364);
		this.setLocation(1000, 1000);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lblMostraTutto = new JLabel("mostra tutto");
		lblMostraTutto.setBounds(105, 10, 247, 16);
		lblMostraTutto.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblMostraTutto);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 28, 434, 283);
		getContentPane().add(scrollPane);

		JTextArea ta = new JTextArea();
		scrollPane.setViewportView(ta);
		ArrayList<Casello> alist = new CaselloCTRL().getCaselli(a);

		String li = "codice\tAutostrada\tkm\n";
		for (Casello s : alist) {
			li = li + s.getId() + "\t" + s.getIdAuto() + "\t" + s.getKm() + "\n";
		}

		ta.setText(li);

		JButton btnRefresh = new JButton("refresh");
		btnRefresh.setBounds(311, 8, 117, 20);
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostra m = new mostra(a);
				m.setVisible(true);
				m.setBounds(200, 200, 450, 339);
				dispose();
			}
		});
		{
			getContentPane().add(btnRefresh);
		}
	}

	public mostra(ArrayList<Autostrada> a) {
		this.setBounds(200, 200, 484, 364);
		this.setLocation(1000, 1000);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lblMostraTutto = new JLabel("mostra tutto");
		lblMostraTutto.setBounds(105, 10, 247, 16);
		lblMostraTutto.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblMostraTutto);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 28, 434, 283);
		getContentPane().add(scrollPane);

		JButton btnRefresh = new JButton("refresh");
		btnRefresh.setBounds(311, 8, 117, 20);
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostra m = new mostra(a);
				m.setVisible(true);
				m.setBounds(200, 200, 450, 339);
				dispose();
			}
		});

		JTextArea ta = new JTextArea();
		scrollPane.setViewportView(ta);
		String li = "";
		for (Autostrada b : a) {
			li = li + "------" + b.getId() + "------------------\n";
			li = li + "Codice\tAutostrada\tKm\n";
			ArrayList<Casello> alist = new CaselloCTRL().getCaselli(b);

			for (Casello s : alist) {
				li = li + s.getId() + "\t" + s.getIdAuto() + "\t" + s.getKm() + "\n";
			}
			li = li + "\n";

		}
		ta.setText(li);

	}
}
