/**
 * @author lange
 * Studienleistungsaufgabe 4/2 aus dem Sommersemester 2017 TPE mit Herr Schramm
 */

package uebung04_aufgabe2;

public class QuickSort_Thread extends Thread {
	
	/**
	 * lower end of arraypart
	 */
	private int bottom;
	
	/**
	 * upper end of arrayPart
	 */
	private int top;
	
	/**
	 * sort object
	 */
	private QuickSort_Parallel sort;

	protected QuickSort_Thread(QuickSort_Parallel sort, int bottom, int top) {
		this.bottom = bottom;
		this.top = top;
		this.sort = sort;
		sort.addThread();
	}

	@Override
	public void run() {
		if (top > bottom) {
			int index;
			index = sort.zerlege(bottom, top);

			//create and start new thread for lower side of the array
			QuickSort_Thread thread = new QuickSort_Thread(sort, bottom, index - 1);
			thread.start();
			
			//restart the current thread for the upper side of the array
			this.bottom = index + 1;
			this.run();
			
			//need to wait for the thread
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
