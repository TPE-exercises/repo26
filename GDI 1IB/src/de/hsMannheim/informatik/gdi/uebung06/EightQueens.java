package de.hsMannheim.informatik.gdi.uebung06;
import static gdi.MakeItSimple.*;

public class EightQueens {

	public static void main(String[] args) {
		int[][] field = new int [8][8];
		boolean solution;
		
		//Ändere true/false um mehr oder weniger auf der Konsole anzu zeigen
		boolean debug = false;
		
		//Auswahl von BeispielFeldern
		println("Zeige gültig 1 oder ungültig 2 an");
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
		//Auswahl ende
		
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
		
		println("Das Ergebniss ist: " + solution);
		
		if(!solution)
			markThreatendQueens(field);
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
		
		//2 Schleifen + If-Anweisung suchen alle Damen im Array
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

		int damenZähler = 0;
		
		//Test auf Diagonal Rechts/Runter
		int zählerZeile = zeile;
		int zählerSpalte = spalte;
		while(zählerZeile < 8 && zählerSpalte < 8){
			//Für die Methode "markThreatendQueens" wird auch nach der 2 gesucht
			if(field[zählerZeile][zählerSpalte] == 1 || field[zählerZeile][zählerSpalte] == 2){
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
		
		//Test auf Diagonal Links/Runter
		zählerZeile = zeile;
		zählerSpalte = spalte;
		while(zählerZeile < 8 && zählerSpalte >= 0){
			if(field[zählerZeile][zählerSpalte] == 1 || field[zählerZeile][zählerSpalte] == 2){
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
		
		//Zähler ist 2 da in beiden Schleifen, die Ausgangsdame gefunden wird
		if(damenZähler==2)
			return true;
		else
			return false;
		
	}
	static boolean isValidSolutionDiagonalUp(int[][] field, int zeile, int spalte, boolean debug){
		
		int damenZähler = 0;
		
		//Test auf Diagonal Rechts/Hoch
		int zählerZeile = zeile;
		int zählerSpalte = spalte;
		while(zählerZeile >= 0 && zählerSpalte < 8){
			//Für die Methode "markThreatendQueens" wird auch nach der 2 gesucht
			if(field[zählerZeile][zählerSpalte] == 1 || field[zählerZeile][zählerSpalte] == 2){
				damenZähler++;
				if(debug && damenZähler > 1){
					println("------------------------------------------------");
					println("Dame auf " + zeile + ", " + spalte + " bedroht");
					println("Dame " + (damenZähler-1) + " diagonal auf " + zählerZeile + ", "+ zählerSpalte);
					println("------------------------------------------------");
				}
			}
			zählerSpalte++;
			zählerZeile--;
		}
		
		//Test auf Diagonal Links/Hoch
		zählerZeile = zeile;
		zählerSpalte = spalte;
		while(zählerZeile >= 0 && zählerSpalte >= 0){
			if(field[zählerZeile][zählerSpalte] == 1 || field[zählerZeile][zählerSpalte] == 2){
				damenZähler++;
				if(debug && damenZähler > 1){
					println("------------------------------------------------");
					println("Dame auf " + zeile + ", " + spalte + " bedroht");
					println("Dame " + (damenZähler-1) + " diagonal auf " + zählerZeile + ", "+ zählerSpalte);
					println("------------------------------------------------");
				}
			}
			zählerSpalte--;
			zählerZeile--;
		}
		
		//Zähler ist 2 da in beiden Schleifen, die Ausgangsdame gefunden wird
		if(damenZähler==2)
			return true;
		else
			return false;
	}
	
	static boolean isValidSolutionVertikal(int[][] field, int spalte, boolean debug){
		
		int damenZähler = 0;
		
		for(int i=0; i<8;i++){
			if(field[i][spalte] == 1 || field[i][spalte] == 2){
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
			if(field[zeile][i] == 1 ||field[zeile][i]==2){
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
		
		boolean debug = false;
		boolean d,v,h,v2;
		
		for(int zeile=0; zeile<8;zeile++){
			for(int spalte=0; spalte<8;spalte++){
				if(field[zeile][spalte] == 1){
					d = isValidSolutionDiagonal(field, zeile, spalte, debug);
					v = isValidSolutionVertikal(field, spalte, debug);
					h = isValidSolutionHorizontal(field, zeile, debug);
					v2 = isValidSolutionDiagonalUp(field, zeile, spalte, debug);
					//Wird eine Dame bedroht wird sie auf 2 geändert
					if(!d || !v || !h || !v2){
						field[zeile][spalte] = 2;
					}
				}
			}
		}
		
		//Ausgabe des "markThreatendQueens"-Feldes
		println("------------------------------------------------");
		println("Hier ist die Bedrohung zu sehen:");
		for(int n=0; n<8;n++){
			println();
			for(int i=0; i<8;i++){
				print(field[n][i] + " ");		
			}
		}
	}
	
	
}
