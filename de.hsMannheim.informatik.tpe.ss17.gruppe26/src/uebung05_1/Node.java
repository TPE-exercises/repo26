package uebung05_1;

public class Node {

	private int m;
	private Integer[] integerArray;
	private Node[] bTreeNodeChildArray;
	private Node bTreeNodeParent;

	/**
	 * Ordnung ist festgelegt auf 1
	 */
	// public Node() {
	// this(1);
	// if (MyBTree.debug)
	// System.out.println("Constructor 0 Class BTree_Node");
	// }

	/**
	 * 
	 * @param Integer[]
	 *            value
	 * @param BTree_Node[]
	 *            bTreeNode
	 */
	public Node(int m) {

		Integer[] integerArray = new Integer[2 * m + 1];
		Node[] bTreeNodeArray = new Node[2 * m + 2];
		Node bTreeNodeParent = null;

		this.m = m;
		this.integerArray = integerArray;
		this.bTreeNodeChildArray = bTreeNodeArray;
		this.bTreeNodeParent = bTreeNodeParent;
		if (MyBTree.debug)
			System.out.println("Constructor 1 Class Node [m=" + m + "]");
	}

	/**
	 * 
	 * @param index
	 * @return Integer
	 */
	public Integer getValue(int index) {
		return this.integerArray[index];
	}

	/**
	 * 
	 * @param value
	 * @param index
	 */
	public void setValue(Integer value, int index) {
		this.integerArray[index] = value;
	}

	/**
	 * 
	 * @param index
	 * @return
	 */
	public Node getNode(int index) {
		return this.bTreeNodeChildArray[index];
	}

	/**
	 * 
	 * @param node
	 * @param index
	 */
	public void setNode(Node node, int index) {
		this.bTreeNodeChildArray[index] = node;
	}

	/**
	 * 
	 * @return
	 */
	public Node getParent() {
		return this.bTreeNodeParent;
	}

	/**
	 * 
	 * @param parent
	 */
	public void setParent(Node parent) {
		this.bTreeNodeParent = parent;
	}

	/**
	 * 
	 * @return boolean
	 */
	public boolean isFull() {
		for (int i = 0; i < this.integerArray.length; i++) {
			if (this.integerArray[i] == null)
				return false;
		}
		return true;
	}

	/**
	 * move inclusive index
	 * 
	 * @param int
	 *            index
	 * @return true when last index belegt wurde
	 */
	public boolean moveForward(int index, int m) {

		// Verschiebe alle nodes [bis] index um einen nach hinten
		for (int i = 2 * m; i > index; i--) {
			this.integerArray[i] = this.integerArray[i - 1];
			this.bTreeNodeChildArray[i + 1] = this.bTreeNodeChildArray[i];
		}
		// mache position frei
		integerArray[index] = null;
		// prüfe ob node nun voll ist
		if (integerArray[2 * this.m] != null) {
			if (MyBTree.debug)
				System.out.println("***Debug: moveForward hat die Node zum Platzen gebracht");
			return true;
		}
		return false;
	}
/**
 * wird vor dem einfügen in den Parent verwendet um die richtige position zu finden ab wo geschoben werden muss
 * @param o
 * @return
 */
	public int getIndexForO(Integer o) {
		int index = 0;
		for (int i = 0; i < 2 * this.m + 1; i++) {
			if (integerArray[i] != null && o.intValue() > integerArray[i]) {
				index = i;
			} else if (integerArray[i] != null && o.intValue() < integerArray[i]) {
				return i;
			} else {
				index++;
				return index;
			}
		}
		return index;
	}

	/**
	 * clone
	 * 
	 * @return BTree_Node clone
	 */
	public Node deepClone() {
		Node newNode = new Node(this.m);
		
		//Clone elements
		for(int i = 0; i< integerArray.length; i++) {
			if(integerArray[i] != null) {
				newNode.integerArray[i] = integerArray[i];
			}
		}
		
		//clone children
		for(int i = 0; i < bTreeNodeChildArray.length; i++) {
			if(bTreeNodeChildArray[i] != null) {
				newNode.bTreeNodeChildArray[i] = bTreeNodeChildArray[i].deepClone();
			}
		}
		
		return newNode;
	}


	/**
	 * @return String
	 */
	public String toString() {
		String res = "[";

		int i = 0;
		while (i < this.integerArray.length) {
			if (this.getNode(i) != null)
				res += " -y- ";
			else
				res += " -n- ";

			if (this.getValue(i) != null)
				res += "| " + this.getValue(i) + " |";
			else
				res += "| null |";

			i++;
		}
		if (this.getNode(i) != null)
			res += " -y- ]";
		else
			res += " -n- ]";

		return res;
	}
}