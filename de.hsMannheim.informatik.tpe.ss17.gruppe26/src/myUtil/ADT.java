package myUtil;

public interface ADT {

	
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
		Object leave()throws Exception;
		
		/**
		 * return first elements in Queue (not delete)
		 * @param list
		 * @return
		 */
		Object front();
		
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
		
		String toString(Node node);

		Node getHead();
	

}
