package Sort;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapSort_byValue {

	public MapSort_byValue()
	{
		
		sortByValue();
		
	}
	
	private static Map<String, Integer> getUnSortedMap()
    {
        Map<String, Integer> unsortMap = new HashMap<>();
        unsortMap.put("alex", 1);
        unsortMap.put("david", 2);
        unsortMap.put("elle", 3);
        unsortMap.put("charles", 4);
        unsortMap.put("brian", 5);
        
        return unsortMap;
    }
	
	 private static void sortByValue()
	 {
		 Map<String, Integer> unSortedMap = getUnSortedMap();
         
	        System.out.println("Unsorted Map : " + unSortedMap);
	 
	        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
	        unSortedMap.entrySet().stream().sorted(Map.Entry.comparingByValue())
	                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
	         
	        System.out.println("Sorted Map   : " + sortedMap);
	 }
	
	public static void main(String[] args)
	{
		MapSort_byValue ms = new MapSort_byValue();
	}
	
}
