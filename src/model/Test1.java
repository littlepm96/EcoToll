package model;
import model.components.*;
import java.util.ArrayList;

import model.components.Autostrada;
import model.components.Casello;
import model.components.ClasseA;

import model.components.Pedaggio;
import model.components.Percorso;


public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	;
		ClasseA v1= new ClasseA("AA121QQ","q3", "Nissan", 2002, 1500, 53, 2, null ,  150);
	v1.setClasseAmbientale();
	
	System.out.println(">Altezza veicolo:  "+v1.getAltezza()+"  > Classe ecologica:  "+ v1.getClasseAmbientale());
	Casello a=new Casello(300, "Rocca", "A01");
	Casello b=new Casello(310, "Valle", "A01");

	ArrayList <Casello> f=new ArrayList<Casello>();
	f.add(a);
	
	 double y[]={1.10,2.21,2.34,4.22,5};
	
	Autostrada a1 = new Autostrada(f, "a1", y, "montagna");
	a1.addCasello(b);
	System.out.println(">Tipo autostrada:  "+a1.getTipoAutostrada() + "  > Tariffa per veicoli classe 3:  "+a1.getTariffe()[2] );
	
	Percorso p= new Percorso (a1.getCaselli().get(0),a1.getCaselli().get(1)) ;
	
	System.out.println(">Km percorsi: "+p.KmPercorsi());
	
	//Pedaggio t = new Pedaggio(p,a1);
	
	
	//System.out.println(">tariffa complessiva:  "+t.tariffaFinale(v1));
	}

}
