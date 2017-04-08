package de.hsMannheim.informatik.tpe.ss17.gruppe26.uebung01;

import static gdi.MakeItSimple.*;

public class Menue {

	private static int numberOfChecks = 0;
	private static int ordnung;

	private static void printSeperatorLine() {
		System.out.println("___________________________________________________");
	}

	private static void printSeperatorDots() {
		System.out.println("...................................................");
	}

	private static void printEmptyTree() {
		if (numberOfChecks == 0)
			System.out.println("Der Baum ist leer. Es wurde noch nichts eingefügt.");
		else
			System.out.println("Der Baum ist immer noch leer.");
		numberOfChecks++;
	}

	private static void printDefault() {
		System.out.print("Fehlerhafte Eingabe! Bitte geben Sie eine gültige Zahl für den jeweiligen Menüpunkt ein! ");
	}

	public static void main(String[] args) {
		boolean weitermachen = true;
		int numberOfRuns = 0;
		boolean added=false;

		System.out.println("Version 1.8 (09/04/2017)");
		System.out.println("Erstellt von: Schoenke und Lange");
		System.out.println("1. Programmieraufgabe \"BTree\" aus TPE im SS17");
		printSeperatorLine();
		System.out.println("Welche Ordnung soll der Baum haben?");
		ordnung = readInt();
		BTree tree = new MyBTree(ordnung);
		System.out.println("...Baum erstelt");
		while (weitermachen) {
			printSeperatorLine();
			System.out.print("(Debugging ist ");
			if (MyBTree.debug)
				System.out.println("aktiviert.)");
			else
				System.out.println("deaktiviert.)");
			System.out.println("---------------------------");
			if (numberOfRuns == 0)
				System.out.println("Was möchten Sie machen?");
			else
				System.out.println("Was möchten Sie als nächstes tun?");
			numberOfRuns++;
			System.out.println();
			System.out.println("(1) Werte in Baum einfügen");
			System.out.println("(2) Werte finden");
			System.out.println("(3) Baum auf Leere prüfen");
			System.out.println("(4) Anderen Baum zum aktuellen Baum hinzufügen");
			System.out.println("(5) Aktuellen Baum klonen");
			System.out.println("(6) Baum ausgeben lassen");
			System.out.println("(7) DEBUGGING aktivieren/deaktivieren");
			System.out.println("(0) Programm beenden");
			switch (readInt()) {
			case (1): /**
						 * 
						 * 
						 * 
						 * Werte in Baum einfügen
						 * 
						 * 
						 * 
						 **/
				printSeperatorDots();
				System.out.println("Wie wollen Sie Werte in den Baum einfügen?");
				System.out.println("(1) Werte per Hand eingeben");
				System.out.println("(2) Werte per Datei einfügen");
				System.out.println("(0) [Zurück]");
				switch (readInt()) {
				case (1): 
					insertManually(tree);
					break;
				case (2):
					insertFile(tree);
					break;
				case (0):
					break;
				default:
					printDefault();
				}
				break;
			case (2): 
				/**
				 * 
				 * 
				 * 
				 * Werte finden
				 * 
				 * 
				 * 
				 **/
				if (tree.isEmpty()) {
					printEmptyTree();
					break;
				} else {
					printSeperatorDots();
					System.out.println("Welche Werte möchten Sie finden/ausgeben lassen?");
					System.out.println("(1) Einen bestimmten Wert finden");
					System.out.println("(2) Die Größe des Baumes herausfinden");
					System.out.println("(3) Die Höhe des Baumes herausfinden");
					System.out.println("(4) Das größte Element herausfinden");
					System.out.println("(5) Das kleinste Element herausfinden");
					System.out.println("(9) ALLES AUSGEBEN LASSEN");
					System.out.println("(0) [Zurück]");
					switch (readInt()) {
					case (1):
						System.out.print("Bitte geben Sie den Wert ein, den Sie finden möchten: ");
						tree.contains(readInt());
						break;
					case (2):
						System.out.println("Anzahl der Elemente werden gezählt...");
						System.out.println("Im B-Baum gibt es " + tree.size() + " Elemente.");
						break;
					case (3):
						System.out.println("Die Höhe des Baumes wird bestimmt...");
						System.out.println("Die Höhe des B-Baumes ist: " + tree.height());
						break;
					case (4):
						System.out.println("Das größte Element im Baum wird ermittelt...");
						System.out.println("Der größte Wert ist: " + tree.getMax());
						break;
					case (5):
						System.out.println("Das kleinste Element im Baum wird ermittelt...");
						System.out.println("Der kleinste Wert ist: " + tree.getMin());
						break;
					case (9):
						System.out.println("  Anzahl Elemente im Baum: " + tree.size());
						System.out.println("          Höhe des Baumes: " + tree.height());
						System.out.println("  Größtes Element im Baum: [" + tree.getMax() + "]");
						System.out.println("Kleinstes Element im Baum: [" + tree.getMin() + "]");
						break;
					case (0):
						break;
					default:
						printDefault();
					}
				}
				break;
			case (3): // Baum auf Leere prüfen
				System.out.println("Es wird geprüft, ob der Baum leer ist...");
				if (tree.isEmpty()) {
					printEmptyTree();
				} else
					System.out.println("Glückwunsch! Es steht etwas im Baum drin :)");
				break;
			case (4): // Anderen Baum zum aktuellen Baum hinzufügen
				if (tree.isEmpty()) {
					printEmptyTree();
				} else {
					System.out.println("Welche Ordnung soll der neue Baum haben?");
					BTree otherTree = new MyBTree(readInt());
					System.out.println(
							"Möchten Sie den neuen Baum selbst erstellen oder durch eine Datei einlesen lassen?");
					System.out.println("(1) Werte selbst eingeben");
					System.out.println("(2) Datei einlesen");
					System.out.println("(0) ABBRUCH");
					switch (readInt()) {
					case (1): 
						insertManually(otherTree);
						break;
					case (2):
						insertFile(otherTree);
						break;
					case (0):
						break;
					default:
						printDefault();
					}
					System.out.println("AddAll:");
					added = tree.addAll(otherTree);
					if (added)
						System.out.println("Der neue Baum wurde zum aktuellen Baum hinzugefügt.");
					else
						System.out.println("FEHLER! Der neue Baum wurde nicht hinzugefügt.");
				}
				break;
			case (5): // Aktuellen Baum klonen
				if (tree.isEmpty()) {
					printEmptyTree();
				} else
					System.out.println(
							"BAUSTELLE! Diese Funktion muss noch implementiert werden! Bitte wählen Sie etwas anderes aus!");
				break;
			case (6): // Baum ausgeben lassen
				printSeperatorDots();
				if (tree.isEmpty()) {
					printEmptyTree();
					break;
				} else {
					System.out.println("Wie soll der Baum ausgegeben werden?");
					System.out.println("(1) Baum als Inorder ausgeben lassen");
					System.out.println("(2) Baum als Postorder ausgeben lassen");
					System.out.println("(3) Baum als Preorder ausgeben lassen");
					System.out.println("(4) Baum als Levelorder ausgeben lassen");
					System.out.println("(9) ALLES AUSGEBEN LASSEN");
					System.out.println("(0) [Zurück]");
					switch (readInt()) {
					case (1):
						System.out.println("Der Baum wird als Inorder ausgegeben:");
						tree.printInorder();
						break;
					case (2):
						System.out.println("Der Baum wird als Postorder ausgegeben:");
						tree.printPostorder();
						break;
					case (3):
						System.out.println("Der Baum wird als Preorder ausgegeben:");
						tree.printPreorder();
						break;
					case (4):
						System.out.println("Der Baum wird als Levelorder ausgegeben:");
						tree.printLevelorder();
						break;
					case (9):
						System.out.println("Alle Ausgabevarianten des Baumes werden erstellt...");
						System.out.println();
						System.out.print("Der Baum als    Inorder: ");
						tree.printInorder();
						System.out.print("Der Baum als  Postorder: ");
						tree.printPostorder();
						System.out.print("Der Baum als   Preorder: ");
						tree.printPreorder();
						System.out.print("Der Baum als Levelorder: ");
						tree.printLevelorder();
						System.out.println();
						break;
					case (0):
						break;
					default:
						printDefault();
					}
					break;
				}
			case (7): // Debugging
				if (MyBTree.debug) {
					MyBTree.debug = false;
					System.out.println("DEBUGGING wurde deaktiviert.");
				} else {
					MyBTree.debug = true;
					System.out.println("DEBUGGING wurde aktiviert.");
				}
				break;
			case (0): // Programm beenden
				weitermachen = false;
			default:
				printDefault();
			}
		}
		System.out.println("Programm beendet.");
	}
	
