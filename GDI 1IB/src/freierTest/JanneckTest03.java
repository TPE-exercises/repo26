package freierTest;

import static gdi.MakeItSimple.*;

public class JanneckTest03 {
	static int length = 8;
	static int blocklänge = 1;
	static int[] array = new int[length];
	static int[] band1 = new int[length / 2];
	static int[] band2 = new int[length / 2];

	static void merge() {
		int i1 = 0;
		int i2 = 0;
		for (int i = 0; i < length / 2; i++) {

			if (band1[i1] < band2[i2]) {
				
				array[i] = band1[i1];
				i1++;

				for (i2 = i2; i2 < blocklänge; i2++) {
					i++;
					array[i] = band2[i2];
				}

			} else {
				array[i] = band2[i2];
				i2++;
				for (i1 = i1; i1 < blocklänge; i1++) {
					i++;
					array[i] = band1[i1];
				}
			}
		}

	}

	static void split() {
		int pos = 0;
		for (int i = 0; i < length / 2; i++) {
			band1[i] = array[pos];
			pos++;
			band2[i] = array[pos];
			pos++;
		}

	}

	public static void main(String[] args) {
		int length = 8;

		array = createRandomNumberSequence(length);
		printArray(array);

		split();

		print("Band1: ");
		printArray(band1);
		print("Band2: ");
		printArray(band2);

		merge();

		printArray(array);

	}

	private static void printArray(int[] arrayToPrint) {

		for (int i = 0; i < arrayToPrint.length; i++) {
			print(arrayToPrint[i] + " ");
		}
		println();

	}

	static int[] createRandomNumberSequence(int length) {
		int[] numberSequence = new int[length];

		for (int i = 0; i < length; i++) {
			int random = (int) Math.floor(Math.random() * 100);
			numberSequence[i] = random;
		}
		return numberSequence;
	}

}