package uebung01;

import static org.junit.Assert.*;
import org.junit.*;

public class BTree_Test03 {
	

	@Test
	public void case1() {
		BTree tree = new MyBTree(3);
		assertTrue(tree.isEmpty());
		tree.insert("TestValues1.txt");
		assertTrue(tree.contains(0));
		assertTrue(tree.contains(1));
		assertTrue(tree.contains(2));
		assertTrue(tree.contains(3));
		assertTrue(tree.contains(4));
		assertTrue(tree.contains(5));
		assertTrue(tree.contains(6));
		assertTrue(tree.contains(7));
		assertTrue(tree.contains(8));
		assertTrue(tree.contains(9));
		assertTrue(tree.contains(10));
		assertTrue(tree.contains(11));
		assertTrue(tree.contains(13));
		assertTrue(tree.contains(15));
		assertTrue(tree.contains(20));
		assertTrue(tree.contains(29));
		assertTrue(tree.contains(30));
		assertTrue(tree.contains(34));
		assertTrue(tree.contains(51));
		assertFalse(tree.contains(12));
		assertFalse(tree.contains(14));
		assertFalse(tree.contains(17));
		assertFalse(tree.contains(31));
		assertFalse(tree.contains(104));
		assertFalse(tree.contains(26));
		assertFalse(tree.contains(17));
		assertFalse(tree.contains(99));
		assertEquals(19,tree.size());
		assertEquals(2,tree.height());
		assertEquals(new Integer(51),tree.getMax());
		assertEquals(new Integer(0),tree.getMin());
		assertFalse(tree.isEmpty());
	}
	
	@Test
	public void case2() {
		BTree tree = new MyBTree(2);
		assertTrue(tree.isEmpty());
		tree.insert("TestValues2.txt");
		assertTrue(tree.contains(6));
		assertTrue(tree.contains(2));
		assertTrue(tree.contains(4));
		assertTrue(tree.contains(1));
		assertTrue(tree.contains(3));
		assertTrue(tree.contains(5));
		assertTrue(tree.contains(8));
		assertTrue(tree.contains(10));
		assertTrue(tree.contains(7));
		assertTrue(tree.contains(9));
		assertTrue(tree.contains(11));
		assertTrue(tree.contains(21));
		assertFalse(tree.contains(41));
		assertFalse(tree.contains(100));
		assertFalse(tree.contains(19));
		assertFalse(tree.contains(15));
		assertEquals(12,tree.size());
		assertEquals(2,tree.height());
		assertEquals(new Integer(21),tree.getMax());
		assertEquals(new Integer(1),tree.getMin());
		assertFalse(tree.isEmpty());
	}
	
	@Test
	public void case3() {
		BTree tree = new MyBTree(2);
		assertTrue(tree.isEmpty());
		tree.insert("TestValues3.txt");
		assertTrue(tree.contains(24));
		assertTrue(tree.contains(21));
		assertTrue(tree.contains(17));
		assertTrue(tree.contains(11));
		assertTrue(tree.contains(10));
		assertFalse(tree.contains(19));
		assertTrue(tree.contains(9));
		assertTrue(tree.contains(8));
		assertTrue(tree.contains(6));
		assertTrue(tree.contains(8));
		assertTrue(tree.contains(7));
		assertTrue(tree.contains(5));
		assertTrue(tree.contains(2));
		assertTrue(tree.contains(3));
		assertTrue(tree.contains(4));
		assertTrue(tree.contains(0));
		assertTrue(tree.contains(1));
		assertTrue(tree.contains(2));
		assertTrue(tree.contains(0));
		assertTrue(tree.contains(3));
		assertTrue(tree.contains(4));
		assertTrue(tree.contains(1));
		assertTrue(tree.contains(10));
		assertTrue(tree.contains(21));
		assertTrue(tree.contains(24));
		assertTrue(tree.contains(2));
		assertTrue(tree.contains(5));
		assertTrue(tree.contains(8));
		assertTrue(tree.contains(11));
		assertFalse(tree.contains(22));
		assertFalse(tree.contains(30));
		assertFalse(tree.contains(12));
		assertFalse(tree.contains(18));
		assertFalse(tree.contains(111));
		assertEquals(15,tree.size());
		assertEquals(2,tree.height());
		assertEquals(new Integer(24),tree.getMax());
		assertEquals(new Integer(0),tree.getMin());
		assertFalse(tree.isEmpty());
	}
	
	@Test
	public void case4() {
		BTree tree = new MyBTree(1);
		assertTrue(tree.isEmpty());
		tree.insert("TestValues4.txt");
		assertTrue(tree.contains(1));
		assertTrue(tree.contains(0));
		assertTrue(tree.contains(3));
		assertTrue(tree.contains(8));
		assertTrue(tree.contains(2));
		assertTrue(tree.contains(4));
		assertTrue(tree.contains(7));
		assertTrue(tree.contains(9));
		assertTrue(tree.contains(10));
		assertTrue(tree.contains(30));
		assertTrue(tree.contains(11));
		assertTrue(tree.contains(15));
		assertTrue(tree.contains(34));
		assertFalse(tree.contains(22));
		assertFalse(tree.contains(23));
		assertFalse(tree.contains(18));
		assertFalse(tree.contains(21));
		assertFalse(tree.contains(20));
		assertEquals(14,tree.size());
		assertEquals(3,tree.height());
		assertEquals(new Integer(34),tree.getMax());
		assertEquals(new Integer(0),tree.getMin());
		assertFalse(tree.isEmpty());
	}
}
