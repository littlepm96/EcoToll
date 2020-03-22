package model.components;

import model.interfaces.Casellointer;

public class Casello implements Casellointer {
private int km;
private String id;
private String idAuto;
private String nome;

public Casello(int km, String codice, String id,String nome) {

	this.km = km;
	this.id = codice;
	this.idAuto = id;
	this.nome=nome;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public Casello(int km, String nome, String id) {

	this.km = km;
	this.id = nome;
	this.idAuto = id;
}


public int getKm() {
	return km;
}
public void setKm(int km) {
	this.km = km;
}
public String getId() {
	return id;
}
public void setId(String nome) {
	this.id = nome;
}
public String getIdAuto() {
	return idAuto;
}
public void setIdAuto(String id) {
	this.idAuto = id;
}

}
