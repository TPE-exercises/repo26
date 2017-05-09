package uebung03_aufgabe1;

public class StackList implements Stack, ADT {

	private Node head;
	private int maxSize;

	StackList(int maxSize) {
		head = null;
		this.maxSize = maxSize;
	}

	public StackList() {
		this(5);
	}
	
	public Node getHead(){
		return this.head;
	}

	@Override
	public void enter(Object element) throws Exception {
		QueueList hQueue = new QueueList();
		hQueue.setHead(this.head);
		if (hQueue.size() < this.maxSize) {
			Node node = new Node(element, null);
			if (this.head == null)
				this.head = node;
			else {
				node.setNext(this.head);
				this.head = node;
			}

		} else

			throw new OverflowException(element);

	}

	@Override
	public Node leave() throws Exception {
		if (this.head != null) {
			Node oldHead = this.head;
			this.head = this.head.getNext();
			return oldHead;
		} else

			throw new UnderflowException();
	}

	@Override
	public Object front() {
		try {
			return this.head.getValue();
		} catch (NullPointerException ex) {
			System.out.print("Es existiert kein Element im Stack! -> ");
			return 0;
		}
	}

	@Override
	public Stack emptyStack(int maxSize) {
		return new StackList(maxSize);
	}

	@Override
	public boolean isEmpty() {
		if (head == null)
			return true;
		return false;
	}

	@Override
	public int size() {
		int size = 0;
		Node node = this.head;
		while (node != null) {
			size++;
			if (node.getNext() != null)
				node = node.getNext();
			else
				node = null;
		}
		return size;
	}

	@Override
	public String toString(Node node) {
		String string = "";
		if (node != null) {
			string += "El: " + node.getValue();
			if (node.getNext() != null) {
				string += "--->";
				string += this.toString(node.getNext());
				string += "<---";
			}
		}
		return string;
	}

}
