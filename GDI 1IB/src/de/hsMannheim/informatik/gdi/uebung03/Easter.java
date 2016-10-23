package de.hsMannheim.informatik.gdi.uebung03;

import static gdi.MakeItSimple.*;

public class Easter {

	public static void main(String[] args) {

		// Programmstart mit Jahreszahlabfrage
		println(">>Programm zur Berechnung des Ostersonntags<<");
		print("Geben Sie bitte eine vierstellige Jahreszahl ein, die nach 1582 liegt: ");

		int y;
		y = readInt();

		// Gültigkeitsprüfung der eingegebenen Jahreszahl und
		// eventuelle Fehlermeldung mit erneuter Abfrage
		while (y < 1583 || y > 9999) {
			println("Fehler!");
			println("Die eingegebene Jahreszahl muss nach 1582 liegen und muss eine vierstellige Zahl sein!");
			print("Geben Sie eine gültige Jahreszahl ein: ");
			y = readInt();
			readLine();
		}

		// Berechnung des Ostersonntags laut Übungsblatt
		int g = y % 19;
		int c = y / 100;
		int h = (c - (c / 4) - ((8 * c + 13) / 25) + 19 * g + 15) % 30;
		int i = h - (h / 28) * (1 - (29 / (h + 1)) * ((21 - g) / 11));
		int j = (y + (y / 4) + i + 2 - c + (c / 4)) % 7;
		int l = i - j;
		int month = 3 + ((l + 40) / 44);
		int day = l + 28 - 31 * (month / 4);

		// Ausgabe des Ergebnisses und Programmende
		println("Der Ostersonntag im Jahr " + y + " fällt auf den " + day + "." + month + "." + y + ".");
		println(">>Programmende<<");

	}

}
