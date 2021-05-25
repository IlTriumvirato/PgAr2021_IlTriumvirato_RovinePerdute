package arnaldo.anno2021.triumvirato.rovineperdute;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Mappa {
	private ArrayList <Villaggio> villaggi;
	private ArrayList <Sentiero> sentieri;
	private Map<Integer,Integer> listaPosizioni;
	Mappa(){
		villaggi=new ArrayList<Villaggio>();
		sentieri=new ArrayList<Sentiero>();
		listaPosizioni=new HashMap<Integer,Integer>();
	}
	
	public ArrayList<Villaggio> getVillaggi() {
		return villaggi;
	}
	public void setVillaggi(ArrayList<Villaggio> villaggi) {
		this.villaggi = villaggi;
	}
	public ArrayList<Sentiero> getSentieri() {
		return sentieri;
	}
	public void setSentieri(ArrayList<Sentiero> sentieri) {
		this.sentieri = sentieri;
	}

	public Villaggio findCityById(int idToFind) {
		//dev'essere chiamato solo se l'array villaggi è ordinato in base all'id
		Villaggio toReturn=null;
		
		Integer position=listaPosizioni.get(idToFind);
		
		if(position!=null) {
			toReturn=this.villaggi.get(position);
		}else {
			
			int start=0;
			int end=villaggi.size();
			int p=(start+end)/2;
			
			while(villaggi.get(p).getId()!=idToFind&&start!=end) {
					
				if(villaggi.get(p).getId()<idToFind) {
					start=p;
					p=(start+end)/2;
				}else if(villaggi.get(p).getId()>idToFind){
					end=p;
					p=(start+end)/2;
				}
			}
			
			if(start==end) {
				p=start;
			}

			listaPosizioni.put(idToFind, p);
			toReturn=villaggi.get(p);
		}
		
		return toReturn;
	}
	
	public void sortMappa() {
		Collections.sort(this.villaggi, new VillaggioComparator());
		 Collections.sort(this.sentieri, new SentieroComparator());
	}
	
	public Villaggio getLostRuins() { //must be sorted, it always is after input method
		return this.villaggi.get(this.villaggi.size()-1);
	}
}
