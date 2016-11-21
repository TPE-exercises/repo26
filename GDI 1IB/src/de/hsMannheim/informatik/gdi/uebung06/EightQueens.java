package de.hsMannheim.informatik.gdi.uebung06;

import static gdi.MakeItSimple.*;

public class EightQueens {

	static int spielbrettGroesse = 8;
	final static int DAME = 1;
	final static int BEDROHTEDAME = 2;
	final static int LEER = 0;
	static int sollAnzahlDamen = 8;
	static boolean debug = false;

	public static void main(String[] args) {

		int[][] field = new int[spielbrettGroesse][spielbrettGroesse];
		boolean solution;
		field = readFieldFromFile("Field-2.txt");
		solution = isValidSolution(field);

		println("Eingelesenes Spielfeld: ");
		gebeSpielbrettAus(field);

		println("Das Ergebniss ist: " + solution);

		if (!solution)
			markThreatenedQueens(field);
	}

	public static void gebeSpielbrettAus(int[][] field) {

		for (int n = 0; n < spielbrettGroesse; n++) {
			println();
			for (int i = 0; i < spielbrettGroesse; i++) {
				print(field[n][i] + " ");
			}
		}
		println();
		trenner();
	}

	public static void trenner() {
		println("---------------------------------");
	}

	public static void diagonalDebug(int damenZähler, int zeile, int spalte, int zählerZeile, int zählerSpalte) {
		trenner();
		println("Dame auf " + zeile + ", " + spalte + " bedroht");
		println("Dame " + (damenZähler - 1) + " diagonal auf " + zählerZeile + ", " + zählerSpalte);
		trenner();
	}

	static int[][] readFieldFromFile(String filename) {
		int[][] field = new int[spielbrettGroesse][spielbrettGroesse];
		if (isFilePresent(filename)) {
			Object datei = openInputFile(filename);

			for (int n = 0; n < spielbrettGroesse; n++) {
				for (int i = 0; i < spielbrettGroesse; i++)
					field[n][i] = readInt(datei);
			}
			closeInputFile(datei);
		} else
			throw new GDIException("Die Datei " + filename + " konnte nicht gefunden werden.");
		return field;
	}

	static boolean isValidSolution(int[][] field) {
		boolean d, v, h;
		int damenZähler = 0;

		// 2 Schleifen + If-Anweisung suchen alle Damen im Array
		for (int zeile = 0; zeile < spielbrettGroesse; zeile++) {
			for (int spalte = 0; spalte < spielbrettGroesse; spalte++) {
				if (field[zeile][spalte] == DAME) {
					d = isValidSolutionDiagonal(field, zeile, spalte);
					v = isValidSolutionVertikal(field, spalte);
					h = isValidSolutionHorizontal(field, zeile);
					damenZähler++;

					if (debug) {
						trenner();
						gebeSpielbrettAus(field);
						trenner();
						println("Testzeile " + zeile);
						println("Vertikal ist " + v);
						println("Horizontal ist " + h);
						println("Diagonal ist " + d);
					}
					// Breche Suche ab, wenn eine Dame bedroht wird
					if (!d || !v || !h)
						return false;
				}
			}
		}
		if (debug)
			println("Es gibt " + damenZähler + " Damen");

		if (damenZähler == sollAnzahlDamen)
			return true;
		else
			return false;
	}

	static boolean isValidSolutionDiagonal(int[][] field, int zeile, int spalte) {

		int damenZähler = 0;

		// Test auf Diagonal Rechts/Runter
		int zählerZeile = zeile;
		int zählerSpalte = spalte;
		while (zählerZeile < spielbrettGroesse && zählerSpalte < spielbrettGroesse) {

			// Für die Methode "markThreatendQueens" wird auch nach der
			// BEDROHTEDAME gesucht
			if (field[zählerZeile][zählerSpalte] == DAME || field[zählerZeile][zählerSpalte] == BEDROHTEDAME) {
				damenZähler++;
				if (debug && damenZähler > 1)
					diagonalDebug(damenZähler, zeile, spalte, zählerZeile, zählerSpalte);
			}
			zählerSpalte++;
			zählerZeile++;
		}

		// Test auf Diagonal Links/Runter
		zählerZeile = zeile;
		zählerSpalte = spalte;
		while (zählerZeile < spielbrettGroesse && zählerSpalte >= 0) {
			if (field[zählerZeile][zählerSpalte] == DAME || field[zählerZeile][zählerSpalte] == BEDROHTEDAME) {
				damenZähler++;
				if (debug && damenZähler > 2)
					diagonalDebug(damenZähler, zeile, spalte, zählerZeile, zählerSpalte);
			}
			zählerSpalte--;
			zählerZeile++;
		}

		// Zähler ist 2 da in beiden Schleifen, die Ausgangsdame gefunden wird
		if (damenZähler == 2)
			return true;
		else
			return false;

	}

