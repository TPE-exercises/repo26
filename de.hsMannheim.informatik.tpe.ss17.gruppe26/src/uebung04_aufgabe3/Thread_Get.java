package uebung04_aufgabe3;

public class Thread_Get extends Thread {

	int sleeptime;
	Menue_Uebung04_Aufgabe3 neuesObjekt;

	Thread_Get(int sleeptime, Menue_Uebung04_Aufgabe3 neuesObjekt) {
		this.sleeptime = sleeptime;
		this.neuesObjekt = neuesObjekt;
		setDaemon(true);
		start();
	}

	@Override
	public void run() {
		System.out.println("Verbraucher " + this + " gestartet! ");
		
		//Soll immer laufen (bis Main beendet)
		while (true) {
			
			if (neuesObjekt.ringpuffer.getCount() <= 0) {
				System.out.println("[VERBRAUCHER " + this.getName() + "]: Array leider leer, warte...");
			} else {
				try {
					System.out.println("[VERBRAUCHER " + this.getName() + "]: Element "+neuesObjekt.ringpuffer.get() + " wurde entfernt.");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			//Wartezeit (Zeit die zum verbrauchen benötigt wird)
			try {
				Thread.sleep(sleeptime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
