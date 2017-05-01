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
		if (name != "Spaghettieis" || name != "Bananasplit")
			entschuldigen();
		else {
System.out.println("Sehr gern!");
			Eis neuesEis = new Eis();
			verabschieden();
		}
	}

	void begruessen() {
		System.out.println("Guten Tag! Was darf ich Ihnen servieren?");
	}

	void kassieren(int preis) {
		System.out.println("Das macht dann bitte: " + preis);
	}

	void verabschieden() {
		System.out.println("Auf Wiedersehen! Und lassen Sie sich ihr Eis schmecken!");
	}

	void entschuldigen() {
		System.out.println("Verzeihen Sie bitte, aber diese Eissorte führen wir leider nicht.");
	}
}
