package uebung03_aufgabe1;

public class StackList implements Stack {

	private Node head;

	StackList() {
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
		try{
		return (int) this.head.getValue();
		}catch(NullPointerException ex){
			System.out.print("Es existiert kein Element im Stack! -> ");
			return 0;
		}
	}

	@Override
	public Stack emptyStack() {
		return new StackList();
	}

	@Override
	public boolean isEmpty() {
		if (head == null)
			return true;
		return false;
	}

	@Override
	public int size() {
		int size=0;
		Node node = this.head;
		while(node !=null){
			size++;
			if(node.getNext()!=null)
				node=node.getNext();
			else
				node=null;
		}
		return size;
	}

}
