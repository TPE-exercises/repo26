package uebung02_teil2_aufgabe2;

public class insertionSort implements Sort1 {


	@Override
	public void sort(Comparable[] numberSequence) {
		for (int i = 1; i < numberSequence.length; i++) {
			Comparable m = numberSequence[i]; // Marker-Field

			int j;
			for (j = i; j > 0 && numberSequence[j - 1].compareTo(m) > 0; j--)
				// for (j =i; j > 0 && numberSequence[j - 1] > m; j--)
				numberSequence[j] = numberSequence[j - 1];

			// Set m to free field
			if (numberSequence[j] != m) {
				numberSequence[j] = m;
			}
		}		
	}
	
	

}
