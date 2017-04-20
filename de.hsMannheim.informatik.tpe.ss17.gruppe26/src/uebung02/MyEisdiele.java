package uebung02;

import static gdi.MakeItSimple.println;
import static gdi.MakeItSimple.readLine;

abstract public class MyEisdiele implements Eisdiele{

	protected String name;
	protected String region;

	MyEisdiele(String name, String region) {
		this.name = name;
		this.region = region;
	}
	
	public void bestellen() {

		begruesen();

		Eis eis = new MyEis();

//		println("Welche Sorte");
//		switch (readLine()) {
//		case ("Spaghettieis"):
//		case ("spaghettieis"):
//			eis.setName("Spaghettieis");
//			break;
//		case ("Bananensplit"):
//		case ("bananensplit"):
//			eis.setName("Bananensplit");
//			break;
//		case ("Nussbecher"):
//		case ("nussbecher"):
//			eis.setName("Nussbecher");
//			break;
//		default:
//			entschuldigen();
//			return;
//		}

		eis.vorbereiten();
		eis.fuellen();
		eis.dekorieren();

		kassieren(eis);

		verabschieden(eis);
	}
	
	abstract public void begruesen();
	
	abstract public void kassieren(Eis eis);
	
	abstract public void verabschieden(Eis eis);
	
	abstract public void entschuldigen();
	
}
