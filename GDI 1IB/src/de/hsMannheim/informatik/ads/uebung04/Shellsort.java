package de.hsMannheim.informatik.ads.uebung04;

import static gdi.MakeItSimple.*;

public class Shellsort {

	static int[] gap = new int[] { 9, 7, 4, 1 };
	static int numberOfComparisons = 0;
	static int numberOfSwaps = 0;

	/**
	 * 
	 */
	public static int[] shellSort(int[] arrayToSort) {

		//the run-loop repeats the loop for every gap that is possible until the array is sorted
		for (int run = 0; run < gap.length; run++) {

			// sorts the array in the shell for the current gap with a insertion sort
			int index1 = 0;
			int index2 = index1 + gap[run];
			for (int end = 0 + gap[run]; end < arrayToSort.length; end++) {
				
				//if the index1 is bigger swap it with index2 
				numberOfComparisons++;
				if (arrayToSort[index1] > arrayToSort[index2]) { 
					numberOfSwaps++;
					int m = arrayToSort[index1];
					arrayToSort[index1] = arrayToSort[index2];
					arrayToSort[index2] = m;

					//checking if the swap currently done made a previous swap incorrect 
					//if thats true swap them and check again until the shell is sorted correctly
					boolean smaleerSwaped = true;
					int afterSwapIndex1 = index1 - gap[run];
					int afterSwapIndex2 = index1;

					while (smaleerSwaped && afterSwapIndex1 >= 0) {
						
						//if the afterSwapIndex1 is bigger swap it with afterSwapIndex2 
						numberOfComparisons++;
						if (arrayToSort[afterSwapIndex1] > arrayToSort[afterSwapIndex2]) {
							numberOfSwaps++;
							m = arrayToSort[afterSwapIndex1];
							arrayToSort[afterSwapIndex1] = arrayToSort[afterSwapIndex2];
							arrayToSort[afterSwapIndex2] = m;
							afterSwapIndex1 -= gap[run];
							afterSwapIndex2 -= gap[run];
						} 
						else { //!(arrayToSort[afterSwapIndex1] > arrayToSort[afterSwapIndex2])
							smaleerSwaped = false;
						}
					}
					
					index1++;
					index2++;

				} 
				else {// !(arrayToSort[index1] > arrayToSort[index2])
					index1++;
					index2++;
				}
			}
			
		}
		return arrayToSort;
	}
	/*
	public static void main(String[] args) {
		
		shellSort();
		println("Vergleiche: " + comparerisenCounter + ", Vertauschungen: " + swaps);
		for(int i = 0; i < arrayToSort.length;i++){
			print(arrayToSort[i] + " ");
		}
	}
	*/

}
