package de.hsMannheim.informatik.tpe.ss17.gruppe26.uebung01;

public class BTree implements BTree_Interface {

	public int m;
	private BTree_Node root;

	BTree() {
		this.setRoot(null);
		this.m = 1;
		System.out.println("Construktor 0 Class BTree");
	}

	BTree(int ordnung) {
		this();
		this.m = ordnung;
		System.out.println("Construktor 1 Class BTree [m=" + m + "]");
	}

	public void printM() {

	}

	@Override
	public boolean insert(Integer o) {

		if (this.contains(o)) {
			System.out.println("F�ge " + o + " nicht ein.");
			return false;
		}

		if (getRoot() == null) {
			BTree_Node node = new BTree_Node(this.m);
			node.setValue(o, 0);
			setRoot(node);
			return true;
		} else {
			return this.rec_insert(o, getRoot(), 0);
		}

		// 3. burst?

	}

	/**
	 * @TODO testen
	 * @param Integer
	 *            o
	 * @param BTree_Node
	 *            node
	 * @param int
	 *            index
	 * @return boolean
	 */
	private boolean rec_insert(Integer o, BTree_Node node, int index) {
		// TODO Linken Pfad einf�gen klappt aber rechter kommt nich in child
		if (node.getValue(index) == null) {
			node.setValue(o, index);
			return true;
		} else if (o < node.getValue(index)) {
			if (node.getNode(index) != null) {
				return rec_insert(o, node.getNode(index), 0);
			} else {
				node.moveForward(index, this.m);
				node.setValue(o, index);
				// TODO verkn�pungen anh�ngen
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
	public void burst(BTree_Node node, BTree_Node parent) {
		// Hilfsvariablen
		int m1 = 2 * m + 1;
		int mid = m1 / 2;

		// Platze node
		Integer newParent = new Integer(node.getValue(mid));
		BTree_Node n1 = new BTree_Node(this.m);
		BTree_Node n2 = new BTree_Node(this.m);

		int i = 0, j = 0;
		// Belege n1
		while (i < mid) {
			n1.setValue(node.getValue(i), i);
			n1.setNode(node.getNode(i), i);
			i++;
		}
		n1.setNode(node.getNode(i), i);
		i++;
		// Belege n2
		while (i < m1) {
			n2.setValue(node.getValue(i), j);
			n2.setNode(node.getNode(i), j);
			j++;
			i++;
		}
		n2.setNode(node.getNode(i), j);

		// bringe alles an die richtige stelle
		int index = 0;
		if (this.getRoot() == parent) {
			BTree_Node newRoot = new BTree_Node(this.m);
			newRoot.setValue(newParent, index);
			newRoot.setNode(n1, index);
			newRoot.setNode(n2, index + 1);
			setRoot(newRoot);
		} else {
			index = parent.getIndexForO(newParent);
			parent.moveForward(index, this.m);
			parent.setValue(newParent, index);
			parent.setNode(n1, index);
			parent.setNode(n2, index + 1);
		}

	}

	@Override
	public boolean contains(Integer o) {
		if (isEmpty())
			return false;
		return this.rec_contains(o, getRoot(), 0);

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
			return false;
		} else if (o == node.getValue(index)) {
			return true;
		} else if (o.intValue() < node.getValue(index)) {
			if (node.getNode(index) != null) {
				return rec_contains(o, node.getNode(index), 0);
			} else
				return false;
		} else /* (o.intValue() > node.getValue(index)) */ {
			if (index < 2 * this.m) {
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
		return this.getRoot() == null ? true : false;
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

	public BTree_Node getRoot() {
		return root;
	}

	public void setRoot(BTree_Node root) {
		this.root = root;
	}

}