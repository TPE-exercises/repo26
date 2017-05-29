package uebung04_aufgabe1.Livelock;

public class Main_Uebung04_Aufgabe1_Livelock {

	public static void main(String[] args) {
		System.out.println("Erstelle Threads...");
		
		Joiner1 sleepy = new Joiner1 ("Sleepy", null);
		Joiner1	grumpy = new Joiner1("Grumpy", null);
		Joiner2 dopey = new Joiner2("Dopey", sleepy);
		Joiner2	doc = new Joiner2("Doc", grumpy);
		
		sleepy.setJoiner(dopey);
		grumpy.setJoiner(doc);
		
		sleepy.start();
		grumpy.start();
		dopey.start();
		doc.start();
		
//		grumpy.interrupt();

	}
}
