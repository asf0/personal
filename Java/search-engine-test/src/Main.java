
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Library library = new Library();
//        library.loadBooks("/src/resources/data/books.txt");
//
//        System.out.println("Before sorting:");
//        library.viewAllBooks();
//        SortUtil.bubbleSort(library.getBooks(), Comparator.comparing(Book::getTitle));
//        System.out.println("After sorting by title: ");
//        library.viewAllBooks();
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter a keyword to search (title, author, or year): ");
//        String keyword = scanner.nextLine();
//
//        Book foundBook = library.searchBookByKeyword(keyword);
//
//        if (foundBook != null) {
//            System.out.println("Book found: " + foundBook);
//        } else {
//            System.out.println("Book not found.");
//        }

        Library library = new Library();
        LibrarySerializer serializer = new LibrarySerializer();

        List<Book> books = serializer.loadLibrary("src/resources/data/library.ser");
        if (books != null) {
            library.setBooks(books);
            System.out.println("Library loaded successfully from src/resources/data/library.ser");
        } else {
            System.out.println("Loading data from books.txt...");
            library.loadBooks("src/resources/data/books.txt");
        }

        LibraryMenu menu = new LibraryMenu(library);
        menu.displayMenu();

        serializer.saveLibrary(library.getBooks(), "src/resources/data/library.ser");
        System.out.println("Library saved successfully to src/resources/data/library.ser");
    }
    }

