package tpe.uebung01;
import static gdi.MakeItSimple.*;
public class Menue {

	public static void main(String[] args) {
		print("geben sie m |m>0 an: ");
		BTree.m = readInt();

		BTree tree = new BTree(1);

		tree.insert(5);
		tree.insert(4);
		tree.insert(6);
		
		System.out.println("");
		

	}

}
