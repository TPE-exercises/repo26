package de.hsMannheim.informatik.ads.uebung04;

import static gdi.MakeItSimple.*;

public class Quicksort {

	/**
	 * declaration of global variables
	 */
	public static int numberOfComparisons = 0;
	public static int numberOfSwaps = 0;
	public static int numberOfRecursions = -1;

	/**
	 * "main"-method to run the quicksort algorithm
	 * @param numberSequence is the array of the unsorted numbers
	 * @param bottom of comparison
	 * @param top of comparison
	 * @return the sorted numbers
	 */
	static int[] quicksort(int[] numberSequence, int bottom, int top) {
		numberOfRecursions++;
		int[] array = numberSequence;

		if (top > bottom) {
			int index = zerlege(array, bottom, top);
			quicksort(array, bottom, index - 1);
			quicksort(array, index + 1, top);
		}
		return array;
	}

	/**
	 * dividing numberSequence
	 * @param numberSequence
	 * @param bottom of comparison
	 * @param top of comparison
	 * @return
	 */
	static int zerlege(int[] numberSequence, int bottom, int top) {
		int[] array = numberSequence;
		int pivot = top;
		int index = bottom;

		for (int marker = bottom; marker <= top - 1; marker++) {
			numberOfComparisons++;
			if (array[marker] <= array[pivot]) {
				if(index != marker)
				swap(array, index, marker);
				index = index + 1;
			}
		}

		swap(array, index, pivot);
		print("Zwischenergebnis: ");
		print(array[0]);
		for (int d = 1; d < array.length; d++) {
			print(", " + array[d]);
		}
		println();

		return index;
	}

	/**
	 * method to swap numbers
	 * @param numberSequence array of numbers
	 * @param idx1
	 * @param idx2
	 */
	static void swap(int[] numberSequence, int idx1, int idx2) {
		numberOfSwaps++;
		int tmp = numberSequence[idx1];
		numberSequence[idx1] = numberSequence[idx2];
		numberSequence[idx2] = tmp;
	}
}