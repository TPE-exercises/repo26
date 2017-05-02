package uebung02_teil2_aufgabe2;

public class MyString implements Comparable<MyString> {

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
	public int compareTo(MyString o) {		
		//TODO Methode bestimmt nicht gültig, danicht selbst geschrieben
		return this.string.compareTo(o.getString());
	}

	public String toString(){
		return this.string;
	}
}
