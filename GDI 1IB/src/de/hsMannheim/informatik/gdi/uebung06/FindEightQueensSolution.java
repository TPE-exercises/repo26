package de.hsMannheim.informatik.gdi.uebung06;

import static gdi.MakeItSimple.*;

public class FindEightQueensSolution {

	public static void main(String[] args) {
		
		int[][] field = new int [8][8];
		boolean debug = false;
		int damenZähler = 0;
		
		for(int zeile=0; zeile<8; zeile++){
			int zählerinZeile = 0;
			int newspalte = 0;
			
			for(int spalte=0; spalte<8; spalte++){
				//println(zeile + ", " + spalte);
				
				newspalte = spalte;
				if(field[zeile][spalte] == 0)
					field[zeile][spalte] = 1;
				
				zählerinZeile++;
				
				boolean d = EightQueens.isValidSolutionDiagonal(field, zeile, spalte, debug);
				boolean du = EightQueens.isValidSolutionDiagonalUp(field, zeile, spalte, debug);
				boolean v = EightQueens.isValidSolutionVertikal(field, spalte, debug);
				boolean h = EightQueens.isValidSolutionHorizontal(field, zeile, debug);
				
				if(!d || !du || !v || !h){
					field[zeile][spalte] = 0;
					zählerinZeile--;
				}
							println("Zeile: " + zeile + " Spalte: " + spalte + " Zähler: " + zählerinZeile);
					
				damenZähler += zählerinZeile;
				
			}
				println("__--__--__--__--__--__--__--__--__--__--__");
				println(zählerinZeile);
				if(zählerinZeile == 0){
					for(int i=0; i<8; i++){
						
						//field[zeile][i] = 0;
					}
					for(int i=0; i<8; i++){
						if(field[zeile-1][i] == 1)
							field[zeile-1][i] = 4;
					}
					for(int n=0; n<8;n++){
						println();
						for(int i=0; i<8;i++){
							print(field[n][i] + " ");		
						}
					}
					zeile = zeile-2;
				}	
		}
	
		
		for(int n=0; n<8;n++){
			println();
			for(int i=0; i<8;i++){
				print(field[n][i] + " ");		
			}
		}
	
	}

}
