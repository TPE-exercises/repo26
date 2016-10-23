package de.hsMannheim.informatik.gdi.uebung03;

import static gdi.MakeItSimple.*;

public class VollkommeneZahl {

	public static void main(String[] args) {

		print("Geben Sie eine Zahl ein: ");
		int ganzeZahl;
		ganzeZahl = readInt();
		readLine();

		// Vollkommene Zahlen zum Ausprobieren: 6, 28, 496, 8.128, 33.550.336
		// weitere vollkommene Zahlen liegen nicht mehr im Zahlenbereich von int

		while (ganzeZahl < 1) {
			println("Eingabe ungültig");
			ganzeZahl = readInt();
			readLine();
		}

		int teiler = 1;
		int summe = 0;

		// Die while-Schleife rechnet die Summe der Teiler zusammen.
		while (teiler < ganzeZahl) {
			if (ganzeZahl % teiler == 0) {
				summe += teiler;
			}
			teiler++;
		}

		// Entspricht die Summe der Teiler, der Zahl die eingegeben wurde, gibt
		// es eine positive Ausgabe.

		if (summe == ganzeZahl) {
			println("ja, die eingegebene Zahl ist vollkommen");
		}

		else {
			println("nein, die eingegebene Zahl ist nicht vollkommen");
		}

	}

}