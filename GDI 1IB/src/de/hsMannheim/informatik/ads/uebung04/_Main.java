package de.hsMannheim.informatik.ads.uebung04;

import static gdi.MakeItSimple.*;

public class _Main {

	static int length;
	public static int[] eingabeArray;
	static int[] ausgabeArray;
	static int eigeneArrayGröße = 100;

	public static void main(String[] args) {

		println("Möchten Sie ein automatisch generiertes Array nutzen oder möchten Sie selbst eins erstellen?");
		println("[1] für \"automatisches Array\"");
		println("[2] für \"eigenes Array\"");
		print("Ihre Eingabe: ");
		int welchesArray = readInt();
		if (!(welchesArray == 1) & !(welchesArray == 2))
			throw new GDIException("Falsche Eingabe. Sie müssen [1] oder [2] eingeben!");
		readLine();

		println("Wie lang soll die zu sortierende Folge sein?");
		print("Ihre Eingabe: ");
		length = readInt();
		if (length <= 0)
			throw new GDIException("Das Array muss länger als 0 sein!");

		switch (welchesArray) {
		case 1:
			eingabeArray = createRandomNumberSequence();
			break;
		case 2:
			eingabeArray = createOwnNumberSequence();
			break;
		default:
			throw new GDIException("Falsche Eingabe. Sie müssen [1] oder [2] eingeben!");
		}

		println("Mit welcher Methode soll sortiert werden?");
		println("[1] für Merge Sort");
		println("[2] für Quicksort");
		println("[3] für Shellsort");
		print("Ihre Eingabe: ");
		int welcheSortierung = readInt();
		if (welcheSortierung < 1 || welcheSortierung > 3)
			throw new GDIException("Bitte geben Sie [1], [2] oder [3] ein!");
		readLine();

		trenner();
		println("Eingabearray: ");
		print(eingabeArray[0]);
		for (int d = 1; d < eingabeArray.length; d++) {
			print(", " + eingabeArray[d]);
		}
		println();
		
		switch (welcheSortierung) {
		case 1:
			Object file = openOutputFile("Hauptband.txt");
			for (int i = 0; i < length; i++) {
				println(file, eingabeArray[i]);
			}
			closeOutputFile(file);
			ausgabeArray = MergeSort.direkterMergeSort(eingabeArray, length);
			// println("Anzahl der Schlüsselvergleiche: " +
			// numberOfComparesInInsertionSort1
			// + " Anzahl der Vertauschungen: " +
			// numberOfSwapsInInsertionSort1);
			break;
		case 2:
			ausgabeArray = Quicksort.quicksort(eingabeArray);
			// println("Anzahl der Schlüsselvergleiche: " +
			// numberOfComparesInInsertionSort2
			// + " Anzahl der Vertauschungen: " +
			// numberOfSwapsInInsertionSort2);
			break;
		case 3:
			ausgabeArray = Shellsort.shellsort(eingabeArray);
			// println("Anzahl der Schlüsselvergleiche: " +
			// numberOfComparesInSelectionSort
			// + " Anzahl der Vertauschungen: " + numberOfSwapsInSelectionSort);
			break;
		}

		// Return Array to Console int i = 0;
		trenner();
		println("Ausgabearray: ");
		print(ausgabeArray[0]);
		for (int i = 1; i < length; i++) {
			print(", " + ausgabeArray[i]);
		}

	}

	/**
	 * Formatierungshilfe
	 */
	static void trenner() {
		println("---------------------------------");
	}

	/**
	 * Create random array
	 * 
	 * @param length
	 * @param n
	 * @return
	 */
	static int[] createRandomNumberSequence() {
		int[] numberSequence = new int[length];

		for (int i = 0; i < length; i++) {
			int random = (int) Math.floor(Math.random() * eigeneArrayGröße);
			numberSequence[i] = random;
		}
		return numberSequence;
	}

	/**
	 * Create own array
	 * 
	 * @param length
	 * @return
	 */
	static int[] createOwnNumberSequence() {
		int[] numberSequence = new int[length];
		println("Geben Sie die Zahlenfolge ein.");
		for (int i = 0; i < length; i++) {
			if (i < 9) {
				print("0" + ++i + ". Stelle (Index 0" + --i + "): ");
				numberSequence[i] = readInt();
				readLine();
			} else if (i == 9) {
				print(++i + ". Stelle (Index 0" + --i + "): ");
				numberSequence[i] = readInt();
				readLine();
			} else {
				print(++i + ". Stelle (Index " + --i + "): ");
				numberSequence[i] = readInt();
				readLine();
			}
		}
		return numberSequence;
	}
}
