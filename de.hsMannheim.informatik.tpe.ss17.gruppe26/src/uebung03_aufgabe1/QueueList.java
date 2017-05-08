package uebung03_aufgabe1;

public class QueueList implements Queue {

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
	public boolean enter(int element) {

		QueueList hQueue = new QueueList();
		hQueue.setHead(this.head);
		if (hQueue.size() < this.maxSize) {
			// TODO maxSize beachten!
			Node node = this.head;
			if (node == null) {
				this.head = new Node(element, null);
				return true;
			}

			while (node.getNext() != null) {
				node = node.getNext();
			}
			node.setNext(new Node(element, null));
			return true;
		}
		return false;
	}

	@Override
	public Node leave() {
		Node first = null;
		if (head != null) {
			first = this.head;
			if (head.getNext() != null)
				this.head = this.head.getNext();
			else
				this.head = null;
			return first;
		}
		return null;

	}

	@Override
	public int front() {
		try {
			return (int) this.head.getValue();
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
