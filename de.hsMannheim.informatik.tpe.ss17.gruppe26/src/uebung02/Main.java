package uebung02;

public class Main {

	public static void main(String[] args) {
		

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
		 * 3 Kugeln Eis (nach wahl?), Nüsse, Sahne und Nusssauce
		 */
		
		Eisdiele mannheimerEisdiele = new MannheimerEisdiele("MonnemBestEis", "Mannheim");
//		Eisdiele koellnerEisdiele = new KoellnerEisdiele("KöllschBestEis", "Kölln");
//		Eisdiele berlinierEisdiele = new BerlinerEisdiele("BerlinBestEis", "Berlin");
		
		mannheimerEisdiele.bestellen();
//		koellnerEisdiele.bestellen();
//		berlinerEisdiele.bestellen();

	}

}