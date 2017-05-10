package myUtil;

public class OverflowException extends Exception {


	OverflowException(String s, Object element) {
		super(s + element);
	}
	

//		super("Too many Objects, array size doubles!");
	
}
