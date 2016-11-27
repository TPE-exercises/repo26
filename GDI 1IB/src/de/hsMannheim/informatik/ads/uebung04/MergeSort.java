package de.hsMannheim.informatik.ads.uebung04;

import static gdi.MakeItSimple.*;

public class MergeSort {

	static int[] zuSortierendesArray;
	static int[] sortiertesArray = new int[_Main.length];

	public static void main(String[] args) {
		_Main.main(args);
	}

	static int[] direkterMergeSort(int[] numberSequence, int anzahlSplits) {
		zuSortierendesArray = einlesenDesEingabeArrays();
		println("zu sortierendes Array:");
		print(zuSortierendesArray[0]);
		for (int i = 1; i < _Main.length; i++) {
			print(", " + zuSortierendesArray[i]);
		}
		println();
		for (int k = 1; k <= 3; k++) {
			anzahlSplits /= 2;
			split(k, anzahlSplits);
			merge(k, anzahlSplits);
			zuSortierendesArray = einlesenDesEingabeArrays();
			print(zuSortierendesArray[0]);
			for (int i = 1; i < _Main.length; i++) {
				print(", " + zuSortierendesArray[i]);
			}
		}
		zuSortierendesArray = einlesenDesEingabeArrays();
		print(zuSortierendesArray[0]);
		for (int i = 1; i < _Main.length; i++) {
			print(", " + zuSortierendesArray[i]);
		}
		println();
		// split(2, anzahlZahlen / 2);
		// merge(2, anzahlZahlen / 2);
		return zuSortierendesArray;
	}

	/*
	 * static void arrayInDateiSchreiben(int[] numberSequence) { Object file =
	 * openOutputFile("EingabeArray.txt"); for (int i = 0; i < _Main.length;
	 * i++) { print(file, _Main.eingabeArray[i] + " "); } closeOutputFile(file);
	 * }
	 */

	static int[] einlesenDesEingabeArrays() {
		int[] array = new int[_Main.length];
		if (isFilePresent("Hauptband.txt")) {
			Object file = openInputFile("Hauptband.txt");
			for (int i = 0; i < _Main.length; i++) {
				array[i] = readInt(file);
			}
			closeInputFile(file);
		} else
			throw new GDIException("Die Datei \"Hauptband.txt\" konnte nicht gefunden werden.");
		return array;
	}

	static void merge(int durchgang, int häufigkeit) {
		Object Band1 = openInputFile("Band1.txt");
		Object Band2 = openInputFile("Band2.txt");
		Object einleseBand = openOutputFile("Hauptband.txt");
		println("Merge:");

		for (int z = 1; z <= häufigkeit; z++) {
			int splitTo1 = readInt(Band1);
			int splitTo2 = readInt(Band2);

			for (int i = 1; i <= durchgang; i++) {

				if (splitTo1 <= splitTo2) {
					print(einleseBand, splitTo1 + " ");
					if (!(i+1>=durchgang)){
							splitTo1 = readInt(Band1);
					}
					else{
						
					}
					
				} else {
					print(einleseBand, splitTo2 + " ");
				
				}
			}
			println(einleseBand);

		}
		closeInputFile(Band1);
		closeInputFile(Band2);
		closeOutputFile(einleseBand);
	}
	static int[] leseDateiZuArray (int durchgänge, String filename){
		int[] array = new int[durchgänge];

		if (isFilePresent(filename)) {
			Object file = openInputFile(filename);
			for (int i = 0; i < _Main.length; i++) {
				array[i] = readInt(file);
			}
			closeInputFile(file);
		} else
			throw new GDIException("Die Datei " + filename + " konnte nicht gefunden werden.");
		return array;
		
	}

	static void split(int durchgang, int häufigkeit) {
		Object einleseBand = openInputFile("Hauptband.txt");
		Object Band1 = openOutputFile("Band1.txt");
		Object Band2 = openOutputFile("Band2.txt");
		println("Split:");
		for (int i = 0; i < häufigkeit; i++) {
			int splitTo1 = readInt(einleseBand);

			for (int j = durchgang; j > 0; j--) {
				print(Band1, splitTo1 + " ");
				print("Band1: " + splitTo1 + "; ");
				println(Band1);
			}

			for (int j = durchgang; j > 0; j--) {
				int splitTo2 = readInt(einleseBand);
				print(Band2, splitTo2 + " ");
				print("Band2: " + splitTo2);
				println(Band2);
			}
			println();
		}
		closeInputFile(einleseBand);
		closeOutputFile(Band1);
		closeOutputFile(Band2);
	}
}
