package bank;

import static gdi.MakeItSimple.*;

public class Bank {
	
	private Konto[] konten = new Konto[100];
	private int kontenAnzahl = 0;
	
	int eröffneKonto(String inhaber) {
		int nummer = (int) (Math.random() * 1000000000);
		konten[kontenAnzahl] = new Konto(inhaber, nummer);
		kontenAnzahl++;
		return nummer;
	}
	
	void schließeKonto(int nummer) {
		int position = sucheKontoPosition(nummer);
		for (int i = position; i < kontenAnzahl - 1; i++)
			konten[i] = konten[i + 1];
		kontenAnzahl--;
	}
	
	private int sucheKontoPosition(int nummer) {
		int position = 0;
		while (position < kontenAnzahl && konten[position].kontonummer() != nummer)
			position++;
		if (position >= kontenAnzahl)
			throw new GDIException("Kein Konto mit Nummer " + nummer);
		return position;
	}
	private Konto sucheKonto(int nummer) {
		return konten[sucheKontoPosition(nummer)];
	}
	
	void zahleEin(int kontoNummer, float betrag) {
		Konto konto = sucheKonto(kontoNummer);
		konto.zahleEin(betrag);
	}

	

	public static void main(String[] args) {
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
	}
}