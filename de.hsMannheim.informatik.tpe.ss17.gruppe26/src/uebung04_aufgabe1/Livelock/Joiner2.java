package uebung04_aufgabe1.Livelock;

public class Joiner2 extends Thread{
	private Joiner1 joiner1;

	public Joiner2(String name, Joiner1 joiner1) {
		super(name);
		this.joiner1 = joiner1;
		start();
	}

	public void run() {
		try {
			joiner1.join();

		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		System.out.println(getName() + "join completed");
	}
}
