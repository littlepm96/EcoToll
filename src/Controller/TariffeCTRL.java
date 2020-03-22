package Controller;

import model.DAO.TariffeDAO;
import model.components.Tariffe;

public class TariffeCTRL {


	public Tariffe createTariffe() {
		
		return new TariffeDAO().buildTariffe();
	};
	public void modtariffe(Tariffe t) {
		new TariffeDAO().update(t);
	}

	

}
