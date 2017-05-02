package uebung02_teil2_aufgabe1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestCrypting {

	@Test
	public void encryption() {
		Crypter caesarLetters = new CrypterCaesar(0);
		assertEquals("abc: ", "ABC", caesarLetters.encrypt("abc"));
		assertEquals("qwertzuiop: ", "QWERTZUIOP", caesarLetters.encrypt("qwertzuiop"));
		caesarLetters = new CrypterCaesar(1);
		assertEquals("abc: ", "BCD", caesarLetters.encrypt("abc"));
	}
	
	@Test
	public void decryption() {
		Crypter caesarLetters = new CrypterCaesar(0);
		assertEquals("ABC: ", "abc", caesarLetters.decrypt("ABC"));
		assertEquals("QWERTZUIOP: ", "qwertzuiop", caesarLetters.decrypt("QWERTZUIOP"));
	}
	
}
