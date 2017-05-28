package uebung04_aufgabe1.Livelock;

public class Joiner1 extends Thread{
	private Joiner2 joiner2;

	public Joiner1(String name, Joiner2 joiner2) {
		super(name);
		this.joiner2 = joiner2;
		start();
	}

	public void run() {
		try {
			joiner2.join();

		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		System.out.println(getName() + "join completed");
	}
}
