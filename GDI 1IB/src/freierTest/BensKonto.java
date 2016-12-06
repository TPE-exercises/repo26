package freierTest;
import static gdi.MakeItSimple.*;
public class BensKonto {

	BensKonto[] konten = new BensKonto[100];
	int kontoNummer;
	int anzahlKonten = 1;

	BensKonto(int neueKontoNummer) {
		kontoNummer = neueKontoNummer;
		int kontoZahl = anzahlKonten;
	}

	int eröffneKonto() {
		int nummer = (int) (Math.random()*1000000000);
		konten[anzahlKonten-1] = new BensKonto(nummer);
		anzahlKonten++;
		return nummer;
	}

	public static void main(String[] args) {
		BensKonto bensKonto = new BensKonto();
		int ersteKontoNummer = eröffneKonto();
		

	}

}
