package de.hsMannheim.informatik.gdi.uebung03;

import static gdi.MakeItSimple.*;

public class VollkommeneZahl {
	// Bei einer vollkommenen Zahl ergibt die Summe der Teiler (außer der Zahl selbst) die Ausgangszahl.
	// Beispiel: Die Zahl 6 hat die Teiler 1, 2 und 3; 1 + 2 + 3 = 6.

	public static void main(String[] args) {
		
		println("Geben sie eine Zahl ein: ");
		int ganzeZahl = readInt();
		
		int teiler = 1;
		int summe = 0;
		
		while(teiler < ganzeZahl){
			if(ganzeZahl % teiler == 0){
				summe += teiler;
			}
			teiler ++;
		}
		//Die while-Schleife rechnet die Summe der Teiler zusammen. 

		

		if (summe == ganzeZahl) {
			println("ja, die eingegebene Zahl ist vollkommen");
		} 
		//Entspricht die Summe der Teiler, der Zahl die eingegeben wurde, gibt es eine positive Ausgabe.

		else {
			println("nein, die eingebenene Zahl ist nicht vollkommen");
		}

	}

}
