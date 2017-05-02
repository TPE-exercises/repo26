package uebung02_teil2_aufgabe2;

public class Main {
private static final String sort1 = "insertionSort";
private static final String sort2 = "shakerSort";

	public static void main(String[] args) {

		Comparable[] arrayInt0 = {};
		Comparable[] arrayInt1 = {new MyInt(5),new MyInt(7),new MyInt(4),new MyInt(3),new MyInt(1),new MyInt(8)};
		Comparable[] arrayInt2 = {new MyInt(5),new MyInt(-5),new MyInt(5),new MyInt(0)};
	
		Sort_ADS.sortArray(sort1, arrayInt0);
		
		
	}

}
