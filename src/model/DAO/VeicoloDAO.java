package model.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.components.Classe3;
import model.components.Classe4;
import model.components.Classe5;
import model.components.ClasseA;
import model.components.ClasseB;
import model.components.Database;
import model.components.Veicolo;

public class VeicoloDAO {

	public Veicolo getV() {

		java.sql.PreparedStatement st = null;
		Connection con = new Database().Connect();
		String targa = "";
		String marca = "";
		String modello = "";
		int peso = 0;
		int assi = 0;
		int altezza = 0;
		int anno = 0;
		String categoria = "";
		double co2 = 0;

		String sql = "select * from veicolo where marca = 'ford' ;";

		try {
			st = con.prepareStatement(sql);

			ResultSet res = null;

			st.execute();
			res = st.getResultSet();

			while (res.next()) {
				targa = res.getString("targa");
				marca = res.getString(2);
				modello = res.getString(3);
				peso = res.getInt(4);
				assi = res.getInt(5);
				altezza = res.getInt(6);
				anno = res.getInt(7);
				categoria = res.getString(8);
				co2 = res.getDouble(9);

			}

		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "error");
			e1.printStackTrace();
		}

		Veicolo a = null;

		if (categoria.equals("A"))

			a = new ClasseA(targa, modello, marca, anno, peso, co2, assi, null, altezza);

		if (categoria.equals("B"))
			a = new ClasseB(targa, modello, marca, anno, peso, co2, assi, null, altezza);

		if (categoria.equals("3"))
			a = new Classe3(targa, modello, marca, anno, peso, co2, assi, null, altezza);

		if (categoria.equals("4"))
			a = new Classe4(targa, modello, marca, anno, peso, co2, assi, null, altezza);

		if (categoria.equals("5"))
			a = new Classe5(targa, modello, marca, anno, peso, co2, assi, null, altezza);
		// doppio check tra categoria in DB e categoria calcolata da setClasseVeicolo();

		System.out.println(a.getClass());
		a.setClasseAmbientale();
		a.setClasseVeicolo();
		a = a.factory();

		return a;

	}

	public Veicolo getV(String string) {

		java.sql.PreparedStatement st = null;
		Connection con = new Database().Connect();
		String targa = "";
		String marca = "";
		String modello = "";
		int peso = 0;
		int assi = 0;
		int altezza = 0;
		int anno = 0;
		String categoria = "";
		double co2 = 0;
		if (string.equals("")) {
			JOptionPane.showMessageDialog(null, "rileva la targa");
			return null;
		}
		String sql = "select * from veicolo where targa = '" + string + "' ;";

		try {
			st = con.prepareStatement(sql);

			ResultSet res = null;

			st.execute();
			res = st.getResultSet();

			while (res.next()) {
				targa = res.getString("targa");
				marca = res.getString(2);
				modello = res.getString(3);
				peso = res.getInt(4);
				assi = res.getInt(5);
				altezza = res.getInt(6);
				anno = res.getInt(7);
				categoria = res.getString(8);
				co2 = res.getDouble(9);

			}

		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "error");
			e1.printStackTrace();
		}

		Veicolo a = null;
		if (categoria.equals("A"))
			a = new ClasseA(targa, modello, marca, anno, peso, co2, assi, null, altezza);

		if (categoria.equals("B"))
			a = new ClasseB(targa, modello, marca, anno, peso, co2, assi, null, altezza);

		if (categoria.equals("3"))
			a = new Classe3(targa, modello, marca, anno, peso, co2, assi, null, altezza);

		if (categoria.equals("4"))
			a = new Classe4(targa, modello, marca, anno, peso, co2, assi, null, altezza);

		if (categoria.equals("5"))
			a = new Classe5(targa, modello, marca, anno, peso, co2, assi, null, altezza);
//doppio check tra categoria in DB e categoria calcolata da setClasseVeicolo();
		System.out.println(a.getClass());

		a.setClasseAmbientale();
		a.setClasseVeicolo();
		a = a.factory();
		int i = a.checkClasseV();
		System.out.println(i);
		return a;

	}

}
