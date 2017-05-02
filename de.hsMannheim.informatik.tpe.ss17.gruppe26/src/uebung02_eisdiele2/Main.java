package uebung02_eisdiele2;

public class Main {

	private static final String eis1 = "Spaghettieis";
	private static final String eis2 = "Bananensplit";
	private static final String eis3 = "Nussbecher";
	
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
		Eisdiele koelnerEisdiele = new KoelnerEisdiele("KölschBestEis", "Köln");
		Eisdiele berlinierEisdiele = new BerlinerEisdiele("BerlinBestEis", "Berlin");

		
		mannheimerEisdiele.bestellen(eis1);
		koelnerEisdiele.bestellen(eis2);
		berlinierEisdiele.bestellen(eis3);

	}

}
