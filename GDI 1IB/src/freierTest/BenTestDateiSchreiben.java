package freierTest;

import static gdi.MakeItSimple.*;

public class BenTestDateiSchreiben {

	public static void main(String[] args) {
		Object file = openInputFile("EingabeArray.txt");
		int[] array = new int[10];
		for (int i = 0; i < 10;i++){
		array[i] = readInt(file);
		}
		closeInputFile(file);

		print(array[0]);
		for (int d = 1; d < array.length; d++) {
			print(", " + array[d]);
		}
		println();
		
	}

}
