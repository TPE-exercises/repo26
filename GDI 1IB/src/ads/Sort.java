package ads;

import static gdi.MakeItSimple.*;

public class Sort {

	// counter to log Compares and Swaps
	static int numberOfComparesInInsertionSort1 = 0;
	static int numberOfSwapsInInsertionSort1 = 0;

	static int numberOfComparesInInsertionSort2 = 0;
	static int numberOfSwapsInInsertionSort2 = 0;

	static int numberOfComparesInSelectionSort = 0;
	static int numberOfSwapsInSelectionSort = 0;

	static int numberOfComparesInShakerSort = 0;
	static int numberOfSwapsInShakerSort = 0;

	/*
	 * only for debugging
	 * 
	 * public static int protokollRun(int[] numberSequence, int numberOfRuns) {
	 * 
	 * println("-----------------------------------"); println("Durchlauf: " +
	 * numberOfRuns++); int d = 0; print(numberSequence[d]); for (d = 1; d <
	 * numberSequence.length; d++) { print(", " + numberSequence[d]); }
	 * println();
	 * 
	 * return numberOfRuns; }
	 * 
	 * public static int protokollSwap(int numberOfSwaps) {
	 * 
	 * println("-----------------------------------"); println(
	 * "Anzahlvertauschungen: " + numberOfSwaps);
	 * 
	 * return numberOfSwaps; }
	 * 
	 * public static int protokollCompare(int numberOfCompares) {
	 * 
	 * println("-----------------------------------"); println(
	 * "Anzahl vergleiche: " + numberOfCompares);
	 * 
	 * return numberOfCompares; }
	 */
	public static void insertionSortComparison(boolean debug) {

		int[] numberSequence1024 = Sort.createRandomNumberSequence(1024, 1000);
		int[] numberSequence2048 = Sort.createRandomNumberSequence(2048, 1000);
		int[] numberSequence4096 = Sort.createRandomNumberSequence(4096, 1000);

		int[] InsertionSort11024 = Sort.insertionSort1(numberSequence1024, debug);
		int[] InsertionSort21024 = Sort.insertionSort2(numberSequence1024, debug);
		if (InsertionSort11024 == InsertionSort21024) {
			println("Die 1024 sind gleich");
			println("-----------------------------------");
			println("Anzahl der Schlüsselvergleiche InsertionSort1: " + Sort.numberOfComparesInInsertionSort1);
			println("Anzahl der Schlüsselvergleiche InsertionSort2: " + Sort.numberOfComparesInInsertionSort2);
			println("-----------------------------------");
			println("Anzahl der Vertauschungen InsertionSort1: " + Sort.numberOfSwapsInInsertionSort1);
			println("Anzahl der Vertauschungen InsertionSort2: " + Sort.numberOfSwapsInInsertionSort2);
			println("___________________________________");
			numberOfComparesInInsertionSort1 = 0;
			numberOfSwapsInInsertionSort1 = 0;

			numberOfComparesInInsertionSort2 = 0;
			numberOfSwapsInInsertionSort2 = 0;
		} else
			println("Die 1024 sind nicht gleich");

		int[] InsertionSort12048 = Sort.insertionSort1(numberSequence2048, debug);
		int[] InsertionSort22048 = Sort.insertionSort2(numberSequence2048, debug);
		if (InsertionSort12048 == InsertionSort22048) {
			println("Die 2048 sind gleich");
			println("-----------------------------------");
			println("Anzahl der Schlüsselvergleiche InsertionSort1: " + Sort.numberOfComparesInInsertionSort1);
			println("Anzahl der Schlüsselvergleiche InsertionSort2: " + Sort.numberOfComparesInInsertionSort2);
			println("-----------------------------------");
			println("Anzahl der Vertauschungen InsertionSort1: " + Sort.numberOfSwapsInInsertionSort1);
			println("Anzahl der Vertauschungen InsertionSort2: " + Sort.numberOfSwapsInInsertionSort2);
			println("___________________________________");
			numberOfComparesInInsertionSort1 = 0;
			numberOfSwapsInInsertionSort1 = 0;

			numberOfComparesInInsertionSort2 = 0;
			numberOfSwapsInInsertionSort2 = 0;
		} else
			println("Die 2048 sind nicht gleich");

		int[] InsertionSort14096 = Sort.insertionSort1(numberSequence4096, debug);
		int[] InsertionSort24096 = Sort.insertionSort2(numberSequence4096, debug);
		if (InsertionSort14096 == InsertionSort24096) {
			println("Die 4096 sind gleich");
			println("-----------------------------------");
			println("Anzahl der Schlüsselvergleiche InsertionSort1: " + Sort.numberOfComparesInInsertionSort1);
			println("Anzahl der Schlüsselvergleiche InsertionSort2: " + Sort.numberOfComparesInInsertionSort2);
			println("-----------------------------------");
			println("Anzahl der Vertauschungen InsertionSort1: " + Sort.numberOfSwapsInInsertionSort1);
			println("Anzahl der Vertauschungen InsertionSort2: " + Sort.numberOfSwapsInInsertionSort2);
			println("___________________________________");
			numberOfComparesInInsertionSort1 = 0;
			numberOfSwapsInInsertionSort1 = 0;

			numberOfComparesInInsertionSort2 = 0;
			numberOfSwapsInInsertionSort2 = 0;
		} else
			println("Die 4096 sind nicht gleich");
		println("Unbekannter Fehler im Programm!!! Anzahl der Vertauschungen in InsertionSort2 ist in dieser Methode abhängig von \"N\" in createRandomNumberSequence.");
		println("Testet 1024, 2048 und 4096 über die Methode \"insertionSort2\" sind die Anzahlen der Vertauschungen annährend gleich.");
	}

