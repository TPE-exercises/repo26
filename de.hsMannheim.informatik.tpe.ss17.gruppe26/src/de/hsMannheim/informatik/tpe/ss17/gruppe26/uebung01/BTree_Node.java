package de.hsMannheim.informatik.tpe.ss17.gruppe26.uebung01;

public class BTree_Node {

	private int m;
	private Integer[] integerArray;
	private BTree_Node[] bTreeNodeArray;

	/**
	 * Ordnung ist festgelegt auf 1
	 */
	public BTree_Node() {
		this(1);
		System.out.println("Constructor 0 Class BTree_Node");
	}

	/**
	 * 
	 * @param Integer[]
	 *            value
	 * @param BTree_Node[]
	 *            bTreeNode
	 */
	public BTree_Node(int m) {

		Integer[] integerArray = new Integer[2 * m + 1];
		BTree_Node[] bTreeNodeArray = new BTree_Node[2 * m + 2];

		this.m = m;
		this.integerArray = integerArray;
		this.bTreeNodeArray = bTreeNodeArray;
		System.out.println("Constructor 1 Class BTree_Node [m=" + m + "]");
	}

	// /**
	// *
	// * @param int
	// * ordnung des Baumes
	// * @param Integer
	// * Restparameter
	// */
	// public BTree_Node(int m, Integer... o) {
	//
	// Integer[] value = new Integer[2 * m + 1];
	// BTree_Node[] bTreeNode = new BTree_Node[2 * m + 1];
	//
	// for (int i = 0; i < o.length; i++) {
	// value[i] = o[i];
	// }
	// this.integerArray = value;
	// this.bTreeNodeArray = bTreeNode;
	//
	// System.out.println("Constructor 2 Class BTree_Node");
	// }

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
	public BTree_Node getNode(int index) {
		return this.bTreeNodeArray[index];
	}

	/**
	 * 
	 * @param node
	 * @param index
	 */
	public void setNode(BTree_Node node, int index) {
		this.bTreeNodeArray[index] = node;
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
		}
		// mache position frei
		integerArray[index] = null;
		// prüfe ob node nun voll ist
		if (integerArray[2 * this.m] != null) {
			System.out.println("***Debug: moveForward hat die Node zum Platzen gebracht");
			return true;
		}
		return false;

	}

	public int getIndexForO(Integer o) {

		int index = 0;
		while (0 > integerArray[index]) {
			index++;
		}

		return index;
	}

	/**
	 * clone
	 * 
	 * @return BTree_Node clone
	 */
	public BTree_Node clone() {
		BTree_Node clone = new BTree_Node(this.m);

		for (int i = 0; i < this.integerArray.length; i++) {
			clone.setValue(this.getValue(i), i);
			clone.setNode(this.getNode(i), i);
		}

		return clone;

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