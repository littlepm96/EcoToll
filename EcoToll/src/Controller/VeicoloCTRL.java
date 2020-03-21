package Controller;

import javax.swing.JTextField;

import model.DAO.VeicoloDAO;
import model.components.Classe3;
import model.components.Classe4;
import model.components.Classe5;
import model.components.ClasseA;
import model.components.ClasseB;
import model.components.Veicolo;

public class VeicoloCTRL {
	

public Veicolo getv() {
	return  new VeicoloDAO().getV();}

public Veicolo getv(String string) {
	return new VeicoloDAO().getV(string);
	

}


}
