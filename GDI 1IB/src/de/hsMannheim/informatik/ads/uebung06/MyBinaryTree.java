package de.hsMannheim.informatik.ads.uebung06;

import static gdi.MakeItSimple.*;

import gdi.MakeItSimple.GDIException;

public class MyBinaryTree implements BinaryTree {	
	MyBinaryTree() {
		root = null;
	}
	public static TreeNode root;
	private static MyBinaryTree tree = new MyBinaryTree();
	private static MyBinaryTree otherTree = new MyBinaryTree();
	private static MyBinaryTree cloneTree = new MyBinaryTree();
	static boolean insertSucsess = false;
    public static int[] sortedTree;
    public static int[] sortedTreeHeight;
    public static int sortedTreeCounter = 0;
    public static int nodeHeight = 1; 
	static int inserts = 0;
	int height = 0;
	int size = 0;



	public static void main(String[] args) {

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
				tree.printInorder();
				separator();
				break;
			case (12): // printPostorder
				tree.printPostorder();
				separator();
				break;
			case (13): // printPreorder
				tree.printPreorder();
				separator();
				break;
			case (14): // printLevelorder
				tree.printLevelorder();
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
	 * 
	 * @return
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
	 * @param node
	 * @param val
	 * @return
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
	 * Ermittelt die Anzahl der Knoten im Baum.
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
			height(node, 1);
		}
		return height;
	}

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
		boolean walkLeft = false;

		if (tree.contains(val)) {
			while (child != null) {

				if (child.getValue() == val) {

					if (child.getLeft() != null) {
						// Weiter aus OneNode
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
        // Check if the current node is empty / null
        // Traverse the left subtree by recursively calling the in-order
        // function.
        // Display the data part of the root (or current node).
        // Traverse the right subtree by recursively calling the in-order
        // function.
        TreeNode node = root;
        if (node == null)
            println("Hurensohn");
        else {
            sortedTree = new int[tree.size];
            inorder(node);
        }
        String output = null;
        while (sortedTreeCounter != 0) {
            output += sortedTree[sortedTreeCounter];
            sortedTreeCounter--;
        }
        println(output);
    }
    private void inorder(TreeNode node) {
        if (node.getLeft() != null) {
            inorder(node.getLeft());
        }
        sortedTree[sortedTreeCounter] = node.getValue();
        sortedTreeCounter++;
        if (node.getRight() != null) {
            inorder(node.getRight());
        }
    }
    /**
     * Gibt Baum in Postorder aus.
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
            println("Hurensohn");
        else {
            sortedTree = new int[tree.size];
            postorder(node);
        }
        String output = null;
        while (sortedTreeCounter != 0) {
            output += sortedTree[sortedTreeCounter];
            sortedTreeCounter--;
        }
        println(output);
    }
    private void postorder(TreeNode node) {
        if (node.getLeft() != null) {
            inorder(node.getLeft());
        }
        if (node.getRight() != null) {
            inorder(node.getRight());
            sortedTree[sortedTreeCounter] = node.getValue();
            sortedTreeCounter++;
        }
    }
    /**
     * Gibt Baum in Preorder aus.
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
            println("Hurensohn");
        else {
            sortedTree = new int[tree.size];
            preorder(node);
        }
        String output = null;
        while (sortedTreeCounter != 0) {
            output += sortedTree[sortedTreeCounter];
            sortedTreeCounter--;
        }
        println(output);
    }
    private void preorder(TreeNode node) {
        sortedTree[sortedTreeCounter] = node.getValue();
        sortedTreeCounter++;
        if (node.getLeft() != null) {
            inorder(node.getLeft());
        }
        if (node.getRight() != null) {
            inorder(node.getRight());
        }
    }
    public void currentHeight(TreeNode node) {
        nodeHeight = 1;
        int search = node.getValue();
        currentHeightx(node, search);
    }
    private void currentHeightx(TreeNode node, int search) {
        if (search == node.getValue())
            nodeHeight = search;
        if (node == null)
            nodeHeight--;
        else {
            nodeHeight++;
            currentHeightx(node.getLeft(), search);
            nodeHeight++;
            currentHeightx(node.getLeft(), search);
        }
    }
    /**
     * Gibt Baum in Levelorder aus.
     */
    public void printLevelorder() {
        TreeNode node = root;
        if (node == null)
            println("Hurensohn");
        else {
            sortedTreeHeight = new int[tree.size];
            sortedTree = new int[tree.size];
            levelorder(node);
            String output = " ";
            for (int i = 1; i <= tree.height(); i++) {
                for (int i2 = 1; i2 <= tree.size(); i2++) {
                    if (i == sortedTreeHeight[i])
                        output += sortedTree[i];
                }
            }
            println();
        }
    }
    private void levelorder(TreeNode node) {
        currentHeight(node);
        sortedTreeHeight[sortedTreeCounter] = nodeHeight;
        sortedTree[sortedTreeCounter] = node.getValue();
        sortedTreeCounter++;
        if (node.getLeft() != null) {
            inorder(node.getLeft());
        }
        if (node.getRight() != null) {
            inorder(node.getRight());
        }
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
