package freierTest;

import static gdi.MakeItSimple.*;

public class BenTest {

	public static void main(String[] args) {

		// Eingabe
		print("Bitte geben Sie an, wie viele Zahlen aus der Fibonacci-Folge berechnet werden sollen: ");
		int n;
		n = readInt();
		readLine();
		// calculateFibonacci(n);
		// println(" " + Arrays.toString(calculateFibonacci(n)));

		int[] zahlenFolge = new int[n];
		int i = 0;
		if (n >= 1)
			zahlenFolge[i] = 0;
		i++;
		if (n >= 2)
			zahlenFolge[i] = 1;
		i++;
		if (n >= 3)
			while (i < n) {
				zahlenFolge[i] = zahlenFolge[i - 2] + zahlenFolge[i - 1];
				i++;
			}
		i = 0;
		print(zahlenFolge[i]);
		i++;
		if (n > 1)
			while (i < n) {
				print(", " + zahlenFolge[i++]);
			}
		// Ausgabe
		/*
		 * int i=0; print(zahlenFolge); if (n > 1) while ( i < n ) print( ", " +
		 * zahlenFolge[i++]);
		 */
	}

	// Verarbeitung
	/*
	 * static int[] calculateFibonacci(int n) {
	 * 
	 * return zahlenFolge; }
	 */

}