	private static void insertManually(BTree tree){
		boolean continueInsert = true;
		readLine();
		do {

			printSeperatorDots();
			System.out.println("INFO: Eingabe kann durch eingeben von Buchstaben abgebrochen werden. ");
			System.out.print("Geben Sie den Wert an, den Sie einfügen möchten: ");
			String rawCode = readLine();
			Integer cleanCode = checkThis(rawCode);
			if (cleanCode == null) {
				System.out.println("Eingabe abgebrochen");
				continueInsert = false;
			} else {
				boolean insertsucces = tree.insert(cleanCode);
				if (insertsucces)
					System.out.println("Wert erfolgreich eingefügt.");
				else {
					System.out.println("Wert nicht eingefügt.");
				}
			}
		} while (continueInsert);
	}

	private static void insertFile(BTree tree){
		readLine();
		System.out.println("Geben Sie den Namen der Datei an:");
		tree.insert(readLine());
	}
	
	/**
	 * Spielerei 
	 * String wird zu Integer umgewandet
	 * Null wenn buchstaben dabei sind
	 * 
	 * @param code
	 * @return
	 */
	private static Integer checkThis(String code) {
		int codeAsInt = 0;
		for (int i = 0; i < code.length(); i++) {
			codeAsInt *= 10;
			char k = code.charAt(i);

			switch (k) {
			case '0':
				codeAsInt += 0;
				break;
			case '1':
				codeAsInt = 1;
				break;
			case '2':
				codeAsInt = 2;
				break;
			case '3':
				codeAsInt = 3;
				break;
			case '4':
				codeAsInt = 4;
				break;
			case '5':
				codeAsInt = 5;
				break;
			case '6':
				codeAsInt = 6;
				break;
			case '7':
				codeAsInt = 7;
				break;
			case '8':
				codeAsInt = 8;
				break;
			case '9':
				codeAsInt = 9;
				break;
			default:
				return null;
			}

		}
		return codeAsInt;
	}
}