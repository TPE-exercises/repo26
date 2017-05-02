package uebung02_teil2_aufgabe2;

import static gdi.MakeItSimple.print;
import static gdi.MakeItSimple.println;

public class ShakerSort_ADS {
	static int numberOfComparesInShakerSort = 0;
	static int numberOfSwapsInShakerSort = 0;
	
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
	
	static void swap(int[] numberSequence, int idx1, int idx2) {
		int tmp = numberSequence[idx1];
		numberSequence[idx1] = numberSequence[idx2];
		numberSequence[idx2] = tmp;
	}
}
