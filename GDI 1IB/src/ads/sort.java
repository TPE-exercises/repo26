package ads;
import static gdi.MakeItSimple.*;
public class sort {


	
	public static void main(String[] args) {
	
		println("Wie lang ist die zu sortierende Folge?");
		int length = readInt();
		int[] numberSequence = createRandomNumberSequence(length);
		
		/*for (int i = 0; i < length; i++) {
			print(numberSequence[i] + " ");
		}println();*/
		
		int[] newNumberSequence = new int[length];
		int choise = 0;
		
		println("Mit welcher Methode soll sortiert werden?");
		choise = readInt();
				
		if (choise == 1){
			newNumberSequence = InsertionSort1(numberSequence);
		}
		else if(choise == 2){
			newNumberSequence = InsertionSort2(numberSequence);
		}
		else if (choise == 3){
			newNumberSequence = ShakerSort (numberSequence);
		}
		else 
			println("Falsche eingabe");

		int i = 0;
		print(newNumberSequence[i]);
		for (i = 1; i < length; i++) {
			print(", " + newNumberSequence[i]);
		}
	}
	
	//Create own array
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
	
	//Create random array
	static int[] createRandomNumberSequence (int length){
		int[] numberSequence = new int[length];
		
		for(int i = 0; i < length; i++){
			int random = (int) Math.floor(Math.random()*99);
			numberSequence[i] = random;
		}
		return numberSequence;

	}
	
	
	static int[] InsertionSort1  (int[] numberSequence){
		
		// Kopie
		for (int i = 1; i < numberSequence.length; i++) {  
			int j = i;     
			int m = numberSequence[i]; //Marker-Feld
	 
			while (j > 0 && numberSequence [j-1] > m) {       
			     //Verschiebe alle größeren Elemente nach hinten  
				numberSequence [j] = numberSequence [j-1];       
				j--;     
			}   
			//Setze m auf das freie Feld
			numberSequence[j] = m;   
		} 
		
		//Kopie Ende
		
		return numberSequence;
	}
	static int[] InsertionSort2  (int[] numberSequence){
		for (int i = 1; i < numberSequence.length; i++) {  
			
			int m = numberSequence[i];
			int j = BinarySearchRecursive(numberSequence, m, 0, i-1);
			
			
			for(int x = i; j != x; x--){	
				numberSequence[x] = numberSequence[x-1];
			}
			numberSequence[i] = m;
			
		}
		return numberSequence;
	}
	
	//BinarySearch for InsertionSort2
	static int BinarySearchRecursive (int[] numberSequence, int searchNumber, int u, int o){
		  
		 int m = (u+o)/2;
		  
		 if (u==o)
			 return m;	 
			
		 else if(searchNumber < numberSequence[m])
			 return BinarySearchRecursive(numberSequence, searchNumber, u, m-1);
			 
		 else //(searchNumber > numberSequence[m])
			 return BinarySearchRecursive(numberSequence, searchNumber, m+1, o);
			
	}
	
	
	
	
	
	
	static int[] SelectionSort  (int[] numberSequence){
		int[] newNumberSequence = new int[numberSequence.length];
		
		
		return newNumberSequence;
	}
	static int[] ShakerSort (int[] numberSequence){
		int[] newNumberSequence = new int[numberSequence.length];
		
		
		return newNumberSequence;
	}	

	
}
