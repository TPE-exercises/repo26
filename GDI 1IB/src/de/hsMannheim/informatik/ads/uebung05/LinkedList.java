package de.hsMannheim.informatik.ads.uebung05;

import static gdi.MakeItSimple.*;

public class LinkedList {


	private int element;
	private int next;

	LinkedList(int element, int next){
		this.element = element;
		this.next = next;		
	}
	
	LinkedList list = new LinkedList(element, next);
	
	public static void main(String[] args) {

	}
	
	/**
	 * 
	 * @return LinkedList 
	 */
	LinkedList empty(){
		LinkedList list = new LinkedList(0, 0);
		
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
		
		
		
		return list;
	}

	/**
	 * @return String
	 */
	public String toString() {
		return null;
	}

	/**
	 * 
	 * @param index
	 * @param element
	 * @param list
	 * @return
	 */
	LinkedList add(int index, int element, LinkedList list) {
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
	 * @return Als Ergebnis wird die konkatenierte Liste zurückgegeben
	 */
	LinkedList concat(LinkedList otherList) {

		return otherList;
	}

	public void addFirst(MyObject obj1) {
	} // it works for all kind of (My)Object
}
