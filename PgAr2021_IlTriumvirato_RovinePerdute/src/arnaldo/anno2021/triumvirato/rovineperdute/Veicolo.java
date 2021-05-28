package arnaldo.anno2021.triumvirato.rovineperdute;

public class Veicolo {
	
	private TipologiaSpostamento mezzo;
	private String nome;
	
	
	public Veicolo(TipologiaSpostamento mezzo, String nome) {
		super();
		this.mezzo = mezzo;
		this.nome = nome;
	}
	
	
	public TipologiaSpostamento getMezzo() {
		return mezzo;
	}
	public void setMezzo(TipologiaSpostamento mezzo) {
		this.mezzo = mezzo;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
