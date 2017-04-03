package tpe.uebung01;
import static gdi.MakeItSimple.*;
public class Menue {

	public static void main(String[] args) {
		print("geben sie m |m>0 an: ");
		 int m = readInt();

		BTree tree = new BTree(m);

		tree.insert(5);
		tree.insert(4);
		tree.insert(6);
		
		System.out.println("");
		

	}

}
