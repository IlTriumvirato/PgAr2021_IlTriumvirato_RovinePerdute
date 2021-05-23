package arnaldo.anno2021.triumvirato.rovineperdute;

public class RovinePerduteMain {
	
	public static void main(String[] args) {
		
		Veicolo veicoloTeam1 = new Veicolo(TipologiaSpostamento.ORIZZONTALE, Constants.TEAM1_NAME);
		Veicolo veicoloTeam2 = new Veicolo(TipologiaSpostamento.VERTICALE, Constants.TEAM2_NAME);
		Mappa mappaTotale = InputXML.inputMappa(Constants.MAP_PATHNAME);
		
			
		Cammino cammino1 = CalcolatoreCammini.calcolaCamminoMinimo(mappaTotale, veicoloTeam1);
		Cammino cammino2 = CalcolatoreCammini.calcolaCamminoMinimo(mappaTotale, veicoloTeam2);
		
		OutputXML.outputPaths(cammino1, cammino2, veicoloTeam1, veicoloTeam2);
		

	}

}
