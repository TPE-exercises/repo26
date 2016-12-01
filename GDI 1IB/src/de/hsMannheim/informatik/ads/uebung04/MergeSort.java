package de.hsMannheim.informatik.ads.uebung04;

import static gdi.MakeItSimple.*;

public class MergeSort {

	public static int[] inputArray;
	// current length of block
	static int tl = 1;
	// necessary for a loop in merge()
	static int tlForLoop = 2;
	// length for the merge | is next power of two
	static int length;
	static int filelength = 0;
	static int runs = 0;
	static Object mainTape;
	static Object tape1;
	static Object tape2;
	public static String filename;

	/**
	 * Optical separator
	 */
	static void separator() {
		print("----------------------");
		for (int i = 0; i < filelength; i++) {
			print("---");
			if (i % 2 == 0)
				print("-");
		}
		println();
	}

	/**
	 * @param filename
	 * @do numbersequens from file, and fills to the next power of two
	 */
	public static void createMainTape() {
		mainTape = openOutputFile("Hauptband.txt");
		Object sourceTape = openInputFile(filename);
		boolean endOfFile = false;
		int number;

		while (!endOfFile) {
			number = readInt(sourceTape);
			print(mainTape, number + " ");
			endOfFile = isEndOfInputFile(sourceTape);
			filelength++;
		}

		int powerOfTwo = 1;
		int howMuchToFill = 0;

		while (powerOfTwo < filelength) {
			powerOfTwo = powerOfTwo * 2;
		}
		length = powerOfTwo;
		howMuchToFill = powerOfTwo - filelength;

		for (int i = 0; i < howMuchToFill; i++)
			print(mainTape, Integer.MAX_VALUE + " ");

		closeInputFile(sourceTape);
		closeOutputFile(mainTape);

	}

	/**
	 * Splits the mainTape alternating on two other tapes
	 */
	public static void split() {

		mainTape = openInputFile("Hauptband.txt");
		tape1 = openOutputFile("Band1.txt");
		tape2 = openOutputFile("Band2.txt");
		int blockPosition = 0;

		for (int j = 0; j < length; j++) {

			if (blockPosition < tl) {
				int mainNumber = readInt(mainTape);
				print(tape1, mainNumber + "\n");
				blockPosition++;
			} else {
				int hauptNumber = readInt(mainTape);
				print(tape2, hauptNumber + "\n");
				blockPosition++;
			}
			if (blockPosition >= tl * 2)
				blockPosition = 0;
		}

		closeInputFile(mainTape);
		closeOutputFile(tape1);
		closeOutputFile(tape2);
	}

	/**
	 * Sort the number sequence using the direct mergeSort
	 * 
	 */
	public static void merge() {

		// Stop when whole number sequence is sorted
		while (tl < length) {
			runs++;
			split();

			tape1 = openInputFile("band1.txt");
			tape2 = openInputFile("band2.txt");
			mainTape = openOutputFile("hauptband.txt");

			// Stop when run is finished
			for (int i = 1; i <= (length / tlForLoop); i++) {

				int indexBand1 = -1;
				int indexBand2 = -1;

				// Stop when TL is finished
				while (indexBand1 < tl && indexBand2 < tl) {

					int splitTo1 = readInt(tape1);
					indexBand1++;

					int splitTo2 = readInt(tape2);
					indexBand2++;

					while (indexBand1 < tl && indexBand2 < tl) {
						if (splitTo1 < splitTo2) {
							print(mainTape, splitTo1 + "\n");
							indexBand1++;
							if (indexBand1 < tl)
								splitTo1 = readInt(tape1);

						} else {
							print(mainTape, splitTo2 + "\n");
							indexBand2++;
							if (indexBand2 < tl)
								splitTo2 = readInt(tape2);
						}
					}

					if (indexBand1 >= tl) {
						while (indexBand2 < tl) {
							print(mainTape, splitTo2 + "\n");
							indexBand2++;
							if (indexBand2 < tl)
								splitTo2 = readInt(tape2);
						}

					} else if (indexBand2 >= tl) {
						while (indexBand1 < tl) {
							print(mainTape, splitTo1 + "\n");
							indexBand1++;
							if (indexBand1 < tl) {
								splitTo1 = readInt(tape1);

							}
						}
					}
				}
			}
			tl = tl * 2;
			tlForLoop = tlForLoop * 2;
			closeInputFile(tape1);
			closeInputFile(tape2);
			closeOutputFile(mainTape);
			
			separator();
			printruns();
			printTape("Hauptband.txt", filelength);
		}
	}

	/**
	 * @param finalFile here could you change the outputfile
	 * @do cut the length of file to the inputFileLength
	 */
	private static void cutFill() {

		mainTape = openInputFile("Hauptband.txt");
		Object finalFile = openOutputFile("finalFile.txt");

		for (int i = 0; i < filelength-1; i++) {
			int number = readInt(mainTape);
			print(finalFile, number + " ");
		}
		int number = readInt(mainTape);
		print(finalFile, number);

		closeOutputFile(finalFile);
		closeInputFile(mainTape);
	}

	/**
	 * 
	 * @param file
	 *            name of file to print
	 * @param fileLength
	 *            legth of printability
	 */
	private static void printTape(String file, int fileLength) {

		Object band = openInputFile(file);
		
		print(file + ": ");
		for(int i = 0; i<fileLength;i++) {
			print(readInt(band) + " ");
		}
		closeInputFile(band);
		println();
	}

	/**
	 * 
	 */
	private static void printruns() {
		println("Durchgang Nummer: " + runs);
	}

	/**
	 * direct external mergeSort
	 * 
	 * @Step1 createMainTape based on userDefined number sequence
	 * @Step2 merge it
	 * @Step3 cut last numbers added in createMainTape
	 * @Step4 print sorted number sequence to "finalFile.txt"
	 * 
	 * @param args
	 */
	
	public static void main(String[] args) {

		print("Geben Sie den Dateinamen ein: ");
		filename = readLine();
		if (!isFilePresent(filename))
			throw new GDIException("Datei \"" + filename + "\" konnte nicht gefunden werden.");

		MergeSort.createMainTape();

		MergeSort.merge();
		MergeSort.cutFill();
		
		separator();
		printTape("finalFile.txt", filelength);
		separator();
		
		println("Sortierte Folge steht nun in \"finalFile.txt\"");
	}

}