package uebung04_aufgabe3;

public class Thread_Put extends Thread {

	int sleeptime;
	Menue_Uebung04_Aufgabe3 neuesObjekt;
	
	/**
	 * constructer sets this thread as daemon and starts it
	 * @param sleeptime
	 * @param neuesObjekt
	 */
	Thread_Put(int sleeptime, Menue_Uebung04_Aufgabe3 neuesObjekt) {
		this.sleeptime = sleeptime;
		this.neuesObjekt = neuesObjekt;
		setDaemon(true);
		start();
	}

	/**
	 * thread puts a random number into the ringbuffer.
	 * if ringbuffer is full, thread will sleep (sleeptime).
	 */
	@Override
	public void run() {
		System.out.println("Erzeuger " + this + " gestartet!");
		
		//run permanently till the timer thread stops that deamon
		while (true) {
			
			//waitingtime (time that needed to create an item of the ringbuffer)
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
