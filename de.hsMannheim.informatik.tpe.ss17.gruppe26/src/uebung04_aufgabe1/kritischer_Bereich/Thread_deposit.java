package uebung04_aufgabe1.kritischer_Bereich;

public class Thread_deposit extends Thread {

	int value;

	public Thread_deposit(int value) {
		this.value = value;
	}

	public void run() {
		int oldBalance = Main.balance;
		oldBalance = oldBalance + this.value;
		Main.balance = oldBalance;
	}


}
