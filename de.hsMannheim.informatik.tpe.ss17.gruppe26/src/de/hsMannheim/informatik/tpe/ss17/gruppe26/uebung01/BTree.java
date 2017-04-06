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
			BTree_Node node = new BTree_Node(this.m);
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
	private boolean rec_insert(Integer o, BTree_Node node, BTree_Node parent, int index) {

		// Position ist frei
		if (node.getValue(index) == null) {
			// kein Kind an dieser Stelle -> Position richtig
			if (node.getNode(index) == null) {
				node.setValue(o, index);
				System.out.println("***Debug: Ein Wert wurde eingefügt -->" + o);
				// Platze wenn index die letzte position ist
				if (index == 2 * this.m || needToBurst) {
					do {// TODO klappt beim 2. mal nicht! parent ist unbekannt
						// child= parent
						BTree_Node[] nodes = { node, parent };
						burst(nodes);
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
				// TODO ggf prüfen, ob geschoben werden muss
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
	public boolean insert(String filename) { // TODO @BEN
		// Schleife -> insert
		return false;
	}

	/**
	 * 
	 */
	public void burst(BTree_Node[] nodes) {

		if (nodes == null) {
			return;
		}

		// Hilfsvariablen
		int m1 = 2 * m + 1;
		int mid = m1 / 2;
		BTree_Node node = nodes[0];
		BTree_Node parent = nodes[1];

		// Platze node
		// TODO NullPointer verhindern
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
		if (parent == null) {
			BTree_Node newRoot = new BTree_Node(this.m);
			newRoot.setValue(newParent, 0);
			newRoot.setNode(n1, 0);
			newRoot.setNode(n2, 1);
			setRoot(newRoot);
			needToBurst = false;
		} else {
			index = parent.getIndexForO(newParent);
			needToBurst = parent.moveForward(index, this.m);
			parent.setValue(newParent, index);
			parent.setNode(n1, index);
			parent.setNode(n2, index + 1);
		}

	}

	// TODO klappt nicht
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
		BTree_Node node = root;
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
		BTree_Node node = root;
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
	public Integer getMin() {
		BTree_Node node = root;

		if (isEmpty()) {
			// TODO [Verbesserung: ] ausgabe "null" kommentieren im JavaDoc
			// System.out.println("DEBUG: Es gibt kein kleinstes Element.");
			return null;
		} else {
			while (node.getNode(0) != null) {
				node = node.getNode(0);
			}
			// TODO [Verbesserung / Programmoptimierung : ] valMin wird nicht
			// benötigt (return node.getValue(0).intValue();)
			// System.out.println("***DEBUG: Der kleinste Wert ist: " +
			// node.getValue(0));
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
	public void addAll(BTree_Interface otherTree) {
		// TODO Auto-generated method stub

	}

	@Override
	public BTree clone() {
		// TODO Auto-generated method stub

		return null;
	}

	@Override
	public void printInorder() { // TODO @Ben

	}

	@Override
	public void printPostorder() { // TODO @Ben
		BTree_Node node = root;
		while (node.getNode(0) != null) {
			node = node.getNode(0);
		}
		System.out.println(node.toString());
	}

	@Override
	public void printPreorder() { // TODO @Ben
		BTree_Node node = root;
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
		BTree_Node node = root;
		System.out.println(node.toString());
	}

	public BTree_Node getRoot() {
		return root;
	}

	public void setRoot(BTree_Node root) {
		this.root = root;
	}

}