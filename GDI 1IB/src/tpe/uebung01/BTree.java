package tpe.uebung01;



public class BTree implements BTree_Interface {

	public static int m;
	private BTree_Node root;

	BTree(int ordnung) {
		this.root = null;
	}

	@Override
	public boolean insert(Integer o) {
		if (this.contains(o))
			return false;

		if (root == null) {
			BTree_Node node = new BTree_Node(o);
			root = node;
			return true;
		} else
			return rec_insert(o, root, 0);

		// 3. burst?

	}

	/**
	 * @TODO testen
	 * @param Integer o
	 * @param BTree_Node node
	 * @param int index
	 * @return boolean
	 */
	private boolean rec_insert(Integer o, BTree_Node node, int index) {
		if (node.getValue(index) == 0) {
			node.setValue(o, index);
			return true;
		} else if (o < node.getValue(index)) {
			if (node.getNode(index) != null) {
				return rec_insert(o, node.getNode(index), 0);
			} else {
				node.moveForward(index);
				node.setValue(o, index);
				// TODO verknüpungen anhängen
				return true;
			}
		} else/* (o>node.getValue(index)) */ {
			return rec_insert(o, node, index + 1);
		}
	}

	@Override
	public boolean insert(String filename) {
		// Schleife -> insert
		return false;
	}

	/**
	 * 
	 */
	private void burst(BTree_Node node, BTree_Node parent) {
		int mid = (2*m+1)/2;
		
		
		
	}

	@Override
	public boolean contains(Integer o) {
		if (isEmpty())
			return false;
		return rec_contains(o, root, 0);

	}

	/**
	 * 
	 * @param o
	 * @param node
	 * @param index
	 * @return
	 */
	private boolean rec_contains(Integer o, BTree_Node node, int index) {
		if (node.getValue(index) == null) {
			System.out.println("test");
			return true;
		} else if (o == node.getValue(index)) {
			return true;
		} else if (o.intValue() < node.getValue(index)) {
			if (node.getNode(index) != null) {
				return rec_contains(o, node.getNode(index), 0);
			} else
				return false;
		}else 	/* (o.intValue() > node.getValue(index))*/{
			if (index < 2 * getM()) {
				return rec_contains(o, node, ++index);
			} else
				return false;
		}

	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int height() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Integer getMax() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getMin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void addAll(BTree_Interface otherTree) {
		// TODO Auto-generated method stub

	}

	public BTree clone() {
		return null;

	}

	@Override
	public void printInorder() {
		// TODO Auto-generated method stub

	}

	@Override
	public void printPostorder() {
		// TODO Auto-generated method stub

	}

	@Override
	public void printPreorder() {
		// TODO Auto-generated method stub

	}

	@Override
	public void printLevelorder() {
		// TODO Auto-generated method stub

	}

	public int getM() {
		return m;
	}

	public void setM(int m) {
		this.m = m;
	}

}
