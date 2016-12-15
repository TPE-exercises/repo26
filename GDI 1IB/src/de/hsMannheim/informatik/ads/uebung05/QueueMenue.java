package de.hsMannheim.informatik.ads.uebung05;

import static gdi.MakeItSimple.println;
import static gdi.MakeItSimple.readInt;
import static gdi.MakeItSimple.readLine;

public class QueueMenue {

	static final int notFound = Integer.MIN_VALUE;
	
	public static void main(String[] args) {
		Queue queue;
		queue = new LinkedList();
		LinkedList QueueOfLinkedlist = queue.emptyQueue();
		boolean menue = true;
		while (menue){
		println("------------------- Menue -------------------");
		println("1: Print Queue");
		println("2: Enter a new Element to the Queue (enter)");
		println("3: Leave the first Element from the Queue (leave)");
		println("4: Get the First Element from the Queue (front)");
		println("5: Check for an empty Queue (isEmpty)");
		println("6: Beenden");
		
		int selection = readInt();
		readLine();

		LinkedList.trenner();
		switch (selection) {
		case 1://print Queue
			println("[toString] Queue: " + QueueOfLinkedlist);
			break;
		case 2:// addLast / enter
			println("Geben Sie den Wert ein, den sie eimfügen wollen.");
			int value = readInt();
			readLine();
			boolean successfulAddedLast = QueueOfLinkedlist.addLast(value, QueueOfLinkedlist);
			if (successfulAddedLast)
				println("Wert " + value + " an letzter Stelle eingefügt.");
			else
				println("Unbekannter Fehler");
			break;
		case 3:// removeFirst / leave
			boolean successfulRemovedFirst = QueueOfLinkedlist.removeFirst(QueueOfLinkedlist);
			if (successfulRemovedFirst)
				println("[removeFirst]");
			else
				println("Wert konnte nicht gelöscht werden, ggf. existiert er nicht.");
			break;
		case 4:// getFirst / front
			int thisValue = QueueOfLinkedlist.getFirst(QueueOfLinkedlist);
			if (thisValue == notFound)
				println("In der Queue befinden sich keine Elemente.");
			else
				println("Der erste Wert in der Queue ist: " + thisValue);
			break;
		case 5://isEmpty
			boolean isEmpty = QueueOfLinkedlist.isEmpty(QueueOfLinkedlist);
			println(" Die Queue ist Empty : " + isEmpty );
		case 6:
			menue = false;
			break;
		default:
			println("Falsche eingabe");
		

		LinkedList.trenner();
		println();
		}
	}

}
}
