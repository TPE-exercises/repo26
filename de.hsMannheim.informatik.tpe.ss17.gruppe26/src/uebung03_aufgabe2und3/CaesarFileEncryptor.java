package uebung03_aufgabe2und3;

//import static gdi.MakeItSimple.*;
import java.io.*;

public class CaesarFileEncryptor implements IFileEncryptor {

	
	int moveTo;

	CaesarFileEncryptor(int moveTo) {
		this.moveTo = moveTo;
	}

	@Override
	public File encrypt(File sourceDirectory) throws IsNoFolderException {

		if (sourceDirectory.isDirectory()) {
			File destinationDirectory = new File(sourceDirectory + "_encrypted");
			if (destinationDirectory.exists()) {
				for (int i = 1; destinationDirectory.exists(); i++) {
					destinationDirectory = new File(sourceDirectory + "_encrypted(" + i + ")");
				}
			}
			destinationDirectory.mkdir();
			encryptRecursive(sourceDirectory, destinationDirectory);
			return destinationDirectory;

		} else {
			throw new IsNoFolderException("Der angegebene Pfad ist kein Ordner!");
		}
	}

	@Override
	public File decrypt(File sourceDirectory) throws IsNoFolderException {
		if (sourceDirectory.isDirectory()) {
			File destinationDirectory = new File(sourceDirectory + "_decrypted");
			if (destinationDirectory.exists()) {
				for (int i = 1; destinationDirectory.exists(); i++) {
					destinationDirectory = new File(sourceDirectory + "_decrypted(" + i + ")");
				}
			}
			destinationDirectory.mkdir();
			decryptRecursive(sourceDirectory, destinationDirectory);
			return destinationDirectory;

		} else {
			throw new IsNoFolderException("Der angegebene Pfad ist kein Ordner!");
		}
	}

	/**
	 * check folder, if there are more files or folders if there are files,
	 * create new files in destination folder and encrypt them with CaesarReader
	 * if there are folders, check them for more files or folders by running
	 * this method recursive
	 * 
	 * @param sourceDirectory
	 * @param destinationDirectory
	 */
	public void encryptRecursive(File sourceDirectory, File destinationDirectory) {

		File[] fileArray = sourceDirectory.listFiles();

		if (fileArray != null) {
			for (int i = 0; i < fileArray.length; i++) {
				if (fileArray[i].isDirectory()) {
					destinationDirectory = new File(destinationDirectory + "//" + fileArray[i].getName());
					destinationDirectory.mkdir();
					encryptRecursive(fileArray[i], destinationDirectory);
				} else {
					FileReader sourceFile;
					PrintWriter destinationFile;
					int c;
					try {
						destinationFile = new PrintWriter(new CaesarWriter(
								new FileWriter(destinationDirectory + "//" + fileArray[i].getName()), this.moveTo));
						sourceFile = new FileReader(fileArray[i]);
						while ((c = sourceFile.read()) != -1) {
							destinationFile.write(c);
						}
						sourceFile.close();
						destinationFile.close();
					} catch (IOException e) {
						System.out.println("Fehler beim Lesen oder Erstellen der Datei");
						e.printStackTrace();
					}
				}
			}
		}
	}

	/**
	 * check folder, if there are more files or folders if there are files,
	 * create new files in destination folder and decrypt them with CaesarReader
	 * if there are folders, check them for more files or folders by running
	 * this method recursive
	 * 
	 * @param sourceDirectory
	 * @param destinationDirectory
	 */
	private void decryptRecursive(File sourceDirectory, File destinationDirectory) {

		File[] fileArray = sourceDirectory.listFiles();

		if (fileArray != null) {
			for (int i = 0; i < fileArray.length; i++) {
				if (fileArray[i].isDirectory()) {
					destinationDirectory = new File(destinationDirectory + "//" + fileArray[i].getName());
					destinationDirectory.mkdir();
					encryptRecursive(fileArray[i], destinationDirectory);
				} else {
					Reader sourceFile;
					PrintWriter destinationFile;
					int c;
					try {
						sourceFile = new CaesarReader(new FileReader(fileArray[i]), this.moveTo);
						destinationFile = new PrintWriter(
								new FileWriter(destinationDirectory + "//" + fileArray[i].getName()));
						while ((c = sourceFile.read()) != -1) {
							destinationFile.write(c);
						}
						sourceFile.close();
						destinationFile.close();
					} catch (IOException e) {
						System.out.println("Fehler beim Lesen oder Erstellen der Datei");
						e.printStackTrace();
					}
				}
			}
		}
	}

	// public static void main(String[] args) {
	// System.out.print("Bitte geben Sie einen Ordner an: ");
	// String pfadangabe = readLine();
	// System.out.print("Um wie viel Zeichen möchten Sie verschieben?");
	// IFileEncryptor neu = new CaesarFileEncryptor(readInt());
	// File sourceFile = new File(pfadangabe);
	// File encryptedFile = neu.encrypt(sourceFile);
	// System.out.println("Der neue Ordner heißt nun: " + encryptedFile);
	// System.out.println("[ENDE]");
	// }
}