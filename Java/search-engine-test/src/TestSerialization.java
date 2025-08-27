import java.util.ArrayList;
import java.util.List;

public class TestSerialization {
    public static void main(String[] args) {
        // Create test data
        List<Book> testBooks = new ArrayList<>();
        testBooks.add(new Book("Test Book 1", "Test Author 1", 2020));
        testBooks.add(new Book("Test Book 2", "Test Author 2", 2021));

        LibrarySerializer serializer = new LibrarySerializer();

        // Test save
        System.out.println("=== TESTING SAVE ===");
        serializer.saveLibrary(testBooks, "test_library.ser");

        // Test load
        System.out.println("\n=== TESTING LOAD ===");
        List<Book> loadedBooks = serializer.loadLibrary("test_library.ser");

        if (loadedBooks != null) {
            System.out.println("SUCCESS: Loaded " + loadedBooks.size() + " books");
            for (Book book : loadedBooks) {
                System.out.println("Loaded: " + book);
            }
        } else {
            System.out.println("FAILED: loadedBooks is null");
        }

        // Test loading non-existent file
        System.out.println("\n=== TESTING NON-EXISTENT FILE ===");
        List<Book> nonExistentBooks = serializer.loadLibrary("non_existent_file.ser");
        System.out.println("Non-existent file result: " + (nonExistentBooks == null ? "null (expected)" : "not null"));
    }
}