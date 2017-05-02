package uebung02_teil2_aufgabe2;

public class MyInt implements Comparable<MyInt> {

	private Integer integer;

	MyInt(Integer integer) {
		this.integer = integer;
	}

	public Integer getInteger() {
		return this.integer;
	}

	@Override
	public int compareTo(MyInt o) {
		System.out.println("Int");
		if (this.integer == o.getInteger())
			return 0;
		else if (this.integer < o.getInteger())
			return -1;
		else //(this.integer > o.getInteger())
			return 1;
	}

	public String toString() {
		return "" + this.integer;
	}

}
