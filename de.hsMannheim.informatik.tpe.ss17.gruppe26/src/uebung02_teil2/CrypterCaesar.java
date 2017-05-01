package uebung02_teil2;

public class CrypterCaesar implements Crypter {

	private int moveTo;

	CrypterCaesar(int moveTo) {
		this.moveTo = moveTo % 26;
	}

	/**
	 * change small characters zu big ones and move to another position
	 */
	@Override
	public String encrypt(String message) {
		String cypherText = "";
		if (moveTo >= 0) {
			for (int i = 0; i <= message.length() - 1; i++) {
				int cypherChar = message.charAt(i) - 32 + moveTo;
				if (cypherChar > 90)
					cypherChar-=26;
				cypherText = cypherText + (char) cypherChar;
			}
		}
		
		else {
			for (int i = 0; i <= message.length() - 1; i++) {
				int cypherChar = message.charAt(i) - 32 + moveTo;
				if (cypherChar > 90)
					cypherChar-=26;
				cypherText = cypherText + (char) cypherChar;
			}
		}

		return cypherText;
	}

	/**
	 * change big characters zu small ones and move to another position
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
