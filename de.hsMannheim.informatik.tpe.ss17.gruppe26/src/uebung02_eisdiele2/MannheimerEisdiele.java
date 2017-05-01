package uebung02_eisdiele2;

import static gdi.MakeItSimple.readLine;

public class MannheimerEisdiele extends MyEisdiele {

	MannheimerEisdiele(String name, String region) {
		super(name, region);
	}

	public void begruesen() {
		
		
//		System.out.println("Moschäh");
//		System.out.println("Unn wieee?");
//		System.out.println("Ahjooo");
		System.out.println("Jou!");
		System.out.println("Was fire Eis willschdan hawwe?");
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
		System.out.println("Ajooh!");
		return eis;
	
	}

	public void kassieren(Eis eis) {
		// TODO ermittle EISPREIS oder lese von der Karte, dann -> erstellen
		System.out.println("Donn krieg ich " + eis.getPreis() + "0 Euroo fun da.");

	}

	public void verabschieden(String eis) {

		System.out.println();
		//System.out.println("Ä Balle Erdbeer, äner mit Schokolad und donn noch äner mit Persching");
		System.out.println(eis);
		System.out.println("Alla dann!");

	}

	public void entschuldigen() {
		System.out.println("Dut ma lääd, des hämma net.");
	}

}
