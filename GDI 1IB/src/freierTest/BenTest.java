package freierTest;

import static gdi.MakeItSimple.*;

public class BenTest {

	public static void main(String[] args) {
		// ALLES FORMATIEREN: alles markieren und <STRG> + <SHIFT> + <F>
		// BEISPIEL KONKATENATION
		String nachname, vorname, name;
		nachname = "Schmidt";
		vorname = "Hans";
		name = vorname + " " + nachname;
		println(name);

		// BEISPIEL FÜR EINE IF-BEDINGUNG
		println("Geben Sie Ihr Geburtsdatum ein: ");
		String geburtsdatum = readLine();

		if (geburtsdatum.equals("16.8."))
			println("Wir haben am " + "gleichen Tag " + "Geburtstag!");

		else
			println("Wir haben nicht " + "am gleichen Tag " + "Geburtstag!");

	}

}
