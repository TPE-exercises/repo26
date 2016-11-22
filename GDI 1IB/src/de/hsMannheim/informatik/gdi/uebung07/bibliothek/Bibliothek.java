package de.hsMannheim.informatik.gdi.uebung07.bibliothek;

import static gdi.MakeItSimple.*;

public class Bibliothek {

	/**
	 * Was kann die Bibliothek? (Aus der sicht des Kunden) 0. Konto anlegen
	 * retrun Kontonummer 0.1 Konto löschen 1. Buch ausleihen ggf return
	 * Rückgabefrist 2. Buch zurückgeben ggf return überzogenKosten 3. Buch
	 * reservieren ggf return zeitRaumReservierung 4. Buch verfügbar? return
	 * boolean 5. Abfrage welche Bücher geliehen sind print array
	 * gelieheneBücher
	 */

	public static void trenner() {
		println("---------------------------------");
	}

	public static void main(String[] args) {

		println("Was wollen sie machen?");
		println("1 = Kontoaktionen | 2 = Buch ausleihen | 3 = Buch zurückgeben | 4 = Buch reservieren | 5 = Prüfe ob Buch verfügbar ist | 6 = Konto anlegen |7 = Beenden");
		int k = readInt();
		readLine();
		trenner();
		switch (k) {
		case (1):
			println("Sie befinden sich in \"Kontoaktionen\"");
			println("Geben sie ihre Kontonummer ein, um sich anzumelden.");
			print("Kontonummer: ");
			int kontonummer = readInt();
			readLine();
			println("Was wollen sie machen?");
			println("1 = Konto anlegen | 2 = Konto löschen | 3 = Zeige geliehene Bücher | 4 = Beenden");
			int z = readInt();
			readLine();
			switch (z) {
			case (1):

				break;
			case (2):
				println("Sie befinden sich in \"Konto löschen\"");
				println("Wollen sie ihr Konto wirklich löschen?");
				println("1 = Ja | 2 = Nein");
				int bestätigen = readInt();
				switch (bestätigen) {
				case (1):
					boolean kontoGelöscht = loescheKonto(kontonummer);
					if (kontoGelöscht)
						println("Ihr Konto " + kontonummer + " wurde gelöscht");
					else {
						println("Ihr Konto " + kontonummer
								+ " kann nicht gelöscht werden. Bringen sie erst alle geliehenen Bücher zurück: ");
					}
					break;
				case (2):
					break;
				}

				// Zeige geliehene Bücher

				break;
			case (3):
				println("Sie befinden sich in \"Zeige geliehene Bücher\"");
				println("Sie haben folgende Bücher geliehen");

				break;
			case (4):
				break;

			}

			break;
		case (2):// Buch ausleihen
			break;
		case (3):// Buch zurückgeben
			break;
		case (4):// Buch reservieren
			break;
		case (5):// Prüfe ob Buch verfügbar ist
			break;
		case (6):// Konto anlegen
			println("Sie befinden sich in \"Konto anlegen\"");
			print("Geben sie ihren Vornamen ein: ");
			String vorname = readLine();
			println();

			print("Geben sie ihren Nachnamen ein: ");
			String nachname = readLine();
			println();

			print("Geben sie ihr Alter ein: ");
			int alter = readInt();
			readLine();
			println();

			// println("Sie heißen: " + vorname + " " + nachname + " und
			// sind " + alter + " Jahre alt.");
			int neuekontonummer = legeKontoAn(vorname, nachname, alter);
			println("Ihre Kontonummer ist: " + neuekontonummer + ". Merken sie sich diese!");
			break;
		}

		println("--> Programmende <--");

	}

	static int legeKontoAn(String vorname, String nachname, int alter) {

		return kundennummer;

	}

	static boolean loescheKonto(int kontonummer) {
		return false;

		// Prüfe ob noch Bücher geliehen sind
		// Lösche alle Daten

	}

	static boolean kontoLöschenMöglich(int kontonummer) {

		return false;
	}

	public boolean istBuchVerfügbar(String titel) {

		return false;
	}

}
