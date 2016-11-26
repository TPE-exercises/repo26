package de.hsMannheim.informatik.gdi.uebung07.bibliothek;

import static gdi.MakeItSimple.*;

public class Bibliothek {
	final static int BUCH_VERFÜGBAR = 1;
	final static int BUCH_VERLIEHEN = 2;
	final static int BUCH_INFO_TITEL = 1;
	final static int BUCH_INFO_NUMMER = 2;
	static int kundenAnzahl = 0;
	static KundenKonto[] kunden = new KundenKonto[100];
	Buecher[] buecher = new Buecher[100];
	private String name;
	private int anzahlBücher;
	
	Bibliothek(String name, int anzahlBücher) {
		this.name = name;
		this.anzahlBücher = anzahlBücher;
	}

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

							boolean kontoLöschenMöglich = kontoLöschenMöglich(kontonummer);
							if (kontoLöschenMöglich) {
								loescheKonto(kontonummer);
								println("Ihr Konto " + kontonummer + " wurde gelöscht");
							} else {
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
				println("1 = Titel | 2 = Inventarnummer");
				int menue_buchVerfügbar = readInt();
				readLine();
				trenner();

				String buchInfo = null;
				int buchInfoArt = 0;

				switch (menue_buchVerfügbar) {// Switch 4 (in 1)
				case (1):
					print("Geben sie den Titel ein: ");
					buchInfo = readLine();
					buchInfoArt = BUCH_INFO_TITEL;
					trenner();
					break;
				case (2):
					print("Geben sie die Inventarnummer ein: ");
					buchInfo = readLine();
					buchInfoArt = BUCH_INFO_NUMMER;
					trenner();
					break;
				}

				int status = istBuchVerfügbar(buchInfo, buchInfoArt);

				if (status == BUCH_VERFÜGBAR) {

				} else if (status == BUCH_VERLIEHEN) {

				} else {// BUCH_NICHT_VORHANDEN

				}

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

		int kontonummer = (int) (Math.floor(Math.random() * 90000) + 10000);

		String passwort = erstellePasswort(kontonummer);

		kundenAnzahl++;

		return kontonummer;

	}

	static String erstellePasswort(int kundennummer) {
		String passwortEingabe1 = "pass1";
		String passwortEingabe2 = "pass2";
		boolean passwortStimmeenUeberein = false;

		while (!passwortStimmeenUeberein) {

			print("Geben sie ihr gewünschtes Passwort ein: ");
			passwortEingabe1 = readLine();
			println();
			print("Wiederholen sie ihr Passwort:           ");
			passwortEingabe2 = readLine();
			println();

			if (passwortEingabe1.equals(passwortEingabe2))
				passwortStimmeenUeberein = true;
			else
				println("Die Passwörter stimme nicht überein, versuchen sie es erneut.");
		}
		return passwortEingabe1;

	}

	static void loescheKonto(int kundennummer) {

		int position = sucheKundenKontoPosition(kundennummer);

		kundenAnzahl--;

	}

	private static int sucheKundenKontoPosition(int kundennummer) {
		int position = 0;

		return position;
	}

	static boolean kontoLöschenMöglich(int kontonummer) {

		// Prüfe ob noch Bücher geliehen sind

		return false;
	}

	public static int istBuchVerfügbar(String buchInfo, int buchInfoArt) {
		int buchStatus;

		if (BUCH_INFO_NUMMER == buchInfoArt) {

			// Suche Inventarnummer für buchInfo

		} else if (BUCH_INFO_TITEL == buchInfoArt) {

			// Suche Titel für buchInfo

		}

		buchStatus = BUCH_VERFÜGBAR;
		buchStatus = BUCH_VERLIEHEN;

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
		String buecherliste= "kein Buch";


		return buecherliste;
	}
	
	static int zeigeAlzahlGelieheneBücher (int kundennummer){
		int anzahl = 0;
		
		//Zähle Bücher
		
		return anzahl;
	}

}
