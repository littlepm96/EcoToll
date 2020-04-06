package Controller;

import java.util.ArrayList;

import model.DAO.AutostradaDAO;
import model.components.Autostrada;

public class AutostradaCTRL {
	public Autostrada getAutostrada(String id) {
		return new AutostradaDAO().getAutostrada(id);
	}


	public ArrayList<Autostrada> getAutostrada() {
		return new AutostradaDAO().getAutostrada();
	}
	
	
	
	public ArrayList<String> getCodAutostrada() {
		return new AutostradaDAO().getCod();
	}

	public void modAutostrada(Autostrada a) {
	
		new AutostradaDAO().modAuto(a);
	}



	public void delete(Autostrada y) {
		new AutostradaDAO().delete(y);
		
	}

	public void insert(Autostrada y) {
		new AutostradaDAO().insert(y);
		
	}

	
		

}
