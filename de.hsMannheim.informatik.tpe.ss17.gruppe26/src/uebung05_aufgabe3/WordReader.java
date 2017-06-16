package uebung05_aufgabe3;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

public class WordReader extends FilterReader {
	
	private static char[] alphabet = new char[58];

	protected WordReader(Reader arg0) {
		super(arg0);
		createAlphabet();
	}

	public int read() throws IOException {
		int c;
		if (moveTo % 58 == 0) {
			c = super.read();
		} else {
			c = readWord(super.read());
		}
		return c;
	}
	
	public int read(char[] cbuf, int off, int len) throws IOException {
		for (int i = off; i < len; ++i) {
			cbuf[i] = (char) decrypt(cbuf[i]);
		}
		return super.read(cbuf, off, len);
	}

	public void read(String str, int off, int len) throws IOException {
		read(str.toCharArray(), off, len);
	}
	
	/**
	 * if character is in alphabet, run the moving method if character is not in
	 * alphabet, return itself
	 * 
	 * @param c
	 *            is the value of the char
	 * @return the moved character or the same character
	 */
	private int readWord(int c) {
		int position = isInAlphabet((char) c);
		if (position != -1) {
			return (int) moveToAlphabet(position);
		} else {
			return c;
		}
	}
	
	/**
	 * check, if the char is in alphabet
	 * 
	 * @param c
	 * @return the position of the char in alphabet
	 * @return -1 if the char is not in the alphabet
	 */
	private int isInAlphabet(char c) {
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
