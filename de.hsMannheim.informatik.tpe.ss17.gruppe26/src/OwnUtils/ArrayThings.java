package OwnUtils;

public class ArrayThings {
	/**
	 * @param Object[] array
	 * @return an cloned array with doublesize
	 */
	private Object[] doubleSizeArray(Object[] array) {
		Object[] doubleSizeArray = new Object[array.length * 2];

		for (int i = 0; i < array.length; i++) {
			doubleSizeArray[i] = array[i];
		}

		return doubleSizeArray;
	}
}
