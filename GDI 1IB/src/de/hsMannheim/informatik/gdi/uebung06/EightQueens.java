package de.hsMannheim.informatik.gdi.uebung06;
import static gdi.MakeItSimple.*;

public class EightQueens {

	public static void main(String[] args) {
		int[][] field = new int [8][8];
		boolean solution;
		
		boolean debug = true;
		
		println("Gültig 1 oder ungültig 2");
		int wahl = readInt();
		
		switch (wahl) {
		case 1:
			field = readFieldFromFile("Field-2.txt");
			break;
		case 2:
			field = readFieldFromFile("Field-1.txt");
			break;
		default:
			println("Ungültige Eingabe");
		}
		solution = isValidSolution(field, debug);
		
		if(debug){
		//Gebe Spielbrett aus
			for(int n=0; n<8;n++){
				println();
				for(int i=0; i<8;i++){
					print(field[n][i] + " ");		
				}
			}
		}println();
		println(solution);
	}
	
	static int[][] readFieldFromFile(String filename){
		int[][] field = new int [8][8];
		if(isFilePresent(filename)){
			Object datei = openInputFile(filename);
			
			for(int n=0; n<8;n++){
				for(int i=0; i<8;i++)
				field[n][i] = readInt(datei);
			}
			closeInputFile(datei);
		}
		else
			throw new GDIException("Die Datei " + filename + " konnte nicht gefunden werden.");
		return field;
	}
	
	static boolean isValidSolution(int[][] field, boolean debug){
		boolean d, v, h;
		int damenZähler = 0;
		
		for(int zeile=0; zeile<8;zeile++){
			for(int spalte=0; spalte<8;spalte++){
				if(field[zeile][spalte] == 1){
					d = isValidSolutionDiagonal(field, zeile, spalte, debug);
					v = isValidSolutionVertikal(field, spalte, debug);
					h = isValidSolutionHorizontal(field, zeile, debug);
					damenZähler++;
			
					if(debug){
						println("Testzeile " + zeile);
						println("Vertikal ist " + v);
						println("Horizontal ist " + h);
						println("Diagonal ist " + d);
						println("------------------------------------------------");
					}
					if(!d || !v || !h){
						return false;
					}
				}
			}	
		}
		if(debug)	
			println("Es gibt " + damenZähler + " Damen");
		if(damenZähler == 8)
			return true;
		else 
			return false;
	}
	static boolean isValidSolutionDiagonal(int[][] field, int zeile, int spalte, boolean debug){

		int zählerZeile = zeile;
		int zählerSpalte = spalte;
		int damenZähler = 0;
		
		while(zählerZeile < 8 && zählerSpalte < 8){
			if(field[zählerZeile][zählerSpalte] == 1){
				damenZähler++;
				if(debug && damenZähler > 1){
					println("------------------------------------------------");
					println("Dame auf " + zeile + ", " + spalte + " bedroht");
					println("Dame " + (damenZähler-1) + " diagonal auf " + zählerZeile + ", "+ zählerSpalte);
					println("------------------------------------------------");
				}
			}
			zählerSpalte++;
			zählerZeile++;
		}
		
		zählerZeile = zeile;
		zählerSpalte = spalte;
		
		while(zählerZeile < 8 && zählerSpalte >= 0){
			if(field[zählerZeile][zählerSpalte] == 1){
				damenZähler++;
				if(debug && damenZähler >2){
					println("------------------------------------------------");
					println("Dame auf " + zeile + ", " + spalte + " bedroht");
					println("Dame " + (damenZähler-1) + " diagonal auf " + zählerZeile + ", "+ zählerSpalte);
					println("------------------------------------------------");
				}
			}
			zählerSpalte--;
			zählerZeile++;
		}
		
		if(damenZähler==2)
			return true;
		else
			return false;
		
	}
	static boolean isValidSolutionVertikal(int[][] field, int spalte, boolean debug){
		int damenZähler = 0;
		for(int i=0; i<8;i++){
			if(field[i][spalte] == 1){
				damenZähler++;	
			}
			if(debug && damenZähler > 2){
				println("------------------------------------------------");
				println("Damen auf Spalte " + spalte + " bedrohen sich.");
				println("------------------------------------------------");
			}
		}
		if(damenZähler==1)
			return true;
		else
			return false;
	}
	static boolean isValidSolutionHorizontal(int[][] field, int zeile, boolean debug){
		int damenZähler = 0;
		for(int i=0; i<8;i++){
			if(field[zeile][i] == 1){
				damenZähler++;
			}
			if(debug && damenZähler > 1){
				println("------------------------------------------------");
				println("Damen auf Zeile " + zeile + " bedrohen sich.");
				println("------------------------------------------------");
			}
		}
		if(damenZähler==1)
			return true;
		else
			return false;
	}
	
	static void markThreatendQueens(int[][] field){
		
	}
	
	
}
