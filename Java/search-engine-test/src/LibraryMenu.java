
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class LibraryMenu {
    private Library library;
    private UserInteractionLogger logger = new UserInteractionLogger();
    private LibrarySerializer serializer = new LibrarySerializer();  // Added serializer

    public LibraryMenu(Library library) {
        this.library = library;

        // Load the library data when the program starts
        List<Book> books = serializer.loadLibrary("src/resources/data/library.ser");
        if (books != null) {
            library.setBooks(books);
            System.out.println("Library loaded successfully.");
        } else {
            System.out.println("No saved library found. Loading default books.");
            library.loadBooks("src/resources/data/books.txt");
        }
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. View all books");
            System.out.println("2. Sort books by title (Bubble Sort)");
            System.out.println("3. Sort books by author (Insertion Sort)");
            System.out.println("4. Sort books by publication year (Quick Sort)");
            System.out.println("5. Search for a book");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    library.viewAllBooks();
                    UserInteractionLogger.logViewAllBooks();
                    break;
                case 2:
                    System.out.println("Sorting books by title...");
                    UserInteractionLogger.logSort("title");
                    SortUtil.bubbleSort(library.getBooks(), Comparator.comparing(Book::getTitle));
                    System.out.println("Books sorted by title.");
                    library.viewAllBooks();
                    break;
                case 3:
                    System.out.println("Sorting books by author...");
                    UserInteractionLogger.logSearch("author");
                    SortUtil.insertionSort(library.getBooks(), Comparator.comparing(Book::getAuthor));
                    System.out.println("Books sorted by author.");
                    library.viewAllBooks();
                    break;
                case 4:
                    System.out.println("Sorting books by publication year...");
                    UserInteractionLogger.logSort("year");
                    SortUtil.quickSort(library.getBooks(), Comparator.comparing(Book::getPublicationYear),0, library.getBooks().size() -1);
                    System.out.println("Books sorted by publication year.");
                    library.viewAllBooks();
                    break;
                case 5:
                    System.out.print("Enter search keyword: ");

                    String keyword = scanner.nextLine();
                    UserInteractionLogger.logSearch(keyword);
                    Book foundBook = library.searchBookByKeyword(keyword);

                    if (foundBook != null) {
                        System.out.print("Book found: ");
                        System.out.println(foundBook);
                    } else {
                        System.out.println("no matching book.");
                    }
                    break;
                case 6:
                    System.out.println("Exiting the program");
                    UserInteractionLogger.log("exiting");
                    scanner.close();

                    return;
                default:
                    System.out.println("Invalid choice");

                    break;
            }

        }
    }

}
