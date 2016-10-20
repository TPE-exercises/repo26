package freierTest;

import java.io.*;
import static gdi.MakeItSimple.*;

public class JanneckTest {

	public static void main(String[] args) throws IOException {

		BufferedReader name1, name2, name3, name4, name5, name6, name7, name8, name9, name10;
		String namePerson1 = "", namePerson2 = "", namePerson3 = "", namePerson4 = "", namePerson5 = "",
				namePerson6 = "", namePerson7 = "", namePerson8 = "", namePerson9 = "", namePerson10 = "";
		int wettePerson1 = 0, wettePerson2 = 0, wettePerson3 = 0, wettePerson4 = 0, wettePerson5 = 0, wettePerson6 = 0,
				wettePerson7 = 0, wettePerson8 = 0, wettePerson9 = 0, wettePerson10 = 0;
		int einsatzPerson1 = 0, einsatzPerson2 = 0, einsatzPerson3 = 0, einsatzPerson4 = 0, einsatzPerson5 = 0,
				einsatzPerson6 = 0, einsatzPerson7 = 0, einsatzPerson8 = 0, einsatzPerson9 = 0, einsatzPerson10 = 0;
		int pott = 0;
		boolean esGibtKeinenSieger = false;

		
		System.out.println("Mögen die Wetten beginnen");
		System.out.println("***----------------------------------------------------------------------------***");
		System.out.println("Wie viele Quatratmeter Tafel benötigt Dr. Y. Totorov in diesem Block");
		System.out.println("Der Wetteinsatz liegt bei mindestens 20 Cent");
		System.out.println("Der Sieger bekommt den gesamten Pott. Gewinnt keiner geht das Geld in die Bank.");
		System.out.println("Gewinnen mehrere, wird der Pott zu gleichen Teilen aufgeteilt.");
		System.out.println("In der nächsten Wettrunde, wird der Pott um das Guthaben der Bank erweitert.");
		System.out.println("***----------------------------------------------------------------------------***");
		System.out.println("Geben sie die Spieleranzahl ein.");
		
		int personenZahl = readInt();
		System.out.println("Geben sie das Guthaben der Bank ein.");
		pott = readInt();

		if (personenZahl < 1) {
			System.out.println("Es muss mindestens eine Person mit spielen!");
			return;
		}

		System.out.println("***----------------------------------------------------------------------------***");

		if (personenZahl >= 1) {
			System.out.println("\n" + "Geben Sie den Namen der ersten Person ein.");
			name1 = new BufferedReader(new InputStreamReader(System.in));
			namePerson1 = name1.readLine();
			System.out.println("\n" + "Hallo " + namePerson1 + ", gib nun deine Wette ein.");
			wettePerson1 = readInt();
			System.out.println("\nGib nun bitte deinen Wetteinsatz in Cent ein.");
			einsatzPerson1 = readInt();
			pott += einsatzPerson1;
			System.out.println("\n" + namePerson1 + " wettet " + einsatzPerson1 + "cent auf " + wettePerson1 + ".");
			System.out.println("***----------------------------------------------------------------------------***");
		}
		if (personenZahl >= 2) {
			System.out.println("\n" + "Geben Sie den Namen der nächsten Person ein.");
			name2 = new BufferedReader(new InputStreamReader(System.in));
			namePerson2 = name2.readLine();
			System.out.println("\n" + "Hallo " + namePerson2 + ", gib nun deine Wette ein.");
			wettePerson2 = readInt();
			System.out.println("\nGib nun bitte deinen Wetteinsatz in Cent ein.");
			einsatzPerson2 = readInt();
			pott += einsatzPerson2;
			System.out.println("\n" + namePerson2 + " wettet " + einsatzPerson2 + "cent auf " + wettePerson2 + ".");
			System.out.println("***----------------------------------------------------------------------------***");
		}
		if (personenZahl >= 3) {
			System.out.println("\n" + "Geben Sie den Namen der nächsten Person ein.");
			name3 = new BufferedReader(new InputStreamReader(System.in));
			namePerson3 = name3.readLine();
			System.out.println("\n" + "Hallo " + namePerson3 + ", gib nun deine Wette ein.");
			wettePerson3 = readInt();
			System.out.println("\nGib nun bitte deinen Wetteinsatz in Cent ein.");
			einsatzPerson3 = readInt();
			pott += einsatzPerson3;
			System.out.println("\n" + namePerson3 + " wettet " + einsatzPerson3 + "cent auf " + wettePerson3 + ".");
			System.out.println("***----------------------------------------------------------------------------***");
		}
		if (personenZahl >= 4) {
			System.out.println("\n" + "Geben Sie den Namen der nächsten Person ein.");
			name4 = new BufferedReader(new InputStreamReader(System.in));
			namePerson4 = name4.readLine();
			System.out.println("\n" + "Hallo " + namePerson4 + ", gib nun deine Wette ein.");
			wettePerson4 = readInt();
			System.out.println("\nGib nun bitte deinen Wetteinsatz in Cent ein.");
			einsatzPerson4 = readInt();
			pott += einsatzPerson4;
			System.out.println("\n" + namePerson4 + " wettet " + einsatzPerson4 + "cent auf " + wettePerson4 + ".");
			System.out.println("***----------------------------------------------------------------------------***");
		}
		if (personenZahl >= 5) {
			System.out.println("\n" + "Geben Sie den Namen der nächsten Person ein.");
			name5 = new BufferedReader(new InputStreamReader(System.in));
			namePerson5 = name5.readLine();
			System.out.println("\n" + "Hallo " + namePerson5 + ", gib nun deine Wette ein.");
			wettePerson5 = readInt();
			System.out.println("\nGib nun bitte deinen Wetteinsatz in Cent ein.");
			einsatzPerson5 = readInt();
			pott += einsatzPerson5;
			System.out.println("\n" + namePerson5 + " wettet " + einsatzPerson5 + "cent auf " + wettePerson5 + ".");
			System.out.println("***----------------------------------------------------------------------------***");
		}
		if (personenZahl >= 6) {
			System.out.println("\n" + "Geben Sie den Namen der nächsten Person ein.");
			name6 = new BufferedReader(new InputStreamReader(System.in));
			namePerson6 = name6.readLine();
			System.out.println("\n" + "Hallo " + namePerson6 + ", gib nun deine Wette ein.");
			wettePerson6 = readInt();
			System.out.println("\nGib nun bitte deinen Wetteinsatz in Cent ein.");
			einsatzPerson6 = readInt();
			pott += einsatzPerson6;
			System.out.println("\n" + namePerson6 + " wettet " + einsatzPerson6 + "cent auf " + wettePerson6 + ".");
			System.out.println("***----------------------------------------------------------------------------***");
		}
		if (personenZahl >= 7) {
			System.out.println("\n" + "Geben Sie den Namen der nächsten Person ein.");
			name7 = new BufferedReader(new InputStreamReader(System.in));
			namePerson7 = name7.readLine();
			System.out.println("\n" + "Hallo " + namePerson7 + ", gib nun deine Wette ein.");
			wettePerson7 = readInt();
			System.out.println("\nGib nun bitte deinen Wetteinsatz in Cent ein.");
			einsatzPerson7 = readInt();
			pott += einsatzPerson7;
			System.out.println("\n" + namePerson7 + " wettet " + einsatzPerson7 + "cent auf " + wettePerson7 + ".");
			System.out.println("***----------------------------------------------------------------------------***");
		}
		if (personenZahl >= 8) {
			System.out.println("\n" + "Geben Sie den Namen der nächsten Person ein.");
			name8 = new BufferedReader(new InputStreamReader(System.in));
			namePerson8 = name8.readLine();
			System.out.println("\n" + "Hallo " + namePerson8 + ", gib nun deine Wette ein.");
			wettePerson8 = readInt();
			System.out.println("\nGib nun bitte deinen Wetteinsatz in Cent ein.");
			einsatzPerson8 = readInt();
			pott += einsatzPerson8;
			System.out.println("\n" + namePerson8 + " wettet " + einsatzPerson8 + "cent auf " + wettePerson8 + ".");
			System.out.println("***----------------------------------------------------------------------------***");
		}
		if (personenZahl >= 9) {
			System.out.println("\n" + "Geben Sie den Namen der nächsten Person ein.");
			name9 = new BufferedReader(new InputStreamReader(System.in));
			namePerson9 = name9.readLine();
			System.out.println("\n" + "Hallo " + namePerson9 + ", gib nun deine Wette ein.");
			wettePerson9 = readInt();
			System.out.println("\nGib nun bitte deinen Wetteinsatz in Cent ein.");
			einsatzPerson9 = readInt();
			pott += einsatzPerson9;
			System.out.println("\n" + namePerson9 + " wettet " + einsatzPerson9 + "cent auf " + wettePerson9 + ".");
			System.out.println("***----------------------------------------------------------------------------***");
		}
		if (personenZahl >= 10) {
			System.out.println("\n" + "Geben Sie den Namen der letzten Person ein.");
			name10 = new BufferedReader(new InputStreamReader(System.in));
			namePerson10 = name10.readLine();
			System.out.println("\n" + "Hallo " + namePerson10 + ", gib nun deine Wette ein.");
			wettePerson10 = readInt();
			System.out.println("\nGib nun bitte deinen Wetteinsatz in Cent ein.");
			einsatzPerson10 = readInt();
			pott += einsatzPerson10;
			System.out.println("\n" + namePerson10 + " wettet " + einsatzPerson10 + "cent auf " + wettePerson10 + ".");
			System.out.println("***----------------------------------------------------------------------------***");
		}
		if (personenZahl >= 11) {
			System.out.println("Tut mir leid, das Programm ist nur auf 10 Spieler ausgelegt."
					+ "Wende dich bitte den Autor, wenn du mehr Spieler spielen lassen willst.");
		}

		System.out.println("Die Wetten wurden abgeschlossn:");
		if (personenZahl >= 1)
			System.out.println(namePerson1 + "\t wettet " + einsatzPerson1 + "cent auf " + wettePerson1 + ".");
		if (personenZahl >= 2)
			System.out.println(namePerson2 + "\t wettet " + einsatzPerson2 + "cent auf " + wettePerson2 + ".");
		if (personenZahl >= 3)
			System.out.println(namePerson3 + "\t wettet " + einsatzPerson3 + "cent auf " + wettePerson3 + ".");
		if (personenZahl >= 4)
			System.out.println(namePerson4 + "\t wettet " + einsatzPerson4 + "cent auf " + wettePerson4 + ".");
		if (personenZahl >= 5)
			System.out.println(namePerson5 + "\t wettet " + einsatzPerson5 + "cent auf " + wettePerson5 + ".");
		if (personenZahl >= 6)
			System.out.println(namePerson6 + "\t wettet " + einsatzPerson6 + "cent auf " + wettePerson6 + ".");
		if (personenZahl >= 7)
			System.out.println(namePerson7 + "\t wettet " + einsatzPerson7 + "cent auf " + wettePerson7 + ".");
		if (personenZahl >= 8)
			System.out.println(namePerson8 + "\t wettet " + einsatzPerson8 + "cent auf " + wettePerson8 + ".");
		if (personenZahl >= 9)
			System.out.println(namePerson9 + "\t wettet " + einsatzPerson9 + "cent auf " + wettePerson9 + ".");
		if (personenZahl >= 10)
			System.out.println(namePerson10 + "\t wettet " + einsatzPerson10 + "cent auf " + wettePerson10 + ".");
		System.out.println("Der Pott liegt bei " + pott + " cent.");
		System.out.println("***----------------------------------------------------------------------------***");

		System.out.println("Geben Sie nun das Wettergebnis ein.");
		int wettergebnis = readInt();
		int siegerAnzahl = 0;

		if (wettergebnis == wettePerson1) {
			System.out.println(namePerson1 + " hat gewonnen!");
			siegerAnzahl++;
		}
		if (wettergebnis == wettePerson2) {
			System.out.println(namePerson2 + " hat gewonnen!");
			siegerAnzahl++;
		}
		if (wettergebnis == wettePerson3) {
			System.out.println(namePerson3 + " hat gewonnen!");
			siegerAnzahl++;
		}
		if (wettergebnis == wettePerson4) {
			System.out.println(namePerson4 + " hat gewonnen!");
			siegerAnzahl++;
		}
		if (wettergebnis == wettePerson5) {
			System.out.println(namePerson5 + " hat gewonnen!");
			siegerAnzahl++;
		}
		if (wettergebnis == wettePerson6) {
			System.out.println(namePerson6 + " hat gewonnen!");
			siegerAnzahl++;
		}
		if (wettergebnis == wettePerson7) {
			System.out.println(namePerson7 + " hat gewonnen!");
			siegerAnzahl++;
		}
		if (wettergebnis == wettePerson8) {
			System.out.println(namePerson8 + " hat gewonnen!");
			siegerAnzahl++;
		}
		if (wettergebnis == wettePerson9) {
			System.out.println(namePerson9 + " hat gewonnen!");
			siegerAnzahl++;
		}
		if (wettergebnis == wettePerson10) {
			System.out.println(namePerson10 + " hat gewonnen!");
			siegerAnzahl++;
		}
		System.out.println("Es gibt " + siegerAnzahl + " Gewinner!");
		
		if (siegerAnzahl == 0) {
			esGibtKeinenSieger = true;
			siegerAnzahl++;
		}
		
		int preis = pott / siegerAnzahl;
		int preisDif = pott % siegerAnzahl;
		
		
		if (preisDif != 0)
			System.out.println("Die Bank gewinnt: " + preisDif + " cent!");

		if (esGibtKeinenSieger == true) {
			System.out.println("Somit geht der Pott von " + pott + "cent an die Bank.");
		} else System.out.println("Der Preis beträgt: " + preis + " cent!");

	}

}
