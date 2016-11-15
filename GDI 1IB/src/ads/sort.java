package ads;

import static gdi.MakeItSimple.*;

public class sort {

	public static void main(String[] args) {

		println("Wie lang ist die zu sortierende Folge?");
		int length = readInt();
		int[] numberSequence = createRandomNumberSequence(length);

		/*
		 * for (int i = 0; i < length; i++) { print(numberSequence[i] + " ");
		 * }println();
		 */

		int[] newNumberSequence = new int[length];

		println("Mit welcher Methode soll sortiert werden?");
		println("1 für InsertionSort1");
		println("2 für InsertionSort2");
		println("3 für SelectionSort");
		println("4 für ShakerSort");
		int k = readInt();
		switch (k) {
		case 1:
			newNumberSequence = InsertionSort1(numberSequence);
			break;
		case 2:
			newNumberSequence = InsertionSort2(numberSequence);
			break;
		case 3:
			newNumberSequence = SelectionSort(numberSequence);
			break;
		case 4:
			newNumberSequence = ShakerSort(numberSequence);
			break;
		default:
			println("Falsche eingabe");
		}

		int i = 0;
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
	static int[] createRandomNumberSequence(int length) {
		int[] numberSequence = new int[length];

		for (int i = 0; i < length; i++) {
			int random = (int) Math.floor(Math.random() * 99);
			numberSequence[i] = random;
		}
		return numberSequence;

	}

	static int[] InsertionSort1(int[] numberSequence) {

		// Kopie
		for (int i = 1; i < numberSequence.length; i++) {
			int j = i;
			int m = numberSequence[i]; // Marker-Feld

			while (j > 0 && numberSequence[j - 1] > m) {
				// Verschiebe alle größeren Elemente nach hinten
				numberSequence[j] = numberSequence[j - 1];
				j--;
			}
			// Setze m auf das freie Feld
			numberSequence[j] = m;
		}

		// Kopie Ende

		return numberSequence;
	}

	static int[] InsertionSort2(int[] numberSequence) {
		for (int i = 1; i < numberSequence.length; i++) {

			int m = numberSequence[i];
			int j = BinarySearchRecursive(numberSequence, m, 0, i - 1);

			for (int x = i; j != x; x--) {
				numberSequence[x] = numberSequence[x - 1];
			}
			numberSequence[i] = m;

		}
		return numberSequence;
	}

	// BinarySearch for InsertionSort2
	static int BinarySearchRecursive(int[] numberSequence, int searchNumber, int u, int o) {

		int m = (u + o) / 2;

		if (u == o)
			return m;

		else if (searchNumber < numberSequence[m])
			return BinarySearchRecursive(numberSequence, searchNumber, u, m - 1);

		else // (searchNumber > numberSequence[m])
			return BinarySearchRecursive(numberSequence, searchNumber, m + 1, o);

	}

	static int[] SelectionSort(int[] numberSequence) {
		int markerMin = 0;
		int markerMax = numberSequence.length - 1;

		/*
		int q = 0;
		print(numberSequence[q]);
		for (q = 1; q < numberSequence.length; q++) {
			print(", " + numberSequence[q]);
		}
		println();
		*/
		while (markerMax > numberSequence.length/2-1) {

			int min = numberSequence.length-1;
			for (int i = numberSequence.length-2; i >= markerMin; i--)
				if (numberSequence[i] < numberSequence[min]){
					min = i;
				}
			//if(markerMin >= 0 && markerMin < numberSequence.length){
				swap(numberSequence, markerMin, min);
				markerMin++;
			//}
			//else 
			//	return numberSequence;

			
			int max = 0;
			for (int i = 1; i <= markerMax; i++)
				if (numberSequence[i] > numberSequence[max])
					max = i;
			swap(numberSequence, markerMax, max);
			markerMax--;	
			
			println("Tausch nummer: " + markerMin);
			/*
			int i = 0;
			print(numberSequence[i]);
			for (i = 1; i < numberSequence.length; i++) {
				print(", " + numberSequence[i]);
			}
			println();
			*/
		}
		return numberSequence;
	}

	static void swap(int[] numberSequence, int idx1, int idx2) {
		int tmp = numberSequence[idx1];
		numberSequence[idx1] = numberSequence[idx2];
		numberSequence[idx2] = tmp;

	}

	static int[] ShakerSort(int[] numberSequence) {
		int[] newNumberSequence = new int[numberSequence.length];

		return newNumberSequence;
	}

}
