package uebung01;

import static org.junit.Assert.*;
import org.junit.*;

public class BTree_Test01 {

	BTree tree = new MyBTree(1);

	@Test
	public void insertNegativIntegers() {
		System.out.println("*********Debug: TEST insert");
		assertTrue("Insert(-2): ", tree.insert(new Integer(-2)));
		assertTrue("Insert(-6): ", tree.insert(new Integer(-6)));
		assertTrue("Insert(-700): ", tree.insert(new Integer(-700)));
		assertTrue("Insert(700): ", tree.insert(new Integer(700)));
		assertTrue("Insert(0): ", tree.insert(new Integer(0)));
		assertFalse("Insert(-700): ", tree.insert(new Integer(-700)));
		assertTrue("Insert(MAX): ", tree.insert(new Integer(Integer.MAX_VALUE)));
		assertTrue("Insert(MIN): ", tree.insert(new Integer(Integer.MIN_VALUE)));
		assertFalse("Insert(0): ", tree.insert(new Integer(0)));
tree.printLevelorder();
	}

	@Test
	public void containsLowIntegers() {
		System.out.println("*********Debug: TEST contains -> insert");
		tree.insert(new Integer(1));
		tree.insert(new Integer(0));
		tree.insert(new Integer(-1));
		tree.insert(new Integer(Integer.MIN_VALUE));
		tree.insert(new Integer(300));
		tree.insert(new Integer(Integer.MAX_VALUE));

		System.out.println("*********Debug: TEST contains -> test");
		assertTrue("contains(2): ", tree.contains(new Integer(1)));
		assertTrue("contains(3): ", tree.contains(new Integer(0)));
		assertTrue("contains(7): ", tree.contains(new Integer(-1)));
		assertTrue("contains(5): ", tree.contains(new Integer(Integer.MIN_VALUE)));
		assertTrue("contains(10)): ", tree.contains(new Integer(Integer.MAX_VALUE)));
		assertTrue("contains(0): ", tree.contains(new Integer(300)));
		assertFalse("contains(0): ", tree.contains(new Integer(400)));
		assertFalse("contains(0): ", tree.contains(new Integer(-5)));

	}

	@Test
	public void getMaxMin() {
		System.out.println("*********Debug: TEST getMax");
		tree.insert(new Integer(2));
		tree.insert(new Integer(6));
		tree.insert(new Integer(7));
		tree.insert(new Integer(3));
		tree.insert(new Integer(200));
		assertEquals("GetMax: ", new Integer(200), tree.getMax());
		assertEquals("getMin: ", new Integer(2), tree.getMin());
	}

	@Test
	public void isEmpty() {
		System.out.println("*********Debug: TEST isEmpty");
		assertEquals("isEmpty: ", true, tree.isEmpty());
		tree.insert(new Integer(2));
		assertEquals("isEmpty: ", false, tree.isEmpty());
	}


}
