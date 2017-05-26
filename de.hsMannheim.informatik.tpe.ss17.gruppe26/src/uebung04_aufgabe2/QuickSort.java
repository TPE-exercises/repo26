package uebung04_aufgabe2;

public class QuickSort implements SortAlgorithm {

	private int numberOfSwaps;
	private int numberOfComparisons;
	private int numberOfCreatedThreads;
	protected int numberOfRecursions;
	private long timeNeedet;
	protected static Comparable[] array;

	QuickSort() {
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

		run(0, array.length - 1);

		final long timeEnd = System.currentTimeMillis();
		setTime(timeEnd - timeStart);

	}

	public void run(int bottom, int top) {
		addRecursion();
		if (top > bottom) {
			int index = zerlege(bottom, top);

			run(bottom, index - 1);
			run(index + 1, top);

		}
	}

	/**
	 * 
	 * @param numberSequence
	 * @param idx1
	 * @param idx2
	 * @return
	 */
	private void swapTwoNumbers(int idx1, int idx2) {
		this.addSwap();
		Comparable tmp = array[idx1];
		array[idx1] = array[idx2];
		array[idx2] = tmp;
	}

	/**
	 * 
	 * @param array
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
	 * 
	 * @param array
	 */
	public void printStatus(Comparable[] array) {
		OwnUtils.printLines.printSeperatorDots();
		System.out.println("numberOfSwaps: " + this.getSwaps());
		System.out.println("numberOfComparisons: " + this.getCompares());
		System.out.println("numberOfRecursions: " + this.getRecusions());
		System.out.println("timeNeedet: " + this.getTime() + " millisec");
		OwnUtils.ArrayThings.printOneDimensionalArray(array);
		OwnUtils.printLines.printSeperatorDots();
	}
}
