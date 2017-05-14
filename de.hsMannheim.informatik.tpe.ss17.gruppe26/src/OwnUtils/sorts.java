package OwnUtils;

public class sorts {

	public static void main(String[] args) {
		int[] array = { 4, 76, 24, 75, 1, 654, 4, 24, 7, 8, 75, 24, 35, 724, 15, 4 };
		array = quicksort(array);

		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

	public static int[] shellSort(int[] arrayToSort) {
		// Sort with this distance
		int[] gap = new int[] { 9, 7, 4, 1 };
		// the run-loop repeats the loop for every gap that is possible until
		// the array is sorted
		for (int run = 0; run < gap.length; run++) {

			// sorts the array in the shell for the current gap with a insertion
			// sort
			int index1 = 0;
			int index2 = index1 + gap[run];
			for (int end = 0 + gap[run]; end < arrayToSort.length; end++) {

				// if the index1 is bigger swap it with index2

				if (arrayToSort[index1] > arrayToSort[index2]) {

					int m = arrayToSort[index1];
					arrayToSort[index1] = arrayToSort[index2];
					arrayToSort[index2] = m;

					// checking if the swap currently done made a previous swap
					// incorrect
					// if thats true swap them and check again until the shell
					// is sorted correctly
					boolean smaleerSwaped = true;
					int afterSwapIndex1 = index1 - gap[run];
					int afterSwapIndex2 = index1;

					while (smaleerSwaped && afterSwapIndex1 >= 0) {

						// if the afterSwapIndex1 is bigger swap it with
						// afterSwapIndex2

						if (arrayToSort[afterSwapIndex1] > arrayToSort[afterSwapIndex2]) {

							m = arrayToSort[afterSwapIndex1];
							arrayToSort[afterSwapIndex1] = arrayToSort[afterSwapIndex2];
							arrayToSort[afterSwapIndex2] = m;

							afterSwapIndex1 -= gap[run];
							afterSwapIndex2 -= gap[run];
						} else { // !(arrayToSort[afterSwapIndex1] >
									// arrayToSort[afterSwapIndex2])
							smaleerSwaped = false;
						}
					}

					index1++;
					index2++;

				} else {// !(arrayToSort[index1] > arrayToSort[index2])
					index1++;
					index2++;
				}
			}

		}
		return arrayToSort;
	}

	/**
	 * "main"-method to run the quicksort algorithm
	 * 
	 * @param numberSequence
	 *            is the array of the unsorted numbers
	 * @return the sorted numbers
	 */
	static int[] quicksort(int[] numberSequence) {
		return quicksort_rec(numberSequence, 0, numberSequence.length - 1);
	}

	/**
	 * 
	 * @param array
	 * @param bottom
	 * @param top
	 * @return
	 */
	static int[] quicksort_rec(int[] array, int bottom, int top) {

		if (top > bottom) {
			int index = zerlege(array, bottom, top);
			quicksort_rec(array, bottom, index - 1);
			quicksort_rec(array, index + 1, top);
		}
		return array;
	}

	/**
	 * dividing numberSequence
	 * 
	 * @param numberSequence
	 * @param bottom
	 *            of comparison
	 * @param top
	 *            of comparison
	 * @return
	 */
	static int zerlege(int[] numberSequence, int bottom, int top) {
		int[] array = numberSequence;
		int pivot = top;
		int index = bottom;

		for (int marker = bottom; marker <= top - 1; marker++) {

			if (array[marker] <= array[pivot]) {
				if (index != marker)
					swapTwoNumbers(array, index, marker);
				index = index + 1;
			}
		}
		swapTwoNumbers(array, index, pivot);
		return index;
	}

	/**
	 * method to swap numbers
	 * 
	 * @param numberSequence
	 *            array of numbers
	 * @param indexInt1
	 * @param indexInt2
	 */
	static void swapTwoNumbers(int[] numberSequence, int idx1, int idx2) {

		int tmp = numberSequence[idx1];
		numberSequence[idx1] = numberSequence[idx2];
		numberSequence[idx2] = tmp;
	}

}
