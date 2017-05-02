package uebung02_eisdiele2;

public class BerlinerEisdiele extends MyEisdiele {

	BerlinerEisdiele(String name, String region) {
		super(name, region);
	}

	public void begruesen() {
		
		System.out.println("Berlinerisch: Hallo!");
		System.out.println("Berlinerisch: Was für ein Eis willst du haben?");
	}

	public Eis erstellen(String typ) {
		Eis eis = new MannheimerEis();
	

	
		switch (typ) {
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
		System.out.println("Koelsch: Ja!");
		return eis;
	
	}

	public void kassieren(Eis eis) {
		// TODO ermittle EISPREIS oder lese von der Karte, dann -> erstellen
		System.out.println("Berlinerisch: Das macht dann " + eis.getPreis() + "0 Euro.");

	}

	public void verabschieden(String eis) {

		System.out.println();
		System.out.println(eis);
		System.out.println("Berlinerisch: Auf Wiedersehen.");

	}

	public void entschuldigen() {
		System.out.println("Berlinerisch: Tut mir leid, das haben wir nicht.");
	}

}