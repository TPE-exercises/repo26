package freierTest;

import static gdi.MakeItSimple.*;
import java.io.*;
import java.lang.reflect.Array;

public class JanneckTest02 {

	public static void main(String[] args) throws IOException {

		// __________________________________________________________________________________________________________________

		int pott = 0;
		String[] namen = new String[19];
		int[] wetten = new int[19];
		int[] einsatz = new int[19];

		// __________________________________________________________________________________________________________________

		System.out.println("Geben sie eine Spieleranzahl zwischen 1 und 20 ein.");
		int personenZahl = readInt();
		System.out.println("Geben sie das Guthaben der Bank in Cent ein.");
		pott = readInt();

		// __________________________________________________________________________________________________________________

		if (personenZahl < 1) {
			System.out.println("Es muss mindestens eine Person mit spielen!");
			return;
		}
		if (personenZahl > 20) {
			System.out.println("Es Dürfen nicht mehr als 20 Spieler mit spielen!");
			return;
		}

		// __________________________________________________________________________________________________________________

		for (int i = 0; i <= (personenZahl - 1); i++) {
			System.out.println("\n" + "Geben Sie den Namen von Person " + (i + 1) + " ein.");
			BufferedReader name1 = new BufferedReader(new InputStreamReader(System.in));
			String person1 = name1.readLine();
			namen[i] = person1;

			System.out.println("\n" + namen[i] + " gib nun ein, wie viele Tafeln du vermutest.");
			int wette1 = readInt();
			wetten[i] = wette1;

			System.out.println("\n" + namen[i] + " wie viel möchtest du auf " + wetten[i] + " Tafelseiten setzen?");			
			int einsatz1 = readInt();
			System.out.println("***----------------------------------------------------------------------------***");
			einsatz[i] = einsatz1;
			pott += einsatz1;
		}

		// __________________________________________________________________________________________________________________

		for (int i = 0; i <= (personenZahl - 1); i++) {
			System.out.println(
					namen[i] + " wettet " + einsatz[i] + "cent darauf, das " + wetten[i] + " Tafeln verwendet werden.");
		}
		System.out.println("Der Pott beträgt: " + pott);
		System.out.println("***----------------------------------------------------------------------------***");

		// __________________________________________________________________________________________________________________

		System.out.println("Geben Sie nun das Wettergebnis ein.");
		int wettErgebnis = readInt();
		int siegerAnzahl = 0;
		double siegerpott = 0.0;

		for (int i = 0; i <= (personenZahl - 1); i++) {
			if (wettErgebnis == wetten[i]) {
				siegerAnzahl++;
				siegerpott += einsatz[i];
			}
		}
		// __________________________________________________________________________________________________________________

		System.out.println("Es gibt " + siegerAnzahl + " Sieger!");

		boolean esGibtKeinenSieger = false;
		if (siegerAnzahl == 0) {
			esGibtKeinenSieger = true;
			siegerAnzahl++;
		}


		int preisDif = pott % siegerAnzahl;

		for (int i = 0; i <= (personenZahl - 1); i++) {
			if (wettErgebnis == wetten[i]) {
				System.out.println(namen[i] + " hat " + (einsatz[i] / siegerpott) * pott + "cent gewonnen!");
			}
		}

		if (esGibtKeinenSieger == true) {
			System.out.println("Somit geht der Pott von " + pott + "cent an die Bank.");
		} else
			System.out.println("Die Bank gewinnt " + preisDif + " cent!");
	}

}
