package uebung02_eisdiele1;

import static gdi.MakeItSimple.*;

public class Eis {

	String name; // Spaghettieis, Bananasplit
	double preis;
	String behaeltnis; // Waffel, Becher, Teller, Schüssel, Glas
	String art; // Bällchen, Bälle, Spaghettis, Kekse
	String[] sorten; // Vanille, Schokolade, Straciatella, Zitrone
	String[] extras; // Sahne, Schokosträusel, Keks, Soße

	/**
	 * Behältnis nehmen...
	 */
	void vorbereiten() {
		switch (this.name) {
		case ("Spaghettieis"):
			this.behaeltnis = "Becher";
			System.out.println("*nimmt " + this.behaeltnis + "*");
			break;
		case ("Bananensplit"):
			this.behaeltnis = "Teller";
			System.out.println("*nimmt " + this.behaeltnis + "*");
			break;
		}
	}

	/**
	 * Behältnis mit Sorten nach Art füllen...
	 */
	void fuellen() {
		switch (this.name) {
		case ("Spaghettieis"):
			this.art = "Spaghettis";
			System.out.println("*füllt " + this.art + " in " + this.behaeltnis + "*");
			break;
		case ("Bananensplit"):
			this.art = "Kugeln";
			String[] sorten = { "Vanille", "Vanille", "Vanille" };
			this.sorten = sorten;
			System.out.println("*füllt " + this.art + " " + this.sorten[0] + " in " + this.behaeltnis + "*");
			break;
		}
	}

	/**
	 * Eis mit Extras dekorieren...
	 */
	void dekorieren() {
		switch (this.name) {
		case ("Spaghettieis"):
			String[] extras = { "Schokosträusel", "Keks" };
			this.extras = extras;
			System.out.println("*dekoriert das Eis mit " + this.extras[0] + " und " + this.extras[1] + "*");
			this.preis = 3.50;
			System.out.println("Der Preis beträgt: " + this.preis);
			break;
		case ("Bananasplit"):
			String[] extras2 = { "Schokosträusel", "Soße", "Sahne" };
			this.extras = extras2;
			System.out.println("*dekoriert das Eis mit " + this.extras[0] + ", " + this.extras[1] + " und "
					+ this.extras[2] + "*");
			this.preis = 5.00;
			System.out.println("Der Preis beträgt: " + this.preis);
			break;
		}
	}

}
