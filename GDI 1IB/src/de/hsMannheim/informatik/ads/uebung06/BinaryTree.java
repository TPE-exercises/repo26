package de.hsMannheim.informatik.ads.uebung06;

public interface BinaryTree {

	/**
	 * Fugt val in den Baum ein.
	 */
	boolean insert(int val);

	/**
	 * Fugt die int-Werte, die in der Datei stehen in den Baum ein.
	 */
	boolean insert(String filename);

	/**
	 * Testet, ob val im Baum vorhanden ist.
	 */
	boolean contains(int val);

	/**
	 * Ermittelt die Anzahl der Knoten im Baum.
	 */
	int size();

	/**
	 * Ermittelt die Höhe des Baums.
	 */
	int height();

	/**
	 * Liefert das größte Element im Baum.
	 */
	int getMax();

	/**
	 * Liefert das kleinste Element im Baum.
	 */
	int getMin();

	/**
	 * Entfernt val aus dem Baum.
	 */
	boolean remove(int val);

	/**
	 * true genau dann, wenn der Baum leer ist.
	 */
	boolean isEmpty();

	/**
	 * Fugt alle Elemente des übergebenen Baums (otherTree) in den aktuellen Baum ein.
	 */
	addAll(BinaryTree otherTree);

	/**
	 * Gibt Baum in Inorder aus.
	 */
	void printInorder();

	/**
	 * Gibt Baum in Postorder aus.
	 */
	void printPostorder();

	/**
	 * Gibt Baum in Preorder aus.
	 */
	void printPreorder();

	/**
	 * Gibt Baum in Levelorder aus.
	 */
	void printLevelorder();

	/**
	 * Erzeugt eine tiefe Kopie des Baums.
	 */
	BinaryTree clone();
}
