package uebung04_aufgabe1.Deadlock;

public class Thread_withdraw extends Thread {

	int value;
	Konto konto;

	/**
	 * Konstruktor für den Abbuch-Thread
	 * @param value stellt den Betrag der Abbuchung dar
	 * @param konto ist das Konto, welches belastet wird
	 */
	public Thread_withdraw(int value, Konto konto) {
		this.value = value;
		this.konto = konto;
	}

	/**
	 * Thread zur Belastung des Kontos
	 */
	public void run() {
		boolean withdrawed = false;
		System.out.println("Starte Abhebevorgang...");
		synchronized (konto) {
			System.out.println("w: Sperre Konto!");
			
			do {
				if (konto.balance - this.value < 0) {
					System.out.println("Warte, dass Konto gedeckt wird.");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					int oldBalance = konto.balance;
					oldBalance = oldBalance - this.value;
					konto.balance = oldBalance;
					withdrawed = true;
					System.out.println("Es wurde abgebucht! Kontostand nun: " + konto.balance);
				}
			} while (!withdrawed);
			System.out.println("w: Konto wird wieder freigegeben.");
		}
	}
}
