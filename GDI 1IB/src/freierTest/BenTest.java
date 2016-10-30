package freierTest;

import static gdi.MakeItSimple.*;

public class BenTest {

	public static void main(String[] args) {
		/*// ALLES FORMATIEREN: alles markieren und <STRG> + <SHIFT> + <F>
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
		*/
		/*
		println( "Ziehungsgerät in ordnungsgemäßem Zustand" );
				int anzahlDerKugeln = 0;
				while ( anzahlDerKugeln < 6 ) {
					int zufallsZahl = (int) (Math.random()*49)+1;
					println( zufallsZahl );
					anzahlDerKugeln ++;
				}
				println( "Die Gewinner werden benachrichtigt" );
				*/
		int[] factorial = { 1, 1, 2, 6, 24, 120, 720, 5040 };
		println( factorial.length );
		boolean[ ] bc = { true, false, false, true, true, true };
		int i = 0;
		while ( i < bc.length )
		print( bc[++i] + ", " );
		int[] empty = { };
		println( empty.length );
		String[] as;		
	}

}
