package arnaldo.anno2021.triumvirato.rovineperdute;

public class RovinePerduteMain {
	
	public static void main(String[] args) {
		
		Veicolo veicoloTeam1 = new Veicolo(TipologiaSpostamento.ORIZZONTALE, Constants.TEAM1_NAME);
		Veicolo veicoloTeam2 = new Veicolo(TipologiaSpostamento.VERTICALE, Constants.TEAM2_NAME);
		System.out.println(Constants.INFORMATION_MESSAGE);
		
		Mappa mappaTotale = InputXML.inputMappa(Constants.PATH_RELATIVO_MAPPA);
		
		System.out.println("villaggi="+mappaTotale.getVillaggi().size());
		System.out.println("sentieri="+mappaTotale.getSentieri().size());		
		
		Cammino cammino1 = new Cammino();
		Cammino cammino2 = new Cammino();
		
		cammino1.aggiungiVillaggio(mappaTotale.getVillaggi().get(0));
		cammino1.aggiungiVillaggio(mappaTotale.getVillaggi().get(3));
		cammino1.aggiungiVillaggio(mappaTotale.getVillaggi().get(4));
		
		cammino2.aggiungiVillaggio(mappaTotale.getVillaggi().get(0));
		cammino2.aggiungiVillaggio(mappaTotale.getVillaggi().get(1));
		cammino2.aggiungiVillaggio(mappaTotale.getVillaggi().get(4));
	
		//Cammino cammino1 = CalcolatoreCammini.calcolaCamminoMinimo(mappaTotale, veicoloTeam1);
		//Cammino cammino2 = CalcolatoreCammini.calcolaCamminoMinimo(mappaTotale, veicoloTeam2);
		
		cammino1.aggiornaCosto(veicoloTeam1);
		cammino2.aggiornaCosto(veicoloTeam2);
		
		try {
			OutputXML.outputPaths(cammino1, cammino2, Constants.PATH_RELATIVO_OUTPUT);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
