package uebung04_aufgabe2;

public class Menue_uebung04_2 {
	
	protected static int cores=2;

	public static void main(String[] args) {
		Comparable[] array = random(500, 0, 100);
		// Comparable[] array = {new Integer(7),new Integer(6),new
		// Integer(4),new Integer(8),new Integer(9),new Integer(3),new
		// Integer(1),new Integer(2),new Integer(10),new Integer(12),new
		// Integer(5),new Integer(4)};
		Comparable[] array2 = OwnUtils.ArrayThings.cloneOneDimensionalArray(array);

		OwnUtils.ArrayThings.printOneDimensionalArray(array);
		QuickSort_Parallel parallel = new QuickSort_Parallel();
		QuickSort sort = new QuickSort();
		sort.sort(array2);
		sort.printStatus(array2);
		
		parallel.sort(array);
		parallel.printStatus(array);

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
