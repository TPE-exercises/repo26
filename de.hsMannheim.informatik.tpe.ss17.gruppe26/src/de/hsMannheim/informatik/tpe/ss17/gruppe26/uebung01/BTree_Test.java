package de.hsMannheim.informatik.tpe.ss17.gruppe26.uebung01;

import static org.junit.Assert.*;
import org.junit.*;

public class BTree_Test {
	
	
	BTree tree = new MyBTree(1);

	@Test
	public void insertNegativIntegers() {
		System.out.println("*********Debug: TEST insert");
//		assertEquals("1Insert(0): ", true, tree.insert(new Integer(0)));
		assertEquals("Insert(-2): ", true, tree.insert(new Integer(-2)));
		assertEquals("Insert(-6): ", true, tree.insert(new Integer(-6)));
		assertEquals("Insert(-700): ", true, tree.insert(new Integer(-700)));
		assertEquals("2Insert(0): ", true, tree.insert(new Integer(0)));
		assertEquals("Insert(-700): ", false, tree.insert(new Integer(-700)));
		assertEquals("Insert(MIN): ", true, tree.insert(new Integer(Integer.MAX_VALUE)));

	}
	@Test
	public void insertLowIntegers() {
		System.out.println("*********Debug: TEST insert");
		assertEquals("Insert(2): ", true, tree.insert(new Integer(2)));
		assertEquals("Insert(6): ", true, tree.insert(new Integer(6)));
		assertEquals("Insert(7): ", true, tree.insert(new Integer(7)));
		assertEquals("Insert(7): ", false, tree.insert(new Integer(7)));
		assertEquals("Insert(0): ", true, tree.insert(new Integer(0)));
		assertEquals("Insert(0): ", false, tree.insert(new Integer(0)));

	}

	@Test
	public void insertHightIntegers() {
		assertEquals("Insert(200): ", true, tree.insert(new Integer(200)));
		assertEquals("Insert(300): ", true, tree.insert(new Integer(300)));
		assertEquals("Insert(400): ", true, tree.insert(new Integer(400)));
		assertEquals("Insert(400): ", false, tree.insert(new Integer(400)));
		assertEquals("Insert(MAX): ", true, tree.insert(new Integer(Integer.MAX_VALUE)));
	}

	@Test
	public void insertHightAndLowIntegers() {
		System.out.println("*********Debug: TEST insert");
		assertEquals("Insert(200): ", true, tree.insert(new Integer(200)));
		assertEquals("Insert(300): ", true, tree.insert(new Integer(300)));
		assertEquals("Insert(400): ", true, tree.insert(new Integer(400)));
		assertEquals("Insert(400): ", false, tree.insert(new Integer(400)));
		assertEquals("Insert(2): ", true, tree.insert(new Integer(2)));
		assertEquals("Insert(6): ", true, tree.insert(new Integer(6)));
		assertEquals("Insert(7): ", true, tree.insert(new Integer(7)));
		assertEquals("Insert(7): ", false, tree.insert(new Integer(7)));

	}

	@Test
	public void containsLowIntegers() {
		System.out.println("*********Debug: TEST contains -> insert");
		tree.insert(new Integer(2));
		tree.insert(new Integer(6));
		tree.insert(new Integer(7));
		tree.insert(new Integer(3));

		System.out.println("*********Debug: TEST contains -> test");
		assertEquals("contains(2): ", true, tree.contains(new Integer(2)));
		assertEquals("contains(3): ", true, tree.contains(new Integer(3)));
		assertEquals("contains(7): ", true, tree.contains(new Integer(7)));
		assertEquals("contains(5): ", false, tree.contains(new Integer(5)));
		assertEquals("contains(10)): ", false, tree.contains(new Integer(10)));
		assertEquals("contains(0): ", false, tree.contains(new Integer(0)));
		tree.insert(new Integer(0));
		assertEquals("contains(0): ", true, tree.contains(new Integer(0)));

	}
	
	@Test
	public void containsHightIntegers() {
		System.out.println("*********Debug: TEST contains -> insert");
		tree.insert(new Integer(300));
		tree.insert(new Integer(400));
		tree.insert(new Integer(200));
		tree.insert(new Integer(Integer.MAX_VALUE));
		System.out.println("*********Debug: TEST contains -> test");

		assertEquals("contains(200): ", true, tree.contains(new Integer(200)));
		assertEquals("contains(200): ", true, tree.contains(new Integer(300)));
		assertEquals("contains(200): ", true, tree.contains(new Integer(400)));
		assertEquals("contains(190)): ", false, tree.contains(new Integer(190)));
		assertEquals("contains(MAX): ", true, tree.contains(new Integer(Integer.MAX_VALUE)));
	}
	
	@Test
	public void containsNegativeIntegers() {
		System.out.println("*********Debug: TEST contains -> insert");
		tree.insert(new Integer(-2));
		tree.insert(new Integer(-6));
		tree.insert(new Integer(-7));
		tree.insert(new Integer(-3));

		System.out.println("*********Debug: TEST contains -> test");
		assertEquals("contains(-2): ", true, tree.contains(new Integer(-2)));
		assertEquals("contains(-3): ", true, tree.contains(new Integer(-3)));
		assertEquals("contains(-7): ", true, tree.contains(new Integer(-7)));
		assertEquals("contains(-5): ", false, tree.contains(new Integer(-5)));
		assertEquals("contains(-10)): ", false, tree.contains(new Integer(-10)));
	}

	@Test
	public void getMax() {
		System.out.println("*********Debug: TEST getMax");
		tree.insert(new Integer(2));
		tree.insert(new Integer(6));
		tree.insert(new Integer(7));
		tree.insert(new Integer(3));
		tree.insert(new Integer(200));
		assertEquals("GetMax: ", new Integer(200), tree.getMax());
	}

	@Test
	public void getMin() {
		System.out.println("*********Debug: TEST getMin");
		tree.insert(new Integer(2));
		tree.insert(new Integer(6));
		tree.insert(new Integer(7));
		tree.insert(new Integer(3));
		tree.insert(new Integer(200));
		assertEquals("getMin: ", new Integer(2), tree.getMin());
	}

	@Test
	public void isEmpty(){
		System.out.println("*********Debug: TEST isEmpty");
		assertEquals("isEmpty: ", true, tree.isEmpty());
		tree.insert(new Integer(2));
		assertEquals("isEmpty: ", false, tree.isEmpty());
	}
}
