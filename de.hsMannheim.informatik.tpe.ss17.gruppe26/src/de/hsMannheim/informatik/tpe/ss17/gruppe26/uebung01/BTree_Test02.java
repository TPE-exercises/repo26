package de.hsMannheim.informatik.tpe.ss17.gruppe26.uebung01;

import static org.junit.Assert.*;
import org.junit.*;

public class BTree_Test02 {
	BTree tree = new MyBTree(1);

	@Before
	public void bevore() {
		tree.insert(new Integer(0));
		tree.insert(new Integer(3));
		tree.insert(new Integer(1));
		tree.insert(new Integer(2));
		tree.insert(new Integer(4));
		tree.insert(new Integer(6));
		tree.insert(new Integer(7));
		tree.insert(new Integer(8));
		tree.insert(new Integer(9));
		tree.insert(new Integer(10));
		tree.insert(new Integer(11));
	}

	@Test
	public void printInorder() {

		String inorder = "[[[ 0 ] 1 [ 2 ]] 3 [[ 4 ] 6 [ 7 ]] 8 [[ 9 ] 10 [ 11 ]]]";
		assertEquals("Inorder: ", inorder, ((MyBTree) tree).printInorderS());
	}

	@Test
	public void printPostorder() {

		String postorder = "[[[ 0 ][ 2 ] 1 ][[ 4 ][ 7 ] 6 ][[ 9 ][ 11 ] 10 ] 3  8 ]";
		assertEquals("Postorder: ", postorder, ((MyBTree) tree).printPostorderS());
	}

	@Test
	public void printPreorder() {

		String preorder = "[ 3  8 [ 1 [ 0 ][ 2 ]][ 6 [ 4 ][ 7 ]][ 10 [ 9 ][ 11 ]]]";
		assertEquals("Preorder: ", preorder, ((MyBTree) tree).printPreorderS());

	}

	@Test
	public void printLevelorder() {

		String levelorder = "[ 3  8 ][ 1 ][ 0 ][ 2 ][ 6 ][ 4 ][ 7 ][ 10 ][ 9 ][ 11 ]";

		assertEquals("Levelorder: ", levelorder, ((MyBTree) tree).printLevelorderS());
	}
	
	@Test
	public void size() {
		assertEquals("Size: ", 11, ((MyBTree) tree).size());

	}
	@Test
	public void hight() {
		assertEquals("Hight: ", 3, ((MyBTree) tree).height());

	}
}
