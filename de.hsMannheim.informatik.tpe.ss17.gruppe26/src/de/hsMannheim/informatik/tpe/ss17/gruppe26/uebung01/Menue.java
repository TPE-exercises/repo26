package de.hsMannheim.informatik.tpe.ss17.gruppe26.uebung01;

import static gdi.MakeItSimple.*;

public class Menue {

	public static void main(String[] args) {
		int numberOfRuns = 0;
		boolean weitermachen = true;

		System.out.println("Version 1.0 (4/2017)");
		System.out.println("Erstellt von: Schoenke und Lange");
		System.out.println("1. Programmieraufgabe \"BTree\" aus TPE im SS17");
		System.out.println("___________________________________________________");
		System.out.println("Starte Programm: 0%");
		System.out.println("Starte Programm: 25%");

		System.out.println("...erstelle Baum");
		System.out.println("Welche Ordnung soll der Baum haben?");
		BTree_Interface tree = new BTree(readInt());
		((BTree) tree).printM();
		System.out.println("...Baum erstelt");

		System.out.println("Starte Programm: 50%");
		System.out.println("Starte Programm: 75%");

		System.out.println("Programm gestartet. (100%)");

		while (weitermachen) {
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
			System.out.println("(7) Programm beenden");
			switch (readInt()) {
			case (1): // Werte in Baum einfügen
				System.out.println("Wie wollen Sie Werte in den Baum einfügen?");
				System.out.println("(1) Werte per Hand eingeben");
				System.out.println("(2) Werte per Datei einfügen");
				switch (readInt()) {
				case (1): // TODO manuelle Eingabe ermöglichen
					System.out.println("Werte werden in den Baum eingefügt...");
					tree.insert(5);
					tree.insert(3);
					tree.insert(4);
					break;
				case (2): //TODO 
					// insert(file);
					break;
				}
			case (2): // Werte finden
				System.out.println("Welche Werte möchten Sie finden/ausgeben lassen?");
				switch (readInt()){
				case (1):
				case (2):
				case (3):
				case (4):
				}
				break;
			case (3): // Baum auf Leere prüfen
				break;
			case (4): // Anderen Baum zum aktuellen Baum hinzufügen
				int size = 0;
				size = tree.size();
				if (size == 0)
					System.out.println("Es gibt kein Element im Baum!");
				System.out.println("[size] Im B-Baum gibt es " + size + "Elemente.");
				break;
			case (5): // Aktuellen Baum klonen
				int height = 0;
				height = tree.height();
				System.out.println("[height] Die Höhe des B-Baumes ist: " + height);
				break;
			case (6): // Baum ausgeben lassen
				Integer maxVal = null;
				maxVal = tree.getMax();
				if (maxVal == null)
					System.out.println("Es gibt kein größtes Element!");
				System.out.println("[getMax] Der größte Wert ist: " + maxVal);
				break;
			case (7): // Programm beenden
				Integer minVal = null;
				minVal = tree.getMin();
				if (minVal == null)
					System.out.println("Es gibt kein kleinstes Element!");
				System.out.println("[getMin] Der kleinste Wert ist: " + minVal);
				break;
			// TODO alles weitere
			}
		}
		System.out.println("ENDE");
	}

}