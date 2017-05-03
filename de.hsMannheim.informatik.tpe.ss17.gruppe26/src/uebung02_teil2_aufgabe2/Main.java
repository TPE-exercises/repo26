package uebung02_teil2_aufgabe2;

public class Main {
	private static final Sort1 sort1 = new insertionSort();
	private static final Sort1 sort2 = new shakerSort();

	public static void main(String[] args) {
		
		/*
		 * Folie Abstrakte Klassen und Interfaces Seite 42
		 * Funktionszeiger
		 */

		Comparable[] arrayInt0 = {};
		Comparable[] arrayInt1 = { new MyInt(5), new MyInt(7), new MyInt(4), new MyInt(3), new MyInt(1), new MyInt(8) };
		Comparable[] arrayInt2 = { new MyInt(5), new MyInt(-5), new MyInt(5), new MyInt(0) };

		sortiere(sort1, arrayInt1);
		
		
//		printSeperator();
//		Sort1.sortArray(sort1, arrayInt1);
//		printSeperator();
//		Sort1.sortArray(sort1, arrayInt2);
//		printSeperator();
//		Sort1.sortArray(sort2, arrayInt0);
//		printSeperator();
//		Sort1.sortArray(sort2, arrayInt1);
//		printSeperator();
//		Sort1.sortArray(sort2, arrayInt2);
//		printSeperator();
//
		Comparable[] arrayStr0 = {};
		Comparable[] arrayStr1 = { new MyString("a"), new MyString("b"), new MyString("c"), new MyString("ad"),
				new MyString("ab"), new MyString("ac") };
		Comparable[] arrayStr2 = { new MyString("Elias"), new MyString("Leon"), new MyString("Jonas"),
				new MyString("Emma"), new MyString("Mia"), new MyString("Emilia") };
//
		sortiere(sort1, arrayStr1);
//		printSeperator();
//		Sort.sortArray(sort1, arrayStr1);
//		printSeperator();
//		Sort.sortArray(sort1, arrayStr2);
//		printSeperator();
//		Sort.sortArray(sort2, arrayStr0);
//		printSeperator();
//		Sort.sortArray(sort2, arrayStr1);
//		printSeperator();
//		Sort.sortArray(sort2, arrayStr2);
//		printSeperator();
	}

	private static void printSeperator() {
		System.out.println("-----------------------------------------");
	}
	
	public static void sortiere(Sort1 s, Comparable[] array){
		System.out.println("Unsortiert:");
		printArray(array);
		s.sort(array);
		printArray(array);
	}
	
	private static void printArray(Comparable[] array) {

		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
			if (i != array.length-1)
				System.out.print(" | ");
		}
		System.out.println();

	}

}
