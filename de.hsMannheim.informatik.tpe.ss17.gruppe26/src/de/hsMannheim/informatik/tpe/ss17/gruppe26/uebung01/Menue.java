package de.hsMannheim.informatik.tpe.ss17.gruppe26.uebung01;

import static gdi.MakeItSimple.*;

public class Menue {

	public static void main(String[] args) {

		System.out.println("Version 1.0 (4/2017)");
		System.out.println("Erstellt von: Schönke und Lange");
		System.out.println("1. Programmieraufgabe \"BTree\" aus TPE im SS17");
		System.out.println("___________________________________________________");
		System.out.println("Starte Programm: 0%");
		System.out.println("Starte Programm: 25%");

		System.out.println("...erstelle Baum");
		System.out.println("Welche Ordnung soll der Baum haben?");
		BTree tree = new BTree(readInt());
		tree.printM();
		System.out.println("...Baum erstelt");

		System.out.println("Starte Programm: 50%");
		System.out.println("Starte Programm: 75%");

		System.out.println("Programm gestartet. (100%)");

		System.out.println("Was wollen Sie machen?");
		switch (readInt()) {
		case (1):// insert(integer)
			tree.insert(3);
			tree.insert(5);
			tree.insert(4);
			tree.burst(tree.getRoot(),tree.getRoot());
			tree.insert(2);
			tree.insert(1);
			tree.insert(6);
			break;
		case (2):// insert(file)
			break;
		case (3):// contains(integer)
			break;
		case (4):// size()
			break;
		case (5):// height()
			break;
		case (6):// getMax();
			break;
		// TODO alles weitere
		}
System.out.println("ENDE");
	}

}