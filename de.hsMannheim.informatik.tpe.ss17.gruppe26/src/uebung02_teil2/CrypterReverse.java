package uebung02_teil2;

public class CrypterReverse implements Crypter {

	@Override
	public String encrypt(String message) {
		String cypherText = null;
		int messageLength = message.length();
		for (int i = 0; i <= messageLength;i++){
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
