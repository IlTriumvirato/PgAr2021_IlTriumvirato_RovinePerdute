package arnaldo.anno2021.triumvirato.rovineperdute;

public class Sentiero {
	private Villaggio partenza;
	private Villaggio destinazione;
	private double costoOrizzontale;
	private double costoVerticale;
	
	
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
	
	public double costoSentiero(Veicolo v) {
		if(v.getMezzo()==TipologiaSpostamento.ORIZZONTALE) {
			return this.costoOrizzontale;
		} else if(v.getMezzo()==TipologiaSpostamento.VERTICALE) {
			return this.costoVerticale;
		}
		return -1;
	}
	
}
