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

	// 1 s1 /2 s2 /3 q1 /4 q2
	private static int ADToption = 0;

	// 1 MyInt /2 MyString
	private static int ObjectOption = 0;

	public static void main(String[] args) throws Exception {
		ADT currentADT = chooseADT(null);
		ObjectOption = chooseObjectOption();
		do {
			printMenue();
			switch (chooseOption(1, 7)) {
			case 1:// enter
				System.out.println("Geben Sie ihr " + getCurrentObject() + " ein.");
				enter(currentADT,getObject());
				break;
			case 2:// leave
				System.out.println(leave(currentADT));
				break;
			case 3:// front
				System.out.println(front(currentADT));
				break;
			case 4:// isEmpty
				System.out.println(isEmpty(currentADT));
				break;
			case 5:// size
				System.out.println(size(currentADT));
				break;
			case 6:// change ADT
				currentADT = chooseADT(currentADT);
				break;
			case 7:
				ObjectOption = chooseObjectOption();
				break;
			default:

			}
			System.out.println(currentADT.toString(currentADT.getHead()));
		} while (true);
	}

	/**
	 * returns the Churrent ObjectTyp as String
	 * @return
	 */
	private static String getCurrentObject() {
		switch (ObjectOption) {
		case 1:
			return "MyInt";
		case 2:
			return "MyString";
		}
		return null;
	}

	/**
	 * Choose ObjectType
	 * @return
	 */
	private static int chooseObjectOption() {
		System.out.println("Geben Sie ihre Gewünschte ObjectArt an.");
		System.out.println("(1) MyInt");
		System.out.println("(2) MyString");
		switch (chooseOption(1, 2)) {
		case (1):// MyInt
			return 1;
		case (2):// MyString
			return 2;
		}
		return 0;
	}

	/**
	 * creates an Object MyInt or MyString
	 * @return
	 */
	private static Object getObject() {
		switch (ObjectOption) {
		case 1:
			Object myInt = null;
			int x = Integer.MIN_VALUE;
			try {
				x = readInt();
				readLine();
			} catch (Exception ex) {
				 ex.printStackTrace();
				 return null;
				 //TODO hier wird die MIN_VALUE eingetragen wenn eingabe falsch
				// System.out.println("Bitte erneut eingeben!");
				// getObject();
			}
			myInt = new uebung02_teil2_aufgabe2.MyInt(new Integer(x));
			readLine();
			return myInt;

		case 2:
			return new uebung02_teil2_aufgabe2.MyString(readLine());
		}
		return null;
	}

	/**
	 * print the options/menue
	 */
	private static void printADTs() {
		OwnUtils.printLines.printSeperatorLine();
		System.out.println("Wählen Sie ihren ADT / Standartgröße \"5\"");
		System.out.println("(1) Stack as List");
		System.out.println("(2) Stack as Array");
		System.out.println("(3) Queue as List");
		System.out.println("(4) Queue as Array");
	}

	/**
	 * returns the new ADT to work with it, saves old ADT first
	 * @param oldADT
	 * @return
	 */
	private static ADT chooseADT(ADT oldADT) {
		// System.out.println("Wie viele Elemente sollen in den ADT passen?");
		// int number = readInt();
		// readLine();

		switch (ADToption) {
		case 1:
			// s1=new StackList(number);
			s1 = oldADT;
			break;
		case 2:
			// s2=new StackArray(number);
			s2 = oldADT;
			break;
		case 3:
			// q1=new QueueList(number);
			q1 = oldADT;
			break;
		case 4:
			// q2=new QueueArray(number);
			q2 = oldADT;
			break;
		default:
			// oldADT==null
			// ADToption==0
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

	/**
	 * prints options/menue
	 */
	private static void printMenue() {
		OwnUtils.printLines.printSeperatorDots();
		System.out.println("Ihre Möglichkeiten:");
		System.out.println("(1) enter");
		System.out.println("(2) leave");
		System.out.println("(3) front");
		System.out.println("(4) isEmpty");
		System.out.println("(5) size");
		System.out.println("(6) change ADT");
		System.out.println("(7) change ObjectType");
	}

	/**
	 * choose an Option, nessasary for all menues
	 * @param min
	 * @param max
	 * @return
	 */
	private static int chooseOption(int min, int max) {
		int value = 0;
		do {
			try {
				value = readInt();
			} catch (Exception ex) {
				value = -1;
			}
			readLine();
			if (value > max || value < min)
				System.out.println("Geben Sie einen Wert zwischen " + min + " und " + max + " ein.");
		} while (value > max || value < min);
		return value;
	}

	
	/*
	 * following methodes link to the special methodes
	 */
	
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
