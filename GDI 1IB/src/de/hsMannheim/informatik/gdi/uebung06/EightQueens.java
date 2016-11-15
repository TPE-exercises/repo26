package de.hsMannheim.informatik.gdi.uebung06;
import static gdi.MakeItSimple.*;

public class EightQueens {

	public static void main(String[] args) {
		int[][] field = new int [8][8];
		boolean solution;
		
		
		field = readFieldFromFile("Field-1.txt");
		solution = isValidSolution(field);
		
		//Gebe Spielbrett aus
		for(int n=0; n<8;n++){
			println();
			for(int i=0; i<8;i++)
				print(field[n][i] + " ");
		}
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
	
	static boolean isValidSolution(int[][] field){
		boolean d, v, h;
		int damenZähler = 0;
		
		for(int zeile=0; zeile<8;zeile++){
			for(int spalte=0; spalte<8;spalte++){
				if(field[zeile][spalte] == 1){
					d = isValidSolutionDiagonal(field, zeile, spalte);
					v = isValidSolutionVertikal(field, spalte);
					h = isValidSolutionHorizontal(field, zeile);
					damenZähler++;
			//println("h ist " + zeile + h);
					if(!d || !v || !h){
						return false;
					}
				}
			}	
		}
		
		if(damenZähler == 8)
			return true;
		else 
			return false;
	}
	static boolean isValidSolutionDiagonal(int[][] field, int zeile, int spalte){
		
		
		return true;
	}
	static boolean isValidSolutionVertikal(int[][] field, int spalte){
		
		return true;
	}
	static boolean isValidSolutionHorizontal(int[][] field, int zeile){
		int damenZähler = 0;
		for(int i=0; i<8;i++){
			if(field[zeile][i] == 1){
				damenZähler++;
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
