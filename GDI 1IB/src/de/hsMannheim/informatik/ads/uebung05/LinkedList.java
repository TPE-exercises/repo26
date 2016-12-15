package de.hsMannheim.informatik.ads.uebung05;

import static gdi.MakeItSimple.*;

public class LinkedList {

	static final int notFound = Integer.MIN_VALUE;
	public ListNode head;

	public LinkedList() {
		head = null;

	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		int index;
		int value;
		boolean runMain = true;

		do {
			println("------------------- Menue -------------------");
			println("1: Print List");
			println("2: Print size of the list");
			println("3: add(index, element)");
			println("4: addFirst(element)");
			println("5: addLast(element)");
			println("6: addAll(LinkedList)");
			println("7: get(index)");
			println("8: getFirst()");
			println("9: getLast()");
			println("10: removeFirst()");
			println("11: removeLast()");
			println("12: removeAll()");// clear
			println("13: remove(element)");// delete
			println("0: end program");

			int selection = readInt();
			readLine();
			
			println("Mit welcher Liste wollen Sie arbeiten?");
			String listName = readLine();
			
			trenner();
			switch (selection) {
			case 1:
				println("[toString] List: " + list);
				break;
			case 2:
				println("[size] Anzahl Elemente: " + list.size(list));
				break;
			case 3:
				do {
					println("Geben Sie den Index an, an den sie einfügen wollen.");
					index = readInt();
					readLine();
				} while (index < 0);

				println("Geben Sie den Wert ein, den sie eimfügen wollen.");
				value = readInt();
				readLine();

				list.add(index, value, list);
				println("[add] " + value + " to index " + index);
				break;
			case 4:
				println("Geben Sie den Wert ein, den sie eimfügen wollen.");
				value = readInt();
				readLine();
				list.addFirst(value, list);
				println("Wert " + value + " an erster Stelle eingefügt.");
				break;
			case 5:
				println("Geben Sie den Wert ein, den sie eimfügen wollen.");
				value = readInt();
				readLine();
				list.addLast(value, list);
				println("Wert " + value + " an letzter Stelle eingefügt.");
				break;
			case 6:

				// list.addAll(otherList, list);
				break;
			case 7:
				do {
					println("Geben Sie den Index an");
					index = readInt();
					readLine();
				} while (index < 0);
				int thisValue = list.get(index, list);
				if (thisValue == notFound)
					println("An ihrem angegebenen Index (" + index + ") befindet sich kein Element.");
				else
					println("Der Wert an IndexStelle " + index + " ist " + thisValue);
				break;
			case 8:
				thisValue = list.getFirst(list);
				if (thisValue == notFound)
					println("An der ersten Stelle befindet sich kein Element.");
				else
					println("Der erste Wert in der Liste ist:" + thisValue);
				break;
			case 9:
				thisValue = list.getLast(list);
				if (thisValue == notFound)
					println("In der Liste befinden sich keine Elemente.");
				else
					println("Der letzte Wert in der Liste ist: " + thisValue);
				break;
			case 10:
				list.removeFirst(list);
				println("[removeFirst]");
				break;
			case 11:
				println("nicht vorhanden");
				break;
			case 12:
				list.clear(list);
				println("[clearList]");
				break;
			case 13:
				println("Geben Sie den Wert ein, den Sie löschen möchten.");
				value = readInt();
				readLine();
				list.delete(value, list);
				println("Wert " + value + " gelöscht.");
				break;
			case 0:
				runMain = false;
				println("--> Programm beendet <--");
			}
			trenner();println();
		} while (runMain);

		// ____________________________________________________________OldMainBeginn__________________
		// trenner();
		// println("[addFirst] 10");
		// list.addFirst(10, list);
		//
		// trenner();
		// println("[addFirst] 9");
		// list.addFirst(9, list);
		//
		// trenner();
		// println("[addFirst] 8");
		// list.addFirst(8, list);
		//
		// trenner();
		// println("[addFirst] 7");
		// list.addFirst(7, list);
		// trenner();
		//
		// println("[toString] List: " + list);
		//
		// int[] array = list.toArray(list);
		// print("[toArray] Array: ");
		// for (int i = 0; i < array.length; i++) {
		// print(array[i] + " ");
		// }
		// println();
		//
		// println("[size] Anzahl Elemente: " + list.size(list));
		//
		// println("[isEmpty]: " + list.isEmpty(list));
		//
		// int index = 3;
		// println("[get] Wert an Stelle " + index + ": " + list.get(index,
		// list));
		//
		// println("[getFirst] Erster Wert: " + list.getFirst(list));
		// println("[getLast] Letzter Wert: " + list.getLast(list));
		// trenner();
		// println("[removeFirst]");
		// list.removeFirst(list);
		// trenner();
		//
		// println("[getFirst] Erster Wert: " + list.getFirst(list));
		//
		// int element = 9;
		// println("[contains] Wert " + element + " enthalten: " +
		// list.contains(element, list));
		//
		// trenner();
		// println("[delete] 9");
		// list.delete(9, list);
		// trenner();
		//
		// println("[contains] Wert " + element + " enthalten: " +
		// list.contains(element, list));
		//
		// trenner();
		// println("[clear]");
		// list.clear(list);
		// trenner();
		//
		// println("[isEmpty]: " + list.isEmpty(list));
		//
		// trenner();
		// list.addLast(11, list);
		// println("[addLast] 11");
		// trenner();
		// list.addLast(1, list);
		// println("[addLast] 1");
		// trenner();
		//
		// println("[toString] List: " + list);
		//
		// trenner();
		// list.add(0, 12, list);
		// println("[add] 12 to index 1");
		// trenner();
		//
		// println("[toString] List: " + list);

	}

