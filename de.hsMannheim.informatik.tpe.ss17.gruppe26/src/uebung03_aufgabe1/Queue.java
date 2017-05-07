package uebung03_aufgabe1;

interface Queue{
	
	/**
	 * Füge ein Element in die QUEUE ein
	 * @param element
	 * @param list
	 */
	void enter(int element, Queue list);
	
	/**
	 * Leave Element 
	 * @param list
	 */
	void leave(Queue list);
	
	int front(Queue list);
	
	Queue emptyQueue();
	
	boolean isEmpty(Queue list);
	
	int size(Queue list);
}
