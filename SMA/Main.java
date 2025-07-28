import model.*;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        List<User> users = DataStore.getUsers();

        // Section 1.
        // 1.
        List<String> unqCoutries = users.stream()
                .map(User::getCountry)
                .distinct()
                .toList();
        System.out.println("\nUnique countries: " + unqCoutries);

        // 2.
        double avgFollowerCount = users.stream()
                .map(user -> user.getFollowers().size())
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
        System.out.println("\nAverage Followers count: " + avgFollowerCount);

        // 3.
        List<User> top5MostFollowedUsers = users.stream()
                .sorted(Comparator.comparingInt((User user) -> user.getFollowers().size())
                        .reversed())
                .limit(5)
                .toList();
        System.out.println("\nTop most Followed users: " + top5MostFollowedUsers);

        // 4.
        List<User> usersWithNoFollowers = users.stream()
                .filter(user -> user.getFollowers().isEmpty())
                .toList();
        System.out.println("\nUsers with no followers: " + usersWithNoFollowers);

        // 5.
        Map<String, Long> userCountryMap = users.stream()
                .collect(Collectors.groupingBy(
                        User::getCountry,
                        Collectors.counting()
                ));
        System.out.println("\n Country -> num users: " + userCountryMap);

        // 6.
        List<User> usersJoinedINLast6Mo = users.stream()
                .filter(user -> user.getJoinedDate().isAfter(LocalDate.now().minusMonths(6)))
                .toList();
        System.out.println("\nUsers joined in last 6 mo: " + usersJoinedINLast6Mo);

        // Section 2.
        // 7.
        List<String> allHashTags = users.stream()
                .flatMap(user -> user.getPosts().stream())
                .flatMap(post -> post.getHashtags().stream())
                .distinct()
                .sorted()
                .toList();
        System.out.println("\nAll unique hashtags: " + allHashTags);

        // 8.
        List<String> top10Hashtags = users.stream()
                .flatMap(user -> user.getPosts().stream())
                .flatMap(post -> post.getHashtags().stream())
                .collect(Collectors.groupingBy(
                        tag -> tag,
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(10)
                .map(Map.Entry::getKey)
                .toList();
        System.out.println("\nTop 10 used hashtags: " + top10Hashtags);

        // 9.
        Map<String, Long> hashtagFreqCount = users.stream()
                .flatMap(user -> user.getPosts().stream())
                .flatMap(post -> post.getHashtags().stream())
                .collect(Collectors.groupingBy(
                        tag -> tag,
                        Collectors.counting()
                ));
        System.out.println("\nHastags frequeny count: " + hashtagFreqCount);

        // 10.
        Map<String, Optional<String>> countryToMostUsedtags = users.stream()
                .collect(Collectors.groupingBy(
                        User::getCountry,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                lst -> {
                                    return lst.stream()
                                            .flatMap(user -> user.getPosts().stream())
                                            .flatMap(post -> post.getHashtags().stream())
                                            .collect(Collectors.groupingBy(
                                                    tag -> tag,
                                                    Collectors.counting()
                                            ))
                                            .entrySet()
                                            .stream()
                                            .max(Map.Entry.comparingByValue())
                                            .map(Map.Entry::getKey);
                                }
                        )
                ));
        System.out.println("\nCountry to tags mapping: " + countryToMostUsedtags);

        // 11.
        Post longestPost = users.stream()
                .flatMap(user -> user.getPosts().stream())
                .max(Comparator.comparingInt(post -> post.getContent().length()))
                .orElse(null);
        System.out.println("\nLongest post by content length: " + longestPost);

        // 12.
        List<User> usersWithNoPost = users.stream()
                .filter(user -> user.getPosts().isEmpty())
                .toList();
        System.out.println("\nUsers with no posts: " + usersWithNoPost);

        // Section 3.
        // 13.
        double avgLikesPerPost = users.stream()
                .flatMap(user -> user.getPosts().stream())
                .mapToDouble(post -> post.getLikes().size())
                .average()
                .orElse(0.0);
        System.out.println("\nAvg Likes per post: " + avgLikesPerPost);

        // 14.
        Optional<Post> postWithMostComments = users.stream()
                .flatMap(user -> user.getPosts().stream())
                .max(Comparator.comparingInt(post -> post.getComments().size()));
        System.out.println("\nPost with most Comments: " + postWithMostComments);

        // 15.



    }
}