	/**
	 * Fertig
	 * 
	 * @return LinkedList
	 */
	LinkedList empty() {
		LinkedList list = new LinkedList();

		return list;
	}

	/**
	 * Fertig
	 * 
	 * @param list
	 * @return cleared list
	 */
	LinkedList clear(LinkedList list) {
		ListNode head = null;
		this.head = head;

		return list;

	}

	/**
	 * Fertig, wenn element an erster Stelle, rufe removeFirst auf
	 * 
	 * @param value
	 * @param list
	 * @return list
	 */
	LinkedList delete(int element, LinkedList list) {

		ListNode savedNode = new ListNode(0, null);
		ListNode previousNode = new ListNode(0, null);
		savedNode = head;
		previousNode = head;

		if (head == null)
			return list;
		if (head.getValue() == element) {
			list.removeFirst(list);
			return list;
		}
		for (int i = 0; i < list.size(list); i++) {
			if (element == savedNode.getValue()) {
				previousNode.setNext(savedNode.getNext());
				return list;
			}
			previousNode = savedNode;
			savedNode = savedNode.getNext();
		}

		return list;

	}

	/**
	 * Fertig, check size, if size == 0, list is empty
	 * 
	 * @param LinkedList
	 * @return
	 */
	boolean isEmpty(LinkedList list) {
		if (list.size(list) == 0)
			return true;
		else
			return false;
	}

	/**
	 * Fertig
	 * 
	 * @param element
	 * @param list
	 * @return boolean
	 */
	boolean contains(int element, LinkedList list) {
		ListNode speicher = new ListNode(0, null);
		speicher = head;

		for (int i = 0; i < list.size(list); i++) {
			if (element == speicher.getValue())
				return true;
			speicher = speicher.getNext();
		}
		return false;
	}

	/**
	 * Fertig
	 * 
	 * @param list
	 * @return
	 */
	int size(LinkedList list) {
		int zaehler = 0;
		boolean notLastElement = true;
		ListNode speicher = new ListNode(0, null);
		speicher = head;

		if (this.head == null)
			return zaehler;

		while (notLastElement) {
			zaehler++;

			if (speicher.getNext() != null)
				speicher = speicher.getNext();
			else
				notLastElement = false;
		}
		return zaehler;

	}

