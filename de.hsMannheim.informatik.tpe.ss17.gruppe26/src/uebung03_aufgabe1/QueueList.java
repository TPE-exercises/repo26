package uebung03_aufgabe1;

public class QueueList implements Queue, ADT {

	private Node head;
	private int maxSize;

	QueueList() {
		this(5);
	}

	QueueList(int maxSize) {
		head = null;
		this.maxSize = maxSize;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	@Override
	public void enter(Object element) throws Exception {

		QueueList hQueue = new QueueList();
		hQueue.setHead(this.head);
		if (hQueue.size() < this.maxSize) {
			Node node = this.head;
			if (node == null) {
				this.head = new Node(element, null);
			return;
			}

			while (node.getNext() != null) {
				node = node.getNext();
			}
			node.setNext(new Node(element, null));
		
		}else
			throw new OverflowException(element);
	
	}

	@Override
	public Node leave() throws Exception {
		Node first = null;
		if (head != null) {
			first = this.head;
			if (head.getNext() != null)
				this.head = this.head.getNext();
			else
				this.head = null;
			return first;
		}
		else
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
	public Queue emptyQueue(int maxSize) {
		return new QueueList(maxSize);
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

}
