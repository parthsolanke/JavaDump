package tutorial;

import java.util.*;

public class ListDemo {
    public static void main(String[] args) {

        // -------------------------------
        // LIST INTERFACE BASICS
        // -------------------------------
        // List<E> is ordered, allows duplicates, index-based
        List<String> list = new ArrayList<>(); // using ArrayList (common implementation)

        // Adding elements
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        list.add("Banana"); // duplicate allowed

        System.out.println("List contents: " + list);
        // [Apple, Banana, Cherry, Banana]

        // Access by index
        System.out.println("Element at index 1: " + list.get(1)); // Banana

        // Modify by index
        list.set(1, "Blueberry");
        System.out.println("After set(): " + list);
        // [Apple, Blueberry, Cherry, Banana]

        // Insert at index
        list.add(2, "Dragonfruit");
        System.out.println("After insert at index 2: " + list);
        // [Apple, Blueberry, Dragonfruit, Cherry, Banana]

        // Index searching
        System.out.println("First index of Banana: " + list.indexOf("Banana")); // 4
        System.out.println("Last index of Banana: " + list.lastIndexOf("Banana")); // 4

        // Sorting
        list.sort(Comparator.naturalOrder());
        System.out.println("Sorted list: " + list);
        // [Apple, Banana, Blueberry, Cherry, Dragonfruit]


        // -------------------------------
        // ARRAYLIST vs LINKEDLIST
        // -------------------------------
        List<String> arrayList = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();

        // Add some elements
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");

        linkedList.add("X");
        linkedList.add("Y");
        linkedList.add("Z");

        System.out.println("ArrayList: " + arrayList); // [A, B, C]
        System.out.println("LinkedList: " + linkedList); // [X, Y, Z]

        // Performance note:
        // - ArrayList is faster for random access (get by index)
        // - LinkedList is faster for frequent insertions/deletions in the middle
        System.out.println("ArrayList get(1): " + arrayList.get(1));   // O(1) → fast
        System.out.println("LinkedList get(1): " + linkedList.get(1)); // O(n) → slower


        // -------------------------------
        // LIST ITERATION
        // -------------------------------

        // For-each loop
        for (String fruit : list) {
            System.out.println("Fruit: " + fruit);
        }

        // Iterator (allows safe removal during iteration)
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String fruit = it.next();
            if (fruit.startsWith("B")) {
                it.remove(); // removes Blueberry and Banana
            }
        }
        System.out.println("After removing elements starting with B: " + list);
        // Remaining: [Apple, Cherry, Dragonfruit]

        // Mutable list
        List<String> mutable = new ArrayList<>();
        mutable.add("One");
        mutable.add("Two");
        System.out.println("Mutable before: " + mutable);
        mutable.add("Three");
        mutable.set(0, "First");
        System.out.println("Mutable after: " + mutable);
        // [First, Two, Three]

        // Immutable list
        List<String> immutable = List.of("A", "B", "C");
        System.out.println("Immutable: " + immutable);
        // immutable.add("D"); // 🚨 UnsupportedOperationException
    }
}
