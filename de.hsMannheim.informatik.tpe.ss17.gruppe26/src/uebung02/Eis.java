package uebung02;
import static gdi.MakeItSimple.*;
public class Eis {

	private String name;
	private double preis;
	private String behaeltnis;
	private String art;
	private String[] sorten;
	private String[] extras;

	Eis() {
		this.name = null;
		this.preis = 0;
		this.behaeltnis = null;
		this.art = null;
		this.sorten = null;
		this.extras = null;
	}

	Eis(String name, double preis, String behaeltnis, String art, String[] sorten, String[] extras) {
		this.name = name;
		this.preis = preis;
		this.behaeltnis = behaeltnis;
		this.art = art;
		this.sorten = sorten;
		this.extras = extras;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}

	public void setPreis(double preis) {
		this.preis = preis;
	}
	
	public double getPreis(){
		return this.preis;
	}

	public void setBehaeltnis(String behaeltnis) {
		this.behaeltnis = behaeltnis;
	}
	
	public String getBehaeltnis(){
		return this.behaeltnis;
	}

	public void setArt(String art) {
		this.art = art;
	}
	
	public String getArt(){
		return this.art;
	}

	public void setSorten(String[] sorten) {
		this.sorten = sorten;
	}
	
	public String[] getSorten(){
		return this.sorten;
	}

	public void setExtras(String[] extras) {
		this.extras = extras;
	}
	
	public String[] getExtras(){
		return this.extras;
	}

	// Spaghettieis
	/*
	 * Schale Schlagsahne über die Vanilleeis gepresst wird Graniert mit
	 * Erdbeersoße und geraspelter weißer Schokolade oder Kokosflocken
	 */

	// Bananensplit
	/*
	 * Banane, darauf Kugeln Vanille-, Schokoladen- und Erdbeereis darüber
	 * Ananassirup, Schokoladensauce und Erdbeersirup topping: Nusssplitter,
	 * Schlagsahne und Maraschino-Kirschen.
	 */

	// Nussbecher
	/*
	 * 3 Kugeln Eis, Nüsse, Sahne und Nusssauce
	 */

	/**
	 * Behaeltnis nehmen. . . Waffel/Becher/Teller/Schussel/Glas/etc.
	 */
	public void vorbereiten() {
		switch (this.name) {
		case ("Spaghettieis"):
		case ("Bananensplit"):
			this.setBehaeltnis("Teller");
			break;
		case ("Nussbecher"):
			this.setBehaeltnis("Becher");
			break;
		}
	}

	/**
	 * Behaeltnis mit Sorten nach Art fuellen. . .
	 */
	public void fuellen() {
		switch (this.name) {
		case ("Spaghettieis"):
			this.setArt("Spaghettis");
			String[] sorten = { "Vanille", "Vanille", "Vanille" };
			this.setSorten(sorten);
			break;
		case ("Bananensplit"):

			break;
		case ("Nussbecher"):

			break;
		}
	}

	/**
	 * 
	 * @return String array
	 */
	private String[] frageSortenAb(int anzahlKugeln) {
		String[] sorten = new String[anzahlKugeln];
		for(int i=0;i<sorten.length;i++){
			System.out.print("Welche Sorte: ");
			//TODO Prüfe ob sorte verfügbar
			sorten[i] = readLine();
			System.out.println();
		}
		return sorten;
	}

	/**
	 * Eis mit Extras dekorieren...
	 */
	public void dekorieren() {
		switch (this.name) {
		case ("Spaghettieis"):
			String[] extras = { "Erdbeersoße", "Kokosflocken" };
			this.setExtras(extras);
			break;
		case ("Bananensplit"):

			break;
		case ("Nussbecher"):

			break;
		}
	}

}
