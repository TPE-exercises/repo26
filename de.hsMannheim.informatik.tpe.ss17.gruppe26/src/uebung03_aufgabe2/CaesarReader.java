package uebung03_aufgabe2;

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
			c--;
			if (c == 128)
				c = 148;
			if (c == 147)
				c = 132;
			if (c == 131)
				c = 154;
			if (c == 152)
				c = 142;
			if (c == 141)
				c = 122;
			if (c == 96)
				c = 90;
			if (c == 64)
				c = 129;
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
