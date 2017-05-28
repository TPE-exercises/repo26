package uebung04_aufgabe3;

public class Menue_uebung04_3 {
	
	Ringpuffer ringpuffer;
	
	Menue_uebung04_3 (int length){
	this.ringpuffer = new Ringpuffer(length);
	}
	
	public static void main(String[ ]args){
		
		OwnUtils.printLines.printSeperatorLine();
		
		Menue_uebung04_3 neuesObjekt = new Menue_uebung04_3(5);
		
		Thread_Timer time = new Thread_Timer(OwnUtils.Reader.readInt());
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
