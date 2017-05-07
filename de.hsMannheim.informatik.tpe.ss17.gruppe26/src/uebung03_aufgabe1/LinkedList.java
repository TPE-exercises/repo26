package uebung03_aufgabe1;

import static gdi.MakeItSimple.*;

public class LinkedList implements Queue {

	public static final int MAX_QUEUE_LENGTH = Integer.MAX_VALUE;
	private static boolean existList1 = true; // standartList1
	private static boolean existList2 = true; // standartList2
	private static boolean existAddAllList = false;
	private static boolean existConcatList = false;
	private static boolean existClonedList = false;
	private static boolean existClonedDeepList = false;

	private static boolean existArray = false;
	private static LinkedList list1 = new LinkedList();
	private static LinkedList list2 = new LinkedList();
	private static LinkedList addAllList = new LinkedList();
	private static LinkedList concatList = new LinkedList();
	private static LinkedList clonedList = new LinkedList();
	private static LinkedList clonedDeepList = new LinkedList();
	public static boolean isEntered = false;
	public static boolean isLeaved = false;
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
			println("------------------- Verfügbare Listen -------------------");
			if (existList1)
				println("1: list1");
			if (existList2)
				println("2: list2");
			if (existClonedList)
				println("3: ClonedList ");
			if (existClonedDeepList)
				println("4: ClonedDeepList ");
			if (existAddAllList)
				println("5: AddAllList ");
			if (existConcatList)
				println("6: ConcatList");
			if (existArray)
				println("7: Array");
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
			println("17: toArray");
			println("0: end program");

			int selection = readInt();
			readLine();

			LinkedList l1 = new LinkedList();
			println("Geben Sie an, welche Liste sie bearbeiten wollen.");
			int listChoise = readInt();
			readLine();
			switch (listChoise) {
			case 1:
				l1 = list1;
				break;
			case 2:
				l1 = list2;
				break;
			case 3:
				l1 = clonedList;

				break;
			case 4:
				l1 = clonedDeepList;

				break;
			case 5:
				l1 = addAllList;
				break;
			case 6:
				l1 = concatList;
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
					println("Geben Sie den Index an, an den Sie einfügen wollen.");
					index = readInt();
					readLine();
				} while (index < 0);

				println("Geben Sie den Wert ein, den Sie einfügen wollen.");
				value = readInt();
				readLine();

				boolean successfulAdded = l1.add(index, value, l1);
				if (successfulAdded)
					println("[add] " + value + " to index " + index);
				else
					println("Der Wert konnte nicht hinzugefügt werden, ggf. existiert der Index nicht.");
				break;
			case 4:
				println("Geben Sie den Wert ein, den Sie einfügen wollen.");
				value = readInt();
				readLine();
				boolean successfulAddedFirst = l1.addFirst(value, l1);
				if (successfulAddedFirst)
					println("Wert " + value + " an erster Stelle eingefügt.");
				else
					println("Unbekannter Fehler");
				break;
			case 5:
				println("Geben Sie den Wert ein, den Sie einfügen wollen.");
				value = readInt();
				readLine();
				boolean successfulAddedLast = l1.addLast(value, l1);
				if (successfulAddedLast)
					println("Wert " + value + " an letzter Stelle eingefügt.");
				else
					println("Unbekannter Fehler");
				break;
			case 6:
				println("Geben Sie an, welche Liste, ihrer hinzugefügt werden soll.");
				LinkedList l2 = new LinkedList();
				listChoise = readInt();
				readLine();
				switch (listChoise) {
				case 1:
					l2 = list1;
					break;
				case 2:
					l2 = list2;
					break;
				case 3:
					l2 = clonedList;

					break;
				case 4:
					l2 = clonedDeepList;

					break;
				case 5:
					l2 = addAllList;
					break;
				case 6:
					l2 = concatList;
					break;
				default:
					println("falsche eingabe");

				}
				addAllList = l1.addAll(l2, l1);
				existAddAllList = true;
				break;
			case 7:// get
				do {
					println("Geben Sie den Index an");
					index = readInt();
					readLine();
				} while (index < 0);

