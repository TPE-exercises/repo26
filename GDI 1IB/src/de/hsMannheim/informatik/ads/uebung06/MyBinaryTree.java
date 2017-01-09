package de.hsMannheim.informatik.ads.uebung06;
import static gdi.MakeItSimple.*;
public class MyBinaryTree implements BinaryTree {
public static TreeNode root;
private static MyBinaryTree tree = new MyBinaryTree();
	
	MyBinaryTree(){
		root = null;
		
	}
	
	public static void main(String[] args) {

		boolean done = false;
		while(!done){
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
		case (1):
			
		
			print("Geben Sie den Wert ein, den sie einfügen wollen: ");
			int val = readInt();
			readLine();
			boolean succses = false;
					
			succses = tree.insert(val);
			
			if(succses)
				println("Der Wert " + val + " wurde erfolgreich eingefügt.");
			else
				println("Der Wert " + val + " wurde nicht eingefügt.");
			
			break;
		case (2):
			break;
		case (3):
			break;
		case (4):
			break;
		case (5):
			break;
		case (6):
			break;
		case (7):
			break;
		case (8):
			break;
		case (9):
			break;
		case (10):
			break;
		case (11):
			break;
		case (12):
			break;
		case (13):
			break;
		case (14):
			break;
		case (15):
			break;
		case (0):
			done=true;
		}
		}

	}
	
	private static void separator(){
		println("-------------------------------------");
	}
	
	/**
	 * Fügt val in den Baum ein.
	 */
	public boolean insert(int val) {

		TreeNode parent = null;
		TreeNode child = root;
		
		while(child != null){
			parent = child;
			if(child.getValue() == 0)
				return false;
			else if(child.getValue() < 0)
				child = child.getLeft();
			else
				child = child.getRight();
		}
		
		if(parent == null)
		    root = new TreeNode(val);
		else if(parent.getValue() < 0)
			parent.setLeft(new TreeNode(val));
		else
			parent.setRight(new TreeNode(val));
		
		return true;
		
	}

	/**
	 * Fügt die int-Werte, die in der Datei stehen in den Baum ein.
	 */
	public boolean insert(String filename) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Testet, ob val im Baum vorhanden ist.
	 */
	public boolean contains(int val) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Ermittelt die Anzahl der Knoten im Baum.
	 */
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Ermittelt die Höhe des Baums.
	 */
	public int height() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Liefert das größte Element im Baum.
	 */
	public int getMax() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Liefert das kleinste Element im Baum.
	 */
	public int getMin() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Entfernt val aus dem Baum.
	 */
	public boolean remove(int val) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * true genau dann, wenn der Baum leer ist.
	 */
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Fügt alle Elemente des übergebenen Baums (otherTree) in den aktuellen Baum ein.
	 */
	public boolean addAll(BinaryTree otherTree){
		return false;
		
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
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Erzeugt einen leeren neuen Baum
	 * @return
	 */
	BinaryTree empty (){
		return null;
		
	}


}
