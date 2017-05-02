package uebung02_teil2_aufgabe2;

//import static gdi.MakeItSimple.*;

public class Sort_ADS {

	protected static void sortArray(String sortierverfahren, Comparable[] array) {
		printArray(array);
		if (sortierverfahren.equals("insertionSort")) {
			array = insertionSort1(array);
		} else if (sortierverfahren.equals("shakerSort")) {
			array = shakerSort(array);
		}
		printArray(array);
	}

	private static void printArray(Comparable[] array) {

		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
			if (i != array.length)
				System.out.println(" | ");
		}

	}

	private static Comparable[] insertionSort1(Comparable[] numberSequence) {

		for (int i = 1; i < numberSequence.length; i++) {
			Comparable m = numberSequence[i]; // Marker-Field

			int j;
			for (j = i; j > 0 && numberSequence[j - 1].compareTo(m) == 1; j--)
				// for (j =i; j > 0 && numberSequence[j - 1] > m; j--)
				numberSequence[j] = numberSequence[j - 1];

			// Set m to free field
			if (numberSequence[j] != m) {
				numberSequence[j] = m;

			}
		}
		return numberSequence;
	}

	private static Comparable[] shakerSort(Comparable[] numberSequence) {
		boolean swapped;
		boolean moved;

		do {
			swapped = false;
			moved = false;

			// swap left to right
			for (int i = 0; i < numberSequence.length - 1; i++) {

				if (numberSequence[i].compareTo(numberSequence[i + 1]) > 0) {
					// if (numberSequence[i] > numberSequence[i + 1]) {
					swap(numberSequence, i, i + 1);
					swapped = true;
					moved = true;

				}

				// print protocol
				// println("-----------------------------------");
				// println("links nach rechts");
				// for (int d = 0; d < i + 1; d++) {
				// print(numberSequence[d] + " ");
				// }
				// if (moved)
				// print("_" + numberSequence[i + 1] + "_ ");
				// else
				// print(numberSequence[i + 1] + " ");
				// for (int d = i + 2; d < numberSequence.length; d++) {
				// print(numberSequence[d] + " ");
				// }
				// println();
				// moved = false;
				// print protocol end
			}

			// swap right to left
			for (int i = numberSequence.length - 1; i > 0; i--) {
				if (numberSequence[i].compareTo(numberSequence[i - 1]) < 0) {
					// if (numberSequence[i] < numberSequence[i - 1]) {
					swap(numberSequence, i, i - 1);
					swapped = true;
					moved = true;

				}

				// print protocol
				// println("-----------------------------------");
				// println("rechts nach links");
				// for (int d = 0; d < i - 1; d++) {
				// print(numberSequence[d] + " ");
				// }
				// if (moved)
				// print("_" + numberSequence[i - 1] + "_ ");
				// else
				// print(numberSequence[i - 1] + " ");
				// for (int d = i; d < numberSequence.length; d++) {
				// print(numberSequence[d] + " ");
				// }
				// println();
				// moved = false;
				// print protocol end
			}

		} while (swapped);

		return numberSequence;
	}

	private static void swap(Comparable[] numberSequence, int idx1, int idx2) {
		Comparable tmp = numberSequence[idx1];
		numberSequence[idx1] = numberSequence[idx2];
		numberSequence[idx2] = tmp;
	}
}
