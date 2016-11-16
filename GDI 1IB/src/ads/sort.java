package ads;

import static gdi.MakeItSimple.*;

public class sort {

	public static int protokollRun (int[] numberSequence, int numberOfRuns){
		// print protocol
		println("-----------------------------------");
		println("Durchlauf: " + numberOfRuns++);
		int d = 0;
		print(numberSequence[d]);
		for (d = 1; d < numberSequence.length; d++) {
			print(", " + numberSequence[d]);
		}
		println();
		// print protocol end
		
		return numberOfRuns;
	}
	public static int protokollSwap (int[] numberSequence, int numberOfSwaps){
		// print protocol
		numberOfSwaps++;
		println("-----------------------------------");
		println("Anzahlvertauschungen: " + numberOfSwaps);
		// print protocol end
		
		return numberOfSwaps;
	}
	
	public static void main(String[] args) {

		boolean debug = true;
		
		println("Wie lang ist die zu sortierende Folge?");
		int length = readInt();
		int[] numberSequence = createRandomNumberSequence(length);

		int[] newNumberSequence = new int[length];

		println("Mit welcher Methode soll sortiert werden?");
		println("1 für InsertionSort1");
		println("2 für InsertionSort2");
		println("3 für SelectionSort");
		println("4 für ShakerSort");
		int k = readInt();
		switch (k) {
		case 1:
			newNumberSequence = InsertionSort1(numberSequence, debug);
			break;
		case 2:
			newNumberSequence = InsertionSort2(numberSequence, debug);
			break;
		case 3:
			newNumberSequence = SelectionSort(numberSequence, debug);
			break;
		case 4:
			newNumberSequence = ShakerSort(numberSequence, debug);
			break;
		default:
			println("Falsche eingabe");
		}

		//Return Array to Console
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
	static int[] createRandomNumberSequence(int length) {
		int[] numberSequence = new int[length];

		for (int i = 0; i < length; i++) {
			int random = (int) Math.floor(Math.random() * 100);
			numberSequence[i] = random;
		}
		return numberSequence;

	}

	static int[] InsertionSort1(int[] numberSequence, boolean debug) {

		int numberOfRuns = 1;
		int numberOfSwap = 0;

		for (int i = 1; i < numberSequence.length; i++) {
			int j = i;
			int m = numberSequence[i]; // Marker-Field

			while (j > 0 && numberSequence[j - 1] > m) {
				numberSequence[j] = numberSequence[j - 1];
				j--;
				if(debug){
					numberOfSwap = protokollSwap(numberSequence, numberOfSwap);
				}
				if(debug){
					numberOfRuns = protokollRun(numberSequence, numberOfRuns);
				}
			}
			// Set m to free field
			numberSequence[j] = m;
		}

		return numberSequence;
	}

	static int[] InsertionSort2(int[] numberSequence, boolean debug) {

		int numberOfRuns = 1;
		int numberOfSwap = 0;
		
		for (int i = 1; i < numberSequence.length; i++) {
			
			int j = i;
			int m = numberSequence[i]; // Marker-Field
			
			int daMusstDuHin = BinarySearchRecursive(numberSequence, m, 0, j-1);	
			if(numberSequence[daMusstDuHin] < m){
				daMusstDuHin ++;
			}
			

			while (j > 0 && daMusstDuHin < j) {
				// swap greater elements
				numberSequence[j] = numberSequence[j - 1];
				j--;
				if(debug){
					numberOfSwap = protokollSwap(numberSequence, numberOfSwap);
				}
			}
			numberSequence[j] = m;
			if(debug){
				numberOfRuns = protokollRun(numberSequence, numberOfRuns);
			}
		}

		return numberSequence;
	}

	// BinarySearch for InsertionSort2
	static int BinarySearchRecursive(int[] numberSequence, int searchNumber, int u, int o) {

		int m = (u + o) / 2;

		if (u >= o)
			return m;

		else if (searchNumber < numberSequence[m])
			return BinarySearchRecursive(numberSequence, searchNumber, u, m - 1);

		else // (searchNumber > numberSequence[m])
			return BinarySearchRecursive(numberSequence, searchNumber, m + 1, o);

	}

	static int[] SelectionSort(int[] numberSequence, boolean debug) {
		int numberOfRuns = 1;
		int numberOfSwap = 0;
		
		int bottom = 0;
		int top = numberSequence.length - 1;

		while (top > bottom) {

			int min = numberSequence.length - 1;
			for (int i = numberSequence.length - 2; i >= bottom; i--){
				if (numberSequence[i] < numberSequence[min]) {
					min = i;		
				}
			}
			swap(numberSequence, bottom, min);
			bottom++;
			if(debug){
				numberOfSwap = protokollSwap(numberSequence, numberOfSwap);
			}


			int max = 0;
			for (int i = 1; i <= top; i++){
				if (numberSequence[i] > numberSequence[max])
					max = i;
			}
			swap(numberSequence, top, max);
			top--;
			if(debug){
				numberOfSwap = protokollSwap(numberSequence, numberOfSwap);
			}
			if(debug){
				numberOfRuns = protokollRun(numberSequence, numberOfRuns);
			}	
		}
		
		return numberSequence;
	}

	//swap for SelectionSort
	static void swap(int[] numberSequence, int idx1, int idx2) {
		int tmp = numberSequence[idx1];
		numberSequence[idx1] = numberSequence[idx2];
		numberSequence[idx2] = tmp;
	}

	static int[] ShakerSort(int[] numberSequence, boolean debug) {
		boolean swapped;
		int numberOfComparisons = 0;
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

			/**
			 * swap left to right
			 */
			for (int i = 0; i < numberSequence.length - 1; i++) {
				if (numberSequence[i] > numberSequence[i + 1]) {
					swap(numberSequence, i, i + 1);
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

			/**
			 * swap right to left
			 */
			for (int i = numberSequence.length - 1; i > 0; i--) {
				if (numberSequence[i] < numberSequence[i - 1]) {
					swap(numberSequence, i, i - 1);
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
