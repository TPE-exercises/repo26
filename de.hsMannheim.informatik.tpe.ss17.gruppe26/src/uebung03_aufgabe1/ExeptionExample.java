package uebung03_aufgabe1;

import static gdi.MakeItSimple.*;

public class ExeptionExample {

	public static void main(String[] args) {

		System.out.println("Version 2 (08/05/2017)");
		System.out.println("Erstellt von: Lange");
		System.out.println("3. Programmieraufgabe \"Exceptions - Theorie\" aus TPE im SS17");
		OwnUtils.printLines.printSeperatorLine();

		div(enterNumbers());

	}

	/**
	 * enter two int values
	 * @return array of int / length of 2
	 */
	private static int[] enterNumbers() {
		int[] numbers = new int[2];
		System.out.print("Geben Sie die erste Zahl ein: ");
		numbers[0] = readInt();
		System.out.print("Geben Sie die zweite Zahl ein: ");
		numbers[1] = readInt();
		return numbers;
	}

	/**
	 * Division of two numbers from an array
	 * Exception division by zero is catched
	 * @param numbers
	 */
	private static void div(int[] numbers) {
		int sum=-1;
		try {
			sum = numbers[0] / numbers[1];
			System.out.println(sum);
		} catch (ArithmeticException ex) {
			System.err.println("Sie dürfen um gottes Willen nicht durch NULL dividieren!");
		}
		
	}

}
