package de.hsMannheim.informatik.gdi.uebung04;

import static gdi.MakeItSimple.*;

public class ByteburgTarifRechner {
	
	
	
	static boolean istStationInLinie(int station, int[] linie){
		int i = 0;
		boolean stationGefunden = false;
		boolean stationIstInLinie = false;
		
		while (i < linie.length && !stationGefunden){
			if(station == linie[i])
				stationGefunden = true;
			else
				i++;
		}
		return stationIstInLinie;

	}
	
	
	
	static int ermittleFahrtkosten (int startStation, int zielStation){
		int fahrtkosten;
		boolean schonDa = false;
		boolean einfacheFahrt = false;
		int[] ringLinie ={13,23,33,43,53};
		
		if(startStation == zielStation){
			schonDa = true;
		}else{
		
			//Start und Ziel liegen auf einer Linie nebeneinander
			if((startStation - zielStation) % 10 == 1|| (startStation - zielStation) % 10  == -1 ){
				einfacheFahrt = true;
			}
			//Start und Ziel sind über Ringlinie verbunden
			else if(istStationInLinie(startStation, ringLinie) && istStationInLinie(zielStation, ringLinie)){
				if(startStation - 10 == zielStation || startStation + 10 == zielStation){
					einfacheFahrt = true;
				}
				else if((startStation == ringLinie[0] && zielStation == ringLinie[ringLinie.length - 1]) || (zielStation == ringLinie[ringLinie.length - 1] && startStation == ringLinie[0])){
					einfacheFahrt = true;
				}
			}
		}	
		

		/*
		int[] linie1 = {00, 11, 12, 13, 14, 15, 16};
		int[] linie2 = {00, 21, 22, 23, 24, 25, 26};
		int[] linie3 = {00, 31, 32, 33, 34, 35, 36};
		int[] linie4 = {00, 41, 42, 43, 44, 45, 46};
		int[] linie5 = {00, 51, 52, 53, 54, 55, 56};
		*/
		
		//Tarif 0: Sie sind da wo sie hin wollen
		if(schonDa){
			fahrtkosten = 0;
		}
		//Tarif 1: Einzelfahrt
		else if(einfacheFahrt){
			fahrtkosten = 1;
		}		
		//Tarif 2: Langstecke
		else{
			fahrtkosten = -1;
		}
		return fahrtkosten;

	}
	
	public static void main(String[] args) {

		println(ermittleFahrtkosten(11,11));
		
	}
}
