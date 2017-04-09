package de.hsMannheim.informatik.tpe.ss17.gruppe26.uebung01;

import static gdi.MakeItSimple.*;

import gdi.MakeItSimple.GDIException;

public class MyBTree implements BTree {

	public int m;
	private Node root;
	public static boolean debug = false;
	private static int difference = 0;
	private static boolean needToBurst;

	// MyBTree() {
	// this.setRoot(null);
	// this.m = 1;
	// if (debug)
	// System.out.println("Construktor 0 Class BTree");
	// }

	MyBTree(int ordnung) {
		// this();
		this.setRoot(null);
		this.m = ordnung;
		if (debug)
			System.out.println("Construktor 1 Class BTree [m=" + m + "]");
	}

	public void printM() {
		System.out.println(this.m);
	}

	@Override
	public boolean insert(Integer o) {
		needToBurst = false;
		if (debug)
			System.out.println("***Debug: Wert " + o + " soll eingefügt werden.");
		if (this.contains(o)) {
			if (debug)
				System.out.println("***Debug: Wert " + o + " ist bereits im Baum.");
			return false;
		} else if (getRoot() == null) {
			if (debug)
				System.out.println("***Debug: Wert " + o + " ist der erste Wert im Baum (neue Wurzel).");
			Node node = new Node(this.m);
			node.setValue(o, 0);
			setRoot(node);
			return true;
		} else {
			return this.rec_insert(o, getRoot(), null, 0);
		}

	}

	/**
	 * 
	 * @param o
	 * @param node
	 * @param parent
	 * @param index
	 * @return
	 */
	private boolean rec_insert(Integer o, Node node, Node parent, int index) {

		// Position ist frei
		if (node.getValue(index) == null) {
			// kein Kind an dieser Stelle -> Position richtig
			if (node.getNode(index) == null) {
				node.setValue(o, index);
				if (debug)
					System.out.println("***Debug: Ein Wert wurde eingefügt -->" + o);
				// Platze wenn index die letzte position ist
				if (index == 2 * this.m || needToBurst) {
					Node[] nodes = { node, parent };
					do {
						// child= parent
						burst(nodes);

						// belege für möglichen nächsten Burst node und parent
						// neu
						if (parent != null) {
							nodes[0] = parent;
							if (parent.getParent() != null) {
								nodes[1] = parent.getParent();
							} else
								nodes[1] = null;
						} else {
							nodes[0] = null;
							nodes[1] = null;
						}
						if (debug)
							System.out.println("***Debug: BURST!!!");
					} while (needToBurst);
				}
				return true;
			}
			// es gibt noch ein Kind!
			else {
				return rec_insert(o, node.getNode(index), node, 0);
			}
		}
		// wert ist kleiner
		else if (o < node.getValue(index)) {
			// kein Kind an dieser Stelle -> Position richtig aber
			// möglicherweise belegt
			if (node.getNode(index) == null) {
				needToBurst = node.moveForward(index, this.m);
				return rec_insert(o, node, parent, index);
			} else {
				return rec_insert(o, node.getNode(index), node, 0);
			}
		}
		// wert ist größer
		else {
			return rec_insert(o, node, parent, index + 1);
		}

	}

	@Override
	public boolean insert(String filename) throws GDIException {

		if (isFilePresent(filename)) {
			Object datei = openInputFile(filename);

			while (!isEndOfInputFile(datei)) {
				if (debug)
					System.out.println("***Debug: Datei");
				this.insert(new Integer(readInt(datei)));
			}
			closeInputFile(datei);

			return true;
		} else
			throw new GDIException("Die Datei " + filename + " konnte nicht gefunden werden.");
	}

