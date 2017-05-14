package myUtil;

/**
 * Own Exception Class for Underflows in Stack or Queue
 * @author lange
 *
 */
public class UnderflowException extends Exception {

	// Konstruktor unserer eigenen Exception
	UnderflowException() {
		// Aufruf des übergeordneten Konstruktors mit dem zu
		// erscheinenden Fehlertext
		super("No Objects!");

	}

}
