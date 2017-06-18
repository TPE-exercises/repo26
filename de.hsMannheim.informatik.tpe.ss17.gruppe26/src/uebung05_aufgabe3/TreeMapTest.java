package uebung05_aufgabe3;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapTest {
	
	

    public static void main(String[] args) {

        Map<String, Integer> startMap = new HashMap<String, Integer>();

        startMap.put("Er", 1);
        startMap.put("Sie", 2);
        startMap.put("Es", 1);

        
        String neu = "Es";
        insertInMap(startMap, neu);

        
        printMap(startMap);

        /*
         * Da hier "Es" & "Sie" den gleichen Wert haben kann man nicht einfach
         * die TreeMap erstellen wie Nille schon sagt
         */
        Set<String> keys = startMap.keySet();
        TreeMap<Integer, Set<String>> treeMap = new TreeMap<Integer, Set<String>>();
        for (String key : keys) {
            int value = startMap.get(key);
            Set<String> values;
            if(treeMap.containsKey(value)){
                values = treeMap.get(value);
                values.add(key);
            } else {
                values = new HashSet<String>();
                values.add(key);
            }
            
            treeMap.put(value, values);
        }
        
        
        
        System.out.println("\nTreeMap \n");
        Set<Integer> treeValues = treeMap.keySet();
        for (Integer integer : treeValues) {
            Set<String> values = treeMap.get(integer);
            System.out.print(integer + " |");
            for (String string : values) {
                System.out.print(" " + string);
            }
            System.out.println();
        }
        
        /* Und groesster Wert zuerst*/
        System.out.println("\nAndersrum");
        List<Integer> reverseKeys = new LinkedList<Integer>(treeValues);
        Collections.reverse(reverseKeys);
        for (Integer integer : reverseKeys) {
            Set<String> values = treeMap.get(integer);
            System.out.print(integer + " |");
            for (String string : values) {
                System.out.print(" " + string);
            }
            System.out.println();
        }

    }
    protected static void printMap(Map<String, Integer> map){
    	System.out.println("HashMap \n");
        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println(key + " | " + map.get(key));
        }
    }
    protected static void printTree(Map<String, Integer> map){
    	
    }

    private static void insertInMap(Map<String, Integer> startMap, String neu) {
        if (startMap.containsKey(neu)) {
            int value = startMap.get(neu);
            startMap.put(neu, ++value);
        }else{
        	startMap.put(neu, 1);
        }
    }
}