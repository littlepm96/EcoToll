package model.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import model.components.Database;
import model.components.Tariffe;

public class TariffeDAO {
	public Tariffe buildTariffe() {
		Tariffe t = new Tariffe(null, null, null);
		String montagna = "montagna";
		String pianura = "pianura";
		String[] cat = { "a", "b", "3", "4", "5" };
		double[] d = { 0, 0, 0, 0, 0, 0 };
		double[] p = { 0, 0, 0, 0, 0 };
		double[] m = { 0, 0, 0, 0, 0 };
		int i = 0;

		Connection con = new Database().Connect();
		try {
			Statement st = con.createStatement();

			for (i = 0; i < 5; i++) {
				ResultSet result = st.executeQuery(
						"select Valore from tariffa where tipo ='" + montagna + "' and  categoria ='" + cat[i] + "'");

				if (result.next()) {

					m[i] = result.getDouble("Valore");
				}
			}
			t.setTariffaM(m);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "error");

			e.printStackTrace();
		}

///////////////////////////////////////////////////////////////////////////////////////////////////
		try {
			Statement st = con.createStatement();

			for (i = 0; i < 5; i++) {
				ResultSet result = st.executeQuery(
						"select Valore from tariffa where tipo ='" + pianura + "' and  categoria ='" + cat[i] + "'");

				if (result.next()) {

					p[i] = result.getDouble("Valore");
				}
			}
			t.setTariffaP(p);

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "error");
			e.printStackTrace();
		}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		try {
			Statement st = con.createStatement();

			for (i = 0; i < 6; i++) {
				ResultSet result = st.executeQuery("select importo from oneri ");

				for (i = 0; i < 6; i++) {
					if (result.next()) {

						d[i] = result.getDouble("importo");
					}

				}
				t.setOneri(d);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "error");

			e.printStackTrace();
		}

		return t;
	}

	public void update(Tariffe t) {
		String montagna = "montagna";
		String pianura = "pianura";
		String[] cat = { "a", "b", "3", "4", "5" };

		Connection con = new Database().Connect();
		try {
			Statement st = con.createStatement();

			for (int i = 0; i < 5; i++) {

				st.execute("update tariffa set Valore =" + t.getTariffaM()[i] + "  where Tipo ='" + montagna
						+ "' and  categoria ='" + cat[i] + "'");

				st.execute("update tariffa set Valore =" + t.getTariffaP()[i] + "  where Tipo ='" + pianura
						+ "' and  categoria ='" + cat[i] + "'");
			}
			for (int i = 0; i < 6; i++) {
				st.execute("update oneri set importo =" + t.getOneri()[i] + "  where euro ='" + (i + 1) + "' ;");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "error");

			e.printStackTrace();
		}
	}
}
