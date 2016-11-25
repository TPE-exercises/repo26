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

			durchgaenge++;

			// Frage Zahl ab
			bigIntAsString = BigIntRechner.toString(0);

			// Frage Stringlänge ab
			length = BigIntRechner.length(bigIntAsString);

			// Wandle String in Array um
			arrayMAX = BigIntRechner.getDigits(bigIntAsString, length);

			println("Eingegebene Zahl: ");
			gebeArrayAus(arrayMAX);

			// Addiere Array auf vorhandenes auf
			arrayAfterAdd = BigIntRechner.add(arrayMAX, length);

			globalArray = arrayAfterAdd;

			int newlength = newlength(arrayAfterAdd);

			// Entferne alle NULLen vor der ersten Zahl
			int[] array = new int[newlength];
			array = BigIntRechner.kuerzeArray(arrayAfterAdd, newlength);

			println("Ausgerechnetes Array: ");
			gebeArrayAus(array);

			// Möglichkeit weiteres Array ab zu fragen
			println("Möchten Sie eine Zahl auf die eingegebene addieren?");
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

	private static int newlength(int[] arrayMax) {

		for (int i = 0; i < arrayMax.length; i++) {
			if (arrayMax[i] != 0) {
				return (MaxBigInt - i);
			}
		}
		return 1;
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
}
