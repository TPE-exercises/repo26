package uebung02_teil2_aufgabe2;

import static gdi.MakeItSimple.print;
import static gdi.MakeItSimple.println;

public class Sort_ADS {

	public static void main(String[] args) {
		Comparable[] arrayInt = { new MyInt(5), new MyInt(7), new MyInt(4), new MyInt(3), new MyInt(1), new MyInt(8), };
		int[] array = { 5, 7, 4, 3, 1, 8 };

		arrayInt = shakerSort(arrayInt);
//		 arrayInt = insertionSort1(arrayInt);


		for (int i = 0; i < arrayInt.length; i++)
			System.out.print(arrayInt[i] + " | ");

	}

	protected static Comparable[] insertionSort1(Comparable[] numberSequence) {

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

	static Comparable[] shakerSort(Comparable[] numberSequence) {
		boolean swapped;
		boolean moved;

		do {
			swapped = false;
			moved = false;

			// swap left to right
			for (int i = 0; i < numberSequence.length - 1; i++) {

				if (numberSequence[i].compareTo(numberSequence[i + 1]) == 1) {
					// if (numberSequence[i] > numberSequence[i + 1]) {
					swap(numberSequence, i, i + 1);
					swapped = true;
					moved = true;

				}

//				// print protocol
//				println("-----------------------------------");
//				println("links nach rechts");
//				for (int d = 0; d < i + 1; d++) {
//					print(numberSequence[d] + "  ");
//				}
//				if (moved)
//					print("_" + numberSequence[i + 1] + "_  ");
//				else
//					print(numberSequence[i + 1] + "  ");
//				for (int d = i + 2; d < numberSequence.length; d++) {
//					print(numberSequence[d] + "  ");
//				}
//				println();
//				moved = false;
//				// print protocol end
			}

			// swap right to left
			for (int i = numberSequence.length - 1; i > 0; i--) {
				if (numberSequence[i].compareTo(numberSequence[i - 1]) == -1) {
					// if (numberSequence[i] < numberSequence[i - 1]) {
					swap(numberSequence, i, i - 1);
					swapped = true;
					moved = true;

				}

//				// print protocol
//				println("-----------------------------------");
//				println("rechts nach links");
//				for (int d = 0; d < i - 1; d++) {
//					print(numberSequence[d] + "  ");
//				}
//				if (moved)
//					print("_" + numberSequence[i - 1] + "_  ");
//				else
//					print(numberSequence[i - 1] + "  ");
//				for (int d = i; d < numberSequence.length; d++) {
//					print(numberSequence[d] + "  ");
//				}
//				println();
//				moved = false;
//				// print protocol end
			}

		} while (swapped);

		return numberSequence;
	}

	static void swap(Comparable[] numberSequence, int idx1, int idx2) {
		Comparable tmp = numberSequence[idx1];
		numberSequence[idx1] = numberSequence[idx2];
		numberSequence[idx2] = tmp;
	}
}
