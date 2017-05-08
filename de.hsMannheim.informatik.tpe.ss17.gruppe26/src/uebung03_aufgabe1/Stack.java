package uebung03_aufgabe1;

public interface Stack {
	/**
	 * Stack new element in Stack
	 * @param element
	 * @param list
	 */
	boolean enter(int element);
	
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
	Stack emptyStack(int maxSize);
	
	/**
	 * 
	 * @param list
	 * @return true when Stack empty
	 */
	boolean isEmpty();
	
	/**
	 * return size of Stack
	 * @param list
	 * @return
	 */
	int size();
}
