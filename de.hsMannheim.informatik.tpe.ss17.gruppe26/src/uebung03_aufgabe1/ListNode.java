package uebung03_aufgabe1;

public class ListNode {
	private int value;
	private ListNode next;

	/**
	 * 
	 * @param value
	 * @param next
	 */
	public ListNode(int value, ListNode next){
		this.value = value;
		this.next = next;
	}
	
	/**
	 * Fertig
	 * @return
	 */
	public int getValue() {
		return this.value;
	}

	/**
	 * Fertig
	 * @param value
	 */
	public void setValue(int value) {
		this.value = value;
	}
	
	/**
	 * Fertig
	 * @return the next element
	 */
	public ListNode getNext() {
		return this.next;
	}
	
	/**
	 * Fertig
	 * @param next
	 *            the new next element
	 */
	public void setNext(ListNode next) {
		this.next = next;
	}

	
}