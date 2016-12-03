package de.hsMannheim.informatik.ads.uebung05;

public class ListNode {
	private int value;
	private ListNode next;
	private MyObject element;

	/**
	 * 
	 * @return
	 */
	public int getValue() {
		return value;
	}

	/**
	 * 
	 * @param value
	 */
	public void setValue(int value) {
		this.value = value;
	}
	
	/**
	 * @return the next element
	 */
	public ListNode getNext() {
		return next;
	}
	
	/**
	 * @param next
	 *            the new next element
	 */
	public void setNext(ListNode next) {
		this.next = next;
	}

	/**
	 * @return the value of the current node
	 */
	public MyObject getElement() {
		return element;
	}

	/**
	 * @param value
	 *            the new value of the current node
	 */
	public void setElement(MyObject value) {
		this.element = value;
	}
}