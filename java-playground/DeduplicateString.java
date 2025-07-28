import java.util.HashSet;
import java.util.Set;

public class DeduplicateString {
    public static String removeConsecutiveDuplicate(String input) {
        if (input == null || input.length() == 1) {
            return input;
        }

        StringBuilder result = new StringBuilder();
        char prevChar = input.charAt(0);
        result.append(prevChar);

        for (int i = 1; i < input.length(); i++) {
            char currChar = input.charAt(i);
            if (currChar != prevChar) {
                result.append(currChar);
                prevChar = currChar;
            }
        }

        return result.toString();
    }

    public static String removeDuplicate(String input) {
        Set<Character> seen = new HashSet<>();
        StringBuilder result = new StringBuilder();

        for (char ch: input.toCharArray()) {
            if (!seen.contains(ch)) {
                seen.add(ch);
                result.append(ch);
            }
        }

        return result.toString();
    }
    
    public static void main(String[] args) {
        String input = "programming";
        String o1 = removeDuplicate(input);
        String o2 = removeConsecutiveDuplicate(input);

        System.out.println("Deduplicated String: " + o1);
        System.out.println("Consecutive Deduplicated String: " + o2);
    }
}