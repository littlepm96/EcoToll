package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.LoginController;
//import view.FinestraPrincipale;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import Controller.LoginController;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField usernameField;
	private JTextField passwordField;
	private String username;
	private String password;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {

		// RICHIESTA DI CONNESSIONE DATABASE

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			JOptionPane.showMessageDialog(null, "error");
			e1.printStackTrace();
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "error");

					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	// FINESTRA LOGIN
	public Login() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 339);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// SERIE DI LABEL
		JLabel lblSistemaDiPedaggi = new JLabel("ECOtoll");
		lblSistemaDiPedaggi.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblSistemaDiPedaggi.setBounds(187, 30, 78, 28);
		contentPane.add(lblSistemaDiPedaggi);

		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblUsername.setBounds(52, 83, 92, 14);
		contentPane.add(lblUsername);

		usernameField = new JTextField();
		usernameField.setBounds(139, 77, 188, 28);
		contentPane.add(usernameField);
		usernameField.setColumns(10);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblPassword.setBounds(52, 176, 78, 14);
		contentPane.add(lblPassword);

		passwordField = new JTextField();
		passwordField.setBounds(139, 169, 188, 28);
		contentPane.add(passwordField);
		passwordField.setColumns(10);

		// BOTTONE LOGIN
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Times New Roman", Font.PLAIN, 15));

		// DIMENSIONI BOTTONE LOGIN
		btnLogin.setBounds(176, 238, 89, 23);
		contentPane.add(btnLogin);

		btnLogin.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				username = usernameField.getText();
				password = passwordField.getText();
				if (!username.equals("") && !password.equals("")) {
					String tipo = new LoginController().login(username, password);
					if (tipo.equals("amministratore")) {
						dispose();
						FinestraPrincipale f = new FinestraPrincipale(username);
						f.setVisible(true);
					}

				} else {
					JOptionPane.showMessageDialog(null, "Uno o più campi vuoti");
				}
			}
		});
	}

	public String getuser() {
		return username;
	}
}