package uebung04_aufgabe1.Deadlock;

public class Konto {
	
	public int balance;

	public Konto(int balance){
		this.balance = balance;
	}
	
	public static void main(String[] args) {
		System.out.println("Führen Sie das Programm mehrfach aus und beobachten Sie die verschiedenen Ergebnisse!");
		System.out.println("Es soll zu 1000 Euro 500 Euro auf- und wieder abgebucht werden:");
		System.out.println("");
		
		Konto konto = new Konto(0);
		
		Thread_withdraw withdraw = new Thread_withdraw (500, konto);
		Thread_deposit deposit = new Thread_deposit (500, konto);

		withdraw.start();
		deposit.start();
	}

}
