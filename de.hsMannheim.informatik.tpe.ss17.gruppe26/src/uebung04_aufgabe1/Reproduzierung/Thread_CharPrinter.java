package uebung04_aufgabe1.Reproduzierung;

public class Thread_CharPrinter extends Thread {
	char signal;

	public Thread_CharPrinter(char ch) {
		signal = ch;
	}

	public void run() {
		for (int i = 0; i < 20; i++) {
			System.out.print(signal);
		}
	}
}