	/**
	 * Fertig
	 * 
	 * @param list
	 * @return newlist
	 */
	LinkedList clone(LinkedList list) {
		LinkedList newlist = new LinkedList();
		newlist = list;
		return newlist;
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
	 * @do konkateniert die aktuelle Liste mit otherList indem die Listen
	 *     jeweils tief kopiert werden
	 * @param otherList
	 * @return Als Ergebnis wird die konkatenierte Liste zurÃ¼ckgegeben
	 */
	LinkedList concat(LinkedList otherList) {

		return otherList;
	}

	/**
	 * Fertig
	 * 
	 * @param index
	 * @param list
	 * @return value (-1 if index not in List)
	 * @exception index
	 *                not in List
	 */
	int get(int index, LinkedList list) {
		int value = 0;
		ListNode speicher = new ListNode(0, null);
		speicher = head;
		int size = list.size(list);
		if (index > size)
			return notFound;

		for (int i = 0; i < index; i++) {

			value = speicher.getValue();
			speicher = speicher.getNext();

		}

		return value;
	}

	/**
	 * Fertig
	 * 
	 * @param LinkedList
	 * @return value
	 */
	int getFirst(LinkedList list) {

		if (head == null)
			return notFound;

		return head.getValue();
	}

	/**
	 * Fertig
	 * 
	 * @param LinkedList
	 * @return Value
	 */
	int getLast(LinkedList list) {
		int value = 0;
		ListNode speicher = new ListNode(0, null);
		speicher = head;

		for (int i = 0; i < list.size(list); i++) {
			value = speicher.getValue();
			speicher = speicher.getNext();

		}
		return value;
	}

	/**
	 * Fertig
	 * 
	 * @param list
	 * @return list
	 */
	LinkedList removeFirst(LinkedList list) {

		if (head == null)
			return list;
		head = head.getNext();
		return list;
	}

	/**
	 * Fertig, if index == 0 -> addFirst
	 * 
	 * @param index
	 * @param element
	 * @param list
	 * @return list
	 * @exception negativer
	 *                index
	 */
	LinkedList add(int index, int element, LinkedList list) {
		ListNode node = new ListNode(element, null);
		ListNode saveNode = new ListNode(0, null);
		ListNode previusNode = new ListNode(0, null);
		saveNode = head;
		previusNode = head;

		if (index > list.size(list)) {
			list.addLast(element, list);
			return list;
		}

		if (index == 0) {
			list.addFirst(element, list);
			return list;
		}

		for (int i = 0; i < index; i++) {

			previusNode = saveNode;
			saveNode = saveNode.getNext();
		}
		node.setNext(saveNode);
		previusNode.setNext(node);

		return list;

	}

	/**
	 * Fertig
	 * 
	 * @param element
	 * @param list
	 * @return list
	 */
	LinkedList addFirst(int element, LinkedList list) {

		ListNode node = new ListNode(element, null);
		node.setNext(head);
		head = node;
		return list;
	}

	/**
	 * Fertig
	 * 
	 * @param element
	 * @param list
	 * @return list
	 */
	LinkedList addLast(int element, LinkedList list) {
		ListNode node = new ListNode(element, null);
		ListNode savedNode = new ListNode(0, null);
		int size = list.size(list);
		savedNode = head;

		if (size == 0)
			head = node;

		for (int i = 0; i < size; i++) {
			if (savedNode.getNext() == null) {
				savedNode.setNext(node);
				return list;
			}
			savedNode = savedNode.getNext();
		}
		return null;

	}

	/**
	 * Vieleicht Fertig nocht testen
	 * 
	 * @param otherList
	 * @param list
	 * @return list
	 */
	LinkedList addAll(LinkedList otherList, LinkedList list) {
		ListNode otherNode = new ListNode(0, null);
		ListNode speicher = new ListNode(0, null);
		speicher = list.head;
		otherNode = otherList.head;
		int size = list.size(list);

		for (int i = 0; i < size; i++) {
			speicher = speicher.getNext();
		}
		speicher.setNext(otherNode);

		return list;

	}

	/**
	 * Fertig
	 * 
	 * @param list
	 * @return array int[]
	 */
	int[] toArray(LinkedList list) {
		int[] array = new int[list.size(list)];
		ListNode speicher = new ListNode(0, null);
		speicher = head;

		if (this.head == null)
			return array;

		for (int i = 0; i < array.length; i++) {
			array[i] = speicher.getValue();
			speicher = speicher.getNext();

		}

		return array;
	}

	/**
	 * Fertig
	 * 
	 * @return String
	 */
	public String toString() {
		String string = "";
		boolean goOn = true;
		ListNode speicher = new ListNode(0, null);
		speicher = head;

		if (this.head == null)
			return "Die Liste ist leer.";

		while (goOn) {
			int lustigerName = speicher.getValue();
			string += " " + lustigerName;

			if (speicher.getNext() != null)
				speicher = speicher.getNext();
			else
				goOn = false;
		}

		return string;
	}

	/**
	 * Print seperator to console
	 */
	private static void trenner() {
		println("-------------------------------------");

	}
}
