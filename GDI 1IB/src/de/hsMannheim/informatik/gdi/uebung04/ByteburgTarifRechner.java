package de.hsMannheim.informatik.gdi.uebung04;

import static gdi.MakeItSimple.*;

public class ByteburgTarifRechner {

	static boolean istStationInLinie(int station, int[] linie) {
		int i = 0;
		boolean stationGefunden = false;

		while (i <= (linie.length - 1) && !stationGefunden) {
			if (station == linie[i]) {
				stationGefunden = true;
			} else
				i++;
		}
		return stationGefunden;
	}

	static int ermittleFahrtkosten(int startStation, int zielStation) {

		int fahrtkosten = 0;
		boolean grundPreisZweiEuro = false;
		int[] ringLinie = { 13, 23, 33, 43, 53/*, 63 */};
		int[] blaueZone = { 00, 11, 12, 13, 21, 22, 23, 31, 32, 33, 41, 42, 43, 51, 52, 53, 61, 62, 63 };
		int[] endStation = { 16, 26, 36, 46, 56, 66 };

		// 1. Der Start ist das Ziel
		if (startStation == zielStation) {
			return 0;
		}
		// 2. Start und Ziel liegen auf einer Linie nebeneinander
		else if ((((startStation - zielStation) == 1) || ((startStation - zielStation) == -1))) {
			return 1;
		}
		// 3. Start und Ziel liegen auf einer Linie nebeneinander und Station 00
		// ist dabei
		else if ((((startStation - 1) % 10 == 0) && (zielStation == 0))
				|| (((zielStation - 1) % 10 == 0) && (startStation == 0))) {
			return 1;
		}
		// 4. und 5. beide Stationen sind Ringlinie
		else if (((startStation - 3) % 10 == 0) && ((zielStation - 3) % 10 == 0)) {
			// 4. Start und Ziel sind über Ringlinie verbunden
			if (startStation - 10 == zielStation || startStation + 10 == zielStation) {
				return 1;
			}
			// 5. Start und Ziel sind über Ringline 1-5 oder 1-6 verbunden
			else if (((startStation == ringLinie[0]) && (zielStation == ringLinie[ringLinie.length - 1]))
					|| ((startStation == ringLinie[ringLinie.length - 1]) && (zielStation == ringLinie[0]))) {
				return 1;
			} else
				grundPreisZweiEuro = true;
		}

		// 6. Start und Ziel liegen in der Blauen Zone
		else if ((istStationInLinie(startStation, blaueZone)) && (istStationInLinie(zielStation, blaueZone))) {
			grundPreisZweiEuro = true;
		}

		// 7. und 8. beide Stationen außerhalb der Blauen Zone
		else if ((!(istStationInLinie(startStation, blaueZone)) && !(istStationInLinie(zielStation, blaueZone)))) {
			grundPreisZweiEuro = true;
			// 7. Beide Stationen auf einer Linie außerhalb der blauen Zone ->
			// muss 2 Kosten -> 2 Einzelkarten
			if ((startStation + 2 == zielStation && (istStationInLinie(zielStation, endStation))) || (zielStation + 2 == startStation && (istStationInLinie(startStation, endStation)))) {
				println("Empfehlung: Kaufen Sie sich 2 Tickets für \"eine Fahrt\" und Sie sparen 1 Euro! ;)");
				return 3;
			}
			// 8.
			else if (!(startStation - 1 == zielStation) && !(startStation - 2 == zielStation)
					&& !(startStation + 1 == zielStation) && !(startStation + 2 == zielStation)) {
				fahrtkosten += 2;
			}
		}

		// 2.1 Zonenüberquerung
		if (((istStationInLinie(startStation, blaueZone)) && !(istStationInLinie(zielStation, blaueZone)))
				|| ((istStationInLinie(zielStation, blaueZone)) && !(istStationInLinie(startStation, blaueZone)))) {
			fahrtkosten += 1;
			grundPreisZweiEuro = true;
			if ( (startStation + 3 == zielStation && (istStationInLinie(zielStation, endStation))) || (zielStation + 3 == startStation && (istStationInLinie(startStation, endStation))) ) {
				println("Empfehlung: Kaufen Sie sich 3 Tickets für \"eine Fahrt\" und Sie sparen 1 Euro! ;)");
				return 4;
			}
		}

		// 3.1 Beide Endstationen
		if ((istStationInLinie(startStation, endStation)) && (istStationInLinie(zielStation, endStation))) {
			fahrtkosten += 2;
			grundPreisZweiEuro = true;

		} // 3.2 Nur eine Endstation
		else if ((istStationInLinie(zielStation, endStation)) || (istStationInLinie(startStation, endStation))) {
			fahrtkosten += 1;
			grundPreisZweiEuro = true;
		}

		// 4.1 Tarif 2: Langstecke
		if (grundPreisZweiEuro) {
			fahrtkosten += 2;
		}

		return fahrtkosten;

	}

