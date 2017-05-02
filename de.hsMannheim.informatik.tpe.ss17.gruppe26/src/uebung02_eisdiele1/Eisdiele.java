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
		System.out.println("Auf der Karte: Spaghettieis, Bananasplit");
		String name = readLine();
		if (name != "Spaghettieis" && name != "Bananasplit")
			entschuldigen();
		else {
			System.out.println("Sehr gern!");
			Eis neuesEis = new Eis();
			neuesEis.name = name;
			neuesEis.vorbereiten();
			neuesEis.fuellen();
			neuesEis.dekorieren();
			kassieren(neuesEis.preis);
			double gegeben = readInt();
			if (gegeben == neuesEis.preis)
				verabschieden();
		}
	}

	void begruessen() {
		System.out.println("Guten Tag! Was darf ich Ihnen servieren?");
	}

	void kassieren(double preis) {
		System.out.println("Das macht dann bitte: " + preis);
	}

	void verabschieden() {
		System.out.println("Auf Wiedersehen! Und lassen Sie sich ihr Eis schmecken!");
	}

	void entschuldigen() {
		System.out.println("Verzeihen Sie bitte, aber diese Eissorte führen wir leider nicht.");
	}
}
