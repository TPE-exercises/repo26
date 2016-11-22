package bank;

import static gdi.MakeItSimple.*;

public class Konto {
	
	private float betrag ;
	private String inhaber;
	private int kontoNummer;
	
	Konto(String inhaberName, int neueKontoNummer) {
		inhaber = inhaberName;
		kontoNummer = neueKontoNummer;
	}
	
	void zahleEin(float einzahlungsbetrag) {
		betrag += einzahlungsbetrag;
	}
	
	void zahleAus(float auszahlungsBetrag) {
		if (auszahlungsBetrag > betrag)
			throw new GDIException("Konto überziehen giltet nicht");
		betrag -= auszahlungsBetrag;
	}
	
	float kontostand() {
		return betrag;
	}
	
	int kontonummer() {
		return kontoNummer;
	}

	@Override
	public String toString() {
		return "Konto von " + inhaber + " (" + kontoNummer + "): " + betrag;
	}
	
}