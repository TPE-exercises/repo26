package uebung05_1;

import java.util.Iterator;

public class MyIterator implements Iterator {

	private final MyBTree myBTree;
	private int current;
	private Integer[] lastObject;

	MyIterator(MyBTree myBTree) {
		this.myBTree = myBTree;
		this.current = 0;
		this.lastObject = new Integer[myBTree.size()];
	}

	@Override
	public boolean hasNext() {
		myBTree.levelorder();
		if (myBTree.removeArray.length > current)
			return true;
		else
			return false;
	}

	@Override
	public Object next() {
		if (hasNext()) {
			myBTree.levelorder();
			Object object = myBTree.removeArray[current];
			lastObject[current] = (Integer) object;
			current++;
			return object;
		} else
			return null;
	}

	@Override
	public void remove() {
		System.out.println("index: " + current);
		for (int i = 0; i < lastObject.length; i++)
			System.out.println("EL: " + this.lastObject[i]);

		if (current > 0) {
			myBTree.remove(this.lastObject[current - 1]);
			current--;
		}else
			System.out.println("Iterriere übers erste Element!");

	}
}