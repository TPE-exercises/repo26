package de.hsMannheim.informatik.gdi.uebung05;

import static gdi.MakeItSimple.*;

public class Fibonacci {

	public static void main(String[] args) {

		// Eingabe
		print("Bitte geben Sie an, wie viele Zahlen aus der Fibonacci-Folge berechnet werden sollen: ");
		int n;
		n = readInt();
		readLine();

		// Ausgabe
		int[] zahlenFolge;
		zahlenFolge = calculateFibonacci(n);
		int i = 0;
		print(zahlenFolge[i]);
		i++;
		if (n > 1)
			while (i < n) {
				print(", " + zahlenFolge[i++]);
			}
	}

	// Verarbeitung
	static int[] calculateFibonacci(int n) {
		if (n < 1)
			throw new GDIException("Ungültiger Parameter! Es wird eine natürliche Zahl erwartet!");
		else {
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
			return zahlenFolge;
		}
	}
}
