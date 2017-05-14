package uebung03_aufgabe2und3;

import static gdi.MakeItSimple.*;

import java.io.*;

public class Main {

	/**
	 * create a new line of underscores
	 */
	private static void printSeperatorLine() {
		System.out.println("___________________________________________________");
	}

	/**
	 * create a new line of bindings
	 */
	private static void printSeperatorShortLines() {
		System.out.println("---------------------------------------------------");
	}

	/**
	 * print failure, if the input was a wrong value
	 */
	private static void printDefault() {
		System.out.print("Fehlerhafte Eingabe!");
		System.out.print("Bitte geben Sie eine gültige Zahl für den jeweiligen Menüpunkt ein! ");
	}

	public static void main(String[] args) {
		boolean continueMenu = true;
		int numberOfRuns = 0;
		int c;
		String letters = new String();

		System.out.println("Version 1.0 (07/05/2017)");
		System.out.println("Erstellt von: Lange und Schoenke");
		System.out.println("3. Programmieraufgabe Aufgabe 2 aus TPE im SS17");
		printSeperatorLine();
		System.out.println();
		while (continueMenu) {
			printSeperatorShortLines();
			if (numberOfRuns == 0)
				System.out.println("Was möchten Sie tun?");
			else
				System.out.println("Was möchten Sie als nächstes tun?");
			numberOfRuns++;
			System.out.println();
			System.out.println("(1) Neue Zeichenfolge eingeben");
			System.out.println("(2) Mit Caesar verschlüsseln");
			System.out.println("(3) Mit Caesar entschlüsseln");
			System.out.println("(8) Einen Ordner verschlüsseln");
			System.out.println("(9) Einen Ordner entschlüsseln");
			System.out.println("(0) Programm beenden");
			switch (readInt()) {
			case (1): // create a new string of letters
				readLine();
				System.out.println("Bitte geben Sie eine neue Zeichenfolge ein: ");
				letters = readLine();
				break;
			case (2): // caesar encrypting
				System.out.println("Um wie viel Zeichen möchten Sie verschieben?");
				PrintWriter f;
				try {
					f = new PrintWriter(new CaesarWriter(new FileWriter("CaesarText.txt"), readInt()));
					System.out.println("Alter Text: " + letters);
					System.out.print("Neuer Text: ");
					f.println(letters);
					// f.write('a'); // Test von write(int)
					// f.println();
					// f.println(); // Zeilenvorschub
					f.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("Fehler beim Erstellen der Datei");
					e.printStackTrace();
				}
				FileReader f2;
				try {
					f2 = new FileReader("CaesarText.txt");
					while ((c = f2.read()) != -1) {
						System.out.print((char) c);
					}
					f2.close();
				} catch (IOException e) {
					System.out.println("Fehler beim Lesen der Datei");
				}
				break;
			case (3): // caesar decrypting
				System.out.println("Um wie viel Zeichen möchten Sie verschieben?");
				int moveTo = readInt();
				FileReader f3;
				System.out.print("Alte Zeichenfolge: ");
				try {
					f3 = new FileReader("CaesarText.txt");
					while ((c = f3.read()) != -1) {
						System.out.print((char) c);
					}
					f3.close();
				} catch (IOException e) {
					System.out.println("Fehler beim Lesen der Datei");
				}
				Reader f4;
				System.out.print("Neue Zeichenfolge: ");
				try {
					f4 = new CaesarReader(new FileReader("CaesarText.txt"), moveTo);
					while ((c = f4.read()) != -1) {
						System.out.print((char) c);
					}
					f4.close();
				} catch (IOException e) {
					System.out.println("Fehler beim Lesen der Datei");
				}
				break;
			case (8): // encrypt a folder by caesar
				readLine();
				System.out.print("Bitte geben Sie einen Ordner an: ");
				String pfadangabe = readLine();
				System.out.println("Um wie viel Zeichen möchten Sie verschieben?");
				IFileEncryptor neu = new CaesarFileEncryptor(readInt());
				File sourceFile = new File(pfadangabe);
				File encryptedFile = neu.encrypt(sourceFile);
				System.out.println("Der neue Ordner heißt nun: " + encryptedFile);
				break;
			case (9): // decrypt a folder by caesar
				readLine();
				System.out.print("Bitte geben Sie einen Ordner an: ");
				String pfadangabe2 = readLine();
				System.out.print("Um wie viel Zeichen möchten Sie verschieben?");
				IFileEncryptor neu2 = new CaesarFileEncryptor(readInt());
				File sourceFile2 = new File(pfadangabe2);
				File decryptedFile = neu2.decrypt(sourceFile2);
				System.out.println("Der neue Ordner heißt nun: " + decryptedFile);
				break;
			case (0): // exit the program
				continueMenu = false;
				break;
			default:
				printDefault();
			}
		}
		System.out.println("Programm beendet.");
	}
}