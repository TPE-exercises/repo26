package uebung04_aufgabe3;

public class Thread_Get extends Thread {

	int sleeptime;
	Menue_uebung04_3 neuesObjekt;

	Thread_Get(int sleeptime, Menue_uebung04_3 neuesObjekt) {
		this.sleeptime = sleeptime;
		this.neuesObjekt = neuesObjekt;
		setDaemon(true);
		start();
	}

	@Override
	public void run() {
		System.out.println("Starte Verbraucher...:" + this);
		
		//Soll immer laufen (bis Main beendet)
		while (true) {
			System.out.println("Starte neue Runde:" + this);
			boolean geted = false;
			
			//Wartezeit (Zeit die zum verbrauchen benötigt wird)
			try {
				Thread.sleep(sleeptime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (neuesObjekt) {
				do {
					System.out.println("Versuche Element zu entfernen.");
					if (neuesObjekt.ringpufferAsArray.getCount() <= 0) {
						System.out.println("Array leider leer, warte...");
						try {
							wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else {
						try {
							System.out.println("Element: "+neuesObjekt.ringpufferAsArray.get() + " entfernt.");
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				} while (!geted);
			}

		}
	}
}
