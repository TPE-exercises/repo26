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
			newNumberSequence = InsertionSort(numberSequence);
		}
		else if(choise == 2){
			newNumberSequence = SelectionSort(numberSequence);
		}
		else if (choise == 3){
			newNumberSequence = ShakerSort (numberSequence);
		}
		else 
			println("Falsche eingabe");

		int i = 0;
		print(newNumberSequence[i]);
		for (i = 1; i <= length; i++) {
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
	
	
	static int[] InsertionSort  (int[] numberSequence){
		int[] newNumberSequence = new int[numberSequence.length];
		
		
		return newNumberSequence;
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
