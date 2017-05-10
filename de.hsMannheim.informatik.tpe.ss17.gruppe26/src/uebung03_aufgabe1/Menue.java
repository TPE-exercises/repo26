package uebung03_aufgabe1;

import static gdi.MakeItSimple.*;
import myUtil.ADT;
import myUtil.Node;
import myUtil.QueueArray;
import myUtil.QueueList;
import myUtil.StackArray;
import myUtil.StackList;

public class Menue {

	private static ADT s1 = new StackList();
	private static ADT s2 = new StackArray();
	private static ADT q1 = new QueueList();
	private static ADT q2 = new QueueArray();
	private static int ADToption = 0;

	public static void main(String[] args) throws Exception {
		ADT currentADT = chooseADT(null);
		do {
			printMenue();
			switch (chooseOption(1, 6)) {
			case 1:// enter
				break;
			case 2:// leave
				break;
			case 3:// front
				break;
			case 4:// isEmpty
				break;
			case 5:// size
				break;
			case 6:// change ADT
				currentADT = chooseADT(currentADT);
				break;
			default:

			}
		} while (true);
	}

	private static void printADTs() {
		OwnUtils.printLines.printSeperatorLine();
		System.out.println("Wählen Sie ihren ADT");
		System.out.println("(1) Stack as List");
		System.out.println("(2) Stack as Array");
		System.out.println("(3) Queue as List");
		System.out.println("(4) Queue as Array");
	}

	private static ADT chooseADT(ADT oldADT) {
		switch (ADToption) {
		case 1:
			s1 = oldADT;
			break;
		case 2:
			s2 = oldADT;
			break;
		case 3:
			q1 = oldADT;
			break;
		case 4:
			q2 = oldADT;
			break;
		default:
			//oldADT==null
			//ADToption==0
		}
		printADTs();
		switch (chooseOption(1, 4)) {
		case 1:
			ADToption = 1;
			return s1;
		case 2:
			ADToption = 2;
			return s2;
		case 3:
			ADToption = 3;
			return q1;
		case 4:
			ADToption = 4;
			return q2;
		default:
			return null;
		}

	}

	private static void printMenue() {
		OwnUtils.printLines.printSeperatorDots();
		System.out.println("Ihre Möglichkeiten:");
		System.out.println("(1) enter");
		System.out.println("(2) leave");
		System.out.println("(3) front");
		System.out.println("(4) isEmpty");
		System.out.println("(5) size");
		System.out.println("(6) change ADT");
	}

	private static int chooseOption(int min, int max) {
		int value;
		do {
			value = readInt();
			if (value > max || value < min)
				System.out.println("Geben Sie einen Wert zwischen " + min + " und " + max + " ein.");
		} while (value > max && value < min);
		return value;
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