				int thisValue = l1.get(index, l1);
				if (thisValue == notFound)
					println("An ihrem angegebenen Index (" + index + ") befindet sich kein Element.");
				else
					println("Der Wert an IndexStelle " + index + " ist " + thisValue);
				break;
			case 8:// getFirst
				thisValue = l1.getFirst(l1);
				if (thisValue == notFound)
					println("An der ersten Stelle befindet sich kein Element.");
				else
					println("Der erste Wert in der Liste ist:" + thisValue);
				break;
			case 9:// getLast
				thisValue = l1.getLast(l1);
				if (thisValue == notFound)
					println("In der Liste befinden sich keine Elemente.");
				else
					println("Der letzte Wert in der Liste ist: " + thisValue);
				break;
			case 10:// removeFirst
				boolean successfulRemovedFirst = l1.removeFirst(l1);
				if (successfulRemovedFirst)
					println("[removeFirst]");
				else
					println("Wert konnte nicht gelöscht werden, ggf. existiert er nicht.");
				break;
			case 11:// removeLast
				boolean successfulRemovedLast = l1.removeLast(l1);
				if (successfulRemovedLast)
					println("[removeLast]");
				else
					println("Wert konnte nicht gelöscht werden, ggf. existiert er nicht.");

				break;
			case 12:// clear
				boolean successfulCleared = l1.clear(l1);
				if (successfulCleared)
					println("[clearList]");
				else
					println("Liste konnte nicht gecleared werden, ggf ist sie schon leer.");
				break;
			case 13:// delete
				println("Geben Sie den Wert ein, den Sie löschen möchten.");
				value = readInt();
				readLine();
				boolean deleteSuccesful = l1.delete(value, l1);
				if (deleteSuccesful)
					println("Wert " + value + " gelöscht.");
				else
					println("Wert konnte nicht gelöscht werden. Ggf. ist er nicht vorhanden.");
				break;
			case 14:// clone
				clonedList = l1.clone(l1);
				existClonedList = true;
				break;
			case 15:// concat
				println("Geben Sie an, mit welcher Liste, ihre konkateniert werden soll.");
				l2 = new LinkedList();
				listChoise = readInt();
				readLine();
				switch (listChoise) {
				case 1:
					l2 = list1;
					break;
				case 2:
					l2 = list2;
					break;
				case 3:
					l2 = clonedList;

					break;
				case 4:
					l2 = clonedDeepList;

					break;
				case 5:
					l2 = addAllList;
					break;
				case 6:
					l2 = concatList;
					break;
				default:
					println("falsche eingabe");
				}
				concatList = l1.concat(l2, l1);
				existConcatList = true;
				break;
			case 16:
				clonedDeepList = l1.cloneDeep(l1);
				existClonedDeepList = true;
				break;
			case 17:
				l1.toArray(l1);
				existArray = true;
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
	 * creates a new empty list
	 * 
	 * @return LinkedList
	 */
	static LinkedList empty() {
		LinkedList list = new LinkedList();

		return list;
	}

	/**
	 * clears a list
	 * 
	 * @param list
	 * @return boolean (successful cleared list)
	 */
	boolean clear(LinkedList list) {
		ListNode head = null;
		this.head = head;

		return true;

	}

	/**
	 * deletes the first element with the value
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
			return true;
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
	 * @param LinkedList
	 * @return boolen (true if empty)
	 */
	public boolean isEmpty(LinkedList list) {
		if (list.size(list) == 0)
			return true;
		else
			return false;
	}

