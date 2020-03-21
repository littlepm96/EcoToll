package model.components;

import java.util.*;

import javax.swing.JOptionPane;

import model.interfaces.AutostradaInter;

enum Tipologia {
	pianura, montagna
};

public class Autostrada implements AutostradaInter {
	private ArrayList<Casello> caselli;
	private String id;
	private double[] tariffe = new double[5];
	private Tipologia tipoAutostrada;
	private String nome;
	private String user;

	public Autostrada(String id, String nome, String tipo, String user) {
		this.id = id;
		this.nome = nome;
		this.tipoAutostrada = setTipoAutostrada(tipo);
		this.user = user;

	}

	public Autostrada(ArrayList<Casello> caselli, String id, double[] tariffa, Tipologia tipologia) {

		this.caselli = caselli;
		this.id = id;
		this.tariffe = tariffa;
		this.tipoAutostrada = tipologia;

	}

	public Autostrada(ArrayList<Casello> caselli, String id, double[] tariffa, String tipologia) {

		this.caselli = caselli;
		this.id = id;
		this.setTariffe(tariffa);
		this.tipoAutostrada = setTipoAutostrada(tipologia);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public ArrayList<Casello> getCaselli() {
		return caselli;
	}

	public void setCaselli(ArrayList<Casello> caselli) {
		this.caselli = caselli;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Tipologia getTipoAutostrada() {
		return tipoAutostrada;
	}

	public String getTipoToString() {
		String tipoAutostrada = "";
		if (this.tipoAutostrada.equals(Tipologia.montagna))
			tipoAutostrada = "montagna";
		if (this.tipoAutostrada.equals(Tipologia.pianura))
			tipoAutostrada = "pianura";
		return tipoAutostrada;
	}

	public void setTipoAutostrada(Tipologia tipoAutostrada) {
		this.tipoAutostrada = tipoAutostrada;
	}

	public Tipologia setTipoAutostrada(String tipoAutostrada) {
		if (tipoAutostrada.equalsIgnoreCase("montagna") || tipoAutostrada.equalsIgnoreCase("m")
				|| tipoAutostrada.equalsIgnoreCase("pianura") || tipoAutostrada.equalsIgnoreCase("p")) {

			if (tipoAutostrada.equalsIgnoreCase("montagna") || tipoAutostrada.equalsIgnoreCase("m")) {
				return Tipologia.montagna;
			}
			if (tipoAutostrada.equalsIgnoreCase("pianura") || tipoAutostrada.equalsIgnoreCase("p")) {
				return Tipologia.pianura;
			}
		}
		return null;

	}

	@Override
	public void addCasello(Casello a) {
		this.caselli.add(a);

	}

	@Override
	public void removeCasello(Casello a) {
		this.caselli.remove(a);

	}

	public double[] getTariffe() {
		return tariffe;
	}

	public void setTariffe(double[] tariffe) {
		this.tariffe = tariffe;
	}

	@Override
	public void addCaselli(ArrayList<Casello> a) {
		for (Casello c : a) {
			this.addCasello(c);
		}

	}

}
