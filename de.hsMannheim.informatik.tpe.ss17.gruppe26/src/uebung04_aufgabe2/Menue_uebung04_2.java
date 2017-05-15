package uebung04_aufgabe2;

public class Menue_uebung04_2 {

	public static void main(String[] args) {
		 Comparable[] array = random(100,0,1000);
//		 Comparable[] array = {new Integer(7),new Integer(6),new Integer(4),new Integer(8),new Integer(9),new Integer(3),new Integer(1),new Integer(2),new Integer(10),new Integer(12),new Integer(5),new Integer(4)};
		 
		 OwnUtils.ArrayThings.printOneDimensionalArray(array);
		 
		 
		 QuickSort_Parallel sort = new QuickSort_Parallel();
		 sort.sort(array);
		 
		 
		
		 sort.printStatus( array);
	}

	private static Comparable[] random(int length, int minimum, int maximum) {
		Comparable[] array = new Comparable[length];

		for (int i = 0; i < array.length; i++) {
			int randomNum = minimum + (int) (Math.random() * maximum);
			array[i] = new Integer(randomNum);
		}

		return array;
	}

}