	public static void main(String[] args) {
		int[] stationen = { 00, 11, 12, 13, 14, 15, 16, 21, 22, 23, 24, 25, 26, 31, 32, 33, 34, 35, 36, 41, 42, 43, 44,
				45, 46, 51, 52, 53, 54, 55, 56/*, 61, 62, 63, 64, 65, 66 */};
		int startStation;
		int zielStation;
		int fahrtKosten;
		int erneut;

		print("Geben Sie ihre Startstation ein: ");
		startStation = readInt();
		while (!istStationInLinie(startStation, stationen)) {
			print("Die von Ihnen eingegebene Startstation ist nicht verfügbar. Bitte geben Sie nun eine gültige ein: ");
			startStation = readInt();
		}

		print("Geben Sie ihre Zielstation ein: ");
		zielStation = readInt();
		while (!istStationInLinie(zielStation, stationen)) {
			print("Die von Ihnen eingegebene Zielstation ist nicht verfügbar. Bitte geben Sie nun eine gültige ein: ");
			zielStation = readInt();
		}

		fahrtKosten = ermittleFahrtkosten(startStation, zielStation);
		
		if (fahrtKosten == 0) {
			println("Sie sind bereits an ihrem Ziel!");
		}
		else if (fahrtKosten > 0)
			println("Sie müssen für diese Fahrt " + fahrtKosten + " Euro zahlen.");

		println(">>>Programmende<<<");

		// Wenn der Fahrplan um eine weitere Linie ausgebaut werden soll, muss
		// man folgendes machen:
		// 1. in der main-Methode: im array "stationen" muss das Kommentar angepasst werden
		// 2. in der ermittleFahrtkosten-Methode: im Array "ringLinie" muss das Kommentar angepasst werden

		/*
		 * // Teste Nachbarstation println("00 und 11 (erwartet 1): " +
		 * ermittleFahrtkosten(0, 11) + "\n___________________________");
		 * println("11 und 00 (erwartet 1): " + ermittleFahrtkosten(11, 0) +
		 * "\n___________________________"); println("11 und 12 (erwartet 1): "
		 * + ermittleFahrtkosten(11, 12) + "\n___________________________");
		 * println("12 und 11 (erwartet 1): " + ermittleFahrtkosten(12, 11) +
		 * "\n___________________________"); println("35 und 36 (erwartet 1): "
		 * + ermittleFahrtkosten(35, 36) + "\n___________________________");
		 * println("23 und 33 (erwartet 1): " + ermittleFahrtkosten(23, 33) +
		 * "\n___________________________"); println("53 und 13 (erwartet 1): "
		 * + ermittleFahrtkosten(53, 13) + "\n___________________________");
		 * println("13 und 53 (erwartet 1): " + ermittleFahrtkosten(13, 53) +
		 * "\n___________________________");
		 * 
		 * //Teste normale Fahrten println("23 und 43 (erwartet 2): " +
		 * ermittleFahrtkosten(23, 43) + "\n___________________________");
		 * println("43 und 23 (erwartet 2): " + ermittleFahrtkosten(43, 23) +
		 * "\n___________________________"); println("00 und 13 (erwartet 2): "
		 * + ermittleFahrtkosten(0, 13) + "\n___________________________");
		 * println("13 und 00 (erwartet 2): " + ermittleFahrtkosten(13, 0) +
		 * "\n___________________________"); println("12 und 41 (erwartet 2): "
		 * + ermittleFahrtkosten(12, 41) + "\n___________________________");
		 * println("42 und 53 (erwartet 2): " + ermittleFahrtkosten(42, 53) +
		 * "\n___________________________"); println("53 und 00 (erwartet 2): "
		 * + ermittleFahrtkosten(53, 00) + "\n___________________________");
		 * println("11 und 41 (erwartet 2): " + ermittleFahrtkosten(11, 41) +
		 * "\n___________________________");
		 * 
		 * //Teste schonDa println("00 und 00 (erwartet 0): " +
		 * ermittleFahrtkosten(0, 0) + "\n___________________________");
		 * println("11 und 11 (erwartet 0): " + ermittleFahrtkosten(11, 11) +
		 * "\n___________________________"); println("55 und 55 (erwartet 0): "
		 * + ermittleFahrtkosten(55, 55) + "\n___________________________");
		 * println("34 und 34 (erwartet 0): " + ermittleFahrtkosten(34, 34) +
		 * "\n___________________________"); println("35 und 35 (erwartet 0): "
		 * + ermittleFahrtkosten(35, 35) + "\n___________________________");
		 * println("33 und 33 (erwartet 0): " + ermittleFahrtkosten(33, 33) +
		 * "\n___________________________"); println("31 und 31 (erwartet 0): "
		 * + ermittleFahrtkosten(31, 31) + "\n___________________________");
		 * println("44 und 44 (erwartet 0): " + ermittleFahrtkosten(44, 44) +
		 * "\n___________________________");
		 * 
		 * //Teste Zonenübergreifend println("00 und 24 (erwartet 3): " +
		 * ermittleFahrtkosten(0, 24) + "\n___________________________");
		 * println("24 und 00 (erwartet 3): " + ermittleFahrtkosten(24, 0) +
		 * "\n___________________________"); println("23 und 25 (erwartet 3): "
		 * + ermittleFahrtkosten(23, 25) + "\n___________________________");
		 * println("25 und 23 (erwartet 3): " + ermittleFahrtkosten(25, 23) +
		 * "\n___________________________"); println("11 und 35 (erwartet 3): "
		 * + ermittleFahrtkosten(11, 35) + "\n___________________________");
		 * println("35 und 11 (erwartet 3): " + ermittleFahrtkosten(35, 11) +
		 * "\n___________________________"); println("54 und 13 (erwartet 3): "
		 * + ermittleFahrtkosten(54, 13) + "\n___________________________");
		 * println("13 und 54 (erwartet 3): " + ermittleFahrtkosten(13, 54) +
		 * "\n___________________________");
		 * 
		 * //Teste Endstation println("55 und 56 (erwartet 1): " +
		 * ermittleFahrtkosten(55, 56) + "\n___________________________");
		 * println("56 und 55 (erwartet 1): " + ermittleFahrtkosten(56, 55) +
		 * "\n___________________________"); println(
		 * "54 und 56 (erwartet 2 + Hinweis): " + ermittleFahrtkosten(54, 56) +
		 * "\n___________________________"); println("56 und 54 (erwartet 2): "
		 * + ermittleFahrtkosten(56, 54) + "\n___________________________");
		 * println("00 und 16 (erwartet 4): " + ermittleFahrtkosten(0, 16) +
		 * "\n___________________________"); println("16 und 00 (erwartet 3): "
		 * + ermittleFahrtkosten(16, 0) + "\n___________________________");
		 * println("43 und 56 (erwartet 4): " + ermittleFahrtkosten(43, 56) +
		 * "\n___________________________"); println("13 und 54 (erwartet 3): "
		 * + ermittleFahrtkosten(13, 54) + "\n___________________________");
		 * println("55 und 46 (erwartet 5): " + ermittleFahrtkosten(55, 46) +
		 * "\n___________________________"); println("46 und 55 (erwartet 4): "
		 * + ermittleFahrtkosten(46, 55) + "\n___________________________");
		 */

	}
}
