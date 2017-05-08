package uebung03_aufgabe2und3;

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
	 * Ä = 196, Ö = 214, Ü = 220, ä = 228, ö = 246, ü = 252 // laut JAVA (Eclipse)
	 * 
	 * @param c
	 * @return
	 */
	public boolean isInAlphabet(int c) {
		if (c >= 65 && c <= 90)
			return true;
		if (c >= 97 && c <= 122)
			return true;
		if (c == 196 || c == 214 || c == 220)
			return true;
		if (c == 228 || c == 246 || c == 252)
			return true;
		return false;
	}

	public int moveToAlphabet(int c) {
		for (int i = 0; i < moveTo; i++) {
			c++;
			if (c == (int) 'Z')
				c = (int) 'a';
			if (c == (int) 'z' +1)
				c = (int) 'Ä';
			if (c == (int) 'Ä' + 1)
				c = (int) 'Ö';
			if (c == (int) 'Ö' + 1)
				c = (int) 'Ü';
			if (c == (int) 'Ü' + 1)
				c = (int) 'ä';
			if (c == (int) 'ä' +1)
				c = (int) 'ö';
			if (c == (int) 'ö' + 1)
				c = (int) 'ü';
			if (c == (int) 'ü' + 1)
				c = (int) 'A';
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

	public static void main(String[] args) {
		PrintWriter f;
		try {
			f = new PrintWriter(new CaesarWriter(new FileWriter("CaesarText.txt"), 1));
			f.println("ÄÖÜäöü");
			// f.write('a'); // Test von write(int)
			// f.println();
			// f.println(); // Zeilenvorschub
			f.close();
		} catch (IOException e) {
			System.out.println("Fehler beim Erstellen der Datei");
		}
	}
}
