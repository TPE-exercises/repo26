package uebung03_aufgabe1;

interface Queue{
	Node getHead();
	/**
	 * Enter new element in Queue
	 * @param element
	 * @param list
	 * @return 
	 */
	void enter(Object element) throws Exception;
	
	/**
	 * Leave first Element (return and delete)
	 * @param list
	 * @return ListNode
	 */
	Node leave()throws Exception;
	
	/**
	 * return first elements in Queue (not delete)
	 * @param list
	 * @return
	 */
	Object front();
	
//	/**
//	 * Creates new Queue
//	 * @return
//	 */
//	Queue emptyQueue(int maxSize);
	
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
