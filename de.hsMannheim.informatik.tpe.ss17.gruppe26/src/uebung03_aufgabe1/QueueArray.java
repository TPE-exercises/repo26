package uebung03_aufgabe1;

public class QueueArray implements Queue, ADT {
	private Object[] array;
	private int maxSize;
	private int first;
	private int count;

	QueueArray(int maxSize) {
		this.maxSize = maxSize;
		this.array = new Object[maxSize];
		this.first = 0;
		this.count = 0;
	}

	QueueArray() {
		this(5);
	}

	@Override
	public String toString(Node node) {
		String string = "";
		for (int i = 0; i < this.count; i++) {
			string += " " + this.array[(this.first + i) % this.array.length];
			// if (this.array[i] != null)
			// string += " " + this.array[i];
			// else
			// string += " _";
		}
		return string;
	}

	@Override
	public Node getHead() {
		// TODO not needet
		return null;
	}

	@Override
	public void enter(Object element) throws Exception {
		if (this.count < this.array.length) {
			this.array[(this.first + this.count) % this.array.length] = element;
			this.count++;
		} else {
			if (this.maxSize == this.array.length) {
				doubleSizeArray();
				this.enter(element);
//				System.out.println("*******double array size");
				throw new OverflowException();
			} else {
				throw new OverflowException(element);
			}
		}

	}

	private void doubleSizeArray() {
		Object[] doubleSizeArray = new Object[this.array.length * 2];

		for (int i = 0; i < this.array.length; i++) {
			doubleSizeArray[i] = this.array[i];
		}

		this.array = doubleSizeArray;
	}

	@Override
	public Object leave() throws Exception {
		this.first++;
		this.count--;
		return this.array[first - 1];
	}

	@Override
	public Object front() {
		return this.array[this.first];
	}

	@Override
	public boolean isEmpty() {
		if (this.count==0)
			return true;
		return false;
	}

	@Override
	public int size() {
		return this.count;
	}

}
