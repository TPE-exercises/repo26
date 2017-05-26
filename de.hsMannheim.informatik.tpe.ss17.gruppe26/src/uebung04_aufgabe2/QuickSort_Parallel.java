package uebung04_aufgabe2;

public class QuickSort_Parallel extends Thread implements SortAlgorithm {

	private int numberOfSwaps;
	private int numberOfComparisons;
	private int numberOfCreatedThreads;
	protected int numberOfRecursions;
	private long timeNeedet;

	protected static int nowRunningThreads = 0;

	protected static Comparable[] array;

	QuickSort_Parallel() {
		numberOfSwaps = 0;
		numberOfComparisons = 0;
		numberOfCreatedThreads = 0;
		numberOfRecursions = 0;
		timeNeedet = 0;
	}

	/*
	 * ################### start getter/setter/adder
	 */
	private void addSwap() {
		this.numberOfSwaps++;
	}

	protected void addRecursion() {
		this.numberOfRecursions++;
	}

	private void setTime(long time) {
		this.timeNeedet = time;
	}

	protected void addThread() {
		this.numberOfCreatedThreads++;
	}

	private void addCompare() {
		this.numberOfComparisons++;
	}

	public int getSwaps() {
		return this.numberOfSwaps;
	}

	public int getCompares() {
		return this.numberOfComparisons;
	}

	public int getThreads() {
		return this.numberOfCreatedThreads;
	}

	public int getRecusions() {
		return this.numberOfRecursions;
	}

	public long getTime() {
		return this.timeNeedet;
	}
	/*
	 * ################### end getter/setter/adder
	 */

	@Override
	public void sort(Comparable[] array) {
		this.array = array;
		final long timeStart = System.currentTimeMillis();

		QuickSort_Thread thread1 = new QuickSort_Thread(this, 0, array.length - 1);
		thread1.start();

		// wait until Thread is ready
		try {
			thread1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		final long timeEnd = System.currentTimeMillis();
		setTime(timeEnd - timeStart);

	}

	/**
	 * 
	 * @param array
	 * @param idx1
	 * @param idx2
	 * @return
	 */
	synchronized private void swapTwoNumbers(int idx1, int idx2) {
		addSwap();

		Comparable tmp = array[idx1];
		array[idx1] = array[idx2];
		array[idx2] = tmp;

	}

	/**
	 * 
	 * @param numberSequence
	 * @param bottom
	 * @param top
	 * @return
	 */
	synchronized protected int zerlege(int bottom, int top) {
		int pivot = top;
		int index = bottom;

		for (int marker = bottom; marker <= top - 1; marker++) {
			this.addCompare();
			if (array[marker].compareTo(array[pivot]) == -1 || array[marker].compareTo(array[pivot]) == 0) {
				if (index != marker) {
					swapTwoNumbers(index, marker);
				}
				index++;
			}
		}
		swapTwoNumbers(index, pivot);
		return index;
	}

	/**
	 * 
	 * @param array
	 */
	public void printStatus(Comparable[] array) {
		OwnUtils.printLines.printSeperatorDots();
		 System.out.println("numberOfSwaps: " + this.getSwaps());
		 System.out.println("numberOfComparisons: " + this.getCompares());
		 System.out.println("numberOfCreatedThreads: " + this.getThreads());
		 System.out.println("timeNeedet: " + this.getTime() + " millisec");
		OwnUtils.ArrayThings.printOneDimensionalArray(array);
		OwnUtils.printLines.printSeperatorDots();
	}
}