	public static void main(String[] args) {

		boolean debug = false;

		println("Wie lang ist die zu sortierende Folge?");
		int length = readInt();
		if (length <= 0)
			throw new GDIException("Das Array muss länger als 0 sein.");
		int[] numberSequence = createRandomNumberSequence(length, 100);
		int[] newNumberSequence = new int[length];

		println("Mit welcher Methode soll sortiert werden?");
		println("1 für InsertionSort1");
		println("2 für InsertionSort2");
		println("3 für Vergleich von InsertionSort1 und InsertionSort2");
		println("4 für SelectionSort");
		println("5 für ShakerSort");
		int k = readInt();

		println("-----------------------------------");
		println("Eingabearray: ");
		int d = 0;
		print(numberSequence[d]);
		for (d = 1; d < numberSequence.length; d++) {
			print(", " + numberSequence[d]);
		}
		println();

		switch (k) {
		case 1:

			newNumberSequence = insertionSort1(numberSequence, debug);
			println("-----------------------------------");
			println("Anzahl der Schlüsselvergleiche: " + numberOfComparesInInsertionSort1
					+ "  Anzahl der Vertauschungen: " + numberOfSwapsInInsertionSort1);
			break;
		case 2:
			newNumberSequence = insertionSort2(numberSequence, debug);
			println("-----------------------------------");
			println("Anzahl der Schlüsselvergleiche: " + numberOfComparesInInsertionSort2
					+ "  Anzahl der Vertauschungen: " + numberOfSwapsInInsertionSort2);
			break;
		case 3:
			insertionSortComparison(debug);
			return;
		case 4:
			newNumberSequence = selectionSort(numberSequence, debug);
			println("-----------------------------------");
			println("Anzahl der Schlüsselvergleiche: " + numberOfComparesInSelectionSort
					+ "  Anzahl der Vertauschungen: " + numberOfSwapsInSelectionSort);
			break;
		case 5:
			newNumberSequence = shakerSort(numberSequence, debug);
			println("-----------------------------------");
			println("Anzahl der Schlüsselvergleiche: " + numberOfComparesInShakerSort + "  Anzahl der Vertauschungen: "
					+ numberOfSwapsInShakerSort);
			break;
		default:
			println("Falsche eingabe");
			return;
		}

		// Return Array to Console
		int i = 0;
		println("______________________________________");
		print(newNumberSequence[i]);
		for (i = 1; i < length; i++) {
			print(", " + newNumberSequence[i]);
		}
	}

	// Create own array
	static int[] createNumberSequence(int length) {
		int i = 0;
		int[] numberSequence = new int[length];
		println("Geben sie die Zahlenfolge ein.");
		while (i < length) {
			println("Gebe " + i + " Stelle ein");
			numberSequence[i] = readInt();
			i++;
		}
		return numberSequence;
	}

	// Create random array
	static int[] createRandomNumberSequence(int length, int n) {
		int[] numberSequence = new int[length];

		for (int i = 0; i < length; i++) {
			int random = (int) Math.floor(Math.random() * n);
			numberSequence[i] = random;
		}
		return numberSequence;

	}

	static int[] insertionSort1(int[] numberSequence, boolean debug) {

		for (int i = 1; i < numberSequence.length; i++) {
			int m = numberSequence[i]; // Marker-Field
			int j = i;

			if (!(j > 0 && numberSequence[j - 1] > m))
				numberOfComparesInInsertionSort1++;
			for (j = i; j > 0 && numberSequence[j - 1] > m; j--) {
				numberSequence[j] = numberSequence[j - 1];
				numberOfSwapsInInsertionSort1++;
				numberOfComparesInInsertionSort1++;
			}
			// Set m to free field
			if (numberSequence[j] != m) {
				numberSequence[j] = m;
				numberOfSwapsInInsertionSort1++;
			}
		}
		return numberSequence;
	}

