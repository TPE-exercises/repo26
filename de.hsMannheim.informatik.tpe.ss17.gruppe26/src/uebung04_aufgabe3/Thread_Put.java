package uebung04_aufgabe3;

public class Thread_Put extends Thread {

	
	int sleeptime;
	Menue_Uebung04_Aufgabe3 neuesObjekt;
	
	Thread_Put(int sleeptime, Menue_Uebung04_Aufgabe3 neuesObjekt) {
		this.sleeptime = sleeptime;
		this.neuesObjekt = neuesObjekt;
		setDaemon(true);
		start();
	}

	@Override
	public void run() {
		System.out.println("Erzeuger " + this + " gestartet!");
		
		//Soll immer laufen (bis Main beendet)
		while (true) {
			
			//Wartezeit (Zeit die zum verbrauchen benötigt wird)
			try {
				Thread.sleep(sleeptime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					Integer element = new Integer((int) (Math.random()*100));
//					System.out.println("Versuche Element " + element + " zu putten.");
					if (neuesObjekt.ringpuffer.getCount() >= neuesObjekt.ringpuffer.getLength()) {
						System.out.println("[ERZEUGER " + this.getName() + "]: Array leider voll, warte...");
					} else {
						try {
							neuesObjekt.ringpuffer.put(element);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("[ERZEUGER " + this.getName() + "]: Element "+ element+" eingefügt.");
					}
		}
	}
}
