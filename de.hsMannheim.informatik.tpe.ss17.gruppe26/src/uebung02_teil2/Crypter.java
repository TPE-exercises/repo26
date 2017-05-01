package uebung02_teil2;

public interface Crypter {
	
	/**
	 * encrypt a message by using a specifically encryption 
	 * @param message
	 * @return
	 */
	public String encrypt(String message);

	/**
	 * decrypt an encrypted text by using a specifically decryption
	 * @param cypherText
	 * @return
	 */
	public String decrypt(String cypherText);
	
}
