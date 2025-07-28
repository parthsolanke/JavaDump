import model.Author;
import model.Book;
import model.Review;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class DataLoader {
    public static List<Author> getAuthors() {
        return Arrays.asList(
                new Author("Alice Walker", Arrays.asList(
                        new Book("The Color Purple", "Historical Fiction", 300, Arrays.asList(
                                new Review(5, "John", LocalDateTime.now().minusDays(5)),
                                new Review(4, "Mary", LocalDateTime.now().minusDays(4))
                        )),
                        new Book("Possessing the Secret of Joy", "Drama", 280, Arrays.asList(
                                new Review(3, "Eve", LocalDateTime.now().minusDays(3)),
                                new Review(5, "John", LocalDateTime.now().minusDays(1))
                        ))
                )),
                new Author("George Orwell", Arrays.asList(
                        new Book("1984", "Dystopian", 328, Arrays.asList(
                                new Review(5, "Alice", LocalDateTime.now().minusDays(2)),
                                new Review(5, "John", LocalDateTime.now().minusHours(10)),
                                new Review(4, "Steve", LocalDateTime.now().minusHours(8))
                        )),
                        new Book("Animal Farm", "Satire", 112, Arrays.asList(
                                new Review(5, "Mary", LocalDateTime.now().minusDays(10)),
                                new Review(3, "Eve", LocalDateTime.now().minusDays(9))
                        ))
                )),
                new Author("Haruki Murakami", Arrays.asList(
                        new Book("Norwegian Wood", "Romance", 296, Arrays.asList(
                                new Review(4, "Steve", LocalDateTime.now().minusDays(3)),
                                new Review(5, "Alice", LocalDateTime.now().minusDays(2)),
                                new Review(5, "John", LocalDateTime.now().minusDays(1))
                        )),
                        new Book("Kafka on the Shore", "Fantasy", 505, Arrays.asList(
                                new Review(2, "Mary", LocalDateTime.now().minusDays(4)),
                                new Review(3, "Steve", LocalDateTime.now().minusHours(12)),
                                new Review(5, "John", LocalDateTime.now().minusHours(5))
                        ))
                ))
        );
    }
}