	/**
	 * 
	 */
	private void burst(Node[] nodes) {

		if (nodes == null) {
			return;
		}

		// Hilfsvariablen
		int m1 = 2 * m + 1;
		int mid = m1 / 2;
		Node node = nodes[0];
		Node parent = nodes[1];

		// Platze node
		Integer newParent = new Integer(node.getValue(mid));
		Node n1 = new Node(this.m);
		Node n2 = new Node(this.m);

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
		if (parent == null) {
			// Erstelle neue Wurzel
			Node newRoot = new Node(this.m);
			newRoot.setValue(newParent, 0);
			setRoot(newRoot);

			// Setze Kinder
			newRoot.setNode(n1, 0);
			newRoot.setNode(n2, 1);

			// Setze Parent
			n1.setParent(newRoot);
			n2.setParent(newRoot);

			// setze kindeskinder
			for (int x = 0; x < 2 * this.m + 1; x++) {
				if (n1.getNode(x) != null)
					n1.getNode(x).setParent(n1);
				if (n2.getNode(x) != null)
					n2.getNode(x).setParent(n2);
			}
			needToBurst = false;
		} else {
			// Platziere wert in Parent
			index = parent.getIndexForO(newParent);
			needToBurst = parent.moveForward(index, this.m);
			parent.setValue(newParent, index);
			if (index == 2 * this.m)
				needToBurst = true;

			// Setze Kinder
			parent.setNode(n1, index);
			parent.setNode(n2, index + 1);

			// Setze Parent
			n1.setParent(parent);
			n2.setParent(parent);

			// Setze Kindeskinder
			for (int x = 0; x < 2 * this.m + 1; x++) {
				if (n1.getNode(x) != null)
					n1.getNode(x).setParent(n1);
				if (n2.getNode(x) != null)
					n2.getNode(x).setParent(n2);
			}
		}

	}

	@Override
	public boolean contains(Integer o) {
		return isEmpty() ? false : this.rec_contains(o, getRoot(), 0);
	}

	/**
	 * 
	 * @param o
	 * @param node
	 * @param index
	 * @return
	 */
	private boolean rec_contains(Integer o, Node node, int index) {
		// System.out.println("**Debug: Ist Wert " + o + " im baum?");
		// System.out.println(node.toString());
		if (node.getValue(index) == null) {
			if (node.getNode(index) == null) {
				return false;
			} else {
				return rec_contains(o, node.getNode(index), 0);
			}
			// System.out.println("**Debug: rec_contains getValue==null");

		} else if (o.intValue() == node.getValue(index).intValue()) {
			// System.out.println("**Debug: rec_contains wert gefunden");
			return true;
		} else if (o.intValue() < node.getValue(index).intValue()) {
			// System.out.println("**Debug: o<value");
			// wenn link == null -> o nicht vorhanden; else schaue node tiefer
			return node.getNode(index) == null ? false : rec_contains(o, node.getNode(index), 0);

		} else /* (o.intValue() > node.getValue(index)) */ {
			// System.out.println("**Debug: o>value");
			// System.out.println("***Debug: index: " +index);
			index++;
			// laufe index weiter, aber prüfe ob nicht zu weit
			// letzte index muss nicht geprüft werden, da sollte nix sein

			if (index < 2 * this.m + 1)
				return rec_contains(o, node, index);
			else
				return false;
		}
	}

	@Override
	public int size() {
		Node node = root;
		return size_rec(node, 0);
	}

	private int size_rec(Node node, int n) {
		int countingNumber = +n;
		for (int i = 0; i < 2 * m + 1; i++) {
			if (node.getValue(i) != null) {
				countingNumber++;
			}
		}
		for (int i = 0; i < 2 * m + 2; i++) {
			if (node.getNode(i) != null) {
				countingNumber = +size_rec(node.getNode(i), countingNumber);
			}
		}
		return countingNumber;
	}

	@Override
	public int height() {
		Node node = root;
		int heightNumber = 1;
		if (isEmpty()) {
			return 0;
		} else {
			while (node.getNode(0) != null) {
				node = node.getNode(0);
				heightNumber++;
			}
			return heightNumber;
		}
	}

