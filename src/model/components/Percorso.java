package model.components;

import model.interfaces.PercorsoInter;

public class Percorso implements PercorsoInter {
	private Casello entrata;
	private Casello uscita;

	public Percorso(Casello entrata, Casello uscita) {

		this.entrata = entrata;
		this.uscita = uscita;

	}

	public Casello getEntrata() {
		return entrata;
	}

	public void setEntrata(Casello entrata) {
		this.entrata = entrata;
	}

	public Casello getUscita() {
		return uscita;
	}

	public void setUscita(Casello uscita) {
		this.uscita = uscita;
	}

	@Override
	public int KmPercorsi() {

		return Math.abs(this.entrata.getKm() - this.uscita.getKm());
	};

}
