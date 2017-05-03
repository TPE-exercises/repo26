package uebung02_teil2_aufgabe1;

public class CrypterCaesar implements Crypter {

	private int moveTo;

	CrypterCaesar(int moveTo) {
		moveTo = moveTo % 26;
		if (moveTo < 0)
			moveTo = 26 + moveTo;
		this.moveTo = moveTo;
	}

	/**
	 * change small characters to big ones and move to another position
	 */
	@Override
	public String encrypt(String message) {
		String cypherText = "";

			for (int i = 0; i <= message.length() - 1; i++) {
				int cypherChar = message.charAt(i) - 32 + moveTo;
				if (cypherChar > 90)
					cypherChar-=26;
				cypherText = cypherText + (char) cypherChar;
			}

		return cypherText;
	}

	/**
	 * change big characters to small ones and move to another position
	 */
	@Override
	public String decrypt(String cypherText) {
		String message = "";

		for (int i = 0; i <= cypherText.length() - 1; i++) {
			message = message + (char) (cypherText.charAt(i) + 32 - moveTo);
		}

		return message;
	}

}
