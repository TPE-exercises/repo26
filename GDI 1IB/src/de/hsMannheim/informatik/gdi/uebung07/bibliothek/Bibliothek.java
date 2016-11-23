package de.hsMannheim.informatik.gdi.uebung07.bibliothek;

import static gdi.MakeItSimple.*;

public class Bibliothek {
	final static int BUCH_NICHT_VORHANDEN = 0;
	final static int BUCH_VERFÜGBAR = 1;
	final static int BUCH_VERLIEHEN = 2;
	final static int BUCH_INFO_TITEL = 1;
	final static int BUCH_INFO_AUTOR = 2;

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
		boolean beenden = false;
		while (!beenden) {
			println("Was wollen sie machen?");
			println("1 = Anmeldung für Kontooptionen | 2 = Prüfe ob Buch verfügbar ist | 3 = Konto anlegen | 0 = Beenden");
			int menue_hauptmenue = readInt();
			readLine();
			trenner();

			// Anmeldung für Kontooperationen
			switch (menue_hauptmenue) {// Switch 1
			case (1): // Login
				println("Geben sie ihre Kontonummer und ihr Passwort ein, um sich anzumelden.");
				print("Kontonummer: ");
				int kontonummer = readInt();
				readLine();
				print("Passwort: ");
				int pass = readInt();
				readLine();
				// Abfrage auf übereinstimmung Dann erst weiter
				println("Erfolgreich Eingeloggt.");
				trenner();

				boolean logout = false;
				while (!logout) {
					println("Was wollen sie machen?");
					println("1 = Konto löschen | 2 = Buch ausleihen | 3 = Buch zurückgeben | 4 = Zeige geliehene Bücher | 0 = Logout");
					int menue_kontoOperationen = readInt();
					readLine();
					trenner();

					// Kontooperationen
					switch (menue_kontoOperationen) {// Switch 2 (in 1)
					case (1): // Konto löschen
						println("Sie befinden sich in \"Konto löschen\"");
						println("Wollen sie ihr Konto wirklich löschen?");
						println("1 = Ja | 2 = Nein");
						int menue_kontoLoeschen = readInt();
						trenner();

						switch (menue_kontoLoeschen) {// Switch 3 (in 2 (in 1))
						case (1): // Ja Konto löschen
							boolean kontoGelöscht = loescheKonto(kontonummer);
							if (kontoGelöscht)
								println("Ihr Konto " + kontonummer + " wurde gelöscht");
							else {
								println("Ihr Konto " + kontonummer
										+ " kann nicht gelöscht werden. Bringen sie erst alle geliehenen Bücher zurück: ");
							}
							logout = true;
							
							break;
						case (2): // Nein Konto nicht löschen
							// Abbruch
							println("Konto wurde nicht gelöscht.");
							trenner();
							break;

						}
						
						break;
					case (2):// Buch ausleihen
						println("Sie befinden sich in \"Buch ausleihen\"");
						println("Geben sie nun den Titel des Buches ein, welches sie ausleihen wollen.");
						String zuSuchendesBuch = readLine();
						trenner();
						break;
					case (3):// Buch zurückgeben
						println("Sie befinden sich in \"Buch zurückgeben\"");

						// Gebe Liste der der ausgeliehenen Bücher mit Index+1
						// aus
						// Abfrage welches Buch zurück soll
					trenner();
						break;
					case (4):// Zeige geliehene Bücher
						println("Sie befinden sich in \"Zeige geliehene Bücher\"");
						println("Sie haben folgende Bücher geliehen");
						// Zeige Liste von Benutzer
						trenner();
						break;
					case (0):
						logout = true;
					trenner();
						break;
					}
				}
				trenner();
				break;// Break Case 1(Switch 1)

			case (2):// Prüfe ob Buch verfügbar ist

				println("Sie befinden sich in \"Prüfe ob Buch verfügbar ist\"");
				println("Wonach möchten sie suchen? ");
				println("1 = Titel | 2 = Autor");
				int menue_buchVerfügbar = readInt();readLine();
				trenner();

				String buchInfo = null;
				int buchInfoArt = 0;

				switch (menue_buchVerfügbar) {//Switch 4 (in 1)
				case (1):
					print("Geben sie den Titel ein: ");
					buchInfo = readLine();
					buchInfoArt = BUCH_INFO_TITEL;
					trenner();
					break;
				case (2):
					print("Geben sie den Autor ein: ");
					buchInfo = readLine();
					buchInfoArt = BUCH_INFO_AUTOR;
					trenner();
					break;
				}

				int status = istBuchVerfügbar(buchInfo, buchInfoArt);
				
				println("Buchstatus: " + status);
				trenner();

				break;
			case (3):// Konto anlegen
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

				println("Sie heißen: " + vorname + " " + nachname + " und sind " + alter + " Jahre alt.");
				int neuekontonummer = legeKontoAn(vorname, nachname, alter);
				println("Ihre Kontonummer ist: " + neuekontonummer + ". Merken sie sich diese!");
				trenner();
				break;
			case (0):// Beenden
				beenden = true;
				break;
			}
		}

		println("--> Programmende <--");

	}

	static int legeKontoAn(String vorname, String nachname, int alter) {
		int kontonummer = 0;

		// Erstelle Kundennummer und lege Konto an

		// erstellePasswort
		erstellePasswort(kontonummer);

		return kontonummer;

	}

	static void erstellePasswort(int kundennummer) {

		// Gebe Passwort 2x ein und verbinde wenn gleich mit dem Konto

	}

	static boolean loescheKonto(int kontonummer) {

		// Prüfe ob noch Bücher geliehen sind
		kontoLöschenMöglich(kontonummer);
		// Lösche alle Daten
		return false;
	}

	static boolean kontoLöschenMöglich(int kontonummer) {

		// Prüfe ob noch Bücher geliehen sind

		return false;
	}

	public static int istBuchVerfügbar(String buchInfo, int buchInfoArt) {

		// Frage ab welche Info gesucht wird (Titel / Autor / Inv.Nummer)
		// Suche Array ab und Liste alles auf

		int buchStatus = BUCH_NICHT_VORHANDEN;

		return buchStatus;
	}

	static void leiheBuchAus(int kundennummer, String buchTitel) {

		// Prüfe ob Buch verfügbar
		// Wenn Verfügbar, setze auf nicht verfügbar
		// Füge Buch dem Benutzerkonto hinzu
	}

	static int buchZurueckgeben(int kundennummer, String buchTitel) {
		int kosten = 0;
		// Prüfe ausleihfrist ggf. Zahlungsaufforderung
		// Entferne Buch von Benutzerkonto
		// Setzte Status auf Verfügbar

		// Zeige geliehene Bücher
		return kosten;
	}

	static String zeigeGelieheneBücher(int kundennummer) {
		String buecherliste;

		buecherliste = "kein Buch";

		return buecherliste;
	}

}
