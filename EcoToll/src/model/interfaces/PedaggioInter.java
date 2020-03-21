package model.interfaces;

import model.components.Classe3;
import model.components.Classe4;
import model.components.Classe5;
import model.components.ClasseA;
import model.components.ClasseB;
import model.components.Veicolo;

public interface PedaggioInter {

	public double arrotondamento(double a);

	public double tariffaFinale(ClasseA a);

	public double tariffaFinale(ClasseB a);

	public double tariffaFinale(Classe3 a);

	public double tariffaFinale(Classe4 a);

	public double tariffaFinale(Classe5 a);

}