	static int[] insertionSort2(int[] numberSequence, boolean debug) {

		for (int i = 1; i < numberSequence.length; i++) {

			int j = i;
			int marker = numberSequence[i]; // Marker-Field

			// Search correct position in array
			int positionInSortedArray = BinarySearchRecursive(numberSequence, marker, 0, j - 1);
			if (numberSequence[positionInSortedArray] < marker) {
				positionInSortedArray++;
			}

			for (j = i; j > 0 && positionInSortedArray < j; j--) {
				// move greater elements
				numberSequence[j] = numberSequence[j - 1];
				numberOfSwapsInInsertionSort2++;
			}

			// Set m to free field
			if (numberSequence[j] != marker) {
				numberSequence[j] = marker;
				numberOfSwapsInInsertionSort2++;
			}
		}
		return numberSequence;
	}

	// BinarySearch for insertionSort2
	static int BinarySearchRecursive(int[] numberSequence, int searchNumber, int u, int o) {

		int m = (u + o) / 2;

		numberOfComparesInInsertionSort2++;
		if (u >= o)
			return m;

		else if (searchNumber < numberSequence[m])
			return BinarySearchRecursive(numberSequence, searchNumber, u, m - 1);

		else // (searchNumber > numberSequence[m])
			return BinarySearchRecursive(numberSequence, searchNumber, m + 1, o);

	}

	static int[] selectionSort(int[] numberSequence, boolean debug) {

		int bottom = 0;
		int top = numberSequence.length - 1;

		while (top > bottom) {
			int min = numberSequence.length - 1;

			// runs from right to left and search min value
			for (int i = numberSequence.length - 2; i >= bottom; i--) {
				numberOfComparesInSelectionSort++;
				if (numberSequence[i] < numberSequence[min]) {
					min = i;
				}
			}
			if (bottom != min) {
				swap(numberSequence, bottom, min);
				numberOfSwapsInSelectionSort++;
			}

			bottom++;
			int max = 0;

			// runs from left to right and search max value
			for (int i = 1; i <= top; i++) {
				numberOfComparesInSelectionSort++;
				if (numberSequence[i] > numberSequence[max])
					max = i;
			}
			if (top != max) {
				swap(numberSequence, top, max);
				numberOfSwapsInSelectionSort++;
			}
			top--;
		}
		return numberSequence;
	}

	// swap for selectionSort
	static void swap(int[] numberSequence, int idx1, int idx2) {
		int tmp = numberSequence[idx1];
		numberSequence[idx1] = numberSequence[idx2];
		numberSequence[idx2] = tmp;
	}

	static int[] shakerSort(int[] numberSequence, boolean debug) {
		boolean swapped;
		boolean moved;

		do {
			swapped = false;
			moved = false;

			// swap left to right
			for (int i = 0; i < numberSequence.length - 1; i++) {
				numberOfComparesInShakerSort++;
				if (numberSequence[i] > numberSequence[i + 1]) {
					swap(numberSequence, i, i + 1);
					swapped = true;
					moved = true;
					numberOfSwapsInShakerSort++;
				}

				// print protocol
				println("-----------------------------------");
				println("links nach rechts");
				for (int d = 0; d < i + 1; d++) {
					print(numberSequence[d] + "  ");
				}
				if (moved)
					print("_" + numberSequence[i + 1] + "_  ");
				else
					print(numberSequence[i + 1] + "  ");
				for (int d = i + 2; d < numberSequence.length; d++) {
					print(numberSequence[d] + "  ");
				}
				println();
				moved = false;
				// print protocol end
			}

			// swap right to left
			for (int i = numberSequence.length - 1; i > 0; i--) {
				numberOfComparesInShakerSort++;
				if (numberSequence[i] < numberSequence[i - 1]) {
					swap(numberSequence, i, i - 1);
					swapped = true;
					moved = true;
					numberOfSwapsInShakerSort++;
				}

				// print protocol
				println("-----------------------------------");
				println("rechts nach links");
				for (int d = 0; d < i - 1; d++) {
					print(numberSequence[d] + "  ");
				}
				if (moved)
					print("_" + numberSequence[i - 1] + "_  ");
				else
					print(numberSequence[i - 1] + "  ");
				for (int d = i; d < numberSequence.length; d++) {
					print(numberSequence[d] + "  ");
				}
				println();
				moved = false;
				// print protocol end
			}

		} while (swapped);

		return numberSequence;
	}

}
