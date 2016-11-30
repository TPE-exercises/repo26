package de.hsMannheim.informatik.gdi.uebung07;

import static gdi.MakeItSimple.*;

public class BigInt {

	static final int MaxBigInt = 50;
	static int[] arrayToAdd = new int[MaxBigInt];
	private static String number;
	static int bigIntCount = 0;
	private static int currentLengthOfBigInt;
	private static BigInt bigInt = new BigInt(number);
	private static BigInt[] saveBigInts = new BigInt[100];
	
	BigInt(String bigInt) {
		number = bigInt;
	}
	
	public static void main(String[] args) {
		boolean erneutUeberpruefen = false;
		
		do {
			int[] arrayOfBigInt = new int[MaxBigInt];
			int[] arrayAfterAdd = new int[MaxBigInt];
			String bigIntAsString;

			println("Geben Sie eine sehr große natürliche Zahl ein: ");
			bigIntAsString = readLine();

			if (bigIntAsString.length() > 0)
				saveBigInts[bigIntCount] = new BigInt(bigIntAsString);
			else
				throw new GDIException("Es wurde keine Zahl eingegeben!");

			// Frage Stringlänge ab
			 bigInt.length(bigIntCount);

			// Wandle String in Array um
			 arrayOfBigInt = BigInt.bigInt.getDigits(bigIntCount);

			println("Eingegebene Zahl: ");
			toString(arrayOfBigInt);

			// Addiere Array auf vorhandenes auf
			arrayAfterAdd = add(arrayOfBigInt);

			arrayToAdd = arrayAfterAdd;

			int newlength = newlength(arrayAfterAdd);

			// Entferne alle NULLen vor der ersten Zahl
			int[] array = new int[newlength];
			array = kuerzeArray(arrayAfterAdd, newlength);

			println("Ausgerechnetes Array: ");
			toString(array);

			// Möglichkeit weiteres Array ab zu fragen
			println("Möchten Sie eine Zahl auf die eingegebene addieren?");
			println(" JA = + | NEIN = 0");
			String wahl = readLine();

			switch (wahl) {
			case ("+"):
				erneutUeberpruefen = true;
				break;
			case ("0"):
				erneutUeberpruefen = false;
				println("-->Programmende<--");
				break;
			default:
				throw new GDIException("Fehlerhafte Eingabe");
			}
		} while (erneutUeberpruefen);
	}

	static int newlength(int[] arrayMax) {

		for (int i = 0; i < arrayMax.length; i++) {
			if (arrayMax[i] != 0) {
				return (MaxBigInt - i);
			}
		}
		return 1;
	}

	static void trenner() {
		println("---------------------------------");
	}

	static void gebeArrayAus() {

		
	}
	
	
	
	static int[] add(int[] arrayOfBigInt) {
		int[] newArray = new int[MaxBigInt];

		for (int i = MaxBigInt - 1; i > 0; i--) {
			int zwischenergebniss = 0;
			boolean uebertrag = false;

			zwischenergebniss = arrayToAdd[i] + arrayOfBigInt[i] + newArray[i];
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
	
	int[] getDigits(int bigIntCount) {

		int[] arrayOfBigInt = new int[MaxBigInt];
		int position = MaxBigInt - 1;

		for (int i = currentLengthOfBigInt - 1; i >= 0; i--) {

			char k = BigInt.number.charAt(i);

			switch (k) {
			case '0':
				arrayOfBigInt[position] = 0;
				break;
			case '1':
				arrayOfBigInt[position] = 1;
				break;
			case '2':
				arrayOfBigInt[position] = 2;
				break;
			case '3':
				arrayOfBigInt[position] = 3;
				break;
			case '4':
				arrayOfBigInt[position] = 4;
				break;
			case '5':
				arrayOfBigInt[position] = 5;
				break;
			case '6':
				arrayOfBigInt[position] = 6;
				break;
			case '7':
				arrayOfBigInt[position] = 7;
				break;
			case '8':
				arrayOfBigInt[position] = 8;
				break;
			case '9':
				arrayOfBigInt[position] = 9;
				break;
			default:
				throw new GDIException("Es dürfen nur positive Ziffern von 0-9 verwendet werden!");
			}
			position--;
		}
		return arrayOfBigInt;
	}
	
	static int[] kuerzeArray(int[] arrayMAX, int length) {
		int[] array = new int[length];
		int position = MaxBigInt - 1;

		for (int i = array.length - 1; i >= 0; i--) {
			array[i] = arrayMAX[position];
			position--;
		}
		return array;
	}
	
	public static String toString(int[] array) {
				
		for (int i = 0; i < array.length; i++) {
			print(array[i]);
		}
		println();
		trenner();
		return "";
	}
	
	void length(int bigIntCount) {

		currentLengthOfBigInt = BigInt.number.length();

		if (currentLengthOfBigInt > MaxBigInt)
			throw new GDIException("Die eingegebene Zahl ist zu groß, ändere MaxBigInt.");
	}
}
