package uebung04_aufgabe3;


public class Menue_uebung04_3 {
	public static void main(String[ ]args){
		
		/*
		 * Pre add things u need
		 */
		int length = 5;
		OwnUtils.RingpufferAsArray ringpufferAsArray = new OwnUtils.RingpufferAsArray(length);
		OwnUtils.ArrayThings.printOneDimensionalArray(ringpufferAsArray.getArray());
		OwnUtils.printLines.printSeperatorLine();
		
		Thread_Put t1 = new Thread_Put();
		Thread_Get t2 = new Thread_Get();
		
		t1.start();
		t2.start();
		/*
		 * Pre add end
		 */
		
		//TODO fill witch content
		
		
	}
	
}
