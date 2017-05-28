package uebung04_aufgabe1.rare_condition;

public class Menue_Uebung04_Aufgabe1_rare_condition {
	
	public static int balance=1000;

	public static void main(String[] args) {
		System.out.println("Führen Sie das Programm mehrfach aus und beobachten Sie die verschiedenen Ergebnisse!");
		System.out.println("Es soll zu 1000 Euro 500 Euro auf- und wieder abgebucht werden:");
		System.out.println("");
		
		while(true){
			Thread_deposit deposit = new Thread_deposit (500);
			Thread_withdraw withdraw = new Thread_withdraw (500);
		deposit.start();
		withdraw.start();
		
		
		System.out.println(balance);
		try {
			deposit.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}

}
