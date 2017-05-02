package uebung02_teil2_aufgabe2;

public class Main {
private static final String sort1 = "insertionSort";
private static final String sort2 = "shakerSort";

	public static void main(String[] args) {

		Comparable[] arrayInt0 = {};
		Comparable[] arrayInt1 = {new MyInt(5),new MyInt(7),new MyInt(4),new MyInt(3),new MyInt(1),new MyInt(8)};
		Comparable[] arrayInt2 = {new MyInt(5),new MyInt(-5),new MyInt(5),new MyInt(0)};
	
		Sort_ADS.sortArray(sort1, arrayInt0);
		printSeperator();
		Sort_ADS.sortArray(sort1, arrayInt1);
		printSeperator();
		Sort_ADS.sortArray(sort1, arrayInt2);	
		printSeperator();
		Sort_ADS.sortArray(sort2, arrayInt0);
		printSeperator();
		Sort_ADS.sortArray(sort2, arrayInt1);
		printSeperator();
		Sort_ADS.sortArray(sort2, arrayInt2);	
		printSeperator();
		
		
		Comparable[] arrayStr0 = {};
		Comparable[] arrayStr1 = {new MyString("a"),new MyString("b"),new MyString("c"),new MyString("ad"),new MyString("ab"),new MyString("ac")};
		Comparable[] arrayStr2 = {new MyString("Elias"),new MyString("Leon"),new MyString("Jonas"),new MyString("Emma"),new MyString("Mia"),new MyString("Emilia")};
		
		Sort_ADS.sortArray(sort1, arrayStr0);
		printSeperator();
		Sort_ADS.sortArray(sort1, arrayStr1);
		printSeperator();
		Sort_ADS.sortArray(sort1, arrayStr2);
		printSeperator();
		Sort_ADS.sortArray(sort2, arrayStr0);
		printSeperator();
		Sort_ADS.sortArray(sort2, arrayStr1);
		printSeperator();
		Sort_ADS.sortArray(sort2, arrayStr2);
		printSeperator();
	}
	
	private static void printSeperator(){
		System.out.println("-----------------------------------------");
	}

}
