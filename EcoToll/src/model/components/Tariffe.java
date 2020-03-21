package model.components;

import model.interfaces.Tariffeinter;

public class Tariffe implements Tariffeinter {
	private double[] tariffaM;
	private double[] tariffaP;
	private double[] oneri;

	public Tariffe(double[] tariffaM, double[] tariffaP, double[] on) {

		this.tariffaM = tariffaM;
		this.tariffaP = tariffaP;
		this.oneri = on;
	}

	public double[] getTariffaM() {
		return tariffaM;
	}

	public void setTariffaM(double[] tariffaM) {
		this.tariffaM = tariffaM;
	}

	public double[] getTariffaP() {
		return tariffaP;
	}

	public void setTariffaP(double[] tariffaP) {
		this.tariffaP = tariffaP;
	}

	public double[] getOneri() {
		return oneri;
	}

	public void setOneri(double[] oneri) {
		this.oneri = oneri;
	}

	public double[] getTariffa(Autostrada autostrada) {
		if (autostrada.getTipoAutostrada().equals(Tipologia.montagna))
			return this.getTariffaM();

		if (autostrada.getTipoAutostrada().equals(Tipologia.pianura))
			return this.getTariffaP();
		return null;

	}

}
