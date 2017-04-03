package de.hsMannheim.informatik.ads.uebung06;

import static gdi.MakeItSimple.*;

import javax.swing.JPopupMenu.Separator;

public class Main {

	private MyBinaryTree tree;

	public static void main(String[] args) {

		println("Was wollen Sie ausführen?");

		println("1. insert (val)");
		println("2. insert (file)");
		println("3. contains");
		println("4. size");
		println("5. hight");
		println("6. getMax");
		println("7. getMin");
		println("8. remove");
		println("9. isEmpty");
		println("10. addAll");
		println("11. printInorder");
		println("12. printPostorder");
		println("13. printPreorder");
		println("14. printLevelorder");
		println("15. clone");

		int selection = readInt();
		readLine();
		separator();
		switch (selection) {
		case (1):
			
			print("Geben Sie den Wert ein, den sie einfügen wollen: ");
			int val = readInt();
			readLine();
			boolean done = false;
					
			done = tree.insert(val);
			
			if(done)
				println("Der Wert " + val + " wurde erfolgreich eingefügt.");
			else
				println("Der Wert " + val + " wurde nicht eingefügt.");
			
			break;
		case (2):
			break;
		case (3):
			break;
		case (4):
			break;
		case (5):
			break;
		case (6):
			break;
		case (7):
			break;
		case (8):
			break;
		case (9):
			break;
		case (10):
			break;
		case (11):
			break;
		case (12):
			break;
		case (13):
			break;
		case (14):
			break;
		case (15):
			break;
		}

	}
	
	private static void separator(){
		println("-------------------------------------");
	}

}
