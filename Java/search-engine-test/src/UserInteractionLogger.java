
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UserInteractionLogger {

    private static final String LOG_FILE = "src/resources/data/user_interactions.log";
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    // Method to log search interactions
    public static void logSearch(String searchTerm) {
        log("Search for: " + searchTerm);
    }

    // Method to log sorting interactions
    public static void logSort(String sortCriteria) {
        log("Sorted by: " + sortCriteria);
    }

  //   Method to log viewing all books
    public static void logViewAllBooks() {
        log("Viewed all books");
    }

    // Generic method to log messages with a timestamp
    public static void log(String message) {
    try(FileWriter writer = new FileWriter(LOG_FILE, true)) {
        LocalDateTime now = LocalDateTime.now();
        String timestamp = now.format(formatter);

        String logEntry = String.format("[%s] %s/n", timestamp, message);
        writer.write(logEntry);
    } catch (IOException e) {
        System.out.println(e.getMessage());
    }
    }

}
