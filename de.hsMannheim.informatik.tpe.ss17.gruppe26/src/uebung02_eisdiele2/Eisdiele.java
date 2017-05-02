package uebung02_eisdiele2;

public interface Eisdiele {

	/**
	 *  @category getter/setter
	 * @return
	 */
	public String getRegion();

	/**
	 * 
	 */
	public void bestellen(String typ);

	/**
	 * Welcome the customer
	 * Begrüße den Kunden
	 */
	public void begruesen();

	/**
	 * 
	 * @param eis
	 */
	public void kassieren(Eis eis);

	/**
	 * Adopts the customer
	 * Verabschiedet den Kunden
	 * 
	 * @param String eis (toString)
	 */
	public void verabschieden(String eis);

	/**
	 * Excused if ice does not exist
	 * Entschuldigt, falls Eis nicht vorhanden
	 */
	public void entschuldigen();

}
