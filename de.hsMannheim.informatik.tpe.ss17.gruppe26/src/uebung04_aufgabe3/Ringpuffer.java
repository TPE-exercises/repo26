package uebung04_aufgabe3;

public class Ringpuffer {

	private int first;
	private int count;
	private Comparable[] array;

	/**
	 * constructer of the ringbuffer
	 * @param length
	 * @param first
	 * @param count
	 */
	private Ringpuffer(int length, int first, int count) {
		this.array = new Comparable[length];
		this.first = first;
		this.count = count;
	}

	/**
	 * constructer of ringbuffer with length parameter
	 * @param length
	 */
	public Ringpuffer(int length) {
		this(length, 0, 0);
	}

	/**
	 * contructer of ringbuffer without parameters
	 */
	public Ringpuffer() {
		this(5, 0, 0);
	}

	/**
	 * 
	 * @return the length of the ringbuffer
	 */
	public int getLength() {
		return array.length;
	}

	/**
	 * 
	 * @return 
	 */
	public int getFirst() {
		return this.first;
	}

	/**
	 * 
	 * @return
	 */
	public int getCount() {
		return this.count;
	}

	/**
	 * 
	 * @return the ringbuffer array
	 */
	public Comparable[] getArray() {
		return this.array;
	}

	/**
	 * 
	 * @param index
	 * @return
	 */
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
	synchronized void put(Comparable el) throws Exception {
		if (this.count < this.array.length) {
			this.count++;
			this.array[(this.first + this.count - 1) % this.array.length] = el;
		} else {
			try {
				System.out.println("Puffer voll => Erzeuger blockiert");
				wait();
			} catch (Exception e) {
			}
		}
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	synchronized Comparable get() throws Exception {
		if (this.count > 0) {
			this.count--;
			this.first++;
			return this.array[(this.first - 1) % this.array.length];
		} else {
			try {
				System.out.println("Puffer leer => Verbraucher blockiert");
				wait();
			} catch (Exception e) {
			}
		}
		throw new Exception("Ringpuffer is Empty!");
	}
}
