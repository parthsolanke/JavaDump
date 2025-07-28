
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReviewAnalytics {
    public static final double MAX_RATING = 5.0;

    public static void main(String[] args) {
        List<Review> reviews = Arrays.asList(
            new Review("Alice", "Bistro Cafe", "French", 4.5, "cozy, romantic, wine", LocalDateTime.of(2025, 7, 20, 19, 30)),
            new Review("Bob", "Sushi Place", "Japanese", 3.8, "fresh, bar seating", LocalDateTime.of(2025, 7, 21, 12, 15)),
            new Review("Charlie", "Taco Town", "Mexican", 5.0, "spicy, casual, quick", LocalDateTime.of(2025, 7, 19, 13, 45)),
            new Review("Diana", "Pasta Palace", "Italian", 4.2, "family-friendly, pasta, wine", LocalDateTime.of(2025, 7, 18, 18, 0)),
            new Review("Eve", "Curry Corner", "Indian", 1.0, "spicy, vegetarian, aromatic", LocalDateTime.of(2025, 7, 17, 20, 20)),
            new Review("Frank", "Burger Barn", "American", 4.0, "casual, burgers, fries", LocalDateTime.of(2025, 7, 22, 14, 10)),
            new Review("Grace", "Sushi Place", "Japanese", 4.8, "fresh, sushi, omakase", LocalDateTime.of(2025, 7, 16, 11, 30)),
            new Review("Heidi", "Green Salad", "Healthy", 4.1, "fresh, vegan, quick", LocalDateTime.of(2025, 7, 15, 13, 0)),
            new Review("Ivan", "Bistro Cafe", "French", 3.9, "brunch, cozy, coffee", LocalDateTime.of(2025, 7, 14, 10, 45)),
            new Review("Judy", "Taco Town", "Mexican", 1.0, "tacos, spicy, late-night", LocalDateTime.of(2025, 7, 13, 18, 15))
        );

        // TODO Requirement 3: Compute Average Rating per Restaurant
        System.out.println("\nAvg reviw rating: " + reviews.stream()
        .collect(Collectors.groupingBy(Review::getRestaurantName,
        Collectors.averagingDouble(Review::getRating)))
        );

        // TODO Requirement 4: Top-K Restaurants by Rating
        System.out.println("\nTop 3 restaurants: " + reviews.stream()
        .collect(Collectors.groupingBy(Review::getRestaurantName, Collectors.averagingDouble(Review::getRating)))
        .entrySet()
        .stream()
        .sorted(Comparator.comparing(Map.Entry<String, Double>::getValue).reversed())
        .limit(3)
        .map(entry -> entry.getKey())
        .toList()
        );

        // TODO Requirement 5: Sort Reviews Chronologically
        System.out.println("\nChronological sorting: " + reviews.stream()
        .sorted()
        .map(r -> {
            return r.getRestaurantName() + "|" +r.getVisitTimestamp();
        })
        .toList()
        );

        // TODO Requirement 6: Sort Restaurants by Cuisine then Name
        System.out.println("\nSorted wrt cuisine nd then name: " + reviews.stream()
        .sorted(Comparator.comparing(Review::getCuisineType)
        .thenComparing(Review::getRestaurantName))
        .map((review) -> {
            return review.getRestaurantName() + "|" + review.getCuisineType();
        })
        .distinct()
        .toList()
        );

        // TODO Requirement 7: Find All Unique Tags
        System.out.println("\nAll unique tags: " + reviews.stream()
        .flatMap(r -> r.getTagsList().stream())
        .map(tag -> tag.toLowerCase().trim())
        .collect(Collectors.toSet())
        );

        // TODO Requirement 8: Find Reviewers Who Love "Cozy"
        System.out.println("\nUsers loving cozy: " + reviews.stream()
        .filter(r -> r.getTagsList().stream().anyMatch(tag -> tag.equalsIgnoreCase("cozy")))
        .map(Review::getReviewerName)
        .toList()
        );

        // TODO Requirement 9: Cuisine-Wise Review Counts
        System.out.println("\nCusine review count: " + reviews.stream()
        .collect(Collectors.groupingBy(Review::getCuisineType,
        Collectors.counting()))
        .toString()
        );

        // TODO Requirement 10: Peak Review Hour
        System.out.println("\nMost visits occured during: " + reviews.stream()
        .collect(Collectors.groupingBy(r -> r.getVisitTimestamp().getHour(),
        Collectors.counting())).entrySet().stream()
        .sorted(Comparator.comparing(Map.Entry<Integer, Long>::getValue).reversed())
        .map(entry -> entry.getKey())
        .toList().get(0)
        );

        // TODO Requirement 11: Normalize Ratings
        System.out.println("\nNormalized ratings: " + reviews.stream()
        .map((review) -> {
            return review.getRestaurantName() + "|" + review.getRating() * 100 / MAX_RATING;
        })
        .toList()
        );


        // TODO Requirement 12: Find One-Star Reviews
        System.out.println("\nRated one star: " + reviews.stream()
        .filter(r -> r.getRating() == 1.0)
        .map((review) -> {
            return review.getRestaurantName() + "|" + review.getRating();
        })
        .toList());
    }
}