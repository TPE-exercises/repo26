package uebung03_aufgabe1;

public class OverflowException extends Exception {

	// Konstruktor unserer eigenen Exception
	OverflowException(Object element) {
		// Aufruf des übergeordneten Konstruktors mit dem zu
		// erscheinenden Fehlertext
		super("Too many Objects: " + element);

	}
}
