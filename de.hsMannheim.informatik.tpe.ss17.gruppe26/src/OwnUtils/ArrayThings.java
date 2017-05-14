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
	public Object[] doubleSizeArray(Object[] array) {
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
		}
		for (int i = 1; i < array.length; i++) {
			System.out.print(" | " + array[i].toString());
		}
		System.out.println();
	}
	
}
