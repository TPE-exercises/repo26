package uebung03_aufgabe1;

public interface Stack {
	/**
	 * Stack new element in Stack
	 * @param element
	 * @param list
	 */
	void enter(int element);
	
	/**
	 * Leave first Element (return and delete)
	 * @param list
	 * @return Stack
	 */
	Node leave();
	
	/**
	 * return first elements in Stack (not delete)
	 * @param list
	 * @return
	 */
	int front();
	
	/**
	 * Creates new Stack
	 * @return
	 */
	Stack emptyStack();
	
	/**
	 * 
	 * @param list
	 * @return true when Stack empty
	 */
	boolean isEmpty();
	
	/**
	 * retru size of Stack
	 * @param list
	 * @return
	 */
	int size();
}
