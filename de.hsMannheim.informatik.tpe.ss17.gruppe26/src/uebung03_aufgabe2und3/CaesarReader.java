package uebung03_aufgabe2und3;

import java.io.*;

public class CaesarReader extends FilterReader {

	private int moveTo;
	private static char[] alphabet = new char[58];

	protected CaesarReader(Reader arg0, int moveTo) {
		super(arg0);
		moveTo = moveTo % 58;
		if (moveTo < 0)
			moveTo = 58 + moveTo;
		this.moveTo = moveTo;
		createAlphabet();
	}

	public int read() throws IOException {
		int c;
		if (moveTo % 58 == 0) {
			c = super.read();
		} else {
			c = decrypt(super.read());
		}
		return c;
	}

	/**
	 * if character is in alphabet, run the moving method if character is not in
	 * alphabet, return itself
	 * 
	 * @param c
	 *            is the value of the char
	 * @return the moved character or the same character
	 */
	private int decrypt(int c) {
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
	 * move the character inner the alphabet
	 * 
	 * @param pos
	 *            of the char in the alphabet
	 * @return the new char
	 */
	private char moveToAlphabet(int pos) {
		for (int i = 0; i < this.moveTo; i++) {
			pos--;
			if (pos < 0) {
				pos = 57;
			}
		}
		return alphabet[pos];
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

	public static void main(String[] args) {
		Reader f;
		int c;
		try {
			f = new CaesarReader(new FileReader("CaesarText.txt"), 1);
			while ((c = f.read()) != -1) {
				System.out.print((char) c);
			}
			f.close();
		} catch (IOException e) {
			System.out.println("Fehler beim Lesen der Datei");
		}
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
