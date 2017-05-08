package uebung03_aufgabe1;

import static gdi.MakeItSimple.*;

public class ExeptionExample {

	public static void main(String[] args) {
		
		System.out.println("Version 1.8 (09/04/2017)");
		System.out.println("Erstellt von: Schoenke und Lange");
		System.out.println("1. Programmieraufgabe \"BTree\" aus TPE im SS17");
		printSeperatorLine();
		
		System.out.print("Geben Sie die erste Zahl ein: ");
		int numberOne=readInt();
		System.out.print("Geben Sie die zweite Zahl ein: ");
		int numberSec=readInt();
		
		try{
			System.out.println(numberOne/numberSec);
		}catch(ArithmeticException ex){
			System.err.println("Sie dürfen um gottes Willen nicht durch NULL dividieren!");
		}
	}

}
