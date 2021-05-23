package arnaldo.anno2021.triumvirato.rovineperdute;

import java.util.ArrayList;

public class Villaggio {
	private int id;
	private String nome; 
	private Posizione coordinate;
	private ArrayList<Sentiero> collegamenti;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Posizione getCoordinate() {
		return coordinate;
	}
	public void setCoordinate(Posizione coordinate) {
		this.coordinate = coordinate;
	}
	public ArrayList<Sentiero> getCollegamenti() {
		return collegamenti;
	}
	public void setCollegamenti(ArrayList<Sentiero> collegamenti) {
		this.collegamenti = collegamenti;
	}
	
	
}
