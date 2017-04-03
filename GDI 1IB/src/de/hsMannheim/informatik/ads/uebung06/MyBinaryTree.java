package de.hsMannheim.informatik.ads.uebung06;

import static gdi.MakeItSimple.*;

class MyBinaryTree {
	public MyBinaryTree() {
		root = null;
	}

	private TreeNode root;
	private static MyBinaryTree tree = new MyBinaryTree();
	private static boolean existTree = true;
	private static MyBinaryTree otherTree = new MyBinaryTree();
	private static boolean existOtherTree = true;
	private static MyBinaryTree cloneTree = new MyBinaryTree();
	private static boolean existCloneTree = false;
	private static MyBinaryTree tree1 = new MyBinaryTree();
	private static boolean insertSucsess = false;
	private static int inserts = 0;
	private static int height = 0;
	private static int size = 0;

	public static void main(String[] args) {

		boolean runMain = true;
		do {
			println("------------------- Verfügbare Listen -------------------");
			if (existTree)
				println("1: tree");
			if (existOtherTree)
				println("2: otherTree");
			if (existCloneTree)
				println("3: cloneList ");
			println();
			println("------------------- Menue -------------------");
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

			println("Geben Sie an, welchen Baum sie bearbeiten wollen.");
			int treeChoise = readInt();
			readLine();
			switch (treeChoise) {
			case 1:
				tree1 = tree;
				break;
			case 2:
				tree1 = otherTree;
				break;
			case 3:
				tree1 = cloneTree;
				break;
			default:
				println("falsche eingabe");

			}

			separator();
			switch (selection) {
			case (1): // Insert (val)

				print("Geben Sie den Wert ein, den sie einfügen wollen: ");
				int val = readInt();
				readLine();

				if (tree1.insert(val))
					println("Der Wert " + val + " wurde erfolgreich eingefügt.");
				else
					println("Der Wert " + val + " wurde nicht eingefügt.");
				separator();

				break;
			case (2): // insert (file)
				print("Geben Sie den Dateinamen ein: ");
				String filename = readLine();

				if (tree1.insert(filename))
					println(inserts + " Werte aus der Datei wurden eingefügt");
				else
					println("Werte aus der Datei wurden nicht eingefügt");

				separator();
				break;
			case (3): // contains
				print("Geben Sie den Wert ein, den Sie prüfen wollen: ");
				val = readInt();
				readLine();

				if (tree1.contains(val))
					println("Der Wert " + val + " ist im Baum");
				else
					println("Der Wert " + val + " ist nicht im Baum");
				separator();

				break;
			case (4): // size
				println("Der Baum hat eine größe von " + tree1.size());
				separator();
				break;
			case (5): // hight
				println("Der Baum hat eine höhe von " + tree1.height());
				separator();
				break;
			case (6): // getMax
				println("Der höchste Wert im Baum ist: " + tree1.getMax());
				separator();

				break;
			case (7): // getMin
				println("Der kleinste Wert im Baum ist: " + tree1.getMin());
				separator();
				break;
			case (8): // remove (val)
				print("Geben Sie den Wert ein, den Sie entfernen wollen: ");
				val = readInt();
				readLine();

				if (tree1.remove(val))
					println("Der Wert " + val + " wurde entfernt");
				else
					println("Der Wert " + val + " ist nicht im Baum");
				separator();
				break;
			case (9): // isEmpty
				if (tree1.isEmpty())
					println("Der Baum ist leer.");
				else
					println("Der Baum ist nicht leer");
				separator();
				break;
			case (10): // addAll
				println("\"otherTree\" wird dem ausgewähltem Baum hinzugefügt.");
				if (tree1.addAll(otherTree))
					println(inserts + " Werte aus dem Baum \"otherTree\" wurden eingefügt.");
				else
					println("Der Baum \"otherTree\" konnte nicht eingefügt werden.");
				separator();
				break;
			case (11): // printInorder
				tree1.printInorder();
				separator();
				break;
			case (12): // printPostorder
				tree1.printPostorder();
				separator();
				break;
			case (13): // printPreorder
				tree1.printPreorder();
				separator();
				break;
			case (14): // printLevelorder
				tree1.printLevelorder();
				separator();
				break;
			case (15): // clone (deep)
				tree1.clone();
				existCloneTree = true;
				separator();
				break;
			case (0):
				runMain = false;
			}
		} while (runMain);

	}

	private static void separator() {
		println("-------------------------------------");
	}

	/**
	 * inserts val in tree
	 * 
	 * @param int
	 *            val
	 * @return boolean succsessfull inserted
	 */

	public boolean insert(int val) {
		insertSucsess = false;
		root = insertRec(root, val);

		if (insertSucsess)
			return true;
		else
			return false;
	}

