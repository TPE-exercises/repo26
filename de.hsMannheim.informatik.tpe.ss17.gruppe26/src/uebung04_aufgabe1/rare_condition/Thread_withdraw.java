package uebung04_aufgabe1.rare_condition;

public class Thread_withdraw extends Thread{

	int value;

	public Thread_withdraw(int value) {
		this.value = value;
	}
	
	public void run() {
		int oldBalance = Main.balance;
		oldBalance = oldBalance - this.value;
		Main.balance = oldBalance;
	}
}