	/**
	 * check if value is in list
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
	 * @param list
	 * @return int (size of list)
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
	 * (not deep) clones a list
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
	 * clones a list deep
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
//			ListNode savedNode2 = new ListNode(0, null);
			newList.addLast(savedNode.getValue(), newList);

			savedNode = savedNode.getNext();
		}

		return newList;
	}

	/**
	 * clones two lists deep, than addAll
	 * 
	 * @param otherList
	 * @return newList
	 */
	LinkedList concat(LinkedList otherList, LinkedList list) {
		LinkedList list1 = list.cloneDeep(list);
		LinkedList list2 = otherList.cloneDeep(otherList);

		list1.addAll(list2, list1);

		return list1;
	}

	/**
	 * @param index
	 * @param list
	 * @return value
	 * @exception index
	 *                not in List returns Integer.MIN_VALUE
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
	 * @param LinkedList
	 * @return value
	 * @exception no
	 *                first element returns Integer.MIN_VALUE
	 */
	int getFirst(LinkedList list) {

		if (head == null)
			return notFound;

		return head.getValue();
	}

	/**
	 * @param LinkedList
	 * @return Value
	 * @exception no
	 *                last element returns Integer.MIN_VALUE
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
	 * @param list
	 * @return boolean (successful removed)
	 */
	boolean removeFirst(LinkedList list) {

		if (head == null)
			return false;
		head = head.getNext();
		return true;
	}

	/**
	 * @param list
	 * @return boolean (successful removed)
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
	 * @param index
	 * @param element
	 * @param list
	 * @return boolean successful added
	 * @exception if
	 *                index not reachable return false
	 */
	boolean add(int index, int element, LinkedList list) {
		ListNode node = new ListNode(element, null);
		ListNode saveNode = new ListNode(0, null);
		ListNode previusNode = new ListNode(0, null);
		saveNode = head;
		previusNode = head;

		if (index == 0) {
			list.addFirst(element, list);
			return true;
		}
		if (index == list.size(list)) {
			list.addLast(element, list);
			return true;
		}
		if (index > list.size(list) || index < 0) {
			return false;
		}
		for (int i = 0; i <= index; i++) {

			previusNode = saveNode;
			saveNode = saveNode.getNext();
		}
		node.setNext(saveNode);
		previusNode.setNext(node);

		return true;

	}

	/**
	 * 
	 * @param element
	 * @param list
	 * @return boolean (successful added)
	 */
	boolean addFirst(int element, LinkedList list) {

		ListNode node = new ListNode(element, null);
		node.setNext(head);
		head = node;
		return true;
	}

	/**
	 * @param element
	 * @param list
	 * @return boolean (successful added)
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

		if (size == 0) {
			list.head = otherList.head;
			return list;
		}

		for (int i = 0; i < size - 1; i++) {
			speicher = speicher.getNext();

		}
		speicher.setNext(otherNode);

		return list;

	}

	/**
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
	public static void trenner() {
		println("-------------------------------------");

	}

	/**
	 * 
	 * @param element
	 * @param list
	 * @return
	 */
	@Override
	public LinkedList enter(int element, LinkedList list) {
		if (list.size(list) >= MAX_QUEUE_LENGTH) {
			println("Die Warteschlange (Queue) ist voll und somit kann kein weiteres Element hinzugefügt werden.");
			isEntered = false;
			return list;
		} else {
			list.addLast(element, list);
			println("size: " + list.size(list));
			isEntered = true;
			return list;
		}
	}

	@Override
	public LinkedList leave(LinkedList list) {
		if (list.size(list)== 0) {
			println("Die Warteschlange (Queue) ist leer und somit kann kein Element entfernt werden.");
			isLeaved = false;
			return list;
		} else {
		list.removeFirst(list);
		isLeaved = true;
		return list;
		}
	}

	@Override
	public int front(LinkedList list) {
		int element = list.getFirst(list);
		return element;
	}

	@Override
	public LinkedList emptyQueue() {
		LinkedList list = new LinkedList();

		return list;
	}
}
