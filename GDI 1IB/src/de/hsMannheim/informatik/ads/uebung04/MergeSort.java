package de.hsMannheim.informatik.ads.uebung04;

import static gdi.MakeItSimple.*;

import gdi.MakeItSimple.GDIException;

public class MergeSort {

	public static void main(String[] args) {

	}
	
	static int[] direkterMergeSort(int[] numberSequence) {

		return numberSequence;
	}

	static int[] einlesenDesEingabeArray(String filename) {
		int[] array = new int[_Main.length];
		if (isFilePresent(filename)) {
			Object datei = openInputFile(filename);
				for (int i = 0; i < _Main.length; i++)
					array[i] = readInt(datei);
			closeInputFile(datei);
		} else
			throw new GDIException("Die Datei " + filename + " konnte nicht gefunden werden.");
		return array;
	}
	
	static void merge() {

	}

	static void split() {

	}
}
