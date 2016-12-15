package de.hsMannheim.informatik.ads.uebung05;

import static gdi.MakeItSimple.*;

import java.awt.List;

public class LinkedList {

	private static boolean existList1 = true; // standartList1
	private static boolean existList2 = true; // standartList2
	private static boolean existAddAllList = false;
	private static boolean existConcatList = false;
	private static boolean existClonedList = false;
	private static boolean existArray = false;
	private static LinkedList list1 = new LinkedList();
	private static LinkedList list2 = new LinkedList();
	private static LinkedList addAllList = new LinkedList();
	private static LinkedList concatList = new LinkedList();
	private static LinkedList clonedList = new LinkedList();

	static final int notFound = Integer.MIN_VALUE;
	public ListNode head;

	public LinkedList() {
		head = null;

	}

	public static void main(String[] args) {
		int index;
		int value;
		boolean runMain = true;

		do {
			println("------------------- Listen -------------------");
			if (existList1)
				println("list1");
			if(existList2)
				println("list2");
			if (existClonedList)
				println("ClonedList ");
			if (existAddAllList)
				println("AddAllList ");
			if (existConcatList)
				println("ConcatList");
			if (existArray)
				println("Array");
			println();
			
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
			println("14: clone(list)");
			println("15: concat(list)");
			println("16: cloneDeep(list)");
			println("0: end program");

			int selection = readInt();
			readLine();

			LinkedList l1 = new LinkedList();
			println("Geben sie an, welche Liste sie bearbeiten wollen.");
			String listChoise = readLine();
			switch (listChoise) {
			case "list1":
				l1 = list1;
				break;
			case "list2":
				l1 = list2;
				break;
			case "addAllList":
				l1 = addAllList;
				break;
			case "concatList":
				l1 = concatList;
				break;
			case "clonedList":
				l1 = clonedList;
				break;
			default:
				println("falsche eingabe");

			}

			trenner();
			switch (selection) {
			case 1:
				println("[toString] List: " + l1);
				break;
			case 2:
				println("[size] Anzahl Elemente: " + l1.size(list1));
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

				boolean successfulAdded = l1.add(index, value, l1);
				if (successfulAdded)
					println("[add] " + value + " to index " + index);
				else
					println("Der Wert konnte nicht hinzugefügt werden, ggf. existiert der Index nicht.");
				break;
			case 4:
				println("Geben Sie den Wert ein, den sie einfügen wollen.");
				value = readInt();
				readLine();
				boolean successfulAddedFirst = list1.addFirst(value, list1);
				if (successfulAddedFirst)
					println("Wert " + value + " an erster Stelle eingefügt.");
				else
					println("Unbekannter Fehler");
				break;
			case 5:
				println("Geben Sie den Wert ein, den sie eimfügen wollen.");
				value = readInt();
				readLine();
				boolean successfulAddedLast = list1.addLast(value, list1);
				if (successfulAddedLast)
					println("Wert " + value + " an letzter Stelle eingefügt.");
				else
					println("Unbekannter Fehler");
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
				int thisValue = list1.get(index, list1);
				if (thisValue == notFound)
					println("An ihrem angegebenen Index (" + index + ") befindet sich kein Element.");
				else
					println("Der Wert an IndexStelle " + index + " ist " + thisValue);
				break;
			case 8:
				thisValue = list1.getFirst(list1);
				if (thisValue == notFound)
					println("An der ersten Stelle befindet sich kein Element.");
				else
					println("Der erste Wert in der Liste ist:" + thisValue);
				break;
			case 9:
				thisValue = list1.getLast(list1);
				if (thisValue == notFound)
					println("In der Liste befinden sich keine Elemente.");
				else
					println("Der letzte Wert in der Liste ist: " + thisValue);
				break;
			case 10:
				boolean successfulRemovedFirst = list1.removeFirst(list1);
				if (successfulRemovedFirst)
					println("[removeFirst]");
				else
					println("Wert konnte nicht gelöscht werden, ggf. existiert er nicht.");
				break;
			case 11:
				boolean successfulRemovedLast = list1.removeLast(list1);
				if (successfulRemovedLast)
					println("[removeLast]");
				else
					println("Wert konnte nicht gelöscht werden, ggf. existiert er nicht.");

				break;
			case 12:
				boolean successfulCleared = list1.clear(list1);
				if (successfulCleared)
					println("[clearList]");
				else
					println("Liste konnte nicht gecleared werden, ggf ist sie schon leer.");
				break;
			case 13:
				println("Geben Sie den Wert ein, den Sie löschen möchten.");
				value = readInt();
				readLine();
				boolean deleteSuccesful = list1.delete(value, list1);
				if (deleteSuccesful)
					println("Wert " + value + " gelöscht.");
				else
					println("Wert konnte nicht gelöscht werden. Ggf. ist er nicht vorhanden.");
				break;
			case 14:
				clonedList=l1.clone(l1);
				existClonedList = true;
				
				
				break;
			case 15:
				break;
			case 16:
				break;
			case 0:
				runMain = false;
				println("--> Programm beendet <--");
			default:
				println("Falsche eingabe");
			}

			trenner();
			println();
		} while (runMain);

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
	 * @return boolean successful cleared list
	 */
	boolean clear(LinkedList list) {
		ListNode head = null;
		this.head = head;

		return true;

	}

	/**
	 * Fertig, wenn element an erster Stelle, rufe removeFirst auf
	 * 
	 * @param value
	 * @param list
	 * @return boolean succesfulll removed
	 */
	boolean delete(int element, LinkedList list) {

		ListNode savedNode = new ListNode(0, null);
		ListNode previousNode = new ListNode(0, null);
		savedNode = head;
		previousNode = head;

		if (head == null)
			return false;
		if (head.getValue() == element) {
			list.removeFirst(list);
			return false;
		}
		for (int i = 0; i < list.size(list); i++) {
			if (element == savedNode.getValue()) {
				previousNode.setNext(savedNode.getNext());
				return true;
			}
			previousNode = savedNode;
			savedNode = savedNode.getNext();
		}

		return false;

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
	 * Fertig
	 * 
	 * @param list
	 * @return newList
	 */
	LinkedList cloneDeep(LinkedList list) {
		LinkedList newList = new LinkedList();
		ListNode savedNode = new ListNode(0, null);
		savedNode = list.head;

		int size = list.size(list);

		for (int i = 0; i < size; i++) {
			ListNode savedNode2 = new ListNode(0, null);
			newList.addLast(savedNode.getValue(), newList);

			savedNode = savedNode.getNext();
		}

		return newList;
	}

	/**
	 * @do konkateniert die aktuelle Liste mit otherList indem die Listen
	 *     jeweils tief kopiert werden
	 * @param otherList
	 * @return Als Ergebnis wird die konkatenierte Liste zurÃ¼ckgegeben
	 */
	LinkedList concat(LinkedList otherList, LinkedList list) {
		LinkedList list1 = list.cloneDeep(list);
		LinkedList list2 = otherList.cloneDeep(otherList);

		list1.addAll(list2, list1);

		return list1;
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
		int value = notFound;
		ListNode speicher = new ListNode(0, null);
		speicher = head;
		int size = list.size(list);

		for (int i = 0; i < size; i++) {
			value = speicher.getValue();
			speicher = speicher.getNext();

		}
		return value;
	}

	/**
	 * Fertig
	 * 
	 * @param list
	 * @return boolean successful removed
	 */
	boolean removeFirst(LinkedList list) {

		if (head == null)
			return false;
		head = head.getNext();
		return true;
	}

	/**
	 * Fertig
	 * 
	 * @param list
	 * @return boolean successful removed
	 */
	boolean removeLast(LinkedList list) {

		ListNode saveNode = new ListNode(0, null);
		ListNode previusNode = new ListNode(0, null);
		saveNode = head;
		previusNode = head;
		int size = list.size(list);

		if (size == 0)
			return false;
		if (size == 1) {
			list.removeFirst(list);
			return true;
		}

		for (int i = 1; i < size; i++) {

			previusNode = saveNode;
			saveNode = saveNode.getNext();
			println(previusNode.getValue());
		}
		previusNode.setNext(null);

		return true;

	}

	/**
	 * Fertig
	 * 
	 * @param index
	 * @param element
	 * @param list
	 * @return boolean successful added
	 * @exception fehlerhafter
	 *                indexwert returns false
	 */
	boolean add(int index, int element, LinkedList list) {
		ListNode node = new ListNode(element, null);
		ListNode saveNode = new ListNode(0, null);
		ListNode previusNode = new ListNode(0, null);
		saveNode = head;
		previusNode = head;

		if (index > list.size(list) || index < 0) {
			return false;
		}

		if (index == 0) {
			list.addFirst(element, list);
			return true;
		}

		for (int i = 0; i < index; i++) {

			previusNode = saveNode;
			saveNode = saveNode.getNext();
		}
		node.setNext(saveNode);
		previusNode.setNext(node);

		return true;

	}

	/**
	 * Fertig
	 * 
	 * @param element
	 * @param list
	 * @return boolean successful added
	 */
	boolean addFirst(int element, LinkedList list) {

		ListNode node = new ListNode(element, null);
		node.setNext(head);
		head = node;
		return true;
	}

	/**
	 * Fertig
	 * 
	 * @param element
	 * @param list
	 * @return boolean successful added
	 */
	boolean addLast(int element, LinkedList list) {
		ListNode node = new ListNode(element, null);
		ListNode savedNode = new ListNode(0, null);
		int size = list.size(list);
		savedNode = head;

		if (size == 0) {
			head = node;
			return true;
		}

		for (int i = 0; i < size; i++) {
			if (savedNode.getNext() == null) {
				savedNode.setNext(node);
				return true;
			}
			savedNode = savedNode.getNext();
		}
		return true;

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

		for (int i = 0; i < size - 1; i++) {
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
