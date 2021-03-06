package myUtil;

public interface Stack {
	Node getHead();
	/**
	 * eigentlich push
	 * Stack new element in Stack
	 * @param element
	 * @param list
	 */
	void enter(Object element) throws Exception;
	
	/**
	 * eigentlich pop
	 * Leave first Element (return and delete)
	 * @param list
	 * @return Stack
	 */
	Object leave()throws Exception;
	
	/**
	 * return first elements in Stack (not delete)
	 * @param list
	 * @return
	 */
	Object front();
	
//	/**
//	 * Creates new Stack
//	 * @return
//	 */
//	Stack emptyStack(int maxSize);
	
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