	@Override
	public Integer getMax() {
		Node node = root;
		if (isEmpty()) {
			return null;
		} else {
			for (int i = m * 2; i >= 0; i--) {
				if (node.getNode(i) != null) {
					node = node.getNode(i);
					i = m * 2 + 1;
				}
			}
			for (int i = m * 2 - 1; i >= 0; i--) {
				if (node.getValue(i) != null) {
					return node.getValue(i);
				}
			}
			return null;
		}
	}

	@Override
	public Integer getMin() {
		Node node = root;
		if (isEmpty()) {
			return null;
		} else {
			while (node.getNode(0) != null) {
				node = node.getNode(0);
			}
			return node.getValue(0);
		}
	}

	@Override
	public boolean isEmpty() {
		if (this.getRoot() == null) {
			if (debug)
				System.out.println("***DEBUG: Der Baum ist leer!");
			return true;
		} else
			return false;
		// return this.getRoot() == null ? true : false;
	}

	@Override
	public boolean addAll(BTree otherTree) {
		int oldSize = this.size();
		Node node = ((MyBTree) otherTree).getRoot();
		this.addAll_rec(node);
		int newSize = size();
		if (debug) {
			System.out.println(" Alte Größe: " + oldSize);
			System.out.println("Unterschied: " + difference);
			System.out.println(" Neue Größe: " + newSize);
		}
		if (oldSize + difference == newSize)
			return true;
		else
			return false;
	}

	public void addAll_rec(Node node) {
		if (debug)
			System.out.println("Beginne neu addAll_rec");
		boolean added;
		for (int i = 0; i < 2 * m + 2; i++) {
			if (debug)
				System.out.println("Anfang Schleife bei i = " + i);
			if (node.getNode(i) != null) {
				addAll_rec(node.getNode(i));
			}
			if (debug)
				System.out.println("Zwischen Schleife");
			if (i < 2 * m + 1 && node.getValue(i) != null) {
				if (debug)
					System.out.println(" " + node.getValue(i) + " ");
				added = this.insert(node.getValue(i));
				if (added)
					difference++;
			}
			if (debug)
				System.out.println("Ende Schleife");
		}
		if (debug)
			System.out.println("Ende addAll_rec");
	}

	@Override
	public BTree clone() {
		MyBTree tree = new MyBTree(this.m);
		if(isEmpty()){
			return null;
		}
		tree.root = this.root.deepClone();
		
		return tree;
	}

	@Override
	public void printInorder() {
		Node node = root;
		if (node == null)
			System.out.println("Der Baum ist leer!");
		else {
			printInorder_rec(node);
		}
		System.out.println();
	}

	private void printInorder_rec(Node node) {
		System.out.print("[");
		for (int i = 0; i < 2 * m + 2; i++) {
			if (node.getNode(i) != null) {
				printInorder_rec(node.getNode(i));
			}
			if (i < 2 * m + 1 && node.getValue(i) != null) {
				System.out.print(" " + node.getValue(i) + " ");
			}
		}
		System.out.print("]");
	}

	@Override
	public void printPostorder() {
		Node node = root;
		if (node == null)
			System.out.println("Der Baum ist leer!");
		else {
			printPostorder_rec(node);
		}
		System.out.println();
	}

	private void printPostorder_rec(Node node) {
		System.out.print("[");
		for (int i = 0; i < 2 * m + 2; i++) {
			if (node.getNode(i) != null) {
				printPostorder_rec(node.getNode(i));
			}
		}
		for (int i = 0; i < 2 * m + 1; i++) {
			if (node.getValue(i) != null)
				System.out.print(" " + node.getValue(i) + " ");
		}
		System.out.print("]");
	}

	@Override
	public void printPreorder() {
		Node node = root;
		if (node == null)
			System.out.println("Der Baum ist leer!");
		else {
			printPreorder_rec(node);
		}
		System.out.println();
	}

