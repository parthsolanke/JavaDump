
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        // Use these methods to access data:
        System.out.println("Sample Students: " + DataStore.getStudents());
        System.out.println("Sample People: " + DataStore.getPeople());
        System.out.println("Sample Employees: " + DataStore.getEmployees());
        System.out.println("Sample Tasks: " + DataStore.getTasks());
        System.out.println("Sample Temperatures: " + DataStore.getTemperatureReadings());


        // 1.
        double avgSensor = DataStore.getTemperatureReadings().stream()
        .mapToDouble(Double::doubleValue)
        .average()
        .orElse(0.0);
        System.out.println("\nSensor Average: " + avgSensor);

        // 2.
        List<Integer> prices = Arrays.asList(100, 250, 475);
        List<Double> dollarPrices = prices.stream()
        .map(p -> p / 100.0)
        .collect(Collectors.toList());
        System.out.println("\nCents to dollors: " + dollarPrices);

        // 3.
        List<Integer> nums = Arrays.asList(1, -3, 0, -2, 4);
        long ct = nums.stream()
        .filter(n -> n < 0)
        .count();
        System.out.println("Num -ve values: " + ct);

        // 4.
        List<String> filteredWords = DataStore.getWords().stream()
        .filter(w -> w.length() > 5)
        .collect(Collectors.toList());
        System.out.println("\nFiltered Words: " + filteredWords);

        // 5.
        int counter = Arrays.asList("hi", "hello", "world").stream()
        .mapToInt(String::length)
        .sum();
        System.out.println("\nTotal chars: " + counter);

        // 6.
        List<String> freqWords = DataStore.getDuplicateWords().stream()
        .collect(Collectors.groupingBy(
            w -> w,
            Collectors.counting()
        ))
        .entrySet()
        .stream()
        .sorted(Comparator.comparing(Map.Entry<String, Long>::getValue)
        .reversed())
        .limit(3)
        .map(entry -> entry.getKey())
        .collect(Collectors.toList());
        System.out.println("\nFrequent words: " + freqWords);

        // 7.
        List<Integer> flatLst = DataStore.getNestedNumbers().stream()
        .flatMap(l -> l.stream())
        .collect(Collectors.toList());

        IntSummaryStatistics flatStats = flatLst.stream()
        .mapToInt(Integer::intValue)
        .summaryStatistics();

        List<Integer> rangeCheckLst = flatLst.stream()
        .filter(num -> num < flatStats.getMax() && num > flatStats.getMin())
        .collect(Collectors.toList());
        System.out.println("\nMatching numbers: " + rangeCheckLst);

        // 8.
        Map<Character, List<String>> charToWordsMap = DataStore.getWords().stream()
        .collect(Collectors.groupingBy(
            word -> word.charAt(0),
            Collectors.mapping(word -> word, Collectors.toList())
        ));
        System.out.println("\nChar to word list: " + charToWordsMap);

        // 9.
        List<String> domainNames = DataStore.getEmails().stream()
        .map(name -> name.split("@")[1])
        .collect(Collectors.toList());
        System.out.println("\nDomain names: " + domainNames);

        // 10.
        List<String> input = Arrays.asList("apple", null, "banana", "pear", null);

        List<String> sortedWords = input.stream()
            .sorted(Comparator.nullsLast(Comparator.reverseOrder()))
            .collect(Collectors.toList());

        System.out.println("\nSorted (reverse, nulls last): " + sortedWords);



    }
}
