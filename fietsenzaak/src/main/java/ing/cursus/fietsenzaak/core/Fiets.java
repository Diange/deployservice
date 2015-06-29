package ing.cursus.fietsenzaak.core;

import org.hibernate.validator.constraints.NotBlank;

public class Fiets {

	private final int fietsId;
	private String fietsNaam;
	private double bedrag;
	
	
	public Fiets(int fietsId, String fietsNaam, double bedrag){
		this.fietsNaam = fietsNaam;
		this.fietsId = fietsId;
		this.bedrag = bedrag;
	}
	
	@NotBlank
	public int getId(){
		return fietsId;
	}
	@NotBlank
	public String getNaam(){
		return fietsNaam;
	}
	@NotBlank
	public double getBedrag(){
		return bedrag;
	}
	
	public void setNaam(String fietsNaam){
		this.fietsNaam = fietsNaam;
	}
}
