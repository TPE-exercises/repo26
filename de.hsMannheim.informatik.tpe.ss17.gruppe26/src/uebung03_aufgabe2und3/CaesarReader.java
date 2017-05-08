package uebung03_aufgabe2und3;

import java.io.*;

public class CaesarReader extends FilterReader {

	int moveTo;

	protected CaesarReader(Reader arg0, int moveTo) {
		super(arg0);
		moveTo = moveTo % 58;
		if (moveTo < 0)
			moveTo = 58 + moveTo;
		this.moveTo = moveTo;
	}

	public int read() throws IOException {
		int c;
		if (moveTo % 58 == 0) {
		c =	super.read();
		} else
		c =	decrypt(super.read());
		return c;
	}

	public int decrypt(int c) {
		if (isInAlphabet(c)) {
			return moveToAlphabet(c);
		} else
			return c; // Ist Buchstabe nicht im gültigen Alphabet, bleibt es
						// unverändert
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
			c--;
			if (c == (int) 'ü' -1)
				c = (int) 'ö';
			if (c == (int) 'ö' -1)
				c = (int) 'ä';
			if (c == (int) 'ä' -1)
				c = (int) 'Ü';
			if (c == (int) 'Ü' -1)
				c = (int) 'Ö';
			if (c == (int) 'Ö' -1)
				c = (int) 'Ä';
			if (c == (int) 'Ä' -1)
				c = (int) 'z';
			if (c == (int) 'a' -1)
				c = (int) 'Z';
			if (c == (int) 'A' -1)
				c = (int) 'ü';
		}
		return c;
	}

//	public int read(char[] cbuf, int off, int len) throws IOException {
//		for (int i = 0; i < len; ++i) {
//			read(cbuf[off + i]);
//		}
//		return
//	}

//	public void read(String str, int off, int len) throws IOException {
//		read(str.toCharArray(), off, len);
//	}

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
}
