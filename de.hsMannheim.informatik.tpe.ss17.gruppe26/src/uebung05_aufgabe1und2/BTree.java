package uebung05_aufgabe1und2;

public interface BTree {


	/**
	 * inserts number of Integer o in BTree
	 * @param o
	 * @return
	 */
	boolean insert (Integer o);
	
	/**
	 * inserts elemets from file in BTree
	 * @param filename
	 * @return
	 */
	boolean insert (String filename);
	
	/**
	 * check if element is in BTree
	 * @param o
	 * @return
	 */
	boolean contains (Integer o);
	
	/**
	 * return count of BTree
	 * @return
	 */
	int size();
	
	/**
	 * return height of BTree
	 * @return
	 */
	int height();
	
	/**
	 * return max Element
	 * @return null, if it does not work
	 */
	Integer getMax();
	
	/**
	 * return min Element
	 * @return null, if tree is empty
	 */
	Integer getMin();
	
	/**
	 * check if BTree is empty
	 * @return
	 */
	boolean isEmpty();
	
	/**
	 * inserts all elements from otherTree to BTree
	 * @param otherTree
	 * @return boolean, because using it to check, if it's work
	 */
	boolean addAll(BTree otherTree);
	
	/**
	 * create deep clone
	 * @return
	 */
	BTree clone();
	
	/**
	 * removes Integer
	 * @param o
	 * @return
	 */
	boolean remove (Integer o);
	
	/**
	 * @return 
	 * prints numbers in natural order
	 */
	void printInorder();

	/**
	 * prints at first the lowest children of the left parttree, then the
	 * children of the right
	 */
	void printPostorder();

	/**
	 * prints at first the root, then the left child, childs child,... and then
	 * the other child of the lowest parent, after that of the other ones
	 */
	void printPreorder();

	/**
	 * prints nodes of tree level per level
	 */
	void printLevelorder();

}