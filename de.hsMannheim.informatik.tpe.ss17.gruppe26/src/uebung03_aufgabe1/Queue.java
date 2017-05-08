package uebung03_aufgabe1;

interface Queue{
	
	/**
	 * Enter new element in Queue
	 * @param element
	 * @param list
	 * @return 
	 */
	boolean enter(int element);
	
	/**
	 * Leave first Element (return and delete)
	 * @param list
	 * @return ListNode
	 */
	Node leave();
	
	/**
	 * return first elements in Queue (not delete)
	 * @param list
	 * @return
	 */
	int front();
	
	/**
	 * Creates new Queue
	 * @return
	 */
	Queue emptyQueue(int maxSize);
	
	/**
	 * 
	 * @param list
	 * @return true when Queue empty
	 */
	boolean isEmpty();
	
	/**
	 * retru size of Queue
	 * @param list
	 * @return
	 */
	int size();
}
