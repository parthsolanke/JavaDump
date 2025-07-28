import core.*;

import java.util.*;
import java.util.stream.Collectors;

public class EventManager {
    public static void main(String[] args) throws Exception {
        List<Participant> participants = new ArrayList<>(Arrays.asList(
            new Participant("parth", "cs", Arrays.asList(80, 90, 70)),
            new Participant("jhon", "it", Arrays.asList(30, 80, 100)),
            new Participant("bob", "aiml", Arrays.asList(50, 60, 70))
        ));

        // 2.
        participants.sort(null);
        System.out.println(participants.toString());

        // 3.
        participants.sort(
            Comparator.comparing(Participant::getDepartment)
            .thenComparing(Participant::getId)
        );
        System.out.println(participants.toString());

        //4. 
        int top = 2;
        List<String> topNParticipants = participants.stream()
                .sorted()
                .limit(top)
                .map(Participant::getName)
                .collect(Collectors.toList());
        System.out.println(topNParticipants);

        // 5.
        Map<String, Double> deptAvgScores = participants.stream()
                .collect(
                        Collectors.groupingBy(
                                Participant::getDepartment,
                                Collectors.averagingDouble(
                                        p -> p.getScores().stream()
                                                .mapToInt(Integer::intValue)
                                                .average()
                                                .orElse(0)
                                )
                        )
                );
        System.out.println(deptAvgScores.toString());

        // 6.
        List<Integer> allScores = participants.stream()
                .flatMap(p -> p.getScores().stream())
                .toList();

        int maxScore = allScores.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);

        List<Integer> normalizedScores = allScores.stream()
                .map(score -> score * 100 / maxScore)
                .collect(Collectors.toList());

        // 7.
        System.out.println(participants.stream()
                .map(Participant::getName)
                .distinct()
                .sorted()
                .collect(Collectors.toList())
                .toString());

        // 8.
        Map<String, List<String>> deptMap = participants.stream()
                .collect(Collectors.groupingBy(
                        Participant::getDepartment,
                        Collectors.mapping(Participant::getName, Collectors.toList())));
        System.out.println(deptMap.toString());

        // 9.
        System.out.printf(participants.stream()
                .filter(p -> p.getScores().stream().allMatch(s -> s >= 40))
                .map(Participant::getName)
                .collect(Collectors.toList())
                .toString());

        // 10.
        System.out.println(participants.stream()
                .filter(p -> p.getScores().stream().anyMatch(s -> s == 100))
                .map(Participant::getName)
                .collect(Collectors.toList()));

        // 11.
        System.out.println(participants.stream()
                .filter(p -> p.getScores().stream().anyMatch(s -> s < 40))
                .collect(Collectors.groupingBy(
                        Participant::getDepartment,
                        Collectors.counting()
                )).toString());

    }
}