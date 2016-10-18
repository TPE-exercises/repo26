package de.hsMannheim.informatik.gdi.uebung03;

import static gdi.MakeItSimple.*;

public class VollkommeneZahl {
			//Programm von Jan -> WhatsApp

	public static void main(String[] args) {
	
		println("Geben sie eine ganze Zahl ein: ");
		int inputValue = -1;
		String errorMassage = "Eingabe Ungültig";
		
		try {
			inputValue = readInt();
		}
		catch(Exception ex) {
			println(errorMassage);
			return;
		}

		if(inputValue == 0){
			println(errorMassage);
			return;
		}
		int count = 1;
		int totalValue = 0;
		while(count != inputValue){
			if(inputValue % count == 0){
				totalValue += count;
			}
			count++;
		}
		
		if(totalValue == inputValue){
			println("Ja, die eingegebene Zahl ist vollkommen");
		}
		else {
			println("nein, die eingegebene Zahl ist nicht vollkommen");
		}
	}

}
