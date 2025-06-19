import java.util.Arrays;

class Book {
    int bookId;
    String title;
    String author;

    public Book(int id, String title, String author) {
        this.bookId = id;
        this.title = title;
        this.author = author;
    }

    public String toString() {
        return bookId + " - " + title + " by " + author;
    }
}

public class LibrarySystem {

    // Linear search by title
    public static Book linearSearch(Book[] books, String title) {
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) return b;
        }
        return null;
    }

    // Binary search by title (array must be sorted)
    public static Book binarySearch(Book[] books, String title) {
        int low = 0, high = books.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = books[mid].title.compareToIgnoreCase(title);
            if (cmp == 0) return books[mid];
            else if (cmp < 0) low = mid + 1;
            else high = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        Book[] books = {
            new Book(1, "Java Basics", "Alice"),
            new Book(2, "Python Guide", "Bob"),
            new Book(3, "Data Structures", "Charlie")
        };

        // Sort books by title before binary search
        Arrays.sort(books, (a, b) -> a.title.compareToIgnoreCase(b.title));

        System.out.println("Linear Search Result:");
        Book found1 = linearSearch(books, "Python Guide");
        System.out.println(found1 != null ? found1 : "Not Found");

        System.out.println("\nBinary Search Result:");
        Book found2 = binarySearch(books, "Data Structures");
        System.out.println(found2 != null ? found2 : "Not Found");
    }
}
