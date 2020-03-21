package model.DAO;

import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.components.Autostrada;
import model.components.Casello;
import model.components.Database;

public class CaselloDAO {
	public Casello getCasello(String codice) {

		String nome = null;
		String idAuto = null;
		int km = 0;
		Connection con = new Database().Connect();

		java.sql.PreparedStatement st = null;
		String sql = null;

		sql = "select * from casello where codice ='" + codice + "' ;";

		try {
			st = con.prepareStatement(sql);

			ResultSet res = null;

			st.execute();
			res = st.getResultSet();

			while (res.next()) {
				km = res.getInt("km");
				idAuto = res.getString("autostrada");
				nome = res.getString("nome");
				codice = res.getString("codice");
			}
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "error");
			e1.printStackTrace();
		}
		Casello c = new Casello(km, codice, idAuto, nome);
		return c;
	}

///////////////////////////////////////////////////////////////////////////////////////////////////
	public ArrayList<Casello> getCaselli(Autostrada a) {

		Connection con = new Database().Connect();
		int km = 0;
		String cod = null;

		String nome = null;
		String autostrada = null;
		java.sql.PreparedStatement st = null;
		String sql = null;

		sql = "select * from casello where Autostrada='" + a.getId() + "';";
		ArrayList<Casello> alist = new ArrayList<Casello>();

		try {
			st = con.prepareStatement(sql);

			ResultSet res = null;

			st.execute();
			res = st.getResultSet();
			while (res.next()) {

				km = res.getInt("km");
				cod = res.getString("codice");
				nome = res.getString("nome");
				autostrada = res.getString("autostrada");

				Casello c = new Casello(km, cod, autostrada);
				System.out.println("casello added");
				alist.add(c);
			}
			;
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "error");

			e1.printStackTrace();
		}
		return alist;
	}

	public void insert(Casello casello) {
		final String CREATE_QUERY_CASELLI = "insert into casello values(?,?,?,?)";
		Connection con = new Database().Connect();
		String codice = casello.getId();
		String Km = Integer.toString(casello.getKm());
		String nome = casello.getNome();
		String Autostrada = casello.getIdAuto();

		java.sql.PreparedStatement st = null;
		try {
			st = con.prepareStatement(CREATE_QUERY_CASELLI);

			st.setString(1, codice);
			st.setString(2, Km);
			st.setString(3, Autostrada);
			st.setString(4, nome);

			st.execute();

		} catch (SQLException e1) {

			e1.printStackTrace();
		}

	}

	public void delete(Casello c) {
		final String DELETE_QUERY = "delete from casello where codice = ?";
		Connection con = new Database().Connect();
		String codice = c.getId();

		java.sql.PreparedStatement st = null;

		try {
			st = con.prepareStatement(DELETE_QUERY);

			st.setString(1, codice);

			st.execute();

		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		System.out.print("del");

	}

	public void update(Casello casello) {
		delete(casello);
		insert(casello);

	}

}
