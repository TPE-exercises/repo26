package myUtil;

public class StackArray implements Stack, ADT {
	private Object[] array;
	private int maxSize;

	public StackArray(int maxSize) {
		this.maxSize = maxSize;
		this.array = new Object[maxSize];
	}

	public StackArray() {
		this(5);
	}

	@Override
	public String toString(Node node) {
		String string = "";
		for (int i = 0; i < this.array.length; i++) {
			if (this.array[i] != null)
				string += " " + this.array[i];
			else
				string += " _";
		}
		return string;
	}

	@Override
	public Node getHead() {
		// TODO not needet
		return null;
	}

	@Override
	public void enter(Object element) throws OverflowException {
		// System.out.println("___________");
		// System.out.println("length: " + this.array.length + " toEnter: " +
		// element);
		int i = 0;
		for (i = 0; i < this.array.length; i++) {
			// System.out.println("El: " + this.array[i] + " at: " + i);
			if (array[i] == null) {
				array[i] = element;
				// System.out.println("enter El: " + element + " at: " + i);
				return;
			}
		}
		// Array to short double or Exception
		if (this.array.length > this.maxSize) {
			throw new OverflowException("Too many Object, Array allready doublesize: ",element);
		} else {
			doubleSizeArray();
			this.array[i] = element;
			try {
				throw new OverflowException("Too many Object, doublesize array: ", element);
			} catch (OverflowException ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * double the size of the array and clone it into the longer
	 */
	private void doubleSizeArray() {
//		System.out.println("doubleSize");
		Object[] doubleSizeArray = new Object[this.array.length * 2];

		for (int i = 0; i < this.array.length; i++) {
			doubleSizeArray[i] = this.array[i];
		}

		this.array = doubleSizeArray;
	}

	@Override
	public Object leave() throws Exception {
		Object toLeave = null;
		if (this.array[0] == null) {
			throw new UnderflowException();
		}
		for (int i = 0; i < this.array.length; i++) {
			if (array[i] == null) {
				toLeave = this.array[i - 1];
				array[i - 1] = null;
				return toLeave;
			}
		}
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
	public boolean isEmpty() {
		if (this.array[0] == null)
			return true;
		return false;
	}

	@Override
	public int size() {
		int count=0;
		for (int i = 0; i < this.array.length; i++) {
			if (array[i] != null){
				count++;
			}
			else return count;
				
		}
		return 0;
	}

}
