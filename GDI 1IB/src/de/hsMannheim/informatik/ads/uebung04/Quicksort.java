package de.hsMannheim.informatik.ads.uebung04;

import static gdi.MakeItSimple.*;

public class Quicksort {

	public static int anzahlSchlüsselvergleiche = 0;
	public static int anzahlVertauschungen = 0;
	public static int anzahlRekursionsschritte = -1;

	static int[] quicksort(int[] numberSequence, int unten, int oben) {
		anzahlRekursionsschritte++;
		int[] array = numberSequence;

		if (oben > unten) {
			int index = zerlege(array, unten, oben);
			quicksort(array, unten, index - 1);
			quicksort(array, index + 1, oben);
		}
		return array;
	}

	static int zerlege(int[] numberSequence, int unten, int oben) {
		int[] array = numberSequence;
		int pivot = oben;
		int index = unten;

		for (int zeiger = unten; zeiger <= oben - 1; zeiger++) {
			anzahlSchlüsselvergleiche++;
			if (array[zeiger] <= array[pivot]) {
				swap(array, index, zeiger);
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
		println("----------------");

		return index;
	}

	static void swap(int[] numberSequence, int idx1, int idx2) {
		anzahlVertauschungen++;
		int tmp = numberSequence[idx1];
		numberSequence[idx1] = numberSequence[idx2];
		numberSequence[idx2] = tmp;
	}
}