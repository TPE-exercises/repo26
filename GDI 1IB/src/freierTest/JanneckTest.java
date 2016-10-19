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
		

		println("Geben sie die Spieleranzahl ein.");
		int personenZahl = readInt();

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
			System.out.println("\n" + namePerson1 + " wettest auf: " + wettePerson1);
			System.out.println("***----------------------------------------------------------------------------***");
		}
		if (personenZahl >= 2) {
			System.out.println("\n" + "Geben Sie den Namen der nächsten Person ein.");
			name2 = new BufferedReader(new InputStreamReader(System.in));
			namePerson2 = name2.readLine();
			System.out.println("\n" + "Hallo " + namePerson2 + ", gib nun deine Wette ein.");
			wettePerson2 = readInt();
			System.out.println("\n" + "Du wettest auf: " + wettePerson2);
			System.out.println("***----------------------------------------------------------------------------***");
		}
		if (personenZahl >= 3) {
			System.out.println("\n" + "Geben Sie den Namen der nächsten Person ein.");
			name3 = new BufferedReader(new InputStreamReader(System.in));
			namePerson3 = name3.readLine();
			System.out.println("\n" + "Hallo " + namePerson3 + ", gib nun deine Wette ein.");
			wettePerson3 = readInt();
			System.out.println("\n" + "Du wettest auf: " + wettePerson3);
			System.out.println("***----------------------------------------------------------------------------***");
		}
		if (personenZahl >= 4) {
			System.out.println("\n" + "Geben Sie den Namen der nächsten Person ein.");
			name4 = new BufferedReader(new InputStreamReader(System.in));
			namePerson4 = name4.readLine();
			System.out.println("\n" + "Hallo " + namePerson4 + ", gib nun deine Wette ein.");
			wettePerson4 = readInt();
			System.out.println("\n" + "Du wettest auf: " + wettePerson4);
			System.out.println("***----------------------------------------------------------------------------***");
		}
		if (personenZahl >= 5) {
			System.out.println("\n" + "Geben Sie den Namen der nächsten Person ein.");
			name5 = new BufferedReader(new InputStreamReader(System.in));
			namePerson5 = name5.readLine();
			System.out.println("\n" + "Hallo " + namePerson5 + ", gib nun deine Wette ein.");
			wettePerson5 = readInt();
			System.out.println("\n" + "Du wettest auf: " + wettePerson5);
			System.out.println("***----------------------------------------------------------------------------***");
		}
		if (personenZahl >= 6) {
			System.out.println("\n" + "Geben Sie den Namen der nächsten Person ein.");
			name6 = new BufferedReader(new InputStreamReader(System.in));
			namePerson6 = name6.readLine();
			System.out.println("\n" + "Hallo " + namePerson6 + ", gib nun deine Wette ein.");
			wettePerson6 = readInt();
			System.out.println("\n" + "Du wettest auf: " + wettePerson6);
			System.out.println("***----------------------------------------------------------------------------***");
		}
		if (personenZahl >= 7) {
			System.out.println("\n" + "Geben Sie den Namen der nächsten Person ein.");
			name7 = new BufferedReader(new InputStreamReader(System.in));
			namePerson7 = name7.readLine();
			System.out.println("\n" + "Hallo " + namePerson7 + ", gib nun deine Wette ein.");
			wettePerson7 = readInt();
			System.out.println("\n" + "Du wettest auf: " + wettePerson7);
			System.out.println("***----------------------------------------------------------------------------***");
		}
		if (personenZahl >= 8) {
			System.out.println("\n" + "Geben Sie den Namen der nächsten Person ein.");
			name8 = new BufferedReader(new InputStreamReader(System.in));
			namePerson8 = name8.readLine();
			System.out.println("\n" + "Hallo " + namePerson8 + ", gib nun deine Wette ein.");
			wettePerson8 = readInt();
			System.out.println("\n" + "Du wettest auf: " + wettePerson8);
			System.out.println("***----------------------------------------------------------------------------***");
		}
		if (personenZahl >= 9) {
			System.out.println("\n" + "Geben Sie den Namen der nächsten Person ein.");
			name9 = new BufferedReader(new InputStreamReader(System.in));
			namePerson9 = name9.readLine();
			System.out.println("\n" + "Hallo " + namePerson9 + ", gib nun deine Wette ein.");
			wettePerson9 = readInt();
			System.out.println("\n" + "Du wettest auf: " + wettePerson9);
			System.out.println("***----------------------------------------------------------------------------***");
		}
		if (personenZahl >= 10) {
			System.out.println("\n" + "Geben Sie den Namen der nächsten Person ein.");
			name10 = new BufferedReader(new InputStreamReader(System.in));
			namePerson10 = name10.readLine();
			System.out.println("\n" + "Hallo " + namePerson10 + ", gib nun deine Wette ein.");
			wettePerson10 = readInt();
			System.out.println("\n" + "Du wettest auf: " + wettePerson10);
			System.out.println("***----------------------------------------------------------------------------***");
		}

		System.out.println("Die Wetten wurden abgeschlossn:");
		if (personenZahl >= 1)
			System.out.println(namePerson1 + ": " + wettePerson1);
		if (personenZahl >= 2)
			System.out.println(namePerson2 + ": " + wettePerson2);
		if (personenZahl >= 3)
			System.out.println(namePerson3 + ": " + wettePerson3);
		if (personenZahl >= 4)
			System.out.println(namePerson4 + ": " + wettePerson4);
		if (personenZahl >= 5)
			System.out.println(namePerson5 + ": " + wettePerson5);
		if (personenZahl >= 6)
			System.out.println(namePerson6 + ": " + wettePerson6);
		if (personenZahl >= 7)
			System.out.println(namePerson7 + ": " + wettePerson7);
		if (personenZahl >= 8)
			System.out.println(namePerson8 + ": " + wettePerson8);
		if (personenZahl >= 9)
			System.out.println(namePerson9 + ": " + wettePerson9);
		if (personenZahl >= 10)
			System.out.println(namePerson10 + ": " + wettePerson10);
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
			System.out.println("Somit geht der Pott die Bank.");
		}

	}

}
