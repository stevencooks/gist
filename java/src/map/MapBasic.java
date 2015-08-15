/**
 * File: map/MapBasic.java
 * ------------------------------------------------
 * V        put(K key, V value)
 * V        remove(Object key)
 * boolean  containsKey(Object key)
 * boolean  containsValue(Object value)
 * V        get(Object key)
 * 
 * boolean  isEmpty()
 * int      size()
 * 
 * Set<Map.Entry<K, V>> entrySet()
 * Set<K>               keySet()
 * Collection<V>        values
 * ------------------------------------------------
 * @author Steven Cooks
 */
package map;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapBasic {
    
    public static void main(String[] args) {
        new MapBasic().run();
        
    }
    
    private void run() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Tom", 1);
        map.put("Steve", 2);
        map.put("Jack", 3);
        loopOverMapEntry(map);
        
        loopOverKeys(map);
        
        // map.values()
        loopOverValues(map);
    }

    // loop over entries in map
    public void loopOverMapEntry(Map<String, Integer> map) {
        for(Entry<String, Integer> entry : map.entrySet()) {
            String str = entry.getKey() + "=" + entry.getValue(); 
            System.out.println(str);
        }
    }
    
    public void loopOverKeys(Map<String, Integer> map) {
        for (String str : map.keySet()) {
            System.out.println(str);
        }
    }
    
    public void loopOverValues(Map<String, Integer> map) {
        for (int num : map.values()) {
            System.out.println(num);
        }
    }

}
