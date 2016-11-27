package freierTest;

import static gdi.MakeItSimple.*;

public class BenTestDateiSchreiben {

	public static void main(String[] args) {
		Object file = openOutputFile("EingabeArray.txt");
		int number = 6;
		print(file, number + " ");
		closeOutputFile(file);

	}

}
