package de.hsMannheim.informatik.gdi.uebung07;

import static gdi.MakeItSimple.*;

public class BigIntRechner {
	
	BigIntRechner(String BigInt){
	}
	
	static int[] add(int[] array2, int arrayLength) {
		int[] newArray = new int[BigInt.MaxBigInt];

		for (int i = BigInt.MaxBigInt - 1; i > 0; i--) {
			int zwischenergebniss = 0;
			boolean uebertrag = false;

			zwischenergebniss = BigInt.globalArray[i] + array2[i] + newArray[i];
			if (zwischenergebniss >= 10) {
				zwischenergebniss -= 10;
				uebertrag = true;
			}
			newArray[i] = zwischenergebniss;
			if (uebertrag) {
				newArray[i - 1] += 1;
			}
		}
		return newArray;
	}
	
	public static int[] getDigits(String bigIntAsString, int arrayLength) {

		int[] array1 = new int[BigInt.MaxBigInt];
		int position = BigInt.MaxBigInt - 1;

		for (int i = arrayLength - 1; i >= 0; i--) {

			char k = bigIntAsString.charAt(i);

			switch (k) {
			case '0':
				array1[position] = 0;
				break;
			case '1':
				array1[position] = 1;
				break;
			case '2':
				array1[position] = 2;
				break;
			case '3':
				array1[position] = 3;
				break;
			case '4':
				array1[position] = 4;
				break;
			case '5':
				array1[position] = 5;
				break;
			case '6':
				array1[position] = 6;
				break;
			case '7':
				array1[position] = 7;
				break;
			case '8':
				array1[position] = 8;
				break;
			case '9':
				array1[position] = 9;
				break;
			default:
				throw new GDIException("Es dürfen nur positive Ziffern von 0-9 verwendet werden!");
			}
			position--;
		}
		return array1;
	}
	
	static int[] kuerzeArray(int[] arrayMAX, int length) {
		int[] array = new int[length];
		int position = BigInt.MaxBigInt - 1;

		for (int i = array.length - 1; i >= 0; i--) {
			array[i] = arrayMAX[position];
			position--;
		}
		return array;
	}
	
	public static String toString(int notUse) {
		String bigIntAsString;

		println("Geben Sie eine sehr große natürliche Zahl ein: ");
		if(BigInt.durchgaenge!=1)bigIntAsString = readLine();
		bigIntAsString = readLine();

		if (bigIntAsString.length() > 0)
			return bigIntAsString;
		else
			throw new GDIException("Es wurde keine Zahl eingegeben!");
	}
	
	public static int length(String bigIntAsString) {

		int length = 0;
		length = bigIntAsString.length();
		if (length > BigInt.MaxBigInt)
			throw new GDIException("Die eingegebene Zahl ist zu groß, ändere MaxBigInt.");
		return length;
	}
}
