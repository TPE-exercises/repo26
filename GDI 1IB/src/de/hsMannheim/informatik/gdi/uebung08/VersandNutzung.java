package de.hsMannheim.informatik.gdi.uebung08;

import static gdi.MakeItSimple.println;

public class VersandNutzung {

	public static void main(String[] args) {
		TShirtVersand tShirtVersand = new TShirtVersand();
		int meineNummer = tShirtVersand.registrieren("Benjamin", "meuier2");
		
		int gefundesTShirt = tShirtVersand.sucheFarbe("blau");
		int bestellNummer = tShirtVersand.bestellung(gefundenesTShirt);
		tShirtVersand.abfrageLieferdatum(bestellNummer);
		tShirtVersand.stonieren(bestellNummer);
		
		
		
		/*
		Bank bank = new Bank();
		int müllerNummer = bank.eröffneKonto("Müller");
		int meierNummer = bank.eröffneKonto("Meier");
		println(bank.kontenAnzahl);
		
		bank.zahleEin(müllerNummer, 200f);
		
		println(bank.sucheKonto(müllerNummer));
		
		bank.zahleEin(meierNummer, 100f);
		println(bank.sucheKonto(meierNummer));
		
		for (int i = 0; i < bank.kontenAnzahl; i++)
			println((i + 1) + ": " + bank.konten[i]);
		
		bank.schließeKonto(müllerNummer);
		bank.schließeKonto(meierNummer);
		
		for (int i = 0; i < bank.kontenAnzahl; i++)
			println((i + 1) + ": " + bank.konten[i]);
			*/
	}

}
