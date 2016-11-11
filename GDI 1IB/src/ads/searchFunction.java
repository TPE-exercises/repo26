package ads;
import static gdi.MakeItSimple.*;
public class searchFunction {


	
	public static void main(String[] args) {
	
		int choise = 0;
		int result = 0;
		int number = 0;
		int[] numberSequence;
		
		println("Wie lang ist die zu sortierende Folge?");
		int length = readInt();
		numberSequence = createNumberSequence(length);
		
		println("Mit welcher Methode soll gesucht werden?");
		choise = readInt();
		println("Welche Zahl soll gesucht werden?");
				
		if (choise == 1){
			result = linearSearchA(numberSequence, number);
		}
		else if(choise == 2){
			result = linearSearchB(numberSequence, number);
		}
		else if (choise == 3){
			result = BinarySearchRecursive(numberSequence, number);
		}
		else if (choise == 4){
			result = BinarySearchIterative(numberSequence, number);
		}
		else 
			println("Falsche eingabe");

		println(result);
	}
	
	static int[] createNumberSequence (int length){
		int i = 0;
		int[] numberSequence = new int[length];
		println("Geben sie die Zahlenfolge ein.");
		while (i < length){
			println("Gebe " + i + " Stelle ein");
			numberSequence[i] = readInt();
			i++;
		}
		return numberSequence;
	}
	
	
	static int linearSearchA (int[] numberSequence, int number){
		
		
		
		return -1;
	}
	static int linearSearchB (int[] numberSequence, int number){
		
		
		
		return -1;
	}
	static int BinarySearchRecursive (int[] numberSequence, int number){
		
		
		
		return -1;
	}
	static int BinarySearchIterative (int[] numberSequence, int number){
		
		
		
		return -1;
	}
	
}
