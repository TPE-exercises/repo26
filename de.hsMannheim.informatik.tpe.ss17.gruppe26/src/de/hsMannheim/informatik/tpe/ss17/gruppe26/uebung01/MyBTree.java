package de.hsMannheim.informatik.tpe.ss17.gruppe26.uebung01;

import static gdi.MakeItSimple.*;


import gdi.MakeItSimple.GDIException;

public class MyBTree implements BTree {

	public int m;
	private Node root;

	MyBTree() {
		this.setRoot(null);
		this.m = 1;
		System.out.println("Construktor 0 Class BTree");
	}

	MyBTree(int ordnung) {
		this();
		this.m = ordnung;
		System.out.println("Construktor 1 Class BTree [m=" + m + "]");
	}

	public void printM() {

	}

	private static boolean needToBurst;
	// private BTree_Node burstNode;
	// private BTree_Node burstParent;

	@Override
	public boolean insert(Integer o) {
		needToBurst = false;
		System.out.println("***Debug: Wert " + o + " soll eingefügt werden.");
		if (this.contains(o)) {
			System.out.println("***Debug: Wert " + o + " ist bereits im Baum.");
			return false;
		} else if (getRoot() == null) {
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
			
			while(!isEndOfInputFile(datei)){
				System.out.println("***Debug: Datei");
				this.insert(new Integer(readInt(datei)));
			}
			closeInputFile(datei);
		} else
			throw new GDIException("Die Datei " + filename + " konnte nicht gefunden werden.");

		return false;
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
			Node newRoot = new Node(this.m);
			n1.setParent(newRoot);
			n1.setParent(newRoot);
			newRoot.setValue(newParent, 0);
			newRoot.setNode(n1, 0);
			newRoot.setNode(n2, 1);
			setRoot(newRoot);
			needToBurst = false;
		} else {
			index = parent.getIndexForO(newParent);
			needToBurst = parent.moveForward(index, this.m);
			if (index == 2 * this.m)
				needToBurst = true;
			parent.setValue(newParent, index);
			n1.setParent(parent);
			n2.setParent(parent);
			parent.setNode(n1, index);
			parent.setNode(n2, index + 1);
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
		System.out.println(node.toString());
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
			return index < 2 * this.m ? rec_contains(o, node, index) : false;
		}
	}

	@Override
	public int size() { // TODO @BEN
		int countingNumber = 0;
		if (isEmpty()) {
			System.out.println("Hinweis: Es gibt kein Element im Baum!");
			return countingNumber;
		} else {
			return countingNumber;
		}
	}

	@Override
	public int height() { // TODO @BEN
		Node node = root;
		int heightNumber = 1;
		if (isEmpty()) {
			// System.out.println("DEBUG: Die Höhe ist Null!");
			return 0;
		} else {
			while (node.getNode(0) != null) {
				node.getNode(0);
				heightNumber++;
			}
			// System.out.println("DEBUG: Die Höhe des B-Baumes ist: " +
			// heightNumber);
			return heightNumber;
		}
	}

	@Override
	public Integer getMax() {
		Node node = root;
		Integer valMax = 0;
		Integer valToCheck = 0;
		if (isEmpty()) {
			// TODO [Verbesserung: ] ausgabe "null" kommentieren im JavaDoc
			// System.out.println("DEBUG: Es gibt kein größtes Element.");
			return null;
		} else {
			for (int i = 0; i <= m * 2; i++) {
				valToCheck = node.getValue(i);
				if (valToCheck == null) {
					if (i > 0 && node.getNode(i) == null) {
						// System.out.println("***DEBUG: Der größte Wert ist: "
						// + valMax);
						return valMax;
					} else {
						node = node.getNode(i);
						i = 0;
					}
				}
				valMax = valToCheck;
			}
			System.out.println("***DEBUG: ***ERR: [getMax()] Schleife falsch" + valMax);
			return valMax;
		}
	}

	@Override
	public Integer getMin() { // TODO [Verbesserung: ] ausgabe "null"
								// kommentieren im JavaDoc
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
			System.out.println("***DEBUG: Der Baum ist leer!");
			return true;
		} else
			return false;
		// return this.getRoot() == null ? true : false;
	}

	@Override
	public void addAll(BTree otherTree) {
		// TODO Auto-generated method stub

	}

	@Override
	public MyBTree clone() {
		// TODO Auto-generated method stub

		return null;
	}

	@Override
	public void printInorder() { // TODO @Ben
		Node node = root;
		if (node == null)
			System.out.println("Der Baum ist leer!");
		else {
			// printInorder_rec(node);

			while (node.getNode(0) != null) {
				node = node.getNode(0);
			}
			System.out.print(node.toString() + ", ");

		}
		System.out.println();
	}

	public void printInorder_rec(Node node) { // TODO @Ben
		for (int i = 0; i < 2 * this.m + 2; i++) {
			if (node.getNode(i) != null) {
				printInorder_rec(node.getNode(i));
			}
			if (i < 2 * m + 1 && node.getValue(i) != null) {
				System.out.print(node.toString() + ", ");
			}
		}
	}

	@Override
	public void printPostorder() { // TODO @Ben
		Node node = root;
		while (node.getNode(0) != null) {
			node = node.getNode(0);
		}
		System.out.println(node.toString());
	}

	@Override
	public void printPreorder() { // TODO @Ben
		Node node = root;
		int ebene = 0;
		System.out.println("Ebene " + ebene + ":" + node.toString());
		while (node.getNode(0) != null) {
			node = node.getNode(0);
			ebene--;
			System.out.println("Ebene " + ebene + ":" + node.toString());
		}

		System.out.println("_Ende der Preorder-Ausgabe_");
	}

	@Override
	public void printLevelorder() { // TODO @Ben
		Node node = root;
		System.out.println(node.toString());
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

}