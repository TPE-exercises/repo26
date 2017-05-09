package uebung03_aufgabe1;

public class Menue {

	private static final ADT s1 = new StackList();
	private static final ADT s2 = new StackArray();
	private static final ADT q1 = new QueueList();
	private static final ADT q2 = new QueueArray();

	public static void main(String[] args) throws Exception {

		enter(s2, new Integer(0));
		enter(s2, new Integer(1));
		leave(s2);
		leave(s2);

		// System.out.println(s2.toString(null));

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
