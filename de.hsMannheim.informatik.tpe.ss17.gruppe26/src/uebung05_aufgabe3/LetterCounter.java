package uebung05_aufgabe3;

import java.io.*;

public class LetterCounter {

	private static final char[] LOWER_LETTERS_WITH_UMLAUTS = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','ä','ö','ü','ß'};

	private static final String[] TEST_FILE_PATHS = {
			"Bravo30Test30",
			"Test100"
	};

	private static final String[] FILE_PATHS = {
			"Die_Bibel",
			"William_Shakespear"
	};

	private static boolean isValidLetter(char letter){
		for(int i = 0; i < LOWER_LETTERS_WITH_UMLAUTS.length; i++){
			if(letter == LOWER_LETTERS_WITH_UMLAUTS[i]){
				return true;
			}
		}
		return false;
	}

	private static String[] addNewWord(String[] words, String wordToAdd){
		if(wordToAdd != null){
			String[] tmp;
			if(words == null || words.length == 0){
				tmp = new String[1];
			}
			else{
				tmp = new String[words.length + 1];
				for(int i = 0; i < words.length; i++){
					tmp[i] = words[i];
				}
			}
			tmp[tmp.length - 1] = wordToAdd;
			words = tmp;
		}
		return words;
	}

	private static String[] getWordsInLine(String line){
		String[] words = null;
		String lowerCaseWord = line.toLowerCase();

		String word = "";
		for(int i = 0; i < lowerCaseWord.length(); i++){
			if(isValidLetter(lowerCaseWord.charAt(i))){
				word = word + lowerCaseWord.charAt(i);
			}
			else{
				words = addNewWord(words, word);
				word = "";
			}
		}
		return words;
	}

	public static void main(String[] args){
		BufferedReader f;
		String line;

		try{
			f = new BufferedReader(new FileReader(TEST_FILE_PATHS[0]));
			while((line = f.readLine()) != null){
				//Teste Einlesen der Zeile und speichern der Worte in einem String Array
				String[] newWords = getWordsInLine(line);
				for(int i = 0; i < newWords.length; i++){
					System.out.print(newWords[i] + " ");
				}
			}
			f.close();
		}catch( IOException e){
			System.out.println("Fehler beim Lesen der Datei.");
		}
	}
}
