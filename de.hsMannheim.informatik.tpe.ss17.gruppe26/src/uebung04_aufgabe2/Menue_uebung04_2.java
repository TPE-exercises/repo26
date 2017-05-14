package uebung04_aufgabe2;

public class Menue_uebung04_2 {

	public static void main(String[] args) {
		Comparable[] array = { new Integer(3), new Integer(6), new Integer(2), new Integer(1), new Integer(0) };

		QuickSort_Parallel sort = new QuickSort_Parallel();

		sort.sort(array);

		sort.printStatus( array);
	}



}
