package uebung02_teil2_aufgabe1;

public class CrypterReverse implements Crypter {

	 public String encrypt(String message) {
		String cypherText = "";
		for (int i = 0; i <= message.length()-1;i++){
			cypherText = message.charAt(i) + cypherText;
		}
		return cypherText;
	}

	/**
	 * This method is doing the same as "encrypt",
	 * because that we just have to call the "encrypt" method
	 */
	@Override
	public String decrypt(String cypherText) {
		return encrypt(cypherText);
	}

}
