package freierTest;

import static gdi.MakeItSimple.*;

public class BenTest02 {

	public static void main(String[] args) {
		int x = 200, y = 4712;
		println( max( 3, 5/2 ) );
		int max = max( 2+3, 4 );
		println( max( x, y ) );

	}

	static int max( int a, int b ) {
		if ( a > b )
		return a;
		else
		return b;
		}
}
