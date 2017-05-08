package uebung03_aufgabe1;



public class Menue {

	private static final ADT stack = new StackList();
	private static final ADT queue = new QueueList();
	
	public static void main(String[] args) throws Exception {
		
		
		
		Stack stack = new StackList(2);
//		Queue stack = new QueueList(4);
		
		stack.enter("a");
		stack.enter("b");

		stack.leave();
		stack.leave();
		stack.leave();


		
		System.out.println("front: " + stack.front());
		
		System.out.println("size: " + stack.size());
		
		stack.leave();
		
		System.out.println("front: " + stack.front());
		
		System.out.println("isEmpty: "+stack.isEmpty());

		
		System.out.println("isEmpty: "+stack.isEmpty());
		System.out.println("front: " + stack.front());
		
		System.out.println("size: " + stack.size());

	}
	
//	public static void sortiere(Sort1 s, Comparable[] array){
//		System.out.println("Unsortiert:");
//		printArray(array);
//		s.sort(array);
//		printArray(array);
//	}

}
