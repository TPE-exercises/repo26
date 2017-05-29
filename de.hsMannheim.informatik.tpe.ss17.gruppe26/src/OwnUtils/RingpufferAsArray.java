package OwnUtils;

public class RingpufferAsArray {

	private int first;
	private int count;
	private Comparable[] array;

	private RingpufferAsArray(int length, int first, int count) {
		this.array = new Comparable[length];
		this.first = first;
		this.count = count;
	}

	public RingpufferAsArray(int length) {
		this(length, 0, 0);
	}

	public RingpufferAsArray() {
		this(5, 0, 0);
	}

	public int getLength() {
		return array.length;
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
	synchronized public void put(Comparable el) throws Exception {
		boolean put = false;
		do {
			if (this.count < this.array.length) {
				this.count++;
				put = true;
				this.array[(this.first + this.count - 1) % this.array.length] = el;
			} else {
				System.out.println("Array leider voll, warte...");
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// throw new Exception("Ringpuffer already full: "+el);

			}
		} while (!put);
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	synchronized public Comparable get() throws Exception {
		boolean get = false;
		do {
			if (this.count > 0) {
				this.count--;
				this.first++;
				get = true;
				return this.array[(this.first - 1) % this.array.length];
			} else {
				System.out.println("Array leider leer, warte...");
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// throw new Exception("Ringpuffer is Empty!");
		} while (!get);
		return null;
	}
}
