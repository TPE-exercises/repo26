package uebung02;

import static gdi.MakeItSimple.*;

public class Eisdiele {

	private String name;
	private String region;

	Eisdiele(String name, String region) {
		this.name = name;
		this.region = region;
	}

	public void bestellen() {

		begruesen();

		Eis eis = new Eis();

		println("Welche Sorte");
		switch (readLine()) {
		case ("Spaghettieis"):
		case ("spaghettieis"):
			eis.setName("Spaghettieis");
			eis.setPreis(5.90);
			break;
		case ("Bananensplit"):
		case ("bananensplit"):
			eis.setName("Bananensplit");
			break;
		case ("Nussbecher"):
		case ("nussbecher"):
			eis.setName("Nussbecher");
			break;
		default:
			entschuldigen();
			return;
		}

		eis.vorbereiten();
		eis.fuellen();
		eis.dekorieren();

		kassieren(eis);

		verabschieden(eis);

	}

	private void begruesen() {
		System.out.println("Hallo!");
	}

	private void kassieren(Eis eis) {
		switch (eis.getName()) {
		case ("Spaghettieis"):
			System.out.println("Bitte bezahlen Sie jetzt " + eis.getPreis() + "0€.");
			break;
		case ("Bananensplit"):

			break;
		case ("Nussbecher"):

			break;
		}
	}

	private void verabschieden(Eis eis) {
		System.out.println("Ihr Eis:");
		
		System.out.print("Name:      ");
		System.out.println(eis.getName());

		String[] extras = eis.getExtras();
		String[] sorten = eis.getSorten();
		
		System.out.print("Extras:    ");
		System.out.print(extras[0]);
		for (int i = 1; i < extras.length; i++) {
			System.out.print(", "+extras[i] );
		}
		System.out.println();
		
		System.out.print("Sorten:    ");
		System.out.print(sorten[0] );
		for (int i = 1; i < sorten.length; i++) {
			System.out.print(", "+sorten[i]);
		}
		System.out.println();
		
		System.out.print("Art:       ");
		System.out.println(eis.getArt());
		
		System.out.print("Behältnis: ");
		System.out.println(eis.getBehaeltnis());

		System.out.println();
		System.out.println("Auf Wiedersehen! Und lassen Sie sich ihr Eis schmecken!");

	}

	private void entschuldigen() {
		System.out.println("Tut uns leid...");
	}

}
