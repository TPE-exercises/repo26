package blatt6;

import static gdi.MakeItSimple.*;

/*Die zu implementierenden Methoden
(bei einigen Methoden sind 
bespielhaft Rückgabetypen angegeben)
1.
addFirst (int)
2.
addLast (int)
3.
int removeFirst ()
4.
int 
removeLa
st ()
5.
int getFirst ()
6.
int getLast ()
7.
bool isEmpty ()
8.
LinkedList 
empty ()
// 
Achtung
è
static Methode
(Klasse)
9.
b
ool contains (int)
10.
LinkedList 
clear ()
11.
int size()
12.
LinkedList 
clone ()
13.
delete (int)
14.
String toString 
()
15.
add(int index, int element)
16.
int get(int index)
17.
int [] toArray ()
18.
LinkedList cloneDeep ()
19.
addAll(LinkedList otherList)
20.
concat(LinkedList otherList)
Bei  den  Methoden,  bei 
denen  kein  Rückgabetyp  angegeben  ist, 
müssen Sie sich einen sinnvollen überlegen.
*/

public class Main {

	private static LinkedList list;

	public static void main(String[] args) {

		list = new MyLinkedList();

		while (true) {
			makeMenu();
		}

	}

	public static void makeMenu() {
		println("------------------- MenÜ -------------------");
		println("1: Print List");
		println("2: Print size of the list");
		println("3: add(index, element)");
		println("4: addFirst(element)");
		println("5: addLast(element)");
		println("6: addAll(LinkedList)");
		println("7: get(index)");
		println("8: getFirst()");
		println("9: getLast()");
		println("10: removeFirst()");
		println("11: removeLast()");
		println("12: removeAll()");
		println("13: remove(element)");

		int selection = readInt();

		switch (selection) {
		case 1:
			// your code here
			break;
		case 2:
			// your code here
			break;
		case 3:
			// your code here
			break;
		case 4:
			// your code here
			// for instance you code looks something like this
			MyObject obj1 = new MyObject("First Element");
			list.addFirst(obj1);  // syntax error until defining addFirst

			break;
		case 5:
			// your code here
			break;
		case 6:
			// your code here
			break;
		case 7:
			// your code here
			break;
		case 8:
			// your code here
			break;
		case 9:
			// your code here
			break;
		case 10:
			// your code here
			break;
		case 11:
			// your code here
			break;
		case 12:
			// your code here
			break;
		case 13:
			// your code here
			break;
		default:
			break;
		}
		;

		readLine();

	}
}

