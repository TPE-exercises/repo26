package blatt5v2;

import static gdi.MakeItSimple.*;

public class Menu {

	

	public static void main(String[] args) {
	
		Hashtable ht = new Hashtable();
		
		while (true) {
	
			printMenu(); // print all options
	
			switch (getAction()) {
	
			case 1: { // put
				println("Key = ");
				String key = readLine();
				println("Value = ");
				String value = readLine();
	
				println("put " +  ht.put(key, value));
	
				break;
			}
			
			case 2: { // get 
				println("Key = ");
				String key = readLine();
	
				println("mapped to  =" + ht.get(key));
	
				break;
			}
			case 3: { // contains key
				println("Key = ");
				String key = readLine();
	
				println(" " + key + "  " + ht.containsKey(key));
	
				break;
			}
			case 4: { // contains value
				println("Value = ");
				String value = readLine();
	
				println(" " + value + "  " + ht.contains(value));
	
				break;
			}
			case 5: { // print
				ht.print();
	
				break;
			}
			case 6:{ // size
				println("size = "+ht.size());
				
				break;
			}
	
			case 7: { // remove
				println("Key = ");
				String key = readLine();
	
				println("removed key " + key + "  "
						+ ht.removeKey(key));
				break;
			}

	
			case 8: { // clear
				ht.clear();
				println("Hashtable cleared");
				ht.print();
	
				break;
			}
	
			case 9: {// load factor
				println("actual load factor= " + ht.getActualLoadFactor());
	
				break;
			}
	
			case 0: { // terminates loop
				return;
			}
	
			case 10: { // is Empty
				println("Hashtable is empty = "+ht.isEmpty());
				break;
			}
	
			default: {
				println("invalid input");
				break;
			}
	
			}
		}
	}

	public static int getAction() {
		String s = readLine();

		if (s.equals("1"))
			return 1;// put
		else if (s.equals("2"))
			return 2;// get
		else if (s.equals("3"))
			return 3;// containsKey
		else if (s.equals("4"))
			return 4;// containsValue
		else if (s.equals("5"))
			return 5;// print
		else if (s.equals("6"))
			return 6; // size
		else if (s.equals("7"))
			return 7;// remove
		else if (s.equals("8"))
			return 8;// clear
		else if (s.equals("9"))
			return 9;// loadFactor
		else if (s.equals("0"))
			return 0;// exit

		else
			return -1;
	}

	public static void printMenu() {

		println("Mögliche Aktionen: Wählen Sie eine Zahl");
		println(" (1) put");
		println(" (2) get");
		println(" (3) contains key");
		println(" (4) contains value");
		println(" (5) print Hashtable");
		println(" (6) size");
		println(" (7) removeKey");
		println(" (8) clear Hashtable");
		println(" (9) actual load factor");
		println(" (10) is empty");

		println(" (0) exit");

	}
}

