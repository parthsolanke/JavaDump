import model.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class DataStore {

    public static List<User> getUsers() {

        User u1 = new User(
                1, "Alice", "USA", LocalDate.now().minusMonths(3),
                List.of(
                        new Post(
                                101,
                                "Exploring the Grand Canyon! #travel #adventure",
                                LocalDateTime.now().minusDays(5),
                                List.of(new Like(2, nowMinusDays(4)), new Like(3, nowMinusDays(4))),
                                List.of(new Comment(2, "Amazing!", nowMinusDays(4))),
                                List.of("travel", "adventure")
                        )
                ),
                List.of(2, 3)
        );

        User u2 = new User(
                2, "Bob", "Canada", LocalDate.now().minusYears(1),
                List.of(
                        new Post(
                                102,
                                "Late night coding session #developer #java",
                                nowMinusHours(10),
                                List.of(new Like(1, nowMinusHours(9))),
                                List.of(new Comment(1, "Classic!", nowMinusHours(9))),
                                List.of("developer", "java")
                        ),
                        new Post(
                                103,
                                "Coffee is life #coffee #morning",
                                nowMinusDays(1),
                                List.of(new Like(3, nowMinusHours(20))),
                                List.of(new Comment(3, "☕️", nowMinusHours(19))),
                                List.of("coffee", "morning")
                        )
                ),
                List.of(1, 3, 4)
        );

        User u3 = new User(
                3, "Charlie", "India", LocalDate.now().minusDays(15),
                List.of(
                        new Post(
                                104,
                                "First time in NYC! #travel #citylife",
                                nowMinusDays(3),
                                List.of(new Like(2, nowMinusDays(2)), new Like(5, nowMinusDays(1))),
                                List.of(new Comment(5, "Have fun!", nowMinusDays(2))),
                                List.of("travel", "citylife")
                        )
                ),
                List.of(1, 2)
        );

        User u4 = new User(
                4, "Diana", "USA", LocalDate.now().minusWeeks(1),
                List.of(
                        new Post(
                                105,
                                "Sketching mountains #art #sketch",
                                nowMinusDays(2),
                                List.of(),
                                List.of(),
                                List.of("art", "sketch")
                        )
                ),
                List.of()
        );

        User u5 = new User(
                5, "Ethan", "India", LocalDate.now().minusMonths(2),
                List.of(
                        new Post(
                                106,
                                "Kolkata diaries #foodie #spicy",
                                nowMinusDays(4),
                                List.of(new Like(1, nowMinusDays(3))),
                                List.of(new Comment(1, "Hungry now!", nowMinusDays(3))),
                                List.of("foodie", "spicy")
                        ),
                        new Post(
                                107,
                                "Code and chai #chai #developer",
                                nowMinusHours(7),
                                List.of(new Like(3, nowMinusHours(5))),
                                List.of(new Comment(2, "Love it!", nowMinusHours(4))),
                                List.of("chai", "developer")
                        )
                ),
                List.of(2, 3, 6)
        );

        User u6 = new User(
                6, "Fiona", "Canada", LocalDate.now().minusMonths(8),
                List.of(
                        new Post(
                                108,
                                "Winter is beautiful #snow #canada",
                                nowMinusDays(10),
                                List.of(new Like(1, nowMinusDays(9))),
                                List.of(),
                                List.of("snow", "canada")
                        )
                ),
                List.of(1, 2, 3, 5)
        );

        User u7 = new User(
                7, "George", "India", LocalDate.now().minusDays(2),
                List.of(),
                List.of()
        );

        return new ArrayList<>(List.of(u1, u2, u3, u4, u5, u6, u7));
    }

    private static LocalDateTime nowMinusDays(long days) {
        return LocalDateTime.now().minusDays(days);
    }

    private static LocalDateTime nowMinusHours(long hours) {
        return LocalDateTime.now().minusHours(hours);
    }
}
