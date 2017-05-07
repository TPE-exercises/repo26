package uebung03_aufgabe2und3;

import java.io.*;

public class CaesarFileEncryptor implements IFileEncryptor {

	/**
	 * Ordnerpfad Ben:
	 * C:\Users\Benjamin\git\repo26\de.hsMannheim.informatik.tpe.ss17.gruppe26
	 */

	@Override
	public File encrypt(File sourceDirectory) {
		String newCode = "";
		Reader f;
		int c;
		try {
			f = new FileReader(sourceDirectory);
			while ((c = f.read()) != -1) {
				newCode = newCode + (char) c;
			}
			f.close();
		} catch (IOException e) {
			System.out.println("Fehler beim Lesen der Datei");
		}

		PrintWriter f2;
		try {
			f2 = new PrintWriter(new CaesarWriter(new FileWriter(sourceDirectory), 0));
			f2.println(newCode);
			// f.write('a'); // Test von write(int)
			// f.println();
			// f.println(); // Zeilenvorschub
			f2.close();
		} catch (IOException e) {
			System.out.println("Fehler beim Erstellen der Datei");
		}
		return null;
	}

	@Override
	public File decrypt(File sourceDirectory) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		// System.out.println("Bitte geben Sie einen Ordner an: ");

		File f = new File("CaesarTest"); // Ordner einlesen
		// File[] fileArray = f.listFiles(); // Inhalte auflisten
		// int anzahl = fileArray.length;
		// System.out.print(anzahl);

		File f2 = new File(f + "_encrypted"); // Neuen Ordner erstellen

		if (f2.exists()) {
			for (int i = 1; f2.exists(); i++) {
				f2 = new File(f + "_encrypted(" + i + ")");
			}
		}
		f2.mkdir();

		IFileEncryptor neu = new CaesarFileEncryptor();
		neu.encrypt(f);

		// try {
		// CaesarFileEncryptor f3 = new CaesarWriter(new
		// FileWriter(fileArray[1]), 0);
		// f3.encrypt();
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		//
		// PrintWriter f;
		// try {
		// f = new PrintWriter(new CaesarWriter(new
		// FileWriter("CaesarText.txt"), 150));
		// f.println("Diese Zeile wird schön groß geschrieben");
		// // f.write('a'); // Test von write(int)
		// // f.println();
		// // f.println(); // Zeilenvorschub
		// f.close();
		// } catch (IOException e) {
		// System.out.println("Fehler beim Erstellen der Datei");
		// }
	}
}
