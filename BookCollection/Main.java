import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Book> books = BookData.getSampleBooks();

        // LEVEL: 1
        // 1.
        List<String> authors = books.stream()
                .map(Book::getAuthor)
                .distinct()
                .sorted()
                .toList();

        System.out.println("\nUnique Authors (Alphabetically): " + authors.toString());

        // 2.
        System.out.println("\nTitles longer than 15 characters: " + books.stream()
                .map(Book::getTitle)
                .filter(title -> title.length() > 15)
                .toList());

        // 3.
        System.out.println("\nBooks more than 300 pages: " + books.stream()
                .filter(b -> b.getPages() > 300)
                .map(Book::toString)
                .toList());

        // 4.
        System.out.println("\nAvg number of pages: " + books.stream()
                .mapToInt(Book::getPages)
                .average()
                .orElse(0));

        // 5.
        System.out.println("\nBooks having more avg rating than 4.0: " + books.stream()
                .filter(b -> b.getRatings()
                        .stream()
                        .mapToInt(Integer::intValue)
                        .average()
                        .orElse(0.0) > 4.0)
                .toList());

        // 6.
        System.out.println("\nAll genres: " + books.stream()
                .map(Book::getGenre)
                .distinct()
                .toList());

        // 7.
        System.out.println("\nTotal books: " + (long) books.size());

        // 8.
        System.out.println("\nUppercase book titles: " + books.stream()
                .map(book -> book.getTitle().toUpperCase())
                .toList());

        // 9.
        System.out.println("\nAll ratings: " + books.stream()
                .flatMap(book -> book.getRatings().stream())
                .toList());

        // 10.
        System.out.println("\nMax rating: " + books.stream().flatMap(book -> book.getRatings().stream())
                .mapToInt(Integer::intValue).max().orElse(0));
        System.out.println("\nMax rated book: " + books.stream()
                .sorted(Comparator.comparingDouble(book -> book.getRatings().stream().mapToInt(Integer::intValue).average().orElse(0)))
                .limit(1)
                .toList()
                .toString());

        // LEVEL 2:
        // 11.
        System.out.println("\nGenre count: " + books.stream().
                collect(Collectors.groupingBy(Book::getGenre,
                        Collectors.counting())));

        // 12.
        System.out.println("\nAvg pages per genre: " + books.stream()
                .collect(Collectors.groupingBy(Book::getGenre,
                        Collectors.averagingDouble(Book::getPages))));

        // 13.
        System.out.println("\nHighest rated book in each genre: " + books.stream()
                .collect(Collectors.groupingBy(Book::getGenre,
                        Collectors.maxBy(Comparator.comparingDouble(book ->
                            book.getRatings().stream()
                                    .mapToInt(Integer::intValue)
                                    .average()
                                    .orElse(0.0)))))
                .toString());

        // 14.
        System.out.println("\nGroup by aothor: " + books.stream()
                .collect(Collectors.groupingBy(Book::getAuthor)).toString());

        // 15.
        books.stream()
                .collect(
                        Collectors.groupingBy(
                                Book::getAuthor,
                                Collectors.counting()
                        )
                )
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent( entry ->
                        System.out.println("\n" + entry.getKey() + ": " + entry.getValue())
                );

        // 16.
        System.out.println("\nBooks with at least one 5 start rating: " + books.stream()
                .filter(book -> book.getRatings().stream().anyMatch(integer -> integer == 5))
                .toList());

        // 17.
        System.out.println("\nGroup by wrt ratings: " + books.stream()
                .collect(Collectors.partitioningBy(book ->
                        book.getRatings()
                                .stream()
                                .mapToInt(Integer::intValue)
                                .average()
                                .orElse(0.0) >= 4.5)).toString());

        // 18.
        List<Book> sortedBooks = books.stream()
                .sorted(Comparator.comparingDouble(Book::getAvgRating)
                        .reversed()
                        .thenComparing(Comparator.comparing(Book::getTitle)))
                .toList();
        System.out.println("\nSorted books with avg rating and title: " + sortedBooks);

        // LEVEL: 3
        // 19.
        List<Book> topBooks = books.stream()
                .sorted(Comparator.comparingDouble(Book::getAvgRating).reversed())
                .limit(3)
                .toList();
        System.out.println("\nTop rated books:" + topBooks);

        // 20.
        int maxRating = books.stream().flatMap(b -> b.getRatings().stream()).mapToInt(Integer::intValue).max().orElse(0);
        List<Integer> normRating = books.stream()
                .flatMap(b -> b.getRatings().stream())
                .map(r -> {
                    return r * 100 / maxRating;
                })
                .toList();
        System.out.println("\nNormalized ratings: " + normRating);

        // 21.
        Map<String, List<String>> genreToTitles = books.stream()
                .collect(Collectors.groupingBy(
                        Book::getGenre,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                b -> {
                                    return b.stream()
                                            .sorted(Comparator.comparingDouble(Book::getAvgRating).reversed())
                                            .map(Book::getTitle)
                                            .toList();
                                }
                        )
                ));
        System.out.println("\nMap of Genre to titleL: " + genreToTitles);

        // 22.
        Map<String, Double> genreAvgRating = books.stream()
                .collect(Collectors.groupingBy(
                        Book::getGenre,
                        Collectors.averagingDouble(Book::getAvgRating)
                ));
        System.out.println("\nGenre to avg rating: " + genreAvgRating);

        // 23.
        List<String> popAuth = books.stream()
                .collect(Collectors.groupingBy(
                        Book::getAuthor,
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();
        System.out.println("\nAuthors more than one publication: " + popAuth);

        // 24.
        Map<String, Map<String, List<Book>>> genreToAuthorToBooks = books.stream()
                .collect(Collectors.groupingBy(
                        Book::getGenre,
                        Collectors.groupingBy(Book::getAuthor)
                        )
                );
        System.out.println("\nGroup books by genre and then by author: " + genreToAuthorToBooks);

        // 25.
        List<String> topAuthors = books.stream()
                .filter(b -> b.getRatings().stream().allMatch(num -> num == 5))
                .map(Book::getAuthor)
                .toList();

        // 26.
        int maxPages = books.stream()
                .mapToInt(Book::getPages)
                .max()
                .orElse(1);
        books.stream()
                .filter(book -> book.getPages() == maxPages)
                .forEach(System.out::println);

        // 27.
        List<Integer> ratingsMoreThan3 = books.stream()
                .flatMap(book -> book.getRatings().stream())
                .filter(r -> r > 3)
                .toList();
        System.out.println(ratingsMoreThan3);

        // 28.
        Map<String, Map<String, Double>> genreToBookToAvgRating = books.stream()
                .collect(Collectors.groupingBy(
                        Book::getGenre,
                        Collectors.groupingBy(
                                Book::getTitle,
                                Collectors.averagingDouble(Book::getAvgRating)
                        )
                ));
        System.out.println("\nmap of genre → average number of ratings per book in that genre: " + genreToBookToAvgRating);

    }
}
