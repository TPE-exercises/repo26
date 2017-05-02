package uebung02_eisdiele2;

public interface Eis {
	/**
	 * @category getter/setter
	 * @param name
	 */
	public void setName(String name);

	/**
	 *  @category getter/setter
	 * @return
	 */
	public String getName();

	/**
	 *  @category getter/setter
	 * @param preis
	 */
	public void setPreis(double preis);

	/**
	 *  @category getter/setter
	 * @return
	 */
	public double getPreis();

	/**
	 *  @category getter/setter
	 * @param behaeltnis
	 */
	public void setBehaeltnis(String behaeltnis);

	/**
	 *  @category getter/setter
	 * @return
	 */
	public String getBehaeltnis();

	/**
	 *  @category getter/setter
	 * @param art
	 */
	public void setArt(String art);

	/**
	 *  @category getter/setter
	 * @return
	 */
	public String getArt();

	/**
	 *  @category getter/setter
	 * @param sorten
	 */
	public void setSorten(String[] sorten);

	/**
	 *  @category getter/setter
	 * @return
	 */
	public String[] getSorten();

	/**
	 *  @category getter/setter
	 * @param extras
	 */
	public void setExtras(String[] extras);

	/**
	 *  @category getter/setter
	 * @return
	 */
	public String[] getExtras();

	/**
	 * Take container...
	 * Behaeltnis nehmen. . . Waffel/Becher/Teller/Schussel/Glas/etc.
	 */
	public void vorbereiten();

	/**
	 * fill Container with varieties
	 * Behaeltnis mit Sorten nach Art fuellen. . .
	 */
	public void fuellen();

	/**
	 * Enables ice balls at customer's request, needs at some "dishes"
	 * Ermöglicht Eiskugeln auf Kundenwunsch, benötigt bei einigen "Gerichten"
	 * 
	 * @return String array
	 */
	public String[] frageSortenAb(int anzahlKugeln);

	/**
	 * Decorate ice with extras ...
	 * Eis mit Extras dekorieren...
	 */
	public void dekorieren();

	/**
	 * Creates String, which is the Ice object for console output
	 * Erstellt String, vom EisObjekt für die Konsolenausgabe 
	 * 
	 * @return String
	 */
	public String toString();

}
