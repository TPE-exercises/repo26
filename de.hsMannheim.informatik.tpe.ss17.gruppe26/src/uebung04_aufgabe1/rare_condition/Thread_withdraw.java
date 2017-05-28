package uebung04_aufgabe1.rare_condition;

public class Thread_withdraw extends Thread{

	int value;

	public Thread_withdraw(int value) {
		this.value = value;
	}
	
	public void run() {
		int oldBalance = Menue_Uebung04_Aufgabe1_rare_condition.balance;
		oldBalance = oldBalance - this.value;
		Menue_Uebung04_Aufgabe1_rare_condition.balance = oldBalance;
	}
}
