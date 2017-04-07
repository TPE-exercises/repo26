package de.hsMannheim.informatik.tpe.ss17.gruppe26.uebung01;

import static org.junit.Assert.*;
import org.junit.*;

public class BTree_Test {

	BTree tree = new MyBTree(1);
//	BTree_Interface tree2 = new BTree(1);


	@Test
	public final void insert() {
		System.out.println("*********Debug: TEST insert");
		assertEquals("Insert(2): ", true, tree.insert(new Integer(2)));
		assertEquals("Insert(6): ", true, tree.insert(new Integer(6)));
//		assertEquals("Insert(2): ", false, tree.insert(new Integer(2)));
		assertEquals("Insert(7): ", true, tree.insert(new Integer(7)));
		assertEquals("Insert(3): ", true, tree.insert(new Integer(3)));
		assertEquals("Insert(200): ", true, tree.insert(new Integer(200)));
		
	}

	@Test
	public final void contains(){
		System.out.println("*********Debug: TEST contains -> insert");
		tree.insert(new Integer(2));
		tree.insert(new Integer(6));
		tree.insert(new Integer(7));
		tree.insert(new Integer(3));
		tree.insert(new Integer(200));
		System.out.println("*********Debug: TEST contains -> test");
		assertEquals("contains(2): ", true, tree.contains(new Integer(2)));
		assertEquals("contains(5): ", false, tree.contains(new Integer(5)));
		assertEquals("contains(200): ", true, tree.contains(new Integer(200)));
		assertEquals("contains(190)): ", false, tree.contains(new Integer(190)));
		assertEquals("contains(10)): ", false, tree.contains(new Integer(10)));
		
	}
	
	@Test
	public final void getMax() {
		System.out.println("*********Debug: TEST getMax");
	tree.insert(new Integer(2));
	tree.insert(new Integer(6));
	tree.insert(new Integer(7));
	tree.insert(new Integer(3));
	tree.insert(new Integer(200));
		assertEquals("GetMax: ", new Integer(200), tree.getMax());
	}

	@Test
	public final void getMin() {
		System.out.println("*********Debug: TEST getMin");
		tree.insert(new Integer(2));
		tree.insert(new Integer(6));
		tree.insert(new Integer(7));
		tree.insert(new Integer(3));
		tree.insert(new Integer(200));
		assertEquals("getMin: ",new Integer(2), tree.getMin());
	}
	
	@Test
	public final void isEmpty(){
		System.out.println("*********Debug: TEST isEmpty");
		assertEquals("isEmpty: ", true, tree.isEmpty());
		tree.insert(new Integer(2));
		assertEquals("isEmpty: ", false, tree.isEmpty());
	}
	
//	@Test
//	public final void cloneTest(){
//		//dürfte nicht klappen, da nur Speicheradressen verglichen werden
//		assertEquals("clone: ", tree, tree.clone());
//	}
}
