package model.components;

import model.interfaces.Veicolointer;

enum ClasseAmbienale {
	Euro1, Euro2, Euro3, Euro4, Euro5, Euro6
}

enum classeVeicolo {
	A, B, C, D, E
};

public abstract class Veicolo implements Veicolointer {

	public String targa, modello, marca;
	public int anno, peso, assi;
	double co2;
	int altezza;
	ClasseAmbienale classeAmbientale;
	classeVeicolo classeVeicolo;

//costruttore per classe ambientale e classe by numero assi e QtaCO2

	public Veicolo(String targa, String modello, String marca, int anno, int peso, double co22, int assi,
			ClasseAmbienale classeAmbientale2, int altezza) {
		this.targa = targa;
		this.modello = modello;
		this.marca = marca;
		this.anno = anno;
		this.peso = peso;
		this.co2 = co22;
		this.assi = assi;
		this.classeAmbientale = classeAmbientale2;
		this.altezza = altezza;
	}

	public Veicolo() {
		this.targa = null;
		this.modello = null;
		this.marca = null;
		this.anno = 0;
		this.peso = 0;
		this.co2 = 0;
		this.assi = 0;
		this.classeAmbientale = null;
		this.altezza = 0;

	}

	public classeVeicolo getClasseVeicolo() {
		return classeVeicolo;
	}

	public void setClasseVeicolo(classeVeicolo classeVeicolo) {
		this.classeVeicolo = classeVeicolo;
	}

	public void setClasseVeicolo() {
		if (this.altezza <= 1.30 && this.assi == 2)
			this.classeVeicolo = model.components.classeVeicolo.A;
		if (this.altezza > 1.30 && this.assi == 2)
			this.classeVeicolo = model.components.classeVeicolo.B;
		if (this.assi == 3)
			this.classeVeicolo = model.components.classeVeicolo.C;
		if (this.assi == 4)
			this.classeVeicolo = model.components.classeVeicolo.D;
		if (this.assi >= 5)
			this.classeVeicolo = model.components.classeVeicolo.E;

	}

	public String getTarga() {
		return targa;
	}

	public void setTarga(String targa) {
		this.targa = targa;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public double getCo2() {
		return co2;
	}

	public void setCo2(double co2) {
		this.co2 = co2;
	}

	public int getAssi() {
		return assi;
	}

	public void setAssi(int assi) {
		this.assi = assi;
	}

	public ClasseAmbienale getClasseAmbientale() {
		return classeAmbientale;
	}

	public void setClasseAmbientale(ClasseAmbienale classeAmbientale) {
		this.classeAmbientale = classeAmbientale;
	}

	public void setClasseAmbientale() {
		if (this.co2 > 10)
			this.classeAmbientale = ClasseAmbienale.Euro1;
		if (this.co2 <= 10 && this.co2 > 8)
			this.classeAmbientale = ClasseAmbienale.Euro2;
		if (this.co2 <= 8 && this.co2 > 6)
			this.classeAmbientale = ClasseAmbienale.Euro3;
		if (this.co2 <= 6 && this.co2 > 4)
			this.classeAmbientale = ClasseAmbienale.Euro4;
		if (this.co2 <= 4 && this.co2 > 2)
			this.classeAmbientale = ClasseAmbienale.Euro4;
		if (this.co2 < 2)
			this.classeAmbientale = ClasseAmbienale.Euro6;
	}

	public int getAltezza() {
		return altezza;
	}

	public void setAltezza(int altezza) {
		this.altezza = altezza;
	}

	public int checkClasseV() {
		if (this.getClass().equals(new ClasseA().getClass())) {
			return 1;
		}
		if (this.getClass().equals(new ClasseB().getClass())) {
			return 2;
		}
		if (this.getClass().equals(new Classe3().getClass())) {
			return 3;
		}
		if (this.getClass().equals(new Classe4().getClass())) {
			return 4;
		}
		if (this.getClass().equals(new Classe5().getClass())) {
			return 5;
		}

		return 0;
	}

	public Veicolo factory(Veicolo v) {
		Veicolo a = new ClasseA(v);
		a = a.factory();
		a.reclass();
		return a;
	}

	@Override
	public Veicolo factory(String targa, String modello, String marca, int anno, int peso, double co22, int assi,
			int altezza) {
		Veicolo a = new ClasseA();
		a.setAltezza(altezza);
		a.setAssi(assi);
		a.setClasseVeicolo();
		a.setAnno(anno);
		a.setCo2(co22);
		a.setMarca(marca);
		a.setPeso(peso);
		a.setModello(modello);
		System.out.println(a.getClass());
		a = a.factory();
		System.out.println(a.getClass());

		return a;
	}

	@Override
	public Veicolo factory() {

		this.setClasseVeicolo();
		this.setClasseAmbientale();

		if (this.classeVeicolo.equals(model.components.classeVeicolo.A))
			return new ClasseA(this);
		if (this.classeVeicolo.equals(model.components.classeVeicolo.B))
			return new ClasseB(this);
		if (this.classeVeicolo.equals(model.components.classeVeicolo.C))
			return new Classe3(this);
		if (this.classeVeicolo.equals(model.components.classeVeicolo.D))
			return new Classe4(this);
		if (this.classeVeicolo.equals(model.components.classeVeicolo.E))
			return new Classe5(this);

		return null;
	}

	public void reclass() {
		Class<? extends Veicolo> t = this.getClass();
		if (t.equals(new ClasseB().getClass())) {
			this.setClasseVeicolo(model.components.classeVeicolo.B);

		}
		if (t.equals(new ClasseA().getClass())) {
			this.setClasseVeicolo(model.components.classeVeicolo.A);

		}
		if (t.equals(new Classe3().getClass())) {
			this.setClasseVeicolo(model.components.classeVeicolo.C);
		}
		if (t.equals(new Classe4().getClass())) {
			this.setClasseVeicolo(model.components.classeVeicolo.D);

		}
		if (t.equals(new Classe5().getClass())) {
			this.setClasseVeicolo(model.components.classeVeicolo.E);

		}
	}

};
