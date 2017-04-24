package uebung02;

import static gdi.MakeItSimple.*;

abstract public class MyEis implements Eis {

	protected String name;
	protected double preis;
	protected String behaeltnis;
	protected String art;
	protected String[] sorten;
	protected String[] extras;

	public MyEis() {
		this.name = null;
		this.preis = 0;
		this.behaeltnis = null;
		this.art = null;
		this.sorten = null;
		this.extras = null;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setPreis(double preis) {
		this.preis = preis;
	}

	public double getPreis() {
		return this.preis;
	}

	public void setBehaeltnis(String behaeltnis) {
		this.behaeltnis = behaeltnis;
	}

	public String getBehaeltnis() {
		return this.behaeltnis;
	}

	public void setArt(String art) {
		this.art = art;
	}

	public String getArt() {
		return this.art;
	}

	public void setSorten(String[] sorten) {
		this.sorten = sorten;
	}

	public String[] getSorten() {
		return this.sorten;
	}

	public void setExtras(String[] extras) {
		this.extras = extras;
	}

	public String[] getExtras() {
		return this.extras;
	}

	abstract public void vorbereiten();

	public String[] frageSortenAb(int anzahlKugeln) {
		String[] sorten = new String[anzahlKugeln];
		for (int i = 0; i < sorten.length; i++) {
			System.out.print("Was fire Sort willschdan hawwe? ");
			// TODO Prüfe ob sorte verfügbar, ENUM? pro Region wieder anders
			sorten[i] = readLine();
			System.out.println();
		}
		return sorten;
	}

	abstract public void fuellen();

	abstract public void dekorieren();

	public String toString() {
		String string = "_____________*du bekommst ein Eis*_____________";
		string += "\n";
		string += "Name:      ";
		string += this.name;
		string += "\n";

		String[] extras = this.extras;
		String[] sorten = this.sorten;

		string += "Extras:    ";
		string += extras[0];
		for (int i = 1; i < extras.length; i++) {
			string += ", " + extras[i];
		}
		string += "\n";

		string += "Sorten:    ";
		string += sorten[0];
		for (int i = 1; i < sorten.length; i++) {
			string += ", " + sorten[i];
		}
		string += "\n";

		string += "Art:       ";
		string += this.art;

		string += "\n";

		string += "Behältnis: ";
		string += this.behaeltnis;

		string += "\n";
	
		string += "_______________________________________________";
		string += "\n";

		return string;
	}

}
