package business.businessSpielplatz;

public class Spielplatz {
	
	private String name;
	private String strasse;
	private int anzahlQuadratmeter;
	
	public Spielplatz(String name, String strasse, String anzahlQuadratmeter) {
		super();
		this.name = name;
		this.strasse = strasse;
		this.anzahlQuadratmeter = Integer.parseInt(anzahlQuadratmeter);
	}
	
	public String gibSpielplatzZurueck(char trenner){
  		return this.getName() + trenner 
  			+ this.getStrasse() + trenner
  		    + this.getAnzahlQuadratmeter();
   	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getStrasse() {
		return strasse;
	}
	
	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}
	
	public int getAnzahlQuadratmeter() {
		return anzahlQuadratmeter;
	}
	
	public void setAnzahlQuadratmeter(int anzahlQuadratmeter) {
		this.anzahlQuadratmeter = anzahlQuadratmeter;
	}
	
	

}
