package uebung04_aufgabe1.Livelock;

public class Main {

	public static void main(String[] args) {
		System.out.println("Erstelle Threads...");
		Joiner1 sleepy = new Joiner1 ("Sleepy", dopey);
		Joiner1	grumpy = new Joiner1("Grumpy", doc);
		Joiner2 dopey = new Joiner2("Dopey", sleepy);
		Joiner2	doc = new Joiner2("Doc", grumpy);
		
//		grumpy.interrupt();

	}


}