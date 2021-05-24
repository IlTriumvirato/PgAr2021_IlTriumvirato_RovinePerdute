package arnaldo.anno2021.triumvirato.rovineperdute;

public class RovinePerduteMain {
	
	public static void main(String[] args) {
		
		Veicolo veicoloTeam1 = new Veicolo(TipologiaSpostamento.ORIZZONTALE, Constants.TEAM1_NAME);
		Veicolo veicoloTeam2 = new Veicolo(TipologiaSpostamento.VERTICALE, Constants.TEAM2_NAME);
		System.out.println(Constants.INFORMATION_MESSAGE);
		
		Mappa mappaTotale = InputXML.inputMappa(Constants.PATH_RELATIVO_MAPPA);
		
		System.out.println("villaggi="+mappaTotale.getVillaggi().size());
		System.out.println("sentieri="+mappaTotale.getSentieri().size());		
		
		/*
		 	TESTING
		 	int k=4;
		 	for(int i=0;i<mappaTotale.getVillaggi().get(k).getCollegamenti().size();i++) {
				System.out.println("da 4 a "+mappaTotale.getVillaggi().get(k).getCollegamenti().get(i).getDestinazione().getId()+mappaTotale.getVillaggi().get(k).getCollegamenti().get(i).getDestinazione().getNome());
			}
		*/
		
		for(int i=0;i<mappaTotale.getVillaggi().size();i++) {
			System.out.println(mappaTotale.getVillaggi().get(i).getId()+": "+mappaTotale.getVillaggi().get(i).getNome());
		}
		
		/*	
		Cammino cammino1 = CalcolatoreCammini.calcolaCamminoMinimo(mappaTotale, veicoloTeam1);
		Cammino cammino2 = CalcolatoreCammini.calcolaCamminoMinimo(mappaTotale, veicoloTeam2);
		
		try {
			//OutputXML.outputPaths(cammino1, cammino2, veicoloTeam1, veicoloTeam2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		

	}

}
