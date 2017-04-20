package uebung02;

import static gdi.MakeItSimple.readLine;

public class MannheimerEisdiele extends MyEisdiele {

	MannheimerEisdiele(String name, String region) {
		super(name, region);
	}

	public void begruesen() {
		System.out.println("Mannheimerisch: Hallo!");

	}

	public Eis erstellen(String typ) {
		Eis eis = new MannheimerEis();
	
		System.out.println("Mannheimerisch: Welche Sorte");
	
		switch (readLine()) {
		case ("Spaghettieis"):
		case ("spaghettieis"):
			eis.setName("Spaghettieis");
			eis.setPreis(5.90);
			break;
		case ("Bananensplit"):
		case ("bananensplit"):
			eis.setName("Bananensplit");
			eis.setPreis(5.90);
			break;
		case ("Nussbecher"):
		case ("nussbecher"):
			eis.setName("Nussbecher");
			eis.setPreis(5.90);
			break;
		default:
			return null;
		}
		return eis;
	
	}

	public void kassieren(Eis eis) {
		// TODO ermittle EISPREIS oder lese von der Karte, dann -> erstellen
		System.out.println("Mannheimerisch: Bitte bezahlen Sie jetzt " + eis.getPreis() + "0€.");

	}

	public void verabschieden(String eis) {

		System.out.println();
		System.out.println(eis);
		System.out.println("Mannheimerisch: Auf Wiedersehen! Und lassen Sie sich ihr Eis schmecken!");

	}

	public void entschuldigen() {
		System.out.println("Mannheimerisch: Tut uns leid...");
	}

}
