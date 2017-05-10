package uebung03_aufgabe1;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import myUtil.ADT;
import myUtil.Node;
import myUtil.OverflowException;
import myUtil.QueueArray;
import myUtil.QueueList;
import myUtil.StackArray;
import myUtil.StackList;
import myUtil.UnderflowException;

public class ADT_Test {

	private static ADT s1 = new myUtil.StackList();
	private static ADT s2 = new myUtil.StackArray();
	private static ADT q1 = new myUtil.QueueList();
	private static ADT q2 = new myUtil.QueueArray();

	@Before
	public void bevore() {
		s1 = new StackList();
		s2 = new StackArray();
		q1 = new QueueList();
		q2 = new QueueArray();
	}

	@Test
	public void queue_List() throws Exception {
		enter(q1, new Integer(0));
		enter(q1, new Integer(1));
		enter(q1, new Integer(2));
		assertEquals(3, size(q1));
		assertEquals(new Integer(0), front(q1));
		assertFalse(isEmpty(q1));
	}

	@Test
	public void queue_Array() throws Exception {
		enter(q2, new Integer(0));
		enter(q2, new Integer(1));
		enter(q2, new Integer(2));
		assertEquals(3, size(q2));
		assertEquals(new Integer(0), front(q2));
		assertFalse(isEmpty(q2));
	}

	@Test
	public void stack_List() throws Exception {
		enter(s1, new Integer(0));
		enter(s1, new Integer(1));
		enter(s1, new Integer(2));
		assertEquals(3, size(s1));
		assertEquals(new Integer(2), front(s1));
		assertFalse(isEmpty(s1));
	}

	@Test
	public void stack_Array() throws Exception {
		enter(s2, new Integer(0));
		enter(s2, new Integer(1));
		enter(s2, new Integer(2));
		assertEquals(3, size(s2));
		assertEquals(new Integer(2), front(s2));
		assertFalse(isEmpty(s2));
	}

	@Test(expected = OverflowException.class)
	public void queue_List_Overflow() throws Exception {

		enter(q1, new Integer(0));
		enter(q1, new Integer(1));
		enter(q1, new Integer(2));
		enter(q1, new Integer(3));
		enter(q1, new Integer(4));
		enter(q1, new Integer(5));

	}

	@Test(expected = OverflowException.class)
	public void queue_Array_Overflow() throws Exception {
		enter(q2, new Integer(0));
		enter(q2, new Integer(1));
		enter(q2, new Integer(2));
		enter(q2, new Integer(3));
		enter(q2, new Integer(4));
		enter(q2, new Integer(5));
	}

	@Test(expected = OverflowException.class)
	public void stack_List_Overflow() throws Exception {
		enter(s1, new Integer(0));
		enter(s1, new Integer(1));
		enter(s1, new Integer(2));
		enter(s1, new Integer(3));
		enter(s1, new Integer(4));
		enter(s1, new Integer(5));
	}

	@Test(expected = OverflowException.class)
	public void stack_Array_Overflow() throws Exception {
		enter(s2, new Integer(0));
		enter(s2, new Integer(1));
		enter(s2, new Integer(2));
		enter(s2, new Integer(3));
		enter(s2, new Integer(4));
		enter(s2, new Integer(5));
	}

	@Test(expected = UnderflowException.class)
	public void queue_List_Underflow() throws Exception {

		enter(q1, new Integer(0));
		enter(q1, new Integer(1));
		enter(q1, new Integer(2));
		enter(q1, new Integer(3));
		leave(q1);
		leave(q1);
		leave(q1);
		leave(q1);
		leave(q1);

	}

	@Test(expected = UnderflowException.class)
	public void queue_Array_Underflow() throws Exception {
		enter(q2, new Integer(0));
		enter(q2, new Integer(1));
		enter(q2, new Integer(2));
		enter(q2, new Integer(3));
		leave(q2);
		leave(q2);
		leave(q2);
		leave(q2);
		leave(q2);
	}

	@Test(expected = UnderflowException.class)
	public void stack_List_Underflow() throws Exception {
		enter(s1, new Integer(0));
		enter(s1, new Integer(1));
		enter(s1, new Integer(2));
		enter(s1, new Integer(3));
		leave(s1);
		leave(s1);
		leave(s1);
		leave(s1);
		leave(s1);
	}

	@Test(expected = UnderflowException.class)
	public void stack_Array_Underflow() throws Exception {
		enter(s2, new Integer(0));
		enter(s2, new Integer(1));
		enter(s2, new Integer(2));
		enter(s2, new Integer(3));
		leave(s2);
		leave(s2);
		leave(s2);
		leave(s2);
		leave(s2);
	}

	private static void enter(ADT adt, Object element) throws Exception {
		adt.enter(element);
	}

	private static Object leave(ADT adt) throws Exception {
		return adt.leave();
	}

	private static Object front(ADT adt) {
		return adt.front();
	}

	private static boolean isEmpty(ADT adt) {
		return adt.isEmpty();
	}

	private static int size(ADT adt) {
		return adt.size();
	}

	public static String toString(ADT adt, Node node) {
		return adt.toString(node);
	}

}
