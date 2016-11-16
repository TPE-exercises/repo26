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
		int numberOfSwaps = 0;
		int q = 1;
		
		for (int i = 1; i < numberSequence.length; i++) {
			int j = i;
			int m = numberSequence[i]; // Marker-Field
			
			// print protocol
			println("-----------------------------------");
			println("Durchlauf: " + q++);
			int d = 0;
			print(numberSequence[d]);
			for (d = 1; d < numberSequence.length; d++) {
				print(", " + numberSequence[d]);
			}
			println();
			// print protocol end
			
			while (j > 0 && numberSequence[j - 1] > m) {
				// swap greater elements
				numberSequence[j] = numberSequence[j - 1];
				j--;
				numberOfSwaps++;
			}
			// Set m to free field
			numberSequence[j] = m;
		}
		
		// print protocol
		println("-----------------------------------");
		println("Anzahlvertauschungen: " + numberOfSwaps);
		// print protocol end
		
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
		int bottom = 0;
		int top = numberSequence.length - 1;
		int numberOfSwaps = 0;
		int q = 1;

		while (top > bottom) {

			// print protocol
			println("-----------------------------------");
			println("Durchlauf: " + q++);
			int d = 0;
			print(numberSequence[d]);
			for (d = 1; d < numberSequence.length; d++) {
				print(", " + numberSequence[d]);
			}
			println();
			// print protocol end
			
			int min = numberSequence.length-1;
			for (int i = numberSequence.length-2; i >= bottom; i--)
				if (numberSequence[i] < numberSequence[min]){
					min = i;
				}
			//if(markerMin >= 0 && markerMin < numberSequence.length){
				swap(numberSequence, bottom, min);
				numberOfSwaps++;
				bottom++;
			//}
			//else 
			//	return numberSequence;

			
			int max = 0;
			for (int i = 1; i <= top; i++)
				if (numberSequence[i] > numberSequence[max])
					max = i;
			swap(numberSequence, top, max);
			numberOfSwaps++;
			top--;	
		}
		
		// print protocol
		println("-----------------------------------");
		println("Anzahlvertauschungen: " + numberOfSwaps);
		return numberSequence;
		// print protocol end
		
	}

	static void swap(int[] numberSequence, int idx1, int idx2) {
		int tmp = numberSequence[idx1];
		numberSequence[idx1] = numberSequence[idx2];
		numberSequence[idx2] = tmp;

	}

	static int[] ShakerSort(int[] numberSequence) {
		boolean swapped;
		int numberOfSwaps = 0;
		int q = 1;
		do {
			swapped = false;
			
			// print protocol
			println("-----------------------------------");
			println("Durchlauf: " + q++);
			int d = 0;
			print(numberSequence[d]);
			for (d = 1; d < numberSequence.length; d++) {
				print(", " + numberSequence[d]);
			}
			println();
			// print protocol end
			
			// swap left to right
			for (int i = 0; i < numberSequence.length - 1; i++) {
				if (numberSequence[i] > numberSequence [i+1]) {
					swap (numberSequence, i, i+1);
					numberOfSwaps++;
					swapped = true;
					
				}

			// print protocol		
			}
			d = 0;
			println("links nach rechts");
			print(numberSequence[d]);
			for (d = 1; d < numberSequence.length; d++) {
				print(", " + numberSequence[d]);
			}
			println();
			// print protocol end

			// swap right to left
			for (int i = numberSequence.length -1 ; i > 0; i--) {
				if (numberSequence[i] < numberSequence [i-1]) {
					swap (numberSequence, i, i-1);
					numberOfSwaps++;
					swapped = true;
				}
			}
			
			// print protocol
			d = 0;
			println("rechts nach links");
			print(numberSequence[d]);
			for (d = 1; d < numberSequence.length; d++) {
				print(", " + numberSequence[d]);
			}
			println();
			// print protocol end
			
		} while (swapped);
		
		// print protocol
		println("-----------------------------------");
		println("Anzahlvertauschungen: " + numberOfSwaps);	
		// print protocol end
		
		return numberSequence;
	}

}
