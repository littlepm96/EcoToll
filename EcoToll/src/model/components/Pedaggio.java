package model.components;

import model.interfaces.PedaggioInter;

public class Pedaggio implements PedaggioInter {
	private int iva = 22;
	private Percorso percorso;
	private Autostrada autostrada;
	private Veicolo v;
	private Tariffe t;

	public Pedaggio(Percorso percorso, Autostrada autostrada, Veicolo v, Tariffe t) {
		super();

		this.percorso = percorso;
		this.autostrada = autostrada;
		this.v = v;
		this.t = t;
	}

	public Tariffe getT() {
		return t;
	}

	public void setT(Tariffe t) {
		this.t = t;
	}

	public Veicolo getV() {
		return v;
	}

	public void setV(Veicolo v) {
		this.v = v;
	}

	public int getIva() {
		return iva;
	}

	public void setIva(int iva) {
		this.iva = iva;
	}

	public Percorso getPercorso() {
		return percorso;
	}

	public void setPercorso(Percorso percorso) {
		this.percorso = percorso;
	}

	public Autostrada getAutostrada() {
		return autostrada;
	}

	public void setAutostrada(Autostrada autostrada) {
		this.autostrada = autostrada;
	}

	@Override
	public double arrotondamento(double a) {

		return Math.round(a);
	}

	public double tariffaFinale() {

		if (v.getClass().equals(new ClasseB().getClass())) {
			return tariffaFinale((ClasseB) v);
		}
		if (v.getClass().equals(new ClasseA().getClass())) {
			return tariffaFinale((ClasseA) v);
		}
		if (v.getClass().equals(new Classe3().getClass())) {
			return tariffaFinale((Classe3) v);
		}
		if (v.getClass().equals(new Classe4().getClass())) {
			return tariffaFinale((Classe4) v);
		}
		if (v.getClass().equals(new Classe5().getClass())) {
			return tariffaFinale((Classe5) v);
		}

		return -1;
	}

	public double oneri() {

		if (v.getClasseAmbientale().equals(ClasseAmbienale.Euro1)) {
			return t.getOneri()[0];
		}

		if (v.getClasseAmbientale().equals(ClasseAmbienale.Euro2)) {
			return t.getOneri()[1];
		}
		if (v.getClasseAmbientale().equals(ClasseAmbienale.Euro3)) {
			return t.getOneri()[2];
		}
		if (v.getClasseAmbientale().equals(ClasseAmbienale.Euro4)) {
			return t.getOneri()[3];
		}
		if (v.getClasseAmbientale().equals(ClasseAmbienale.Euro5)) {
			return t.getOneri()[4];
		}
		if (v.getClasseAmbientale().equals(ClasseAmbienale.Euro6)) {
			return t.getOneri()[5];
		}
		v.setClasseAmbientale();

		return oneri();

	}

	@Override
	public double tariffaFinale(ClasseA g) {

		return arrotondamento(this.tarParziale(g) + (this.tarParziale(g) * this.iva / 100) + this.oneri());
	}

	@Override
	public double tariffaFinale(ClasseB a) {

		return arrotondamento(this.tarParziale(a) + (this.tarParziale(a) * this.iva / 100) + this.oneri());
	}

	@Override
	public double tariffaFinale(Classe3 a) {
		return arrotondamento(this.tarParziale(a) + (this.tarParziale(a) * this.iva / 100) + this.oneri());
	}

	@Override
	public double tariffaFinale(Classe4 a) {
		return arrotondamento(this.tarParziale(a) + (this.tarParziale(a) * this.iva / 100) + this.oneri());
	}

	@Override
	public double tariffaFinale(Classe5 a) {
		return arrotondamento(this.tarParziale(a) + (this.tarParziale(a) * this.iva / 100) + this.oneri());
	}

	public double tarParziale(ClasseA a) {
		return this.percorso.KmPercorsi() * (this.autostrada.getTariffe()[0]);
	}

	public double tarParziale(ClasseB a) {
		return this.percorso.KmPercorsi() * (this.autostrada.getTariffe()[1]);
	}

	public double tarParziale(Classe3 a) {
		return this.percorso.KmPercorsi() * (this.autostrada.getTariffe()[2]);
	}

	public double tarParziale(Classe4 a) {
		return this.percorso.KmPercorsi() * (this.autostrada.getTariffe()[3]);
	}

	public double tarParziale(Classe5 a) {
		return this.percorso.KmPercorsi() * (this.autostrada.getTariffe()[4]);
	}

}
