package de.hsMannheim.informatik.ads.uebung06;

import static gdi.MakeItSimple.*;

import gdi.MakeItSimple.GDIException;

public class MyBinaryTree implements BinaryTree {
	public static TreeNode root;
	private static MyBinaryTree tree = new MyBinaryTree();
	private static MyBinaryTree otherTree = new MyBinaryTree();

	private static MyBinaryTree cloneTree = new MyBinaryTree();
	static int inserts = 0;
	int height = 0;
	int size = 0;

	MyBinaryTree() {
		root = null;

	}

	public static void main(String[] args) {
		// otherTree.insert(10);
		// otherTree.insert(5);
		// otherTree.insert(15);
		// otherTree.insert(16);

		boolean done = false;
		while (!done) {
			println("Was wollen Sie ausführen?");

			println("1. insert (val)");
			println("2. insert (file)");
			println("3. contains");
			println("4. size");
			println("5. hight");
			println("6. getMax");
			println("7. getMin");
			println("8. remove");
			println("9. isEmpty");
			println("10. addAll");
			println("11. printInorder");
			println("12. printPostorder");
			println("13. printPreorder");
			println("14. printLevelorder");
			println("15. clone");
			println("0. beenden");

			int selection = readInt();
			readLine();
			separator();
			switch (selection) {
			case (1): // Insert (val)

				print("Geben Sie den Wert ein, den sie einfügen wollen: ");
				int val = readInt();
				readLine();
				boolean succses = false;

				if (tree.insert(val))
					println("Der Wert " + val + " wurde erfolgreich eingefügt.");
				else
					println("Der Wert " + val + " wurde nicht eingefügt.");
				separator();

				break;
			case (2): // insert (file)
				print("Geben Sie den Dateinamen ein: ");
				String filename = readLine();

				if (tree.insert(filename))
					println(inserts + " Werte aus der Datei wurden eingefügt");
				else
					println("Werte aus der Datei wurden nicht eingefügt");

				separator();
				break;
			case (3): // contains
				print("Geben Sie den Wert ein, den Sie prüfen wollen: ");
				val = readInt();
				readLine();

				if (tree.contains(val))
					println("Der Wert " + val + " ist im Baum");
				else
					println("Der Wert " + val + " ist nicht im Baum");
				separator();

				break;
			case (4): // size
				println("Der Baum hat eine größe von " + tree.size());
				separator();
				break;
			case (5): // hight
				println("Der Baum hat eine höhe von " + tree.height());
				separator();
				break;
			case (6): // getMax
				println("Der höchste Wert im Baum ist: " + tree.getMax());
				separator();

				break;
			case (7): // getMin
				println("Der kleinste Wert im Baum ist: " + tree.getMin());
				separator();
				break;
			case (8): // remove (val)
				print("Geben Sie den Wert ein, den Sie entfernen wollen: ");
				val = readInt();
				readLine();

				if (tree.remove(val))
					println("Der Wert " + val + " wurde entfernt");
				else
					println("Der Wert " + val + " ist nicht im Baum");
				separator();
				break;
			case (9): // isEmpty
				if (tree.isEmpty())
					println("Der Baum ist leer.");
				else
					println("Der Baum ist nicht leer");
				separator();
				break;
			case (10): // addAll
				println("Der Baum \"otherTree\" wurde bereits mit den Werten \"10\", \"5\", \"15\" und \"16\" belegt.");
				println("Dieser Baum wird nun in \"tree\" eingefügt.");
				if (tree.addAll(otherTree))
					println(inserts + " Werte aus dem Baum \"otherTree\" wurden eingefügt.");
				else
					println("Der Baum \"otherTree\" konnte nicht eingefügt werden.");
				separator();
				break;
			case (11): // printInorder
				// _______________________________________________________________________<--
				separator();
				break;
			case (12): // printPostorder
				// _______________________________________________________________________<--
				separator();
				break;
			case (13): // printPreorder
				// _______________________________________________________________________<--
				separator();
				break;
			case (14): // printLevelorder
				// _______________________________________________________________________<--
				separator();
				break;
			case (15): // clone (deep)
				tree.clone();
				separator();
				break;
			case (0):
				done = true;
			}
		}

	}

	private static void separator() {
		println("-------------------------------------");
	}

	/**
	 * Fügt val in den Baum ein.
	 */
	public boolean insert(int val) {

		TreeNode parent = null;
		TreeNode child = root;

		while (child != null) {
			parent = child;
			if (child.getValue() == val)
				return false;
			else if (child.getValue() > val)
				child = child.getLeft();
			else
				child = child.getRight();
		}

		if (parent == null)
			root = new TreeNode(val);
		else if (parent.getValue() > val)
			parent.setLeft(new TreeNode(val));
		else
			parent.setRight(new TreeNode(val));

		return true;

	}

	/**
	 * Fügt die int-Werte, die in der Datei stehen in den Baum ein.
	 */
	public boolean insert(String filename) {

		if (isFilePresent(filename)) {
			inserts = 0;
			Object datei = openInputFile(filename);

			while (!isEndOfInputFile(datei)) {
				int val = readInt(datei);
				if (tree.insert(val))
					inserts++;
			}

			closeInputFile(datei);
			return true;
		} else
			return false;

	}

	/**
	 * Testet, ob val im Baum vorhanden ist.
	 */
	public boolean contains(int val) {

		TreeNode parent = null;
		TreeNode child = root;

		while (child != null) {
			parent = child;
			if (child.getValue() == val)
				return true;
			else if (child.getValue() > val)
				child = child.getLeft();
			else
				child = child.getRight();
		}

		return false;
	}

