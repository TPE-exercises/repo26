package myUtil;

public class QueueArray implements Queue, ADT {
	private Object[] array;
	private int maxSize;
	private int first;
	private int count;

	public QueueArray(int maxSize) {
		this.maxSize = maxSize;
		this.array = new Object[maxSize];
		this.first = 0;
		this.count = 0;
	}

	public QueueArray() {
		this(5);
	}

	@Override
	public String toString(Node node) {
		String string = "";
		for (int i = 0; i < this.count; i++) {
			string += " " + this.array[(this.first + i) % this.array.length];
		
		}
		for (int i = count; i < this.array.length; i++) {
			string += " _";
		}
		System.out.println("length: "+this.array.length);
		return string;
	}

	@Override
	public Node getHead() {
		return null;
	}

	@Override
	public void enter(Object element) throws OverflowException {
		if (this.count < this.array.length) {
			this.array[(this.first + this.count) % this.array.length] = element;
			this.count++;
		} else {
			if (this.maxSize == this.array.length) {
				doubleSizeArray();
				this.enter(element);
				
				
				try {
					throw new OverflowException("Too many Object, doublesize array: ", element);
				} catch (OverflowException ex) {
					ex.printStackTrace();
				}
				
			} else {
				throw new OverflowException("Too many Object, Array allready doublesize: ",element);
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
	public Object leave() throws UnderflowException {
		if (this.count==0) {
			throw new UnderflowException();
		}
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
		if (this.count == 0)
			return true;
		return false;
	}

	@Override
	public int size() {
		return this.count;
	}

}
