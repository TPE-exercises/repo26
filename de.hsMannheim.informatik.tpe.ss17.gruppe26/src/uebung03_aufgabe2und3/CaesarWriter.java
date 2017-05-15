package uebung03_aufgabe2und3;

import java.io.*;

public class CaesarWriter extends FilterWriter {

	int moveTo;
	static char[] alphabet = new char[58];

	public CaesarWriter(Writer arg0, int moveTo) {
		super(arg0);
		moveTo = moveTo % 58;
		if (moveTo < 0)
			moveTo = 58 + moveTo;
		this.moveTo = moveTo;
		createAlphabet();
	}

	public void write(int c) throws IOException {
		if (this.moveTo % 58 == 0) {
			super.write((char) c);
		} else {
			super.write(encrypt((char) c));
		}
	}

	/**
	 * if character is in alphabet, run the moving method
	 * if character is not in alphabet, return itself
	 * @param cc
	 * @return the moved character or the same character
	 */
	public char encrypt(char cc) {
		int position = isInAlphabet(cc);
		if (position != -1) {
			return moveToAlphabet(position);
		} else {
			// System.out.print((char) cc); // *********DEBUG
			return cc;
		}
	}

	/**
	 * check, if the char is in alphabet 
	 * @param c
	 * @return the position of the char in alphabet
	 * @return -1 if the char is not in the alphabet
	 */
	public int isInAlphabet(char c) {
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
	 * @param pos of the char in the alphabet
	 * @return the new char
	 */
	public char moveToAlphabet(int pos) {
		for (int i = 0; i < this.moveTo; i++) {
			pos++;
			if (pos > 57) {
				pos = 0;
			}
		}
		// System.out.print((char) c); //*****************DEBUG
		return alphabet[pos];
	}

	public void write(char[] cbuf, int off, int len) throws IOException {
		for (int i = 0; i < len; ++i) {
			write(cbuf[off + i]);
		}
	}

	public void write(String str, int off, int len) throws IOException {
		write(str.toCharArray(), off, len);
	}

	/**
	 * extra method to create the long alphabet as an array of chars
	 */
	public static void createAlphabet() {
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