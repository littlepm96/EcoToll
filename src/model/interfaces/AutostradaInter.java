package model.interfaces;

import java.util.ArrayList;

import model.components.Casello;

public interface AutostradaInter {
	public void addCasello(Casello a);

	public void removeCasello(Casello a);

	public void addCaselli(ArrayList<Casello> a);

}
