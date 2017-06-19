package uebung05_aufgabe3;

import java.io.FilterReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import uebung02_teil2_aufgabe2.MyString;

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

		// create HashMap
		Map<String, Integer> hashMap = new HashMap<String, Integer>();

		// info and user dialog to ask for parameters
		System.out.println("2IB im SS17");
		System.out.println("TPE: 5. Übung, Aufgabe 3");
		System.out.println("Erstellt von: Lange und Schoenke");
		System.out.println("Version 1.0 (15/06/2017)");
		OwnUtils.printLines.printSeperatorLine();
		System.out.println("Bitte wählen Sie eine Datei aus:");
		System.out.println("[1] Bibel.txt");
		System.out.println("[2] shakespeare.txt");
		System.out.println("[3] Bibel2.txt (in UTF-8)");
		System.out.println("[4] shakespeare2.txt (in UTF-8)");

		switch (OwnUtils.MenueHelper.chooseOption(1, 4)) {
		case 1:
			fileName = "Bibel.txt";
			break;
		case 2:
			fileName = "shakespeare.txt";
			break;
		case 3:
			fileName = "Bibel2.txt";
			break;
		case 4:
			fileName = "shakespeare2.txt";
			break;
		}

		try {
			Reader f;
			int c;
			String newWord = "";
			f = new WordReader(new FileReader(fileName));
			timeStart = System.currentTimeMillis();
			while ((c = f.read()) != -1) {
				
				// check if letters are an word or not
				int position = isInAlphabet((char) c);
				if (position != -1) {
					newWord += (char) position;
				} else {
					if (newWord != null) {
						newWord = newWord.toLowerCase(); // ignore lower and upper case in words

						if ( newWord.length()>0)
							MyTreeMap.insertInMap(hashMap, newWord);
						newWord = "";
					}
				}
			}
			timeEnd = System.currentTimeMillis();
			f.close();
			System.out.println("Benötigte Zeit: " + (timeEnd - timeStart) + " ms");
		} catch (IOException e) {
			System.out.println("Fehler beim Lesen der Datei");
		}

		TreeMap<Integer, Set<String>> treeMap = MyTreeMap.convertHashToTree(hashMap);

		MyString[] array = MyTreeMap.printTreeReversed(treeMap);
		System.out.println("\n");
		MyTreeMap.sortArray(array);
		
		
	}

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
				return c;
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
