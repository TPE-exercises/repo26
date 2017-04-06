package de.hsMannheim.informatik.tpe.ss17.gruppe26.uebung01;

import static gdi.MakeItSimple.*;

public class Menue {

	public static void main(String[] args) {
		int numberOfRuns = 0;
		boolean weitermachen = true;
		int zurueck = 0;

		System.out.println("Version 1.0 (4/2017)");
		System.out.println("Erstellt von: Schoenke und Lange");
		System.out.println("1. Programmieraufgabe \"BTree\" aus TPE im SS17");
		System.out.println("___________________________________________________");
		System.out.println("Starte Programm: 0%");
		System.out.println("Starte Programm: 25%");
		System.out.println("...erstelle Baum");
		System.out.println("................");
		System.out.println("Welche Ordnung soll der Baum haben?");
		BTree_Interface tree = new BTree(readInt());
		((BTree) tree).printM();
		System.out.println("...Baum erstelt");
		System.out.println("...............");
		System.out.println("Starte Programm: 50%");
		System.out.println("Starte Programm: 75%");
		System.out.println(".......................");
		System.out.println("Programm gestartet. (100%)");
		while (weitermachen) {
			System.out.println(".......................................................");
			switch (zurueck) {
			case (1):
				System.out.println("Doch anders entschieden?");
				break;
			case (2):
				System.out.println("Sie können sich wohl nicht entscheiden. Oder?");
				break;
			case (3):
				System.out.println("Ist das Ihr erstes Mal?");
				break;
			case (4):
				System.out.println("Was wollen Sie überhaupt hier?");
				break;
			case (5):
				System.out.println("Hmmm....");
				break;
			case (6):
				System.out.println("Was soll das?");
				break;
			case (7):
				System.out.println("Wissen Sie überhaupt wozu das Programm gut ist?");
				break;
			case (8):
				System.out.println("Übertreiben Sie es nicht!");
				break;
			case (9):
				System.out.println("Wenn Sie so weitermachen, kann ich mich auch ganz schnell beenden!");
				break;
			case (10):
				System.out.println(
						"Okay. Sie haben es ja nicht anders gewollt. Aber ich gebe Ihnen noch eine allerletzte Chance!");
				weitermachen = false;
				break;
			}
			System.out.println("........................");

			if (numberOfRuns == 0)
				System.out.println("Was wollen Sie machen?");
			else
				System.out.println("Was wollen Sie als nächste tun?");
			numberOfRuns++;
			System.out.println("(1) Werte in Baum einfügen");
			System.out.println("(2) Werte finden");
			System.out.println("(3) Baum auf Leere prüfen");
			System.out.println("(4) Anderen Baum zum aktuellen Baum hinzufügen");
			System.out.println("(5) Aktuellen Baum klonen");
			System.out.println("(6) Baum ausgeben lassen");
			System.out.println("(0) Programm beenden");
			switch (readInt()) {
			case (1): // Werte in Baum einfügen
				System.out.println(".......................................................");
				System.out.println("Wie wollen Sie Werte in den Baum einfügen?");
				System.out.println("(1) Werte per Hand eingeben");
				System.out.println("(2) Werte per Datei einfügen");
				System.out.println("(0) [Zurück]");
				switch (readInt()) {
				case (1): // TODO manuelle Eingabe ermöglichen
					System.out.println("Werte werden in den Baum eingefügt...");
					tree.insert(2);
					tree.insert(2);
//					tree.insert(4);
					break;
				case (2): // TODO
					// insert(file);
					break;
				case (0):
					zurueck++;
					break;
				}
				break;
			case (2): // Werte finden
				System.out.println(".......................................................");
				System.out.println("Welche Werte möchten Sie finden/ausgeben lassen?");
				System.out.println("(1) Einen bestimmten Wert finden");
				System.out.println("(2) Die Größe des Baumes herausfinden");
				System.out.println("(3) Die Höhe des Baumes herausfinden");
				System.out.println("(4) Das größte Element herausfinden");
				System.out.println("(5) Das kleinste Element herausfinden");
				System.out.println("(0) [Zurück]");
				switch (readInt()) {
				case (1):
					System.out.print("Bitte geben Sie den Wert ein, den Sie finden möchten: ");
					tree.contains(readInt());
					break;
				case (2):
					System.out.println("Anzahl der Elemente werden gezählt...");
					int size = 0;
					size = tree.size();
					if (size == 0)
						System.out.println("Es gibt kein Element im Baum!");
					System.out.println("Im B-Baum gibt es " + size + "Elemente.");
					break;
				case (3):
					System.out.println("Die Höhe des Baumes wird bestimmt...");
					int height = 0;
					height = tree.height();
					System.out.println("[height] Die Höhe des B-Baumes ist: " + height);
					break;
				case (4):
					System.out.println("Das größte Element im Baum wird ermittelt...");
					Integer maxVal = null;
					maxVal = tree.getMax();
					if (maxVal == null)
						System.out.println("Es gibt kein größtes Element!");
					System.out.println("[getMax] Der größte Wert ist: " + maxVal);
					break;
				case (5):
					System.out.println("Das kleinste Element im Baum wird ermittelt...");
					Integer minVal = null;
					minVal = tree.getMin();
					if (minVal == null)
						System.out.println("Es gibt kein kleinstes Element!");
					System.out.println("[getMin] Der kleinste Wert ist: " + minVal);
					break;
				case (0):
					zurueck++;
					break;
				}
				break;
			case (3): // Baum auf Leere prüfen
				System.out.println("Es wird geprüft, ob der Baum leer ist...");
				if (tree.isEmpty())
					System.out.println("Der Baum ist leer. Es wurde nichts gefunden.");
				else
					System.out.println("Glückwunsch! Es steht etwas im Baum drin :)");
				break;
			case (4): // Anderen Baum zum aktuellen Baum hinzufügen
				System.out.println(
						"BAUSTELLE! Diese Funktion muss noch implementiert werden! Bitte wählen Sie etwas anderes aus!");
				break;
			case (5): // Aktuellen Baum klonen
				System.out.println(
						"BAUSTELLE! Diese Funktion muss noch implementiert werden! Bitte wählen Sie etwas anderes aus!");
				break;
			case (6): // Baum ausgeben lassen
				System.out.println(".......................................................");
				System.out.println("Wie soll der Baum ausgegeben werden?");
				System.out.println("(1) Baum als Inorder ausgeben lassen");
				System.out.println("(2) Baum als Postorder ausgeben lassen");
				System.out.println("(3) Baum als Preorder ausgeben lassen");
				System.out.println("(4) Baum als Levelorder ausgeben lassen");
				System.out.println("(0) [Zurück]");
				switch (readInt()) {
				case (1):
					System.out.println("Der Baum wird als Inorder ausgegeben...");
					tree.printInorder();
					break;
				case (2):
					System.out.println("Der Baum wird als Postorder ausgegeben...");
					tree.printPostorder();
					break;
				case (3):
					System.out.println("Der Baum wird als Preorder ausgegeben...");
					tree.printPreorder();
					break;
				case (4):
					System.out.println("Der Baum wird als Levelorder ausgegeben...");
					tree.printLevelorder();
					break;
				case (0):
					zurueck++;
					break;
				}
				break;
			case (0): // Programm beenden
				System.out.println("Neeeeeeeeeeeeeeeeeeiiiiiiiiiiiiiiinnnnnnnnnnnnnnnnnn");
				System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				System.out.println("Programm wird beendet...");
				System.out.println("!!!");
				System.out.println("NIIIIICCCCHTTT!!!!");
				System.out.println("!!!!!!!!!!!!!!!!!!!!!");
				System.out.println("Beende Programm: 75%");
				System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				System.out.println("Beende Programm: 50%");
				System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				System.out.println("AAAAAAAAAAAAAAAhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh........");
				System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				System.out.println("Beende Programm: 25%");
				System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				System.out.println("hhhhhhhhhhhh........");
				System.out.println(".......................................................");
				System.out.println(".........................");
				System.out.println("......");
				System.out.println();
				weitermachen = false;
				break;
			// TODO alles weitere
			}
		}
		if (zurueck >= 10) {
			System.out.println("Tschüss!");
			System.out.println("Ich hoffe, ich muss Sie nie wiedersehen!...");
		} else
			System.out.println("Programm beendet.");
	}
}