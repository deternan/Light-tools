package Sort;

/*
 * 
 * version: May 03, 2019 04:00 PM
 * Last revision: May 03, 2019 04:50 PM
 * 
 * Author : Chao-Hsuan Ke
 * Institute: Delta Research Center
 * Company : Delta Electronics Inc. (Taiwan)
 * 
 */

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapSort_byValue {

	public MapSort_byValue() {
		
		//sortByValue();
		
		reverseSortedMap();
	}

	private static Map<String, Integer> getUnSortedMap() {
		Map<String, Integer> unsortMap = new HashMap<>();
		unsortMap.put("alex", 1);
		unsortMap.put("david", 2);
		unsortMap.put("elle", 3);
		unsortMap.put("charles", 4);
		unsortMap.put("brian", 5);

		return unsortMap;
	}

	private static void sortByValue() {
		Map<String, Integer> unSortedMap = getUnSortedMap();
//		System.out.println("Unsorted Map : " + unSortedMap);

		LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
		unSortedMap.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));

		System.out.println("Sorted Map   : " + sortedMap);

		for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}

	}

	private void reverseSortedMap() {
		Map<String, Integer> unSortedMap = getUnSortedMap();
		
		LinkedHashMap<String, Integer> reverseSortedMap = new LinkedHashMap<>();
        unSortedMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));
         
        System.out.println("Reverse Sorted Map   : " + reverseSortedMap);
	
        for (Map.Entry<String, Integer> entry : reverseSortedMap.entrySet()) {
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}
        
	}

	public static void main(String[] args) {
		MapSort_byValue ms = new MapSort_byValue();
	}

}
