package freierTest;

import static gdi.MakeItSimple.*;

import gdi.MakeItSimple.GDIException;

public class BenTest02 {
	int länge;
	static String eingegebeneZahl;
	// static final int MaxBigInt = 50;
	// static int[] globalArray = new int[MaxBigInt];
	// static int durchgaenge = 0;
	private static String number;
	// static String vorliegendeZahl;

	BenTest02(String bigInt) {
		number = bigInt;
	}

	// int length = number.length();
	// int[] feld = new int[length];

	/**
	 * Eingabe einer sehr großen natürlichen Zahl sowie die Ausgabe der
	 * berechneten Zahlen.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// boolean erneutUeberpruefen = false;

		println("Geben Sie eine sehr große natürliche Zahl ein: ");
		// if(durchgaenge!=1)number = readLine();
		eingegebeneZahl = readLine();
		BigInt zahl = new BigInt(eingegebeneZahl);
		// BigInt number = new BigInt(vorliegendeZahl);

		println("Länge: " + zahl.length());
		println("String: " + number.toString());
		print("Feld: ");
		for (int i = 0; i < zahl.length(); i++)
			print(zahl.getDigits()[i]);
		/*
		 * for (int i = 0; i < feld.length; i++) { print(feld[i]); } println();
		 */
		// trenner();

		// do {
		// int length = 0;
		// int[] arrayMAX = new int[MaxBigInt];
		// int[] arrayAfterAdd = new int[MaxBigInt];
		// String bigIntAsString;

		// durchgaenge++;

		/*
		 * // Frage Zahl ab bigIntAsString = toString(0);
		 * 
		 * // Frage Stringlänge ab length = length();
		 */

		// Wandle String in Array um
		// arrayMAX = BigInt.getDigits(bigIntAsString, length);

		// println("Eingegebene Zahl: ");
		// gebeArrayAus(arrayMAX);

		// Addiere Array auf vorhandenes auf
		// arrayAfterAdd = BigInt.add(arrayMAX, length);

		// globalArray = arrayAfterAdd;

		// int newlength = newlength(arrayAfterAdd);

		// Entferne alle NULLen vor der ersten Zahl
		// int[] array = new int[newlength];
		// array = kuerzeArray(arrayAfterAdd, newlength);

		// println("Ausgerechnetes Array: ");
		// gebeArrayAus(array);

		// Möglichkeit weiteres Array ab zu fragen
		// println("Möchten Sie eine Zahl auf die eingegebene addieren?");
		// println(" JA = 1 | NEIN = 0");
		// int wahl = readInt();

		// switch (wahl) {
		// case (1):
		// erneutUeberpruefen = true;
		// break;
		// case (0):
		// erneutUeberpruefen = false;
		// println("-->Programmende<--");
		// break;
		// default:
		// throw new GDIException("Fehlerhafte Eingabe");
		// }
		// } while (erneutUeberpruefen);
	}
	/*
	 * private static int newlength(int[] arrayMax) {
	 * 
	 * for (int i = 0; i < arrayMax.length; i++) { if (arrayMax[i] != 0) {
	 * return (MaxBigInt - i); } } return 1; }
	 */

	/*
	 * public static void trenner() {
	 * println("---------------------------------"); }
	 */

	/*
	 * public static void gebeArrayAus(int[] array) {
	 * 
	 * for (int i = 0; i < array.length; i++) { print(array[i]); } println();
	 * //trenner(); }
	 */

	/**
	 * Addiert die als Parameter übergebene Zahl vom Typ BigInt zu der
	 * vorliegenden Zahl.
	 * 
	 * @param number
	 * @return
	 */
	int[] add(BigInt number) {
		int[] newArray = new int[länge];

		for (int i = länge - 1; i > 0; i--) {
			int zwischenergebniss = 0;
			boolean uebertrag = false;

			zwischenergebniss = number.getDigits()[i] + newArray[i];
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

	/**
	 * Liefert das Feld in dem die Ziffern der vorliegenden Zahl gespeichert
	 * wurden.
	 * 
	 * @return
	 */
	int[] getDigits() {

		int[] neuesfeld = new int[länge];
		/*
		 * for (int i = länge - 1; i > 0; i--) { char k = toString().charAt(i);
		 * neuesfeld[i] = k; // if (0 <= k && k <= 9)
		 * 
		 * // else // throw new GDIException("Es wurde keine Zahl eingegeben!");
		 * } for (int i = 0; i < länge; i++) { print(neuesfeld[i]); print(", ");
		 * } println();
		 */

		int position = länge - 1;

		for (int i = länge - 1; i >= 0; i--) {

			char k = number.charAt(i);

			switch (k) {
			case '0':
				neuesfeld[position] = 0;
				break;
			case '1':
				neuesfeld[position] = 1;
				break;
			case '2':
				neuesfeld[position] = 2;
				break;
			case '3':
				neuesfeld[position] = 3;
				break;
			case '4':
				neuesfeld[position] = 4;
				break;
			case '5':
				neuesfeld[position] = 5;
				break;
			case '6':
				neuesfeld[position] = 6;
				break;
			case '7':
				neuesfeld[position] = 7;
				break;
			case '8':
				neuesfeld[position] = 8;
				break;
			case '9':
				neuesfeld[position] = 9;
				break;
			default:
				throw new GDIException("Es dürfen nur positive Ziffern von 0-9 verwendet werden!");
			}
			position--;
		}
		return neuesfeld;
	}

	/*
	 * static int[] kuerzeArray(int[] arrayMAX, int length) { int[] array = new
	 * int[length]; int position = MaxBigInt - 1;
	 * 
	 * for (int i = array.length - 1; i >= 0; i--) { array[i] =
	 * arrayMAX[position]; position--; } return array; }
	 */

	/**
	 * Liefert vorliegende Zahl als String.
	 */
	public String toString() {
		String vorliegendeZahl = number;

		// println("Geben Sie eine sehr große natürliche Zahl ein: ");
		// if(durchgaenge!=1)vorliegendeZahl = readLine();
		// vorliegendeZahl = readLine();

		// if (length > 0)
		return vorliegendeZahl;
		// else
		// throw new GDIException("Es wurde keine Zahl eingegeben!");

	}

	/**
	 * Liefert die Anzahl der Ziffern der vorliegenden Zahl.
	 * 
	 * @return
	 */
	int length() {
		/*
		 * int länge;/* Änderung für 50 Stellen if (length > BigInt.MaxBigInt)
		 * //throw new GDIException(
		 * "Die eingegebene Zahl ist zu groß, ändere MaxBigInt.");
		 * 
		 */
		return länge = number.length();
	}
}