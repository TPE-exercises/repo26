package uebung02;

import static gdi.MakeItSimple.*;

abstract public class MyEis implements Eis{

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
	
	public String getName(){
		return this.name;
	}

	public void setPreis(double preis) {
		this.preis = preis;
	}
	
	public double getPreis(){
		return this.preis;
	}

	public void setBehaeltnis(String behaeltnis) {
		this.behaeltnis = behaeltnis;
	}
	
	public String getBehaeltnis(){
		return this.behaeltnis;
	}

	public void setArt(String art) {
		this.art = art;
	}
	
	public String getArt(){
		return this.art;
	}

	public void setSorten(String[] sorten) {
		this.sorten = sorten;
	}
	
	public String[] getSorten(){
		return this.sorten;
	}

	public void setExtras(String[] extras) {
		this.extras = extras;
	}
	
	public String[] getExtras(){
		return this.extras;
	}
	
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
	
	public String[] frageSortenAb(int anzahlKugeln) {
		String[] sorten = new String[anzahlKugeln];
		for(int i=0;i<sorten.length;i++){
			System.out.print("Welche Sorte: ");
			//TODO Prüfe ob sorte verfügbar
			sorten[i] = readLine();
			System.out.println();
		}
		return sorten;
	}
	
	abstract public void fuellen();
	
	abstract public void dekorieren();
	
	
	
}
