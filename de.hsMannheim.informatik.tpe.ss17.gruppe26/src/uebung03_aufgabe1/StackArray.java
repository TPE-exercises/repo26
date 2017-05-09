package uebung03_aufgabe1;

public class StackArray implements Stack, ADT {
	private Object[] array;
	private int maxSize;

	StackArray(int maxSize) {
		this.maxSize = maxSize;
		this.array = new Object[maxSize];
	}

	StackArray() {
		this(5);
	}

	@Override
	public String toString(Node node) {
		String string = "";
		for (int i = 0; i < this.array.length; i++) {
			string += this.array[i];
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

		for (int i = 0; i < this.array.length; i++) {
			if (array[i] == null) {
				array[i] = element;
				return;
			}
			if (this.array.length > this.maxSize)
				throw new OverflowException(element);
			else {
				//TODO ERR
				doubleSizeArray();
				this.array[i]=element;
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
	public Node leave() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object front() {
		for (int i = 0; i < this.array.length; i++) {
			if (array[i] == null)
				return array[i - 1];
		}
		return null;
	}

	@Override
	public Stack emptyStack(int maxSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

}
