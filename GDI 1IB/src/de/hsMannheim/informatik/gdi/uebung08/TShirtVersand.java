package de.hsMannheim.informatik.gdi.uebung08;

import static gdi.MakeItSimple.*;

public class TShirtVersand {

	private Kunden[] kunde = new Kunden[100];
	private int kundenanzahl = 0;
	/*
	 * Konstruktor Kunde benötigt
	 * Kundennummer
	 * Warenkorb
	 * 
	 * Konstruktor Bestellung benötigt
	 * Bestellnummer
	 * Int[] Bestellte Elemente (Inventarnummer)
	 * Lieferdatum
	 * 
	 */
	public static void main(String[] args) {
		int [] warenkorb = new int[10]; 
		TShirtVersand versand = new TShirtVersand();
		
		println("Registrieren Sie sich!");
		println("Geben Sie ihren Vornamen ein");
		String vorname = readLine();
		println("Geben sie ihren Nachnamen ein");
		String nachname = readLine();
		

	}
	
	/**
	 * Kunde kann sich registrieren
	 * @return kundennummer
	 * @param Vorname
	 * @param Nachname
	 */
	int registrieren (String Vorname, String Nachname){
		int kundennummer = erstelleKundennummer();
		kunde[kundenanzahl] = new Kunden(Vorname, kundennummer);
		kundenanzahl++;
		
		return kundennummer;
	}
	
	/**
	 * Erstelle zufällige kundennummer
	 * @return kundennummer
	 * 
	 */
	private int erstelleKundennummer() {
		int nummer = (int) (Math.random() * 1000000000);
		return nummer;
	}

	/**
	 * Suche nach T-Shirts anhand von Farbe, Aufdruck, Größe
	 */
	void suche(){
		sucheFarbe(null);
		sucheAufdruck(null);
		sucheGroesse(0);
		
	}
	
	/**
	 * Suche TShirts der angegebenen paramether
	 * @return String Ergebnisse
	 * @param größe
	 */
	
	private String sucheGroesse(int groesse) {
		
		
		return "keine Treffer";
		
	}

	/**
	 * Suche TShirts der angegebenen paramether
	 * @return String Ergebnisse
	 * @param aufdruck
	 */
	private String sucheAufdruck(String aufdruck) {
		
		
		return "keine Treffer";
	}

	/**
	 * Suche TShirts der angegebenen paramether
	 * @return String Ergebnisse
	 * @param farbe
	 */
	private String sucheFarbe(String farbe) {
		
		
		return "keine Treffer";
	}

	/**
	 * bestellug mehrerer T-Shirts
	 * @return bestellnummer
	 * @param int[] warenkorb
	 * @exception Warenkorp ist leer
	 */
	
	int bestellung(int[] warenkorb){
		
		return 43321;
	}
	
	/**
	 * Bestellung stonieren
	 * @param bestellnummer
	 * @exception bestellnummer nicht verfügbar
	 */
	void stonieren(int bestellnummer){
		
		
	}
	/**
	 * Lieferdatum abfragen
	 * @param String Lieferdatum
	 * @exception bestellnummer nicht verfügbar
	 */
	String abfrageLieferdatum(int bestellnummer){
		
		
		return "datum";
	}
	

}
