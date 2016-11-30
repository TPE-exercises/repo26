package freierTest;

import static gdi.MakeItSimple.*;

public class Mergesort {

	public static int[] eingabeArray = { 10, 5, 15, 3, 6, 9, 12, 16, };
	static final int length = 9; // 2, 4, 8, 16, 32, 64, 128, 256, 1024, 2048,
									// 4096
	static int tl = 1;// aktuelle Lauflänge | Blocklänge
	static int runGeneral = 2; // Für berechnung der Schleife notwendig ist den
								// "tl" eine runde vorraus
	static int lengthBand1; // Berechnugn der länge des Bandes in den einzelnen
							// durchgängen
	static int lengthBand2;// Berechnugn der länge des Bandes in den einzelnen
							// durchgängen
	static int positionAufBand1 = 0;
	static int positionAufBand2 = 0;
	static int runs = 1;
	static Object hauptband;// Dateivariable
	static Object band1;// Dateivariable
	static Object band2;// Dateivariable
	static int ddrun = 1; // Debug
	static int anzahlBlöcke = -1;// -1 == es gibt kein vorher

	/**
	 * 
	 */
	static void trenner() {
		print("----------------------");
		for (int i = 0; i < length; i++) {
			print("---");
			if (i % 2 == 0)
				print("-");
		}
		println();
	}

	/**
	 * Errechne die Länge der Bänder, benötigt bei zahlen die nicht in der 2er
	 * potenz sind
	 */
	static void calcBandLegth() {

		int i = 0;
		lengthBand1 = 0;
		lengthBand2 = 0;
		while (i < length) {

			for (int i1 = 1; i1 < runs + 1 && i < length; i1++) {
				lengthBand1++;
				i++;
			}

			for (int i2 = 1; i2 < runs + 1 && i < length; i2++) {
				lengthBand2++;
				i++;
			}

		}
		runs++;

	}

	/**
	 * @do Berechne Anzahl an Blöcken Pro durchgang
	 */
	static void calcTlCount() {
		int vorherAnzahlBlöcke = anzahlBlöcke;

		if (vorherAnzahlBlöcke == -1) {
			anzahlBlöcke = length;
		}
		else if (vorherAnzahlBlöcke % 2 == 0) {
			anzahlBlöcke = vorherAnzahlBlöcke / 2;
		} else {
			vorherAnzahlBlöcke++;
			anzahlBlöcke = vorherAnzahlBlöcke / 2;
		}
	}

	/**
	 * @param length
	 *            length of the array
	 * @param n
	 *            upper border of random number
	 * @return random array of int between 0 and n.
	 */
	static int[] createRandomNumberSequence(int length, int n) {
		int[] numberSequence = new int[length];

		for (int i = 0; i < length; i++) {
			int random = (int) Math.floor(Math.random() * n);
			numberSequence[i] = random;
		}
		return numberSequence;

	}

	/**
	 * print array to file
	 */
	public static void erstelleHauptband() {
		Object hauptband = openOutputFile("Hauptband.txt");
		for (int i = 0; i < eingabeArray.length; i++)
			print(hauptband, eingabeArray[i] + "\n");
		closeOutputFile(hauptband);

	}

	public static void split() {

		hauptband = openInputFile("Hauptband.txt");
		band1 = openOutputFile("Band1.txt");
		band2 = openOutputFile("Band2.txt");
		int blockPosition = 0;

		for (int j = 0; j < length; j++) {

			if (blockPosition < tl) {
				int hauptNumber = readInt(hauptband);
				print(band1, hauptNumber + "\n");
				blockPosition++;
			} else {
				int hauptNumber = readInt(hauptband);
				print(band2, hauptNumber + "\n");
				blockPosition++;
			}
			if (blockPosition >= tl * 2)
				blockPosition = 0;
		}

		closeInputFile(hauptband);
		closeOutputFile(band1);
		closeOutputFile(band2);

		printTape("band1.txt", lengthBand1);
		printTape("band2.txt", lengthBand2);
	}

	/**
	 * TODO Programm läuft nicht für längen außerhalb der 2er Potenz,
	 * printOperationen in extra methode, split in extra methode
	 * 
	 */
	public static void merge() {

		// läuft bis sortiert
		while (tl < length) {

			Mergesort.calcBandLegth();
			println("Länge Band1: " + lengthBand1 + " Länge Band2: " + lengthBand2);
			trenner();
			println("______________________Split Start______________________");
			split();
			println("______________________Split Ende______________________");

			band1 = openInputFile("band1.txt");
			band2 = openInputFile("band2.txt");
			hauptband = openOutputFile("hauptband.txt");

			// läuft bis zum ende der datei (alle blöcke)
			for (int i = 1; /* BlöckeCount<AnzahlBlöcke */; i++) {

				int indexBand1 = -1;
				int indexBand2 = -1;

				// läuft bis zum ende von tl
				while (indexBand1 < tl && indexBand2 < tl) {

					println("Start Durchgang: " + ddrun);
					print("Lese von Band1: ");
					int splitTo1 = readInt(band1);
					indexBand1++;
					positionAufBand1++;
					println("done!");
					print("Lese von Band2: ");
					int splitTo2 = readInt(band2);
					indexBand2++;
					positionAufBand2++;
					println("done!");

					while (indexBand1 < tl && indexBand2 < tl) {
						if (splitTo1 < splitTo2) {
							print(hauptband, splitTo1 + "\n");
							indexBand1++;
							if (indexBand1 < tl)
								splitTo1 = readInt(band1);
							positionAufBand1++;
						} else {
							print(hauptband, splitTo2 + "\n");
							indexBand2++;
							if (indexBand2 < tl)
								splitTo2 = readInt(band2);
							positionAufBand2++;
						}
					}

					if (indexBand1 >= tl) {
						while (indexBand2 < tl) {
							print(hauptband, splitTo2 + "\n");
							indexBand2++;
							if (indexBand2 < tl)
								splitTo2 = readInt(band2);
							positionAufBand2++;
						}
					} else if (indexBand2 >= tl) {
						while (indexBand1 < tl) {
							print(hauptband, splitTo1 + "\n");
							indexBand1++;
							if (indexBand1 < tl) {
								splitTo1 = readInt(band1);
								positionAufBand1++;
							}
						}
					}
					ddrun++;
				}

				// printTape("hauptband.txt", (runs*2)-2);
			}
			tl = tl * 2;
			runGeneral = runGeneral * 2;
			closeInputFile(band1);
			closeInputFile(band2);
			closeOutputFile(hauptband);

			printTape("hauptband.txt", length);
			trenner();
		}
	}

	/**
	 * 
	 * @param file
	 *            name of file to print
	 * @param dateiLänge
	 *            legth of printability
	 */
	private static void printTape(String file, int dateiLänge) {

		Object band = openInputFile(file);
		print(file + ": ");
		for (int i = 0; i < dateiLänge; i++) {
			print(readInt(band) + ", ");
		}
		closeInputFile(band);
		println();
	}

	/**
	 * 
	 */
	private static void printruns() {

	}

	/**
	 * 
	 * @param fileName
	 * @return boolean true = file is presend, false = file not found
	 */
	public static boolean isFilePresent(String fileName) {
		return false;

	}

	public static void main(String[] args) {
		eingabeArray = createRandomNumberSequence(length, 100);

		Mergesort.erstelleHauptband();
		println("Eingabe Zahlenfolge:");
		Mergesort.printTape("Hauptband.txt", length);
		trenner();
		Mergesort.merge();
	}
}