package uebung03_aufgabe2;

import java.io.*;

public class CaesarWriter extends FilterWriter {

	int moveTo;

	public CaesarWriter(Writer arg0, int moveTo) {
		super(arg0);
		moveTo = moveTo % 58;
		if (moveTo < 0)
			moveTo = 58 + moveTo;
		this.moveTo = moveTo;
	}

	public void write(int c) throws IOException {
		if (moveTo % 58 == 0) {
			super.write((char) c);
		} else
			super.write((char) encrypt(c));
	}

	public int encrypt(int c) {
		if (isInAlphabet(c)) {
			return moveToAlphabet(c);
		} else { // Ist Buchstabe nicht im gültigen Alphabet, bleibt es unverändert
//			System.out.print((char) c); // *********DEBUG
			return c;
		}
	}

	/**
	 * Ä = 142, Ö = 153, Ü = 154, ä = 132, ö = 148, ü = 129
	 * 
	 * @param c
	 * @return
	 */
	public boolean isInAlphabet(int c) {
		if (c >= 65 && c <= 90)
			return true;
		if (c >= 97 && c <= 122)
			return true;
		if (c == 129 || c == 132 || c == 148)
			return true;
		if (c == 153 || c == 154 || c == 142)
			return true;
		return false;
	}

	public int moveToAlphabet(int c) {
		for (int i = 0; i <= moveTo; i++) {
			c++;
			if (c == 91)
				c = 97;
			if (c == 123)
				c = 142;
			if (c == 143)
				c = 153;
			if (c == 155)
				c = 132;
			if (c == 133)
				c = 148;
			if (c == 149)
				c = 129;
			if (c == 130)
				c = 65;
		}
//		System.out.print((char) c); //*****************DEBUG
		return c;
	}

	public void write(char[] cbuf, int off, int len) throws IOException {
		for (int i = 0; i < len; ++i) {
			write(cbuf[off + i]);
		}
	}

	public void write(String str, int off, int len) throws IOException {
		write(str.toCharArray(), off, len);
	}

//	public static void main(String[] args) {
//		PrintWriter f;
//		try {
//			f = new PrintWriter(new CaesarWriter(new FileWriter("CaesarText.txt"), 150));
//			f.println("Diese Zeile wird schön groß geschrieben");
//			// f.write('a'); // Test von write(int)
//			// f.println();
//			// f.println(); // Zeilenvorschub
//			f.close();
//		} catch (IOException e) {
//			System.out.println("Fehler beim Erstellen der Datei");
//		}
//	}
}
