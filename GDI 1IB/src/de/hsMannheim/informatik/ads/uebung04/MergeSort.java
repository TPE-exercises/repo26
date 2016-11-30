package de.hsMannheim.informatik.ads.uebung04;

import static gdi.MakeItSimple.*;

public class MergeSort {

	//mergeSortFileToSort3.txt
	
	
	public static int[] eingabeArray = { 10, 5, 15, 3, 6, 9, 12, 16, };
	static int length; 						
	static int tl = 1;// aktuelle Lauflänge | Blocklänge
	static int runGeneral = 2; // Für berechnung der Schleife notwendig ist den
								// "tl" eine runde vorraus
	static int filelength = 0;
	static int runs = 1;
	static Object hauptband;// Dateivariable
	static Object band1;// Dateivariable
	static Object band2;// Dateivariable
	static int ddrun = 1; // Debug

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


	public static void erstelleHauptband(String filename) {
		Object hauptband = openOutputFile("Hauptband.txt");
		Object quellBand = openInputFile(filename);
		boolean endOfFile = false;
		int number;
		/*
		 * for (int i = 0; i < eingabeArray.length; i++) print(hauptband,
		 * eingabeArray[i] + "\n");
		 */

		while (!endOfFile) {
			number = readInt(quellBand);
			print(hauptband, number + " ");
			endOfFile = isEndOfInputFile(quellBand);
			filelength++;
			//println("An Stelle: " + filelength + ", schreibe: " + number);
		}

		int zweierPotenz = 1;
		int howMuchToFill = 0;

		while (zweierPotenz < filelength) {
			zweierPotenz = zweierPotenz * 2;
		}
		length = zweierPotenz;
		howMuchToFill = zweierPotenz - filelength;

		for (int i = 0; i < howMuchToFill; i++)
			print(hauptband, Integer.MAX_VALUE + " ");
		println(howMuchToFill);

		closeInputFile(quellBand);
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

		printTape("band1.txt", length / 2);
		printTape("band2.txt", length / 2);
	}

	/**
	 * TODO Programm läuft nicht für längen außerhalb der 2er Potenz,
	 * printOperationen in extra methode, split in extra methode
	 * 
	 */
	public static void merge() {

		// läuft bis sortiert
		while (tl < length) {

			println("______________________Split Start______________________");
			split();
			println("______________________Split Ende______________________");

			band1 = openInputFile("band1.txt");
			band2 = openInputFile("band2.txt");
			hauptband = openOutputFile("hauptband.txt");

			// läuft bis zum ende der datei (alle blöcke)
			for (int i = 1; i <= (length / runGeneral); i++) {

				int indexBand1 = -1;
				int indexBand2 = -1;

				// läuft bis zum ende von tl
				while (indexBand1 < tl && indexBand2 < tl) {

					//println("Start Durchgang: " + ddrun);
					//print("Lese von Band1: ");
					int splitTo1 = readInt(band1);
					indexBand1++;

					//println("done!");
					//print("Lese von Band2: ");
					int splitTo2 = readInt(band2);
					indexBand2++;

					//println("done!");

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
							if (indexBand1 < tl) {
								splitTo1 = readInt(band1);

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

			// printTape("hauptband.txt", filelength);
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

	public static void main(String[] args) {
		// eingabeArray = createRandomNumberSequence(length, 100);

		print("Geben Sie den Dateinamen ein: ");
		String filename = readLine();
		if (!isFilePresent(filename))
			throw new GDIException("Datei \"" + filename + "\" konnte nicht gefunden werden.");

		MergeSort.erstelleHauptband(filename);

		println("Eingabe Zahlenfolge:");
		MergeSort.printTape("Hauptband.txt", filelength);
		trenner();
		MergeSort.merge();
		cutFill();
	}

/**
 * Programm Liest angegebene Datei
 * Benutzt Hauptband/Band1/Band2
 * Gibt in finalFile aus
 */
	private static void cutFill() {
		
		hauptband = openInputFile("Hauptband.txt");
		Object finalFile = openOutputFile("finalFile.txt");
		
		for (int i = 0; i < filelength;i++){
			int number = readInt(hauptband);
			print(finalFile, number + " ");
		}
		
		
		closeOutputFile(finalFile);
		closeInputFile(hauptband);
	}

}