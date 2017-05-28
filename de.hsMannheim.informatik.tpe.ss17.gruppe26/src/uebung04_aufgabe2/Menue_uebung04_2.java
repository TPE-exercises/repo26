package uebung04_aufgabe2;

public class Menue_uebung04_2 {

	public static void main(String[] args) {
		Comparable[] array = OwnUtils.ArrayThings.random(500, 0, 100);
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

}
