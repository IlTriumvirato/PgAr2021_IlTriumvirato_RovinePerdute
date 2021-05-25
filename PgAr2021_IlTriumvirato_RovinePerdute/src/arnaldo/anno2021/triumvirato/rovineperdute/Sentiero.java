package arnaldo.anno2021.triumvirato.rovineperdute;

public class Sentiero {
	
	private Villaggio partenza;
	private Villaggio destinazione;
	private int idPartenza;
	private int idDestinazione;
	private double costoOrizzontale;
	private double costoVerticale;
	
	
	
	
	public Sentiero(int idPartenza, int idDestinazione) {
		super();
		this.idPartenza = idPartenza;
		this.idDestinazione = idDestinazione;
	}
	
	public Sentiero(Villaggio partenza, Villaggio destinazione) {
		this.partenza=partenza;
		this.destinazione=destinazione;
		this.idPartenza=partenza.getId();
		this.idDestinazione=destinazione.getId();
		this.generateCosts();
	}
	
	
	//non � stato creato un costruttore apposito per avere la sicurezza di preservare lo stesso indirizzo in memoria
	/***
	 * Aggiorna le informazioni riportate da questo sentiero, da solo l'id di partenza e destinazione ai riferimenti ai villaggi di partenza e destinazione
	 * @param partenza � il villaggio di partenza
	 * @param destinazione � il villaggio di destinazione
	 */
	public void aggiornaSentiero(Villaggio partenza, Villaggio destinazione) {
		this.partenza=partenza;
		this.destinazione=destinazione;
		this.idPartenza=partenza.getId();
		this.idDestinazione=destinazione.getId();
		this.generateCosts();
	}
	
	
	
	public Villaggio getPartenza() {
		return partenza;
	}
	public void setPartenza(Villaggio partenza) {
		this.partenza = partenza;
	}
	
	
	public Villaggio getDestinazione() {
		return destinazione;
	}
	public void setDestinazione(Villaggio destinazione) {
		this.destinazione = destinazione;
	}
	
	
	public double getCostoOrizzontale() {
		return costoOrizzontale;
	}
	public void setCostoOrizzontale(double costoOrizzontale) {
		this.costoOrizzontale = costoOrizzontale;
	}
	
	
	public double getCostoVerticale() {
		return costoVerticale;
	}
	public void setCostoVerticale(double costoVerticale) {
		this.costoVerticale = costoVerticale;
	}
	
	
	public int getIdPartenza() {
		return idPartenza;
	}
	public void setIdPartenza(int idPartenza) {
		this.idPartenza = idPartenza;
	}

	
	public int getIdDestinazione() {
		return idDestinazione;
	}
	public void setIdDestinazione(int idDestinazione) {
		this.idDestinazione = idDestinazione;
	}

	
	public void generateCosts() { //deve essere fatto il controllo se il collegamento esiste, su metodo chiamante
		this.generateHorizontalCost();
		this.generateVerticalCost();
	}
	
	
	public void generateHorizontalCost() {
		this.costoOrizzontale=this.partenza.getCoordinate().getHorizontalDistance(destinazione.getCoordinate());
	}

	public void generateVerticalCost() {
		this.costoVerticale=this.partenza.getCoordinate().getVerticalDistance(destinazione.getCoordinate());
	}

	public double costoSentiero(Veicolo v) {
		if(v.getMezzo()==TipologiaSpostamento.ORIZZONTALE) {
			return this.costoOrizzontale;
		} else if(v.getMezzo()==TipologiaSpostamento.VERTICALE) {
			return this.costoVerticale;
		}
		return -1;
	}
	
	
}
