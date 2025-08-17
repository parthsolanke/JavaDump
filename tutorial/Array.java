package tutorial;

import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
        // -------------------------------
        // DECLARATION AND CREATION
        // -------------------------------
        // Declaration of array variable (no memory yet):
        int[] numbers;

        // Create (allocate memory for) an array of size 5:
        numbers = new int[5];

        // Arrays are objects in Java, stored on the heap
        // Elements of int[] default to 0
        System.out.println("Default int array: " + Arrays.toString(numbers));
        // Output: [0, 0, 0, 0, 0]


        // -------------------------------
        // INITIALIZATION
        // -------------------------------
        // Direct initialization using array literal:
        String[] fruits = {"Apple", "Banana", "Cherry"};

        // Accessing elements (zero-based index):
        System.out.println("First fruit: " + fruits[0]);  // Apple
        System.out.println("Array length: " + fruits.length); // 3


        // -------------------------------
        // MULTIDIMENSIONAL ARRAYS
        // -------------------------------
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6}
        };
        System.out.println("matrix[1][2] = " + matrix[1][2]); // 6


        // -------------------------------
        // JAVA.UTIL.ARRAYS CLASS METHODS
        // -------------------------------
        int[] data = {42, 7, 19, 73, 2};

        // Sort the array
        Arrays.sort(data);
        System.out.println("Sorted: " + Arrays.toString(data));
        // [2, 7, 19, 42, 73]

        // Fill array with a value
        int[] filled = new int[5];
        Arrays.fill(filled, 9);
        System.out.println("Filled: " + Arrays.toString(filled));
        // [9, 9, 9, 9, 9]

        // Binary search (on sorted array)
        int index = Arrays.binarySearch(data, 19);
        System.out.println("Index of 19: " + index); // 2

        // Copy array
        int[] copy = Arrays.copyOf(data, 3);
        System.out.println("Copy: " + Arrays.toString(copy));
        // [2, 7, 19]

        // Stream from array
        int sum = Arrays.stream(data).sum();
        System.out.println("Sum of array: " + sum); // 143


        // -------------------------------
        // SYSTEM.ARRAYCOPY (fast copy)
        // -------------------------------
        int[] source = {1, 2, 3, 4, 5};
        int[] destination = new int[5];
        System.arraycopy(source, 0, destination, 0, source.length);
        System.out.println("Copied with arraycopy: " + Arrays.toString(destination));
        // [1, 2, 3, 4, 5]


        // -------------------------------
        // ARRAYS VS ARRAYLIST (conceptual)
        // -------------------------------
        // Arrays:
        int[] arr = new int[3];   // fixed size, can hold primitives
        arr[0] = 100;

        // ArrayList:
        java.util.ArrayList<Integer> list = new java.util.ArrayList<>();
        list.add(100); // resizable, only objects (Integer not int)
        list.add(200);

        System.out.println("Array first element: " + arr[0]);
        System.out.println("ArrayList elements: " + list);
    }
}