package uebung04_aufgabe3;

public class Thread_Put extends Thread {

	int sleeptime;
	Menue_uebung04_3 neuesObjekt;
	
	Thread_Put(int sleeptime, Menue_uebung04_3 neuesObjekt) {
		this.sleeptime = sleeptime;
		this.neuesObjekt = neuesObjekt;
		setDaemon(true);
		start();
	}

	@Override
	public void run() {
		System.out.println("Starte Erzeuger...:" + this);
		while (true) {
			System.out.println("Starte neue Runde:" + this);
			boolean putted = false;
			try {
				Thread.sleep(sleeptime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (neuesObjekt) {
				do {
					Integer element = new Integer((int) (Math.random()*100));
					System.out.println("Versuche Element " + element + " zu putten.");
					if (neuesObjekt.ringpufferAsArray.getCount() >= neuesObjekt.ringpufferAsArray.getLength()) {
						System.out.println("Array leider voll, warte...");
						try {
							wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else {
						try {
							
							neuesObjekt.ringpufferAsArray.put(element);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("Element "+ element+" eingefügt.");
					}
				} while (!putted);
			}

		}
	}
}
