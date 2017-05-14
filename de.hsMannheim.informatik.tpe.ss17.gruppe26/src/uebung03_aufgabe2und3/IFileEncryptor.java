package uebung03_aufgabe2und3;

import java.io.File;

public interface IFileEncryptor {

	/**
	 * checks sourceDirectory, if it is a directory, that method creates new
	 * folder(s) and encrypt them files
	 * 
	 * @param sourceDirectory
	 * @return null, if the sourceDirectory is not a folder
	 */
	public File encrypt(File sourceDirectory);

	/**
	 * checks sourceDirectory, if it is a directory, that method creates new
	 * folder(s) and decrypt them files
	 * 
	 * @param sourceDirectory
	 * @return null, if the sourceDirectory is not a folder
	 */
	public File decrypt(File sourceDirectory);

}
