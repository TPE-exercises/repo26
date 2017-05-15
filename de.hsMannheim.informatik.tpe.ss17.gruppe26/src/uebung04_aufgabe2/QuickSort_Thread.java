package uebung04_aufgabe2;

public class QuickSort_Thread extends Thread {
	private int bottom;
	private int top;
	private QuickSort_Parallel sort;
	private Comparable[] array;
	private String name;

	public QuickSort_Thread(QuickSort_Parallel sort, Comparable[] array, int bottom, int top) {
		this.bottom = bottom;
		this.top = top;
		this.sort = sort;
		this.array = array;
		sort.addThread();
	}

	@Override
	public void run() {

		// Debug
//		OwnUtils.printLines.printSeperatorShortLines();
//		int rec = sort.numberOfRecursions + 1;
//		System.out.println("newQuicksort Instance " + rec);
//		OwnUtils.ArrayThings.printOneDimensionalArray(QuickSort_Parallel.array);
		// Debug


		
		if (top > bottom) {
			int index = sort.zerlege(QuickSort_Parallel.array, bottom, top);

			// Debug
//			OwnUtils.ArrayThings.printOneDimensionalArray(QuickSort_Parallel.array);
//			System.out.println("***Arr1: " + bottom + "-" + (index - 1));
//			System.out.println("***Arr2: " + (index + 1) + "-" + top);
			// Debug

			QuickSort_Thread thread1 = new QuickSort_Thread(sort,array, bottom, index - 1);
			thread1.start();


			QuickSort_Thread thread2 = new QuickSort_Thread(sort,array, index + 1, top);
			thread2.start();
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		

		}
		// debug
//		OwnUtils.ArrayThings.printOneDimensionalArray(QuickSort_Parallel.array);
//		System.out.println("endQuicksort Instance " + rec);
//		OwnUtils.printLines.printSeperatorDots();
		// debug

		return;
	}
}