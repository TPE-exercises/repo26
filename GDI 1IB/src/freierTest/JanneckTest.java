package freierTest;

import static gdi.MakeItSimple.*;

import gdi.MakeItSimple.GDIException;

public class JanneckTest {

	
	static int a1(int n){
		int sum = 0;

		if (n < 0){
			throw new GDIException("Ungültiger Parameter! Es wird eine Zahl größer/gleich 0 erwartet!");
		}
		
		if (n == 0 || n == 1) {
			return 1;
		} else {
			int[] zahlenFolge = new int[n];

			int i = 0;
			if (n >= 1)
				zahlenFolge[i] = 1;
			i++;
			if (n >= 2)
				zahlenFolge[i] = 1;
			i++;
			if (n >= 3)
				while (i < n) {
					zahlenFolge[i] = zahlenFolge[i - 2] + zahlenFolge[i - 1];
					i++;
				}

			sum = zahlenFolge[n - 1] + zahlenFolge[n - 2];
			return sum;
		}
	}

	static int a2(int n) {
		int a = 1;
		int b = 1;
		int zwischenSpeicher = 0;
		
		if (n < 0){
			throw new GDIException("Ungültiger Parameter! Es wird eine Zahl größer/gleich 0 erwartet!");
		}
		
		while (n!=0){
			n = n-1;
			zwischenSpeicher = b;
			b = a+b;
			a = zwischenSpeicher;
		}
		return a;
	}

	public static void main(String[] args) {

		println("Welchen Stelle der Fibonacci-Folge wollen sie berechnen?");
		int n = readInt();

		println("Wollen sie nach A1 oder nach A2 verfahren?");
		println("Geben sie 1 für A1 ein und 2 für A2");
		int wahl = readInt();
		int a;

		if (wahl == 1) {
			a=a1(n);
		} else if (wahl == 2) {
			a=a2(n);

		} else {
			println("Fehlerhafte eingabe");
			return;
		}
		println("Die Gesuchte Zahl ist: " + a);

	}
}