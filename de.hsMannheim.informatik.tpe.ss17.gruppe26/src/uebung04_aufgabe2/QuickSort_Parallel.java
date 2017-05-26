/**
 * @author lange
 * Studienleistungsaufgabe 4/2 aus dem Sommersemester 2017 TPE mit Herr Schramm
 */

package uebung04_aufgabe2;

public class QuickSort_Parallel extends Thread implements SortAlgorithm {

	/**
	 * Count number of swaps needet to sort
	 */
	private int numberOfSwaps;

	/**
	 * Count number of comparisons needet to sort
	 */
	private int numberOfComparisons;

	/**
	 * Count number of created Threads during the whole sort
	 */
	private int numberOfCreatedThreads;

	/**
	 * logs the time needet so sort the array
	 */
	private long timeNeedet;

	/**
	 * array to sort
	 */
	protected static Comparable[] array;

	QuickSort_Parallel() {
		this.numberOfSwaps = 0;
		this.numberOfComparisons = 0;
		this.numberOfCreatedThreads = 0;
		this.timeNeedet = 0;
	}

	/*
	 * ################### start getter/setter/adder
	 */
	private void addSwap() {
		this.numberOfSwaps++;
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

	private int getSwaps() {
		return this.numberOfSwaps;
	}

	private int getCompares() {
		return this.numberOfComparisons;
	}

	private int getThreads() {
		return this.numberOfCreatedThreads;
	}

	private long getTime() {
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
	 * swap two objects in an array
	 * 
	 * @param array
	 * @param idx1
	 * @param idx2
	 * @return
	 */
	private void swapTwoNumbers(int idx1, int idx2) {
		addSwap();
		Comparable tmp = array[idx1];
		array[idx1] = array[idx2];
		array[idx2] = tmp;
	}

	/**
	 * copied from Semester 1
	 * 
	 * @param numberSequence
	 * @param bottom
	 * @param top
	 * @return
	 */
	protected int zerlege(int bottom, int top) {
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
	 * Print all informatins
	 * <li>Number of Swaps
	 * <li>Number of Comparisons
	 * <li>Number of Threads
	 * <li>Time
	 * <li>array
	 * 
	 * @param array
	 */
	protected void printStatus(Comparable[] array) {
		OwnUtils.printLines.printSeperatorDots();
		System.out.println("numberOfSwaps: " + this.getSwaps());
		System.out.println("numberOfComparisons: " + this.getCompares());
		System.out.println("numberOfCreatedThreads: " + this.getThreads());
		System.out.println("timeNeedet: " + this.getTime() + " millisec");
		OwnUtils.ArrayThings.printOneDimensionalArray(array);
		OwnUtils.printLines.printSeperatorDots();
	}
}
