package uebung04_aufgabe1.Reproduzierung;

public class Menue_Uebung04_Aufgabe1_Reproduzierung {

	public static void main(String[] args) {
		System.out.println("Führen Sie das Programm mehrfach aus und beobachten Sie die verschiedenen Ergebnisse!");
		System.out.println("Es sollten zuerst 20 Punkte und dann 20 Sterne ausgegeben werden:");
		System.out.println("");
		Thread_CharPrinter thread1 = new Thread_CharPrinter ('.');
		Thread_CharPrinter thread2 = new Thread_CharPrinter ('*');
		thread1.start();
		thread2.start();
	}

}
