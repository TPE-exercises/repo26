package de.hsMannheim.informatik.ads.uebung05;


public class MyInteger extends MyObject {
	
	// declare objects with int-values
	
	private int value;  

	public MyInteger(int value) {
		this.value = value;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyInteger other = (MyInteger) obj;
		return other.value == value;
	
	}

	@Override
	public String toString() {
		return "MyObject [value= " + value + "]";
	}

}
