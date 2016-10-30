package de.hsMannheim.informatik.gdi.uebung04;

import static gdi.MakeItSimple.*;

public class PerfectNumber {

	public static void main(String[] args) {

		// Abfrage der Zahl
		// Vollkommene Zahlen zum Ausprobieren: 6, 28, 496, 8.128, 33.550.336
		// weitere vollkommene Zahlen liegen nicht mehr im Zahlenbereich von int
		print("Bitte geben Sie eine natürliche Zahl ein, um diese auf Vollkommenheit prüfen zu lassen: ");
		int ganzeZahl;
		ganzeZahl = readInt();
		readLine();

		// Prüfschleife, ob Eingabe korrekt
		while (ganzeZahl < 1) {
			print("Eingabe ungültig! Geben sie eine Zahl größer/gleich 1 ein.");
			ganzeZahl = readInt();
			readLine();
		}

		// Ausgabe vom Ergebnis
		if (isPerfectNumber(ganzeZahl)) {
			println("Herzlichen Glückwunsch!");
			println("Die " + ganzeZahl + " ist eine vollkommene Zahl!");
		}
	}

	static boolean isPerfectNumber(int ganzeZahl) {
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
		if (summe == ganzeZahl)
			return true;
		else
			// >>> HIER die Kommentare ändern, um den JUnit-Test durchlaufen zu
			// lassen! <<<
			// return false;
			throw new GDIException("Die " + ganzeZahl + " ist leider keine vollkommene Zahl!");
	}

}
