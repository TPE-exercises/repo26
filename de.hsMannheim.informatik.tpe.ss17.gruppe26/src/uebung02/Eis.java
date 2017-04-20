package uebung02;

public interface Eis {
	
	

		public void setName(String name);
		
		public String getName();

		public void setPreis(double preis);
		
		public double getPreis();
		
		public void setBehaeltnis(String behaeltnis) ;
		
		public String getBehaeltnis();

		public void setArt(String art) ;
		
		public String getArt();

		public void setSorten(String[] sorten);
		
		public String[] getSorten();

		public void setExtras(String[] extras);
		
		public String[] getExtras();

		// Spaghettieis
		/*
		 * Schale Schlagsahne über die Vanilleeis gepresst wird Graniert mit
		 * Erdbeersoße und geraspelter weißer Schokolade oder Kokosflocken
		 */

		// Bananensplit
		/*
		 * Banane, darauf Kugeln Vanille-, Schokoladen- und Erdbeereis darüber
		 * Ananassirup, Schokoladensauce und Erdbeersirup topping: Nusssplitter,
		 * Schlagsahne und Maraschino-Kirschen.
		 */

		// Nussbecher
		/*
		 * 3 Kugeln Eis, Nüsse, Sahne und Nusssauce
		 */

		/**
		 * Behaeltnis nehmen. . . Waffel/Becher/Teller/Schussel/Glas/etc.
		 */
		public void vorbereiten();

		/**
		 * Behaeltnis mit Sorten nach Art fuellen. . .
		 */
		public void fuellen();
		

		/**
		 * 
		 * @return String array
		 */
		public String[] frageSortenAb(int anzahlKugeln);
	

		/**
		 * Eis mit Extras dekorieren...
		 */
		public void dekorieren();

}
