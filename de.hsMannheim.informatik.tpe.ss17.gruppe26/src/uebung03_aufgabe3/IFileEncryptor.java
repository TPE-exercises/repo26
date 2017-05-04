package uebung03_aufgabe3;

import java.io.File;

public interface IFileEncryptor {
	
	public File encrypt(File sourceDirectory);

	public File decrypt(File sourceDirectory);
	
}
