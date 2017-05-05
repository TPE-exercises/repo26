package uebung03_aufgabe1;

public class MyQueue implements Queue{
	
	
	private Node head;

	MyQueue() {
		head = null;
	}
	
	public Node getHead(){
		return this.head;
	}

	@Override
	public void enter(int element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Node leave() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int front() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Queue emptyQueue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
