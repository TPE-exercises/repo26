package uebung04_aufgabe3;

public class Thread_Timer extends Thread{
	int runTime;
	Thread_Timer(int runTime){
		this.runTime=runTime*60000;
	}
	
	/**
	 * this thread is the timegiver to let other threads work
	 */
	public void run(){
		final long timeStart = System.currentTimeMillis();
		
		while(System.currentTimeMillis()-timeStart < this.runTime){
			System.out.println("[TIMER]: " + (System.currentTimeMillis()-timeStart)/1000 + " Sek.");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("");
		System.out.println("[TIMER]: Zeit abgelaufen!");
		System.out.println("[TIMER]: Programm terminiert!");
	}
}
