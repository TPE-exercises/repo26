package freierTest;

import static gdi.MakeItSimple.*;

public class Mergesort {

	public static int[] eingabeArray = { 10, 5, 15, 3, 6, 9, 12, 16, };
	static final int length = 8;
	static int tl = 1;// aktuelle Lauflänge | Blocklänge
	static int runs = 1;
	static int runGeneral = 2;

	static void trenner() {
		print("-------------");
	}
	static int[] createRandomNumberSequence(int length, int n) {
		int[] numberSequence = new int[length];

		for (int i = 0; i < length; i++) {
			int random = (int) Math.floor(Math.random() * n);
			numberSequence[i] = random;
		}
		return numberSequence;

	}

	public static void erstelleHauptband() {
		Object hauptband = openOutputFile("Hauptband.txt");
		for (int i = 0; i < eingabeArray.length; i++)
			print(hauptband, eingabeArray[i] + "\n");
		closeOutputFile(hauptband);

	}

	public static void merge() {

		int blockPosition = 0;

		// läuft bis sortiert
		while (tl <= length) {
			/**
			 * Split Start
			 */
			trenner();
			print("Split Start");
			trenner();
			println();
			Object hauptband = openInputFile("Hauptband.txt");
			Object band1 = openOutputFile("Band1.txt");
			Object band2 = openOutputFile("Band2.txt");

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

			printBand("band1.txt", 4);
			printBand("band2.txt", 4);

			trenner();
			print("Split Ende");
			trenner();
			println();
			/**
			 * Split Ende
			 * 
			 * Merge Start
			 */

			band1 = openInputFile("band1.txt");
			band2 = openInputFile("band2.txt");
			hauptband = openOutputFile("hauptband.txt");
			runs = 1;
			// läuft bis zum ende der datei (alle blöcke)
			for (int i = 1; i <= (length / runGeneral); i++) {

				int indexBand1 = -1;
				int indexBand2 = -1;

				// läuft bis zum ende von tl
				while (indexBand1 < tl && indexBand2 < tl) {
					trenner();
					print("Merge Runde " + runs++ + " Start");
					trenner();
					println();

					int splitTo1 = readInt(band1);
					indexBand1++;
					int splitTo2 = readInt(band2);
					indexBand2++;

					while (indexBand1 < tl && indexBand2 < tl) {
						if (splitTo1 < splitTo2) {
							print(hauptband, splitTo1 + "\n");
							indexBand1++;
							if (indexBand1 < tl)
								splitTo1 = readInt(band1);
						} else {
							print(hauptband, splitTo2 + "\n");
							indexBand2++;
							if (indexBand2 < tl)
								splitTo2 = readInt(band2);
						}
					}

					if (indexBand1 >= tl) {
						while (indexBand2 < tl) {
							print(hauptband, splitTo2 + "\n");
							indexBand2++;
							if (indexBand2 < tl)
								splitTo2 = readInt(band2);
						}
					} else if (indexBand2 >= tl) {
						while (indexBand1 < tl) {
							print(hauptband, splitTo1 + "\n");
							indexBand1++;
							if (indexBand1 < tl)
								splitTo1 = readInt(band1);
						}
					}

				}
				// Füge den verbleibenden nichtleeren Rest des aktuellen Laufs
				// von F1 oder F2 an F an

				printBand("hauptband.txt", (runs * 2) - 2);
			}
			tl = tl * 2;
			runGeneral = runGeneral * 2;
			closeInputFile(band1);
			closeInputFile(band2);
			closeOutputFile(hauptband);

		}
	}

	private static void printBand(String file, int dateiLänge) {
		boolean endOfFile = false;

		Object band = openInputFile(file);
		print(file + ": ");
		for (int i = 0; i < dateiLänge; i++) {
			print(readInt(band) + ", ");
		}
		closeInputFile(band);
		println();
	}

	public static void main(String[] args) {
		eingabeArray = createRandomNumberSequence(8, 50); // 2, 4, 8, 16, 32, 64, 128
		erstelleHauptband();
		Mergesort.merge();
	}
}