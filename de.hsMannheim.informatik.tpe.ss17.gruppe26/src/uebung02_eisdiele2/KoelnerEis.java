package uebung02_eisdiele2;

public class KoelnerEis extends MyEis {

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
			String[] sorten1 = { "Vanille", "Vanille", "Vanille" };
			this.setSorten(sorten1);
			break;
		case ("Bananensplit"):
			this.setArt("Bananensplit");
			String[] sorten2 = { "Vanille", "Schokolade", "Erdbeer" };
			this.setSorten(sorten2);
			break;
		case ("Nussbecher"):
			this.setArt("Nussbecher");
			String[] sorten3 = frageSortenAb(3);
			this.setSorten(sorten3);
			break;
		}
	}

	public void dekorieren() {
		switch (this.name) {
		case ("Spaghettieis"):
			String[] extras1 = { "Erdbeersoße", "Kokosflocken" };
			this.setExtras(extras1);
			break;
		case ("Bananensplit"):
			String[] extras2 = { "Banane", "Erdbeersirup", "Ananassirup", "Schokoladensauce", "Schlagsahne",
					"Maraschino-Kirschen" };
			this.setExtras(extras2);
			break;
		case ("Nussbecher"):
			String[] extras3 = { "Nüsse", "Sahne", "Nusssauce"};
	this.setExtras(extras3);
			break;
		}
	}

}