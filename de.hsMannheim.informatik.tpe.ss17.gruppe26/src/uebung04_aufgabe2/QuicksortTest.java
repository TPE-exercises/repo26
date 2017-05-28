package uebung04_aufgabe2;

import static org.junit.Assert.*;
import org.junit.Test;

public class QuicksortTest {

	@Test
	public void randomArrayTest() {
		Comparable[] array1 = OwnUtils.ArrayThings.random(100, 0, 100);
		Comparable[] array2 = OwnUtils.ArrayThings.cloneOneDimensionalArray(array1);

		QuickSort sequenziell = new QuickSort();
		sequenziell.sort(array2);

		QuickSort_Parallel parallel = new QuickSort_Parallel();
		parallel.sort(array1);

		assertTrue(OwnUtils.ArrayThings.isOneDimensionalArrayEquals(array1, array2));
	}

	@Test
	public void presortedArrayTest() {
		Comparable[] array1 = presorted(100);
		Comparable[] array2 = OwnUtils.ArrayThings.cloneOneDimensionalArray(array1);

		QuickSort sequenziell = new QuickSort();
		sequenziell.sort(array2);

		QuickSort_Parallel parallel = new QuickSort_Parallel();
		parallel.sort(array1);

		assertTrue(OwnUtils.ArrayThings.isOneDimensionalArrayEquals(array1, array2));
	}

	@Test
	public void inversedPresortedArrayTest() {
		Comparable[] array1 = inversedPresorted(100);
		Comparable[] array2 = OwnUtils.ArrayThings.cloneOneDimensionalArray(array1);

		QuickSort sequenziell = new QuickSort();
		sequenziell.sort(array2);

		QuickSort_Parallel parallel = new QuickSort_Parallel();
		parallel.sort(array1);

		assertTrue(OwnUtils.ArrayThings.isOneDimensionalArrayEquals(array1, array2));
	}

	private static Comparable[] presorted(int length) {
		Comparable[] array = new Comparable[length];

		for (int i = 0; i < length; i++) {
			array[i] = i;
		}
		return array;
	}

	private static Comparable[] inversedPresorted(int length) {
		Comparable[] array = new Comparable[length];

		for (int i = length-1; i >= 0; i--) {
			array[i] = i;
		}
		return array;
	}

}
