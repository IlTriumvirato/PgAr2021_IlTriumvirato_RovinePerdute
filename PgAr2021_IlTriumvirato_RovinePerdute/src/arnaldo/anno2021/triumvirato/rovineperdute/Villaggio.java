package arnaldo.anno2021.triumvirato.rovineperdute;

import java.util.ArrayList;

public class Villaggio{
	
	private int id;
	private String nome; 
	private Posizione coordinate;
	private ArrayList<Sentiero> collegamenti;
	private ArrayList<Integer> idCollegati;
	
	private double dijsktraValue;
	
	
	public Villaggio(Villaggio copia) {
		super();
		this.id = copia.getId();
		this.nome = copia.getNome();
		this.coordinate = new Posizione(copia.getCoordinate());
		this.collegamenti=copia.getCollegamenti();
		//this.collegamenti = new ArrayList<Sentiero>();
		//for(int i=0;i<copia.size();i++){
		//this.collegamenti.add(new Sentiero(copia.getCollegamenti().get(i));
		//}
	}
	
	public Villaggio(int id, String nome, Posizione coordinate) {
		super();
		this.id = id;
		this.nome = nome;
		this.coordinate = new Posizione(coordinate);
		this.collegamenti = new ArrayList<Sentiero>();
		this.collegamenti = new ArrayList<Sentiero>();
		this.idCollegati=new ArrayList<Integer>();
	}
	
	
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
	
	
	public double getX() {
		return coordinate.getX();
	}
	
	public double getY() {
		return coordinate.getY();
	}
	
	public double getH() {
		return coordinate.getH();
	}
	
	

	public ArrayList<Integer> getIdCollegati() {
		return idCollegati;
	}
	public void setIdCollegati(ArrayList<Integer> idCollegati) {
		this.idCollegati = idCollegati;
	}

	//non vengono chiamati finché non avviene l'aggiornamento dei sentieri
	public ArrayList<Sentiero> getCollegamenti() {
		return collegamenti;
	}
	public void setCollegamenti(ArrayList<Sentiero> collegamenti) {
		this.collegamenti = collegamenti;
	}


}
