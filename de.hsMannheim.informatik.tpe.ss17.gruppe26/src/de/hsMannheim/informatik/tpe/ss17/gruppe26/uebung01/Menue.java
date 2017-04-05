package de.hsMannheim.informatik.tpe.ss17.gruppe26.uebung01;

import static gdi.MakeItSimple.*;

public class Menue {

	public static void main(String[] args) {

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

		System.out.println("Was wollen Sie machen?");
		System.out.println("(1) Werte manuell einfügen");
		System.out.println("(2) Werte über Datei einfügen");
		System.out.println("(3) Wert finden");
		System.out.println("(4) Anzahl der Werte zählen lassen");
		System.out.println("(5) Höhe des Baumes ausgeben lassen");
		System.out.println("(6) Größtes Element ausgeben lassen");
		System.out.println("(7) Kleinestes Element ausgeben lassen");
		switch (readInt()) {
		case (1):
			tree.insert(5);
			tree.insert(3);
			tree.insert(4);
			// break;
		case (2):// insert(file);
			// break;
		case (3): // contains(integer);
			// break;
		case (4):
			// tree.size();
			// break;
		case (5)://
			int height = 0;
			height = tree.height();
			System.out.println("Die Höhe des B-Baumes ist: " + height);
			// break;
		case (6):
			Integer maxVal = null;
			maxVal = tree.getMax();
			System.out.println("Der größte Wert ist: " + maxVal);
			// break;
		case (7):
			Integer minVal = null;
			minVal = tree.getMin();
			System.out.println("Der kleinste Wert ist: " + minVal);
			break;
		// TODO alles weitere
		}
		System.out.println("ENDE");
	}

}