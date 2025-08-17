package tutorial;

import java.util.*;

public class CollectionsGotchas {
    public static void main(String[] args) {
        /*
         * -----------------------------------
         * Iteration and Modification
         * -----------------------------------
         */

        List<String> names = new ArrayList<>(Arrays.asList("Alice", "Bob", "Charlie"));

        // ✅ Enhanced for-loop works for arrays & Iterables
        for (String n : names) {
            System.out.println(n);
            // n = "X"; // allowed, but does NOT change the list
            // names.remove(n); // ❌ ConcurrentModificationException
        }

        // ✅ Correct way to remove elements while iterating
        Iterator<String> it = names.iterator();
        while (it.hasNext()) {
            if (it.next().equals("Bob")) {
                it.remove(); // safe removal
            }
        }
        System.out.println("After removing Bob: " + names);

        // ✅ For replacing elements or moving both directions
        ListIterator<String> listIt = names.listIterator();
        while (listIt.hasNext()) {
            String val = listIt.next();
            if (val.equals("Charlie")) {
                listIt.set("Chuck"); // replace current element
            }
        }
        System.out.println("After replacement: " + names);

        /*
         * -----------------------------------
         * Use Interfaces, Not Implementations
         * -----------------------------------
         */

        // ✅ Good practice (program to the interface)
        List<Integer> list = new ArrayList<>();
        list.add(10);

        // ❌ Avoid tying code to concrete class
        // ArrayList<Integer> list2 = new ArrayList<>();

        // Later you can switch to a LinkedList without changing other logic:
        List<Integer> linked = new LinkedList<>();

        /*
         * -----------------------------------
         * Map is Not a Collection
         * -----------------------------------
         */
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Alice", 90);
        scores.put("Bob", 85);

        // Map provides views to iterate:
        System.out.println("Keys: " + scores.keySet());      // Set of keys
        System.out.println("Values: " + scores.values());    // Collection of values
        System.out.println("Entries: " + scores.entrySet()); // Set of key-value pairs

        /*
         * -----------------------------------
         * Immutability and Unmodifiability
         * -----------------------------------
         */

        // Java 9+ immutable collections
        List<String> immList = List.of("A", "B", "C");
        // immList.add("D"); // ❌ UnsupportedOperationException
        // immList.set(0, "X"); // ❌ UnsupportedOperationException

        // Cannot contain null
        // List<String> bad = List.of("A", null); // ❌ NullPointerException

        /*
         * -----------------------------------
         * Primitive Types and Wrapper Classes
         * -----------------------------------
         */

        // Collections only work with objects, not primitives
        List<Integer> nums = new ArrayList<>();
        nums.add(10);  // int auto-boxed to Integer
        nums.add(20);
        int sum = nums.get(0) + nums.get(1); // unboxed back to int
        System.out.println("Sum: " + sum);
    }
}
