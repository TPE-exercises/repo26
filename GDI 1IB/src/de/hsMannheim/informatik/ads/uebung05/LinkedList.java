package de.hsMannheim.informatik.ads.uebung05;

import static gdi.MakeItSimple.*;

public class LinkedList {

	public static int value;
	public LinkedList next;
	public static ListNode head = new ListNode (0, null);
	
	public LinkedList(ListNode head){
		this.head = head;

	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList(head);
		
		list.addFirst(10, list);
		list.addFirst(9, list);
		list.addFirst(8, list);
		list.addFirst(7, list);
		
		print("List: " + list);
		
	}
	
	/**
	 * Fertig
	 * @return LinkedList 
	 */
	LinkedList empty(){
		LinkedList list = new LinkedList();
		
		return list;	
	}
	/**
	 * 
	 * @param element
	 * @param list
	 * @return
	 */
	boolean contains (int element, LinkedList list){
		
		
		return false;
	}
	/**
	 * 
	 * @param list
	 * @return
	 */
	LinkedList clear (LinkedList list){
		return list;
		
	}
	/**
	 * 
	 * @param list
	 * @return
	 */
	int size(LinkedList list){
		return 0;
		
	}
	/**
	 * 
	 * @param list
	 * @return
	 */
	LinkedList clone(LinkedList list){
		return list;
		
	}
	/**
	 * 
	 * @param element
	 * @param list
	 * @return
	 */
	LinkedList delete (int element, LinkedList list){
		return list;
		
	}
	/**
	 * @param LinkedList
	 * @return
	 */
	boolean isEmpty(LinkedList list){
		
		return false;
	}
	/**
	 * @param LinkedList
	 * @return
	 */
	int getLast(LinkedList list){
		return 0;
	}
	/**
	 * @param LinkedList
	 * @return
	 */
	int getFirst(LinkedList list){

		
		return 0;
	}
	/**
	 * 
	 * @param list
	 * @return
	 */
	LinkedList removeFirst(LinkedList list){
		return list;
		
	}
	/**
	 * 
	 * @param element
	 * @param list
	 * @return
	 */
	LinkedList addLast(int element, LinkedList list){
		return null;
		
	}
	/**
	 * 
	 * @param element
	 * @param list
	 * @return
	 */
	LinkedList addFirst(int element, LinkedList list){

		ListNode node = new ListNode(element, null);
		node.setNext(head);
		head = node;
		
		
		//next same as Head.next
		//head pointer neu setzten
		
		return list;
	}
	/**
	 * @return String
	 */
	public String toString() {
		String string = "";
		boolean goOn = true;
		ListNode speicher = new ListNode(0, null);
		speicher = head;
		
		while(goOn){
			int lustigerName = speicher.getValue();
			string += " " + lustigerName;
			
			if(speicher.getNext() != null)
				speicher = speicher.getNext();
			else 
				goOn = false;
		}
		
		
		return string;
	}
	/**
	 * 
	 * @param index
	 * @param element
	 * @param list
	 * @return
	 */
	LinkedList add(int index, int element, LinkedList list) {
		
		
		//neues Node erstellen
		//mit wert belegen
		//ListNode.getNext -> pointer setzen
		//getPrevius -> pointer setzen

		return list;

	}

	/**
	 * 
	 * @param index
	 * @param list
	 * @return
	 */
	int get(int index, LinkedList list) {
		return 0;
	}

	/**
	 * 
	 * @param list
	 * @return
	 */
	int[] toArray(LinkedList list) {

		return null;
	}

	/**
	 * 
	 * @param LinkedList
	 * @return
	 */
	LinkedList cloneDeep(int LinkedList) {
		return null;
	}

	/**
	 * 
	 * @param otherList
	 * @param list
	 * @return
	 */
	LinkedList addAll(LinkedList otherList, LinkedList list) {
		return list;

	}

	/**
	 * @do konkateniert die aktuelle Liste mit otherList indem die Listen
	 *     jeweils tief kopiert werden
	 * @param otherList
	 * @return Als Ergebnis wird die konkatenierte Liste zurÃ¼ckgegeben
	 */
	LinkedList concat(LinkedList otherList) {

		return otherList;
	}
}
