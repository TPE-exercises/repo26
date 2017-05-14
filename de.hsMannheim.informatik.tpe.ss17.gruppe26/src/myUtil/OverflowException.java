package myUtil;

/**
 * Own Exception Class for Overflows in Stack or Queue
 * @author lange
 *
 */
public class OverflowException extends Exception {


	OverflowException(String s, Object element) {
		super(s + element);
	}
	
}
