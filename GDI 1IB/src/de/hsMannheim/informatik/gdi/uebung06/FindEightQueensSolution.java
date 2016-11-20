package de.hsMannheim.informatik.gdi.uebung06;

import static gdi.MakeItSimple.*;

public class FindEightQueensSolution {

	final static int Dame = 1;
	final static int Leer = 0;
	static int anzahlDerLösungen = 0;
	static int sollAnzahlDamen = 8;
	static int spielbrettGroesse = 8;

	public static void main(String[] args) {

		anzahlDerLösungen = 0;
		int[][] schachbrett = new int[spielbrettGroesse][spielbrettGroesse];
		int damenZähler = 0;
		int zeile = 0;
		int spalte = 0;

		findeLoesung(schachbrett, damenZähler, zeile, spalte);

		println("Anzahl der Lösungen: " + anzahlDerLösungen);
	}

	static void findeLoesung(int[][] schachbrett, int damenZähler, int zeile, int spalte) {

		if (zeile >= spielbrettGroesse || spalte >= spielbrettGroesse)
			return;

		schachbrett[zeile][spalte] = Dame;
		damenZähler++;

		if (isValidSolution(schachbrett)) {
			if (damenZähler == sollAnzahlDamen)
				printValidSolution(schachbrett);
			else
				findeLoesung(schachbrett, damenZähler, zeile + 1, 0);
		}

		schachbrett[zeile][spalte] = Leer;
		damenZähler--;
		findeLoesung(schachbrett, damenZähler, zeile, spalte + 1);
	}

	static void printValidSolution(int[][] field) {
		anzahlDerLösungen++;
		println("Mögliche Lösung: " + anzahlDerLösungen);

		// Gebe Spielbrett aus
		for (int j = 0; j < spielbrettGroesse; j++) {
			println();
			for (int i = 0; i < spielbrettGroesse; i++)
				print(field[j][i] + " ");
		}
		println();
		EightQueens.trenner();
	}

	static boolean isValidSolution(int[][] field) {
		boolean d = false, v = false;
		boolean debug = false;

		for (int zeile = 0; zeile < spielbrettGroesse; zeile++) {
			for (int spalte = 0; spalte < spielbrettGroesse; spalte++) {
				if (field[zeile][spalte] == 1) {
					d = EightQueens.isValidSolutionDiagonalUp(field, zeile, spalte);
					v = EightQueens.isValidSolutionVertikal(field, spalte);
				}
			}
		}
		if (d && v)
			return true;
		return false;
	}
}