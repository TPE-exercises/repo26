package uebung02_eisdiele2;

public class MannheimerEis extends MyEis {
	
	public void vorbereiten() {
		switch (this.name) {
		case ("Spaghettieis"):
		case ("Bananensplit"):
			this.setBehaeltnis("Teller");
			break;
		case ("Nussbecher"):
			this.setBehaeltnis("Becher");
			break;
		}
	}

	public void fuellen() {
		switch (this.name) {
		case ("Spaghettieis"):
			this.setArt("Spaghettis");
			String[] sorten = { "Vanille", "Vanille", "Vanille" };
			this.setSorten(sorten);
			break;
		case ("Bananensplit"):

			break;
		case ("Nussbecher"):

			break;
		}
	}

	public void dekorieren() {
		switch (this.name) {
		case ("Spaghettieis"):
			String[] extras = { "Erdbeersoße", "Kokosflocken" };
			this.setExtras(extras);
			break;
		case ("Bananensplit"):

			break;
		case ("Nussbecher"):

			break;
		}
	}
	
	

}
