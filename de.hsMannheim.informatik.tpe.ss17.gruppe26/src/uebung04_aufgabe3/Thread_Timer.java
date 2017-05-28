package uebung04_aufgabe3;

public class Thread_Timer extends Thread{
	int runTime;
	Thread_Timer(int runTime){
		this.runTime=runTime*60000;
	}
	
	public void run(){
		final long timeStart = System.currentTimeMillis();
		
		while(System.currentTimeMillis()-timeStart < this.runTime){
			System.out.println((System.currentTimeMillis()-timeStart)/1000 + "sec");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		notifyAll();
	}
}
