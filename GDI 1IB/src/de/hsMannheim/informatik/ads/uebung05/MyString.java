package de.hsMannheim.informatik.ads.uebung05;

public class MyString extends MyObject {
	
	private String value;   // 

	public MyString(String value) {
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
		MyString other = (MyString) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MyString [value= " + value + "]";
	}

}
