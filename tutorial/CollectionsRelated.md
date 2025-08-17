📌 Related Concepts in Java Collections Framework

🔹 Generics (<E>, <K, V>, <?>)
- Generics add *type safety* (no accidental mixing of types, avoids ClassCastException).
- Common conventions:
  E → Element
  K → Key
  V → Value
  T → Type
- Bounded types:
  <T extends Number> → T must be a subtype of Number
- Wildcards:
    <? extends E> → "any subtype of E" (read-only access)
    <? super E>   → "any supertype of E" (write is allowed)

---------------------------------------------------------

🔹 Iteration (Traversing Collections)
- Iterator:
  hasNext(), next(), remove()
  → works for all Collection types.
- ListIterator:
  bidirectional traversal (hasPrevious(), previous())
  allows modification (set(), add(), remove()) while iterating.
- Enhanced for-loop (for-each):
  simple syntax: for (Element e : collection) { ... }
  ⚠ cannot remove/modify elements directly during iteration.

---------------------------------------------------------

🔹 Sorting
- Comparable<T> interface:
  Defines "natural ordering" for objects (compareTo()).
  Used by: Collections.sort(), Arrays.sort(), TreeSet, TreeMap.
- Comparator<T> interface:
  Defines *custom* sorting logic (compare()).
  Useful when:
  • you want multiple sorting strategies
  • you cannot modify the class itself

---------------------------------------------------------

🔹 Object Equality (equals() and hashCode())
- Critical for Set (uniqueness) and Map (key lookup).
- Contract:
  If a.equals(b) → then a.hashCode() == b.hashCode()
- Violating the contract breaks HashSet/HashMap behavior.

---------------------------------------------------------

🔹 Concurrency
- Default Collections → NOT thread-safe.
- Options:
  • Collections.synchronizedList(list) → thread-safe wrapper
  • java.util.concurrent package:
  - ConcurrentHashMap
  - CopyOnWriteArrayList
  - BlockingQueue (e.g. LinkedBlockingQueue)

---------------------------------------------------------

🔹 Immutability
- Collections.unmodifiableList(list) → read-only view.
- Collections.emptyList(), emptySet(), emptyMap() → immutable empties.
- Java 9+ factory methods:
  List.of(...), Set.of(...), Map.of(...)
  → immutable collections, no nulls allowed.

---------------------------------------------------------

🔹 Performance Considerations
- HashSet / HashMap:
  average-case O(1) for add(), remove(), contains(), get()
- TreeSet / TreeMap:
  O(log n) (internally balanced tree)
- ArrayList:
  O(1) random access, O(n) for middle insert/remove
- LinkedList:
  O(n) random access, O(1) for middle insert/remove

