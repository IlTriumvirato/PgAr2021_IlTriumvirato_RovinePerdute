package arnaldo.anno2021.triumvirato.rovineperdute;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class CalcolatoreCammini {
	static TreeSet<Sentiero> treeSentiero= new TreeSet<>();
	
	static Veicolo v_utilizzato;
	static Villaggio theLostRuins;
	
	
	public static Cammino calcolaCamminoMinimo(Mappa mappaTotale, Veicolo veicoloTeam) {
		
		firstStep(mappaTotale,veicoloTeam);
		Cammino daRitornare=new Cammino();
			
		ArrayList<Integer> lista=mappaTotale.getLostRuins().getPathIds();
		
		for(int i=0;i<lista.size();i++) {
			daRitornare.aggiungiVillaggio(mappaTotale.getVillaggi().get(lista.get(i)));
		}
		
		return daRitornare;
	}
	
	
	

	
	private static void firstStep(Mappa mappaTotale,Veicolo v) {
		
		if(v.getMezzo()==TipologiaSpostamento.ORIZZONTALE) {
            Sentiero.veicoloOrizzontale=true;
        }else {
            Sentiero.veicoloOrizzontale=false;
        }
		
		treeSentiero= new TreeSet<>();
		v_utilizzato=v;
		theLostRuins=mappaTotale.getLostRuins();
		
		Villaggio campoBase=mappaTotale.getStartCamp();
		campoBase.setDijsktraValue(0);
		Sentiero firstPath=new Sentiero(campoBase,campoBase);
		
		mappaTotale.getStartCamp().setPathIds();
		
		treeSentiero.add(firstPath);
		
		nextStep();
	}
	

	/**
	 * 
	 */
	private static void nextStep() {
		//TreeSet<Sentiero> riferimentoTree=treeSentiero;    per debugging
		
		while(!treeSentiero.isEmpty()) {
			
			Sentiero stradaPercorsa=treeSentiero.pollFirst();
			Villaggio currentNode=stradaPercorsa.getDestinazione();
			double nodeCost=currentNode.getDijsktraValue();
			
			//non so se l'if cambia un gran ché a livello di efficienza, forse peggiora addirittura, non noto differenze con 10000 elementi, circa 5 secondi anche in quel caso
			//if(currentNode!=theLostRuins) {
				for(int i=0;i<currentNode.getCollegamenti().size();i++) {
					
					Sentiero pathWay=currentNode.getCollegamenti().get(i);
					Villaggio endNode=pathWay.getDestinazione();
					double cost=pathWay.getCostoSentiero(v_utilizzato);
					double fullCost=nodeCost+cost;
					
					if(endNode.nodeHasWorsePath(fullCost)) {
						pathWay.getDestinazione().setDijsktraValue(fullCost);
						pathWay.getDestinazione().setPathIds(currentNode.getPathIds());
						
						treeSentiero.add(pathWay);
					}else if(endNode==theLostRuins&&Math.abs(fullCost-endNode.getDijsktraValue())<Constants.EPSILON) {
						
						if(currentNode.getPathIds().size()+1<theLostRuins.getPathIds().size()){
							
							pathWay.getDestinazione().setDijsktraValue(fullCost);
							pathWay.getDestinazione().setPathIds(currentNode.getPathIds());
							
							treeSentiero.add(pathWay);
						}
						//else if() {
							
						//}
					}
					
					
					
					//se è alla fine E gli viene == dijsktravalue, deve scegliere il percorso
					
				}
			//}
			
		}

	}
	
	
	
	public static ContenitoreDatiOutput calcolaCamminiMinimi(Mappa mappaTotale) {
		ContenitoreDatiOutput risultato=new ContenitoreDatiOutput();
		
		
		risultato.setCamminoSquadra1(CalcolatoreCammini.calcolaCamminoMinimo(mappaTotale, Constants.squadra1.getVeicolo()));
		
		mappaTotale.resetDijkstra();
		
		risultato.setCamminoSquadra2(CalcolatoreCammini.calcolaCamminoMinimo(mappaTotale, Constants.squadra2.getVeicolo()));
		
		
		
		risultato.aggiornaCosti(Constants.squadra1.getVeicolo(), Constants.squadra2.getVeicolo());
		
		return risultato;
	}
	
	

}
