package myUtil;


public class Node {
	Object val; // contains nodes of any kind
	Node next;

	// >>>>>>>>>> constructors <<<<<<<<<<<<<<<

	public Node(Object val, Node n) {
		this.val = val;
		this.next = n;
	}

	public Node() {
		this.val = null;
		this.next = null;
	}

	// --------------- public methods

	public void setValue(Object val) {
		this.val = val;
	}

	public String toString() {
		return "" + val;
	}

	public Object getValue() {
		return val;
	}

	public void setNext(Node n) {
		this.next = n;
	}

	public Node getNext() {
		return next;
	}

}
