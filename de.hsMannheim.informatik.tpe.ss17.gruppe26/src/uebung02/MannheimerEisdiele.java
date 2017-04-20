package uebung02;

import static gdi.MakeItSimple.*;

public class MannheimerEisdiele extends MyEisdiele{

	MannheimerEisdiele(String name, String region) {
		super(name, region);
	}

	public void begruesen() {
		System.out.println(this.name);
		System.out.println("Hallo!");
	}

	public void kassieren(Eis eis) {
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

	public void verabschieden(Eis eis) {
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

	public void entschuldigen() {
		System.out.println("Tut uns leid...");
	}


}
