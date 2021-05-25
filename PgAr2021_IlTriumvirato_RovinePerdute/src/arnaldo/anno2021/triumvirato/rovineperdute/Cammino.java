package arnaldo.anno2021.triumvirato.rovineperdute;

import java.util.ArrayList;

public class Cammino {
	
	private ArrayList<Villaggio> listaVillaggi;
	private double costo;
	
	public Cammino() {
		super();
		listaVillaggi=new ArrayList<Villaggio>();
	}
	
	
	public ArrayList<Villaggio> getListaVillaggi() {
		return listaVillaggi;
	}
	public void setListaVillaggi(ArrayList<Villaggio> listaVillaggi) {
		this.listaVillaggi = listaVillaggi;
	}
	
	
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}
	
	
	public void aggiungiVillaggio(Villaggio v) {
		this.listaVillaggi.add(v);
	}
	
	
	public void aggiornaCosto(Veicolo v) {
		
		double costoAppoggio=0;
		for(int i=0; i<listaVillaggi.size()-1;i++) {
			Sentiero s = new Sentiero(listaVillaggi.get(i),listaVillaggi.get(i+1));
			costoAppoggio += s.costoSentiero(v);
		}
		
		this.costo=costoAppoggio;
	}
	
}
