package de.hsMannheim.informatik.gdi.uebung07;

import static gdi.MakeItSimple.*;

public class BigInt {

	static final int MaxBigInt = 50;
	static int[] globalArray = new int[MaxBigInt];
	static int durchgaenge = 0;

	public static void main(String[] args) {

		boolean erneutUeberpruefen = false;

		do {
			int length = 0;
			int[] arrayMAX = new int[MaxBigInt];
			int[] arrayAfterAdd = new int[MaxBigInt];
			String bigIntAsString;

			BigInt name = new BigInt("");
			
			durchgaenge++;
			
			// Frage Zahl ab
			bigIntAsString = toString(0);

			// Frage Stringlänge ab
			length = length(bigIntAsString);

			// Wandle String in Array um
			arrayMAX = getDigits(bigIntAsString, length);

			
			println("Eigegebene Zahl: ");
			gebeArrayAus(arrayMAX);
			
			// Addiere Array auf vorhandenes auf
			arrayAfterAdd = add(arrayMAX, length);
			
			globalArray = arrayAfterAdd;
			
			int newlength = newlength(arrayAfterAdd);

			// Entferne alle NULLen vor der ersten Zahl
			int[] array = new int[newlength];
			array = kuerzeArray(arrayAfterAdd, newlength);

			println("Ausgerechnetes Array: ");
			gebeArrayAus(array);

			// Möglichkeit weiteres Array ab zu fragen
			println("Möchten sie eine Zahl auf die eingegebene addieren?");
			println(" JA = 1 | NEIN = 0");
			int wahl = readInt();

			switch (wahl) {
			case (1):
				erneutUeberpruefen = true;
				break;
			case (0):
				erneutUeberpruefen = false;
				println("-->Programmende<--");
				break;
			default:
				throw new GDIException("Fehlerhafte Eingabe");
			}
		} while (erneutUeberpruefen);

	}
	private static int newlength (int[] arrayMax){
		
		for(int i = 0; i<arrayMax.length; i++){
			if(arrayMax[i] != 0){
				return (MaxBigInt-i);
			}
		}
		return -1;
	}

	private int[] kuerzeArray(int[] arrayMAX, int length) {
		int[] array = new int[length];

		int position = MaxBigInt - 1;

		for (int i = array.length - 1; i >= 0; i--) {
			array[i] = arrayMAX[position];
			position--;
		}

		return array;
	}

	public static void trenner() {
		println("---------------------------------");
	}

	public static void gebeArrayAus(int[] array) {

		for (int i = 0; i < array.length; i++) {
			print(array[i]);
		}
		println();
		trenner();
	}

	static int[] add(int[] array2, int arrayLength) {
		int[] newArray = new int[MaxBigInt];

		for (int i = MaxBigInt - 1; i > 0; i--) {
			int zwischenergebniss = 0;
			boolean uebertrag = false;

			zwischenergebniss = globalArray[i] + array2[i] + newArray[i];
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

	public static String toString(int notUse) {
		String bigIntAsString;

		println("Gebe nun die BigInt ein");
		if(durchgaenge!=1)bigIntAsString = readLine();
		bigIntAsString = readLine();

		if (bigIntAsString.length() > 0)
			return bigIntAsString;
		else
			throw new GDIException("Es wurde keine Zahl eingegeben");
	}

	public static int[] getDigits(String bigIntAsString, int arrayLength) {

		int[] array1 = new int[MaxBigInt];
		int position = MaxBigInt - 1;

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
				throw new GDIException("Es dürfen nur Zahlen von 0-9 verwendet werden");
			}
			position--;
		}
		return array1;

	}

	public static int length(String bigIntAsString) {

		int length = 0;
		length = bigIntAsString.length();
		if (length > MaxBigInt)
			throw new GDIException("Die eingegebene Zahl ist zu groß, ändere MaxBigInt.");
		return length;

	}

}
