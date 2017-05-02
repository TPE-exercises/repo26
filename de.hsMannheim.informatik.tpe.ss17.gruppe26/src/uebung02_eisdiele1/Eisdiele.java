package uebung02_eisdiele1;

import static gdi.MakeItSimple.*;

public class Eisdiele {

	/**
	 * Eis zubereiten und Dialog mit Kunden
	 * 
	 * @param typ
	 */
	public void bestellen(String typ) {
		begruessen();
		String name = readLine();
		while (!name.equals("Spaghettieis") && !name.equals("Bananasplit")) {
			entschuldigen();
			System.out.println("Auf der Karte stehen: \"Spaghettieis\" und \"Bananasplit\"");
			name = readLine();
		}
		System.out.println("Sehr gern!");
		Eis neuesEis = new Eis();
		neuesEis.name = name;
		neuesEis.vorbereiten();
		neuesEis.fuellen();
		neuesEis.dekorieren();
		double gegeben;
		do {
			kassieren(neuesEis.preis);
			gegeben = readInt();
		} while (Double.compare(gegeben, neuesEis.preis) > 0.01);
		verabschieden();
	}

	void begruessen() {
		System.out.println("Guten Tag! Was darf ich Ihnen servieren?");
	}

	void kassieren(double preis) {
		System.out.println("Das macht dann bitte: " + preis + " Euro");
	}

	void verabschieden() {
		System.out.println("Auf Wiedersehen! Und lassen Sie sich ihr Eis schmecken!");
	}

	void entschuldigen() {
		System.out.println("Verzeihen Sie bitte, aber diese Eissorte führen wir leider nicht.");
	}
}
