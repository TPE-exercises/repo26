package uebung02_eisdiele2;

public interface Eis {

	public void setName(String name);

	public String getName();

	public void setPreis(double preis);

	public double getPreis();

	public void setBehaeltnis(String behaeltnis);

	public String getBehaeltnis();

	public void setArt(String art);

	public String getArt();

	public void setSorten(String[] sorten);

	public String[] getSorten();

	public void setExtras(String[] extras);

	public String[] getExtras();

	/**
	 * Behaeltnis nehmen. . . Waffel/Becher/Teller/Schussel/Glas/etc.
	 */
	public void vorbereiten();

	/**
	 * Behaeltnis mit Sorten nach Art fuellen. . .
	 */
	public void fuellen();

	/**
	 * Ermöglicht Eiskugeln auf Kundenwunsch, benötigt bei einigen "Gerichten"
	 * 
	 * @return String array
	 */
	public String[] frageSortenAb(int anzahlKugeln);

	/**
	 * Eis mit Extras dekorieren...
	 */
	public void dekorieren();

	/**
	 * Erstellt String, welcher das EisObjekt für die Konsolenausgabe
	 * @return String
	 */
	public String toString();

}