	private void printPreorder_rec(Node node) {
		System.out.print("[");
		for (int i = 0; i < 2 * m + 1; i++) {
			if (node.getValue(i) != null)
				System.out.print(" " + node.getValue(i) + " ");
		}
		for (int i = 0; i < 2 * m + 2; i++) {
			if (node.getNode(i) != null) {
				printPreorder_rec(node.getNode(i));
			}
		}
		System.out.print("]");
	}

	@Override
	public void printLevelorder() { // TODO Muss noch korrigiert werden!
		Node node = root;
		if (node == null)
			System.out.println("Der Baum ist leer!");
		else {
			for (int i = 0; i < height(); i++) {
				i++;
				System.out.print("Ebene/Höhe " + i + ": ");
				i--;
				printLevelorder_rec(node, i);
				System.out.println();
			}
		}
	}

	private void printLevelorder_rec(Node node, int level) {
		if (level > 0) {
			for (int i = 0; i < 2 * m + 1; i++) {
				if (node.getNode(i) != null) {
					printLevelorder_rec(node.getNode(i), level - 1);
				}
			}
		} else {
			System.out.print("[");
			for (int i = 0; i < 2 * m + 1; i++) {
				if (node.getValue(i) != null) {
					System.out.print(" " + node.getValue(i) + " ");
				}
			}
			System.out.print("]");
		}
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	/*********************************************************************************************
	 * 
	 * 
	 * Selbe Prints mit String als Rückgabe besser zu testen
	 * 
	 * 
	 */

	private static String inorder = "";

	public String printInorderS() {
		Node node = getRoot();
		if (node == null)
			inorder = null;
		else {
			printInorder_recS(node);
		}
		return inorder;
	}

	private void printInorder_recS(Node node) {
		inorder += "[";
		for (int i = 0; i < 2 * m + 2; i++) {
			if (node.getNode(i) != null) {
				printInorder_recS(node.getNode(i));
			}
			if (i < 2 * m + 1 && node.getValue(i) != null) {
				inorder += " " + node.getValue(i) + " ";
			}
		}
		inorder += "]";
	}

	private static String postorder = "";

	public String printPostorderS() {

		Node node = getRoot();
		if (node == null)
			postorder = null;
		else {
			printPostorder_recS(node);
		}
		return postorder;
	}

	private void printPostorder_recS(Node node) {
		postorder += "[";
		for (int i = 0; i < 2 * m + 2; i++) {
			if (node.getNode(i) != null) {
				printPostorder_recS(node.getNode(i));
			}
		}
		for (int i = 0; i < 2 * m + 1; i++) {
			if (node.getValue(i) != null)
				postorder += " " + node.getValue(i) + " ";
		}
		postorder += "]";
	}

	private static String preorder = "";

	public String printPreorderS() {

		Node node = getRoot();
		if (node == null)
			preorder = null;
		else {
			printPreorder_recS(node);
		}
		return preorder;
	}

	private void printPreorder_recS(Node node) {
		preorder += "[";
		for (int i = 0; i < 2 * m + 1; i++) {
			if (node.getValue(i) != null)
				preorder += " " + node.getValue(i) + " ";
		}
		for (int i = 0; i < 2 * m + 2; i++) {
			if (node.getNode(i) != null) {
				printPreorder_recS(node.getNode(i));
			}
		}
		preorder += "]";

	}

	private static String levelorder = "";

	public String printLevelorderS() {

		Node node = getRoot();
		if (node == null)
			levelorder = null;
		else {
			printLevelorder_recS(node);
		}
		return levelorder;
	}

	private void printLevelorder_recS(Node node) {
		levelorder += "[";
		for (int i = 0; i < 2 * m + 1; i++) {
			if (node.getValue(i) != null) {
				levelorder += " " + node.getValue(i) + " ";
			}
		}
		levelorder += "]";

		for (int i = 0; i < 2 * m + 1; i++) {
			if (node.getNode(i) != null) {
				printLevelorder_recS(node.getNode(i));
			}
		}
	}
	/*********************************************************************************************
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

}