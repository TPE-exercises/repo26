package uebung02_teil2_aufgabe2;

public class MyInt implements Comparable {

	private Integer integer;

	public MyInt(Integer integer) {
		this.integer = integer;
	}

	public Integer getInteger() {
		return this.integer;
	}

	public int compareTo(Object o) {
//		System.out.println("Int");
		if (this.integer == ((MyInt) o).getInteger())
			return 0;
		else if (this.integer < ((MyInt) o).getInteger())
			return -1;
		else //(this.integer > o.getInteger())
			return 1;
	}

	public String toString() {
		return "" + this.integer;
	}



}
