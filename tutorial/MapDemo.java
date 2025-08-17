package tutorial;

import java.util.*;

public class MapDemo {
    public static void main(String[] args) {
        /*
         * Map Interface
         * - Stores key/value pairs (associations).
         * - Keys are unique, values can be duplicated.
         * - Generic: Map<K, V>
         * - Primary operations:
         *     put(K key, V value) → adds/updates a pair
         *     get(Object key) → retrieves value for key
         * - Not directly Iterable, but provides "views":
         *     keySet(), values(), entrySet()
         */

        // --------------------------
        // 1. HashMap
        // --------------------------
        // - Backed by hash table.
        // - O(1) average time for get(), put().
        // - Does NOT guarantee ordering.
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "Apple");
        hashMap.put(2, "Banana");
        hashMap.put(3, "Orange");
        hashMap.put(2, "Mango"); // key=2 overwritten
        System.out.println("HashMap: " + hashMap);

        // Access value by key
        System.out.println("Value for key=2: " + hashMap.get(2));

        // Iterating via entrySet() (key + value)
        for (Map.Entry<Integer, String> entry : hashMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " → Value: " + entry.getValue());
        }

        // --------------------------
        // 2. TreeMap
        // --------------------------
        // - Backed by Red-Black tree.
        // - Stores keys in ascending (natural) order or by Comparator.
        // - O(log n) for get(), put().
        Map<Integer, String> treeMap = new TreeMap<>(hashMap);
        System.out.println("TreeMap (sorted by keys): " + treeMap);

        // --------------------------
        // 3. LinkedHashMap
        // --------------------------
        // - Extends HashMap.
        // - Maintains insertion order (or access order if configured).
        Map<Integer, String> linkedMap = new LinkedHashMap<>();
        linkedMap.put(10, "Dog");
        linkedMap.put(20, "Cat");
        linkedMap.put(30, "Parrot");
        System.out.println("LinkedHashMap (insertion order): " + linkedMap);

        // --------------------------
        // 4. EnumMap
        // --------------------------
        // - Highly efficient Map for enum keys.
        enum Day { MON, TUE, WED, THU, FRI }
        Map<Day, String> enumMap = new EnumMap<>(Day.class);
        enumMap.put(Day.MON, "Start of week");
        enumMap.put(Day.FRI, "Almost weekend");
        System.out.println("EnumMap: " + enumMap);

        // --------------------------
        // Sub-interfaces
        // --------------------------
        // SortedMap: keys in ascending order
        // NavigableMap: adds methods like floorKey(), ceilingKey()
        NavigableMap<Integer, String> navMap = new TreeMap<>();
        navMap.put(100, "A");
        navMap.put(200, "B");
        navMap.put(300, "C");
        System.out.println("NavigableMap: " + navMap);
        System.out.println("floorKey(250): " + navMap.floorKey(250));   // <= 250
        System.out.println("ceilingKey(250): " + navMap.ceilingKey(250)); // >= 250
    }
}
