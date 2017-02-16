package de.hsMannheim.informatik.gdi.uebung04;

import static gdi.MakeItSimple.*;

import freierTest.GUI_Biteburg;

public class ByteburgTarifRechner {
	
	public static int startStation = 0;
	public static int zielStation = 0 ;
	public static int fahrtKosten = 0;
	public static String info = null;

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
		info = "";
		fahrtKosten = 0;
		
		
		startStation = GUI_Biteburg.start;
//		while (!istStationInLinie(startStation, stationen)) {
//			print("Die von Ihnen eingegebene Startstation ist nicht verfügbar. Bitte geben Sie nun eine gültige ein: ");
//			startStation = readInt();
//		}
//
		zielStation = GUI_Biteburg.ziel;
//		while (!istStationInLinie(zielStation, stationen)) {
//			print("Die von Ihnen eingegebene Zielstation ist nicht verfügbar. Bitte geben Sie nun eine gültige ein: ");
//			zielStation = readInt();
//		}
		
		if(!istStationInLinie(startStation, stationen)||!istStationInLinie(zielStation, stationen)){
			info = "Start oder Ziel ist ungültig";
		}		
		
		println("Start: " + startStation);
		println("Ziel: " + zielStation);
		fahrtKosten = ermittleFahrtkosten(startStation, zielStation);
		
		if (fahrtKosten == 0) {
			info = "Sie sind bereits an ihrem Ziel!";
		}
		else if (fahrtKosten > 0)
			println("Sie müssen für diese Fahrt " + fahrtKosten + " Euro zahlen.");

		
		println(">>>Programmende<<<");

		// Wenn der Fahrplan um eine weitere Linie ausgebaut werden soll, muss
		// man folgendes machen:
		// 1. in der main-Methode: im array "stationen" muss das Kommentar angepasst werden
		// 2. in der ermittleFahrtkosten-Methode: im Array "ringLinie" muss das Kommentar angepasst werden

		

	}
}
