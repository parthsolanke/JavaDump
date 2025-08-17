package tutorial;

import java.util.Arrays;

public class StringDemo {
    public static void main(String[] args) {

        // -------------------------------
        // STRING BASICS
        // -------------------------------
        String s1 = "Hello";          // String literal (goes into String Pool)
        String s2 = new String("Hi"); // Explicit object creation (NOT in pool unless interned)

        // Length and character access
        System.out.println("Length of s1: " + s1.length());       // 5
        System.out.println("Char at index 1: " + s1.charAt(1));   // e

        // Convert to arrays
        char[] chars = s1.toCharArray();
        System.out.println("toCharArray(): " + Arrays.toString(chars));
        // [H, e, l, l, o]


        // -------------------------------
        // STRING COMPARISON
        // -------------------------------
        String a = "Java";
        String b = "java";

        System.out.println("equals(): " + a.equals(b));                   // false
        System.out.println("equalsIgnoreCase(): " + a.equalsIgnoreCase(b)); // true
        System.out.println("compareTo(): " + a.compareTo("Javb"));        // negative (<0)


        // -------------------------------
        // STRING MODIFICATION (IMMUTABLE)
        // -------------------------------
        String text = "   Hello World   ";

        String trimmed = text.trim(); // removes whitespace
        String upper = text.toUpperCase();
        String replaced = text.replace('o', '0');
        String substring = text.substring(3, 8); // "Hello"

        System.out.println("Original text: [" + text + "]");
        System.out.println("Trimmed: [" + trimmed + "]");
        System.out.println("Uppercase: [" + upper + "]");
        System.out.println("Replaced: [" + replaced + "]");
        System.out.println("Substring: [" + substring + "]");


        // -------------------------------
        // STRING UTILITY METHODS
        // -------------------------------
        String csv = "red,green,blue";
        String[] colors = csv.split(","); // split into array
        System.out.println("Split: " + Arrays.toString(colors));
        // [red, green, blue]

        System.out.println("Contains 'green': " + csv.contains("green")); // true
        System.out.println("isEmpty(): " + "".isEmpty());                 // true

        String formatted = String.format("Pi is approx %.2f", 3.14159);
        System.out.println("Formatted: " + formatted);
        // Pi is approx 3.14

        // String.valueOf converts values to String
        int num = 42;
        String numStr = String.valueOf(num);
        System.out.println("valueOf(42): " + numStr); // "42"


        // -------------------------------
        // IMMUTABILITY & STRING POOL
        // -------------------------------
        String pool1 = "Hello";
        String pool2 = "Hello";
        String objStr = new String("Hello");

        System.out.println("pool1 == pool2: " + (pool1 == pool2)); // true (same pool ref)
        System.out.println("pool1 == objStr: " + (pool1 == objStr)); // false (different object)
        System.out.println("pool1.equals(objStr): " + pool1.equals(objStr)); // true (same content)


        // -------------------------------
        // MUTABLE ALTERNATIVES
        // -------------------------------
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" World");
        sb.insert(5, ",");
        sb.replace(0, 5, "Hi");
        System.out.println("StringBuilder result: " + sb.toString());
        // Hi, World

        StringBuffer sbf = new StringBuffer("Thread");
        sbf.append(" Safe");
        System.out.println("StringBuffer result: " + sbf.toString());


        // -------------------------------
        // PERFORMANCE NOTE
        // -------------------------------
        // Bad: Using + in a loop (creates many temp Strings)
        String result = "";
        for (int i = 0; i < 5; i++) {
            result += i;  // inefficient
        }
        System.out.println("Bad concat with +: " + result);

        // Good: Use StringBuilder
        StringBuilder efficient = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            efficient.append(i);
        }
        System.out.println("Good concat with StringBuilder: " + efficient);
    }
}
