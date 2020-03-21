package model;

import java.util.ArrayList;
import java.util.Iterator;

import Controller.AutostradaCTRL;
import Controller.VeicoloCTRL;
import model.components.Autostrada;
import model.components.Casello;
import model.components.Classe3;
import model.components.Classe4;
import model.components.Classe5;
import model.components.ClasseA;
import model.components.ClasseB;
import model.components.Tariffe;

import model.components.Veicolo;
import model.interfaces.Veicolointer;
import Controller.TariffeCTRL;

public class test2 {

	public static void main(String[] args) {
		//Tariffe t= new TariffeCTRL().createTariffe();
		
		//Autostrada a =new Autostrada(null,"A01" ,t.getTariffaM() , "montagna");
		//Autostrada b =new AutostradaCTRL().getAutostrada("A01");
		
		//System.out.println(b.getId());
		
		//for(Casello r:b.getCaselli()){//System.out.println(r.getNome());}
		
		//System.out.println(b.getTipoToString());
		
		//for (double r :  t.getTariffaM()) {
			//System.out.println(r);
			
	//	}
	    
		//Veicolo s =new VeicoloCTRL().getv();
	    
		//if(s.getClass().equals(new ClasseB().getClass() )) 
	//	{		
			//System.out.println("yes");
//}
//		else {		
	
			//System.out.println("no");
//}
	
		//ArrayList<Autostrada> w = new AutostradaCTRL().getAutostrada();

		//Iterator<Autostrada> i= w.iterator();
	
		//while (i.hasNext()) {
	
			//System.out.println(i.next().getId())	;
			//}
		
	
		//ArrayList<String> q = new AutostradaCTRL().getCodAutostrada();
	
		//Iterator<String> z = q.iterator();
	
		//while (z.hasNext()){
		
			//System.out.println(z.next())	;
	//}
		Veicolo p =new VeicoloCTRL().getv();
		Veicolo i=new ClasseA();
				i=i.factory(p.targa, p.modello, p.marca, p.anno,p.peso, p.getCo2(), p.getAssi(),p.getAltezza());
		
		System.out.print(i.marca);

		System.out.print("--    "+ i.getClasseVeicolo()+"            ");
		
		int typo=i.checkClasseV();
		System.out.print(typo);
		if(i.getClass().isInstance(new ClasseB())) {
		System.out.println(i.factory(p.targa, p.modello, p.marca, p.anno,p.peso, p.getCo2(), p.getAssi(),p.getAltezza()).getClasseVeicolo());}
	
	}}


