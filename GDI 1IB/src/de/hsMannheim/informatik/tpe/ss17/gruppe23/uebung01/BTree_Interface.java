package de.hsMannheim.informatik.tpe.ss17.gruppe23.uebung01;

public interface BTree_Interface {

	/**
	 * inserts o in BTree
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
	 * @return
	 */
	Integer getMax();
	
	/**
	 * return min Element
	 * @return
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
	 */
	void addAll(BTree_Interface otherTree);
	
	/**
	 * create deep clone
	 * @return
	 */
	BTree clone();
	
	/**
	 * 
	 */
	void printInorder();
	
	/**
	 * 
	 */
	void printPostorder();
	
	/**
	 * 
	 */
	void printPreorder();
	
	/**
	 * 
	 */
	void printLevelorder();

}
