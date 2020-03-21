package model.interfaces;

import model.components.Classe3;
import model.components.Classe4;
import model.components.Classe5;
import model.components.ClasseA;

import model.components.ClasseB;
import model.components.Veicolo;

public interface Veicolointer {
	Veicolo factory();

	Veicolo factory(String targa, String modello, String marca, int anno, int peso, double co22, int assi, int altezza);

}
