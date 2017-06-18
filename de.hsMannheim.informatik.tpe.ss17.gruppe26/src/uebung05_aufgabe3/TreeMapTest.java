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
	// TODO kommentare auf englisch

	/**
	 * Beispiel der Verwendung
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// HashMap erstellen
		Map<String, Integer> hashMap = new HashMap<String, Integer>();

		// Manuelles Einfügen
		hashMap.put("Er", 1);
		hashMap.put("Sie", 2);
		hashMap.put("Es", 1);

		// automatisches einfügen
		String neu = "Es";
		insertInMap(hashMap, neu);

		// TreeMap erstellen
		TreeMap<Integer, Set<String>> treeMap = convertHashToTree(hashMap);

		// alles ausgeben lassen
		printHashMap(hashMap);
		printTreeInorder(treeMap);
		printTreeReversed(treeMap);
	}

	/**
	 * <li>creates a TreeMap out of a HashMap
	 * <li>erstellt aus der HashMap eine TreeMap
	 * 
	 * @param map
	 * @return
	 */
	protected static TreeMap<Integer, Set<String>> convertHashToTree(Map<String, Integer> map) {
		Set<String> keys = map.keySet();
		TreeMap<Integer, Set<String>> treeMap = new TreeMap<Integer, Set<String>>();

		for (String key : keys) {
			int value = map.get(key);
			Set<String> values;

			if (treeMap.containsKey(value)) {
				values = treeMap.get(value);
				values.add(key);
			} else {
				values = new HashSet<String>();
				values.add(key);
			}

			treeMap.put(value, values);
		}
		return treeMap;
	}

	/**
	 * <li>prints the whole HashMap
	 * <li>Gibt die gesamte HashMap aus
	 * 
	 * @param map
	 */
	protected static void printHashMap(Map<String, Integer> map) {
		// System.out.println("HashMap \n");
		Set<String> keys = map.keySet();
		for (String key : keys) {
			System.out.println(key + " | " + map.get(key));
		}
	}

	/**
	 * <li>prints the whole TreeMap, rarest word at first
	 * <li>Gibt den gesamten Baum aus, kleinster Wert zuerst
	 * 
	 * @param treeMap
	 */
	protected static void printTreeInorder(TreeMap<Integer, Set<String>> treeMap) {
		// System.out.println("\nTreeMap \n");
		Set<Integer> treeValues = treeMap.keySet();
		for (Integer integer : treeValues) {
			Set<String> values = treeMap.get(integer);
			System.out.print(integer + " |");
			for (String string : values) {
				System.out.print(" (" + string + ")");
				// TODO möglicher counter um zu zählen, wie viele Wörter bereits
				// genannt wurden.

			}
			// würde, wenn 100 ereicht, hier einen
			// break;
			// setzen
			System.out.println();
		}
	}

	/**
	 * <li>prints the whole TreeMap, most common word at first
	 * <li>Gibt den gesamten Baum aus, heufigster Wert zuerst
	 * 
	 * @param treeMap
	 */
	protected static void printTreeReversed(TreeMap<Integer, Set<String>> treeMap) {
		System.out.println("\nAndersrum");
		Set<Integer> treeValues = treeMap.keySet();
		List<Integer> reverseKeys = new LinkedList<Integer>(treeValues);
		Collections.reverse(reverseKeys);
		for (Integer integer : reverseKeys) {
			Set<String> values = treeMap.get(integer);
			System.out.print(integer + " |");
			for (String string : values) {
				System.out.print(" (" + string + ")");
				// TODO möglicher counter um zu zählen, wie viele Wörter bereits
				// genannt wurden.
			}
			// würde, wenn 100 ereicht, hier einen
			// break;
			// setzen
			System.out.println();
		}
	}

	/**
	 * <li>Adds a string to the map. If the string is already included, its
	 * value is increased. Otherwise, the entry is created.
	 * <li>Fügt einen String die die Map ein. Ist der String bereits enthalten
	 * wird sein Wert vergrößert. Andernfalls wird der Eintrag erstellt.
	 * 
	 * @param startMap
	 * @param neu
	 */
	private static void insertInMap(Map<String, Integer> startMap, String neu) {
		// erhöhe wert
		if (startMap.containsKey(neu)) {
			int value = startMap.get(neu);
			startMap.put(neu, ++value);
		}
		// füge wert neu ein
		else {
			startMap.put(neu, 1);
		}
	}
}