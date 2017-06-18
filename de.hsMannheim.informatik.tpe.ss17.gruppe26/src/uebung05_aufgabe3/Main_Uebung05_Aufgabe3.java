package uebung05_aufgabe3;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Main_Uebung05_Aufgabe3 {

	public static void main(String[] args) {

		long timeStart = 0;
		long timeEnd = 0;
		String fileName = null;

		// info and user dialog to ask for parameters
		System.out.println("2IB im SS17");
		System.out.println("TPE: 5. Übung, Aufgabe 3");
		System.out.println("Erstellt von: Lange und Schoenke");
		System.out.println("Version 1.0 (15/06/2017)");
		OwnUtils.printLines.printSeperatorLine();
		System.out.println("Bitte wählen Sie eine Datei aus:");
		System.out.println("[1] Bibel.txt");
		System.out.println("[2] shakespeare.txt");

		switch (OwnUtils.MenueHelper.chooseOption(1, 2)) {
		case 1:
			fileName = "Bibel.txt";
			break;
		case 2:
			fileName = "shakespeare.txt";
			break;
		}
		
		try {
			Reader f;
			int c;
			
			f = new WordReader(new FileReader(fileName));
			timeStart = System.currentTimeMillis();
			while ((c = f.read()) != -1) {
				// TODO System.out.print((char) c);
			}
			timeEnd = System.currentTimeMillis();
			f.close();
			System.out.println("Benötigte Zeit: " + (timeEnd - timeStart) + " ms");
		} catch (IOException e) {
			System.out.println("Fehler beim Lesen der Datei");
		}

	}

}
