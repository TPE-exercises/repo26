package uebung02_eisdiele2;

public interface Eisdiele {

	public String getRegion();

	/**
	 * 
	 */
	public void bestellen(String typ);

	/**
	 * Begrüße den Kunden
	 */
	public void begruesen();

	/**
	 * 
	 * @param eis
	 */
	public void kassieren(Eis eis);

	/**
	 * Verabschiedet den Kunden
	 * 
	 * @param String eis (toString)
	 */
	public void verabschieden(String eis);

	/**
	 * Entschuldigt, falls Eis nicht vorhanden
	 */
	public void entschuldigen();

}
