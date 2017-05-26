package uebung04_aufgabe2;

public class Menue_uebung04_2 {
	
	protected static int cores=2;

	public static void main(String[] args) {
		Comparable[] array = random(500, 0, 100);
		Comparable[] array2 = OwnUtils.ArrayThings.cloneOneDimensionalArray(array);

		OwnUtils.ArrayThings.printOneDimensionalArray(array);
		
		//Quicksort sequenziell
		QuickSort sequenziell = new QuickSort();
		sequenziell.sort(array2);
		sequenziell.printStatus(array2);
		
		//Quicksort Parallel
		QuickSort_Parallel parallel = new QuickSort_Parallel();
		parallel.sort(array);
		parallel.printStatus(array);

		//check if arrays are equlas 
		System.out.println("Arrays gleich: " + OwnUtils.ArrayThings.isOneDimensionalArrayEquals(array, array2));
	}

	/**
	 * erstellt zufälliges array
	 * 
	 * @param length
	 * @param minimum
	 * @param maximum
	 * @return
	 */
	private static Comparable[] random(int length, int minimum, int maximum) {
		Comparable[] array = new Comparable[length];

		for (int i = 0; i < array.length; i++) {
			int randomNum = minimum + (int) (Math.random() * maximum);
			array[i] = new Integer(randomNum);
		}

		return array;
	}

}
