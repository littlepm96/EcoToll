package model.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

import Controller.AutostradaCTRL;
import Controller.CaselloCTRL;
import Controller.TariffeCTRL;
import model.components.Autostrada;
import model.components.Casello;
import model.components.Database;

public class AutostradaDAO {
	private static final String DELETE_QUERY = "delete from autostrada where codice = ?";
	private static final String CREATE_QUERY_AUTOSTRADA = "insert into autostrada values(?,?,?,?)";

	public Autostrada getAutostrada(String id) {

		String cod = "";
		String tipologia = "";
		String nome = "";
		java.sql.PreparedStatement st = null;
		Connection con = new Database().Connect();
		String sql = "select * from autostrada where Codice ='" + id + "' ";

		try {
			st = con.prepareStatement(sql);

			ResultSet res = null;

			st.execute();
			res = st.getResultSet();

			while (res.next()) {

				cod = res.getString("codice");
				tipologia = res.getString("tipo");
				nome = res.getString("nome");

			}

		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "error");

			e1.printStackTrace();
		}
		double[] g = { 0, 0, 0, 0, 0 };
		Autostrada b = new Autostrada(null, cod, g, tipologia);
		b.setNome(nome);
		if (tipologia.equals("pianura")) {
			b.setTariffe(new TariffeCTRL().createTariffe().getTariffaP());
			b.setCaselli(new CaselloCTRL().getCaselli(b));

		}

		if (tipologia.equals("montagna")) {
			b.setTariffe(new TariffeCTRL().createTariffe().getTariffaM());
			b.setCaselli(new CaselloCTRL().getCaselli(b));
		}

		return b;
	}

	public ArrayList<String> getCod() {

		String cod = "";
		ArrayList<String> a = new ArrayList<String>();

		java.sql.PreparedStatement st = null;
		Connection con = new Database().Connect();

		String sql = "select codice from autostrada  ";

		try {
			st = con.prepareStatement(sql);

			ResultSet res = null;

			st.execute();
			res = st.getResultSet();

			while (res.next()) {

				cod = res.getString("codice");

				a.add(cod);

			}

		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "error");

			e1.printStackTrace();
		}

		return a;
	}

	public ArrayList<Autostrada> getAutostrada() {
		ArrayList<Autostrada> a = new ArrayList<Autostrada>();
		ArrayList<String> c = new AutostradaDAO().getCod();
		for (String s : c) {
			a.add(new AutostradaDAO().getAutostrada(s));
		}
		return a;
	}

	public void modAuto(Autostrada a) {
		ArrayList<Casello> arrayee = new CaselloDAO().getCaselli(a);
		
		
		delete(a);
		insert(a);
		
		for(Casello c:arrayee) {
			new CaselloDAO().insert(c);
		}
		
		

	
		

	}

	public void delete(Autostrada y) {

		Connection con = new Database().Connect();
		String cod = y.getId();
		java.sql.PreparedStatement st = null;
		try {
			st = con.prepareStatement(DELETE_QUERY);

			st.setString(1, cod);
			st.execute();

		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "non ho cancellato");
			e1.printStackTrace();
		}
		ArrayList<Casello> array = new CaselloDAO().getCaselli(y);
		for(Casello c:array) {
			new CaselloDAO().delete(c);
		}
		
		
		System.out.print("ho cancellato");
		//JOptionPane.showMessageDialog(null, "ho cancellato");
	}

	public void insert(Autostrada y) {

		Connection con = new Database().Connect();

		java.sql.PreparedStatement st = null;
		try {
			st = con.prepareStatement(CREATE_QUERY_AUTOSTRADA);

			st.setString(1, y.getId());
			st.setString(2, y.getNome());
			st.setString(3, y.getTipoToString());
			st.setString(4, y.getUser());

			st.execute();

			//JOptionPane.showMessageDialog(null, "autostrada inserita");
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "autostrada non inserita");

			e1.printStackTrace();
		}

	}
}
