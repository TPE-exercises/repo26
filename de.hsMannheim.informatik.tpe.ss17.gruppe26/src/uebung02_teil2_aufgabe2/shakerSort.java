package uebung02_teil2_aufgabe2;

public class shakerSort implements Sort1 {

	/**
	 * nessasary for shakerSort
	 * @param numberSequence
	 * @param int idx1
	 * @param int idx2
	 */
	private static void swap(Comparable[] numberSequence, int idx1, int idx2) {
		Comparable tmp = numberSequence[idx1];
		numberSequence[idx1] = numberSequence[idx2];
		numberSequence[idx2] = tmp;
	}

	@Override
	public void sort(Comparable[] numberSequence) {
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
	}
	
	public static void sortiere(Sort1 s, Comparable[] array){
		s.sort(array);
	}
}
