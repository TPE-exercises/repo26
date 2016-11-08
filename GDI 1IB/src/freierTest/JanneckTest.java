package freierTest;

import static gdi.MakeItSimple.*;


public class JanneckTest {

	
	static boolean aenderung(int[] kaenderung) {
		int i=0;
		int z=0;
		while (i< kaenderung.length){
			if(kaenderung[i] == 1){
				z+=1;
			}else if(kaenderung[i] == 0){
				
			}i++;
		}
		if(z == kaenderung.length){
			return true;
		}		
		return false;
		
	}
	
	public static void main(String[] args) {
		
	
		int x;
		int y;
		int i = 0;
		print("Kartenanzahl: ");
		int kanzahl = readInt();
		int[] kaenderung = new int[kanzahl];
		int[] karten = new int[kanzahl];
		int i1=0;
		
		while(i1<kanzahl){
			print("stelle " + (i1+1) );
			karten[i1] = readInt();
			i1++;
		}
		
		while (aenderung(kaenderung) == true){
			
			while(i<karten.length){
				if(karten[i]<karten[i+1]){
					kaenderung[i] = 1;
				}else if(karten[i]>karten[i+1]){
					x=i;
					y=i+1;
					karten[i]=y;
					karten[i+1]=x;
					kaenderung[i] = 0;
				}
				i++;
				
			}
			i=0;
		}
		int i2 = 0;;
		while( i2<karten.length){
			print(karten[i2]);
			i2++;
		}
	}}