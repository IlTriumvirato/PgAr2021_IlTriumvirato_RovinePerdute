package arnaldo.anno2021.triumvirato.rovineperdute;

public class RovinePerduteMain {
	public static boolean continueExectuion=true;
	
	private static void inizializzazione() {
		continueExectuion=true;
		fornisciInformazioniUtilizzo();
	}

	public static void setUnexecutable() {
		continueExectuion=false;
	}
	
	public static boolean canContinueExecution() {
		return continueExectuion;
	}
	
	public static void fornisciInformazioniUtilizzo() {
		System.out.println(Constants.INFORMATION_MESSAGE);
	}
	
	public static void notifyResults() {
		if(continueExectuion) {
			System.out.println("\n"+Constants.ALERT_MESSAGE_SUCCESSFUL_EXECUTION);
		}else {
			System.out.println("\n"+Constants.ERROR_MESSAGE_UNSUCCESSFUL_EXECUTION);
		}
	}
	
	
	
	public static void main(String[] args) {
		
		inizializzazione();
		
		Mappa mappaTotale = InputXML.inputMappa(Constants.PATH_RELATIVO_MAPPA);
		
		if(continueExectuion) {
		
			//per testing
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
			
			cammino1.aggiornaCosto(Constants.squadra1.getVeicolo());
			cammino2.aggiornaCosto(Constants.squadra2.getVeicolo());
			
			try {
				OutputXML.outputPaths(cammino1, cammino2, Constants.PATH_RELATIVO_OUTPUT);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		notifyResults();
		
	}



}
