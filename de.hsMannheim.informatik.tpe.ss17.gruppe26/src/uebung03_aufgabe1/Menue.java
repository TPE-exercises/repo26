package uebung03_aufgabe1;

import myUtil.ADT;
import myUtil.Node;
import myUtil.QueueArray;
import myUtil.QueueList;
import myUtil.StackArray;
import myUtil.StackList;

public class Menue {

	private static final ADT s1 = new StackList();
	private static final ADT s2 = new StackArray();
	private static final ADT q1 = new QueueList();
	private static final ADT q2 = new QueueArray();

	public static void main(String[] args) throws Exception {

			enter(q2, new Integer(0));
			enter(q2, new Integer(1));
			enter(q2, new Integer(2));
			enter(q2, new Integer(3));
			enter(q2, new Integer(4));
			enter(q2, new Integer(5));
			
			enter(q1, new Integer(0));
			enter(q1, new Integer(1));
			enter(q1, new Integer(2));
			enter(q1, new Integer(3));
			enter(q1, new Integer(4));
			enter(q1, new Integer(5));
			
			enter(s1, new Integer(0));
			enter(s1, new Integer(1));
			enter(s1, new Integer(2));
			enter(s1, new Integer(3));
			enter(s1, new Integer(4));
			enter(s1, new Integer(5));
			
			enter(q2, new Integer(0));
			enter(q2, new Integer(1));
			enter(q2, new Integer(2));
			enter(q2, new Integer(3));
			enter(q2, new Integer(4));
			enter(q2, new Integer(5));


		System.out.println(q2.toString(null));
		System.out.println("-.-´");

	}

	private static void enter(ADT adt, Object element) throws Exception {
		adt.enter(element);
	}

	private static Object leave(ADT adt) throws Exception {
		return adt.leave();
	}

	private static Object front(ADT adt) {
		return adt.front();
	}

	private static boolean isEmpty(ADT adt) {
		return adt.isEmpty();
	}

	private static int size(ADT adt) {
		return adt.size();
	}

	public static String toString(ADT adt, Node node) {
		return adt.toString(node);
	}

}
