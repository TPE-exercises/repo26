package uebung02_teil2_aufgabe2;

public class MyString implements Comparable {

	private String string;
	
	MyString(String string){
		this.string=string;
	}
	
	public String getString(){
		return this.string;
	}

	/**
	 * @return 0  this==o; -1 this<o; 1 this>o
	 */
	@Override
	public int compareTo(Object o) {		
		//TODO Methode bestimmt nicht gültig, danicht selbst geschrieben
		
		int x =this.string.compareTo(((MyString) o).getString());
//		System.out.println("****************Test: " + o + " | " + this + " | "+ x);
		return x;
	}

	public String toString(){
		return this.string;
	}
}