	/**
	 * methode only for insert(int)
	 * 
	 * @param TreeNode
	 *            node
	 * @param int
	 *            val
	 * @return TreeNode
	 */
	private TreeNode insertRec(TreeNode node, int val) {

		if (node == null) {
			node = new TreeNode(val);
			insertSucsess = true;
			return node;
		}

		if (val < node.getValue())
			node.setLeft(insertRec(node.getLeft(), val));
		else if (val > node.getValue())
			node.setRight(insertRec(node.getRight(), val));

		return node; // return false;
	}

	/**
	 * Inserts Values from file
	 * 
	 * @param String
	 *            filename
	 * @return boolean
	 */
	public boolean insert(String filename) {

		if (isFilePresent(filename)) {
			inserts = 0;
			Object datei = openInputFile(filename);

			while (!isEndOfInputFile(datei)) {
				int val = readInt(datei);
				if (tree1.insert(val))
					inserts++;
			}

			closeInputFile(datei);
			return true;
		} else
			return false;

	}

	/**
	 * Test if val is in the tree
	 * 
	 * @param int
	 *            val
	 * @return boolean
	 */
	public boolean contains(int val) {

		TreeNode child = root;

		while (child != null) {

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
	 * calculate nodes in the tree
	 * 
	 * @return int size
	 */
	public int size() {

		TreeNode node = root;
		size = 0;

		if (node != null) {
			size(node);
			size++;
		}
		return size;
	}

	/**
	 * only for size()
	 * 
	 * @param node
	 */
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
	 * calculate the height of the tree
	 * 
	 * @return int height
	 */
	public int height() {
		TreeNode node = root;
		height = 0;
		if (node != null) {
			height++;
			height(node, 1);
		}
		return height;
	}

	/**
	 * only for height()
	 * 
	 * @param TreeNode
	 *            node
	 * @param int
	 *            level
	 */
	private void height(TreeNode node, int level) {

		if (level > height)
			height++;

		if (node.getLeft() != null) {
			tree.height(node.getLeft(), level + 1);
		}

		if (node.getRight() != null) {
			tree.height(node.getRight(), level + 1);
		}

	}

	/**
	 * gives you the biggest Value
	 * 
	 * @returnint maxValue
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
	 * gives you the smalest Value
	 * 
	 * @return minValue
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
	 * remove val in tree
	 * @param int val
	 * @return boolean
	 */
	public boolean remove(int val) {
		boolean walkLeft = false;
		if (!tree.contains(val))
			return false;
		if (root.getValue() == val) {
			if (root.getLeft() == null && root.getRight() == null) {
				root = null;
				return true;
			}
			if (root.getLeft() == null && root.getRight() != null) {
				root = root.getRight();
				return true;
			}
			if (root.getLeft() != null && root.getRight() == null) {
				root = root.getLeft();
				return true;
			}
			if (root.getLeft() != null && root.getRight() != null) {
				TreeNode parent = root.getLeft();
				if (parent.getRight() == null) {
					root.setValue(parent.getValue());
					root.setLeft(parent.getLeft());
					return true;
				} else {
					TreeNode child = parent.getRight();
					int valMax = child.getValue();
					while (child.getRight() != null) {
						child = child.getRight();
						valMax = child.getValue();
						parent = parent.getRight();
					}
					if (child.getLeft() != null)
						parent.setRight(child.getLeft());
					else
						parent.setRight(null);
					root.setValue(valMax);
					return true;
				}
			}
		} else {
			TreeNode parent = root;
			TreeNode child = null;
			TreeNode tmp = null;
			TreeNode deleteNode = root;
			while (deleteNode.getValue() != val) {
				parent = deleteNode;
				if (deleteNode.getValue() > val) {
					deleteNode = deleteNode.getLeft();
					walkLeft = true;
				} else {
					deleteNode = deleteNode.getRight();
					walkLeft = false;
				}
			}
			//entferne knoten ohne nachfolger
			if (deleteNode.getLeft() == null && deleteNode.getRight() == null) {
				deleteNode = null;
				return true;
			}
			//entferne knoten mit nachfolger
			if (deleteNode.getLeft() != null) {
				tmp = deleteNode.getLeft();
				if (tmp.getRight() == null) {
					deleteNode.setValue(tmp.getValue());
					deleteNode.setLeft(tmp.getLeft());
					return true;
				} else {
					child = tmp.getRight();
					int valMax = child.getValue();
					while (child.getRight() != null) {
						child = child.getRight();
						valMax = child.getValue();
						tmp = tmp.getRight();
					}
					if (child.getLeft() != null)
						tmp.setRight(child.getLeft());
					else
						tmp.setRight(null);
					deleteNode.setValue(valMax);
					return true;
				}
			}
			//entferne knoten ohne linken nachfolger
			if (deleteNode.getLeft() == null && deleteNode.getRight() != null) {
				if(walkLeft)
					parent.setLeft(deleteNode.getRight());
				else 
					parent.setRight(deleteNode.getRight());
				return true;
			}
		}
		return false;

	}

	/**
	 * retruns true if tree is empty
	 * 
	 * @return boolean
	 */
	public boolean isEmpty() {
		TreeNode child = root;
		if (child == null)
			return true;
		else
			return false;
	}

	/**
	 * inserts all Values from otherTree in tree
	 * 
	 * @param MyBinaryTree
	 *            otherTree
	 * @return boolean
	 */
	public boolean addAll(MyBinaryTree otherTree) {
		inserts = 0;

		TreeNode node = otherTree.root;

		tree.addAll(node);

		return true;
	}

	/**
	 * only for addAll(MyBinaryTree)
	 * 
	 * @param node
	 */
	private void addAll(TreeNode node) {
		if (node != null) {
			tree1.insert(node.getValue());
			inserts++;
			if (node.getLeft() != null)
				addAll(node.getLeft());
			if (node.getRight() != null)
				addAll(node.getRight());
		} else
			return;
	}

	/**
	 *
	 * print tree in Inorder
	 *
	 */
	public void printInorder() {
		// Check if the current node is empty / null
		// Traverse the left subtree by recursively calling the in-order
		// function.
		// Display the data part of the root (or current node).
		// Traverse the right subtree by recursively calling the in-order
		// function.
		TreeNode node = root;
		if (node == null)
			println("Der Baum ist leer.");
		else {

			inorder(node);
			println();
		}

	}

	/**
	 * only for printInorder
	 * 
	 * @param node
	 */
	private void inorder(TreeNode node) {
		if (node.getLeft() != null) {
			inorder(node.getLeft());
		}
		print(node.getValue() + "  ");
		if (node.getRight() != null) {
			inorder(node.getRight());
		}
	}

	/**
	 *
	 * prints tree in Postorder
	 *
	 */
	public void printPostorder() {
		// Check if the current node is empty / null
		// Traverse the left subtree by recursively calling the post-order
		// function.
		// Traverse the right subtree by recursively calling the post-order
		// function.
		// Display the data part of the root (or current node).
		TreeNode node = root;
		if (node == null)
			println("Der Baum ist leer");
		else {

			postorder(node);
			println();
		}

	}

	/**
	 * only for printPostorder
	 * 
	 * @param node
	 */
	private void postorder(TreeNode node) {
		if (node.getLeft() != null) {
			inorder(node.getLeft());
		}
		if (node.getRight() != null) {
			inorder(node.getRight());
			print(node.getValue() + "  ");
		}
	}

	/**
	 * prints tree in Preorder
	 */
	public void printPreorder() {
		// Check if the current node is empty / null
		// Display the data part of the root (or current node).
		// Traverse the left subtree by recursively calling the pre-order
		// function.
		// Traverse the right subtree by recursively calling the pre-order
		// function.
		TreeNode node = root;
		if (node == null)
			println("Der Baum ist leer");
		else {

			preorder(node);
			println();
		}

	}

	/**
	 * only for printPreorder
	 * 
	 * @param node
	 */
	private void preorder(TreeNode node) {
		print(node.getValue() + "  ");

		if (node.getLeft() != null) {
			inorder(node.getLeft());
		}
		if (node.getRight() != null) {
			inorder(node.getRight());
		}
	}

	/**
	 *
	 * prints tee in Levelorder
	 *
	 */
	public void printLevelorder() {
		TreeNode node = root;

		if (node != null) {
			for (int i = 0; i < tree1.height(); i++) {
				levelorder(node, i);
				println();
			}
		} else
			println("Der Baum ist leer");
	}

	/**
	 * only for printLevelorder
	 * 
	 * @param node
	 * @param level
	 */
	private void levelorder(TreeNode node, int level) {
		if (level == 0) {
			print(node.getValue() + " ");
		} else {
			level--;
			if (node.getLeft() != null)
				levelorder(node.getLeft(), level);

			if (node.getRight() != null)
				levelorder(node.getRight(), level);
		}
	}

	/**
	 * creates a deep clone
	 */
	public MyBinaryTree clone() {

		TreeNode node = root;

		tree1.cloneDeep(node);

		return cloneTree;

	}

	/**
	 * only for clone
	 * 
	 * @param node
	 */
	public void cloneDeep(TreeNode node) {

		if (node != null) {
			cloneTree.insert(node.getValue());

			if (node.getLeft() != null)
				cloneDeep(node.getLeft());
			if (node.getRight() != null)
				cloneDeep(node.getRight());
		} else
			return;
	}

	/**
	 * creates an empty tree
	 * 
	 * @return MyBinaryTree newTree
	 */
	MyBinaryTree empty() {
		return new MyBinaryTree();
	}
}