import java.util.Arrays;
import java.util.List;

public class BookData {
    public static List<Book> getSampleBooks() {
        return Arrays.asList(
                new Book(1, "The Alchemist", "Paulo Coelho", "Fiction", 208, Arrays.asList(5, 4, 5)),
                new Book(2, "Clean Code", "Robert C. Martin", "Non-Fiction", 464, Arrays.asList(5, 5, 4, 5)),
                new Book(2, "Bad Code", "Robert C. Martin", "Non-Fiction", 464, Arrays.asList(3, 4, 2, 3)),
                new Book(3, "The Pragmatic Programmer", "Andy Hunt", "Non-Fiction", 352, Arrays.asList(4, 4, 3)),
                new Book(4, "1984", "George Orwell", "Fiction", 328, Arrays.asList(5, 4, 4)),
                new Book(5, "Murder on the Orient Express", "Agatha Christie", "Mystery", 256, Arrays.asList(4, 5, 4)),
                new Book(6, "Gone Girl", "Gillian Flynn", "Mystery", 422, Arrays.asList(5, 4, 5)),
                new Book(7, "Animal Farm", "George Orwell", "Fiction", 112, Arrays.asList(4, 3, 4)),
                new Book(8, "Goat Farm", "George Orwell", "Fiction", 112, Arrays.asList(4, 3, 4))
        );
    }
}
