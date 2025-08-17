package tutorial;

import java.util.*;

public class SetDemo {
    public static void main(String[] args) {
        /*
         * Set Interface
         * - A collection that does NOT allow duplicate elements.
         * - If you try to add a duplicate, add() returns false.
         * - Generic: Set<E>.
         */

        // --------------------------
        // 1. HashSet
        // --------------------------
        // - Backed by a hash table.
        // - Provides O(1) average time for add, remove, contains.
        // - DOES NOT guarantee order of elements.
        Set<String> hashSet = new HashSet<>();
        hashSet.add("Apple");
        hashSet.add("Banana");
        hashSet.add("Orange");
        hashSet.add("Apple"); // duplicate, ignored
        System.out.println("HashSet (unordered, no duplicates): " + hashSet);

        // --------------------------
        // 2. TreeSet
        // --------------------------
        // - Backed by a Red-Black tree (self-balancing BST).
        // - Stores elements in SORTED order (natural or custom comparator).
        // - Slower than HashSet because of sorting (O(log n)).
        Set<String> treeSet = new TreeSet<>(hashSet); // copy elements from hashSet
        System.out.println("TreeSet (sorted): " + treeSet);

        // Example with integers
        Set<Integer> numbers = new TreeSet<>();
        numbers.add(42);
        numbers.add(7);
        numbers.add(15);
        System.out.println("TreeSet of numbers (sorted): " + numbers);

        // --------------------------
        // 3. EnumSet
        // --------------------------
        // - Specialized high-performance Set for enum types.
        // - Very efficient, internally uses bit vectors.
        enum Day { MON, TUE, WED, THU, FRI, SAT, SUN }
        EnumSet<Day> weekend = EnumSet.of(Day.SAT, Day.SUN);
        System.out.println("EnumSet (weekend days): " + weekend);

        // --------------------------
        // Sub-interfaces
        // --------------------------
        // SortedSet: guarantees ascending order.
        // NavigableSet: adds navigation methods (like floor(), ceiling()).
        NavigableSet<Integer> navSet = new TreeSet<>();
        navSet.addAll(Arrays.asList(10, 20, 30, 40, 50));
        System.out.println("NavigableSet: " + navSet);
        System.out.println("floor(25): " + navSet.floor(25));   // greatest <= 25
        System.out.println("ceiling(25): " + navSet.ceiling(25)); // smallest >= 25
    }
}