	static boolean isValidSolutionDiagonalUp(int[][] field, int zeile, int spalte) {

		int damenZähler = 0;

		// Test auf Diagonal Rechts/Hoch
		int zählerZeile = zeile;
		int zählerSpalte = spalte;
		while (zählerZeile >= 0 && zählerSpalte < spielbrettGroesse) {
			// Für die Methode "markThreatendQueens" wird auch nach der 2
			// gesucht
			if (field[zählerZeile][zählerSpalte] == DAME || field[zählerZeile][zählerSpalte] == BEDROHTEDAME) {
				damenZähler++;
				if (debug && damenZähler > 1)
					diagonalDebug(damenZähler, zeile, spalte, zählerZeile, zählerSpalte);
			}
			zählerSpalte++;
			zählerZeile--;
		}

		// Test auf Diagonal Links/Hoch
		zählerZeile = zeile;
		zählerSpalte = spalte;
		while (zählerZeile >= 0 && zählerSpalte >= 0) {
			if (field[zählerZeile][zählerSpalte] == DAME || field[zählerZeile][zählerSpalte] == BEDROHTEDAME) {
				damenZähler++;
				if (debug && damenZähler > 2)
					diagonalDebug(damenZähler, zeile, spalte, zählerZeile, zählerSpalte);
			}
			zählerSpalte--;
			zählerZeile--;
		}

		// Zähler ist 2 da in beiden Schleifen, die Ausgangsdame gefunden wird
		if (damenZähler == 2)
			return true;
		else
			return false;
	}

	static boolean isValidSolutionVertikal(int[][] field, int spalte) {

		int damenZähler = 0;

		for (int i = 0; i < spielbrettGroesse; i++) {
			if (field[i][spalte] == DAME || field[i][spalte] == BEDROHTEDAME) {
				damenZähler++;
			}
			if (debug && damenZähler > 1) {
				trenner();
				println("Damen auf Spalte " + spalte + " bedrohen sich.");
				trenner();
			}
		}

		if (damenZähler == 1)
			return true;
		else
			return false;
	}

	static boolean isValidSolutionHorizontal(int[][] field, int zeile) {

		int damenZähler = 0;

		for (int i = 0; i < spielbrettGroesse; i++) {
			if (field[zeile][i] == DAME || field[zeile][i] == BEDROHTEDAME) {
				damenZähler++;
			}
			if (debug && damenZähler > 1) {
				trenner();
				println("Damen auf Zeile " + zeile + " bedrohen sich.");
				trenner();
			}
		}

		if (damenZähler == 1)
			return true;
		else
			return false;
	}

	static void markThreatenedQueens(int[][] field) {

		boolean debug = false;
		boolean d, v, h, du;

		for (int zeile = 0; zeile < spielbrettGroesse; zeile++) {
			for (int spalte = 0; spalte < spielbrettGroesse; spalte++) {
				if (field[zeile][spalte] == DAME) {
					d = isValidSolutionDiagonal(field, zeile, spalte);
					v = isValidSolutionVertikal(field, spalte);
					h = isValidSolutionHorizontal(field, zeile);
					du = isValidSolutionDiagonalUp(field, zeile, spalte);
					// Wird eine Dame bedroht wird sie auf 2 geändert
					if (!d || !v || !h || !du) {
						field[zeile][spalte] = BEDROHTEDAME;
					}
				}
			}
		}

		// Ausgabe des "markThreatendQueens"-Feldes
		trenner();
		println("Hier ist die Bedrohung zu sehen:");
		gebeSpielbrettAus(field);
	}

}
