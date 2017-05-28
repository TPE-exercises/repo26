package uebung04_aufgabe3;

public class Ringpuffer {

	private int first;
	private int count;
	private Comparable[] array;

	private Ringpuffer(int length, int first, int count) {
		this.array = new Comparable[length];
		this.first = first;
		this.count = count;
	}

	public Ringpuffer(int length) {
		this(length, 0, 0);
	}

	public Ringpuffer() {
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
