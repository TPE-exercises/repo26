package freierTest;
import static gdi.MakeItSimple.*;

public class JanneckTest04 {

	private int[] digits;
	
	JanneckTest04(String number){//BigInt = JanneckTest04
		
		
		for( int i=0; i<number.length();i++){
			if(number.charAt(i)<'0' || number.charAt(i)>'9'){
				throw new GDIException("  ");
			}	
		}
		if (number.equals("")){
			throw new GDIException(" ");
		}
		digits = new int[number.length()];
		for(int i = 0; i<number.length();i++){
			int currentDigit = number.charAt(i)-'0'; //Ziehe 0 ab ergebnis ist eine Zahl
			digits[i] = currentDigit;
			
		}

	}
	
	int length(){
		
		return digits.length;
	}
	print(BigInt.length());
	
	public String toString(){
		String res=
		for(int i = 0; i<digits.length; i++)
			res+=digits[i];
		return res;
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		
		
		//Linke Tafelseite
		JanneckTest04 zahl =
		new JanneckTest04("123");
		
		assertEquals("123", zahl.toString());
		
		assertEquals(3, zahl.length());
		
		int[] digits = zahl.getDigits();
		assertEquals (3, digits.length);
		assertEquals (1, digits[0]);
		assertEquals (2, digits[1]);
		assertEquals (3, digits[2]);
		
		
		

	}

}
