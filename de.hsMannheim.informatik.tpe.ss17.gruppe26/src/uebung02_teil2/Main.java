package uebung02_teil2;

import static gdi.MakeItSimple.*;

public class Main {

	/**
	 * create a new line of underlines
	 */
	private static void printSeperatorLine() {
		System.out.println("___________________________________________________");
	}

	/**
	 * create a new line of dots
	 */
	private static void printSeperatorDots() {
		System.out.println("...................................................");
	}

	/**
	 * create a new line of bindings
	 */
	private static void printSeperatorShortLines() {
		System.out.println("---------------------------------------------------");
	}

	/**
	 * print failure, if the input was a wrong value
	 */
	private static void printDefault() {
		System.out.print("Fehlerhafte Eingabe!");
		System.out.print("Bitte geben Sie eine gültige Zahl für den jeweiligen Menüpunkt ein! ");
	}

	public static void main(String[] args) {
		boolean continueMenu = true;
		int numberOfRuns = 0;
		String letters = new String();

		System.out.println("Version 1.0 (01/05/2017)");
		System.out.println("Erstellt von: Schoenke und Lange");
		System.out.println("2. Programmieraufgabe Teil 2 aus TPE im SS17");
		printSeperatorLine();
		System.out.println();
		System.out.println("Bitte geben Sie einen Text oder Code ein,");
		System.out.println("den Sie ver- oder entschlüsseln möchten: ");
		letters = readLine();
		while (continueMenu) {
			printSeperatorShortLines();
			if (numberOfRuns == 0)
				System.out.println("Was möchten Sie tun?");
			else
				System.out.println("Was möchten Sie als nächstes tun?");
			numberOfRuns++;
			System.out.println();
			System.out.println("(1) Mit Caesar verschlüsseln");
			System.out.println("(2) Mit Caesar entschlüsseln");
			System.out.println("(3) Zeichenreihenfolge umkehren");
			System.out.println("(4) Botschaft aus aufgabe d) entschlüsseln");
			System.out.println("(9) Neue Zeichenfolge eingeben");
			System.out.println("(0) Programm beenden");
			switch (readInt()) {
			case (1): // caesar encrypting
				System.out.println("Alte Zeichenfolge: " + letters);
				System.out.println("Neue Zeichenfolge: " + null);
				break;
			case (2): // caesar decrypting
				System.out.println("Alte Zeichenfolge: " + letters);
				System.out.println("Neue Zeichenfolge: " + null);
				break;
			case (3): // reversing
				System.out.println("Alte Zeichenfolge: " + letters);
				System.out.println("Neue Zeichenfolge: " + null);
				break;
			case (4): // task d from lesson 2 part 2
				break;
			case (9): // create a new string of letters
				System.out.println("Bitte geben Sie eine neue Zeichenfolge ein: ");
				letters = readLine();
				break;
			case (0): // exit the program
				continueMenu = false;
				break;
			default:
				printDefault();
			}
		}
		System.out.println("Programm beendet.");
	}

}
