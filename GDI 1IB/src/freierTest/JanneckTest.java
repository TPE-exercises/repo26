package freierTest;

import java.util.ArrayList;
import java.util.List;

import static gdi.MakeItSimple.*;

public class JanneckTest {
	
	private static boolean PRINT = false;
	private static boolean DEBUG = false;
	
	public static void main(String[] args) {
		
		//maxThreads = Integer.valueOf(args[0]);
		maxThreads = 8;
		
		long timeBefore = System.nanoTime();
		long time = System.nanoTime();
		
		int count = 0;
		
		int max = 100000000;
		
		numbers = new boolean[max];
		
		while(true) {
			count++;
			
			List<Integer> numbers = new ArrayList<>();
			long timeBegin = System.nanoTime();
			numbers = calcPrimes(max);
			time = System.nanoTime() - timeBegin;
			
			if(time < timeBefore) {
				timeBefore = time;
				
				System.out.println();
				System.out.println("Count: " + count);
				System.out.println("Time: " + ((double) time / 1000000d)+ " Milli-Sekunden");
			
				if(PRINT) {
					for(int i = 0; i< numbers.size(); i++) {
						System.out.print(numbers.get(i) + " ");
						if(i % 100 == 0) 
							System.out.println();
					}
				}
			}
		}
	}
	
	private static boolean[] numbers;
	private static int maxThreads;
	
	private static List<Integer> calcPrimes(int max) {		
		//true normal / marked number
		//false deleted number
		
		List<Integer> primzahlen = new ArrayList<>();
		
		for(int i = 0; i < numbers.length; i++) {
			numbers[i] = true;
		}
		
		int squareRoot = (int) Math.sqrt(max);
		
		for(int i = 2; i <= squareRoot; i++) {
			boolean boolInArray = numbers[i];
			
			if (boolInArray) {				
				deleteNumber(i);				
				primzahlen.add(i);				
				
				while(java.lang.Thread.activeCount() > maxThreads) {
					//Wait until threads are finished
					//System.out.println("Waiting");
				}
			}			
		}
		
		while(java.lang.Thread.activeCount() > 1) {
			//Wait until every thread is finished
		}
		
		for(int i = squareRoot + 1; i < numbers.length; i++) {
			if(numbers[i]) {
				primzahlen.add(i);
			}
		}
		
		return primzahlen;
	}
	
	private static void deleteNumber(final int i) {
		
		Thread background = new Thread ( new Runnable() {
			
			@Override
			public void run() {
				
				for(int j = i * 2; j < numbers.length; j += i) {
					numbers[j] = false;
				}	
			}
		});
		
		background.start();
	}

}
