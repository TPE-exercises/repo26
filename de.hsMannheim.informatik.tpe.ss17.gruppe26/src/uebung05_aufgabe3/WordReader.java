package uebung05_aufgabe3;

import java.io.FilterReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.IOException;
import java.io.Reader;

public class WordReader extends FilterReader {
	
	private static char[] alphabet = new char[58];

	protected WordReader(Reader arg0) {
		super(arg0);
		createAlphabet();
	}

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
			String newWord = null;
			f = new WordReader(new FileReader(fileName));
			timeStart = System.currentTimeMillis();
			while ((c = f.read()) != -1) {
				// TODO System.out.print((char) c);
				int position = isInAlphabet((char) c);
				if (position != -1) {
					newWord +=  (char)position;
				} else {
					newWord = newWord.toLowerCase();
					
					newWord = null;
				}
			}
			timeEnd = System.currentTimeMillis();
			f.close();
			System.out.println("Benötigte Zeit: " + (timeEnd - timeStart) + " ms");
		} catch (IOException e) {
			System.out.println("Fehler beim Lesen der Datei");
		}

	}
	
	public int read() throws IOException {
		int c = super.read();
		
		return c;
	}
	
//	public int read(char[] cbuf, int off, int len) throws IOException {
//		for (int i = off; i < len; ++i) {
//			cbuf[i] = (char) decrypt(cbuf[i]);
//		}
//		return super.read(cbuf, off, len);
//	}

	public void read(String str, int off, int len) throws IOException {
		read(str.toCharArray(), off, len);
	}
	
//	/**
//	 * if character is in alphabet, run the moving method if character is not in
//	 * alphabet, return itself
//	 * 
//	 * @param c
//	 *            is the value of the char
//	 * @return the moved character or the same character
//	 */
//	private int readWord(int c) {
//		int position = isInAlphabet((char) c);
//		if (position != -1) {
//			return (int) moveToAlphabet(position);
//		} else {
//			return c;
//		}
//	}
	
	/**
	 * check, if the char is in alphabet
	 * 
	 * @param c
	 * @return the position of the char in alphabet
	 * @return -1 if the char is not in the alphabet
	 */
	private static int isInAlphabet(char c) {
		for (int i = 0; i < alphabet.length; i++) {
			if (c == alphabet[i]) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * extra method to create the long alphabet as an array of chars
	 */
	private static void createAlphabet() {
		for (int i = 0; i < 26; i++) {
			alphabet[i] = (char) ((int) 'A' + i);
		}
		for (int i = 0; i < 26; i++) {
			alphabet[i + 26] = (char) ((int) 'a' + i);
		}
		alphabet[52] = 'Ä';
		alphabet[53] = 'Ö';
		alphabet[54] = 'Ü';
		alphabet[55] = 'ä';
		alphabet[56] = 'ö';
		alphabet[57] = 'ü';
	}

	public static void printAlphabet() {
		for (int i = 0; i < alphabet.length; i++) {
			System.out.println("alphabet[" + i + "]: " + alphabet[i]);
		}
	}
}
