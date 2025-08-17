package tutorial;

import java.util.*;

public class CollectionsAndArraysDemo {
    public static void main(String[] args) {
        /*
         * -------------------------------
         * java.util.Collections
         * -------------------------------
         * - Utility class for working with Collections (List, Set, Map).
         * - Provides static helper methods.
         */

        // Sorting a List
        List<Integer> numbers = new ArrayList<>(Arrays.asList(5, 2, 8, 1, 3));
        Collections.sort(numbers);  // Natural order (ascending)
        System.out.println("Sorted List: " + numbers);

        // Sorting with Comparator (custom order)
        Collections.sort(numbers, Collections.reverseOrder());
        System.out.println("Reverse Sorted List: " + numbers);

        // Read-only collection
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        List<String> unmodifiable = Collections.unmodifiableList(names);
        // unmodifiable.add("David");  // ❌ UnsupportedOperationException
        System.out.println("Unmodifiable List: " + unmodifiable);

        // Empty collections (better than returning null!)
        List<String> emptyList = Collections.emptyList();
        Set<String> emptySet = Collections.emptySet();
        Map<String, String> emptyMap = Collections.emptyMap();
        System.out.println("Empty List: " + emptyList);

        // Synchronization wrapper (thread-safe collection)
        List<Integer> syncList = Collections.synchronizedList(new ArrayList<>());
        syncList.add(10);
        syncList.add(20);

        // Other utilities
        Collections.shuffle(numbers); // Random shuffle
        System.out.println("Shuffled Numbers: " + numbers);
        System.out.println("Max: " + Collections.max(numbers));
        System.out.println("Frequency of 2: " + Collections.frequency(numbers, 2));

        /*
         * -------------------------------
         * java.util.Arrays
         * -------------------------------
         * - Utility class for working with arrays.
         * - Provides static methods.
         */

        int[] arr = { 5, 2, 8, 1, 3 };

        // Sorting and binary search
        Arrays.sort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
        int idx = Arrays.binarySearch(arr, 3);
        System.out.println("Index of 3: " + idx);

        // Converting array to List (⚠ fixed-size view)
        List<Integer> fixedList = Arrays.asList(1, 2, 3, 4);
        System.out.println("List from Array: " + fixedList);
        // fixedList.add(5); // ❌ UnsupportedOperationException

        // Copying & filling
        int[] copy = Arrays.copyOfRange(arr, 1, 4); // index 1 to 3
        System.out.println("Copy (range 1-3): " + Arrays.toString(copy));
        int[] filled = new int[5];
        Arrays.fill(filled, 7);
        System.out.println("Filled Array: " + Arrays.toString(filled));

        // Utility methods
        int[] arr2 = { 1, 2, 3 };
        int[] arr3 = { 1, 2, 3 };
        System.out.println("Arrays.equals: " + Arrays.equals(arr2, arr3));
        System.out.println("Arrays.toString: " + Arrays.toString(arr2));
    }
}
