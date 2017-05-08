package uebung03_aufgabe1;

public class UnderflowException extends Exception {

	// Konstruktor unserer eigenen Exception
	UnderflowException() {
		// Aufruf des übergeordneten Konstruktors mit dem zu
		// erscheinenden Fehlertext
		super("No Objects!");

	}

}
