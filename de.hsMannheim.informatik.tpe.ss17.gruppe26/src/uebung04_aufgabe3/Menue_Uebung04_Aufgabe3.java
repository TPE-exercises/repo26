package uebung04_aufgabe3;

public class Menue_Uebung04_Aufgabe3 {

	Ringpuffer ringpuffer;

	Menue_Uebung04_Aufgabe3(int length) {
		this.ringpuffer = new Ringpuffer(length);
	}

	public static void main(String[] args) {

		System.out.println("Version 2.0 (28/05/2017)");
		System.out.println("Erstellt von: Lange und Schoenke");
		System.out.println("4. Programmieraufgabe Aufgabe 3 aus TPE im SS17");
		OwnUtils.printLines.printSeperatorLine();
		System.out.println("Erzeuger (3) / Verbraucher (2)");	
		System.out.print("Bitte geben Sie die Größe des Ringpuffers ein: ");	
		Menue_Uebung04_Aufgabe3 neuesObjekt = new Menue_Uebung04_Aufgabe3(OwnUtils.Reader.readInt());
		System.out.print(
				"Bitte geben Sie die Anzahl Minuten an, wie lange der Ringpuffer beschrieben und gelesen werden soll: ");
		Thread_Timer time = new Thread_Timer(OwnUtils.Reader.readInt());
		System.out.println("");
		time.start();

		Thread_Put p1 = new Thread_Put(1000, neuesObjekt);
		Thread_Put p2 = new Thread_Put(1000, neuesObjekt);
		Thread_Put p3 = new Thread_Put(1000, neuesObjekt);
		Thread_Get g1 = new Thread_Get(500, neuesObjekt);
		Thread_Get g2 = new Thread_Get(500, neuesObjekt);

		try {
			time.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
