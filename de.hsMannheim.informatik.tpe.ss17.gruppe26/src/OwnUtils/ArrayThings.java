package OwnUtils;

public class ArrayThings {

	// public static void main(String[] args) {
	// Integer array[] = {new Integer(1),new Integer(2),new Integer(3)};
	// printOneDimensionalArray(array);
	// }

	/**
	 * @param Object[]
	 *            array
	 * @return an cloned array with doublesize
	 */
	public static Object[] doubleSizeArray(Object[] array) {
		Object[] doubleSizeArray = new Object[array.length * 2];

		for (int i = 0; i < array.length; i++) {
			doubleSizeArray[i] = array[i];
		}

		return doubleSizeArray;
	}

	/**
	 * prints an array, needs to be printale
	 * 
	 * @param array
	 */
	public static void printOneDimensionalArray(Object[] array) {
		if (array[0] != null) {
			System.out.print(array[0].toString());
		}else{
			System.out.print("_");
		}
		for (int i = 1; i < array.length; i++) {
			if(array[i]!=null)
			System.out.print(" | " + array[i].toString());
			else
				System.out.print(" | _");
		}
		System.out.println();
	}
	
	/**
	 * Index above array
	 * prints an array, needs to be printale
	 * @param array
	 */
	public static void printOneDimensionalArrayInclusiveIndex(Object[] array) {
		for(int i=0;i<array.length;i++){
			System.out.print(" | "+i);
		}
		System.out.println();
		printOneDimensionalArray(array);
	}
	
	/**
	 * Clone an Comparable array
	 * @param array
	 * @returns the clone
	 */
	public static Comparable[] cloneOneDimensionalArray(Comparable[] array) {
		Comparable[] newArray = new Comparable[array.length];
		for (int i = 0; i < array.length; i++) {
			newArray[i] = array[i];
		}
		return newArray;
	}
	
	/**
	 * compares two OneDimensionalArrays 
	 * @param array1
	 * @param array2
	 * @return <li>true if equals <li>false if not
	 */
	public static boolean isOneDimensionalArrayEquals(Comparable[] array1, Comparable[] array2) {
		if (array1.length != array2.length)
			return false;
		for (int i = 0; i < array1.length; i++) {
			if (array1[i] != array2[i]) {
				System.out.println("Fehler an Stelle: " + i);
				return false;
			}
		}
		return true;

	}
	
}
