package ads;
import static gdi.MakeItSimple.*;
public class searchFunction {


	
	public static void main(String[] args) {
	
		int result1 = 0;
		int result2 = 0;
		int result3 = 0;
		int result4 = 0;
		int searchNumber = 0;
		int[] numberSequence;
		
		/*println("Wie lang ist die zu sortierende Folge?");
		int length = readInt();*/ int length = 10;
		numberSequence = createDNumberSequence(1);
	
		println("Welche Zahl soll gesucht werden?");
		searchNumber = readInt();
				
			result1 = linearSearchA(numberSequence, searchNumber);
			result2 = linearSearchB(numberSequence, searchNumber);
			result3 = BinarySearchRecursive(numberSequence, searchNumber, 0, numberSequence.length-1);
			result4 = BinarySearchIterative(numberSequence, searchNumber);
			
			;
			
			println("Array________________________");
			for (int i = 0; i < length; i++) {
				print(i + "  ");
			}println();
			for (int i = 0; i < length; i++) {
				print(numberSequence[i] + " ");
			}println();
			println("_____________________________");

		println("Index der Linearen Suche 1: " + result1);
		println("Index der Linearen Suche 2: " + result2);
		println("Index der Binären Suche rekusiv: " + result3);
		println("Index der Binären Suche iterativ: " + result4);
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
	
	static int[] createDNumberSequence (int length){
		int[] numberSequence = {5,10,11,13,14,20,30,32,35,40};
		return numberSequence;
	}
	
	//Return last searchNumber in array
	static int linearSearchA (int[] numberSequence, int searchNumber){
		int x = -1;
		for(int i = 0; i < numberSequence.length; i++){
			if(numberSequence[i] == searchNumber){
				x = i;
			}
		}
		return x;
	}
	
	//Return first searchNumber in array
	static int linearSearchB (int[] numberSequence, int searchNumber){
		boolean found = false; 
		int x = -1;
		for(int i=0; i < numberSequence.length && !found; i++){
			if(numberSequence[i] == searchNumber){
				found = true;
				x = i;
				return x;
			}
		}
		return x;
	}
	
	static int BinarySearchRecursive (int[] numberSequence, int searchNumber, int u, int o){

		
		  if(u>o)
			 return -1;
		  
		  int m = (u+o)/2;
		  
		 if (numberSequence[m] == searchNumber)
			 return m;	 
			
		 else if(searchNumber < numberSequence[m])
			 return BinarySearchRecursive(numberSequence, searchNumber, u, m-1);
			 
		 else //(searchNumber > numberSequence[m])
			 return BinarySearchRecursive(numberSequence, searchNumber, m+1, o);
			
	}
	
	static int BinarySearchIterative (int[] numberSequence, int searchNumber){
		 int u = 0;
		 int o = numberSequence.length-1;
		 
		 while(u<=o){
			 int m = (u+o)/2;
			 if (numberSequence[m] == searchNumber)
				 return m;
			 
			 else if(searchNumber < numberSequence[m])
				 o = m-1;
			 else
				 u = m+1;
		 } 
		
		return -1;
	}
	
}