	/**
	 * Ermittelt die Anzahl der Knoten im Baum.
	 */
	public int size() {

		TreeNode node = root;
		size = 0;

		if (node != null) {
			size++;
			if (node.getLeft() != null) {
				tree.size(node.getLeft());
				size++;
			}

			if (node.getRight() != null) {
				tree.size(node.getRight());
				size++;
			}

			return size;
		} else
			return 0;
	}

	private void size(TreeNode node) {
		if (node != null) {
			if (node.getLeft() != null) {
				tree.size(node.getLeft());
				size++;
			}

			if (node.getRight() != null) {
				tree.size(node.getRight());
				size++;
			}
		}
	}

	/**
	 * Ermittelt die Höhe des Baums.
	 */
	public int height() {
		TreeNode node = root;
		height = 0;
		if (node != null) {
			height++;
			if (node.getLeft() != null) {
				tree.maxHight(node.getLeft(), 2);

			}

			if (node.getRight() != null) {
				tree.maxHight(node.getRight(), 2);

			}

			return height;
		} else
			return 0;
	}

	private void maxHight(TreeNode node, int level) {

		if (level > height)
			height++;

		if (node.getLeft() != null) {
			tree.maxHight(node.getLeft(), level + 1);

		}

		if (node.getRight() != null) {
			tree.maxHight(node.getRight(), level + 1);

		}

	}

	/**
	 * Liefert das größte Element im Baum.
	 */
	public int getMax() {
		TreeNode child = root;
		int valMax = 0;

		while (child != null) {
			valMax = child.getValue();
			child = child.getRight();
		}

		return valMax;
	}

	/**
	 * Liefert das kleinste Element im Baum.
	 */
	public int getMin() {
		TreeNode child = root;
		int valMin = 0;

		while (child != null) {
			valMin = child.getValue();
			child = child.getLeft();
		}

		return valMin;
	}

	/**
	 * Entfernt val aus dem Baum.
	 */
	public boolean remove(int val) {
		TreeNode parent = null;
		TreeNode child = tree.root;
		TreeNode help = null;
		TreeNode helpParent = null;
		boolean walkLeft = false;
		boolean noHelpParen = false;

		if (tree.contains(val)) {
			while (child != null) {

				if (child.getValue() == val) {

					if (child.getLeft() != null) {
						help = child.getLeft();
						while (help.getRight() != null) {
							helpParent = help;
							help = help.getRight();
							noHelpParen = true;
						}
						if (!noHelpParen) {
							child.setLeft(null);
						} else {
							helpParent.setRight(null);
						}

						if (child.getLeft() != null)
							help.setLeft(child.getLeft());
						if (child.getRight() != null)
							help.setRight(child.getRight());
						child = help;
						if (walkLeft)
							parent.setLeft(help);
						else

							parent.setRight(help);

						return true;
					} else {
						if (child.getRight() != null)
							parent.setRight(child.getRight());
						else
							child = null;

					}
				} else if (child.getValue() > val) {
					parent = child;
					child = child.getLeft();
					walkLeft = true;
				} else {
					parent = child;
					child = child.getRight();
					walkLeft = false;
				}
			}

			return false;
		} else
			return false;

	}

	/**
	 * true genau dann, wenn der Baum leer ist.
	 */
	public boolean isEmpty() {
		TreeNode child = root;
		if (child == null)
			return true;
		else
			return false;
	}

	/**
	 * Fügt alle Elemente des übergebenen Baums (otherTree) in den aktuellen
	 * Baum ein.
	 */
	public boolean addAll(BinaryTree otherTree) {
		inserts = 0;
		TreeNode node = otherTree.root;

		if (node != null) {
			if (tree.insert(node.getValue()))
				inserts++;

			if (node.getLeft() != null) {
				tree.addAll(node.getLeft());
			}

			if (node.getRight() != null) {
				tree.addAll(node.getRight());
			}
		} else {
			return false;
		}
		return true;
	}

	private void addAll(TreeNode node) {

		if (node != null) {
			if (tree.insert(node.getValue()))
				inserts++;

			if (node.getLeft() != null) {
				tree.addAll(node.getLeft());
			}

			if (node.getRight() != null) {
				tree.addAll(node.getRight());
			}
		}

	}

	/**
	 * Gibt Baum in Inorder aus.
	 */
	public void printInorder() {
		// TODO Auto-generated method stub

	}

	/**
	 * Gibt Baum in Postorder aus.
	 */
	public void printPostorder() {
		// TODO Auto-generated method stub

	}

	/**
	 * Gibt Baum in Preorder aus.
	 */
	public void printPreorder() {
		// TODO Auto-generated method stub

	}

	/**
	 * Gibt Baum in Levelorder aus.
	 */
	public void printLevelorder() {
		// TODO Auto-generated method stub

	}

	/**
	 * Erzeugt eine tiefe Kopie des Baums.
	 */
	public BinaryTree clone() {
		
		
		TreeNode node = root;
		
		if(node == null)
			return cloneTree;
		
		TreeNode
		
		node.setValue();
		cloneTree.insert(node.getValue());
		
		if(node.getLeft() != null)
			cloneDeep(node.getLeft());
		if(node.getRight() != null)
			cloneDeep(node.getRight());

		return cloneTree;
	}

	public void cloneDeep(TreeNode node) {

		cloneTree.insert(node.getValue());

		if (node.getLeft() != null)
			cloneDeep(node.getLeft());
		if (node.getRight() != null)
			cloneDeep(node.getRight());

	}

	/**
	 * Erzeugt einen leeren neuen Baum
	 * 
	 * @return
	 */
	BinaryTree empty() {

		MyBinaryTree newTree = new MyBinaryTree();

		return newTree;

	}

}
