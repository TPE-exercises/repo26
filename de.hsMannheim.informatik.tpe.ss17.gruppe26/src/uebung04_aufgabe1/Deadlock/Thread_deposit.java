package uebung04_aufgabe1.Deadlock;

public class Thread_deposit extends Thread {

	int value;
	Konto konto;

	/**
	 * Konstruktur für den Einzahl-Thread
	 * @param value stellt den Betrag dar
	 * @param konto ist das übergebene Konto, auf das eingezahlt werden soll
	 */
	public Thread_deposit(int value, Konto konto) {
		this.value = value;
		this.konto = konto;
	}

	/**
	 * Thread zur Einzahlung eines Betrags auf das Konto 
	 */
	public void run() {
		System.out.println("Starte Einzahlung...");
		synchronized (konto) {
			System.out.println("d: Sperre Konto!");
			int oldBalance = konto.balance;
			oldBalance = oldBalance + this.value;
			konto.balance = oldBalance;System.out.println("Es wurde Geld eingezahlt! Kontostand nun: "+konto.balance);
			System.out.println("d: Konto wird wieder freigegeben.");
		}	
	}
}
