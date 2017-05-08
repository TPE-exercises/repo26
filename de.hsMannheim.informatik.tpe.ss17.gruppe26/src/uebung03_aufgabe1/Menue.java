package uebung03_aufgabe1;

public class Menue {

	public static void main(String[] args) {
		
//		Stack stack = new MyStack();
		Queue stack = new QueueList(3);
		
		System.out.println(stack.enter(new Integer(4)));
		System.out.println(stack.enter(new Integer(5)));
		System.out.println(stack.enter(new Integer(6)));
		
		System.out.println("front: " + stack.front());
		
		System.out.println("size: " + stack.size());
		
		stack.leave();
		
		System.out.println("front: " + stack.front());
		
		System.out.println("isEmpty: "+stack.isEmpty());
		
		stack.leave();
		stack.leave();
		
		System.out.println("isEmpty: "+stack.isEmpty());
		System.out.println("front: " + stack.front());
		
		System.out.println("size: " + stack.size());

	}

}
