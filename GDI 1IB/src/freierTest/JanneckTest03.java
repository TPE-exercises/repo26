package freierTest;

import static gdi.MakeItSimple.*;
import java.io.*;

public class JanneckTest03 {

	public static void main(String[] args) throws IOException {
		
		double pott = 0.0;
		
		// Abfrage der Personenanzahl und des Bankguthabens___________________________________________________
		
		System.out.print("Geben sie eine Spieleranzahl ein: ");
		int personenZahl = readInt();
		readLine();
		while(personenZahl <= 0){
			System.out.print("Ohne Spieler ist langeweilig, nochmal bitte: ");
			personenZahl = readInt();
			readLine();
		}
		System.out.print("\nGeben sie das Guthaben der Bank in Euro ein: ");
		pott = readInt();
		readLine();
		System.out.println("***----------------------------------------------------------------------------***");

		// __________________________________________________________________________________________________________________

		String[] namen = new String[personenZahl];
		int[] wetten = new int[personenZahl];
		double[] einsatz = new double[personenZahl];

		// Eingabe der Daten: Name, wette, Einsatz____________________________________________________________________________

		for (int i = 0; i <= (personenZahl - 1); i++) {
			System.out.println("\n" + "Geben Sie den Namen von Person " + (i + 1) + " ein.");
			String person1 = readLine();
			namen[i] = person1;

			System.out.println("\n" + namen[i] + " gib nun ein, wie viele Tafeln du vermutest.");
			int wette1 = readInt();
			readLine();
			wetten[i] = wette1;

			System.out.println("\n" + namen[i] + " wie viel Euro möchtest du auf " + wetten[i] + " Tafelseiten setzen?");			
			double einsatz1 = readInt();
			readLine();
			System.out.println("***----------------------------------------------------------------------------***");
			einsatz[i] = einsatz1;
			pott += einsatz1;
		}

		// Zusammenfassung_______________________________________________________________________________________

		for (int i = 0; i <= (personenZahl - 1); i++) {
			System.out.println(
					namen[i] + " wettet " + einsatz[i] + "€ darauf, das " + wetten[i] + " Tafeln verwendet werden.");
		}
		System.out.println("Der Pott beträgt: " + pott);
		System.out.println("***----------------------------------------------------------------------------***");

		// Errechnung der Siegeranzahl und des siegerPotts____________________________________________________________________

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
		// Errechnung der Gewinnes für Spieler und/oder Bank_________________________________________________________________________

		System.out.println("Es gibt " + siegerAnzahl + " Sieger!");

		boolean esGibtKeinenSieger = false;
		if (siegerAnzahl == 0) {
			esGibtKeinenSieger = true;
			siegerAnzahl++;
		}


		double preisDif = pott % siegerAnzahl;

		for (int i = 0; i <= (personenZahl - 1); i++) {
			if (wettErgebnis == wetten[i]) {
				System.out.println(namen[i] + " hat " + (einsatz[i] / siegerpott) * pott + "€ gewonnen!");
			}
		}

		if (esGibtKeinenSieger == true) {
			System.out.println("Somit geht der Pott von " + pott + "€ an die Bank.");
		} else
			System.out.println("Die Bank gewinnt " + preisDif + "€!");
	}

}
