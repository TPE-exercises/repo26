package OwnUtils;

public class RingpufferAsArray {

	private int first;
	private int count;
	private Comparable[] array;

	RingpufferAsArray(int length, int first, int count) {
		this.array = new Comparable[length];
		this.first = first;
		this.count = count;
	}

	RingpufferAsArray(int length) {
		this(length, 0, 0);
	}

	RingpufferAsArray() {
		this(5, 0, 0);
	}

	public int getFirst() {
		return this.first;
	}

	public int getCount() {
		return this.count;
	}

	public Comparable[] getArray() {
		return this.array;
	}

	public Comparable getIndex(int index) {
		if (index > this.count)
			return null;
		return this.array[(first + index) % this.array.length];
	}

	/**
	 * put an element into the ringpuffer
	 * 
	 * @param Comparable
	 *            element to enter
	 * @throws Exception
	 *             when array is full
	 */
	public void put(Comparable el) throws Exception {
		if (this.count < this.array.length) {
			this.count++;
			this.array[(this.first + this.count-1) % this.array.length] = el;
		} else {
			throw new Exception("Ringpuffer already full: "+el);
		}
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public Comparable get() throws Exception {
		if (this.count > 0) {
			this.count--;
			this.first++;
			return this.array[(this.first - 1) % this.array.length];
		} else
			throw new Exception("Ringpuffer is Empty!");
	}
}
