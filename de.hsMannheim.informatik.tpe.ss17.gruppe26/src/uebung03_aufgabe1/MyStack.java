package uebung03_aufgabe1;

public class MyStack implements Stack {

	private Node head;

	MyStack() {
		head = null;
	}

	@Override
	public void enter(int element) {
		Node node = new Node(element, null);
		if (this.head == null)
			this.head = node;
		else{
			node.setNext(this.head);
			this.head=node;
		}
	}

	@Override
	public Node leave() {
		Node oldHead = this.head;
		this.head=this.head.getNext();
		return oldHead;
	}

	@Override
	public int front() {
		return (int) this.head.getValue();
	}

	@Override
	public Stack emptyStack() {
		return new MyStack();
	}

	@Override
	public boolean isEmpty() {
		if (head == null)
			return true;
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

}
