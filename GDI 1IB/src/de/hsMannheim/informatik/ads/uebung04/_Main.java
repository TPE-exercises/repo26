package de.hsMannheim.informatik.ads.uebung04;

import static gdi.MakeItSimple.*;

import gdi.MakeItSimple.GDIException;

public class _Main {

	/*
	 * 
	 * 
	 * 
	 * 
	 * ACHTUNG !!! !!! !!! !!! !!! !!!
	 * 
	 * 
	 * Dateien für MergeSort wurden in ein Ordner verschoben: FilesForADSUebung04
	 * 
	 * 
	 * Quelltext muss dafür noch angepasst werden!
	 * 
	 * 
	 * 
	 */
	static int length;
	public static int[] inputArray;
	static int[] outputArray;
	static int ownArrayLength = 100;
	static int kindOfSort;
	static int whichNumbers;
	static int comparisons;
	static int swaps;
	static int recursions;
	static final int MERGE_SORT = 1;
	static final int QUICK_SORT = 2;
	static final int SHELL_SORT = 3;
	static final int FIELD = 1;
	static final int RANDOM_NUMBER_SEQUENCE = 2;
	static final int OWN_NUMBER_SEQUENCE = 3;

	public static void main(String[] args) {

		println("Mit welcher Methode soll sortiert werden?");
		println("[1] Merge Sort (direkt)");
		println("[2] Quicksort");
		println("[3] Shellsort");
		print("Ihre Eingabe: ");
		kindOfSort = readInt();
		if (kindOfSort < 1 || kindOfSort > 3)
			throw new GDIException("Bitte geben Sie eine [1], [2] oder [3] ein!");
		readLine();
		perfectSeperator();
		if (kindOfSort == QUICK_SORT || kindOfSort == SHELL_SORT) {
			println("Was soll sortiert werden?");
			println("[1] ein vorgegebenes Feld");
			println("[2] ein zufällige Zahlenfolge");
			println("[3] eine eigene Zahlenfolge");
			print("Ihre Eingabe: ");
			whichNumbers = readInt();
			if (whichNumbers < 1 || whichNumbers > 3)
				throw new GDIException("Falsche Eingabe. Sie müssen [1], [2] oder [3] eingeben!");
			readLine();
		}else
			whichNumbers = FIELD;
		if (whichNumbers == RANDOM_NUMBER_SEQUENCE || whichNumbers == OWN_NUMBER_SEQUENCE) {
			println("Wie lang soll die zu sortierende Zahlfolge sein?");
			print("Ihre Eingabe: ");
			length = readInt();
			if (length <= 0)
				throw new GDIException("Das Array muss länger als 0 sein!");
		}

		switch (whichNumbers) {
		case FIELD:
			switch (kindOfSort) {
			case MERGE_SORT:
				MergeSort.main(args);

				break;
			case QUICK_SORT:
				// Testfelder für Quickort
				perfectSeperator();
				println("Bitte wählen Sie eins der folgenden Felder aus:");
				println(" [1] {10, 4, 33, 44, 17, 20, 3, 2, 9, 82, 38, 67, 55, 11, 32, 23, 19, 7, 6, 14, 29}; (\"zufälliges\" Feld)");
				println(" [2] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};  (ist schon sortiert)");
				println(" [3] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};  (ist umgekehrt sortiert)");
				println(" [4] {10, 1, 9, 2, 8, 3, 7, 4, 6, 5};  (ist alternierend, umgekehrt sortiert)");
				println(" [5] {2, 3, 4, 5, 6, 7, 8, 9, 10, 1};  (ist fast sortiert - das kleinste Element steht ganz rechts)");
				println(" [6] {6, 7, 8, 9, 10, 1, 2, 3, 4, 5};  (besteht aus 2 sortierten Teilfolgen)");
				println(" [7] {10, 2, 3, 4, 5, 6, 7, 8, 9, 1};  (ist fast sortiert - nur min und max haben ihre Position vertauscht)");
				println(" [8] {1};");
				println(" [9] {10, 1, 2, 3, 4, 5, 6, 7, 8, 9};  (ist fast sortiert - das größte Element steht ganz links)");
				println("[10] {5, 5, 5, 5, 5, 5, 5, 5, 5, 5};  (ist sortiert - alle Elemente sind gleich)");
				print("Ihre Eingabe: ");
				int feldFürQuickSort = readInt();
				switch (feldFürQuickSort) {
				case 1:
					inputArray = new int[] { 10, 4, 33, 44, 17, 20, 3, 2, 9, 82, 38, 67, 55, 11, 32, 23, 19, 7, 6, 14,
							29 };
					recursions = 14;
					comparisons = 64;
					swaps = 31;
					break;
				case 2:
					inputArray = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
					recursions = 8;
					comparisons = 45;
					swaps = 0;
					break;
				case 3:
					inputArray = new int[] { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
					recursions = 8;
					comparisons = 45;
					swaps = 5;
					break;
				case 4:
					inputArray = new int[] { 10, 1, 9, 2, 8, 3, 7, 4, 6, 5 };
					recursions = 6;
					comparisons = 21;
					swaps = 9;
					break;
				case 5:
					inputArray = new int[] { 2, 3, 4, 5, 6, 7, 8, 9, 10, 1 };
					recursions = 8;
					comparisons = 45;
					swaps = 9;
					break;
				case 6:
					inputArray = new int[] { 6, 7, 8, 9, 10, 1, 2, 3, 4, 5 };
					recursions = 7;
					comparisons = 25;
					swaps = 5;
					break;
				case 7:
					inputArray = new int[] { 10, 2, 3, 4, 5, 6, 7, 8, 9, 1 };
					recursions = 8;
					comparisons = 45;
					swaps = 1;
					break;
				case 8:
					inputArray = new int[] { 1 };
					recursions = 0;
					comparisons = 0;
					swaps = 0;
					break;
				case 9:
					inputArray = new int[] { 10, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
					recursions = 7;
					comparisons = 37;
					swaps = 9;
					break;
				case 10:
					inputArray = new int[] { 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 };
					recursions = 8;
					comparisons = 45;
					swaps = 0;
					break;
				}
				break;
			case SHELL_SORT:
				// Testfelder fur Shell Sort
				perfectSeperator();
				println("Bitte wählen Sie eins der folgenden Felder aus:");
				println("values for h-sorting 9, 4, 3, 1");
				println(" [1] {10, 4, 33, 44, 17, 20, 3, 2, 9, 82, 38, 67, 55, 11, 32, 23, 19, 7, 6, 14, 29}; (\"zufälliges\" Feld)");
				println(" [2] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; (ist schon sortiert)");
				println(" [3] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1}; (ist umgekehrt sortiert)");
				println(" [4] {10, 1, 9, 2, 8, 3, 7, 4, 6, 5}; (ist alternierend, umgekehrt sortiert)");
				println(" [5] {2, 3, 4, 5, 6, 7, 8, 9, 10, 1}; (ist fast sortiert - das kleinste Element steht ganz rechts)");
				println(" [6] {6, 7, 8, 9, 10, 1, 2, 3, 4, 5}; (besteht aus 2 sortierten Teilfolgen)");
				println(" [7] {10, 2, 3, 4, 5, 6, 7, 8, 9, 1}; (ist fast sortiert - nur min und max haben ihre Position vertauscht)");
				println(" [8] {1};");
				println(" [9] {10, 1, 2, 3, 4, 5, 6, 7, 8, 9}; (ist fast sortiert - das größte Element steht ganz links)");
				println("[10] {5, 5, 5, 5, 5, 5, 5, 5, 5, 5};  (ist sortiert - alle Elemente sind gleich)");
				print("Ihre Eingabe: ");
				int feldFürShellSort = readInt();
				switch (feldFürShellSort) {
				case 1:
					inputArray = new int[] { 10, 4, 33, 44, 17, 20, 3, 2, 9, 82, 38, 67, 55, 11, 32, 23, 19, 7, 6, 14,
							29 };
					comparisons = 99;
					swaps = 39;
					break;
				case 2:
					inputArray = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
					comparisons = 23;
					swaps = 0;
					break;
				case 3:
					inputArray = new int[] { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
					comparisons = 27;
					swaps = 9;
					break;
				case 4:
					inputArray = new int[] { 10, 1, 9, 2, 8, 3, 7, 4, 6, 5 };
					comparisons = 29;
					swaps = 11;
					break;
				case 5:
					inputArray = new int[] { 2, 3, 4, 5, 6, 7, 8, 9, 10, 1 };
					comparisons = 29;
					swaps = 9;
					break;
				case 6:
					inputArray = new int[] { 6, 7, 8, 9, 10, 1, 2, 3, 4, 5 };
					comparisons = 29;
					swaps = 13;
					break;
				case 7:
					inputArray = new int[] { 10, 2, 3, 4, 5, 6, 7, 8, 9, 1 };
					comparisons = 23;
					swaps = 1;
					break;
				case 8:
					inputArray = new int[] { 1 };
					comparisons = 0;
					swaps = 0;
					break;
				case 9:
					inputArray = new int[] { 10, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
					comparisons = 28;
					swaps = 9;
					break;
				case 10:
					inputArray = new int[] { 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 };
					comparisons = 23;
					swaps = 0;
					break;
				}
				break;
			}
			break;
		case RANDOM_NUMBER_SEQUENCE:
			inputArray = createRandomNumberSequence();
			break;
		case OWN_NUMBER_SEQUENCE:
			inputArray = createOwnNumberSequence();
			break;
		}

		if (kindOfSort == QUICK_SORT || kindOfSort == SHELL_SORT) {
			perfectSeperator();
			println("Eingabearray: ");
			print(inputArray[0]);
			for (int d = 1; d < inputArray.length; d++) {
				print(", " + inputArray[d]);
			}
			println();
		}

		switch (kindOfSort) {
		case MERGE_SORT:
			Object file = openOutputFile("Hauptband.txt");
			for (int i = 0; i < length; i++) {
				println(file, inputArray[i]);
			}
			closeOutputFile(file);
			// ausgabeArray = MergeSort.direkterMergeSort(eingabeArray, length);
			// println("Anzahl der Schlüsselvergleiche: " +
			// numberOfComparesInInsertionSort1
			// + " Anzahl der Vertauschungen: " +
			// numberOfSwapsInInsertionSort1);
			break;
		case QUICK_SORT:
			outputArray = Quicksort.quicksort(inputArray, 0, inputArray.length - 1);
			printSortedArray();
			println("Durchgeführte Vergleiche: " + Quicksort.numberOfComparisons);
			println("Soll          Vergleiche: " + comparisons);
			println("               Differenz: " + (Quicksort.numberOfComparisons - comparisons));
			println("Durchgeführte Vertauschungen: " + Quicksort.numberOfSwaps);
			println("Soll          Vertauschungen: " + swaps);
			println("                   Differenz: " + (Quicksort.numberOfSwaps - swaps));
			println("Durchgeführte Rekursionen: " + Quicksort.numberOfRecursions);
			println("Soll          Rekursionen: " + recursions);
			println("                Differenz: " + (Quicksort.numberOfRecursions - recursions));
			break;
		case SHELL_SORT:
			outputArray = Shellsort.shellSort(inputArray);
			printSortedArray();
			println("Durchgeführte Vergleiche: " + Shellsort.numberOfComparisons);
			println("Soll          Vergleiche: " + comparisons);
			println("               Differenz: " + (Shellsort.numberOfComparisons - comparisons));
			println("Durchgeführte Vertauschungen: " + Shellsort.numberOfSwaps);
			println("Soll          Vertauschungen: " + swaps);
			println("                   Differenz: " + (Shellsort.numberOfSwaps - swaps));

			printSortedArray();
			// println("Anzahl der Schlüsselvergleiche: " +
			// numberOfComparesInSelectionSort
			// + " Anzahl der Vertauschungen: " + numberOfSwapsInSelectionSort);
			break;
		}
		perfectSeperator();
		println(">>> PROGRAMMENDE <<<");
	}

	/**
	 * Returns Array to Console int i = 0;
	 */
	static void printSortedArray() {
		perfectSeperator();
		println("Ausgabearray: ");
		print(outputArray[0]);
		for (int i = 1; i < outputArray.length; i++) {
			print(", " + outputArray[i]);
		}
		println();
		perfectSeperator();
	}

	/**
	 * Formatierungshilfe
	 */
	static void perfectSeperator() {
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
			int random = (int) Math.floor(Math.random() * ownArrayLength);
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
