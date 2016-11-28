package freierTest;
import static gdi.MakeItSimple.*;
public class Mergesort { 

    public static int[] eingabeArray = { 10, 5, 15, 3 }; 

    public static int[] sort(int untereGrenze, int obereGrenze) { 
         
        if (untereGrenze < obereGrenze) { 
            int mittelWert = (untereGrenze + obereGrenze) / 2; 
             
            sort(untereGrenze, mittelWert); 
            sort(mittelWert + 1, obereGrenze); 
            merge(untereGrenze, mittelWert, obereGrenze); 
        } 
        return eingabeArray; 
    } 

    private static void merge(int untereGrenze, int mittelWert, int obereGrenze) { 
        int[] arr = new int[eingabeArray.length]; 
        int i, j; 
        for (i = untereGrenze; i <= mittelWert; i++) { 
            arr[i] = eingabeArray[i]; 
        } 
        for (j = mittelWert + 1; j <= obereGrenze; j++) { 
            arr[obereGrenze + mittelWert + 1 - j] = eingabeArray[j]; 
        } 
        i = untereGrenze; 
        j = obereGrenze; 
        for (int k = untereGrenze; k <= obereGrenze; k++) { 
            if (arr[i] <= arr[j]) { 
                eingabeArray[k] = arr[i]; 
                i++; 
            } else { 
                eingabeArray[k] = arr[j]; 
                j--; 
            } 
        } 
    } 

    public static void main(String[] args) { 
      
        int[] array = sort(0, eingabeArray.length - 1); 
        
        for (int i = 0; i < array.length; i++) { 
            System.out.println(i + 1 + ": " + array[i]); 
        } 
    } 
}