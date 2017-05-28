package uebung04_aufgabe3;

public class Thread_Get extends Thread {

	int sleeptime;
	Menue_Uebung04_Aufgabe3 neuesObjekt;

	/**
	 * constructer sets this thread as daemon and starts it
	 * @param sleeptime
	 * @param neuesObjekt
	 */
	Thread_Get(int sleeptime, Menue_Uebung04_Aufgabe3 neuesObjekt) {
		this.sleeptime = sleeptime;
		this.neuesObjekt = neuesObjekt;
		setDaemon(true);
		start();
	}

	/**
	 * thread gets a number of the ringbuffer.
	 * if ringbuffer is empty, thread sleep (sleeptime)
	 */
	@Override
	public void run() {
		System.out.println("Verbraucher " + this + " gestartet! ");
		
		//run permanently till the timer thread stops that deamon
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
			
			//waitingtime (time that needed to consume an item of the ringbuffer)
			try {
				Thread.sleep(sleeptime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
