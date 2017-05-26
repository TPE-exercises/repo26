package uebung04_aufgabe2;

public class QuickSort_Thread extends Thread {
	private int bottom;
	private int top;
	private QuickSort_Parallel sort;
	private String name;

	public QuickSort_Thread(QuickSort_Parallel sort, int bottom, int top) {
		this.bottom = bottom;
		this.top = top;
		this.sort = sort;
		sort.addThread();
	}

	@Override
	public void run() {
		
		QuickSort_Parallel.nowRunningThreads++;

		if (top > bottom) {
			int index;
			index = sort.zerlege(bottom, top);

			QuickSort_Thread thread = new QuickSort_Thread(sort, bottom, index - 1);
			thread.start();
			this.bottom = index + 1;
			this.run();
			
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			

		}
		QuickSort_Parallel.nowRunningThreads--;
	}
}
